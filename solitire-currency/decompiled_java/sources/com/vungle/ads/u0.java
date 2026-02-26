package com.vungle.ads;

import com.vungle.ads.internal.protos.Sdk$SDKError;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: VungleError.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class u0 extends b2 {
    /* JADX WARN: Multi-variable type inference failed */
    public u0() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public /* synthetic */ u0(String str, int i10, kotlin.jvm.internal.k kVar) {
        this((i10 & 1) != 0 ? null : str);
    }

    public u0(@Nullable String str) {
        super(130, Sdk$SDKError.b.MRAID_DOWNLOAD_JS_ERROR, str, null, null, null, 56, null);
    }
}
