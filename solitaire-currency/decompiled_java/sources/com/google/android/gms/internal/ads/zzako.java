package com.google.android.gms.internal.ads;

import android.graphics.Bitmap;
import androidx.annotation.Nullable;
import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzako {
    private final zzek zza = new zzek();
    private final int[] zzb = new int[256];
    private boolean zzc;
    private int zzd;
    private int zze;
    private int zzf;
    private int zzg;
    private int zzh;
    private int zzi;

    static /* bridge */ /* synthetic */ void zzb(zzako zzakoVar, zzek zzekVar, int i10) {
        int iZzo;
        if (i10 < 4) {
            return;
        }
        zzekVar.zzL(3);
        int i11 = i10 - 4;
        if ((zzekVar.zzm() & 128) != 0) {
            if (i11 < 7 || (iZzo = zzekVar.zzo()) < 4) {
                return;
            }
            zzakoVar.zzh = zzekVar.zzq();
            zzakoVar.zzi = zzekVar.zzq();
            zzakoVar.zza.zzH(iZzo - 4);
            i11 -= 7;
        }
        zzek zzekVar2 = zzakoVar.zza;
        int iZzd = zzekVar2.zzd();
        int iZze = zzekVar2.zze();
        if (iZzd >= iZze || i11 <= 0) {
            return;
        }
        int iMin = Math.min(i11, iZze - iZzd);
        zzekVar.zzG(zzekVar2.zzM(), iZzd, iMin);
        zzakoVar.zza.zzK(iZzd + iMin);
    }

    static /* bridge */ /* synthetic */ void zzc(zzako zzakoVar, zzek zzekVar, int i10) {
        if (i10 < 19) {
            return;
        }
        zzakoVar.zzd = zzekVar.zzq();
        zzakoVar.zze = zzekVar.zzq();
        zzekVar.zzL(11);
        zzakoVar.zzf = zzekVar.zzq();
        zzakoVar.zzg = zzekVar.zzq();
    }

    static /* bridge */ /* synthetic */ void zzd(zzako zzakoVar, zzek zzekVar, int i10) {
        if (i10 % 5 != 2) {
            return;
        }
        zzekVar.zzL(2);
        int i11 = 0;
        Arrays.fill(zzakoVar.zzb, 0);
        int i12 = i10 / 5;
        int i13 = 0;
        while (i13 < i12) {
            int iZzm = zzekVar.zzm();
            int iZzm2 = zzekVar.zzm();
            int iZzm3 = zzekVar.zzm();
            int iZzm4 = zzekVar.zzm();
            int iZzm5 = zzekVar.zzm();
            double d10 = iZzm2;
            int[] iArr = zzakoVar.zzb;
            double d11 = iZzm3 - 128;
            int iMax = Math.max(i11, Math.min((int) ((1.402d * d11) + d10), 255)) << 16;
            double d12 = iZzm4 - 128;
            iArr[iZzm] = Math.max(0, Math.min((int) (d10 + (d12 * 1.772d)), 255)) | (iZzm5 << 24) | iMax | (Math.max(0, Math.min((int) ((d10 - (0.34414d * d12)) - (d11 * 0.71414d)), 255)) << 8);
            i13++;
            i11 = 0;
        }
        zzakoVar.zzc = true;
    }

    @Nullable
    public final zzdb zza() {
        int i10;
        if (this.zzd == 0 || this.zze == 0 || this.zzh == 0 || this.zzi == 0) {
            return null;
        }
        zzek zzekVar = this.zza;
        if (zzekVar.zze() == 0 || zzekVar.zzd() != zzekVar.zze() || !this.zzc) {
            return null;
        }
        zzekVar.zzK(0);
        int i11 = this.zzh * this.zzi;
        int[] iArr = new int[i11];
        int i12 = 0;
        while (i12 < i11) {
            int iZzm = this.zza.zzm();
            if (iZzm != 0) {
                i10 = i12 + 1;
                iArr[i12] = this.zzb[iZzm];
            } else {
                int iZzm2 = this.zza.zzm();
                if (iZzm2 != 0) {
                    int iZzm3 = iZzm2 & 63;
                    if ((iZzm2 & 64) != 0) {
                        iZzm3 = (iZzm3 << 8) | this.zza.zzm();
                    }
                    i10 = iZzm3 + i12;
                    Arrays.fill(iArr, i12, i10, (iZzm2 & 128) == 0 ? this.zzb[0] : this.zzb[this.zza.zzm()]);
                }
            }
            i12 = i10;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iArr, this.zzh, this.zzi, Bitmap.Config.ARGB_8888);
        zzcz zzczVar = new zzcz();
        zzczVar.zzc(bitmapCreateBitmap);
        zzczVar.zzh(this.zzf / this.zzd);
        zzczVar.zzi(0);
        zzczVar.zze(this.zzg / this.zze, 0);
        zzczVar.zzf(0);
        zzczVar.zzk(this.zzh / this.zzd);
        zzczVar.zzd(this.zzi / this.zze);
        return zzczVar.zzp();
    }

    public final void zze() {
        this.zzd = 0;
        this.zze = 0;
        this.zzf = 0;
        this.zzg = 0;
        this.zzh = 0;
        this.zzi = 0;
        this.zza.zzH(0);
        this.zzc = false;
    }
}
