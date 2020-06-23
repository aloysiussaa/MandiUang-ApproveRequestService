package coid.bca.MandiUangTrxService.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "main_account_dimension")
public class MainAccount {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mainAccountId;
	
	@NotBlank
	@Column(length = 10)
	private String mainAccountNo;
	
	@NotBlank
	@Column(length = 255)
	private String mainAccountName;
	
	@NotBlank
	private Double mainBalance; 
	
	@NotBlank
	@Column(length = 20)
	private String picPhone;
	
	@NotBlank
	@Column(length = 40)
	private String picName;
	
	@NotBlank
	private Long cityId;
	
	@NotBlank
	@Column(length = 255)
	private String address;
	
	@NotBlank
	@Column(length = 255)
	private String businessType;
	
	@NotBlank
	@Column(length = 5)
	private String postCode;

	public Long getMainAccountId() {
		return mainAccountId;
	}

	public void setMainAccountId(Long mainAccountId) {
		this.mainAccountId = mainAccountId;
	}

	public String getMainAccountNo() {
		return mainAccountNo;
	}

	public void setMainAccountNo(String mainAccountNo) {
		this.mainAccountNo = mainAccountNo;
	}
	
	public String getMainAccountName() {
		return mainAccountName;
	}

	public void setMainAccountName(String mainAccountName) {
		this.mainAccountName = mainAccountName;
	}

	public Double getMainBalance() {
		return mainBalance;
	}

	public void setMainBalance(Double mainBalance) {
		this.mainBalance = mainBalance;
	}

	public String getPicPhone() {
		return picPhone;
	}

	public void setPicPhone(String picPhone) {
		this.picPhone = picPhone;
	}

	public String getPicName() {
		return picName;
	}

	public void setPicName(String picName) {
		this.picName = picName;
	}

	public Long getCityId() {
		return cityId;
	}

	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBusinessType() {
		return businessType;
	}

	public void setBusinessType(String businessType) {
		this.businessType = businessType;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	
}
