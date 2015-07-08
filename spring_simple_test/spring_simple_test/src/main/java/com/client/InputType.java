
package com.client;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>inputType complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="inputType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="businessType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="businessTypeCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="docNo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="edocToken" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="gemsToken" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="imageStatus" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="userId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="userName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "inputType", propOrder = {
    "businessType",
    "businessTypeCode",
    "docNo",
    "edocToken",
    "gemsToken",
    "imageStatus",
    "userId",
    "userName"
})
public class InputType {

    @XmlElement(required = true)
    protected String businessType;
    @XmlElement(required = true)
    protected String businessTypeCode;
    @XmlElement(required = true)
    protected String docNo;
    @XmlElement(required = true)
    protected String edocToken;
    @XmlElement(required = true)
    protected String gemsToken;
    @XmlElement(required = true)
    protected String imageStatus;
    @XmlElement(required = true)
    protected String userId;
    @XmlElement(required = true)
    protected String userName;

    /**
     * ��ȡbusinessType���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBusinessType() {
        return businessType;
    }

    /**
     * ����businessType���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBusinessType(String value) {
        this.businessType = value;
    }

    /**
     * ��ȡbusinessTypeCode���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBusinessTypeCode() {
        return businessTypeCode;
    }

    /**
     * ����businessTypeCode���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBusinessTypeCode(String value) {
        this.businessTypeCode = value;
    }

    /**
     * ��ȡdocNo���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDocNo() {
        return docNo;
    }

    /**
     * ����docNo���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDocNo(String value) {
        this.docNo = value;
    }

    /**
     * ��ȡedocToken���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEdocToken() {
        return edocToken;
    }

    /**
     * ����edocToken���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEdocToken(String value) {
        this.edocToken = value;
    }

    /**
     * ��ȡgemsToken���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGemsToken() {
        return gemsToken;
    }

    /**
     * ����gemsToken���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGemsToken(String value) {
        this.gemsToken = value;
    }

    /**
     * ��ȡimageStatus���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getImageStatus() {
        return imageStatus;
    }

    /**
     * ����imageStatus���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setImageStatus(String value) {
        this.imageStatus = value;
    }

    /**
     * ��ȡuserId���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserId() {
        return userId;
    }

    /**
     * ����userId���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserId(String value) {
        this.userId = value;
    }

    /**
     * ��ȡuserName���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserName() {
        return userName;
    }

    /**
     * ����userName���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserName(String value) {
        this.userName = value;
    }

}
