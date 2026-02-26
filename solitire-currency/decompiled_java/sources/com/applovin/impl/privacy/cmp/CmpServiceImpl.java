package com.applovin.impl.privacy.cmp;

import android.app.Activity;
import android.os.Bundle;
import androidx.annotation.NonNull;
import com.applovin.impl.g0;
import com.applovin.impl.privacy.cmp.a;
import com.applovin.impl.sdk.j;
import com.applovin.impl.sdk.n;
import com.applovin.impl.z6;
import com.applovin.sdk.AppLovinCmpError;
import com.applovin.sdk.AppLovinCmpService;
import com.applovin.sdk.AppLovinSdkUtils;

/* JADX INFO: loaded from: classes2.dex */
public class CmpServiceImpl implements AppLovinCmpService, a.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final j f6591a;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private AppLovinCmpError f6595e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private e f6596f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private f f6597g;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Object f6593c = new Object();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private d f6594d = d.NONE;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.applovin.impl.privacy.cmp.a f6592b = c();

    class a implements e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AppLovinCmpService.OnCompletedListener f6598a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Activity f6599b;

        /* JADX INFO: renamed from: com.applovin.impl.privacy.cmp.CmpServiceImpl$a$a, reason: collision with other inner class name */
        class C0168a implements f {
            C0168a() {
            }

            @Override // com.applovin.impl.privacy.cmp.CmpServiceImpl.f
            public void a(AppLovinCmpError appLovinCmpError) {
                a.this.f6598a.onCompleted(appLovinCmpError);
            }
        }

        a(AppLovinCmpService.OnCompletedListener onCompletedListener, Activity activity) {
            this.f6598a = onCompletedListener;
            this.f6599b = activity;
        }

        @Override // com.applovin.impl.privacy.cmp.CmpServiceImpl.e
        public void a(AppLovinCmpError appLovinCmpError) {
            if (appLovinCmpError != null) {
                this.f6598a.onCompleted(appLovinCmpError);
            } else {
                CmpServiceImpl.this.showCmp(this.f6599b, new C0168a());
            }
        }
    }

    class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Activity f6602a;

        b(Activity activity) {
            this.f6602a = activity;
        }

        @Override // java.lang.Runnable
        public void run() {
            CmpServiceImpl.this.f6592b.b(this.f6602a, CmpServiceImpl.this.a(), CmpServiceImpl.this);
        }
    }

    class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Activity f6604a;

        c(Activity activity) {
            this.f6604a = activity;
        }

        @Override // java.lang.Runnable
        public void run() {
            CmpServiceImpl.this.f6592b.a(this.f6604a, CmpServiceImpl.this.a(), CmpServiceImpl.this);
        }
    }

    private enum d {
        NONE,
        LOADING,
        COMPLETED
    }

    public interface e {
        void a(AppLovinCmpError appLovinCmpError);
    }

    public interface f {
        void a(AppLovinCmpError appLovinCmpError);
    }

    public CmpServiceImpl(j jVar) {
        this.f6591a = jVar;
    }

    private com.applovin.impl.privacy.cmp.a c() {
        if (z6.a("com.google.android.ump.ConsentForm")) {
            return new com.applovin.impl.privacy.cmp.a(this.f6591a);
        }
        if (!this.f6591a.v().j()) {
            return null;
        }
        n.h("AppLovinSdk", "Could not load Google UMP. Please add the Google User Messaging Platform SDK into your application. Instructions can be found here: https://developers.applovin.com/en/android/overview/terms-and-privacy-policy-flow#enabling-google-ump");
        return null;
    }

    private void d() {
        if (hasSupportedCmp()) {
            this.f6592b.c();
        }
    }

    @Override // com.applovin.sdk.AppLovinCmpService
    public boolean hasSupportedCmp() {
        return this.f6592b != null;
    }

    public void loadCmp(Activity activity, e eVar) {
        a(activity, eVar);
    }

    @Override // com.applovin.impl.privacy.cmp.a.d
    public void onFlowHidden(Bundle bundle) {
        b((AppLovinCmpError) null);
        b();
    }

    @Override // com.applovin.impl.privacy.cmp.a.d
    public void onFlowLoadFailed(CmpErrorImpl cmpErrorImpl) {
        b();
        synchronized (this.f6593c) {
            if (this.f6596f == null) {
                this.f6594d = d.COMPLETED;
                this.f6595e = cmpErrorImpl;
            } else {
                this.f6594d = d.NONE;
                a(cmpErrorImpl);
            }
        }
    }

    @Override // com.applovin.impl.privacy.cmp.a.d
    public void onFlowLoaded(Bundle bundle) {
        synchronized (this.f6593c) {
            if (this.f6596f == null) {
                this.f6594d = d.COMPLETED;
            } else {
                this.f6594d = d.NONE;
                a((AppLovinCmpError) null);
            }
        }
    }

    @Override // com.applovin.impl.privacy.cmp.a.d
    public void onFlowShowFailed(CmpErrorImpl cmpErrorImpl) {
        b(cmpErrorImpl);
        b();
    }

    public void preloadCmp(Activity activity) {
        a(activity, null);
    }

    public void showCmp(Activity activity, f fVar) {
        b bVar = new b(activity);
        this.f6597g = fVar;
        if (this.f6592b.e()) {
            AppLovinSdkUtils.runOnUiThread(bVar);
        } else {
            bVar.run();
        }
    }

    @Override // com.applovin.sdk.AppLovinCmpService
    public void showCmpForExistingUser(@NonNull Activity activity, @NonNull AppLovinCmpService.OnCompletedListener onCompletedListener) {
        this.f6591a.I();
        if (n.a()) {
            this.f6591a.I().a("AppLovinCmpService", "showCmpForExistingUser(activity=" + activity + ", completedListener=" + onCompletedListener + ")");
        }
        if (!hasSupportedCmp()) {
            onCompletedListener.onCompleted(new CmpErrorImpl(AppLovinCmpError.Code.INTEGRATION_ERROR, "A supported CMP is not integrated"));
        } else {
            d();
            loadCmp(activity, new a(onCompletedListener, activity));
        }
    }

    @NonNull
    public String toString() {
        return "[CmpService]";
    }

    private void a(AppLovinCmpError appLovinCmpError) {
        e eVar = this.f6596f;
        if (eVar == null) {
            return;
        }
        eVar.a(appLovinCmpError);
        this.f6596f = null;
        this.f6595e = null;
    }

    private void b(AppLovinCmpError appLovinCmpError) {
        f fVar = this.f6597g;
        if (fVar == null) {
            return;
        }
        fVar.a(appLovinCmpError);
        this.f6597g = null;
    }

    private void b() {
        com.applovin.impl.privacy.cmp.a aVar = this.f6592b;
        if (aVar == null) {
            return;
        }
        aVar.a();
    }

    private void a(Activity activity, e eVar) {
        boolean z10;
        if (!hasSupportedCmp()) {
            if (eVar != null) {
                eVar.a(new CmpErrorImpl(AppLovinCmpError.Code.INTEGRATION_ERROR, "A supported CMP is not integrated"));
                return;
            }
            return;
        }
        synchronized (this.f6593c) {
            if (eVar != null) {
                this.f6596f = eVar;
            }
            d dVar = this.f6594d;
            d dVar2 = d.NONE;
            if (dVar == dVar2) {
                this.f6594d = d.LOADING;
                z10 = false;
            } else {
                if (dVar == d.LOADING) {
                    return;
                }
                this.f6594d = dVar2;
                z10 = true;
            }
            if (z10) {
                a(this.f6595e);
                return;
            }
            c cVar = new c(activity);
            if (this.f6592b.d()) {
                AppLovinSdkUtils.runOnUiThread(cVar);
            } else {
                cVar.run();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public g0 a() {
        return new g0(this.f6591a.v().d());
    }
}
