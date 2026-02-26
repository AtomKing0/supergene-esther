package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer;

import android.view.View;
import androidx.annotation.MainThread;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.t;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i;
import h9.q;
import kotlin.coroutines.jvm.internal.l;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.p0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import s9.e0;
import s9.j;
import s9.m0;
import s9.x;
import v8.k0;
import v8.u;

/* JADX INFO: loaded from: classes4.dex */
@MainThread
public final class g implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public final e f21508a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public final o0 f21509b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    public final x<Boolean> f21510c;

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.VisibilityAwareVideoPlayer$1", f = "VisibilityAwareVideoPlayer.kt", l = {}, m = "invokeSuspend")
    public static final class a extends l implements q<Boolean, Boolean, z8.d<? super k0>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f21511j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public /* synthetic */ boolean f21512k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public /* synthetic */ boolean f21513l;

        public a(z8.d<? super a> dVar) {
            super(3, dVar);
        }

        @Nullable
        public final Object f(boolean z10, boolean z11, @Nullable z8.d<? super k0> dVar) {
            a aVar = g.this.new a(dVar);
            aVar.f21512k = z10;
            aVar.f21513l = z11;
            return aVar.invokeSuspend(k0.f35197a);
        }

        @Override // h9.q
        public /* bridge */ /* synthetic */ Object invoke(Boolean bool, Boolean bool2, z8.d<? super k0> dVar) {
            return f(bool.booleanValue(), bool2.booleanValue(), dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            a9.d.e();
            if (this.f21511j != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            u.b(obj);
            boolean z10 = this.f21512k;
            boolean z11 = this.f21513l;
            if (z10 && z11) {
                g.this.f21508a.play();
            } else {
                g.this.f21508a.pause();
            }
            return k0.f35197a;
        }
    }

    public g(@NotNull e basePlayer, @NotNull t viewVisibilityTracker) {
        kotlin.jvm.internal.t.i(basePlayer, "basePlayer");
        kotlin.jvm.internal.t.i(viewVisibilityTracker, "viewVisibilityTracker");
        this.f21508a = basePlayer;
        o0 o0VarB = p0.b();
        this.f21509b = o0VarB;
        x<Boolean> xVarB = e0.b(1, 0, r9.a.DROP_OLDEST, 2, null);
        this.f21510c = xVarB;
        j.D(j.m(h.b(viewVisibilityTracker, basePlayer.F()), xVarB, new a(null)), o0VarB);
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.f
    @Nullable
    public View F() {
        return this.f21508a.F();
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.f
    @Nullable
    public Object a(@NotNull z8.d<? super k0> dVar) {
        return this.f21508a.a(dVar);
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.i
    public void destroy() {
        p0.e(this.f21509b, null, 1, null);
        this.f21508a.destroy();
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.f
    @NotNull
    public m0<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.l> e() {
        return this.f21508a.e();
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.f
    @NotNull
    public m0<b> isPlaying() {
        return this.f21508a.isPlaying();
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.f
    @NotNull
    public m0<i> o() {
        return this.f21508a.o();
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.f
    public void pause() {
        this.f21510c.a(Boolean.FALSE);
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.f
    public void play() {
        this.f21510c.a(Boolean.TRUE);
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.f
    public void seekTo(long j10) {
        this.f21508a.seekTo(j10);
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.f
    public void a(boolean z10) {
        this.f21508a.a(z10);
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.f
    public void a(@Nullable String str) {
        this.f21508a.a(str);
    }
}
