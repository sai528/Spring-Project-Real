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
@Table(name="purchasetab")
public class PurchaseOrder
{
	@Id
	@GeneratedValue(generator = "purseidgen")
	@GenericGenerator(name="purseidgen", strategy = "increment")
	@Column(name="purseid")
	private Integer purseId;

	@Column(name="ordcode")
	private String ordCode;


	@ManyToOne
	@JoinColumn(name="shipcodeFK")
	private ShipmentType shipCodeOb;

	@ManyToOne
	@JoinColumn(name="uservendorFK") 
	private WhUserType userVendorOb;


	@Column(name="refnumber")
	private Integer refNumber;

	@Column(name="qualitycheck")
	private String qualityCheck;

	@Column(name="dftstatus")
	private String defaultStatus;

	@Column(name="purdesc")
	private String purDesc;

	public PurchaseOrder() {
		super();
	}



	public PurchaseOrder(Integer purseId) {
		super();
		this.purseId = purseId;
	}



	public Integer getPurseId() {
		return purseId;
	}

	public void setPurseId(Integer purseId) {
		this.purseId = purseId;
	}

	public String getOrdCode() {
		return ordCode;
	}

	public void setOrdCode(String ordCode) {
		this.ordCode = ordCode;
	}
	
	public ShipmentType getShipCodeOb() {
		return shipCodeOb;
	}
	
	public void setShipCodeOb(ShipmentType shipCodeOb) {
		this.shipCodeOb = shipCodeOb;
	}
	
	public WhUserType getUserVendorOb() {
		return userVendorOb;
	}

	public void setUserVendorOb(WhUserType userVendorOb) {
		this.userVendorOb = userVendorOb;
	}

	public Integer getRefNumber() {
		return refNumber;
	}

	public void setRefNumber(Integer refNumber) {
		this.refNumber = refNumber;
	}

	public String getQualityCheck() {
		return qualityCheck;
	}

	public void setQualityCheck(String qualityCheck) {
		this.qualityCheck = qualityCheck;
	}

	public String getDefaultStatus() {
		return defaultStatus;
	}

	public void setDefaultStatus(String defaultStatus) {
		this.defaultStatus = defaultStatus;
	}

	public String getPurDesc() {
		return purDesc;
	}

	public void setPurDesc(String purDesc) {
		this.purDesc = purDesc;
	}



	@Override
	public String toString() {
		return "PurchaseOrder [purseId=" + purseId + ", ordCode=" + ordCode + ", shipCodeOb=" + shipCodeOb
				+ ", userVendorOb=" + userVendorOb + ", refNumber=" + refNumber + ", qualityCheck=" + qualityCheck
				+ ", defaultStatus=" + defaultStatus + ", purDesc=" + purDesc + "]";
	}






}
