package com.king.usdk.popupwebview;

import androidx.annotation.Keep;

/* JADX INFO: loaded from: classes4.dex */
@Keep
public interface ILoadingListener {
    void onBackButtonPressed();

    void onPageError(String str);

    void onPageLoaded(String str);
}
