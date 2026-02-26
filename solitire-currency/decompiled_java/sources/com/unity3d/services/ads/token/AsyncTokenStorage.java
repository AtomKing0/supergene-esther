package com.unity3d.services.ads.token;

import com.unity3d.services.ads.gmascar.managers.IBiddingManager;
import com.unity3d.services.core.configuration.Configuration;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: AsyncTokenStorage.kt */
/* JADX INFO: loaded from: classes4.dex */
public interface AsyncTokenStorage {
    void getToken(@Nullable IBiddingManager iBiddingManager);

    void onTokenAvailable();

    void setConfiguration(@Nullable Configuration configuration);
}
