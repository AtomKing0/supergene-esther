package com.king.usdk.localnotification;

import androidx.annotation.Keep;

/* JADX INFO: loaded from: classes4.dex */
@Keep
public class LocalNotification {
    public String backgroundPath;
    public String deeplink;
    public String mediaPath;
    public String message;
    public int textColor;
    public String title;
    public String titleKey;
    public String trackingType;

    public LocalNotification() {
    }

    public LocalNotification(String str, String str2, String str3, String str4, String str5, String str6, String str7, int i10) {
        this.title = str;
        this.message = str2;
        this.trackingType = str3;
        this.titleKey = str4;
        this.deeplink = str5;
        this.mediaPath = str6;
        this.backgroundPath = str7;
        this.textColor = i10;
    }
}
