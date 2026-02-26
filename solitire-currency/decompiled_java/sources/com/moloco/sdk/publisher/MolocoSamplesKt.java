package com.moloco.sdk.publisher;

import android.content.Context;
import android.widget.FrameLayout;
import com.moloco.sdk.internal.MolocoLogger;
import com.moloco.sdk.publisher.MolocoAdError;
import com.moloco.sdk.publisher.init.MolocoInitParams;
import h9.p;
import io.sentry.protocol.App;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: loaded from: classes4.dex */
public final class MolocoSamplesKt {

    /* JADX INFO: renamed from: com.moloco.sdk.publisher.MolocoSamplesKt$MolocoCreateBanner$1, reason: invalid class name */
    public static final class AnonymousClass1 extends v implements p<Banner, MolocoAdError.AdCreateError, k0> {
        final /* synthetic */ FrameLayout $frameLayout;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(FrameLayout frameLayout) {
            super(2);
            this.$frameLayout = frameLayout;
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ k0 mo4invoke(Banner banner, MolocoAdError.AdCreateError adCreateError) {
            invoke2(banner, adCreateError);
            return k0.f35197a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@Nullable Banner banner, @Nullable MolocoAdError.AdCreateError adCreateError) {
            if (banner != null) {
                banner.load("bid_response", null);
                this.$frameLayout.addView(banner);
                banner.destroy();
                this.$frameLayout.removeView(banner);
            }
        }
    }

    /* JADX INFO: renamed from: com.moloco.sdk.publisher.MolocoSamplesKt$MolocoCreateBannerTablet$1, reason: invalid class name and case insensitive filesystem */
    public static final class C31311 extends v implements p<Banner, MolocoAdError.AdCreateError, k0> {
        final /* synthetic */ FrameLayout $frameLayout;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C31311(FrameLayout frameLayout) {
            super(2);
            this.$frameLayout = frameLayout;
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ k0 mo4invoke(Banner banner, MolocoAdError.AdCreateError adCreateError) {
            invoke2(banner, adCreateError);
            return k0.f35197a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@Nullable Banner banner, @Nullable MolocoAdError.AdCreateError adCreateError) {
            if (banner != null) {
                banner.load("bid_response", null);
                this.$frameLayout.addView(banner);
                banner.destroy();
                this.$frameLayout.removeView(banner);
            }
        }
    }

    /* JADX INFO: renamed from: com.moloco.sdk.publisher.MolocoSamplesKt$MolocoCreateInterstitialAd$1, reason: invalid class name and case insensitive filesystem */
    public static final class C31321 extends v implements p<InterstitialAd, MolocoAdError.AdCreateError, k0> {
        public static final C31321 INSTANCE = new C31321();

        public C31321() {
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
            if (interstitialAd != null) {
                interstitialAd.load("bid_response", null);
                interstitialAd.show(null);
                interstitialAd.destroy();
            }
        }
    }

    /* JADX INFO: renamed from: com.moloco.sdk.publisher.MolocoSamplesKt$MolocoCreateMREC$1, reason: invalid class name and case insensitive filesystem */
    public static final class C31331 extends v implements p<Banner, MolocoAdError.AdCreateError, k0> {
        final /* synthetic */ FrameLayout $frameLayout;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C31331(FrameLayout frameLayout) {
            super(2);
            this.$frameLayout = frameLayout;
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ k0 mo4invoke(Banner banner, MolocoAdError.AdCreateError adCreateError) {
            invoke2(banner, adCreateError);
            return k0.f35197a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@Nullable Banner banner, @Nullable MolocoAdError.AdCreateError adCreateError) {
            if (banner != null) {
                banner.load("bid_response", null);
                this.$frameLayout.addView(banner);
                banner.destroy();
                this.$frameLayout.removeView(banner);
            }
        }
    }

    /* JADX INFO: renamed from: com.moloco.sdk.publisher.MolocoSamplesKt$MolocoCreateNativeAd$1, reason: invalid class name and case insensitive filesystem */
    public static final class C31341 extends v implements p<NativeAd, MolocoAdError.AdCreateError, k0> {
        public static final C31341 INSTANCE = new C31341();

