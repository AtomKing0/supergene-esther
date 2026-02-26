package com.moloco.sdk.internal.publisher;

import com.moloco.sdk.internal.MolocoLogger;
import com.moloco.sdk.publisher.AdShowListener;
import com.moloco.sdk.publisher.MolocoAd;
import com.moloco.sdk.publisher.MolocoAdError;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class o implements AdShowListener {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public static final a f18263b = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public final AdShowListener f18264a;

    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        public a() {
        }
    }

    public o(@Nullable AdShowListener adShowListener) {
        this.f18264a = adShowListener;
    }

    @Override // com.moloco.sdk.publisher.AdShowListener
    public void onAdClicked(@NotNull MolocoAd molocoAd) {
        kotlin.jvm.internal.t.i(molocoAd, "molocoAd");
        MolocoLogger.debug$default(MolocoLogger.INSTANCE, "AdShowListenerTrackerImpl", "onAdClicked: " + molocoAd, false, 4, null);
        AdShowListener adShowListener = this.f18264a;
        if (adShowListener != null) {
            adShowListener.onAdClicked(molocoAd);
        }
    }

    @Override // com.moloco.sdk.publisher.AdShowListener
    public void onAdHidden(@NotNull MolocoAd molocoAd) {
        kotlin.jvm.internal.t.i(molocoAd, "molocoAd");
        MolocoLogger.debug$default(MolocoLogger.INSTANCE, "AdShowListenerTrackerImpl", "onAdHidden: " + molocoAd, false, 4, null);
        AdShowListener adShowListener = this.f18264a;
        if (adShowListener != null) {
            adShowListener.onAdHidden(molocoAd);
        }
    }

    @Override // com.moloco.sdk.publisher.AdShowListener
    public void onAdShowFailed(@NotNull MolocoAdError molocoAdError) {
        kotlin.jvm.internal.t.i(molocoAdError, "molocoAdError");
        MolocoLogger.debug$default(MolocoLogger.INSTANCE, "AdShowListenerTrackerImpl", "onAdShowFailed: " + molocoAdError, false, 4, null);
        AdShowListener adShowListener = this.f18264a;
        if (adShowListener != null) {
            adShowListener.onAdShowFailed(molocoAdError);
        }
    }

    @Override // com.moloco.sdk.publisher.AdShowListener
    public void onAdShowSuccess(@NotNull MolocoAd molocoAd) {
        kotlin.jvm.internal.t.i(molocoAd, "molocoAd");
        MolocoLogger.debug$default(MolocoLogger.INSTANCE, "AdShowListenerTrackerImpl", "onAdShowSuccess: " + molocoAd, false, 4, null);
        AdShowListener adShowListener = this.f18264a;
        if (adShowListener != null) {
            adShowListener.onAdShowSuccess(molocoAd);
        }
    }
}
