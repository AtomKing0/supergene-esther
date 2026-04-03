package com.ironsource;

import androidx.media3.exoplayer.upstream.CmcdData;

/* JADX INFO: loaded from: classes4.dex */
public enum go {
    PER_DAY("d"),
    PER_HOUR(CmcdData.Factory.STREAMING_FORMAT_HLS);


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f12323a;

    go(String str) {
        this.f12323a = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.f12323a;
    }
}
