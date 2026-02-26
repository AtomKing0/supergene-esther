package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzxn extends zzxp implements Comparable {
    private final int zze;
    private final boolean zzf;
    private final boolean zzg;
    private final boolean zzh;
    private final int zzi;
    private final int zzj;
    private final int zzk;
    private final int zzl;
    private final boolean zzm;

    /* JADX WARN: Multi-variable type inference failed */
    public zzxn(int i10, zzcd zzcdVar, int i11, zzxi zzxiVar, int i12, @Nullable String str) {
        int iZzc;
        super(i10, zzcdVar, i11);
        int i13 = 0;
        this.zzf = zzlf.zza(i12, false);
        int i14 = this.zzd.zze;
        int i15 = zzxiVar.zzv;
        this.zzg = 1 == (i14 & 1);
        this.zzh = (i14 & 2) != 0;
        zzfxr zzfxrVarZzn = zzxiVar.zzt.isEmpty() ? zzfxr.zzn("") : zzxiVar.zzt;
        int i16 = 0;
        while (true) {
            if (i16 >= zzfxrVarZzn.size()) {
                i16 = Integer.MAX_VALUE;
                iZzc = 0;
                break;
            } else {
                iZzc = zzxt.zzc(this.zzd, (String) zzfxrVarZzn.get(i16), false);
                if (iZzc > 0) {
                    break;
                } else {
                    i16++;
                }
            }
        }
        this.zzi = i16;
        this.zzj = iZzc;
        int iZzb = zzxt.zzb(this.zzd.zzf, zzxiVar.zzu);
        this.zzk = iZzb;
        this.zzm = (this.zzd.zzf & 1088) != 0;
        int iZzc2 = zzxt.zzc(this.zzd, str, zzxt.zzh(str) == null);
        this.zzl = iZzc2;
        boolean z10 = iZzc > 0 || (zzxiVar.zzt.isEmpty() && iZzb > 0) || this.zzg || (this.zzh && iZzc2 > 0);
        if (zzlf.zza(i12, zzxiVar.zzN) && z10) {
            i13 = 1;
        }
        this.zze = i13;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final int compareTo(zzxn zzxnVar) {
        zzfxg zzfxgVarZzb = zzfxg.zzj().zzd(this.zzf, zzxnVar.zzf).zzc(Integer.valueOf(this.zzi), Integer.valueOf(zzxnVar.zzi), zzfzc.zzc().zza()).zzb(this.zzj, zzxnVar.zzj).zzb(this.zzk, zzxnVar.zzk).zzd(this.zzg, zzxnVar.zzg).zzc(Boolean.valueOf(this.zzh), Boolean.valueOf(zzxnVar.zzh), this.zzj == 0 ? zzfzc.zzc() : zzfzc.zzc().zza()).zzb(this.zzl, zzxnVar.zzl);
        if (this.zzk == 0) {
            zzfxgVarZzb = zzfxgVarZzb.zze(this.zzm, zzxnVar.zzm);
        }
        return zzfxgVarZzb.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzxp
    public final int zzb() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.ads.zzxp
    public final /* bridge */ /* synthetic */ boolean zzc(zzxp zzxpVar) {
        return false;
    }
}
