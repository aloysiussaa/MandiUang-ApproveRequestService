package coid.bca.MandiUangTrxService.model.audit;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.time.Instant;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(
        value = {"dateStarted", "dateUpdated"},
        allowGetters = true
)
public abstract class DateAudit implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@CreatedDate
    @Column(nullable = false, updatable = false)
    private Instant dateStarted;

    @LastModifiedDate
    @Column(nullable = false)
    private Instant dateUpdated;

	public Instant getDateStarted() {
		return dateStarted;
	}

	public void setDateStarted(Instant dateStarted) {
		this.dateStarted = dateStarted;
	}

	public Instant getDateUpdated() {
		return dateUpdated;
	}

	public void setDateUpdated(Instant dateUpdated) {
		this.dateUpdated = dateUpdated;
	}

}