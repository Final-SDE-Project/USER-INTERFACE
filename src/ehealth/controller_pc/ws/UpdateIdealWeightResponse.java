
package ehealth.controller_pc.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for updateIdealWeightResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="updateIdealWeightResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="idealWeight" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "updateIdealWeightResponse", propOrder = {
    "idealWeight"
})
public class UpdateIdealWeightResponse {

    protected String idealWeight;

    /**
     * Gets the value of the idealWeight property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdealWeight() {
        return idealWeight;
    }

    /**
     * Sets the value of the idealWeight property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdealWeight(String value) {
        this.idealWeight = value;
    }

}
