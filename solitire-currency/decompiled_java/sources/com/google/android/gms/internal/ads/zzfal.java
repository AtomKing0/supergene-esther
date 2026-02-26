package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzfal extends zzezt {
    public zzfal(Context context, Executor executor, zzcgj zzcgjVar, zzfcc zzfccVar, zzfaj zzfajVar, zzffe zzffeVar, VersionInfoParcel versionInfoParcel) {
        super(context, executor, zzcgjVar, zzfccVar, zzfajVar, zzffeVar, versionInfoParcel);
    }

    @Override // com.google.android.gms.internal.ads.zzezt
    protected final /* bridge */ /* synthetic */ zzcvw zze(zzcph zzcphVar, zzcwa zzcwaVar, zzdck zzdckVar) {
        zzcox zzcoxVarZzd = this.zza.zzd();
        zzcoxVarZzd.zzd(zzcwaVar);
        zzcoxVarZzd.zzc(zzdckVar);
        return zzcoxVarZzd;
    }
}
