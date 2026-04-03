package com.applovin.impl.adview;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.RelativeLayout;
import com.applovin.impl.adview.e;
import com.applovin.impl.g1;
import com.applovin.impl.l4;
import com.applovin.sdk.AppLovinSdkUtils;

/* JADX INFO: loaded from: classes2.dex */
class f extends Dialog implements g1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Activity f4831a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.applovin.impl.sdk.j f4832b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.applovin.impl.sdk.n f4833c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final b f4834d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final com.applovin.impl.sdk.ad.a f4835e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private RelativeLayout f4836f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private e f4837g;

    f(com.applovin.impl.sdk.ad.a aVar, b bVar, Activity activity, com.applovin.impl.sdk.j jVar) {
        super(activity, R.style.Theme.Translucent.NoTitleBar);
        if (aVar == null) {
            throw new IllegalArgumentException("No ad specified");
        }
        if (bVar == null) {
            throw new IllegalArgumentException("No main view specified");
        }
        if (jVar == null) {
            throw new IllegalArgumentException("No sdk specified");
        }
        if (activity == null) {
            throw new IllegalArgumentException("No activity specified");
        }
        this.f4832b = jVar;
        this.f4833c = jVar.I();
        this.f4831a = activity;
        this.f4834d = bVar;
        this.f4835e = aVar;
        requestWindowFeature(1);
        setCancelable(false);
    }

    private void g() {
        this.f4831a.runOnUiThread(new Runnable() { // from class: com.applovin.impl.adview.g0
            @Override // java.lang.Runnable
            public final void run() {
                this.f4842a.f();
            }
        });
    }

    @Override // android.app.Dialog, android.content.DialogInterface, com.applovin.impl.g1
    public void dismiss() {
        this.f4831a.runOnUiThread(new Runnable() { // from class: com.applovin.impl.adview.h0
            @Override // java.lang.Runnable
            public final void run() {
                this.f4843a.e();
            }
        });
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        this.f4834d.a("javascript:al_onBackPressed();");
        dismiss();
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        d();
    }

    @Override // android.app.Dialog
    protected void onStart() {
        super.onStart();
        try {
            Window window = getWindow();
            if (window != null) {
                window.setFlags(this.f4831a.getWindow().getAttributes().flags, this.f4831a.getWindow().getAttributes().flags);
                window.addFlags(16777216);
            } else if (com.applovin.impl.sdk.n.a()) {
                this.f4833c.b("ExpandedAdDialog", "Unable to turn on hardware acceleration - window is null");
            }
        } catch (Throwable th) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f4833c.a("ExpandedAdDialog", "Setting window flags failed.", th);
            }
        }
    }

    private void a() {
        this.f4834d.a("javascript:al_onCloseTapped();");
        dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        if (this.f4837g.isClickable()) {
            this.f4837g.performClick();
        }
    }

    private void d() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13);
        this.f4834d.setLayoutParams(layoutParams);
        RelativeLayout relativeLayout = new RelativeLayout(this.f4831a);
        this.f4836f = relativeLayout;
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.f4836f.setBackgroundColor(-1157627904);
        this.f4836f.addView(this.f4834d);
        if (!this.f4835e.k1()) {
            a(this.f4835e.e1());
            g();
        }
        setContentView(this.f4836f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e() {
        this.f4836f.removeView(this.f4834d);
        super.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f() {
        try {
            if (this.f4837g == null) {
                a();
            }
            this.f4837g.setVisibility(0);
            this.f4837g.bringToFront();
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setDuration(300L);
            alphaAnimation.setAnimationListener(new a());
            this.f4837g.startAnimation(alphaAnimation);
        } catch (Throwable th) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f4833c.a("ExpandedAdDialog", "Unable to fade in close button", th);
            }
            a();
        }
    }

    public b c() {
        return this.f4834d;
    }

    private void a(e.a aVar) {
        if (this.f4837g != null) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f4833c.k("ExpandedAdDialog", "Attempting to create duplicate close button");
                return;
            }
            return;
        }
        e eVarA = e.a(aVar, this.f4831a);
        this.f4837g = eVarA;
        eVarA.setVisibility(8);
        this.f4837g.setOnClickListener(new View.OnClickListener() { // from class: com.applovin.impl.adview.e0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f4830a.a(view);
            }
        });
        this.f4837g.setClickable(false);
        int iA = a(((Integer) this.f4832b.a(l4.f5752u1)).intValue());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(iA, iA);
        layoutParams.addRule(10);
        com.applovin.impl.sdk.j jVar = this.f4832b;
        l4 l4Var = l4.f5773x1;
        layoutParams.addRule(((Boolean) jVar.a(l4Var)).booleanValue() ? 9 : 11);
        this.f4837g.a(iA);
        int iA2 = a(((Integer) this.f4832b.a(l4.f5766w1)).intValue());
        int iA3 = a(((Integer) this.f4832b.a(l4.f5759v1)).intValue());
        layoutParams.setMargins(iA3, iA2, iA3, 0);
        this.f4836f.addView(this.f4837g, layoutParams);
        this.f4837g.bringToFront();
        int iA4 = a(((Integer) this.f4832b.a(l4.f5780y1)).intValue());
        View view = new View(this.f4831a);
        view.setBackgroundColor(0);
        int i10 = iA + iA4;
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(i10, i10);
        layoutParams2.addRule(10);
        layoutParams2.addRule(((Boolean) this.f4832b.a(l4Var)).booleanValue() ? 9 : 11);
        layoutParams2.setMargins(iA3 - a(5), iA2 - a(5), iA3 - a(5), 0);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.applovin.impl.adview.f0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f4839a.b(view2);
            }
        });
        this.f4836f.addView(view, layoutParams2);
        view.bringToFront();
    }

    public com.applovin.impl.sdk.ad.a b() {
        return this.f4835e;
    }

    class a implements Animation.AnimationListener {
        a() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            f.this.f4837g.setClickable(true);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        a();
    }

    private int a(int i10) {
        return AppLovinSdkUtils.dpToPx(this.f4831a, i10);
    }
}
