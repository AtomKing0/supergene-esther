package com.google.android.gms.internal.ads;

import android.util.Pair;
import androidx.media3.common.MimeTypes;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzahi {
    public byte[] zzN;
    public zzadq zzT;
    public boolean zzU;
    public zzadp zzW;
    public int zzX;
    private int zzY;
    public String zza;
    public String zzb;
    public int zzc;
    public int zzd;
    public int zze;
    public int zzf;
    public boolean zzg;
    public byte[] zzh;
    public zzado zzi;
    public byte[] zzj;
    public zzy zzk;
    public int zzl = -1;
    public int zzm = -1;
    public int zzn = -1;
    public int zzo = -1;
    public int zzp = -1;
    public int zzq = 0;
    public int zzr = -1;
    public float zzs = 0.0f;
    public float zzt = 0.0f;
    public float zzu = 0.0f;
    public byte[] zzv = null;
    public int zzw = -1;
    public boolean zzx = false;
    public int zzy = -1;
    public int zzz = -1;
    public int zzA = -1;
    public int zzB = 1000;
    public int zzC = 200;
    public float zzD = -1.0f;
    public float zzE = -1.0f;
    public float zzF = -1.0f;
    public float zzG = -1.0f;
    public float zzH = -1.0f;
    public float zzI = -1.0f;
    public float zzJ = -1.0f;
    public float zzK = -1.0f;
    public float zzL = -1.0f;
    public float zzM = -1.0f;
    public int zzO = 1;
    public int zzP = -1;
    public int zzQ = 8000;
    public long zzR = 0;
    public long zzS = 0;
    public boolean zzV = true;
    private String zzZ = "eng";

    protected zzahi() {
    }

    private static Pair zzf(zzek zzekVar) throws zzbo {
        try {
            zzekVar.zzL(16);
            long jZzs = zzekVar.zzs();
            if (jZzs == 1482049860) {
                return new Pair(MimeTypes.VIDEO_DIVX, null);
            }
            if (jZzs == 859189832) {
                return new Pair(MimeTypes.VIDEO_H263, null);
            }
            if (jZzs != 826496599) {
                zzea.zzf("MatroskaExtractor", "Unknown FourCC. Setting mimeType to video/x-unknown");
                return new Pair(MimeTypes.VIDEO_UNKNOWN, null);
            }
            int iZzd = zzekVar.zzd() + 20;
            byte[] bArrZzM = zzekVar.zzM();
            while (true) {
                int length = bArrZzM.length;
                if (iZzd >= length - 4) {
                    throw zzbo.zza("Failed to find FourCC VC1 initialization data", null);
                }
                int i10 = iZzd + 1;
                if (bArrZzM[iZzd] == 0 && bArrZzM[i10] == 0 && bArrZzM[iZzd + 2] == 1 && bArrZzM[iZzd + 3] == 15) {
                    return new Pair(MimeTypes.VIDEO_VC1, Collections.singletonList(Arrays.copyOfRange(bArrZzM, iZzd, length)));
                }
                iZzd = i10;
            }
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw zzbo.zza("Error parsing FourCC private data", null);
        }
    }

    private static List zzg(byte[] bArr) throws zzbo {
        int i10;
        int i11;
        try {
            if (bArr[0] != 2) {
                throw zzbo.zza("Error parsing vorbis codec private", null);
            }
            int i12 = 0;
            int i13 = 1;
            while (true) {
                int i14 = bArr[i13];
                i13++;
                i10 = i14 & 255;
                if (i10 != 255) {
                    break;
                }
                i12 += 255;
            }
            int i15 = i12 + i10;
            int i16 = 0;
            while (true) {
                int i17 = bArr[i13];
                i13++;
                i11 = i17 & 255;
                if (i11 != 255) {
                    break;
                }
                i16 += 255;
            }
            int i18 = i16 + i11;
            if (bArr[i13] != 1) {
                throw zzbo.zza("Error parsing vorbis codec private", null);
            }
            byte[] bArr2 = new byte[i15];
            System.arraycopy(bArr, i13, bArr2, 0, i15);
            int i19 = i13 + i15;
            if (bArr[i19] != 3) {
                throw zzbo.zza("Error parsing vorbis codec private", null);
            }
            int i20 = i19 + i18;
            if (bArr[i20] != 5) {
                throw zzbo.zza("Error parsing vorbis codec private", null);
            }
            int length = bArr.length - i20;
            byte[] bArr3 = new byte[length];
            System.arraycopy(bArr, i20, bArr3, 0, length);
            ArrayList arrayList = new ArrayList(2);
            arrayList.add(bArr2);
            arrayList.add(bArr3);
            return arrayList;
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw zzbo.zza("Error parsing vorbis codec private", null);
        }
    }

    private static boolean zzh(zzek zzekVar) throws zzbo {
        try {
            int iZzk = zzekVar.zzk();
            if (iZzk == 1) {
                return true;
            }
            if (iZzk == 65534) {
                zzekVar.zzK(24);
                if (zzekVar.zzt() == zzahj.zze.getMostSignificantBits()) {
                    if (zzekVar.zzt() == zzahj.zze.getLeastSignificantBits()) {
                        return true;
                    }
                }
            }
            return false;
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw zzbo.zza("Error parsing MS/ACM codec private", null);
        }
    }

    private final byte[] zzi(String str) throws zzbo {
        byte[] bArr = this.zzj;
        if (bArr != null) {
            return bArr;
        }
        throw zzbo.zza("Missing CodecPrivate for codec ".concat(String.valueOf(str)), null);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:173:0x03b3  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x03cc  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x03ce  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x03db  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x03ea  */
    /* JADX WARN: Removed duplicated region for block: B:253:0x056e  */
    /* JADX WARN: Removed duplicated region for block: B:273:0x05c8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zze(com.google.android.gms.internal.ads.zzacn r20, int r21) throws com.google.android.gms.internal.ads.zzbo {
        /*
            Method dump skipped, instruction units count: 1750
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzahi.zze(com.google.android.gms.internal.ads.zzacn, int):void");
    }
}
