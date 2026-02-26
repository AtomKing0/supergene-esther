package com.braze.configuration;

import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.media3.common.C;
import com.braze.enums.BrazeSdkMetadata;
import com.braze.enums.DeviceKey;
import com.braze.enums.LocationProviderName;
import com.braze.enums.SdkFlavor;
import com.braze.support.BrazeLogger;
import java.util.EnumSet;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import p9.q;

/* JADX INFO: loaded from: classes2.dex */
public final class BrazeConfig {
    public final String apiKey;
    public final Boolean areAutomaticGeofenceRequestsEnabled;
    public final Boolean areGeofencesEnabled;
    public final Integer badNetworkInterval;
    public final EnumSet<BrazeSdkMetadata> brazeSdkMetadata;
    private final Builder builder;
    public final String customEndpoint;
    public final String customHtmlWebViewActivityClassName;
    public final EnumSet<LocationProviderName> customLocationProviderNames;
    public final Integer defaultNotificationAccentColor;
    public final String defaultNotificationChannelDescription;
    public final String defaultNotificationChannelName;
    public final EnumSet<DeviceKey> deviceObjectAllowlist;
    public final Boolean doesPushStoryDismissOnClick;
    public final String fallbackFirebaseMessagingServiceClasspath;
    public final String firebaseCloudMessagingSenderIdKey;
    public final Integer goodNetworkInterval;
    public final Integer greatNetworkInterval;
    public final Integer inAppMessageWebViewClientMaxOnPageFinishedWaitMs;
    public final Boolean isAdmMessagingRegistrationEnabled;
    public final Boolean isContentCardsUnreadVisualIndicatorEnabled;
    public final Boolean isDeviceObjectAllowlistEnabled;
    public final Boolean isFallbackFirebaseMessagingServiceEnabled;
    public final Boolean isFirebaseCloudMessagingRegistrationEnabled;
    public final Boolean isFirebaseMessagingServiceOnNewTokenRegistrationEnabled;
    public final Boolean isHtmlInAppMessageApplyWindowInsetsEnabled;
    public final Boolean isHtmlInAppMessageHtmlLinkTargetEnabled;
    public final Boolean isInAppMessageAccessibilityExclusiveModeEnabled;
    public final Boolean isInAppMessageTestPushEagerDisplayEnabled;
    public final Boolean isLocationCollectionEnabled;
    public final Boolean isNewsFeedVisualIndicatorOn;
    public final Boolean isPushDeepLinkBackStackActivityEnabled;
    public final Boolean isPushHtmlRenderingEnabled;
    public final Boolean isPushWakeScreenForNotificationEnabled;
    public final Boolean isSdkAuthEnabled;
    public final Boolean isSessionStartBasedTimeoutEnabled;
    public final Boolean isTouchModeRequiredForHtmlInAppMessages;
    public final String largeNotificationIcon;
    public final String pushDeepLinkBackStackActivityClassName;
    public final SdkFlavor sdkFlavor;
    public final String serverTarget;
    public final Integer sessionTimeout;
    public final Boolean shouldOptInWhenPushAuthorized;
    public final Boolean shouldPreventInAppMessageDisplayForDifferentUsers;
    public final Boolean shouldUseWindowFlagSecureInActivities;
    public final String smallNotificationIcon;
    public final Integer triggerActionMinimumTimeIntervalSeconds;
    public final Boolean willHandlePushDeepLinksAutomatically;

    public /* synthetic */ BrazeConfig(Builder builder, k kVar) {
        this(builder);
    }

    public String toString() {
        return this.builder.toString();
    }

