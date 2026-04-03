package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.m;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzcsc implements zzeio {
    public final List zza;

    public zzcsc(List list) {
        this.zza = list;
    }

    @Override // com.google.android.gms.internal.ads.zzeio
    public final void zzr() {
        Iterator it = this.zza.iterator();
        while (it.hasNext()) {
            zzgcj.zzr((m) it.next(), new zzcsb(this), zzgda.zzb());
        }
    }

    public zzcsc(zzcru zzcruVar) {
        this.zza = Collections.singletonList(zzgcj.zzh(zzcruVar));
    }
}
