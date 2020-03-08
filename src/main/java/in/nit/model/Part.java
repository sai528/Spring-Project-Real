
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
	private Double partWidth;

	@Column(name="plength")
	private Double partLength;

	@Column(name="pheight")
	private Double partHeight;

	@Column(name="pbasecost")
	private Double partBaseCost;

	@Column(name="pbasecurrency")
	private String partBaseCurrency;

	@ManyToOne
	@JoinColumn(name="uomIdFK") 
	private Uom uomOb;

	@ManyToOne
	 @JoinColumn(name="ordSaleFK") 
	 private OrderMethod ordSaleOb;
	
	@ManyToOne
	 @JoinColumn(name="ordPurchaseFK") 
	 private OrderMethod ordPurchaseOb;
	


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

	public Double getPartWidth() {
		return partWidth;
	}

	public void setPartWidth(Double partWidth) {
		this.partWidth = partWidth;
	}

	public Double getPartLength() {
		return partLength;
	}

	public void setPartLength(Double partLength) {
		this.partLength = partLength;
	}

	public Double getPartHeight() {
		return partHeight;
	}

	public void setPartHeight(Double partHeight) {
		this.partHeight = partHeight;
	}

	public Double getPartBaseCost() {
		return partBaseCost;
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

	public Uom getUomOb() {
		return uomOb;
	}

	public void setUomOb(Uom uomOb) {
		this.uomOb = uomOb;
	}

	public OrderMethod getOrdSaleOb() {
		return ordSaleOb;
	}

	public void setOrdSaleOb(OrderMethod ordSaleOb) {
		this.ordSaleOb = ordSaleOb;
	}

	public OrderMethod getOrdPurchaseOb() {
		return ordPurchaseOb;
	}

	public void setOrdPurchaseOb(OrderMethod ordPurchaseOb) {
		this.ordPurchaseOb = ordPurchaseOb;
	}

	public String getPartDesc() {
		return partDesc;
	}

	public void setPartDesc(String partDesc) {
		this.partDesc = partDesc;
	}

	@Override
	public String toString() {
		return "Part [partId=" + partId + ", partCode=" + partCode + ", partWidth=" + partWidth + ", partLength="
				+ partLength + ", partHeight=" + partHeight + ", partBaseCost=" + partBaseCost + ", partBaseCurrency="
				+ partBaseCurrency + ", uomOb=" + uomOb + ", ordSaleOb=" + ordSaleOb + ", ordPurchaseOb="
				+ ordPurchaseOb + ", partDesc=" + partDesc + "]";
	}

	
}
