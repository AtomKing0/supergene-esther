package com.google.android.gms.internal.consent_sdk;

import android.content.ContentResolver;
import android.content.Context;
import android.provider.Settings;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: compiled from: com.google.android.ump:user-messaging-platform@@3.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzcl {

    @Nullable
    @GuardedBy("DeviceId.class")
    private static String zza;

    public static synchronized String zza(Context context) {
        if (zza == null) {
            ContentResolver contentResolver = context.getContentResolver();
            String string = contentResolver == null ? null : Settings.Secure.getString(contentResolver, "android_id");
            if (string == null || zzct.zza(true)) {
                string = "emulator";
            }
            zza = zzb(string);
        }
        return zza;
    }

    private static String zzb(String str) {
        for (int i10 = 0; i10 < 3; i10++) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                messageDigest.update(str.getBytes());
                return String.format("%032X", new BigInteger(1, messageDigest.digest()));
            } catch (ArithmeticException unused) {
                return "";
            } catch (NoSuchAlgorithmException unused2) {
            }
        }
        return "";
    }
}
