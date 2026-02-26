package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@21.6.1 */
/* JADX INFO: loaded from: classes3.dex */
final class zzio {
    private final zzja zza;
    private final byte[] zzb;

    public final zzij zza() {
        this.zza.zzb();
        return new zzit(this.zzb);
    }

    public final zzja zzb() {
        return this.zza;
    }

    private zzio(int i10) {
        byte[] bArr = new byte[i10];
        this.zzb = bArr;
        this.zza = zzja.zzb(bArr);
    }
}
