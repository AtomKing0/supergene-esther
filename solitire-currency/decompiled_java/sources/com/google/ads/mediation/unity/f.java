package com.google.ads.mediation.unity;

import android.content.Context;
import android.util.Log;
import com.unity3d.ads.IUnityAdsInitializationListener;
import com.unity3d.ads.metadata.MediationMetaData;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;

/* JADX INFO: compiled from: UnityInitializer.java */
/* JADX INFO: loaded from: classes2.dex */
public class f {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static f f8366d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final String f8367a = "UnityInitializer";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private AtomicBoolean f8369c = new AtomicBoolean(true);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final c f8368b = new c();

    private f() {
    }

    public static synchronized f a() {
        if (f8366d == null) {
            f8366d = new f();
        }
        return f8366d;
    }

    public void b(Context context, String str, IUnityAdsInitializationListener iUnityAdsInitializationListener) throws JSONException {
        if (!this.f8369c.get() || this.f8368b.d()) {
            Log.i("UnityInitializer", "Unity Adapter is disabled or initialized.");
            iUnityAdsInitializationListener.onInitializationComplete();
            return;
        }
        Log.i("UnityInitializer", "Unity Adapter initializing ... ... ...");
        MediationMetaData mediationMetaDataA = this.f8368b.a(context);
        mediationMetaDataA.setName("AdMob");
        mediationMetaDataA.setVersion(this.f8368b.b());
        mediationMetaDataA.set("adapter_version", "4.12.2.0");
        mediationMetaDataA.commit();
        this.f8368b.c(context, str, iUnityAdsInitializationListener);
    }
}
