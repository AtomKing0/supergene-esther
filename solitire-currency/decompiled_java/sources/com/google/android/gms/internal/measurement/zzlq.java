package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@21.6.1 */
/* JADX INFO: loaded from: classes3.dex */
final class zzlq {
    private static final zzlo zza = zzc();
    private static final zzlo zzb = new zzln();

    static zzlo zza() {
        return zza;
    }

    static zzlo zzb() {
        return zzb;
    }

    private static zzlo zzc() {
        try {
            return (zzlo) Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
