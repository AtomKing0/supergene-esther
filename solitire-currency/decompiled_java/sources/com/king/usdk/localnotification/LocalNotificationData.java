package com.king.usdk.localnotification;

import androidx.annotation.Keep;

/* JADX INFO: loaded from: classes4.dex */
@Keep
public class LocalNotificationData {
    public String activityClassName;
    public String backgroundPath;
    public String deeplink;
    public String mediaPath;
    public String message;
    public int notificationId;
    public int textColor;
    public String title;
    public String titleKey;
    public String trackingType;

    public LocalNotificationData(int i10, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i11) {
        this.notificationId = i10;
        this.activityClassName = str;
        this.title = str2;
        this.message = str3;
        this.trackingType = str4;
        this.titleKey = str5;
        this.deeplink = str6;
        this.mediaPath = str7;
        this.backgroundPath = str8;
        this.textColor = i11;
    }
}
