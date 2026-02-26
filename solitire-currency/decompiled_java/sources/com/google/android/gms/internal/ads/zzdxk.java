package com.google.android.gms.internal.ads;

import android.os.Binder;
import android.os.Bundle;
import com.google.common.util.concurrent.m;
import java.io.InputStream;
import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdxk {
    private final ScheduledExecutorService zza;
    private final zzgcu zzb;
    private final zzgcu zzc;
    private final zzdyc zzd;
    private final zzhew zze;

    public zzdxk(ScheduledExecutorService scheduledExecutorService, zzgcu zzgcuVar, zzgcu zzgcuVar2, zzdyc zzdycVar, zzhew zzhewVar) {
        this.zza = scheduledExecutorService;
        this.zzb = zzgcuVar;
        this.zzc = zzgcuVar2;
        this.zzd = zzdycVar;
        this.zze = zzhewVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    final /* synthetic */ zzdyq zza(zzbvb zzbvbVar) throws Exception {
        return (zzdyq) this.zzd.zza(zzbvbVar).get(((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzeU)).intValue(), TimeUnit.SECONDS);
    }

    final /* synthetic */ m zzb(final zzbvb zzbvbVar, int i10, Throwable th) throws Exception {
        Bundle bundle;
        if (zzbvbVar != null && (bundle = zzbvbVar.zzm) != null) {
            bundle.putBoolean("ls", true);
        }
        return zzgcj.zzn(((zzeay) this.zze.zzb()).zzd(zzbvbVar, i10), new zzgbq() { // from class: com.google.android.gms.internal.ads.zzdxh
            @Override // com.google.android.gms.internal.ads.zzgbq
            public final m zza(Object obj) {
                return zzgcj.zzh(new zzdyq((InputStream) obj, zzbvbVar));
            }
        }, this.zzb);
    }

    public final m zzc(final zzbvb zzbvbVar) {
        m mVarZzb;
        String str = zzbvbVar.zzd;
        com.google.android.gms.ads.internal.zzu.zzp();
        if (com.google.android.gms.ads.internal.util.zzt.zzC(str)) {
            mVarZzb = zzgcj.zzg(new zzdyp(1));
        } else {
            mVarZzb = ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzgK)).booleanValue() ? this.zzc.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzdxi
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return this.zza.zza(zzbvbVar);
                }
            }) : this.zzd.zza(zzbvbVar);
        }
        final int callingUid = Binder.getCallingUid();
        return zzgcj.zzf((zzgca) zzgcj.zzo(zzgca.zzu(mVarZzb), ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzeU)).intValue(), TimeUnit.SECONDS, this.zza), Throwable.class, new zzgbq() { // from class: com.google.android.gms.internal.ads.zzdxj
            @Override // com.google.android.gms.internal.ads.zzgbq
            public final m zza(Object obj) {
                return this.zza.zzb(zzbvbVar, callingUid, (Throwable) obj);
            }
        }, this.zzb);
    }
}
