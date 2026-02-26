package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@21.6.1 */
/* JADX INFO: loaded from: classes3.dex */
final class zzin extends zzit {
    private final int zzc;
    private final int zzd;

    zzin(byte[] bArr, int i10, int i11) {
        super(bArr);
        zzij.zza(i10, i10 + i11, bArr.length);
        this.zzc = i10;
        this.zzd = i11;
    }

    @Override // com.google.android.gms.internal.measurement.zzit, com.google.android.gms.internal.measurement.zzij
    public final byte zza(int i10) {
        int iZzb = zzb();
        if (((iZzb - (i10 + 1)) | i10) >= 0) {
            return this.zzb[this.zzc + i10];
        }
        if (i10 < 0) {
            throw new ArrayIndexOutOfBoundsException("Index < 0: " + i10);
        }
        throw new ArrayIndexOutOfBoundsException("Index > length: " + i10 + ", " + iZzb);
    }

    @Override // com.google.android.gms.internal.measurement.zzit, com.google.android.gms.internal.measurement.zzij
    final byte zzb(int i10) {
        return this.zzb[this.zzc + i10];
    }

    @Override // com.google.android.gms.internal.measurement.zzit
    protected final int zze() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.measurement.zzit, com.google.android.gms.internal.measurement.zzij
    public final int zzb() {
        return this.zzd;
    }
}
