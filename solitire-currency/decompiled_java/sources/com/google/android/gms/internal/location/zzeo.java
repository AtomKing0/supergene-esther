package com.google.android.gms.internal.location;

import androidx.annotation.GuardedBy;
import androidx.media3.exoplayer.upstream.CmcdData;
import com.vungle.ads.internal.signals.b;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* JADX INFO: compiled from: com.google.android.gms:play-services-location@@21.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzeo {
    private static final SimpleDateFormat zza;
    private static final SimpleDateFormat zzb;

    @GuardedBy("sharedStringBuilder")
    private static final StringBuilder zzc;

    static {
        Locale locale = Locale.ROOT;
        zza = new SimpleDateFormat("MM-dd HH:mm:ss.SSS", locale);
        zzb = new SimpleDateFormat("MM-dd HH:mm:ss", locale);
        zzc = new StringBuilder(33);
    }

    public static String zza(long j10) {
        return j10 >= 0 ? zza.format(new Date(j10)) : Long.toString(j10);
    }

    public static String zzb(long j10) {
        String string;
        StringBuilder sb = zzc;
        synchronized (sb) {
            sb.setLength(0);
            zzc(j10, sb);
            string = sb.toString();
        }
        return string;
    }

    public static StringBuilder zzc(long j10, StringBuilder sb) {
        if (j10 == 0) {
            sb.append("0s");
            return sb;
        }
        sb.ensureCapacity(sb.length() + 27);
        boolean z10 = false;
        if (j10 < 0) {
            sb.append("-");
            if (j10 != Long.MIN_VALUE) {
                j10 = -j10;
            } else {
                j10 = Long.MAX_VALUE;
                z10 = true;
            }
        }
        if (j10 >= b.TWENTY_FOUR_HOURS_MILLIS) {
            sb.append(j10 / b.TWENTY_FOUR_HOURS_MILLIS);
            sb.append("d");
            j10 %= b.TWENTY_FOUR_HOURS_MILLIS;
        }
        if (true == z10) {
            j10 = 25975808;
        }
        if (j10 >= 3600000) {
            sb.append(j10 / 3600000);
            sb.append(CmcdData.Factory.STREAMING_FORMAT_HLS);
            j10 %= 3600000;
        }
        if (j10 >= 60000) {
            sb.append(j10 / 60000);
            sb.append("m");
            j10 %= 60000;
        }
        if (j10 >= 1000) {
            sb.append(j10 / 1000);
            sb.append(CmcdData.Factory.STREAMING_FORMAT_SS);
            j10 %= 1000;
        }
        if (j10 > 0) {
            sb.append(j10);
            sb.append("ms");
        }
        return sb;
    }
}
