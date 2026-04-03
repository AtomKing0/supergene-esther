package com.google.android.gms.internal.play_billing;

/* JADX INFO: compiled from: com.android.billingclient:billing@@7.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzbj extends zzbn {
    private final int zzc;

    zzbj(byte[] bArr, int i10, int i11) {
        super(bArr);
        zzbq.zzj(0, i11, bArr.length);
        this.zzc = i11;
    }

    @Override // com.google.android.gms.internal.play_billing.zzbn, com.google.android.gms.internal.play_billing.zzbq
    public final byte zza(int i10) {
        int i11 = this.zzc;
        if (((i11 - (i10 + 1)) | i10) >= 0) {
            return this.zza[i10];
        }
        if (i10 < 0) {
            throw new ArrayIndexOutOfBoundsException("Index < 0: " + i10);
        }
        throw new ArrayIndexOutOfBoundsException("Index > length: " + i10 + ", " + i11);
    }

    @Override // com.google.android.gms.internal.play_billing.zzbn, com.google.android.gms.internal.play_billing.zzbq
    final byte zzb(int i10) {
        return this.zza[i10];
    }

    @Override // com.google.android.gms.internal.play_billing.zzbn
    protected final int zzc() {
        return 0;
    }

    @Override // com.google.android.gms.internal.play_billing.zzbn, com.google.android.gms.internal.play_billing.zzbq
    public final int zzd() {
        return this.zzc;
    }
}
