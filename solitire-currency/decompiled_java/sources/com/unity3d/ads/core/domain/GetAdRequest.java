package com.unity3d.ads.core.domain;

import com.google.protobuf.ByteString;
import gatewayprotocol.v1.AdRequestOuterClass;
import gatewayprotocol.v1.UniversalRequestOuterClass;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: GetAdRequest.kt */
/* JADX INFO: loaded from: classes4.dex */
public interface GetAdRequest {

    /* JADX INFO: compiled from: GetAdRequest.kt */
    public static final class DefaultImpls {
        public static /* synthetic */ Object invoke$default(GetAdRequest getAdRequest, String str, ByteString byteString, AdRequestOuterClass.BannerSize bannerSize, z8.d dVar, int i10, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: invoke");
            }
            if ((i10 & 4) != 0) {
                bannerSize = null;
            }
            return getAdRequest.invoke(str, byteString, bannerSize, dVar);
        }
    }

    @Nullable
    Object invoke(@NotNull String str, @NotNull ByteString byteString, @Nullable AdRequestOuterClass.BannerSize bannerSize, @NotNull z8.d<? super UniversalRequestOuterClass.UniversalRequest> dVar);
}
