package com.king.usdk.popupguard;

import androidx.annotation.Keep;

/* JADX INFO: loaded from: classes4.dex */
@Keep
public interface IPopupDialog {
    @Keep
    boolean isWebviewEnabled();

    @Keep
    void showNativeDialog(String str, String str2, String str3, boolean z10, long j10);
}
