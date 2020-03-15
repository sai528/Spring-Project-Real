package in.nit.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="shippingtab")
public class Shipping 
{
	@Id
	@GeneratedValue(generator = "shippingidgen")
	@GenericGenerator(name="shippingidgen", strategy = "increment")

	@Column(name="shippingid")
	private Integer shippingId;

	@Column(name="shippingcode")
	private String shippingCode;

	@Column(name="shippingrefnum")
	private Integer shippingRefNum;

	@Column(name="courierrefnum")
	private Integer courierRefNum;

	@Column(name="contactdetails")
	private String contactDetails;

	@ManyToOne
	@JoinColumn(name="saleOrdCodeFK" , unique=true)
	private SaleOrder saleOrdCodeOb;

	@Column(name="shippingdesc")
	private String shippingDesc;

	@Column(name="billtoaddr")
	private String billToAddr;

	@Column(name="shiptoaddr")
	private String shipToAddr;

	public Shipping() {
		super();
	}

	public Shipping(Integer shippingId) {
		super();
		this.shippingId = shippingId;
	}

	public Integer getShippingId() {
		return shippingId;
	}

	public void setShippingId(Integer shippingId) {
		this.shippingId = shippingId;
	}

	public String getShippingCode() {
		return shippingCode;
	}

	public void setShippingCode(String shippingCode) {
		this.shippingCode = shippingCode;
	}

	public Integer getShippingRefNum() {
		return shippingRefNum;
	}

	public void setShippingRefNum(Integer shippingRefNum) {
		this.shippingRefNum = shippingRefNum;
	}

	public Integer getCourierRefNum() {
		return courierRefNum;
	}

	public void setCourierRefNum(Integer courierRefNum) {
		this.courierRefNum = courierRefNum;
	}

	public String getContactDetails() {
		return contactDetails;
	}

	public void setContactDetails(String contactDetails) {
		this.contactDetails = contactDetails;
	}

	
	public SaleOrder getSaleOrdCodeOb() {
		return saleOrdCodeOb;
	}

	public void setSaleOrdCodeOb(SaleOrder saleOrdCodeOb) {
		this.saleOrdCodeOb = saleOrdCodeOb;
	}

	public String getShippingDesc() {
		return shippingDesc;
	}

	public void setShippingDesc(String shippingDesc) {
		this.shippingDesc = shippingDesc;
	}

	public String getBillToAddr() {
		return billToAddr;
	}

	public void setBillToAddr(String billToAddr) {
		this.billToAddr = billToAddr;
	}

	public String getShipToAddr() {
		return shipToAddr;
	}

	public void setShipToAddr(String shipToAddr) {
		this.shipToAddr = shipToAddr;
	}

	@Override
	public String toString() {
		return "Shipping [shippingId=" + shippingId + ", shippingCode=" + shippingCode + ", shippingRefNum="
				+ shippingRefNum + ", courierRefNum=" + courierRefNum + ", contactDetails=" + contactDetails
				+ ", saleOrdCodeOb=" + saleOrdCodeOb + ", shippingDesc=" + shippingDesc + ", billToAddr=" + billToAddr
				+ ", shipToAddr=" + shipToAddr + "]";
	}

	

}
