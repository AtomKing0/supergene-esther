package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import androidx.media3.common.MimeTypes;
import androidx.media3.extractor.ts.PsExtractor;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzajq extends zzajo {

    @Nullable
    private zzajp zza;
    private int zzb;
    private boolean zzc;

    @Nullable
    private zzadu zzd;

    @Nullable
    private zzads zze;

    zzajq() {
    }

    @Override // com.google.android.gms.internal.ads.zzajo
    protected final long zza(zzek zzekVar) {
        if ((zzekVar.zzM()[0] & 1) == 1) {
            return -1L;
        }
        byte b10 = zzekVar.zzM()[0];
        zzajp zzajpVar = this.zza;
        zzdi.zzb(zzajpVar);
        int i10 = !zzajpVar.zzd[(b10 >> 1) & (255 >>> (8 - zzajpVar.zze))].zza ? zzajpVar.zza.zze : zzajpVar.zza.zzf;
        int i11 = this.zzc ? (this.zzb + i10) / 4 : 0;
        if (zzekVar.zzc() < zzekVar.zze() + 4) {
            byte[] bArrCopyOf = Arrays.copyOf(zzekVar.zzM(), zzekVar.zze() + 4);
            zzekVar.zzI(bArrCopyOf, bArrCopyOf.length);
        } else {
            zzekVar.zzJ(zzekVar.zze() + 4);
        }
        long j10 = i11;
        byte[] bArrZzM = zzekVar.zzM();
        bArrZzM[zzekVar.zze() - 4] = (byte) (j10 & 255);
        bArrZzM[zzekVar.zze() - 3] = (byte) ((j10 >>> 8) & 255);
        bArrZzM[zzekVar.zze() - 2] = (byte) ((j10 >>> 16) & 255);
        bArrZzM[zzekVar.zze() - 1] = (byte) ((j10 >>> 24) & 255);
        this.zzc = true;
        this.zzb = i10;
        return j10;
    }

    @Override // com.google.android.gms.internal.ads.zzajo
    protected final void zzb(boolean z10) {
        super.zzb(z10);
        if (z10) {
            this.zza = null;
            this.zzd = null;
            this.zze = null;
        }
        this.zzb = 0;
        this.zzc = false;
    }

    @Override // com.google.android.gms.internal.ads.zzajo
    protected final boolean zzc(zzek zzekVar, long j10, zzajl zzajlVar) throws IOException {
        zzajp zzajpVar;
        int i10;
        int iZzb;
        int i11;
        int i12;
        zzadu zzaduVar;
        long jFloor;
        if (this.zza != null) {
            zzajlVar.zza.getClass();
            return false;
        }
        zzadu zzaduVar2 = this.zzd;
        int i13 = 4;
        if (zzaduVar2 == null) {
            zzadv.zzd(1, zzekVar, false);
            int iZzj = zzekVar.zzj();
            int iZzm = zzekVar.zzm();
            int iZzj2 = zzekVar.zzj();
            int iZzi = zzekVar.zzi();
            int i14 = iZzi <= 0 ? -1 : iZzi;
            int iZzi2 = zzekVar.zzi();
            int i15 = iZzi2 <= 0 ? -1 : iZzi2;
            int iZzi3 = zzekVar.zzi();
            int i16 = iZzi3 <= 0 ? -1 : iZzi3;
            int iZzm2 = zzekVar.zzm();
            this.zzd = new zzadu(iZzj, iZzm, iZzj2, i14, i15, i16, (int) Math.pow(2.0d, iZzm2 & 15), (int) Math.pow(2.0d, (iZzm2 & PsExtractor.VIDEO_STREAM_MASK) >> 4), 1 == (zzekVar.zzm() & 1), Arrays.copyOf(zzekVar.zzM(), zzekVar.zze()));
        } else {
            zzads zzadsVar = this.zze;
            if (zzadsVar == null) {
                this.zze = zzadv.zzc(zzekVar, true, true);
            } else {
                byte[] bArr = new byte[zzekVar.zze()];
                System.arraycopy(zzekVar.zzM(), 0, bArr, 0, zzekVar.zze());
                int i17 = zzaduVar2.zza;
                int i18 = 5;
                zzadv.zzd(5, zzekVar, false);
                int iZzm3 = zzekVar.zzm() + 1;
                zzadr zzadrVar = new zzadr(zzekVar.zzM());
                zzadrVar.zzc(zzekVar.zzd() * 8);
                int i19 = 0;
                while (true) {
                    int i20 = 2;
                    int i21 = 16;
                    if (i19 >= iZzm3) {
                        zzadu zzaduVar3 = zzaduVar2;
                        int i22 = 6;
                        int iZzb2 = zzadrVar.zzb(6) + 1;
                        for (int i23 = 0; i23 < iZzb2; i23++) {
                            if (zzadrVar.zzb(16) != 0) {
                                throw zzbo.zza("placeholder of time domain transforms not zeroed out", null);
                            }
                        }
                        int i24 = 1;
                        int iZzb3 = zzadrVar.zzb(6) + 1;
                        int i25 = 0;
                        while (true) {
                            int i26 = 3;
                            if (i25 < iZzb3) {
                                int iZzb4 = zzadrVar.zzb(i21);
                                if (iZzb4 == 0) {
                                    i11 = iZzb3;
                                    int i27 = 8;
                                    zzadrVar.zzc(8);
                                    zzadrVar.zzc(16);
                                    zzadrVar.zzc(16);
                                    zzadrVar.zzc(6);
                                    zzadrVar.zzc(8);
                                    int iZzb5 = zzadrVar.zzb(4) + 1;
                                    int i28 = 0;
                                    while (i28 < iZzb5) {
                                        zzadrVar.zzc(i27);
                                        i28++;
                                        i27 = 8;
                                    }
                                } else {
                                    if (iZzb4 != i24) {
                                        throw zzbo.zza("floor type greater than 1 not decodable: " + iZzb4, null);
                                    }
                                    int iZzb6 = zzadrVar.zzb(i18);
                                    int[] iArr = new int[iZzb6];
                                    int i29 = -1;
                                    for (int i30 = 0; i30 < iZzb6; i30++) {
                                        int iZzb7 = zzadrVar.zzb(4);
                                        iArr[i30] = iZzb7;
                                        if (iZzb7 > i29) {
                                            i29 = iZzb7;
                                        }
                                    }
                                    int i31 = i29 + 1;
                                    int[] iArr2 = new int[i31];
                                    int i32 = 0;
                                    while (i32 < i31) {
                                        iArr2[i32] = zzadrVar.zzb(i26) + 1;
                                        int iZzb8 = zzadrVar.zzb(i20);
                                        if (iZzb8 > 0) {
                                            i12 = 8;
                                            zzadrVar.zzc(8);
                                        } else {
                                            i12 = 8;
                                        }
                                        int i33 = iZzb3;
                                        int i34 = 0;
                                        for (int i35 = 1; i34 < (i35 << iZzb8); i35 = 1) {
                                            zzadrVar.zzc(i12);
                                            i34++;
                                            i12 = 8;
                                        }
                                        i32++;
                                        iZzb3 = i33;
                                        i20 = 2;
                                        i26 = 3;
                                    }
                                    i11 = iZzb3;
                                    zzadrVar.zzc(i20);
                                    int iZzb9 = zzadrVar.zzb(4);
                                    int i36 = 0;
                                    int i37 = 0;
                                    for (int i38 = 0; i38 < iZzb6; i38++) {
                                        i36 += iArr2[iArr[i38]];
                                        while (i37 < i36) {
                                            zzadrVar.zzc(iZzb9);
                                            i37++;
                                        }
                                    }
                                }
                                i25++;
                                iZzb3 = i11;
                                i22 = 6;
                                i21 = 16;
                                i20 = 2;
                                i24 = 1;
                                i18 = 5;
                            } else {
                                int i39 = 1;
                                int iZzb10 = zzadrVar.zzb(i22) + 1;
                                int i40 = 0;
                                while (i40 < iZzb10) {
                                    if (zzadrVar.zzb(16) > 2) {
                                        throw zzbo.zza("residueType greater than 2 is not decodable", null);
                                    }
                                    zzadrVar.zzc(24);
                                    zzadrVar.zzc(24);
                                    zzadrVar.zzc(24);
                                    int iZzb11 = zzadrVar.zzb(i22) + i39;
                                    int i41 = 8;
                                    zzadrVar.zzc(8);
                                    int[] iArr3 = new int[iZzb11];
                                    for (int i42 = 0; i42 < iZzb11; i42++) {
                                        iArr3[i42] = ((zzadrVar.zzd() ? zzadrVar.zzb(5) : 0) * 8) + zzadrVar.zzb(3);
                                    }
                                    int i43 = 0;
                                    while (i43 < iZzb11) {
                                        int i44 = 0;
                                        while (i44 < i41) {
                                            if ((iArr3[i43] & (1 << i44)) != 0) {
                                                zzadrVar.zzc(i41);
                                            }
                                            i44++;
                                            i41 = 8;
                                        }
                                        i43++;
                                        i41 = 8;
                                    }
                                    i40++;
                                    i22 = 6;
                                    i39 = 1;
                                }
                                int iZzb12 = zzadrVar.zzb(i22) + 1;
                                for (int i45 = 0; i45 < iZzb12; i45++) {
                                    int iZzb13 = zzadrVar.zzb(16);
                                    if (iZzb13 != 0) {
                                        zzea.zzc("VorbisUtil", "mapping type other than 0 not supported: " + iZzb13);
                                    } else {
                                        if (zzadrVar.zzd()) {
                                            i10 = 1;
                                            iZzb = zzadrVar.zzb(4) + 1;
                                        } else {
                                            i10 = 1;
                                            iZzb = 1;
                                        }
                                        if (zzadrVar.zzd()) {
                                            int iZzb14 = zzadrVar.zzb(8) + i10;
                                            for (int i46 = 0; i46 < iZzb14; i46++) {
                                                int i47 = i17 - 1;
                                                zzadrVar.zzc(zzadv.zza(i47));
                                                zzadrVar.zzc(zzadv.zza(i47));
                                            }
                                        }
                                        if (zzadrVar.zzb(2) != 0) {
                                            throw zzbo.zza("to reserved bits must be zero after mapping coupling steps", null);
                                        }
                                        if (iZzb > 1) {
                                            for (int i48 = 0; i48 < i17; i48++) {
                                                zzadrVar.zzc(4);
                                            }
                                        }
                                        for (int i49 = 0; i49 < iZzb; i49++) {
                                            zzadrVar.zzc(8);
                                            zzadrVar.zzc(8);
                                            zzadrVar.zzc(8);
                                        }
                                    }
                                }
                                int iZzb15 = zzadrVar.zzb(6) + 1;
                                zzadt[] zzadtVarArr = new zzadt[iZzb15];
                                for (int i50 = 0; i50 < iZzb15; i50++) {
                                    zzadtVarArr[i50] = new zzadt(zzadrVar.zzd(), zzadrVar.zzb(16), zzadrVar.zzb(16), zzadrVar.zzb(8));
                                }
                                if (!zzadrVar.zzd()) {
                                    throw zzbo.zza("framing bit after modes not set as expected", null);
                                }
                                zzajpVar = new zzajp(zzaduVar3, zzadsVar, bArr, zzadtVarArr, zzadv.zza(iZzb15 - 1));
                            }
                        }
                    } else {
                        if (zzadrVar.zzb(24) != 5653314) {
                            throw zzbo.zza("expected code book to start with [0x56, 0x43, 0x42] at " + zzadrVar.zza(), null);
                        }
                        int iZzb16 = zzadrVar.zzb(16);
                        int iZzb17 = zzadrVar.zzb(24);
                        if (zzadrVar.zzd()) {
                            zzadrVar.zzc(5);
                            for (int iZzb18 = 0; iZzb18 < iZzb17; iZzb18 += zzadrVar.zzb(zzadv.zza(iZzb17 - iZzb18))) {
                            }
                        } else {
                            boolean zZzd = zzadrVar.zzd();
                            for (int i51 = 0; i51 < iZzb17; i51++) {
                                if (!zZzd) {
                                    zzadrVar.zzc(5);
                                } else if (zzadrVar.zzd()) {
                                    zzadrVar.zzc(5);
                                }
                            }
                        }
                        int iZzb19 = zzadrVar.zzb(i13);
                        if (iZzb19 > 2) {
                            throw zzbo.zza("lookup type greater than 2 not decodable: " + iZzb19, null);
                        }
                        if (iZzb19 != 1) {
                            if (iZzb19 != 2) {
                                zzaduVar = zzaduVar2;
                            }
                            i19++;
                            zzaduVar2 = zzaduVar;
                            i13 = 4;
                        } else {
                            i20 = iZzb19;
                        }
                        zzadrVar.zzc(32);
                        zzadrVar.zzc(32);
                        int iZzb20 = zzadrVar.zzb(i13) + 1;
                        zzadrVar.zzc(1);
                        if (i20 != 1) {
                            zzaduVar = zzaduVar2;
                            jFloor = ((long) iZzb16) * ((long) iZzb17);
                        } else if (iZzb16 != 0) {
                            zzaduVar = zzaduVar2;
                            jFloor = (long) Math.floor(Math.pow(iZzb17, 1.0d / ((double) iZzb16)));
                        } else {
                            zzaduVar = zzaduVar2;
                            jFloor = 0;
                        }
                        zzadrVar.zzc((int) (jFloor * ((long) iZzb20)));
                        i19++;
                        zzaduVar2 = zzaduVar;
                        i13 = 4;
                    }
                }
            }
        }
        zzajpVar = null;
        this.zza = zzajpVar;
        if (zzajpVar == null) {
            return true;
        }
        ArrayList arrayList = new ArrayList();
        zzadu zzaduVar4 = zzajpVar.zza;
        arrayList.add(zzaduVar4.zzg);
        arrayList.add(zzajpVar.zzc);
        zzbk zzbkVarZzb = zzadv.zzb(zzfxr.zzl(zzajpVar.zzb.zza));
        zzad zzadVar = new zzad();
        zzadVar.zzX(MimeTypes.AUDIO_VORBIS);
        zzadVar.zzx(zzaduVar4.zzd);
        zzadVar.zzS(zzaduVar4.zzc);
        zzadVar.zzy(zzaduVar4.zza);
        zzadVar.zzY(zzaduVar4.zzb);
        zzadVar.zzL(arrayList);
        zzadVar.zzQ(zzbkVarZzb);
        zzajlVar.zza = zzadVar.zzad();
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzajo
    protected final void zzi(long j10) {
        super.zzi(j10);
        this.zzc = j10 != 0;
        zzadu zzaduVar = this.zzd;
        this.zzb = zzaduVar != null ? zzaduVar.zze : 0;
    }
}
