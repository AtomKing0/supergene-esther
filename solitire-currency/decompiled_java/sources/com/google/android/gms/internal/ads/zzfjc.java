package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.google.common.util.concurrent.m;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzfjc {
    final /* synthetic */ zzfjd zza;
    private final Object zzb;

    @Nullable
    private final String zzc;
    private final m zzd;
    private final List zze;
    private final m zzf;

    private zzfjc(zzfjd zzfjdVar, Object obj, String str, m mVar, List list, m mVar2) {
        this.zza = zzfjdVar;
        this.zzb = obj;
        this.zzc = str;
        this.zzd = mVar;
        this.zze = list;
        this.zzf = mVar2;
    }

    public final zzfiq zza() {
        Object obj = this.zzb;
        String strZzf = this.zzc;
        if (strZzf == null) {
            strZzf = this.zza.zzf(obj);
        }
        final zzfiq zzfiqVar = new zzfiq(obj, strZzf, this.zzf);
        this.zza.zzd.zza(zzfiqVar);
        m mVar = this.zzd;
        Runnable runnable = new Runnable() { // from class: com.google.android.gms.internal.ads.zzfiz
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zza.zzd.zzc(zzfiqVar);
            }
        };
        zzgcu zzgcuVar = zzbzo.zzf;
        mVar.addListener(runnable, zzgcuVar);
        zzgcj.zzr(zzfiqVar, new zzfja(this, zzfiqVar), zzgcuVar);
        return zzfiqVar;
    }

    public final zzfjc zzb(Object obj) {
        return this.zza.zzb(obj, zza());
    }

    public final zzfjc zzc(Class cls, zzgbq zzgbqVar) {
        return new zzfjc(this.zza, this.zzb, this.zzc, this.zzd, this.zze, zzgcj.zzf(this.zzf, cls, zzgbqVar, this.zza.zzb));
    }

    public final zzfjc zzd(final m mVar) {
        return zzg(new zzgbq() { // from class: com.google.android.gms.internal.ads.zzfiy
            @Override // com.google.android.gms.internal.ads.zzgbq
            public final m zza(Object obj) {
                return mVar;
            }
        }, zzbzo.zzf);
    }

    public final zzfjc zze(final zzfio zzfioVar) {
        return zzf(new zzgbq() { // from class: com.google.android.gms.internal.ads.zzfix
            @Override // com.google.android.gms.internal.ads.zzgbq
            public final m zza(Object obj) {
                return zzgcj.zzh(zzfioVar.zza(obj));
            }
        });
    }

    public final zzfjc zzf(zzgbq zzgbqVar) {
        return zzg(zzgbqVar, this.zza.zzb);
    }

    public final zzfjc zzg(zzgbq zzgbqVar, Executor executor) {
        return new zzfjc(this.zza, this.zzb, this.zzc, this.zzd, this.zze, zzgcj.zzn(this.zzf, zzgbqVar, executor));
    }

    public final zzfjc zzh(String str) {
        return new zzfjc(this.zza, this.zzb, str, this.zzd, this.zze, this.zzf);
    }

    public final zzfjc zzi(long j10, TimeUnit timeUnit) {
        return new zzfjc(this.zza, this.zzb, this.zzc, this.zzd, this.zze, zzgcj.zzo(this.zzf, j10, timeUnit, this.zza.zzc));
    }
}
