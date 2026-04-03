package com.moloco.sdk.internal.services;

import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import com.moloco.sdk.internal.MolocoLogger;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class a implements DefaultLifecycleObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public final com.moloco.sdk.internal.services.analytics.a f18397a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public final r f18398b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public Long f18399c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f18400d;

    public a(@NotNull com.moloco.sdk.internal.services.analytics.a analyticsService, @NotNull r timeProviderService) {
        kotlin.jvm.internal.t.i(analyticsService, "analyticsService");
        kotlin.jvm.internal.t.i(timeProviderService, "timeProviderService");
        this.f18397a = analyticsService;
        this.f18398b = timeProviderService;
    }

    public final void a() {
        this.f18400d = true;
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public /* synthetic */ void onCreate(LifecycleOwner lifecycleOwner) {
        androidx.lifecycle.c.a(this, lifecycleOwner);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public /* synthetic */ void onDestroy(LifecycleOwner lifecycleOwner) {
        androidx.lifecycle.c.b(this, lifecycleOwner);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public /* synthetic */ void onPause(LifecycleOwner lifecycleOwner) {
        androidx.lifecycle.c.c(this, lifecycleOwner);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public /* synthetic */ void onResume(LifecycleOwner lifecycleOwner) {
        androidx.lifecycle.c.d(this, lifecycleOwner);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onStart(@NotNull LifecycleOwner owner) {
        kotlin.jvm.internal.t.i(owner, "owner");
        androidx.lifecycle.c.e(this, owner);
        MolocoLogger molocoLogger = MolocoLogger.INSTANCE;
        MolocoLogger.debug$default(molocoLogger, "SingleObserverBackgroundThenForegroundAnalyticsListener", "Application onStart", false, 4, null);
        Long l10 = this.f18399c;
        if (l10 != null) {
            MolocoLogger.debug$default(molocoLogger, "SingleObserverBackgroundThenForegroundAnalyticsListener", "Background event has been recorded, recording foreground", false, 4, null);
            this.f18397a.b(this.f18398b.invoke(), l10.longValue());
            this.f18399c = null;
            this.f18400d = false;
        }
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onStop(@NotNull LifecycleOwner owner) {
        kotlin.jvm.internal.t.i(owner, "owner");
        androidx.lifecycle.c.f(this, owner);
        MolocoLogger molocoLogger = MolocoLogger.INSTANCE;
        MolocoLogger.debug$default(molocoLogger, "SingleObserverBackgroundThenForegroundAnalyticsListener", "Application onStop", false, 4, null);
        if (this.f18400d) {
            MolocoLogger.debug$default(molocoLogger, "SingleObserverBackgroundThenForegroundAnalyticsListener", "Tracking of event is true. Recording background", false, 4, null);
            long jInvoke = this.f18398b.invoke();
            this.f18399c = Long.valueOf(jInvoke);
            this.f18397a.a(jInvoke);
        }
    }
}
