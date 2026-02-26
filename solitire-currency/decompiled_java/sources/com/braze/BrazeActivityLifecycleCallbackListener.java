package com.braze;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.VisibleForTesting;
import com.braze.Braze;
import com.braze.push.NotificationTrampolineActivity;
import com.braze.support.BrazeLogger;
import com.braze.ui.inappmessage.BrazeInAppMessageManager;
import java.util.Set;
import kotlin.collections.z0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: BrazeActivityLifecycleCallbackListener.kt */
/* JADX INFO: loaded from: classes2.dex */
public class BrazeActivityLifecycleCallbackListener implements Application.ActivityLifecycleCallbacks {

    @NotNull
    private Set<? extends Class<?>> inAppMessagingRegistrationBlocklist;
    private final boolean registerInAppMessageManager;

    @NotNull
    private Set<? extends Class<?>> sessionHandlingBlocklist;
    private final boolean sessionHandlingEnabled;

    /* JADX INFO: renamed from: com.braze.BrazeActivityLifecycleCallbackListener$1, reason: invalid class name */
    /* JADX INFO: compiled from: BrazeActivityLifecycleCallbackListener.kt */
    static final class AnonymousClass1 extends kotlin.jvm.internal.v implements h9.a<String> {
        AnonymousClass1() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "BrazeActivityLifecycleCallbackListener using in-app messaging blocklist: " + BrazeActivityLifecycleCallbackListener.this.inAppMessagingRegistrationBlocklist;
        }
    }

    /* JADX INFO: renamed from: com.braze.BrazeActivityLifecycleCallbackListener$2, reason: invalid class name */
    /* JADX INFO: compiled from: BrazeActivityLifecycleCallbackListener.kt */
    static final class AnonymousClass2 extends kotlin.jvm.internal.v implements h9.a<String> {
        AnonymousClass2() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "BrazeActivityLifecycleCallbackListener using session handling blocklist: " + BrazeActivityLifecycleCallbackListener.this.sessionHandlingBlocklist;
        }
    }

    /* JADX INFO: renamed from: com.braze.BrazeActivityLifecycleCallbackListener$onActivityCreated$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BrazeActivityLifecycleCallbackListener.kt */
    static final class C10641 extends kotlin.jvm.internal.v implements h9.a<String> {
        final /* synthetic */ Activity $activity;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C10641(Activity activity) {
            super(0);
            this.$activity = activity;
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Automatically calling lifecycle method: ensureSubscribedToInAppMessageEvents for class: " + this.$activity.getClass();
        }
    }

    /* JADX INFO: renamed from: com.braze.BrazeActivityLifecycleCallbackListener$onActivityPaused$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BrazeActivityLifecycleCallbackListener.kt */
    static final class C10651 extends kotlin.jvm.internal.v implements h9.a<String> {
        final /* synthetic */ Activity $activity;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C10651(Activity activity) {
            super(0);
            this.$activity = activity;
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Automatically calling lifecycle method: unregisterInAppMessageManager for class: " + this.$activity.getClass();
        }
    }

    /* JADX INFO: renamed from: com.braze.BrazeActivityLifecycleCallbackListener$onActivityResumed$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BrazeActivityLifecycleCallbackListener.kt */
    static final class C10661 extends kotlin.jvm.internal.v implements h9.a<String> {
        final /* synthetic */ Activity $activity;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C10661(Activity activity) {
            super(0);
            this.$activity = activity;
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Automatically calling lifecycle method: registerInAppMessageManager for class: " + this.$activity.getClass();
        }
    }

    /* JADX INFO: renamed from: com.braze.BrazeActivityLifecycleCallbackListener$onActivityStarted$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BrazeActivityLifecycleCallbackListener.kt */
    static final class C10671 extends kotlin.jvm.internal.v implements h9.a<String> {
        final /* synthetic */ Activity $activity;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C10671(Activity activity) {
            super(0);
            this.$activity = activity;
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Automatically calling lifecycle method: openSession for class: " + this.$activity.getClass();
        }
    }

    /* JADX INFO: renamed from: com.braze.BrazeActivityLifecycleCallbackListener$onActivityStopped$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BrazeActivityLifecycleCallbackListener.kt */
    static final class C10681 extends kotlin.jvm.internal.v implements h9.a<String> {
        final /* synthetic */ Activity $activity;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C10681(Activity activity) {
            super(0);
            this.$activity = activity;
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Automatically calling lifecycle method: closeSession for class: " + this.$activity.getClass();
        }
    }

    /* JADX INFO: renamed from: com.braze.BrazeActivityLifecycleCallbackListener$shouldHandleLifecycleMethodsInActivity$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BrazeActivityLifecycleCallbackListener.kt */
    static final class C10691 extends kotlin.jvm.internal.v implements h9.a<String> {
        public static final C10691 INSTANCE = new C10691();

        C10691() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Skipping automatic registration for notification trampoline activity class.";
        }
    }

    public BrazeActivityLifecycleCallbackListener() {
        this(false, false, null, null, 15, null);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(@NotNull Activity activity, @Nullable Bundle bundle) {
        kotlin.jvm.internal.t.i(activity, "activity");
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, false, (h9.a) new C10641(activity), 6, (Object) null);
        BrazeInAppMessageManager companion = BrazeInAppMessageManager.Companion.getInstance();
        Context applicationContext = activity.getApplicationContext();
        kotlin.jvm.internal.t.h(applicationContext, "activity.applicationContext");
        companion.ensureSubscribedToInAppMessageEvents(applicationContext);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(@NotNull Activity activity) {
        kotlin.jvm.internal.t.i(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(@NotNull Activity activity) {
        kotlin.jvm.internal.t.i(activity, "activity");
        if (this.registerInAppMessageManager && shouldHandleLifecycleMethodsInActivity(activity, false)) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, false, (h9.a) new C10651(activity), 6, (Object) null);
            BrazeInAppMessageManager.Companion.getInstance().unregisterInAppMessageManager(activity);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(@NotNull Activity activity) {
        kotlin.jvm.internal.t.i(activity, "activity");
        if (this.registerInAppMessageManager && shouldHandleLifecycleMethodsInActivity(activity, false)) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, false, (h9.a) new C10661(activity), 6, (Object) null);
            BrazeInAppMessageManager.Companion.getInstance().registerInAppMessageManager(activity);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(@NotNull Activity activity, @NotNull Bundle bundle) {
        kotlin.jvm.internal.t.i(activity, "activity");
        kotlin.jvm.internal.t.i(bundle, "bundle");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(@NotNull Activity activity) {
        kotlin.jvm.internal.t.i(activity, "activity");
        if (this.sessionHandlingEnabled && shouldHandleLifecycleMethodsInActivity(activity, true)) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, false, (h9.a) new C10671(activity), 6, (Object) null);
            Braze.Companion companion = Braze.Companion;
            Context applicationContext = activity.getApplicationContext();
            kotlin.jvm.internal.t.h(applicationContext, "activity.applicationContext");
            companion.getInstance(applicationContext).openSession(activity);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(@NotNull Activity activity) {
        kotlin.jvm.internal.t.i(activity, "activity");
        if (this.sessionHandlingEnabled && shouldHandleLifecycleMethodsInActivity(activity, true)) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, false, (h9.a) new C10681(activity), 6, (Object) null);
            Braze.Companion companion = Braze.Companion;
            Context applicationContext = activity.getApplicationContext();
            kotlin.jvm.internal.t.h(applicationContext, "activity.applicationContext");
            companion.getInstance(applicationContext).closeSession(activity);
        }
    }

    @VisibleForTesting
    public final boolean shouldHandleLifecycleMethodsInActivity(@NotNull Activity activity, boolean z10) {
        kotlin.jvm.internal.t.i(activity, "activity");
        Class<?> cls = activity.getClass();
        if (kotlin.jvm.internal.t.d(cls, NotificationTrampolineActivity.class)) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, false, (h9.a) C10691.INSTANCE, 6, (Object) null);
            return false;
        }
        if (z10) {
            if (this.sessionHandlingBlocklist.contains(cls)) {
                return false;
            }
        } else if (this.inAppMessagingRegistrationBlocklist.contains(cls)) {
            return false;
        }
        return true;
    }

    public BrazeActivityLifecycleCallbackListener(boolean z10, boolean z11, @Nullable Set<? extends Class<?>> set, @Nullable Set<? extends Class<?>> set2) {
        this.sessionHandlingEnabled = z10;
        this.registerInAppMessageManager = z11;
        this.inAppMessagingRegistrationBlocklist = set == null ? z0.e() : set;
        this.sessionHandlingBlocklist = set2 == null ? z0.e() : set2;
        BrazeLogger brazeLogger = BrazeLogger.INSTANCE;
        BrazeLogger.Priority priority = BrazeLogger.Priority.V;
        BrazeLogger.brazelog$default(brazeLogger, (Object) this, priority, (Throwable) null, false, (h9.a) new AnonymousClass1(), 6, (Object) null);
        BrazeLogger.brazelog$default(brazeLogger, (Object) this, priority, (Throwable) null, false, (h9.a) new AnonymousClass2(), 6, (Object) null);
    }

    public /* synthetic */ BrazeActivityLifecycleCallbackListener(boolean z10, boolean z11, Set set, Set set2, int i10, kotlin.jvm.internal.k kVar) {
        this((i10 & 1) != 0 ? true : z10, (i10 & 2) != 0 ? true : z11, (i10 & 4) != 0 ? z0.e() : set, (i10 & 8) != 0 ? z0.e() : set2);
    }
}
