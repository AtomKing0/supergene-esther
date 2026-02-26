package com.king.amp.sa;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaRouter;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Display;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.OptIn;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.content.ContextCompat;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.media3.common.AudioAttributes;
import androidx.media3.common.C;
import androidx.media3.common.DeviceInfo;
import androidx.media3.common.MediaItem;
import androidx.media3.common.MediaMetadata;
import androidx.media3.common.Metadata;
import androidx.media3.common.PlaybackException;
import androidx.media3.common.PlaybackParameters;
import androidx.media3.common.Player;
import androidx.media3.common.Timeline;
import androidx.media3.common.TrackGroup;
import androidx.media3.common.TrackSelectionParameters;
import androidx.media3.common.Tracks;
import androidx.media3.common.VideoSize;
import androidx.media3.common.text.CueGroup;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.datasource.DefaultDataSource;
import androidx.media3.exoplayer.DefaultRenderersFactory;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.exoplayer.source.ProgressiveMediaSource;
import androidx.media3.ui.PlayerView;
import androidx.viewpager2.widget.ViewPager2;
import com.ironsource.v8;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: loaded from: classes4.dex */
public class AbmMediaPlayerActivity extends AppCompatActivity implements Player.Listener, d1 {
    private View A;
    private int B;
    private int C;
    private long D;
    private ValueAnimator I;
    private AbmMediaPlayerLayoutConfig J;
    private s K;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private PlayerView f16584b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ExoPlayer f16585c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ViewPager2 f16586d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private u f16587e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private AbmMediaPlayerChapterAdIndicatorView f16588f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Timer f16589g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Timer f16590h;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @Nullable
    private AbmMediaPlayer f16597o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private y f16598p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private v f16599q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private ConstraintLayout f16600r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private View f16601s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private TextView f16602t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private ImageButton f16603u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private TextView f16604v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private TextView f16605w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private ImageButton f16606x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private ImageButton f16607y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private Button f16608z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f16583a = "undefined";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private long f16591i = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f16592j = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f16593k = 1;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final long f16594l = 100;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private long f16595m = 5000;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f16596n = false;
    private int E = 0;
    private int F = 0;
    private int G = 100;
    private Timer H = null;
    private boolean L = false;
    private r M = r.Idle;
    MediaRouter.Callback N = new i();
    private BroadcastReceiver O = new j();

