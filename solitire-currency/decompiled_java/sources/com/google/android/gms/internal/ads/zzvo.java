package com.google.android.gms.internal.ads;

import android.os.Looper;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import androidx.media3.common.C;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzvo extends zzth implements zzvf {
    private final zzfr zza;
    private final zzri zzb;
    private final int zzc;
    private boolean zzd = true;
    private long zze = C.TIME_UNSET;
    private boolean zzf;
    private boolean zzg;

    @Nullable
    private zzgu zzh;

    @GuardedBy("this")
    private zzbc zzi;
    private final zzvl zzj;
    private final zzyo zzk;

    /* synthetic */ zzvo(zzbc zzbcVar, zzfr zzfrVar, zzvl zzvlVar, zzri zzriVar, zzyo zzyoVar, int i10, zzvn zzvnVar) {
        this.zzi = zzbcVar;
        this.zza = zzfrVar;
        this.zzj = zzvlVar;
        this.zzb = zzriVar;
        this.zzk = zzyoVar;
        this.zzc = i10;
    }

    private final void zzw() {
        long j10 = this.zze;
        boolean z10 = this.zzf;
        boolean z11 = this.zzg;
        zzbc zzbcVarZzJ = zzJ();
        zzwb zzwbVar = new zzwb(C.TIME_UNSET, C.TIME_UNSET, C.TIME_UNSET, j10, j10, 0L, 0L, z10, false, false, null, zzbcVarZzJ, z11 ? zzbcVarZzJ.zzc : null);
        zzo(this.zzd ? new zzvk(this, zzwbVar) : zzwbVar);
    }

    @Override // com.google.android.gms.internal.ads.zzuk
    public final void zzG(zzug zzugVar) {
        ((zzvj) zzugVar).zzN();
    }

    @Override // com.google.android.gms.internal.ads.zzuk
    public final zzug zzI(zzui zzuiVar, zzyk zzykVar, long j10) {
        zzfs zzfsVarZza = this.zza.zza();
        zzgu zzguVar = this.zzh;
        if (zzguVar != null) {
            zzfsVarZza.zzf(zzguVar);
        }
        zzax zzaxVar = zzJ().zzb;
        zzaxVar.getClass();
        zzvl zzvlVar = this.zzj;
        zzb();
        return new zzvj(zzaxVar.zza, zzfsVarZza, new zztk(zzvlVar.zza), this.zzb, zzc(zzuiVar), this.zzk, zze(zzuiVar), this, zzykVar, null, this.zzc, zzet.zzr(C.TIME_UNSET));
    }

    @Override // com.google.android.gms.internal.ads.zzuk
    public final synchronized zzbc zzJ() {
        return this.zzi;
    }

    @Override // com.google.android.gms.internal.ads.zzvf
    public final void zza(long j10, boolean z10, boolean z11) {
        if (j10 == C.TIME_UNSET) {
            j10 = this.zze;
        }
        if (!this.zzd && this.zze == j10 && this.zzf == z10 && this.zzg == z11) {
            return;
        }
        this.zze = j10;
        this.zzf = z10;
        this.zzg = z11;
        this.zzd = false;
        zzw();
    }

    @Override // com.google.android.gms.internal.ads.zzth
    protected final void zzn(@Nullable zzgu zzguVar) {
        this.zzh = zzguVar;
        Looper.myLooper().getClass();
        zzb();
        zzw();
    }

    @Override // com.google.android.gms.internal.ads.zzth, com.google.android.gms.internal.ads.zzuk
    public final synchronized void zzt(zzbc zzbcVar) {
        this.zzi = zzbcVar;
    }

    @Override // com.google.android.gms.internal.ads.zzth
    protected final void zzq() {
    }

    @Override // com.google.android.gms.internal.ads.zzuk
    public final void zzz() {
    }
}
