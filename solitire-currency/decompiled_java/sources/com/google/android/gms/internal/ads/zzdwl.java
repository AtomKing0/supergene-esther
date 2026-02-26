package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public class zzdwl extends Exception {
    private final int zza;

    public zzdwl(int i10) {
        this.zza = i10;
    }

    public final int zza() {
        return this.zza;
    }

    public zzdwl(int i10, String str) {
        super(str);
        this.zza = i10;
    }

    public zzdwl(int i10, String str, Throwable th) {
        super(str, th);
        this.zza = 1;
    }
}
