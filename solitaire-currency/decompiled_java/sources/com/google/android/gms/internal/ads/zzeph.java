package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.appset.AppSet;
import com.google.android.gms.appset.AppSetIdClient;
import com.google.android.gms.appset.AppSetIdInfo;
import com.google.android.gms.tasks.Task;
import com.google.common.util.concurrent.m;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzeph implements zzevo {

    @VisibleForTesting
    final zzbze zza;

    @VisibleForTesting
    AppSetIdClient zzb;
    private final ScheduledExecutorService zzc;
    private final zzgcu zzd;
    private final Context zze;

    zzeph(Context context, zzbze zzbzeVar, ScheduledExecutorService scheduledExecutorService, zzgcu zzgcuVar) {
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzcA)).booleanValue()) {
            this.zzb = AppSet.getClient(context);
        }
        this.zze = context;
        this.zza = zzbzeVar;
        this.zzc = scheduledExecutorService;
        this.zzd = zzgcuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzevo
    public final int zza() {
        return 11;
    }

    @Override // com.google.android.gms.internal.ads.zzevo
    public final m zzb() {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzcw)).booleanValue()) {
            if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzcB)).booleanValue()) {
                if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzcx)).booleanValue()) {
                    return zzgcj.zzm(zzfsf.zza(this.zzb.getAppSetIdInfo(), null), new zzful() { // from class: com.google.android.gms.internal.ads.zzepe
                        @Override // com.google.android.gms.internal.ads.zzful
                        public final Object apply(Object obj) {
                            AppSetIdInfo appSetIdInfo = (AppSetIdInfo) obj;
                            return new zzepi(appSetIdInfo.getId(), appSetIdInfo.getScope());
                        }
                    }, zzbzo.zzf);
                }
                Task<AppSetIdInfo> taskZza = ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzcA)).booleanValue() ? zzfgl.zza(this.zze) : this.zzb.getAppSetIdInfo();
                if (taskZza == null) {
                    return zzgcj.zzh(new zzepi(null, -1));
                }
                m mVarZzn = zzgcj.zzn(zzfsf.zza(taskZza, null), new zzgbq() { // from class: com.google.android.gms.internal.ads.zzepf
                    @Override // com.google.android.gms.internal.ads.zzgbq
                    public final m zza(Object obj) {
                        AppSetIdInfo appSetIdInfo = (AppSetIdInfo) obj;
                        return appSetIdInfo == null ? zzgcj.zzh(new zzepi(null, -1)) : zzgcj.zzh(new zzepi(appSetIdInfo.getId(), appSetIdInfo.getScope()));
                    }
                }, zzbzo.zzf);
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzcy)).booleanValue()) {
                    mVarZzn = zzgcj.zzo(mVarZzn, ((Long) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzcz)).longValue(), TimeUnit.MILLISECONDS, this.zzc);
                }
                return zzgcj.zze(mVarZzn, Exception.class, new zzful() { // from class: com.google.android.gms.internal.ads.zzepg
                    @Override // com.google.android.gms.internal.ads.zzful
                    public final Object apply(Object obj) {
                        this.zza.zza.zzw((Exception) obj, "AppSetIdInfoSignal");
                        return new zzepi(null, -1);
                    }
                }, this.zzd);
            }
        }
        return zzgcj.zzh(new zzepi(null, -1));
    }
}
