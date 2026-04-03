package com.iab.omid.library.ironsrc.adsession;

import io.sentry.protocol.Request;

/* JADX INFO: loaded from: classes4.dex */
public enum DeviceCategory {
    CTV("ctv"),
    MOBILE("mobile"),
    OTHER(Request.JsonKeys.OTHER);

    private final String deviceCategory;

    DeviceCategory(String str) {
        this.deviceCategory = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.deviceCategory;
    }
}
