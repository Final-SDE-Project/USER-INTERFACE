
package ehealth.controller_pc.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for readGoalReminderResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="readGoalReminderResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="goalReminder" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "readGoalReminderResponse", propOrder = {
    "goalReminder"
})
public class ReadGoalReminderResponse {

    protected String goalReminder;

    /**
     * Gets the value of the goalReminder property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGoalReminder() {
        return goalReminder;
    }

    /**
     * Sets the value of the goalReminder property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGoalReminder(String value) {
        this.goalReminder = value;
    }

}
