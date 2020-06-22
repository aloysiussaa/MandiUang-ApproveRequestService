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
@Table(name = "approve_budget_fact")
public class MainApproveBudget {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long approveId;
	
	@NotBlank
	private Long reqId;
	
	@NotBlank
	private Long branchAcctIdReceive;
	
	@NotBlank
	@Column(length = 20)
	private String reviewedBy;
	
	@Column(length = 255)
	private String remarks;
	
	@Column(length = 50)
	private String status;
	
	@NotBlank
	private Double approvedAmt;
	
	@NotBlank
	private Date reviewDate;
	
	public MainApproveBudget(Long reqId, Double approvedAmt, Long branchAcctIdReceive, String reviewedBy, Date reviewDate, 
			String remarks, String status) {
		this.reqId = reqId;
		this.approvedAmt = approvedAmt;
		this.branchAcctIdReceive = branchAcctIdReceive;
		this.reviewedBy = reviewedBy;
		this.reviewDate = reviewDate;
		this.remarks = remarks;
		this.status = status;
	}
	
	public MainApproveBudget() {
		
	}

	public Long getApproveId() {
		return approveId;
	}

	public void setApproveId(Long approveId) {
		this.approveId = approveId;
	}

	public Long getReqId() {
		return reqId;
	}

	public void setReqId(Long reqId) {
		this.reqId = reqId;
	}

	public Long getBranchAcctIdReceive() {
		return branchAcctIdReceive;
	}

	public void setBranchAcctIdReceive(Long branchAcctIdReceive) {
		this.branchAcctIdReceive = branchAcctIdReceive;
	}

	public String getReviewedBy() {
		return reviewedBy;
	}

	public void setReviewedBy(String reviewedBy) {
		this.reviewedBy = reviewedBy;
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

	public Double getApprovedAmt() {
		return approvedAmt;
	}

	public void setApprovedAmt(Double approvedAmt) {
		this.approvedAmt = approvedAmt;
	}

	public Date getReviewDate() {
		return reviewDate;
	}

	public void setReviewDate(Date reviewDate) {
		this.reviewDate = reviewDate;
	}
}
