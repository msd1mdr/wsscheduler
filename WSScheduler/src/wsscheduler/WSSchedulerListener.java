package wsscheduler;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;

import javax.persistence.Persistence;

import javax.persistence.PersistenceContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import javax.servlet.annotation.WebListener;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import org.quartz.SchedulerException;
import org.quartz.ee.servlet.QuartzInitializerListener;
import org.quartz.impl.StdSchedulerFactory;

import org.slf4j.LoggerFactory;

@WebListener
public class WSSchedulerListener extends QuartzInitializerListener implements ServletContextListener {
    
    public static final String key_cfg_file = "wsscheduler.configuration.file";
    public static final String key_cfg_service_url = "wsscheduler.service.url";
    public static final String key_cfg_connect_timeout = "wsscheduler.service.connect.timeout";
    public static final String key_cfg_request_timeout = "wsscheduler.service.request.timeout";
    public static final String key_cfg_batchsize = "wsscheduler.query.batchsize";
    
    public static String cfg_file = "/home/oracle/middleware/user_projects/applications/wsscheduler/wsscheduler.properties";
    public static String cfg_service_url = "http://192.168.218.174:7001/default/Test";
    public static int cfg_connect_timeout = 5000;
    public static int cfg_request_timeout = 10000;
    public static int cfg_batchsize = 10;
    
    static {
        configure();
    }
    
    
    private static EntityManagerFactory emFactory = null;
    
    public static EntityManagerFactory getEMFactory() {
        if (emFactory == null) emFactory = Persistence.createEntityManagerFactory("WSScheduler");
        return emFactory;
    }
       
    public WSSchedulerListener() {
        super();
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        super.contextDestroyed(servletContextEvent);
        if (emFactory != null) {
            emFactory.close();
            emFactory = null;
        }
    }

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        super.contextInitialized(servletContextEvent);
    }

    @Override
    protected StdSchedulerFactory getSchedulerFactory(String string) throws SchedulerException {
        // assume string is the configuration file name
        return super.getSchedulerFactory(cfg_file);
    }

    private static void configure(Properties p) {
        cfg_file = p.getProperty(key_cfg_file, cfg_file);
        cfg_service_url = p.getProperty(key_cfg_service_url, cfg_service_url);
        cfg_connect_timeout = Integer.valueOf(p.getProperty(key_cfg_connect_timeout, String.valueOf(cfg_connect_timeout)));
        cfg_request_timeout = Integer.valueOf(p.getProperty(key_cfg_request_timeout, String.valueOf(cfg_request_timeout)));
        cfg_batchsize = Integer.valueOf(p.getProperty(key_cfg_batchsize, String.valueOf(cfg_batchsize)));
    }
    
    private static void configure() {
        String s = null;
        InputStream fis = null;
        Properties prop = null;
        
        s = System.getProperty(key_cfg_file);
        if ((s == null) || (s.isEmpty() == true)) {
            fis = Thread.currentThread().getContextClassLoader().getResourceAsStream("wsscheduler.properties");
            if (fis != null) {
                // from embedded wsscheduler.properties
                try {
                    prop = new Properties();
                    prop.load(fis);
                    fis.close();
                    configure(prop);
                } catch (IOException e) {
                    // error loading : not likely
                }                
            }
        } 
        else cfg_file = s;
        fis = null;
        prop = null;
        try {
            fis = new FileInputStream(cfg_file);
            prop = new Properties();
            prop.load(fis);
            fis.close();
            configure(prop);
        } catch (FileNotFoundException e) {
            LoggerFactory.getLogger(WSSchedulerListener.class).warn("Failed opening application configuration.", e);
        } catch (IOException e) {
            LoggerFactory.getLogger(WSSchedulerListener.class).warn("Failed loading application configuration.", e);
        }
        if (cfg_file.isEmpty() == false) {
            LogManager.resetConfiguration();
            PropertyConfigurator.configure(cfg_file);
            LoggerFactory.getLogger(WSSchedulerListener.class).info("Application configuration loaded from '{}'.",
                                                                    cfg_file);
        } else
            LoggerFactory.getLogger(WSSchedulerListener.class).info("Application configuration loaded from default.");
    }
}
