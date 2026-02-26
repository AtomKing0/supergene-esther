package com.google.ads.mediation.applovin;

import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import com.applovin.mediation.BuildConfig;
import com.applovin.sdk.AppLovinMediationProvider;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkConfiguration;
import com.applovin.sdk.AppLovinSdkInitializationConfiguration;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: AppLovinInitializer.java */
/* JADX INFO: loaded from: classes2.dex */
public class d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f8261c = "d";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static d f8262d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f8263e = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AtomicBoolean f8265b = new AtomicBoolean(true);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final i f8264a = new i();

    /* JADX INFO: compiled from: AppLovinInitializer.java */
    class a implements AppLovinSdk.SdkInitializationListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f8266a;

        a(b bVar) {
            this.f8266a = bVar;
        }

        @Override // com.applovin.sdk.AppLovinSdk.SdkInitializationListener
        public void onSdkInitialized(AppLovinSdkConfiguration appLovinSdkConfiguration) {
            this.f8266a.onInitializeSuccess();
        }
    }

    /* JADX INFO: compiled from: AppLovinInitializer.java */
    public interface b {
        void onInitializeSuccess();
    }

    private d() {
    }

    public static d a() {
        if (f8262d == null) {
            f8262d = new d();
        }
        return f8262d;
    }

    public void b(@NonNull Context context, @NonNull String str, @NonNull b bVar) {
        if (this.f8265b.get()) {
            this.f8264a.a(context).initialize(AppLovinSdkInitializationConfiguration.builder(str).setMediationProvider(AppLovinMediationProvider.ADMOB).setPluginVersion(BuildConfig.ADAPTER_VERSION).build(), new a(bVar));
        } else {
            Log.i(f8261c, "AppLovin adapter is disabled. Skipping initialization.");
        }
    }

    public AppLovinSdk c(Context context) {
        return this.f8264a.a(context);
    }
}
