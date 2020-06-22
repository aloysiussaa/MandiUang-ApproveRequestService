package coid.bca.MandiUangApproveRequestService.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "request_budget_fact")
public class BranchReqBudget {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reqId;
	
	@NotBlank
	private Long branchAcctIdSubmit;
	
	@NotBlank
	private Long mainAccountId;
	
	@NotBlank
	@Column(length = 20)
	private String submitBy;
	
	@Column(length = 50)
	private String purpose;
	
	@Column(length = 255)
	private String remarks;
	
	@Column(length = 50)
	private String status;
	
	@NotBlank
	private Double requestAmt;
	
	@NotBlank
	private String requestType;
	
	@NotBlank
	private Date submitDate;
	
	public BranchReqBudget(Long branchAcctIdSubmit, Long mainAccountId, String submitBy, String purpose, String remarks, String status, Double requestAmt,
			String requestType, Date submitDate) {
		this.branchAcctIdSubmit = branchAcctIdSubmit;
		this.mainAccountId = mainAccountId;
		this.submitBy = submitBy;
		this.purpose = purpose;
		this.remarks = remarks;
		this.status = status;
		this.requestAmt = requestAmt;
		this.requestType = requestType;
		this.submitDate = submitDate;
	}
	
	public BranchReqBudget() {
		
	}

	public Long getReqId() {
		return reqId;
	}

	public void setReqId(Long reqId) {
		this.reqId = reqId;
	}

	public Long getBranchAcctIdSubmit() {
		return branchAcctIdSubmit;
	}

	public void setBranchAcctIdSubmit(Long branchAcctIdSubmit) {
		this.branchAcctIdSubmit = branchAcctIdSubmit;
	}

	public String getSubmitBy() {
		return submitBy;
	}

	public void setSubmitBy(String submitBy) {
		this.submitBy = submitBy;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Double getRequestAmt() {
		return requestAmt;
	}

	public void setRequestAmt(Double requestAmt) {
		this.requestAmt = requestAmt;
	}

	public String getRequestType() {
		return requestType;
	}

	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}

	public Date getSubmitDate() {
		return submitDate;
	}

	public void setSubmitDate(Date submitDate) {
		this.submitDate = submitDate;
	}

	public Long getMainAccountId() {
		return mainAccountId;
	}

	public void setMainAccountId(Long mainAccountId) {
		this.mainAccountId = mainAccountId;
	}
}