    class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
            AbmMediaPlayerActivity.this.f16601s.getLayoutParams().width = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            AbmMediaPlayerActivity.this.f16601s.requestLayout();
        }
    }

    class b implements Runnable {

        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                AbmMediaPlayerActivity.this.f16602t.setVisibility(0);
            }
        }

        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AbmMediaPlayerActivity.this.f16602t.setText(AbmMediaPlayerActivity.this.getString(j6.i.f28755a));
            AbmMediaPlayerActivity.this.f16602t.animate().alpha(1.0f).setDuration(500L).withEndAction(new a()).start();
        }
    }

    class c implements ValueAnimator.AnimatorUpdateListener {
        c() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            AbmMediaPlayerActivity.this.f16601s.setBackgroundTintList(ColorStateList.valueOf(((Integer) valueAnimator.getAnimatedValue()).intValue()));
        }
    }

    class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f16613a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f16614b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f16615c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f16616d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f16617e;

        d(View view, int i10, int i11, int i12, int i13) {
            this.f16613a = view;
            this.f16614b = i10;
            this.f16615c = i11;
            this.f16616d = i12;
            this.f16617e = i13;
        }

        @Override // java.lang.Runnable
        public void run() {
            Rect rect = new Rect();
            this.f16613a.getHitRect(rect);
            rect.top -= this.f16614b;
            rect.bottom += this.f16615c;
            rect.left -= this.f16616d;
            rect.right += this.f16617e;
            AbmMediaPlayerActivity.this.K.a(new TouchDelegate(rect, this.f16613a));
            AbmMediaPlayerActivity.this.f16600r.setTouchDelegate(AbmMediaPlayerActivity.this.K);
        }
    }

    class e extends TimerTask {

        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                AbmMediaPlayerActivity.this.Z();
            }
        }

        e() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            AbmMediaPlayerActivity.this.runOnUiThread(new a());
        }
    }

    class f extends TimerTask {

        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                AbmMediaPlayerActivity.this.f16593k = 0;
                int itemCount = (AbmMediaPlayerActivity.this.f16592j + 1) % AbmMediaPlayerActivity.this.f16586d.getAdapter().getItemCount();
                AbmMediaPlayerActivity.this.f16586d.setCurrentItem(itemCount, true);
                AbmMediaPlayerActivity.this.f16592j = itemCount;
            }
        }

        f() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            AbmMediaPlayerActivity.this.runOnUiThread(new a());
        }
    }

    class g implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f16623a;

        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                AbmMediaPlayerActivity.this.f16604v.setVisibility(0);
            }
        }

        g(String str) {
            this.f16623a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            AbmMediaPlayerActivity.this.f16604v.setText(this.f16623a);
            AbmMediaPlayerActivity.this.f16604v.animate().alpha(1.0f).setDuration(300L).withEndAction(new a()).start();
        }
    }

    class h implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f16626a;

        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                AbmMediaPlayerActivity.this.f16605w.setVisibility(0);
            }
        }

        h(String str) {
            this.f16626a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            AbmMediaPlayerActivity.this.f16605w.setText(this.f16626a);
            AbmMediaPlayerActivity.this.f16605w.animate().alpha(1.0f).setDuration(300L).withEndAction(new a()).start();
        }
    }

    class j extends BroadcastReceiver {
        j() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Log.i("AbmMediaPlayerActivity", "Update intent received");
            if (intent.getAction().equals("com.king.amp.sa.UPDATE_PLAYER_ACTIVITY")) {
                AbmMediaPlayerActivity.this.onNewIntent(intent);
            }
        }
    }

    class k implements View.OnClickListener {
        k() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AbmMediaPlayerActivity.this.c0();
            if (AbmMediaPlayerActivity.this.f16597o != null) {
                AbmMediaPlayerActivity.this.f16597o.onPlayerEvent("cta", s1.a());
            }
        }
    }

    class l implements View.OnClickListener {
        l() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AbmMediaPlayerActivity.this.c0();
            if (AbmMediaPlayerActivity.this.f16597o != null) {
                AbmMediaPlayerActivity.this.f16597o.onPlayerEvent("ad_icon", s1.a());
            }
        }
    }

    class m implements View.OnClickListener {
        m() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AbmMediaPlayerActivity.this.c0();
            if (AbmMediaPlayerActivity.this.f16597o != null) {
                AbmMediaPlayerActivity.this.f16597o.onPlayerEvent(AbmMediaPlayer.USER_ACTION_AD_CHOICES_ICON, s1.a());
            }
        }
    }

    class n implements View.OnClickListener {
        n() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AbmMediaPlayerActivity.this.c0();
            if (AbmMediaPlayerActivity.this.f16597o != null) {
                AbmMediaPlayerActivity.this.f16597o.onPlayerEvent("close", s1.a());
            }
        }
    }

    class o extends ViewPager2.OnPageChangeCallback {
        o() {
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int i10) {
            super.onPageSelected(i10);
            if (AbmMediaPlayerActivity.this.f16592j == i10) {
                return;
            }
            AdProviderNameValuePairs adProviderNameValuePairs = new AdProviderNameValuePairs();
            adProviderNameValuePairs.add("previous_page", Integer.valueOf(AbmMediaPlayerActivity.this.f16592j + 1));
            adProviderNameValuePairs.add("current_page", Integer.valueOf(i10 + 1));
            adProviderNameValuePairs.add("is_manually_scrolled", Integer.valueOf(AbmMediaPlayerActivity.this.f16593k));
            if (AbmMediaPlayerActivity.this.f16597o != null) {
                AbmMediaPlayerActivity.this.f16597o.onPlayerEvent("page_changed", s1.d(adProviderNameValuePairs));
            }
            AbmMediaPlayerActivity.this.f16588f.b(i10);
            AbmMediaPlayerActivity abmMediaPlayerActivity = AbmMediaPlayerActivity.this;
            abmMediaPlayerActivity.j0(abmMediaPlayerActivity.f16592j, i10);
            AbmMediaPlayerActivity.this.f16592j = i10;
            AbmMediaPlayerActivity.this.b0();
            AbmMediaPlayerActivity.this.f16593k = 1;
        }
    }

    class p extends TimerTask {

        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                AbmMediaPlayerActivity.this.a0();
            }
        }

        p() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            AbmMediaPlayerActivity.this.runOnUiThread(new a());
        }
    }

    class q extends TimerTask {

        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                AbmMediaPlayerActivity.this.f16603u.setClickable(true);
                AbmMediaPlayerActivity.this.f16606x.setClickable(true);
                AbmMediaPlayerActivity.this.f16608z.setClickable(true);
                AbmMediaPlayerActivity.this.f16607y.setClickable(true);
            }
        }

        q() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            AbmMediaPlayerActivity.this.runOnUiThread(new a());
        }
    }

    private enum r {
        Idle,
        Initialized,
        Showing,
        Finished
    }

    private class s extends TouchDelegate {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List<TouchDelegate> f16645a;

        public s(View view) {
            super(new Rect(), view);
            this.f16645a = new ArrayList();
        }

        public void a(TouchDelegate touchDelegate) {
            if (touchDelegate != null) {
                this.f16645a.add(touchDelegate);
            }
        }

        @Override // android.view.TouchDelegate
        public boolean onTouchEvent(MotionEvent motionEvent) {
            boolean z10;
            float x10 = motionEvent.getX();
            float y10 = motionEvent.getY();
            while (true) {
                for (TouchDelegate touchDelegate : this.f16645a) {
                    motionEvent.setLocation(x10, y10);
                    z10 = touchDelegate.onTouchEvent(motionEvent) || z10;
                }
                return z10;
            }
        }
    }

    private String P(long j10) {
        return String.format(Locale.getDefault(), "%02d:%02d", Integer.valueOf((int) ((j10 / 60000) % 60)), Integer.valueOf(((int) (j10 / 1000)) % 60));
    }

    private String Q(String str) {
        return this.f16583a.equalsIgnoreCase("chapters") ? this.J.getChapterConfigMapList().get(0).get(str) : this.J.getLayoutConfigMap().get(str);
    }

    private int R(@NonNull Bundle bundle, @NonNull String str, int i10) {
        String string = bundle.getString(str);
        if (string == null) {
            return i10;
        }
        try {
            return Integer.parseInt(string);
        } catch (Exception e10) {
            Log.e("AbmMediaPlayerActivity", "Unable to get " + str + ", " + e10.getMessage());
            return i10;
        }
    }

    private void S(View view, int i10, int i11, int i12, int i13) {
        this.f16600r.post(new d(view, i10, i11, i12, i13));
    }

    private void T() {
        int i10 = this.E;
        long duration = ((long) i10) * 1000;
        if (i10 == 0 && this.f16585c != null && !this.f16583a.equalsIgnoreCase("chapters")) {
            duration = this.f16585c.getDuration();
        }
        if (duration != C.TIME_UNSET && this.I == null) {
            Display defaultDisplay = getWindowManager().getDefaultDisplay();
            Point point = new Point();
            defaultDisplay.getRealSize(point);
            ValueAnimator duration2 = ValueAnimator.ofInt(1, Math.min(point.x, point.y)).setDuration(duration);
            this.I = duration2;
            duration2.addUpdateListener(new a());
            this.I.setInterpolator(new LinearInterpolator());
        }
    }

    @SuppressLint({"UseCompatLoadingForDrawables"})
    private void U() {
        this.f16604v.setText(Q("ad_title_text"));
        this.f16605w.setText(Q("ad_description_text"));
        String strQ = Q("cta_button_title");
        if (!TextUtils.isEmpty(strQ)) {
            this.f16608z.setText(strQ);
        }
        String strQ2 = Q("cta_button_image");
        if (!TextUtils.isEmpty(strQ2)) {
            this.f16608z.setBackground(Drawable.createFromPath(strQ2));
        }
        S(this.f16608z, 150, 150, 150, 150);
        String strQ3 = Q("advertiser_icon");
        if (!TextUtils.isEmpty(strQ3)) {
            this.f16603u.setClipToOutline(true);
            this.f16603u.setVisibility(0);
            this.f16603u.setImageDrawable(Drawable.createFromPath(strQ3));
            S(this.f16603u, 20, 150, 20, 150);
        }
        if (!TextUtils.isEmpty(Q("adchoice_url"))) {
            this.f16607y.setVisibility(0);
            String strQ4 = Q("adchoice_icon");
            if (TextUtils.isEmpty(strQ4)) {
                this.f16607y.setImageResource(j6.d.f28708a);
            } else {
                this.f16607y.setImageDrawable(Drawable.createFromPath(strQ4));
            }
            S(this.f16607y, 50, 50, 50, 0);
        }
        if (this.f16583a.equalsIgnoreCase("chapters")) {
            ArrayList arrayList = new ArrayList();
            Iterator<Map<String, String>> it = this.J.getChapterConfigMapList().iterator();
            while (it.hasNext()) {
                arrayList.add(Drawable.createFromPath(it.next().get("ad_image")));
            }
            int i10 = this.E;
            this.f16595m = i10 != 0 ? (((long) i10) * 1000) / ((long) arrayList.size()) : 5000L;
            u uVar = new u(arrayList, this);
            this.f16587e = uVar;
            this.f16586d.setAdapter(uVar);
            this.f16588f.a(this, arrayList.size());
            this.f16586d.registerOnPageChangeCallback(new o());
            b0();
            this.f16586d.setVisibility(0);
            ConstraintSet constraintSet = new ConstraintSet();
            constraintSet.clone(this.f16600r);
            constraintSet.connect(this.f16607y.getId(), 4, this.f16586d.getId(), 4, 0);
            constraintSet.connect(this.f16607y.getId(), 7, this.f16586d.getId(), 7, 0);
            constraintSet.applyTo(this.f16600r);
            T();
        }
    }

    @OptIn(markerClass = {UnstableApi.class})
    private boolean W(@NonNull Bundle bundle) {
        y yVar;
        y yVar2;
        if (bundle.containsKey("pause")) {
            Log.i("AbmMediaPlayerActivity", "Pause action received");
            ExoPlayer exoPlayer = this.f16585c;
            if (exoPlayer != null && exoPlayer.isPlaying()) {
                Log.i("AbmMediaPlayerActivity", "Pausing player");
                this.f16585c.pause();
            }
            return true;
        }
        if (bundle.containsKey("resume")) {
            Log.i("AbmMediaPlayerActivity", "Resume action received");
            ExoPlayer exoPlayer2 = this.f16585c;
            if (exoPlayer2 != null && !exoPlayer2.isPlaying()) {
                Log.i("AbmMediaPlayerActivity", "Resuming player");
                this.f16585c.play();
            }
            return true;
        }
        if (bundle.containsKey("dismiss")) {
            X();
            finish();
            return true;
        }
        if (bundle.containsKey("reward_granted")) {
            f0();
            return true;
        }
        if (bundle.containsKey("show_prompt") && (yVar2 = this.f16598p) != null && !yVar2.isAdded()) {
            this.f16598p.show(getSupportFragmentManager(), "AbmMediaPlayerPromptDialogFragment");
            return true;
        }
        if (bundle.containsKey("dismiss_prompt") && (yVar = this.f16598p) != null) {
            yVar.dismiss();
            return true;
        }
        if (bundle.containsKey(AbmMediaPlayer.SHOW_END_CARD)) {
            this.f16606x.bringToFront();
            this.A.animate().alpha(0.85f).setDuration(300L).start();
            this.f16599q.show(getSupportFragmentManager(), "AbmMediaPlayerEndCardFragment");
            this.f16608z.setVisibility(4);
            AbmMediaPlayer abmMediaPlayer = this.f16597o;
            if (abmMediaPlayer != null) {
                abmMediaPlayer.onPlayerEvent("end_card_shown", s1.a());
            }
            return true;
        }
        if (bundle.containsKey("dismiss_end_card")) {
            this.A.animate().alpha(0.0f).setDuration(300L).start();
            this.f16599q.dismiss();
            return true;
        }
        if (!bundle.containsKey("open_url")) {
            return false;
        }
        String string = bundle.getString("open_url");
        Log.i("AbmMediaPlayerActivity", "Open URL: " + string);
        startActivity(BrowserComponent.getStartIntent(this, string));
        return true;
    }

    private void X() {
        ExoPlayer exoPlayer = this.f16585c;
        if (exoPlayer != null) {
            exoPlayer.stop();
            this.f16585c.setVideoSurface(null);
            this.f16585c.setVideoSurfaceView(null);
            this.f16585c.release();
        }
        this.f16585c = null;
    }

    private void Y() {
        if (this.f16590h == null) {
            Log.d("AbmMediaPlayerActivity", "resumeChapterScroll");
            b0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z() {
        long j10 = ((long) this.E) * 1000;
        long j11 = this.f16591i;
        if (j11 >= j10) {
            h0();
            AbmMediaPlayer abmMediaPlayer = this.f16597o;
            if (abmMediaPlayer != null) {
                abmMediaPlayer.onPlayerProgressV1(100, this.f16591i / 1000.0f);
            }
            this.M = r.Finished;
            return;
        }
        if (j11 % 1000 == 0) {
            double d10 = j11 / j10;
            AbmMediaPlayer abmMediaPlayer2 = this.f16597o;
            if (abmMediaPlayer2 != null) {
                abmMediaPlayer2.onPlayerProgressV1((int) (d10 * 100.0d), j11 / 1000.0f);
            }
            if (d10 * 100.0d >= this.F && this.f16606x.getVisibility() == 8) {
                this.f16606x.setVisibility(0);
                S(this.f16606x, 20, 150, 150, 20);
            }
            long j12 = (((j10 * ((long) this.G)) / 100) - this.f16591i) - 100;
            if (j12 > 0) {
                this.f16602t.setText(getString(j6.i.f28756b, P(j12)));
            }
        }
        this.f16591i += 100;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a0() {
        ExoPlayer exoPlayer = this.f16585c;
        if (exoPlayer != null) {
            int i10 = this.E;
            long duration = i10 != 0 ? ((long) i10) * 1000 : exoPlayer.getDuration();
            if (duration == C.TIME_UNSET) {
                return;
            }
            long currentPosition = this.f16585c.getCurrentPosition();
            double d10 = currentPosition / duration;
            AbmMediaPlayer abmMediaPlayer = this.f16597o;
            if (abmMediaPlayer != null) {
                abmMediaPlayer.onPlayerProgressV1((int) (d10 * 100.0d), currentPosition / 1000.0f);
            }
            if (100.0d * d10 >= this.F && this.f16606x.getVisibility() == 8) {
                this.f16606x.setVisibility(0);
                S(this.f16606x, 20, 150, 150, 20);
            }
            if (d10 >= 1.0d) {
                i0();
            }
            long j10 = ((duration * ((long) this.G)) / 100) - currentPosition;
            if (j10 > 0) {
                this.f16602t.setText(getString(j6.i.f28756b, P(j10)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b0() {
        if (this.f16583a.equalsIgnoreCase("chapters")) {
            g0();
            Timer timer = new Timer();
            this.f16590h = timer;
            f fVar = new f();
            long j10 = this.f16595m;
            timer.schedule(fVar, j10, j10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c0() {
        this.f16603u.setClickable(false);
        this.f16606x.setClickable(false);
        this.f16608z.setClickable(false);
        this.f16607y.setClickable(false);
        new Timer().schedule(new q(), 500L);
    }

    private void d0() {
        h0();
        Timer timer = new Timer();
        this.f16589g = timer;
        timer.schedule(new e(), 0L, 100L);
    }

    private void e0() {
        if (this.H != null) {
            return;
        }
        Timer timer = new Timer();
        this.H = timer;
        timer.schedule(new p(), 100L, 1000L);
    }

    private void f0() {
        TextView textView = this.f16602t;
        if (textView == null) {
            return;
        }
        textView.animate().alpha(0.0f).setDuration(500L).withEndAction(new b()).start();
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(ContextCompat.getColor(this, j6.b.f28705a), ContextCompat.getColor(this, j6.b.f28706b));
        valueAnimatorOfInt.setDuration(500L);
        valueAnimatorOfInt.setEvaluator(new ArgbEvaluator());
        valueAnimatorOfInt.setInterpolator(new LinearInterpolator());
        valueAnimatorOfInt.addUpdateListener(new c());
        valueAnimatorOfInt.start();
    }

    private void g0() {
        Timer timer;
        if (this.f16583a.equalsIgnoreCase("chapters") && (timer = this.f16590h) != null) {
            timer.cancel();
            this.f16590h = null;
        }
    }

    private void h0() {
        Timer timer = this.f16589g;
        if (timer != null) {
            timer.cancel();
        }
    }

    private void i0() {
        Timer timer = this.H;
        if (timer != null) {
            timer.cancel();
            this.H.purge();
            this.H = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j0(int i10, int i11) {
        List<Map<String, String>> chapterConfigMapList = this.J.getChapterConfigMapList();
        String str = chapterConfigMapList.get(i10).get("ad_title_text");
        String str2 = chapterConfigMapList.get(i10).get("ad_description_text");
        String str3 = chapterConfigMapList.get(i11).get("ad_title_text");
        String str4 = chapterConfigMapList.get(i11).get("ad_description_text");
        if (str != null && str3 != null && !str.equals(str3)) {
            this.f16604v.animate().alpha(0.0f).setDuration(300L).withEndAction(new g(str3)).start();
        }
        if (str2 == null || str4 == null || str2.equals(str4)) {
            return;
        }
        this.f16605w.animate().alpha(0.0f).setDuration(300L).withEndAction(new h(str4)).start();
    }

    public void V() {
        Log.d("AbmMediaPlayerActivity", "pauseChapterScroll");
        g0();
    }

    @Override // com.king.amp.sa.d1
    public void a(@NonNull String str) {
        AbmMediaPlayer abmMediaPlayer = this.f16597o;
        if (abmMediaPlayer != null) {
            abmMediaPlayer.onPlayerEvent(str, s1.a());
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if ((motionEvent.getAction() == 1 || motionEvent.getAction() == 3) && this.f16583a.equalsIgnoreCase("chapters")) {
            Y();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // androidx.media3.common.Player.Listener
    public /* synthetic */ void onAudioAttributesChanged(AudioAttributes audioAttributes) {
        androidx.media3.common.g0.a(this, audioAttributes);
    }

    @Override // androidx.media3.common.Player.Listener
    public /* synthetic */ void onAudioSessionIdChanged(int i10) {
        androidx.media3.common.g0.b(this, i10);
    }

    @Override // androidx.media3.common.Player.Listener
    public /* synthetic */ void onAvailableCommandsChanged(Player.Commands commands) {
        androidx.media3.common.g0.c(this, commands);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        AbmMediaPlayer abmMediaPlayer = this.f16597o;
        if (abmMediaPlayer != null) {
            abmMediaPlayer.onPlayerEvent("close", s1.a());
        } else {
            super.onBackPressed();
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NonNull Configuration configuration) {
        if (configuration.orientation == 1) {
            this.L = true;
        }
        super.onConfigurationChanged(configuration);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    @OptIn(markerClass = {UnstableApi.class})
    @SuppressLint({"ClickableViewAccessibility", "SourceLockedOrientationActivity"})
    protected void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setRequestedOrientation(1);
        Bundle extras = getIntent().getExtras();
        setContentView(j6.g.f28745g);
        setVolumeControlStream(3);
        int i10 = 0;
        this.B = 0;
        this.D = 0L;
        if (extras == null || extras.isEmpty()) {
            Log.e("AbmMediaPlayerActivity", "Media playback error: Required config is missing.");
            this.M = r.Finished;
            AbmMediaPlayer abmMediaPlayer = this.f16597o;
            if (abmMediaPlayer != null) {
                abmMediaPlayer.onPlayerDismissed(2, "Media playback error: Required config is missing.");
            }
            finish();
            return;
        }
        String string = extras.getString("ad_type");
        this.f16583a = string;
        if (string == null) {
            this.f16583a = "undefined";
        }
        String string2 = extras.getString("layout_configuration");
        if (TextUtils.isEmpty(string2)) {
            Log.e("AbmMediaPlayerActivity", "Media playback error: layout config is empty.");
            this.M = r.Finished;
            AbmMediaPlayer abmMediaPlayer2 = this.f16597o;
            if (abmMediaPlayer2 != null) {
                abmMediaPlayer2.onPlayerDismissed(4, "Media playback error: layout config is empty.");
            }
            finish();
            return;
        }
        this.J = new AbmMediaPlayerLayoutConfig(string2);
        this.f16597o = AbmMediaPlayer.getInstance();
        if (this.f16583a.equalsIgnoreCase(AbmMediaPlayer.REWARDED_SHORT_RV) || this.f16583a.equalsIgnoreCase(AbmMediaPlayer.REWARDED_LONG_RV)) {
            this.f16584b = (PlayerView) findViewById(j6.f.A);
            DefaultRenderersFactory defaultRenderersFactory = new DefaultRenderersFactory(this);
            defaultRenderersFactory.setExtensionRendererMode(2);
            defaultRenderersFactory.setEnableDecoderFallback(true);
            MediaCodecInfo[] codecInfos = new MediaCodecList(0).getCodecInfos();
            int length = codecInfos.length;
            int i11 = 0;
            while (i11 < length) {
                MediaCodecInfo mediaCodecInfo = codecInfos[i11];
                if (!mediaCodecInfo.isEncoder()) {
                    String[] supportedTypes = mediaCodecInfo.getSupportedTypes();
                    int i12 = i10;
                    for (int length2 = supportedTypes.length; i12 < length2; length2 = length2) {
                        Log.i("AbmMediaPlayerActivity", ">>> Codec: " + mediaCodecInfo.getName() + ", Type: " + supportedTypes[i12]);
                        i12++;
                        supportedTypes = supportedTypes;
                    }
                }
                i11++;
                i10 = 0;
            }
            ExoPlayer exoPlayerBuild = new ExoPlayer.Builder(this).setRenderersFactory(defaultRenderersFactory).build();
            this.f16585c = exoPlayerBuild;
            exoPlayerBuild.addListener(this);
            this.f16585c.setVideoSurface(null);
            this.f16585c.setVideoSurfaceView(null);
            this.f16584b.setPlayer(this.f16585c);
            this.f16584b.setUseController(false);
        } else if (this.f16583a.equalsIgnoreCase("chapters")) {
            this.f16586d = (ViewPager2) findViewById(j6.f.f28720h);
            this.f16588f = (AbmMediaPlayerChapterAdIndicatorView) findViewById(j6.f.f28719g);
            this.f16586d.setOrientation(1);
        }
        this.f16600r = (ConstraintLayout) findViewById(j6.f.f28738z);
        this.f16601s = findViewById(j6.f.B);
        this.f16602t = (TextView) findViewById(j6.f.G);
        this.f16603u = (ImageButton) findViewById(j6.f.f28716d);
        this.f16604v = (TextView) findViewById(j6.f.I);
        this.f16605w = (TextView) findViewById(j6.f.f28727o);
        ImageButton imageButton = (ImageButton) findViewById(j6.f.E);
        this.f16606x = imageButton;
        imageButton.setVisibility(0);
        this.f16606x.setClickable(true);
        this.f16607y = (ImageButton) findViewById(j6.f.f28714b);
        this.f16608z = (Button) findViewById(j6.f.f28726n);
        this.A = findViewById(j6.f.f28729q);
        AbmMediaPlayer abmMediaPlayer3 = this.f16597o;
        if (abmMediaPlayer3 != null) {
            abmMediaPlayer3.setRewardGranted(false);
        }
        this.f16608z.setOnClickListener(new k());
        this.f16603u.setOnClickListener(new l());
        this.f16607y.setOnClickListener(new m());
        this.f16606x.setOnClickListener(new n());
        this.E = R(extras, "video_duration", 0);
        this.F = R(extras, "close_button_playback_percentage", 0);
        this.G = R(extras, "reward_playback_percentage", 100);
        if (this.f16583a.equalsIgnoreCase("chapters")) {
            String string3 = extras.getString("Chapter_configuration");
            if (TextUtils.isEmpty(string3)) {
                Log.e("AbmMediaPlayerActivity", "Media playback error: chapter ad config is empty.");
                this.M = r.Finished;
                AbmMediaPlayer abmMediaPlayer4 = this.f16597o;
                if (abmMediaPlayer4 != null) {
                    abmMediaPlayer4.onPlayerDismissed(4, "Media playback error: chapter ad config is empty.");
                }
                finish();
                return;
            }
            this.J.setChapterConfig(string3);
        } else if (this.f16583a.equalsIgnoreCase(AbmMediaPlayer.REWARDED_SHORT_RV) || this.f16583a.equalsIgnoreCase(AbmMediaPlayer.REWARDED_LONG_RV)) {
            String string4 = extras.getString("ad_media");
            if (TextUtils.isEmpty(string4)) {
                Log.e("AbmMediaPlayerActivity", "Media playback error: media path is empty.");
                this.M = r.Finished;
                AbmMediaPlayer abmMediaPlayer5 = this.f16597o;
                if (abmMediaPlayer5 != null) {
                    abmMediaPlayer5.onPlayerDismissed(2, "Media playback error: media path is empty.");
                }
                finish();
                return;
            }
            MediaItem mediaItemBuild = new MediaItem.Builder().setUri(Uri.parse(string4)).build();
            ProgressiveMediaSource progressiveMediaSourceCreateMediaSource = new ProgressiveMediaSource.Factory(new DefaultDataSource.Factory(this)).createMediaSource(mediaItemBuild);
            ExoPlayer exoPlayer = this.f16585c;
            if (exoPlayer != null) {
                exoPlayer.addMediaSource(progressiveMediaSourceCreateMediaSource);
                this.f16585c.setMediaItem(mediaItemBuild);
            }
        }
        this.K = new s(this.f16600r);
        U();
        Bundle bundle2 = new Bundle();
        bundle2.putString("Layout_configuration", string2);
        this.f16598p = y.w(bundle2, this.f16597o);
        this.f16599q = v.t(this.J, this);
        this.M = r.Initialized;
    }

    @Override // androidx.media3.common.Player.Listener
    public /* synthetic */ void onCues(CueGroup cueGroup) {
        androidx.media3.common.g0.d(this, cueGroup);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        Log.i("AbmMediaPlayerActivity", "onDestroy");
        if (this.L) {
            super.onDestroy();
            return;
        }
        X();
        AbmMediaPlayer abmMediaPlayer = this.f16597o;
        if (abmMediaPlayer != null) {
            abmMediaPlayer.onPlayerDismissed(0, "Player dismissed in onDestroy().");
        }
        AbmMediaPlayer.resetPlayerAddress();
        this.f16597o = null;
        super.onDestroy();
    }

    @Override // androidx.media3.common.Player.Listener
    public /* synthetic */ void onDeviceInfoChanged(DeviceInfo deviceInfo) {
        androidx.media3.common.g0.f(this, deviceInfo);
    }

    @Override // androidx.media3.common.Player.Listener
    public /* synthetic */ void onDeviceVolumeChanged(int i10, boolean z10) {
        androidx.media3.common.g0.g(this, i10, z10);
    }

    @Override // androidx.media3.common.Player.Listener
    public /* synthetic */ void onEvents(Player player, Player.Events events) {
        androidx.media3.common.g0.h(this, player, events);
    }

    @Override // androidx.media3.common.Player.Listener
    public /* synthetic */ void onIsLoadingChanged(boolean z10) {
        androidx.media3.common.g0.i(this, z10);
    }

    @Override // androidx.media3.common.Player.Listener
    public void onIsPlayingChanged(boolean z10) {
        if (this.M == r.Finished) {
            return;
        }
        if (!z10) {
            if (this.I != null) {
                i0();
                this.I.pause();
                return;
            }
            return;
        }
        if (this.I != null) {
            e0();
            if (this.I.isStarted()) {
                this.I.resume();
            } else {
                this.I.start();
            }
        }
    }

    @Override // androidx.media3.common.Player.Listener
    public /* synthetic */ void onLoadingChanged(boolean z10) {
        androidx.media3.common.g0.k(this, z10);
    }

    @Override // androidx.media3.common.Player.Listener
    public /* synthetic */ void onMaxSeekToPreviousPositionChanged(long j10) {
        androidx.media3.common.g0.l(this, j10);
    }

    @Override // androidx.media3.common.Player.Listener
    public /* synthetic */ void onMediaItemTransition(MediaItem mediaItem, int i10) {
        androidx.media3.common.g0.m(this, mediaItem, i10);
    }

    @Override // androidx.media3.common.Player.Listener
    public /* synthetic */ void onMediaMetadataChanged(MediaMetadata mediaMetadata) {
        androidx.media3.common.g0.n(this, mediaMetadata);
    }

    @Override // androidx.media3.common.Player.Listener
    public /* synthetic */ void onMetadata(Metadata metadata) {
        androidx.media3.common.g0.o(this, metadata);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    protected void onNewIntent(Intent intent) {
        W(intent.getExtras());
        super.onNewIntent(intent);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        Log.i("AbmMediaPlayerActivity", v8.h.f15818t0);
        g0();
        this.f16596n = true;
        super.onPause();
        LocalBroadcastManager.getInstance(this).unregisterReceiver(this.O);
        ((MediaRouter) getSystemService("media_router")).removeCallback(this.N);
    }

    @Override // androidx.media3.common.Player.Listener
    public /* synthetic */ void onPlayWhenReadyChanged(boolean z10, int i10) {
        androidx.media3.common.g0.p(this, z10, i10);
    }

    @Override // androidx.media3.common.Player.Listener
    public /* synthetic */ void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {
        androidx.media3.common.g0.q(this, playbackParameters);
    }

    @Override // androidx.media3.common.Player.Listener
    public void onPlaybackStateChanged(int i10) {
        if (this.f16583a.equalsIgnoreCase("chapters")) {
            return;
        }
        if (i10 == 3) {
            AudioManager audioManager = (AudioManager) getSystemService("audio");
            if (audioManager != null) {
                int streamVolume = audioManager.getStreamVolume(3);
                this.C = streamVolume;
                AbmMediaPlayer abmMediaPlayer = this.f16597o;
                if (abmMediaPlayer != null) {
                    if (streamVolume == 0) {
                        abmMediaPlayer.onPlayerEvent("mute", s1.a());
                    } else {
                        abmMediaPlayer.onPlayerEvent("unmute", s1.a());
                    }
                }
            }
            T();
            return;
        }
        if (i10 != 4) {
            return;
        }
        r rVar = this.M;
        r rVar2 = r.Finished;
        if (rVar != rVar2) {
            this.M = rVar2;
            ExoPlayer exoPlayer = this.f16585c;
            if (exoPlayer != null) {
                this.D = exoPlayer.getCurrentPosition();
                AbmMediaPlayer abmMediaPlayer2 = this.f16597o;
                if (abmMediaPlayer2 != null) {
                    abmMediaPlayer2.onPlayerProgressV1(100, this.f16585c.getCurrentPosition() / 1000.0f);
                }
            }
        }
    }

    @Override // androidx.media3.common.Player.Listener
    public /* synthetic */ void onPlaybackSuppressionReasonChanged(int i10) {
        androidx.media3.common.g0.s(this, i10);
    }

    @Override // androidx.media3.common.Player.Listener
    public void onPlayerError(@NonNull PlaybackException playbackException) {
        AbmMediaPlayer abmMediaPlayer = this.f16597o;
        if (abmMediaPlayer != null) {
            abmMediaPlayer.onPlayerDismissed(6, "Player error=" + playbackException.errorCode + ", " + PlaybackException.getErrorCodeName(playbackException.errorCode) + ", " + playbackException.getMessage());
        }
        finish();
    }

    @Override // androidx.media3.common.Player.Listener
    public /* synthetic */ void onPlayerErrorChanged(PlaybackException playbackException) {
        androidx.media3.common.g0.u(this, playbackException);
    }

    @Override // androidx.media3.common.Player.Listener
    public /* synthetic */ void onPlayerStateChanged(boolean z10, int i10) {
        androidx.media3.common.g0.v(this, z10, i10);
    }

    @Override // androidx.media3.common.Player.Listener
    public /* synthetic */ void onPlaylistMetadataChanged(MediaMetadata mediaMetadata) {
        androidx.media3.common.g0.w(this, mediaMetadata);
    }

    @Override // androidx.media3.common.Player.Listener
    public /* synthetic */ void onPositionDiscontinuity(int i10) {
        androidx.media3.common.g0.x(this, i10);
    }

    @Override // androidx.media3.common.Player.Listener
    public /* synthetic */ void onRenderedFirstFrame() {
        androidx.media3.common.g0.z(this);
    }

    @Override // androidx.media3.common.Player.Listener
    public /* synthetic */ void onRepeatModeChanged(int i10) {
        androidx.media3.common.g0.A(this, i10);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        Log.i("AbmMediaPlayerActivity", v8.h.f15820u0);
        super.onResume();
        LocalBroadcastManager.getInstance(this).registerReceiver(this.O, new IntentFilter("com.king.amp.sa.UPDATE_PLAYER_ACTIVITY"));
        if (this.f16596n) {
            b0();
            this.f16596n = false;
        }
        ((MediaRouter) getSystemService("media_router")).addCallback(8388608, this.N, 2);
    }

    @Override // androidx.media3.common.Player.Listener
    public /* synthetic */ void onSeekBackIncrementChanged(long j10) {
        androidx.media3.common.g0.B(this, j10);
    }

    @Override // androidx.media3.common.Player.Listener
    public /* synthetic */ void onSeekForwardIncrementChanged(long j10) {
        androidx.media3.common.g0.C(this, j10);
    }

    @Override // androidx.media3.common.Player.Listener
    public /* synthetic */ void onShuffleModeEnabledChanged(boolean z10) {
        androidx.media3.common.g0.D(this, z10);
    }

    @Override // androidx.media3.common.Player.Listener
    public /* synthetic */ void onSkipSilenceEnabledChanged(boolean z10) {
        androidx.media3.common.g0.E(this, z10);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        ExoPlayer exoPlayer;
        if (this.M == r.Initialized && (exoPlayer = this.f16585c) != null) {
            this.M = r.Showing;
            exoPlayer.prepare();
            this.B = (int) (this.f16585c.getVolume() * 100.0f);
        }
        super.onStart();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        Log.i("AbmMediaPlayerActivity", "onStop");
        if (isFinishing()) {
            Log.i("AbmMediaPlayerActivity", "onStop::finishing");
            X();
            AbmMediaPlayer abmMediaPlayer = this.f16597o;
            if (abmMediaPlayer != null) {
                abmMediaPlayer.onPlayerDismissed(0, "");
            }
        }
        g0();
        h0();
        super.onStop();
    }

    @Override // androidx.media3.common.Player.Listener
    public /* synthetic */ void onSurfaceSizeChanged(int i10, int i11) {
        androidx.media3.common.g0.F(this, i10, i11);
    }

    @Override // androidx.media3.common.Player.Listener
    public /* synthetic */ void onTimelineChanged(Timeline timeline, int i10) {
        androidx.media3.common.g0.G(this, timeline, i10);
    }

    @Override // androidx.media3.common.Player.Listener
    public /* synthetic */ void onTrackSelectionParametersChanged(TrackSelectionParameters trackSelectionParameters) {
        androidx.media3.common.g0.H(this, trackSelectionParameters);
    }

    @Override // androidx.media3.common.Player.Listener
    @OptIn(markerClass = {UnstableApi.class})
    public void onTracksChanged(Tracks tracks) {
        com.google.common.collect.i1<Tracks.Group> it = tracks.getGroups().iterator();
        while (it.hasNext()) {
            TrackGroup mediaTrackGroup = it.next().getMediaTrackGroup();
            for (int i10 = 0; i10 < mediaTrackGroup.length; i10++) {
                Log.i("AbmMediaPlayerActivity", "Track Info: " + mediaTrackGroup.getFormat(i10).toString());
            }
        }
    }

    @Override // androidx.media3.common.Player.Listener
    public void onVideoSizeChanged(VideoSize videoSize) {
        androidx.media3.common.g0.J(this, videoSize);
    }

    @Override // androidx.media3.common.Player.Listener
    public /* synthetic */ void onVolumeChanged(float f10) {
        androidx.media3.common.g0.K(this, f10);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z10) {
        super.onWindowFocusChanged(z10);
        if (!z10) {
            if (this.M == r.Finished) {
                return;
            }
            ExoPlayer exoPlayer = this.f16585c;
            if (exoPlayer != null && exoPlayer.isPlaying()) {
                this.f16585c.pause();
            }
            if (this.f16583a.equalsIgnoreCase("chapters")) {
                g0();
                this.I.pause();
                h0();
            }
            AbmMediaPlayer abmMediaPlayer = this.f16597o;
            if (abmMediaPlayer != null) {
                abmMediaPlayer.onPlayerEvent("pause", s1.a());
                return;
            }
            return;
        }
        if (this.M == r.Finished) {
            ExoPlayer exoPlayer2 = this.f16585c;
            if (exoPlayer2 != null) {
                exoPlayer2.seekTo(this.D);
            }
            AbmMediaPlayer abmMediaPlayer2 = this.f16597o;
            if (abmMediaPlayer2 != null) {
                abmMediaPlayer2.onPlayerEvent("resume", s1.a());
                return;
            }
            return;
        }
        ExoPlayer exoPlayer3 = this.f16585c;
        if (exoPlayer3 != null && !exoPlayer3.isPlaying()) {
            this.f16585c.play();
        }
        if (this.f16583a.equalsIgnoreCase("chapters")) {
            b0();
            if (this.I.isStarted()) {
                this.I.resume();
            } else {
                this.I.start();
            }
            d0();
        }
    }

    @Override // androidx.media3.common.Player.Listener
    public /* synthetic */ void onCues(List list) {
        androidx.media3.common.g0.e(this, list);
    }

    @Override // androidx.media3.common.Player.Listener
    public /* synthetic */ void onPositionDiscontinuity(Player.PositionInfo positionInfo, Player.PositionInfo positionInfo2, int i10) {
        androidx.media3.common.g0.y(this, positionInfo, positionInfo2, i10);
    }

    class i extends MediaRouter.Callback {
        i() {
        }

        @Override // android.media.MediaRouter.Callback
        public void onRouteVolumeChanged(MediaRouter mediaRouter, MediaRouter.RouteInfo routeInfo) {
            Log.d("AbmMediaPlayerActivity", "onRouteVolumeChanged: " + routeInfo.getVolume());
            if (AbmMediaPlayerActivity.this.f16597o == null) {
                Log.w("AbmMediaPlayerActivity", "ABM Player is null.");
                return;
            }
            AudioManager audioManager = (AudioManager) AbmMediaPlayerActivity.this.getSystemService("audio");
            if (audioManager == null) {
                Log.w("AbmMediaPlayerActivity", "Failed to get AudioManager service.");
                return;
            }
            if (AbmMediaPlayerActivity.this.C == 0 && audioManager.getStreamVolume(3) > 0) {
                AbmMediaPlayerActivity.this.f16597o.onPlayerEvent("unmute", s1.a());
            }
            if (AbmMediaPlayerActivity.this.C > 0 && audioManager.getStreamVolume(3) == 0) {
                AbmMediaPlayerActivity.this.f16597o.onPlayerEvent("mute", s1.a());
            }
            AbmMediaPlayerActivity.this.C = audioManager.getStreamVolume(3);
        }

        @Override // android.media.MediaRouter.Callback
        public void onRouteAdded(MediaRouter mediaRouter, MediaRouter.RouteInfo routeInfo) {
        }

        @Override // android.media.MediaRouter.Callback
        public void onRouteChanged(MediaRouter mediaRouter, MediaRouter.RouteInfo routeInfo) {
        }

        @Override // android.media.MediaRouter.Callback
        public void onRouteRemoved(MediaRouter mediaRouter, MediaRouter.RouteInfo routeInfo) {
        }

        @Override // android.media.MediaRouter.Callback
        public void onRouteSelected(MediaRouter mediaRouter, int i10, MediaRouter.RouteInfo routeInfo) {
        }

        @Override // android.media.MediaRouter.Callback
        public void onRouteUngrouped(MediaRouter mediaRouter, MediaRouter.RouteInfo routeInfo, MediaRouter.RouteGroup routeGroup) {
        }

        @Override // android.media.MediaRouter.Callback
        public void onRouteUnselected(MediaRouter mediaRouter, int i10, MediaRouter.RouteInfo routeInfo) {
        }

        @Override // android.media.MediaRouter.Callback
        public void onRouteGrouped(MediaRouter mediaRouter, MediaRouter.RouteInfo routeInfo, MediaRouter.RouteGroup routeGroup, int i10) {
        }
    }
}
