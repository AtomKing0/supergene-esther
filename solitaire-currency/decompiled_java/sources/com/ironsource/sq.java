package com.ironsource;

import android.content.Context;
import android.text.TextUtils;
import com.ironsource.cr;
import com.ironsource.environment.thread.IronSourceThreadManager;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class sq {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final vi f15326a = new vi();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final hh f15327b = new hh(IronSourceThreadManager.INSTANCE.getInitHandler());

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final ce f15328c = el.f11917p.d().f();

    public static final class a extends yp {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Runnable f15329a;

        a(Runnable runnable) {
            this.f15329a = runnable;
        }

        @Override // com.ironsource.yp
        public void a() {
            this.f15329a.run();
        }
    }

    @NotNull
    public final ce a() {
        return this.f15328c;
    }

    @NotNull
    public final vi b() {
        return this.f15326a;
    }

    public final void c(@NotNull Runnable runnable) {
        kotlin.jvm.internal.t.i(runnable, "runnable");
        this.f15327b.b(runnable);
    }

    public final void d() {
        com.ironsource.mediationsdk.p.m().U();
    }

    public final void e() {
        rp.i().a(new kb(IronSourceConstants.USING_CACHE_FOR_INIT_EVENT, IronSourceUtils.getMediationAdditionalData(false)));
    }

    @Nullable
    public final cr a(@NotNull Context context, @NotNull String appKey) {
        kotlin.jvm.internal.t.i(context, "context");
        kotlin.jvm.internal.t.i(appKey, "appKey");
        return com.ironsource.mediationsdk.p.m().a(context, appKey);
    }

    @NotNull
    public final String b(@NotNull Context context) {
        kotlin.jvm.internal.t.i(context, "context");
        String strJ = this.f15328c.J(context);
        kotlin.jvm.internal.t.h(strJ, "deviceInfoService.getOrG…UniqueIdentifier(context)");
        return strJ;
    }

    public final boolean c() {
        return IronSourceUtils.isEncryptedResponse();
    }

    public final void d(@NotNull Runnable callback) {
        kotlin.jvm.internal.t.i(callback, "callback");
        IronSourceThreadManager.postOnUiThreadTask$default(IronSourceThreadManager.INSTANCE, callback, 0L, 2, null);
    }

    public final void e(@NotNull Runnable callback) {
        kotlin.jvm.internal.t.i(callback, "callback");
        IronSourceThreadManager.postOnUiThreadTask$default(IronSourceThreadManager.INSTANCE, new a(callback), 0L, 2, null);
    }

    @NotNull
    public final String a(@NotNull Context context) {
        kotlin.jvm.internal.t.i(context, "context");
        String strB = com.ironsource.mediationsdk.p.m().b(context);
        kotlin.jvm.internal.t.h(strB, "getInstance().getAdvertiserId(context)");
        return strB;
    }

    public final void b(@NotNull yp safeRunnable) {
        kotlin.jvm.internal.t.i(safeRunnable, "safeRunnable");
        this.f15327b.a(safeRunnable);
    }

    public final boolean c(@NotNull Context context) {
        kotlin.jvm.internal.t.i(context, "context");
        return IronSourceUtils.isNetworkConnected(context);
    }

    public final void a(long j10, @NotNull cr.a responseOrigin) {
        kotlin.jvm.internal.t.i(responseOrigin, "responseOrigin");
        com.ironsource.mediationsdk.p.m().a(j10, responseOrigin);
    }

    public final void b(@NotNull Runnable runnable) {
        kotlin.jvm.internal.t.i(runnable, "runnable");
        IronSourceThreadManager.postMediationBackgroundTask$default(IronSourceThreadManager.INSTANCE, runnable, 0L, 2, null);
    }

    public final void a(@NotNull qq initStatus) {
        kotlin.jvm.internal.t.i(initStatus, "initStatus");
        rq.f14723a.a(initStatus);
    }

    public static /* synthetic */ void a(sq sqVar, yp ypVar, long j10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            j10 = 0;
        }
        sqVar.a(ypVar, j10);
    }

    public static /* synthetic */ void a(sq sqVar, Runnable runnable, long j10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            j10 = 0;
        }
        sqVar.a(runnable, j10);
    }

    public final void a(@NotNull w3 reporterSettings) {
        kotlin.jvm.internal.t.i(reporterSettings, "reporterSettings");
        i9.d().a(reporterSettings.b(), reporterSettings.d(), reporterSettings.c(), reporterSettings.e(), IronSourceUtils.getSessionId(), reporterSettings.a(), reporterSettings.g());
    }

    public final void a(@NotNull yp safeRunnable) {
        kotlin.jvm.internal.t.i(safeRunnable, "safeRunnable");
        a(this, safeRunnable, 0L, 2, (Object) null);
    }

    public final void a(@NotNull yp safeRunnable, long j10) {
        kotlin.jvm.internal.t.i(safeRunnable, "safeRunnable");
        this.f15327b.a(safeRunnable, j10);
    }

    public final void a(@NotNull Runnable callback) {
        kotlin.jvm.internal.t.i(callback, "callback");
        this.f15327b.a(callback);
    }

    public final void a(@NotNull Runnable runnable, long j10) {
        kotlin.jvm.internal.t.i(runnable, "runnable");
        IronSourceThreadManager.INSTANCE.postOnUiThreadTask(runnable, j10);
    }

    public final void a(@NotNull String key, @NotNull String value) {
        kotlin.jvm.internal.t.i(key, "key");
        kotlin.jvm.internal.t.i(value, "value");
        if (TextUtils.isEmpty(value)) {
            return;
        }
        xc.a().a(key, value);
    }
}
