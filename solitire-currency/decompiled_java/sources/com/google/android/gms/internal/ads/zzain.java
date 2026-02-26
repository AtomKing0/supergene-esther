package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import androidx.media3.common.C;
import com.unity3d.services.UnityAdsConstants;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzain {
    /* JADX WARN: Removed duplicated region for block: B:130:0x0261 A[Catch: all -> 0x01f3, TryCatch #0 {all -> 0x01f3, blocks: (B:9:0x002c, B:11:0x0037, B:12:0x0043, B:15:0x004f, B:18:0x005c, B:21:0x006b, B:24:0x0078, B:27:0x0085, B:29:0x008f, B:37:0x00a8, B:38:0x00be, B:39:0x00d2, B:42:0x00de, B:45:0x00eb, B:48:0x00f8, B:51:0x0105, B:54:0x0112, B:57:0x011f, B:60:0x012c, B:63:0x0139, B:66:0x0146, B:69:0x0156, B:73:0x016a, B:75:0x0170, B:77:0x0185, B:78:0x018c, B:80:0x0193, B:85:0x019e, B:90:0x01aa, B:130:0x0261, B:91:0x01bf, B:93:0x01c6, B:95:0x01d0, B:96:0x01e4, B:111:0x0213, B:114:0x0220, B:117:0x022c, B:120:0x0238, B:123:0x0244, B:126:0x0250, B:129:0x025a, B:131:0x027a, B:132:0x0281), top: B:137:0x001e }] */
    @androidx.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.google.android.gms.internal.ads.zzbj zza(com.google.android.gms.internal.ads.zzek r14) {
        /*
            Method dump skipped, instruction units count: 655
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzain.zza(com.google.android.gms.internal.ads.zzek):com.google.android.gms.internal.ads.zzbj");
    }

    private static int zzb(zzek zzekVar) {
        int iZzg = zzekVar.zzg();
        if (zzekVar.zzg() == 1684108385) {
            zzekVar.zzL(8);
            int i10 = iZzg - 16;
            if (i10 == 1) {
                return zzekVar.zzm();
            }
            if (i10 == 2) {
                return zzekVar.zzq();
            }
            if (i10 == 3) {
                return zzekVar.zzo();
            }
            if (i10 == 4 && (zzekVar.zzf() & 128) == 0) {
                return zzekVar.zzp();
            }
        }
        zzea.zzf("MetadataUtil", "Failed to parse data atom to int");
        return -1;
    }

    @Nullable
    private static zzagd zzc(int i10, String str, zzek zzekVar, boolean z10, boolean z11) {
        int iZzb = zzb(zzekVar);
        if (z11) {
            iZzb = Math.min(1, iZzb);
        }
        if (iZzb >= 0) {
            return z10 ? new zzagm(str, null, zzfxr.zzn(Integer.toString(iZzb))) : new zzafx(C.LANGUAGE_UNDETERMINED, str, Integer.toString(iZzb));
        }
        zzea.zzf("MetadataUtil", "Failed to parse uint8 attribute: ".concat(zzahx.zzf(i10)));
        return null;
    }

    @Nullable
    private static zzagm zzd(int i10, String str, zzek zzekVar) {
        int iZzg = zzekVar.zzg();
        if (zzekVar.zzg() == 1684108385 && iZzg >= 22) {
            zzekVar.zzL(10);
            int iZzq = zzekVar.zzq();
            if (iZzq > 0) {
                StringBuilder sb = new StringBuilder();
                sb.append(iZzq);
                String string = sb.toString();
                int iZzq2 = zzekVar.zzq();
                if (iZzq2 > 0) {
                    string = string + UnityAdsConstants.DefaultUrls.AD_ASSET_PATH + iZzq2;
                }
                return new zzagm(str, null, zzfxr.zzn(string));
            }
        }
        zzea.zzf("MetadataUtil", "Failed to parse index/count attribute: ".concat(zzahx.zzf(i10)));
        return null;
    }

    @Nullable
    private static zzagm zze(int i10, String str, zzek zzekVar) {
        int iZzg = zzekVar.zzg();
        if (zzekVar.zzg() == 1684108385) {
            zzekVar.zzL(8);
            return new zzagm(str, null, zzfxr.zzn(zzekVar.zzz(iZzg - 16)));
        }
        zzea.zzf("MetadataUtil", "Failed to parse text attribute: ".concat(zzahx.zzf(i10)));
        return null;
    }
}
