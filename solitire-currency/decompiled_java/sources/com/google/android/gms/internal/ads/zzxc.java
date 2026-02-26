package com.google.android.gms.internal.ads;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.media3.exoplayer.RendererCapabilities;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzxc extends zzxp implements Comparable {
    private final int zze;
    private final boolean zzf;

    @Nullable
    private final String zzg;
    private final zzxi zzh;
    private final boolean zzi;
    private final int zzj;
    private final int zzk;
    private final int zzl;
    private final boolean zzm;
    private final int zzn;
    private final int zzo;
    private final boolean zzp;
    private final int zzq;
    private final int zzr;
    private final int zzs;
    private final int zzt;
    private final boolean zzu;
    private final boolean zzv;

    /* JADX WARN: Multi-variable type inference failed */
    public zzxc(int i10, zzcd zzcdVar, int i11, zzxi zzxiVar, int i12, boolean z10, zzfuv zzfuvVar, int i13) {
        int i14;
        int iZzc;
        int iZzc2;
        boolean z11;
        super(i10, zzcdVar, i11);
        this.zzh = zzxiVar;
        int i15 = 1;
        int i16 = true != zzxiVar.zzL ? 16 : 24;
        this.zzg = zzxt.zzh(this.zzd.zzd);
        this.zzi = zzlf.zza(i12, false);
        int i17 = 0;
        while (true) {
            i14 = Integer.MAX_VALUE;
            if (i17 >= zzxiVar.zzn.size()) {
                iZzc = 0;
                i17 = Integer.MAX_VALUE;
                break;
            } else {
                iZzc = zzxt.zzc(this.zzd, (String) zzxiVar.zzn.get(i17), false);
                if (iZzc > 0) {
                    break;
                } else {
                    i17++;
                }
            }
        }
        this.zzk = i17;
        this.zzj = iZzc;
        this.zzl = zzxt.zzb(this.zzd.zzf, 0);
        zzaf zzafVar = this.zzd;
        int i18 = zzafVar.zzf;
        this.zzm = i18 == 0 || (i18 & 1) != 0;
        this.zzp = 1 == (zzafVar.zze & 1);
        this.zzq = zzafVar.zzz;
        this.zzr = zzafVar.zzA;
        this.zzs = zzafVar.zzi;
        this.zzf = zzfuvVar.zza(zzafVar);
        Configuration configuration = Resources.getSystem().getConfiguration();
        String[] strArrSplit = zzet.zza >= 24 ? configuration.getLocales().toLanguageTags().split(",", -1) : new String[]{configuration.locale.toLanguageTag()};
        for (int i19 = 0; i19 < strArrSplit.length; i19++) {
            strArrSplit[i19] = zzet.zzD(strArrSplit[i19]);
        }
        int i20 = 0;
        while (true) {
            if (i20 >= strArrSplit.length) {
                iZzc2 = 0;
                i20 = Integer.MAX_VALUE;
                break;
            } else {
                iZzc2 = zzxt.zzc(this.zzd, strArrSplit[i20], false);
                if (iZzc2 > 0) {
                    break;
                } else {
                    i20++;
                }
            }
        }
        this.zzn = i20;
        this.zzo = iZzc2;
        int i21 = 0;
        while (true) {
            if (i21 >= zzxiVar.zzr.size()) {
                break;
            }
            String str = this.zzd.zzm;
            if (str != null && str.equals(zzxiVar.zzr.get(i21))) {
                i14 = i21;
                break;
            }
            i21++;
        }
        this.zzt = i14;
        this.zzu = (i12 & RendererCapabilities.DECODER_SUPPORT_MASK) == 128;
        this.zzv = (i12 & 64) == 64;
        zzxi zzxiVar2 = this.zzh;
        if (!zzlf.zza(i12, zzxiVar2.zzN) || (!(z11 = this.zzf) && !zzxiVar2.zzG)) {
            i15 = 0;
        } else if (zzlf.zza(i12, false) && z11 && this.zzd.zzi != -1 && ((zzxiVar2.zzP || !z10) && (i16 & i12) != 0)) {
            i15 = 2;
        }
        this.zze = i15;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final int compareTo(zzxc zzxcVar) {
        zzfzc zzfzcVarZza = (this.zzf && this.zzi) ? zzxt.zzb : zzxt.zzb.zza();
        zzfxg zzfxgVarZzc = zzfxg.zzj().zzd(this.zzi, zzxcVar.zzi).zzc(Integer.valueOf(this.zzk), Integer.valueOf(zzxcVar.zzk), zzfzc.zzc().zza()).zzb(this.zzj, zzxcVar.zzj).zzb(this.zzl, zzxcVar.zzl).zzd(this.zzp, zzxcVar.zzp).zzd(this.zzm, zzxcVar.zzm).zzc(Integer.valueOf(this.zzn), Integer.valueOf(zzxcVar.zzn), zzfzc.zzc().zza()).zzb(this.zzo, zzxcVar.zzo).zzd(this.zzf, zzxcVar.zzf).zzc(Integer.valueOf(this.zzt), Integer.valueOf(zzxcVar.zzt), zzfzc.zzc().zza());
        boolean z10 = this.zzh.zzy;
        zzfxg zzfxgVarZzc2 = zzfxgVarZzc.zzd(this.zzu, zzxcVar.zzu).zzd(this.zzv, zzxcVar.zzv).zzc(Integer.valueOf(this.zzq), Integer.valueOf(zzxcVar.zzq), zzfzcVarZza).zzc(Integer.valueOf(this.zzr), Integer.valueOf(zzxcVar.zzr), zzfzcVarZza);
        if (zzet.zzG(this.zzg, zzxcVar.zzg)) {
            zzfxgVarZzc2 = zzfxgVarZzc2.zzc(Integer.valueOf(this.zzs), Integer.valueOf(zzxcVar.zzs), zzfzcVarZza);
        }
        return zzfxgVarZzc2.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzxp
    public final int zzb() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.ads.zzxp
    public final /* bridge */ /* synthetic */ boolean zzc(zzxp zzxpVar) {
        String str;
        zzxc zzxcVar = (zzxc) zzxpVar;
        boolean z10 = this.zzh.zzJ;
        zzaf zzafVar = this.zzd;
        int i10 = zzafVar.zzz;
        if (i10 == -1) {
            return false;
        }
        zzaf zzafVar2 = zzxcVar.zzd;
        if (i10 != zzafVar2.zzz || (str = zzafVar.zzm) == null || !TextUtils.equals(str, zzafVar2.zzm)) {
            return false;
        }
        boolean z11 = this.zzh.zzI;
        int i11 = this.zzd.zzA;
        return i11 != -1 && i11 == zzxcVar.zzd.zzA && this.zzu == zzxcVar.zzu && this.zzv == zzxcVar.zzv;
    }
}
