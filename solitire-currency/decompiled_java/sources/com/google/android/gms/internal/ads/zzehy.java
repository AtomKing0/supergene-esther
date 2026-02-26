package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import androidx.annotation.GuardedBy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzehy {

    @GuardedBy("this")
    private final zzgdc zzc;

    @GuardedBy("this")
    private zzeio zzf;
    private final String zzh;
    private final int zzi;
    private final zzein zzj;
    private zzfel zzk;

    @GuardedBy("this")
    private final Map zza = new HashMap();

    @GuardedBy("this")
    private final List zzb = new ArrayList();

    @GuardedBy("this")
    private final List zzd = new ArrayList();

    @GuardedBy("this")
    private final Set zze = new HashSet();

    @GuardedBy("this")
    private int zzg = Integer.MAX_VALUE;

    @GuardedBy("this")
    private boolean zzl = false;

    zzehy(zzfex zzfexVar, zzein zzeinVar, zzgdc zzgdcVar) {
        this.zzi = zzfexVar.zzb.zzb.zzr;
        this.zzj = zzeinVar;
        this.zzc = zzgdcVar;
        this.zzh = zzeiu.zzc(zzfexVar);
        List list = zzfexVar.zzb.zza;
        for (int i10 = 0; i10 < list.size(); i10++) {
            this.zza.put((zzfel) list.get(i10), Integer.valueOf(i10));
        }
        this.zzb.addAll(list);
    }

    private final synchronized void zze() {
        this.zzj.zzi(this.zzk);
        zzeio zzeioVar = this.zzf;
        if (zzeioVar != null) {
            this.zzc.zzc(zzeioVar);
        } else {
            this.zzc.zzd(new zzeir(3, this.zzh));
        }
    }

    private final synchronized boolean zzf(boolean z10) {
        for (zzfel zzfelVar : this.zzb) {
            Integer num = (Integer) this.zza.get(zzfelVar);
            Integer numValueOf = Integer.valueOf(num != null ? num.intValue() : Integer.MAX_VALUE);
            if (z10 || !this.zze.contains(zzfelVar.zzat)) {
                if (numValueOf.intValue() < this.zzg) {
                    return true;
                }
                if (numValueOf.intValue() > this.zzg) {
                    break;
                }
            }
        }
        return false;
    }

    private final synchronized boolean zzg() {
        Iterator it = this.zzd.iterator();
        while (it.hasNext()) {
            Integer num = (Integer) this.zza.get((zzfel) it.next());
            if (Integer.valueOf(num != null ? num.intValue() : Integer.MAX_VALUE).intValue() < this.zzg) {
                return true;
            }
        }
        return false;
    }

    private final synchronized boolean zzh() {
        if (!zzf(true)) {
            if (!zzg()) {
                return false;
            }
        }
        return true;
    }

    private final synchronized boolean zzi() {
        if (this.zzl) {
            return false;
        }
        if (!this.zzb.isEmpty() && ((zzfel) this.zzb.get(0)).zzav && !this.zzd.isEmpty()) {
            return false;
        }
        if (!zzd()) {
            List list = this.zzd;
            if (list.size() < this.zzi) {
                if (zzf(false)) {
                    return true;
                }
            }
        }
        return false;
    }

    final synchronized zzfel zza() {
        if (zzi()) {
            for (int i10 = 0; i10 < this.zzb.size(); i10++) {
                zzfel zzfelVar = (zzfel) this.zzb.get(i10);
                String str = zzfelVar.zzat;
                if (!this.zze.contains(str)) {
                    if (zzfelVar.zzav) {
                        this.zzl = true;
                    }
                    if (!TextUtils.isEmpty(str)) {
                        this.zze.add(str);
                    }
                    this.zzd.add(zzfelVar);
                    return (zzfel) this.zzb.remove(i10);
                }
            }
        }
        return null;
    }

    final synchronized void zzb(Throwable th, zzfel zzfelVar) {
        this.zzl = false;
        this.zzd.remove(zzfelVar);
        this.zze.remove(zzfelVar.zzat);
        if (zzd() || zzh()) {
            return;
        }
        zze();
    }

    final synchronized void zzc(zzeio zzeioVar, zzfel zzfelVar) {
        this.zzl = false;
        this.zzd.remove(zzfelVar);
        if (zzd()) {
            zzeioVar.zzr();
            return;
        }
        Integer num = (Integer) this.zza.get(zzfelVar);
        Integer numValueOf = Integer.valueOf(num != null ? num.intValue() : Integer.MAX_VALUE);
        if (numValueOf.intValue() > this.zzg) {
            this.zzj.zzm(zzfelVar);
            return;
        }
        if (this.zzf != null) {
            this.zzj.zzm(this.zzk);
        }
        this.zzg = numValueOf.intValue();
        this.zzf = zzeioVar;
        this.zzk = zzfelVar;
        if (zzh()) {
            return;
        }
        zze();
    }

    final synchronized boolean zzd() {
        return this.zzc.isDone();
    }
}
