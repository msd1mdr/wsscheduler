
package org.tempuri;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ReceiveDataInvestorResult" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "receiveDataInvestorResult" })
@XmlRootElement(name = "ReceiveDataInvestorResponse")
public class ReceiveDataInvestorResponse {

    @XmlElement(name = "ReceiveDataInvestorResult")
    protected int receiveDataInvestorResult;

    /**
     * Gets the value of the receiveDataInvestorResult property.
     *
     */
    public int getReceiveDataInvestorResult() {
        return receiveDataInvestorResult;
    }

    /**
     * Sets the value of the receiveDataInvestorResult property.
     *
     */
    public void setReceiveDataInvestorResult(int value) {
        this.receiveDataInvestorResult = value;
    }

}
