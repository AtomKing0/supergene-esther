package com.vungle.ads;

import com.vungle.ads.internal.protos.Sdk$SDKError;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: VungleError.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class m1 extends b2 {
    /* JADX WARN: Multi-variable type inference failed */
    public m1() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public /* synthetic */ m1(String str, int i10, kotlin.jvm.internal.k kVar) {
        this((i10 & 1) != 0 ? null : str);
    }

    public m1(@Nullable String str) {
        super(3001, Sdk$SDKError.b.OUT_OF_MEMORY, str, null, null, null, 56, null);
    }
}
