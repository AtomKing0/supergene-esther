package com.google.android.gms.measurement.internal;

import androidx.annotation.NonNull;
import androidx.collection.ArrayMap;
import com.google.android.gms.internal.measurement.zzft;
import com.google.android.gms.internal.measurement.zzou;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@21.6.1 */
/* JADX INFO: loaded from: classes3.dex */
final class zzu {
    private String zza;
    private boolean zzb;
    private zzft.zzl zzc;
    private BitSet zzd;
    private BitSet zze;
    private Map<Integer, Long> zzf;
    private Map<Integer, List<Long>> zzg;
    private final /* synthetic */ zzs zzh;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [com.google.android.gms.internal.measurement.zzft$zzc$zza, com.google.android.gms.internal.measurement.zzjt$zza] */
    /* JADX WARN: Type inference failed for: r1v10, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r1v8, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r1v9, types: [java.lang.Iterable] */
    /* JADX WARN: Type inference failed for: r7v5, types: [com.google.android.gms.internal.measurement.zzft$zzl$zza] */
    @NonNull
    final zzft.zzc zza(int i10) {
        ArrayList arrayList;
        ?? arrayList2;
        ?? Zzb = zzft.zzc.zzb();
        Zzb.zza(i10);
        Zzb.zza(this.zzb);
        zzft.zzl zzlVar = this.zzc;
        if (zzlVar != null) {
            Zzb.zza(zzlVar);
        }
        ?? Zzd = zzft.zzl.zze().zzb(zznm.zza(this.zzd)).zzd(zznm.zza(this.zze));
        if (this.zzf == null) {
            arrayList = null;
        } else {
            arrayList = new ArrayList(this.zzf.size());
            Iterator<Integer> it = this.zzf.keySet().iterator();
            while (it.hasNext()) {
                int iIntValue = it.next().intValue();
                Long l10 = this.zzf.get(Integer.valueOf(iIntValue));
                if (l10 != null) {
                    arrayList.add((zzft.zzd) ((com.google.android.gms.internal.measurement.zzjt) zzft.zzd.zzc().zza(iIntValue).zza(l10.longValue()).zzah()));
                }
            }
        }
        if (arrayList != null) {
            Zzd.zza(arrayList);
        }
        if (this.zzg == null) {
            arrayList2 = Collections.emptyList();
        } else {
            arrayList2 = new ArrayList(this.zzg.size());
            for (Integer num : this.zzg.keySet()) {
                zzft.zzm.zza zzaVarZza = zzft.zzm.zzc().zza(num.intValue());
                List<Long> list = this.zzg.get(num);
                if (list != null) {
                    Collections.sort(list);
                    zzaVarZza.zza(list);
                }
                arrayList2.add((zzft.zzm) ((com.google.android.gms.internal.measurement.zzjt) zzaVarZza.zzah()));
            }
        }
        Zzd.zzc(arrayList2);
        Zzb.zza(Zzd);
        return (zzft.zzc) ((com.google.android.gms.internal.measurement.zzjt) Zzb.zzah());
    }

    private zzu(zzs zzsVar, String str) {
        this.zzh = zzsVar;
        this.zza = str;
        this.zzb = true;
        this.zzd = new BitSet();
        this.zze = new BitSet();
        this.zzf = new ArrayMap();
        this.zzg = new ArrayMap();
    }

    private zzu(zzs zzsVar, String str, zzft.zzl zzlVar, BitSet bitSet, BitSet bitSet2, Map<Integer, Long> map, Map<Integer, Long> map2) {
        this.zzh = zzsVar;
        this.zza = str;
        this.zzd = bitSet;
        this.zze = bitSet2;
        this.zzf = map;
        this.zzg = new ArrayMap();
        if (map2 != null) {
            for (Integer num : map2.keySet()) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(map2.get(num));
                this.zzg.put(num, arrayList);
            }
        }
        this.zzb = false;
        this.zzc = zzlVar;
    }

    final void zza(@NonNull zzab zzabVar) {
        int iZza = zzabVar.zza();
        Boolean bool = zzabVar.zzc;
        if (bool != null) {
            this.zze.set(iZza, bool.booleanValue());
        }
        Boolean bool2 = zzabVar.zzd;
        if (bool2 != null) {
            this.zzd.set(iZza, bool2.booleanValue());
        }
        if (zzabVar.zze != null) {
            Long l10 = this.zzf.get(Integer.valueOf(iZza));
            long jLongValue = zzabVar.zze.longValue() / 1000;
            if (l10 == null || jLongValue > l10.longValue()) {
                this.zzf.put(Integer.valueOf(iZza), Long.valueOf(jLongValue));
            }
        }
        if (zzabVar.zzf != null) {
            List<Long> arrayList = this.zzg.get(Integer.valueOf(iZza));
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                this.zzg.put(Integer.valueOf(iZza), arrayList);
            }
            if (zzabVar.zzc()) {
                arrayList.clear();
            }
            if (zzou.zza() && this.zzh.zze().zzf(this.zza, zzbh.zzbi) && zzabVar.zzb()) {
                arrayList.clear();
            }
            if (zzou.zza() && this.zzh.zze().zzf(this.zza, zzbh.zzbi)) {
                long jLongValue2 = zzabVar.zzf.longValue() / 1000;
                if (arrayList.contains(Long.valueOf(jLongValue2))) {
                    return;
                }
                arrayList.add(Long.valueOf(jLongValue2));
                return;
            }
            arrayList.add(Long.valueOf(zzabVar.zzf.longValue() / 1000));
        }
    }
}
