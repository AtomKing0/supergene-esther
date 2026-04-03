package com.braze.push;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.UiModeManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.PowerManager;
import android.os.SystemClock;
import androidx.core.app.NotificationCompat;
import androidx.media3.exoplayer.upstream.CmcdConfiguration;
import androidx.media3.exoplayer.upstream.CmcdData;
import com.braze.Braze;
import com.braze.BrazeInternal;
import com.braze.Constants;
import com.braze.IBrazeNotificationFactory;
import com.braze.configuration.BrazeConfigurationProvider;
import com.braze.enums.BrazePushEventType;
import com.braze.enums.BrazeViewBounds;
import com.braze.enums.Channel;
import com.braze.models.push.BrazeNotificationPayload;
import com.braze.push.support.HtmlUtils;
import com.braze.support.BrazeLogger;
import com.braze.support.IntentUtils;
import com.braze.support.JsonUtils;
import com.braze.support.PermissionUtils;
import com.braze.ui.BrazeDeeplinkHandler;
import com.braze.ui.actions.UriAction;
import com.braze.ui.support.UriUtils;
import h9.a;
import io.sentry.protocol.TransactionInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p9.q;

/* JADX INFO: compiled from: BrazeNotificationUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class BrazeNotificationUtils {

    @NotNull
    public static final BrazeNotificationUtils INSTANCE = new BrazeNotificationUtils();

    @NotNull
    private static final String TAG = BrazeLogger.getBrazeLogTag((Class<?>) BrazeNotificationUtils.class);

    /* JADX INFO: compiled from: BrazeNotificationUtils.kt */
    private enum BrazeNotificationBroadcastType {
        OPENED(BrazePushEventType.NOTIFICATION_OPENED),
        RECEIVED(BrazePushEventType.NOTIFICATION_RECEIVED),
        DELETED(BrazePushEventType.NOTIFICATION_DELETED);


        @NotNull
        private final BrazePushEventType brazePushEventType;

        BrazeNotificationBroadcastType(BrazePushEventType brazePushEventType) {
            this.brazePushEventType = brazePushEventType;
        }

        @NotNull
        public final BrazePushEventType getBrazePushEventType() {
            return this.brazePushEventType;
        }
    }

    /* JADX INFO: compiled from: BrazeNotificationUtils.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[BrazeNotificationBroadcastType.values().length];
            try {
                iArr[BrazeNotificationBroadcastType.OPENED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[BrazeNotificationBroadcastType.RECEIVED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[BrazeNotificationBroadcastType.DELETED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: renamed from: com.braze.push.BrazeNotificationUtils$cancelNotification$1, reason: invalid class name */
    /* JADX INFO: compiled from: BrazeNotificationUtils.kt */
    static final class AnonymousClass1 extends v implements a<String> {
        final /* synthetic */ int $notificationId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(int i10) {
            super(0);
            this.$notificationId = i10;
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Cancelling notification action with id: " + this.$notificationId;
        }
    }

    /* JADX INFO: renamed from: com.braze.push.BrazeNotificationUtils$cancelNotification$2, reason: invalid class name */
    /* JADX INFO: compiled from: BrazeNotificationUtils.kt */
    static final class AnonymousClass2 extends v implements a<String> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        AnonymousClass2() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Exception occurred attempting to cancel notification.";
        }
    }

    /* JADX INFO: renamed from: com.braze.push.BrazeNotificationUtils$getNotificationId$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BrazeNotificationUtils.kt */
    static final class C10831 extends v implements a<String> {
        final /* synthetic */ Integer $customNotificationId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C10831(Integer num) {
            super(0);
            this.$customNotificationId = num;
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Using notification id provided in the message's extras bundle: " + this.$customNotificationId;
        }
    }

    /* JADX INFO: renamed from: com.braze.push.BrazeNotificationUtils$getNotificationId$4, reason: invalid class name */
    /* JADX INFO: compiled from: BrazeNotificationUtils.kt */
    static final class AnonymousClass4 extends v implements a<String> {
        final /* synthetic */ int $notificationId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass4(int i10) {
            super(0);
            this.$notificationId = i10;
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Message without notification id provided in the extras bundle received. Using a hash of the message: " + this.$notificationId;
        }
    }

    /* JADX INFO: renamed from: com.braze.push.BrazeNotificationUtils$getOrCreateNotificationChannelId$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BrazeNotificationUtils.kt */
    static final class C10841 extends v implements a<String> {
        final /* synthetic */ String $channelIdFromExtras;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C10841(String str) {
            super(0);
            this.$channelIdFromExtras = str;
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Found notification channel in extras with id: " + this.$channelIdFromExtras;
        }
    }

    /* JADX INFO: renamed from: com.braze.push.BrazeNotificationUtils$getOrCreateNotificationChannelId$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BrazeNotificationUtils.kt */
    static final class C10852 extends v implements a<String> {
        final /* synthetic */ String $channelIdFromExtras;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C10852(String str) {
            super(0);
            this.$channelIdFromExtras = str;
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Notification channel from extras is invalid. No channel found with id: " + this.$channelIdFromExtras;
        }
    }

    /* JADX INFO: renamed from: com.braze.push.BrazeNotificationUtils$getOrCreateNotificationChannelId$3, reason: invalid class name */
    /* JADX INFO: compiled from: BrazeNotificationUtils.kt */
    static final class AnonymousClass3 extends v implements a<String> {
        public static final AnonymousClass3 INSTANCE = new AnonymousClass3();

        AnonymousClass3() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Braze default notification channel does not exist on device. Creating default channel.";
        }
    }

    /* JADX INFO: renamed from: com.braze.push.BrazeNotificationUtils$getValidNotificationChannel$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BrazeNotificationUtils.kt */
    static final class C10861 extends v implements a<String> {
        public static final C10861 INSTANCE = new C10861();

        C10861() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Notification extras bundle was null. Could not find a valid notification channel";
        }
    }

    /* JADX INFO: renamed from: com.braze.push.BrazeNotificationUtils$getValidNotificationChannel$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BrazeNotificationUtils.kt */
    static final class C10872 extends v implements a<String> {
        final /* synthetic */ String $channelIdFromExtras;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C10872(String str) {
            super(0);
            this.$channelIdFromExtras = str;
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Found notification channel in extras with id: " + this.$channelIdFromExtras;
        }
    }

    /* JADX INFO: renamed from: com.braze.push.BrazeNotificationUtils$getValidNotificationChannel$3, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BrazeNotificationUtils.kt */
    static final class C10883 extends v implements a<String> {
        final /* synthetic */ String $channelIdFromExtras;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C10883(String str) {
            super(0);
            this.$channelIdFromExtras = str;
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Notification channel from extras is invalid, no channel found with id: " + this.$channelIdFromExtras;
        }
    }

    /* JADX INFO: renamed from: com.braze.push.BrazeNotificationUtils$getValidNotificationChannel$4, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BrazeNotificationUtils.kt */
    static final class C10894 extends v implements a<String> {
        public static final C10894 INSTANCE = new C10894();

        C10894() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Braze default notification channel does not exist on device.";
        }
    }

    /* JADX INFO: renamed from: com.braze.push.BrazeNotificationUtils$handleCancelNotificationAction$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BrazeNotificationUtils.kt */
    static final class C10901 extends v implements a<String> {
        final /* synthetic */ int $notificationId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C10901(int i10) {
            super(0);
            this.$notificationId = i10;
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Cancelling notification action with id: " + this.$notificationId;
        }
    }

    /* JADX INFO: renamed from: com.braze.push.BrazeNotificationUtils$handleCancelNotificationAction$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BrazeNotificationUtils.kt */
    static final class C10912 extends v implements a<String> {
        public static final C10912 INSTANCE = new C10912();

        C10912() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Exception occurred handling cancel notification intent.";
        }
    }

    /* JADX INFO: renamed from: com.braze.push.BrazeNotificationUtils$handleContentCardsSerializedCardIfPresent$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BrazeNotificationUtils.kt */
    static final class C10921 extends v implements a<String> {
        final /* synthetic */ String $contentCardData;
        final /* synthetic */ String $contentCardDataUserId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C10921(String str, String str2) {
            super(0);
            this.$contentCardDataUserId = str;
            this.$contentCardData = str2;
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Push contains associated Content Cards card. User id: " + this.$contentCardDataUserId + " Card data: " + this.$contentCardData;
        }
    }

    /* JADX INFO: renamed from: com.braze.push.BrazeNotificationUtils$handleNotificationDeleted$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BrazeNotificationUtils.kt */
    static final class C10931 extends v implements a<String> {
        public static final C10931 INSTANCE = new C10931();

        C10931() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Sending notification deleted broadcast";
        }
    }

    /* JADX INFO: renamed from: com.braze.push.BrazeNotificationUtils$handleNotificationDeleted$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BrazeNotificationUtils.kt */
    static final class C10942 extends v implements a<String> {
        public static final C10942 INSTANCE = new C10942();

        C10942() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Exception occurred attempting to handle notification delete intent.";
        }
    }

    /* JADX INFO: renamed from: com.braze.push.BrazeNotificationUtils$handleNotificationOpened$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BrazeNotificationUtils.kt */
    static final class C10951 extends v implements a<String> {
        public static final C10951 INSTANCE = new C10951();

        C10951() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Not handling deep links automatically, skipping deep link handling";
        }
    }

    /* JADX INFO: renamed from: com.braze.push.BrazeNotificationUtils$handleNotificationOpened$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BrazeNotificationUtils.kt */
    static final class C10962 extends v implements a<String> {
        public static final C10962 INSTANCE = new C10962();

        C10962() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Exception occurred attempting to handle notification opened intent.";
        }
    }

    /* JADX INFO: renamed from: com.braze.push.BrazeNotificationUtils$handlePushStoryPageClicked$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BrazeNotificationUtils.kt */
    static final class C10971 extends v implements a<String> {
        final /* synthetic */ String $deepLink;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C10971(String str) {
            super(0);
            this.$deepLink = str;
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Not handling deep links automatically, skipping deep link handling for '" + this.$deepLink + '\'';
        }
    }

    /* JADX INFO: renamed from: com.braze.push.BrazeNotificationUtils$handlePushStoryPageClicked$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BrazeNotificationUtils.kt */
    static final class C10982 extends v implements a<String> {
        public static final C10982 INSTANCE = new C10982();

        C10982() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Caught exception while handling story click.";
        }
    }

    /* JADX INFO: renamed from: com.braze.push.BrazeNotificationUtils$refreshFeatureFlagsIfAppropriate$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BrazeNotificationUtils.kt */
    static final class C10991 extends v implements a<String> {
        public static final C10991 INSTANCE = new C10991();

        C10991() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Feature flag refresh key was true. Refreshing feature flags.";
        }
    }

    /* JADX INFO: renamed from: com.braze.push.BrazeNotificationUtils$refreshFeatureFlagsIfAppropriate$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BrazeNotificationUtils.kt */
    static final class C11002 extends v implements a<String> {
        public static final C11002 INSTANCE = new C11002();

        C11002() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Feature flag refresh key not included in push payload or false. Not refreshing feature flags.";
        }
    }

    /* JADX INFO: renamed from: com.braze.push.BrazeNotificationUtils$requestGeofenceRefreshIfAppropriate$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BrazeNotificationUtils.kt */
    static final class C11011 extends v implements a<String> {
        public static final C11011 INSTANCE = new C11011();

        C11011() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Geofence sync key was true. Syncing geofences.";
        }
    }

    /* JADX INFO: renamed from: com.braze.push.BrazeNotificationUtils$requestGeofenceRefreshIfAppropriate$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BrazeNotificationUtils.kt */
    static final class C11022 extends v implements a<String> {
        public static final C11022 INSTANCE = new C11022();

        C11022() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Geofence sync key not included in push payload or false. Not syncing geofences.";
        }
    }

    /* JADX INFO: renamed from: com.braze.push.BrazeNotificationUtils$routeUserWithNotificationOpenedIntent$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BrazeNotificationUtils.kt */
    static final class C11031 extends v implements a<String> {
        public static final C11031 INSTANCE = new C11031();

        C11031() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "routeUserWithNotificationOpenedIntent called with Intent";
        }
    }

    /* JADX INFO: renamed from: com.braze.push.BrazeNotificationUtils$routeUserWithNotificationOpenedIntent$3, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BrazeNotificationUtils.kt */
    static final class C11043 extends v implements a<String> {
        final /* synthetic */ String $deepLink;
        final /* synthetic */ boolean $useWebView;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C11043(String str, boolean z10) {
            super(0);
            this.$deepLink = str;
            this.$useWebView = z10;
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Found a deep link: " + this.$deepLink + ". Use webview set to: " + this.$useWebView;
        }
    }

    /* JADX INFO: renamed from: com.braze.push.BrazeNotificationUtils$routeUserWithNotificationOpenedIntent$5, reason: invalid class name */
    /* JADX INFO: compiled from: BrazeNotificationUtils.kt */
    static final class AnonymousClass5 extends v implements a<String> {
        final /* synthetic */ Intent $mainActivityIntent;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass5(Intent intent) {
            super(0);
            this.$mainActivityIntent = intent;
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Push notification had no deep link. Opening main activity: " + this.$mainActivityIntent;
        }
    }

    /* JADX INFO: renamed from: com.braze.push.BrazeNotificationUtils$sendNotificationOpenedBroadcast$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BrazeNotificationUtils.kt */
    static final class C11051 extends v implements a<String> {
        public static final C11051 INSTANCE = new C11051();

        C11051() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Sending notification opened broadcast";
        }
    }

    /* JADX INFO: renamed from: com.braze.push.BrazeNotificationUtils$sendPushActionIntent$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BrazeNotificationUtils.kt */
    static final class C11061 extends v implements a<String> {
        final /* synthetic */ BrazeNotificationBroadcastType $broadcastType;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C11061(BrazeNotificationBroadcastType brazeNotificationBroadcastType) {
            super(0);
            this.$broadcastType = brazeNotificationBroadcastType;
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Sending Braze broadcast receiver intent for " + this.$broadcastType;
        }
    }

    /* JADX INFO: renamed from: com.braze.push.BrazeNotificationUtils$sendPushActionIntent$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BrazeNotificationUtils.kt */
    static final class C11072 extends v implements a<String> {
        final /* synthetic */ Intent $pushIntent;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C11072(Intent intent) {
            super(0);
            this.$pushIntent = intent;
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Sending push action intent: " + this.$pushIntent;
        }
    }

    /* JADX INFO: renamed from: com.braze.push.BrazeNotificationUtils$sendPushMessageReceivedBroadcast$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BrazeNotificationUtils.kt */
    static final class C11081 extends v implements a<String> {
        public static final C11081 INSTANCE = new C11081();

        C11081() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Sending push message received broadcast";
        }
    }

    /* JADX INFO: renamed from: com.braze.push.BrazeNotificationUtils$setAccentColorIfPresentAndSupported$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BrazeNotificationUtils.kt */
    static final class C11091 extends v implements a<String> {
        public static final C11091 INSTANCE = new C11091();

        C11091() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Using accent color for notification from extras bundle";
        }
    }

    /* JADX INFO: renamed from: com.braze.push.BrazeNotificationUtils$setCategoryIfPresentAndSupported$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BrazeNotificationUtils.kt */
    static final class C11101 extends v implements a<String> {
        public static final C11101 INSTANCE = new C11101();

        C11101() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Setting category for notification";
        }
    }

    /* JADX INFO: renamed from: com.braze.push.BrazeNotificationUtils$setCategoryIfPresentAndSupported$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BrazeNotificationUtils.kt */
    static final class C11112 extends v implements a<String> {
        public static final C11112 INSTANCE = new C11112();

        C11112() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Category not present in notification extras. Not setting category for notification.";
        }
    }

    /* JADX INFO: renamed from: com.braze.push.BrazeNotificationUtils$setContentIfPresent$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BrazeNotificationUtils.kt */
    static final class C11121 extends v implements a<String> {
        public static final C11121 INSTANCE = new C11121();

        C11121() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Setting content for notification";
        }
    }

    /* JADX INFO: renamed from: com.braze.push.BrazeNotificationUtils$setContentIntentIfPresent$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BrazeNotificationUtils.kt */
    static final class C11131 extends v implements a<String> {
        public static final C11131 INSTANCE = new C11131();

        C11131() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Error setting content intent.";
        }
    }

    /* JADX INFO: renamed from: com.braze.push.BrazeNotificationUtils$setDeleteIntent$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BrazeNotificationUtils.kt */
    static final class C11141 extends v implements a<String> {
        public static final C11141 INSTANCE = new C11141();

        C11141() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Error setting delete intent.";
        }
    }

    /* JADX INFO: renamed from: com.braze.push.BrazeNotificationUtils$setLargeIconIfPresentAndSupported$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BrazeNotificationUtils.kt */
    static final class C11151 extends v implements a<String> {
        public static final C11151 INSTANCE = new C11151();

        C11151() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Large icon not supported in story push.";
        }
    }

    /* JADX INFO: renamed from: com.braze.push.BrazeNotificationUtils$setLargeIconIfPresentAndSupported$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BrazeNotificationUtils.kt */
    static final class C11162 extends v implements a<String> {
        public static final C11162 INSTANCE = new C11162();

        C11162() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Setting large icon for notification";
        }
    }

    /* JADX INFO: renamed from: com.braze.push.BrazeNotificationUtils$setLargeIconIfPresentAndSupported$4, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BrazeNotificationUtils.kt */
    static final class C11174 extends v implements a<String> {
        public static final C11174 INSTANCE = new C11174();

        C11174() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Large icon bitmap url not present in extras. Attempting to use resource id instead.";
        }
    }

    /* JADX INFO: renamed from: com.braze.push.BrazeNotificationUtils$setLargeIconIfPresentAndSupported$5, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BrazeNotificationUtils.kt */
    static final class C11185 extends v implements a<String> {
        public static final C11185 INSTANCE = new C11185();

        C11185() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Large icon resource id not present for notification";
        }
    }

    /* JADX INFO: renamed from: com.braze.push.BrazeNotificationUtils$setLargeIconIfPresentAndSupported$6, reason: invalid class name */
    /* JADX INFO: compiled from: BrazeNotificationUtils.kt */
    static final class AnonymousClass6 extends v implements a<String> {
        public static final AnonymousClass6 INSTANCE = new AnonymousClass6();

        AnonymousClass6() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Error setting large notification icon";
        }
    }

    /* JADX INFO: renamed from: com.braze.push.BrazeNotificationUtils$setLargeIconIfPresentAndSupported$7, reason: invalid class name */
    /* JADX INFO: compiled from: BrazeNotificationUtils.kt */
    static final class AnonymousClass7 extends v implements a<String> {
        public static final AnonymousClass7 INSTANCE = new AnonymousClass7();

        AnonymousClass7() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Large icon not set for notification";
        }
    }

    /* JADX INFO: renamed from: com.braze.push.BrazeNotificationUtils$setNotificationBadgeNumberIfPresent$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BrazeNotificationUtils.kt */
    static final class C11191 extends v implements a<String> {
        public static final C11191 INSTANCE = new C11191();

        C11191() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Notification badge number not supported on this android version. Not setting badge number for notification.";
        }
    }

    /* JADX INFO: renamed from: com.braze.push.BrazeNotificationUtils$setNotificationDurationAlarm$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BrazeNotificationUtils.kt */
    static final class C11201 extends v implements a<String> {
        final /* synthetic */ int $durationInMillis;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C11201(int i10) {
            super(0);
            this.$durationInMillis = i10;
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Setting Notification duration alarm for " + this.$durationInMillis + " ms";
        }
    }

    /* JADX INFO: renamed from: com.braze.push.BrazeNotificationUtils$setPriorityIfPresentAndSupported$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BrazeNotificationUtils.kt */
    static final class C11211 extends v implements a<String> {
        public static final C11211 INSTANCE = new C11211();

        C11211() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Setting priority for notification";
        }
    }

    /* JADX INFO: renamed from: com.braze.push.BrazeNotificationUtils$setPublicVersionIfPresentAndSupported$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BrazeNotificationUtils.kt */
    static final class C11222 extends v implements a<String> {
        final /* synthetic */ BrazeNotificationPayload $publicPayload;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C11222(BrazeNotificationPayload brazeNotificationPayload) {
            super(0);
            this.$publicPayload = brazeNotificationPayload;
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Setting public version of notification with payload: " + this.$publicPayload;
        }
    }

    /* JADX INFO: renamed from: com.braze.push.BrazeNotificationUtils$setSetShowWhen$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BrazeNotificationUtils.kt */
    static final class C11231 extends v implements a<String> {
        public static final C11231 INSTANCE = new C11231();

        C11231() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Set show when not supported in story push.";
        }
    }

    /* JADX INFO: renamed from: com.braze.push.BrazeNotificationUtils$setSmallIcon$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BrazeNotificationUtils.kt */
    static final class C11241 extends v implements a<String> {
        public static final C11241 INSTANCE = new C11241();

        C11241() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Small notification icon resource was not found. Will use the app icon when displaying notifications.";
        }
    }

    /* JADX INFO: renamed from: com.braze.push.BrazeNotificationUtils$setSmallIcon$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BrazeNotificationUtils.kt */
    static final class C11252 extends v implements a<String> {
        public static final C11252 INSTANCE = new C11252();

        C11252() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Setting small icon for notification via resource id";
        }
    }

    /* JADX INFO: renamed from: com.braze.push.BrazeNotificationUtils$setSoundIfPresentAndSupported$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BrazeNotificationUtils.kt */
    static final class C11261 extends v implements a<String> {
        public static final C11261 INSTANCE = new C11261();

        C11261() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Setting default sound for notification.";
        }
    }

    /* JADX INFO: renamed from: com.braze.push.BrazeNotificationUtils$setSoundIfPresentAndSupported$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BrazeNotificationUtils.kt */
    static final class C11272 extends v implements a<String> {
        public static final C11272 INSTANCE = new C11272();

        C11272() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Setting sound for notification via uri.";
        }
    }

    /* JADX INFO: renamed from: com.braze.push.BrazeNotificationUtils$setSummaryTextIfPresentAndSupported$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BrazeNotificationUtils.kt */
    static final class C11281 extends v implements a<String> {
        public static final C11281 INSTANCE = new C11281();

        C11281() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Setting summary text for notification";
        }
    }

    /* JADX INFO: renamed from: com.braze.push.BrazeNotificationUtils$setSummaryTextIfPresentAndSupported$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BrazeNotificationUtils.kt */
    static final class C11292 extends v implements a<String> {
        public static final C11292 INSTANCE = new C11292();

        C11292() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Summary text not present. Not setting summary text for notification.";
        }
    }

    /* JADX INFO: renamed from: com.braze.push.BrazeNotificationUtils$setTickerIfPresent$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BrazeNotificationUtils.kt */
    static final class C11301 extends v implements a<String> {
        public static final C11301 INSTANCE = new C11301();

        C11301() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Setting ticker for notification";
        }
    }

    /* JADX INFO: renamed from: com.braze.push.BrazeNotificationUtils$setTitleIfPresent$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BrazeNotificationUtils.kt */
    static final class C11311 extends v implements a<String> {
        public static final C11311 INSTANCE = new C11311();

        C11311() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Setting title for notification";
        }
    }

    /* JADX INFO: renamed from: com.braze.push.BrazeNotificationUtils$setVisibilityIfPresentAndSupported$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BrazeNotificationUtils.kt */
    static final class C11321 extends v implements a<String> {
        public static final C11321 INSTANCE = new C11321();

        C11321() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Setting visibility for notification";
        }
    }

    /* JADX INFO: renamed from: com.braze.push.BrazeNotificationUtils$setVisibilityIfPresentAndSupported$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BrazeNotificationUtils.kt */
    static final class C11332 extends v implements a<String> {
        final /* synthetic */ Integer $visibility;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C11332(Integer num) {
            super(0);
            this.$visibility = num;
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Received invalid notification visibility " + this.$visibility;
        }
    }

    /* JADX INFO: renamed from: com.braze.push.BrazeNotificationUtils$wakeScreenIfAppropriate$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BrazeNotificationUtils.kt */
    static final class C11341 extends v implements a<String> {
        public static final C11341 INSTANCE = new C11341();

        C11341() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Not waking this TV UI mode device";
        }
    }

    /* JADX INFO: renamed from: com.braze.push.BrazeNotificationUtils$wakeScreenIfAppropriate$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BrazeNotificationUtils.kt */
    static final class C11352 extends v implements a<String> {
        public static final C11352 INSTANCE = new C11352();

        C11352() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Failed to check for TV status during screen wake. Continuing.";
        }
    }

    /* JADX INFO: renamed from: com.braze.push.BrazeNotificationUtils$wakeScreenIfAppropriate$3, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BrazeNotificationUtils.kt */
    static final class C11363 extends v implements a<String> {
        public static final C11363 INSTANCE = new C11363();

        C11363() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Not waking screen on Android O+ device, could not find notification channel.";
        }
    }

    /* JADX INFO: renamed from: com.braze.push.BrazeNotificationUtils$wakeScreenIfAppropriate$4, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BrazeNotificationUtils.kt */
    static final class C11374 extends v implements a<String> {
        final /* synthetic */ NotificationChannel $notificationChannel;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C11374(NotificationChannel notificationChannel) {
            super(0);
            this.$notificationChannel = notificationChannel;
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Not acquiring wake-lock for Android O+ notification with importance: " + this.$notificationChannel.getImportance();
        }
    }

    /* JADX INFO: renamed from: com.braze.push.BrazeNotificationUtils$wakeScreenIfAppropriate$5, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BrazeNotificationUtils.kt */
    static final class C11385 extends v implements a<String> {
        public static final C11385 INSTANCE = new C11385();

        C11385() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Waking screen for notification";
        }
    }

    private BrazeNotificationUtils() {
    }

    public static final void cancelNotification(@NotNull Context context, int i10) {
        t.i(context, "context");
        try {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, (BrazeLogger.Priority) null, (Throwable) null, false, (a) new AnonymousClass1(i10), 7, (Object) null);
            Intent intent = new Intent("com.braze.action.CANCEL_NOTIFICATION").setClass(context, getNotificationReceiverClass());
            t.h(intent, "Intent(Constants.BRAZE_C…otificationReceiverClass)");
            intent.setPackage(context.getPackageName());
            intent.putExtra("nid", i10);
            IntentUtils.addComponentAndSendBroadcast(context, intent);
        } catch (Exception e10) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, BrazeLogger.Priority.E, (Throwable) e10, false, (a) AnonymousClass2.INSTANCE, 4, (Object) null);
        }
    }

    @NotNull
    public static final IBrazeNotificationFactory getActiveNotificationFactory() {
        IBrazeNotificationFactory customBrazeNotificationFactory = Braze.Companion.getCustomBrazeNotificationFactory();
        return customBrazeNotificationFactory == null ? BrazeNotificationFactory.Companion.getInstance() : customBrazeNotificationFactory;
    }

    public static final int getNotificationId(@NotNull BrazeNotificationPayload payload) {
        t.i(payload, "payload");
        Integer customNotificationId = payload.getCustomNotificationId();
        if (customNotificationId != null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, (BrazeLogger.Priority) null, (Throwable) null, false, (a) new C10831(customNotificationId), 7, (Object) null);
            return customNotificationId.intValue();
        }
        String titleText = payload.getTitleText();
        String str = "";
        if (titleText != null) {
            str = "" + titleText;
        }
        String contentText = payload.getContentText();
        if (contentText != null) {
            str = str + contentText;
        }
        int iHashCode = str != null ? str.hashCode() : 0;
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, (BrazeLogger.Priority) null, (Throwable) null, false, (a) new AnonymousClass4(iHashCode), 7, (Object) null);
        return iHashCode;
    }

    public static final int getNotificationPriority(@NotNull BrazeNotificationPayload payload) {
        t.i(payload, "payload");
        Integer notificationPriorityInt = payload.getNotificationPriorityInt();
        Integer notificationPriorityInt2 = payload.getNotificationPriorityInt();
        if (notificationPriorityInt2 != null) {
            int iIntValue = notificationPriorityInt2.intValue();
            if (-2 <= iIntValue && iIntValue < 3) {
                return iIntValue;
            }
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, BrazeLogger.Priority.W, (Throwable) null, false, (a) new BrazeNotificationUtils$getNotificationPriority$1$1(notificationPriorityInt), 6, (Object) null);
        }
        return 0;
    }

    @NotNull
    public static final Class<?> getNotificationReceiverClass() {
        return Constants.isAmazonDevice() ? BrazeAmazonDeviceMessagingReceiver.class : BrazePushReceiver.class;
    }

    @NotNull
    public static final String getOrCreateNotificationChannelId(@NotNull BrazeNotificationPayload payload) {
        t.i(payload, "payload");
        String notificationChannelId = payload.getNotificationChannelId();
        if (Build.VERSION.SDK_INT < 26) {
            return notificationChannelId == null ? "com_appboy_default_notification_channel" : notificationChannelId;
        }
        Context context = payload.getContext();
        BrazeConfigurationProvider configurationProvider = payload.getConfigurationProvider();
        Object systemService = context != null ? context.getSystemService("notification") : null;
        t.g(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
        NotificationManager notificationManager = (NotificationManager) systemService;
        if (notificationChannelId != null) {
            if (notificationManager.getNotificationChannel(notificationChannelId) != null) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, (BrazeLogger.Priority) null, (Throwable) null, false, (a) new C10841(notificationChannelId), 7, (Object) null);
                return notificationChannelId;
            }
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, (BrazeLogger.Priority) null, (Throwable) null, false, (a) new C10852(notificationChannelId), 7, (Object) null);
        }
        if (notificationManager.getNotificationChannel("com_appboy_default_notification_channel") == null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, (BrazeLogger.Priority) null, (Throwable) null, false, (a) AnonymousClass3.INSTANCE, 7, (Object) null);
            NotificationChannel notificationChannel = new NotificationChannel("com_appboy_default_notification_channel", configurationProvider != null ? configurationProvider.getDefaultNotificationChannelName() : null, 3);
            notificationChannel.setDescription(configurationProvider != null ? configurationProvider.getDefaultNotificationChannelDescription() : null);
            notificationManager.createNotificationChannel(notificationChannel);
        }
        return "com_appboy_default_notification_channel";
    }

    private final PendingIntent getPushActionPendingIntent(Context context, String str, Bundle bundle) {
        Intent intent = new Intent(str).setClass(context, NotificationTrampolineActivity.class);
        t.h(intent, "Intent(action).setClass(…lineActivity::class.java)");
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        PendingIntent activity = PendingIntent.getActivity(context, IntentUtils.getRequestCode(), intent, 1073741824 | IntentUtils.getImmutablePendingIntentFlags());
        t.h(activity, "getActivity(context, get… pushActionIntent, flags)");
        return activity;
    }

    @TargetApi(26)
    @Nullable
    public static final NotificationChannel getValidNotificationChannel(@NotNull NotificationManager notificationManager, @Nullable Bundle bundle) {
        t.i(notificationManager, "notificationManager");
        if (bundle == null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, (BrazeLogger.Priority) null, (Throwable) null, false, (a) C10861.INSTANCE, 7, (Object) null);
            return null;
        }
        String string = bundle.getString("ab_nc", null);
        if (!(string == null || q.z(string))) {
            NotificationChannel notificationChannel = notificationManager.getNotificationChannel(string);
            if (notificationChannel != null) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, (BrazeLogger.Priority) null, (Throwable) null, false, (a) new C10872(string), 7, (Object) null);
                return notificationChannel;
            }
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, (BrazeLogger.Priority) null, (Throwable) null, false, (a) new C10883(string), 7, (Object) null);
        }
        NotificationChannel notificationChannel2 = notificationManager.getNotificationChannel("com_appboy_default_notification_channel");
        if (notificationChannel2 != null) {
            return notificationChannel2;
        }
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, (BrazeLogger.Priority) null, (Throwable) null, false, (a) C10894.INSTANCE, 7, (Object) null);
        return null;
    }

    public static final void handleCancelNotificationAction(@NotNull Context context, @NotNull Intent intent) {
        t.i(context, "context");
        t.i(intent, "intent");
        try {
            if (intent.hasExtra("nid")) {
                int intExtra = intent.getIntExtra("nid", -1);
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, (BrazeLogger.Priority) null, (Throwable) null, false, (a) new C10901(intExtra), 7, (Object) null);
                Object systemService = context.getSystemService("notification");
                t.g(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
                ((NotificationManager) systemService).cancel("appboy_notification", intExtra);
            }
        } catch (Exception e10) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, BrazeLogger.Priority.E, (Throwable) e10, false, (a) C10912.INSTANCE, 4, (Object) null);
        }
    }

    public static final void handleContentCardsSerializedCardIfPresent(@NotNull BrazeNotificationPayload payload) {
        t.i(payload, "payload");
        String contentCardSyncData = payload.getContentCardSyncData();
        String contentCardSyncUserId = payload.getContentCardSyncUserId();
        Context context = payload.getContext();
        if (contentCardSyncData == null || context == null) {
            return;
        }
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, (BrazeLogger.Priority) null, (Throwable) null, false, (a) new C10921(contentCardSyncUserId, contentCardSyncData), 7, (Object) null);
        BrazeInternal.addSerializedContentCardToStorage(context, contentCardSyncData, contentCardSyncUserId);
    }

    public static final void handleNotificationDeleted(@NotNull Context context, @NotNull Intent intent) {
        t.i(context, "context");
        t.i(intent, "intent");
        try {
            BrazeLogger brazeLogger = BrazeLogger.INSTANCE;
            BrazeNotificationUtils brazeNotificationUtils = INSTANCE;
            BrazeLogger.brazelog$default(brazeLogger, (Object) brazeNotificationUtils, (BrazeLogger.Priority) null, (Throwable) null, false, (a) C10931.INSTANCE, 7, (Object) null);
            Bundle extras = intent.getExtras();
            if (extras != null) {
                brazeNotificationUtils.sendPushActionIntent(context, BrazeNotificationBroadcastType.DELETED, extras, new BrazeNotificationPayload(extras, null, context, null, 10, null));
            } else {
                sendPushActionIntent$default(brazeNotificationUtils, context, BrazeNotificationBroadcastType.DELETED, extras, null, 8, null);
            }
        } catch (Exception e10) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, BrazeLogger.Priority.E, (Throwable) e10, false, (a) C10942.INSTANCE, 4, (Object) null);
        }
    }

    public static final void handleNotificationOpened(@NotNull Context context, @NotNull Intent intent) {
        t.i(context, "context");
        t.i(intent, "intent");
        try {
            Braze.Companion.getInstance(context).logPushNotificationOpened(intent);
            sendNotificationOpenedBroadcast(context, intent);
            if (BrazeInternal.INSTANCE.getConfigurationProvider(context).getDoesHandlePushDeepLinksAutomatically()) {
                routeUserWithNotificationOpenedIntent(context, intent);
            } else {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, BrazeLogger.Priority.I, (Throwable) null, false, (a) C10951.INSTANCE, 6, (Object) null);
            }
        } catch (Exception e10) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, BrazeLogger.Priority.E, (Throwable) e10, false, (a) C10962.INSTANCE, 4, (Object) null);
        }
    }

    public static final void handlePushStoryPageClicked(@NotNull Context context, @NotNull Intent intent) {
        t.i(context, "context");
        t.i(intent, "intent");
        try {
            Braze.Companion.getInstance(context).logPushStoryPageClicked(intent.getStringExtra("braze_campaign_id"), intent.getStringExtra("braze_story_page_id"));
            BrazeConfigurationProvider configurationProvider = BrazeInternal.INSTANCE.getConfigurationProvider(context);
            int intExtra = intent.getIntExtra("nid", 0);
            if (configurationProvider.getDoesPushStoryDismissOnClick() && intExtra != 0) {
                cancelNotification(context, intExtra);
            }
            String stringExtra = intent.getStringExtra("braze_action_uri");
            if (stringExtra == null || q.z(stringExtra)) {
                intent.removeExtra("uri");
            } else {
                intent.putExtra("uri", intent.getStringExtra("braze_action_uri"));
                String stringExtra2 = intent.getStringExtra("braze_action_use_webview");
                if (!(stringExtra2 == null || q.z(stringExtra2))) {
                    intent.putExtra("ab_use_webview", stringExtra2);
                }
            }
            sendNotificationOpenedBroadcast(context, intent);
            if (configurationProvider.getDoesHandlePushDeepLinksAutomatically()) {
                routeUserWithNotificationOpenedIntent(context, intent);
            } else {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, BrazeLogger.Priority.I, (Throwable) null, false, (a) new C10971(stringExtra), 6, (Object) null);
            }
        } catch (Exception e10) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, BrazeLogger.Priority.E, (Throwable) e10, false, (a) C10982.INSTANCE, 4, (Object) null);
        }
    }

    public static final boolean isBrazePushMessage(@NotNull Intent intent) {
        t.i(intent, "<this>");
        Bundle extras = intent.getExtras();
        if (extras == null) {
            return false;
        }
        return q.x(com.ironsource.mediationsdk.metadata.a.f13688g, extras.getString("_ab"), true);
    }

    public static final boolean isNotificationMessage(@NotNull Intent intent) {
        t.i(intent, "intent");
        Bundle extras = intent.getExtras();
        return extras != null && extras.containsKey("t") && extras.containsKey(CmcdData.Factory.OBJECT_TYPE_AUDIO_ONLY);
    }

    @TargetApi(21)
    public static final boolean isValidNotificationVisibility(int i10) {
        return i10 == -1 || i10 == 0 || i10 == 1;
    }

    public static final void prefetchBitmapsIfNewlyReceivedStoryPush(@NotNull BrazeNotificationPayload payload) {
        t.i(payload, "payload");
        Context context = payload.getContext();
        if (context != null && payload.isPushStory() && payload.isNewlyReceivedPushStory()) {
            List<BrazeNotificationPayload.PushStoryPage> pushStoryPages = payload.getPushStoryPages();
            ArrayList<String> arrayList = new ArrayList();
            Iterator<T> it = pushStoryPages.iterator();
            while (it.hasNext()) {
                String bitmapUrl = ((BrazeNotificationPayload.PushStoryPage) it.next()).getBitmapUrl();
                if (bitmapUrl != null) {
                    arrayList.add(bitmapUrl);
                }
            }
            for (String str : arrayList) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, BrazeLogger.Priority.V, (Throwable) null, false, (a) new BrazeNotificationUtils$prefetchBitmapsIfNewlyReceivedStoryPush$2$1(str), 6, (Object) null);
                Braze.Companion.getInstance(context).getImageLoader().getPushBitmapFromUrl(context, payload.getBrazeExtras(), str, BrazeViewBounds.NOTIFICATION_ONE_IMAGE_STORY);
            }
            payload.setNewlyReceivedPushStory(false);
        }
    }

    public static final boolean refreshFeatureFlagsIfAppropriate(@NotNull BrazeNotificationPayload payload) {
        t.i(payload, "payload");
        Context context = payload.getContext();
        if (!payload.getShouldRefreshFeatureFlags() || context == null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, BrazeLogger.Priority.V, (Throwable) null, false, (a) C11002.INSTANCE, 6, (Object) null);
            return false;
        }
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, (BrazeLogger.Priority) null, (Throwable) null, false, (a) C10991.INSTANCE, 7, (Object) null);
        BrazeInternal.refreshFeatureFlags(context);
        return true;
    }

    public static final boolean requestGeofenceRefreshIfAppropriate(@NotNull BrazeNotificationPayload payload) {
        t.i(payload, "payload");
        Context context = payload.getContext();
        if (!payload.getShouldSyncGeofences() || context == null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, (BrazeLogger.Priority) null, (Throwable) null, false, (a) C11022.INSTANCE, 7, (Object) null);
            return false;
        }
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, (BrazeLogger.Priority) null, (Throwable) null, false, (a) C11011.INSTANCE, 7, (Object) null);
        BrazeInternal.requestGeofenceRefresh(context, true);
        return true;
    }

    public static final void routeUserWithNotificationOpenedIntent(@NotNull Context context, @NotNull Intent intent) {
        t.i(context, "context");
        t.i(intent, "intent");
        BrazeLogger brazeLogger = BrazeLogger.INSTANCE;
        BrazeNotificationUtils brazeNotificationUtils = INSTANCE;
        BrazeLogger.brazelog$default(brazeLogger, (Object) brazeNotificationUtils, (BrazeLogger.Priority) null, (Throwable) null, false, (a) C11031.INSTANCE, 7, (Object) null);
        Bundle bundleExtra = intent.getBundleExtra("extra");
        if (bundleExtra == null) {
            bundleExtra = new Bundle();
        }
        bundleExtra.putString(CmcdConfiguration.KEY_CONTENT_ID, intent.getStringExtra(CmcdConfiguration.KEY_CONTENT_ID));
        bundleExtra.putString(TransactionInfo.JsonKeys.SOURCE, "Appboy");
        brazeNotificationUtils.routeUserWithNotificationOpenedIntent(context, bundleExtra, intent.getStringExtra("uri"), q.x(com.ironsource.mediationsdk.metadata.a.f13688g, intent.getStringExtra("ab_use_webview"), true));
    }

    public static final void sendNotificationOpenedBroadcast(@NotNull Context context, @NotNull Intent intent) {
        t.i(context, "context");
        t.i(intent, "intent");
        BrazeLogger brazeLogger = BrazeLogger.INSTANCE;
        BrazeNotificationUtils brazeNotificationUtils = INSTANCE;
        BrazeLogger.brazelog$default(brazeLogger, (Object) brazeNotificationUtils, (BrazeLogger.Priority) null, (Throwable) null, false, (a) C11051.INSTANCE, 7, (Object) null);
        Bundle extras = intent.getExtras();
        if (extras == null) {
            sendPushActionIntent$default(brazeNotificationUtils, context, BrazeNotificationBroadcastType.OPENED, extras, null, 8, null);
        } else {
            brazeNotificationUtils.sendPushActionIntent(context, BrazeNotificationBroadcastType.OPENED, extras, new BrazeNotificationPayload(extras, null, context, null, 10, null));
        }
    }

    private final void sendPushActionIntent(Context context, BrazeNotificationBroadcastType brazeNotificationBroadcastType, Bundle bundle, BrazeNotificationPayload brazeNotificationPayload) {
        Intent intent;
        int i10 = WhenMappings.$EnumSwitchMapping$0[brazeNotificationBroadcastType.ordinal()];
        if (i10 == 1) {
            intent = new Intent("com.braze.push.intent.NOTIFICATION_OPENED").setPackage(context.getPackageName());
            t.h(intent, "{\n                Intent…ackageName)\n            }");
        } else if (i10 == 2) {
            intent = new Intent("com.braze.push.intent.NOTIFICATION_RECEIVED").setPackage(context.getPackageName());
            t.h(intent, "{\n                Intent…ackageName)\n            }");
        } else {
            if (i10 != 3) {
                throw new v8.q();
            }
            intent = new Intent("com.braze.push.intent.NOTIFICATION_DELETED").setPackage(context.getPackageName());
            t.h(intent, "{\n                Intent…ackageName)\n            }");
        }
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, false, (a) new C11061(brazeNotificationBroadcastType), 6, (Object) null);
        sendPushActionIntent(context, intent, bundle);
        if (brazeNotificationPayload != null) {
            BrazeInternal.INSTANCE.publishBrazePushAction(context, brazeNotificationBroadcastType.getBrazePushEventType(), brazeNotificationPayload);
        }
    }

    static /* synthetic */ void sendPushActionIntent$default(BrazeNotificationUtils brazeNotificationUtils, Context context, BrazeNotificationBroadcastType brazeNotificationBroadcastType, Bundle bundle, BrazeNotificationPayload brazeNotificationPayload, int i10, Object obj) {
        if ((i10 & 8) != 0) {
            brazeNotificationPayload = null;
        }
        brazeNotificationUtils.sendPushActionIntent(context, brazeNotificationBroadcastType, bundle, brazeNotificationPayload);
    }

    public static final void sendPushMessageReceivedBroadcast(@NotNull Context context, @NotNull Bundle notificationExtras, @NotNull BrazeNotificationPayload payload) {
        t.i(context, "context");
        t.i(notificationExtras, "notificationExtras");
        t.i(payload, "payload");
        BrazeLogger brazeLogger = BrazeLogger.INSTANCE;
        BrazeNotificationUtils brazeNotificationUtils = INSTANCE;
        BrazeLogger.brazelog$default(brazeLogger, (Object) brazeNotificationUtils, (BrazeLogger.Priority) null, (Throwable) null, false, (a) C11081.INSTANCE, 7, (Object) null);
        brazeNotificationUtils.sendPushActionIntent(context, BrazeNotificationBroadcastType.RECEIVED, notificationExtras, payload);
    }

    public static final void setAccentColorIfPresentAndSupported(@NotNull NotificationCompat.Builder notificationBuilder, @NotNull BrazeNotificationPayload payload) {
        t.i(notificationBuilder, "notificationBuilder");
        t.i(payload, "payload");
        Integer accentColor = payload.getAccentColor();
        if (accentColor != null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, (BrazeLogger.Priority) null, (Throwable) null, false, (a) C11091.INSTANCE, 7, (Object) null);
            notificationBuilder.setColor(accentColor.intValue());
            return;
        }
        BrazeConfigurationProvider configurationProvider = payload.getConfigurationProvider();
        if (configurationProvider != null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, (BrazeLogger.Priority) null, (Throwable) null, false, (a) BrazeNotificationUtils$setAccentColorIfPresentAndSupported$2$1.INSTANCE, 7, (Object) null);
            notificationBuilder.setColor(configurationProvider.getDefaultNotificationAccentColor());
        }
    }

    public static final void setCategoryIfPresentAndSupported(@NotNull NotificationCompat.Builder notificationBuilder, @NotNull BrazeNotificationPayload payload) {
        t.i(notificationBuilder, "notificationBuilder");
        t.i(payload, "payload");
        String notificationCategory = payload.getNotificationCategory();
        if (notificationCategory == null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, (BrazeLogger.Priority) null, (Throwable) null, false, (a) C11112.INSTANCE, 7, (Object) null);
        } else {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, (BrazeLogger.Priority) null, (Throwable) null, false, (a) C11101.INSTANCE, 7, (Object) null);
            notificationBuilder.setCategory(notificationCategory);
        }
    }

    public static final void setContentIfPresent(@NotNull NotificationCompat.Builder notificationBuilder, @NotNull BrazeNotificationPayload payload) {
        BrazeConfigurationProvider configurationProvider;
        t.i(notificationBuilder, "notificationBuilder");
        t.i(payload, "payload");
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, (BrazeLogger.Priority) null, (Throwable) null, false, (a) C11121.INSTANCE, 7, (Object) null);
        String contentText = payload.getContentText();
        if (contentText == null || (configurationProvider = payload.getConfigurationProvider()) == null) {
            return;
        }
        notificationBuilder.setContentText(HtmlUtils.getHtmlSpannedTextIfEnabled(contentText, configurationProvider));
    }

    public static final void setContentIntentIfPresent(@NotNull Context context, @NotNull NotificationCompat.Builder notificationBuilder, @Nullable Bundle bundle) {
        t.i(context, "context");
        t.i(notificationBuilder, "notificationBuilder");
        try {
            notificationBuilder.setContentIntent(INSTANCE.getPushActionPendingIntent(context, "com.braze.action.BRAZE_PUSH_CLICKED", bundle));
        } catch (Exception e10) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, BrazeLogger.Priority.E, (Throwable) e10, false, (a) C11131.INSTANCE, 4, (Object) null);
        }
    }

    public static final void setDeleteIntent(@NotNull Context context, @NotNull NotificationCompat.Builder notificationBuilder, @Nullable Bundle bundle) {
        t.i(context, "context");
        t.i(notificationBuilder, "notificationBuilder");
        try {
            Intent intent = new Intent("com.braze.action.BRAZE_PUSH_DELETED").setClass(context, getNotificationReceiverClass());
            t.h(intent, "Intent(Constants.BRAZE_P…otificationReceiverClass)");
            if (bundle != null) {
                intent.putExtras(bundle);
            }
            notificationBuilder.setDeleteIntent(PendingIntent.getBroadcast(context, IntentUtils.getRequestCode(), intent, IntentUtils.getImmutablePendingIntentFlags() | 1073741824));
        } catch (Exception e10) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, BrazeLogger.Priority.E, (Throwable) e10, false, (a) C11141.INSTANCE, 4, (Object) null);
        }
    }

    public static final boolean setLargeIconIfPresentAndSupported(@NotNull NotificationCompat.Builder notificationBuilder, @NotNull BrazeNotificationPayload payload) {
        BrazeConfigurationProvider configurationProvider;
        BrazeLogger brazeLogger;
        BrazeNotificationUtils brazeNotificationUtils;
        String largeIcon;
        t.i(notificationBuilder, "notificationBuilder");
        t.i(payload, "payload");
        if (payload.isPushStory()) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, (BrazeLogger.Priority) null, (Throwable) null, false, (a) C11151.INSTANCE, 7, (Object) null);
            return false;
        }
        Context context = payload.getContext();
        if (context == null || (configurationProvider = payload.getConfigurationProvider()) == null) {
            return false;
        }
        try {
            brazeLogger = BrazeLogger.INSTANCE;
            brazeNotificationUtils = INSTANCE;
            BrazeLogger.brazelog$default(brazeLogger, (Object) brazeNotificationUtils, (BrazeLogger.Priority) null, (Throwable) null, false, (a) C11162.INSTANCE, 7, (Object) null);
            largeIcon = payload.getLargeIcon();
        } catch (Exception e10) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, BrazeLogger.Priority.E, (Throwable) e10, false, (a) AnonymousClass6.INSTANCE, 4, (Object) null);
        }
        if (largeIcon != null) {
            notificationBuilder.setLargeIcon(Braze.Companion.getInstance(context).getImageLoader().getPushBitmapFromUrl(context, null, largeIcon, BrazeViewBounds.NOTIFICATION_LARGE_ICON));
            return true;
        }
        BrazeLogger.brazelog$default(brazeLogger, (Object) brazeNotificationUtils, (BrazeLogger.Priority) null, (Throwable) null, false, (a) C11174.INSTANCE, 7, (Object) null);
        int largeNotificationIconResourceId = configurationProvider.getLargeNotificationIconResourceId();
        if (largeNotificationIconResourceId != 0) {
            notificationBuilder.setLargeIcon(BitmapFactory.decodeResource(context.getResources(), largeNotificationIconResourceId));
            return true;
        }
        BrazeLogger.brazelog$default(brazeLogger, (Object) brazeNotificationUtils, (BrazeLogger.Priority) null, (Throwable) null, false, (a) C11185.INSTANCE, 7, (Object) null);
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, (BrazeLogger.Priority) null, (Throwable) null, false, (a) AnonymousClass7.INSTANCE, 7, (Object) null);
        return false;
    }

    public static final void setNotificationBadgeNumberIfPresent(@NotNull NotificationCompat.Builder notificationBuilder, @NotNull BrazeNotificationPayload payload) {
        t.i(notificationBuilder, "notificationBuilder");
        t.i(payload, "payload");
        if (Build.VERSION.SDK_INT < 26) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, (BrazeLogger.Priority) null, (Throwable) null, false, (a) C11191.INSTANCE, 7, (Object) null);
            return;
        }
        Integer notificationBadgeNumber = payload.getNotificationBadgeNumber();
        if (notificationBadgeNumber != null) {
            notificationBuilder.setNumber(notificationBadgeNumber.intValue());
        }
    }

    public static final void setNotificationDurationAlarm(@NotNull Context context, @Nullable Class<?> cls, int i10, int i11) {
        t.i(context, "context");
        Intent intent = new Intent(context, cls);
        intent.setAction("com.braze.action.CANCEL_NOTIFICATION");
        intent.putExtra("nid", i10);
        PendingIntent broadcast = PendingIntent.getBroadcast(context, 0, intent, 134217728 | IntentUtils.getImmutablePendingIntentFlags());
        Object systemService = context.getSystemService(NotificationCompat.CATEGORY_ALARM);
        t.g(systemService, "null cannot be cast to non-null type android.app.AlarmManager");
        AlarmManager alarmManager = (AlarmManager) systemService;
        if (i11 >= 1000) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, (BrazeLogger.Priority) null, (Throwable) null, false, (a) new C11201(i11), 7, (Object) null);
            alarmManager.set(3, SystemClock.elapsedRealtime() + ((long) i11), broadcast);
        }
    }

    public static final void setPriorityIfPresentAndSupported(@NotNull NotificationCompat.Builder notificationBuilder, @NotNull BrazeNotificationPayload payload) {
        t.i(notificationBuilder, "notificationBuilder");
        t.i(payload, "payload");
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, (BrazeLogger.Priority) null, (Throwable) null, false, (a) C11211.INSTANCE, 7, (Object) null);
        notificationBuilder.setPriority(getNotificationPriority(payload));
    }

    public static final void setPublicVersionIfPresentAndSupported(@NotNull NotificationCompat.Builder notificationBuilder, @NotNull BrazeNotificationPayload payload) {
        t.i(notificationBuilder, "notificationBuilder");
        t.i(payload, "payload");
        Context context = payload.getContext();
        BrazeConfigurationProvider configurationProvider = payload.getConfigurationProvider();
        if (context == null || payload.getPublicNotificationExtras() == null || configurationProvider == null) {
            return;
        }
        String orCreateNotificationChannelId = getOrCreateNotificationChannelId(payload);
        Bundle jsonObjectIntoBundle = JsonUtils.parseJsonObjectIntoBundle(payload.getPublicNotificationExtras());
        if (jsonObjectIntoBundle.isEmpty()) {
            return;
        }
        BrazeNotificationPayload brazeNotificationPayload = new BrazeNotificationPayload(jsonObjectIntoBundle, null, context, configurationProvider, 2, null);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, orCreateNotificationChannelId);
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, (BrazeLogger.Priority) null, (Throwable) null, false, (a) new C11222(brazeNotificationPayload), 7, (Object) null);
        setContentIfPresent(builder, brazeNotificationPayload);
        setTitleIfPresent(builder, brazeNotificationPayload);
        setSummaryTextIfPresentAndSupported(builder, brazeNotificationPayload);
        setSmallIcon(configurationProvider, builder);
        setAccentColorIfPresentAndSupported(builder, brazeNotificationPayload);
        notificationBuilder.setPublicVersion(builder.build());
    }

    public static final void setSetShowWhen(@NotNull NotificationCompat.Builder notificationBuilder, @NotNull BrazeNotificationPayload payload) {
        t.i(notificationBuilder, "notificationBuilder");
        t.i(payload, "payload");
        if (payload.isPushStory()) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, (BrazeLogger.Priority) null, (Throwable) null, false, (a) C11231.INSTANCE, 7, (Object) null);
            notificationBuilder.setShowWhen(false);
        }
    }

    public static final int setSmallIcon(@NotNull BrazeConfigurationProvider appConfigurationProvider, @NotNull NotificationCompat.Builder notificationBuilder) {
        t.i(appConfigurationProvider, "appConfigurationProvider");
        t.i(notificationBuilder, "notificationBuilder");
        int smallNotificationIconResourceId = appConfigurationProvider.getSmallNotificationIconResourceId();
        if (smallNotificationIconResourceId == 0) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, (BrazeLogger.Priority) null, (Throwable) null, false, (a) C11241.INSTANCE, 7, (Object) null);
            smallNotificationIconResourceId = appConfigurationProvider.getApplicationIconResourceId();
        } else {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, (BrazeLogger.Priority) null, (Throwable) null, false, (a) C11252.INSTANCE, 7, (Object) null);
        }
        notificationBuilder.setSmallIcon(smallNotificationIconResourceId);
        return smallNotificationIconResourceId;
    }

    public static final void setSoundIfPresentAndSupported(@NotNull NotificationCompat.Builder notificationBuilder, @NotNull BrazeNotificationPayload payload) {
        t.i(notificationBuilder, "notificationBuilder");
        t.i(payload, "payload");
        String notificationSound = payload.getNotificationSound();
        if (notificationSound == null) {
            return;
        }
        if (t.d(notificationSound, "d")) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, (BrazeLogger.Priority) null, (Throwable) null, false, (a) C11261.INSTANCE, 7, (Object) null);
            notificationBuilder.setDefaults(1);
        } else {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, (BrazeLogger.Priority) null, (Throwable) null, false, (a) C11272.INSTANCE, 7, (Object) null);
            notificationBuilder.setSound(Uri.parse(notificationSound));
        }
    }

    public static final void setSummaryTextIfPresentAndSupported(@NotNull NotificationCompat.Builder notificationBuilder, @NotNull BrazeNotificationPayload payload) {
        t.i(notificationBuilder, "notificationBuilder");
        t.i(payload, "payload");
        String summaryText = payload.getSummaryText();
        if (summaryText == null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, (BrazeLogger.Priority) null, (Throwable) null, false, (a) C11292.INSTANCE, 7, (Object) null);
        } else {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, (BrazeLogger.Priority) null, (Throwable) null, false, (a) C11281.INSTANCE, 7, (Object) null);
            notificationBuilder.setSubText(summaryText);
        }
    }

    public static final void setTickerIfPresent(@NotNull NotificationCompat.Builder notificationBuilder, @NotNull BrazeNotificationPayload payload) {
        t.i(notificationBuilder, "notificationBuilder");
        t.i(payload, "payload");
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, (BrazeLogger.Priority) null, (Throwable) null, false, (a) C11301.INSTANCE, 7, (Object) null);
        String titleText = payload.getTitleText();
        if (titleText == null) {
            return;
        }
        notificationBuilder.setTicker(titleText);
    }

    public static final void setTitleIfPresent(@NotNull NotificationCompat.Builder notificationBuilder, @NotNull BrazeNotificationPayload payload) {
        BrazeConfigurationProvider configurationProvider;
        t.i(notificationBuilder, "notificationBuilder");
        t.i(payload, "payload");
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, (BrazeLogger.Priority) null, (Throwable) null, false, (a) C11311.INSTANCE, 7, (Object) null);
        String titleText = payload.getTitleText();
        if (titleText == null || (configurationProvider = payload.getConfigurationProvider()) == null) {
            return;
        }
        notificationBuilder.setContentTitle(HtmlUtils.getHtmlSpannedTextIfEnabled(titleText, configurationProvider));
    }

    public static final void setVisibilityIfPresentAndSupported(@NotNull NotificationCompat.Builder notificationBuilder, @NotNull BrazeNotificationPayload payload) {
        t.i(notificationBuilder, "notificationBuilder");
        t.i(payload, "payload");
        Integer notificationVisibility = payload.getNotificationVisibility();
        if (notificationVisibility != null) {
            if (!isValidNotificationVisibility(notificationVisibility.intValue())) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, BrazeLogger.Priority.W, (Throwable) null, false, (a) new C11332(notificationVisibility), 6, (Object) null);
            } else {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, (BrazeLogger.Priority) null, (Throwable) null, false, (a) C11321.INSTANCE, 7, (Object) null);
                notificationBuilder.setVisibility(notificationVisibility.intValue());
            }
        }
    }

    public static final boolean wakeScreenIfAppropriate(@NotNull Context context, @NotNull BrazeConfigurationProvider configurationProvider, @Nullable Bundle bundle) {
        t.i(context, "context");
        t.i(configurationProvider, "configurationProvider");
        return wakeScreenIfAppropriate(new BrazeNotificationPayload(bundle, null, context, configurationProvider, 2, null));
    }

    @SuppressLint({"WakelockTimeout"})
    public static final boolean wakeScreenIfAppropriate(@NotNull BrazeNotificationPayload payload) {
        BrazeConfigurationProvider configurationProvider;
        t.i(payload, "payload");
        Context context = payload.getContext();
        if (context == null || (configurationProvider = payload.getConfigurationProvider()) == null) {
            return false;
        }
        Bundle notificationExtras = payload.getNotificationExtras();
        if (!PermissionUtils.hasPermission(context, "android.permission.WAKE_LOCK") || !configurationProvider.isPushWakeScreenForNotificationEnabled()) {
            return false;
        }
        try {
            Object systemService = context.getSystemService("uimode");
            t.g(systemService, "null cannot be cast to non-null type android.app.UiModeManager");
            if (((UiModeManager) systemService).getCurrentModeType() == 4) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, (BrazeLogger.Priority) null, (Throwable) null, false, (a) C11341.INSTANCE, 7, (Object) null);
                return false;
            }
        } catch (Exception e10) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, BrazeLogger.Priority.E, (Throwable) e10, false, (a) C11352.INSTANCE, 4, (Object) null);
        }
        if (Build.VERSION.SDK_INT >= 26) {
            Object systemService2 = context.getSystemService("notification");
            t.g(systemService2, "null cannot be cast to non-null type android.app.NotificationManager");
            NotificationChannel validNotificationChannel = getValidNotificationChannel((NotificationManager) systemService2, notificationExtras);
            if (validNotificationChannel != null) {
                if (validNotificationChannel.getImportance() == 1) {
                    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, (BrazeLogger.Priority) null, (Throwable) null, false, (a) new C11374(validNotificationChannel), 7, (Object) null);
                    return false;
                }
            } else {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, (BrazeLogger.Priority) null, (Throwable) null, false, (a) C11363.INSTANCE, 7, (Object) null);
                return false;
            }
        } else if (getNotificationPriority(payload) == -2) {
            return false;
        }
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, (BrazeLogger.Priority) null, (Throwable) null, false, (a) C11385.INSTANCE, 7, (Object) null);
        Object systemService3 = context.getSystemService("power");
        t.g(systemService3, "null cannot be cast to non-null type android.os.PowerManager");
        PowerManager.WakeLock wakeLockNewWakeLock = ((PowerManager) systemService3).newWakeLock(268435482, TAG);
        wakeLockNewWakeLock.acquire();
        wakeLockNewWakeLock.release();
        return true;
    }

    private final void routeUserWithNotificationOpenedIntent(Context context, Bundle bundle, String str, boolean z10) {
        if (!(str == null || q.z(str))) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (a) new C11043(str, z10), 7, (Object) null);
            bundle.putString("uri", str);
            bundle.putBoolean("ab_use_webview", z10);
            BrazeDeeplinkHandler.Companion companion = BrazeDeeplinkHandler.Companion;
            UriAction uriActionCreateUriActionFromUrlString = companion.getInstance().createUriActionFromUrlString(str, bundle, z10, Channel.PUSH);
            if (uriActionCreateUriActionFromUrlString != null) {
                companion.getInstance().gotoUri(context, uriActionCreateUriActionFromUrlString);
                return;
            }
            return;
        }
        Intent mainActivityIntent = UriUtils.getMainActivityIntent(context, bundle);
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (a) new AnonymousClass5(mainActivityIntent), 7, (Object) null);
        context.startActivity(mainActivityIntent);
    }

    private final void sendPushActionIntent(Context context, Intent intent, Bundle bundle) {
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, false, (a) new C11072(intent), 6, (Object) null);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        IntentUtils.addComponentAndSendBroadcast(context, intent);
    }
}
