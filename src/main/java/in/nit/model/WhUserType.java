package in.nit.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="whusertab")
public class WhUserType
{
	@Id
	@GeneratedValue(generator = "useridgen")
	@GenericGenerator(name="useridgen", strategy = "increment")

	@Column(name="userid")
	private Integer userId;

	@Column(name="usertype")
	private String userType;

	@Column(name="usercode")
	private String userCode;

	@Column(name="userfor")
	private String userFor;

	@Column(name="useremail")
	private String userEmail;

	@Column(name="usercontact")
	private Long userContact;

	@Column(name="useridtype")
	private String userIdType;

	@Column(name="otheridtype")
	private String ifOther;

	@Column(name="idnumber")
	private Integer idNumber;

	public WhUserType() {
		super();
	}



	public WhUserType(Integer userId) {
		super();
		this.userId = userId;
	}



	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getUserFor() {
		return userFor;
	}

	public void setUserFor(String userFor) {
		this.userFor = userFor;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public Long getUserContact() {
		return userContact;
	}

	public void setUserContact(Long userContact) {
		this.userContact = userContact;
	}

	public String getUserIdType() {
		return userIdType;
	}

	public void setUserIdType(String userIdType) {
		this.userIdType = userIdType;
	}

	public String getIfOther() {
		return ifOther;
	}

	public void setIfOther(String ifOther) {
		this.ifOther = ifOther;
	}

	public Integer getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(Integer idNumber) {
		this.idNumber = idNumber;
	}

	@Override
	public String toString() {
		return "WhUserType [userId=" + userId + ", userType=" + userType + ", userCode=" + userCode + ", userFor="
				+ userFor + ", userEmail=" + userEmail + ", userContact=" + userContact + ", userIdType=" + userIdType
				+ ", ifOther=" + ifOther + ", idNumber=" + idNumber + "]";
	}



}
