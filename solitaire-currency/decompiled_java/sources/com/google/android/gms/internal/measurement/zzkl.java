package com.google.android.gms.internal.measurement;

import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@21.6.1 */
/* JADX INFO: loaded from: classes3.dex */
abstract class zzkl {
    private static final zzkl zza = new zzko();
    private static final zzkl zzb = new zzkq();

    private zzkl() {
    }

    static zzkl zza() {
        return zza;
    }

    static zzkl zzb() {
        return zzb;
    }

    abstract <L> List<L> zza(Object obj, long j10);

    abstract <L> void zza(Object obj, Object obj2, long j10);

    abstract void zzb(Object obj, long j10);
}
