package com.king.usdk.kdid;

import androidx.annotation.Keep;

/* JADX INFO: loaded from: classes4.dex */
@Keep
public enum IntentActions {
    REQUEST_VALUE("com.king.analytics.REQUEST_VALUE"),
    RECEIVE_VALUE("com.king.analytics.RECEIVE_VALUE");

    private String value;

    IntentActions(String str) {
        this.value = str;
    }

    public String getValue() {
        return this.value;
    }
}
