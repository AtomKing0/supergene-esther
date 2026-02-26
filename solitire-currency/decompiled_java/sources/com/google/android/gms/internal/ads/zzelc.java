package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzelc {
    private final ConcurrentHashMap zza = new ConcurrentHashMap();
    private final zzdqb zzb;

    public zzelc(zzdqb zzdqbVar) {
        this.zzb = zzdqbVar;
    }

    public final zzbql zza(String str) {
        if (this.zza.containsKey(str)) {
            return (zzbql) this.zza.get(str);
        }
        return null;
    }

    public final void zzb(String str) {
        try {
            this.zza.put(str, this.zzb.zzb(str));
        } catch (RemoteException e10) {
            com.google.android.gms.ads.internal.util.zze.zzb("Couldn't create RTB adapter : ", e10);
        }
    }
}
