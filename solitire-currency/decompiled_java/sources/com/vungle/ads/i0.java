package com.vungle.ads;

import android.content.Context;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: BaseAd.kt */
/* JADX INFO: loaded from: classes4.dex */
public interface i0 extends a {
    @Override // com.vungle.ads.a
    @Nullable
    /* synthetic */ Boolean canPlayAd();

    /* synthetic */ void load(@Nullable String str);

    void play(@Nullable Context context);
}
