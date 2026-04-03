package com.ironsource;

import android.app.Activity;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public interface fg {

    public interface a {
        void onNativeAdClicked();

        void onNativeAdLoadFailed(@NotNull String str);

        void onNativeAdLoadSuccess(@NotNull dg dgVar);

        void onNativeAdShown();
    }

    @Nullable
    a a();

    void a(@NotNull Activity activity, @NotNull JSONObject jSONObject);

    void a(@Nullable a aVar);

    void a(@NotNull gg ggVar);

    @Nullable
    dg b();

    void destroy();
}
