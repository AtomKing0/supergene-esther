package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.ironsource.v8;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzod {
    public static final zzod zza;
    public final int zzb;
    public final int zzc;

    @Nullable
    private final zzfxw zzd;

    static {
        zzod zzodVar;
        if (zzet.zza >= 33) {
            zzfxv zzfxvVar = new zzfxv();
            for (int i10 = 1; i10 <= 10; i10++) {
                zzfxvVar.zzf(Integer.valueOf(zzet.zzh(i10)));
            }
            zzodVar = new zzod(2, zzfxvVar.zzi());
        } else {
            zzodVar = new zzod(2, 10);
        }
        zza = zzodVar;
    }

    public zzod(int i10, int i11) {
        this.zzb = i10;
        this.zzc = i11;
        this.zzd = null;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzod)) {
            return false;
        }
        zzod zzodVar = (zzod) obj;
        return this.zzb == zzodVar.zzb && this.zzc == zzodVar.zzc && zzet.zzG(this.zzd, zzodVar.zzd);
    }

    public final int hashCode() {
        zzfxw zzfxwVar = this.zzd;
        return (((this.zzb * 31) + this.zzc) * 31) + (zzfxwVar == null ? 0 : zzfxwVar.hashCode());
    }

    public final String toString() {
        return "AudioProfile[format=" + this.zzb + ", maxChannelCount=" + this.zzc + ", channelMasks=" + String.valueOf(this.zzd) + v8.i.f15839e;
    }

    public final int zza(int i10, zzh zzhVar) {
        if (this.zzd != null) {
            return this.zzc;
        }
        if (zzet.zza >= 29) {
            return zzob.zza(this.zzb, i10, zzhVar);
        }
        Integer num = (Integer) zzof.zzb.getOrDefault(Integer.valueOf(this.zzb), 0);
        num.getClass();
        return num.intValue();
    }

    public final boolean zzb(int i10) {
        if (this.zzd == null) {
            return i10 <= this.zzc;
        }
        int iZzh = zzet.zzh(i10);
        if (iZzh == 0) {
            return false;
        }
        return this.zzd.contains(Integer.valueOf(iZzh));
    }

    @RequiresApi(33)
    public zzod(int i10, Set set) {
        this.zzb = i10;
        zzfxw zzfxwVarZzl = zzfxw.zzl(set);
        this.zzd = zzfxwVarZzl;
        zzfzx it = zzfxwVarZzl.iterator();
        int iMax = 0;
        while (it.hasNext()) {
            iMax = Math.max(iMax, Integer.bitCount(((Integer) it.next()).intValue()));
        }
        this.zzc = iMax;
    }
}
