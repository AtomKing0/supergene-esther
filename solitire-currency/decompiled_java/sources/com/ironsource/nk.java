package com.ironsource;

import android.content.Context;
import com.ironsource.el;
import com.ironsource.environment.thread.IronSourceThreadManager;
import com.ironsource.ig;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.nk;
import com.ironsource.oe;
import com.ironsource.x1;
import com.unity3d.mediation.LevelPlay;
import com.unity3d.mediation.LevelPlayConfiguration;
import com.unity3d.mediation.LevelPlayInitError;
import com.unity3d.mediation.LevelPlayInitListener;
import com.unity3d.mediation.LevelPlayInitRequest;
import java.util.Arrays;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class nk {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final nk f14147a = new nk();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private static final ok f14148b = new ok();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final boolean f14149c = false;

    public static final class a implements hq {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ LevelPlayInitRequest f14150a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Context f14151b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ ta f14152c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ LevelPlayInitListener f14153d;

        a(LevelPlayInitRequest levelPlayInitRequest, Context context, ta taVar, LevelPlayInitListener levelPlayInitListener) {
            this.f14150a = levelPlayInitRequest;
            this.f14151b = context;
            this.f14152c = taVar;
            this.f14153d = levelPlayInitListener;
        }

        @Override // com.ironsource.hq
        public void a(@NotNull final bq sdkConfig) {
            kotlin.jvm.internal.t.i(sdkConfig, "sdkConfig");
            ok okVar = nk.f14148b;
            final LevelPlayInitRequest levelPlayInitRequest = this.f14150a;
            final Context context = this.f14151b;
            final ta taVar = this.f14152c;
            final LevelPlayInitListener levelPlayInitListener = this.f14153d;
            okVar.a(new Runnable() { // from class: com.ironsource.ky
                @Override // java.lang.Runnable
                public final void run() {
                    nk.a.a(levelPlayInitRequest, sdkConfig, context, taVar, levelPlayInitListener);
                }
            });
        }

        @Override // com.ironsource.hq
        public void a(@NotNull final dq error) {
            kotlin.jvm.internal.t.i(error, "error");
            ok okVar = nk.f14148b;
            final LevelPlayInitListener levelPlayInitListener = this.f14153d;
            final ta taVar = this.f14152c;
            okVar.a(new Runnable() { // from class: com.ironsource.jy
                @Override // java.lang.Runnable
                public final void run() {
                    nk.a.a(levelPlayInitListener, taVar, error);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void a(LevelPlayInitListener levelPlayInitListener, ta initDuration, dq error) {
            kotlin.jvm.internal.t.i(initDuration, "$initDuration");
            kotlin.jvm.internal.t.i(error, "$error");
            nk.f14147a.a(levelPlayInitListener, initDuration, error);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void a(LevelPlayInitRequest initRequest, bq sdkConfig, Context context, ta initDuration, LevelPlayInitListener levelPlayInitListener) {
            kotlin.jvm.internal.t.i(initRequest, "$initRequest");
            kotlin.jvm.internal.t.i(sdkConfig, "$sdkConfig");
            kotlin.jvm.internal.t.i(context, "$context");
            kotlin.jvm.internal.t.i(initDuration, "$initDuration");
            nk.f14147a.a(initRequest, sdkConfig, context, initDuration, levelPlayInitListener);
        }
    }

    public static final class b implements hq {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ LevelPlayInitRequest f14154a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Context f14155b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ ta f14156c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ LevelPlayInitListener f14157d;

        b(LevelPlayInitRequest levelPlayInitRequest, Context context, ta taVar, LevelPlayInitListener levelPlayInitListener) {
            this.f14154a = levelPlayInitRequest;
            this.f14155b = context;
            this.f14156c = taVar;
            this.f14157d = levelPlayInitListener;
        }

        @Override // com.ironsource.hq
        public void a(@NotNull final bq sdkConfig) {
            kotlin.jvm.internal.t.i(sdkConfig, "sdkConfig");
            ok okVar = nk.f14148b;
            final LevelPlayInitRequest levelPlayInitRequest = this.f14154a;
            final Context context = this.f14155b;
            final ta taVar = this.f14156c;
            final LevelPlayInitListener levelPlayInitListener = this.f14157d;
            okVar.a(new Runnable() { // from class: com.ironsource.my
                @Override // java.lang.Runnable
                public final void run() {
                    nk.b.a(levelPlayInitRequest, sdkConfig, context, taVar, levelPlayInitListener);
                }
            });
        }

        @Override // com.ironsource.hq
        public void a(@NotNull final dq error) {
            kotlin.jvm.internal.t.i(error, "error");
            ok okVar = nk.f14148b;
            final LevelPlayInitListener levelPlayInitListener = this.f14157d;
            final ta taVar = this.f14156c;
            okVar.a(new Runnable() { // from class: com.ironsource.ly
                @Override // java.lang.Runnable
                public final void run() {
                    nk.b.a(levelPlayInitListener, taVar, error);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void a(LevelPlayInitListener levelPlayInitListener, ta initDuration, dq error) {
            kotlin.jvm.internal.t.i(initDuration, "$initDuration");
            kotlin.jvm.internal.t.i(error, "$error");
            nk.f14147a.a(levelPlayInitListener, initDuration, error);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void a(LevelPlayInitRequest initRequest, bq sdkConfig, Context context, ta initDuration, LevelPlayInitListener levelPlayInitListener) {
            kotlin.jvm.internal.t.i(initRequest, "$initRequest");
            kotlin.jvm.internal.t.i(sdkConfig, "$sdkConfig");
            kotlin.jvm.internal.t.i(context, "$context");
            kotlin.jvm.internal.t.i(initDuration, "$initDuration");
            nk.f14147a.a(initRequest, sdkConfig, context, initDuration, levelPlayInitListener);
        }
    }

    private nk() {
    }

    private final void c(Context context, LevelPlayInitRequest levelPlayInitRequest, LevelPlayInitListener levelPlayInitListener) {
        ta taVar = new ta();
        ok okVar = f14148b;
        LevelPlay.AdFormat[] adFormatArr = (LevelPlay.AdFormat[]) levelPlayInitRequest.getLegacyAdFormats().toArray(new LevelPlay.AdFormat[0]);
        iq iqVar = new iq(levelPlayInitRequest.getAppKey(), levelPlayInitRequest.getUserId(), kotlin.collections.p.q0(okVar.a((LevelPlay.AdFormat[]) Arrays.copyOf(adFormatArr, adFormatArr.length))));
        iqVar.e().isEmpty();
        pq.f14391a.a(context, iqVar, new a(levelPlayInitRequest, context, taVar, levelPlayInitListener));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(Context context, LevelPlayInitRequest initRequest, LevelPlayInitListener levelPlayInitListener) {
        kotlin.jvm.internal.t.i(context, "$context");
        kotlin.jvm.internal.t.i(initRequest, "$initRequest");
        f14147a.c(context, initRequest, levelPlayInitListener);
    }

    public final void a(@NotNull final Context context, @NotNull final LevelPlayInitRequest initRequest, @Nullable final LevelPlayInitListener levelPlayInitListener) {
        kotlin.jvm.internal.t.i(context, "context");
        kotlin.jvm.internal.t.i(initRequest, "initRequest");
        f14148b.d(new Runnable() { // from class: com.ironsource.iy
            @Override // java.lang.Runnable
            public final void run() {
                nk.b(context, initRequest, levelPlayInitListener);
            }
        });
    }

    public static /* synthetic */ void a(nk nkVar, Context context, LevelPlayInitRequest levelPlayInitRequest, LevelPlayInitListener levelPlayInitListener, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            levelPlayInitListener = null;
        }
        nkVar.a(context, levelPlayInitRequest, levelPlayInitListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LevelPlayInitListener levelPlayInitListener, ak config) {
        kotlin.jvm.internal.t.i(config, "$config");
        if (levelPlayInitListener != null) {
            levelPlayInitListener.onInitSuccess(new LevelPlayConfiguration(config.k()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LevelPlayInitListener levelPlayInitListener, dq error) {
        kotlin.jvm.internal.t.i(error, "$error");
        if (levelPlayInitListener != null) {
            levelPlayInitListener.onInitFailed(new LevelPlayInitError(error));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(final LevelPlayInitListener levelPlayInitListener, ta taVar, final dq dqVar) {
        long jA = ta.a(taVar);
        ok okVar = f14148b;
        okVar.a(dqVar, jA);
        okVar.e(new Runnable() { // from class: com.ironsource.hy
            @Override // java.lang.Runnable
            public final void run() {
                nk.a(levelPlayInitListener, dqVar);
            }
        });
    }

    private final void a(LevelPlayInitRequest levelPlayInitRequest, ak akVar) {
        LevelPlay.AdFormat adFormat = LevelPlay.AdFormat.INTERSTITIAL;
        if (a(levelPlayInitRequest, adFormat) && akVar.d().c().d() != null) {
            di diVarA = di.A.a(new zh(), akVar, true);
            List<rm> listB = akVar.b(adFormat);
            IronSource.AD_UNIT ad_unit = IronSource.AD_UNIT.INTERSTITIAL;
            x1.b bVar = x1.b.MEDIATION;
            new no(new p2(new k1(ad_unit, bVar), diVarA, bVar), adFormat, listB, diVarA).a();
        }
        LevelPlay.AdFormat adFormat2 = LevelPlay.AdFormat.BANNER;
        if (!a(levelPlayInitRequest, adFormat2) || akVar.d().c().c() == null) {
            return;
        }
        f6 f6VarA = f6.A.a(new c6(), akVar, true);
        List<rm> listB2 = akVar.b(adFormat2);
        IronSource.AD_UNIT ad_unit2 = IronSource.AD_UNIT.BANNER;
        x1.b bVar2 = x1.b.MEDIATION;
        new no(new p2(new k1(ad_unit2, bVar2), f6VarA, bVar2), adFormat2, listB2, f6VarA).a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(LevelPlayInitRequest levelPlayInitRequest, bq bqVar, Context context, ta taVar, final LevelPlayInitListener levelPlayInitListener) {
        el.b bVar = el.f11917p;
        ig.a aVarZ = bVar.a().z();
        final ak akVar = new ak(bqVar);
        if (akVar.l()) {
            f14148b.a(context);
        }
        oe.a aVarA = bVar.a().a();
        ok okVar = f14148b;
        akVar.b(okVar).a(aVarA);
        akVar.a(okVar).a(bVar.a().u());
        okVar.a(ta.a(taVar), bqVar.f());
        f14147a.a(levelPlayInitRequest, akVar);
        bVar.a().z().d();
        okVar.e(new Runnable() { // from class: com.ironsource.gy
            @Override // java.lang.Runnable
            public final void run() {
                nk.a(levelPlayInitListener, akVar);
            }
        });
        aVarZ.a(akVar);
        if (bqVar.a().e()) {
            new uo(null, null, null, IronSourceThreadManager.INSTANCE.getThreadPoolExecutor(), 7, null).c(context);
        }
    }

    private final boolean a(LevelPlayInitRequest levelPlayInitRequest, LevelPlay.AdFormat adFormat) {
        return !levelPlayInitRequest.getLegacyAdFormats().contains(adFormat);
    }
}
