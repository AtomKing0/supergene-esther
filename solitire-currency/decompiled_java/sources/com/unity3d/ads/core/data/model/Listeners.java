package com.unity3d.ads.core.data.model;

import com.unity3d.ads.UnityAds;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Listeners.kt */
/* JADX INFO: loaded from: classes4.dex */
public interface Listeners {

    /* JADX INFO: compiled from: Listeners.kt */
    public static final class DefaultImpls {
        public static void onClick(@NotNull Listeners listeners, @NotNull String placementId) {
            t.i(placementId, "placementId");
        }

        public static void onComplete(@NotNull Listeners listeners, @NotNull String placementId, @NotNull UnityAds.UnityAdsShowCompletionState state) {
            t.i(placementId, "placementId");
            t.i(state, "state");
        }

        public static void onError(@NotNull Listeners listeners, @NotNull String placementId, @NotNull UnityAds.UnityAdsShowError error, @NotNull String message) {
            t.i(placementId, "placementId");
            t.i(error, "error");
            t.i(message, "message");
        }

        public static void onLeftApplication(@NotNull Listeners listeners, @NotNull String placementId) {
            t.i(placementId, "placementId");
        }

        public static void onStart(@NotNull Listeners listeners, @NotNull String placementId) {
            t.i(placementId, "placementId");
        }
    }

    void onClick(@NotNull String str);

    void onComplete(@NotNull String str, @NotNull UnityAds.UnityAdsShowCompletionState unityAdsShowCompletionState);

    void onError(@NotNull String str, @NotNull UnityAds.UnityAdsShowError unityAdsShowError, @NotNull String str2);

    void onLeftApplication(@NotNull String str);

    void onStart(@NotNull String str);
}
