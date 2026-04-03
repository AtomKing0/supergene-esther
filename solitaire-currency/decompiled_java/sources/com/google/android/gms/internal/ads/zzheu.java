package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class zzheu {
    public static zzheu zzb(Class cls) {
        return System.getProperty("java.vm.name").equalsIgnoreCase("Dalvik") ? new zzhep(cls.getSimpleName()) : new zzher(cls.getSimpleName());
    }

    public abstract void zza(String str);
}
