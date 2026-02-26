package com.unity3d.ads.core.domain;

import com.google.protobuf.ByteString;
import gatewayprotocol.v1.UniversalRequestOuterClass;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: GetAdPlayerConfigRequest.kt */
/* JADX INFO: loaded from: classes4.dex */
public interface GetAdPlayerConfigRequest {
    @Nullable
    Object invoke(@NotNull String str, @NotNull ByteString byteString, @NotNull ByteString byteString2, @NotNull z8.d<? super UniversalRequestOuterClass.UniversalRequest> dVar);
}
