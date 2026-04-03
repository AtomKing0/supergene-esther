package com.applovin.impl.sdk.array;

import android.os.Bundle;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public interface ArrayDirectDownloadAd {
    Bundle getDirectDownloadParameters();

    @Nullable
    String getDirectDownloadToken();

    boolean isDirectDownloadEnabled();
}
