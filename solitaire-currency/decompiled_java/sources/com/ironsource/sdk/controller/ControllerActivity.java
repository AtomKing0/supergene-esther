package com.ironsource.sdk.controller;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import com.ironsource.ce;
import com.ironsource.cu;
import com.ironsource.el;
import com.ironsource.i9;
import com.ironsource.kn;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.n5;
import com.ironsource.nb;
import com.ironsource.pf;
import com.ironsource.qi;
import com.ironsource.sdk.controller.v;
import com.ironsource.sdk.utils.Logger;
import com.ironsource.sdk.utils.SDKUtils;
import com.ironsource.sf;
import com.ironsource.t2;
import com.ironsource.v8;
import com.ironsource.vp;
import com.ironsource.xf;
import com.ironsource.yu;

/* JADX INFO: loaded from: classes4.dex */
public class ControllerActivity extends Activity implements kn, cu {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final String f14823n = "ControllerActivity";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final int f14824o = 1;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static String f14825p = "removeWebViewContainerView | mContainer is null";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static String f14826q = "removeWebViewContainerView | view is null";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f14827a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private v f14828b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private RelativeLayout f14829c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private FrameLayout f14830d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private ce f14831e;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f14833g;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private t2 f14837k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f14838l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f14839m;
    public int currentRequestedRotation = -1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f14832f = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Handler f14834h = new Handler();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Runnable f14835i = new a();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    final RelativeLayout.LayoutParams f14836j = new RelativeLayout.LayoutParams(-1, -1);

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ControllerActivity.this.getWindow().getDecorView().setSystemUiVisibility(SDKUtils.getActivityUIFlags(ControllerActivity.this.f14832f));
        }
    }

    class b implements View.OnSystemUiVisibilityChangeListener {
        b() {
        }

        @Override // android.view.View.OnSystemUiVisibilityChangeListener
        public void onSystemUiVisibilityChange(int i10) {
            if ((i10 & InputDeviceCompat.SOURCE_TOUCHSCREEN) == 0) {
                ControllerActivity.this.f14834h.removeCallbacks(ControllerActivity.this.f14835i);
                ControllerActivity.this.f14834h.postDelayed(ControllerActivity.this.f14835i, 500L);
            }
        }
    }

    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ControllerActivity.this.getWindow().addFlags(128);
        }
    }

    class d implements Runnable {
        d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ControllerActivity.this.getWindow().clearFlags(128);
        }
    }

    private View a(ViewGroup viewGroup) {
        return d() ? viewGroup.findViewById(1) : pf.a().a(this.f14827a).getPresentingView();
    }

    private boolean d() {
        return this.f14827a == null;
    }

    private void e() {
        runOnUiThread(new c());
    }

    private void f() {
        ViewGroup viewGroup;
        try {
            if (this.f14829c == null) {
                throw new Exception(f14825p);
            }
            ViewGroup viewGroup2 = (ViewGroup) this.f14830d.getParent();
            View viewA = a(viewGroup2);
            if (viewA == null) {
                throw new Exception(f14826q);
            }
            if (isFinishing() && (viewGroup = (ViewGroup) viewA.getParent()) != null) {
                viewGroup.removeView(viewA);
            }
            viewGroup2.removeView(this.f14830d);
        } catch (Exception e10) {
            i9.d().a(e10);
            xf.a(vp.f15951s, new sf().a(nb.A, e10.getMessage()).a());
            Logger.i(f14823n, "removeWebViewContainerView fail " + e10.getMessage());
        }
    }

    private void g() {
        String str;
        String str2;
        int I = this.f14831e.I(this);
        String str3 = f14823n;
        Logger.i(str3, "setInitiateLandscapeOrientation");
        if (I != 0) {
            if (I == 2) {
                str2 = "ROTATION_180";
            } else if (I == 3) {
                str2 = "ROTATION_270 Right Landscape";
            } else {
                if (I != 1) {
                    Logger.i(str3, "No Rotation");
                    return;
                }
                str = "ROTATION_90 Left Landscape";
            }
            Logger.i(str3, str2);
            setRequestedOrientation(8);
            return;
        }
        str = "ROTATION_0";
        Logger.i(str3, str);
        setRequestedOrientation(0);
    }

    @SuppressLint({"SourceLockedOrientationActivity"})
    private void h() {
        String str;
        int I = this.f14831e.I(this);
        String str2 = f14823n;
        Logger.i(str2, "setInitiatePortraitOrientation");
        if (I == 0) {
            str = "ROTATION_0";
        } else if (I == 2) {
            Logger.i(str2, "ROTATION_180");
            setRequestedOrientation(9);
            return;
        } else if (I == 1) {
            str = "ROTATION_270 Right Landscape";
        } else {
            if (I != 3) {
                Logger.i(str2, "No Rotation");
                return;
            }
            str = "ROTATION_90 Left Landscape";
        }
        Logger.i(str2, str);
        setRequestedOrientation(1);
    }

    @Override // com.ironsource.kn
    public boolean onBackButtonPressed() {
        onBackPressed();
        return true;
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        Logger.i(f14823n, "onBackPressed");
        if (n5.a().a(this)) {
            return;
        }
        super.onBackPressed();
    }

    @Override // com.ironsource.kn
    public void onCloseRequested() {
        finish();
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f14831e = el.N().f();
        try {
            new com.ironsource.m(this).a();
            new com.ironsource.l(this).a();
            v vVar = (v) qi.a((Context) this).a().j();
            this.f14828b = vVar;
            vVar.s().setId(1);
            this.f14828b.a((kn) this);
            this.f14828b.a((cu) this);
            Intent intent = getIntent();
            this.f14833g = intent.getStringExtra(v8.h.f15803m);
            this.f14832f = intent.getBooleanExtra(v8.h.f15821v, false);
            this.f14827a = intent.getStringExtra("adViewId");
            this.f14838l = false;
            this.f14839m = intent.getBooleanExtra(v8.h.f15830z0, false);
            if (this.f14832f) {
                getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(new b());
                runOnUiThread(this.f14835i);
            }
            RelativeLayout relativeLayout = new RelativeLayout(this);
            this.f14829c = relativeLayout;
            setContentView(relativeLayout, this.f14836j);
            this.f14830d = a(this.f14827a);
            if (this.f14829c.findViewById(1) == null && this.f14830d.getParent() != null) {
                finish();
            }
            c();
            this.f14829c.addView(this.f14830d, this.f14836j);
        } catch (Exception e10) {
            i9.d().a(e10);
            IronLog.INTERNAL.error(e10.toString());
            finish();
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        String str = f14823n;
        Logger.i(str, "onDestroy");
        f();
        if (this.f14838l) {
            return;
        }
        Logger.i(str, "onDestroy | destroyedFromBackground");
        b();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i10, KeyEvent keyEvent) {
        if (i10 == 4 && this.f14828b.y()) {
            this.f14828b.x();
            return true;
        }
        if (this.f14832f && (i10 == 25 || i10 == 24)) {
            this.f14834h.removeCallbacks(this.f14835i);
            this.f14834h.postDelayed(this.f14835i, 500L);
        }
        return super.onKeyDown(i10, keyEvent);
    }

    @Override // com.ironsource.kn
    public void onOrientationChanged(String str, int i10) {
        a(str, i10);
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        Logger.i(f14823n, "onPause, isFinishing=" + isFinishing());
        t.a(this);
        v vVar = this.f14828b;
        if (vVar != null) {
            vVar.a((Context) this);
            if (!this.f14839m) {
                this.f14828b.B();
            }
            this.f14828b.a(false, "main");
            this.f14828b.g(this.f14833g, v8.h.f15818t0);
        }
        if (isFinishing()) {
            this.f14838l = true;
            b();
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        Logger.i(f14823n, v8.h.f15820u0);
        v vVar = this.f14828b;
        if (vVar != null) {
            vVar.b(this);
            if (!this.f14839m) {
                this.f14828b.F();
            }
            this.f14828b.a(true, "main");
            this.f14828b.g(this.f14833g, v8.h.f15820u0);
        }
        t.b(this);
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        Logger.i(f14823n, "onStart");
        v vVar = this.f14828b;
        if (vVar != null) {
            vVar.g(this.f14833g, "onStart");
        }
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
        Logger.i(f14823n, "onStop");
        v vVar = this.f14828b;
        if (vVar != null) {
            vVar.g(this.f14833g, "onStop");
        }
    }

    @Override // android.app.Activity
    protected void onUserLeaveHint() {
        super.onUserLeaveHint();
        Logger.i(f14823n, "onUserLeaveHint");
        v vVar = this.f14828b;
        if (vVar != null) {
            vVar.g(this.f14833g, "onUserLeaveHint");
        }
    }

    @Override // com.ironsource.cu
    public void onVideoEnded() {
        toggleKeepScreen(false);
    }

    @Override // com.ironsource.cu
    public void onVideoPaused() {
        toggleKeepScreen(false);
    }

    @Override // com.ironsource.cu
    public void onVideoResumed() {
        toggleKeepScreen(true);
    }

    @Override // com.ironsource.cu
    public void onVideoStarted() {
        toggleKeepScreen(true);
    }

    @Override // com.ironsource.cu
    public void onVideoStopped() {
        toggleKeepScreen(false);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z10) {
        super.onWindowFocusChanged(z10);
        if (this.f14832f && z10) {
            runOnUiThread(this.f14835i);
        }
    }

    @Override // android.app.Activity
    public void setRequestedOrientation(int i10) {
        if (this.currentRequestedRotation != i10) {
            Logger.i(f14823n, "Rotation: Req = " + i10 + " Curr = " + this.currentRequestedRotation);
            this.currentRequestedRotation = i10;
            super.setRequestedOrientation(i10);
        }
    }

    public void toggleKeepScreen(boolean z10) {
        if (z10) {
            e();
        } else {
            a();
        }
    }

    private FrameLayout a(String str) {
        return !b(str) ? this.f14828b.s() : yu.a(getApplicationContext(), pf.a().a(str).getPresentingView());
    }

    private void b() {
        String str = f14823n;
        Logger.i(str, "clearWebviewController");
        v vVar = this.f14828b;
        if (vVar == null) {
            Logger.i(str, "clearWebviewController, null");
            return;
        }
        vVar.a(v.u.Gone);
        this.f14828b.C();
        this.f14828b.D();
        this.f14828b.g(this.f14833g, "onDestroy");
    }

    private void c() {
        Intent intent = getIntent();
        a(intent.getStringExtra(v8.h.A), intent.getIntExtra(v8.h.B, 0));
    }

    private void a() {
        runOnUiThread(new d());
    }

    private boolean b(String str) {
        return (TextUtils.isEmpty(str) || str.equals(Integer.toString(1))) ? false : true;
    }

    @SuppressLint({"SourceLockedOrientationActivity"})
    private void a(String str, int i10) {
        int i11;
        if (str != null) {
            if (v8.h.C.equalsIgnoreCase(str)) {
                g();
                return;
            }
            if (v8.h.D.equalsIgnoreCase(str)) {
                h();
                return;
            }
            if ("device".equalsIgnoreCase(str)) {
                if (!this.f14831e.B(this)) {
                    return;
                } else {
                    i11 = 1;
                }
            } else if (getRequestedOrientation() != -1) {
                return;
            } else {
                i11 = 4;
            }
            setRequestedOrientation(i11);
        }
    }
}
