package coid.bca.MandiUangTrxService.model;

import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;


@Entity
@Table(name = "branch_acct_trx_BCA_fact")
public class BranchTrxToBCA {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long branchBcaTrxId;
	//branch_bca_trx_id
	
	@NotBlank
	private Long branchAccountId; 
	
	@NotBlank
	private String acctRecNo;
	
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
	
	public BranchTrxToBCA (String acctRecNo, Long branchAccountId, String transferType, Integer beneficiaryId, Double trxAmount, Date trxDate, String trxByUser) {
		this.acctRecNo = acctRecNo;
		this.branchAccountId = branchAccountId;
		this.transferType = transferType;
		this.beneficiaryId = beneficiaryId;
		this.trxAmount = trxAmount;
		this.trxDate = trxDate;
		this.trxByUser = trxByUser;
	}
	
	public BranchTrxToBCA() {
		
	}

	public Long getBranchBcaTrxId() {
		return branchBcaTrxId;
	}

	public void setBranchBcaTrxId(Long branchBcaTrxId) {
		this.branchBcaTrxId = branchBcaTrxId;
	}

	public Long getBranchAccountId() {
		return branchAccountId;
	}

	public void setBranchAccountId(Long branchAccountId) {
		this.branchAccountId = branchAccountId;
	}

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
}
