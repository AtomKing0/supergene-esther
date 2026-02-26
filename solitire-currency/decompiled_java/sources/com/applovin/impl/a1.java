package com.applovin.impl;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.browser.customtabs.CustomTabColorSchemeParams;
import androidx.browser.customtabs.CustomTabsCallback;
import androidx.browser.customtabs.CustomTabsClient;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.browser.customtabs.CustomTabsService;
import androidx.browser.customtabs.CustomTabsServiceConnection;
import androidx.browser.customtabs.CustomTabsSession;
import com.applovin.impl.sdk.AppLovinBroadcastManager;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.sdk.R;
import com.ironsource.v8;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class a1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.applovin.impl.sdk.j f4677a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private CustomTabsClient f4678b;

    class a extends CustomTabsServiceConnection {
        a() {
        }

        @Override // androidx.browser.customtabs.CustomTabsServiceConnection
        public void onCustomTabsServiceConnected(ComponentName componentName, CustomTabsClient customTabsClient) {
            a1.this.f4677a.I();
            if (com.applovin.impl.sdk.n.a()) {
                a1.this.f4677a.I().a("CustomTabsManager", "Connection successful: " + componentName);
            }
            a1.this.f4678b = customTabsClient;
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            a1.this.f4677a.I();
            if (com.applovin.impl.sdk.n.a()) {
                a1.this.f4677a.I().a("CustomTabsManager", "Service disconnected: " + componentName);
            }
            a1.this.f4678b = null;
        }
    }

    private class b extends CustomTabsCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final WeakReference f4680a;

        public b(com.applovin.impl.adview.a aVar) {
            this.f4680a = new WeakReference(aVar);
        }

        @Override // androidx.browser.customtabs.CustomTabsCallback
        public void onNavigationEvent(int i10, Bundle bundle) {
            com.applovin.impl.adview.a aVar = (com.applovin.impl.adview.a) this.f4680a.get();
            if (aVar == null) {
                a1.this.f4677a.I();
                if (com.applovin.impl.sdk.n.a()) {
                    a1.this.f4677a.I().b("CustomTabsManager", "Unable to track navigation event (" + i10 + "). Controller is null.");
                }
                return;
            }
            com.applovin.impl.sdk.ad.b bVarG = aVar.g();
            if (bVarG == null) {
                a1.this.f4677a.I();
                if (com.applovin.impl.sdk.n.a()) {
                    a1.this.f4677a.I().b("CustomTabsManager", "Unable to track navigation event (" + i10 + "). No ad specified.");
                    return;
                }
                return;
            }
            switch (i10) {
                case 1:
                    if (bVarG.P0()) {
                        a1.this.f4677a.k().trackCustomTabsNavigationStarted(bVarG);
                    }
                    break;
                case 2:
                    if (bVarG.P0()) {
                        a1.this.f4677a.k().trackCustomTabsNavigationFinished(bVarG);
                    }
                    break;
                case 3:
                    if (bVarG.P0()) {
                        a1.this.f4677a.k().trackCustomTabsNavigationFailed(bVarG);
                    }
                    break;
                case 4:
                    if (bVarG.P0()) {
                        a1.this.f4677a.k().trackCustomTabsNavigationAborted(bVarG);
                    }
                    break;
                case 5:
                    if (bVarG.P0()) {
                        a1.this.f4677a.k().trackCustomTabsTabShown(bVarG);
                    }
                    AppLovinBroadcastManager.sendBroadcast(new Intent("com.applovin.custom_tabs_shown"), null);
                    l2.c(aVar.e(), bVarG, aVar.i());
                    break;
                case 6:
                    if (bVarG.P0()) {
                        a1.this.f4677a.k().trackCustomTabsTabHidden(bVarG);
                    }
                    AppLovinBroadcastManager.sendBroadcast(new Intent("com.applovin.custom_tabs_hidden"), null);
                    l2.a(aVar.e(), bVarG, aVar.i());
                    break;
                default:
                    a1.this.f4677a.I();
                    if (com.applovin.impl.sdk.n.a()) {
                        a1.this.f4677a.I().a("CustomTabsManager", "Unknown navigation event: " + i10);
                    }
                    break;
            }
        }

        @Override // androidx.browser.customtabs.CustomTabsCallback
        public void onRelationshipValidationResult(int i10, Uri uri, boolean z10, Bundle bundle) {
            a1.this.f4677a.I();
            if (com.applovin.impl.sdk.n.a()) {
                com.applovin.impl.sdk.n nVarI = a1.this.f4677a.I();
                StringBuilder sb = new StringBuilder();
                sb.append("Validation ");
                sb.append(z10 ? "succeeded" : v8.h.f15817t);
                sb.append(" for session-URL relation(");
                sb.append(i10);
                sb.append("), requestedOrigin(");
                sb.append(uri);
                sb.append(")");
                nVarI.a("CustomTabsManager", sb.toString());
            }
        }
    }

    public a1(com.applovin.impl.sdk.j jVar) {
        this.f4677a = jVar;
    }

    public void b(final List list, final CustomTabsSession customTabsSession) {
        if (list.isEmpty()) {
            return;
        }
        if (customTabsSession != null) {
            a("warmup urls", new Runnable() { // from class: com.applovin.impl.f8
                @Override // java.lang.Runnable
                public final void run() {
                    this.f5209a.a(list, customTabsSession);
                }
            });
            return;
        }
        this.f4677a.I();
        if (com.applovin.impl.sdk.n.a()) {
            this.f4677a.I().a("CustomTabsManager", "Custom Tabs session is null, cannot warmup urls");
        }
    }

    public void a() {
        if (((Boolean) this.f4677a.a(l4.f5653h6)).booleanValue() && this.f4678b == null) {
            String packageName = CustomTabsClient.getPackageName(com.applovin.impl.sdk.j.n(), this.f4677a.c(l4.f5661i6), true);
            String packageName2 = CustomTabsClient.getPackageName(com.applovin.impl.sdk.j.n(), null);
            LinkedList linkedList = new LinkedList();
            if (((Boolean) this.f4677a.a(l4.f5669j6)).booleanValue()) {
                CollectionUtils.addUniqueObjectIfExists(packageName2, linkedList);
                CollectionUtils.addUniqueObjectIfExists(packageName, linkedList);
            } else {
                CollectionUtils.addUniqueObjectIfExists(packageName, linkedList);
                CollectionUtils.addUniqueObjectIfExists(packageName2, linkedList);
            }
            if (linkedList.isEmpty()) {
                this.f4677a.I();
                if (com.applovin.impl.sdk.n.a()) {
                    this.f4677a.I().b("CustomTabsManager", "Unable to find a supported Custom Tabs package name");
                    return;
                }
                return;
            }
            a(linkedList);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x006e A[DONT_GENERATE] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void a(java.util.LinkedList r7) {
        /*
            r6 = this;
            java.lang.String r0 = "Retrying with next package name..."
            java.lang.String r1 = "CustomTabsManager"
            r2 = 0
            android.content.Context r3 = com.applovin.impl.sdk.j.n()     // Catch: java.lang.Throwable -> L44
            java.lang.Object r4 = r7.poll()     // Catch: java.lang.Throwable -> L44
            java.lang.String r4 = (java.lang.String) r4     // Catch: java.lang.Throwable -> L44
            com.applovin.impl.a1$a r5 = new com.applovin.impl.a1$a     // Catch: java.lang.Throwable -> L44
            r5.<init>()     // Catch: java.lang.Throwable -> L44
            boolean r2 = androidx.browser.customtabs.CustomTabsClient.bindCustomTabsService(r3, r4, r5)     // Catch: java.lang.Throwable -> L44
            if (r2 != 0) goto L30
            com.applovin.impl.sdk.j r3 = r6.f4677a     // Catch: java.lang.Throwable -> L44
            r3.I()     // Catch: java.lang.Throwable -> L44
            boolean r3 = com.applovin.impl.sdk.n.a()     // Catch: java.lang.Throwable -> L44
            if (r3 == 0) goto L30
            com.applovin.impl.sdk.j r3 = r6.f4677a     // Catch: java.lang.Throwable -> L44
            com.applovin.impl.sdk.n r3 = r3.I()     // Catch: java.lang.Throwable -> L44
            java.lang.String r4 = "Custom Tabs service not available"
            r3.b(r1, r4)     // Catch: java.lang.Throwable -> L44
        L30:
            if (r2 != 0) goto L7a
            boolean r2 = r7.isEmpty()
            if (r2 != 0) goto L7a
            com.applovin.impl.sdk.j r2 = r6.f4677a
            r2.I()
            boolean r2 = com.applovin.impl.sdk.n.a()
            if (r2 == 0) goto L77
            goto L6e
        L44:
            r3 = move-exception
            com.applovin.impl.sdk.j r4 = r6.f4677a     // Catch: java.lang.Throwable -> L7b
            r4.I()     // Catch: java.lang.Throwable -> L7b
            boolean r4 = com.applovin.impl.sdk.n.a()     // Catch: java.lang.Throwable -> L7b
            if (r4 == 0) goto L5b
            com.applovin.impl.sdk.j r4 = r6.f4677a     // Catch: java.lang.Throwable -> L7b
            com.applovin.impl.sdk.n r4 = r4.I()     // Catch: java.lang.Throwable -> L7b
            java.lang.String r5 = "Failed to bind to service"
            r4.a(r1, r5, r3)     // Catch: java.lang.Throwable -> L7b
        L5b:
            if (r2 != 0) goto L7a
            boolean r2 = r7.isEmpty()
            if (r2 != 0) goto L7a
            com.applovin.impl.sdk.j r2 = r6.f4677a
            r2.I()
            boolean r2 = com.applovin.impl.sdk.n.a()
            if (r2 == 0) goto L77
        L6e:
            com.applovin.impl.sdk.j r2 = r6.f4677a
            com.applovin.impl.sdk.n r2 = r2.I()
            r2.a(r1, r0)
        L77:
            r6.a(r7)
        L7a:
            return
        L7b:
            r3 = move-exception
            if (r2 != 0) goto L9b
            boolean r2 = r7.isEmpty()
            if (r2 != 0) goto L9b
            com.applovin.impl.sdk.j r2 = r6.f4677a
            r2.I()
            boolean r2 = com.applovin.impl.sdk.n.a()
            if (r2 == 0) goto L98
            com.applovin.impl.sdk.j r2 = r6.f4677a
            com.applovin.impl.sdk.n r2 = r2.I()
            r2.a(r1, r0)
        L98:
            r6.a(r7)
        L9b:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.a1.a(java.util.LinkedList):void");
    }

    public CustomTabsSession a(com.applovin.impl.adview.a aVar) {
        if (this.f4678b == null) {
            this.f4677a.I();
            if (com.applovin.impl.sdk.n.a()) {
                this.f4677a.I().a("CustomTabsManager", "Custom Tabs service is not connected, cannot start session");
            }
            return null;
        }
        this.f4677a.I();
        if (com.applovin.impl.sdk.n.a()) {
            this.f4677a.I().a("CustomTabsManager", "Starting Custom Tabs session");
        }
        try {
            CustomTabsSession customTabsSessionNewSession = this.f4678b.newSession(new b(aVar));
            a(customTabsSessionNewSession, aVar.g());
            return customTabsSessionNewSession;
        } catch (Exception e10) {
            this.f4677a.I();
            if (com.applovin.impl.sdk.n.a()) {
                this.f4677a.I().a("CustomTabsManager", "Failed to create Custom Tabs session", e10);
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(List list, CustomTabsSession customTabsSession) {
        this.f4677a.I();
        if (com.applovin.impl.sdk.n.a()) {
            this.f4677a.I().a("CustomTabsManager", "Warming up URLs: " + list);
        }
        String str = (String) list.remove(0);
        ArrayList arrayList = new ArrayList(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            String str2 = (String) it.next();
            Bundle bundle = new Bundle();
            bundle.putParcelable(CustomTabsService.KEY_URL, Uri.parse(str2));
            arrayList.add(bundle);
        }
        boolean zMayLaunchUrl = customTabsSession.mayLaunchUrl(Uri.parse(str), null, arrayList);
        this.f4677a.I();
        if (com.applovin.impl.sdk.n.a()) {
            com.applovin.impl.sdk.n nVarI = this.f4677a.I();
            StringBuilder sb = new StringBuilder();
            sb.append("Warmup for URLs ");
            sb.append(zMayLaunchUrl ? "succeeded" : v8.h.f15817t);
            nVarI.a("CustomTabsManager", sb.toString());
        }
    }

    public void a(final String str, final com.applovin.impl.adview.a aVar, final Activity activity) {
        if (a("launch url", new Runnable() { // from class: com.applovin.impl.e8
            @Override // java.lang.Runnable
            public final void run() {
                this.f5149a.a(aVar, activity, str);
            }
        })) {
            this.f4677a.f0().pauseForClick();
        } else {
            AppLovinBroadcastManager.sendBroadcast(new Intent("com.applovin.custom_tabs_failure"), CollectionUtils.map("url", str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(com.applovin.impl.adview.a aVar, Activity activity, String str) {
        a(aVar, activity).launchUrl(activity, Uri.parse(str));
    }

    private void a(final CustomTabsSession customTabsSession, final com.applovin.impl.sdk.ad.b bVar) {
        if (bVar == null || !bVar.y0()) {
            return;
        }
        a("client warmup", new Runnable() { // from class: com.applovin.impl.d8
            @Override // java.lang.Runnable
            public final void run() {
                this.f5038a.a(bVar, customTabsSession);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(com.applovin.impl.sdk.ad.b bVar, CustomTabsSession customTabsSession) {
        this.f4678b.warmup(0L);
        b1 b1VarX = bVar.x();
        if (b1VarX == null) {
            return;
        }
        Integer numE = b1VarX.e();
        String strB = b1VarX.b();
        if (numE == null || TextUtils.isEmpty(strB)) {
            return;
        }
        if (customTabsSession == null) {
            this.f4677a.I();
            if (com.applovin.impl.sdk.n.a()) {
                this.f4677a.I().b("CustomTabsManager", "Cannot validate session-URL relation because the session is null");
                return;
            }
            return;
        }
        this.f4677a.I();
        if (com.applovin.impl.sdk.n.a()) {
            this.f4677a.I().a("CustomTabsManager", "Validating session-URL relation: " + numE + " with digital asset link: " + strB);
        }
        customTabsSession.validateRelationship(numE.intValue(), Uri.parse(strB), null);
    }

    private CustomTabsIntent a(com.applovin.impl.adview.a aVar, Activity activity) {
        this.f4677a.I();
        if (com.applovin.impl.sdk.n.a()) {
            this.f4677a.I().a("CustomTabsManager", "Creating Custom Tabs intent");
        }
        com.applovin.impl.sdk.ad.b bVarG = aVar.g();
        CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder(aVar.h());
        b1 b1VarX = bVarG != null ? bVarG.x() : null;
        if (((Boolean) this.f4677a.a(l4.f5677k6)).booleanValue()) {
            int i10 = R.anim.applovin_slide_up_animation;
            int i11 = R.anim.applovin_slide_down_animation;
            builder.setStartAnimations(activity, i10, i11);
            builder.setExitAnimations(activity, i10, i11);
        }
        if (b1VarX != null) {
            Integer numH = b1VarX.h();
            if (numH != null) {
                builder.setDefaultColorSchemeParams(new CustomTabColorSchemeParams.Builder().setToolbarColor(numH.intValue()).build());
            }
            Integer numA = b1VarX.a();
            if (numA != null) {
                builder.setColorSchemeParams(2, new CustomTabColorSchemeParams.Builder().setToolbarColor(numA.intValue()).build());
            }
            Boolean boolI = b1VarX.i();
            if (boolI != null) {
                builder.setUrlBarHidingEnabled(boolI.booleanValue());
            }
            Boolean boolG = b1VarX.g();
            if (boolG != null) {
                builder.setShowTitle(boolG.booleanValue());
            }
            Boolean boolC = b1VarX.c();
            if (boolC != null) {
                builder.setInstantAppsEnabled(boolC.booleanValue());
            }
            Integer numF = b1VarX.f();
            if (numF != null) {
                builder.setShareState(numF.intValue());
            }
        }
        CustomTabsIntent customTabsIntentBuild = builder.build();
        if (b1VarX != null) {
            String strD = b1VarX.d();
            if (strD != null) {
                customTabsIntentBuild.intent.putExtra("android.intent.extra.REFERRER", Uri.parse(strD));
            }
            Bundle bundleS = bVarG.s();
            if (!bundleS.isEmpty()) {
                customTabsIntentBuild.intent.putExtra("com.android.browser.headers", bundleS);
            }
        }
        return customTabsIntentBuild;
    }

    private boolean a(String str, Runnable runnable) {
        try {
            this.f4677a.I();
            if (com.applovin.impl.sdk.n.a()) {
                this.f4677a.I().a("CustomTabsManager", "Running operation: " + str);
            }
            runnable.run();
            this.f4677a.I();
            if (!com.applovin.impl.sdk.n.a()) {
                return true;
            }
            this.f4677a.I().a("CustomTabsManager", "Finished operation: " + str);
            return true;
        } catch (Throwable th) {
            this.f4677a.I();
            if (com.applovin.impl.sdk.n.a()) {
                this.f4677a.I().a("CustomTabsManager", "Failed to run operation: " + str, th);
            }
            this.f4677a.A().a("CustomTabsManager", str, th);
            return false;
        }
    }
}
