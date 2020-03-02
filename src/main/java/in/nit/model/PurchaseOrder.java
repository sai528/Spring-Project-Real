package in.nit.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
	
	/*
	 * @Column(name="shipcode") private ShipmentType shipCode;//ShipmentCode
	 * 
	 * @Column(name="usertype") private WhUserType userType;//vendor
	 */	 	
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

	/*
	 * public ShipmentType getShipCode() { return shipCode; }
	 * 
	 * public void setShipCode(ShipmentType shipCode) { this.shipCode = shipCode; }
	 * 
	 * public WhUserType getUserType() { return userType; }
	 * 
	 * public void setUserType(WhUserType userType) { this.userType = userType; }
	 */

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
		return "PurchaseOrder [purseId=" + purseId + ", ordCode=" + ordCode
				+ /*
					 * ", shipCode=" + shipCode + ", userType=" + userType +
					 */ ", refNumber=" + refNumber + ", qualityCheck=" + qualityCheck + ", defaultStatus="
				+ defaultStatus + ", purDesc=" + purDesc + "]";
	}

	 
	

}
