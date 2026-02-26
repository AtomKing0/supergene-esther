package com.king.amp.sa;

/* JADX INFO: compiled from: AbmAdProviderRewardedAdListener.java */
/* JADX INFO: loaded from: classes4.dex */
public interface p {
    void logBreadcrumb(String str, String str2);

    void onAdLoaded(AdProviderNameValuePairs adProviderNameValuePairs);

    void onAdMetaReceived(AdProviderNameValuePairs adProviderNameValuePairs);

    void onClosed(boolean z10);

    void onEndCardInfoClicked();

    void onLoadFailed(int i10, String str);

    void onPaidEvent(String str, String str2, int i10);

    void onPlayCompleted();

    void onShowFailed(int i10, String str);
}
