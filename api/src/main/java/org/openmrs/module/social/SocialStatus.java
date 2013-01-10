/**
 * The contents of this file are subject to the OpenMRS Public License
 * Version 1.0 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 * http://license.openmrs.org
 *
 * Software distributed under the License is distributed on an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
 * License for the specific language governing rights and limitations
 * under the License.
 *
 * Copyright (C) OpenMRS, LLC.  All Rights Reserved.
 */
package org.openmrs.module.social;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.openmrs.BaseOpenmrsData;
import org.openmrs.User;

@Entity
@Table(name = "social_social_status")
public class SocialStatus extends BaseOpenmrsData {
	
	@Id
	@GeneratedValue
	@Column(name = "social_status_id")
	private Integer socialStatusId;
	
	@ManyToOne
	@JoinColumn(name = "user")
	private User user;
	
	@Basic
	@Column(name = "status", length = 255)
	private String status;
	
	public SocialStatus() {
	}
	
	public SocialStatus(User user, String status) {
		this.user = user;
		this.status = status;
	}
	
	@Override
	public Integer getId() {
		return socialStatusId;
	}
	
	/**
	 * @see org.openmrs.OpenmrsObject#setId(java.lang.Integer)
	 */
	@Override
	public void setId(Integer id) {
		this.socialStatusId = id;
	}
	
	public Integer getSocialStatusId() {
		return socialStatusId;
	}
	
	public void setSocialStatusId(Integer socialStatusId) {
		this.socialStatusId = socialStatusId;
	}
	
	/**
	 * @see org.openmrs.BaseOpenmrsObject#getUuid()
	 */
	@Basic
	@Access(AccessType.PROPERTY)
	@Column(name = "uuid", length = 38, unique = true)
	@Override
	public String getUuid() {
		return super.getUuid();
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	public User getUser() {
		return user;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
}
