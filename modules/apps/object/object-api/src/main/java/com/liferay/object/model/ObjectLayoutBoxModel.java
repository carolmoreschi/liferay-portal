/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.object.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.MVCCModel;
import com.liferay.portal.kernel.model.ShardedModel;
import com.liferay.portal.kernel.model.StagedAuditedModel;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the ObjectLayoutBox service. Represents a row in the &quot;ObjectLayoutBox&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.liferay.object.model.impl.ObjectLayoutBoxModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.liferay.object.model.impl.ObjectLayoutBoxImpl</code>.
 * </p>
 *
 * @author Marco Leo
 * @see ObjectLayoutBox
 * @generated
 */
@ProviderType
public interface ObjectLayoutBoxModel
	extends BaseModel<ObjectLayoutBox>, MVCCModel, ShardedModel,
			StagedAuditedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a object layout box model instance should use the {@link ObjectLayoutBox} interface instead.
	 */

	/**
	 * Returns the primary key of this object layout box.
	 *
	 * @return the primary key of this object layout box
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this object layout box.
	 *
	 * @param primaryKey the primary key of this object layout box
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the mvcc version of this object layout box.
	 *
	 * @return the mvcc version of this object layout box
	 */
	@Override
	public long getMvccVersion();

	/**
	 * Sets the mvcc version of this object layout box.
	 *
	 * @param mvccVersion the mvcc version of this object layout box
	 */
	@Override
	public void setMvccVersion(long mvccVersion);

	/**
	 * Returns the uuid of this object layout box.
	 *
	 * @return the uuid of this object layout box
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this object layout box.
	 *
	 * @param uuid the uuid of this object layout box
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the object layout box ID of this object layout box.
	 *
	 * @return the object layout box ID of this object layout box
	 */
	public long getObjectLayoutBoxId();

	/**
	 * Sets the object layout box ID of this object layout box.
	 *
	 * @param objectLayoutBoxId the object layout box ID of this object layout box
	 */
	public void setObjectLayoutBoxId(long objectLayoutBoxId);

	/**
	 * Returns the company ID of this object layout box.
	 *
	 * @return the company ID of this object layout box
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this object layout box.
	 *
	 * @param companyId the company ID of this object layout box
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this object layout box.
	 *
	 * @return the user ID of this object layout box
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this object layout box.
	 *
	 * @param userId the user ID of this object layout box
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this object layout box.
	 *
	 * @return the user uuid of this object layout box
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this object layout box.
	 *
	 * @param userUuid the user uuid of this object layout box
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this object layout box.
	 *
	 * @return the user name of this object layout box
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this object layout box.
	 *
	 * @param userName the user name of this object layout box
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this object layout box.
	 *
	 * @return the create date of this object layout box
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this object layout box.
	 *
	 * @param createDate the create date of this object layout box
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this object layout box.
	 *
	 * @return the modified date of this object layout box
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this object layout box.
	 *
	 * @param modifiedDate the modified date of this object layout box
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	@Override
	public ObjectLayoutBox cloneWithOriginalValues();

}