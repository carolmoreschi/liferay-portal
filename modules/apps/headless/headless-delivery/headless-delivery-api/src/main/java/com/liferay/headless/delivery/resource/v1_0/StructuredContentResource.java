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

package com.liferay.headless.delivery.resource.v1_0;

import com.liferay.headless.delivery.dto.v1_0.Rating;
import com.liferay.headless.delivery.dto.v1_0.StructuredContent;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.filter.Filter;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.ResourceActionLocalService;
import com.liferay.portal.kernel.service.ResourcePermissionLocalService;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.vulcan.accept.language.AcceptLanguage;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.pagination.Pagination;

import java.util.Locale;

import javax.annotation.Generated;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.osgi.annotation.versioning.ProviderType;

/**
 * To access this resource, run:
 *
 *     curl -u your@email.com:yourpassword -D - http://localhost:8080/o/headless-delivery/v1.0
 *
 * @author Javier Gamarra
 * @generated
 */
@Generated("")
@ProviderType
public interface StructuredContentResource {

	public static Builder builder() {
		return FactoryHolder.factory.create();
	}

	public Page<StructuredContent> getAssetLibraryStructuredContentsPage(
			Long assetLibraryId, Boolean flatten, String search,
			com.liferay.portal.vulcan.aggregation.Aggregation aggregation,
			Filter filter, Pagination pagination, Sort[] sorts)
		throws Exception;

	public StructuredContent postAssetLibraryStructuredContent(
			Long assetLibraryId, StructuredContent structuredContent)
		throws Exception;

	public Response postAssetLibraryStructuredContentBatch(
			Long assetLibraryId, String callbackURL, Object object)
		throws Exception;

	public Page<com.liferay.portal.vulcan.permission.Permission>
			getAssetLibraryStructuredContentPermissionsPage(
				Long assetLibraryId, String roleNames)
		throws Exception;

	public Page<com.liferay.portal.vulcan.permission.Permission>
			putAssetLibraryStructuredContentPermission(
				Long assetLibraryId,
				com.liferay.portal.vulcan.permission.Permission[] permissions)
		throws Exception;

	public Page<StructuredContent> getContentStructureStructuredContentsPage(
			Long contentStructureId, String search,
			com.liferay.portal.vulcan.aggregation.Aggregation aggregation,
			Filter filter, Pagination pagination, Sort[] sorts)
		throws Exception;

	public Page<StructuredContent> getSiteStructuredContentsPage(
			Long siteId, Boolean flatten, String search,
			com.liferay.portal.vulcan.aggregation.Aggregation aggregation,
			Filter filter, Pagination pagination, Sort[] sorts)
		throws Exception;

	public StructuredContent postSiteStructuredContent(
			Long siteId, StructuredContent structuredContent)
		throws Exception;

	public Response postSiteStructuredContentBatch(
			Long siteId, String callbackURL, Object object)
		throws Exception;

	public void deleteSiteStructuredContentByExternalReferenceCode(
			Long siteId, String externalReferenceCode)
		throws Exception;

	public StructuredContent getSiteStructuredContentByExternalReferenceCode(
			Long siteId, String externalReferenceCode)
		throws Exception;

	public StructuredContent putSiteStructuredContentByExternalReferenceCode(
			Long siteId, String externalReferenceCode,
			StructuredContent structuredContent)
		throws Exception;

	public StructuredContent getSiteStructuredContentByKey(
			Long siteId, String key)
		throws Exception;

	public StructuredContent getSiteStructuredContentByUuid(
			Long siteId, String uuid)
		throws Exception;

	public Page<com.liferay.portal.vulcan.permission.Permission>
			getSiteStructuredContentPermissionsPage(
				Long siteId, String roleNames)
		throws Exception;

	public Page<com.liferay.portal.vulcan.permission.Permission>
			putSiteStructuredContentPermission(
				Long siteId,
				com.liferay.portal.vulcan.permission.Permission[] permissions)
		throws Exception;

