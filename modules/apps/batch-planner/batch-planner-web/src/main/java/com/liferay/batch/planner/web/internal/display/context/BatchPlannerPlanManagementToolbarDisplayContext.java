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

package com.liferay.batch.planner.web.internal.display.context;

import com.liferay.frontend.taglib.clay.servlet.taglib.display.context.SearchContainerManagementToolbarDisplayContext;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.CreationMenu;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.CreationMenuBuilder;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.DropdownItem;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.DropdownItemList;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.LabelItem;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.LabelItemListBuilder;
import com.liferay.petra.portlet.url.builder.PortletURLBuilder;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Matija Petanjek
 */
public class BatchPlannerPlanManagementToolbarDisplayContext
	extends SearchContainerManagementToolbarDisplayContext {

	public BatchPlannerPlanManagementToolbarDisplayContext(
		HttpServletRequest httpServletRequest,
		LiferayPortletRequest liferayPortletRequest,
		LiferayPortletResponse liferayPortletResponse,
		SearchContainer<?> searchContainer) {

		super(
			httpServletRequest, liferayPortletRequest, liferayPortletResponse,
			searchContainer);
	}

	@Override
	public List<DropdownItem> getActionDropdownItems() {
		return DropdownItemList.of(
			() -> {
				DropdownItem dropdownItem = new DropdownItem();

				dropdownItem.putData("action", "deleteBatchPlannerPlans");
				dropdownItem.putData(
					"deleteBatchPlannerPlansURL",
					PortletURLBuilder.createActionURL(
						liferayPortletResponse
					).setActionName(
						"/batch_planner/edit_batch_planner_plan"
					).setCMD(
						Constants.DELETE
					).setNavigation(
						getNavigation()
					).buildString());
				dropdownItem.setIcon("times-circle");
				dropdownItem.setLabel(
					LanguageUtil.get(httpServletRequest, "delete"));
				dropdownItem.setQuickAction(true);

				return dropdownItem;
			});
	}

	public List<String> getAvailableActions() {
		return Arrays.asList("deleteBatchPlannerPlans");
	}

	@Override
	public CreationMenu getCreationMenu() {
		return CreationMenuBuilder.addDropdownItem(
			dropdownItem -> dropdownItem.setLabel(
				LanguageUtil.get(httpServletRequest, "export-file"))
		).addDropdownItem(
			dropdownItem -> {
				dropdownItem.setHref(
					PortletURLBuilder.createRenderURL(
						liferayPortletResponse
					).setMVCRenderCommandName(
						"/batch_planner/edit_batch_planner_plan"
					).setBackURL(
						String.valueOf(liferayPortletResponse.createRenderURL())
					).buildPortletURL());
				dropdownItem.setLabel(
					LanguageUtil.get(httpServletRequest, "import-file"));
			}
		).build();
	}

	@Override
	public List<LabelItem> getFilterLabelItems() {
		return LabelItemListBuilder.add(
			() -> !Objects.equals(getNavigation(), "all"),
			labelItem -> {
				labelItem.putData(
					"removeLabelURL",
					PortletURLBuilder.create(
						getPortletURL()
					).setNavigation(
						(String)null
					).buildString());

				labelItem.setDismissible(true);

				labelItem.setLabel(
					String.format(
						"%s: %s",
						LanguageUtil.get(httpServletRequest, "action"),
						LanguageUtil.get(httpServletRequest, getNavigation())));
			}
		).build();
	}

	@Override
	public String getFilterNavigationDropdownItemsLabel() {
		return LanguageUtil.get(httpServletRequest, "filter-by-action");
	}

	@Override
	public Boolean isDisabled() {
		return false;
	}

	@Override
	protected String getNavigation() {
		return ParamUtil.getString(
			liferayPortletRequest, getNavigationParam(), "all");
	}

	@Override
	protected String[] getNavigationKeys() {
		return new String[] {"all", "export", "import"};
	}

	@Override
	protected String[] getOrderByKeys() {
		return new String[] {"name"};
	}

}