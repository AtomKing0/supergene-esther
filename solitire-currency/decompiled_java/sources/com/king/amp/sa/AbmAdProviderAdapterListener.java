package com.king.amp.sa;

import androidx.annotation.Keep;

/* JADX INFO: loaded from: classes4.dex */
@Keep
public interface AbmAdProviderAdapterListener {
    void logBreadcrumb(String str, String str2);

    void onSDKInitFailed(String str);

    void onSDKInitSucceeded();

    void onSDKInitialized(boolean z10, String str);
}
