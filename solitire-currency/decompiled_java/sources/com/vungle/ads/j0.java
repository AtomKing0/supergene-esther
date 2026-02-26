package com.vungle.ads;

import android.content.Context;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: BaseFullscreenAd.kt */
/* JADX INFO: loaded from: classes4.dex */
public abstract class j0 extends com.vungle.ads.internal.a {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j0(@NotNull Context context) {
        super(context);
        kotlin.jvm.internal.t.i(context, "context");
    }

    @Override // com.vungle.ads.internal.a
    @Nullable
    public z1 getAdSizeForAdRequest() {
        return null;
    }

    @Override // com.vungle.ads.internal.a
    public boolean isValidAdSize(@Nullable z1 z1Var) {
        return true;
    }
}