    private BrazeConfig(Builder builder) {
        this.builder = builder;
        this.apiKey = builder.getApiKey$android_sdk_base_release();
        this.serverTarget = builder.getServerTarget$android_sdk_base_release();
        this.smallNotificationIcon = builder.getSmallNotificationIconName$android_sdk_base_release();
        this.largeNotificationIcon = builder.getLargeNotificationIconName$android_sdk_base_release();
        this.customEndpoint = builder.getCustomEndpoint$android_sdk_base_release();
        this.defaultNotificationChannelName = builder.getDefaultNotificationChannelName$android_sdk_base_release();
        this.defaultNotificationChannelDescription = builder.getDefaultNotificationChannelDescription$android_sdk_base_release();
        this.pushDeepLinkBackStackActivityClassName = builder.getPushDeepLinkBackStackActivityClassName$android_sdk_base_release();
        this.firebaseCloudMessagingSenderIdKey = builder.getFirebaseCloudMessagingSenderIdKey$android_sdk_base_release();
        this.customHtmlWebViewActivityClassName = builder.getCustomHtmlWebViewActivityClassName$android_sdk_base_release();
        this.sdkFlavor = builder.getSdkFlavor$android_sdk_base_release();
        this.sessionTimeout = builder.getSessionTimeout$android_sdk_base_release();
        this.defaultNotificationAccentColor = builder.getDefaultNotificationAccentColor$android_sdk_base_release();
        this.triggerActionMinimumTimeIntervalSeconds = builder.getTriggerActionMinimumTimeIntervalSeconds$android_sdk_base_release();
        this.badNetworkInterval = builder.getBadNetworkInterval$android_sdk_base_release();
        this.goodNetworkInterval = builder.getGoodNetworkInterval$android_sdk_base_release();
        this.greatNetworkInterval = builder.getGreatNetworkInterval$android_sdk_base_release();
        this.inAppMessageWebViewClientMaxOnPageFinishedWaitMs = builder.getInAppMessageWebViewClientMaxOnPageFinishedWaitMs$android_sdk_base_release();
        this.isAdmMessagingRegistrationEnabled = builder.getAdmMessagingRegistrationEnabled$android_sdk_base_release();
        this.willHandlePushDeepLinksAutomatically = builder.getHandlePushDeepLinksAutomatically$android_sdk_base_release();
        this.isLocationCollectionEnabled = builder.isLocationCollectionEnabled$android_sdk_base_release();
        this.isNewsFeedVisualIndicatorOn = builder.isNewsFeedVisualIndicatorOn$android_sdk_base_release();
        this.isPushDeepLinkBackStackActivityEnabled = builder.isPushDeepLinkBackStackActivityEnabled$android_sdk_base_release();
        this.isSessionStartBasedTimeoutEnabled = builder.isSessionStartBasedTimeoutEnabled$android_sdk_base_release();
        this.isFirebaseCloudMessagingRegistrationEnabled = builder.isFirebaseCloudMessagingRegistrationEnabled$android_sdk_base_release();
        this.isContentCardsUnreadVisualIndicatorEnabled = builder.isContentCardsUnreadVisualIndicatorEnabled$android_sdk_base_release();
        this.isInAppMessageAccessibilityExclusiveModeEnabled = builder.isInAppMessageAccessibilityExclusiveModeEnabled$android_sdk_base_release();
        this.isPushWakeScreenForNotificationEnabled = builder.isPushWakeScreenForNotificationEnabled$android_sdk_base_release();
        this.isPushHtmlRenderingEnabled = builder.isPushHtmlRenderingEnabled$android_sdk_base_release();
        this.areGeofencesEnabled = builder.isGeofencesEnabled$android_sdk_base_release();
        this.isInAppMessageTestPushEagerDisplayEnabled = builder.getInAppMessageTestPushEagerDisplayEnabled$android_sdk_base_release();
        this.areAutomaticGeofenceRequestsEnabled = builder.getAutomaticGeofenceRequestsEnabled$android_sdk_base_release();
        this.isFirebaseMessagingServiceOnNewTokenRegistrationEnabled = builder.isFirebaseMessagingServiceOnNewTokenRegistrationEnabled$android_sdk_base_release();
        this.isSdkAuthEnabled = builder.isSdkAuthEnabled$android_sdk_base_release();
        this.isTouchModeRequiredForHtmlInAppMessages = builder.isTouchModeRequiredForHtmlInAppMessages$android_sdk_base_release();
        this.deviceObjectAllowlist = builder.getDeviceObjectAllowlist$android_sdk_base_release();
        this.isDeviceObjectAllowlistEnabled = builder.isDeviceObjectAllowlistEnabled$android_sdk_base_release();
        this.customLocationProviderNames = builder.getCustomLocationProviderNames$android_sdk_base_release();
        this.brazeSdkMetadata = builder.getBrazeSdkMetadata$android_sdk_base_release();
        this.isHtmlInAppMessageApplyWindowInsetsEnabled = builder.isHtmlInAppMessageApplyWindowInsetsEnabled$android_sdk_base_release();
        this.isHtmlInAppMessageHtmlLinkTargetEnabled = builder.isHtmlInAppMessageHtmlLinkTargetEnabled$android_sdk_base_release();
        this.doesPushStoryDismissOnClick = builder.getDoesPushStoryDismissOnClick$android_sdk_base_release();
        this.isFallbackFirebaseMessagingServiceEnabled = builder.isFallbackFirebaseMessagingServiceEnabled$android_sdk_base_release();
        this.fallbackFirebaseMessagingServiceClasspath = builder.getFallbackFirebaseMessagingServiceClasspath$android_sdk_base_release();
        this.shouldOptInWhenPushAuthorized = builder.getShouldOptInWhenPushAuthorized$android_sdk_base_release();
        this.shouldUseWindowFlagSecureInActivities = builder.getShouldUseWindowFlagSecureInActivities$android_sdk_base_release();
        this.shouldPreventInAppMessageDisplayForDifferentUsers = builder.getShouldPreventInAppMessageDisplayForDifferentUsers$android_sdk_base_release();
    }

    public static final class Builder {
        private Boolean admMessagingRegistrationEnabled;
        private String apiKey;
        private Boolean automaticGeofenceRequestsEnabled;
        private Integer badNetworkInterval;
        private EnumSet<BrazeSdkMetadata> brazeSdkMetadata;
        private String customEndpoint;
        private String customHtmlWebViewActivityClassName;
        private EnumSet<LocationProviderName> customLocationProviderNames;
        private Integer defaultNotificationAccentColor;
        private String defaultNotificationChannelDescription;
        private String defaultNotificationChannelName;
        private EnumSet<DeviceKey> deviceObjectAllowlist;
        private Boolean doesPushStoryDismissOnClick;
        private String fallbackFirebaseMessagingServiceClasspath;
        private String firebaseCloudMessagingSenderIdKey;
        private Integer goodNetworkInterval;
        private Integer greatNetworkInterval;
        private Boolean handlePushDeepLinksAutomatically;
        private Boolean inAppMessageTestPushEagerDisplayEnabled;
        private Integer inAppMessageWebViewClientMaxOnPageFinishedWaitMs;
        private Boolean isContentCardsUnreadVisualIndicatorEnabled;
        private Boolean isDeviceObjectAllowlistEnabled;
        private Boolean isFallbackFirebaseMessagingServiceEnabled;
        private Boolean isFirebaseCloudMessagingRegistrationEnabled;
        private Boolean isFirebaseMessagingServiceOnNewTokenRegistrationEnabled;
        private Boolean isGeofencesEnabled;
        private Boolean isHtmlInAppMessageApplyWindowInsetsEnabled;
        private Boolean isHtmlInAppMessageHtmlLinkTargetEnabled;
        private Boolean isInAppMessageAccessibilityExclusiveModeEnabled;
        private Boolean isLocationCollectionEnabled;
        private Boolean isNewsFeedVisualIndicatorOn;
        private Boolean isPushDeepLinkBackStackActivityEnabled;
        private Boolean isPushHtmlRenderingEnabled;
        private Boolean isPushWakeScreenForNotificationEnabled;
        private Boolean isSdkAuthEnabled;
        private Boolean isSessionStartBasedTimeoutEnabled;
        private Boolean isTouchModeRequiredForHtmlInAppMessages;
        private String largeNotificationIconName;
        private String pushDeepLinkBackStackActivityClassName;
        private SdkFlavor sdkFlavor;
        private String serverTarget;
        private Integer sessionTimeout;
        private Boolean shouldOptInWhenPushAuthorized;
        private Boolean shouldPreventInAppMessageDisplayForDifferentUsers;
        private Boolean shouldUseWindowFlagSecureInActivities;
        private String smallNotificationIconName;
        private Integer triggerActionMinimumTimeIntervalSeconds;

