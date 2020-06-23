package coid.bca.MandiUangTrxService.model;

import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "branch_account_dimension")
public class BranchAccount {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long branchAccountId;
	
	@NotBlank
	@Column(length = 10)
	private String branchAccountNo; 
	
	@NotBlank
	private Long mainAccountId;
	
	@NotBlank
	@Column(length = 255)
	private String branchName;
	
	@Column(length = 25)
	private String picPhone;
	
	@Column(length = 255)
	private String picName;
	
	@Column(length = 255)
	private String address;
	
	@Column(length = 50)
	private String businessType;
	
	@NotBlank
    @Size(max = 40)
    private String createdBy;
	
	@NotBlank
    @Size(max = 10)
    private Integer cityId;
    
    @NotBlank
    private Date dateStarted;
    
    @Size(max = 40)
    private String updatedBy;
    
    @Size(max = 40)
    private String endedBy;
    
    @Size(max = 100)
    private String updateReason;
    
    private Date dateEnded;
    
    private Date dateUpdated;
    
    private Double branchBalance;
    
    public BranchAccount(String branchAccountNo, Long mainAccountId, String branchName, String picPhone, String picName, Integer cityId, 
    		String businessType, String address, String createdBy, Date dateStarted, Double branchBalance) {
    	this.branchAccountNo = branchAccountNo;
    	this.mainAccountId = mainAccountId;
    	this.branchName = branchName;
    	this.picPhone = picPhone;
    	this.picName = picName;
    	this.cityId = cityId;
    	this.businessType = businessType;
    	this.address = address;
    	this.createdBy = createdBy;
    	this.dateStarted = dateStarted;
    	this.branchBalance = branchBalance;
    }
    
    public BranchAccount() {
    	
    }

	public Long getBranchAccountId() {
		return branchAccountId;
	}

	public void setBranchAccountId(Long branchAccountId) {
		this.branchAccountId = branchAccountId;
	}

	public String getBranchAccountNo() {
		return branchAccountNo;
	}

	public void setBranchAccountNo(String branchAccountNo) {
		this.branchAccountNo = branchAccountNo;
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

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getEndedBy() {
		return endedBy;
	}

	public void setEndedBy(String endedBy) {
		this.endedBy = endedBy;
	}

	public String getUpdateReason() {
		return updateReason;
	}

	public void setUpdateReason(String updateReason) {
		this.updateReason = updateReason;
	}

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public Date getDateEnded() {
		return dateEnded;
	}

	public void setDateEnded(Date dateEnded) {
		this.dateEnded = dateEnded;
	}

	public Date getDateStarted() {
		return dateStarted;
	}

	public void setDateStarted(Date dateStarted) {
		this.dateStarted = dateStarted;
	}

	public Date getDateUpdated() {
		return dateUpdated;
	}

	public void setDateUpdated(Date dateUpdated) {
		this.dateUpdated = dateUpdated;
	}

	public Double getBranchBalance() {
		return branchBalance;
	}

	public void setBranchBalance(Double branchBalance) {
		this.branchBalance = branchBalance;
	}

	public Long getMainAccountId() {
		return mainAccountId;
	}

	public void setMainAccountId(Long mainAccountId) {
		this.mainAccountId = mainAccountId;
	}
}
