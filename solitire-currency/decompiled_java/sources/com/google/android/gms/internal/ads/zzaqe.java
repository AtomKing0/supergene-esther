package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzaqe {
    public static long zza(String str) {
        try {
            return zzd("EEE, dd MMM yyyy HH:mm:ss zzz").parse(str).getTime();
        } catch (ParseException e10) {
            if ("0".equals(str) || "-1".equals(str)) {
                zzapt.zzd("Unable to parse dateStr: %s, falling back to 0", str);
                return 0L;
            }
            zzapt.zzc(e10, "Unable to parse dateStr: %s, falling back to 0", str);
            return 0L;
        }
    }

    @Nullable
    public static zzaoq zzb(zzapd zzapdVar) {
        boolean z10;
        long j10;
        long j11;
        long j12;
        long j13;
        long j14;
        long jCurrentTimeMillis = System.currentTimeMillis();
        Map map = zzapdVar.zzc;
        if (map == null) {
            return null;
        }
        String str = (String) map.get("Date");
        long jZza = str != null ? zza(str) : 0L;
        String str2 = (String) map.get("Cache-Control");
        int i10 = 0;
        if (str2 != null) {
            String[] strArrSplit = str2.split(",", 0);
            z10 = false;
            j10 = 0;
            j11 = 0;
            while (i10 < strArrSplit.length) {
                String strTrim = strArrSplit[i10].trim();
                if (strTrim.equals("no-cache") || strTrim.equals("no-store")) {
                    return null;
                }
                if (strTrim.startsWith("max-age=")) {
                    try {
                        j11 = Long.parseLong(strTrim.substring(8));
                    } catch (Exception unused) {
                    }
                } else if (strTrim.startsWith("stale-while-revalidate=")) {
                    j10 = Long.parseLong(strTrim.substring(23));
                } else if (strTrim.equals("must-revalidate") || strTrim.equals("proxy-revalidate")) {
                    z10 = true;
                }
                i10++;
            }
            i10 = 1;
        } else {
            z10 = false;
            j10 = 0;
            j11 = 0;
        }
        String str3 = (String) map.get("Expires");
        long jZza2 = str3 != null ? zza(str3) : 0L;
        String str4 = (String) map.get("Last-Modified");
        long jZza3 = str4 != null ? zza(str4) : 0L;
        String str5 = (String) map.get("ETag");
        if (i10 != 0) {
            j13 = jCurrentTimeMillis + (j11 * 1000);
            if (z10) {
                j14 = j13;
            } else {
                Long.signum(j10);
                j14 = (j10 * 1000) + j13;
            }
            j12 = j14;
        } else {
            j12 = 0;
            if (jZza <= 0 || jZza2 < jZza) {
                j13 = 0;
            } else {
                j13 = jCurrentTimeMillis + (jZza2 - jZza);
                j12 = j13;
            }
        }
        zzaoq zzaoqVar = new zzaoq();
        zzaoqVar.zza = zzapdVar.zzb;
        zzaoqVar.zzb = str5;
        zzaoqVar.zzf = j13;
        zzaoqVar.zze = j12;
        zzaoqVar.zzc = jZza;
        zzaoqVar.zzd = jZza3;
        zzaoqVar.zzg = map;
        zzaoqVar.zzh = zzapdVar.zzd;
        return zzaoqVar;
    }

    static String zzc(long j10) {
        return zzd("EEE, dd MMM yyyy HH:mm:ss 'GMT'").format(new Date(j10));
    }

    private static SimpleDateFormat zzd(String str) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str, Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        return simpleDateFormat;
    }
}
