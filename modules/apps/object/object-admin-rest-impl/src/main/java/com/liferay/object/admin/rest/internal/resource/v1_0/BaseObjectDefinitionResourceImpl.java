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

package com.liferay.object.admin.rest.internal.resource.v1_0;

import com.liferay.object.admin.rest.dto.v1_0.ObjectDefinition;
import com.liferay.object.admin.rest.resource.v1_0.ObjectDefinitionResource;
import com.liferay.petra.function.UnsafeConsumer;
import com.liferay.petra.function.UnsafeFunction;
import com.liferay.portal.kernel.model.GroupedModel;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.filter.Filter;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.ResourceActionLocalService;
import com.liferay.portal.kernel.service.ResourcePermissionLocalService;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.odata.entity.EntityModel;
import com.liferay.portal.vulcan.accept.language.AcceptLanguage;
import com.liferay.portal.vulcan.batch.engine.VulcanBatchEngineTaskItemDelegate;
import com.liferay.portal.vulcan.batch.engine.resource.VulcanBatchEngineImportTaskResource;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.pagination.Pagination;
import com.liferay.portal.vulcan.resource.EntityModelResource;
import com.liferay.portal.vulcan.util.ActionUtil;
import com.liferay.portal.vulcan.util.TransformUtil;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;

import java.io.Serializable;

import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Generated;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.validation.constraints.NotNull;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PATCH;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 * @author Javier Gamarra
 * @generated
 */
