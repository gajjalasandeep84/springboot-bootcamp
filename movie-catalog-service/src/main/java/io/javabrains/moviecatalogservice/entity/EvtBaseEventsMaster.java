// Generated with g9.

package io.javabrains.moviecatalogservice.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@SuppressWarnings("serial")
@Entity(name = "EVT_BASE_EVENTS_MASTER")
//@IdClass(EvtBaseEventsMaster.EvtBaseEventsMasterId.class)
public class EvtBaseEventsMaster implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5956937449310070063L;

	/**

	/**
	 * The optimistic lock. Available via standard bean get/set operations.
	 */
	/*
	 * @Version
	 * 
	 * @Column(name="LOCK_FLAG") private Integer lockFlag;
	 */

	/*   *//**
			 * Access method for the lockFlag property.
			 *
			 * @return the current value of the lockFlag property
			 */
	/*
	 * public Integer getLockFlag() { return lockFlag; }
	 * 
	 *//**
		 * Sets the value of the lockFlag property.
		 *
		 * @param aLockFlag the new value of the lockFlag property
		 *//*
			 * public void setLockFlag(Integer aLockFlag) { lockFlag = aLockFlag; }
			 */

	@Id
	@Column(name = "BASE_EVENT_NAME", nullable = false, length = 50)
	private String baseEventName;
	@Column(name = "CREATED_BY", nullable = false, length = 150)
	private String createdBy;
	@Column(name = "CREATED_DATE", nullable = false)
	private LocalDateTime createdDate;
	@Column(name = "UPDATED_BY", length = 150)
	private String updatedBy;
	@Column(name = "UPDATED_DATE")
	private LocalDateTime updatedDate;

	/** Default constructor. */
	public EvtBaseEventsMaster() {
		
	}

	public EvtBaseEventsMaster(String baseEventName, String createdBy, LocalDateTime createdDate, String updatedBy,
			LocalDateTime updatedDate) {
		this.baseEventName = baseEventName;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.updatedBy = updatedBy;
		this.updatedDate = updatedDate;
	}

	/**
	 * Access method for baseEventName.
	 *
	 * @return the current value of baseEventName
	 */
	public String getBaseEventName() {
		return baseEventName;
	}

	/**
	 * Setter method for baseEventName.
	 *
	 * @param aBaseEventName the new value for baseEventName
	 */
	public void setBaseEventName(String aBaseEventName) {
		baseEventName = aBaseEventName;
	}

	/**
	 * Access method for createdBy.
	 *
	 * @return the current value of createdBy
	 */
	public String getCreatedBy() {
		return createdBy;
	}

	/**
	 * Setter method for createdBy.
	 *
	 * @param aCreatedBy the new value for createdBy
	 */
	public void setCreatedBy(String aCreatedBy) {
		createdBy = aCreatedBy;
	}

	/**
	 * Access method for createdDate.
	 *
	 * @return the current value of createdDate
	 */
	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	/**
	 * Setter method for createdDate.
	 *
	 * @param aCreatedDate the new value for createdDate
	 */
	public void setCreatedDate(LocalDateTime aCreatedDate) {
		createdDate = aCreatedDate;
	}

	/**
	 * Access method for updatedBy.
	 *
	 * @return the current value of updatedBy
	 */
	public String getUpdatedBy() {
		return updatedBy;
	}

	/**
	 * Setter method for updatedBy.
	 *
	 * @param aUpdatedBy the new value for updatedBy
	 */
	public void setUpdatedBy(String aUpdatedBy) {
		updatedBy = aUpdatedBy;
	}

	/**
	 * Access method for updatedDate.
	 *
	 * @return the current value of updatedDate
	 */
	public LocalDateTime getUpdatedDate() {
		return updatedDate;
	}

	/**
	 * Setter method for updatedDate.
	 *
	 * @param aUpdatedDate the new value for updatedDate
	 */
	public void setUpdatedDate(LocalDateTime aUpdatedDate) {
		updatedDate = aUpdatedDate;
	}

	/**
	 * Compares the key for this instance with another EvtBaseEventsMaster.
	 *
	 * @param other The object to compare to
	 * @return True if other object is instance of class EvtBaseEventsMaster and the
	 *         key objects are equal
	 */
	private boolean equalKeys(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof EvtBaseEventsMaster)) {
			return false;
		}
		EvtBaseEventsMaster that = (EvtBaseEventsMaster) other;
		Object myBaseEventName = this.getBaseEventName();
		Object yourBaseEventName = that.getBaseEventName();
		if (myBaseEventName == null ? yourBaseEventName != null : !myBaseEventName.equals(yourBaseEventName)) {
			return false;
		}
		return true;
	}

	/**
	 * Compares this instance with another EvtBaseEventsMaster.
	 *
	 * @param other The object to compare to
	 * @return True if the objects are the same
	 */
	@Override
	public boolean equals(Object other) {
		if (!(other instanceof EvtBaseEventsMaster))
			return false;
		return this.equalKeys(other) && ((EvtBaseEventsMaster) other).equalKeys(this);
	}

	/**
	 * Returns a hash code for this instance.
	 *
	 * @return Hash code
	 */
	@Override
	public int hashCode() {
		int i;
		int result = 17;
		if (getBaseEventName() == null) {
			i = 0;
		} else {
			i = getBaseEventName().hashCode();
		}
		result = 37 * result + i;
		return result;
	}

	/**
	 * Returns a debug-friendly String representation of this instance.
	 *
	 * @return String representation of this instance
	 */
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer("[EvtBaseEventsMaster |");
		sb.append(" baseEventName=").append(getBaseEventName());
		sb.append("]");
		return sb.toString();
	}

	/**
	 * Return all elements of the primary key.
	 *
	 * @return Map of key names to values
	 */
	public Map<String, Object> getPrimaryKey() {
		Map<String, Object> ret = new LinkedHashMap<String, Object>(6);
		ret.put("baseEventName", getBaseEventName());
		return ret;
	}

}
