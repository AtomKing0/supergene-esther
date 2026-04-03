package com.vungle.ads;

import android.content.Context;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: NativeAd.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class f1 extends com.vungle.ads.internal.a implements com.vungle.ads.internal.presenter.p {

    @NotNull
    public static final a Companion = new a(null);

    @NotNull
    public static final String TOKEN_APP_DESCRIPTION = "APP_DESCRIPTION";

    @NotNull
    public static final String TOKEN_APP_ICON = "APP_ICON";

    @NotNull
    public static final String TOKEN_APP_NAME = "APP_NAME";

    @NotNull
    public static final String TOKEN_APP_RATING_VALUE = "APP_RATING_VALUE";

    @NotNull
    public static final String TOKEN_CTA_BUTTON_TEXT = "CTA_BUTTON_TEXT";

    @NotNull
    public static final String TOKEN_CTA_BUTTON_URL = "CTA_BUTTON_URL";

    @NotNull
    public static final String TOKEN_MAIN_IMAGE = "MAIN_IMAGE";

    @NotNull
    public static final String TOKEN_OM_SDK_DATA = "OM_SDK_DATA";

    @NotNull
    public static final String TOKEN_SPONSORED_BY = "SPONSORED_BY";

    @NotNull
    public static final String TOKEN_VUNGLE_PRIVACY_ICON_URL = "VUNGLE_PRIVACY_ICON_URL";

    @NotNull
    public static final String TOKEN_VUNGLE_PRIVACY_URL = "VUNGLE_PRIVACY_URL";

    /* JADX INFO: compiled from: NativeAd.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f1(@NotNull Context context) {
        super(context);
        kotlin.jvm.internal.t.i(context, "context");
    }

    @Override // com.vungle.ads.internal.a
    @Nullable
    public z1 getAdSizeForAdRequest() {
        return null;
    }

    @Override // com.vungle.ads.internal.presenter.p
    @Nullable
    public List<String> getImpressionUrls() {
        com.vungle.ads.internal.model.e bidPayload = getBidPayload();
        if (bidPayload != null) {
            return bidPayload.getImpression();
        }
        return null;
    }

    @Override // com.vungle.ads.internal.presenter.p
    @Nullable
    public String getPlacementRefId() {
        com.vungle.ads.internal.model.j placement = getPlacement();
        if (placement != null) {
            return placement.getReferenceId();
        }
        return null;
    }

    @Override // com.vungle.ads.internal.a
    public boolean isValidAdSize(@Nullable z1 z1Var) {
        return true;
    }

    @Override // com.vungle.ads.internal.a
    public boolean isValidAdTypeForPlacement(@NotNull com.vungle.ads.internal.model.j placement) {
        kotlin.jvm.internal.t.i(placement, "placement");
        return placement.isNative();
    }
}
