package coid.bca.MandiUangTrxService.payload;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TrxToBCARequest {
	
	@JsonProperty("acct_rec_no")
	@NotBlank
    private String acctRecNo;
	
	@JsonProperty("transfer_type")
    @NotBlank
    private String transferType;
	
	@JsonProperty("beneficiary_id")
	@NotBlank
	private Integer beneficiaryId;
    
	@JsonProperty("trx_amount")
    @NotBlank
    private Double trxAmount;
    
    @JsonProperty("verification_code")
    @NotBlank
    private String verificationCode;

	public String getAcctRecNo() {
		return acctRecNo;
	}

	public void setAcctRecNo(String acctRecNo) {
		this.acctRecNo = acctRecNo;
	}

	public String getTransferType() {
		return transferType;
	}

	public void setTransferType(String transferType) {
		this.transferType = transferType;
	}

	public Double getTrxAmount() {
		return trxAmount;
	}

	public void setTrxAmount(Double trxAmount) {
		this.trxAmount = trxAmount;
	}

	public String getVerificationCode() {
		return verificationCode;
	}

	public void setVerificationCode(String verificationCode) {
		this.verificationCode = verificationCode;
	}

	public Integer getBeneficiaryId() {
		return beneficiaryId;
	}

	public void setBeneficiaryId(Integer beneficiaryId) {
		this.beneficiaryId = beneficiaryId;
	}
    
    
}
