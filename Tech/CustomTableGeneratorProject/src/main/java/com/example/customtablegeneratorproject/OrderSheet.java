package com.example.customtablegeneratorproject;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;
import java.util.Map;

@Data
@EqualsAndHashCode(of = "id", callSuper = false)
public class OrderSheet {
    private String id;

    private String backUrl;

    private Long userNo;

    private List<OrderSheetProduct> products;
    private Map.Entry<Long, OrderSheetMerchant> merchantsByMerchantNo;

    private Instant registeredDateTime;

    private Map<String, OrderSheetBundleDeliveryFee> bundleDeliveryFeesByDeliveryGroupKey;

    @Data
    @EqualsAndHashCode(of = "id", callSuper = false)
    public static class OrderSheetProduct {
        String id;

        String productName;

        BigDecimal salePrice;

        String ecMallProductId;

        List<OrderSheetItem> items;

        OrderSheetDeliveryPolicy deliveryPolicy;

        long merchantNo;

        String merchantCategoryItemTypeName;

        String wholeCategoryId;

        boolean naverBenefit;

        OrderSheetDeliveryFee deliveryFee;

        OrderSheetRewardPointPolicy rewardPointPolicy;
    }

    @Data
    @EqualsAndHashCode(of = "id", callSuper = false)
    public static class OrderSheetItem {

        String id;

        String itemNo;

        BigDecimal price;

        Long quantity;

        BigDecimal orderAmount;

        List<OrderSheetElement> elements;
    }

    @Data
    public static class OrderSheetElement {
        String id;

        ElementType elementType;

        List<String> names;

        List<String> valueIds;

        List<String> texts;
    }

    @Data
    public static class OrderSheetMerchant {
        String talkInterlockAccountId;

        String logeyeRequestId;

        String logeyeInflowPathName;

        Boolean logeyePayAccumulation;
    }

    @Data
    public static class OrderSheetDeliveryPolicy {
        DeliveryMethodType deliveryMethodType;

        DeliveryFeeClassType deliveryFeeClassType;

        DeliveryFeePayType deliveryFeePayType;

        BigDecimal baseFee;

        OrderSheetDeliveryBundlePolicy bundlePolicy;

        BigDecimal freeConditionalAmount;
    }

    @Data
    public static class OrderSheetDeliveryBundlePolicy {
        String bundleGroupId;
    }

    @Data
    public static class OrderSheetDeliveryFee {
        BigDecimal deliveryFee;

        String deliveryGroupKey;
    }

    @Data
    public static class OrderSheetBundleDeliveryFee {
        BigDecimal deliveryFee;

        BundleType type;
    }

    @Data
    public static class OrderSheetRewardPointPolicy {
        Long purchasePolicyNo;

        BigDecimal purchaseAccumulateAmount;
    }

    public enum DeliveryMethodType {
        DELIVERY,
        VISIT_RECEIPT,
        DIRECT_DELIVERY,
        QUICK_SVC,
        NOTHING
    }

    public enum ElementType {
        OPTION,
        CUSTOM
    }

    public enum DeliveryFeeClassType {
        CHARGE,
        FREE
    }

    public enum DeliveryFeePayType {
        PRE_PAY,
        AFTER_PAY,
        FREE
    }

    public enum BundleType {
        MANUALLY,
        IDENTICAL_PRODUCT
    }
}