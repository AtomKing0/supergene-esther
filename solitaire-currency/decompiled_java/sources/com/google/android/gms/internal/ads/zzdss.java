package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import com.google.android.gms.ads.nonagon.util.logging.csi.CsiUrlBuilder;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public class zzdss {
    protected final Map zza;
    protected final Context zzb;
    protected final Executor zzc;
    protected final com.google.android.gms.ads.internal.util.client.zzr zzd;
    protected final boolean zze;
    private final CsiUrlBuilder zzf;
    private final boolean zzg;
    private final boolean zzh;
    private final AtomicBoolean zzi;
    private final AtomicReference zzj;

    protected zzdss(Executor executor, com.google.android.gms.ads.internal.util.client.zzr zzrVar, CsiUrlBuilder csiUrlBuilder, Context context) {
        this.zza = new HashMap();
        this.zzi = new AtomicBoolean();
        this.zzj = new AtomicReference(new Bundle());
        this.zzc = executor;
        this.zzd = zzrVar;
        this.zze = ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzbN)).booleanValue();
        this.zzf = csiUrlBuilder;
        this.zzg = ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzbQ)).booleanValue();
        this.zzh = ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzgp)).booleanValue();
        this.zzb = context;
    }

    private final void zza(Map map, boolean z10) {
        if (map.isEmpty()) {
            com.google.android.gms.ads.internal.util.client.zzm.zze("Empty paramMap.");
            return;
        }
        if (map.isEmpty()) {
            com.google.android.gms.ads.internal.util.client.zzm.zze("Empty or null paramMap.");
        } else {
            if (!this.zzi.getAndSet(true)) {
                final String str = (String) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzjF);
                this.zzj.set(com.google.android.gms.ads.internal.util.zzad.zza(this.zzb, str, new SharedPreferences.OnSharedPreferenceChangeListener() { // from class: com.google.android.gms.internal.ads.zzdsr
                    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
                    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str2) {
                        this.zza.zzd(str, sharedPreferences, str2);
                    }
                }));
            }
            Bundle bundle = (Bundle) this.zzj.get();
            for (String str2 : bundle.keySet()) {
                map.put(str2, String.valueOf(bundle.get(str2)));
            }
        }
        final String strGenerateUrl = this.zzf.generateUrl(map);
        com.google.android.gms.ads.internal.util.zze.zza(strGenerateUrl);
        boolean z11 = Boolean.parseBoolean((String) map.get("scar"));
        if (this.zze) {
            if (!z10 || this.zzg) {
                if (!z11 || this.zzh) {
                    this.zzc.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdsq
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.zza.zzd.zza(strGenerateUrl);
                        }
                    });
                }
            }
        }
    }

    protected final String zzb(Map map) {
        return this.zzf.generateUrl(map);
    }

    public final ConcurrentHashMap zzc() {
        return new ConcurrentHashMap(this.zza);
    }

    final /* synthetic */ void zzd(String str, SharedPreferences sharedPreferences, String str2) {
        this.zzj.set(com.google.android.gms.ads.internal.util.zzad.zzb(this.zzb, str));
    }

    public final void zze(Map map) {
        zza(map, true);
    }

    public final void zzf(Map map) {
        zza(map, false);
    }
}
