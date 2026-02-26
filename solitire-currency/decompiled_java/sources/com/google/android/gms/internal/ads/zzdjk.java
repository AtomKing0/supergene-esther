package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import androidx.collection.SimpleArrayMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdjk {
    zzbge zza;
    zzbgb zzb;
    zzbgr zzc;
    zzbgo zzd;
    zzblq zze;
    final SimpleArrayMap zzf = new SimpleArrayMap();
    final SimpleArrayMap zzg = new SimpleArrayMap();

    public final zzdjk zza(zzbgb zzbgbVar) {
        this.zzb = zzbgbVar;
        return this;
    }

    public final zzdjk zzb(zzbge zzbgeVar) {
        this.zza = zzbgeVar;
        return this;
    }

    public final zzdjk zzc(String str, zzbgk zzbgkVar, @Nullable zzbgh zzbghVar) {
        this.zzf.put(str, zzbgkVar);
        if (zzbghVar != null) {
            this.zzg.put(str, zzbghVar);
        }
        return this;
    }

    public final zzdjk zzd(zzblq zzblqVar) {
        this.zze = zzblqVar;
        return this;
    }

    public final zzdjk zze(zzbgo zzbgoVar) {
        this.zzd = zzbgoVar;
        return this;
    }

    public final zzdjk zzf(zzbgr zzbgrVar) {
        this.zzc = zzbgrVar;
        return this;
    }

    public final zzdjm zzg() {
        return new zzdjm(this);
    }
}