        public C31341() {
            super(2);
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ k0 mo4invoke(NativeAd nativeAd, MolocoAdError.AdCreateError adCreateError) {
            invoke2(nativeAd, adCreateError);
            return k0.f35197a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@Nullable NativeAd nativeAd, @Nullable MolocoAdError.AdCreateError adCreateError) {
            if (nativeAd != null) {
                nativeAd.load("bid_response", null);
            }
        }
    }

    /* JADX INFO: renamed from: com.moloco.sdk.publisher.MolocoSamplesKt$MolocoCreateRewardedInterstitialAd$1, reason: invalid class name and case insensitive filesystem */
    public static final class C31351 extends v implements p<RewardedInterstitialAd, MolocoAdError.AdCreateError, k0> {
        public static final C31351 INSTANCE = new C31351();

        public C31351() {
            super(2);
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ k0 mo4invoke(RewardedInterstitialAd rewardedInterstitialAd, MolocoAdError.AdCreateError adCreateError) {
            invoke2(rewardedInterstitialAd, adCreateError);
            return k0.f35197a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@Nullable RewardedInterstitialAd rewardedInterstitialAd, @Nullable MolocoAdError.AdCreateError adCreateError) {
            if (rewardedInterstitialAd != null) {
                rewardedInterstitialAd.load("bid_response", null);
                rewardedInterstitialAd.show(null);
                rewardedInterstitialAd.destroy();
            }
        }
    }

    private static final void MolocoCreateBanner(FrameLayout frameLayout) {
        Moloco.createBanner$default("MOLOCO_ADUNIT_ID", null, new AnonymousClass1(frameLayout), 2, null);
    }

    private static final void MolocoCreateBannerTablet(FrameLayout frameLayout) {
        Moloco.createBannerTablet$default("MOLOCO_ADUNIT_ID", null, new C31311(frameLayout), 2, null);
    }

    private static final void MolocoCreateInterstitialAd() {
        Moloco.createInterstitial$default("MOLOCO_ADUNIT_ID", null, C31321.INSTANCE, 2, null);
    }

    private static final void MolocoCreateMREC(FrameLayout frameLayout) {
        Moloco.createMREC$default("MOLOCO_ADUNIT_ID", null, new C31331(frameLayout), 2, null);
    }

    private static final void MolocoCreateNativeAd(String str) {
        Moloco.createNativeAd$default("MOLOCO_ADUNIT_ID", null, C31341.INSTANCE, 2, null);
    }

    private static final void MolocoCreateRewardedInterstitialAd() {
        Moloco.createRewardedInterstitial$default("MOLOCO_ADUNIT_ID", null, C31351.INSTANCE, 2, null);
    }

    private static final void MolocoInitializeSample(final Context context) {
        Moloco.initialize(new MolocoInitParams(context, "YOUR_APP_KEY", new MediationInfo("<YourMediationName>")), new MolocoInitializationListener() { // from class: com.moloco.sdk.publisher.MolocoSamplesKt.MolocoInitializeSample.1
            @Override // com.moloco.sdk.publisher.MolocoInitializationListener
            public final void onMolocoInitializationStatus(@NotNull MolocoInitStatus molocoInitStatus) {
                t.i(molocoInitStatus, "molocoInitStatus");
                if (molocoInitStatus.getInitialization() == Initialization.SUCCESS) {
                    Moloco.getBidToken(context, new MolocoBidTokenListener() { // from class: com.moloco.sdk.publisher.MolocoSamplesKt$MolocoInitializeSample$1$onMolocoInitializationStatus$1
                        @Override // com.moloco.sdk.publisher.MolocoBidTokenListener
                        public final void onBidTokenResult(@NotNull String bidToken, @Nullable MolocoAdError.ErrorType errorType) {
                            t.i(bidToken, "bidToken");
                        }
                    });
                } else {
                    MolocoLogger.error$default(MolocoLogger.INSTANCE, App.TYPE, molocoInitStatus.getDescription(), null, false, 12, null);
                }
            }
        });
    }

    private static final void MolocoIsInitializedSample() {
        Moloco.isInitialized();
    }
}
