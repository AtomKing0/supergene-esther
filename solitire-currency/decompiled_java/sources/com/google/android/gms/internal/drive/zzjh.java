package com.google.android.gms.internal.drive;

/* JADX INFO: loaded from: classes3.dex */
final class zzjh extends zzjm {
    private final int zznv;
    private final int zznw;

    zzjh(byte[] bArr, int i10, int i11) {
        super(bArr);
        zzjc.zzb(i10, i10 + i11, bArr.length);
        this.zznv = i10;
        this.zznw = i11;
    }

    @Override // com.google.android.gms.internal.drive.zzjm, com.google.android.gms.internal.drive.zzjc
    public final int size() {
        return this.zznw;
    }

    @Override // com.google.android.gms.internal.drive.zzjm
    protected final int zzbw() {
        return this.zznv;
    }

    @Override // com.google.android.gms.internal.drive.zzjm, com.google.android.gms.internal.drive.zzjc
    public final byte zzs(int i10) {
        int size = size();
        if (((size - (i10 + 1)) | i10) >= 0) {
            return this.zzny[this.zznv + i10];
        }
        if (i10 < 0) {
            StringBuilder sb = new StringBuilder(22);
            sb.append("Index < 0: ");
            sb.append(i10);
            throw new ArrayIndexOutOfBoundsException(sb.toString());
        }
        StringBuilder sb2 = new StringBuilder(40);
        sb2.append("Index > length: ");
        sb2.append(i10);
        sb2.append(", ");
        sb2.append(size);
        throw new ArrayIndexOutOfBoundsException(sb2.toString());
    }

    @Override // com.google.android.gms.internal.drive.zzjm, com.google.android.gms.internal.drive.zzjc
    final byte zzt(int i10) {
        return this.zzny[this.zznv + i10];
    }
}
