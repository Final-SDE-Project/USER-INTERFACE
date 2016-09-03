
package ehealth.controller_pc.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for readBigWeightChangeResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="readBigWeightChangeResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="weightChange" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "readBigWeightChangeResponse", propOrder = {
    "weightChange"
})
public class ReadBigWeightChangeResponse {

    protected String weightChange;

    /**
     * Gets the value of the weightChange property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWeightChange() {
        return weightChange;
    }

    /**
     * Sets the value of the weightChange property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWeightChange(String value) {
        this.weightChange = value;
    }

}
