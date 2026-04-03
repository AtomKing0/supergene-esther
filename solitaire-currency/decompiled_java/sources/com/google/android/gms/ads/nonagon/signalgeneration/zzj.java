package com.google.android.gms.ads.nonagon.signalgeneration;

import android.util.Pair;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzj extends LinkedHashMap {
    final /* synthetic */ zzl zza;

    zzj(zzl zzlVar) {
        this.zza = zzlVar;
    }

    @Override // java.util.LinkedHashMap
    protected final boolean removeEldestEntry(Map.Entry entry) {
        synchronized (this.zza) {
            int size = size();
            zzl zzlVar = this.zza;
            if (size <= zzlVar.zza) {
                return false;
            }
            zzlVar.zzf.add(new Pair((String) entry.getKey(), ((zzk) entry.getValue()).zzb));
            return size() > this.zza.zza;
        }
    }
}
