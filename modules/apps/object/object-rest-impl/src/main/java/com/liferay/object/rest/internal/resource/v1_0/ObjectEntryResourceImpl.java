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

package com.liferay.object.rest.internal.resource.v1_0;

import com.liferay.object.model.ObjectDefinition;
import com.liferay.object.rest.dto.v1_0.ObjectEntry;
import com.liferay.object.rest.internal.odata.entity.v1_0.ObjectEntryEntityModel;
import com.liferay.object.rest.manager.v1_0.ObjectEntryManager;
import com.liferay.object.rest.resource.v1_0.ObjectEntryResource;
import com.liferay.object.service.ObjectDefinitionLocalService;
import com.liferay.object.service.ObjectFieldLocalService;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.filter.Filter;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.odata.entity.EntityModel;
import com.liferay.portal.vulcan.aggregation.Aggregation;
import com.liferay.portal.vulcan.dto.converter.DefaultDTOConverterContext;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.pagination.Pagination;

import java.io.Serializable;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MultivaluedMap;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Javier Gamarra
 */
@Component(
	factory = "com.liferay.object.rest.internal.resource.v1_0.ObjectEntryResource",
	properties = "OSGI-INF/liferay/rest/v1_0/object-entry.properties",
	service = ObjectEntryResource.class
)
public class ObjectEntryResourceImpl extends BaseObjectEntryResourceImpl {

	@Override
	public void create(
			Collection<ObjectEntry> objectEntries,
			Map<String, Serializable> parameters)
		throws Exception {

		_loadObjectDefinition(parameters);

		super.create(objectEntries, parameters);
	}

	@Override
	public void delete(
			Collection<ObjectEntry> objectEntries,
			Map<String, Serializable> parameters)
		throws Exception {

		_loadObjectDefinition(parameters);

		super.delete(objectEntries, parameters);
	}

	@Override
	public void deleteObjectEntry(Long objectEntryId) throws Exception {
		_objectEntryManager.deleteObjectEntry(objectEntryId);
	}

	@Override
	public void deleteObjectEntryByExternalReferenceCode(
			String externalReferenceCode)
		throws Exception {

		_objectEntryManager.deleteObjectEntry(
			externalReferenceCode, contextCompany.getCompanyId(), 0L);
	}

	@Override
	public void deleteSiteObjectEntryByExternalReferenceCode(
			Long siteId, String externalReferenceCode)
		throws Exception {

		_objectEntryManager.deleteObjectEntry(
			externalReferenceCode, contextCompany.getCompanyId(), siteId);
	}

	@Override
	public EntityModel getEntityModel(MultivaluedMap multivaluedMap) {
		if (_entityModel == null) {
			_entityModel = new ObjectEntryEntityModel(
				_objectFieldLocalService.getObjectFields(
					_objectDefinition.getObjectDefinitionId()));
		}

		return _entityModel;
	}

	@Override
	public Page<ObjectEntry> getObjectEntriesPage(
			Boolean flatten, String search, Aggregation aggregation,
			Filter filter, Pagination pagination, Sort[] sorts)
		throws Exception {

		return _objectEntryManager.getObjectEntries(
			contextCompany.getCompanyId(), 0,
			_objectDefinition.getObjectDefinitionId(), aggregation,
			_getDTOConverterContext(null), filter, pagination, search, sorts);
	}

	@Override
	public ObjectEntry getObjectEntry(Long objectEntryId) throws Exception {
		return _objectEntryManager.getObjectEntry(
			_getDTOConverterContext(objectEntryId), objectEntryId);
	}

	@Override
	public ObjectEntry getObjectEntryByExternalReferenceCode(
			String externalReferenceCode)
		throws Exception {

		return _objectEntryManager.getObjectEntry(
			_getDTOConverterContext(null), externalReferenceCode,
			contextCompany.getCompanyId(), 0L);
	}

	@Override
	public ObjectEntry getSiteObjectEntryByExternalReferenceCode(
			Long siteId, String externalReferenceCode)
		throws Exception {

		return _objectEntryManager.getObjectEntry(
			_getDTOConverterContext(null), externalReferenceCode,
			contextCompany.getCompanyId(), siteId);
	}

	@Override
	public ObjectEntry postObjectEntry(ObjectEntry objectEntry)
		throws Exception {

		return _objectEntryManager.addObjectEntry(
			_getDTOConverterContext(null), contextUser.getUserId(), 0,
			_objectDefinition.getObjectDefinitionId(), objectEntry);
	}

	@Override
	public ObjectEntry putObjectEntry(
			Long objectEntryId, ObjectEntry objectEntry)
		throws Exception {

		return _objectEntryManager.updateObjectEntry(
			_getDTOConverterContext(objectEntryId), contextUser.getUserId(),
			objectEntryId, objectEntry);
	}

	@Override
	public ObjectEntry putObjectEntryByExternalReferenceCode(
			String externalReferenceCode, ObjectEntry objectEntry)
		throws Exception {

		return _objectEntryManager.addOrUpdateObjectEntry(
			_getDTOConverterContext(null), externalReferenceCode,
			contextUser.getUserId(), 0L,
			_objectDefinition.getObjectDefinitionId(), objectEntry);
	}

	@Override
	public ObjectEntry putSiteObjectEntryByExternalReferenceCode(
			Long siteId, String externalReferenceCode, ObjectEntry objectEntry)
		throws Exception {

		return _objectEntryManager.addOrUpdateObjectEntry(
			_getDTOConverterContext(null), externalReferenceCode,
			contextUser.getUserId(), siteId,
			_objectDefinition.getObjectDefinitionId(), objectEntry);
	}

	@Override
	public void update(
			Collection<ObjectEntry> objectEntries,
			Map<String, Serializable> parameters)
		throws Exception {

		_loadObjectDefinition(parameters);

		super.update(objectEntries, parameters);
	}

	private DefaultDTOConverterContext _getDTOConverterContext(
		Long objectEntryId) {

		return new DefaultDTOConverterContext(
			contextAcceptLanguage.isAcceptAllLanguages(),
			Collections.singletonMap(
				"delete", Collections.singletonMap("delete", "")),
			null, contextHttpServletRequest, objectEntryId,
			contextAcceptLanguage.getPreferredLocale(), contextUriInfo,
			contextUser);
	}

	private void _loadObjectDefinition(Map<String, Serializable> parameters)
		throws Exception {

		String parameterValue = (String)parameters.get("objectDefinitionId");

		if ((parameterValue != null) && (parameterValue.length() > 2)) {
			String[] objectDefinitionIds = StringUtil.split(
				parameterValue.substring(1, parameterValue.length() - 1), ",");

			if (objectDefinitionIds.length > 0) {
				_objectDefinition =
					_objectDefinitionLocalService.getObjectDefinition(
						GetterUtil.getLong(objectDefinitionIds[0]));

				return;
			}
		}

		throw new NotFoundException("Missing parameter \"objectDefinitionId\"");
	}

	private EntityModel _entityModel;

	@Context
	private ObjectDefinition _objectDefinition;

	@Reference
	private ObjectDefinitionLocalService _objectDefinitionLocalService;

	@Reference
	private ObjectEntryManager _objectEntryManager;

	@Reference
	private ObjectFieldLocalService _objectFieldLocalService;

}