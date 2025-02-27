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

package com.liferay.commerce.checkout.web.internal.display.context;

import com.liferay.commerce.constants.CommerceCheckoutWebKeys;
import com.liferay.commerce.constants.CommerceWebKeys;
import com.liferay.commerce.context.CommerceContext;
import com.liferay.commerce.currency.model.CommerceCurrency;
import com.liferay.commerce.currency.model.CommerceMoney;
import com.liferay.commerce.discount.CommerceDiscountValue;
import com.liferay.commerce.model.CommerceOrder;
import com.liferay.commerce.model.CommerceOrderItem;
import com.liferay.commerce.order.CommerceOrderHttpHelper;
import com.liferay.commerce.order.CommerceOrderValidatorRegistry;
import com.liferay.commerce.order.CommerceOrderValidatorResult;
import com.liferay.commerce.payment.engine.CommercePaymentEngine;
import com.liferay.commerce.percentage.PercentageFormatter;
import com.liferay.commerce.price.CommerceOrderPrice;
import com.liferay.commerce.price.CommerceOrderPriceCalculation;
import com.liferay.commerce.price.CommerceProductPrice;
import com.liferay.commerce.price.CommerceProductPriceCalculation;
import com.liferay.commerce.price.CommerceProductPriceImpl;
import com.liferay.commerce.price.CommerceProductPriceRequest;
import com.liferay.commerce.product.constants.CPConstants;
import com.liferay.commerce.product.model.CommerceChannel;
import com.liferay.commerce.product.option.CommerceOptionValue;
import com.liferay.commerce.product.option.CommerceOptionValueHelper;
import com.liferay.commerce.product.service.CommerceChannelLocalService;
import com.liferay.commerce.product.util.CPInstanceHelper;
import com.liferay.commerce.util.CommerceBigDecimalUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.KeyValuePair;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Marco Leo
 */
public class OrderSummaryCheckoutStepDisplayContext {

	public OrderSummaryCheckoutStepDisplayContext(
		CommerceChannelLocalService commerceChannelLocalService,
		CommerceOrderHttpHelper commerceOrderHttpHelper,
		CommerceOrderPriceCalculation commerceOrderPriceCalculation,
		CommerceOrderValidatorRegistry commerceOrderValidatorRegistry,
		CommercePaymentEngine commercePaymentEngine,
		CommerceProductPriceCalculation commerceProductPriceCalculation,
		CPInstanceHelper cpInstanceHelper,
		CommerceOptionValueHelper commerceOptionValueHelper,
		PercentageFormatter percentageFormatter,
		HttpServletRequest httpServletRequest) {

		_commerceChannelLocalService = commerceChannelLocalService;
		_commerceOrderHttpHelper = commerceOrderHttpHelper;
		_commerceOrderPriceCalculation = commerceOrderPriceCalculation;
		_commerceOrderValidatorRegistry = commerceOrderValidatorRegistry;
		_commercePaymentEngine = commercePaymentEngine;
		_commerceProductPriceCalculation = commerceProductPriceCalculation;
		_cpInstanceHelper = cpInstanceHelper;
		_commerceOptionValueHelper = commerceOptionValueHelper;
		_percentageFormatter = percentageFormatter;
		_httpServletRequest = httpServletRequest;

		_commerceContext = (CommerceContext)httpServletRequest.getAttribute(
			CommerceWebKeys.COMMERCE_CONTEXT);
		_commerceOrder = (CommerceOrder)httpServletRequest.getAttribute(
			CommerceCheckoutWebKeys.COMMERCE_ORDER);
	}

	public CommerceOrder getCommerceOrder() {
		return _commerceOrder;
	}

	public int getCommerceOrderItemsQuantity() throws PortalException {
		return _commerceOrderHttpHelper.getCommerceOrderItemsQuantity(
			_httpServletRequest);
	}

	public String getCommerceOrderItemThumbnailSrc(
			CommerceOrderItem commerceOrderItem)
		throws Exception {

		return _cpInstanceHelper.getCPInstanceThumbnailSrc(
			commerceOrderItem.getCPInstanceId());
	}

	public CommerceOrderPrice getCommerceOrderPrice() throws PortalException {
		CommerceOrderPrice commerceOrderPrice =
			_commerceOrderPriceCalculation.getCommerceOrderPrice(
				getCommerceOrder(), _commerceContext);

		if (commerceOrderPrice != null) {
			return commerceOrderPrice;
		}

		throw new PortalException(
			"There is no price for this order, or the current user does not " +
				"have permission to view it");
	}

	public Map<Long, List<CommerceOrderValidatorResult>>
			getCommerceOrderValidatorResults()
		throws PortalException {

		ThemeDisplay themeDisplay =
			(ThemeDisplay)_httpServletRequest.getAttribute(
				WebKeys.THEME_DISPLAY);

		return _commerceOrderValidatorRegistry.getCommerceOrderValidatorResults(
			themeDisplay.getLocale(), _commerceOrder);
	}

