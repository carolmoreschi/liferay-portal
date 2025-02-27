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

package com.liferay.portal.kernel.repository;

import com.liferay.petra.string.CharPool;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.resource.bundle.ResourceBundleLoader;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.StringUtil;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @author Adolfo Pérez
 */
public class RepositoryConfigurationBuilder {

	public RepositoryConfigurationBuilder() {
		this(LanguageUtil.getResourceBundleLoader());
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #RepositoryConfigurationBuilder(ResourceBundleLoader,
	 *             String[])}
	 */
	@Deprecated
	public RepositoryConfigurationBuilder(
		com.liferay.portal.kernel.util.ResourceBundleLoader
			resourceBundleLoader,
		String... names) {

		this(
			new ResourceBundleLoader() {

				@Override
				public ResourceBundle loadResourceBundle(Locale locale) {
					return resourceBundleLoader.loadResourceBundle(locale);
				}

			},
			names);
	}

	public RepositoryConfigurationBuilder(
		ResourceBundleLoader resourceBundleLoader, String... names) {

		_resourceBundleLoader = resourceBundleLoader;

		for (String name : names) {
			addParameter(name);
		}
	}

	public RepositoryConfigurationBuilder addParameter(String name) {
		String labelKey = HtmlUtil.escape(
			StringUtil.replace(
				StringUtil.toLowerCase(name), CharPool.UNDERLINE,
				CharPool.DASH));

		return addParameter(name, labelKey);
	}

	public RepositoryConfigurationBuilder addParameter(
		String labelKey, String name) {

		_parameters.add(new ParameterImpl(labelKey, name));

		return this;
	}

	public RepositoryConfiguration build() {
		return new RepositoryConfigurationImpl(new ArrayList<>(_parameters));
	}

	private final Collection<RepositoryConfiguration.Parameter> _parameters =
		new ArrayList<>();
	private final ResourceBundleLoader _resourceBundleLoader;

	private static class RepositoryConfigurationImpl
		implements RepositoryConfiguration {

		public RepositoryConfigurationImpl(Collection<Parameter> parameters) {
			_parameters = parameters;
		}

		@Override
		public Collection<Parameter> getParameters() {
			return _parameters;
		}

		private final Collection<Parameter> _parameters;

	}

	private class ParameterImpl implements RepositoryConfiguration.Parameter {

		public ParameterImpl(String name, String labelKey) {
			_name = name;
			_labelKey = labelKey;
		}

		@Override
		public String getLabel(Locale locale) {
			ResourceBundle resourceBundle =
				_resourceBundleLoader.loadResourceBundle(locale);

			return LanguageUtil.get(resourceBundle, _labelKey);
		}

		@Override
		public String getName() {
			return _name;
		}

		private final String _labelKey;
		private final String _name;

	}

}