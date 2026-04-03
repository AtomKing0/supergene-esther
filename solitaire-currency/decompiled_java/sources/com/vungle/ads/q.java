package com.vungle.ads;

import com.vungle.ads.internal.protos.Sdk$SDKError;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: VungleError.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class q extends b2 {
    public /* synthetic */ q(String str, Integer num, String str2, String str3, String str4, int i10, kotlin.jvm.internal.k kVar) {
        this(str, (i10 & 2) != 0 ? null : num, (i10 & 4) != 0 ? null : str2, (i10 & 8) != 0 ? null : str3, (i10 & 16) != 0 ? null : str4);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(@NotNull String url, @Nullable Integer num, @Nullable String str, @Nullable String str2, @Nullable String str3) {
        super(117, Sdk$SDKError.b.ASSET_FAILED_STATUS_CODE, "Asset fail to download: " + url + ", Error code:" + num + ", Error message: " + str3, str, str2, null, 32, null);
        kotlin.jvm.internal.t.i(url, "url");
    }
}
