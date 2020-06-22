package coid.bca.MandiUangApproveRequestService.payload;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ReqBudgetRequest {
	
	@JsonProperty("request_amt")
	@NotBlank
    private Double requestAmt;
	
	@JsonProperty("request_type")
    @NotBlank
    private String requestType;
    
	@JsonProperty("purpose")
	@NotBlank
	private String purpose;
	
	@JsonProperty("remarks")
	@NotBlank
	private String remarks;
    
    @JsonProperty("verification_code")
    @NotBlank
    private String verificationCode;

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

	public String getVerificationCode() {
		return verificationCode;
	}

	public void setVerificationCode(String verificationCode) {
		this.verificationCode = verificationCode;
	}
	
}
