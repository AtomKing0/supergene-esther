package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import androidx.media3.common.C;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzkh {
    public final zzug zza;
    public final Object zzb;
    public final zzvx[] zzc;
    public boolean zzd;
    public boolean zze;
    public zzki zzf;
    public boolean zzg;
    private final boolean[] zzh;
    private final zzlh[] zzi;
    private final zzyb zzj;
    private final zzkw zzk;

    @Nullable
    private zzkh zzl;
    private zzwi zzm;
    private zzyc zzn;
    private long zzo;

    public zzkh(zzlh[] zzlhVarArr, long j10, zzyb zzybVar, zzyk zzykVar, zzkw zzkwVar, zzki zzkiVar, zzyc zzycVar) {
        this.zzi = zzlhVarArr;
        this.zzo = j10;
        this.zzj = zzybVar;
        this.zzk = zzkwVar;
        zzui zzuiVar = zzkiVar.zza;
        this.zzb = zzuiVar.zza;
        this.zzf = zzkiVar;
        this.zzm = zzwi.zza;
        this.zzn = zzycVar;
        this.zzc = new zzvx[2];
        this.zzh = new boolean[2];
        long j11 = zzkiVar.zzb;
        long j12 = zzkiVar.zzd;
        zzug zzugVarZzp = zzkwVar.zzp(zzuiVar, zzykVar, j11);
        this.zza = j12 != C.TIME_UNSET ? new zztm(zzugVarZzp, true, 0L, j12) : zzugVarZzp;
    }

    private final void zzs() {
        if (!zzu()) {
            return;
        }
        int i10 = 0;
        while (true) {
            zzyc zzycVar = this.zzn;
            if (i10 >= zzycVar.zza) {
                return;
            }
            zzycVar.zzb(i10);
            zzxv zzxvVar = this.zzn.zzc[i10];
            i10++;
        }
    }

    private final void zzt() {
        if (!zzu()) {
            return;
        }
        int i10 = 0;
        while (true) {
            zzyc zzycVar = this.zzn;
            if (i10 >= zzycVar.zza) {
                return;
            }
            zzycVar.zzb(i10);
            zzxv zzxvVar = this.zzn.zzc[i10];
            i10++;
        }
    }

    private final boolean zzu() {
        return this.zzl == null;
    }

    public final long zza(zzyc zzycVar, long j10, boolean z10) {
        return zzb(zzycVar, j10, false, new boolean[2]);
    }

    public final long zzb(zzyc zzycVar, long j10, boolean z10, boolean[] zArr) {
        int i10 = 0;
        while (true) {
            boolean z11 = true;
            if (i10 >= zzycVar.zza) {
                break;
            }
            boolean[] zArr2 = this.zzh;
            if (z10 || !zzycVar.zza(this.zzn, i10)) {
                z11 = false;
            }
            zArr2[i10] = z11;
            i10++;
        }
        int i11 = 0;
        while (true) {
            zzlh[] zzlhVarArr = this.zzi;
            if (i11 >= 2) {
                break;
            }
            zzlhVarArr[i11].zzb();
            i11++;
        }
        zzs();
        this.zzn = zzycVar;
        zzt();
        long jZzg = this.zza.zzg(zzycVar.zzc, this.zzh, this.zzc, zArr, j10);
        int i12 = 0;
        while (true) {
            zzlh[] zzlhVarArr2 = this.zzi;
            if (i12 >= 2) {
                break;
            }
            zzlhVarArr2[i12].zzb();
            i12++;
        }
        this.zze = false;
        int i13 = 0;
        while (true) {
            zzvx[] zzvxVarArr = this.zzc;
            if (i13 >= 2) {
                return jZzg;
            }
            if (zzvxVarArr[i13] != null) {
                zzdi.zzf(zzycVar.zzb(i13));
                this.zzi[i13].zzb();
                this.zze = true;
            } else {
                zzdi.zzf(zzycVar.zzc[i13] == null);
            }
            i13++;
        }
    }

    public final long zzc() {
        if (!this.zzd) {
            return this.zzf.zzb;
        }
        long jZzb = this.zze ? this.zza.zzb() : Long.MIN_VALUE;
        return jZzb == Long.MIN_VALUE ? this.zzf.zze : jZzb;
    }

    public final long zzd() {
        if (this.zzd) {
            return this.zza.zzc();
        }
        return 0L;
    }

    public final long zze() {
        return this.zzo;
    }

    public final long zzf() {
        return this.zzf.zzb + this.zzo;
    }

    @Nullable
    public final zzkh zzg() {
        return this.zzl;
    }

    public final zzwi zzh() {
        return this.zzm;
    }

    public final zzyc zzi() {
        return this.zzn;
    }

    public final zzyc zzj(float f10, zzcc zzccVar) throws zzhw {
        zzyc zzycVarZzo = this.zzj.zzo(this.zzi, this.zzm, this.zzf.zza, zzccVar);
        for (zzxv zzxvVar : zzycVarZzo.zzc) {
        }
        return zzycVarZzo;
    }

    public final void zzk(long j10, float f10, long j11) {
        zzdi.zzf(zzu());
        long j12 = j10 - this.zzo;
        zzkd zzkdVar = new zzkd();
        zzkdVar.zze(j12);
        zzkdVar.zzf(f10);
        zzkdVar.zzd(j11);
        this.zza.zzo(new zzkf(zzkdVar, null));
    }

    public final void zzl(float f10, zzcc zzccVar) throws zzhw {
        this.zzd = true;
        this.zzm = this.zza.zzi();
        zzyc zzycVarZzj = zzj(f10, zzccVar);
        zzki zzkiVar = this.zzf;
        long jMax = zzkiVar.zzb;
        long j10 = zzkiVar.zze;
        if (j10 != C.TIME_UNSET && jMax >= j10) {
            jMax = Math.max(0L, j10 - 1);
        }
        long jZza = zza(zzycVarZzj, jMax, false);
        long j11 = this.zzo;
        zzki zzkiVar2 = this.zzf;
        this.zzo = j11 + (zzkiVar2.zzb - jZza);
        this.zzf = zzkiVar2.zzb(jZza);
    }

    public final void zzm(long j10) {
        zzdi.zzf(zzu());
        if (this.zzd) {
            this.zza.zzm(j10 - this.zzo);
        }
    }

    public final void zzn() {
        zzs();
        zzug zzugVar = this.zza;
        try {
            boolean z10 = zzugVar instanceof zztm;
            zzkw zzkwVar = this.zzk;
            if (z10) {
                zzkwVar.zzi(((zztm) zzugVar).zza);
            } else {
                zzkwVar.zzi(zzugVar);
            }
        } catch (RuntimeException e10) {
            zzea.zzd("MediaPeriodHolder", "Period release failed.", e10);
        }
    }

    public final void zzo(@Nullable zzkh zzkhVar) {
        if (zzkhVar == this.zzl) {
            return;
        }
        zzs();
        this.zzl = zzkhVar;
        zzt();
    }

    public final void zzp(long j10) {
        this.zzo = j10;
    }

    public final void zzq() {
        zzug zzugVar = this.zza;
        if (zzugVar instanceof zztm) {
            long j10 = this.zzf.zzd;
            if (j10 == C.TIME_UNSET) {
                j10 = Long.MIN_VALUE;
            }
            ((zztm) zzugVar).zzn(0L, j10);
        }
    }

    public final boolean zzr() {
        if (this.zzd) {
            return !this.zze || this.zza.zzb() == Long.MIN_VALUE;
        }
        return false;
    }
}
