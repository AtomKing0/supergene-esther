package com.google.android.gms.internal.drive;

import com.google.android.gms.internal.drive.zzkk;

/* JADX INFO: loaded from: classes3.dex */
final class zzme implements zzlo {
    private final int flags;
    private final String info;
    private final Object[] zzue;
    private final zzlq zzuh;

    zzme(zzlq zzlqVar, String str, Object[] objArr) {
        this.zzuh = zzlqVar;
        this.info = str;
        this.zzue = objArr;
        char cCharAt = str.charAt(0);
        if (cCharAt < 55296) {
            this.flags = cCharAt;
            return;
        }
        int i10 = cCharAt & 8191;
        int i11 = 13;
        int i12 = 1;
        while (true) {
            int i13 = i12 + 1;
            char cCharAt2 = str.charAt(i12);
            if (cCharAt2 < 55296) {
                this.flags = i10 | (cCharAt2 << i11);
                return;
            } else {
                i10 |= (cCharAt2 & 8191) << i11;
                i11 += 13;
                i12 = i13;
            }
        }
    }

    @Override // com.google.android.gms.internal.drive.zzlo
    public final int zzec() {
        return (this.flags & 1) == 1 ? zzkk.zze.zzsf : zzkk.zze.zzsg;
    }

    @Override // com.google.android.gms.internal.drive.zzlo
    public final boolean zzed() {
        return (this.flags & 2) == 2;
    }

    @Override // com.google.android.gms.internal.drive.zzlo
    public final zzlq zzee() {
        return this.zzuh;
    }

    final String zzek() {
        return this.info;
    }

    final Object[] zzel() {
        return this.zzue;
    }
}
