package com.unity3d.ads.core.domain.events;

import gatewayprotocol.v1.UniversalResponseOuterClass;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import z8.d;

/* JADX INFO: compiled from: HandleGatewayEventResponse.kt */
/* JADX INFO: loaded from: classes4.dex */
public interface HandleGatewayEventResponse {
    @Nullable
    Object invoke(@NotNull UniversalResponseOuterClass.UniversalResponse universalResponse, @NotNull d<? super k0> dVar);
}
