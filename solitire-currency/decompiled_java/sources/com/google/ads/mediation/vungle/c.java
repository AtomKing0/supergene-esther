package com.google.ads.mediation.vungle;

import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.MobileAds;
import com.vungle.ads.VungleAds;
import com.vungle.ads.b2;
import com.vungle.ads.c2;
import com.vungle.ads.l0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: VungleInitializer.java */
/* JADX INFO: loaded from: classes2.dex */
public class c implements l0 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final c f8406e = new c();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f8407f = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final String f8408a = "VungleInitializer";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AtomicBoolean f8409b = new AtomicBoolean(false);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private AtomicBoolean f8411d = new AtomicBoolean(true);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ArrayList<a> f8410c = new ArrayList<>();

    /* JADX INFO: compiled from: VungleInitializer.java */
    public interface a {
        void a(AdError adError);

        void onInitializeSuccess();
    }

    private c() {
        VungleAds.setIntegrationName(VungleAds.WrapperFramework.admob, "7.4.2.0".replace('.', '_'));
    }

    @NonNull
    public static c a() {
        return f8406e;
    }

    public void b(@NonNull String str, @NonNull Context context, @NonNull a aVar) {
        if (!this.f8411d.get() || d.f8413b.isInitialized()) {
            Log.i("VungleInitializer", "Vungle Adapter is disabled or already initialized");
            aVar.onInitializeSuccess();
        } else {
            if (this.f8409b.getAndSet(true)) {
                this.f8410c.add(aVar);
                return;
            }
            Log.i("VungleInitializer", "Vungle Adapter initializing");
            c(MobileAds.getRequestConfiguration().getTagForChildDirectedTreatment());
            d.f8413b.a(context, str, this);
            this.f8410c.add(aVar);
        }
    }

    public void c(int i10) {
        if (i10 == 0) {
            c2.setCOPPAStatus(false);
        } else {
            if (i10 != 1) {
                return;
            }
            c2.setCOPPAStatus(true);
        }
    }

    @Override // com.vungle.ads.l0
    public void onError(@NonNull b2 b2Var) {
        AdError adError = VungleMediationAdapter.getAdError(b2Var);
        Iterator<a> it = this.f8410c.iterator();
        while (it.hasNext()) {
            it.next().a(adError);
        }
        this.f8410c.clear();
        this.f8409b.set(false);
    }

    @Override // com.vungle.ads.l0
    public void onSuccess() {
        Iterator<a> it = this.f8410c.iterator();
        while (it.hasNext()) {
            it.next().onInitializeSuccess();
        }
        this.f8410c.clear();
        this.f8409b.set(false);
    }
}