	public String getCommercePriceDisplayType() throws PortalException {
		CommerceOrder commerceOrder = getCommerceOrder();

		CommerceChannel commerceChannel =
			_commerceChannelLocalService.getCommerceChannelByOrderGroupId(
				commerceOrder.getGroupId());

		return commerceChannel.getPriceDisplayType();
	}

	public CommerceProductPrice getCommerceProductPrice(
			CommerceOrderItem commerceOrderItem)
		throws PortalException {

		if (commerceOrderItem.isManuallyAdjusted()) {
			return _getCommerceProductPriceFromOrderItem(commerceOrderItem);
		}

		return _getCommerceProductPrice(commerceOrderItem, _commerceContext);
	}

	public List<KeyValuePair> getKeyValuePairs(
			long cpDefinitionId, String json, Locale locale)
		throws PortalException {

		return _cpInstanceHelper.getKeyValuePairs(cpDefinitionId, json, locale);
	}

	public String getLocalizedPercentage(BigDecimal percentage, Locale locale)
		throws PortalException {

		CommerceOrder commerceOrder = getCommerceOrder();

		CommerceCurrency commerceCurrency = commerceOrder.getCommerceCurrency();

		return _percentageFormatter.getLocalizedPercentage(
			locale, commerceCurrency.getMaxFractionDigits(),
			commerceCurrency.getMinFractionDigits(), percentage);
	}

	public String getPaymentMethodName(String paymentMethodKey, Locale locale) {
		if (paymentMethodKey.isEmpty() || (locale == null)) {
			return StringPool.BLANK;
		}

		return _commercePaymentEngine.getPaymentMethodName(
			paymentMethodKey, locale);
	}

	private CommerceProductPrice _getCommerceProductPrice(
			CommerceOrderItem commerceOrderItem,
			CommerceContext commerceContext)
		throws PortalException {

		List<CommerceOptionValue> cpDefinitionCommerceOptionValues =
			_commerceOptionValueHelper.getCPDefinitionCommerceOptionValues(
				commerceOrderItem.getCPDefinitionId(),
				commerceOrderItem.getJson());

		if (ListUtil.isEmpty(cpDefinitionCommerceOptionValues) &&
			!Objects.equals(commerceOrderItem.getJson(), "[]")) {

			List<CommerceOptionValue> commerceOptionValues =
				_commerceOptionValueHelper.toCommerceOptionValues(
					commerceOrderItem.getJson());

			for (CommerceOptionValue commerceOptionValue :
					commerceOptionValues) {

				if (Objects.equals(
						commerceOptionValue.getPriceType(),
						CPConstants.PRODUCT_OPTION_PRICE_TYPE_STATIC)) {

					return _getCommerceProductPriceFromOrderItem(
						commerceOrderItem);
				}
			}
		}

		CommerceProductPriceRequest commerceProductPriceRequest =
			new CommerceProductPriceRequest();

		commerceProductPriceRequest.setCpInstanceId(
			commerceOrderItem.getCPInstanceId());
		commerceProductPriceRequest.setQuantity(
			commerceOrderItem.getQuantity());
		commerceProductPriceRequest.setSecure(false);
		commerceProductPriceRequest.setCommerceContext(commerceContext);
		commerceProductPriceRequest.setCommerceOptionValues(
			cpDefinitionCommerceOptionValues);
		commerceProductPriceRequest.setCalculateTax(true);

		return _commerceProductPriceCalculation.getCommerceProductPrice(
			commerceProductPriceRequest);
	}

