package com.braze.models.inappmessage;

/* JADX INFO: loaded from: classes2.dex */
public interface IInAppMessageHtml extends IInAppMessage {
    String getLocalAssetsDirectoryUrl();

    boolean logButtonClick(String str);

    void setLocalAssetsDirectoryUrl(String str);
}
