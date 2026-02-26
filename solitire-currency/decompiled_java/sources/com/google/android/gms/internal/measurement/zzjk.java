package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@21.6.1 */
/* JADX INFO: loaded from: classes3.dex */
final class zzjk {
    private static final zzji<?> zza = new zzjh();
    private static final zzji<?> zzb = zzc();

    static zzji<?> zza() {
        zzji<?> zzjiVar = zzb;
        if (zzjiVar != null) {
            return zzjiVar;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }

    static zzji<?> zzb() {
        return zza;
    }

    private static zzji<?> zzc() {
        try {
            return (zzji) Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
