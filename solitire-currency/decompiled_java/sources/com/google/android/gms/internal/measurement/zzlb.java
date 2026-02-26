package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@21.6.1 */
/* JADX INFO: loaded from: classes3.dex */
final class zzlb {
    private static final zzkz zza = zzc();
    private static final zzkz zzb = new zzlc();

    static zzkz zza() {
        return zza;
    }

    static zzkz zzb() {
        return zzb;
    }

    private static zzkz zzc() {
        try {
            return (zzkz) Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
