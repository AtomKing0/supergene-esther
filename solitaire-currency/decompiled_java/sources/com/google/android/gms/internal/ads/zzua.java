package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import androidx.media3.common.C;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzua implements zzug, zzuf {
    public final zzui zza;
    private final long zzb;
    private zzuk zzc;
    private zzug zzd;

    @Nullable
    private zzuf zze;
    private long zzf = C.TIME_UNSET;
    private final zzyk zzg;

    public zzua(zzui zzuiVar, zzyk zzykVar, long j10) {
        this.zza = zzuiVar;
        this.zzg = zzykVar;
        this.zzb = j10;
    }

    private final long zzv(long j10) {
        long j11 = this.zzf;
        return j11 != C.TIME_UNSET ? j11 : j10;
    }

    @Override // com.google.android.gms.internal.ads.zzug
    public final long zza(long j10, zzlj zzljVar) {
        zzug zzugVar = this.zzd;
        int i10 = zzet.zza;
        return zzugVar.zza(j10, zzljVar);
    }

    @Override // com.google.android.gms.internal.ads.zzug, com.google.android.gms.internal.ads.zzvz
    public final long zzb() {
        zzug zzugVar = this.zzd;
        int i10 = zzet.zza;
        return zzugVar.zzb();
    }

    @Override // com.google.android.gms.internal.ads.zzug, com.google.android.gms.internal.ads.zzvz
    public final long zzc() {
        zzug zzugVar = this.zzd;
        int i10 = zzet.zza;
        return zzugVar.zzc();
    }

    @Override // com.google.android.gms.internal.ads.zzug
    public final long zzd() {
        zzug zzugVar = this.zzd;
        int i10 = zzet.zza;
        return zzugVar.zzd();
    }

    @Override // com.google.android.gms.internal.ads.zzug
    public final long zze(long j10) {
        zzug zzugVar = this.zzd;
        int i10 = zzet.zza;
        return zzugVar.zze(j10);
    }

    @Override // com.google.android.gms.internal.ads.zzvy
    public final /* bridge */ /* synthetic */ void zzf(zzvz zzvzVar) {
        zzuf zzufVar = this.zze;
        int i10 = zzet.zza;
        zzufVar.zzf(this);
    }

    @Override // com.google.android.gms.internal.ads.zzug
    public final long zzg(zzxv[] zzxvVarArr, boolean[] zArr, zzvx[] zzvxVarArr, boolean[] zArr2, long j10) {
        long j11 = this.zzf;
        long j12 = (j11 == C.TIME_UNSET || j10 != this.zzb) ? j10 : j11;
        this.zzf = C.TIME_UNSET;
        zzug zzugVar = this.zzd;
        int i10 = zzet.zza;
        return zzugVar.zzg(zzxvVarArr, zArr, zzvxVarArr, zArr2, j12);
    }

    @Override // com.google.android.gms.internal.ads.zzuf
    public final void zzh(zzug zzugVar) {
        zzuf zzufVar = this.zze;
        int i10 = zzet.zza;
        zzufVar.zzh(this);
    }

    @Override // com.google.android.gms.internal.ads.zzug
    public final zzwi zzi() {
        zzug zzugVar = this.zzd;
        int i10 = zzet.zza;
        return zzugVar.zzi();
    }

    @Override // com.google.android.gms.internal.ads.zzug
    public final void zzj(long j10, boolean z10) {
        zzug zzugVar = this.zzd;
        int i10 = zzet.zza;
        zzugVar.zzj(j10, false);
    }

    @Override // com.google.android.gms.internal.ads.zzug
    public final void zzk() throws IOException {
        try {
            zzug zzugVar = this.zzd;
            if (zzugVar != null) {
                zzugVar.zzk();
                return;
            }
            zzuk zzukVar = this.zzc;
            if (zzukVar != null) {
                zzukVar.zzz();
            }
        } catch (IOException e10) {
            throw e10;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzug
    public final void zzl(zzuf zzufVar, long j10) {
        this.zze = zzufVar;
        zzug zzugVar = this.zzd;
        if (zzugVar != null) {
            zzugVar.zzl(this, zzv(this.zzb));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzug, com.google.android.gms.internal.ads.zzvz
    public final void zzm(long j10) {
        zzug zzugVar = this.zzd;
        int i10 = zzet.zza;
        zzugVar.zzm(j10);
    }

    public final long zzn() {
        return this.zzf;
    }

    @Override // com.google.android.gms.internal.ads.zzug, com.google.android.gms.internal.ads.zzvz
    public final boolean zzo(zzkf zzkfVar) {
        zzug zzugVar = this.zzd;
        return zzugVar != null && zzugVar.zzo(zzkfVar);
    }

    @Override // com.google.android.gms.internal.ads.zzug, com.google.android.gms.internal.ads.zzvz
    public final boolean zzp() {
        zzug zzugVar = this.zzd;
        return zzugVar != null && zzugVar.zzp();
    }

    public final long zzq() {
        return this.zzb;
    }

    public final void zzr(zzui zzuiVar) {
        long jZzv = zzv(this.zzb);
        zzuk zzukVar = this.zzc;
        zzukVar.getClass();
        zzug zzugVarZzI = zzukVar.zzI(zzuiVar, this.zzg, jZzv);
        this.zzd = zzugVarZzI;
        if (this.zze != null) {
            zzugVarZzI.zzl(this, jZzv);
        }
    }

    public final void zzs(long j10) {
        this.zzf = j10;
    }

    public final void zzt() {
        zzug zzugVar = this.zzd;
        if (zzugVar != null) {
            zzuk zzukVar = this.zzc;
            zzukVar.getClass();
            zzukVar.zzG(zzugVar);
        }
    }

    public final void zzu(zzuk zzukVar) {
        zzdi.zzf(this.zzc == null);
        this.zzc = zzukVar;
    }
}
