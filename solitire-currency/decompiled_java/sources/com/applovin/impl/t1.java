package com.applovin.impl;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.StrictMode;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import androidx.media3.exoplayer.ExoPlayer;
import com.applovin.adview.AppLovinAdView;
import com.applovin.communicator.AppLovinCommunicator;
import com.applovin.communicator.AppLovinCommunicatorMessage;
import com.applovin.communicator.AppLovinCommunicatorSubscriber;
import com.applovin.impl.adview.AppLovinTouchToClickListener;
import com.applovin.impl.adview.AppLovinVideoView;
import com.applovin.impl.r5;
import com.applovin.impl.sdk.utils.ImageViewUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.w0;
import com.applovin.impl.y7;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;
import com.applovin.sdk.AppLovinSdkUtils;
import com.iab.omid.library.applovin.adsession.FriendlyObstructionPurpose;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public class t1 extends p1 implements AppLovinCommunicatorSubscriber {
    private final u1 J;
    private MediaPlayer K;
    private final View L;
    protected final AppLovinVideoView M;
    protected final com.applovin.impl.a N;
    protected final com.applovin.impl.adview.g O;
    protected e0 P;
    protected final ImageView Q;
    protected com.applovin.impl.adview.l R;
    protected final ProgressBar S;
    protected ProgressBar T;
    protected ImageView U;
    private final e V;
    private final d W;
    private final Handler X;
    private final Handler Y;
    protected final w0 Z;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    protected final w0 f7407a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    private final boolean f7408b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    protected boolean f7409c0;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    protected long f7410d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    private int f7411e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    private int f7412f0;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    protected boolean f7413g0;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    private boolean f7414h0;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    private final AtomicBoolean f7415i0;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    private final AtomicBoolean f7416j0;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    private long f7417k0;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    private long f7418l0;

    class a implements w0.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f7419a;

        a(int i10) {
            this.f7419a = i10;
        }

        @Override // com.applovin.impl.w0.b
        public void a() {
            if (t1.this.P != null) {
                long seconds = ((long) this.f7419a) - TimeUnit.MILLISECONDS.toSeconds(r0.M.getCurrentPosition());
                if (seconds <= 0) {
                    t1.this.f6525t = true;
                } else if (t1.this.N()) {
                    t1.this.P.setProgress((int) seconds);
                }
            }
        }

        @Override // com.applovin.impl.w0.b
        public boolean b() {
            return t1.this.N();
        }
    }

    class b implements w0.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Integer f7421a;

        b(Integer num) {
            this.f7421a = num;
        }

        @Override // com.applovin.impl.w0.b
        public void a() {
            t1 t1Var = t1.this;
            if (t1Var.f7413g0) {
                t1Var.S.setVisibility(8);
            } else {
                t1.this.S.setProgress((int) ((t1Var.M.getCurrentPosition() / t1.this.f7410d0) * this.f7421a.intValue()));
            }
        }

        @Override // com.applovin.impl.w0.b
        public boolean b() {
            return !t1.this.f7413g0;
        }
    }

    class c implements w0.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f7423a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Integer f7424b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Long f7425c;

        c(long j10, Integer num, Long l10) {
            this.f7423a = j10;
            this.f7424b = num;
            this.f7425c = l10;
        }

        @Override // com.applovin.impl.w0.b
        public void a() {
            t1.this.T.setProgress((int) ((t1.this.f6521p / this.f7423a) * this.f7424b.intValue()));
            t1.this.f6521p += this.f7425c.longValue();
        }

        @Override // com.applovin.impl.w0.b
        public boolean b() {
            return t1.this.f6521p < this.f7423a;
        }
    }

    private class d implements y7.a {
        private d() {
        }

        @Override // com.applovin.impl.y7.a
        public void a(com.applovin.impl.adview.l lVar) {
            com.applovin.impl.sdk.n nVar = t1.this.f6508c;
            if (com.applovin.impl.sdk.n.a()) {
                t1.this.f6508c.a("AppLovinFullscreenActivity", "Closing ad from video button...");
            }
            t1.this.c();
        }

        @Override // com.applovin.impl.y7.a
        public void b(com.applovin.impl.adview.l lVar) {
            com.applovin.impl.sdk.n nVar = t1.this.f6508c;
            if (com.applovin.impl.sdk.n.a()) {
                t1.this.f6508c.a("AppLovinFullscreenActivity", "Clicking through from video button...");
            }
            t1.this.a(lVar.getAndClearLastClickEvent(), (Bundle) null);
        }

        @Override // com.applovin.impl.y7.a
        public void c(com.applovin.impl.adview.l lVar) {
            com.applovin.impl.sdk.n nVar = t1.this.f6508c;
            if (com.applovin.impl.sdk.n.a()) {
                t1.this.f6508c.a("AppLovinFullscreenActivity", "Fully Watched from video button...");
            }
            t1.this.G = true;
        }

        @Override // com.applovin.impl.y7.a
        public void d(com.applovin.impl.adview.l lVar) {
            com.applovin.impl.sdk.n nVar = t1.this.f6508c;
            if (com.applovin.impl.sdk.n.a()) {
                t1.this.f6508c.a("AppLovinFullscreenActivity", "Skipping video from video button...");
            }
            t1.this.R();
        }

        /* synthetic */ d(t1 t1Var, a aVar) {
            this();
        }

        @Override // com.applovin.impl.y7.a
        public void a(com.applovin.impl.adview.l lVar, Bundle bundle) {
            com.applovin.impl.sdk.n nVar = t1.this.f6508c;
            if (com.applovin.impl.sdk.n.a()) {
                t1.this.f6508c.a("AppLovinFullscreenActivity", "Attempting to launch Direct Download from video button...");
            }
            t1.this.a(lVar.getAndClearLastClickEvent(), bundle);
        }

        @Override // com.applovin.impl.y7.a
        public void b(Uri uri, com.applovin.impl.adview.l lVar) {
            com.applovin.impl.sdk.n nVar = t1.this.f6508c;
            if (com.applovin.impl.sdk.n.a()) {
                t1.this.f6508c.a("AppLovinFullscreenActivity", "Attempting to report a template error from video button...");
            }
            w6.b(uri, t1.this.f6513h.getController().g(), t1.this.f6507b);
        }

        @Override // com.applovin.impl.y7.a
        public void a(Uri uri, com.applovin.impl.adview.l lVar) {
            com.applovin.impl.sdk.n nVar = t1.this.f6508c;
            if (com.applovin.impl.sdk.n.a()) {
                t1.this.f6508c.a("AppLovinFullscreenActivity", "Attempting to load a url from video button...");
            }
            w6.a(uri, t1.this.f6513h.getController(), t1.this.f6507b);
        }
    }

    private class e implements MediaPlayer.OnPreparedListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnCompletionListener, AppLovinTouchToClickListener.OnClickListener {
        private e() {
        }

        @Override // com.applovin.impl.adview.AppLovinTouchToClickListener.OnClickListener
        public void onClick(View view, MotionEvent motionEvent) {
            t1.this.a(motionEvent, (Bundle) null);
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            com.applovin.impl.sdk.n nVar = t1.this.f6508c;
            if (com.applovin.impl.sdk.n.a()) {
                t1.this.f6508c.a("AppLovinFullscreenActivity", "Video completed");
            }
            t1.this.f7414h0 = true;
            t1 t1Var = t1.this;
            if (!t1Var.f6523r) {
                t1Var.Q();
            } else if (t1Var.h()) {
                t1.this.x();
            }
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i10, int i11) {
            t1.this.d("Video view error (" + i10 + "," + i11 + ")");
            t1.this.M.start();
            return true;
        }

        @Override // android.media.MediaPlayer.OnInfoListener
        public boolean onInfo(MediaPlayer mediaPlayer, int i10, int i11) {
            com.applovin.impl.sdk.n nVar = t1.this.f6508c;
            if (com.applovin.impl.sdk.n.a()) {
                t1.this.f6508c.a("AppLovinFullscreenActivity", "MediaPlayer Info: (" + i10 + ", " + i11 + ")");
            }
            if (i10 == 701) {
                t1.this.P();
                return false;
            }
            if (i10 != 3) {
                if (i10 != 702) {
                    return false;
                }
                t1.this.B();
                return false;
            }
            t1.this.Z.b();
            t1 t1Var = t1.this;
            if (t1Var.O != null) {
                t1Var.M();
            }
            t1.this.B();
            if (!t1.this.D.b()) {
                return false;
            }
            t1.this.u();
            return false;
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            t1.this.K = mediaPlayer;
            mediaPlayer.setOnInfoListener(t1.this.V);
            mediaPlayer.setOnErrorListener(t1.this.V);
            float f10 = !t1.this.f7409c0 ? 1 : 0;
            mediaPlayer.setVolume(f10, f10);
            t1.this.f6524s = (int) TimeUnit.MILLISECONDS.toSeconds(mediaPlayer.getDuration());
            t1.this.c(mediaPlayer.getDuration());
            t1.this.L();
            com.applovin.impl.sdk.n nVar = t1.this.f6508c;
            if (com.applovin.impl.sdk.n.a()) {
                t1.this.f6508c.a("AppLovinFullscreenActivity", "MediaPlayer prepared: " + t1.this.K);
            }
        }

        /* synthetic */ e(t1 t1Var, a aVar) {
            this();
        }
    }

    private class f implements View.OnClickListener {
        private f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            t1 t1Var = t1.this;
            if (view == t1Var.O) {
                t1Var.R();
                return;
            }
            if (view == t1Var.Q) {
                t1Var.S();
                return;
            }
            if (com.applovin.impl.sdk.n.a()) {
                t1.this.f6508c.b("AppLovinFullscreenActivity", "Unhandled click on widget: " + view);
            }
        }

        /* synthetic */ f(t1 t1Var, a aVar) {
            this();
        }
    }

    public t1(com.applovin.impl.sdk.ad.b bVar, Activity activity, Map map, com.applovin.impl.sdk.j jVar, AppLovinAdClickListener appLovinAdClickListener, AppLovinAdDisplayListener appLovinAdDisplayListener, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener) {
        super(bVar, activity, map, jVar, appLovinAdClickListener, appLovinAdDisplayListener, appLovinAdVideoPlaybackListener);
        this.J = new u1(this.f6506a, this.f6509d, this.f6507b);
        a aVar = null;
        this.U = null;
        e eVar = new e(this, aVar);
        this.V = eVar;
        d dVar = new d(this, aVar);
        this.W = dVar;
        Handler handler = new Handler(Looper.getMainLooper());
        this.X = handler;
        Handler handler2 = new Handler(Looper.getMainLooper());
        this.Y = handler2;
        w0 w0Var = new w0(handler, this.f6507b);
        this.Z = w0Var;
        this.f7407a0 = new w0(handler2, this.f6507b);
        boolean zH0 = this.f6506a.H0();
        this.f7408b0 = zH0;
        this.f7409c0 = z6.e(this.f6507b);
        this.f7412f0 = -1;
        this.f7415i0 = new AtomicBoolean();
        this.f7416j0 = new AtomicBoolean();
        this.f7417k0 = -2L;
        this.f7418l0 = 0L;
        if (!bVar.hasVideoUrl()) {
            throw new IllegalStateException("Attempting to use fullscreen video ad presenter for non-video ad");
        }
        AppLovinVideoView appLovinVideoView = new AppLovinVideoView(activity);
        this.M = appLovinVideoView;
        appLovinVideoView.setOnPreparedListener(eVar);
        appLovinVideoView.setOnCompletionListener(eVar);
        appLovinVideoView.setOnErrorListener(eVar);
        bVar.e().putString("video_view_address", q7.a(appLovinVideoView));
        View view = new View(activity);
        this.L = view;
        boolean z10 = false;
        view.setBackgroundColor(Color.argb(254, 0, 0, 0));
        if (((Boolean) jVar.a(l4.f5648h1)).booleanValue()) {
            view.setOnTouchListener(new AppLovinTouchToClickListener(jVar, l4.f5655i0, activity, eVar));
        } else {
            appLovinVideoView.setOnTouchListener(new AppLovinTouchToClickListener(jVar, l4.f5655i0, activity, eVar));
            view.setOnTouchListener(new View.OnTouchListener() { // from class: com.applovin.impl.vd
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view2, MotionEvent motionEvent) {
                    return t1.a(view2, motionEvent);
                }
            });
        }
        f fVar = new f(this, aVar);
        if (bVar.h0() >= 0) {
            com.applovin.impl.adview.g gVar = new com.applovin.impl.adview.g(bVar.Y(), activity);
            this.O = gVar;
            gVar.setVisibility(8);
            gVar.setOnClickListener(fVar);
        } else {
            this.O = null;
        }
        if (a(this.f7409c0, jVar)) {
            ImageView imageView = new ImageView(activity);
            this.Q = imageView;
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imageView.setClickable(true);
            imageView.setOnClickListener(fVar);
            d(this.f7409c0);
        } else {
            this.Q = null;
        }
        String strE0 = bVar.e0();
        if (StringUtils.isValidString(strE0)) {
            y7 y7Var = new y7(jVar);
            y7Var.a(new WeakReference(dVar));
            com.applovin.impl.adview.l lVar = new com.applovin.impl.adview.l(bVar.d0(), bVar, y7Var, activity);
            this.R = lVar;
            lVar.a(strE0);
        } else {
            this.R = null;
        }
        if (zH0) {
            com.applovin.impl.a aVar2 = new com.applovin.impl.a(activity, ((Integer) jVar.a(l4.f5641g2)).intValue(), R.attr.progressBarStyleLarge);
            this.N = aVar2;
            aVar2.setColor(Color.parseColor("#75FFFFFF"));
            aVar2.setBackgroundColor(Color.parseColor("#00000000"));
            aVar2.setVisibility(8);
            AppLovinCommunicator.getInstance(activity).subscribe(this, "video_caching_failed");
        } else {
            this.N = null;
        }
        int iD = d();
        if (((Boolean) jVar.a(l4.L1)).booleanValue() && iD > 0) {
            z10 = true;
        }
        if (this.P == null && z10) {
            this.P = new e0(activity);
            int iQ = bVar.q();
            this.P.setTextColor(iQ);
            this.P.setTextSize(((Integer) jVar.a(l4.K1)).intValue());
            this.P.setFinishedStrokeColor(iQ);
            this.P.setFinishedStrokeWidth(((Integer) jVar.a(l4.J1)).intValue());
            this.P.setMax(iD);
            this.P.setProgress(iD);
            w0Var.a("COUNTDOWN_CLOCK", TimeUnit.SECONDS.toMillis(1L), new a(iD));
        }
        if (!bVar.o0()) {
            this.S = null;
            return;
        }
        Long l10 = (Long) jVar.a(l4.f5617d2);
        Integer num = (Integer) jVar.a(l4.f5625e2);
        ProgressBar progressBar = new ProgressBar(activity, null, R.attr.progressBarStyleHorizontal);
        this.S = progressBar;
        a(progressBar, bVar.n0(), num.intValue());
        w0Var.a("PROGRESS_BAR", l10.longValue(), new b(num));
    }

    private void J() {
        com.applovin.impl.adview.l lVar;
        p7 p7VarF0 = this.f6506a.f0();
        if (p7VarF0 == null || !p7VarF0.j() || this.f7413g0 || (lVar = this.R) == null) {
            return;
        }
        final boolean z10 = lVar.getVisibility() == 4;
        final long jH = p7VarF0.h();
        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.wd
            @Override // java.lang.Runnable
            public final void run() {
                this.f7702a.b(z10, jH);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K() {
        if (this.f7413g0) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f6508c.k("AppLovinFullscreenActivity", "Skip video resume - postitial shown");
                return;
            }
            return;
        }
        if (this.f6507b.f0().isApplicationPaused()) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f6508c.k("AppLovinFullscreenActivity", "Skip video resume - app paused");
                return;
            }
            return;
        }
        if (this.f7412f0 < 0) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f6508c.a("AppLovinFullscreenActivity", "Invalid last video position");
                return;
            }
            return;
        }
        if (com.applovin.impl.sdk.n.a()) {
            this.f6508c.a("AppLovinFullscreenActivity", "Resuming video at position " + this.f7412f0 + "ms for MediaPlayer: " + this.K);
        }
        this.M.seekTo(this.f7412f0);
        this.M.start();
        this.Z.b();
        this.f7412f0 = -1;
        a(new Runnable() { // from class: com.applovin.impl.yd
            @Override // java.lang.Runnable
            public final void run() {
                this.f7855a.F();
            }
        }, 250L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M() {
        if (this.f7416j0.compareAndSet(false, true)) {
            a(this.O, this.f6506a.h0(), new Runnable() { // from class: com.applovin.impl.ud
                @Override // java.lang.Runnable
                public final void run() {
                    this.f7544a.G();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean a(View view, MotionEvent motionEvent) {
        return true;
    }

    private void e(boolean z10) {
        this.f7411e0 = z();
        if (z10) {
            this.M.pause();
        } else {
            this.M.stopPlayback();
        }
    }

    protected void L() {
        long jU;
        long millis;
        if (this.f6506a.T() >= 0 || this.f6506a.U() >= 0) {
            if (this.f6506a.T() >= 0) {
                jU = this.f6506a.T();
            } else {
                com.applovin.impl.sdk.ad.a aVar = (com.applovin.impl.sdk.ad.a) this.f6506a;
                long j10 = this.f7410d0;
                long j11 = j10 > 0 ? j10 : 0L;
                if (aVar.X0()) {
                    int iG1 = (int) ((com.applovin.impl.sdk.ad.a) this.f6506a).g1();
                    if (iG1 > 0) {
                        millis = TimeUnit.SECONDS.toMillis(iG1);
                    } else {
                        int iP = (int) aVar.p();
                        if (iP > 0) {
                            millis = TimeUnit.SECONDS.toMillis(iP);
                        }
                    }
                    j11 += millis;
                }
                jU = (long) (j11 * (((double) this.f6506a.U()) / 100.0d));
            }
            b(jU);
        }
    }

    protected boolean N() {
        return (this.f6525t || this.f7413g0 || !this.M.isPlaying()) ? false : true;
    }

    protected boolean O() {
        return h() && !C();
    }

    protected void P() {
        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.sd
            @Override // java.lang.Runnable
            public final void run() {
                this.f6843a.H();
            }
        });
    }

    public void Q() {
        if (com.applovin.impl.sdk.n.a()) {
            this.f6508c.a("AppLovinFullscreenActivity", "Showing postitial...");
        }
        e(this.f6506a.d1());
        long jR = this.f6506a.R();
        if (jR > 0) {
            this.f6521p = 0L;
            Long l10 = (Long) this.f6507b.a(l4.f5689m2);
            Integer num = (Integer) this.f6507b.a(l4.f5713p2);
            ProgressBar progressBar = new ProgressBar(this.f6509d, null, R.attr.progressBarStyleHorizontal);
            this.T = progressBar;
            a(progressBar, this.f6506a.Q(), num.intValue());
            this.f7407a0.a("POSTITIAL_PROGRESS_BAR", l10.longValue(), new c(jR, num, l10));
            this.f7407a0.b();
        }
        this.J.a(this.f6515j, this.f6514i, this.f6513h, this.T);
        a("javascript:al_onPoststitialShow(" + this.f6528w + "," + this.f6529x + ");", this.f6506a.D());
        if (this.f6515j != null) {
            if (this.f6506a.p() >= 0) {
                a(this.f6515j, this.f6506a.p(), new Runnable() { // from class: com.applovin.impl.td
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f7482a.I();
                    }
                });
            } else {
                this.f6515j.setVisibility(0);
            }
        }
        ArrayList arrayList = new ArrayList();
        com.applovin.impl.adview.g gVar = this.f6515j;
        if (gVar != null) {
            arrayList.add(new u3(gVar, FriendlyObstructionPurpose.CLOSE_AD, "close button"));
        }
        com.applovin.impl.adview.k kVar = this.f6514i;
        if (kVar != null && kVar.a()) {
            com.applovin.impl.adview.k kVar2 = this.f6514i;
            arrayList.add(new u3(kVar2, FriendlyObstructionPurpose.NOT_VISIBLE, kVar2.getIdentifier()));
        }
        ProgressBar progressBar2 = this.T;
        if (progressBar2 != null) {
            arrayList.add(new u3(progressBar2, FriendlyObstructionPurpose.OTHER, "postitial progress bar"));
        }
        this.f6506a.getAdEventTracker().b(this.f6513h, arrayList);
        o();
        this.f7413g0 = true;
    }

    public void R() {
        this.f7417k0 = SystemClock.elapsedRealtime() - this.f7418l0;
        if (com.applovin.impl.sdk.n.a()) {
            this.f6508c.a("AppLovinFullscreenActivity", "Attempting to skip video with skip time: " + this.f7417k0 + "ms");
        }
        if (!O()) {
            A();
            return;
        }
        u();
        m();
        if (com.applovin.impl.sdk.n.a()) {
            this.f6508c.a("AppLovinFullscreenActivity", "Prompting incentivized ad close warning");
        }
        this.D.e();
    }

    protected void S() {
        MediaPlayer mediaPlayer = this.K;
        if (mediaPlayer == null) {
            return;
        }
        try {
            float f10 = this.f7409c0 ? 1.0f : 0.0f;
            mediaPlayer.setVolume(f10, f10);
            boolean z10 = !this.f7409c0;
            this.f7409c0 = z10;
            d(z10);
            a(this.f7409c0, 0L);
        } catch (Throwable unused) {
        }
    }

    protected void d(String str) {
        if (com.applovin.impl.sdk.n.a()) {
            this.f6508c.b("AppLovinFullscreenActivity", "Encountered media error: " + str + " for ad: " + this.f6506a);
        }
        if (this.f7415i0.compareAndSet(false, true)) {
            if (((Boolean) this.f6507b.a(l4.I0)).booleanValue()) {
                this.f6507b.C().d(this.f6506a, com.applovin.impl.sdk.j.n());
            }
            AppLovinAdDisplayListener appLovinAdDisplayListener = this.B;
            if (appLovinAdDisplayListener instanceof f2) {
                ((f2) appLovinAdDisplayListener).onAdDisplayFailed(str);
            }
            this.f6507b.A().a(this.f6506a instanceof a7 ? "handleVastVideoError" : "handleVideoError", str, this.f6506a);
            c();
        }
    }

    @Override // com.applovin.impl.p1
    public void f() {
        super.f();
        this.J.a(this.R);
        this.J.a((View) this.O);
        if (!h() || this.f7413g0) {
            x();
        }
    }

    @Override // com.applovin.communicator.AppLovinCommunicatorEntity
    public String getCommunicatorId() {
        return "FullscreenVideoAdPresenter";
    }

    @Override // com.applovin.impl.p1
    protected void l() {
        super.a(z(), this.f7408b0, C(), this.f7417k0);
    }

    @Override // com.applovin.communicator.AppLovinCommunicatorSubscriber
    public void onMessageReceived(AppLovinCommunicatorMessage appLovinCommunicatorMessage) {
        if ("video_caching_failed".equals(appLovinCommunicatorMessage.getTopic())) {
            Bundle messageData = appLovinCommunicatorMessage.getMessageData();
            if (messageData.getLong("ad_id") == this.f6506a.getAdIdNumber() && this.f7408b0) {
                int i10 = messageData.getInt("load_response_code");
                String string = messageData.getString("load_exception_message");
                if ((string == null && i10 >= 200 && i10 < 300) || this.f7414h0 || this.M.isPlaying()) {
                    return;
                }
                d("Video cache error during stream. ResponseCode=" + i10 + ", exception=" + string);
            }
        }
    }

    @Override // com.applovin.impl.p1
    public void q() {
        if (com.applovin.impl.sdk.n.a()) {
            this.f6508c.d("AppLovinFullscreenActivity", "Destroying video components");
        }
        try {
            if (((Boolean) this.f6507b.a(l4.J5)).booleanValue()) {
                a8.b(this.R);
                this.R = null;
            }
            if (this.f7408b0) {
                AppLovinCommunicator.getInstance(this.f6509d).unsubscribe(this, "video_caching_failed");
            }
            AppLovinVideoView appLovinVideoView = this.M;
            if (appLovinVideoView != null) {
                appLovinVideoView.pause();
                this.M.stopPlayback();
            }
            MediaPlayer mediaPlayer = this.K;
            if (mediaPlayer != null) {
                mediaPlayer.release();
            }
        } catch (Throwable th) {
            com.applovin.impl.sdk.n.c("AppLovinFullscreenActivity", "Unable to destroy presenter", th);
        }
        super.q();
    }

    @Override // com.applovin.impl.p1
    public void u() {
        if (com.applovin.impl.sdk.n.a()) {
            this.f6508c.a("AppLovinFullscreenActivity", "Pausing video");
        }
        this.f7412f0 = this.M.getCurrentPosition();
        this.M.pause();
        this.Z.c();
        if (com.applovin.impl.sdk.n.a()) {
            this.f6508c.a("AppLovinFullscreenActivity", "Paused video at position " + this.f7412f0 + "ms");
        }
    }

    @Override // com.applovin.impl.p1
    public void v() {
        a((ViewGroup) null);
    }

    @Override // com.applovin.impl.p1
    protected void x() {
        this.J.a(this.f6516k);
        this.f6520o = SystemClock.elapsedRealtime();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void E() {
        com.applovin.impl.a aVar = this.N;
        if (aVar != null) {
            aVar.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void F() {
        com.applovin.impl.a aVar = this.N;
        if (aVar != null) {
            aVar.a();
            final com.applovin.impl.a aVar2 = this.N;
            Objects.requireNonNull(aVar2);
            a(new Runnable() { // from class: com.applovin.impl.zd
                @Override // java.lang.Runnable
                public final void run() {
                    aVar2.b();
                }
            }, ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void G() {
        this.f7417k0 = -1L;
        this.f7418l0 = SystemClock.elapsedRealtime();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void H() {
        com.applovin.impl.a aVar = this.N;
        if (aVar != null) {
            aVar.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void I() {
        this.f6520o = SystemClock.elapsedRealtime();
    }

    public void A() {
        this.f6528w++;
        if (this.f6506a.B()) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f6508c.a("AppLovinFullscreenActivity", "Dismissing ad on video skip...");
            }
            c();
        } else {
            if (com.applovin.impl.sdk.n.a()) {
                this.f6508c.a("AppLovinFullscreenActivity", "Skipping video...");
            }
            Q();
        }
    }

    protected void B() {
        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.xd
            @Override // java.lang.Runnable
            public final void run() {
                this.f7760a.E();
            }
        });
    }

    protected boolean C() {
        if (this.G && this.f6506a.a1()) {
            return true;
        }
        return D();
    }

    protected boolean D() {
        return z() >= this.f6506a.j0();
    }

    @Override // com.applovin.impl.p1
    public void b(boolean z10) {
        super.b(z10);
        if (z10) {
            a(0L);
            if (this.f7413g0) {
                this.f7407a0.b();
                return;
            }
            return;
        }
        if (this.f7413g0) {
            this.f7407a0.c();
        } else {
            u();
        }
    }

    protected void c(long j10) {
        this.f7410d0 = j10;
    }

    protected int z() {
        long currentPosition = this.M.getCurrentPosition();
        if (this.f7414h0) {
            return 100;
        }
        return currentPosition > 0 ? (int) ((currentPosition / this.f7410d0) * 100.0f) : this.f7411e0;
    }

    @Override // com.applovin.impl.p1
    public void c() {
        this.Z.a();
        this.f7407a0.a();
        this.X.removeCallbacksAndMessages(null);
        this.Y.removeCallbacksAndMessages(null);
        l();
        super.c();
    }

    @Override // com.applovin.impl.p1
    public void e() {
        super.e();
        x();
    }

    @Override // com.applovin.impl.p1
    public void a(ViewGroup viewGroup) {
        String str;
        this.J.a(this.Q, this.O, this.R, this.N, this.S, this.P, this.M, this.L, this.f6513h, this.f6514i, this.U, viewGroup);
        if (k0.g() && (str = this.f6507b.g0().getExtraParameters().get("audio_focus_request")) != null) {
            this.M.setAudioFocusRequest(Integer.parseInt(str));
        }
        StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
        if (a(!this.f7408b0)) {
            return;
        }
        this.M.setVideoURI(this.f6506a.p0());
        StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
        com.applovin.impl.adview.k kVar = this.f6514i;
        if (kVar != null) {
            kVar.b();
        }
        this.M.start();
        if (this.f7408b0) {
            P();
        }
        this.f6513h.renderAd(this.f6506a);
        if (this.O != null) {
            this.f6507b.j0().a(new f6(this.f6507b, "scheduleSkipButton", new Runnable() { // from class: com.applovin.impl.rd
                @Override // java.lang.Runnable
                public final void run() {
                    this.f6782a.M();
                }
            }), r5.b.TIMEOUT, this.f6506a.i0(), true);
        }
        super.c(this.f7409c0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(boolean z10, long j10) {
        if (z10) {
            q7.a(this.R, j10, (Runnable) null);
        } else {
            q7.b(this.R, j10, (Runnable) null);
        }
    }

    private void d(boolean z10) {
        if (k0.d()) {
            AnimatedVectorDrawable animatedVectorDrawable = (AnimatedVectorDrawable) this.f6509d.getDrawable(z10 ? com.applovin.sdk.R.drawable.applovin_ic_unmute_to_mute : com.applovin.sdk.R.drawable.applovin_ic_mute_to_unmute);
            if (animatedVectorDrawable != null) {
                this.Q.setScaleType(ImageView.ScaleType.FIT_XY);
                this.Q.setImageDrawable(animatedVectorDrawable);
                animatedVectorDrawable.start();
                return;
            }
        }
        ImageViewUtils.setImageUri(this.Q, z10 ? this.f6506a.M() : this.f6506a.c0(), this.f6507b);
    }

    @Override // com.applovin.impl.c2.a
    public void b() {
        if (com.applovin.impl.sdk.n.a()) {
            this.f6508c.a("AppLovinFullscreenActivity", "Continue video from prompt - will resume in onWindowFocusChanged(true) when alert dismisses");
        }
    }

    @Override // com.applovin.impl.p1
    protected void a(final String str, long j10) {
        super.a(str, j10);
        if (this.R == null || j10 < 0 || !StringUtils.isValidString(str)) {
            return;
        }
        a(new Runnable() { // from class: com.applovin.impl.qd
            @Override // java.lang.Runnable
            public final void run() {
                this.f6722a.a(str);
            }
        }, j10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(String str) {
        a8.a(this.R, str, "AppLovinFullscreenActivity", this.f6507b);
    }

    private void a(ProgressBar progressBar, int i10, int i11) {
        progressBar.setMax(i11);
        progressBar.setPadding(0, 0, 0, 0);
        if (k0.d()) {
            progressBar.setProgressTintList(ColorStateList.valueOf(i10));
        }
    }

    protected void a(MotionEvent motionEvent, Bundle bundle) {
        Context context;
        if (this.f6506a.G0()) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f6508c.a("AppLovinFullscreenActivity", "Clicking through video");
            }
            Uri uriG0 = this.f6506a.g0();
            if (uriG0 != null) {
                if (!((Boolean) this.f6507b.a(l4.f5771x)).booleanValue() || (context = this.f6509d) == null) {
                    AppLovinAdView appLovinAdView = this.f6513h;
                    context = appLovinAdView != null ? appLovinAdView.getContext() : com.applovin.impl.sdk.j.n();
                }
                this.f6507b.k().trackAndLaunchVideoClick(this.f6506a, uriG0, motionEvent, bundle, this, context);
                l2.a(this.A, this.f6506a);
                this.f6529x++;
                return;
            }
            return;
        }
        J();
    }

    @Override // com.applovin.impl.p1
    public void a(long j10) {
        a(new Runnable() { // from class: com.applovin.impl.pd
            @Override // java.lang.Runnable
            public final void run() {
                this.f6582a.K();
            }
        }, j10);
    }

    private static boolean a(boolean z10, com.applovin.impl.sdk.j jVar) {
        if (!((Boolean) jVar.a(l4.V1)).booleanValue()) {
            return false;
        }
        if (!((Boolean) jVar.a(l4.W1)).booleanValue() || z10) {
            return true;
        }
        return ((Boolean) jVar.a(l4.Y1)).booleanValue();
    }

    @Override // com.applovin.impl.c2.a
    public void a() {
        if (com.applovin.impl.sdk.n.a()) {
            this.f6508c.a("AppLovinFullscreenActivity", "Skipping video from prompt");
        }
        A();
    }
}
