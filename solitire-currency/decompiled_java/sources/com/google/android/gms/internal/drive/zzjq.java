package com.google.android.gms.internal.drive;

/* JADX INFO: loaded from: classes3.dex */
final class zzjq extends zzjo {
    private final byte[] buffer;
    private int limit;
    private int pos;
    private final boolean zzoc;
    private int zzod;
    private int zzoe;
    private int zzof;

    private zzjq(byte[] bArr, int i10, int i11, boolean z10) {
        super();
        this.zzof = Integer.MAX_VALUE;
        this.buffer = bArr;
        this.limit = i11 + i10;
        this.pos = i10;
        this.zzoe = i10;
        this.zzoc = z10;
    }

    @Override // com.google.android.gms.internal.drive.zzjo
    public final int zzbz() {
        return this.pos - this.zzoe;
    }

    @Override // com.google.android.gms.internal.drive.zzjo
    public final int zzv(int i10) throws zzkq {
        if (i10 < 0) {
            throw zzkq.zzdj();
        }
        int iZzbz = i10 + zzbz();
        int i11 = this.zzof;
        if (iZzbz > i11) {
            throw zzkq.zzdi();
        }
        this.zzof = iZzbz;
        int i12 = this.limit + this.zzod;
        this.limit = i12;
        int i13 = i12 - this.zzoe;
        if (i13 > iZzbz) {
            int i14 = i13 - iZzbz;
            this.zzod = i14;
            this.limit = i12 - i14;
        } else {
            this.zzod = 0;
        }
        return i11;
    }
}
