package com.google.android.gms.internal.ads;

import android.util.Pair;
import androidx.annotation.Nullable;
import androidx.media3.common.C;
import androidx.media3.common.MimeTypes;
import androidx.media3.extractor.mp4.Atom;
import androidx.media3.extractor.ts.PsExtractor;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzaif {
    private static final byte[] zza;

    static {
        int i10 = zzet.zza;
        zza = "OpusHead".getBytes(zzfuj.zzc);
    }

    @Nullable
    public static zzbk zza(zzahv zzahvVar) {
        zzex zzexVar;
        zzahw zzahwVarZzb = zzahvVar.zzb(Atom.TYPE_hdlr);
        zzahw zzahwVarZzb2 = zzahvVar.zzb(Atom.TYPE_keys);
        zzahw zzahwVarZzb3 = zzahvVar.zzb(Atom.TYPE_ilst);
        if (zzahwVarZzb != null && zzahwVarZzb2 != null && zzahwVarZzb3 != null && zzg(zzahwVarZzb.zza) == 1835299937) {
            zzek zzekVar = zzahwVarZzb2.zza;
            zzekVar.zzK(12);
            int iZzg = zzekVar.zzg();
            String[] strArr = new String[iZzg];
            for (int i10 = 0; i10 < iZzg; i10++) {
                int iZzg2 = zzekVar.zzg();
                zzekVar.zzL(4);
                strArr[i10] = zzekVar.zzA(iZzg2 - 8, zzfuj.zzc);
            }
            zzek zzekVar2 = zzahwVarZzb3.zza;
            zzekVar2.zzK(8);
            ArrayList arrayList = new ArrayList();
            while (zzekVar2.zzb() > 8) {
                int iZzd = zzekVar2.zzd() + zzekVar2.zzg();
                int iZzg3 = zzekVar2.zzg() - 1;
                if (iZzg3 < 0 || iZzg3 >= iZzg) {
                    zzea.zzf("AtomParsers", "Skipped metadata with unknown key index: " + iZzg3);
                } else {
                    String str = strArr[iZzg3];
                    while (true) {
                        int iZzd2 = zzekVar2.zzd();
                        if (iZzd2 >= iZzd) {
                            zzexVar = null;
                            break;
                        }
                        int iZzg4 = zzekVar2.zzg();
                        if (zzekVar2.zzg() == 1684108385) {
                            int iZzg5 = zzekVar2.zzg();
                            int iZzg6 = zzekVar2.zzg();
                            int i11 = iZzg4 - 16;
                            byte[] bArr = new byte[i11];
                            zzekVar2.zzG(bArr, 0, i11);
                            zzexVar = new zzex(str, bArr, iZzg6, iZzg5);
                            break;
                        }
                        zzekVar2.zzK(iZzd2 + iZzg4);
                    }
                    if (zzexVar != null) {
                        arrayList.add(zzexVar);
                    }
                }
                zzekVar2.zzK(iZzd);
            }
            if (!arrayList.isEmpty()) {
                return new zzbk(arrayList);
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x00da  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.google.android.gms.internal.ads.zzbk zzb(com.google.android.gms.internal.ads.zzahw r14) {
        /*
            Method dump skipped, instruction units count: 303
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaif.zzb(com.google.android.gms.internal.ads.zzahw):com.google.android.gms.internal.ads.zzbk");
    }

    public static zzfd zzc(zzek zzekVar) {
        long jZzt;
        long jZzt2;
        zzekVar.zzK(8);
        if (zzahx.zze(zzekVar.zzg()) == 0) {
            jZzt = zzekVar.zzu();
            jZzt2 = zzekVar.zzu();
        } else {
            jZzt = zzekVar.zzt();
            jZzt2 = zzekVar.zzt();
        }
        return new zzfd(jZzt, jZzt2, zzekVar.zzu());
    }

    /* JADX WARN: Removed duplicated region for block: B:315:0x063c  */
    /* JADX WARN: Removed duplicated region for block: B:316:0x0656  */
    /* JADX WARN: Removed duplicated region for block: B:354:0x071f  */
    /* JADX WARN: Removed duplicated region for block: B:355:0x0724  */
    /* JADX WARN: Removed duplicated region for block: B:358:0x072f  */
    /* JADX WARN: Removed duplicated region for block: B:360:0x0735  */
    /* JADX WARN: Removed duplicated region for block: B:362:0x0738  */
    /* JADX WARN: Removed duplicated region for block: B:365:0x0740  */
    /* JADX WARN: Removed duplicated region for block: B:368:0x0747  */
    /* JADX WARN: Removed duplicated region for block: B:383:0x0776  */
    /* JADX WARN: Removed duplicated region for block: B:384:0x0778  */
    /* JADX WARN: Removed duplicated region for block: B:465:0x096c  */
    /* JADX WARN: Removed duplicated region for block: B:466:0x096e  */
    /* JADX WARN: Removed duplicated region for block: B:517:0x0afe  */
    /* JADX WARN: Removed duplicated region for block: B:518:0x0b02  */
    /* JADX WARN: Removed duplicated region for block: B:521:0x0b31  */
    /* JADX WARN: Removed duplicated region for block: B:522:0x0b5b  */
    /* JADX WARN: Removed duplicated region for block: B:529:0x0b68 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x018e  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0197  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x01db  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.util.List zzd(com.google.android.gms.internal.ads.zzahv r55, com.google.android.gms.internal.ads.zzacy r56, long r57, @androidx.annotation.Nullable com.google.android.gms.internal.ads.zzy r59, boolean r60, boolean r61, com.google.android.gms.internal.ads.zzful r62) throws com.google.android.gms.internal.ads.zzbo {
        /*
            Method dump skipped, instruction units count: 2930
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaif.zzd(com.google.android.gms.internal.ads.zzahv, com.google.android.gms.internal.ads.zzacy, long, com.google.android.gms.internal.ads.zzy, boolean, boolean, com.google.android.gms.internal.ads.zzful):java.util.List");
    }

    public static void zze(zzek zzekVar) {
        int iZzd = zzekVar.zzd();
        zzekVar.zzL(4);
        if (zzekVar.zzg() != 1751411826) {
            iZzd += 4;
        }
        zzekVar.zzK(iZzd);
    }

    private static int zzf(zzek zzekVar) {
        int iZzm = zzekVar.zzm();
        int i10 = iZzm & 127;
        while ((iZzm & 128) == 128) {
            iZzm = zzekVar.zzm();
            i10 = (i10 << 7) | (iZzm & 127);
        }
        return i10;
    }

    private static int zzg(zzek zzekVar) {
        zzekVar.zzK(16);
        return zzekVar.zzg();
    }

    @Nullable
    private static Pair zzh(zzek zzekVar, int i10, int i11) throws zzbo {
        Integer num;
        zzaix zzaixVar;
        Pair pairCreate;
        int i12;
        int i13;
        byte[] bArr;
        int iZzd = zzekVar.zzd();
        while (iZzd - i10 < i11) {
            zzekVar.zzK(iZzd);
            int iZzg = zzekVar.zzg();
            zzaco.zzb(iZzg > 0, "childAtomSize must be positive");
            if (zzekVar.zzg() == 1936289382) {
                int i14 = iZzd + 8;
                int i15 = 0;
                int i16 = -1;
                String strZzA = null;
                Integer numValueOf = null;
                while (i14 - iZzd < iZzg) {
                    zzekVar.zzK(i14);
                    int iZzg2 = zzekVar.zzg();
                    int iZzg3 = zzekVar.zzg();
                    if (iZzg3 == 1718775137) {
                        numValueOf = Integer.valueOf(zzekVar.zzg());
                    } else if (iZzg3 == 1935894637) {
                        zzekVar.zzL(4);
                        strZzA = zzekVar.zzA(4, zzfuj.zzc);
                    } else if (iZzg3 == 1935894633) {
                        i16 = i14;
                        i15 = iZzg2;
                    }
                    i14 += iZzg2;
                }
                if (C.CENC_TYPE_cenc.equals(strZzA) || C.CENC_TYPE_cbc1.equals(strZzA) || C.CENC_TYPE_cens.equals(strZzA) || C.CENC_TYPE_cbcs.equals(strZzA)) {
                    zzaco.zzb(numValueOf != null, "frma atom is mandatory");
                    zzaco.zzb(i16 != -1, "schi atom is mandatory");
                    int i17 = i16 + 8;
                    while (true) {
                        if (i17 - i16 >= i15) {
                            num = numValueOf;
                            zzaixVar = null;
                            break;
                        }
                        zzekVar.zzK(i17);
                        int iZzg4 = zzekVar.zzg();
                        if (zzekVar.zzg() == 1952804451) {
                            int iZze = zzahx.zze(zzekVar.zzg());
                            zzekVar.zzL(1);
                            if (iZze == 0) {
                                zzekVar.zzL(1);
                                i12 = 0;
                                i13 = 0;
                            } else {
                                int iZzm = zzekVar.zzm();
                                int i18 = (iZzm & PsExtractor.VIDEO_STREAM_MASK) >> 4;
                                i12 = iZzm & 15;
                                i13 = i18;
                            }
                            boolean z10 = zzekVar.zzm() == 1;
                            int iZzm2 = zzekVar.zzm();
                            byte[] bArr2 = new byte[16];
                            zzekVar.zzG(bArr2, 0, 16);
                            if (z10 && iZzm2 == 0) {
                                int iZzm3 = zzekVar.zzm();
                                byte[] bArr3 = new byte[iZzm3];
                                zzekVar.zzG(bArr3, 0, iZzm3);
                                bArr = bArr3;
                            } else {
                                bArr = null;
                            }
                            num = numValueOf;
                            zzaixVar = new zzaix(z10, strZzA, iZzm2, bArr2, i13, i12, bArr);
                        } else {
                            i17 += iZzg4;
                        }
                    }
                    zzaco.zzb(zzaixVar != null, "tenc atom is mandatory");
                    int i19 = zzet.zza;
                    pairCreate = Pair.create(num, zzaixVar);
                } else {
                    pairCreate = null;
                }
                if (pairCreate != null) {
                    return pairCreate;
                }
            }
            iZzd += iZzg;
        }
        return null;
    }

    @Nullable
    private static zzbk zzi(zzek zzekVar) {
        short sZzD = zzekVar.zzD();
        zzekVar.zzL(2);
        String strZzA = zzekVar.zzA(sZzD, zzfuj.zzc);
        int iMax = Math.max(strZzA.lastIndexOf(43), strZzA.lastIndexOf(45));
        try {
            return new zzbk(C.TIME_UNSET, new zzfa(Float.parseFloat(strZzA.substring(0, iMax)), Float.parseFloat(strZzA.substring(iMax, strZzA.length() - 1))));
        } catch (IndexOutOfBoundsException | NumberFormatException unused) {
            return null;
        }
    }

    private static zzahz zzj(zzek zzekVar, int i10) {
        zzekVar.zzK(i10 + 12);
        zzekVar.zzL(1);
        zzf(zzekVar);
        zzekVar.zzL(2);
        int iZzm = zzekVar.zzm();
        if ((iZzm & 128) != 0) {
            zzekVar.zzL(2);
        }
        if ((iZzm & 64) != 0) {
            zzekVar.zzL(zzekVar.zzm());
        }
        if ((iZzm & 32) != 0) {
            zzekVar.zzL(2);
        }
        zzekVar.zzL(1);
        zzf(zzekVar);
        String strZzd = zzbn.zzd(zzekVar.zzm());
        if (MimeTypes.AUDIO_MPEG.equals(strZzd) || MimeTypes.AUDIO_DTS.equals(strZzd) || MimeTypes.AUDIO_DTS_HD.equals(strZzd)) {
            return new zzahz(strZzd, null, -1L, -1L);
        }
        zzekVar.zzL(4);
        long jZzu = zzekVar.zzu();
        long jZzu2 = zzekVar.zzu();
        zzekVar.zzL(1);
        int iZzf = zzf(zzekVar);
        byte[] bArr = new byte[iZzf];
        zzekVar.zzG(bArr, 0, iZzf);
        return new zzahz(strZzd, bArr, jZzu2 <= 0 ? -1L : jZzu2, jZzu > 0 ? jZzu : -1L);
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x0271 A[ADDED_TO_REGION, LOOP:12: B:103:0x0271->B:107:0x027b, LOOP_START, PHI: r16
      0x0271: PHI (r16v6 int) = (r16v2 int), (r16v7 int) binds: [B:102:0x026f, B:107:0x027b] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0281  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0284  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x02d0  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x031c  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x031f  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0344  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0353  */
    /* JADX WARN: Removed duplicated region for block: B:254:0x025f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0173 A[PHI: r9
      0x0173: PHI (r9v4 int) = (r9v3 int), (r9v3 int), (r9v35 int), (r9v3 int) binds: [B:36:0x00cf, B:43:0x00e9, B:60:0x0172, B:42:0x00e7] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x018e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static com.google.android.gms.internal.ads.zzaiz zzk(com.google.android.gms.internal.ads.zzaiw r40, com.google.android.gms.internal.ads.zzahv r41, com.google.android.gms.internal.ads.zzacy r42) throws com.google.android.gms.internal.ads.zzbo {
        /*
            Method dump skipped, instruction units count: 1506
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaif.zzk(com.google.android.gms.internal.ads.zzaiw, com.google.android.gms.internal.ads.zzahv, com.google.android.gms.internal.ads.zzacy):com.google.android.gms.internal.ads.zzaiz");
    }

    private static ByteBuffer zzl() {
        return ByteBuffer.allocate(25).order(ByteOrder.LITTLE_ENDIAN);
    }

    /* JADX WARN: Removed duplicated region for block: B:128:0x01bc  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0138  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void zzm(com.google.android.gms.internal.ads.zzek r26, int r27, int r28, int r29, int r30, java.lang.String r31, boolean r32, @androidx.annotation.Nullable com.google.android.gms.internal.ads.zzy r33, com.google.android.gms.internal.ads.zzaib r34, int r35) throws com.google.android.gms.internal.ads.zzbo {
        /*
            Method dump skipped, instruction units count: 1360
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaif.zzm(com.google.android.gms.internal.ads.zzek, int, int, int, int, java.lang.String, boolean, com.google.android.gms.internal.ads.zzy, com.google.android.gms.internal.ads.zzaib, int):void");
    }
}
