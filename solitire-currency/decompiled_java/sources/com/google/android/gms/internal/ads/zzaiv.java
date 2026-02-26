package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import androidx.media3.extractor.mp4.Atom;
import androidx.media3.extractor.mp4.Sniffer;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzaiv {
    private static final int[] zza = {1769172845, 1769172786, 1769172787, 1769172788, 1769172789, 1769172790, 1769172793, Atom.TYPE_avc1, Atom.TYPE_hvc1, Atom.TYPE_hev1, Atom.TYPE_av01, 1836069937, 1836069938, 862401121, 862401122, 862417462, 862417718, 862414134, 862414646, 1295275552, 1295270176, 1714714144, 1801741417, 1295275600, Sniffer.BRAND_QUICKTIME, 1297305174, 1684175153, 1769172332, 1885955686};

    @Nullable
    public static zzadm zza(zzacl zzaclVar) throws IOException {
        return zzc(zzaclVar, true, false);
    }

    @Nullable
    public static zzadm zzb(zzacl zzaclVar, boolean z10) throws IOException {
        return zzc(zzaclVar, false, z10);
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:?, code lost:
    
        return com.google.android.gms.internal.ads.zzaim.zza;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0122, code lost:
    
        r8 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0125, code lost:
    
        if (r11 != false) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0129, code lost:
    
        return com.google.android.gms.internal.ads.zzair.zza;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x012c, code lost:
    
        if (r25 == r8) goto L83;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x012e, code lost:
    
        if (r8 == 0) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0135, code lost:
    
        return com.google.android.gms.internal.ads.zzaim.zzb;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x0136, code lost:
    
        return null;
     */
    @androidx.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static com.google.android.gms.internal.ads.zzadm zzc(com.google.android.gms.internal.ads.zzacl r24, boolean r25, boolean r26) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 312
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaiv.zzc(com.google.android.gms.internal.ads.zzacl, boolean, boolean):com.google.android.gms.internal.ads.zzadm");
    }

    private static boolean zzd(int i10, boolean z10) {
        if ((i10 >>> 8) == 3368816) {
            return true;
        }
        if (i10 == 1751476579) {
            if (z10) {
                return true;
            }
            i10 = 1751476579;
        }
        int[] iArr = zza;
        for (int i11 = 0; i11 < 29; i11++) {
            if (iArr[i11] == i10) {
                return true;
            }
        }
        return false;
    }
}
