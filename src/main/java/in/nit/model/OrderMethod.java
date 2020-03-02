package in.nit.model;


import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="ordertab")
public class OrderMethod 
{

	@Id
	@GeneratedValue(generator = "ordidgen")
	@GenericGenerator(name="ordidgen", strategy = "increment")

	@Column(name="ordid")
	private Integer ordId;
	
	@Column(name="ordmode")
	private String ordMode;
	
	@Column(name="ordcode")
	private String ordCode;
	
	@Column(name="ordtype")
	private String ordType;
	
	@ElementCollection(fetch=FetchType.EAGER)
	@CollectionTable(name="orderacptab",joinColumns=@JoinColumn(name="ordid"))
	@OrderColumn(name="pos")
	
	
	@Column(name="ordaccept")
	private List<String> ordAccept;
	
	
	
	//@Column(name="ordaccept")
	//private String ordAccept;
	
	@Column(name="orddesc")
	private String ordDesc;
	
	

	public OrderMethod() {
		super();
	}

	
	
	public OrderMethod(Integer ordId) {
		super();
		this.ordId = ordId;
	}



	public Integer getOrdId() {
		return ordId;
	}

	public void setOrdId(Integer ordId) {
		this.ordId = ordId;
	}

	public String getOrdMode() {
		return ordMode;
	}

	public void setOrdMode(String ordMode) {
		this.ordMode = ordMode;
	}

	public String getOrdCode() {
		return ordCode;
	}

	public void setOrdCode(String ordCode) {
		this.ordCode = ordCode;
	}

	public String getOrdType() {
		return ordType;
	}

	public void setOrdType(String ordType) {
		this.ordType = ordType;
	}

	/*public String getOrdAccept() {
		return ordAccept;
		}
		public void setOrdAccept(String ordAccept) {
		this.ordAccept = ordAccept;
		
	}*/
	public List<String> getOrdAccept() {
		return ordAccept;
	}

	public void setOrdAccept(List<String> ordAccept) {
		this.ordAccept = ordAccept;
	}

	public String getOrdDesc() {
		return ordDesc;
	}

	public void setOrdDesc(String ordDesc) {
		this.ordDesc = ordDesc;
	}

	@Override
	public String toString() {
		return "OrderMethod [ordId=" + ordId + ", ordMode=" + ordMode + ", ordCode=" + ordCode + ", ordMethod="
				+ ordType + ", ordAccept=" + ordAccept + ", ordDesc=" + ordDesc + "]";
	}


}
