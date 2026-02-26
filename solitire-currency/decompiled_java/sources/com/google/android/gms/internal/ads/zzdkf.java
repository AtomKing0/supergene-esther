package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.util.Clock;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdkf implements View.OnClickListener {

    @Nullable
    @VisibleForTesting
    String zza;

    @Nullable
    @VisibleForTesting
    Long zzb;

    @Nullable
    @VisibleForTesting
    WeakReference zzc;
    private final zzdoa zzd;
    private final Clock zze;

    @Nullable
    private zzbgx zzf;

    @Nullable
    private zzbix zzg;

    public zzdkf(zzdoa zzdoaVar, Clock clock) {
        this.zzd = zzdoaVar;
        this.zze = clock;
    }

    private final void zzd() {
        View view;
        this.zza = null;
        this.zzb = null;
        WeakReference weakReference = this.zzc;
        if (weakReference == null || (view = (View) weakReference.get()) == null) {
            return;
        }
        view.setClickable(false);
        view.setOnClickListener(null);
        this.zzc = null;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        WeakReference weakReference = this.zzc;
        if (weakReference == null || weakReference.get() != view) {
            return;
        }
        if (this.zza != null && this.zzb != null) {
            HashMap map = new HashMap();
            map.put("id", this.zza);
            map.put("time_interval", String.valueOf(this.zze.currentTimeMillis() - this.zzb.longValue()));
            map.put("messageType", "onePointFiveClick");
            this.zzd.zzj("sendMessageToNativeJs", map);
        }
        zzd();
    }

    @Nullable
    public final zzbgx zza() {
        return this.zzf;
    }

    public final void zzb() {
        if (this.zzf == null || this.zzb == null) {
            return;
        }
        zzd();
        try {
            this.zzf.zze();
        } catch (RemoteException e10) {
            com.google.android.gms.ads.internal.util.client.zzm.zzl("#007 Could not call remote method.", e10);
        }
    }

    public final void zzc(final zzbgx zzbgxVar) {
        this.zzf = zzbgxVar;
        zzbix zzbixVar = this.zzg;
        if (zzbixVar != null) {
            this.zzd.zzn("/unconfirmedClick", zzbixVar);
        }
        zzbix zzbixVar2 = new zzbix() { // from class: com.google.android.gms.internal.ads.zzdke
            @Override // com.google.android.gms.internal.ads.zzbix
            public final void zza(Object obj, Map map) {
                zzdkf zzdkfVar = this.zza;
                try {
                    zzdkfVar.zzb = Long.valueOf(Long.parseLong((String) map.get("timestamp")));
                } catch (NumberFormatException unused) {
                    com.google.android.gms.ads.internal.util.client.zzm.zzg("Failed to call parse unconfirmedClickTimestamp.");
                }
                zzbgx zzbgxVar2 = zzbgxVar;
                zzdkfVar.zza = (String) map.get("id");
                String str = (String) map.get("asset_id");
                if (zzbgxVar2 == null) {
                    com.google.android.gms.ads.internal.util.client.zzm.zze("Received unconfirmed click but UnconfirmedClickListener is null.");
                    return;
                }
                try {
                    zzbgxVar2.zzf(str);
                } catch (RemoteException e10) {
                    com.google.android.gms.ads.internal.util.client.zzm.zzl("#007 Could not call remote method.", e10);
                }
            }
        };
        this.zzg = zzbixVar2;
        this.zzd.zzl("/unconfirmedClick", zzbixVar2);
    }
}
