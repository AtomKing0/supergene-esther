package com.vungle.ads.internal.presenter;

import com.vungle.ads.b2;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: AdPlayCallback.kt */
/* JADX INFO: loaded from: classes4.dex */
public class c implements b {

    @NotNull
    private final b adPlayCallback;

    public c(@NotNull b adPlayCallback) {
        t.i(adPlayCallback, "adPlayCallback");
        this.adPlayCallback = adPlayCallback;
    }

    @Override // com.vungle.ads.internal.presenter.b
    public void onAdClick(@Nullable String str) {
        this.adPlayCallback.onAdClick(str);
    }

    @Override // com.vungle.ads.internal.presenter.b
    public void onAdEnd(@Nullable String str) {
        this.adPlayCallback.onAdEnd(str);
    }

    @Override // com.vungle.ads.internal.presenter.b
    public void onAdImpression(@Nullable String str) {
        this.adPlayCallback.onAdImpression(str);
    }

    @Override // com.vungle.ads.internal.presenter.b
    public void onAdLeftApplication(@Nullable String str) {
        this.adPlayCallback.onAdLeftApplication(str);
    }

    @Override // com.vungle.ads.internal.presenter.b
    public void onAdRewarded(@Nullable String str) {
        this.adPlayCallback.onAdRewarded(str);
    }

    @Override // com.vungle.ads.internal.presenter.b
    public void onAdStart(@Nullable String str) {
        this.adPlayCallback.onAdStart(str);
    }

    @Override // com.vungle.ads.internal.presenter.b
    public void onFailure(@NotNull b2 error) {
        t.i(error, "error");
        this.adPlayCallback.onFailure(error);
    }
}
