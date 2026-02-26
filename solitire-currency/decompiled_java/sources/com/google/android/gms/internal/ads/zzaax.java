package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.SystemClock;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzaax {

    @Nullable
    private final Handler zza;

    @Nullable
    private final zzaay zzb;

    public zzaax(@Nullable Handler handler, @Nullable zzaay zzaayVar) {
        this.zza = zzaayVar == null ? null : handler;
        this.zzb = zzaayVar;
    }

    public final void zza(final String str, final long j10, final long j11) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzaan
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzg(str, j10, j11);
                }
            });
        }
    }

    public final void zzb(final String str) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzaaw
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzh(str);
                }
            });
        }
    }

    public final void zzc(final zzhn zzhnVar) {
        zzhnVar.zza();
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzaav
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzi(zzhnVar);
                }
            });
        }
    }

    public final void zzd(final int i10, final long j10) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzaap
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzj(i10, j10);
                }
            });
        }
    }

    public final void zze(final zzhn zzhnVar) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzaat
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzk(zzhnVar);
                }
            });
        }
    }

    public final void zzf(final zzaf zzafVar, @Nullable final zzho zzhoVar) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzaau
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzl(zzafVar, zzhoVar);
                }
            });
        }
    }

    final /* synthetic */ void zzg(String str, long j10, long j11) {
        int i10 = zzet.zza;
        this.zzb.zzp(str, j10, j11);
    }

    final /* synthetic */ void zzh(String str) {
        int i10 = zzet.zza;
        this.zzb.zzq(str);
    }

    final /* synthetic */ void zzi(zzhn zzhnVar) {
        zzhnVar.zza();
        int i10 = zzet.zza;
        this.zzb.zzr(zzhnVar);
    }

    final /* synthetic */ void zzj(int i10, long j10) {
        int i11 = zzet.zza;
        this.zzb.zzl(i10, j10);
    }

    final /* synthetic */ void zzk(zzhn zzhnVar) {
        int i10 = zzet.zza;
        this.zzb.zzs(zzhnVar);
    }

    final /* synthetic */ void zzl(zzaf zzafVar, zzho zzhoVar) {
        int i10 = zzet.zza;
        this.zzb.zzu(zzafVar, zzhoVar);
    }

    final /* synthetic */ void zzm(Object obj, long j10) {
        int i10 = zzet.zza;
        this.zzb.zzm(obj, j10);
    }

    final /* synthetic */ void zzn(long j10, int i10) {
        int i11 = zzet.zza;
        this.zzb.zzt(j10, i10);
    }

    final /* synthetic */ void zzo(Exception exc) {
        int i10 = zzet.zza;
        this.zzb.zzo(exc);
    }

    final /* synthetic */ void zzp(zzcp zzcpVar) {
        int i10 = zzet.zza;
        this.zzb.zzv(zzcpVar);
    }

    public final void zzq(final Object obj) {
        Handler handler = this.zza;
        if (handler != null) {
            final long jElapsedRealtime = SystemClock.elapsedRealtime();
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzaaq
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzm(obj, jElapsedRealtime);
                }
            });
        }
    }

    public final void zzr(final long j10, final int i10) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzaar
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzn(j10, i10);
                }
            });
        }
    }

    public final void zzs(final Exception exc) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzaas
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzo(exc);
                }
            });
        }
    }

    public final void zzt(final zzcp zzcpVar) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzaao
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzp(zzcpVar);
                }
            });
        }
    }
}
