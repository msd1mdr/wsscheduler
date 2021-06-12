
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
 *         &lt;element name="ValidatorDataInvestorResult" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "validatorDataInvestorResult" })
@XmlRootElement(name = "ValidatorDataInvestorResponse")
public class ValidatorDataInvestorResponse {

    @XmlElement(name = "ValidatorDataInvestorResult")
    protected int validatorDataInvestorResult;

    /**
     * Gets the value of the validatorDataInvestorResult property.
     *
     */
    public int getValidatorDataInvestorResult() {
        return validatorDataInvestorResult;
    }

    /**
     * Sets the value of the validatorDataInvestorResult property.
     *
     */
    public void setValidatorDataInvestorResult(int value) {
        this.validatorDataInvestorResult = value;
    }

}
