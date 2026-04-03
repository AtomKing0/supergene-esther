package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzhfq implements zzhfc {
    private final List zza;
    private final List zzb;

    static {
        zzhfd.zza(Collections.emptySet());
    }

    /* synthetic */ zzhfq(List list, List list2, zzhfo zzhfoVar) {
        this.zza = list;
        this.zzb = list2;
    }

    public static zzhfp zza(int i10, int i11) {
        return new zzhfp(i10, i11, null);
    }

    @Override // com.google.android.gms.internal.ads.zzhfu, com.google.android.gms.internal.ads.zzhft
    /* JADX INFO: renamed from: zzc, reason: merged with bridge method [inline-methods] */
    public final Set zzb() {
        int size = this.zza.size();
        ArrayList arrayList = new ArrayList(this.zzb.size());
        int size2 = this.zzb.size();
        for (int i10 = 0; i10 < size2; i10++) {
            Collection collection = (Collection) ((zzhfl) this.zzb.get(i10)).zzb();
            size += collection.size();
            arrayList.add(collection);
        }
        HashSet hashSetZza = zzhez.zza(size);
        int size3 = this.zza.size();
        for (int i11 = 0; i11 < size3; i11++) {
            Object objZzb = ((zzhfl) this.zza.get(i11)).zzb();
            objZzb.getClass();
            hashSetZza.add(objZzb);
        }
        int size4 = arrayList.size();
        for (int i12 = 0; i12 < size4; i12++) {
            for (Object obj : (Collection) arrayList.get(i12)) {
                obj.getClass();
                hashSetZza.add(obj);
            }
        }
        return Collections.unmodifiableSet(hashSetZza);
    }
}
