
package ehealth.controller_pc.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for readStepsResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="readStepsResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="stepStatus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "readStepsResponse", propOrder = {
    "stepStatus"
})
public class ReadStepsResponse {

    protected String stepStatus;

    /**
     * Gets the value of the stepStatus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStepStatus() {
        return stepStatus;
    }

    /**
     * Sets the value of the stepStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStepStatus(String value) {
        this.stepStatus = value;
    }

}
