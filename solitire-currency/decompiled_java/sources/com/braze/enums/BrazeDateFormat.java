package com.braze.enums;

/* JADX INFO: loaded from: classes2.dex */
public enum BrazeDateFormat {
    SHORT("yyyy-MM-dd"),
    LONG("yyyy-MM-dd kk:mm:ss"),
    ANDROID_LOGCAT("MM-dd kk:mm:ss.SSS"),
    CLOCK_12_HOUR("h:mm a");

    private final String format;

    BrazeDateFormat(String str) {
        this.format = str;
    }

    public final String getFormat() {
        return this.format;
    }
}
