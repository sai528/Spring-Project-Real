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
@Table(name="goodstab")
public class GoodsReceiveNote
{
	@Id
	@GeneratedValue(generator = "goodsidgen")
	@GenericGenerator(name = "goodsidgen",strategy = "increment")

	@Column(name="goodsid")
	private Integer goodsId;

	@Column(name="goodscode")
	private String goodsCode;

	@Column(name="goodstype")
	private String goodsType;

	@ManyToOne
	@JoinColumn(name="purseOrdCodeFK", unique=true)
	private PurchaseOrder purseOrdCodeOb;


	@Column(name="goodsdesc")
	private String goodsDesc;

	public GoodsReceiveNote() {
		super();
	}

	public GoodsReceiveNote(Integer goodsId) {
		super();
		this.goodsId = goodsId;
	}

	public Integer getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}

	public String getGoodsCode() {
		return goodsCode;
	}

	public void setGoodsCode(String goodsCode) {
		this.goodsCode = goodsCode;
	}

	public String getGoodsType() {
		return goodsType;
	}

	public void setGoodsType(String goodsType) {
		this.goodsType = goodsType;
	}


	public PurchaseOrder getPurseOrdCodeOb() {
		return purseOrdCodeOb;
	}

	public void setPurseOrdCodeOb(PurchaseOrder purseOrdCodeOb) {
		this.purseOrdCodeOb = purseOrdCodeOb;
	}

	public String getGoodsDesc() {
		return goodsDesc;
	}

	public void setGoodsDesc(String goodsDesc) {
		this.goodsDesc = goodsDesc;
	}

	@Override
	public String toString() {
		return "GoodsReceiveNote [goodsId=" + goodsId + ", goodsCode=" + goodsCode + ", goodsType=" + goodsType
				+ ", purseOrdCodeOb=" + purseOrdCodeOb + ", goodsDesc=" + goodsDesc + "]";
	}





}
