package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzeq {
    private long[] zza;
    private Object[] zzb;
    private int zzc;
    private int zzd;

    public zzeq() {
        throw null;
    }

    @Nullable
    private final Object zzf() {
        zzdi.zzf(this.zzd > 0);
        Object[] objArr = this.zzb;
        int i10 = this.zzc;
        Object obj = objArr[i10];
        objArr[i10] = null;
        this.zzc = (i10 + 1) % objArr.length;
        this.zzd--;
        return obj;
    }

    public final synchronized int zza() {
        return this.zzd;
    }

    @Nullable
    public final synchronized Object zzb() {
        if (this.zzd == 0) {
            return null;
        }
        return zzf();
    }

    @Nullable
    public final synchronized Object zzc(long j10) {
        Object objZzf;
        objZzf = null;
        while (this.zzd > 0 && j10 - this.zza[this.zzc] >= 0) {
            objZzf = zzf();
        }
        return objZzf;
    }

    public final synchronized void zzd(long j10, Object obj) {
        if (this.zzd > 0) {
            if (j10 <= this.zza[((this.zzc + r0) - 1) % this.zzb.length]) {
                zze();
            }
        }
        int length = this.zzb.length;
        if (this.zzd >= length) {
            int i10 = length + length;
            long[] jArr = new long[i10];
            Object[] objArr = new Object[i10];
            int i11 = this.zzc;
            int i12 = length - i11;
            System.arraycopy(this.zza, i11, jArr, 0, i12);
            System.arraycopy(this.zzb, this.zzc, objArr, 0, i12);
            int i13 = this.zzc;
            if (i13 > 0) {
                System.arraycopy(this.zza, 0, jArr, i12, i13);
                System.arraycopy(this.zzb, 0, objArr, i12, this.zzc);
            }
            this.zza = jArr;
            this.zzb = objArr;
            this.zzc = 0;
        }
        int i14 = this.zzc;
        int i15 = this.zzd;
        Object[] objArr2 = this.zzb;
        int length2 = (i14 + i15) % objArr2.length;
        this.zza[length2] = j10;
        objArr2[length2] = obj;
        this.zzd = i15 + 1;
    }

    public final synchronized void zze() {
        this.zzc = 0;
        this.zzd = 0;
        Arrays.fill(this.zzb, (Object) null);
    }

    public zzeq(int i10) {
        this.zza = new long[10];
        this.zzb = new Object[10];
    }
}
