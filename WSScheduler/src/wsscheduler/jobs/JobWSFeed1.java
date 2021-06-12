package wsscheduler.jobs;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import wsscheduler.WSSchedulerListener;

import wsscheduler.db.WebserviceFeed1;

import wsscheduler.ws.ServiceSoap;
import wsscheduler.ws.ServiceSoap12Client;

@DisallowConcurrentExecution
public class JobWSFeed1 implements Job {
    public static Logger logger = LoggerFactory.getLogger(JobWSFeed1.class);
    public static ServiceSoap service = ServiceSoap12Client.getService();

    public JobWSFeed1() {
        super();
    }

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        EntityManager em = WSSchedulerListener.getEMFactory().createEntityManager();
        try {
            Query query =
                em.createNativeQuery("SELECT * FROM WEBSERVICE_FEED1 WHERE RESPONSE IS NULL OR RESPONSE = '0' OR RESPONSE = 'ERROR' ORDER BY RECORDID ASC",
                                     WebserviceFeed1.class)
                .setMaxResults(WSSchedulerListener.cfg_batchsize);
            List<WebserviceFeed1> list = query.getResultList();
            em.clear();
            
            if (list.size() > 0) logger.info("Found {} rows. Processing ...", list.size());
            logger.debug("Row count : {}.", list.size());
            
            int count = 0;
            for (WebserviceFeed1 item : list) {
                count++;
                logger.debug("Invoking service OPERATION '{}' for RECORDID '{}'.", item.getOperation(), item.getRecordid());
                String response = "ERROR";
                try {
                    response =
                        ServiceSoap12Client.invoke(service, item.getOperation(), item.getMembercode(),
                                                   item.getFilecontent());
                    logger.debug("Completed invoking service '{}' for RECORDID '{}'.", item.getOperation(), item.getRecordid());
                } catch (Exception e) {
                    logger.warn("Failed invoking service OPERATION '{}' for RECORDID '{}'.", item.getOperation(), item.getRecordid(), e);
                }
                logger.debug("Updating row RESPONSE '{}' for RECORDID '{}'.", response, item.getRecordid());
                Query update = em.createNativeQuery("UPDATE WEBSERVICE_FEED1 SET RESPONSE = ? , UPDATETIME = SYSDATE WHERE RECORDID = ? ")
                    .setParameter(1, response)
                    .setParameter(2, item.getRecordid());
                em.getTransaction().begin();
                int n = update.executeUpdate();
                em.getTransaction().commit();
                em.clear();
                logger.debug("Updated '{}' row.", n);
                if ((response.compareTo("ERROR") == 0) || (response.compareTo("0") == 0)) break;
            }
            if (list.size() > 0) logger.info("Done. Process completed : {}/{}.", count, list.size());
        } finally {
            em.close();
            em = null;
        }
    }
}
