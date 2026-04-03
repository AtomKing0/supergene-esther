package com.google.android.gms.internal.ads;

import android.os.Binder;
import android.os.Bundle;
import com.google.common.util.concurrent.m;
import java.io.InputStream;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdwq {
    private final zzgcu zza;
    private final zzgcu zzb;
    private final zzdxx zzc;
    private final zzhew zzd;

    public zzdwq(zzgcu zzgcuVar, zzgcu zzgcuVar2, zzdxx zzdxxVar, zzhew zzhewVar) {
        this.zza = zzgcuVar;
        this.zzb = zzgcuVar2;
        this.zzc = zzdxxVar;
        this.zzd = zzhewVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    final /* synthetic */ zzdyq zza(zzbvb zzbvbVar) throws Exception {
        return (zzdyq) this.zzc.zza(zzbvbVar).get(((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzeU)).intValue(), TimeUnit.SECONDS);
    }

    final /* synthetic */ m zzb(final zzbvb zzbvbVar, int i10, zzdyp zzdypVar) throws Exception {
        Bundle bundle;
        if (zzbvbVar != null && (bundle = zzbvbVar.zzm) != null) {
            bundle.putBoolean("ls", true);
        }
        return zzgcj.zzn(((zzeay) this.zzd.zzb()).zzc(zzbvbVar, i10), new zzgbq() { // from class: com.google.android.gms.internal.ads.zzdwm
            @Override // com.google.android.gms.internal.ads.zzgbq
            public final m zza(Object obj) {
                return zzgcj.zzh(new zzdyq((InputStream) obj, zzbvbVar));
            }
        }, this.zzb);
    }

    public final m zzc(final zzbvb zzbvbVar) {
        String str = zzbvbVar.zzd;
        com.google.android.gms.ads.internal.zzu.zzp();
        m mVarZzg = com.google.android.gms.ads.internal.util.zzt.zzC(str) ? zzgcj.zzg(new zzdyp(1)) : zzgcj.zzf(this.zza.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzdwn
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zza.zza(zzbvbVar);
            }
        }), ExecutionException.class, new zzgbq() { // from class: com.google.android.gms.internal.ads.zzdwo
            @Override // com.google.android.gms.internal.ads.zzgbq
            public final m zza(Object obj) {
                return zzgcj.zzg(((ExecutionException) obj).getCause());
            }
        }, this.zzb);
        final int callingUid = Binder.getCallingUid();
        return zzgcj.zzf(mVarZzg, zzdyp.class, new zzgbq() { // from class: com.google.android.gms.internal.ads.zzdwp
            @Override // com.google.android.gms.internal.ads.zzgbq
            public final m zza(Object obj) {
                return this.zza.zzb(zzbvbVar, callingUid, (zzdyp) obj);
            }
        }, this.zzb);
    }
}
