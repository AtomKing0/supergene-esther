package com.google.android.gms.internal.play_billing;

import java.util.Arrays;

/* JADX INFO: compiled from: com.android.billingclient:billing@@7.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzak {
    Object[] zza = new Object[8];
    int zzb = 0;
    zzaj zzc;

    public final zzak zza(Object obj, Object obj2) {
        int i10 = this.zzb + 1;
        Object[] objArr = this.zza;
        int length = objArr.length;
        int i11 = i10 + i10;
        if (i11 > length) {
            int i12 = length + (length >> 1) + 1;
            if (i12 < i11) {
                int iHighestOneBit = Integer.highestOneBit(i11 - 1);
                i12 = iHighestOneBit + iHighestOneBit;
            }
            if (i12 < 0) {
                i12 = Integer.MAX_VALUE;
            }
            this.zza = Arrays.copyOf(objArr, i12);
        }
        zzad.zza(obj, obj2);
        Object[] objArr2 = this.zza;
        int i13 = this.zzb;
        int i14 = i13 + i13;
        objArr2[i14] = obj;
        objArr2[i14 + 1] = obj2;
        this.zzb = i13 + 1;
        return this;
    }

    public final zzal zzb() {
        zzaj zzajVar = this.zzc;
        if (zzajVar != null) {
            throw zzajVar.zza();
        }
        zzat zzatVarZzg = zzat.zzg(this.zzb, this.zza, this);
        zzaj zzajVar2 = this.zzc;
        if (zzajVar2 == null) {
            return zzatVarZzg;
        }
        throw zzajVar2.zza();
    }
}
