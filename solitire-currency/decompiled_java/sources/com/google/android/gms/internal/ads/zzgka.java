package com.google.android.gms.internal.ads;

import javax.crypto.Cipher;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzgka {
    public static final /* synthetic */ int zza = 0;
    private static final ThreadLocal zzb = new zzgjz();

    public static Cipher zza() {
        return (Cipher) zzb.get();
    }
}
