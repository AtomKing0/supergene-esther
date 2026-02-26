package com.ironsource;

import android.app.Activity;
import android.os.Handler;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.IronSourceBannerLayout;
import com.ironsource.mediationsdk.testSuite.TestSuiteActivity;
import com.ironsource.ns;
import java.lang.ref.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class ct implements ns.c, ns.d, ns.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final WeakReference<TestSuiteActivity> f11715a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final Handler f11716b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    private RelativeLayout f11717c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    private IronSourceBannerLayout f11718d;

    public ct(@NotNull TestSuiteActivity activity, @NotNull Handler handler) {
        kotlin.jvm.internal.t.i(activity, "activity");
        kotlin.jvm.internal.t.i(handler, "handler");
        this.f11715a = new WeakReference<>(activity);
        this.f11716b = handler;
    }

    private final RelativeLayout a(TestSuiteActivity testSuiteActivity) {
        RelativeLayout relativeLayout = new RelativeLayout(testSuiteActivity);
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        return relativeLayout;
    }

    private final TestSuiteActivity f() {
        return this.f11715a.get();
    }

    @Override // com.ironsource.ns.d
    public void d() {
        zs.f16492a.b((Activity) this.f11715a.get());
    }

    @Override // com.ironsource.ns.c
    public boolean e() {
        return zs.f16492a.e();
    }

    private final FrameLayout.LayoutParams b(double d10) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = (int) (((double) zs.f16492a.a()) * d10);
        return layoutParams;
    }

    @Override // com.ironsource.ns.b
    public void a(double d10) {
        if (this.f11717c == null) {
            IronSourceBannerLayout ironSourceBannerLayout = this.f11718d;
            if (ironSourceBannerLayout != null) {
                ironSourceBannerLayout.setLayoutParams(b(d10));
            }
            final TestSuiteActivity testSuiteActivityF = f();
            if (testSuiteActivityF != null) {
                this.f11717c = a(testSuiteActivityF);
                this.f11716b.post(new Runnable() { // from class: com.ironsource.yv
                    @Override // java.lang.Runnable
                    public final void run() {
                        ct.a(this.f16347a, testSuiteActivityF);
                    }
                });
            }
        }
    }

    @Override // com.ironsource.ns.c
    public void c() {
        zs.f16492a.a((Activity) this.f11715a.get());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(ct this$0) {
        RelativeLayout container;
        kotlin.jvm.internal.t.i(this$0, "this$0");
        RelativeLayout relativeLayout = this$0.f11717c;
        if (relativeLayout != null) {
            relativeLayout.removeAllViews();
        }
        TestSuiteActivity testSuiteActivityF = this$0.f();
        if (testSuiteActivityF != null && (container = testSuiteActivityF.getContainer()) != null) {
            container.removeView(this$0.f11717c);
        }
        this$0.f11717c = null;
    }

    @Override // com.ironsource.ns.b
    public void b() {
        IronSourceBannerLayout ironSourceBannerLayout = this.f11718d;
        if (ironSourceBannerLayout != null) {
            zs.f16492a.a(ironSourceBannerLayout);
        }
        this.f11716b.post(new Runnable() { // from class: com.ironsource.zv
            @Override // java.lang.Runnable
            public final void run() {
                ct.a(this.f16494a);
            }
        });
        this.f11718d = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(ct this$0, TestSuiteActivity testSuiteActivity) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        RelativeLayout relativeLayout = this$0.f11717c;
        if (relativeLayout != null) {
            relativeLayout.addView(this$0.f11718d);
        }
        testSuiteActivity.getContainer().addView(this$0.f11717c);
    }

    @Override // com.ironsource.ns.d
    public void b(@NotNull ts loadAdConfig) {
        kotlin.jvm.internal.t.i(loadAdConfig, "loadAdConfig");
        zs zsVar = zs.f16492a;
        zsVar.a(IronSource.AD_UNIT.REWARDED_VIDEO, loadAdConfig);
        zsVar.h();
    }

    @Override // com.ironsource.ns.c
    public void a(@NotNull ts loadAdConfig) {
        kotlin.jvm.internal.t.i(loadAdConfig, "loadAdConfig");
        zs zsVar = zs.f16492a;
        zsVar.a(IronSource.AD_UNIT.INTERSTITIAL, loadAdConfig);
        zsVar.g();
    }

    @Override // com.ironsource.ns.b
    public void a(@NotNull ts loadAdConfig, @NotNull String description, int i10, int i11) {
        kotlin.jvm.internal.t.i(loadAdConfig, "loadAdConfig");
        kotlin.jvm.internal.t.i(description, "description");
        b();
        zs zsVar = zs.f16492a;
        zsVar.a(IronSource.AD_UNIT.BANNER, loadAdConfig);
        TestSuiteActivity testSuiteActivityF = f();
        if (testSuiteActivityF != null) {
            IronSourceBannerLayout ironSourceBannerLayoutA = zsVar.a(testSuiteActivityF, zsVar.a(description, i10, i11));
            this.f11718d = ironSourceBannerLayoutA;
            zsVar.b(ironSourceBannerLayoutA);
        }
    }

    @Override // com.ironsource.ns.d
    public boolean a() {
        return zs.f16492a.f();
    }
}
