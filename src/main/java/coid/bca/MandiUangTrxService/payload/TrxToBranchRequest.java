package coid.bca.MandiUangTrxService.payload;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TrxToBranchRequest {

	@JsonProperty("transfer_to_acct")
	@NotBlank
    private String transferToAcct;
	
	@JsonProperty("transfer_type")
    @NotBlank
    private String transferType;
    
	@JsonProperty("trx_amount")
    @NotBlank
    private Double trxAmount;
    
    @JsonProperty("verification_code")
    @NotBlank
    private String verificationCode;

	public String getTransferToAcct() {
		return transferToAcct;
	}

	public void setTransferToAcct(String transferToAcct) {
		this.transferToAcct = transferToAcct;
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
    
    
}
