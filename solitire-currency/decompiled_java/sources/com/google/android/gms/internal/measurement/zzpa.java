package com.google.android.gms.internal.measurement;

import e5.u;
import e5.v;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzpa implements u<zzpd> {
    private static zzpa zza = new zzpa();
    private final u<zzpd> zzb = v.b(new zzpc());

    public static boolean zza() {
        return ((zzpd) zza.get()).zza();
    }

    public static boolean zzb() {
        return ((zzpd) zza.get()).zzb();
    }

    @Override // e5.u
    public final /* synthetic */ zzpd get() {
        return this.zzb.get();
    }
}
