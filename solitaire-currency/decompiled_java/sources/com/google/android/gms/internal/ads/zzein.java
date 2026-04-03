package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import com.google.android.gms.common.util.Clock;
import com.google.common.util.concurrent.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzein {
    private final Clock zza;
    private final zzeip zzb;
    private final zzfll zzc;

    @GuardedBy("this")
    private final LinkedHashMap zzd = new LinkedHashMap();
    private final boolean zze = ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzgh)).booleanValue();
    private final zzeey zzf;
    private boolean zzg;
    private long zzh;
    private long zzi;

    public zzein(Clock clock, zzeip zzeipVar, zzeey zzeeyVar, zzfll zzfllVar) {
        this.zza = clock;
        this.zzb = zzeipVar;
        this.zzf = zzeeyVar;
        this.zzc = zzfllVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized boolean zzq(zzfel zzfelVar) {
        zzeim zzeimVar = (zzeim) this.zzd.get(zzfelVar);
        if (zzeimVar == null) {
            return false;
        }
        return zzeimVar.zzc == 8;
    }

    public final synchronized long zza() {
        return this.zzh;
    }

    final synchronized m zzf(zzfex zzfexVar, zzfel zzfelVar, m mVar, zzflh zzflhVar) {
        zzfeo zzfeoVar = zzfexVar.zzb.zzb;
        long jElapsedRealtime = this.zza.elapsedRealtime();
        String str = zzfelVar.zzw;
        if (str != null) {
            this.zzd.put(zzfelVar, new zzeim(str, zzfelVar.zzaf, 9, 0L, null));
            zzgcj.zzr(mVar, new zzeil(this, jElapsedRealtime, zzfeoVar, zzfelVar, str, zzflhVar, zzfexVar), zzbzo.zzf);
        }
        return mVar;
    }

    public final synchronized String zzg() {
        ArrayList arrayList;
        arrayList = new ArrayList();
        Iterator it = this.zzd.entrySet().iterator();
        while (it.hasNext()) {
            zzeim zzeimVar = (zzeim) ((Map.Entry) it.next()).getValue();
            if (zzeimVar.zzc != Integer.MAX_VALUE) {
                arrayList.add(zzeimVar.toString());
            }
        }
        return TextUtils.join("_", arrayList);
    }

    public final synchronized void zzi(@Nullable zzfel zzfelVar) {
        this.zzh = this.zza.elapsedRealtime() - this.zzi;
        if (zzfelVar != null) {
            this.zzf.zze(zzfelVar);
        }
        this.zzg = true;
    }

    public final synchronized void zzj() {
        this.zzh = this.zza.elapsedRealtime() - this.zzi;
    }

    public final synchronized void zzk(List list) {
        this.zzi = this.zza.elapsedRealtime();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            zzfel zzfelVar = (zzfel) it.next();
            if (!TextUtils.isEmpty(zzfelVar.zzw)) {
                this.zzd.put(zzfelVar, new zzeim(zzfelVar.zzw, zzfelVar.zzaf, Integer.MAX_VALUE, 0L, null));
            }
        }
    }

    public final synchronized void zzl() {
        this.zzi = this.zza.elapsedRealtime();
    }

    public final synchronized void zzm(zzfel zzfelVar) {
        zzeim zzeimVar = (zzeim) this.zzd.get(zzfelVar);
        if (zzeimVar == null || this.zzg) {
            return;
        }
        zzeimVar.zzc = 8;
    }
}
