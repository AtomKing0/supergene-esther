package com.moloco.sdk.publisher;

import com.moloco.sdk.publisher.MolocoAdError;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public interface MolocoBidTokenListener {
    void onBidTokenResult(@NotNull String str, @Nullable MolocoAdError.ErrorType errorType);
}
