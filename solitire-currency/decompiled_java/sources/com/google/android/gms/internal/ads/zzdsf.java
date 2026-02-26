package com.google.android.gms.internal.ads;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdsf {
    private final ConcurrentHashMap zza;
    private final zzbzi zzb;
    private final zzffg zzc;
    private final String zzd;
    private final String zze;
    private final com.google.android.gms.ads.internal.zzj zzf;
    private final Bundle zzg = new Bundle();
    private final Context zzh;

    public zzdsf(Context context, zzdsp zzdspVar, zzbzi zzbziVar, zzffg zzffgVar, String str, String str2, com.google.android.gms.ads.internal.zzj zzjVar) {
        ActivityManager.MemoryInfo memoryInfoZzc;
        ConcurrentHashMap concurrentHashMapZzc = zzdspVar.zzc();
        this.zza = concurrentHashMapZzc;
        this.zzb = zzbziVar;
        this.zzc = zzffgVar;
        this.zzd = str;
        this.zze = str2;
        this.zzf = zzjVar;
        this.zzh = context;
        concurrentHashMapZzc.put("ad_format", str2.toUpperCase(Locale.ROOT));
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zziF)).booleanValue()) {
            int iZzj = zzjVar.zzj();
            int i10 = iZzj - 1;
            if (iZzj == 0) {
                throw null;
            }
            concurrentHashMapZzc.put("asv", i10 != 0 ? i10 != 1 ? "na" : "2" : "1");
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzbS)).booleanValue()) {
            Runtime runtime = Runtime.getRuntime();
            zzc("rt_f", String.valueOf(runtime.freeMemory()));
            zzc("rt_m", String.valueOf(runtime.maxMemory()));
            zzc("rt_t", String.valueOf(runtime.totalMemory()));
            zzc("wv_c", String.valueOf(com.google.android.gms.ads.internal.zzu.zzo().zzb()));
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzbU)).booleanValue() && (memoryInfoZzc = com.google.android.gms.ads.internal.util.client.zzf.zzc(context)) != null) {
                zzc("mem_avl", String.valueOf(memoryInfoZzc.availMem));
                zzc("mem_tt", String.valueOf(memoryInfoZzc.totalMem));
                zzc("low_m", true != memoryInfoZzc.lowMemory ? "0" : "1");
            }
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzgo)).booleanValue()) {
            int iZzf = com.google.android.gms.ads.nonagon.signalgeneration.zzq.zzf(zzffgVar) - 1;
            if (iZzf == 0) {
                concurrentHashMapZzc.put("request_id", str);
                concurrentHashMapZzc.put("scar", "false");
                return;
            }
            if (iZzf == 1) {
                concurrentHashMapZzc.put("request_id", str);
                concurrentHashMapZzc.put("se", "query_g");
            } else if (iZzf == 2) {
                concurrentHashMapZzc.put("se", "r_adinfo");
            } else if (iZzf != 3) {
                concurrentHashMapZzc.put("se", "r_both");
            } else {
                concurrentHashMapZzc.put("se", "r_adstring");
            }
            concurrentHashMapZzc.put("scar", com.ironsource.mediationsdk.metadata.a.f13688g);
            zzc("ragent", zzffgVar.zzd.zzp);
            zzc("rtype", com.google.android.gms.ads.nonagon.signalgeneration.zzq.zzb(com.google.android.gms.ads.nonagon.signalgeneration.zzq.zzc(zzffgVar.zzd)));
        }
    }

    public final Bundle zza() {
        return this.zzg;
    }

    public final Map zzb() {
        return this.zza;
    }

    public final void zzc(String str, @Nullable String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        this.zza.put(str, str2);
    }

    public final void zzd(zzfex zzfexVar) {
        if (!zzfexVar.zzb.zza.isEmpty()) {
            zzfel zzfelVar = (zzfel) zzfexVar.zzb.zza.get(0);
            zzc("ad_format", zzfel.zza(zzfelVar.zzb));
            if (zzfelVar.zzb == 6) {
                this.zza.put("as", true != this.zzb.zzm() ? "0" : "1");
            }
        }
        zzc("gqi", zzfexVar.zzb.zzb.zzb);
    }

    public final void zze(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        if (bundle.containsKey("cnt")) {
            zzc("network_coarse", Integer.toString(bundle.getInt("cnt")));
        }
        if (bundle.containsKey("gnt")) {
            zzc("network_fine", Integer.toString(bundle.getInt("gnt")));
        }
    }
}
