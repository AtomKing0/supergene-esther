package com.google.android.gms.internal.ads;

import io.sentry.protocol.Request;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public enum zzflw {
    CTV("ctv"),
    MOBILE("mobile"),
    OTHER(Request.JsonKeys.OTHER);

    private final String zze;

    zzflw(String str) {
        this.zze = str;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return this.zze;
    }
}
