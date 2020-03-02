
package in.nit.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity

@Table(name="parttab")
public class Part {

	@Id

	@GeneratedValue(generator = "pidgen")
	@GenericGenerator(name="pidgen", strategy = "increment")
	@Column (name="pid")
	private Integer partId;

	@Column(name="pcode")
	private String partCode;

	@Column(name="pwidth")
	private Float partWidth;

	@Column(name="plength")
	private Float partLength;

	@Column(name="pheight")
	private Float partHeight;

	@Column(name="pbasecost")
	private Double partBaseCost;

	@Column(name="pbasecurrency")
	private String partBaseCurrency;


	/*
	 * @Column(name="") private Uom uom;
	 * 
	 * @Column(name="") private OrderMethod orderMethodCode;
	 */


	@Column(name="pdesc")
	private String partDesc;

	public Part() {
		super();
	}
	
	public Part(Integer partId) {
		super();
		this.partId = partId;
	}
	
	public Integer getPartId() {
		return partId;
	}
	public void setPartId(Integer partId) {
		this.partId = partId;
	}
	public String getPartCode() {
		return partCode; 
	}
	public void setPartCode(String partCode) {
		this.partCode = partCode; 
	}
	public Float getPartWidth() { 
		return partWidth;
	} 
	public void setPartWidth(Float partWidth) { 
		this.partWidth = partWidth;
	} 
	public Float getPartLength() { 
		return partLength;
	} 
	public void setPartLength(Float partLength) {
		this.partLength = partLength;
	}
	public Float getPartHeight() {
		return partHeight;
	}
	public void setPartHeight(Float partHeight) {
		this.partHeight = partHeight;
	}
	public Double getPartBaseCost() { 
		return 	partBaseCost; 
	}
	public void setPartBaseCost(Double partBaseCost) {
		this.partBaseCost = partBaseCost; 
	}
	public String getPartBaseCurrency() { 
		return partBaseCurrency;
	} 
	public void setPartBaseCurrency(String partBaseCurrency) { 
		this.partBaseCurrency = partBaseCurrency; 
	}

	/*
	 * public Uom getUom() { return uom; } public void setUom(Uom uom) { this.uom =
	 * uom; } public OrderMethod getOrderMethodCode() { return OrderMethodCode; }
	 * public void setOrderMethodCode(OrderMethod orderMethodCode) { OrderMethodCode
	 * = orderMethodCode; }
	 */
	public String getPartDesc() {
		return partDesc; 
	} 
	public void setPartDesc(String partDesc) { 
		this.partDesc = partDesc; 
	}
	@Override
	public String toString() {
		return "Part [partId=" + partId + ", partCode=" + partCode + ", partWidth=" + partWidth + ", partLength=" + partLength + ", partHeight=" +
				partHeight + ", partBaseCost=" + partBaseCost + ", partBaseCurrency=" + partBaseCurrency
				+ /* ", uom=" + uom + ", OrderMethodCode=" + OrderMethodCode+ */ ", partDesc=" +
				partDesc + "]"; 
	}



}
