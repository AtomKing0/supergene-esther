package com.google.android.gms.internal.ads;

import androidx.media3.common.C;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzamy implements zzang {
    private zzaf zza;
    private zzer zzb;
    private zzadp zzc;

    public zzamy(String str) {
        zzad zzadVar = new zzad();
        zzadVar.zzX(str);
        this.zza = zzadVar.zzad();
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final void zza(zzek zzekVar) {
        zzdi.zzb(this.zzb);
        int i10 = zzet.zza;
        long jZze = this.zzb.zze();
        long jZzf = this.zzb.zzf();
        if (jZze == C.TIME_UNSET || jZzf == C.TIME_UNSET) {
            return;
        }
        zzaf zzafVar = this.zza;
        if (jZzf != zzafVar.zzq) {
            zzad zzadVarZzb = zzafVar.zzb();
            zzadVarZzb.zzab(jZzf);
            zzaf zzafVarZzad = zzadVarZzb.zzad();
            this.zza = zzafVarZzad;
            this.zzc.zzl(zzafVarZzad);
        }
        int iZzb = zzekVar.zzb();
        this.zzc.zzq(zzekVar, iZzb);
        this.zzc.zzs(jZze, 1, iZzb, 0, null);
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final void zzb(zzer zzerVar, zzacn zzacnVar, zzans zzansVar) {
        this.zzb = zzerVar;
        zzansVar.zzc();
        zzadp zzadpVarZzw = zzacnVar.zzw(zzansVar.zza(), 5);
        this.zzc = zzadpVarZzw;
        zzadpVarZzw.zzl(this.zza);
    }
}
