package com.vungle.ads.internal.util;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.VisibleForTesting;
import androidx.media3.common.C;
import com.vungle.ads.internal.util.p;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ActivityManager.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class c implements Application.ActivityLifecycleCallbacks {

    @Nullable
    private Handler handler;

    @Nullable
    private String lastStoppedActivityName;

    @NotNull
    public static final a Companion = new a(null);
    private static final String TAG = c.class.getSimpleName();

    @NotNull
    private static final c instance = new c();
    private static final long TIMEOUT = C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS;
    private static final long CONFIG_CHANGE_DELAY = 700;

    @NotNull
    private d state = d.UNKNOWN;

    @NotNull
    private AtomicBoolean isInitialized = new AtomicBoolean(false);

    @NotNull
    private final CopyOnWriteArraySet<String> startedActivities = new CopyOnWriteArraySet<>();

    @NotNull
    private final CopyOnWriteArraySet<String> resumedActivities = new CopyOnWriteArraySet<>();

    @NotNull
    private final CopyOnWriteArraySet<C0535c> callbacks = new CopyOnWriteArraySet<>();

    @NotNull
    private final ConcurrentHashMap<b, C0535c> adLeftCallbacks = new ConcurrentHashMap<>();

    @NotNull
    private final Runnable configChangeRunnable = new Runnable() { // from class: com.vungle.ads.internal.util.a
        @Override // java.lang.Runnable
        public final void run() {
            c.m4114configChangeRunnable$lambda0(this.f24401a);
        }
    };

    /* JADX INFO: compiled from: ActivityManager.kt */
    public interface b {
        void onLeftApplication();
    }

    /* JADX INFO: compiled from: ActivityManager.kt */
    public enum d {
        STARTED,
        RESUMED,
        PAUSED,
        STOPPED,
        UNKNOWN
    }

    /* JADX INFO: compiled from: ActivityManager.kt */
    public static final class e extends C0535c {
        final /* synthetic */ Runnable $cancelRunnable;
        final /* synthetic */ WeakReference<b> $weakCallback;

        e(WeakReference<b> weakReference, Runnable runnable) {
            this.$weakCallback = weakReference;
            this.$cancelRunnable = runnable;
        }

        @Override // com.vungle.ads.internal.util.c.C0535c
        public void onStart() {
            a aVar = c.Companion;
            aVar.getInstance$vungle_ads_release().removeListener(this);
            C0535c c0535c = (C0535c) c.this.adLeftCallbacks.get(this.$weakCallback.get());
            if (c0535c != null) {
                Handler handler = c.this.handler;
                if (handler != null) {
                    handler.postDelayed(this.$cancelRunnable, aVar.getTIMEOUT());
                }
                c.this.addListener(c0535c);
            }
        }
    }

    /* JADX INFO: compiled from: ActivityManager.kt */
    public static final class f extends C0535c {
        final /* synthetic */ Runnable $cancelRunnable;
        final /* synthetic */ WeakReference<b> $weakCallback;
        final /* synthetic */ c this$0;
        private boolean wasPaused;

        f(WeakReference<b> weakReference, c cVar, Runnable runnable) {
            this.$weakCallback = weakReference;
            this.this$0 = cVar;
            this.$cancelRunnable = runnable;
        }

        public final boolean getWasPaused() {
            return this.wasPaused;
        }

        @Override // com.vungle.ads.internal.util.c.C0535c
        public void onPause() {
            super.onPause();
            this.wasPaused = true;
            Handler handler = this.this$0.handler;
            if (handler != null) {
                handler.removeCallbacks(this.$cancelRunnable);
            }
        }

        @Override // com.vungle.ads.internal.util.c.C0535c
        public void onResume() {
            super.onResume();
            Handler handler = this.this$0.handler;
            if (handler != null) {
                handler.postDelayed(this.$cancelRunnable, c.Companion.getCONFIG_CHANGE_DELAY() * ((long) 2));
            }
        }

        @Override // com.vungle.ads.internal.util.c.C0535c
        public void onStop() {
            super.onStop();
            b bVar = this.$weakCallback.get();
            if (this.wasPaused && bVar != null && this.this$0.adLeftCallbacks.containsKey(bVar)) {
                bVar.onLeftApplication();
            }
            this.this$0.removeOnNextAppLeftCallback(bVar);
            Handler handler = this.this$0.handler;
            if (handler != null) {
                handler.removeCallbacks(this.$cancelRunnable);
            }
        }

        public final void setWasPaused(boolean z10) {
            this.wasPaused = z10;
        }
    }

    /* JADX INFO: compiled from: ActivityManager.kt */
    public static final class g implements Runnable {
        final /* synthetic */ WeakReference<b> $weakCallback;

        g(WeakReference<b> weakReference) {
            this.$weakCallback = weakReference;
        }

        @Override // java.lang.Runnable
        public void run() {
            Handler handler = c.this.handler;
            if (handler != null) {
                handler.removeCallbacks(this);
            }
            c.this.removeOnNextAppLeftCallback(this.$weakCallback.get());
        }
    }

    private c() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: configChangeRunnable$lambda-0, reason: not valid java name */
    public static final void m4114configChangeRunnable$lambda0(c this$0) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        if (this$0.getNoResumedActivities()) {
            d dVar = this$0.state;
            d dVar2 = d.PAUSED;
            if (dVar != dVar2) {
                this$0.state = dVar2;
                Iterator<C0535c> it = this$0.callbacks.iterator();
                while (it.hasNext()) {
                    it.next().onPause();
                }
            }
        }
        if (this$0.getNoStartedActivities() && this$0.state == d.PAUSED) {
            this$0.state = d.STOPPED;
            Iterator<C0535c> it2 = this$0.callbacks.iterator();
            while (it2.hasNext()) {
                it2.next().onStop();
            }
        }
    }

    private final boolean getNoResumedActivities() {
        return this.resumedActivities.isEmpty();
    }

    private final boolean getNoStartedActivities() {
        return this.startedActivities.isEmpty();
    }

    private final int getResumedActivitiesCount() {
        return this.resumedActivities.size();
    }

    private final int getStartedActivitiesCount() {
        return this.startedActivities.size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean inForeground() {
        return !this.isInitialized.get() || this.lastStoppedActivityName == null || isAppForeground();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: init$lambda-1, reason: not valid java name */
    public static final void m4115init$lambda1(Context context, c this$0) {
        kotlin.jvm.internal.t.i(context, "$context");
        kotlin.jvm.internal.t.i(this$0, "this$0");
        Context applicationContext = context.getApplicationContext();
        kotlin.jvm.internal.t.g(applicationContext, "null cannot be cast to non-null type android.app.Application");
        ((Application) applicationContext).registerActivityLifecycleCallbacks(this$0);
    }

    private final boolean isAppForeground() {
        return !this.resumedActivities.isEmpty();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void removeListener(C0535c c0535c) {
        this.callbacks.remove(c0535c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void removeOnNextAppLeftCallback(b bVar) {
        C0535c c0535cRemove;
        if (bVar == null || (c0535cRemove = this.adLeftCallbacks.remove(bVar)) == null) {
            return;
        }
        removeListener(c0535cRemove);
    }

    public final void addListener(@NotNull C0535c callback) {
        kotlin.jvm.internal.t.i(callback, "callback");
        this.callbacks.add(callback);
    }

    public final void addOnNextAppLeftCallback(@Nullable b bVar) {
        if (bVar == null) {
            return;
        }
        if (!this.isInitialized.get()) {
            bVar.onLeftApplication();
            return;
        }
        WeakReference weakReference = new WeakReference(bVar);
        g gVar = new g(weakReference);
        f fVar = new f(weakReference, this, gVar);
        this.adLeftCallbacks.put(bVar, fVar);
        if (!inForeground()) {
            instance.addListener(new e(weakReference, gVar));
            return;
        }
        Handler handler = this.handler;
        if (handler != null) {
            handler.postDelayed(gVar, TIMEOUT);
        }
        addListener(fVar);
    }

    @VisibleForTesting
    public final void deInit(@NotNull Context context) {
        kotlin.jvm.internal.t.i(context, "context");
        Context applicationContext = context.getApplicationContext();
        kotlin.jvm.internal.t.g(applicationContext, "null cannot be cast to non-null type android.app.Application");
        ((Application) applicationContext).unregisterActivityLifecycleCallbacks(this);
        this.startedActivities.clear();
        this.resumedActivities.clear();
        this.isInitialized.set(false);
        this.callbacks.clear();
        this.adLeftCallbacks.clear();
    }

    public final void init(@NotNull final Context context) {
        kotlin.jvm.internal.t.i(context, "context");
        if (this.isInitialized.getAndSet(true)) {
            return;
        }
        try {
            Handler handler = new Handler(Looper.getMainLooper());
            this.handler = handler;
            handler.post(new Runnable() { // from class: com.vungle.ads.internal.util.b
                @Override // java.lang.Runnable
                public final void run() {
                    c.m4115init$lambda1(context, this);
                }
            });
        } catch (Exception e10) {
            p.a aVar = p.Companion;
            String TAG2 = TAG;
            kotlin.jvm.internal.t.h(TAG2, "TAG");
            aVar.e(TAG2, "Error initializing ActivityManager", e10);
            this.isInitialized.set(false);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(@NotNull Activity activity, @Nullable Bundle bundle) {
        kotlin.jvm.internal.t.i(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(@NotNull Activity activity) {
        kotlin.jvm.internal.t.i(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(@NotNull Activity activity) {
        kotlin.jvm.internal.t.i(activity, "activity");
        this.resumedActivities.remove(activity.toString());
        if (getNoResumedActivities()) {
            Handler handler = this.handler;
            if (handler != null) {
                handler.removeCallbacks(this.configChangeRunnable);
            }
            Handler handler2 = this.handler;
            if (handler2 != null) {
                handler2.postDelayed(this.configChangeRunnable, CONFIG_CHANGE_DELAY);
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(@NotNull Activity activity) {
        kotlin.jvm.internal.t.i(activity, "activity");
        boolean noResumedActivities = getNoResumedActivities();
        this.resumedActivities.add(activity.toString());
        if (getResumedActivitiesCount() == 1) {
            if (noResumedActivities) {
                d dVar = d.RESUMED;
                if (!kotlin.collections.u.e(dVar).contains(this.state)) {
                    this.state = dVar;
                    Iterator<C0535c> it = this.callbacks.iterator();
                    while (it.hasNext()) {
                        it.next().onResume();
                    }
                    return;
                }
            }
            Handler handler = this.handler;
            if (handler != null) {
                handler.removeCallbacks(this.configChangeRunnable);
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(@NotNull Activity activity, @NotNull Bundle outState) {
        kotlin.jvm.internal.t.i(activity, "activity");
        kotlin.jvm.internal.t.i(outState, "outState");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(@NotNull Activity activity) {
        kotlin.jvm.internal.t.i(activity, "activity");
        this.startedActivities.add(activity.toString());
        if (getStartedActivitiesCount() == 1) {
            d dVar = d.STARTED;
            if (kotlin.collections.v.n(dVar, d.RESUMED).contains(this.state)) {
                return;
            }
            this.state = dVar;
            Iterator<C0535c> it = this.callbacks.iterator();
            while (it.hasNext()) {
                it.next().onStart();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(@NotNull Activity activity) {
        Handler handler;
        kotlin.jvm.internal.t.i(activity, "activity");
        this.lastStoppedActivityName = activity.toString();
        this.startedActivities.remove(activity.toString());
        if (!getNoStartedActivities() || (handler = this.handler) == null) {
            return;
        }
        handler.removeCallbacks(this.configChangeRunnable);
        handler.postDelayed(this.configChangeRunnable, CONFIG_CHANGE_DELAY);
    }

    /* JADX INFO: compiled from: ActivityManager.kt */
    public static final class a {

        /* JADX INFO: renamed from: com.vungle.ads.internal.util.c$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: ActivityManager.kt */
        public static final class C0534a extends C0535c {
            final /* synthetic */ com.vungle.ads.internal.ui.b $adOpenCallback;
            final /* synthetic */ Intent $deepLinkOverrideIntent;
            final /* synthetic */ Intent $defaultIntent;
            final /* synthetic */ b $leftCallback;
            final /* synthetic */ WeakReference<Context> $weakContext;

            C0534a(WeakReference<Context> weakReference, Intent intent, Intent intent2, com.vungle.ads.internal.ui.b bVar, b bVar2) {
                this.$weakContext = weakReference;
                this.$deepLinkOverrideIntent = intent;
                this.$defaultIntent = intent2;
                this.$adOpenCallback = bVar;
                this.$leftCallback = bVar2;
            }

            @Override // com.vungle.ads.internal.util.c.C0535c
            public void onStart() {
                super.onStart();
                a aVar = c.Companion;
                aVar.getInstance$vungle_ads_release().removeListener(this);
                Context context = this.$weakContext.get();
                if (context == null || !aVar.startActivityHandleException(context, this.$deepLinkOverrideIntent, this.$defaultIntent, this.$adOpenCallback)) {
                    return;
                }
                aVar.getInstance$vungle_ads_release().addOnNextAppLeftCallback(this.$leftCallback);
            }
        }

        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean startActivityHandleException(Context context, Intent intent, Intent intent2, com.vungle.ads.internal.ui.b bVar) {
            if (intent == null && intent2 == null) {
                return false;
            }
            try {
                if (intent != null) {
                    context.startActivity(intent);
                    if (bVar != null) {
                        bVar.onDeeplinkClick(true);
                    }
                } else {
                    context.startActivity(intent2);
                }
                return true;
            } catch (Exception e10) {
                p.a aVar = p.Companion;
                String TAG = getTAG();
                kotlin.jvm.internal.t.h(TAG, "TAG");
                aVar.e(TAG, "Cannot launch/find activity to handle the Implicit intent: " + e10);
                if (intent != null) {
                    try {
                        com.vungle.ads.o.INSTANCE.logError$vungle_ads_release(312, "Fail to open " + intent.getDataString(), (28 & 4) != 0 ? null : "", (28 & 8) != 0 ? null : null, (28 & 16) != 0 ? null : null);
                        if (bVar != null) {
                            bVar.onDeeplinkClick(false);
                        }
                    } catch (Exception unused) {
                        return false;
                    }
                }
                if (intent != null && intent2 != null) {
                    context.startActivity(intent2);
                    return true;
                }
                return false;
            }
        }

        public final void addLifecycleListener(@NotNull C0535c listener) {
            kotlin.jvm.internal.t.i(listener, "listener");
            getInstance$vungle_ads_release().addListener(listener);
        }

        public final long getCONFIG_CHANGE_DELAY() {
            return c.CONFIG_CHANGE_DELAY;
        }

        @NotNull
        public final c getInstance$vungle_ads_release() {
            return c.instance;
        }

        public final String getTAG() {
            return c.TAG;
        }

        public final long getTIMEOUT() {
            return c.TIMEOUT;
        }

        public final void init(@NotNull Context context) {
            kotlin.jvm.internal.t.i(context, "context");
            getInstance$vungle_ads_release().init(context);
        }

        public final boolean isForeground() {
            return getInstance$vungle_ads_release().inForeground();
        }

        public final void startWhenForeground(@NotNull Context context, @Nullable Intent intent, @Nullable Intent intent2, @Nullable b bVar, @Nullable com.vungle.ads.internal.ui.b bVar2) {
            kotlin.jvm.internal.t.i(context, "context");
            WeakReference weakReference = new WeakReference(context);
            if (!getInstance$vungle_ads_release().inForeground()) {
                getInstance$vungle_ads_release().addListener(new C0534a(weakReference, intent, intent2, bVar2, bVar));
            } else if (startActivityHandleException(context, intent, intent2, bVar2)) {
                getInstance$vungle_ads_release().addOnNextAppLeftCallback(bVar);
            }
        }

        public final void startWhenForeground(@NotNull Context context, @Nullable Intent intent, @Nullable Intent intent2, @Nullable b bVar) {
            kotlin.jvm.internal.t.i(context, "context");
            startWhenForeground(context, intent, intent2, bVar, null);
        }

        @VisibleForTesting
        public static /* synthetic */ void getCONFIG_CHANGE_DELAY$annotations() {
        }

        @VisibleForTesting(otherwise = 2)
        public static /* synthetic */ void getInstance$vungle_ads_release$annotations() {
        }

        @VisibleForTesting
        public static /* synthetic */ void getTIMEOUT$annotations() {
        }
    }

    /* JADX INFO: renamed from: com.vungle.ads.internal.util.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ActivityManager.kt */
    public static class C0535c {
        public void onPause() {
        }

        public void onResume() {
        }

        public void onStart() {
        }

        public void onStop() {
        }
    }
}
