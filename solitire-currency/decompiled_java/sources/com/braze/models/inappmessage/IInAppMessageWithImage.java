package com.braze.models.inappmessage;

import android.graphics.Bitmap;

/* JADX INFO: loaded from: classes2.dex */
public interface IInAppMessageWithImage {
    Bitmap getBitmap();

    String getLocalImageUrl();

    String getRemoteImageUrl();

    void setBitmap(Bitmap bitmap);

    void setImageDownloadSuccessful(boolean z10);

    void setLocalImageUrl(String str);
}
