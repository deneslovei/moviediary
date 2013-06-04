package org.nnc.moviediary.domain.entities;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@MappedSuperclass
public class BaseEntity implements Serializable {
	private static final long serialVersionUID = 2553248050343601424L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "visible", nullable = false)
	private Boolean visible = false;

	@Column(name = "last_update_date", nullable = false)
	private Timestamp lastUpdateDate;

	public BaseEntity() {
	}

	public BaseEntity(final long id, final Boolean visible) {
		super();
		this.id = id;
		this.visible = visible;
	}

	public BaseEntity(final long id) {
		this.id = id;
	}

	public void setId(final long id) {
		this.id = id;
	}

	private void setLastUpdateDate(final Timestamp lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	@PrePersist
	protected void beforePersist() {
		this.setLastUpdateDate(new Timestamp(System.currentTimeMillis()));
	}

	@PreUpdate
	protected void beforeUpdate() {
		this.setLastUpdateDate(new Timestamp(System.currentTimeMillis()));
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}
