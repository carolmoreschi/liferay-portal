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

package com.liferay.asset.info.item.provider.test;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;
import com.liferay.asset.info.item.provider.AssetEntryInfoItemFieldSetProvider;
import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.model.AssetVocabulary;
import com.liferay.asset.kernel.service.AssetCategoryLocalServiceUtil;
import com.liferay.asset.kernel.service.AssetVocabularyLocalServiceUtil;
import com.liferay.asset.test.util.AssetTestUtil;
import com.liferay.info.field.InfoFieldSet;
import com.liferay.info.field.InfoFieldSetEntry;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.test.rule.AggregateTestRule;
import com.liferay.portal.kernel.test.rule.DeleteAfterTestRun;
import com.liferay.portal.kernel.test.util.GroupTestUtil;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.test.util.ServiceContextTestUtil;
import com.liferay.portal.kernel.test.util.TestPropsValues;
import com.liferay.portal.test.rule.Inject;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.test.rule.PermissionCheckerMethodTestRule;

import org.junit.Assert;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author Jürgen Kappler
 */
@RunWith(Arquillian.class)
public class AssetEntryInfoItemFieldSetProviderTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(),
			PermissionCheckerMethodTestRule.INSTANCE);

	@Before
	public void setUp() throws Exception {
		_group = GroupTestUtil.addGroup();
	}

	@Test
	public void testVocabularyWithCategoryIsAvailableInInfoFieldSet()
		throws Exception {

		ServiceContext serviceContext =
			ServiceContextTestUtil.getServiceContext(_group.getGroupId());

		AssetVocabulary vocabulary =
			AssetVocabularyLocalServiceUtil.addVocabulary(
				TestPropsValues.getUserId(), serviceContext.getScopeGroupId(),
				RandomTestUtil.randomString(), serviceContext);

		AssetCategoryLocalServiceUtil.addCategory(
			TestPropsValues.getUserId(), serviceContext.getScopeGroupId(),
			"Category 1", vocabulary.getVocabularyId(), serviceContext);

		AssetEntry assetEntry = AssetTestUtil.addAssetEntry(
			_group.getGroupId());

		InfoFieldSet infoFieldSet =
			_assetEntryInfoItemFieldSetProvider.getInfoFieldSet(assetEntry);

		Assert.assertNotNull(infoFieldSet);

		InfoFieldSetEntry infoFieldSetEntry = infoFieldSet.getInfoFieldSetEntry(
			vocabulary.getName());

		Assert.assertNotNull(infoFieldSetEntry);
	}

	@Test
	public void testVocabularyWithoutCategoriesIsAvailableInInfoFieldSet()
		throws Exception {

		ServiceContext serviceContext =
			ServiceContextTestUtil.getServiceContext(_group.getGroupId());

		AssetVocabulary vocabulary =
			AssetVocabularyLocalServiceUtil.addVocabulary(
				TestPropsValues.getUserId(), serviceContext.getScopeGroupId(),
				RandomTestUtil.randomString(), serviceContext);

		AssetEntry assetEntry = AssetTestUtil.addAssetEntry(
			_group.getGroupId());

		InfoFieldSet infoFieldSet =
			_assetEntryInfoItemFieldSetProvider.getInfoFieldSet(assetEntry);

		Assert.assertNotNull(infoFieldSet);

		InfoFieldSetEntry infoFieldSetEntry = infoFieldSet.getInfoFieldSetEntry(
			vocabulary.getName());

		Assert.assertNotNull(infoFieldSetEntry);
	}

	@Inject
	private AssetEntryInfoItemFieldSetProvider
		_assetEntryInfoItemFieldSetProvider;

	@DeleteAfterTestRun
	private Group _group;

}