package com.braze.push;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.VisibleForTesting;
import com.braze.Braze;
import com.braze.BrazeInternal;
import com.braze.Constants;
import com.braze.configuration.BrazeConfigurationProvider;
import com.braze.coroutine.BrazeCoroutineScope;
import com.braze.models.push.BrazeNotificationPayload;
import com.braze.support.BrazeLogger;
import h9.a;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import l9.c;
import n9.o;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: BrazePushReceiver.kt */
/* JADX INFO: loaded from: classes2.dex */
public class BrazePushReceiver extends BroadcastReceiver {

    @NotNull
    public static final Companion Companion = new Companion(null);

    /* JADX INFO: compiled from: BrazePushReceiver.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k kVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void handlePush(Context context, Intent intent) {
            Context applicationContext = context.getApplicationContext();
            String action = intent.getAction();
            try {
                handlePush$performWork(action, applicationContext, intent, context);
            } catch (Exception e10) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) e10, false, (a) new BrazePushReceiver$Companion$handlePush$1(action, intent), 4, (Object) null);
            }
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x004a, code lost:
        
            if (r10.equals("hms_push_service_routing_action") == false) goto L52;
         */
        /* JADX WARN: Code restructure failed: missing block: B:19:0x0054, code lost:
        
            if (r10.equals("com.amazon.device.messaging.intent.RECEIVE") == false) goto L52;
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x007a, code lost:
        
            if (r10.equals("com.braze.action.STORY_TRAVERSE") == false) goto L52;
         */
        /* JADX WARN: Code restructure failed: missing block: B:41:0x00a2, code lost:
        
            if (r10.equals("firebase_messaging_service_routing_action") == false) goto L52;
         */
        /* JADX WARN: Code restructure failed: missing block: B:43:0x00a5, code lost:
        
            r9.handlePushNotificationPayload(r11, r12);
         */
        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private static final void handlePush$performWork(java.lang.String r10, android.content.Context r11, android.content.Intent r12, android.content.Context r13) {
            /*
                Method dump skipped, instruction units count: 252
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.braze.push.BrazePushReceiver.Companion.handlePush$performWork(java.lang.String, android.content.Context, android.content.Intent, android.content.Context):void");
        }

        public static /* synthetic */ void handleReceivedIntent$default(Companion companion, Context context, Intent intent, boolean z10, int i10, Object obj) {
            if ((i10 & 4) != 0) {
                z10 = true;
            }
            companion.handleReceivedIntent(context, intent, z10);
        }

        @VisibleForTesting
        @NotNull
        public final BrazeNotificationPayload createPayload(@NotNull Context context, @NotNull BrazeConfigurationProvider appConfigurationProvider, @NotNull Bundle notificationExtras, @NotNull Bundle brazeExtras) {
            t.i(context, "context");
            t.i(appConfigurationProvider, "appConfigurationProvider");
            t.i(notificationExtras, "notificationExtras");
            t.i(brazeExtras, "brazeExtras");
            return Constants.isAmazonDevice() ? new BrazeNotificationPayload(notificationExtras, BrazeNotificationPayload.Companion.getAttachedBrazeExtras(notificationExtras), context, appConfigurationProvider) : new BrazeNotificationPayload(notificationExtras, brazeExtras, context, appConfigurationProvider);
        }

        @VisibleForTesting
        public final boolean handleAdmRegistrationEventIfEnabled(@NotNull BrazeConfigurationProvider appConfigurationProvider, @NotNull Context context, @NotNull Intent intent) {
            t.i(appConfigurationProvider, "appConfigurationProvider");
            t.i(context, "context");
            t.i(intent, "intent");
            BrazeLogger brazeLogger = BrazeLogger.INSTANCE;
            BrazeLogger.brazelog$default(brazeLogger, (Object) this, BrazeLogger.Priority.I, (Throwable) null, false, (a) new BrazePushReceiver$Companion$handleAdmRegistrationEventIfEnabled$1(intent), 6, (Object) null);
            if (!Constants.isAmazonDevice() || !appConfigurationProvider.isAdmMessagingRegistrationEnabled()) {
                BrazeLogger.brazelog$default(brazeLogger, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (a) BrazePushReceiver$Companion$handleAdmRegistrationEventIfEnabled$3.INSTANCE, 6, (Object) null);
                return false;
            }
            BrazeLogger.brazelog$default(brazeLogger, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (a) BrazePushReceiver$Companion$handleAdmRegistrationEventIfEnabled$2.INSTANCE, 7, (Object) null);
            handleAdmRegistrationIntent(context, intent);
            return true;
        }

        @VisibleForTesting
        public final boolean handleAdmRegistrationIntent(@NotNull Context context, @NotNull Intent intent) {
            t.i(context, "context");
            t.i(intent, "intent");
            String stringExtra = intent.getStringExtra("error");
            String stringExtra2 = intent.getStringExtra("error_description");
            String stringExtra3 = intent.getStringExtra("registration_id");
            String stringExtra4 = intent.getStringExtra("unregistered");
            if (stringExtra != null) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (a) new BrazePushReceiver$Companion$handleAdmRegistrationIntent$1(stringExtra, stringExtra2), 6, (Object) null);
                return true;
            }
            if (stringExtra3 != null) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.I, (Throwable) null, false, (a) new BrazePushReceiver$Companion$handleAdmRegistrationIntent$2(stringExtra3), 6, (Object) null);
                Braze.Companion.getInstance(context).setRegisteredPushToken(stringExtra3);
                return true;
            }
            if (stringExtra4 != null) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (a) new BrazePushReceiver$Companion$handleAdmRegistrationIntent$3(stringExtra4), 6, (Object) null);
                return true;
            }
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (a) BrazePushReceiver$Companion$handleAdmRegistrationIntent$4.INSTANCE, 6, (Object) null);
            return false;
        }

        /* JADX WARN: Removed duplicated region for block: B:45:0x0145  */
        @androidx.annotation.VisibleForTesting
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final boolean handlePushNotificationPayload(@org.jetbrains.annotations.NotNull android.content.Context r19, @org.jetbrains.annotations.NotNull android.content.Intent r20) {
            /*
                Method dump skipped, instruction units count: 454
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.braze.push.BrazePushReceiver.Companion.handlePushNotificationPayload(android.content.Context, android.content.Intent):boolean");
        }

        public final void handleReceivedIntent(@NotNull Context context, @NotNull Intent intent, boolean z10) {
            t.i(context, "context");
            t.i(intent, "intent");
            if (z10) {
                kotlinx.coroutines.k.d(BrazeCoroutineScope.INSTANCE, null, null, new BrazePushReceiver$Companion$handleReceivedIntent$1(context, intent, null), 3, null);
            } else {
                handlePush(context, intent);
            }
        }

        @VisibleForTesting
        public final void logNotificationMetadata$android_sdk_ui_release(@NotNull Context context, @NotNull BrazeNotificationPayload payload) {
            String campaignId;
            t.i(context, "context");
            t.i(payload, "payload");
            if (payload.isPushDeliveryEnabled() && (campaignId = payload.getCampaignId()) != null) {
                long jF = o.f(payload.getFlushMinMinutes(), 0L);
                long jF2 = o.f(payload.getFlushMaxMinutes(), jF);
                TimeUnit timeUnit = TimeUnit.MINUTES;
                long millis = timeUnit.toMillis(jF);
                if (jF2 > jF) {
                    millis = c.f30972a.h(millis, timeUnit.toMillis(jF2));
                }
                BrazeInternal.INSTANCE.logPushDelivery(context, campaignId, millis);
            }
            String campaignId2 = payload.getCampaignId();
            if (campaignId2 != null) {
                BrazeInternal.INSTANCE.logPushCampaign(context, campaignId2);
            }
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(@NotNull Context context, @NotNull Intent intent) {
        t.i(context, "context");
        t.i(intent, "intent");
        Companion.handleReceivedIntent$default(Companion, context, intent, false, 4, null);
    }
}
