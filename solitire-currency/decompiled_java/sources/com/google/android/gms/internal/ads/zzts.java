package com.google.android.gms.internal.ads;

import androidx.media3.common.C;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzts implements zzvz {
    private final zzfxr zza;
    private long zzb;

    public zzts(List list, List list2) {
        zzfxo zzfxoVar = new zzfxo();
        zzdi.zzd(list.size() == list2.size());
        for (int i10 = 0; i10 < list.size(); i10++) {
            zzfxoVar.zzf(new zztr((zzvz) list.get(i10), (List) list2.get(i10)));
        }
        this.zza = zzfxoVar.zzi();
        this.zzb = C.TIME_UNSET;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.ads.zzvz
    public final long zzb() {
        long jMin = Long.MAX_VALUE;
        long jMin2 = Long.MAX_VALUE;
        for (int i10 = 0; i10 < this.zza.size(); i10++) {
            zztr zztrVar = (zztr) this.zza.get(i10);
            long jZzb = zztrVar.zzb();
            if ((zztrVar.zza().contains(1) || zztrVar.zza().contains(2) || zztrVar.zza().contains(4)) && jZzb != Long.MIN_VALUE) {
                jMin = Math.min(jMin, jZzb);
            }
            if (jZzb != Long.MIN_VALUE) {
                jMin2 = Math.min(jMin2, jZzb);
            }
        }
        if (jMin != Long.MAX_VALUE) {
            this.zzb = jMin;
            return jMin;
        }
        if (jMin2 == Long.MAX_VALUE) {
            return Long.MIN_VALUE;
        }
        long j10 = this.zzb;
        return j10 != C.TIME_UNSET ? j10 : jMin2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.ads.zzvz
    public final long zzc() {
        long jMin = Long.MAX_VALUE;
        for (int i10 = 0; i10 < this.zza.size(); i10++) {
            long jZzc = ((zztr) this.zza.get(i10)).zzc();
            if (jZzc != Long.MIN_VALUE) {
                jMin = Math.min(jMin, jZzc);
            }
        }
        if (jMin == Long.MAX_VALUE) {
            return Long.MIN_VALUE;
        }
        return jMin;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.ads.zzvz
    public final void zzm(long j10) {
        for (int i10 = 0; i10 < this.zza.size(); i10++) {
            ((zztr) this.zza.get(i10)).zzm(j10);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.ads.zzvz
    public final boolean zzo(zzkf zzkfVar) {
        boolean zZzo;
        boolean z10 = false;
        do {
            long jZzc = zzc();
            if (jZzc == Long.MIN_VALUE) {
                break;
            }
            zZzo = false;
            for (int i10 = 0; i10 < this.zza.size(); i10++) {
                long jZzc2 = ((zztr) this.zza.get(i10)).zzc();
                boolean z11 = jZzc2 != Long.MIN_VALUE && jZzc2 <= zzkfVar.zza;
                if (jZzc2 == jZzc || z11) {
                    zZzo |= ((zztr) this.zza.get(i10)).zzo(zzkfVar);
                }
            }
            z10 |= zZzo;
        } while (zZzo);
        return z10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.ads.zzvz
    public final boolean zzp() {
        for (int i10 = 0; i10 < this.zza.size(); i10++) {
            if (((zztr) this.zza.get(i10)).zzp()) {
                return true;
            }
        }
        return false;
    }
}
