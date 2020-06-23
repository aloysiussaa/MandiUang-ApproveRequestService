package coid.bca.MandiUangTrxService.model;

import org.hibernate.annotations.NaturalId;

import coid.bca.MandiUangTrxService.model.audit.DateAudit;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user_dimension", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
            "username"
        }),
        @UniqueConstraint(columnNames = {
            "email"
        })
})

public class User extends DateAudit {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
	
    @NotBlank
    @Size(max = 15)
    private String username;
    
    @NotBlank
    @Size(max = 20)
    private String password;
    
    @NotBlank
    @Size(max = 40)
    private String name;
    
	@NotBlank
    @Size(max = 10)
    private Long branchIdWork;
    
    @Size(max = 10)
    private Long mainIdWork;
	
	@NotBlank
    @Size(max = 20)
    private String jobPosition;
	
    @NotBlank
    @Size(max = 15)
    private String phoneNumber;
    
    @NaturalId
    @NotBlank
    @Size(max = 40)
    @Email
    private String email;
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();
    
    @NotBlank
    private Date lastLoginDate;
    
    @NotBlank
    @Size(max = 40)
    private String createdBy;
    
    @Size(max = 40)
    private String updatedBy;
    
    @Size(max = 60)
    private String updateReason;
    
    private Date dateEnded;
    
    public User() {

    }

    public User(Long branchIdWork , String name, String username, String phoneNumber, String email, String password, String jobPosition, String createdBy, String updatedBy) {
        this.branchIdWork = branchIdWork; 
    	this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.jobPosition = jobPosition;
        this.createdBy = createdBy; 
        this.updatedBy = updatedBy;
    }

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getBranchIdWork() {
		return branchIdWork;
	}

	public void setBranchIdWork(Long branchIdWork) {
		this.branchIdWork = branchIdWork;
	}
	
	public Long getMainIdWork() {
		return mainIdWork;
	}

	public void setMainIdWork(Long mainIdWork) {
		this.mainIdWork = mainIdWork;
	}

	public String getJobPosition() {
		return jobPosition;
	}

	public void setJobPosition(String jobPosition) {
		this.jobPosition = jobPosition;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public Date getLastLoginDate() {
		return lastLoginDate;
	}

	public void setLastLoginDate(Date lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public String getUpdateReason() {
		return updateReason;
	}

	public void setUpdateReason(String updateReason) {
		this.updateReason = updateReason;
	}

	public Date getDateEnded() {
		return dateEnded;
	}

	public void setDateEnded(Date dateEnded) {
		this.dateEnded = dateEnded;
	}

}
