
package com.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>inType complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="inType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="docNo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="gemsToken" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="edocToken" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "inType", propOrder = {
    "docNo",
    "gemsToken",
    "edocToken"
})
public class InType {

    @XmlElement(required = true)
    protected String docNo;
    @XmlElement(required = true)
    protected String gemsToken;
    @XmlElement(required = true)
    protected String edocToken;

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

}
