package com.king.amp.sa;

import androidx.annotation.Keep;

/* JADX INFO: loaded from: classes4.dex */
@Keep
class UUID {
    UUID() {
    }

    public String getUUID() {
        return java.util.UUID.randomUUID().toString();
    }
}
