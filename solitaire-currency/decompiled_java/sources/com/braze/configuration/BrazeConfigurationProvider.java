package com.braze.configuration;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import bo.app.a8;
import bo.app.b8;
import bo.app.c8;
import bo.app.d8;
import bo.app.e8;
import bo.app.f8;
import bo.app.g8;
import bo.app.h8;
import bo.app.i8;
import bo.app.j8;
import bo.app.k8;
import bo.app.l8;
import bo.app.m8;
import bo.app.n8;
import bo.app.s7;
import bo.app.wu;
import bo.app.x7;
import bo.app.xk;
import bo.app.xu;
import bo.app.y7;
import bo.app.z7;
import com.braze.enums.BrazeSdkMetadata;
import com.braze.enums.DeviceKey;
import com.braze.enums.LocationProviderName;
import com.braze.enums.SdkFlavor;
import com.braze.support.BrazeLogger;
import com.braze.support.PackageUtils;
import com.braze.support.e;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.collections.d0;
import kotlin.collections.z0;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.t0;
import p9.q;

/* JADX INFO: loaded from: classes2.dex */
public class BrazeConfigurationProvider extends CachedConfigurationProvider {
    public static final x7 Companion = new x7();
    public static final int DEFAULT_IN_APP_MESSAGE_WEBVIEW_ONPAGEFINISHED_WAIT_MS = (int) TimeUnit.SECONDS.toMillis(15);
    private final Context context;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BrazeConfigurationProvider(Context context) {
        super(context, false, null, 6, null);
        t.i(context, "context");
        Context applicationContext = context.getApplicationContext();
        t.h(applicationContext, "context.applicationContext");
        this.context = applicationContext;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final <E extends Enum<E>> EnumSet<E> getGenericEnumSetFromStringSet(Class<E> targetEnumClass, y7 y7Var) {
        String str = y7Var.f4332a;
        if (getConfigurationCache().containsKey(str)) {
            Object obj = getConfigurationCache().get(str);
            t.g(obj, "null cannot be cast to non-null type java.util.EnumSet<E of com.braze.configuration.BrazeConfigurationProvider.getGenericEnumSetFromStringSet>");
            return (EnumSet) obj;
        }
        Set<String> sourceStringSet = getStringSetValue(y7Var.f4332a, new HashSet());
        if (sourceStringSet == null) {
            sourceStringSet = new HashSet<>();
        }
        t.i(targetEnumClass, "targetEnumClass");
        t.i(sourceStringSet, "sourceStringSet");
        EnumSet<E> result = (EnumSet<E>) EnumSet.noneOf(targetEnumClass);
        for (String str2 : sourceStringSet) {
            try {
                Locale US = Locale.US;
                t.h(US, "US");
                String enumValue = str2.toUpperCase(US);
                t.h(enumValue, "this as java.lang.String).toUpperCase(locale)");
                t.i(enumValue, "enumValue");
                t.i(targetEnumClass, "targetEnumClass");
                result.add(Enum.valueOf(targetEnumClass, enumValue));
            } catch (Exception e10) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) e.f8117a, BrazeLogger.Priority.E, (Throwable) e10, false, (h9.a) new wu(str2), 4, (Object) null);
            }
        }
        t.h(result, "result");
        getConfigurationCache().put(str, result);
        return result;
    }

    private final String getServerTarget() {
        String stringValue = getStringValue("com_braze_server_target", "PROD");
        return stringValue == null ? "PROD" : stringValue;
    }

    public final int getApplicationIconResourceId() {
        int i10;
        if (getConfigurationCache().containsKey("application_icon")) {
            Object obj = getConfigurationCache().get("application_icon");
            t.g(obj, "null cannot be cast to non-null type kotlin.Int");
            return ((Integer) obj).intValue();
        }
        String packageName = this.context.getPackageName();
        try {
            ApplicationInfo applicationInfo = Build.VERSION.SDK_INT >= 33 ? this.context.getPackageManager().getApplicationInfo(packageName, PackageManager.ApplicationInfoFlags.of(0L)) : this.context.getPackageManager().getApplicationInfo(packageName, 0);
            t.h(applicationInfo, "if (Build.VERSION.SDK_IN… 0)\n                    }");
            i10 = applicationInfo.icon;
        } catch (Exception e10) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) e10, false, (h9.a) new z7(packageName), 4, (Object) null);
            i10 = 0;
        }
        getConfigurationCache().put("application_icon", Integer.valueOf(i10));
        return i10;
    }

    public final String getBaseUrlForRequests() {
        String serverTarget = getServerTarget();
        Locale US = Locale.US;
        t.h(US, "US");
        String upperCase = serverTarget.toUpperCase(US);
        t.h(upperCase, "this as java.lang.String).toUpperCase(locale)");
        return t.d("STAGING", upperCase) ? "https://sondheim.braze.com/api/v3/" : "https://sdk.iad-01.braze.com/api/v3/";
    }

    public final s7 getBrazeApiKey() {
        String stringValue = (String) getConfigurationCache().get("com_braze_api_key");
        if (stringValue == null) {
            stringValue = getRuntimeAppConfigurationProvider().getStringValue("com_braze_api_key", null);
            if (stringValue != null) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.I, (Throwable) null, false, (h9.a) b8.f2422a, 6, (Object) null);
            } else {
                stringValue = getStringValue("com_braze_api_key", null);
            }
            if (stringValue != null) {
                getConfigurationCache().put("com_braze_api_key", stringValue);
            }
        }
        if (stringValue != null) {
            return new s7(stringValue);
        }
        BrazeLogger brazeLogger = BrazeLogger.INSTANCE;
        BrazeLogger.Priority priority = BrazeLogger.Priority.W;
        BrazeLogger.brazelog$default(brazeLogger, (Object) this, priority, (Throwable) null, false, (h9.a) c8.f2490a, 6, (Object) null);
        BrazeLogger.brazelog$default(brazeLogger, (Object) this, priority, (Throwable) null, false, (h9.a) d8.f2629a, 6, (Object) null);
        BrazeLogger.brazelog$default(brazeLogger, (Object) this, priority, (Throwable) null, false, (h9.a) e8.f2713a, 6, (Object) null);
        BrazeLogger.brazelog$default(brazeLogger, (Object) this, priority, (Throwable) null, false, (h9.a) f8.f2782a, 6, (Object) null);
        BrazeLogger.brazelog$default(brazeLogger, (Object) this, priority, (Throwable) null, false, (h9.a) g8.f2878a, 6, (Object) null);
        BrazeLogger.brazelog$default(brazeLogger, (Object) this, priority, (Throwable) null, false, (h9.a) h8.f2960a, 6, (Object) null);
        BrazeLogger.brazelog$default(brazeLogger, (Object) this, priority, (Throwable) null, false, (h9.a) i8.f3031a, 6, (Object) null);
        BrazeLogger.brazelog$default(brazeLogger, (Object) this, priority, (Throwable) null, false, (h9.a) j8.f3136a, 6, (Object) null);
        BrazeLogger.brazelog$default(brazeLogger, (Object) this, priority, (Throwable) null, false, (h9.a) a8.f2356a, 6, (Object) null);
        throw new RuntimeException("Unable to read the Braze API key from the res/values/braze.xml file or from runtime configuration via BrazeConfig. See log for more details.");
    }

    public final String getCustomEndpoint() {
        return getStringValue("com_braze_custom_endpoint", null);
    }

    public final String getCustomHtmlWebViewActivityClassName() {
        return getStringValue("com_braze_custom_html_webview_activity_class_name", "");
    }

    public final EnumSet<LocationProviderName> getCustomLocationProviderNames() {
        return getGenericEnumSetFromStringSet(LocationProviderName.class, y7.CUSTOM_LOCATION_PROVIDERS_LIST_KEY);
    }

    public final int getDefaultNotificationAccentColor() {
        Integer colorValue = getColorValue("com_braze_default_notification_accent_color");
        if (colorValue == null) {
            return 0;
        }
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) k8.f3224a, 7, (Object) null);
        return colorValue.intValue();
    }

    public final String getDefaultNotificationChannelDescription() {
        String stringValue = getStringValue("com_braze_default_notification_channel_description", "");
        return stringValue == null ? "" : stringValue;
    }

    public final String getDefaultNotificationChannelName() {
        String stringValue = getStringValue("com_braze_default_notification_channel_name", "General");
        return stringValue == null ? "General" : stringValue;
    }

    public final EnumSet<DeviceKey> getDeviceObjectAllowlist() {
        return getGenericEnumSetFromStringSet(DeviceKey.class, y7.DEVICE_OBJECT_ALLOWLIST_VALUE);
    }

    public final boolean getDoesHandlePushDeepLinksAutomatically() {
        return getBooleanValue("com_braze_handle_push_deep_links_automatically", false);
    }

    public final boolean getDoesPushStoryDismissOnClick() {
        return getBooleanValue("com_braze_does_push_story_dismiss_on_click", true);
    }

    public final Set<String> getEphemeralEventKeys() {
        Set<String> stringSetValue = getStringSetValue("com_braze_ephemeral_events_keys", z0.e());
        if (stringSetValue == null) {
            stringSetValue = z0.e();
        }
        if (stringSetValue.size() > 12) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (h9.a) l8.f3312a, 6, (Object) null);
        }
        return d0.T0(d0.J0(stringSetValue, 12));
    }

    public final String getFallbackFirebaseMessagingServiceClasspath() {
        return getStringValue("com_braze_fallback_firebase_cloud_messaging_service_classpath", null);
    }

    public final String getFirebaseCloudMessagingSenderIdKey() {
        return getStringValue("com_braze_firebase_cloud_messaging_sender_id", null);
    }

    public final int getInAppMessageWebViewClientOnPageFinishedMaxWaitMs() {
        return getIntValue("com_braze_in_app_message_webview_client_max_onpagefinished_wait_ms", DEFAULT_IN_APP_MESSAGE_WEBVIEW_ONPAGEFINISHED_WAIT_MS);
    }

    public final int getLargeNotificationIconResourceId() {
        return getDrawableValue("com_braze_push_large_notification_icon", 0);
    }

    public final int getLoggerInitialLogLevel() {
        return getIntValue("com_braze_logger_initial_log_level", 4);
    }

    public final String getPushDeepLinkBackStackActivityClassName() {
        return getStringValue("com_braze_push_deep_link_back_stack_activity_class_name", "");
    }

    public final SdkFlavor getSdkFlavor() {
        String stringValue = getStringValue("com_braze_sdk_flavor", null);
        if (stringValue == null || q.z(stringValue)) {
            return null;
        }
        try {
            Locale US = Locale.US;
            t.h(US, "US");
            String upperCase = stringValue.toUpperCase(US);
            t.h(upperCase, "this as java.lang.String).toUpperCase(locale)");
            return SdkFlavor.valueOf(upperCase);
        } catch (Exception e10) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) e10, false, (h9.a) m8.f3397a, 4, (Object) null);
            return null;
        }
    }

    public final EnumSet<BrazeSdkMetadata> getSdkMetadata() {
        String upperCase;
        int i10;
        xk xkVar = xk.STRING_ARRAY;
        Object resourceConfigurationValue = getResourceConfigurationValue(xkVar, "com_braze_internal_sdk_metadata", new HashSet());
        t.g(resourceConfigurationValue, "null cannot be cast to non-null type kotlin.collections.MutableSet<kotlin.String>");
        Set<String> setE = t0.e(resourceConfigurationValue);
        Object resourceConfigurationValue2 = getResourceConfigurationValue(xkVar, "com_braze_sdk_metadata", new HashSet());
        t.g(resourceConfigurationValue2, "null cannot be cast to non-null type kotlin.collections.Set<kotlin.String>");
        Object runtimeConfigurationValue = getRuntimeConfigurationValue(xkVar, "com_braze_sdk_metadata", new HashSet());
        t.g(runtimeConfigurationValue, "null cannot be cast to non-null type kotlin.collections.Set<kotlin.String>");
        setE.addAll((Set) resourceConfigurationValue2);
        setE.addAll((Set) runtimeConfigurationValue);
        EnumSet<BrazeSdkMetadata> result = EnumSet.noneOf(BrazeSdkMetadata.class);
        for (String str : setE) {
            try {
                Locale US = Locale.US;
                t.h(US, "US");
                upperCase = str.toUpperCase(US);
                t.h(upperCase, "this as java.lang.String).toUpperCase(locale)");
            } catch (Exception e10) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) e.f8117a, BrazeLogger.Priority.E, (Throwable) e10, false, (h9.a) new xu(str), 4, (Object) null);
            }
            for (BrazeSdkMetadata brazeSdkMetadata : BrazeSdkMetadata.values()) {
                if (t.d(brazeSdkMetadata.name(), upperCase)) {
                    result.add(brazeSdkMetadata);
                }
            }
            throw new NoSuchElementException("Array contains no element matching the predicate.");
        }
        t.h(result, "result");
        return result;
    }

    public final int getSessionTimeoutSeconds() {
        return getIntValue("com_braze_session_timeout", 10);
    }

    public final boolean getShouldOptInWhenPushAuthorized() {
        return getBooleanValue("com_braze_optin_when_push_authorized", true);
    }

    public final boolean getShouldUseWindowFlagSecureInActivities() {
        return getBooleanValue("com_braze_use_activity_window_flag_secure", false);
    }

    public final int getSmallNotificationIconResourceId() {
        return getDrawableValue("com_braze_push_small_notification_icon", 0);
    }

    public final long getTriggerActionMinimumTimeIntervalInSeconds() {
        return getIntValue("com_braze_trigger_action_minimum_time_interval_seconds", 30);
    }

    public final int getVersionCode() {
        int i10;
        if (getConfigurationCache().containsKey("version_code")) {
            Object obj = getConfigurationCache().get("version_code");
            t.g(obj, "null cannot be cast to non-null type kotlin.Int");
            return ((Integer) obj).intValue();
        }
        try {
            i10 = this.context.getPackageManager().getPackageInfo(PackageUtils.getResourcePackageName(this.context), 0).versionCode;
        } catch (Exception e10) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) e10, false, (h9.a) n8.f3473a, 4, (Object) null);
            i10 = -1;
        }
        getConfigurationCache().put("version_code", Integer.valueOf(i10));
        return i10;
    }

    public final boolean isAdmMessagingRegistrationEnabled() {
        return getBooleanValue("com_braze_push_adm_messaging_registration_enabled", false);
    }

    public final boolean isAutomaticGeofenceRequestsEnabled() {
        return getBooleanValue("com_braze_automatic_geofence_requests_enabled", true);
    }

    public final boolean isContentCardsUnreadVisualIndicatorEnabled() {
        return getBooleanValue("com_braze_content_cards_unread_visual_indicator_enabled", true);
    }

    public final boolean isDeviceObjectAllowlistEnabled() {
        return getBooleanValue("com_braze_device_object_whitelisting_enabled", false);
    }

    public final boolean isEphemeralEventsEnabled() {
        return getBooleanValue("com_braze_ephemeral_events_enabled", false);
    }

    public final boolean isFallbackFirebaseMessagingServiceEnabled() {
        return getBooleanValue("com_braze_fallback_firebase_cloud_messaging_service_enabled", false);
    }

    public final boolean isFirebaseCloudMessagingRegistrationEnabled() {
        return getBooleanValue("com_braze_firebase_cloud_messaging_registration_enabled", false);
    }

    public final boolean isFirebaseMessagingServiceOnNewTokenRegistrationEnabled() {
        return getBooleanValue("com_braze_firebase_messaging_service_automatically_register_on_new_token", isFirebaseCloudMessagingRegistrationEnabled());
    }

    public final boolean isGeofencesEnabled() {
        return getBooleanValue("com_braze_geofences_enabled", isLocationCollectionEnabled());
    }

    public final boolean isHtmlInAppMessageApplyWindowInsetsEnabled() {
        return getBooleanValue("com_braze_html_in_app_message_apply_insets", false);
    }

    public final boolean isHtmlInAppMessageHtmlLinkTargetEnabled() {
        return getBooleanValue("com_braze_html_in_app_message_enable_html_link_target", true);
    }

    public final boolean isInAppMessageAccessibilityExclusiveModeEnabled() {
        return getBooleanValue("com_braze_device_in_app_message_accessibility_exclusive_mode_enabled", false);
    }

    public final boolean isInAppMessageTestPushEagerDisplayEnabled() {
        return getBooleanValue("com_braze_in_app_message_push_test_eager_display_enabled", true);
    }

    public final boolean isLocationCollectionEnabled() {
        return getBooleanValue("com_braze_enable_location_collection", false);
    }

    public final boolean isNewsfeedVisualIndicatorOn() {
        return getBooleanValue("com_braze_newsfeed_unread_visual_indicator_on", true);
    }

    public final boolean isPreventInAppMessageDisplayForDifferentUsersEnabled() {
        return getBooleanValue("com_braze_prevent_in_app_message_display_for_different_user", false);
    }

    public final boolean isPushDeepLinkBackStackActivityEnabled() {
        return getBooleanValue("com_braze_push_deep_link_back_stack_activity_enabled", true);
    }

    public final boolean isPushNotificationHtmlRenderingEnabled() {
        return getBooleanValue("com_braze_push_notification_html_rendering_enabled", false);
    }

    public final boolean isPushWakeScreenForNotificationEnabled() {
        return getBooleanValue("com_braze_push_wake_screen_for_notification_enabled", true);
    }

    public final boolean isSdkAuthenticationEnabled() {
        return getBooleanValue("com_braze_sdk_authentication_enabled", false);
    }

    public final boolean isSessionStartBasedTimeoutEnabled() {
        return getBooleanValue("com_braze_session_start_based_timeout_enabled", false);
    }

    public final boolean isTouchModeRequiredForHtmlInAppMessages() {
        return getBooleanValue("com_braze_require_touch_mode_for_html_in_app_messages", true);
    }
}
