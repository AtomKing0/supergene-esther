package com.moloco.sdk.publisher;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import com.moloco.sdk.publisher.AdLoad;
import com.moloco.sdk.publisher.MolocoAdError;
import h9.p;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import v8.r;

/* JADX INFO: loaded from: classes4.dex */
final class InterstitialAdActivitySample extends Activity {
    private InterstitialAd interstitialAd;

    /* JADX INFO: renamed from: com.moloco.sdk.publisher.InterstitialAdActivitySample$onCreate$1, reason: invalid class name */
    public static final class AnonymousClass1 extends v implements p<InterstitialAd, MolocoAdError.AdCreateError, k0> {
        public AnonymousClass1() {
            super(2);
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ k0 mo4invoke(InterstitialAd interstitialAd, MolocoAdError.AdCreateError adCreateError) {
            invoke2(interstitialAd, adCreateError);
            return k0.f35197a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@Nullable InterstitialAd interstitialAd, @Nullable MolocoAdError.AdCreateError adCreateError) {
            if (interstitialAd == null) {
                InterstitialAdActivitySample.this.finish();
                return;
            }
            InterstitialAdActivitySample.this.interstitialAd = interstitialAd;
            interstitialAd.load("bid response", new AdLoad.Listener() { // from class: com.moloco.sdk.publisher.InterstitialAdActivitySample.onCreate.1.1
                @Override // com.moloco.sdk.publisher.AdLoad.Listener
                public void onAdLoadFailed(@NotNull MolocoAdError molocoAdError) {
                    t.i(molocoAdError, "molocoAdError");
                    throw new r("An operation is not implemented: Not yet implemented");
                }

                @Override // com.moloco.sdk.publisher.AdLoad.Listener
                public void onAdLoadSuccess(@NotNull MolocoAd molocoAd) {
                    t.i(molocoAd, "molocoAd");
                    throw new r("An operation is not implemented: Not yet implemented");
                }
            });
            interstitialAd.isLoaded();
            interstitialAd.show(new InterstitialAdShowListener() { // from class: com.moloco.sdk.publisher.InterstitialAdActivitySample.onCreate.1.2
                @Override // com.moloco.sdk.publisher.AdShowListener
                public void onAdClicked(@NotNull MolocoAd molocoAd) {
                    t.i(molocoAd, "molocoAd");
                    throw new r("An operation is not implemented: Not yet implemented");
                }

                @Override // com.moloco.sdk.publisher.AdShowListener
                public void onAdHidden(@NotNull MolocoAd molocoAd) {
                    t.i(molocoAd, "molocoAd");
                    throw new r("An operation is not implemented: Not yet implemented");
                }

                @Override // com.moloco.sdk.publisher.AdShowListener
                public void onAdShowFailed(@NotNull MolocoAdError molocoAdError) {
                    t.i(molocoAdError, "molocoAdError");
                    throw new r("An operation is not implemented: Not yet implemented");
                }

                @Override // com.moloco.sdk.publisher.AdShowListener
                public void onAdShowSuccess(@NotNull MolocoAd molocoAd) {
                    t.i(molocoAd, "molocoAd");
                    throw new r("An operation is not implemented: Not yet implemented");
                }
            });
            interstitialAd.load("an_another_bid_response", null);
        }
    }

    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle bundle, @Nullable PersistableBundle persistableBundle) {
        super.onCreate(bundle, persistableBundle);
        Moloco.createInterstitial$default("MOLOCO_ADUNIT_ID", null, new AnonymousClass1(), 2, null);
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        InterstitialAd interstitialAd = this.interstitialAd;
        if (interstitialAd == null) {
            t.A("interstitialAd");
            interstitialAd = null;
        }
        interstitialAd.destroy();
    }
}
