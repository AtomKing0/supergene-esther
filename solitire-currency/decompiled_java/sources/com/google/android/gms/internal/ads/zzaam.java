package com.google.android.gms.internal.ads;

import androidx.annotation.FloatRange;
import androidx.annotation.Nullable;
import androidx.media3.common.C;
import androidx.media3.common.MimeTypes;
import java.util.Iterator;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzaam {
    private final zzaah zza;

    @Nullable
    private zzcp zzf;
    private long zzh;
    private final zzzi zzj;
    private final zzaaf zzb = new zzaaf();
    private final zzeq zzc = new zzeq(10);
    private final zzeq zzd = new zzeq(10);
    private final zzec zze = new zzec(16);
    private zzcp zzg = zzcp.zza;
    private long zzi = C.TIME_UNSET;

    public zzaam(zzzi zzziVar, zzaah zzaahVar) {
        this.zzj = zzziVar;
        this.zza = zzaahVar;
    }

    private static Object zzf(zzeq zzeqVar) {
        zzdi.zzd(zzeqVar.zza() > 0);
        while (zzeqVar.zza() > 1) {
            zzeqVar.zzb();
        }
        Object objZzb = zzeqVar.zzb();
        objZzb.getClass();
        return objZzb;
    }

    public final void zza() {
        this.zze.zzc();
        this.zzi = C.TIME_UNSET;
        zzeq zzeqVar = this.zzd;
        if (zzeqVar.zza() > 0) {
            this.zzd.zzd(0L, Long.valueOf(((Long) zzf(zzeqVar)).longValue()));
        }
        if (this.zzf != null) {
            this.zzc.zze();
            return;
        }
        zzeq zzeqVar2 = this.zzc;
        if (zzeqVar2.zza() > 0) {
            this.zzf = (zzcp) zzf(zzeqVar2);
        }
    }

    public final void zzb(long j10, long j11) {
        this.zzd.zzd(j10, Long.valueOf(j11));
    }

    public final void zzc(long j10, long j11) throws zzhw {
        zzec zzecVar = this.zze;
        if (zzecVar.zzd()) {
            return;
        }
        zzeq zzeqVar = this.zzd;
        long jZza = zzecVar.zza();
        Long l10 = (Long) zzeqVar.zzc(jZza);
        if (l10 != null && l10.longValue() != this.zzh) {
            this.zzh = l10.longValue();
            this.zza.zzf();
        }
        int iZza = this.zza.zza(jZza, j10, j11, this.zzh, false, this.zzb);
        if (iZza != 0 && iZza != 1) {
            if (iZza == 2 || iZza == 3 || iZza == 4) {
                this.zzi = jZza;
                this.zze.zzb();
                zzzi zzziVar = this.zzj;
                Iterator it = zzziVar.zza.zzg.iterator();
                while (it.hasNext()) {
                    ((zzzj) it.next()).zzb(zzziVar.zza);
                }
                zzdi.zzb(null);
                throw null;
            }
            return;
        }
        this.zzi = jZza;
        long jLongValue = Long.valueOf(this.zze.zzb()).longValue();
        zzcp zzcpVar = (zzcp) this.zzc.zzc(jLongValue);
        if (zzcpVar != null && !zzcpVar.equals(zzcp.zza) && !zzcpVar.equals(this.zzg)) {
            this.zzg = zzcpVar;
            zzzi zzziVar2 = this.zzj;
            zzad zzadVar = new zzad();
            zzadVar.zzac(zzcpVar.zzb);
            zzadVar.zzI(zzcpVar.zzc);
            zzadVar.zzX(MimeTypes.VIDEO_RAW);
            zzziVar2.zza.zzi = zzadVar.zzad();
            Iterator it2 = zzziVar2.zza.zzg.iterator();
            while (it2.hasNext()) {
                ((zzzj) it2.next()).zzc(zzziVar2.zza, zzcpVar);
            }
        }
        zzzi zzziVar3 = this.zzj;
        long j12 = this.zzh;
        if (this.zza.zzo()) {
            zzzt zzztVar = zzziVar3.zza;
            if (zzztVar.zzl != null) {
                Iterator it3 = zzztVar.zzg.iterator();
                while (it3.hasNext()) {
                    ((zzzj) it3.next()).zza(zzziVar3.zza);
                }
            }
        }
        zzzt zzztVar2 = zzziVar3.zza;
        if (zzztVar2.zzj != null) {
            zzaf zzafVarZzad = zzztVar2.zzi == null ? new zzad().zzad() : zzztVar2.zzi;
            zzzt zzztVar3 = zzziVar3.zza;
            zzaae zzaaeVar = zzztVar3.zzj;
            zzdi.zzb(zzztVar3.zzh);
            zzaaeVar.zza(jLongValue - j12, System.nanoTime(), zzafVarZzad, null);
        }
        zzdi.zzb(null);
        throw null;
    }

    public final void zzd(@FloatRange(from = 0.0d, fromInclusive = false) float f10) {
        zzdi.zzd(f10 > 0.0f);
        this.zza.zzm(f10);
    }

    public final boolean zze(long j10) {
        long j11 = this.zzi;
        return j11 != C.TIME_UNSET && j11 >= j10;
    }
}
