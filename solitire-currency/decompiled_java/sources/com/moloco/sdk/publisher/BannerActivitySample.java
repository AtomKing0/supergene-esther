package com.moloco.sdk.publisher;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
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
final class BannerActivitySample extends Activity {
    private Banner banner;

    @NotNull
    private final FrameLayout bannerContainer = new FrameLayout(this);

    /* JADX INFO: renamed from: com.moloco.sdk.publisher.BannerActivitySample$onCreate$1, reason: invalid class name */
    public static final class AnonymousClass1 extends v implements p<Banner, MolocoAdError.AdCreateError, k0> {
        public AnonymousClass1() {
            super(2);
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ k0 mo4invoke(Banner banner, MolocoAdError.AdCreateError adCreateError) {
            invoke2(banner, adCreateError);
            return k0.f35197a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@Nullable Banner banner, @Nullable MolocoAdError.AdCreateError adCreateError) {
            if (banner == null) {
                BannerActivitySample.this.finish();
                return;
            }
            BannerActivitySample.this.banner = banner;
            BannerActivitySample.this.bannerContainer.addView(banner);
            banner.setAdShowListener(new BannerAdShowListener() { // from class: com.moloco.sdk.publisher.BannerActivitySample.onCreate.1.1
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
            banner.load("bid response", new AdLoad.Listener() { // from class: com.moloco.sdk.publisher.BannerActivitySample.onCreate.1.2
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
            banner.isLoaded();
            banner.load("an_another_bid_response", null);
            BannerActivitySample.this.bannerContainer.removeView(banner);
            banner.load("", null);
            banner.load("some_other_bid_response", null);
            BannerActivitySample.this.bannerContainer.addView(banner);
        }
    }

    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle bundle, @Nullable PersistableBundle persistableBundle) {
        super.onCreate(bundle, persistableBundle);
        setContentView(this.bannerContainer);
        Moloco.createBanner$default("MOLOCO_ADUNIT_ID", null, new AnonymousClass1(), 2, null);
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        Banner banner = this.banner;
        Banner banner2 = null;
        if (banner == null) {
            t.A("banner");
            banner = null;
        }
        banner.destroy();
        Banner banner3 = this.banner;
        if (banner3 == null) {
            t.A("banner");
            banner3 = null;
        }
        ViewParent parent = banner3.getParent();
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (viewGroup != null) {
            Banner banner4 = this.banner;
            if (banner4 == null) {
                t.A("banner");
            } else {
                banner2 = banner4;
            }
            viewGroup.removeView(banner2);
        }
    }
}
