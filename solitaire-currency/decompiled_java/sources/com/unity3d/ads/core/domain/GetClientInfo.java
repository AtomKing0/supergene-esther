package com.unity3d.ads.core.domain;

import gatewayprotocol.v1.ClientInfoOuterClass;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: GetClientInfo.kt */
/* JADX INFO: loaded from: classes4.dex */
public interface GetClientInfo {
    @NotNull
    ClientInfoOuterClass.ClientInfo invoke();
}
