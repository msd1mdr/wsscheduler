
package org.tempuri.services_asmx.getresponsefile;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CFileContent complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="CFileContent">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="fileContents" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/>
 *         &lt;element name="sizeInBytes" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="crc32" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CFileContent", propOrder = { "fileContents", "sizeInBytes", "crc32" })
public class CFileContent {

    protected byte[] fileContents;
    protected int sizeInBytes;
    protected int crc32;

    /**
     * Gets the value of the fileContents property.
     *
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getFileContents() {
        return fileContents;
    }

    /**
     * Sets the value of the fileContents property.
     *
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setFileContents(byte[] value) {
        this.fileContents = value;
    }

    /**
     * Gets the value of the sizeInBytes property.
     *
     */
    public int getSizeInBytes() {
        return sizeInBytes;
    }

    /**
     * Sets the value of the sizeInBytes property.
     *
     */
    public void setSizeInBytes(int value) {
        this.sizeInBytes = value;
    }

    /**
     * Gets the value of the crc32 property.
     *
     */
    public int getCrc32() {
        return crc32;
    }

    /**
     * Sets the value of the crc32 property.
     *
     */
    public void setCrc32(int value) {
        this.crc32 = value;
    }

}
