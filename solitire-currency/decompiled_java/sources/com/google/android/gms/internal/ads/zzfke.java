package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.common.util.concurrent.m;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzfke {
    public static void zza(m mVar, zzfkf zzfkfVar, zzfju zzfjuVar) {
        zzg(mVar, zzfkfVar, zzfjuVar, false);
    }

    public static void zzb(m mVar, zzfkf zzfkfVar, zzfju zzfjuVar) {
        zzg(mVar, zzfkfVar, zzfjuVar, true);
    }

    public static void zzc(m mVar, zzfkf zzfkfVar, zzfju zzfjuVar) {
        if (((Boolean) zzbdl.zzc.zze()).booleanValue()) {
            zzgcj.zzr(zzgca.zzu(mVar), new zzfkd(zzfkfVar, zzfjuVar), zzbzo.zzf);
        }
    }

    public static void zzd(m mVar, zzfju zzfjuVar) {
        if (((Boolean) zzbdl.zzc.zze()).booleanValue()) {
            zzgcj.zzr(zzgca.zzu(mVar), new zzfkb(zzfjuVar), zzbzo.zzf);
        }
    }

    public static boolean zze(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return Pattern.matches((String) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzhU), str);
    }

    public static int zzf(zzffg zzffgVar) {
        int iZzf = com.google.android.gms.ads.nonagon.signalgeneration.zzq.zzf(zzffgVar) - 1;
        return (iZzf == 0 || iZzf == 1) ? 7 : 23;
    }

    private static void zzg(m mVar, zzfkf zzfkfVar, zzfju zzfjuVar, boolean z10) {
        if (((Boolean) zzbdl.zzc.zze()).booleanValue()) {
            zzgcj.zzr(zzgca.zzu(mVar), new zzfkc(zzfkfVar, zzfjuVar, z10), zzbzo.zzf);
        }
    }
}
