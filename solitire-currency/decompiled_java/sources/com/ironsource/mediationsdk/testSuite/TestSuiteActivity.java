package com.ironsource.mediationsdk.testSuite;

import android.app.Activity;
import android.os.Bundle;
import android.widget.RelativeLayout;
import com.ironsource.at;
import com.ironsource.ft;
import com.ironsource.qg;
import com.ironsource.qs;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class TestSuiteActivity extends Activity implements qg {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private RelativeLayout f13902a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ft f13903b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private at f13904c;

    private final String a() {
        Bundle extras;
        if (getIntent() == null || getIntent().getExtras() == null || (extras = getIntent().getExtras()) == null) {
            return null;
        }
        return extras.getString("controllerUrl");
    }

    private final JSONObject b() {
        if (getIntent() != null && getIntent().getExtras() != null) {
            Bundle extras = getIntent().getExtras();
            String string = extras != null ? extras.getString(qs.f14582a) : null;
            if (!(string == null || string.length() == 0)) {
                return new JSONObject(string);
            }
        }
        return new JSONObject();
    }

    @NotNull
    public final RelativeLayout getContainer() {
        RelativeLayout relativeLayout = this.f13902a;
        if (relativeLayout != null) {
            return relativeLayout;
        }
        t.A("mContainer");
        return null;
    }

    @Override // com.ironsource.qg
    public void onClosed() {
        runOnUiThread(new Runnable() { // from class: com.ironsource.mediationsdk.testSuite.b
            @Override // java.lang.Runnable
            public final void run() {
                TestSuiteActivity.a(this.f13906a);
            }
        });
    }

    @Override // android.app.Activity
    protected void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        RelativeLayout relativeLayout = new RelativeLayout(this);
        this.f13902a = relativeLayout;
        setContentView(relativeLayout, c());
        ft ftVar = new ft(this, this, b(), a());
        this.f13903b = ftVar;
        at atVar = new at(ftVar);
        this.f13904c = atVar;
        atVar.d();
        RelativeLayout relativeLayout2 = this.f13902a;
        ft ftVar2 = null;
        if (relativeLayout2 == null) {
            t.A("mContainer");
            relativeLayout2 = null;
        }
        ft ftVar3 = this.f13903b;
        if (ftVar3 == null) {
            t.A("mWebViewWrapper");
        } else {
            ftVar2 = ftVar3;
        }
        relativeLayout2.addView(ftVar2.d(), c());
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        at atVar = this.f13904c;
        ft ftVar = null;
        if (atVar == null) {
            t.A("mNativeBridge");
            atVar = null;
        }
        atVar.a();
        RelativeLayout relativeLayout = this.f13902a;
        if (relativeLayout == null) {
            t.A("mContainer");
            relativeLayout = null;
        }
        relativeLayout.removeAllViews();
        ft ftVar2 = this.f13903b;
        if (ftVar2 == null) {
            t.A("mWebViewWrapper");
        } else {
            ftVar = ftVar2;
        }
        ftVar.a();
        super.onDestroy();
    }

    @Override // com.ironsource.qg
    public void onUIReady() {
        runOnUiThread(new Runnable() { // from class: com.ironsource.mediationsdk.testSuite.a
            @Override // java.lang.Runnable
            public final void run() {
                TestSuiteActivity.b(this.f13905a);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(TestSuiteActivity this$0) {
        t.i(this$0, "this$0");
        this$0.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(TestSuiteActivity this$0) {
        t.i(this$0, "this$0");
        ft ftVar = this$0.f13903b;
        ft ftVar2 = null;
        if (ftVar == null) {
            t.A("mWebViewWrapper");
            ftVar = null;
        }
        if (ftVar.c().getParent() == null) {
            RelativeLayout relativeLayout = this$0.f13902a;
            if (relativeLayout == null) {
                t.A("mContainer");
                relativeLayout = null;
            }
            ft ftVar3 = this$0.f13903b;
            if (ftVar3 == null) {
                t.A("mWebViewWrapper");
                ftVar3 = null;
            }
            relativeLayout.removeView(ftVar3.d());
            RelativeLayout relativeLayout2 = this$0.f13902a;
            if (relativeLayout2 == null) {
                t.A("mContainer");
                relativeLayout2 = null;
            }
            ft ftVar4 = this$0.f13903b;
            if (ftVar4 == null) {
                t.A("mWebViewWrapper");
                ftVar4 = null;
            }
            relativeLayout2.addView(ftVar4.c(), this$0.c());
            ft ftVar5 = this$0.f13903b;
            if (ftVar5 == null) {
                t.A("mWebViewWrapper");
            } else {
                ftVar2 = ftVar5;
            }
            ftVar2.b();
        }
    }

    private final RelativeLayout.LayoutParams c() {
        return new RelativeLayout.LayoutParams(-1, -1);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
    }
}
