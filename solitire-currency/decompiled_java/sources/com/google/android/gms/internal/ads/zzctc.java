package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.google.common.util.concurrent.m;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzctc {
    private final zzdxu zza;
    private final zzffg zzb;
    private final zzfjl zzc;
    private final zzclw zzd;
    private final zzeiu zze;
    private final zzdby zzf;

    @Nullable
    private zzfex zzg;
    private final zzdzc zzh;
    private final zzcvu zzi;
    private final Executor zzj;
    private final zzdym zzk;
    private final zzeey zzl;
    private final zzdzs zzm;
    private final zzdzz zzn;

    zzctc(zzdxu zzdxuVar, zzffg zzffgVar, zzfjl zzfjlVar, zzclw zzclwVar, zzeiu zzeiuVar, zzdby zzdbyVar, @Nullable zzfex zzfexVar, zzdzc zzdzcVar, zzcvu zzcvuVar, Executor executor, zzdym zzdymVar, zzeey zzeeyVar, zzdzs zzdzsVar, zzdzz zzdzzVar) {
        this.zza = zzdxuVar;
        this.zzb = zzffgVar;
        this.zzc = zzfjlVar;
        this.zzd = zzclwVar;
        this.zze = zzeiuVar;
        this.zzf = zzdbyVar;
        this.zzg = zzfexVar;
        this.zzh = zzdzcVar;
        this.zzi = zzcvuVar;
        this.zzj = executor;
        this.zzk = zzdymVar;
        this.zzl = zzeeyVar;
        this.zzm = zzdzsVar;
        this.zzn = zzdzzVar;
    }

    public final com.google.android.gms.ads.internal.client.zze zza(Throwable th) {
        return zzfgi.zzb(th, this.zzl);
    }

    public final zzdby zzc() {
        return this.zzf;
    }

    final /* synthetic */ zzfex zzd(zzfex zzfexVar) throws Exception {
        this.zzd.zza(zzfexVar);
        return zzfexVar;
    }

    public final m zze(final zzfhb zzfhbVar) {
        zzfiq zzfiqVarZza = this.zzc.zzb(zzfjf.GET_CACHE_KEY, this.zzi.zzc()).zzf(new zzgbq() { // from class: com.google.android.gms.internal.ads.zzcsy
            @Override // com.google.android.gms.internal.ads.zzgbq
            public final m zza(Object obj) {
                return this.zza.zzf(zzfhbVar, (zzbvb) obj);
            }
        }).zza();
        zzgcj.zzr(zzfiqVarZza, new zzcta(this), this.zzj);
        return zzfiqVarZza;
    }

    final /* synthetic */ m zzf(zzfhb zzfhbVar, zzbvb zzbvbVar) throws Exception {
        zzbvbVar.zzi = zzfhbVar;
        return this.zzh.zza(zzbvbVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    final /* synthetic */ m zzg(m mVar, m mVar2, m mVar3) throws Exception {
        return this.zzn.zzc((zzbvb) mVar.get(), (JSONObject) mVar2.get(), (zzbvd) mVar3.get());
    }

    public final m zzh(zzbvb zzbvbVar) {
        zzfiq zzfiqVarZza = this.zzc.zzb(zzfjf.NOTIFY_CACHE_HIT, this.zzh.zzg(zzbvbVar)).zza();
        zzgcj.zzr(zzfiqVarZza, new zzctb(this), this.zzj);
        return zzfiqVarZza;
    }

    public final m zzi(m mVar) {
        zzfjc zzfjcVarZzf = this.zzc.zzb(zzfjf.RENDERER, mVar).zze(new zzfio() { // from class: com.google.android.gms.internal.ads.zzcst
            @Override // com.google.android.gms.internal.ads.zzfio
            public final Object zza(Object obj) throws Exception {
                zzfex zzfexVar = (zzfex) obj;
                this.zza.zzd(zzfexVar);
                return zzfexVar;
            }
        }).zzf(this.zze);
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzeT)).booleanValue()) {
            zzfjcVarZzf = zzfjcVarZzf.zzi(((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzeU)).intValue(), TimeUnit.SECONDS);
        }
        return zzfjcVarZzf.zza();
    }

    public final m zzj() {
        com.google.android.gms.ads.internal.client.zzl zzlVar = this.zzb.zzd;
        if (zzlVar.zzx == null && zzlVar.zzs == null) {
            return zzk(this.zzi.zzc());
        }
        zzfjl zzfjlVar = this.zzc;
        zzdxu zzdxuVar = this.zza;
        return zzfiv.zzc(zzdxuVar.zza(), zzfjf.PRELOADED_LOADER, zzfjlVar).zza();
    }

    public final m zzk(final m mVar) {
        zzfex zzfexVar = this.zzg;
        if (zzfexVar != null) {
            return zzfiv.zzc(zzgcj.zzh(zzfexVar), zzfjf.SERVER_TRANSACTION, this.zzc).zza();
        }
        com.google.android.gms.ads.internal.zzu.zzc().zzj();
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzkF)).booleanValue() || ((Boolean) zzbdy.zzc.zze()).booleanValue()) {
            zzfjc zzfjcVarZzb = this.zzc.zzb(zzfjf.SERVER_TRANSACTION, mVar);
            final zzdym zzdymVar = this.zzk;
            Objects.requireNonNull(zzdymVar);
            return zzfjcVarZzb.zzf(new zzgbq() { // from class: com.google.android.gms.internal.ads.zzcsz
                @Override // com.google.android.gms.internal.ads.zzgbq
                public final m zza(Object obj) {
                    return zzdymVar.zzb((zzbvb) obj);
                }
            }).zza();
        }
        final zzdzs zzdzsVar = this.zzm;
        Objects.requireNonNull(zzdzsVar);
        final m mVarZzn = zzgcj.zzn(mVar, new zzgbq() { // from class: com.google.android.gms.internal.ads.zzcsu
            @Override // com.google.android.gms.internal.ads.zzgbq
            public final m zza(Object obj) {
                return zzdzsVar.zza((zzbvb) obj);
            }
        }, this.zzj);
        zzfjc zzfjcVarZzb2 = this.zzc.zzb(zzfjf.BUILD_URL, mVarZzn);
        final zzdzc zzdzcVar = this.zzh;
        Objects.requireNonNull(zzdzcVar);
        final zzfiq zzfiqVarZza = zzfjcVarZzb2.zzf(new zzgbq() { // from class: com.google.android.gms.internal.ads.zzcsv
            @Override // com.google.android.gms.internal.ads.zzgbq
            public final m zza(Object obj) {
                return zzdzcVar.zzb((JSONObject) obj);
            }
        }).zza();
        return this.zzc.zza(zzfjf.SERVER_TRANSACTION, mVar, mVarZzn, zzfiqVarZza).zza(new Callable() { // from class: com.google.android.gms.internal.ads.zzcsw
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zza.zzg(mVar, mVarZzn, zzfiqVarZza);
            }
        }).zzf(new zzgbq() { // from class: com.google.android.gms.internal.ads.zzcsx
            @Override // com.google.android.gms.internal.ads.zzgbq
            public final m zza(Object obj) {
                return (m) obj;
            }
        }).zza();
    }

    public final void zzl(zzfex zzfexVar) {
        this.zzg = zzfexVar;
    }
}
