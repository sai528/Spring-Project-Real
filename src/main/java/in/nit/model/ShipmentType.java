package in.nit.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="shiptab")
public class ShipmentType 
{
	@Id
	@GeneratedValue(generator="sidgen")
	@GenericGenerator(name="sidgen",strategy = "increment")
	
	//@GeneratedValue(strategy = GenerationType.AUTO)

	@Column(name="sid")
	private Integer shipId;

	@Column(name="smode")
	private String shipMode;

	@Column(name="scode")
	private String shipCode;

	@Column(name="eship")
	private String enableShip;

	@Column(name="sgrade")
	private String shipGrade;

	@Column(name="sdesc")
	private String shipDesc;

	
	public ShipmentType() {
		super();
	}
	

	public ShipmentType(Integer shipId) {
		super();
		this.shipId = shipId;
	}


	public Integer getShipId() {
		return shipId;
	}

	public void setShipId(Integer shipId) {
		this.shipId = shipId;
	}

	public String getShipMode() {
		return shipMode;
	}

	public void setShipMode(String shipMode) {
		this.shipMode = shipMode;
	}

	public String getShipCode() {
		return shipCode;
	}

	public void setShipCode(String shipCode) {
		this.shipCode = shipCode;
	}

	public String getEnableShip() {
		return enableShip;
	}

	public void setEnableShip(String enableShip) {
		this.enableShip = enableShip;
	}

	public String getShipGrade() {
		return shipGrade;
	}

	public void setShipGrade(String shipGrade) {
		this.shipGrade = shipGrade;
	}

	public String getShipDesc() {
		return shipDesc;
	}

	public void setShipDesc(String shipDesc) {
		this.shipDesc = shipDesc;
	}

	@Override
	public String toString() {
		return "ShipmentType [shipId=" + shipId + ", shipMode=" + shipMode + ", shipCode=" + shipCode + ", enableShip="
				+ enableShip + ", shipGrade=" + shipGrade + ", shipDesc=" + shipDesc + "]";
	}



}
