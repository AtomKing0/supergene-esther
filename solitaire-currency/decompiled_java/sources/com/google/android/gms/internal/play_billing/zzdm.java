package com.google.android.gms.internal.play_billing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: com.android.billingclient:billing@@7.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzdm extends zzdq {
    private static final Class zza = Collections.unmodifiableList(Collections.emptyList()).getClass();

    private zzdm() {
        throw null;
    }

    @Override // com.google.android.gms.internal.play_billing.zzdq
    final void zza(Object obj, long j10) {
        Object objUnmodifiableList;
        List list = (List) zzfp.zzf(obj, j10);
        if (list instanceof zzdk) {
            objUnmodifiableList = ((zzdk) list).zze();
        } else {
            if (zza.isAssignableFrom(list.getClass())) {
                return;
            }
            if ((list instanceof zzek) && (list instanceof zzcz)) {
                zzcz zzczVar = (zzcz) list;
                if (zzczVar.zzc()) {
                    zzczVar.zzb();
                    return;
                }
                return;
            }
            objUnmodifiableList = Collections.unmodifiableList(list);
        }
        zzfp.zzs(obj, j10, objUnmodifiableList);
    }

    @Override // com.google.android.gms.internal.play_billing.zzdq
    final void zzb(Object obj, Object obj2, long j10) {
        List list;
        List list2;
        List list3 = (List) zzfp.zzf(obj2, j10);
        int size = list3.size();
        List list4 = (List) zzfp.zzf(obj, j10);
        if (list4.isEmpty()) {
            List zzdjVar = list4 instanceof zzdk ? new zzdj(size) : ((list4 instanceof zzek) && (list4 instanceof zzcz)) ? ((zzcz) list4).zzd(size) : new ArrayList(size);
            zzfp.zzs(obj, j10, zzdjVar);
            list2 = zzdjVar;
        } else {
            if (zza.isAssignableFrom(list4.getClass())) {
                ArrayList arrayList = new ArrayList(list4.size() + size);
                arrayList.addAll(list4);
                zzfp.zzs(obj, j10, arrayList);
                list = arrayList;
            } else if (list4 instanceof zzfk) {
                zzdj zzdjVar2 = new zzdj(list4.size() + size);
                zzdjVar2.addAll(zzdjVar2.size(), (zzfk) list4);
                zzfp.zzs(obj, j10, zzdjVar2);
                list = zzdjVar2;
            } else {
                boolean z10 = list4 instanceof zzek;
                list2 = list4;
                if (z10) {
                    boolean z11 = list4 instanceof zzcz;
                    list2 = list4;
                    if (z11) {
                        zzcz zzczVar = (zzcz) list4;
                        list2 = list4;
                        if (!zzczVar.zzc()) {
                            zzcz zzczVarZzd = zzczVar.zzd(list4.size() + size);
                            zzfp.zzs(obj, j10, zzczVarZzd);
                            list2 = zzczVarZzd;
                        }
                    }
                }
            }
            list2 = list;
        }
        int size2 = list2.size();
        int size3 = list3.size();
        if (size2 > 0 && size3 > 0) {
            list2.addAll(list3);
        }
        if (size2 > 0) {
            list3 = list2;
        }
        zzfp.zzs(obj, j10, list3);
    }

    /* synthetic */ zzdm(zzdl zzdlVar) {
        super(null);
    }
}
