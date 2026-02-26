package com.google.android.gms.internal.ads;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.SparseArray;
import androidx.core.view.ViewCompat;
import androidx.media3.common.C;
import androidx.media3.exoplayer.trackselection.AdaptiveTrackSelection;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzakn implements zzaka {
    private static final byte[] zza = {0, 7, 8, 15};
    private static final byte[] zzb = {0, 119, -120, -1};
    private static final byte[] zzc = {0, 17, 34, 51, 68, 85, 102, 119, -120, -103, -86, -69, -52, -35, -18, -1};
    private final Paint zzd;
    private final Paint zze;
    private final Canvas zzf;
    private final zzakg zzg;
    private final zzakf zzh;
    private final zzakm zzi;
    private Bitmap zzj;

    public zzakn(List list) {
        zzek zzekVar = new zzek((byte[]) list.get(0));
        int iZzq = zzekVar.zzq();
        int iZzq2 = zzekVar.zzq();
        Paint paint = new Paint();
        this.zzd = paint;
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
        paint.setPathEffect(null);
        Paint paint2 = new Paint();
        this.zze = paint2;
        paint2.setStyle(Paint.Style.FILL);
        paint2.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OVER));
        paint2.setPathEffect(null);
        this.zzf = new Canvas();
        this.zzg = new zzakg(AdaptiveTrackSelection.DEFAULT_MAX_HEIGHT_TO_DISCARD, 575, 0, AdaptiveTrackSelection.DEFAULT_MAX_HEIGHT_TO_DISCARD, 0, 575);
        this.zzh = new zzakf(0, zzh(), zzi(), zzj());
        this.zzi = new zzakm(iZzq, iZzq2);
    }

    private static int zzc(int i10, int i11, int i12, int i13) {
        return (i10 << 24) | (i11 << 16) | (i12 << 8) | i13;
    }

    private static zzakf zzd(zzej zzejVar, int i10) {
        int iZzd;
        int iZzd2;
        int iZzd3;
        int iZzd4;
        int i11 = 8;
        int iZzd5 = zzejVar.zzd(8);
        zzejVar.zzn(8);
        int[] iArrZzh = zzh();
        int[] iArrZzi = zzi();
        int[] iArrZzj = zzj();
        int i12 = i10 - 2;
        while (i12 > 0) {
            int iZzd6 = zzejVar.zzd(i11);
            int iZzd7 = zzejVar.zzd(i11);
            int i13 = i12 - 2;
            int[] iArr = (iZzd7 & 128) != 0 ? iArrZzh : (iZzd7 & 64) != 0 ? iArrZzi : iArrZzj;
            if ((iZzd7 & 1) != 0) {
                iZzd3 = zzejVar.zzd(i11);
                iZzd4 = zzejVar.zzd(i11);
                iZzd = zzejVar.zzd(i11);
                iZzd2 = zzejVar.zzd(i11);
                i12 = i13 - 4;
            } else {
                int iZzd8 = zzejVar.zzd(6) << 2;
                int iZzd9 = zzejVar.zzd(4) << 4;
                i12 = i13 - 2;
                iZzd = zzejVar.zzd(4) << 4;
                iZzd2 = zzejVar.zzd(2) << 6;
                iZzd3 = iZzd8;
                iZzd4 = iZzd9;
            }
            if (iZzd3 == 0) {
                iZzd2 = 255;
            }
            if (iZzd3 == 0) {
                iZzd = 0;
            }
            if (iZzd3 == 0) {
                iZzd4 = 0;
            }
            double d10 = iZzd3;
            double d11 = iZzd4 - 128;
            double d12 = iZzd - 128;
            iArr[iZzd6] = zzc((byte) (255 - (iZzd2 & 255)), Math.max(0, Math.min((int) (d10 + (1.402d * d11)), 255)), Math.max(0, Math.min((int) ((d10 - (0.34414d * d12)) - (d11 * 0.71414d)), 255)), Math.max(0, Math.min((int) (d10 + (d12 * 1.772d)), 255)));
            iZzd5 = iZzd5;
            i11 = 8;
        }
        return new zzakf(iZzd5, iArrZzh, iArrZzi, iArrZzj);
    }

    private static zzakh zze(zzej zzejVar) {
        byte[] bArr;
        int iZzd = zzejVar.zzd(16);
        zzejVar.zzn(4);
        int iZzd2 = zzejVar.zzd(2);
        boolean zZzp = zzejVar.zzp();
        zzejVar.zzn(1);
        byte[] bArr2 = zzet.zzf;
        if (iZzd2 != 1) {
            if (iZzd2 == 0) {
                int iZzd3 = zzejVar.zzd(16);
                int iZzd4 = zzejVar.zzd(16);
                if (iZzd3 > 0) {
                    bArr2 = new byte[iZzd3];
                    zzejVar.zzi(bArr2, 0, iZzd3);
                }
                if (iZzd4 > 0) {
                    bArr = new byte[iZzd4];
                    zzejVar.zzi(bArr, 0, iZzd4);
                }
            }
            return new zzakh(iZzd, zZzp, bArr2, bArr);
        }
        zzejVar.zzn(zzejVar.zzd(8) * 16);
        bArr = bArr2;
        return new zzakh(iZzd, zZzp, bArr2, bArr);
    }

    /* JADX WARN: Removed duplicated region for block: B:110:0x01ef A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0219  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0228 A[LOOP:3: B:88:0x0172->B:119:0x0228, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0222 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0181  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void zzf(byte[] r24, int[] r25, int r26, int r27, int r28, @androidx.annotation.Nullable android.graphics.Paint r29, android.graphics.Canvas r30) {
        /*
            Method dump skipped, instruction units count: 584
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzakn.zzf(byte[], int[], int, int, int, android.graphics.Paint, android.graphics.Canvas):void");
    }

    private static byte[] zzg(int i10, int i11, zzej zzejVar) {
        byte[] bArr = new byte[i10];
        for (int i12 = 0; i12 < i10; i12++) {
            bArr[i12] = (byte) zzejVar.zzd(i11);
        }
        return bArr;
    }

    private static int[] zzh() {
        return new int[]{0, -1, ViewCompat.MEASURED_STATE_MASK, -8421505};
    }

    private static int[] zzi() {
        int[] iArr = new int[16];
        iArr[0] = 0;
        for (int i10 = 1; i10 < 16; i10++) {
            int i11 = i10 & 4;
            int i12 = i10 & 2;
            int i13 = i10 & 1;
            if (i10 < 8) {
                iArr[i10] = zzc(255, 1 != i13 ? 0 : 255, i12 != 0 ? 255 : 0, i11 != 0 ? 255 : 0);
            } else {
                iArr[i10] = zzc(255, 1 != i13 ? 0 : 127, i12 != 0 ? 127 : 0, i11 == 0 ? 0 : 127);
            }
        }
        return iArr;
    }

    private static int[] zzj() {
        int[] iArr = new int[256];
        iArr[0] = 0;
        for (int i10 = 0; i10 < 256; i10++) {
            if (i10 < 8) {
                iArr[i10] = zzc(63, 1 != (i10 & 1) ? 0 : 255, (i10 & 2) != 0 ? 255 : 0, (i10 & 4) == 0 ? 0 : 255);
            } else {
                int i11 = i10 & 136;
                if (i11 == 0) {
                    iArr[i10] = zzc(255, (1 != (i10 & 1) ? 0 : 85) + ((i10 & 16) != 0 ? 170 : 0), ((i10 & 2) != 0 ? 85 : 0) + ((i10 & 32) != 0 ? 170 : 0), ((i10 & 4) == 0 ? 0 : 85) + ((i10 & 64) == 0 ? 0 : 170));
                } else if (i11 == 8) {
                    iArr[i10] = zzc(127, (1 != (i10 & 1) ? 0 : 85) + ((i10 & 16) != 0 ? 170 : 0), ((i10 & 2) != 0 ? 85 : 0) + ((i10 & 32) != 0 ? 170 : 0), ((i10 & 4) == 0 ? 0 : 85) + ((i10 & 64) == 0 ? 0 : 170));
                } else if (i11 == 128) {
                    iArr[i10] = zzc(255, (1 != (i10 & 1) ? 0 : 43) + 127 + ((i10 & 16) != 0 ? 85 : 0), ((i10 & 2) != 0 ? 43 : 0) + 127 + ((i10 & 32) != 0 ? 85 : 0), ((i10 & 4) == 0 ? 0 : 43) + 127 + ((i10 & 64) == 0 ? 0 : 85));
                } else if (i11 == 136) {
                    iArr[i10] = zzc(255, (1 != (i10 & 1) ? 0 : 43) + ((i10 & 16) != 0 ? 85 : 0), ((i10 & 2) != 0 ? 43 : 0) + ((i10 & 32) != 0 ? 85 : 0), ((i10 & 4) == 0 ? 0 : 43) + ((i10 & 64) == 0 ? 0 : 85));
                }
            }
        }
        return iArr;
    }

    @Override // com.google.android.gms.internal.ads.zzaka
    public final void zza(byte[] bArr, int i10, int i11, zzajz zzajzVar, zzdn zzdnVar) {
        zzajs zzajsVar;
        char c10;
        char c11;
        int i12;
        SparseArray sparseArray;
        int i13;
        SparseArray sparseArray2;
        zzakk zzakkVar;
        int i14;
        int iZzd;
        int iZzd2;
        int iZzd3;
        int iZzd4;
        int i15;
        int iZzd5;
        zzej zzejVar = new zzej(bArr, i10 + i11);
        zzejVar.zzl(i10);
        while (zzejVar.zza() >= 48 && zzejVar.zzd(8) == 15) {
            zzakm zzakmVar = this.zzi;
            int iZzd6 = zzejVar.zzd(8);
            int iZzd7 = zzejVar.zzd(16);
            int iZzd8 = zzejVar.zzd(16);
            int iZzb = zzejVar.zzb() + iZzd8;
            if (iZzd8 * 8 > zzejVar.zza()) {
                zzea.zzf("DvbParser", "Data field length exceeds limit");
                zzejVar.zzn(zzejVar.zza());
            } else {
                switch (iZzd6) {
                    case 16:
                        if (iZzd7 == zzakmVar.zza) {
                            zzaki zzakiVar = zzakmVar.zzi;
                            int iZzd9 = zzejVar.zzd(8);
                            int iZzd10 = zzejVar.zzd(4);
                            int iZzd11 = zzejVar.zzd(2);
                            zzejVar.zzn(2);
                            SparseArray sparseArray3 = new SparseArray();
                            for (int i16 = iZzd8 - 2; i16 > 0; i16 -= 6) {
                                int iZzd12 = zzejVar.zzd(8);
                                zzejVar.zzn(8);
                                sparseArray3.put(iZzd12, new zzakj(zzejVar.zzd(16), zzejVar.zzd(16)));
                            }
                            zzaki zzakiVar2 = new zzaki(iZzd9, iZzd10, iZzd11, sparseArray3);
                            if (zzakiVar2.zzb != 0) {
                                zzakmVar.zzi = zzakiVar2;
                                zzakmVar.zzc.clear();
                                zzakmVar.zzd.clear();
                                zzakmVar.zze.clear();
                            } else if (zzakiVar != null) {
                                if (zzakiVar.zza != zzakiVar2.zza) {
                                    zzakmVar.zzi = zzakiVar2;
                                }
                            }
                        }
                        break;
                    case 17:
                        zzaki zzakiVar3 = zzakmVar.zzi;
                        if (iZzd7 == zzakmVar.zza && zzakiVar3 != null) {
                            int iZzd13 = zzejVar.zzd(8);
                            zzejVar.zzn(4);
                            boolean zZzp = zzejVar.zzp();
                            zzejVar.zzn(3);
                            int iZzd14 = zzejVar.zzd(16);
                            int iZzd15 = zzejVar.zzd(16);
                            int iZzd16 = zzejVar.zzd(3);
                            int iZzd17 = zzejVar.zzd(3);
                            zzejVar.zzn(2);
                            int iZzd18 = zzejVar.zzd(8);
                            int iZzd19 = zzejVar.zzd(8);
                            int iZzd20 = zzejVar.zzd(4);
                            int iZzd21 = zzejVar.zzd(2);
                            zzejVar.zzn(2);
                            int i17 = iZzd8 - 10;
                            SparseArray sparseArray4 = new SparseArray();
                            while (i17 > 0) {
                                int iZzd22 = zzejVar.zzd(16);
                                int iZzd23 = zzejVar.zzd(2);
                                int iZzd24 = zzejVar.zzd(2);
                                int iZzd25 = zzejVar.zzd(12);
                                zzejVar.zzn(4);
                                int iZzd26 = zzejVar.zzd(12);
                                i17 -= 6;
                                if (iZzd23 == 1) {
                                    i17 -= 2;
                                    i14 = iZzd23;
                                    iZzd = zzejVar.zzd(8);
                                    iZzd2 = zzejVar.zzd(8);
                                } else if (iZzd23 == 2) {
                                    iZzd23 = 2;
                                    i17 -= 2;
                                    i14 = iZzd23;
                                    iZzd = zzejVar.zzd(8);
                                    iZzd2 = zzejVar.zzd(8);
                                } else {
                                    i14 = iZzd23;
                                    iZzd = 0;
                                    iZzd2 = 0;
                                }
                                sparseArray4.put(iZzd22, new zzakl(i14, iZzd24, iZzd25, iZzd26, iZzd, iZzd2));
                            }
                            zzakk zzakkVar2 = new zzakk(iZzd13, zZzp, iZzd14, iZzd15, iZzd16, iZzd17, iZzd18, iZzd19, iZzd20, iZzd21, sparseArray4);
                            if (zzakiVar3.zzb == 0 && (zzakkVar = (zzakk) zzakmVar.zzc.get(zzakkVar2.zza)) != null) {
                                int i18 = 0;
                                while (true) {
                                    SparseArray sparseArray5 = zzakkVar.zzj;
                                    if (i18 < sparseArray5.size()) {
                                        zzakkVar2.zzj.put(sparseArray5.keyAt(i18), (zzakl) sparseArray5.valueAt(i18));
                                        i18++;
                                    }
                                }
                            }
                            zzakmVar.zzc.put(zzakkVar2.zza, zzakkVar2);
                        }
                        break;
                    case 18:
                        if (iZzd7 == zzakmVar.zza) {
                            zzakf zzakfVarZzd = zzd(zzejVar, iZzd8);
                            zzakmVar.zzd.put(zzakfVarZzd.zza, zzakfVarZzd);
                        } else if (iZzd7 == zzakmVar.zzb) {
                            zzakf zzakfVarZzd2 = zzd(zzejVar, iZzd8);
                            zzakmVar.zzf.put(zzakfVarZzd2.zza, zzakfVarZzd2);
                        }
                        break;
                    case 19:
                        if (iZzd7 == zzakmVar.zza) {
                            zzakh zzakhVarZze = zze(zzejVar);
                            zzakmVar.zze.put(zzakhVarZze.zza, zzakhVarZze);
                        } else if (iZzd7 == zzakmVar.zzb) {
                            zzakh zzakhVarZze2 = zze(zzejVar);
                            zzakmVar.zzg.put(zzakhVarZze2.zza, zzakhVarZze2);
                        }
                        break;
                    case 20:
                        if (iZzd7 == zzakmVar.zza) {
                            zzejVar.zzn(4);
                            boolean zZzp2 = zzejVar.zzp();
                            zzejVar.zzn(3);
                            int iZzd27 = zzejVar.zzd(16);
                            int iZzd28 = zzejVar.zzd(16);
                            if (zZzp2) {
                                int iZzd29 = zzejVar.zzd(16);
                                iZzd3 = zzejVar.zzd(16);
                                iZzd5 = zzejVar.zzd(16);
                                iZzd4 = zzejVar.zzd(16);
                                i15 = iZzd29;
                            } else {
                                iZzd3 = iZzd27;
                                iZzd4 = iZzd28;
                                i15 = 0;
                                iZzd5 = 0;
                            }
                            zzakmVar.zzh = new zzakg(iZzd27, iZzd28, i15, iZzd3, iZzd5, iZzd4);
                        }
                        break;
                }
                zzejVar.zzo(iZzb - zzejVar.zzb());
            }
        }
        zzakm zzakmVar2 = this.zzi;
        zzaki zzakiVar4 = zzakmVar2.zzi;
        if (zzakiVar4 == null) {
            zzajsVar = new zzajs(zzfxr.zzm(), C.TIME_UNSET, C.TIME_UNSET);
        } else {
            zzakg zzakgVar = zzakmVar2.zzh;
            if (zzakgVar == null) {
                zzakgVar = this.zzg;
            }
            Bitmap bitmap = this.zzj;
            if (bitmap == null || zzakgVar.zza + 1 != bitmap.getWidth() || zzakgVar.zzb + 1 != this.zzj.getHeight()) {
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(zzakgVar.zza + 1, zzakgVar.zzb + 1, Bitmap.Config.ARGB_8888);
                this.zzj = bitmapCreateBitmap;
                this.zzf.setBitmap(bitmapCreateBitmap);
            }
            ArrayList arrayList = new ArrayList();
            SparseArray sparseArray6 = zzakiVar4.zzc;
            int i19 = 0;
            while (i19 < sparseArray6.size()) {
                this.zzf.save();
                zzakj zzakjVar = (zzakj) sparseArray6.valueAt(i19);
                zzakk zzakkVar3 = (zzakk) this.zzi.zzc.get(sparseArray6.keyAt(i19));
                int i20 = zzakjVar.zza + zzakgVar.zzc;
                int i21 = zzakjVar.zzb + zzakgVar.zze;
                this.zzf.clipRect(i20, i21, Math.min(zzakkVar3.zzc + i20, zzakgVar.zzd), Math.min(zzakkVar3.zzd + i21, zzakgVar.zzf));
                zzakf zzakfVar = (zzakf) this.zzi.zzd.get(zzakkVar3.zzf);
                if (zzakfVar == null) {
                    zzakfVar = (zzakf) this.zzi.zzf.get(zzakkVar3.zzf);
                    if (zzakfVar == null) {
                        zzakfVar = this.zzh;
                    }
                }
                SparseArray sparseArray7 = zzakkVar3.zzj;
                int i22 = 0;
                while (i22 < sparseArray7.size()) {
                    int iKeyAt = sparseArray7.keyAt(i22);
                    zzakl zzaklVar = (zzakl) sparseArray7.valueAt(i22);
                    zzakh zzakhVar = (zzakh) this.zzi.zze.get(iKeyAt);
                    if (zzakhVar == null) {
                        zzakhVar = (zzakh) this.zzi.zzg.get(iKeyAt);
                    }
                    if (zzakhVar != null) {
                        Paint paint = zzakhVar.zzb ? null : this.zzd;
                        int i23 = zzakkVar3.zze;
                        int i24 = zzaklVar.zza + i20;
                        int i25 = zzaklVar.zzb + i21;
                        sparseArray = sparseArray6;
                        Canvas canvas = this.zzf;
                        sparseArray2 = sparseArray7;
                        i13 = i19;
                        int[] iArr = i23 == 3 ? zzakfVar.zzd : i23 == 2 ? zzakfVar.zzc : zzakfVar.zzb;
                        Paint paint2 = paint;
                        zzf(zzakhVar.zzc, iArr, i23, i24, i25, paint2, canvas);
                        zzf(zzakhVar.zzd, iArr, i23, i24, i25 + 1, paint2, canvas);
                    } else {
                        sparseArray = sparseArray6;
                        i13 = i19;
                        sparseArray2 = sparseArray7;
                    }
                    i22++;
                    sparseArray6 = sparseArray;
                    sparseArray7 = sparseArray2;
                    i19 = i13;
                }
                SparseArray sparseArray8 = sparseArray6;
                int i26 = i19;
                float f10 = i21;
                float f11 = i20;
                if (zzakkVar3.zzb) {
                    int i27 = zzakkVar3.zze;
                    c10 = 3;
                    if (i27 == 3) {
                        i12 = zzakfVar.zzd[zzakkVar3.zzg];
                        c11 = 2;
                    } else {
                        c11 = 2;
                        i12 = i27 == 2 ? zzakfVar.zzc[zzakkVar3.zzh] : zzakfVar.zzb[zzakkVar3.zzi];
                    }
                    this.zze.setColor(i12);
                    this.zzf.drawRect(f11, f10, zzakkVar3.zzc + i20, zzakkVar3.zzd + i21, this.zze);
                } else {
                    c10 = 3;
                    c11 = 2;
                }
                zzcz zzczVar = new zzcz();
                zzczVar.zzc(Bitmap.createBitmap(this.zzj, i20, i21, zzakkVar3.zzc, zzakkVar3.zzd));
                zzczVar.zzh(f11 / zzakgVar.zza);
                zzczVar.zzi(0);
                zzczVar.zze(f10 / zzakgVar.zzb, 0);
                zzczVar.zzf(0);
                zzczVar.zzk(zzakkVar3.zzc / zzakgVar.zza);
                zzczVar.zzd(zzakkVar3.zzd / zzakgVar.zzb);
                arrayList.add(zzczVar.zzp());
                this.zzf.drawColor(0, PorterDuff.Mode.CLEAR);
                this.zzf.restore();
                i19 = i26 + 1;
                sparseArray6 = sparseArray8;
            }
            zzajsVar = new zzajs(arrayList, C.TIME_UNSET, C.TIME_UNSET);
        }
        zzdnVar.zza(zzajsVar);
    }

    @Override // com.google.android.gms.internal.ads.zzaka
    public final void zzb() {
        zzakm zzakmVar = this.zzi;
        zzakmVar.zzc.clear();
        zzakmVar.zzd.clear();
        zzakmVar.zze.clear();
        zzakmVar.zzf.clear();
        zzakmVar.zzg.clear();
        zzakmVar.zzh = null;
        zzakmVar.zzi = null;
    }
}
