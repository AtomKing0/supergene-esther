package com.vungle.ads;

import com.vungle.ads.internal.protos.Sdk$SDKError;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: VungleError.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class x1 extends b2 {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x1(@NotNull String url) {
        super(137, Sdk$SDKError.b.TPAT_RETRY_FAILED, "Pinging Tpat did not succeed during all allowed reries. Failed url is " + url, null, null, null, 56, null);
        kotlin.jvm.internal.t.i(url, "url");
    }
}
