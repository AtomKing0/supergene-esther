package com.king.usdk.kdid;

import androidx.annotation.Keep;
import com.ironsource.v8;

/* JADX INFO: loaded from: classes4.dex */
@Keep
public enum IntentField {
    KEY(v8.h.W),
    VALUE("value"),
    ACTION("action"),
    SENDER("sender"),
    TOKEN("token"),
    VERSION("version");

    private String value;

    IntentField(String str) {
        this.value = str;
    }

    public String getValue() {
        return this.value;
    }
}
