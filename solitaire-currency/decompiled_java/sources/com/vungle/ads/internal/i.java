package com.vungle.ads.internal;

import android.content.Context;
import com.vungle.ads.b2;
import com.vungle.ads.internal.a;
import com.vungle.ads.internal.util.x;
import com.vungle.ads.z1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: BannerAdImpl.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class i extends com.vungle.ads.internal.a {

    @NotNull
    private final z1 adSize;

    @Nullable
    private z1 updatedAdSize;

    /* JADX INFO: compiled from: BannerAdImpl.kt */
    public static final class a extends com.vungle.ads.internal.presenter.c {
        final /* synthetic */ i this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(com.vungle.ads.internal.presenter.b bVar, i iVar) {
            super(bVar);
            this.this$0 = iVar;
        }

        @Override // com.vungle.ads.internal.presenter.c, com.vungle.ads.internal.presenter.b
        public void onAdEnd(@Nullable String str) {
            this.this$0.setAdState(a.EnumC0499a.FINISHED);
            super.onAdEnd(str);
        }

        @Override // com.vungle.ads.internal.presenter.c, com.vungle.ads.internal.presenter.b
        public void onAdStart(@Nullable String str) {
            this.this$0.setAdState(a.EnumC0499a.PLAYING);
            super.onAdStart(str);
        }

        @Override // com.vungle.ads.internal.presenter.c, com.vungle.ads.internal.presenter.b
        public void onFailure(@NotNull b2 error) {
            kotlin.jvm.internal.t.i(error, "error");
            this.this$0.setAdState(a.EnumC0499a.ERROR);
            super.onFailure(error);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(@NotNull Context context, @NotNull z1 adSize) {
        super(context);
        kotlin.jvm.internal.t.i(context, "context");
        kotlin.jvm.internal.t.i(adSize, "adSize");
        this.adSize = adSize;
    }

    @Override // com.vungle.ads.internal.a
    public void adLoadedAndUpdateConfigure$vungle_ads_release(@NotNull com.vungle.ads.internal.model.b advertisement) {
        kotlin.jvm.internal.t.i(advertisement, "advertisement");
        super.adLoadedAndUpdateConfigure$vungle_ads_release(advertisement);
        if (this.adSize.isAdaptiveWidth$vungle_ads_release() || this.adSize.isAdaptiveHeight$vungle_ads_release()) {
            v8.s<Integer, Integer> deviceWidthAndHeightWithOrientation = x.INSTANCE.getDeviceWidthAndHeightWithOrientation(getContext(), 0);
            int iIntValue = deviceWidthAndHeightWithOrientation.a().intValue();
            int iIntValue2 = deviceWidthAndHeightWithOrientation.b().intValue();
            int iAdWidth = this.adSize.isAdaptiveWidth$vungle_ads_release() ? advertisement.adWidth() : this.adSize.getWidth();
            int iAdHeight = this.adSize.isAdaptiveHeight$vungle_ads_release() ? advertisement.adHeight() : this.adSize.getHeight();
            int iMin = Math.min(iIntValue, iAdWidth);
            int iMin2 = Math.min(iIntValue2, iAdHeight);
            if (this.adSize.isAdaptiveHeight$vungle_ads_release() && this.adSize.getHeight() > 0) {
                iMin2 = Math.min(this.adSize.getHeight(), iMin2);
            }
            this.updatedAdSize = new z1(iMin, iMin2);
        }
    }

    @Override // com.vungle.ads.internal.a
    @NotNull
    public z1 getAdSizeForAdRequest() {
        return this.adSize;
    }

    @Nullable
    public final z1 getUpdatedAdSize$vungle_ads_release() {
        return this.updatedAdSize;
    }

    @Override // com.vungle.ads.internal.a
    public boolean isValidAdSize(@Nullable z1 z1Var) {
        boolean zIsValidSize$vungle_ads_release = z1Var != null ? z1Var.isValidSize$vungle_ads_release() : false;
        if (!zIsValidSize$vungle_ads_release) {
            com.vungle.ads.o oVar = com.vungle.ads.o.INSTANCE;
            String str = "Invalidate size " + z1Var + " for banner ad";
            com.vungle.ads.internal.model.j placement = getPlacement();
            String referenceId = placement != null ? placement.getReferenceId() : null;
            com.vungle.ads.internal.model.b advertisement = getAdvertisement();
            oVar.logError$vungle_ads_release(500, str, (28 & 4) != 0 ? null : referenceId, (28 & 8) != 0 ? null : null, (28 & 16) != 0 ? null : advertisement != null ? advertisement.eventId() : null);
        }
        return zIsValidSize$vungle_ads_release;
    }

    @Override // com.vungle.ads.internal.a
    public boolean isValidAdTypeForPlacement(@NotNull com.vungle.ads.internal.model.j placement) {
        kotlin.jvm.internal.t.i(placement, "placement");
        return placement.isBanner() || placement.isMREC() || placement.isInline();
    }

    public final void setUpdatedAdSize$vungle_ads_release(@Nullable z1 z1Var) {
        this.updatedAdSize = z1Var;
    }

    @NotNull
    public final com.vungle.ads.internal.presenter.c wrapCallback$vungle_ads_release(@NotNull com.vungle.ads.internal.presenter.b adPlayCallback) {
        kotlin.jvm.internal.t.i(adPlayCallback, "adPlayCallback");
        return new a(adPlayCallback, this);
    }
}
