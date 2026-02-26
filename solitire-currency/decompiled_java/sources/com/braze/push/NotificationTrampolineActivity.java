package com.braze.push;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.braze.BrazeInternal;
import com.braze.Constants;
import com.braze.coroutine.BrazeCoroutineScope;
import com.braze.push.BrazePushReceiver;
import com.braze.support.BrazeLogger;
import h9.a;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import v8.u;
import z8.d;

/* JADX INFO: compiled from: NotificationTrampolineActivity.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class NotificationTrampolineActivity extends Activity {

    /* JADX INFO: renamed from: com.braze.push.NotificationTrampolineActivity$onCreate$1, reason: invalid class name */
    /* JADX INFO: compiled from: NotificationTrampolineActivity.kt */
    static final class AnonymousClass1 extends v implements a<String> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "NotificationTrampolineActivity created";
        }
    }

    /* JADX INFO: renamed from: com.braze.push.NotificationTrampolineActivity$onPause$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: NotificationTrampolineActivity.kt */
    static final class C11391 extends v implements a<String> {
        public static final C11391 INSTANCE = new C11391();

        C11391() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Notification trampoline activity paused and finishing";
        }
    }

    /* JADX INFO: renamed from: com.braze.push.NotificationTrampolineActivity$onResume$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: NotificationTrampolineActivity.kt */
    static final class C11401 extends v implements a<String> {
        public static final C11401 INSTANCE = new C11401();

        C11401() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Notification trampoline activity received null intent. Doing nothing.";
        }
    }

    /* JADX INFO: renamed from: com.braze.push.NotificationTrampolineActivity$onResume$2, reason: invalid class name */
    /* JADX INFO: compiled from: NotificationTrampolineActivity.kt */
    static final class AnonymousClass2 extends v implements a<String> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        AnonymousClass2() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Notification trampoline activity received intent with null action. Doing nothing.";
        }
    }

    /* JADX INFO: renamed from: com.braze.push.NotificationTrampolineActivity$onResume$3, reason: invalid class name */
    /* JADX INFO: compiled from: NotificationTrampolineActivity.kt */
    static final class AnonymousClass3 extends v implements a<String> {
        final /* synthetic */ Intent $receivedIntent;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(Intent intent) {
            super(0);
            this.$receivedIntent = intent;
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Notification trampoline activity received intent: " + this.$receivedIntent;
        }
    }

    /* JADX INFO: renamed from: com.braze.push.NotificationTrampolineActivity$onResume$5, reason: invalid class name */
    /* JADX INFO: compiled from: NotificationTrampolineActivity.kt */
    static final class AnonymousClass5 extends v implements a<String> {
        public static final AnonymousClass5 INSTANCE = new AnonymousClass5();

        AnonymousClass5() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Failed to route intent to notification receiver";
        }
    }

    /* JADX INFO: renamed from: com.braze.push.NotificationTrampolineActivity$onResume$6, reason: invalid class name */
    /* JADX INFO: compiled from: NotificationTrampolineActivity.kt */
    static final class AnonymousClass6 extends v implements a<String> {
        public static final AnonymousClass6 INSTANCE = new AnonymousClass6();

        AnonymousClass6() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Notification trampoline activity finished processing. Delaying before finishing activity.";
        }
    }

    /* JADX INFO: renamed from: com.braze.push.NotificationTrampolineActivity$onResume$7, reason: invalid class name */
    /* JADX INFO: compiled from: NotificationTrampolineActivity.kt */
    @f(c = "com.braze.push.NotificationTrampolineActivity$onResume$7", f = "NotificationTrampolineActivity.kt", l = {}, m = "invokeSuspend")
    static final class AnonymousClass7 extends l implements h9.l<d<? super k0>, Object> {
        int label;

        /* JADX INFO: renamed from: com.braze.push.NotificationTrampolineActivity$onResume$7$1, reason: invalid class name */
        /* JADX INFO: compiled from: NotificationTrampolineActivity.kt */
        static final class AnonymousClass1 extends v implements a<String> {
            public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

            AnonymousClass1() {
                super(0);
            }

            @Override // h9.a
            @NotNull
            public final String invoke() {
                return "Delay complete. Finishing Notification trampoline activity now";
            }
        }

        AnonymousClass7(d<? super AnonymousClass7> dVar) {
            super(1, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final d<k0> create(@NotNull d<?> dVar) {
            return NotificationTrampolineActivity.this.new AnonymousClass7(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            a9.d.e();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            u.b(obj);
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) NotificationTrampolineActivity.this, BrazeLogger.Priority.V, (Throwable) null, false, (a) AnonymousClass1.INSTANCE, 6, (Object) null);
            NotificationTrampolineActivity.this.finish();
            return k0.f35197a;
        }

        @Override // h9.l
        @Nullable
        public final Object invoke(@Nullable d<? super k0> dVar) {
            return ((AnonymousClass7) create(dVar)).invokeSuspend(k0.f35197a);
        }
    }

    @Override // android.app.Activity
    protected void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (BrazeInternal.INSTANCE.getConfigurationProvider(this).getShouldUseWindowFlagSecureInActivities()) {
            getWindow().setFlags(8192, 8192);
        }
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, false, (a) AnonymousClass1.INSTANCE, 6, (Object) null);
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, false, (a) C11391.INSTANCE, 6, (Object) null);
        finish();
    }

    @Override // android.app.Activity
    protected void onResume() {
        Intent intent;
        super.onResume();
        try {
            intent = getIntent();
        } catch (Exception e10) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) e10, false, (a) AnonymousClass5.INSTANCE, 4, (Object) null);
        }
        if (intent == null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (a) C11401.INSTANCE, 7, (Object) null);
            finish();
            return;
        }
        String action = intent.getAction();
        if (action == null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (a) AnonymousClass2.INSTANCE, 7, (Object) null);
            finish();
            return;
        }
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, false, (a) new AnonymousClass3(intent), 6, (Object) null);
        Intent intent2 = new Intent(action).setClass(this, BrazeNotificationUtils.getNotificationReceiverClass());
        t.h(intent2, "Intent(action).setClass(…otificationReceiverClass)");
        Bundle extras = intent.getExtras();
        if (extras != null) {
            intent2.putExtras(extras);
        }
        if (Constants.isAmazonDevice()) {
            BrazePushReceiver.Companion.handleReceivedIntent$default(BrazePushReceiver.Companion, this, intent2, false, 4, null);
        } else {
            BrazePushReceiver.Companion.handleReceivedIntent(this, intent2, false);
        }
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, false, (a) AnonymousClass6.INSTANCE, 6, (Object) null);
        BrazeCoroutineScope.launchDelayed$default(BrazeCoroutineScope.INSTANCE, 200, null, new AnonymousClass7(null), 2, null);
    }
}
