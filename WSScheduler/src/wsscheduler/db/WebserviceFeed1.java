package wsscheduler.db;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@NamedQueries({ @NamedQuery(name = "WebserviceFeed1.findAll", query = "select o from WebserviceFeed1 o") })
@Table(name = "WEBSERVICE_FEED1")
public class WebserviceFeed1 implements Serializable {
    private static final long serialVersionUID = -5281468732231082796L;
    @Temporal(TemporalType.DATE)
    private Date createtime;
    @Column(nullable = false, length = 4000)
    private String filecontent;
    @Column(nullable = false, length = 40)
    private String membercode;
    @Column(nullable = false, length = 20)
    private String operation;
    @Id
    @Column(nullable = false)
    private BigDecimal recordid;
    @Column(length = 20)
    private String response;
    @Temporal(TemporalType.DATE)
    private Date updatetime;

    public WebserviceFeed1() {
    }

    public WebserviceFeed1(Date createtime, String filecontent, String membercode, String operation,
                           BigDecimal recordid, String response, Date updatetime) {
        this.createtime = createtime;
        this.filecontent = filecontent;
        this.membercode = membercode;
        this.operation = operation;
        this.recordid = recordid;
        this.response = response;
        this.updatetime = updatetime;
    }


    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getFilecontent() {
        return filecontent;
    }

    public void setFilecontent(String filecontent) {
        this.filecontent = filecontent;
    }

    public String getMembercode() {
        return membercode;
    }

    public void setMembercode(String membercode) {
        this.membercode = membercode;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public BigDecimal getRecordid() {
        return recordid;
    }

    public void setRecordid(BigDecimal recordid) {
        this.recordid = recordid;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append(getClass().getName() + "@" + Integer.toHexString(hashCode()));
        buffer.append('[');
        buffer.append("createtime=");
        buffer.append(getCreatetime());
        buffer.append(',');
        buffer.append("filecontent=");
        buffer.append(getFilecontent());
        buffer.append(',');
        buffer.append("membercode=");
        buffer.append(getMembercode());
        buffer.append(',');
        buffer.append("operation=");
        buffer.append(getOperation());
        buffer.append(',');
        buffer.append("recordid=");
        buffer.append(getRecordid());
        buffer.append(',');
        buffer.append("response=");
        buffer.append(getResponse());
        buffer.append(',');
        buffer.append("updatetime=");
        buffer.append(getUpdatetime());
        buffer.append(']');
        return buffer.toString();
    }
}
