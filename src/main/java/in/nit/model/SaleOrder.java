package in.nit.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="saletab")
public class SaleOrder 
{
	@Id
	@GeneratedValue(generator ="saleidgen")
	@GenericGenerator(name="saleidgen", strategy = "increment")
	
	@Column(name="saleid")
	private Integer saleId;
	
	@Column(name="ordcode")
	private String ordCode;
	
	/*
	 * @Column(name="shipcode") private ShipmentType shipCode;
	 * 
	 * @Column(name="usertype") private WhUserType userType;
	 */
	
	@Column(name="refnumber")
	private Integer refNumber;
	
	@Column(name="stockmode")
	private String stockMode;
	
	@Column(name="stocksource")
	private String stockSource;
	
	@Column(name="dftstatus")
	private String defaultStatus;
	
	@Column(name="saledesc")
	private String saleDesc;

	public SaleOrder() {
		super();
	}

	public SaleOrder(Integer saleId) {
		super();
		this.saleId = saleId;
	}

	public Integer getSaleId() {
		return saleId;
	}

	public void setSaleId(Integer saleId) {
		this.saleId = saleId;
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

	public String getStockMode() {
		return stockMode;
	}

	public void setStockMode(String stockMode) {
		this.stockMode = stockMode;
	}

	public String getStockSource() {
		return stockSource;
	}

	public void setStockSource(String stockSource) {
		this.stockSource = stockSource;
	}

	public String getDefaultStatus() {
		return defaultStatus;
	}

	public void setDefaultStatus(String defaultStatus) {
		this.defaultStatus = defaultStatus;
	}

	public String getSaleDesc() {
		return saleDesc;
	}

	public void setSaleDesc(String saleDesc) {
		this.saleDesc = saleDesc;
	}

	@Override
	public String toString() {
		return "SaleOrder [saleId=" + saleId + ", ordCode=" + ordCode
				+ /*
					 * ", shipCode=" + shipCode + ", userType=" + userType +
					 */ ", refNumber=" + refNumber + ", stockMode=" + stockMode + ", stockSource=" + stockSource
				+ ", defaultStatus=" + defaultStatus + ", saleDesc=" + saleDesc + "]";
	}

	
}
