package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzgnz extends RuntimeException {
    public zzgnz(String str) {
        super(str);
    }

    public static Object zza(zzgny zzgnyVar) {
        try {
            return zzgnyVar.zza();
        } catch (Exception e10) {
            throw new zzgnz(e10);
        }
    }

    public zzgnz(String str, Throwable th) {
        super(str, th);
    }

    public zzgnz(Throwable th) {
        super(th);
    }
}
