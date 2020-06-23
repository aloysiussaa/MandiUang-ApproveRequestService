package coid.bca.MandiUangTrxService.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "main_acct_trx_fact")
public class MainTrxToBranch {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer mainAcctTrxId;
	
	@NotBlank
	private Long mainAccountId; 
	
	@NotBlank
	private String transferToAcct;
	
	@NotBlank
	private String transferType;
	
	@NotBlank
	private Double trxAmount;
	
	@NotBlank
	private Date trxDate;
	
	@NotBlank
	private String trxByUser;
	
	public MainTrxToBranch(Long mainAccountId, String transferToAcct, String transferType, Double trxAmount,
			Date trxDate, String trxByUser) {
		this.mainAccountId = mainAccountId;
		this.transferToAcct = transferToAcct;
		this.transferType = transferType;
		this.trxAmount = trxAmount;
		this.trxDate = trxDate;
		this.trxByUser = trxByUser;
	}
	
	public MainTrxToBranch() {
		
	}

	public Integer getMainAcctTrxId() {
		return mainAcctTrxId;
	}

	public void setMainAcctTrxId(Integer mainAcctTrxId) {
		this.mainAcctTrxId = mainAcctTrxId;
	}

	public Long getMainAccountId() {
		return mainAccountId;
	}

	public void setMainAccountId(Long mainAccountId) {
		this.mainAccountId = mainAccountId;
	}

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
