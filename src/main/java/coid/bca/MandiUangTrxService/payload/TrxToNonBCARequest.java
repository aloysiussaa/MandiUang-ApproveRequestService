package coid.bca.MandiUangTrxService.payload;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TrxToNonBCARequest {

	@JsonProperty("transfer_to_non_acct")
	@NotBlank
    private String transferToNonAcct;
	
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
    
    @JsonProperty("bank_name")
    @NotBlank
    private String bankName;

	public String getTransferToNonAcct() {
		return transferToNonAcct;
	}

	public void setTransferToNonAcct(String transferToNonAcct) {
		this.transferToNonAcct = transferToNonAcct;
	}

	public String getTransferType() {
		return transferType;
	}

	public void setTransferType(String transferType) {
		this.transferType = transferType;
	}

	public Integer getBeneficiaryId() {
		return beneficiaryId;
	}

	public void setBeneficiaryId(Integer beneficiaryId) {
		this.beneficiaryId = beneficiaryId;
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

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
    
}