@Generated("")
@Path("/v1.0")
public abstract class BaseObjectDefinitionResourceImpl
	implements EntityModelResource, ObjectDefinitionResource,
			   VulcanBatchEngineTaskItemDelegate<ObjectDefinition> {

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -X 'GET' 'http://localhost:8080/o/object-admin/v1.0/object-definitions'  -u 'test@liferay.com:test'
	 */
	@GET
	@Override
	@Parameters(
		value = {
			@Parameter(in = ParameterIn.QUERY, name = "page"),
			@Parameter(in = ParameterIn.QUERY, name = "pageSize")
		}
	)
	@Path("/object-definitions")
	@Produces({"application/json", "application/xml"})
	@Tags(value = {@Tag(name = "ObjectDefinition")})
	public Page<ObjectDefinition> getObjectDefinitionsPage(
			@Context Pagination pagination)
		throws Exception {

		return Page.of(Collections.emptyList());
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -X 'POST' 'http://localhost:8080/o/object-admin/v1.0/object-definitions' -d $'{"label": ___, "name": ___, "objectFields": ___, "panelAppOrder": ___, "panelCategoryKey": ___, "pluralLabel": ___, "scope": ___}' --header 'Content-Type: application/json' -u 'test@liferay.com:test'
	 */
	@Consumes({"application/json", "application/xml"})
	@Override
	@Path("/object-definitions")
	@POST
	@Produces({"application/json", "application/xml"})
	@Tags(value = {@Tag(name = "ObjectDefinition")})
	public ObjectDefinition postObjectDefinition(
			ObjectDefinition objectDefinition)
		throws Exception {

		return new ObjectDefinition();
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -X 'POST' 'http://localhost:8080/o/object-admin/v1.0/object-definitions/batch'  -u 'test@liferay.com:test'
	 */
	@Consumes("application/json")
	@Override
	@Parameters(
		value = {@Parameter(in = ParameterIn.QUERY, name = "callbackURL")}
	)
	@Path("/object-definitions/batch")
	@POST
	@Produces("application/json")
	@Tags(value = {@Tag(name = "ObjectDefinition")})
	public Response postObjectDefinitionBatch(
			@Parameter(hidden = true) @QueryParam("callbackURL") String
				callbackURL,
			Object object)
		throws Exception {

		vulcanBatchEngineImportTaskResource.setContextAcceptLanguage(
			contextAcceptLanguage);
		vulcanBatchEngineImportTaskResource.setContextCompany(contextCompany);
		vulcanBatchEngineImportTaskResource.setContextHttpServletRequest(
			contextHttpServletRequest);
		vulcanBatchEngineImportTaskResource.setContextUriInfo(contextUriInfo);
		vulcanBatchEngineImportTaskResource.setContextUser(contextUser);

		Response.ResponseBuilder responseBuilder = Response.accepted();

		return responseBuilder.entity(
			vulcanBatchEngineImportTaskResource.postImportTask(
				ObjectDefinition.class.getName(), callbackURL, null, object)
		).build();
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -X 'DELETE' 'http://localhost:8080/o/object-admin/v1.0/object-definitions/{objectDefinitionId}'  -u 'test@liferay.com:test'
	 */
	@DELETE
	@Override
	@Parameters(
		value = {@Parameter(in = ParameterIn.PATH, name = "objectDefinitionId")}
	)
	@Path("/object-definitions/{objectDefinitionId}")
	@Produces({"application/json", "application/xml"})
	@Tags(value = {@Tag(name = "ObjectDefinition")})
	public void deleteObjectDefinition(
			@NotNull @Parameter(hidden = true) @PathParam("objectDefinitionId")
				Long objectDefinitionId)
		throws Exception {
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -X 'DELETE' 'http://localhost:8080/o/object-admin/v1.0/object-definitions/batch'  -u 'test@liferay.com:test'
	 */
	@Consumes("application/json")
	@DELETE
	@Override
	@Parameters(
		value = {@Parameter(in = ParameterIn.QUERY, name = "callbackURL")}
	)
	@Path("/object-definitions/batch")
	@Produces("application/json")
	@Tags(value = {@Tag(name = "ObjectDefinition")})
	public Response deleteObjectDefinitionBatch(
			@Parameter(hidden = true) @QueryParam("callbackURL") String
				callbackURL,
			Object object)
		throws Exception {

		vulcanBatchEngineImportTaskResource.setContextAcceptLanguage(
			contextAcceptLanguage);
		vulcanBatchEngineImportTaskResource.setContextCompany(contextCompany);
		vulcanBatchEngineImportTaskResource.setContextHttpServletRequest(
			contextHttpServletRequest);
		vulcanBatchEngineImportTaskResource.setContextUriInfo(contextUriInfo);
		vulcanBatchEngineImportTaskResource.setContextUser(contextUser);

		Response.ResponseBuilder responseBuilder = Response.accepted();

		return responseBuilder.entity(
			vulcanBatchEngineImportTaskResource.deleteImportTask(
				ObjectDefinition.class.getName(), callbackURL, object)
		).build();
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -X 'GET' 'http://localhost:8080/o/object-admin/v1.0/object-definitions/{objectDefinitionId}'  -u 'test@liferay.com:test'
	 */
	@GET
	@Override
	@Parameters(
		value = {@Parameter(in = ParameterIn.PATH, name = "objectDefinitionId")}
	)
	@Path("/object-definitions/{objectDefinitionId}")
	@Produces({"application/json", "application/xml"})
	@Tags(value = {@Tag(name = "ObjectDefinition")})
	public ObjectDefinition getObjectDefinition(
			@NotNull @Parameter(hidden = true) @PathParam("objectDefinitionId")
				Long objectDefinitionId)
		throws Exception {

		return new ObjectDefinition();
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -X 'PATCH' 'http://localhost:8080/o/object-admin/v1.0/object-definitions/{objectDefinitionId}' -d $'{"label": ___, "name": ___, "objectFields": ___, "panelAppOrder": ___, "panelCategoryKey": ___, "pluralLabel": ___, "scope": ___}' --header 'Content-Type: application/json' -u 'test@liferay.com:test'
	 */
	@Consumes({"application/json", "application/xml"})
	@Override
	@Parameters(
		value = {@Parameter(in = ParameterIn.PATH, name = "objectDefinitionId")}
	)
	@PATCH
	@Path("/object-definitions/{objectDefinitionId}")
	@Produces({"application/json", "application/xml"})
	@Tags(value = {@Tag(name = "ObjectDefinition")})
	public ObjectDefinition patchObjectDefinition(
			@NotNull @Parameter(hidden = true) @PathParam("objectDefinitionId")
				Long objectDefinitionId,
			ObjectDefinition objectDefinition)
		throws Exception {

		ObjectDefinition existingObjectDefinition = getObjectDefinition(
			objectDefinitionId);

		if (objectDefinition.getActions() != null) {
			existingObjectDefinition.setActions(objectDefinition.getActions());
		}

		if (objectDefinition.getDateCreated() != null) {
			existingObjectDefinition.setDateCreated(
				objectDefinition.getDateCreated());
		}

		if (objectDefinition.getDateModified() != null) {
			existingObjectDefinition.setDateModified(
				objectDefinition.getDateModified());
		}

		if (objectDefinition.getLabel() != null) {
			existingObjectDefinition.setLabel(objectDefinition.getLabel());
		}

		if (objectDefinition.getName() != null) {
			existingObjectDefinition.setName(objectDefinition.getName());
		}

		if (objectDefinition.getPanelAppOrder() != null) {
			existingObjectDefinition.setPanelAppOrder(
				objectDefinition.getPanelAppOrder());
		}

		if (objectDefinition.getPanelCategoryKey() != null) {
			existingObjectDefinition.setPanelCategoryKey(
				objectDefinition.getPanelCategoryKey());
		}

		if (objectDefinition.getPluralLabel() != null) {
			existingObjectDefinition.setPluralLabel(
				objectDefinition.getPluralLabel());
		}

		if (objectDefinition.getScope() != null) {
			existingObjectDefinition.setScope(objectDefinition.getScope());
		}

		if (objectDefinition.getSystem() != null) {
			existingObjectDefinition.setSystem(objectDefinition.getSystem());
		}

		preparePatch(objectDefinition, existingObjectDefinition);

		return putObjectDefinition(
			objectDefinitionId, existingObjectDefinition);
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -X 'PUT' 'http://localhost:8080/o/object-admin/v1.0/object-definitions/{objectDefinitionId}' -d $'{"label": ___, "name": ___, "objectFields": ___, "panelAppOrder": ___, "panelCategoryKey": ___, "pluralLabel": ___, "scope": ___}' --header 'Content-Type: application/json' -u 'test@liferay.com:test'
	 */
	@Consumes({"application/json", "application/xml"})
	@Override
	@Parameters(
		value = {@Parameter(in = ParameterIn.PATH, name = "objectDefinitionId")}
	)
	@Path("/object-definitions/{objectDefinitionId}")
	@Produces({"application/json", "application/xml"})
	@PUT
	@Tags(value = {@Tag(name = "ObjectDefinition")})
	public ObjectDefinition putObjectDefinition(
			@NotNull @Parameter(hidden = true) @PathParam("objectDefinitionId")
				Long objectDefinitionId,
			ObjectDefinition objectDefinition)
		throws Exception {

		return new ObjectDefinition();
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -X 'PUT' 'http://localhost:8080/o/object-admin/v1.0/object-definitions/batch'  -u 'test@liferay.com:test'
	 */
	@Consumes("application/json")
	@Override
	@Parameters(
		value = {@Parameter(in = ParameterIn.QUERY, name = "callbackURL")}
	)
	@Path("/object-definitions/batch")
	@Produces("application/json")
	@PUT
	@Tags(value = {@Tag(name = "ObjectDefinition")})
	public Response putObjectDefinitionBatch(
			@Parameter(hidden = true) @QueryParam("callbackURL") String
				callbackURL,
			Object object)
		throws Exception {

		vulcanBatchEngineImportTaskResource.setContextAcceptLanguage(
			contextAcceptLanguage);
		vulcanBatchEngineImportTaskResource.setContextCompany(contextCompany);
		vulcanBatchEngineImportTaskResource.setContextHttpServletRequest(
			contextHttpServletRequest);
		vulcanBatchEngineImportTaskResource.setContextUriInfo(contextUriInfo);
		vulcanBatchEngineImportTaskResource.setContextUser(contextUser);

		Response.ResponseBuilder responseBuilder = Response.accepted();

		return responseBuilder.entity(
			vulcanBatchEngineImportTaskResource.putImportTask(
				ObjectDefinition.class.getName(), callbackURL, object)
		).build();
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -X 'POST' 'http://localhost:8080/o/object-admin/v1.0/object-definitions/{objectDefinitionId}/publish'  -u 'test@liferay.com:test'
	 */
	@Override
	@Parameters(
		value = {@Parameter(in = ParameterIn.PATH, name = "objectDefinitionId")}
	)
	@Path("/object-definitions/{objectDefinitionId}/publish")
	@POST
	@Produces({"application/json", "application/xml"})
	@Tags(value = {@Tag(name = "ObjectDefinition")})
	public void postObjectDefinitionPublish(
			@NotNull @Parameter(hidden = true) @PathParam("objectDefinitionId")
				Long objectDefinitionId)
		throws Exception {
	}

	@Override
	@SuppressWarnings("PMD.UnusedLocalVariable")
	public void create(
			java.util.Collection<ObjectDefinition> objectDefinitions,
			Map<String, Serializable> parameters)
		throws Exception {

		UnsafeConsumer<ObjectDefinition, Exception>
			objectDefinitionUnsafeConsumer =
				objectDefinition -> postObjectDefinition(objectDefinition);

		for (ObjectDefinition objectDefinition : objectDefinitions) {
			objectDefinitionUnsafeConsumer.accept(objectDefinition);
		}
	}

	@Override
	public void delete(
			java.util.Collection<ObjectDefinition> objectDefinitions,
			Map<String, Serializable> parameters)
		throws Exception {

		for (ObjectDefinition objectDefinition : objectDefinitions) {
			deleteObjectDefinition(objectDefinition.getId());
		}
	}

	@Override
	public EntityModel getEntityModel(Map<String, List<String>> multivaluedMap)
		throws Exception {

		return getEntityModel(
			new MultivaluedHashMap<String, Object>(multivaluedMap));
	}

	@Override
	public EntityModel getEntityModel(MultivaluedMap multivaluedMap)
		throws Exception {

		return null;
	}

	@Override
	public Page<ObjectDefinition> read(
			Filter filter, Pagination pagination, Sort[] sorts,
			Map<String, Serializable> parameters, String search)
		throws Exception {

		return getObjectDefinitionsPage(pagination);
	}

	@Override
	public void setLanguageId(String languageId) {
		this.contextAcceptLanguage = new AcceptLanguage() {

			@Override
			public List<Locale> getLocales() {
				return null;
			}

			@Override
			public String getPreferredLanguageId() {
				return languageId;
			}

			@Override
			public Locale getPreferredLocale() {
				return LocaleUtil.fromLanguageId(languageId);
			}

		};
	}

	@Override
	public void update(
			java.util.Collection<ObjectDefinition> objectDefinitions,
			Map<String, Serializable> parameters)
		throws Exception {

		for (ObjectDefinition objectDefinition : objectDefinitions) {
			putObjectDefinition(
				objectDefinition.getId() != null ? objectDefinition.getId() :
					Long.parseLong(
						(String)parameters.get("objectDefinitionId")),
				objectDefinition);
		}
	}

	public void setContextAcceptLanguage(AcceptLanguage contextAcceptLanguage) {
		this.contextAcceptLanguage = contextAcceptLanguage;
	}

	public void setContextCompany(
		com.liferay.portal.kernel.model.Company contextCompany) {

		this.contextCompany = contextCompany;
	}

	public void setContextHttpServletRequest(
		HttpServletRequest contextHttpServletRequest) {

		this.contextHttpServletRequest = contextHttpServletRequest;
	}

	public void setContextHttpServletResponse(
		HttpServletResponse contextHttpServletResponse) {

		this.contextHttpServletResponse = contextHttpServletResponse;
	}

	public void setContextUriInfo(UriInfo contextUriInfo) {
		this.contextUriInfo = contextUriInfo;
	}

	public void setContextUser(
		com.liferay.portal.kernel.model.User contextUser) {

		this.contextUser = contextUser;
	}

	public void setGroupLocalService(GroupLocalService groupLocalService) {
		this.groupLocalService = groupLocalService;
	}

	public void setResourceActionLocalService(
		ResourceActionLocalService resourceActionLocalService) {

		this.resourceActionLocalService = resourceActionLocalService;
	}

	public void setResourcePermissionLocalService(
		ResourcePermissionLocalService resourcePermissionLocalService) {

		this.resourcePermissionLocalService = resourcePermissionLocalService;
	}

	public void setRoleLocalService(RoleLocalService roleLocalService) {
		this.roleLocalService = roleLocalService;
	}

	protected Map<String, String> addAction(
		String actionName, GroupedModel groupedModel, String methodName) {

		return ActionUtil.addAction(
			actionName, getClass(), groupedModel, methodName,
			contextScopeChecker, contextUriInfo);
	}

	protected Map<String, String> addAction(
		String actionName, Long id, String methodName, Long ownerId,
		String permissionName, Long siteId) {

		return ActionUtil.addAction(
			actionName, getClass(), id, methodName, contextScopeChecker,
			ownerId, permissionName, siteId, contextUriInfo);
	}

	protected Map<String, String> addAction(
		String actionName, Long id, String methodName,
		ModelResourcePermission modelResourcePermission) {

		return ActionUtil.addAction(
			actionName, getClass(), id, methodName, contextScopeChecker,
			modelResourcePermission, contextUriInfo);
	}

	protected Map<String, String> addAction(
		String actionName, String methodName, String permissionName,
		Long siteId) {

		return addAction(
			actionName, siteId, methodName, null, permissionName, siteId);
	}

	protected void preparePatch(
		ObjectDefinition objectDefinition,
		ObjectDefinition existingObjectDefinition) {
	}

	protected <T, R> List<R> transform(
		java.util.Collection<T> collection,
		UnsafeFunction<T, R, Exception> unsafeFunction) {

		return TransformUtil.transform(collection, unsafeFunction);
	}

	protected <T, R> R[] transform(
		T[] array, UnsafeFunction<T, R, Exception> unsafeFunction,
		Class<?> clazz) {

		return TransformUtil.transform(array, unsafeFunction, clazz);
	}

	protected <T, R> R[] transformToArray(
		java.util.Collection<T> collection,
		UnsafeFunction<T, R, Exception> unsafeFunction, Class<?> clazz) {

		return TransformUtil.transformToArray(
			collection, unsafeFunction, clazz);
	}

	protected <T, R> List<R> transformToList(
		T[] array, UnsafeFunction<T, R, Exception> unsafeFunction) {

		return TransformUtil.transformToList(array, unsafeFunction);
	}

	protected AcceptLanguage contextAcceptLanguage;
	protected com.liferay.portal.kernel.model.Company contextCompany;
	protected HttpServletRequest contextHttpServletRequest;
	protected HttpServletResponse contextHttpServletResponse;
	protected Object contextScopeChecker;
	protected UriInfo contextUriInfo;
	protected com.liferay.portal.kernel.model.User contextUser;
	protected GroupLocalService groupLocalService;
	protected ResourceActionLocalService resourceActionLocalService;
	protected ResourcePermissionLocalService resourcePermissionLocalService;
	protected RoleLocalService roleLocalService;
	protected VulcanBatchEngineImportTaskResource
		vulcanBatchEngineImportTaskResource;

}