package com.naturalprogrammer.srr.commons.domain;

import java.io.Serializable;
import java.time.Instant;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Version;

public abstract class AbstractEntity<ID extends Serializable> implements Serializable {
	
	private static final long serialVersionUID = -1598878306629145605L;

	@Id
	private ID id;
	
	@CreatedBy
	private ID createdBy;
	
	@CreatedDate
	private Instant createdDate;
	
	@LastModifiedBy
	private ID lastModifiedBy;
	
	@LastModifiedDate
	private Instant lastModifiedDate;
	
	@Version
	private long version;

	public ID getId() {
		return id;
	}

	public void setId(ID id) {
		this.id = id;
	}

	public ID getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(ID createdBy) {
		this.createdBy = createdBy;
	}

	public Instant getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Instant createdDate) {
		this.createdDate = createdDate;
	}

	public ID getLastModifiedBy() {
		return lastModifiedBy;
	}

	public void setLastModifiedBy(ID lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}

	public Instant getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(Instant lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	public long getVersion() {
		return version;
	}

	public void setVersion(long version) {
		this.version = version;
	}
}
