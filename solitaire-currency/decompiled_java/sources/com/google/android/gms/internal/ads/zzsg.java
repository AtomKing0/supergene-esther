package com.google.android.gms.internal.ads;

import android.media.MediaCodecInfo;
import androidx.annotation.RequiresApi;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
@RequiresApi(29)
final class zzsg {
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0088, code lost:
    
        if (zzb(r7, new android.media.MediaCodecInfo.VideoCapabilities.PerformancePoint(1280, 720, 60)) != 1) goto L13;
     */
    /* JADX WARN: Removed duplicated region for block: B:33:0x009f A[RETURN] */
    @androidx.annotation.DoNotInline
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int zza(android.media.MediaCodecInfo.VideoCapabilities r3, int r4, int r5, double r6) {
        /*
            java.util.List r3 = androidx.media3.exoplayer.mediacodec.f.a(r3)
            r0 = 0
            if (r3 == 0) goto La1
            boolean r1 = r3.isEmpty()
            if (r1 == 0) goto Lf
            goto La1
        Lf:
            int r6 = (int) r6
            android.media.MediaCodecInfo$VideoCapabilities$PerformancePoint r7 = new android.media.MediaCodecInfo$VideoCapabilities$PerformancePoint
            r7.<init>(r4, r5, r6)
            int r3 = zzb(r3, r7)
            r4 = 1
            if (r3 != r4) goto La0
            java.lang.Boolean r5 = com.google.android.gms.internal.ads.zzsh.zzb()
            if (r5 != 0) goto La0
            int r5 = com.google.android.gms.internal.ads.zzet.zza
            r6 = 35
            if (r5 < r6) goto L2a
        L28:
            r4 = r0
            goto L8e
        L2a:
            com.google.android.gms.internal.ads.zzad r5 = new com.google.android.gms.internal.ads.zzad     // Catch: com.google.android.gms.internal.ads.zzsw -> L8e
            r5.<init>()     // Catch: com.google.android.gms.internal.ads.zzsw -> L8e
            java.lang.String r6 = "video/avc"
            r5.zzX(r6)     // Catch: com.google.android.gms.internal.ads.zzsw -> L8e
            com.google.android.gms.internal.ads.zzaf r5 = r5.zzad()     // Catch: com.google.android.gms.internal.ads.zzsw -> L8e
            java.lang.String r6 = r5.zzm     // Catch: com.google.android.gms.internal.ads.zzsw -> L8e
            if (r6 == 0) goto L8e
            com.google.android.gms.internal.ads.zzsq r6 = com.google.android.gms.internal.ads.zzsq.zza     // Catch: com.google.android.gms.internal.ads.zzsw -> L8e
            java.util.List r5 = com.google.android.gms.internal.ads.zztc.zzf(r6, r5, r0, r0)     // Catch: com.google.android.gms.internal.ads.zzsw -> L8e
            r6 = r0
        L43:
            int r7 = r5.size()     // Catch: com.google.android.gms.internal.ads.zzsw -> L8e
            if (r6 >= r7) goto L8e
            java.lang.Object r7 = r5.get(r6)     // Catch: com.google.android.gms.internal.ads.zzsw -> L8e
            com.google.android.gms.internal.ads.zzsf r7 = (com.google.android.gms.internal.ads.zzsf) r7     // Catch: com.google.android.gms.internal.ads.zzsw -> L8e
            android.media.MediaCodecInfo$CodecCapabilities r7 = r7.zzd     // Catch: com.google.android.gms.internal.ads.zzsw -> L8e
            if (r7 == 0) goto L8b
            java.lang.Object r7 = r5.get(r6)     // Catch: com.google.android.gms.internal.ads.zzsw -> L8e
            com.google.android.gms.internal.ads.zzsf r7 = (com.google.android.gms.internal.ads.zzsf) r7     // Catch: com.google.android.gms.internal.ads.zzsw -> L8e
            android.media.MediaCodecInfo$CodecCapabilities r7 = r7.zzd     // Catch: com.google.android.gms.internal.ads.zzsw -> L8e
            android.media.MediaCodecInfo$VideoCapabilities r7 = r7.getVideoCapabilities()     // Catch: com.google.android.gms.internal.ads.zzsw -> L8e
            if (r7 == 0) goto L8b
            java.lang.Object r7 = r5.get(r6)     // Catch: com.google.android.gms.internal.ads.zzsw -> L8e
            com.google.android.gms.internal.ads.zzsf r7 = (com.google.android.gms.internal.ads.zzsf) r7     // Catch: com.google.android.gms.internal.ads.zzsw -> L8e
            android.media.MediaCodecInfo$CodecCapabilities r7 = r7.zzd     // Catch: com.google.android.gms.internal.ads.zzsw -> L8e
            android.media.MediaCodecInfo$VideoCapabilities r7 = r7.getVideoCapabilities()     // Catch: com.google.android.gms.internal.ads.zzsw -> L8e
            java.util.List r7 = androidx.media3.exoplayer.mediacodec.f.a(r7)     // Catch: com.google.android.gms.internal.ads.zzsw -> L8e
            if (r7 == 0) goto L8b
            boolean r1 = r7.isEmpty()     // Catch: com.google.android.gms.internal.ads.zzsw -> L8e
            if (r1 != 0) goto L8b
            android.media.MediaCodecInfo$VideoCapabilities$PerformancePoint r5 = new android.media.MediaCodecInfo$VideoCapabilities$PerformancePoint     // Catch: com.google.android.gms.internal.ads.zzsw -> L8e
            r6 = 720(0x2d0, float:1.009E-42)
            r1 = 60
            r2 = 1280(0x500, float:1.794E-42)
            r5.<init>(r2, r6, r1)     // Catch: com.google.android.gms.internal.ads.zzsw -> L8e
            int r5 = zzb(r7, r5)     // Catch: com.google.android.gms.internal.ads.zzsw -> L8e
            if (r5 != r4) goto L28
            goto L8e
        L8b:
            int r6 = r6 + 1
            goto L43
        L8e:
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)
            com.google.android.gms.internal.ads.zzsh.zzc(r4)
            java.lang.Boolean r4 = com.google.android.gms.internal.ads.zzsh.zzb()
            boolean r4 = r4.booleanValue()
            if (r4 == 0) goto La0
            return r0
        La0:
            return r3
        La1:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzsg.zza(android.media.MediaCodecInfo$VideoCapabilities, int, int, double):int");
    }

    private static int zzb(List list, MediaCodecInfo.VideoCapabilities.PerformancePoint performancePoint) {
        for (int i10 = 0; i10 < list.size(); i10++) {
            if (((MediaCodecInfo.VideoCapabilities.PerformancePoint) list.get(i10)).covers(performancePoint)) {
                return 2;
            }
        }
        return 1;
    }
}
