package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@21.6.1 */
/* JADX INFO: loaded from: classes3.dex */
abstract class zznf {
    zznf() {
    }

    abstract int zza(int i10, byte[] bArr, int i11, int i12);

    abstract int zza(String str, byte[] bArr, int i10, int i11);

    abstract String zza(byte[] bArr, int i10, int i11) throws zzkb;

    final boolean zzb(byte[] bArr, int i10, int i11) {
        return zza(0, bArr, i10, i11) == 0;
    }
}
