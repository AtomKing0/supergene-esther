package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import androidx.media3.common.C;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzamz implements zzant {
    private final zzamf zza;
    private final zzej zzb = new zzej(new byte[10], 10);
    private int zzc = 0;
    private int zzd;
    private zzer zze;
    private boolean zzf;
    private boolean zzg;
    private boolean zzh;
    private int zzi;
    private int zzj;
    private boolean zzk;

    public zzamz(zzamf zzamfVar) {
        this.zza = zzamfVar;
    }

    private final void zze(int i10) {
        this.zzc = i10;
        this.zzd = 0;
    }

    private final boolean zzf(zzek zzekVar, @Nullable byte[] bArr, int i10) {
        int iMin = Math.min(zzekVar.zzb(), i10 - this.zzd);
        if (iMin <= 0) {
            return true;
        }
        if (bArr == null) {
            zzekVar.zzL(iMin);
        } else {
            zzekVar.zzG(bArr, this.zzd, iMin);
        }
        int i11 = this.zzd + iMin;
        this.zzd = i11;
        return i11 == i10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r5v9 */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r6v12 */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r8v16, types: [com.google.android.gms.internal.ads.zzej] */
    /* JADX WARN: Type inference failed for: r8v9, types: [com.google.android.gms.internal.ads.zzamf] */
    /* JADX WARN: Type inference failed for: r9v15 */
    /* JADX WARN: Type inference failed for: r9v23 */
    /* JADX WARN: Type inference failed for: r9v9, types: [int] */
    @Override // com.google.android.gms.internal.ads.zzant
    public final void zza(zzek zzekVar, int i10) throws zzbo {
        int i11;
        ?? r52;
        int i12;
        int i13;
        long jZzb;
        int i14;
        zzdi.zzb(this.zze);
        int i15 = -1;
        int i16 = 2;
        ?? r62 = 0;
        int i17 = 1;
        if ((i10 & 1) != 0) {
            int i18 = this.zzc;
            if (i18 != 0 && i18 != 1) {
                if (i18 != 2) {
                    int i19 = this.zzj;
                    if (i19 != -1) {
                        zzea.zzf("PesReader", "Unexpected start indicator: expected " + i19 + " more bytes");
                    }
                    this.zza.zzc(zzekVar.zze() == 0);
                } else {
                    zzea.zzf("PesReader", "Unexpected start indicator reading extended header");
                }
            }
            zze(1);
        }
        int i20 = i10;
        while (zzekVar.zzb() > 0) {
            int i21 = this.zzc;
            if (i21 == 0) {
                i11 = i16;
                r52 = r62;
                i12 = i17;
                zzekVar.zzL(zzekVar.zzb());
            } else if (i21 != i17) {
                if (i21 != i16) {
                    int iZzb = zzekVar.zzb();
                    int i22 = this.zzj;
                    ?? r92 = i22 == i15 ? r62 : iZzb - i22;
                    if (r92 > 0) {
                        iZzb -= r92;
                        zzekVar.zzJ(zzekVar.zzd() + iZzb);
                    }
                    this.zza.zza(zzekVar);
                    int i23 = this.zzj;
                    if (i23 != i15) {
                        int i24 = i23 - iZzb;
                        this.zzj = i24;
                        if (i24 == 0) {
                            this.zza.zzc(r62);
                            zze(i17);
                        }
                    }
                } else {
                    if (zzf(zzekVar, this.zzb.zza, Math.min(10, this.zzi)) && zzf(zzekVar, null, this.zzi)) {
                        this.zzb.zzl(r62);
                        if (this.zzf) {
                            this.zzb.zzn(4);
                            long jZzd = this.zzb.zzd(3);
                            this.zzb.zzn(i17);
                            int iZzd = this.zzb.zzd(15) << 15;
                            this.zzb.zzn(i17);
                            long jZzd2 = this.zzb.zzd(15);
                            this.zzb.zzn(i17);
                            if (this.zzh || !this.zzg) {
                                i14 = iZzd;
                            } else {
                                this.zzb.zzn(4);
                                long jZzd3 = ((long) this.zzb.zzd(3)) << 30;
                                this.zzb.zzn(i17);
                                int iZzd2 = this.zzb.zzd(15) << 15;
                                this.zzb.zzn(i17);
                                long jZzd4 = this.zzb.zzd(15);
                                this.zzb.zzn(i17);
                                i14 = iZzd;
                                this.zze.zzb(jZzd3 | ((long) iZzd2) | jZzd4);
                                this.zzh = true;
                            }
                            jZzb = this.zze.zzb((jZzd << 30) | ((long) i14) | jZzd2);
                        } else {
                            jZzb = C.TIME_UNSET;
                        }
                        i20 |= true != this.zzk ? 0 : 4;
                        this.zza.zzd(jZzb, i20);
                        zze(3);
                        i15 = -1;
                        i16 = 2;
                        r62 = 0;
                        i17 = 1;
                    }
                }
                i11 = i16;
                r52 = r62;
                i12 = i17;
            } else if (zzf(zzekVar, this.zzb.zza, 9)) {
                r52 = 0;
                this.zzb.zzl(0);
                int iZzd3 = this.zzb.zzd(24);
                i12 = 1;
                if (iZzd3 != 1) {
                    zzea.zzf("PesReader", "Unexpected start code prefix: " + iZzd3);
                    i15 = -1;
                    this.zzj = -1;
                    i13 = 0;
                    i11 = 2;
                } else {
                    this.zzb.zzn(8);
                    zzej zzejVar = this.zzb;
                    int iZzd4 = zzejVar.zzd(16);
                    zzejVar.zzn(5);
                    this.zzk = this.zzb.zzp();
                    i11 = 2;
                    this.zzb.zzn(2);
                    this.zzf = this.zzb.zzp();
                    this.zzg = this.zzb.zzp();
                    this.zzb.zzn(6);
                    int iZzd5 = this.zzb.zzd(8);
                    this.zzi = iZzd5;
                    if (iZzd4 == 0) {
                        this.zzj = -1;
                        i15 = -1;
                    } else {
                        int i25 = (iZzd4 - 3) - iZzd5;
                        this.zzj = i25;
                        if (i25 < 0) {
                            zzea.zzf("PesReader", "Found negative packet payload size: " + i25);
                            i15 = -1;
                            this.zzj = -1;
                        } else {
                            i15 = -1;
                        }
                    }
                    i13 = 2;
                }
                zze(i13);
            } else {
                i15 = -1;
                r52 = 0;
                i12 = 1;
                i11 = 2;
            }
            i17 = i12;
            r62 = r52;
            i16 = i11;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzant
    public final void zzb(zzer zzerVar, zzacn zzacnVar, zzans zzansVar) {
        this.zze = zzerVar;
        this.zza.zzb(zzacnVar, zzansVar);
    }

    @Override // com.google.android.gms.internal.ads.zzant
    public final void zzc() {
        this.zzc = 0;
        this.zzd = 0;
        this.zzh = false;
        this.zza.zze();
    }

    public final boolean zzd(boolean z10) {
        return this.zzc == 3 && this.zzj == -1;
    }
}
