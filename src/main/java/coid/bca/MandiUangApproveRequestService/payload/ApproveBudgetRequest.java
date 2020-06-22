package coid.bca.MandiUangApproveRequestService.payload;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ApproveBudgetRequest {
	
	@JsonProperty("req_id")
	@NotBlank
	private Long reqId;

	@JsonProperty("approved_amt")
	@NotBlank
    private Double approvedAmt;
    
	@JsonProperty("remarks")
	@NotBlank
	private String remarks;
    
    @JsonProperty("verification_code")
    @NotBlank
    private String verificationCode;

	public Double getApprovedAmt() {
		return approvedAmt;
	}

	public void setApprovedAmt(Double approvedAmt) {
		this.approvedAmt = approvedAmt;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getVerificationCode() {
		return verificationCode;
	}

	public void setVerificationCode(String verificationCode) {
		this.verificationCode = verificationCode;
	}

	public Long getReqId() {
		return reqId;
	}

	public void setReqId(Long reqId) {
		this.reqId = reqId;
	}
}
