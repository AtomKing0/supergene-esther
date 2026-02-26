package com.braze.push;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.core.app.NotificationCompat;
import androidx.media3.exoplayer.upstream.CmcdConfiguration;
import com.braze.Braze;
import com.braze.IBrazeDeeplinkHandler;
import com.braze.models.push.BrazeNotificationPayload;
import com.braze.support.BrazeLogger;
import com.braze.support.IntentUtils;
import com.braze.ui.BrazeDeeplinkHandler;
import h9.a;
import java.util.List;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: BrazeNotificationActionUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class BrazeNotificationActionUtils {

    @NotNull
    public static final BrazeNotificationActionUtils INSTANCE = new BrazeNotificationActionUtils();

    /* JADX INFO: renamed from: com.braze.push.BrazeNotificationActionUtils$addNotificationAction$1, reason: invalid class name */
    /* JADX INFO: compiled from: BrazeNotificationActionUtils.kt */
    static final class AnonymousClass1 extends v implements a<String> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Cannot add notification action with null context from payload";
        }
    }

    /* JADX INFO: renamed from: com.braze.push.BrazeNotificationActionUtils$addNotificationAction$2, reason: invalid class name */
    /* JADX INFO: compiled from: BrazeNotificationActionUtils.kt */
    static final class AnonymousClass2 extends v implements a<String> {
        final /* synthetic */ String $actionType;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(String str) {
            super(0);
            this.$actionType = str;
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Adding notification action with type: " + this.$actionType + "Setting intent class to notification receiver: " + BrazeNotificationUtils.getNotificationReceiverClass();
        }
    }

    /* JADX INFO: renamed from: com.braze.push.BrazeNotificationActionUtils$addNotificationAction$3, reason: invalid class name */
    /* JADX INFO: compiled from: BrazeNotificationActionUtils.kt */
    static final class AnonymousClass3 extends v implements a<String> {
        final /* synthetic */ String $actionType;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(String str) {
            super(0);
            this.$actionType = str;
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Adding notification action with type: " + this.$actionType + " Setting intent class to trampoline activity";
        }
    }

    /* JADX INFO: renamed from: com.braze.push.BrazeNotificationActionUtils$addNotificationAction$4, reason: invalid class name */
    /* JADX INFO: compiled from: BrazeNotificationActionUtils.kt */
    static final class AnonymousClass4 extends v implements a<String> {
        final /* synthetic */ Bundle $actionExtras;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass4(Bundle bundle) {
            super(0);
            this.$actionExtras = bundle;
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Added action with bundle: " + this.$actionExtras;
        }
    }

    /* JADX INFO: renamed from: com.braze.push.BrazeNotificationActionUtils$addNotificationActions$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BrazeNotificationActionUtils.kt */
    static final class C10761 extends v implements a<String> {
        public static final C10761 INSTANCE = new C10761();

        C10761() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Context cannot be null when adding notification buttons.";
        }
    }

    /* JADX INFO: renamed from: com.braze.push.BrazeNotificationActionUtils$addNotificationActions$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BrazeNotificationActionUtils.kt */
    static final class C10772 extends v implements a<String> {
        public static final C10772 INSTANCE = new C10772();

        C10772() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "No action buttons present. Not adding notification actions";
        }
    }

    /* JADX INFO: renamed from: com.braze.push.BrazeNotificationActionUtils$addNotificationActions$3, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BrazeNotificationActionUtils.kt */
    static final class C10783 extends v implements a<String> {
        final /* synthetic */ BrazeNotificationPayload.ActionButton $actionButton;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C10783(BrazeNotificationPayload.ActionButton actionButton) {
            super(0);
            this.$actionButton = actionButton;
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Adding action button: " + this.$actionButton;
        }
    }

    /* JADX INFO: renamed from: com.braze.push.BrazeNotificationActionUtils$handleNotificationActionClicked$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BrazeNotificationActionUtils.kt */
    static final class C10791 extends v implements a<String> {
        public static final C10791 INSTANCE = new C10791();

        C10791() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Notification action button type was blank or null. Doing nothing.";
        }
    }

    /* JADX INFO: renamed from: com.braze.push.BrazeNotificationActionUtils$handleNotificationActionClicked$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BrazeNotificationActionUtils.kt */
    static final class C10802 extends v implements a<String> {
        public static final C10802 INSTANCE = new C10802();

        C10802() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Not handling deep links automatically, skipping deep link handling";
        }
    }

    /* JADX INFO: renamed from: com.braze.push.BrazeNotificationActionUtils$handleNotificationActionClicked$3, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BrazeNotificationActionUtils.kt */
    static final class C10813 extends v implements a<String> {
        public static final C10813 INSTANCE = new C10813();

        C10813() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Unknown notification action button clicked. Doing nothing.";
        }
    }

    /* JADX INFO: renamed from: com.braze.push.BrazeNotificationActionUtils$handleNotificationActionClicked$4, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BrazeNotificationActionUtils.kt */
    static final class C10824 extends v implements a<String> {
        public static final C10824 INSTANCE = new C10824();

        C10824() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Caught exception while handling notification action button click.";
        }
    }

    private BrazeNotificationActionUtils() {
    }

    public static final void addNotificationActions(@NotNull NotificationCompat.Builder notificationBuilder, @NotNull BrazeNotificationPayload payload) {
        t.i(notificationBuilder, "notificationBuilder");
        t.i(payload, "payload");
        if (payload.getContext() == null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, (BrazeLogger.Priority) null, (Throwable) null, false, (a) C10761.INSTANCE, 7, (Object) null);
            return;
        }
        List<BrazeNotificationPayload.ActionButton> actionButtons = payload.getActionButtons();
        if (actionButtons.isEmpty()) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, (BrazeLogger.Priority) null, (Throwable) null, false, (a) C10772.INSTANCE, 7, (Object) null);
            return;
        }
        for (BrazeNotificationPayload.ActionButton actionButton : actionButtons) {
            BrazeLogger brazeLogger = BrazeLogger.INSTANCE;
            BrazeNotificationActionUtils brazeNotificationActionUtils = INSTANCE;
            BrazeLogger.brazelog$default(brazeLogger, (Object) brazeNotificationActionUtils, BrazeLogger.Priority.V, (Throwable) null, false, (a) new C10783(actionButton), 6, (Object) null);
            brazeNotificationActionUtils.addNotificationAction(notificationBuilder, payload, actionButton);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x007f A[Catch: Exception -> 0x00e6, TRY_ENTER, TRY_LEAVE, TryCatch #0 {Exception -> 0x00e6, blocks: (B:3:0x000a, B:5:0x0014, B:11:0x0020, B:13:0x0030, B:15:0x003e, B:23:0x0055, B:33:0x0074, B:36:0x007f, B:39:0x0087, B:44:0x0092, B:47:0x00a1, B:51:0x00aa, B:53:0x00b7, B:55:0x00c6, B:56:0x00ca, B:52:0x00b4, B:26:0x005e, B:29:0x0068, B:30:0x006d, B:57:0x00d8), top: B:62:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00b4 A[Catch: Exception -> 0x00e6, TryCatch #0 {Exception -> 0x00e6, blocks: (B:3:0x000a, B:5:0x0014, B:11:0x0020, B:13:0x0030, B:15:0x003e, B:23:0x0055, B:33:0x0074, B:36:0x007f, B:39:0x0087, B:44:0x0092, B:47:0x00a1, B:51:0x00aa, B:53:0x00b7, B:55:0x00c6, B:56:0x00ca, B:52:0x00b4, B:26:0x005e, B:29:0x0068, B:30:0x006d, B:57:0x00d8), top: B:62:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00c6 A[Catch: Exception -> 0x00e6, TryCatch #0 {Exception -> 0x00e6, blocks: (B:3:0x000a, B:5:0x0014, B:11:0x0020, B:13:0x0030, B:15:0x003e, B:23:0x0055, B:33:0x0074, B:36:0x007f, B:39:0x0087, B:44:0x0092, B:47:0x00a1, B:51:0x00aa, B:53:0x00b7, B:55:0x00c6, B:56:0x00ca, B:52:0x00b4, B:26:0x005e, B:29:0x0068, B:30:0x006d, B:57:0x00d8), top: B:62:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00ca A[Catch: Exception -> 0x00e6, TryCatch #0 {Exception -> 0x00e6, blocks: (B:3:0x000a, B:5:0x0014, B:11:0x0020, B:13:0x0030, B:15:0x003e, B:23:0x0055, B:33:0x0074, B:36:0x007f, B:39:0x0087, B:44:0x0092, B:47:0x00a1, B:51:0x00aa, B:53:0x00b7, B:55:0x00c6, B:56:0x00ca, B:52:0x00b4, B:26:0x005e, B:29:0x0068, B:30:0x006d, B:57:0x00d8), top: B:62:0x000a }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void handleNotificationActionClicked(@org.jetbrains.annotations.NotNull android.content.Context r12, @org.jetbrains.annotations.NotNull android.content.Intent r13) {
        /*
            Method dump skipped, instruction units count: 247
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.braze.push.BrazeNotificationActionUtils.handleNotificationActionClicked(android.content.Context, android.content.Intent):void");
    }

    public final void addNotificationAction(@NotNull NotificationCompat.Builder notificationBuilder, @NotNull BrazeNotificationPayload payload, @NotNull BrazeNotificationPayload.ActionButton actionButton) {
        PendingIntent activity;
        t.i(notificationBuilder, "notificationBuilder");
        t.i(payload, "payload");
        t.i(actionButton, "actionButton");
        Context context = payload.getContext();
        if (context == null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (a) AnonymousClass1.INSTANCE, 7, (Object) null);
            return;
        }
        Bundle bundle = new Bundle(payload.getNotificationExtras());
        actionButton.putIntoBundle(bundle);
        String type = actionButton.getType();
        int immutablePendingIntentFlags = 134217728 | IntentUtils.getImmutablePendingIntentFlags();
        if (t.d("ab_none", type)) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, false, (a) new AnonymousClass2(type), 6, (Object) null);
            Intent intent = new Intent("com.braze.action.BRAZE_ACTION_CLICKED").setClass(context, BrazeNotificationUtils.getNotificationReceiverClass());
            t.h(intent, "Intent(Constants.BRAZE_A…ceiverClass\n            )");
            intent.putExtras(bundle);
            activity = PendingIntent.getBroadcast(context, IntentUtils.getRequestCode(), intent, immutablePendingIntentFlags);
            t.h(activity, "getBroadcast(\n          …IntentFlags\n            )");
        } else {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, false, (a) new AnonymousClass3(type), 6, (Object) null);
            Intent intent2 = new Intent("com.braze.action.BRAZE_ACTION_CLICKED").setClass(context, NotificationTrampolineActivity.class);
            t.h(intent2, "Intent(Constants.BRAZE_A…lineActivity::class.java)");
            intent2.setFlags(intent2.getFlags() | BrazeDeeplinkHandler.Companion.getInstance().getIntentFlags(IBrazeDeeplinkHandler.IntentFlagPurpose.NOTIFICATION_ACTION_WITH_DEEPLINK));
            intent2.putExtras(bundle);
            activity = PendingIntent.getActivity(context, IntentUtils.getRequestCode(), intent2, immutablePendingIntentFlags);
            t.h(activity, "getActivity(\n           …IntentFlags\n            )");
        }
        NotificationCompat.Action.Builder builder = new NotificationCompat.Action.Builder(0, actionButton.getText(), activity);
        builder.addExtras(new Bundle(bundle));
        notificationBuilder.addAction(builder.build());
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, false, (a) new AnonymousClass4(bundle), 6, (Object) null);
    }

    public final void logNotificationActionClicked(@NotNull Context context, @NotNull Intent intent, @Nullable String str) {
        t.i(context, "context");
        t.i(intent, "intent");
        Braze.Companion.getInstance(context).logPushNotificationActionClicked(intent.getStringExtra(CmcdConfiguration.KEY_CONTENT_ID), intent.getStringExtra("braze_action_id"), str);
    }
}
