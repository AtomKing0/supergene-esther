package com.google.android.exoplayer2.ui;

import a4.o0;
import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.opengl.GLSurfaceView;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;
import com.google.android.exoplayer2.ui.AspectRatioFrameLayout;
import com.google.android.exoplayer2.ui.g;
import java.util.ArrayList;
import java.util.List;
import k2.b2;
import k2.n2;
import k2.n3;
import k2.q2;
import k2.r2;
import k2.s3;
import k2.t2;
import k2.w1;

/* JADX INFO: compiled from: StyledPlayerView.java */
/* JADX INFO: loaded from: classes2.dex */
public class a0 extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a f8460a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    private final AspectRatioFrameLayout f8461b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    private final View f8462c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    private final View f8463d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f8464e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    private final ImageView f8465f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    private final SubtitleView f8466g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Nullable
    private final View f8467h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    private final TextView f8468i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Nullable
    private final g f8469j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @Nullable
    private final FrameLayout f8470k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @Nullable
    private final FrameLayout f8471l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @Nullable
    private r2 f8472m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f8473n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @Nullable
    private b f8474o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @Nullable
    private g.m f8475p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f8476q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @Nullable
    private Drawable f8477r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f8478s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private boolean f8479t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    @Nullable
    private CharSequence f8480u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private int f8481v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private boolean f8482w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private boolean f8483x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private boolean f8484y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private int f8485z;

    /* JADX INFO: compiled from: StyledPlayerView.java */
    private final class a implements r2.d, View.OnLayoutChangeListener, View.OnClickListener, g.m, g.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final n3.b f8486a = new n3.b();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        private Object f8487b;

        public a() {
        }

        @Override // k2.r2.d
        public /* synthetic */ void B(k2.o oVar) {
            t2.d(this, oVar);
        }

        @Override // k2.r2.d
        public void D(r2.e eVar, r2.e eVar2, int i10) {
            if (a0.this.y() && a0.this.f8483x) {
                a0.this.w();
            }
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
        public void G(s3 s3Var) {
            r2 r2Var = (r2) a4.a.e(a0.this.f8472m);
            n3 currentTimeline = r2Var.getCurrentTimeline();
            if (currentTimeline.u()) {
                this.f8487b = null;
            } else if (r2Var.getCurrentTracks().c()) {
                Object obj = this.f8487b;
                if (obj != null) {
                    int iF = currentTimeline.f(obj);
                    if (iF != -1) {
                        if (r2Var.getCurrentMediaItemIndex() == currentTimeline.j(iF, this.f8486a).f29300c) {
                            return;
                        }
                    }
                    this.f8487b = null;
                }
            } else {
                this.f8487b = currentTimeline.k(r2Var.getCurrentPeriodIndex(), this.f8486a, true).f29299b;
            }
            a0.this.P(false);
        }

        @Override // k2.r2.d
        public /* synthetic */ void H(x3.z zVar) {
            t2.C(this, zVar);
        }

        @Override // k2.r2.d
        public void a(n3.f fVar) {
            if (a0.this.f8466g != null) {
                a0.this.f8466g.setCues(fVar.f31659a);
            }
        }

        @Override // k2.r2.d
        public void f(b4.b0 b0Var) {
            a0.this.K();
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
        public /* synthetic */ void m(b2 b2Var) {
            t2.k(this, b2Var);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a0.this.J();
        }

        @Override // k2.r2.d
        public /* synthetic */ void onCues(List list) {
            t2.b(this, list);
        }

        @Override // k2.r2.d
        public /* synthetic */ void onDeviceVolumeChanged(int i10, boolean z10) {
            t2.e(this, i10, z10);
        }

        @Override // com.google.android.exoplayer2.ui.g.d
        public void onFullScreenModeChanged(boolean z10) {
            a0.h(a0.this);
        }

        @Override // k2.r2.d
        public /* synthetic */ void onIsLoadingChanged(boolean z10) {
            t2.g(this, z10);
        }

        @Override // k2.r2.d
        public /* synthetic */ void onIsPlayingChanged(boolean z10) {
            t2.h(this, z10);
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
            a0.q((TextureView) view, a0.this.f8485z);
        }

        @Override // k2.r2.d
        public /* synthetic */ void onLoadingChanged(boolean z10) {
            t2.i(this, z10);
        }

        @Override // k2.r2.d
        public void onPlayWhenReadyChanged(boolean z10, int i10) {
            a0.this.L();
            a0.this.N();
        }

        @Override // k2.r2.d
        public void onPlaybackStateChanged(int i10) {
            a0.this.L();
            a0.this.O();
            a0.this.N();
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
        public void onRenderedFirstFrame() {
            if (a0.this.f8462c != null) {
                a0.this.f8462c.setVisibility(4);
            }
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

        @Override // com.google.android.exoplayer2.ui.g.m
        public void onVisibilityChange(int i10) {
            a0.this.M();
            if (a0.this.f8474o != null) {
                a0.this.f8474o.onVisibilityChanged(i10);
            }
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

    /* JADX INFO: compiled from: StyledPlayerView.java */
    public interface b {
        void onVisibilityChanged(int i10);
    }

    /* JADX INFO: compiled from: StyledPlayerView.java */
    public interface c {
    }

    public a0(Context context) {
        this(context, null);
    }

    private boolean D(b2 b2Var) {
        byte[] bArr = b2Var.f28986j;
        if (bArr == null) {
            return false;
        }
        return E(new BitmapDrawable(getResources(), BitmapFactory.decodeByteArray(bArr, 0, bArr.length)));
    }

    private boolean E(@Nullable Drawable drawable) {
        if (drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            if (intrinsicWidth > 0 && intrinsicHeight > 0) {
                A(this.f8461b, intrinsicWidth / intrinsicHeight);
                this.f8465f.setImageDrawable(drawable);
                this.f8465f.setVisibility(0);
                return true;
            }
        }
        return false;
    }

    private static void F(AspectRatioFrameLayout aspectRatioFrameLayout, int i10) {
        aspectRatioFrameLayout.setResizeMode(i10);
    }

    private boolean G() {
        r2 r2Var = this.f8472m;
        if (r2Var == null) {
            return true;
        }
        int playbackState = r2Var.getPlaybackState();
        return this.f8482w && !this.f8472m.getCurrentTimeline().u() && (playbackState == 1 || playbackState == 4 || !((r2) a4.a.e(this.f8472m)).getPlayWhenReady());
    }

    private void I(boolean z10) {
        if (R()) {
            this.f8469j.setShowTimeoutMs(z10 ? 0 : this.f8481v);
            this.f8469j.r0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J() {
        if (!R() || this.f8472m == null) {
            return;
        }
        if (!this.f8469j.f0()) {
            z(true);
        } else if (this.f8484y) {
            this.f8469j.b0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K() {
        r2 r2Var = this.f8472m;
        b4.b0 videoSize = r2Var != null ? r2Var.getVideoSize() : b4.b0.f2077e;
        int i10 = videoSize.f2079a;
        int i11 = videoSize.f2080b;
        int i12 = videoSize.f2081c;
        float f10 = (i11 == 0 || i10 == 0) ? 0.0f : (i10 * videoSize.f2082d) / i11;
        View view = this.f8463d;
        if (view instanceof TextureView) {
            if (f10 > 0.0f && (i12 == 90 || i12 == 270)) {
                f10 = 1.0f / f10;
            }
            if (this.f8485z != 0) {
                view.removeOnLayoutChangeListener(this.f8460a);
            }
            this.f8485z = i12;
            if (i12 != 0) {
                this.f8463d.addOnLayoutChangeListener(this.f8460a);
            }
            q((TextureView) this.f8463d, this.f8485z);
        }
        A(this.f8461b, this.f8464e ? 0.0f : f10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0020  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void L() {
        /*
            r4 = this;
            android.view.View r0 = r4.f8467h
            if (r0 == 0) goto L2b
            k2.r2 r0 = r4.f8472m
            r1 = 0
            if (r0 == 0) goto L20
            int r0 = r0.getPlaybackState()
            r2 = 2
            if (r0 != r2) goto L20
            int r0 = r4.f8478s
            r3 = 1
            if (r0 == r2) goto L21
            if (r0 != r3) goto L20
            k2.r2 r0 = r4.f8472m
            boolean r0 = r0.getPlayWhenReady()
            if (r0 == 0) goto L20
            goto L21
        L20:
            r3 = r1
        L21:
            android.view.View r0 = r4.f8467h
            if (r3 == 0) goto L26
            goto L28
        L26:
            r1 = 8
        L28:
            r0.setVisibility(r1)
        L2b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.ui.a0.L():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M() {
        g gVar = this.f8469j;
        if (gVar == null || !this.f8473n) {
            setContentDescription(null);
        } else if (gVar.f0()) {
            setContentDescription(this.f8484y ? getResources().getString(y3.o.f36574e) : null);
        } else {
            setContentDescription(getResources().getString(y3.o.f36581l));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N() {
        if (y() && this.f8483x) {
            w();
        } else {
            z(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O() {
        TextView textView = this.f8468i;
        if (textView != null) {
            CharSequence charSequence = this.f8480u;
            if (charSequence != null) {
                textView.setText(charSequence);
                this.f8468i.setVisibility(0);
            } else {
                r2 r2Var = this.f8472m;
                if (r2Var != null) {
                    r2Var.getPlayerError();
                }
                this.f8468i.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P(boolean z10) {
        r2 r2Var = this.f8472m;
        if (r2Var == null || r2Var.getCurrentTracks().c()) {
            if (this.f8479t) {
                return;
            }
            v();
            r();
            return;
        }
        if (z10 && !this.f8479t) {
            r();
        }
        if (r2Var.getCurrentTracks().d(2)) {
            v();
            return;
        }
        r();
        if (Q() && (D(r2Var.getMediaMetadata()) || E(this.f8477r))) {
            return;
        }
        v();
    }

    private boolean Q() {
        if (!this.f8476q) {
            return false;
        }
        a4.a.i(this.f8465f);
        return true;
    }

    private boolean R() {
        if (!this.f8473n) {
            return false;
        }
        a4.a.i(this.f8469j);
        return true;
    }

    static /* synthetic */ c h(a0 a0Var) {
        a0Var.getClass();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void q(TextureView textureView, int i10) {
        Matrix matrix = new Matrix();
        float width = textureView.getWidth();
        float height = textureView.getHeight();
        if (width != 0.0f && height != 0.0f && i10 != 0) {
            float f10 = width / 2.0f;
            float f11 = height / 2.0f;
            matrix.postRotate(i10, f10, f11);
            RectF rectF = new RectF(0.0f, 0.0f, width, height);
            RectF rectF2 = new RectF();
            matrix.mapRect(rectF2, rectF);
            matrix.postScale(width / rectF2.width(), height / rectF2.height(), f10, f11);
        }
        textureView.setTransform(matrix);
    }

    private void r() {
        View view = this.f8462c;
        if (view != null) {
            view.setVisibility(0);
        }
    }

    private static void s(Resources resources, ImageView imageView) {
        imageView.setImageDrawable(resources.getDrawable(y3.i.f36520a));
        imageView.setBackgroundColor(resources.getColor(y3.g.f36515a));
    }

    @RequiresApi(23)
    private static void t(Resources resources, ImageView imageView) {
        imageView.setImageDrawable(resources.getDrawable(y3.i.f36520a, null));
        imageView.setBackgroundColor(resources.getColor(y3.g.f36515a, null));
    }

    private void v() {
        ImageView imageView = this.f8465f;
        if (imageView != null) {
            imageView.setImageResource(R.color.transparent);
            this.f8465f.setVisibility(4);
        }
    }

    @SuppressLint({"InlinedApi"})
    private boolean x(int i10) {
        return i10 == 19 || i10 == 270 || i10 == 22 || i10 == 271 || i10 == 20 || i10 == 269 || i10 == 21 || i10 == 268 || i10 == 23;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean y() {
        r2 r2Var = this.f8472m;
        return r2Var != null && r2Var.isPlayingAd() && this.f8472m.getPlayWhenReady();
    }

    private void z(boolean z10) {
        if (!(y() && this.f8483x) && R()) {
            boolean z11 = this.f8469j.f0() && this.f8469j.getShowTimeoutMs() <= 0;
            boolean zG = G();
            if (z10 || z11 || zG) {
                I(zG);
            }
        }
    }

    protected void A(@Nullable AspectRatioFrameLayout aspectRatioFrameLayout, float f10) {
        if (aspectRatioFrameLayout != null) {
            aspectRatioFrameLayout.setAspectRatio(f10);
        }
    }

    public void B() {
        View view = this.f8463d;
        if (view instanceof GLSurfaceView) {
            ((GLSurfaceView) view).onPause();
        }
    }

    public void C() {
        View view = this.f8463d;
        if (view instanceof GLSurfaceView) {
            ((GLSurfaceView) view).onResume();
        }
    }

    public void H() {
        I(G());
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        r2 r2Var = this.f8472m;
        if (r2Var != null && r2Var.isPlayingAd()) {
            return super.dispatchKeyEvent(keyEvent);
        }
        boolean zX = x(keyEvent.getKeyCode());
        if (zX && R() && !this.f8469j.f0()) {
            z(true);
            return true;
        }
        if (u(keyEvent) || super.dispatchKeyEvent(keyEvent)) {
            z(true);
            return true;
        }
        if (zX && R()) {
            z(true);
        }
        return false;
    }

    public List<y3.a> getAdOverlayInfos() {
        ArrayList arrayList = new ArrayList();
        FrameLayout frameLayout = this.f8471l;
        if (frameLayout != null) {
            arrayList.add(new y3.a(frameLayout, 4, "Transparent overlay does not impact viewability"));
        }
        g gVar = this.f8469j;
        if (gVar != null) {
            arrayList.add(new y3.a(gVar, 1));
        }
        return com.google.common.collect.y.m(arrayList);
    }

    public ViewGroup getAdViewGroup() {
        return (ViewGroup) a4.a.j(this.f8470k, "exo_ad_overlay must be present for ad playback");
    }

    public boolean getControllerAutoShow() {
        return this.f8482w;
    }

    public boolean getControllerHideOnTouch() {
        return this.f8484y;
    }

    public int getControllerShowTimeoutMs() {
        return this.f8481v;
    }

    @Nullable
    public Drawable getDefaultArtwork() {
        return this.f8477r;
    }

    @Nullable
    public FrameLayout getOverlayFrameLayout() {
        return this.f8471l;
    }

    @Nullable
    public r2 getPlayer() {
        return this.f8472m;
    }

    public int getResizeMode() {
        a4.a.i(this.f8461b);
        return this.f8461b.getResizeMode();
    }

    @Nullable
    public SubtitleView getSubtitleView() {
        return this.f8466g;
    }

    public boolean getUseArtwork() {
        return this.f8476q;
    }

    public boolean getUseController() {
        return this.f8473n;
    }

    @Nullable
    public View getVideoSurfaceView() {
        return this.f8463d;
    }

    @Override // android.view.View
    public boolean onTrackballEvent(MotionEvent motionEvent) {
        if (!R() || this.f8472m == null) {
            return false;
        }
        z(true);
        return true;
    }

    @Override // android.view.View
    public boolean performClick() {
        J();
        return super.performClick();
    }

    public void setAspectRatioListener(@Nullable AspectRatioFrameLayout.b bVar) {
        a4.a.i(this.f8461b);
        this.f8461b.setAspectRatioListener(bVar);
    }

    public void setControllerAutoShow(boolean z10) {
        this.f8482w = z10;
    }

    public void setControllerHideDuringAds(boolean z10) {
        this.f8483x = z10;
    }

    public void setControllerHideOnTouch(boolean z10) {
        a4.a.i(this.f8469j);
        this.f8484y = z10;
        M();
    }

    @Deprecated
    public void setControllerOnFullScreenModeChangedListener(@Nullable g.d dVar) {
        a4.a.i(this.f8469j);
        this.f8469j.setOnFullScreenModeChangedListener(dVar);
    }

    public void setControllerShowTimeoutMs(int i10) {
        a4.a.i(this.f8469j);
        this.f8481v = i10;
        if (this.f8469j.f0()) {
            H();
        }
    }

    public void setControllerVisibilityListener(@Nullable b bVar) {
        this.f8474o = bVar;
        setControllerVisibilityListener((g.m) null);
    }

    public void setCustomErrorMessage(@Nullable CharSequence charSequence) {
        a4.a.g(this.f8468i != null);
        this.f8480u = charSequence;
        O();
    }

    public void setDefaultArtwork(@Nullable Drawable drawable) {
        if (this.f8477r != drawable) {
            this.f8477r = drawable;
            P(false);
        }
    }

    public void setErrorMessageProvider(@Nullable a4.k<? super n2> kVar) {
        if (kVar != null) {
            O();
        }
    }

    public void setFullscreenButtonClickListener(@Nullable c cVar) {
        a4.a.i(this.f8469j);
        this.f8469j.setOnFullScreenModeChangedListener(this.f8460a);
    }

    public void setKeepContentOnPlayerReset(boolean z10) {
        if (this.f8479t != z10) {
            this.f8479t = z10;
            P(false);
        }
    }

    public void setPlayer(@Nullable r2 r2Var) {
        a4.a.g(Looper.myLooper() == Looper.getMainLooper());
        a4.a.a(r2Var == null || r2Var.getApplicationLooper() == Looper.getMainLooper());
        r2 r2Var2 = this.f8472m;
        if (r2Var2 == r2Var) {
            return;
        }
        if (r2Var2 != null) {
            r2Var2.f(this.f8460a);
            View view = this.f8463d;
            if (view instanceof TextureView) {
                r2Var2.clearVideoTextureView((TextureView) view);
            } else if (view instanceof SurfaceView) {
                r2Var2.clearVideoSurfaceView((SurfaceView) view);
            }
        }
        SubtitleView subtitleView = this.f8466g;
        if (subtitleView != null) {
            subtitleView.setCues(null);
        }
        this.f8472m = r2Var;
        if (R()) {
            this.f8469j.setPlayer(r2Var);
        }
        L();
        O();
        P(true);
        if (r2Var == null) {
            w();
            return;
        }
        if (r2Var.isCommandAvailable(27)) {
            View view2 = this.f8463d;
            if (view2 instanceof TextureView) {
                r2Var.setVideoTextureView((TextureView) view2);
            } else if (view2 instanceof SurfaceView) {
                r2Var.setVideoSurfaceView((SurfaceView) view2);
            }
            K();
        }
        if (this.f8466g != null && r2Var.isCommandAvailable(28)) {
            this.f8466g.setCues(r2Var.getCurrentCues().f31659a);
        }
        r2Var.a(this.f8460a);
        z(false);
    }

    public void setRepeatToggleModes(int i10) {
        a4.a.i(this.f8469j);
        this.f8469j.setRepeatToggleModes(i10);
    }

    public void setResizeMode(int i10) {
        a4.a.i(this.f8461b);
        this.f8461b.setResizeMode(i10);
    }

    public void setShowBuffering(int i10) {
        if (this.f8478s != i10) {
            this.f8478s = i10;
            L();
        }
    }

    public void setShowFastForwardButton(boolean z10) {
        a4.a.i(this.f8469j);
        this.f8469j.setShowFastForwardButton(z10);
    }

    public void setShowMultiWindowTimeBar(boolean z10) {
        a4.a.i(this.f8469j);
        this.f8469j.setShowMultiWindowTimeBar(z10);
    }

    public void setShowNextButton(boolean z10) {
        a4.a.i(this.f8469j);
        this.f8469j.setShowNextButton(z10);
    }

    public void setShowPreviousButton(boolean z10) {
        a4.a.i(this.f8469j);
        this.f8469j.setShowPreviousButton(z10);
    }

    public void setShowRewindButton(boolean z10) {
        a4.a.i(this.f8469j);
        this.f8469j.setShowRewindButton(z10);
    }

    public void setShowShuffleButton(boolean z10) {
        a4.a.i(this.f8469j);
        this.f8469j.setShowShuffleButton(z10);
    }

    public void setShowSubtitleButton(boolean z10) {
        a4.a.i(this.f8469j);
        this.f8469j.setShowSubtitleButton(z10);
    }

    public void setShowVrButton(boolean z10) {
        a4.a.i(this.f8469j);
        this.f8469j.setShowVrButton(z10);
    }

    public void setShutterBackgroundColor(@ColorInt int i10) {
        View view = this.f8462c;
        if (view != null) {
            view.setBackgroundColor(i10);
        }
    }

    public void setUseArtwork(boolean z10) {
        a4.a.g((z10 && this.f8465f == null) ? false : true);
        if (this.f8476q != z10) {
            this.f8476q = z10;
            P(false);
        }
    }

    public void setUseController(boolean z10) {
        a4.a.g((z10 && this.f8469j == null) ? false : true);
        setClickable(z10 || hasOnClickListeners());
        if (this.f8473n == z10) {
            return;
        }
        this.f8473n = z10;
        if (R()) {
            this.f8469j.setPlayer(this.f8472m);
        } else {
            g gVar = this.f8469j;
            if (gVar != null) {
                gVar.b0();
                this.f8469j.setPlayer(null);
            }
        }
        M();
    }

    @Override // android.view.View
    public void setVisibility(int i10) {
        super.setVisibility(i10);
        View view = this.f8463d;
        if (view instanceof SurfaceView) {
            view.setVisibility(i10);
        }
    }

    public boolean u(KeyEvent keyEvent) {
        return R() && this.f8469j.U(keyEvent);
    }

    public void w() {
        g gVar = this.f8469j;
        if (gVar != null) {
            gVar.b0();
        }
    }

    public a0(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a0(Context context, @Nullable AttributeSet attributeSet, int i10) {
        int i11;
        boolean z10;
        int i12;
        int integer;
        boolean z11;
        boolean z12;
        int i13;
        int i14;
        boolean z13;
        boolean z14;
        int i15;
        boolean z15;
        boolean z16;
        int i16;
        boolean z17;
        super(context, attributeSet, i10);
        a aVar = new a();
        this.f8460a = aVar;
        if (isInEditMode()) {
            this.f8461b = null;
            this.f8462c = null;
            this.f8463d = null;
            this.f8464e = false;
            this.f8465f = null;
            this.f8466g = null;
            this.f8467h = null;
            this.f8468i = null;
            this.f8469j = null;
            this.f8470k = null;
            this.f8471l = null;
            ImageView imageView = new ImageView(context);
            if (o0.f214a >= 23) {
                t(getResources(), imageView);
            } else {
                s(getResources(), imageView);
            }
            addView(imageView);
            return;
        }
        int i17 = y3.m.f36564b;
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, y3.q.N, i10, 0);
            try {
                int i18 = y3.q.X;
                boolean zHasValue = typedArrayObtainStyledAttributes.hasValue(i18);
                int color = typedArrayObtainStyledAttributes.getColor(i18, 0);
                int resourceId = typedArrayObtainStyledAttributes.getResourceId(y3.q.T, i17);
                boolean z18 = typedArrayObtainStyledAttributes.getBoolean(y3.q.Z, true);
                int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(y3.q.P, 0);
                boolean z19 = typedArrayObtainStyledAttributes.getBoolean(y3.q.f36598a0, true);
                int i19 = typedArrayObtainStyledAttributes.getInt(y3.q.Y, 1);
                int i20 = typedArrayObtainStyledAttributes.getInt(y3.q.U, 0);
                int i21 = typedArrayObtainStyledAttributes.getInt(y3.q.W, 5000);
                boolean z20 = typedArrayObtainStyledAttributes.getBoolean(y3.q.R, true);
                boolean z21 = typedArrayObtainStyledAttributes.getBoolean(y3.q.O, true);
                integer = typedArrayObtainStyledAttributes.getInteger(y3.q.V, 0);
                this.f8479t = typedArrayObtainStyledAttributes.getBoolean(y3.q.S, this.f8479t);
                boolean z22 = typedArrayObtainStyledAttributes.getBoolean(y3.q.Q, true);
                typedArrayObtainStyledAttributes.recycle();
                z12 = z20;
                z10 = z21;
                i12 = i20;
                z15 = z19;
                i15 = resourceId2;
                z14 = z18;
                z13 = zHasValue;
                i14 = color;
                i13 = i19;
                i17 = resourceId;
                i11 = i21;
                z11 = z22;
            } catch (Throwable th) {
                typedArrayObtainStyledAttributes.recycle();
                throw th;
            }
        } else {
            i11 = 5000;
            z10 = true;
            i12 = 0;
            integer = 0;
            z11 = true;
            z12 = true;
            i13 = 1;
            i14 = 0;
            z13 = false;
            z14 = true;
            i15 = 0;
            z15 = true;
        }
        LayoutInflater.from(context).inflate(i17, this);
        setDescendantFocusability(262144);
        AspectRatioFrameLayout aspectRatioFrameLayout = (AspectRatioFrameLayout) findViewById(y3.k.f36543i);
        this.f8461b = aspectRatioFrameLayout;
        if (aspectRatioFrameLayout != null) {
            F(aspectRatioFrameLayout, i12);
        }
        View viewFindViewById = findViewById(y3.k.M);
        this.f8462c = viewFindViewById;
        if (viewFindViewById != null && z13) {
            viewFindViewById.setBackgroundColor(i14);
        }
        if (aspectRatioFrameLayout != null && i13 != 0) {
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
            if (i13 == 2) {
                this.f8463d = new TextureView(context);
            } else if (i13 == 3) {
                try {
                    int i22 = c4.l.f4567m;
                    this.f8463d = (View) c4.l.class.getConstructor(Context.class).newInstance(context);
                    z17 = true;
                    this.f8463d.setLayoutParams(layoutParams);
                    this.f8463d.setOnClickListener(aVar);
                    this.f8463d.setClickable(false);
                    aspectRatioFrameLayout.addView(this.f8463d, 0);
                    z16 = z17;
                } catch (Exception e10) {
                    throw new IllegalStateException("spherical_gl_surface_view requires an ExoPlayer dependency", e10);
                }
            } else if (i13 != 4) {
                this.f8463d = new SurfaceView(context);
            } else {
                try {
                    int i23 = b4.j.f2148b;
                    this.f8463d = (View) b4.j.class.getConstructor(Context.class).newInstance(context);
                } catch (Exception e11) {
                    throw new IllegalStateException("video_decoder_gl_surface_view requires an ExoPlayer dependency", e11);
                }
            }
            z17 = false;
            this.f8463d.setLayoutParams(layoutParams);
            this.f8463d.setOnClickListener(aVar);
            this.f8463d.setClickable(false);
            aspectRatioFrameLayout.addView(this.f8463d, 0);
            z16 = z17;
        } else {
            this.f8463d = null;
            z16 = false;
        }
        this.f8464e = z16;
        this.f8470k = (FrameLayout) findViewById(y3.k.f36535a);
        this.f8471l = (FrameLayout) findViewById(y3.k.A);
        ImageView imageView2 = (ImageView) findViewById(y3.k.f36536b);
        this.f8465f = imageView2;
        this.f8476q = z14 && imageView2 != null;
        if (i15 != 0) {
            this.f8477r = ContextCompat.getDrawable(getContext(), i15);
        }
        SubtitleView subtitleView = (SubtitleView) findViewById(y3.k.P);
        this.f8466g = subtitleView;
        if (subtitleView != null) {
            subtitleView.d();
            subtitleView.e();
        }
        View viewFindViewById2 = findViewById(y3.k.f36540f);
        this.f8467h = viewFindViewById2;
        if (viewFindViewById2 != null) {
            viewFindViewById2.setVisibility(8);
        }
        this.f8478s = integer;
        TextView textView = (TextView) findViewById(y3.k.f36548n);
        this.f8468i = textView;
        if (textView != null) {
            textView.setVisibility(8);
        }
        int i24 = y3.k.f36544j;
        g gVar = (g) findViewById(i24);
        View viewFindViewById3 = findViewById(y3.k.f36545k);
        if (gVar != null) {
            this.f8469j = gVar;
            i16 = 0;
        } else if (viewFindViewById3 != null) {
            i16 = 0;
            g gVar2 = new g(context, null, 0, attributeSet);
            this.f8469j = gVar2;
            gVar2.setId(i24);
            gVar2.setLayoutParams(viewFindViewById3.getLayoutParams());
            ViewGroup viewGroup = (ViewGroup) viewFindViewById3.getParent();
            int iIndexOfChild = viewGroup.indexOfChild(viewFindViewById3);
            viewGroup.removeView(viewFindViewById3);
            viewGroup.addView(gVar2, iIndexOfChild);
        } else {
            i16 = 0;
            this.f8469j = null;
        }
        g gVar3 = this.f8469j;
        this.f8481v = gVar3 != null ? i11 : i16;
        this.f8484y = z12;
        this.f8482w = z10;
        this.f8483x = z11;
        this.f8473n = (!z15 || gVar3 == null) ? i16 : 1;
        if (gVar3 != null) {
            gVar3.c0();
            this.f8469j.S(aVar);
        }
        if (z15) {
            setClickable(true);
        }
        M();
    }

    @Deprecated
    public void setControllerVisibilityListener(@Nullable g.m mVar) {
        a4.a.i(this.f8469j);
        g.m mVar2 = this.f8475p;
        if (mVar2 == mVar) {
            return;
        }
        if (mVar2 != null) {
            this.f8469j.m0(mVar2);
        }
        this.f8475p = mVar;
        if (mVar != null) {
            this.f8469j.S(mVar);
        }
        setControllerVisibilityListener((b) null);
    }
}
