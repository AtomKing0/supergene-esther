package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class zzayx {

    @Nullable
    private static MessageDigest zzb;
    protected final Object zza = new Object();

    @Nullable
    protected final MessageDigest zza() {
        synchronized (this.zza) {
            MessageDigest messageDigest = zzb;
            if (messageDigest != null) {
                return messageDigest;
            }
            for (int i10 = 0; i10 < 2; i10++) {
                try {
                    zzb = MessageDigest.getInstance("MD5");
                } catch (NoSuchAlgorithmException unused) {
                }
            }
            return zzb;
        }
    }

    abstract byte[] zzb(String str);
}
