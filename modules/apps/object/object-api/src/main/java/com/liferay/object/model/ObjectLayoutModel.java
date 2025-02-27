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
 * The base model interface for the ObjectLayout service. Represents a row in the &quot;ObjectLayout&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.liferay.object.model.impl.ObjectLayoutModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.liferay.object.model.impl.ObjectLayoutImpl</code>.
 * </p>
 *
 * @author Marco Leo
 * @see ObjectLayout
 * @generated
 */
@ProviderType
public interface ObjectLayoutModel
	extends BaseModel<ObjectLayout>, MVCCModel, ShardedModel,
			StagedAuditedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a object layout model instance should use the {@link ObjectLayout} interface instead.
	 */

	/**
	 * Returns the primary key of this object layout.
	 *
	 * @return the primary key of this object layout
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this object layout.
	 *
	 * @param primaryKey the primary key of this object layout
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the mvcc version of this object layout.
	 *
	 * @return the mvcc version of this object layout
	 */
	@Override
	public long getMvccVersion();

	/**
	 * Sets the mvcc version of this object layout.
	 *
	 * @param mvccVersion the mvcc version of this object layout
	 */
	@Override
	public void setMvccVersion(long mvccVersion);

	/**
	 * Returns the uuid of this object layout.
	 *
	 * @return the uuid of this object layout
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this object layout.
	 *
	 * @param uuid the uuid of this object layout
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the object layout ID of this object layout.
	 *
	 * @return the object layout ID of this object layout
	 */
	public long getObjectLayoutId();

	/**
	 * Sets the object layout ID of this object layout.
	 *
	 * @param objectLayoutId the object layout ID of this object layout
	 */
	public void setObjectLayoutId(long objectLayoutId);

	/**
	 * Returns the company ID of this object layout.
	 *
	 * @return the company ID of this object layout
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this object layout.
	 *
	 * @param companyId the company ID of this object layout
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this object layout.
	 *
	 * @return the user ID of this object layout
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this object layout.
	 *
	 * @param userId the user ID of this object layout
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this object layout.
	 *
	 * @return the user uuid of this object layout
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this object layout.
	 *
	 * @param userUuid the user uuid of this object layout
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this object layout.
	 *
	 * @return the user name of this object layout
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this object layout.
	 *
	 * @param userName the user name of this object layout
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this object layout.
	 *
	 * @return the create date of this object layout
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this object layout.
	 *
	 * @param createDate the create date of this object layout
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this object layout.
	 *
	 * @return the modified date of this object layout
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this object layout.
	 *
	 * @param modifiedDate the modified date of this object layout
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	@Override
	public ObjectLayout cloneWithOriginalValues();

}