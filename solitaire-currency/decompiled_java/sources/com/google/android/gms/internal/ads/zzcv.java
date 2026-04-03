package com.google.android.gms.internal.ads;

import java.nio.ShortBuffer;
import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzcv {
    private final int zza;
    private final int zzb;
    private final float zzc;
    private final float zzd;
    private final float zze;
    private final int zzf;
    private final int zzg;
    private final int zzh;
    private final short[] zzi;
    private short[] zzj;
    private int zzk;
    private short[] zzl;
    private int zzm;
    private short[] zzn;
    private int zzo;
    private int zzp;
    private int zzq;
    private int zzr;
    private int zzs;
    private int zzt;
    private int zzu;
    private int zzv;

    public zzcv(int i10, int i11, float f10, float f11, int i12) {
        this.zza = i10;
        this.zzb = i11;
        this.zzc = f10;
        this.zzd = f11;
        this.zze = i10 / i12;
        this.zzf = i10 / 400;
        int i13 = i10 / 65;
        this.zzg = i13;
        int i14 = i13 + i13;
        this.zzh = i14;
        this.zzi = new short[i14];
        int i15 = i14 * i11;
        this.zzj = new short[i15];
        this.zzl = new short[i15];
        this.zzn = new short[i15];
    }

    private final int zzg(short[] sArr, int i10, int i11, int i12) {
        int i13 = 1;
        int i14 = 255;
        int i15 = 0;
        int i16 = 0;
        while (i11 <= i12) {
            int iAbs = 0;
            for (int i17 = 0; i17 < i11; i17++) {
                int i18 = this.zzb * i10;
                iAbs += Math.abs(sArr[i18 + i17] - sArr[(i18 + i11) + i17]);
            }
            int i19 = iAbs * i15;
            int i20 = i13 * i11;
            if (i19 < i20) {
                i13 = iAbs;
            }
            if (i19 < i20) {
                i15 = i11;
            }
            int i21 = iAbs * i14;
            int i22 = i16 * i11;
            if (i21 > i22) {
                i16 = iAbs;
            }
            if (i21 > i22) {
                i14 = i11;
            }
            i11++;
        }
        this.zzu = i13 / i15;
        this.zzv = i16 / i14;
        return i15;
    }

    private final void zzh(short[] sArr, int i10, int i11) {
        short[] sArrZzl = zzl(this.zzl, this.zzm, i11);
        this.zzl = sArrZzl;
        int i12 = this.zzm;
        int i13 = this.zzb;
        System.arraycopy(sArr, i10 * i13, sArrZzl, i12 * i13, i11 * i13);
        this.zzm += i11;
    }

    private final void zzi(short[] sArr, int i10, int i11) {
        int i12;
        for (int i13 = 0; i13 < this.zzh / i11; i13++) {
            int i14 = 0;
            int i15 = 0;
            while (true) {
                int i16 = this.zzb;
                i12 = i16 * i11;
                if (i14 < i12) {
                    i15 += sArr[(i16 * i10) + (i12 * i13) + i14];
                    i14++;
                }
            }
            this.zzi[i13] = (short) (i15 / i12);
        }
    }

    private static void zzj(int i10, int i11, short[] sArr, int i12, short[] sArr2, int i13, short[] sArr3, int i14) {
        for (int i15 = 0; i15 < i11; i15++) {
            int i16 = (i13 * i11) + i15;
            int i17 = (i14 * i11) + i15;
            int i18 = (i12 * i11) + i15;
            for (int i19 = 0; i19 < i10; i19++) {
                sArr[i18] = (short) (((sArr2[i16] * (i10 - i19)) + (sArr3[i17] * i19)) / i10);
                i18 += i11;
                i16 += i11;
                i17 += i11;
            }
        }
    }

    private final void zzk() {
        int iZzg;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        float f10 = this.zzc / this.zzd;
        double d10 = f10;
        int i17 = this.zzm;
        if (d10 > 1.00001d || d10 < 0.99999d) {
            int i18 = this.zzk;
            if (i18 >= this.zzh) {
                int i19 = 0;
                do {
                    int i20 = this.zzr;
                    if (i20 > 0) {
                        int iMin = Math.min(this.zzh, i20);
                        zzh(this.zzj, i19, iMin);
                        this.zzr -= iMin;
                        i19 += iMin;
                    } else {
                        short[] sArr = this.zzj;
                        int i21 = this.zza;
                        int i22 = i21 > 4000 ? i21 / 4000 : 1;
                        if (this.zzb == 1 && i22 == 1) {
                            iZzg = zzg(sArr, i19, this.zzf, this.zzg);
                        } else {
                            zzi(sArr, i19, i22);
                            int iZzg2 = zzg(this.zzi, 0, this.zzf / i22, this.zzg / i22);
                            if (i22 != 1) {
                                int i23 = iZzg2 * i22;
                                int i24 = i22 * 4;
                                int i25 = this.zzf;
                                int i26 = i23 - i24;
                                if (i26 >= i25) {
                                    i25 = i26;
                                }
                                int i27 = i23 + i24;
                                int i28 = this.zzg;
                                if (i27 > i28) {
                                    i27 = i28;
                                }
                                if (this.zzb == 1) {
                                    iZzg = zzg(sArr, i19, i25, i27);
                                } else {
                                    zzi(sArr, i19, 1);
                                    iZzg = zzg(this.zzi, 0, i25, i27);
                                }
                            } else {
                                iZzg = iZzg2;
                            }
                        }
                        int i29 = this.zzu;
                        int i30 = (i29 == 0 || (i12 = this.zzs) == 0 || this.zzv > i29 * 3 || i29 + i29 <= this.zzt * 3) ? iZzg : i12;
                        int i31 = i19 + i30;
                        this.zzt = i29;
                        this.zzs = iZzg;
                        float f11 = i30;
                        if (d10 > 1.0d) {
                            short[] sArr2 = this.zzj;
                            float f12 = (-1.0f) + f10;
                            if (f10 >= 2.0f) {
                                i11 = (int) (f11 / f12);
                            } else {
                                this.zzr = (int) ((f11 * (2.0f - f10)) / f12);
                                i11 = i30;
                            }
                            short[] sArrZzl = zzl(this.zzl, this.zzm, i11);
                            this.zzl = sArrZzl;
                            int i32 = i11;
                            zzj(i11, this.zzb, sArrZzl, this.zzm, sArr2, i19, sArr2, i31);
                            this.zzm += i32;
                            i19 += i30 + i32;
                        } else {
                            int i33 = i30;
                            short[] sArr3 = this.zzj;
                            float f13 = 1.0f - f10;
                            if (f10 < 0.5f) {
                                i10 = (int) ((f11 * f10) / f13);
                            } else {
                                this.zzr = (int) ((f11 * ((f10 + f10) - 1.0f)) / f13);
                                i10 = i33;
                            }
                            int i34 = i33 + i10;
                            short[] sArrZzl2 = zzl(this.zzl, this.zzm, i34);
                            this.zzl = sArrZzl2;
                            int i35 = this.zzb;
                            System.arraycopy(sArr3, i19 * i35, sArrZzl2, this.zzm * i35, i35 * i33);
                            zzj(i10, this.zzb, this.zzl, this.zzm + i33, sArr3, i31, sArr3, i19);
                            this.zzm += i34;
                            i19 += i10;
                        }
                    }
                } while (this.zzh + i19 <= i18);
                int i36 = this.zzk - i19;
                short[] sArr4 = this.zzj;
                int i37 = this.zzb;
                System.arraycopy(sArr4, i19 * i37, sArr4, 0, i37 * i36);
                this.zzk = i36;
            }
        } else {
            zzh(this.zzj, 0, this.zzk);
            this.zzk = 0;
        }
        float f14 = this.zze * this.zzd;
        if (f14 == 1.0f || this.zzm == i17) {
            return;
        }
        int i38 = this.zza;
        int i39 = (int) (i38 / f14);
        while (true) {
            if (i39 <= 16384 && i38 <= 16384) {
                break;
            }
            i39 /= 2;
            i38 /= 2;
        }
        int i40 = this.zzm - i17;
        short[] sArrZzl3 = zzl(this.zzn, this.zzo, i40);
        this.zzn = sArrZzl3;
        short[] sArr5 = this.zzl;
        int i41 = this.zzb;
        System.arraycopy(sArr5, i17 * i41, sArrZzl3, this.zzo * i41, i41 * i40);
        this.zzm = i17;
        this.zzo += i40;
        int i42 = 0;
        while (true) {
            i13 = this.zzo;
            i14 = i13 - 1;
            if (i42 >= i14) {
                break;
            }
            while (true) {
                i15 = this.zzp + 1;
                int i43 = i15 * i39;
                i16 = this.zzq;
                if (i43 <= i16 * i38) {
                    break;
                }
                this.zzl = zzl(this.zzl, this.zzm, 1);
                int i44 = 0;
                while (true) {
                    int i45 = this.zzb;
                    if (i44 < i45) {
                        short[] sArr6 = this.zzl;
                        int i46 = this.zzm * i45;
                        short[] sArr7 = this.zzn;
                        int i47 = (i42 * i45) + i44;
                        short s10 = sArr7[i47];
                        short s11 = sArr7[i47 + i45];
                        int i48 = this.zzq * i38;
                        int i49 = this.zzp;
                        int i50 = i49 * i39;
                        int i51 = (i49 + 1) * i39;
                        int i52 = i51 - i48;
                        int i53 = i51 - i50;
                        sArr6[i46 + i44] = (short) (((s10 * i52) + ((i53 - i52) * s11)) / i53);
                        i44++;
                    }
                }
                this.zzq++;
                this.zzm++;
            }
            this.zzp = i15;
            if (i15 == i38) {
                this.zzp = 0;
                zzdi.zzf(i16 == i39);
                this.zzq = 0;
            }
            i42++;
        }
        if (i14 != 0) {
            short[] sArr8 = this.zzn;
            int i54 = this.zzb;
            System.arraycopy(sArr8, i14 * i54, sArr8, 0, (i13 - i14) * i54);
            this.zzo -= i14;
        }
    }

    private final short[] zzl(short[] sArr, int i10, int i11) {
        int length = sArr.length;
        int i12 = this.zzb;
        int i13 = length / i12;
        return i10 + i11 <= i13 ? sArr : Arrays.copyOf(sArr, (((i13 * 3) / 2) + i11) * i12);
    }

    public final int zza() {
        int i10 = this.zzm * this.zzb;
        return i10 + i10;
    }

    public final int zzb() {
        int i10 = this.zzk * this.zzb;
        return i10 + i10;
    }

    public final void zzc() {
        this.zzk = 0;
        this.zzm = 0;
        this.zzo = 0;
        this.zzp = 0;
        this.zzq = 0;
        this.zzr = 0;
        this.zzs = 0;
        this.zzt = 0;
        this.zzu = 0;
        this.zzv = 0;
    }

    public final void zzd(ShortBuffer shortBuffer) {
        int iMin = Math.min(shortBuffer.remaining() / this.zzb, this.zzm);
        shortBuffer.put(this.zzl, 0, this.zzb * iMin);
        int i10 = this.zzm - iMin;
        this.zzm = i10;
        int i11 = this.zzb;
        short[] sArr = this.zzl;
        System.arraycopy(sArr, iMin * i11, sArr, 0, i10 * i11);
    }

    public final void zze() {
        int i10;
        int i11 = this.zzk;
        int i12 = this.zzm;
        float f10 = this.zzo;
        float f11 = this.zzc;
        float f12 = this.zze;
        float f13 = this.zzd;
        int i13 = i12 + ((int) ((((i11 / (f11 / f13)) + f10) / (f12 * f13)) + 0.5f));
        int i14 = this.zzh;
        this.zzj = zzl(this.zzj, i11, i14 + i14 + i11);
        int i15 = 0;
        while (true) {
            int i16 = this.zzh;
            int i17 = this.zzb;
            i10 = i16 + i16;
            if (i15 >= i10 * i17) {
                break;
            }
            this.zzj[(i17 * i11) + i15] = 0;
            i15++;
        }
        this.zzk += i10;
        zzk();
        if (this.zzm > i13) {
            this.zzm = i13;
        }
        this.zzk = 0;
        this.zzr = 0;
        this.zzo = 0;
    }

    public final void zzf(ShortBuffer shortBuffer) {
        int iRemaining = shortBuffer.remaining();
        int i10 = this.zzb;
        int i11 = iRemaining / i10;
        int i12 = i10 * i11;
        short[] sArrZzl = zzl(this.zzj, this.zzk, i11);
        this.zzj = sArrZzl;
        shortBuffer.get(sArrZzl, this.zzk * this.zzb, (i12 + i12) / 2);
        this.zzk += i11;
        zzk();
    }
}
