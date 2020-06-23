package coid.bca.MandiUangTrxService.model;

import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "branch_acct_trx_NON_fact")
public class BranchTrxToNonBCA {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long branchNonTrxId;
	
	@NotBlank
	private Long branchAccountId; 
	
	@NotBlank
	private String transferToNonAcct;
	
	@NotBlank
	private String transferType;
	
	@NotBlank
	private Integer beneficiaryId;
	
	@NotBlank
	private Double trxAmount;
	
	@NotBlank
	private Date trxDate;
	
	@NotBlank
	private String trxByUser;
	
	@NotBlank
	private String bankName;
	
	public BranchTrxToNonBCA (String transferToNonAcct, Long branchAccountId, String transferType, Integer beneficiaryId, Double trxAmount, Date trxDate, String trxByUser, String bankName) {
		this.transferToNonAcct = transferToNonAcct;
		this.branchAccountId = branchAccountId;
		this.transferType = transferType;
		this.beneficiaryId = beneficiaryId;
		this.trxAmount = trxAmount;
		this.trxDate = trxDate;
		this.trxByUser = trxByUser;
		this.bankName = bankName;
	}

	public Long getBranchNonTrxId() {
		return branchNonTrxId;
	}

	public void setBranchNonTrxId(Long branchNonTrxId) {
		this.branchNonTrxId = branchNonTrxId;
	}

	public Long getBranchAccountId() {
		return branchAccountId;
	}

	public void setBranchAccountId(Long branchAccountId) {
		this.branchAccountId = branchAccountId;
	}

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

	public Date getTrxDate() {
		return trxDate;
	}

	public void setTrxDate(Date trxDate) {
		this.trxDate = trxDate;
	}

	public String getTrxByUser() {
		return trxByUser;
	}

	public void setTrxByUser(String trxByUser) {
		this.trxByUser = trxByUser;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	
	
}