        private Builder(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, SdkFlavor sdkFlavor, Integer num, Integer num2, Integer num3, Integer num4, Integer num5, Integer num6, Integer num7, Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, Boolean bool5, Boolean bool6, Boolean bool7, Boolean bool8, Boolean bool9, Boolean bool10, Boolean bool11, Boolean bool12, Boolean bool13, Boolean bool14, Boolean bool15, Boolean bool16, Boolean bool17, EnumSet<DeviceKey> enumSet, Boolean bool18, EnumSet<BrazeSdkMetadata> enumSet2, EnumSet<LocationProviderName> enumSet3, Boolean bool19, Boolean bool20, Boolean bool21, Boolean bool22, String str11, Boolean bool23, Boolean bool24, Boolean bool25) {
            this.apiKey = str;
            this.serverTarget = str2;
            this.smallNotificationIconName = str3;
            this.largeNotificationIconName = str4;
            this.customEndpoint = str5;
            this.defaultNotificationChannelName = str6;
            this.defaultNotificationChannelDescription = str7;
            this.pushDeepLinkBackStackActivityClassName = str8;
            this.firebaseCloudMessagingSenderIdKey = str9;
            this.customHtmlWebViewActivityClassName = str10;
            this.sdkFlavor = sdkFlavor;
            this.sessionTimeout = num;
            this.defaultNotificationAccentColor = num2;
            this.triggerActionMinimumTimeIntervalSeconds = num3;
            this.badNetworkInterval = num4;
            this.goodNetworkInterval = num5;
            this.greatNetworkInterval = num6;
            this.inAppMessageWebViewClientMaxOnPageFinishedWaitMs = num7;
            this.admMessagingRegistrationEnabled = bool;
            this.handlePushDeepLinksAutomatically = bool2;
            this.isLocationCollectionEnabled = bool3;
            this.isNewsFeedVisualIndicatorOn = bool4;
            this.isPushDeepLinkBackStackActivityEnabled = bool5;
            this.isSessionStartBasedTimeoutEnabled = bool6;
            this.isFirebaseCloudMessagingRegistrationEnabled = bool7;
            this.isContentCardsUnreadVisualIndicatorEnabled = bool8;
            this.isInAppMessageAccessibilityExclusiveModeEnabled = bool9;
            this.isPushWakeScreenForNotificationEnabled = bool10;
            this.isPushHtmlRenderingEnabled = bool11;
            this.isGeofencesEnabled = bool12;
            this.inAppMessageTestPushEagerDisplayEnabled = bool13;
            this.automaticGeofenceRequestsEnabled = bool14;
            this.isFirebaseMessagingServiceOnNewTokenRegistrationEnabled = bool15;
            this.isTouchModeRequiredForHtmlInAppMessages = bool16;
            this.isSdkAuthEnabled = bool17;
            this.deviceObjectAllowlist = enumSet;
            this.isDeviceObjectAllowlistEnabled = bool18;
            this.brazeSdkMetadata = enumSet2;
            this.customLocationProviderNames = enumSet3;
            this.isHtmlInAppMessageApplyWindowInsetsEnabled = bool19;
            this.isHtmlInAppMessageHtmlLinkTargetEnabled = bool20;
            this.doesPushStoryDismissOnClick = bool21;
            this.isFallbackFirebaseMessagingServiceEnabled = bool22;
            this.fallbackFirebaseMessagingServiceClasspath = str11;
            this.shouldOptInWhenPushAuthorized = bool23;
            this.shouldUseWindowFlagSecureInActivities = bool24;
            this.shouldPreventInAppMessageDisplayForDifferentUsers = bool25;
        }

