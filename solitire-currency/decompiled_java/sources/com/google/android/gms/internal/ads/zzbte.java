package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.query.QueryInfoGenerationCallback;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzbte {
    private static zzbym zza;
    private final Context zzb;
    private final AdFormat zzc;

    @Nullable
    private final com.google.android.gms.ads.internal.client.zzdx zzd;

    @Nullable
    private final String zze;

    public zzbte(Context context, AdFormat adFormat, @Nullable com.google.android.gms.ads.internal.client.zzdx zzdxVar, @Nullable String str) {
        this.zzb = context;
        this.zzc = adFormat;
        this.zzd = zzdxVar;
        this.zze = str;
    }

    @Nullable
    public static zzbym zza(Context context) {
        zzbym zzbymVar;
        synchronized (zzbte.class) {
            if (zza == null) {
                zza = com.google.android.gms.ads.internal.client.zzay.zza().zzr(context, new zzboi());
            }
            zzbymVar = zza;
        }
        return zzbymVar;
    }

    public final void zzb(QueryInfoGenerationCallback queryInfoGenerationCallback) {
        com.google.android.gms.ads.internal.client.zzl zzlVarZza;
        long jCurrentTimeMillis = System.currentTimeMillis();
        zzbym zzbymVarZza = zza(this.zzb);
        if (zzbymVarZza == null) {
            queryInfoGenerationCallback.onFailure("Internal Error, query info generator is null.");
            return;
        }
        Context context = this.zzb;
        com.google.android.gms.ads.internal.client.zzdx zzdxVar = this.zzd;
        IObjectWrapper iObjectWrapperWrap = ObjectWrapper.wrap(context);
        if (zzdxVar == null) {
            com.google.android.gms.ads.internal.client.zzm zzmVar = new com.google.android.gms.ads.internal.client.zzm();
            zzmVar.zzg(jCurrentTimeMillis);
            zzlVarZza = zzmVar.zza();
        } else {
            zzdxVar.zzq(jCurrentTimeMillis);
            zzlVarZza = com.google.android.gms.ads.internal.client.zzp.zza.zza(this.zzb, this.zzd);
        }
        try {
            zzbymVarZza.zzf(iObjectWrapperWrap, new zzbyq(this.zze, this.zzc.name(), null, zzlVarZza), new zzbtd(this, queryInfoGenerationCallback));
        } catch (RemoteException unused) {
            queryInfoGenerationCallback.onFailure("Internal Error.");
        }
    }
}
