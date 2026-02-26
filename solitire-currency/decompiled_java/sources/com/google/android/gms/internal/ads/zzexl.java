package com.google.android.gms.internal.ads;

import com.google.android.gms.appset.AppSetIdInfo;
import com.google.android.gms.tasks.Tasks;
import com.google.common.util.concurrent.m;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzexl implements zzevo {
    private final zzbze zza;
    private final ScheduledExecutorService zzb;
    private final zzgcu zzc;

    zzexl(String str, zzazy zzazyVar, zzbze zzbzeVar, ScheduledExecutorService scheduledExecutorService, zzgcu zzgcuVar) {
        this.zza = zzbzeVar;
        this.zzb = scheduledExecutorService;
        this.zzc = zzgcuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzevo
    public final int zza() {
        return 43;
    }

    @Override // com.google.android.gms.internal.ads.zzevo
    public final m zzb() {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzcw)).booleanValue()) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzcB)).booleanValue()) {
                m mVarZzn = zzgcj.zzn(zzfsf.zza(Tasks.forResult(null), null), new zzgbq() { // from class: com.google.android.gms.internal.ads.zzexj
                    @Override // com.google.android.gms.internal.ads.zzgbq
                    public final m zza(Object obj) {
                        AppSetIdInfo appSetIdInfo = (AppSetIdInfo) obj;
                        return appSetIdInfo == null ? zzgcj.zzh(new zzexm(null, -1)) : zzgcj.zzh(new zzexm(appSetIdInfo.getId(), appSetIdInfo.getScope()));
                    }
                }, this.zzc);
                if (((Boolean) zzbdf.zza.zze()).booleanValue()) {
                    mVarZzn = zzgcj.zzo(mVarZzn, ((Long) zzbdf.zzb.zze()).longValue(), TimeUnit.MILLISECONDS, this.zzb);
                }
                return zzgcj.zze(mVarZzn, Exception.class, new zzful() { // from class: com.google.android.gms.internal.ads.zzexk
                    @Override // com.google.android.gms.internal.ads.zzful
                    public final Object apply(Object obj) {
                        return this.zza.zzc((Exception) obj);
                    }
                }, this.zzc);
            }
        }
        return zzgcj.zzh(new zzexm(null, -1));
    }

    final /* synthetic */ zzexm zzc(Exception exc) {
        this.zza.zzw(exc, "AppSetIdInfoGmscoreSignal");
        return new zzexm(null, -1);
    }
}