        public final BrazeConfig build() {
            return new BrazeConfig(this, null);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Builder)) {
                return false;
            }
            Builder builder = (Builder) obj;
            return t.d(this.apiKey, builder.apiKey) && t.d(this.serverTarget, builder.serverTarget) && t.d(this.smallNotificationIconName, builder.smallNotificationIconName) && t.d(this.largeNotificationIconName, builder.largeNotificationIconName) && t.d(this.customEndpoint, builder.customEndpoint) && t.d(this.defaultNotificationChannelName, builder.defaultNotificationChannelName) && t.d(this.defaultNotificationChannelDescription, builder.defaultNotificationChannelDescription) && t.d(this.pushDeepLinkBackStackActivityClassName, builder.pushDeepLinkBackStackActivityClassName) && t.d(this.firebaseCloudMessagingSenderIdKey, builder.firebaseCloudMessagingSenderIdKey) && t.d(this.customHtmlWebViewActivityClassName, builder.customHtmlWebViewActivityClassName) && this.sdkFlavor == builder.sdkFlavor && t.d(this.sessionTimeout, builder.sessionTimeout) && t.d(this.defaultNotificationAccentColor, builder.defaultNotificationAccentColor) && t.d(this.triggerActionMinimumTimeIntervalSeconds, builder.triggerActionMinimumTimeIntervalSeconds) && t.d(this.badNetworkInterval, builder.badNetworkInterval) && t.d(this.goodNetworkInterval, builder.goodNetworkInterval) && t.d(this.greatNetworkInterval, builder.greatNetworkInterval) && t.d(this.inAppMessageWebViewClientMaxOnPageFinishedWaitMs, builder.inAppMessageWebViewClientMaxOnPageFinishedWaitMs) && t.d(this.admMessagingRegistrationEnabled, builder.admMessagingRegistrationEnabled) && t.d(this.handlePushDeepLinksAutomatically, builder.handlePushDeepLinksAutomatically) && t.d(this.isLocationCollectionEnabled, builder.isLocationCollectionEnabled) && t.d(this.isNewsFeedVisualIndicatorOn, builder.isNewsFeedVisualIndicatorOn) && t.d(this.isPushDeepLinkBackStackActivityEnabled, builder.isPushDeepLinkBackStackActivityEnabled) && t.d(this.isSessionStartBasedTimeoutEnabled, builder.isSessionStartBasedTimeoutEnabled) && t.d(this.isFirebaseCloudMessagingRegistrationEnabled, builder.isFirebaseCloudMessagingRegistrationEnabled) && t.d(this.isContentCardsUnreadVisualIndicatorEnabled, builder.isContentCardsUnreadVisualIndicatorEnabled) && t.d(this.isInAppMessageAccessibilityExclusiveModeEnabled, builder.isInAppMessageAccessibilityExclusiveModeEnabled) && t.d(this.isPushWakeScreenForNotificationEnabled, builder.isPushWakeScreenForNotificationEnabled) && t.d(this.isPushHtmlRenderingEnabled, builder.isPushHtmlRenderingEnabled) && t.d(this.isGeofencesEnabled, builder.isGeofencesEnabled) && t.d(this.inAppMessageTestPushEagerDisplayEnabled, builder.inAppMessageTestPushEagerDisplayEnabled) && t.d(this.automaticGeofenceRequestsEnabled, builder.automaticGeofenceRequestsEnabled) && t.d(this.isFirebaseMessagingServiceOnNewTokenRegistrationEnabled, builder.isFirebaseMessagingServiceOnNewTokenRegistrationEnabled) && t.d(this.isTouchModeRequiredForHtmlInAppMessages, builder.isTouchModeRequiredForHtmlInAppMessages) && t.d(this.isSdkAuthEnabled, builder.isSdkAuthEnabled) && t.d(this.deviceObjectAllowlist, builder.deviceObjectAllowlist) && t.d(this.isDeviceObjectAllowlistEnabled, builder.isDeviceObjectAllowlistEnabled) && t.d(this.brazeSdkMetadata, builder.brazeSdkMetadata) && t.d(this.customLocationProviderNames, builder.customLocationProviderNames) && t.d(this.isHtmlInAppMessageApplyWindowInsetsEnabled, builder.isHtmlInAppMessageApplyWindowInsetsEnabled) && t.d(this.isHtmlInAppMessageHtmlLinkTargetEnabled, builder.isHtmlInAppMessageHtmlLinkTargetEnabled) && t.d(this.doesPushStoryDismissOnClick, builder.doesPushStoryDismissOnClick) && t.d(this.isFallbackFirebaseMessagingServiceEnabled, builder.isFallbackFirebaseMessagingServiceEnabled) && t.d(this.fallbackFirebaseMessagingServiceClasspath, builder.fallbackFirebaseMessagingServiceClasspath) && t.d(this.shouldOptInWhenPushAuthorized, builder.shouldOptInWhenPushAuthorized) && t.d(this.shouldUseWindowFlagSecureInActivities, builder.shouldUseWindowFlagSecureInActivities) && t.d(this.shouldPreventInAppMessageDisplayForDifferentUsers, builder.shouldPreventInAppMessageDisplayForDifferentUsers);
        }

        public final Boolean getAdmMessagingRegistrationEnabled$android_sdk_base_release() {
            return this.admMessagingRegistrationEnabled;
        }

        public final String getApiKey$android_sdk_base_release() {
            return this.apiKey;
        }

        public final Boolean getAutomaticGeofenceRequestsEnabled$android_sdk_base_release() {
            return this.automaticGeofenceRequestsEnabled;
        }

        public final Integer getBadNetworkInterval$android_sdk_base_release() {
            return this.badNetworkInterval;
        }

        public final EnumSet<BrazeSdkMetadata> getBrazeSdkMetadata$android_sdk_base_release() {
            return this.brazeSdkMetadata;
        }

        public final String getCustomEndpoint$android_sdk_base_release() {
            return this.customEndpoint;
        }

        public final String getCustomHtmlWebViewActivityClassName$android_sdk_base_release() {
            return this.customHtmlWebViewActivityClassName;
        }

        public final EnumSet<LocationProviderName> getCustomLocationProviderNames$android_sdk_base_release() {
            return this.customLocationProviderNames;
        }

        public final Integer getDefaultNotificationAccentColor$android_sdk_base_release() {
            return this.defaultNotificationAccentColor;
        }

        public final String getDefaultNotificationChannelDescription$android_sdk_base_release() {
            return this.defaultNotificationChannelDescription;
        }

        public final String getDefaultNotificationChannelName$android_sdk_base_release() {
            return this.defaultNotificationChannelName;
        }

        public final EnumSet<DeviceKey> getDeviceObjectAllowlist$android_sdk_base_release() {
            return this.deviceObjectAllowlist;
        }

        public final Boolean getDoesPushStoryDismissOnClick$android_sdk_base_release() {
            return this.doesPushStoryDismissOnClick;
        }

        public final String getFallbackFirebaseMessagingServiceClasspath$android_sdk_base_release() {
            return this.fallbackFirebaseMessagingServiceClasspath;
        }

        public final String getFirebaseCloudMessagingSenderIdKey$android_sdk_base_release() {
            return this.firebaseCloudMessagingSenderIdKey;
        }

        public final Integer getGoodNetworkInterval$android_sdk_base_release() {
            return this.goodNetworkInterval;
        }

        public final Integer getGreatNetworkInterval$android_sdk_base_release() {
            return this.greatNetworkInterval;
        }

        public final Boolean getHandlePushDeepLinksAutomatically$android_sdk_base_release() {
            return this.handlePushDeepLinksAutomatically;
        }

        public final Boolean getInAppMessageTestPushEagerDisplayEnabled$android_sdk_base_release() {
            return this.inAppMessageTestPushEagerDisplayEnabled;
        }

        public final Integer getInAppMessageWebViewClientMaxOnPageFinishedWaitMs$android_sdk_base_release() {
            return this.inAppMessageWebViewClientMaxOnPageFinishedWaitMs;
        }

        public final String getLargeNotificationIconName$android_sdk_base_release() {
            return this.largeNotificationIconName;
        }

        public final String getPushDeepLinkBackStackActivityClassName$android_sdk_base_release() {
            return this.pushDeepLinkBackStackActivityClassName;
        }

        public final SdkFlavor getSdkFlavor$android_sdk_base_release() {
            return this.sdkFlavor;
        }

        public final String getServerTarget$android_sdk_base_release() {
            return this.serverTarget;
        }

        public final Integer getSessionTimeout$android_sdk_base_release() {
            return this.sessionTimeout;
        }

        public final Boolean getShouldOptInWhenPushAuthorized$android_sdk_base_release() {
            return this.shouldOptInWhenPushAuthorized;
        }

        public final Boolean getShouldPreventInAppMessageDisplayForDifferentUsers$android_sdk_base_release() {
            return this.shouldPreventInAppMessageDisplayForDifferentUsers;
        }

        public final Boolean getShouldUseWindowFlagSecureInActivities$android_sdk_base_release() {
            return this.shouldUseWindowFlagSecureInActivities;
        }

        public final String getSmallNotificationIconName$android_sdk_base_release() {
            return this.smallNotificationIconName;
        }

        public final Integer getTriggerActionMinimumTimeIntervalSeconds$android_sdk_base_release() {
            return this.triggerActionMinimumTimeIntervalSeconds;
        }

        public int hashCode() {
            String str = this.apiKey;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.serverTarget;
            int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.smallNotificationIconName;
            int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.largeNotificationIconName;
            int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
            String str5 = this.customEndpoint;
            int iHashCode5 = (iHashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
            String str6 = this.defaultNotificationChannelName;
            int iHashCode6 = (iHashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
            String str7 = this.defaultNotificationChannelDescription;
            int iHashCode7 = (iHashCode6 + (str7 == null ? 0 : str7.hashCode())) * 31;
            String str8 = this.pushDeepLinkBackStackActivityClassName;
            int iHashCode8 = (iHashCode7 + (str8 == null ? 0 : str8.hashCode())) * 31;
            String str9 = this.firebaseCloudMessagingSenderIdKey;
            int iHashCode9 = (iHashCode8 + (str9 == null ? 0 : str9.hashCode())) * 31;
            String str10 = this.customHtmlWebViewActivityClassName;
            int iHashCode10 = (iHashCode9 + (str10 == null ? 0 : str10.hashCode())) * 31;
            SdkFlavor sdkFlavor = this.sdkFlavor;
            int iHashCode11 = (iHashCode10 + (sdkFlavor == null ? 0 : sdkFlavor.hashCode())) * 31;
            Integer num = this.sessionTimeout;
            int iHashCode12 = (iHashCode11 + (num == null ? 0 : num.hashCode())) * 31;
            Integer num2 = this.defaultNotificationAccentColor;
            int iHashCode13 = (iHashCode12 + (num2 == null ? 0 : num2.hashCode())) * 31;
            Integer num3 = this.triggerActionMinimumTimeIntervalSeconds;
            int iHashCode14 = (iHashCode13 + (num3 == null ? 0 : num3.hashCode())) * 31;
            Integer num4 = this.badNetworkInterval;
            int iHashCode15 = (iHashCode14 + (num4 == null ? 0 : num4.hashCode())) * 31;
            Integer num5 = this.goodNetworkInterval;
            int iHashCode16 = (iHashCode15 + (num5 == null ? 0 : num5.hashCode())) * 31;
            Integer num6 = this.greatNetworkInterval;
            int iHashCode17 = (iHashCode16 + (num6 == null ? 0 : num6.hashCode())) * 31;
            Integer num7 = this.inAppMessageWebViewClientMaxOnPageFinishedWaitMs;
            int iHashCode18 = (iHashCode17 + (num7 == null ? 0 : num7.hashCode())) * 31;
            Boolean bool = this.admMessagingRegistrationEnabled;
            int iHashCode19 = (iHashCode18 + (bool == null ? 0 : bool.hashCode())) * 31;
            Boolean bool2 = this.handlePushDeepLinksAutomatically;
            int iHashCode20 = (iHashCode19 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
            Boolean bool3 = this.isLocationCollectionEnabled;
            int iHashCode21 = (iHashCode20 + (bool3 == null ? 0 : bool3.hashCode())) * 31;
            Boolean bool4 = this.isNewsFeedVisualIndicatorOn;
            int iHashCode22 = (iHashCode21 + (bool4 == null ? 0 : bool4.hashCode())) * 31;
            Boolean bool5 = this.isPushDeepLinkBackStackActivityEnabled;
            int iHashCode23 = (iHashCode22 + (bool5 == null ? 0 : bool5.hashCode())) * 31;
            Boolean bool6 = this.isSessionStartBasedTimeoutEnabled;
            int iHashCode24 = (iHashCode23 + (bool6 == null ? 0 : bool6.hashCode())) * 31;
            Boolean bool7 = this.isFirebaseCloudMessagingRegistrationEnabled;
            int iHashCode25 = (iHashCode24 + (bool7 == null ? 0 : bool7.hashCode())) * 31;
            Boolean bool8 = this.isContentCardsUnreadVisualIndicatorEnabled;
            int iHashCode26 = (iHashCode25 + (bool8 == null ? 0 : bool8.hashCode())) * 31;
            Boolean bool9 = this.isInAppMessageAccessibilityExclusiveModeEnabled;
            int iHashCode27 = (iHashCode26 + (bool9 == null ? 0 : bool9.hashCode())) * 31;
            Boolean bool10 = this.isPushWakeScreenForNotificationEnabled;
            int iHashCode28 = (iHashCode27 + (bool10 == null ? 0 : bool10.hashCode())) * 31;
            Boolean bool11 = this.isPushHtmlRenderingEnabled;
            int iHashCode29 = (iHashCode28 + (bool11 == null ? 0 : bool11.hashCode())) * 31;
            Boolean bool12 = this.isGeofencesEnabled;
            int iHashCode30 = (iHashCode29 + (bool12 == null ? 0 : bool12.hashCode())) * 31;
            Boolean bool13 = this.inAppMessageTestPushEagerDisplayEnabled;
            int iHashCode31 = (iHashCode30 + (bool13 == null ? 0 : bool13.hashCode())) * 31;
            Boolean bool14 = this.automaticGeofenceRequestsEnabled;
            int iHashCode32 = (iHashCode31 + (bool14 == null ? 0 : bool14.hashCode())) * 31;
            Boolean bool15 = this.isFirebaseMessagingServiceOnNewTokenRegistrationEnabled;
            int iHashCode33 = (iHashCode32 + (bool15 == null ? 0 : bool15.hashCode())) * 31;
            Boolean bool16 = this.isTouchModeRequiredForHtmlInAppMessages;
            int iHashCode34 = (iHashCode33 + (bool16 == null ? 0 : bool16.hashCode())) * 31;
            Boolean bool17 = this.isSdkAuthEnabled;
            int iHashCode35 = (iHashCode34 + (bool17 == null ? 0 : bool17.hashCode())) * 31;
            EnumSet<DeviceKey> enumSet = this.deviceObjectAllowlist;
            int iHashCode36 = (iHashCode35 + (enumSet == null ? 0 : enumSet.hashCode())) * 31;
            Boolean bool18 = this.isDeviceObjectAllowlistEnabled;
            int iHashCode37 = (iHashCode36 + (bool18 == null ? 0 : bool18.hashCode())) * 31;
            EnumSet<BrazeSdkMetadata> enumSet2 = this.brazeSdkMetadata;
            int iHashCode38 = (iHashCode37 + (enumSet2 == null ? 0 : enumSet2.hashCode())) * 31;
            EnumSet<LocationProviderName> enumSet3 = this.customLocationProviderNames;
            int iHashCode39 = (iHashCode38 + (enumSet3 == null ? 0 : enumSet3.hashCode())) * 31;
            Boolean bool19 = this.isHtmlInAppMessageApplyWindowInsetsEnabled;
            int iHashCode40 = (iHashCode39 + (bool19 == null ? 0 : bool19.hashCode())) * 31;
            Boolean bool20 = this.isHtmlInAppMessageHtmlLinkTargetEnabled;
            int iHashCode41 = (iHashCode40 + (bool20 == null ? 0 : bool20.hashCode())) * 31;
            Boolean bool21 = this.doesPushStoryDismissOnClick;
            int iHashCode42 = (iHashCode41 + (bool21 == null ? 0 : bool21.hashCode())) * 31;
            Boolean bool22 = this.isFallbackFirebaseMessagingServiceEnabled;
            int iHashCode43 = (iHashCode42 + (bool22 == null ? 0 : bool22.hashCode())) * 31;
            String str11 = this.fallbackFirebaseMessagingServiceClasspath;
            int iHashCode44 = (iHashCode43 + (str11 == null ? 0 : str11.hashCode())) * 31;
            Boolean bool23 = this.shouldOptInWhenPushAuthorized;
            int iHashCode45 = (iHashCode44 + (bool23 == null ? 0 : bool23.hashCode())) * 31;
            Boolean bool24 = this.shouldUseWindowFlagSecureInActivities;
            int iHashCode46 = (iHashCode45 + (bool24 == null ? 0 : bool24.hashCode())) * 31;
            Boolean bool25 = this.shouldPreventInAppMessageDisplayForDifferentUsers;
            return iHashCode46 + (bool25 != null ? bool25.hashCode() : 0);
        }

        public final Boolean isContentCardsUnreadVisualIndicatorEnabled$android_sdk_base_release() {
            return this.isContentCardsUnreadVisualIndicatorEnabled;
        }

        public final Boolean isDeviceObjectAllowlistEnabled$android_sdk_base_release() {
            return this.isDeviceObjectAllowlistEnabled;
        }

        public final Boolean isFallbackFirebaseMessagingServiceEnabled$android_sdk_base_release() {
            return this.isFallbackFirebaseMessagingServiceEnabled;
        }

        public final Boolean isFirebaseCloudMessagingRegistrationEnabled$android_sdk_base_release() {
            return this.isFirebaseCloudMessagingRegistrationEnabled;
        }

        public final Boolean isFirebaseMessagingServiceOnNewTokenRegistrationEnabled$android_sdk_base_release() {
            return this.isFirebaseMessagingServiceOnNewTokenRegistrationEnabled;
        }

        public final Boolean isGeofencesEnabled$android_sdk_base_release() {
            return this.isGeofencesEnabled;
        }

        public final Boolean isHtmlInAppMessageApplyWindowInsetsEnabled$android_sdk_base_release() {
            return this.isHtmlInAppMessageApplyWindowInsetsEnabled;
        }

        public final Boolean isHtmlInAppMessageHtmlLinkTargetEnabled$android_sdk_base_release() {
            return this.isHtmlInAppMessageHtmlLinkTargetEnabled;
        }

        public final Boolean isInAppMessageAccessibilityExclusiveModeEnabled$android_sdk_base_release() {
            return this.isInAppMessageAccessibilityExclusiveModeEnabled;
        }

        public final Boolean isLocationCollectionEnabled$android_sdk_base_release() {
            return this.isLocationCollectionEnabled;
        }

        public final Boolean isNewsFeedVisualIndicatorOn$android_sdk_base_release() {
            return this.isNewsFeedVisualIndicatorOn;
        }

        public final Boolean isPushDeepLinkBackStackActivityEnabled$android_sdk_base_release() {
            return this.isPushDeepLinkBackStackActivityEnabled;
        }

        public final Boolean isPushHtmlRenderingEnabled$android_sdk_base_release() {
            return this.isPushHtmlRenderingEnabled;
        }

        public final Boolean isPushWakeScreenForNotificationEnabled$android_sdk_base_release() {
            return this.isPushWakeScreenForNotificationEnabled;
        }

        public final Boolean isSdkAuthEnabled$android_sdk_base_release() {
            return this.isSdkAuthEnabled;
        }

        public final Boolean isSessionStartBasedTimeoutEnabled$android_sdk_base_release() {
            return this.isSessionStartBasedTimeoutEnabled;
        }

        public final Boolean isTouchModeRequiredForHtmlInAppMessages$android_sdk_base_release() {
            return this.isTouchModeRequiredForHtmlInAppMessages;
        }

        public final Builder setApiKey(String apiKey) {
            t.i(apiKey, "apiKey");
            if (!q.z(apiKey)) {
                this.apiKey = apiKey;
            } else {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (h9.a) a.f8064a, 6, (Object) null);
            }
            return this;
        }

        public final Builder setAutomaticGeofenceRequestsEnabled(boolean z10) {
            this.automaticGeofenceRequestsEnabled = Boolean.valueOf(z10);
            return this;
        }

        public final Builder setCustomEndpoint(String customEndpoint) {
            t.i(customEndpoint, "customEndpoint");
            this.customEndpoint = customEndpoint;
            return this;
        }

        public final Builder setDefaultNotificationAccentColor(int i10) {
            this.defaultNotificationAccentColor = Integer.valueOf(i10);
            return this;
        }

        public final Builder setFirebaseCloudMessagingSenderIdKey(String firebaseSenderId) {
            t.i(firebaseSenderId, "firebaseSenderId");
            if (!q.z(firebaseSenderId)) {
                this.firebaseCloudMessagingSenderIdKey = firebaseSenderId;
            } else {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (h9.a) d.f8065a, 6, (Object) null);
            }
            return this;
        }

        public final Builder setGeofencesEnabled(boolean z10) {
            this.isGeofencesEnabled = Boolean.valueOf(z10);
            return this;
        }

        public final Builder setHandlePushDeepLinksAutomatically(boolean z10) {
            this.handlePushDeepLinksAutomatically = Boolean.valueOf(z10);
            return this;
        }

        public final Builder setIsFirebaseCloudMessagingRegistrationEnabled(boolean z10) {
            this.isFirebaseCloudMessagingRegistrationEnabled = Boolean.valueOf(z10);
            return this;
        }

        public final Builder setIsLocationCollectionEnabled(boolean z10) {
            this.isLocationCollectionEnabled = Boolean.valueOf(z10);
            return this;
        }

        public final Builder setLargeNotificationIcon(String largeNotificationIconName) {
            t.i(largeNotificationIconName, "largeNotificationIconName");
            this.largeNotificationIconName = largeNotificationIconName;
            return this;
        }

        public final Builder setPushHtmlRenderingEnabled(boolean z10) {
            this.isPushHtmlRenderingEnabled = Boolean.valueOf(z10);
            return this;
        }

        public final Builder setSessionTimeout(int i10) {
            this.sessionTimeout = Integer.valueOf(i10);
            return this;
        }

        public final Builder setSmallNotificationIcon(String smallNotificationIconName) {
            t.i(smallNotificationIconName, "smallNotificationIconName");
            this.smallNotificationIconName = smallNotificationIconName;
            return this;
        }

        public final Builder setTriggerActionMinimumTimeIntervalSeconds(int i10) {
            this.triggerActionMinimumTimeIntervalSeconds = Integer.valueOf(i10);
            return this;
        }

        public String toString() {
            return "Builder(apiKey=" + this.apiKey + ", serverTarget=" + this.serverTarget + ", smallNotificationIconName=" + this.smallNotificationIconName + ", largeNotificationIconName=" + this.largeNotificationIconName + ", customEndpoint=" + this.customEndpoint + ", defaultNotificationChannelName=" + this.defaultNotificationChannelName + ", defaultNotificationChannelDescription=" + this.defaultNotificationChannelDescription + ", pushDeepLinkBackStackActivityClassName=" + this.pushDeepLinkBackStackActivityClassName + ", firebaseCloudMessagingSenderIdKey=" + this.firebaseCloudMessagingSenderIdKey + ", customHtmlWebViewActivityClassName=" + this.customHtmlWebViewActivityClassName + ", sdkFlavor=" + this.sdkFlavor + ", sessionTimeout=" + this.sessionTimeout + ", defaultNotificationAccentColor=" + this.defaultNotificationAccentColor + ", triggerActionMinimumTimeIntervalSeconds=" + this.triggerActionMinimumTimeIntervalSeconds + ", badNetworkInterval=" + this.badNetworkInterval + ", goodNetworkInterval=" + this.goodNetworkInterval + ", greatNetworkInterval=" + this.greatNetworkInterval + ", inAppMessageWebViewClientMaxOnPageFinishedWaitMs=" + this.inAppMessageWebViewClientMaxOnPageFinishedWaitMs + ", admMessagingRegistrationEnabled=" + this.admMessagingRegistrationEnabled + ", handlePushDeepLinksAutomatically=" + this.handlePushDeepLinksAutomatically + ", isLocationCollectionEnabled=" + this.isLocationCollectionEnabled + ", isNewsFeedVisualIndicatorOn=" + this.isNewsFeedVisualIndicatorOn + ", isPushDeepLinkBackStackActivityEnabled=" + this.isPushDeepLinkBackStackActivityEnabled + ", isSessionStartBasedTimeoutEnabled=" + this.isSessionStartBasedTimeoutEnabled + ", isFirebaseCloudMessagingRegistrationEnabled=" + this.isFirebaseCloudMessagingRegistrationEnabled + ", isContentCardsUnreadVisualIndicatorEnabled=" + this.isContentCardsUnreadVisualIndicatorEnabled + ", isInAppMessageAccessibilityExclusiveModeEnabled=" + this.isInAppMessageAccessibilityExclusiveModeEnabled + ", isPushWakeScreenForNotificationEnabled=" + this.isPushWakeScreenForNotificationEnabled + ", isPushHtmlRenderingEnabled=" + this.isPushHtmlRenderingEnabled + ", isGeofencesEnabled=" + this.isGeofencesEnabled + ", inAppMessageTestPushEagerDisplayEnabled=" + this.inAppMessageTestPushEagerDisplayEnabled + ", automaticGeofenceRequestsEnabled=" + this.automaticGeofenceRequestsEnabled + ", isFirebaseMessagingServiceOnNewTokenRegistrationEnabled=" + this.isFirebaseMessagingServiceOnNewTokenRegistrationEnabled + ", isTouchModeRequiredForHtmlInAppMessages=" + this.isTouchModeRequiredForHtmlInAppMessages + ", isSdkAuthEnabled=" + this.isSdkAuthEnabled + ", deviceObjectAllowlist=" + this.deviceObjectAllowlist + ", isDeviceObjectAllowlistEnabled=" + this.isDeviceObjectAllowlistEnabled + ", brazeSdkMetadata=" + this.brazeSdkMetadata + ", customLocationProviderNames=" + this.customLocationProviderNames + ", isHtmlInAppMessageApplyWindowInsetsEnabled=" + this.isHtmlInAppMessageApplyWindowInsetsEnabled + ", isHtmlInAppMessageHtmlLinkTargetEnabled=" + this.isHtmlInAppMessageHtmlLinkTargetEnabled + ", doesPushStoryDismissOnClick=" + this.doesPushStoryDismissOnClick + ", isFallbackFirebaseMessagingServiceEnabled=" + this.isFallbackFirebaseMessagingServiceEnabled + ", fallbackFirebaseMessagingServiceClasspath=" + this.fallbackFirebaseMessagingServiceClasspath + ", shouldOptInWhenPushAuthorized=" + this.shouldOptInWhenPushAuthorized + ", shouldUseWindowFlagSecureInActivities=" + this.shouldUseWindowFlagSecureInActivities + ", shouldPreventInAppMessageDisplayForDifferentUsers=" + this.shouldPreventInAppMessageDisplayForDifferentUsers + ')';
        }

        public /* synthetic */ Builder(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, SdkFlavor sdkFlavor, Integer num, Integer num2, Integer num3, Integer num4, Integer num5, Integer num6, Integer num7, Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, Boolean bool5, Boolean bool6, Boolean bool7, Boolean bool8, Boolean bool9, Boolean bool10, Boolean bool11, Boolean bool12, Boolean bool13, Boolean bool14, Boolean bool15, Boolean bool16, Boolean bool17, EnumSet enumSet, Boolean bool18, EnumSet enumSet2, EnumSet enumSet3, Boolean bool19, Boolean bool20, Boolean bool21, Boolean bool22, String str11, Boolean bool23, Boolean bool24, Boolean bool25, int i10, int i11, k kVar) {
            this((i10 & 1) != 0 ? null : str, (i10 & 2) != 0 ? null : str2, (i10 & 4) != 0 ? null : str3, (i10 & 8) != 0 ? null : str4, (i10 & 16) != 0 ? null : str5, (i10 & 32) != 0 ? null : str6, (i10 & 64) != 0 ? null : str7, (i10 & 128) != 0 ? null : str8, (i10 & 256) != 0 ? null : str9, (i10 & 512) != 0 ? null : str10, (i10 & 1024) != 0 ? null : sdkFlavor, (i10 & 2048) != 0 ? null : num, (i10 & 4096) != 0 ? null : num2, (i10 & 8192) != 0 ? null : num3, (i10 & 16384) != 0 ? null : num4, (i10 & 32768) != 0 ? null : num5, (i10 & 65536) != 0 ? null : num6, (i10 & 131072) != 0 ? null : num7, (i10 & 262144) != 0 ? null : bool, (i10 & 524288) != 0 ? null : bool2, (i10 & 1048576) != 0 ? null : bool3, (i10 & 2097152) != 0 ? null : bool4, (i10 & 4194304) != 0 ? null : bool5, (i10 & 8388608) != 0 ? null : bool6, (i10 & 16777216) != 0 ? null : bool7, (i10 & 33554432) != 0 ? null : bool8, (i10 & AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL) != 0 ? null : bool9, (i10 & C.BUFFER_FLAG_FIRST_SAMPLE) != 0 ? null : bool10, (i10 & 268435456) != 0 ? null : bool11, (i10 & 536870912) != 0 ? null : bool12, (i10 & 1073741824) != 0 ? null : bool13, (i10 & Integer.MIN_VALUE) != 0 ? null : bool14, (i11 & 1) != 0 ? null : bool15, (i11 & 2) != 0 ? null : bool16, (i11 & 4) != 0 ? null : bool17, (i11 & 8) != 0 ? null : enumSet, (i11 & 16) != 0 ? null : bool18, (i11 & 32) != 0 ? null : enumSet2, (i11 & 64) != 0 ? null : enumSet3, (i11 & 128) != 0 ? null : bool19, (i11 & 256) != 0 ? null : bool20, (i11 & 512) != 0 ? null : bool21, (i11 & 1024) != 0 ? null : bool22, (i11 & 2048) != 0 ? null : str11, (i11 & 4096) != 0 ? null : bool23, (i11 & 8192) != 0 ? null : bool24, (i11 & 16384) != 0 ? null : bool25);
        }

        public Builder() {
            this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -2, 32767, null);
        }
    }
}
