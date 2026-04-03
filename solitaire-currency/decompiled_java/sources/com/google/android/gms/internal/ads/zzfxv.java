package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzfxv extends zzfxk {
    Object[] zzd;
    private int zze;

    public zzfxv() {
        super(4);
    }

    @Override // com.google.android.gms.internal.ads.zzfxk, com.google.android.gms.internal.ads.zzfxl
    public final /* bridge */ /* synthetic */ zzfxl zzb(Object obj) {
        zzf(obj);
        return this;
    }

    public final zzfxv zzf(Object obj) {
        obj.getClass();
        if (this.zzd != null) {
            int iZzh = zzfxw.zzh(this.zzb);
            Object[] objArr = this.zzd;
            if (iZzh <= objArr.length) {
                int length = objArr.length - 1;
                int iHashCode = obj.hashCode();
                int iZza = zzfxj.zza(iHashCode);
                while (true) {
                    int i10 = iZza & length;
                    Object[] objArr2 = this.zzd;
                    Object obj2 = objArr2[i10];
                    if (obj2 != null) {
                        if (obj2.equals(obj)) {
                            break;
                        }
                        iZza = i10 + 1;
                    } else {
                        objArr2[i10] = obj;
                        this.zze += iHashCode;
                        super.zza(obj);
                        break;
                    }
                }
                return this;
            }
        }
        this.zzd = null;
        super.zza(obj);
        return this;
    }

    public final zzfxv zzg(Object... objArr) {
        if (this.zzd != null) {
            for (int i10 = 0; i10 < 2; i10++) {
                zzf(objArr[i10]);
            }
        } else {
            zzd(objArr, 2);
        }
        return this;
    }

    public final zzfxv zzh(Iterable iterable) {
        iterable.getClass();
        if (this.zzd != null) {
            Iterator it = iterable.iterator();
            while (it.hasNext()) {
                zzf(it.next());
            }
        } else {
            super.zzc(iterable);
        }
        return this;
    }

    public final zzfxw zzi() {
        zzfxw zzfxwVarZzv;
        int i10 = this.zzb;
        if (i10 == 0) {
            return zzfzj.zza;
        }
        if (i10 == 1) {
            Object obj = this.zza[0];
            Objects.requireNonNull(obj);
            return new zzfzu(obj);
        }
        if (this.zzd == null || zzfxw.zzh(i10) != this.zzd.length) {
            zzfxwVarZzv = zzfxw.zzv(this.zzb, this.zza);
            this.zzb = zzfxwVarZzv.size();
        } else {
            int i11 = this.zzb;
            Object[] objArrCopyOf = this.zza;
            if (zzfxw.zzw(i11, objArrCopyOf.length)) {
                objArrCopyOf = Arrays.copyOf(objArrCopyOf, i11);
            }
            zzfxwVarZzv = new zzfzj(objArrCopyOf, this.zze, this.zzd, r6.length - 1, this.zzb);
        }
        this.zzc = true;
        this.zzd = null;
        return zzfxwVarZzv;
    }

    zzfxv(int i10) {
        super(i10);
        this.zzd = new Object[zzfxw.zzh(i10)];
    }
}
