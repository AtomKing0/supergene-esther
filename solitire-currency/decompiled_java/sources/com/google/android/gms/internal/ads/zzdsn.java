package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdsn implements zzfjm {
    private final zzdsf zzb;
    private final Clock zzc;
    private final Map zza = new HashMap();
    private final Map zzd = new HashMap();

    public zzdsn(zzdsf zzdsfVar, Set set, Clock clock) {
        this.zzb = zzdsfVar;
        Iterator it = set.iterator();
        while (it.hasNext()) {
            zzdsm zzdsmVar = (zzdsm) it.next();
            this.zzd.put(zzdsmVar.zzc, zzdsmVar);
        }
        this.zzc = clock;
    }

    private final void zze(zzfjf zzfjfVar, boolean z10) {
        zzfjf zzfjfVar2 = ((zzdsm) this.zzd.get(zzfjfVar)).zzb;
        if (this.zza.containsKey(zzfjfVar2)) {
            String str = true != z10 ? "f." : "s.";
            long jElapsedRealtime = this.zzc.elapsedRealtime() - ((Long) this.zza.get(zzfjfVar2)).longValue();
            this.zzb.zzb().put("label.".concat(((zzdsm) this.zzd.get(zzfjfVar)).zza), str.concat(String.valueOf(Long.toString(jElapsedRealtime))));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfjm
    public final void zzd(zzfjf zzfjfVar, String str) {
        if (this.zza.containsKey(zzfjfVar)) {
            long jElapsedRealtime = this.zzc.elapsedRealtime() - ((Long) this.zza.get(zzfjfVar)).longValue();
            zzdsf zzdsfVar = this.zzb;
            String strValueOf = String.valueOf(str);
            zzdsfVar.zzb().put("task.".concat(strValueOf), "s.".concat(String.valueOf(Long.toString(jElapsedRealtime))));
        }
        if (this.zzd.containsKey(zzfjfVar)) {
            zze(zzfjfVar, true);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfjm
    public final void zzdD(zzfjf zzfjfVar, String str, Throwable th) {
        if (this.zza.containsKey(zzfjfVar)) {
            long jElapsedRealtime = this.zzc.elapsedRealtime() - ((Long) this.zza.get(zzfjfVar)).longValue();
            zzdsf zzdsfVar = this.zzb;
            String strValueOf = String.valueOf(str);
            zzdsfVar.zzb().put("task.".concat(strValueOf), "f.".concat(String.valueOf(Long.toString(jElapsedRealtime))));
        }
        if (this.zzd.containsKey(zzfjfVar)) {
            zze(zzfjfVar, false);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfjm
    public final void zzdE(zzfjf zzfjfVar, String str) {
        this.zza.put(zzfjfVar, Long.valueOf(this.zzc.elapsedRealtime()));
    }

    @Override // com.google.android.gms.internal.ads.zzfjm
    public final void zzdC(zzfjf zzfjfVar, String str) {
    }
}
