package com.king.amp.sa;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.media.MediaRouter;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Display;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.ironsource.v8;
import com.king.amp.sa.i0;
import com.king.amp.sa.r1;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: loaded from: classes4.dex */
public class AbmAdActivity extends AppCompatActivity {
    private Map<String, String> A;
    private m B;
    private int D;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private AbmAdPlayer f16531a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private n f16532b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private k6.a f16533c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ConstraintLayout f16534d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private View f16535e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private View f16536f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private ImageView f16537g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private ImageView f16538h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private TextView f16539i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private ImageButton f16540j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private View f16541k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private TextView f16542l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private TextView f16543m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private ImageButton f16544n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private ImageButton f16545o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private Button f16546p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private ProgressBar f16547q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private i0 f16548r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f16549s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f16550t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private int f16551u;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private long f16553w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private long f16554x;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private long f16556z;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private long f16552v = 0;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private boolean f16555y = false;
    private Boolean C = Boolean.FALSE;
    final MediaRouter.Callback E = new d();

    class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f16557a;

        /* JADX INFO: renamed from: com.king.amp.sa.AbmAdActivity$a$a, reason: collision with other inner class name */
        class RunnableC0275a implements Runnable {
            RunnableC0275a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                AbmAdActivity.this.f16542l.setVisibility(0);
            }
        }

        a(String str) {
            this.f16557a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            AbmAdActivity.this.f16542l.setText(this.f16557a);
            AbmAdActivity.this.f16542l.animate().alpha(1.0f).setDuration(300L).withEndAction(new RunnableC0275a()).start();
        }
    }

    class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f16560a;

        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                AbmAdActivity.this.f16543m.setVisibility(0);
            }
        }

        b(String str) {
            this.f16560a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            AbmAdActivity.this.f16543m.setText(this.f16560a);
            AbmAdActivity.this.f16543m.animate().alpha(1.0f).setDuration(300L).withEndAction(new a()).start();
        }
    }

    class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f16563a;

        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                AbmAdActivity.this.f16546p.setVisibility(0);
            }
        }

        c(String str) {
            this.f16563a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            AbmAdActivity.this.f16546p.setText(this.f16563a);
            AbmAdActivity.this.f16546p.animate().alpha(1.0f).setDuration(300L).withEndAction(new a()).start();
        }
    }

    class e implements View.OnClickListener {
        e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AbmAdActivity.this.E0();
            if (AbmAdActivity.this.f16531a != null) {
                AbmAdActivity.this.f16531a.onPlayerEvent("ad_icon", s1.d(new AdProviderNameValuePairs()));
            }
        }
    }

    class f implements View.OnClickListener {
        f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AbmAdActivity.this.E0();
            if (AbmAdActivity.this.f16531a != null) {
                AbmAdActivity.this.f16531a.onPlayerEvent("close", s1.a());
            }
        }
    }

    class g implements View.OnClickListener {
        g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AbmAdActivity.this.E0();
            if (AbmAdActivity.this.f16531a != null) {
                AbmAdActivity.this.f16531a.onPlayerEvent("cta", s1.a());
            }
        }
    }

    class h extends OnBackPressedCallback {
        h(boolean z10) {
            super(z10);
        }

        @Override // androidx.activity.OnBackPressedCallback
        public void handleOnBackPressed() {
            if (AbmAdActivity.this.f16531a != null) {
                AbmAdActivity.this.f16531a.onPlayerEvent("close", s1.a());
            }
        }
    }

    class i implements Runnable {

        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                AbmAdActivity.this.f16539i.setVisibility(0);
            }
        }

        i() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AbmAdActivity.this.f16539i.setText(AbmAdActivity.this.getString(j6.i.f28755a));
            AbmAdActivity.this.f16539i.animate().alpha(1.0f).setDuration(500L).withEndAction(new a()).start();
        }
    }

    class j implements ValueAnimator.AnimatorUpdateListener {
        j() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
            AbmAdActivity.this.f16535e.setBackgroundTintList(ColorStateList.valueOf(((Integer) valueAnimator.getAnimatedValue()).intValue()));
        }
    }

    class k extends TimerTask {

        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                AbmAdActivity.this.f16544n.setEnabled(true);
                AbmAdActivity.this.f16546p.setEnabled(true);
                AbmAdActivity.this.f16540j.setEnabled(true);
                AbmAdActivity.this.f16545o.setEnabled(true);
            }
        }

        k() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            AbmAdActivity.this.runOnUiThread(new a());
        }
    }

    class l implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f16576a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f16577b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f16578c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f16579d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f16580e;

        l(View view, int i10, int i11, int i12, int i13) {
            this.f16576a = view;
            this.f16577b = i10;
            this.f16578c = i11;
            this.f16579d = i12;
            this.f16580e = i13;
        }

        @Override // java.lang.Runnable
        public void run() {
            Rect rect = new Rect();
            this.f16576a.getHitRect(rect);
            rect.top -= this.f16577b;
            rect.bottom += this.f16578c;
            rect.left -= this.f16579d;
            rect.right += this.f16580e;
            AbmAdActivity.this.B.a(new TouchDelegate(rect, this.f16576a));
            AbmAdActivity.this.f16534d.setTouchDelegate(AbmAdActivity.this.B);
        }
    }

    @VisibleForTesting
    protected static class m extends TouchDelegate {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        protected final List<TouchDelegate> f16582a;

        public m(View view) {
            super(new Rect(), view);
            this.f16582a = new ArrayList();
        }

        public void a(TouchDelegate touchDelegate) {
            if (touchDelegate != null) {
                this.f16582a.add(touchDelegate);
            }
        }

        @Override // android.view.TouchDelegate
        public boolean onTouchEvent(MotionEvent motionEvent) {
            boolean z10;
            float x10 = motionEvent.getX();
            float y10 = motionEvent.getY();
            while (true) {
                for (TouchDelegate touchDelegate : this.f16582a) {
                    motionEvent.setLocation(x10, y10);
                    z10 = touchDelegate.onTouchEvent(motionEvent) || z10;
                }
                return z10;
            }
        }
    }

    private void R(r0 r0Var, boolean z10) {
        if (this.C.booleanValue()) {
            x0();
            y0("resume", r0Var, z10);
        }
        this.C = Boolean.TRUE;
    }

    private void S(r0 r0Var, boolean z10) {
        if (this.C.booleanValue()) {
            w0();
            y0("pause", r0Var, z10);
        }
    }

    private void T(float f10, long j10, long j11) {
        this.f16535e.getLayoutParams().width = (int) f10;
        int iFloor = (int) Math.floor(j10 / 1000.0f);
        int iFloor2 = (int) Math.floor((j10 - this.f16556z) / 1000.0f);
        if (iFloor > this.f16550t) {
            U(this.f16554x - j10);
        }
        if (this.f16531a != null && (iFloor > this.f16550t || iFloor2 > this.f16551u)) {
            this.f16550t = iFloor;
            this.f16551u = iFloor2;
            Fragment fragmentFindFragmentByTag = getSupportFragmentManager().findFragmentByTag("AbmVideoFragment");
            if ((fragmentFindFragmentByTag instanceof r0) && fragmentFindFragmentByTag.isVisible() && iFloor2 == 1) {
                r0 r0Var = (r0) fragmentFindFragmentByTag;
                View view = this.f16535e;
                r1.d dVar = r1.d.OTHER;
                r0Var.F(view, dVar, "Progress bar");
                r0Var.F(this.f16540j, dVar, "Advertiser icon");
                r0Var.F(this.f16542l, dVar, "Title");
                r0Var.F(this.f16543m, dVar, "Description");
                r0Var.F(this.f16545o, dVar, "Ad choices icon");
                r0Var.F(this.f16546p, dVar, "CTA button");
                r0Var.F(this.f16544n, r1.d.CLOSE_AD, "Close button");
                r0Var.F(this.f16539i, dVar, "Remaining time");
            }
            if (fragmentFindFragmentByTag instanceof l0) {
                ((l0) fragmentFindFragmentByTag).X(iFloor2, this.f16550t);
            } else {
                this.f16531a.onPlayerProgressV2(iFloor2, this.f16550t);
            }
        }
        if (j10 >= j11) {
            this.C = Boolean.FALSE;
            this.f16555y = true;
        }
        this.f16535e.requestLayout();
    }

    private void U(long j10) {
        if (this.f16539i.getVisibility() == 8) {
            Log.d("AbmAdActivity", "Reward Countdown text is disabled");
            return;
        }
        if (this.f16554x < 0) {
            this.f16539i.setVisibility(4);
            return;
        }
        if (j10 >= 0) {
            String str = String.format(Locale.getDefault(), "%02d:%02d", Integer.valueOf((int) ((j10 / 60000) % 60)), Integer.valueOf(((int) (j10 / 1000)) % 60));
            n nVar = this.f16532b;
            if (nVar != null && (nVar.j().getValue() == null || !this.f16532b.j().getValue().booleanValue())) {
                J0(str);
            }
        }
        if (j10 <= 0) {
            this.C = Boolean.FALSE;
        }
    }

    private boolean Z(r0 r0Var) {
        if (r0Var instanceof l0) {
            return ((l0) r0Var).T();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a0(float f10) {
        T(f10, this.f16548r.o(), this.f16553w);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c0(Map map) {
        if (map != null) {
            G0(map);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d0(Integer num) {
        this.f16547q.setProgress(num.intValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e0(Integer num) {
        if (num != null) {
            z0(num.intValue());
            this.f16547q.setMax(100);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f0(Boolean bool) {
        if (bool != null) {
            H0(bool.booleanValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g0(Integer num) {
        if (num != null) {
            B0(num.intValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h0(Map map) {
        this.A = map;
        Y();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i0(Integer num) {
        if (num != null) {
            int iIntValue = num.intValue();
            if (iIntValue == 1) {
                x0();
            } else if (iIntValue != 2) {
                w0();
            } else {
                F0();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j0(Integer num) {
        if (num != null) {
            C0(num.intValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k0(Boolean bool) {
        if (Boolean.TRUE.equals(bool)) {
            K0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l0(Integer num) {
        if (num != null) {
            D0(num.intValue());
        }
    }

    private void m0() {
        n nVar = this.f16532b;
        if (nVar == null) {
            return;
        }
        nVar.a().observe(this, new Observer() { // from class: com.king.amp.sa.g
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f16749a.c0((Map) obj);
            }
        });
    }

    private void n0() {
        n nVar = this.f16532b;
        if (nVar == null) {
            return;
        }
        nVar.b().observe(this, new Observer() { // from class: com.king.amp.sa.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f16720a.d0((Integer) obj);
            }
        });
    }

    private void o0() {
        n nVar = this.f16532b;
        if (nVar == null) {
            return;
        }
        nVar.c().observe(this, new Observer() { // from class: com.king.amp.sa.k
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f16787a.e0((Integer) obj);
            }
        });
    }

    private void p0() {
        n nVar = this.f16532b;
        if (nVar == null) {
            return;
        }
        nVar.e().observe(this, new Observer() { // from class: com.king.amp.sa.i
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f16765a.f0((Boolean) obj);
            }
        });
    }

    private void q0() {
        n nVar = this.f16532b;
        if (nVar == null) {
            return;
        }
        nVar.d().observe(this, new Observer() { // from class: com.king.amp.sa.j
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f16785a.g0((Integer) obj);
            }
        });
    }

    private void r0() {
        n nVar = this.f16532b;
        if (nVar == null) {
            return;
        }
        nVar.f().observe(this, new Observer() { // from class: com.king.amp.sa.h
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f16751a.h0((Map) obj);
            }
        });
    }

    private void s0() {
        n nVar = this.f16532b;
        if (nVar == null) {
            return;
        }
        nVar.h().observe(this, new Observer() { // from class: com.king.amp.sa.f
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f16746a.i0((Integer) obj);
            }
        });
    }

    private void t0() {
        n nVar = this.f16532b;
        if (nVar == null) {
            return;
        }
        nVar.i().observe(this, new Observer() { // from class: com.king.amp.sa.l
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f16789a.j0((Integer) obj);
            }
        });
    }

    private void u0() {
        n nVar = this.f16532b;
        if (nVar == null) {
            return;
        }
        nVar.j().observe(this, new Observer() { // from class: com.king.amp.sa.m
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f16815a.k0((Boolean) obj);
            }
        });
    }

    private void v0() {
        n nVar = this.f16532b;
        if (nVar == null) {
            return;
        }
        nVar.k().observe(this, new Observer() { // from class: com.king.amp.sa.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f16743a.l0((Integer) obj);
            }
        });
    }

    private void y0(String str, r0 r0Var, boolean z10) {
        AdProviderNameValuePairs adProviderNameValuePairs = new AdProviderNameValuePairs();
        adProviderNameValuePairs.add("reason", "");
        adProviderNameValuePairs.add(AbmAdPlayer.PAUSE_RESUME_CONTROLLER_TYPE, r0Var != null ? r0Var.p() : "");
        adProviderNameValuePairs.add("rewarded", Integer.valueOf(Boolean.TRUE.equals(this.f16532b.j().getValue()) ? 1 : 0));
        adProviderNameValuePairs.add(AbmAdPlayer.PAUSE_RESUME_PLAYBACK_FINISHED, Integer.valueOf(z10 ? 1 : 0));
        AbmAdPlayer abmAdPlayer = this.f16531a;
        if (abmAdPlayer != null) {
            abmAdPlayer.onPlayerEvent(str, s1.d(adProviderNameValuePairs));
        }
    }

    @VisibleForTesting
    protected void A0(int i10) {
        this.f16544n.setVisibility(i10);
        if (i10 == 0) {
            V(this.f16544n, 20, 150, 150, 20);
        }
    }

    @VisibleForTesting
    protected void B0(int i10) {
        this.f16546p.setVisibility(i10);
        if (i10 == 0) {
            V(this.f16546p, 150, 150, 150, 150);
        }
    }

    @VisibleForTesting
    protected void C0(int i10) {
        this.f16535e.setVisibility(i10);
        this.f16536f.setVisibility(i10);
        this.f16539i.setVisibility(i10);
    }

    @VisibleForTesting
    protected void D0(int i10) {
        this.f16537g.setVisibility(i10);
        this.f16538h.setVisibility(i10);
    }

    @VisibleForTesting
    protected void E0() {
        this.f16544n.setEnabled(false);
        this.f16546p.setEnabled(false);
        this.f16540j.setEnabled(false);
        this.f16545o.setEnabled(false);
        new Timer().schedule(new k(), 500L);
    }

    @VisibleForTesting
    protected void F0() {
        if (this.f16535e.getVisibility() == 8) {
            Log.d("AbmAdActivity", "progress bar is disabled");
            return;
        }
        Log.d("AbmAdActivity", "startProgressAnimation called at " + this.f16552v);
        i0 i0Var = this.f16548r;
        if (i0Var == null || this.f16555y) {
            Log.e("AbmAdActivity", "Abm Ad Activity Error: Progress bar has not been initialized or has finished");
            return;
        }
        this.f16556z = this.f16552v;
        this.f16551u = 0;
        if (i0Var.q()) {
            this.f16548r.s();
        } else {
            this.f16548r.t(this.f16552v);
            this.f16548r.v();
        }
    }

    @VisibleForTesting
    protected void G0(Map<String, String> map) {
        String str = map.get("current_title");
        String str2 = map.get("current_description");
        String str3 = map.get("current_adIcon");
        String str4 = map.get("current_cta_title");
        String str5 = map.get("next_title");
        String str6 = map.get("next_description");
        String str7 = map.get("next_adIcon");
        String str8 = map.get("next_cta_title");
        if (str != null && str5 != null && !str.equals(str5)) {
            this.f16542l.animate().alpha(0.0f).setDuration(300L).withEndAction(new a(str5)).start();
        }
        if (str2 != null && str6 != null && !str2.equals(str6)) {
            this.f16543m.animate().alpha(0.0f).setDuration(300L).withEndAction(new b(str6)).start();
        }
        if (str3 != null && str7 != null && !str3.equals(str7)) {
            this.f16540j.setImageDrawable(Drawable.createFromPath(str7));
        }
        if (str4 == null || str8 == null || str4.equals(str8)) {
            return;
        }
        this.f16546p.animate().alpha(0.0f).setDuration(300L).withEndAction(new c(str8)).start();
    }

    @VisibleForTesting
    protected void H0(boolean z10) {
        this.f16546p.setEnabled(z10);
    }

    public void I0(long j10, long j11) {
        this.f16553w = j10;
        this.f16554x = j11;
    }

    @VisibleForTesting
    protected void J0(String str) {
        this.f16539i.setText(getString(j6.i.f28756b, str));
    }

    @VisibleForTesting
    protected void K0() {
        if (this.f16539i.getVisibility() == 8) {
            return;
        }
        this.f16539i.animate().alpha(0.0f).setDuration(500L).withEndAction(new i()).start();
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(ContextCompat.getColor(this, j6.b.f28705a), ContextCompat.getColor(this, j6.b.f28706b));
        valueAnimatorOfInt.setDuration(500L);
        valueAnimatorOfInt.setEvaluator(new ArgbEvaluator());
        valueAnimatorOfInt.setInterpolator(new LinearInterpolator());
        valueAnimatorOfInt.addUpdateListener(new j());
        valueAnimatorOfInt.start();
    }

    @VisibleForTesting
    protected n Q() {
        return (n) new ViewModelProvider(this).get(n.class);
    }

    @VisibleForTesting
    protected void V(View view, int i10, int i11, int i12, int i13) {
        this.f16534d.post(new l(view, i10, i11, i12, i13));
    }

    @VisibleForTesting
    protected void W() {
        this.f16532b = Q();
        r0();
        q0();
        t0();
        u0();
        s0();
        m0();
        o0();
        v0();
        n0();
        p0();
    }

    @VisibleForTesting
    protected void X() {
        if (this.f16535e.getVisibility() == 8) {
            Log.d("AbmAdActivity", "progress bar is disabled");
            return;
        }
        Log.d("AbmAdActivity", "initializeProgressBar called with milliseconds: " + this.f16553w + " " + this.f16554x);
        this.f16550t = 0;
        this.f16551u = 0;
        this.f16548r = new i0(1, this.f16549s, this.f16553w, new LinearInterpolator(), new i0.c() { // from class: com.king.amp.sa.c
            @Override // com.king.amp.sa.i0.c
            public final void a(float f10) {
                this.f16731a.a0(f10);
            }
        }, new i0.b() { // from class: com.king.amp.sa.d
            @Override // com.king.amp.sa.i0.b
            public final void a() {
                Log.d("AbmSafeValueAnimator", "Animation finished!");
            }
        });
    }

    @SuppressLint({"UseCompatLoadingForDrawables"})
    @VisibleForTesting
    protected void Y() {
        if (this.A == null) {
            return;
        }
        Display defaultDisplay = getWindowManager().getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        String str = this.A.get("is_landscape_enabled");
        if (TextUtils.isEmpty(str) || !str.equalsIgnoreCase(com.ironsource.mediationsdk.metadata.a.f13688g)) {
            this.f16549s = Math.min(point.x, point.y);
            setRequestedOrientation(1);
        } else {
            this.f16549s = point.x;
        }
        i0 i0Var = this.f16548r;
        if (i0Var != null) {
            i0Var.n();
        }
        X();
        String str2 = this.A.get("ad_title_text");
        if (TextUtils.isEmpty(str2)) {
            this.f16542l.setVisibility(4);
        } else {
            this.f16542l.setVisibility(0);
            this.f16542l.setText(str2);
        }
        String str3 = this.A.get("ad_description_text");
        if (TextUtils.isEmpty(str3)) {
            this.f16543m.setVisibility(4);
        } else {
            this.f16543m.setVisibility(0);
            this.f16543m.setText(str3);
        }
        String str4 = this.A.get("cta_button_title");
        if (!TextUtils.isEmpty(str4)) {
            this.f16546p.setText(str4);
        }
        String str5 = this.A.get("cta_button_image");
        if (!TextUtils.isEmpty(str5)) {
            this.f16546p.setBackground(Drawable.createFromPath(str5));
        }
        V(this.f16546p, 150, 150, 150, 150);
        String str6 = this.A.get("advertiser_icon");
        if (TextUtils.isEmpty(str6)) {
            this.f16540j.setVisibility(8);
        } else {
            this.f16540j.setClipToOutline(true);
            this.f16540j.setVisibility(0);
            this.f16540j.setImageDrawable(Drawable.createFromPath(str6));
            V(this.f16540j, 20, 150, 20, 150);
        }
        if (TextUtils.isEmpty(this.A.get("adchoice_url"))) {
            this.f16545o.setVisibility(8);
            return;
        }
        this.f16545o.setVisibility(0);
        String str7 = this.A.get("adchoice_icon");
        if (TextUtils.isEmpty(str7)) {
            this.f16545o.setImageResource(j6.d.f28708a);
        } else {
            this.f16545o.setImageDrawable(Drawable.createFromPath(str7));
        }
        V(this.f16545o, 50, 50, 50, 0);
    }

    @Override // android.app.Activity
    public void finish() {
        this.C = Boolean.FALSE;
        super.finish();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NonNull Configuration configuration) {
        super.onConfigurationChanged(configuration);
        Display defaultDisplay = getWindowManager().getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        this.f16549s = point.x;
        if (this.f16555y) {
            ViewGroup.LayoutParams layoutParams = this.f16535e.getLayoutParams();
            layoutParams.width = this.f16549s;
            this.f16535e.setLayoutParams(layoutParams);
            return;
        }
        i0 i0Var = this.f16548r;
        if (i0Var != null) {
            long jO = i0Var.o();
            if (!hasWindowFocus()) {
                jO = this.f16552v;
            }
            this.f16548r.n();
            this.f16548r.u(1, this.f16549s);
            this.f16548r.t(jO);
            if (getSupportFragmentManager().findFragmentByTag("AbmMediaPlayerPromptDialogFragment") == null) {
                this.f16552v = jO;
                x0();
            }
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    @SuppressLint({"SourceLockedOrientationActivity"})
    protected void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        Bundle extras = getIntent().getExtras();
        if (extras == null || extras.isEmpty()) {
            Log.e("AbmAdActivity", "Abm Ad Activity error: missing required config");
            finish();
            return;
        }
        long j10 = extras.getLong("AbmPlayerInstanceId");
        if (j10 == 0) {
            Log.e("AbmAdActivity", "Initialization error: missing required instance Id");
            finish();
            return;
        }
        AbmAdPlayer abmAdPlayer = AbmAdPlayer.getInstance(j10);
        this.f16531a = abmAdPlayer;
        if (abmAdPlayer == null) {
            Log.e("AbmAdActivity", "Abm Ad Activity error: missing required AbmAdPlayer");
            finish();
            return;
        }
        k6.a aVarC = k6.a.c(getLayoutInflater());
        this.f16533c = aVarC;
        setContentView(aVarC.getRoot());
        k6.a aVar = this.f16533c;
        this.f16534d = aVar.f29679b;
        this.f16535e = aVar.f29691n;
        this.f16536f = aVar.f29692o;
        ImageButton imageButton = aVar.f29682e;
        this.f16540j = imageButton;
        this.f16541k = aVar.f29690m;
        this.f16542l = aVar.f29694q;
        this.f16543m = aVar.f29686i;
        this.f16544n = aVar.f29684g;
        this.f16546p = aVar.f29685h;
        this.f16539i = aVar.f29693p;
        this.f16545o = aVar.f29680c;
        this.f16547q = aVar.f29683f;
        this.f16537g = aVar.f29695r;
        this.f16538h = aVar.f29689l;
        imageButton.setOnClickListener(new e());
        this.f16544n.setOnClickListener(new f());
        this.f16546p.setOnClickListener(new g());
        this.B = new m(this.f16534d);
        W();
        A0(0);
        AudioManager audioManager = (AudioManager) getSystemService("audio");
        if (audioManager != null) {
            this.D = audioManager.getStreamVolume(3);
        }
        ((MediaRouter) getSystemService("media_router")).addCallback(8388608, this.E, 2);
        getOnBackPressedDispatcher().addCallback(this, new h(true));
        this.f16547q.setProgress(0);
        AbmAdPlayer abmAdPlayer2 = this.f16531a;
        if (abmAdPlayer2 != null) {
            abmAdPlayer2.onActivityReady(this);
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        ((MediaRouter) getSystemService("media_router")).removeCallback(this.E);
        if (!isFinishing() || this.f16531a == null) {
            return;
        }
        Log.d("AbmAdActivity", "onDestroy called, player is not null");
        this.f16531a.onPlayerDismissed(0, "");
        this.f16531a = null;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        Log.d("AbmAdActivity", v8.h.f15818t0);
        super.onPause();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        Log.d("AbmAdActivity", v8.h.f15820u0);
        super.onResume();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        super.onStart();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        super.onStop();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z10) {
        super.onWindowFocusChanged(z10);
        Log.d("AbmAdActivity", "onWindowFocusChanged called " + z10);
        AbmAdPlayer abmAdPlayer = this.f16531a;
        if (abmAdPlayer == null) {
            return;
        }
        r0 currentController = abmAdPlayer.getCurrentController();
        boolean Z = Z(currentController);
        if (z10) {
            R(currentController, Z);
        } else {
            S(currentController, Z);
        }
    }

    @VisibleForTesting
    protected void w0() {
        if (this.f16535e.getVisibility() == 8) {
            Log.d("AbmAdActivity", "progress bar is disabled");
            return;
        }
        if (this.f16548r == null) {
            Log.e("AbmAdActivity", "Abm Ad Activity Error: Progress bar has not been initialized");
            return;
        }
        Log.d("AbmAdActivity", "pauseProgressAnimation called at " + this.f16548r.o());
        if (this.f16548r.p()) {
            this.f16548r.r();
            this.f16552v = this.f16548r.o();
        }
        getWindow().clearFlags(128);
    }

    @VisibleForTesting
    protected void x0() {
        if (this.f16535e.getVisibility() == 8) {
            Log.d("AbmAdActivity", "progress bar is disabled");
            return;
        }
        Log.d("AbmAdActivity", "resumeProgressAnimation called at " + this.f16552v);
        i0 i0Var = this.f16548r;
        if (i0Var == null || this.f16555y) {
            Log.e("AbmAdActivity", "Abm Ad Activity Error: Progress bar has not been initialized or has finished");
            return;
        }
        if (i0Var.q()) {
            this.f16548r.s();
        } else {
            this.f16548r.v();
            this.f16548r.t(this.f16552v);
        }
        getWindow().addFlags(128);
    }

    @VisibleForTesting
    protected void z0(int i10) {
        this.f16547q.setVisibility(i10);
        if (this.f16540j.getVisibility() == 8) {
            this.f16541k.setVisibility(0);
        } else {
            this.f16541k.setVisibility(8);
        }
    }

    class d extends MediaRouter.Callback {
        d() {
        }

        @Override // android.media.MediaRouter.Callback
        public void onRouteVolumeChanged(MediaRouter mediaRouter, MediaRouter.RouteInfo routeInfo) {
            Log.d("AbmAdActivity", "onRouteVolumeChanged: " + routeInfo.getVolume());
            if (AbmAdActivity.this.f16531a == null) {
                Log.w("AbmAdActivity", "ABM Player is null.");
                return;
            }
            AudioManager audioManager = (AudioManager) AbmAdActivity.this.getSystemService("audio");
            if (audioManager == null) {
                Log.w("AbmAdActivity", "Failed to get AudioManager service.");
                return;
            }
            if (AbmAdActivity.this.D == 0 && audioManager.getStreamVolume(3) > 0) {
                AbmAdActivity.this.f16531a.onPlayerEvent("unmute", s1.a());
            }
            if (AbmAdActivity.this.D > 0 && audioManager.getStreamVolume(3) == 0) {
                AbmAdActivity.this.f16531a.onPlayerEvent("mute", s1.a());
            }
            AbmAdActivity.this.D = audioManager.getStreamVolume(3);
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
