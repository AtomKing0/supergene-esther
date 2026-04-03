package com.unity3d.ads.core.domain;

import android.content.Context;
import com.google.protobuf.ByteString;
import com.unity3d.ads.UnityAdsLoadOptions;
import com.unity3d.ads.core.data.model.LoadResult;
import gatewayprotocol.v1.AdRequestOuterClass;
import gatewayprotocol.v1.HeaderBiddingAdMarkupOuterClass;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Load.kt */
/* JADX INFO: loaded from: classes4.dex */
public interface Load {

    /* JADX INFO: compiled from: Load.kt */
    public static final class DefaultImpls {
        public static /* synthetic */ Object invoke$default(Load load, Context context, String str, ByteString byteString, HeaderBiddingAdMarkupOuterClass.HeaderBiddingAdMarkup headerBiddingAdMarkup, AdRequestOuterClass.BannerSize bannerSize, UnityAdsLoadOptions unityAdsLoadOptions, z8.d dVar, int i10, Object obj) {
            if (obj == null) {
                return load.invoke(context, str, byteString, headerBiddingAdMarkup, (i10 & 16) != 0 ? null : bannerSize, unityAdsLoadOptions, dVar);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: invoke");
        }
    }

    @Nullable
    Object invoke(@NotNull Context context, @NotNull String str, @NotNull ByteString byteString, @NotNull HeaderBiddingAdMarkupOuterClass.HeaderBiddingAdMarkup headerBiddingAdMarkup, @Nullable AdRequestOuterClass.BannerSize bannerSize, @NotNull UnityAdsLoadOptions unityAdsLoadOptions, @NotNull z8.d<? super LoadResult> dVar);
}
