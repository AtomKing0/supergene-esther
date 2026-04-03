package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Looper;
import android.util.Pair;
import android.view.Surface;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class zzzt implements zzabd, zzco {
    private static final Executor zza = new Executor() { // from class: com.google.android.gms.internal.ads.zzzd
        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
        }
    };
    private final Context zzb;
    private final zzzr zzc;
    private final zzaah zzd;
    private final zzaam zze;
    private final zzbx zzf;
    private final CopyOnWriteArraySet zzg;
    private zzdj zzh;
    private zzaf zzi;
    private zzaae zzj;
    private zzdt zzk;

    @Nullable
    private Pair zzl;
    private int zzm;
    private int zzn;

    /* synthetic */ zzzt(zzzg zzzgVar, zzzs zzzsVar) {
        Context context = zzzgVar.zza;
        this.zzb = context;
        zzzr zzzrVar = new zzzr(this, context);
        this.zzc = zzzrVar;
        zzaah zzaahVar = zzzgVar.zzb;
        this.zzd = zzaahVar;
        this.zze = new zzaam(new zzzi(this, null), zzaahVar);
        zzbx zzbxVar = zzzgVar.zzd;
        zzdi.zzb(zzbxVar);
        this.zzf = zzbxVar;
        CopyOnWriteArraySet copyOnWriteArraySet = new CopyOnWriteArraySet();
        this.zzg = copyOnWriteArraySet;
        this.zzn = 0;
        copyOnWriteArraySet.add(zzzrVar);
    }

    static /* bridge */ /* synthetic */ zzcn zzd(zzzt zzztVar, zzaf zzafVar, zzdj zzdjVar) throws zzabb {
        zzdi.zzf(zzztVar.zzn == 0);
        zzztVar.zzh = zzdjVar;
        Looper looperMyLooper = Looper.myLooper();
        zzdi.zzb(looperMyLooper);
        zzztVar.zzk = zzdjVar.zzb(looperMyLooper, null);
        zzo zzoVarZzw = zzw(zzafVar.zzy);
        if (zzoVarZzw.zzd == 7 && zzet.zza < 34) {
            zzm zzmVarZzc = zzoVarZzw.zzc();
            zzmVarZzc.zzd(6);
            zzoVarZzw = zzmVarZzc.zzg();
        }
        zzo zzoVar = zzoVarZzw;
        try {
            zzbx zzbxVar = zzztVar.zzf;
            Context context = zzztVar.zzb;
            zzr zzrVar = zzr.zza;
            final zzdt zzdtVar = zzztVar.zzk;
            Objects.requireNonNull(zzdtVar);
            zzbxVar.zza(context, zzoVar, zzrVar, zzztVar, new Executor() { // from class: com.google.android.gms.internal.ads.zzze
                @Override // java.util.concurrent.Executor
                public final void execute(Runnable runnable) {
                    zzdtVar.zzh(runnable);
                }
            }, zzfxr.zzm(), 0L);
            Pair pair = zzztVar.zzl;
            if (pair == null) {
                throw null;
            }
            zzel zzelVar = (zzel) pair.second;
            zzelVar.zzb();
            zzelVar.zza();
            throw null;
        } catch (zzcl e10) {
            throw new zzabb(e10, zzafVar);
        }
    }

    public static /* synthetic */ void zzl(zzzt zzztVar) {
        int i10 = zzztVar.zzm - 1;
        zzztVar.zzm = i10;
        if (i10 > 0) {
            return;
        }
        if (i10 < 0) {
            throw new IllegalStateException(String.valueOf(i10));
        }
        zzztVar.zze.zza();
    }

    static /* bridge */ /* synthetic */ void zzn(final zzzt zzztVar) {
        if (zzztVar.zzn == 1) {
            zzztVar.zzm++;
            zzztVar.zze.zza();
            zzdt zzdtVar = zzztVar.zzk;
            zzdi.zzb(zzdtVar);
            zzdtVar.zzh(new Runnable() { // from class: com.google.android.gms.internal.ads.zzzf
                @Override // java.lang.Runnable
                public final void run() {
                    zzzt.zzl(this.zza);
                }
            });
        }
    }

    static /* bridge */ /* synthetic */ boolean zzv(zzzt zzztVar, long j10) {
        return zzztVar.zzm == 0 && zzztVar.zze.zze(j10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static zzo zzw(@Nullable zzo zzoVar) {
        return (zzoVar == null || !zzoVar.zzf()) ? zzo.zza : zzoVar;
    }

    @Override // com.google.android.gms.internal.ads.zzabd
    public final zzaah zzh() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzabd
    public final zzabc zzi() {
        return this.zzc;
    }

    public final void zzr() {
        zzel zzelVar = zzel.zza;
        zzelVar.zzb();
        zzelVar.zza();
        this.zzl = null;
    }

    public final void zzs() {
        if (this.zzn == 2) {
            return;
        }
        zzdt zzdtVar = this.zzk;
        if (zzdtVar != null) {
            zzdtVar.zze(null);
        }
        this.zzl = null;
        this.zzn = 2;
    }

    public final void zzt(long j10, long j11) throws zzhw {
        if (this.zzm == 0) {
            this.zze.zzc(j10, j11);
        }
    }

    public final void zzu(Surface surface, zzel zzelVar) {
        Pair pair = this.zzl;
        if (pair != null && ((Surface) pair.first).equals(surface) && ((zzel) this.zzl.second).equals(zzelVar)) {
            return;
        }
        this.zzl = Pair.create(surface, zzelVar);
    }
}
