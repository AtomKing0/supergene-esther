package com.google.android.gms.internal.ads;

import androidx.media3.exoplayer.upstream.CmcdData;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzgaj {
    public static long zza(long j10, long j11) {
        long j12 = j10 + j11;
        if (((j10 ^ j11) < 0) || ((j10 ^ j12) >= 0)) {
            return j12;
        }
        throw new ArithmeticException("overflow: checkedAdd(" + j10 + ", " + j11 + ")");
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0051, code lost:
    
        if (r9 != false) goto L26;
     */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0050  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static long zzb(long r8, long r10, java.math.RoundingMode r12) {
        /*
            r12.getClass()
            long r0 = r8 / r10
            long r2 = r10 * r0
            long r2 = r8 - r2
            r4 = 0
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 != 0) goto L10
            goto L59
        L10:
            long r8 = r8 ^ r10
            int[] r6 = com.google.android.gms.internal.ads.zzgai.zza
            int r7 = r12.ordinal()
            r6 = r6[r7]
            r7 = 63
            long r8 = r8 >> r7
            int r8 = (int) r8
            r9 = 1
            r8 = r8 | r9
            r7 = 0
            switch(r6) {
                case 1: goto L56;
                case 2: goto L59;
                case 3: goto L4d;
                case 4: goto L53;
                case 5: goto L4a;
                case 6: goto L29;
                case 7: goto L29;
                case 8: goto L29;
                default: goto L23;
            }
        L23:
            java.lang.AssertionError r8 = new java.lang.AssertionError
            r8.<init>()
            throw r8
        L29:
            long r2 = java.lang.Math.abs(r2)
            long r10 = java.lang.Math.abs(r10)
            long r10 = r10 - r2
            long r2 = r2 - r10
            int r10 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r10 != 0) goto L47
            java.math.RoundingMode r10 = java.math.RoundingMode.HALF_UP
            if (r12 == r10) goto L51
            java.math.RoundingMode r10 = java.math.RoundingMode.HALF_EVEN
            if (r12 != r10) goto L50
            r10 = 1
            long r10 = r10 & r0
            int r10 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            if (r10 == 0) goto L50
            goto L51
        L47:
            if (r10 <= 0) goto L50
            goto L51
        L4a:
            if (r8 <= 0) goto L50
            goto L51
        L4d:
            if (r8 >= 0) goto L50
            goto L51
        L50:
            r9 = r7
        L51:
            if (r9 == 0) goto L59
        L53:
            long r8 = (long) r8
            long r0 = r0 + r8
            return r0
        L56:
            com.google.android.gms.internal.ads.zzgak.zzb(r7)
        L59:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgaj.zzb(long, long, java.math.RoundingMode):long");
    }

    public static long zzc(long j10, long j11) {
        zzgak.zza(CmcdData.Factory.OBJECT_TYPE_AUDIO_ONLY, j10);
        zzgak.zza("b", j11);
        if (j10 == 0) {
            return j11;
        }
        if (j11 == 0) {
            return j10;
        }
        int iNumberOfTrailingZeros = Long.numberOfTrailingZeros(j10);
        long jNumberOfTrailingZeros = j10 >> iNumberOfTrailingZeros;
        int iNumberOfTrailingZeros2 = Long.numberOfTrailingZeros(j11);
        long j12 = j11 >> iNumberOfTrailingZeros2;
        while (jNumberOfTrailingZeros != j12) {
            long j13 = jNumberOfTrailingZeros - j12;
            long j14 = (j13 >> 63) & j13;
            long j15 = (j13 - j14) - j14;
            jNumberOfTrailingZeros = j15 >> Long.numberOfTrailingZeros(j15);
            j12 += j14;
        }
        return jNumberOfTrailingZeros << Math.min(iNumberOfTrailingZeros, iNumberOfTrailingZeros2);
    }

    public static long zzd(long j10, long j11) {
        int iNumberOfLeadingZeros = Long.numberOfLeadingZeros(j10) + Long.numberOfLeadingZeros(~j10) + Long.numberOfLeadingZeros(j11) + Long.numberOfLeadingZeros(~j11);
        if (iNumberOfLeadingZeros > 65) {
            return j10 * j11;
        }
        long j12 = ((j10 ^ j11) >>> 63) + Long.MAX_VALUE;
        if ((iNumberOfLeadingZeros < 64) || ((j11 == Long.MIN_VALUE) & (j10 < 0))) {
            return j12;
        }
        long j13 = j10 * j11;
        return (j10 == 0 || j13 / j10 == j11) ? j13 : j12;
    }
}
