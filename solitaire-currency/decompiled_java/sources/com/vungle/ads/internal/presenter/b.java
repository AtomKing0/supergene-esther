package com.vungle.ads.internal.presenter;

import com.vungle.ads.b2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: AdPlayCallback.kt */
/* JADX INFO: loaded from: classes4.dex */
public interface b {
    void onAdClick(@Nullable String str);

    void onAdEnd(@Nullable String str);

    void onAdImpression(@Nullable String str);

    void onAdLeftApplication(@Nullable String str);

    void onAdRewarded(@Nullable String str);

    void onAdStart(@Nullable String str);

    void onFailure(@NotNull b2 b2Var);
}