	private CommerceProductPrice _getCommerceProductPriceFromOrderItem(
			CommerceOrderItem commerceOrderItem)
		throws PortalException {

		CommerceProductPriceImpl commerceProductPriceImpl =
			new CommerceProductPriceImpl();

		BigDecimal activePrice = commerceOrderItem.getUnitPrice();
		BigDecimal activePriceWithTaxAmount =
			commerceOrderItem.getUnitPriceWithTaxAmount();

		BigDecimal promoPrice = commerceOrderItem.getPromoPrice();

		if ((promoPrice != null) &&
			CommerceBigDecimalUtil.gt(promoPrice, BigDecimal.ZERO) &&
			CommerceBigDecimalUtil.lte(promoPrice, activePrice)) {

			activePrice = promoPrice;
			activePriceWithTaxAmount =
				commerceOrderItem.getPromoPriceWithTaxAmount();
		}

		commerceProductPriceImpl.setFinalPrice(
			commerceOrderItem.getFinalPriceMoney());
		commerceProductPriceImpl.setFinalPriceWithTaxAmount(
			commerceOrderItem.getFinalPriceWithTaxAmountMoney());
		commerceProductPriceImpl.setQuantity(commerceOrderItem.getQuantity());
		commerceProductPriceImpl.setUnitPrice(
			commerceOrderItem.getUnitPriceMoney());
		commerceProductPriceImpl.setUnitPriceWithTaxAmount(
			commerceOrderItem.getUnitPriceWithTaxAmountMoney());
		commerceProductPriceImpl.setUnitPromoPrice(
			commerceOrderItem.getPromoPriceMoney());
		commerceProductPriceImpl.setUnitPromoPriceWithTaxAmount(
			commerceOrderItem.getPromoPriceWithTaxAmountMoney());

		BigDecimal discountAmount = commerceOrderItem.getDiscountAmount();

		if ((discountAmount == null) ||
			CommerceBigDecimalUtil.isZero(discountAmount)) {

			return commerceProductPriceImpl;
		}

		activePrice = activePrice.multiply(
			BigDecimal.valueOf(commerceOrderItem.getQuantity()));

		BigDecimal discountedAmount = activePrice.subtract(discountAmount);

		CommerceMoney discountAmountCommerceMoney =
			commerceOrderItem.getDiscountAmountMoney();

		CommerceCurrency commerceCurrency =
			discountAmountCommerceMoney.getCommerceCurrency();

		BigDecimal[] values = {
			commerceOrderItem.getDiscountPercentageLevel1(),
			commerceOrderItem.getDiscountPercentageLevel2(),
			commerceOrderItem.getDiscountPercentageLevel3(),
			commerceOrderItem.getDiscountPercentageLevel4()
		};

		CommerceDiscountValue commerceDiscountValue = new CommerceDiscountValue(
			0, discountAmountCommerceMoney,
			_getDiscountPercentage(
				discountedAmount, activePrice,
				RoundingMode.valueOf(commerceCurrency.getRoundingMode())),
			values);

		commerceProductPriceImpl.setCommerceDiscountValue(
			commerceDiscountValue);

		activePriceWithTaxAmount = activePriceWithTaxAmount.multiply(
			BigDecimal.valueOf(commerceOrderItem.getQuantity()));

		CommerceMoney discountWithTaxAmountCommerceMoney =
			commerceOrderItem.getDiscountWithTaxAmountMoney();

		BigDecimal discountedAmountWithTaxAmount =
			activePriceWithTaxAmount.subtract(
				commerceOrderItem.getDiscountWithTaxAmount());

		BigDecimal[] valuesWithTaxAmount = {
			commerceOrderItem.getDiscountPercentageLevel1WithTaxAmount(),
			commerceOrderItem.getDiscountPercentageLevel2WithTaxAmount(),
			commerceOrderItem.getDiscountPercentageLevel3WithTaxAmount(),
			commerceOrderItem.getDiscountPercentageLevel4WithTaxAmount()
		};

		CommerceDiscountValue commerceDiscountValueWithTaxAmount =
			new CommerceDiscountValue(
				0, discountWithTaxAmountCommerceMoney,
				_getDiscountPercentage(
					discountedAmountWithTaxAmount, activePriceWithTaxAmount,
					RoundingMode.valueOf(commerceCurrency.getRoundingMode())),
				valuesWithTaxAmount);

		commerceProductPriceImpl.setCommerceDiscountValueWithTaxAmount(
			commerceDiscountValueWithTaxAmount);

		return commerceProductPriceImpl;
	}

	private BigDecimal _getDiscountPercentage(
		BigDecimal discountedAmount, BigDecimal amount,
		RoundingMode roundingMode) {

		double actualPrice = discountedAmount.doubleValue();
		double originalPrice = amount.doubleValue();

		double percentage = actualPrice / originalPrice;

		BigDecimal discountPercentage = new BigDecimal(percentage);

		discountPercentage = discountPercentage.multiply(_ONE_HUNDRED);

		MathContext mathContext = new MathContext(
			discountPercentage.precision(), roundingMode);

		return _ONE_HUNDRED.subtract(discountPercentage, mathContext);
	}

	private static final BigDecimal _ONE_HUNDRED = BigDecimal.valueOf(100);

	private final CommerceChannelLocalService _commerceChannelLocalService;
	private final CommerceContext _commerceContext;
	private final CommerceOptionValueHelper _commerceOptionValueHelper;
	private final CommerceOrder _commerceOrder;
	private final CommerceOrderHttpHelper _commerceOrderHttpHelper;
	private final CommerceOrderPriceCalculation _commerceOrderPriceCalculation;
	private final CommerceOrderValidatorRegistry
		_commerceOrderValidatorRegistry;
	private final CommercePaymentEngine _commercePaymentEngine;
	private final CommerceProductPriceCalculation
		_commerceProductPriceCalculation;
	private final CPInstanceHelper _cpInstanceHelper;
	private final HttpServletRequest _httpServletRequest;
	private final PercentageFormatter _percentageFormatter;

}