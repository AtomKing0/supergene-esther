package com.google.ads.mediation.vungle;

import android.content.Context;
import com.vungle.ads.VungleAds;
import com.vungle.ads.l0;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: VungleSdkWrapper.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final d f8412a = new d();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public static com.google.ads.mediation.vungle.a f8413b = new a();

    /* JADX INFO: compiled from: VungleSdkWrapper.kt */
    public static final class a implements com.google.ads.mediation.vungle.a {
        a() {
        }

        @Override // com.google.ads.mediation.vungle.a
        public void a(@NotNull Context context, @NotNull String appId, @NotNull l0 initializationListener) {
            t.i(context, "context");
            t.i(appId, "appId");
            t.i(initializationListener, "initializationListener");
            VungleAds.Companion.init(context, appId, initializationListener);
        }

        @Override // com.google.ads.mediation.vungle.a
        @Nullable
        public String b(@NotNull Context context) {
            t.i(context, "context");
            return VungleAds.Companion.getBiddingToken(context);
        }

        @Override // com.google.ads.mediation.vungle.a
        @NotNull
        public String getSdkVersion() {
            return VungleAds.Companion.getSdkVersion();
        }

        @Override // com.google.ads.mediation.vungle.a
        public boolean isInitialized() {
            return VungleAds.Companion.isInitialized();
        }
    }

    private d() {
    }
}