	public Page<StructuredContent>
			getStructuredContentFolderStructuredContentsPage(
				Long structuredContentFolderId, Boolean flatten, String search,
				com.liferay.portal.vulcan.aggregation.Aggregation aggregation,
				Filter filter, Pagination pagination, Sort[] sorts)
		throws Exception;

	public StructuredContent postStructuredContentFolderStructuredContent(
			Long structuredContentFolderId, StructuredContent structuredContent)
		throws Exception;

	public Response postStructuredContentFolderStructuredContentBatch(
			Long structuredContentFolderId, String callbackURL, Object object)
		throws Exception;

	public void deleteStructuredContent(Long structuredContentId)
		throws Exception;

	public Response deleteStructuredContentBatch(
			String callbackURL, Object object)
		throws Exception;

	public StructuredContent getStructuredContent(Long structuredContentId)
		throws Exception;

	public StructuredContent patchStructuredContent(
			Long structuredContentId, StructuredContent structuredContent)
		throws Exception;

	public StructuredContent putStructuredContent(
			Long structuredContentId, StructuredContent structuredContent)
		throws Exception;

	public Response putStructuredContentBatch(String callbackURL, Object object)
		throws Exception;

	public void deleteStructuredContentMyRating(Long structuredContentId)
		throws Exception;

	public Rating getStructuredContentMyRating(Long structuredContentId)
		throws Exception;

	public Rating postStructuredContentMyRating(
			Long structuredContentId, Rating rating)
		throws Exception;

	public Rating putStructuredContentMyRating(
			Long structuredContentId, Rating rating)
		throws Exception;

	public Page<com.liferay.portal.vulcan.permission.Permission>
			getStructuredContentPermissionsPage(
				Long structuredContentId, String roleNames)
		throws Exception;

	public Page<com.liferay.portal.vulcan.permission.Permission>
			putStructuredContentPermission(
				Long structuredContentId,
				com.liferay.portal.vulcan.permission.Permission[] permissions)
		throws Exception;

	public String
			getStructuredContentRenderedContentByDisplayPageDisplayPageKey(
				Long structuredContentId, String displayPageKey)
		throws Exception;

	public String getStructuredContentRenderedContentTemplate(
			Long structuredContentId, String contentTemplateId)
		throws Exception;

	public void putStructuredContentSubscribe(Long structuredContentId)
		throws Exception;

	public void putStructuredContentUnsubscribe(Long structuredContentId)
		throws Exception;

	public default void setContextAcceptLanguage(
		AcceptLanguage contextAcceptLanguage) {
	}

	public void setContextCompany(
		com.liferay.portal.kernel.model.Company contextCompany);

	public default void setContextHttpServletRequest(
		HttpServletRequest contextHttpServletRequest) {
	}

	public default void setContextHttpServletResponse(
		HttpServletResponse contextHttpServletResponse) {
	}

	public default void setContextUriInfo(UriInfo contextUriInfo) {
	}

	public void setContextUser(
		com.liferay.portal.kernel.model.User contextUser);

	public void setGroupLocalService(GroupLocalService groupLocalService);

	public void setResourceActionLocalService(
		ResourceActionLocalService resourceActionLocalService);

	public void setResourcePermissionLocalService(
		ResourcePermissionLocalService resourcePermissionLocalService);

	public void setRoleLocalService(RoleLocalService roleLocalService);

	public static class FactoryHolder {

		public static volatile Factory factory;

	}

	@ProviderType
	public interface Builder {

		public StructuredContentResource build();

		public Builder checkPermissions(boolean checkPermissions);

		public Builder httpServletRequest(
			HttpServletRequest httpServletRequest);

		public Builder httpServletResponse(
			HttpServletResponse httpServletResponse);

		public Builder preferredLocale(Locale preferredLocale);

		public Builder user(com.liferay.portal.kernel.model.User user);

	}

	@ProviderType
	public interface Factory {

		public Builder create();

	}

}