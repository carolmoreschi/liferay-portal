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

package com.liferay.headless.admin.user.resource.v1_0;

import com.liferay.headless.admin.user.dto.v1_0.AccountRole;
import com.liferay.portal.kernel.search.Sort;
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
 *     curl -u your@email.com:yourpassword -D - http://localhost:8080/o/headless-admin-user/v1.0
 *
 * @author Javier Gamarra
 * @generated
 */
@Generated("")
@ProviderType
public interface AccountRoleResource {

	public static Builder builder() {
		return FactoryHolder.factory.create();
	}

	public void
			deleteAccountByExternalReferenceCodeAccountRoleUserAccountByExternalReferenceCode(
				String accountExternalReferenceCode, Long accountRoleId,
				String userAccountExternalReferenceCode)
		throws Exception;

	public void
			postAccountByExternalReferenceCodeAccountRoleUserAccountByExternalReferenceCode(
				String accountExternalReferenceCode, Long accountRoleId,
				String userAccountExternalReferenceCode)
		throws Exception;

	public Page<AccountRole>
			getAccountByExternalReferenceCodeUserAccountByExternalReferenceCodeAccountRolesPage(
				String accountExternalReferenceCode,
				String userAccountExternalReferenceCode)
		throws Exception;

	public Page<AccountRole> getAccountAccountRolesByExternalReferenceCodePage(
			String externalReferenceCode, String keywords,
			Pagination pagination, Sort[] sorts)
		throws Exception;

	public AccountRole postAccountAccountRoleByExternalReferenceCode(
			String externalReferenceCode, AccountRole accountRole)
		throws Exception;

	public void
			deleteAccountByExternalReferenceCodeAccountRoleUserAccountByEmailAddress(
				String externalReferenceCode, Long accountRoleId,
				String emailAddress)
		throws Exception;

	public void
			postAccountByExternalReferenceCodeAccountRoleUserAccountByEmailAddress(
				String externalReferenceCode, Long accountRoleId,
				String emailAddress)
		throws Exception;

	public Page<AccountRole>
			getAccountByExternalReferenceCodeUserAccountByEmailAddressAccountRolesPage(
				String externalReferenceCode, String emailAddress)
		throws Exception;

	public Page<AccountRole> getAccountAccountRolesPage(
			Long accountId, String keywords, Pagination pagination,
			Sort[] sorts)
		throws Exception;

	public AccountRole postAccountAccountRole(
			Long accountId, AccountRole accountRole)
		throws Exception;

	public Response postAccountAccountRoleBatch(
			Long accountId, String callbackURL, Object object)
		throws Exception;

	public void deleteAccountAccountRoleUserAccountAssociation(
			Long accountId, Long accountRoleId, Long userAccountId)
		throws Exception;

	public void postAccountAccountRoleUserAccountAssociation(
			Long accountId, Long accountRoleId, Long userAccountId)
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

		public AccountRoleResource build();

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