package com.applovin.impl;

import android.R;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import androidx.core.net.MailTo;
import androidx.webkit.internal.AssetHelper;
import com.applovin.creative.MaxCreativeDebuggerActivity;
import com.applovin.creative.MaxCreativeDebuggerDisplayedAdActivity;
import com.applovin.impl.d;
import com.applovin.impl.f1;
import com.applovin.impl.sdk.utils.BundleUtils;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkUtils;
import com.unity3d.ads.core.domain.InitializeAndroidBoldSDK;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class z0 implements f1.a {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static WeakReference f7864m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final AtomicBoolean f7865n = new AtomicBoolean();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.applovin.impl.sdk.j f7866a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f7867b;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final y0 f7870e;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private f1 f7872g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private t6 f7873h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f7874i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f7875j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private long f7876k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f7877l;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List f7868c = new ArrayList(10);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Object f7869d = new Object();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private WeakReference f7871f = new WeakReference(null);

    class a extends com.applovin.impl.b {
        a() {
        }

        @Override // com.applovin.impl.b, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            if (activity instanceof MaxCreativeDebuggerActivity) {
                com.applovin.impl.sdk.n.g("AppLovinSdk", "Started Creative Debugger");
                if (!z0.this.h() || z0.f7864m.get() != activity) {
                    MaxCreativeDebuggerActivity maxCreativeDebuggerActivity = (MaxCreativeDebuggerActivity) activity;
                    WeakReference unused = z0.f7864m = new WeakReference(maxCreativeDebuggerActivity);
                    maxCreativeDebuggerActivity.a(z0.this.f7870e, z0.this.f7866a.e());
                }
                z0.f7865n.set(false);
            }
        }

        @Override // com.applovin.impl.b, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            if (activity instanceof MaxCreativeDebuggerActivity) {
                com.applovin.impl.sdk.n.g("AppLovinSdk", "Creative Debugger destroyed");
                WeakReference unused = z0.f7864m = null;
            }
        }
    }

    class b implements d.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f7879a;

        b(Object obj) {
            this.f7879a = obj;
        }

        @Override // com.applovin.impl.d.b
        public void a(MaxCreativeDebuggerDisplayedAdActivity maxCreativeDebuggerDisplayedAdActivity) {
            maxCreativeDebuggerDisplayedAdActivity.a(new j1(this.f7879a, z0.this.f7866a.D().b()), z0.this.f7866a);
            z0.f7865n.set(false);
        }
    }

    public z0(com.applovin.impl.sdk.j jVar) {
        this.f7866a = jVar;
        Context contextN = com.applovin.impl.sdk.j.n();
        this.f7867b = contextN;
        this.f7870e = new y0(contextN);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j() {
        this.f7874i = 0;
    }

    private void m() {
        this.f7866a.e().a(new a());
    }

    public void k() {
        f1 f1Var = this.f7872g;
        if (f1Var != null) {
            f1Var.b();
        }
    }

    public void l() {
        if (g()) {
            this.f7875j = ((Boolean) this.f7866a.a(l4.f5640g1)).booleanValue();
            if (this.f7872g == null) {
                this.f7872g = new f1(this.f7866a, this);
            }
            this.f7872g.a();
        }
    }

    public void n() {
        ArrayList arrayList;
        if (h() || !f7865n.compareAndSet(false, true)) {
            com.applovin.impl.sdk.n.h("AppLovinSdk", "Creative Debugger is already showing");
            return;
        }
        Object objA = this.f7866a.D().a();
        if (objA != null) {
            e(objA);
            return;
        }
        synchronized (this.f7869d) {
            arrayList = new ArrayList(this.f7868c);
        }
        this.f7870e.a(arrayList, this.f7866a);
        if (!this.f7877l) {
            m();
            this.f7877l = true;
        }
        com.applovin.impl.sdk.n.g("AppLovinSdk", "Starting Creative Debugger...");
        d.a(this.f7867b, MaxCreativeDebuggerActivity.class);
    }

    private void e(Object obj) {
        com.applovin.impl.sdk.n.g("AppLovinSdk", "Starting Creative Debugger for current fullscreen ad...");
        d.a(this.f7867b, MaxCreativeDebuggerDisplayedAdActivity.class, this.f7866a.e(), new b(obj));
    }

    private Drawable f() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(1);
        gradientDrawable.setColor(Color.rgb(5, 131, 170));
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setShape(1);
        gradientDrawable2.setColor(Color.rgb(2, 98, 127));
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{R.attr.state_pressed}, gradientDrawable2);
        stateListDrawable.addState(new int[0], gradientDrawable);
        return stateListDrawable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean h() {
        WeakReference weakReference = f7864m;
        return (weakReference == null || weakReference.get() == null) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i() {
        long seconds = TimeUnit.MILLISECONDS.toSeconds(SystemClock.elapsedRealtime() - this.f7876k);
        if (this.f7876k == 0 || seconds < 10) {
            return;
        }
        this.f7866a.A().a(y1.f7775d, "showingMediationDebuggerFromHoldingCreativeDebuggerButton");
        this.f7866a.Q0();
    }

    @Override // com.applovin.impl.f1.a
    public void b() {
        if (this.f7874i == 0) {
            this.f7873h = t6.a(TimeUnit.SECONDS.toMillis(3L), this.f7866a, new Runnable() { // from class: com.applovin.impl.jf
                @Override // java.lang.Runnable
                public final void run() {
                    this.f5507a.j();
                }
            });
        }
        int i10 = this.f7874i;
        if (i10 % 2 == 0) {
            this.f7874i = i10 + 1;
        }
    }

    public boolean g() {
        return ((Boolean) this.f7866a.a(l4.f5632f1)).booleanValue() && this.f7866a.g0().isCreativeDebuggerEnabled();
    }

    private boolean c(Object obj) {
        MaxAdFormat format;
        if (obj instanceof com.applovin.impl.sdk.ad.b) {
            format = ((com.applovin.impl.sdk.ad.b) obj).getAdZone().d();
        } else {
            format = obj instanceof q2 ? ((q2) obj).getFormat() : null;
        }
        return format != null && format.isFullscreenAd();
    }

    public void d(Object obj) {
        if (g() && obj != null) {
            if (!l3.a(obj) || c(obj)) {
                if (l3.b(obj) && c(obj)) {
                    return;
                }
                synchronized (this.f7869d) {
                    this.f7868c.add(0, new j1(obj, System.currentTimeMillis()));
                    if (this.f7868c.size() > 10) {
                        this.f7868c.remove(r6.size() - 1);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (g() && this.f7871f.get() == null && !h()) {
            Activity activityB = this.f7866a.e().b();
            if (activityB == null) {
                this.f7866a.I();
                if (com.applovin.impl.sdk.n.a()) {
                    this.f7866a.I().b("AppLovinSdk", "Failed to display Creative Debugger button");
                    return;
                }
                return;
            }
            View viewFindViewById = activityB.findViewById(R.id.content);
            if (viewFindViewById instanceof FrameLayout) {
                final FrameLayout frameLayout = (FrameLayout) viewFindViewById;
                final View viewA = a(frameLayout, activityB);
                frameLayout.addView(viewA);
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(150L);
                viewA.startAnimation(alphaAnimation);
                final ViewTreeObserver viewTreeObserver = viewFindViewById.getViewTreeObserver();
                final ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.applovin.impl.lf
                    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                    public final void onGlobalLayout() {
                        this.f5837a.a(viewA, frameLayout);
                    }
                };
                viewTreeObserver.addOnGlobalLayoutListener(onGlobalLayoutListener);
                AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() { // from class: com.applovin.impl.mf
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f6362a.a(viewA, frameLayout, viewTreeObserver, onGlobalLayoutListener);
                    }
                }, TimeUnit.SECONDS.toMillis(5L));
                this.f7871f = new WeakReference(viewA);
            }
        }
    }

    @Override // com.applovin.impl.f1.a
    public void a() {
        int i10 = this.f7874i;
        if (i10 % 2 == 1) {
            this.f7874i = i10 + 1;
        }
        if (this.f7874i / 2 == 2) {
            AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.nf
                @Override // java.lang.Runnable
                public final void run() {
                    this.f6438a.e();
                }
            });
            this.f7874i = 0;
            this.f7873h.a();
        }
    }

    private void b(View view, FrameLayout frameLayout) {
        if (this.f7875j) {
            view.setOnTouchListener(null);
            this.f7876k = 0L;
        }
        frameLayout.removeView(view);
        this.f7871f = new WeakReference(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(View view, FrameLayout frameLayout) {
        if (view.getParent() != null || this.f7871f.get() == null) {
            return;
        }
        frameLayout.addView(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(View view, FrameLayout frameLayout, ViewTreeObserver viewTreeObserver, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        if (this.f7876k > 0 && this.f7875j) {
            view.setVisibility(4);
        } else {
            b(view, frameLayout);
        }
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.removeOnGlobalLayoutListener(onGlobalLayoutListener);
        }
    }

    public String b(Object obj) {
        JSONObject jSONObjectA;
        if (obj instanceof com.applovin.impl.sdk.ad.b) {
            return ((com.applovin.impl.sdk.ad.b) obj).getOriginalFullResponse().toString();
        }
        if (!(obj instanceof q2)) {
            return null;
        }
        String strE = ((q2) obj).E();
        return (!l3.b(obj) || (jSONObjectA = new i(strE, this.f7866a).a()) == null) ? strE : jSONObjectA.toString();
    }

    private View a(final FrameLayout frameLayout, Activity activity) {
        View view;
        int iDpToPx = AppLovinSdkUtils.dpToPx(activity, 40);
        int i10 = iDpToPx / 10;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(iDpToPx, iDpToPx, 8388629);
        layoutParams.setMargins(i10, i10, i10, i10);
        try {
            ImageButton imageButton = new ImageButton(activity);
            imageButton.setImageDrawable(activity.getResources().getDrawable(com.applovin.sdk.R.drawable.applovin_ic_white_small));
            imageButton.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imageButton.setPadding(i10, i10, i10, i10 * 2);
            view = imageButton;
        } catch (Throwable unused) {
            Button button = new Button(activity);
            button.setText("ⓘ");
            button.setTextColor(-1);
            button.setAllCaps(false);
            button.setTextSize(2, 20.0f);
            button.setPadding(0, 0, 0, 0);
            view = button;
        }
        view.setLayoutParams(layoutParams);
        view.setBackground(f());
        if (this.f7875j) {
            view.setOnTouchListener(new View.OnTouchListener() { // from class: com.applovin.impl.hf
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view2, MotionEvent motionEvent) {
                    return this.f5356a.a(frameLayout, view2, motionEvent);
                }
            });
        } else {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.applovin.impl.if
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    this.f5410a.a(view2);
                }
            });
        }
        if (k0.d()) {
            view.setElevation(AppLovinSdkUtils.dpToPx(activity, 5));
        }
        return view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean a(FrameLayout frameLayout, View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.f7876k = SystemClock.elapsedRealtime();
            AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() { // from class: com.applovin.impl.kf
                @Override // java.lang.Runnable
                public final void run() {
                    this.f5568a.i();
                }
            }, TimeUnit.SECONDS.toMillis(10L));
        } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
            if (view.getVisibility() == 0) {
                this.f7876k = 0L;
                n();
            } else {
                b(view, frameLayout);
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        n();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [java.io.Serializable, java.lang.Object[]] */
    public void a(j1 j1Var, Context context, boolean z10) {
        Object objA = j1Var.a();
        String strA = a(j1Var);
        n2 n2Var = new n2();
        if (z10) {
            n2Var.b("Please describe the issue you had with this ad:\n\n\n\n");
        }
        n2Var.b(strA);
        String strB = this.f7866a.w().b(objA);
        if (strB != null) {
            n2Var.a("\nBid Response:\n");
            n2Var.a(strB);
        }
        String str = "AppLovin Ad Report";
        Intent intentCreateChooser = Intent.createChooser(new Intent("android.intent.action.SEND").setType(AssetHelper.DEFAULT_MIME_TYPE).putExtra("android.intent.extra.SUBJECT", objA instanceof com.applovin.impl.sdk.ad.b ? "AppLovin Ad Report" : "MAX Ad Report").putExtra("android.intent.extra.TEXT", n2Var.toString()).setPackage(null), "Share Ad Report");
        if (z10) {
            try {
                Intent intent = new Intent("android.intent.action.SENDTO", Uri.parse(MailTo.MAILTO_SCHEME));
                if (!(objA instanceof com.applovin.impl.sdk.ad.b)) {
                    str = "MAX Ad Report";
                }
                Intent intent2 = intent.putExtra("android.intent.extra.SUBJECT", str).putExtra("android.intent.extra.TEXT", n2Var.toString()).setPackage("com.google.android.gm");
                String str2 = this.f7866a.g0().getExtraParameters().get("creative_debugger_email_recipients");
                if (StringUtils.isValidString(str2)) {
                    intent2.putExtra("android.intent.extra.EMAIL", (Serializable) CollectionUtils.explode(str2).toArray());
                }
                context.startActivity(intent2);
                return;
            } catch (ActivityNotFoundException unused) {
                context.startActivity(intentCreateChooser);
                return;
            }
        }
        context.startActivity(intentCreateChooser);
    }

    public String a(j1 j1Var) {
        Object objA = j1Var.a();
        n2 n2Var = new n2();
        n2Var.b("Ad Info:\n");
        if (objA instanceof com.applovin.impl.sdk.ad.b) {
            com.applovin.impl.sdk.ad.b bVar = (com.applovin.impl.sdk.ad.b) objA;
            n2Var.a(InitializeAndroidBoldSDK.MSG_NETWORK, "APPLOVIN").a(bVar).b(bVar);
        } else if (objA instanceof q2) {
            n2Var.a((q2) objA);
        }
        n2Var.a(this.f7866a);
        n2Var.a("Epoch Timestamp (ms)", Long.valueOf(j1Var.b()));
        n2Var.a("\nDebug Info:\n").a("Platform", "fireos".equals(this.f7866a.y().x()) ? "Fire OS" : com.ironsource.v8.f15653d).a("AppLovin SDK Version", AppLovinSdk.VERSION).a("Plugin Version", this.f7866a.a(l4.f5761v3)).a("App Package Name", this.f7867b.getPackageName()).a("Device", String.format("%s %s (%s)", Build.BRAND, Build.MODEL, Build.DEVICE)).a("OS Version", Build.VERSION.RELEASE).a("AppLovin Random Token", this.f7866a.a0()).a("Ad Review Version", h.b()).a(a(objA)).a("User ID", this.f7866a.p0().c() != null ? this.f7866a.p0().c() : "None").a("MD", this.f7866a.a(l4.f5742t));
        return n2Var.toString();
    }

    private Bundle a(Object obj) {
        this.f7866a.I();
        if (com.applovin.impl.sdk.n.a()) {
            this.f7866a.I().a("CreativeDebuggerService", "Retrieving Ad Review info for ad: " + obj);
        }
        String strA = z6.a(obj);
        Bundle bundleA = this.f7866a.j().a(strA);
        this.f7866a.I();
        if (com.applovin.impl.sdk.n.a()) {
            this.f7866a.I().a("CreativeDebuggerService", "Serve id: " + strA);
        }
        this.f7866a.I();
        if (com.applovin.impl.sdk.n.a()) {
            this.f7866a.I().a("CreativeDebuggerService", "Public data: " + bundleA);
        }
        if (bundleA == null) {
            return null;
        }
        for (String str : bundleA.keySet()) {
            Object obj2 = bundleA.get(str);
            bundleA.remove(str);
            BundleUtils.put(StringUtils.toHumanReadableString(str), obj2, bundleA);
        }
        return bundleA;
    }
}
