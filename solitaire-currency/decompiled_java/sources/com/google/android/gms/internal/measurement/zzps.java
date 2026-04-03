package com.google.android.gms.internal.measurement;

import e5.u;
import e5.v;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzps implements u<zzpv> {
    private static zzps zza = new zzps();
    private final u<zzpv> zzb = v.b(new zzpu());

    public static double zza() {
        return ((zzpv) zza.get()).zza();
    }

    public static long zzb() {
        return ((zzpv) zza.get()).zzb();
    }

    public static long zzc() {
        return ((zzpv) zza.get()).zzc();
    }

    public static String zzd() {
        return ((zzpv) zza.get()).zzd();
    }

    public static boolean zze() {
        return ((zzpv) zza.get()).zze();
    }

    @Override // e5.u
    public final /* synthetic */ zzpv get() {
        return this.zzb.get();
    }
}
