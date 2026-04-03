package com.google.android.gms.internal.ads;

import androidx.annotation.VisibleForTesting;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzakv implements zzaka {
    private static final Pattern zza = Pattern.compile("\\s*((?:(\\d+):)?(\\d+):(\\d+)(?:,(\\d+))?)\\s*-->\\s*((?:(\\d+):)?(\\d+):(\\d+)(?:,(\\d+))?)\\s*");
    private static final Pattern zzb = Pattern.compile("\\{\\\\.*?\\}");
    private final StringBuilder zzc = new StringBuilder();
    private final ArrayList zzd = new ArrayList();
    private final zzek zze = new zzek();

    @VisibleForTesting(otherwise = 2)
    public static float zzc(int i10) {
        if (i10 == 0) {
            return 0.08f;
        }
        if (i10 == 1) {
            return 0.5f;
        }
        if (i10 == 2) {
            return 0.92f;
        }
        throw new IllegalArgumentException();
    }

    private static long zzd(Matcher matcher, int i10) {
        String strGroup = matcher.group(i10 + 1);
        long j10 = strGroup != null ? Long.parseLong(strGroup) * 3600000 : 0L;
        String strGroup2 = matcher.group(i10 + 2);
        strGroup2.getClass();
        long j11 = j10 + (Long.parseLong(strGroup2) * 60000);
        String strGroup3 = matcher.group(i10 + 3);
        strGroup3.getClass();
        long j12 = j11 + (Long.parseLong(strGroup3) * 1000);
        String strGroup4 = matcher.group(i10 + 4);
        if (strGroup4 != null) {
            j12 += Long.parseLong(strGroup4);
        }
        return j12 * 1000;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:59:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0197  */
    @Override // com.google.android.gms.internal.ads.zzaka
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zza(byte[] r17, int r18, int r19, com.google.android.gms.internal.ads.zzajz r20, com.google.android.gms.internal.ads.zzdn r21) {
        /*
            Method dump skipped, instruction units count: 566
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzakv.zza(byte[], int, int, com.google.android.gms.internal.ads.zzajz, com.google.android.gms.internal.ads.zzdn):void");
    }

    @Override // com.google.android.gms.internal.ads.zzaka
    public final /* synthetic */ void zzb() {
    }
}
