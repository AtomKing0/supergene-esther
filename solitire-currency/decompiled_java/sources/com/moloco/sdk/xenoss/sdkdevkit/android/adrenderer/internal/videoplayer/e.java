package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer;

import android.content.Context;
import android.os.Looper;
import android.view.InflateException;
import androidx.annotation.MainThread;
import androidx.lifecycle.Lifecycle;
import b4.b0;
import com.google.android.exoplayer2.ui.a0;
import com.moloco.sdk.internal.MolocoLogger;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.l;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i;
import h9.p;
import java.util.List;
import k2.n2;
import k2.n3;
import k2.q2;
import k2.r2;
import k2.s;
import k2.s3;
import k2.t2;
import k2.w1;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.v;
import kotlinx.coroutines.b2;
import kotlinx.coroutines.o;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.p0;
import kotlinx.coroutines.y0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import s9.j;
import s9.m0;
import s9.y;
import v8.k0;
import v8.t;
import v8.u;
import x3.z;
import z3.k;

/* JADX INFO: loaded from: classes4.dex */
@MainThread
public final class e implements com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public final Context f21475a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f21476b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.f f21477c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    public final String f21478d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    public final o0 f21479e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    public final y<i> f21480f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NotNull
    public final m0<i> f21481g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NotNull
    public final y<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.b> f21482h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NotNull
    public final m0<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.b> f21483i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NotNull
    public final y<l> f21484j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @NotNull
    public final m0<l> f21485k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @Nullable
    public final a0 f21486l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @Nullable
    public String f21487m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f21488n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Looper f21489o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @Nullable
    public s f21490p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @Nullable
    public com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.c f21491q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f21492r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @NotNull
    public final d f21493s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @NotNull
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.a f21494t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public long f21495u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    @Nullable
    public b2 f21496v;

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.SimplifiedExoPlayer$1", f = "SimplifiedExoPlayer.kt", l = {}, m = "invokeSuspend")
    public static final class a extends kotlin.coroutines.jvm.internal.l implements p<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.b, z8.d<? super k0>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f21497j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public /* synthetic */ Object f21498k;

        public a(z8.d<? super a> dVar) {
            super(2, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            a aVar = e.this.new a(dVar);
            aVar.f21498k = obj;
            return aVar;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.b bVar, @Nullable z8.d<? super k0> dVar) {
            return ((a) create(bVar, dVar)).invokeSuspend(k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            a9.d.e();
            if (this.f21497j != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            u.b(obj);
            if (((com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.b) this.f21498k).b()) {
                e.this.n();
            } else {
                b2 b2Var = e.this.f21496v;
                if (b2Var != null) {
                    b2.a.a(b2Var, null, 1, null);
                }
            }
            return k0.f35197a;
        }
    }

    public static final class b extends v implements h9.l<Throwable, k0> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ s f21500g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ c f21501h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(s sVar, c cVar) {
            super(1);
            this.f21500g = sVar;
            this.f21501h = cVar;
        }

        public final void a(@Nullable Throwable th) {
            this.f21500g.f(this.f21501h);
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(Throwable th) {
            a(th);
            return k0.f35197a;
        }
    }

    public static final class c implements r2.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f21502a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ s f21503b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ o<k0> f21504c;

        /* JADX WARN: Multi-variable type inference failed */
        public c(int i10, s sVar, o<? super k0> oVar) {
            this.f21502a = i10;
            this.f21503b = sVar;
            this.f21504c = oVar;
        }

        @Override // k2.r2.d
        public /* synthetic */ void B(k2.o oVar) {
            t2.d(this, oVar);
        }

        @Override // k2.r2.d
        public /* synthetic */ void D(r2.e eVar, r2.e eVar2, int i10) {
            t2.u(this, eVar, eVar2, i10);
        }

        @Override // k2.r2.d
        public /* synthetic */ void E(n2 n2Var) {
            t2.r(this, n2Var);
        }

        @Override // k2.r2.d
        public /* synthetic */ void F(r2.b bVar) {
            t2.a(this, bVar);
        }

        @Override // k2.r2.d
        public /* synthetic */ void G(s3 s3Var) {
            t2.D(this, s3Var);
        }

        @Override // k2.r2.d
        public /* synthetic */ void H(z zVar) {
            t2.C(this, zVar);
        }

        @Override // k2.r2.d
        public /* synthetic */ void a(n3.f fVar) {
            t2.c(this, fVar);
        }

        @Override // k2.r2.d
        public /* synthetic */ void f(b0 b0Var) {
            t2.E(this, b0Var);
        }

        @Override // k2.r2.d
        public /* synthetic */ void h(q2 q2Var) {
            t2.n(this, q2Var);
        }

        @Override // k2.r2.d
        public /* synthetic */ void j(c3.a aVar) {
            t2.l(this, aVar);
        }

        @Override // k2.r2.d
        public /* synthetic */ void m(k2.b2 b2Var) {
            t2.k(this, b2Var);
        }

        @Override // k2.r2.d
        public /* synthetic */ void onCues(List list) {
            t2.b(this, list);
        }

        @Override // k2.r2.d
        public /* synthetic */ void onDeviceVolumeChanged(int i10, boolean z10) {
            t2.e(this, i10, z10);
        }

        @Override // k2.r2.d
        public /* synthetic */ void onIsLoadingChanged(boolean z10) {
            t2.g(this, z10);
        }

        @Override // k2.r2.d
        public /* synthetic */ void onIsPlayingChanged(boolean z10) {
            t2.h(this, z10);
        }

        @Override // k2.r2.d
        public /* synthetic */ void onLoadingChanged(boolean z10) {
            t2.i(this, z10);
        }

        @Override // k2.r2.d
        public /* synthetic */ void onPlayWhenReadyChanged(boolean z10, int i10) {
            t2.m(this, z10, i10);
        }

        @Override // k2.r2.d
        public void onPlaybackStateChanged(int i10) {
            if (i10 == this.f21502a) {
                this.f21503b.f(this);
                o<k0> oVar = this.f21504c;
                t.a aVar = t.f35208b;
                oVar.resumeWith(t.b(k0.f35197a));
            }
        }

        @Override // k2.r2.d
        public /* synthetic */ void onPlaybackSuppressionReasonChanged(int i10) {
            t2.p(this, i10);
        }

        @Override // k2.r2.d
        public /* synthetic */ void onPlayerStateChanged(boolean z10, int i10) {
            t2.s(this, z10, i10);
        }

        @Override // k2.r2.d
        public /* synthetic */ void onPositionDiscontinuity(int i10) {
            t2.t(this, i10);
        }

        @Override // k2.r2.d
        public /* synthetic */ void onRenderedFirstFrame() {
            t2.v(this);
        }

        @Override // k2.r2.d
        public /* synthetic */ void onRepeatModeChanged(int i10) {
            t2.w(this, i10);
        }

        @Override // k2.r2.d
        public /* synthetic */ void onShuffleModeEnabledChanged(boolean z10) {
            t2.y(this, z10);
        }

        @Override // k2.r2.d
        public /* synthetic */ void onSkipSilenceEnabledChanged(boolean z10) {
            t2.z(this, z10);
        }

        @Override // k2.r2.d
        public /* synthetic */ void onSurfaceSizeChanged(int i10, int i11) {
            t2.A(this, i10, i11);
        }

        @Override // k2.r2.d
        public /* synthetic */ void onVolumeChanged(float f10) {
            t2.F(this, f10);
        }

        @Override // k2.r2.d
        public /* synthetic */ void t(r2 r2Var, r2.c cVar) {
            t2.f(this, r2Var, cVar);
        }

        @Override // k2.r2.d
        public /* synthetic */ void u(n2 n2Var) {
            t2.q(this, n2Var);
        }

        @Override // k2.r2.d
        public /* synthetic */ void x(w1 w1Var, int i10) {
            t2.j(this, w1Var, i10);
        }

        @Override // k2.r2.d
        public /* synthetic */ void y() {
            t2.x(this);
        }

        @Override // k2.r2.d
        public /* synthetic */ void z(n3 n3Var, int i10) {
            t2.B(this, n3Var, i10);
        }
    }

    public static final class d implements r2.d {
        public d() {
        }

        @Override // k2.r2.d
        public /* synthetic */ void B(k2.o oVar) {
            t2.d(this, oVar);
        }

        @Override // k2.r2.d
        public /* synthetic */ void D(r2.e eVar, r2.e eVar2, int i10) {
            t2.u(this, eVar, eVar2, i10);
        }

        @Override // k2.r2.d
        public /* synthetic */ void E(n2 n2Var) {
            t2.r(this, n2Var);
        }

        @Override // k2.r2.d
        public /* synthetic */ void F(r2.b bVar) {
            t2.a(this, bVar);
        }

        @Override // k2.r2.d
        public /* synthetic */ void G(s3 s3Var) {
            t2.D(this, s3Var);
        }

        @Override // k2.r2.d
        public /* synthetic */ void H(z zVar) {
            t2.C(this, zVar);
        }

        @Override // k2.r2.d
        public /* synthetic */ void a(n3.f fVar) {
            t2.c(this, fVar);
        }

        @Override // k2.r2.d
        public /* synthetic */ void f(b0 b0Var) {
            t2.E(this, b0Var);
        }

        @Override // k2.r2.d
        public /* synthetic */ void h(q2 q2Var) {
            t2.n(this, q2Var);
        }

        @Override // k2.r2.d
        public /* synthetic */ void j(c3.a aVar) {
            t2.l(this, aVar);
        }

        @Override // k2.r2.d
        public /* synthetic */ void m(k2.b2 b2Var) {
            t2.k(this, b2Var);
        }

        @Override // k2.r2.d
        public /* synthetic */ void onCues(List list) {
            t2.b(this, list);
        }

        @Override // k2.r2.d
        public /* synthetic */ void onDeviceVolumeChanged(int i10, boolean z10) {
            t2.e(this, i10, z10);
        }

        @Override // k2.r2.d
        public /* synthetic */ void onIsLoadingChanged(boolean z10) {
            t2.g(this, z10);
        }

        @Override // k2.r2.d
        public void onIsPlayingChanged(boolean z10) {
            t2.h(this, z10);
            s sVarT = e.this.T();
            long duration = sVarT != null ? sVarT.getDuration() : 0L;
            s sVarT2 = e.this.T();
            e.this.f21482h.setValue(new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.b(z10, true, duration - (sVarT2 != null ? sVarT2.getCurrentPosition() : 0L) > 0));
        }

        @Override // k2.r2.d
        public /* synthetic */ void onLoadingChanged(boolean z10) {
            t2.i(this, z10);
        }

        @Override // k2.r2.d
        public /* synthetic */ void onPlayWhenReadyChanged(boolean z10, int i10) {
            t2.m(this, z10, i10);
        }

        @Override // k2.r2.d
        public void onPlaybackStateChanged(int i10) {
            t2.o(this, i10);
            if (i10 == 4) {
                e eVar = e.this;
                s sVarT = e.this.T();
                eVar.v(new i.a(sVarT != null ? sVarT.getDuration() : 1L));
                e.this.m();
            }
        }

        @Override // k2.r2.d
        public /* synthetic */ void onPlaybackSuppressionReasonChanged(int i10) {
            t2.p(this, i10);
        }

        @Override // k2.r2.d
        public /* synthetic */ void onPlayerStateChanged(boolean z10, int i10) {
            t2.s(this, z10, i10);
        }

        @Override // k2.r2.d
        public /* synthetic */ void onPositionDiscontinuity(int i10) {
            t2.t(this, i10);
        }

        @Override // k2.r2.d
        public /* synthetic */ void onRenderedFirstFrame() {
            t2.v(this);
        }

        @Override // k2.r2.d
        public /* synthetic */ void onRepeatModeChanged(int i10) {
            t2.w(this, i10);
        }

        @Override // k2.r2.d
        public /* synthetic */ void onShuffleModeEnabledChanged(boolean z10) {
            t2.y(this, z10);
        }

        @Override // k2.r2.d
        public /* synthetic */ void onSkipSilenceEnabledChanged(boolean z10) {
            t2.z(this, z10);
        }

        @Override // k2.r2.d
        public /* synthetic */ void onSurfaceSizeChanged(int i10, int i11) {
            t2.A(this, i10, i11);
        }

        @Override // k2.r2.d
        public /* synthetic */ void onVolumeChanged(float f10) {
            t2.F(this, f10);
        }

        @Override // k2.r2.d
        public /* synthetic */ void t(r2 r2Var, r2.c cVar) {
            t2.f(this, r2Var, cVar);
        }

        @Override // k2.r2.d
        public void u(@NotNull n2 error) {
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.c cVar;
            kotlin.jvm.internal.t.i(error, "error");
            t2.q(this, error);
            MolocoLogger molocoLogger = MolocoLogger.INSTANCE;
            MolocoLogger.error$default(molocoLogger, e.this.f21478d, "Exoplayer error (streaming enabled = " + e.this.f21476b + ')', error, false, 8, null);
            if (e.this.f21476b && (cVar = e.this.f21491q) != null && cVar.i()) {
                i iVar = (i) e.this.f21480f.getValue();
                if ((iVar instanceof i.a) || (iVar instanceof i.c)) {
                    MolocoLogger.info$default(molocoLogger, e.this.f21478d, "Ignoring exoplayer streaming error as the user has viewed some of the ad already", null, false, 12, null);
                    return;
                } else if ((iVar instanceof i.d) || kotlin.jvm.internal.t.d(iVar, i.b.f21315a)) {
                    MolocoLogger.info$default(molocoLogger, e.this.f21478d, "Exoplayer streaming failed before any playback started, so report that as error", null, false, 12, null);
                }
            }
            e.this.f21484j.setValue(l.VAST_AD_EXOPLAYER_VIDEO_LAYER_ERROR);
        }

        @Override // k2.r2.d
        public /* synthetic */ void x(w1 w1Var, int i10) {
            t2.j(this, w1Var, i10);
        }

        @Override // k2.r2.d
        public /* synthetic */ void y() {
            t2.x(this);
        }

        @Override // k2.r2.d
        public /* synthetic */ void z(n3 n3Var, int i10) {
            t2.B(this, n3Var, i10);
        }
    }

    /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.e$e, reason: collision with other inner class name */
    public /* synthetic */ class C0471e extends q implements h9.a<k0> {
        public C0471e(Object obj) {
            super(0, obj, e.class, "initOrResumeExoPlayer", "initOrResumeExoPlayer()V", 0);
        }

        public final void c() {
            ((e) this.receiver).j();
        }

        @Override // h9.a
        public /* bridge */ /* synthetic */ k0 invoke() {
            c();
            return k0.f35197a;
        }
    }

    public /* synthetic */ class f extends q implements h9.a<k0> {
        public f(Object obj) {
            super(0, obj, e.class, "disposeExoPlayer", "disposeExoPlayer()V", 0);
        }

        public final void c() {
            ((e) this.receiver).L();
        }

        @Override // h9.a
        public /* bridge */ /* synthetic */ k0 invoke() {
            c();
            return k0.f35197a;
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.SimplifiedExoPlayer$startPlaybackProgressJob$1", f = "SimplifiedExoPlayer.kt", l = {328}, m = "invokeSuspend")
    public static final class g extends kotlin.coroutines.jvm.internal.l implements p<o0, z8.d<? super k0>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f21506j;

        public g(z8.d<? super g> dVar) {
            super(2, dVar);
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super k0> dVar) {
            return ((g) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            return e.this.new g(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE = a9.d.e();
            int i10 = this.f21506j;
            if (i10 != 0 && i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            u.b(obj);
            do {
                s sVarT = e.this.T();
                if (sVarT != null) {
                    e.this.v(new i.c(sVarT.getCurrentPosition(), sVarT.getDuration()));
                }
                this.f21506j = 1;
            } while (y0.a(500L, this) != objE);
            return objE;
        }
    }

    public e(@NotNull Context context, boolean z10, @NotNull com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.f mediaCacheRepository, @NotNull Lifecycle lifecycle) {
        a0 a0Var;
        kotlin.jvm.internal.t.i(context, "context");
        kotlin.jvm.internal.t.i(mediaCacheRepository, "mediaCacheRepository");
        kotlin.jvm.internal.t.i(lifecycle, "lifecycle");
        this.f21475a = context;
        this.f21476b = z10;
        this.f21477c = mediaCacheRepository;
        this.f21478d = "SimplifiedExoPlayer";
        this.f21479e = p0.a(com.moloco.sdk.internal.scheduling.c.a().getMain());
        y<i> yVarA = s9.o0.a(i.b.f21315a);
        this.f21480f = yVarA;
        this.f21481g = yVarA;
        y<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.b> yVarA2 = s9.o0.a(new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.b(false, false, false, 6, null));
        this.f21482h = yVarA2;
        this.f21483i = yVarA2;
        y<l> yVarA3 = s9.o0.a(null);
        this.f21484j = yVarA3;
        this.f21485k = yVarA3;
        try {
            a0Var = new a0(context);
            a0Var.setUseController(false);
        } catch (InflateException e10) {
            MolocoLogger.error$default(MolocoLogger.INSTANCE, this.f21478d, "ExoPlayerView could not be instantiated.", e10, false, 8, null);
            this.f21484j.setValue(l.VAST_AD_EXOPLAYER_STYLED_PLAYER_VIEW_INFLATE_EXCEPTION_ERROR);
            a0Var = null;
        }
        this.f21486l = a0Var;
        this.f21489o = Looper.getMainLooper();
        j.D(j.G(isPlaying(), new a(null)), this.f21479e);
        this.f21493s = new d();
        this.f21494t = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.a(lifecycle, new C0471e(this), new f(this));
    }

    public static final k p(String str, e this$0) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.c cVar = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.c(str, this$0.f21477c);
        this$0.f21491q = cVar;
        return cVar;
    }

    public final void L() {
        MolocoLogger.info$default(MolocoLogger.INSTANCE, this.f21478d, "Disposing exo player", null, false, 12, null);
        a0 a0VarF = F();
        if (a0VarF != null) {
            a0VarF.B();
            a0VarF.setPlayer(null);
        }
        s sVar = this.f21490p;
        long duration = sVar != null ? sVar.getDuration() : 0L;
        s sVar2 = this.f21490p;
        boolean z10 = duration - (sVar2 != null ? sVar2.getCurrentPosition() : 0L) > 0;
        s sVar3 = this.f21490p;
        if (sVar3 != null) {
            y(sVar3);
            sVar3.f(this.f21493s);
            sVar3.release();
        }
        this.f21490p = null;
        this.f21482h.setValue(new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.b(false, false, z10));
    }

    @MainThread
    @Nullable
    public final s T() {
        return this.f21490p;
    }

    @Nullable
    public String U() {
        return this.f21487m;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.f
    @MainThread
    @Nullable
    /* JADX INFO: renamed from: V, reason: merged with bridge method [inline-methods] */
    public a0 F() {
        return this.f21486l;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.f
    public void a(@Nullable String str) {
        this.f21487m = str;
        s sVar = this.f21490p;
        if (sVar != null) {
            s(sVar, str);
        }
        m();
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.i
    public void destroy() {
        p0.e(this.f21479e, null, 1, null);
        this.f21494t.destroy();
        L();
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.f
    @NotNull
    public m0<l> e() {
        return this.f21485k;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.f
    @NotNull
    public m0<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.b> isPlaying() {
        return this.f21483i;
    }

    public final void j() {
        MolocoLogger.info$default(MolocoLogger.INSTANCE, this.f21478d, "Init exo player", null, false, 12, null);
        a0 a0VarF = F();
        if (a0VarF == null) {
            return;
        }
        if (this.f21490p == null) {
            s sVarE = new s.b(this.f21475a).j(this.f21489o).k(true).e();
            kotlin.jvm.internal.t.h(sVarE, "Builder(context)\n       …\n                .build()");
            a0VarF.setPlayer(sVarE);
            this.f21490p = sVarE;
            sVarE.setPlayWhenReady(false);
            sVarE.a(this.f21493s);
            w(sVarE);
            if (kotlin.jvm.internal.t.d(o().getValue(), i.b.f21315a)) {
                v(new i.d(sVarE.getDuration()));
            }
        }
        a0VarF.C();
    }

    public boolean l() {
        return this.f21488n;
    }

    public final void m() {
        this.f21492r = false;
        this.f21495u = 0L;
    }

    public final void n() {
        b2 b2Var = this.f21496v;
        if (b2Var != null) {
            b2.a.a(b2Var, null, 1, null);
        }
        this.f21496v = kotlinx.coroutines.k.d(this.f21479e, null, null, new g(null), 3, null);
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.f
    @NotNull
    public m0<i> o() {
        return this.f21481g;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.f
    public void pause() {
        this.f21492r = false;
        s sVar = this.f21490p;
        if (sVar != null) {
            sVar.pause();
        }
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.f
    public void play() {
        this.f21492r = true;
        s sVar = this.f21490p;
        if (sVar != null) {
            sVar.play();
        }
    }

    public final void s(s sVar, final String str) {
        if (str == null) {
            MolocoLogger.info$default(MolocoLogger.INSTANCE, this.f21478d, "URI Source is empty", null, false, 12, null);
            return;
        }
        try {
            if (this.f21476b) {
                MolocoLogger.info$default(MolocoLogger.INSTANCE, this.f21478d, "Streaming is enabled", null, false, 12, null);
                l3.p pVar = new l3.p(new k.a() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.d
                    @Override // z3.k.a
                    public final k createDataSource() {
                        return e.p(str, this);
                    }
                });
                w1 w1VarD = w1.d(str);
                kotlin.jvm.internal.t.h(w1VarD, "fromUri(uriSource)");
                sVar.e(pVar.b(w1VarD));
            } else {
                MolocoLogger.info$default(MolocoLogger.INSTANCE, this.f21478d, "Streaming is disabled", null, false, 12, null);
                sVar.d(w1.d(str));
            }
            sVar.prepare();
        } catch (Exception e10) {
            MolocoLogger.error$default(MolocoLogger.INSTANCE, this.f21478d, "ExoPlayer setMediaItem exception", e10, false, 8, null);
            this.f21484j.setValue(l.VAST_AD_EXOPLAYER_SET_MEDIA_ITEM_EXCEPTION_ERROR);
        }
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.f
    public void seekTo(long j10) {
        this.f21495u = j10;
        s sVar = this.f21490p;
        if (sVar != null) {
            sVar.seekTo(j10);
        }
    }

    public final void t(s sVar, boolean z10) {
        sVar.setVolume(z10 ? 0.0f : 1.0f);
    }

    public final void v(i iVar) {
        this.f21480f.setValue(iVar);
    }

    public final void w(s sVar) {
        t(sVar, l());
        s(sVar, U());
        sVar.seekTo(this.f21495u);
        if (this.f21492r) {
            sVar.play();
        } else {
            sVar.pause();
        }
    }

    public final void y(s sVar) {
        this.f21495u = sVar.getCurrentPosition();
    }

    public final Object o(s sVar, int i10, z8.d<? super k0> dVar) throws Throwable {
        kotlinx.coroutines.p pVar = new kotlinx.coroutines.p(a9.c.c(dVar), 1);
        pVar.C();
        c cVar = new c(i10, sVar, pVar);
        sVar.a(cVar);
        pVar.m(new b(sVar, cVar));
        Object objZ = pVar.z();
        if (objZ == a9.d.e()) {
            kotlin.coroutines.jvm.internal.h.c(dVar);
        }
        return objZ == a9.d.e() ? objZ : k0.f35197a;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.f
    public void a(boolean z10) {
        this.f21488n = z10;
        s sVar = this.f21490p;
        if (sVar == null) {
            return;
        }
        t(sVar, z10);
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.f
    @Nullable
    public Object a(@NotNull z8.d<? super k0> dVar) {
        Object objO;
        s sVar = this.f21490p;
        return (sVar == null || (objO = o(sVar, 3, dVar)) != a9.d.e()) ? k0.f35197a : objO;
    }
}
