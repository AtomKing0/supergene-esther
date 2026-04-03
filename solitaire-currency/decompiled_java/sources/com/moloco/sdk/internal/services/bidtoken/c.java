package com.moloco.sdk.internal.services.bidtoken;

/* JADX INFO: loaded from: classes4.dex */
public enum c {
    NEEDS_REFRESH,
    EXPIRING,
    NO_REFRESH_NEEDED;

    public final boolean c() {
        return this == EXPIRING || this == NO_REFRESH_NEEDED;
    }
}
