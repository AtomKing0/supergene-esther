package com.google.android.gms.internal.ads;

import androidx.core.view.InputDeviceCompat;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzanh implements zzant {
    private final zzang zza;
    private final zzek zzb = new zzek(32);
    private int zzc;
    private int zzd;
    private boolean zze;
    private boolean zzf;

    public zzanh(zzang zzangVar) {
        this.zza = zzangVar;
    }

    @Override // com.google.android.gms.internal.ads.zzant
    public final void zza(zzek zzekVar, int i10) {
        int i11 = i10 & 1;
        int iZzd = i11 != 0 ? zzekVar.zzd() + zzekVar.zzm() : -1;
        if (this.zzf) {
            if (i11 == 0) {
                return;
            }
            this.zzf = false;
            zzekVar.zzK(iZzd);
            this.zzd = 0;
        }
        while (zzekVar.zzb() > 0) {
            int i12 = this.zzd;
            if (i12 < 3) {
                if (i12 == 0) {
                    int iZzm = zzekVar.zzm();
                    zzekVar.zzK(zzekVar.zzd() - 1);
                    if (iZzm == 255) {
                        this.zzf = true;
                        return;
                    }
                }
                int iMin = Math.min(zzekVar.zzb(), 3 - this.zzd);
                zzekVar.zzG(this.zzb.zzM(), this.zzd, iMin);
                int i13 = this.zzd + iMin;
                this.zzd = i13;
                if (i13 == 3) {
                    this.zzb.zzK(0);
                    this.zzb.zzJ(3);
                    this.zzb.zzL(1);
                    zzek zzekVar2 = this.zzb;
                    int iZzm2 = zzekVar2.zzm();
                    boolean z10 = (iZzm2 & 128) != 0;
                    int iZzm3 = zzekVar2.zzm();
                    this.zze = z10;
                    this.zzc = (iZzm3 | ((iZzm2 & 15) << 8)) + 3;
                    int iZzc = this.zzb.zzc();
                    int i14 = this.zzc;
                    if (iZzc < i14) {
                        int iZzc2 = this.zzb.zzc();
                        this.zzb.zzE(Math.min(InputDeviceCompat.SOURCE_TOUCHSCREEN, Math.max(i14, iZzc2 + iZzc2)));
                    }
                }
            } else {
                int iMin2 = Math.min(zzekVar.zzb(), this.zzc - i12);
                zzekVar.zzG(this.zzb.zzM(), this.zzd, iMin2);
                int i15 = this.zzd + iMin2;
                this.zzd = i15;
                int i16 = this.zzc;
                if (i15 != i16) {
                    continue;
                } else {
                    if (!this.zze) {
                        this.zzb.zzJ(i16);
                    } else {
                        if (zzet.zze(this.zzb.zzM(), 0, i16, -1) != 0) {
                            this.zzf = true;
                            return;
                        }
                        this.zzb.zzJ(this.zzc - 4);
                    }
                    this.zzb.zzK(0);
                    this.zza.zza(this.zzb);
                    this.zzd = 0;
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzant
    public final void zzb(zzer zzerVar, zzacn zzacnVar, zzans zzansVar) {
        this.zza.zzb(zzerVar, zzacnVar, zzansVar);
        this.zzf = true;
    }

    @Override // com.google.android.gms.internal.ads.zzant
    public final void zzc() {
        this.zzf = true;
    }
}
