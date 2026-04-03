package com.king.amp.sa;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.app.AppCompatActivity;
import androidx.browser.customtabs.CustomTabsCallback;
import androidx.browser.customtabs.CustomTabsClient;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.browser.customtabs.CustomTabsServiceConnection;
import androidx.browser.customtabs.CustomTabsSession;

/* JADX INFO: loaded from: classes4.dex */
public class BrowserComponentActivity extends AppCompatActivity {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static String f16653i = "BrowserComponentActivity";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private k6.g f16654a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f16655b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private CustomTabsSession f16656c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private CustomTabsServiceConnection f16657d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private BrowserComponent f16658e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f16659f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @VisibleForTesting
    protected CustomTabsCallback f16660g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @VisibleForTesting
    protected b f16661h;

    class a extends CustomTabsServiceConnection {

        /* JADX INFO: renamed from: com.king.amp.sa.BrowserComponentActivity$a$a, reason: collision with other inner class name */
        class C0276a extends CustomTabsCallback {
            C0276a() {
            }

            @Override // androidx.browser.customtabs.CustomTabsCallback
            public void onNavigationEvent(int i10, Bundle bundle) {
                if (i10 == 3) {
                    Log.i(BrowserComponentActivity.f16653i, "Navigation failed");
                    if (BrowserComponentActivity.this.f16658e != null) {
                        BrowserComponentActivity.this.f16658e.browserError("Navigation failed");
                        return;
                    }
                    return;
                }
                if (i10 != 4) {
                    return;
                }
                Log.i(BrowserComponentActivity.f16653i, "Navigation aborted");
                if (BrowserComponentActivity.this.f16658e != null) {
                    BrowserComponentActivity.this.f16658e.browserError("Navigation aborted");
                }
            }
        }

        a() {
        }

        @Override // androidx.browser.customtabs.CustomTabsServiceConnection
        public void onCustomTabsServiceConnected(ComponentName componentName, CustomTabsClient customTabsClient) {
            BrowserComponentActivity.this.f16660g = new C0276a();
            BrowserComponentActivity browserComponentActivity = BrowserComponentActivity.this;
            browserComponentActivity.f16656c = customTabsClient.newSession(browserComponentActivity.f16660g);
            BrowserComponentActivity.this.w();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            BrowserComponentActivity.this.f16656c = null;
        }
    }

    protected static class b {
        protected b() {
        }

        protected void a(CustomTabsIntent customTabsIntent, Activity activity, String str) {
            customTabsIntent.launchUrl(activity, Uri.parse(str));
        }
    }

    private void v() {
        Log.i(f16653i, "Initialize tabs");
        a aVar = new a();
        this.f16657d = aVar;
        CustomTabsClient.bindCustomTabsService(this, "com.android.chrome", aVar);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        k6.g gVarC = k6.g.c(getLayoutInflater());
        this.f16654a = gVarC;
        setContentView(gVarC.getRoot());
        Log.i(f16653i, "Create");
        this.f16655b = false;
        BrowserComponent browserComponent = BrowserComponent.getInstance();
        this.f16658e = browserComponent;
        if (browserComponent == null) {
            Log.e(f16653i, "Browser Component Activity error: missing required BrowserComponent");
            finish();
            return;
        }
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            this.f16658e.browserError("No Url provided in intent");
            return;
        }
        this.f16659f = extras.getString("url");
        this.f16661h = new b();
        v();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        Log.i(f16653i, "Destroy");
        this.f16658e = null;
        this.f16657d = null;
        this.f16656c = null;
        super.onDestroy();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        Log.i(f16653i, "Pause");
        super.onPause();
        if (this.f16655b) {
            return;
        }
        BrowserComponent browserComponent = this.f16658e;
        if (browserComponent != null) {
            browserComponent.browserAppeared();
        }
        this.f16655b = true;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        if (this.f16655b) {
            Log.i(f16653i, "Dismiss in resume");
            BrowserComponent browserComponent = this.f16658e;
            if (browserComponent != null) {
                browserComponent.browserDismissed();
            }
            finish();
        }
    }

    protected CustomTabsIntent u() {
        CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder(this.f16656c);
        builder.setShowTitle(true);
        return builder.build();
    }

    protected void w() {
        Log.i(f16653i, "open URL: " + this.f16659f);
        ResolveInfo resolveInfoY = y();
        if (resolveInfoY == null) {
            Log.e(f16653i, "No default browser found");
            return;
        }
        String str = resolveInfoY.activityInfo.packageName;
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(this.f16659f));
        ComponentName componentNameX = x(intent);
        if (componentNameX != null) {
            String packageName = componentNameX.getPackageName();
            if (!TextUtils.equals(str, packageName)) {
                Log.d(f16653i, "Let's launch app for url, " + packageName);
                startActivity(intent);
                return;
            }
        }
        Log.d(f16653i, "Let's open url in browser component");
        this.f16661h.a(u(), this, this.f16659f);
    }

    @Nullable
    @VisibleForTesting
    protected ComponentName x(Intent intent) {
        PackageManager packageManager = getPackageManager();
        if (packageManager == null) {
            return null;
        }
        return intent.resolveActivity(packageManager);
    }

    @Nullable
    @VisibleForTesting
    protected ResolveInfo y() {
        PackageManager packageManager = getPackageManager();
        if (packageManager == null) {
            return null;
        }
        return packageManager.resolveActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://")), 65536);
    }
}
