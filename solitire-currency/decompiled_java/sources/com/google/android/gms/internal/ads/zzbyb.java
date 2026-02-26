package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.annotation.GuardedBy;
import androidx.annotation.VisibleForTesting;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class zzbyb {

    @GuardedBy("ScionComponent.class")
    @VisibleForTesting
    static zzbyb zza;

    public static synchronized zzbyb zzd(Context context) {
        zzbyb zzbybVar = zza;
        if (zzbybVar != null) {
            return zzbybVar;
        }
        Context applicationContext = context.getApplicationContext();
        zzbbw.zza(applicationContext);
        com.google.android.gms.ads.internal.util.zzg zzgVarZzi = com.google.android.gms.ads.internal.zzu.zzo().zzi();
        zzgVarZzi.zzs(applicationContext);
        zzbxt zzbxtVar = new zzbxt(null);
        zzbxtVar.zzb(applicationContext);
        zzbxtVar.zzc(com.google.android.gms.ads.internal.zzu.zzB());
        zzbxtVar.zza(zzgVarZzi);
        zzbxtVar.zzd(com.google.android.gms.ads.internal.zzu.zzn());
        zzbyb zzbybVarZze = zzbxtVar.zze();
        zza = zzbybVarZze;
        zzbybVarZze.zza().zza();
        zzbyf zzbyfVarZzc = zza.zzc();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzal)).booleanValue()) {
            com.google.android.gms.ads.internal.zzu.zzp();
            Map mapZzv = com.google.android.gms.ads.internal.util.zzt.zzv((String) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzam));
            Iterator it = mapZzv.keySet().iterator();
            while (it.hasNext()) {
                zzbyfVarZzc.zzc((String) it.next());
            }
            zzbyfVarZzc.zzd(new zzbyd(zzbyfVarZzc, mapZzv));
        }
        return zza;
    }

    abstract zzbxm zza();

    abstract zzbxq zzb();

    abstract zzbyf zzc();
}
