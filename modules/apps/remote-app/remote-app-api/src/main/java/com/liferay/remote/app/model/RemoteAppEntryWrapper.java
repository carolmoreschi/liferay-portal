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

package com.liferay.remote.app.model;

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link RemoteAppEntry}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RemoteAppEntry
 * @generated
 */
public class RemoteAppEntryWrapper
	extends BaseModelWrapper<RemoteAppEntry>
	implements ModelWrapper<RemoteAppEntry>, RemoteAppEntry {

	public RemoteAppEntryWrapper(RemoteAppEntry remoteAppEntry) {
		super(remoteAppEntry);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("mvccVersion", getMvccVersion());
		attributes.put("uuid", getUuid());
		attributes.put("remoteAppEntryId", getRemoteAppEntryId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("name", getName());
		attributes.put("url", getUrl());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long mvccVersion = (Long)attributes.get("mvccVersion");

		if (mvccVersion != null) {
			setMvccVersion(mvccVersion);
		}

		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long remoteAppEntryId = (Long)attributes.get("remoteAppEntryId");

		if (remoteAppEntryId != null) {
			setRemoteAppEntryId(remoteAppEntryId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String url = (String)attributes.get("url");

		if (url != null) {
			setUrl(url);
		}
	}

	@Override
	public RemoteAppEntry cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	@Override
	public String[] getAvailableLanguageIds() {
		return model.getAvailableLanguageIds();
	}

	/**
	 * Returns the company ID of this remote app entry.
	 *
	 * @return the company ID of this remote app entry
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the container model ID of this remote app entry.
	 *
	 * @return the container model ID of this remote app entry
	 */
	@Override
	public long getContainerModelId() {
		return model.getContainerModelId();
	}

	/**
	 * Returns the container name of this remote app entry.
	 *
	 * @return the container name of this remote app entry
	 */
	@Override
	public String getContainerModelName() {
		return model.getContainerModelName();
	}

	/**
	 * Returns the create date of this remote app entry.
	 *
	 * @return the create date of this remote app entry
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	@Override
	public String getDefaultLanguageId() {
		return model.getDefaultLanguageId();
	}

	/**
	 * Returns the modified date of this remote app entry.
	 *
	 * @return the modified date of this remote app entry
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the mvcc version of this remote app entry.
	 *
	 * @return the mvcc version of this remote app entry
	 */
	@Override
	public long getMvccVersion() {
		return model.getMvccVersion();
	}

	/**
	 * Returns the name of this remote app entry.
	 *
	 * @return the name of this remote app entry
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the localized name of this remote app entry in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized name of this remote app entry
	 */
	@Override
	public String getName(java.util.Locale locale) {
		return model.getName(locale);
	}

	/**
	 * Returns the localized name of this remote app entry in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized name of this remote app entry. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getName(java.util.Locale locale, boolean useDefault) {
		return model.getName(locale, useDefault);
	}

	/**
	 * Returns the localized name of this remote app entry in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized name of this remote app entry
	 */
	@Override
	public String getName(String languageId) {
		return model.getName(languageId);
	}

	/**
	 * Returns the localized name of this remote app entry in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized name of this remote app entry
	 */
	@Override
	public String getName(String languageId, boolean useDefault) {
		return model.getName(languageId, useDefault);
	}

	@Override
	public String getNameCurrentLanguageId() {
		return model.getNameCurrentLanguageId();
	}

	@Override
	public String getNameCurrentValue() {
		return model.getNameCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized names of this remote app entry.
	 *
	 * @return the locales and localized names of this remote app entry
	 */
	@Override
	public Map<java.util.Locale, String> getNameMap() {
		return model.getNameMap();
	}

	/**
	 * Returns the parent container model ID of this remote app entry.
	 *
	 * @return the parent container model ID of this remote app entry
	 */
	@Override
	public long getParentContainerModelId() {
		return model.getParentContainerModelId();
	}

	/**
	 * Returns the primary key of this remote app entry.
	 *
	 * @return the primary key of this remote app entry
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the remote app entry ID of this remote app entry.
	 *
	 * @return the remote app entry ID of this remote app entry
	 */
	@Override
	public long getRemoteAppEntryId() {
		return model.getRemoteAppEntryId();
	}

	/**
	 * Returns the url of this remote app entry.
	 *
	 * @return the url of this remote app entry
	 */
	@Override
	public String getUrl() {
		return model.getUrl();
	}

	/**
	 * Returns the user ID of this remote app entry.
	 *
	 * @return the user ID of this remote app entry
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this remote app entry.
	 *
	 * @return the user name of this remote app entry
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this remote app entry.
	 *
	 * @return the user uuid of this remote app entry
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this remote app entry.
	 *
	 * @return the uuid of this remote app entry
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	@Override
	public void prepareLocalizedFieldsForImport()
		throws com.liferay.portal.kernel.exception.LocaleException {

		model.prepareLocalizedFieldsForImport();
	}

	@Override
	public void prepareLocalizedFieldsForImport(
			java.util.Locale defaultImportLocale)
		throws com.liferay.portal.kernel.exception.LocaleException {

		model.prepareLocalizedFieldsForImport(defaultImportLocale);
	}

	/**
	 * Sets the company ID of this remote app entry.
	 *
	 * @param companyId the company ID of this remote app entry
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the container model ID of this remote app entry.
	 *
	 * @param containerModelId the container model ID of this remote app entry
	 */
	@Override
	public void setContainerModelId(long containerModelId) {
		model.setContainerModelId(containerModelId);
	}

	/**
	 * Sets the create date of this remote app entry.
	 *
	 * @param createDate the create date of this remote app entry
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the modified date of this remote app entry.
	 *
	 * @param modifiedDate the modified date of this remote app entry
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the mvcc version of this remote app entry.
	 *
	 * @param mvccVersion the mvcc version of this remote app entry
	 */
	@Override
	public void setMvccVersion(long mvccVersion) {
		model.setMvccVersion(mvccVersion);
	}

	/**
	 * Sets the name of this remote app entry.
	 *
	 * @param name the name of this remote app entry
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the localized name of this remote app entry in the language.
	 *
	 * @param name the localized name of this remote app entry
	 * @param locale the locale of the language
	 */
	@Override
	public void setName(String name, java.util.Locale locale) {
		model.setName(name, locale);
	}

	/**
	 * Sets the localized name of this remote app entry in the language, and sets the default locale.
	 *
	 * @param name the localized name of this remote app entry
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setName(
		String name, java.util.Locale locale, java.util.Locale defaultLocale) {

		model.setName(name, locale, defaultLocale);
	}

	@Override
	public void setNameCurrentLanguageId(String languageId) {
		model.setNameCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized names of this remote app entry from the map of locales and localized names.
	 *
	 * @param nameMap the locales and localized names of this remote app entry
	 */
	@Override
	public void setNameMap(Map<java.util.Locale, String> nameMap) {
		model.setNameMap(nameMap);
	}

	/**
	 * Sets the localized names of this remote app entry from the map of locales and localized names, and sets the default locale.
	 *
	 * @param nameMap the locales and localized names of this remote app entry
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setNameMap(
		Map<java.util.Locale, String> nameMap, java.util.Locale defaultLocale) {

		model.setNameMap(nameMap, defaultLocale);
	}

	/**
	 * Sets the parent container model ID of this remote app entry.
	 *
	 * @param parentContainerModelId the parent container model ID of this remote app entry
	 */
	@Override
	public void setParentContainerModelId(long parentContainerModelId) {
		model.setParentContainerModelId(parentContainerModelId);
	}

	/**
	 * Sets the primary key of this remote app entry.
	 *
	 * @param primaryKey the primary key of this remote app entry
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the remote app entry ID of this remote app entry.
	 *
	 * @param remoteAppEntryId the remote app entry ID of this remote app entry
	 */
	@Override
	public void setRemoteAppEntryId(long remoteAppEntryId) {
		model.setRemoteAppEntryId(remoteAppEntryId);
	}

	/**
	 * Sets the url of this remote app entry.
	 *
	 * @param url the url of this remote app entry
	 */
	@Override
	public void setUrl(String url) {
		model.setUrl(url);
	}

	/**
	 * Sets the user ID of this remote app entry.
	 *
	 * @param userId the user ID of this remote app entry
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this remote app entry.
	 *
	 * @param userName the user name of this remote app entry
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this remote app entry.
	 *
	 * @param userUuid the user uuid of this remote app entry
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this remote app entry.
	 *
	 * @param uuid the uuid of this remote app entry
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	public StagedModelType getStagedModelType() {
		return model.getStagedModelType();
	}

	@Override
	protected RemoteAppEntryWrapper wrap(RemoteAppEntry remoteAppEntry) {
		return new RemoteAppEntryWrapper(remoteAppEntry);
	}

}