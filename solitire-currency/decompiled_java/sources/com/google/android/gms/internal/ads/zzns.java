package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzns {
    final /* synthetic */ zznt zza;
    private final String zzb;
    private int zzc;
    private long zzd;
    private zzui zze;
    private boolean zzf;
    private boolean zzg;

    public zzns(zznt zzntVar, String str, @Nullable int i10, zzui zzuiVar) {
        this.zza = zzntVar;
        this.zzb = str;
        this.zzc = i10;
        this.zzd = zzuiVar == null ? -1L : zzuiVar.zzd;
        if (zzuiVar == null || !zzuiVar.zzb()) {
            return;
        }
        this.zze = zzuiVar;
    }

    public final void zzg(int i10, @Nullable zzui zzuiVar) {
        if (this.zzd == -1 && i10 == this.zzc && zzuiVar != null) {
            zznt zzntVar = this.zza;
            long j10 = zzuiVar.zzd;
            if (j10 >= zzntVar.zzl()) {
                this.zzd = j10;
            }
        }
    }

    public final boolean zzj(int i10, @Nullable zzui zzuiVar) {
        if (zzuiVar == null) {
            return i10 == this.zzc;
        }
        zzui zzuiVar2 = this.zze;
        return zzuiVar2 == null ? !zzuiVar.zzb() && zzuiVar.zzd == this.zzd : zzuiVar.zzd == zzuiVar2.zzd && zzuiVar.zzb == zzuiVar2.zzb && zzuiVar.zzc == zzuiVar2.zzc;
    }

    public final boolean zzk(zzlo zzloVar) {
        zzui zzuiVar = zzloVar.zzd;
        if (zzuiVar == null) {
            return this.zzc != zzloVar.zzc;
        }
        long j10 = this.zzd;
        if (j10 == -1) {
            return false;
        }
        if (zzuiVar.zzd > j10) {
            return true;
        }
        if (this.zze == null) {
            return false;
        }
        zzcc zzccVar = zzloVar.zzb;
        int iZza = zzccVar.zza(zzuiVar.zza);
        int iZza2 = zzccVar.zza(this.zze.zza);
        zzui zzuiVar2 = zzloVar.zzd;
        if (zzuiVar2.zzd < this.zze.zzd || iZza < iZza2) {
            return false;
        }
        if (iZza > iZza2) {
            return true;
        }
        if (!zzuiVar2.zzb()) {
            int i10 = zzloVar.zzd.zze;
            return i10 == -1 || i10 > this.zze.zzb;
        }
        zzui zzuiVar3 = zzloVar.zzd;
        int i11 = zzuiVar3.zzb;
        int i12 = zzuiVar3.zzc;
        zzui zzuiVar4 = this.zze;
        int i13 = zzuiVar4.zzb;
        if (i11 <= i13) {
            return i11 == i13 && i12 > zzuiVar4.zzc;
        }
        return true;
    }

    public final boolean zzl(zzcc zzccVar, zzcc zzccVar2) {
        int i10 = this.zzc;
        if (i10 < zzccVar.zzc()) {
            zzccVar.zze(i10, this.zza.zzc, 0L);
            for (int i11 = this.zza.zzc.zzn; i11 <= this.zza.zzc.zzo; i11++) {
                int iZza = zzccVar2.zza(zzccVar.zzf(i11));
                if (iZza != -1) {
                    i10 = zzccVar2.zzd(iZza, this.zza.zzd, false).zzc;
                    break;
                }
            }
            i10 = -1;
        } else if (i10 >= zzccVar2.zzc()) {
            i10 = -1;
        }
        this.zzc = i10;
        if (i10 == -1) {
            return false;
        }
        zzui zzuiVar = this.zze;
        return zzuiVar == null || zzccVar2.zza(zzuiVar.zza) != -1;
    }
}
