package com.google.android.gms.internal.ads;

import android.os.Binder;
import com.google.common.util.concurrent.m;
import java.util.concurrent.ExecutionException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdzh {
    private final zzgcu zza;
    private final zzgcu zzb;
    private final zzeac zzc;
    private final zzhew zzd;

    zzdzh(zzgcu zzgcuVar, zzgcu zzgcuVar2, zzeac zzeacVar, zzhew zzhewVar) {
        this.zza = zzgcuVar;
        this.zzb = zzgcuVar2;
        this.zzc = zzeacVar;
        this.zzd = zzhewVar;
    }

    final /* synthetic */ m zza(zzbug zzbugVar) throws Exception {
        return this.zzc.zza(zzbugVar, ((Long) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzkH)).longValue());
    }

    final /* synthetic */ m zzb(zzbug zzbugVar, int i10, zzdyp zzdypVar) throws Exception {
        return ((zzebi) this.zzd.zzb()).zzb(zzbugVar, i10);
    }

    public final m zzc(final zzbug zzbugVar) {
        String str = zzbugVar.zzf;
        com.google.android.gms.ads.internal.zzu.zzp();
        m mVarZzg = com.google.android.gms.ads.internal.util.zzt.zzC(str) ? zzgcj.zzg(new zzdyp(1, "Ads service proxy force local")) : zzgcj.zzf(zzgcj.zzk(new zzgbp() { // from class: com.google.android.gms.internal.ads.zzdze
            @Override // com.google.android.gms.internal.ads.zzgbp
            public final m zza() {
                return this.zza.zza(zzbugVar);
            }
        }, this.zza), ExecutionException.class, new zzgbq() { // from class: com.google.android.gms.internal.ads.zzdzf
            @Override // com.google.android.gms.internal.ads.zzgbq
            public final m zza(Object obj) {
                Throwable cause = (ExecutionException) obj;
                if (cause.getCause() != null) {
                    cause = cause.getCause();
                }
                return zzgcj.zzg(cause);
            }
        }, this.zzb);
        final int callingUid = Binder.getCallingUid();
        return zzgcj.zzf(mVarZzg, zzdyp.class, new zzgbq() { // from class: com.google.android.gms.internal.ads.zzdzg
            @Override // com.google.android.gms.internal.ads.zzgbq
            public final m zza(Object obj) {
                return this.zza.zzb(zzbugVar, callingUid, (zzdyp) obj);
            }
        }, this.zzb);
    }
}
