package com.king.amp.sa;

import androidx.annotation.Keep;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes4.dex */
@Keep
public interface BidderTokenListener {
    void onBidderTokenCollected(@NonNull String str);

    void onBidderTokenCollectionFailed(@NonNull String str);
}
