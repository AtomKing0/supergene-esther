package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.Size;
import java.net.UnknownHostException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzea {
    private static final Object zza = new Object();

    public static String zza(String str, @Nullable Throwable th) {
        String strReplace;
        if (th != null) {
            synchronized (zza) {
                Throwable cause = th;
                while (true) {
                    if (cause == null) {
                        strReplace = Log.getStackTraceString(th).trim().replace("\t", "    ");
                        break;
                    }
                    if (cause instanceof UnknownHostException) {
                        strReplace = "UnknownHostException (no network)";
                        break;
                    }
                    cause = cause.getCause();
                }
            }
        } else {
            strReplace = null;
        }
        if (TextUtils.isEmpty(strReplace)) {
            return str;
        }
        return str + "\n  " + strReplace.replace("\n", "\n  ") + "\n";
    }

    public static void zzb(@Size(max = 23) String str, String str2) {
        synchronized (zza) {
            Log.d(str, zza(str2, null));
        }
    }

    public static void zzc(@Size(max = 23) String str, String str2) {
        synchronized (zza) {
            Log.e(str, zza(str2, null));
        }
    }

    public static void zzd(@Size(max = 23) String str, String str2, @Nullable Throwable th) {
        synchronized (zza) {
            Log.e(str, zza(str2, th));
        }
    }

    public static void zze(@Size(max = 23) String str, String str2) {
        synchronized (zza) {
            Log.i(str, zza(str2, null));
        }
    }

    public static void zzf(@Size(max = 23) String str, String str2) {
        synchronized (zza) {
            Log.w(str, zza(str2, null));
        }
    }

    public static void zzg(@Size(max = 23) String str, String str2, @Nullable Throwable th) {
        synchronized (zza) {
            Log.w(str, zza(str2, th));
        }
    }
}
