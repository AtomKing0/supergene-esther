package com.braze;

import android.content.Context;
import android.content.Intent;
import com.braze.configuration.BrazeConfigurationProvider;
import com.braze.enums.BrazePushEventType;
import com.braze.enums.GeofenceTransitionType;
import com.braze.events.InAppMessageEvent;
import com.braze.models.IBrazeLocation;
import com.braze.models.push.BrazeNotificationPayload;

/* JADX INFO: loaded from: classes2.dex */
public final class BrazeInternal {
    public static final BrazeInternal INSTANCE = new BrazeInternal();

    private BrazeInternal() {
    }

    public static final void addSerializedContentCardToStorage(Context context, String serializedCardJson, String str) {
        kotlin.jvm.internal.t.i(context, "context");
        kotlin.jvm.internal.t.i(serializedCardJson, "serializedCardJson");
        INSTANCE.getInstance(context).addSerializedCardJsonToStorage$android_sdk_base_release(serializedCardJson, str);
    }

    public static final void applyPendingRuntimeConfiguration(Context context) {
        kotlin.jvm.internal.t.i(context, "context");
        INSTANCE.getInstance(context).applyPendingRuntimeConfiguration$android_sdk_base_release();
    }

    private final Braze getInstance(Context context) {
        return Braze.Companion.getInstance(context);
    }

    public static final void handleInAppMessageTestPush(Context context, Intent intent) {
        kotlin.jvm.internal.t.i(context, "context");
        kotlin.jvm.internal.t.i(intent, "intent");
        INSTANCE.getInstance(context).handleInAppMessageTestPush$android_sdk_base_release(intent);
    }

    public static final void logLocationRecordedEvent(Context context, IBrazeLocation location) {
        kotlin.jvm.internal.t.i(context, "context");
        kotlin.jvm.internal.t.i(location, "location");
        INSTANCE.getInstance(context).logLocationRecordedEventFromLocationUpdate$android_sdk_base_release(location);
    }

    public static final void recordGeofenceTransition(Context context, String geofenceId, GeofenceTransitionType transitionType) {
        kotlin.jvm.internal.t.i(context, "context");
        kotlin.jvm.internal.t.i(geofenceId, "geofenceId");
        kotlin.jvm.internal.t.i(transitionType, "transitionType");
        INSTANCE.getInstance(context).recordGeofenceTransition$android_sdk_base_release(geofenceId, transitionType);
    }

    public static final void refreshFeatureFlags(Context context) {
        kotlin.jvm.internal.t.i(context, "context");
        INSTANCE.getInstance(context).refreshFeatureFlags();
    }

    public static final void requestGeofenceRefresh(Context context, boolean z10) {
        kotlin.jvm.internal.t.i(context, "context");
        INSTANCE.getInstance(context).requestGeofenceRefresh$android_sdk_base_release(z10);
    }

    public static final void retryInAppMessage(Context context, InAppMessageEvent inAppMessageEvent) {
        kotlin.jvm.internal.t.i(context, "context");
        kotlin.jvm.internal.t.i(inAppMessageEvent, "inAppMessageEvent");
        INSTANCE.getInstance(context).retryInAppMessage$android_sdk_base_release(inAppMessageEvent);
    }

    public final BrazeConfigurationProvider getConfigurationProvider(Context context) {
        kotlin.jvm.internal.t.i(context, "context");
        return getInstance(context).getConfigurationProviderSafe$android_sdk_base_release(context);
    }

    public final /* synthetic */ void logPushCampaign(Context context, String campaignId) {
        kotlin.jvm.internal.t.i(context, "context");
        kotlin.jvm.internal.t.i(campaignId, "campaignId");
        getInstance(context).logPushMaxCampaign$android_sdk_base_release(campaignId);
    }

    public final /* synthetic */ void logPushDelivery(Context context, String campaignId, long j10) {
        kotlin.jvm.internal.t.i(context, "context");
        kotlin.jvm.internal.t.i(campaignId, "campaignId");
        getInstance(context).logPushDelivery$android_sdk_base_release(campaignId, j10);
    }

    public final /* synthetic */ void performPushDeliveryFlush(Context context) {
        kotlin.jvm.internal.t.i(context, "context");
        getInstance(context).performPushDeliveryFlush$android_sdk_base_release();
    }

    public final /* synthetic */ void publishBrazePushAction(Context context, BrazePushEventType pushActionType, BrazeNotificationPayload payload) {
        kotlin.jvm.internal.t.i(context, "context");
        kotlin.jvm.internal.t.i(pushActionType, "pushActionType");
        kotlin.jvm.internal.t.i(payload, "payload");
        getInstance(context).publishBrazePushAction$android_sdk_base_release(pushActionType, payload);
    }

    public final void reenqueueInAppMessage(Context context, InAppMessageEvent inAppMessageEvent) {
        kotlin.jvm.internal.t.i(context, "context");
        kotlin.jvm.internal.t.i(inAppMessageEvent, "inAppMessageEvent");
        getInstance(context).reenqueueInAppMessage$android_sdk_base_release(inAppMessageEvent);
    }

    public final /* synthetic */ boolean validateAndStorePushId(Context context, String pushId) {
        kotlin.jvm.internal.t.i(context, "context");
        kotlin.jvm.internal.t.i(pushId, "pushId");
        return getInstance(context).validateAndStorePushId$android_sdk_base_release(pushId);
    }
}
