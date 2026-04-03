package com.king.amp.sa;

import androidx.annotation.NonNull;

/* JADX INFO: compiled from: DownloadChunkConfig.java */
/* JADX INFO: loaded from: classes4.dex */
public class t0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final int f16956a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f16957b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f16958c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f16959d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f16960e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f16961f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f16962g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    a f16963h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    long f16964i = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    long f16965j = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final String f16966k = java.util.UUID.randomUUID().toString();

    /* JADX INFO: compiled from: DownloadChunkConfig.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f16967a = 15;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f16968b = 16000;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f16969c = 16000;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f16970d = 1;
    }

    t0(int i10, @NonNull String str, @NonNull String str2) {
        this.f16956a = i10;
        this.f16957b = str;
        this.f16958c = str2;
    }

    long a() {
        return this.f16962g - this.f16961f;
    }

    void b(@NonNull String str) {
        this.f16959d = str;
        this.f16960e = this.f16959d + ".download." + this.f16956a;
    }

    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != t0.class) {
            return false;
        }
        return ((t0) obj).f16966k.equals(this.f16966k);
    }

    public int hashCode() {
        return this.f16966k.hashCode();
    }

    @NonNull
    public String toString() {
        return "{ " + this.f16957b + ", " + this.f16961f + "-" + this.f16962g + ", " + this.f16958c + " }";
    }
}
