
package org.tempuri;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.tempuri.services_asmx.getresponsefile.CFileContent;


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
 *         &lt;element name="memberCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element ref="{http://tempuri.org/Services.asmx/getResponseFile}getFileResponse"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "memberCode", "getFileResponse" })
@XmlRootElement(name = "ReceiveDataStatic")
public class ReceiveDataStatic {

    protected String memberCode;
    @XmlElement(namespace = "http://tempuri.org/Services.asmx/getResponseFile", required = true, nillable = true)
    protected CFileContent getFileResponse;

    /**
     * Gets the value of the memberCode property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getMemberCode() {
        return memberCode;
    }

    /**
     * Sets the value of the memberCode property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setMemberCode(String value) {
        this.memberCode = value;
    }

    /**
     * Gets the value of the getFileResponse property.
     *
     * @return
     *     possible object is
     *     {@link CFileContent }
     *
     */
    public CFileContent getGetFileResponse() {
        return getFileResponse;
    }

    /**
     * Sets the value of the getFileResponse property.
     *
     * @param value
     *     allowed object is
     *     {@link CFileContent }
     *
     */
    public void setGetFileResponse(CFileContent value) {
        this.getFileResponse = value;
    }

}
