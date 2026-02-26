package com.ironsource;

import java.lang.ref.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class lc implements dn {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    private mc f13012a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private WeakReference<nc> f13013b = new WeakReference<>(null);

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        public static final a f13014a = new a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @NotNull
        public static final String f13015b = "impressions";

        private a() {
        }
    }

    public final void a(@NotNull mc loadListener) {
        kotlin.jvm.internal.t.i(loadListener, "loadListener");
        this.f13012a = loadListener;
    }

    @Override // com.ironsource.dn
    public void onInterstitialAdRewarded(@Nullable String str, int i10) {
        nc ncVar = this.f13013b.get();
        if (ncVar != null) {
            ncVar.onAdInstanceDidReward(str, i10);
        }
    }

    @Override // com.ironsource.dn
    public void onInterstitialClick() {
        nc ncVar = this.f13013b.get();
        if (ncVar != null) {
            ncVar.onAdInstanceDidClick();
        }
    }

    @Override // com.ironsource.dn
    public void onInterstitialClose() {
        nc ncVar = this.f13013b.get();
        if (ncVar != null) {
            ncVar.onAdInstanceDidDismiss();
        }
    }

    @Override // com.ironsource.dn
    public void onInterstitialEventNotificationReceived(@Nullable String str, @Nullable JSONObject jSONObject) {
        nc ncVar;
        if (!kotlin.jvm.internal.t.d(str, "impressions") || (ncVar = this.f13013b.get()) == null) {
            return;
        }
        ncVar.onAdInstanceDidBecomeVisible();
    }

    @Override // com.ironsource.dn
    public void onInterstitialLoadFailed(@NotNull String description) {
        kotlin.jvm.internal.t.i(description, "description");
        mc mcVar = this.f13012a;
        if (mcVar != null) {
            mcVar.a(description);
        }
    }

    @Override // com.ironsource.dn
    public void onInterstitialLoadSuccess(@NotNull mi adInstance) {
        kotlin.jvm.internal.t.i(adInstance, "adInstance");
        mc mcVar = this.f13012a;
        if (mcVar != null) {
            mcVar.a(adInstance);
        }
    }

    @Override // com.ironsource.dn
    public void onInterstitialOpen() {
        nc ncVar = this.f13013b.get();
        if (ncVar != null) {
            ncVar.onAdInstanceDidShow();
        }
    }

    @Override // com.ironsource.dn
    public void onInterstitialShowFailed(@Nullable String str) {
        nc ncVar = this.f13013b.get();
        if (ncVar != null) {
            ncVar.a(str);
        }
    }

    public final void a(@NotNull nc showListener) {
        kotlin.jvm.internal.t.i(showListener, "showListener");
        this.f13013b = new WeakReference<>(showListener);
    }

    @Override // com.ironsource.dn
    public void onInterstitialInitSuccess() {
    }

    @Override // com.ironsource.dn
    public void onInterstitialShowSuccess() {
    }

    @Override // com.ironsource.dn
    public void onInterstitialInitFailed(@Nullable String str) {
    }
}
