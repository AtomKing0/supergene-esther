package com.google.android.gms.internal.ads;

import com.king.amp.sa.AbmAdPlayer;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public enum zzflt {
    HTML(AbmAdPlayer.HTML),
    NATIVE("native"),
    JAVASCRIPT("javascript");

    private final String zze;

    zzflt(String str) {
        this.zze = str;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return this.zze;
    }
}
