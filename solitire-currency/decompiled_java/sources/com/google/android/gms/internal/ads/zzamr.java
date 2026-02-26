package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import androidx.media3.common.C;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzamr implements zzamf {
    private final zzek zza;
    private final zzadc zzb;

    @Nullable
    private final String zzc;
    private final int zzd;
    private zzadp zze;
    private String zzf;
    private int zzg;
    private int zzh;
    private boolean zzi;
    private boolean zzj;
    private long zzk;
    private int zzl;
    private long zzm;

    public zzamr() {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzamf
    public final void zza(zzek zzekVar) {
        zzdi.zzb(this.zze);
        while (zzekVar.zzb() > 0) {
            int i10 = this.zzg;
            if (i10 == 0) {
                byte[] bArrZzM = zzekVar.zzM();
                int iZzd = zzekVar.zzd();
                int iZze = zzekVar.zze();
                while (true) {
                    if (iZzd >= iZze) {
                        zzekVar.zzK(iZze);
                        break;
                    }
                    int i11 = iZzd + 1;
                    byte b10 = bArrZzM[iZzd];
                    boolean z10 = (b10 & 255) == 255;
                    boolean z11 = this.zzj && (b10 & 224) == 224;
                    this.zzj = z10;
                    if (z11) {
                        zzekVar.zzK(i11);
                        this.zzj = false;
                        this.zza.zzM()[1] = bArrZzM[iZzd];
                        this.zzh = 2;
                        this.zzg = 1;
                        break;
                    }
                    iZzd = i11;
                }
            } else if (i10 != 1) {
                int iMin = Math.min(zzekVar.zzb(), this.zzl - this.zzh);
                this.zze.zzq(zzekVar, iMin);
                int i12 = this.zzh + iMin;
                this.zzh = i12;
                if (i12 >= this.zzl) {
                    zzdi.zzf(this.zzm != C.TIME_UNSET);
                    this.zze.zzs(this.zzm, 1, this.zzl, 0, null);
                    this.zzm += this.zzk;
                    this.zzh = 0;
                    this.zzg = 0;
                }
            } else {
                int iMin2 = Math.min(zzekVar.zzb(), 4 - this.zzh);
                zzekVar.zzG(this.zza.zzM(), this.zzh, iMin2);
                int i13 = this.zzh + iMin2;
                this.zzh = i13;
                if (i13 >= 4) {
                    this.zza.zzK(0);
                    if (this.zzb.zza(this.zza.zzg())) {
                        zzadc zzadcVar = this.zzb;
                        this.zzl = zzadcVar.zzc;
                        if (!this.zzi) {
                            this.zzk = (((long) zzadcVar.zzg) * 1000000) / ((long) zzadcVar.zzd);
                            zzad zzadVar = new zzad();
                            zzadVar.zzK(this.zzf);
                            zzadVar.zzX(this.zzb.zzb);
                            zzadVar.zzP(4096);
                            zzadVar.zzy(this.zzb.zze);
                            zzadVar.zzY(this.zzb.zzd);
                            zzadVar.zzO(this.zzc);
                            zzadVar.zzV(this.zzd);
                            this.zze.zzl(zzadVar.zzad());
                            this.zzi = true;
                        }
                        this.zza.zzK(0);
                        this.zze.zzq(this.zza, 4);
                        this.zzg = 2;
                    } else {
                        this.zzh = 0;
                        this.zzg = 1;
                    }
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamf
    public final void zzb(zzacn zzacnVar, zzans zzansVar) {
        zzansVar.zzc();
        this.zzf = zzansVar.zzb();
        this.zze = zzacnVar.zzw(zzansVar.zza(), 1);
    }

    @Override // com.google.android.gms.internal.ads.zzamf
    public final void zzd(long j10, int i10) {
        this.zzm = j10;
    }

    @Override // com.google.android.gms.internal.ads.zzamf
    public final void zze() {
        this.zzg = 0;
        this.zzh = 0;
        this.zzj = false;
        this.zzm = C.TIME_UNSET;
    }

    public zzamr(@Nullable String str, int i10) {
        this.zzg = 0;
        zzek zzekVar = new zzek(4);
        this.zza = zzekVar;
        zzekVar.zzM()[0] = -1;
        this.zzb = new zzadc();
        this.zzm = C.TIME_UNSET;
        this.zzc = str;
        this.zzd = i10;
    }

    @Override // com.google.android.gms.internal.ads.zzamf
    public final void zzc(boolean z10) {
    }
}
