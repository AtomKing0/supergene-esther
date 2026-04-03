package com.google.android.gms.internal.ads;

import androidx.core.view.ViewCompat;
import androidx.media3.common.C;
import androidx.media3.common.MimeTypes;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzams implements zzamf {
    private String zze;
    private zzadp zzf;
    private boolean zzi;
    private int zzk;
    private int zzl;
    private int zzn;
    private int zzo;
    private int zzs;
    private boolean zzu;
    private int zzd = 0;
    private final zzek zza = new zzek(new byte[15], 2);
    private final zzej zzb = new zzej();
    private final zzek zzc = new zzek();
    private final zzamt zzp = new zzamt();
    private int zzq = C.RATE_UNSET_INT;
    private int zzr = -1;
    private long zzt = -1;
    private boolean zzj = true;
    private boolean zzm = true;
    private double zzg = -9.223372036854776E18d;
    private double zzh = -9.223372036854776E18d;

    private static final void zzf(zzek zzekVar, zzek zzekVar2, boolean z10) {
        int iZzd = zzekVar.zzd();
        int iMin = Math.min(zzekVar.zzb(), zzekVar2.zzb());
        zzekVar.zzG(zzekVar2.zzM(), zzekVar2.zzd(), iMin);
        zzekVar2.zzL(iMin);
        if (z10) {
            zzekVar.zzK(iZzd);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamf
    public final void zza(zzek zzekVar) throws zzbo {
        int i10;
        zzdi.zzb(this.zzf);
        while (zzekVar.zzb() > 0) {
            int i11 = this.zzd;
            int iZzd = 0;
            if (i11 == 0) {
                int i12 = this.zzk;
                if ((i12 & 2) != 0) {
                    if ((i12 & 4) == 0) {
                        while (zzekVar.zzb() > 0) {
                            int i13 = this.zzl << 8;
                            this.zzl = i13;
                            int iZzm = i13 | zzekVar.zzm();
                            this.zzl = iZzm;
                            if ((iZzm & ViewCompat.MEASURED_SIZE_MASK) == 12583333) {
                                zzekVar.zzK(zzekVar.zzd() - 3);
                                this.zzl = 0;
                            }
                        }
                    }
                    this.zzd = 1;
                    break;
                }
                zzekVar.zzK(zzekVar.zze());
            } else if (i11 != 1) {
                int i14 = this.zzp.zza;
                if (i14 == 1 || i14 == 17) {
                    zzf(zzekVar, this.zzc, true);
                }
                int iMin = Math.min(zzekVar.zzb(), this.zzp.zzc - this.zzn);
                this.zzf.zzq(zzekVar, iMin);
                int i15 = this.zzn + iMin;
                this.zzn = i15;
                zzamt zzamtVar = this.zzp;
                if (i15 == zzamtVar.zzc) {
                    int i16 = zzamtVar.zza;
                    if (i16 == 1) {
                        byte[] bArrZzM = this.zzc.zzM();
                        zzamv zzamvVarZza = zzamw.zza(new zzej(bArrZzM, bArrZzM.length));
                        this.zzq = zzamvVarZza.zzb;
                        this.zzr = zzamvVarZza.zzc;
                        long j10 = this.zzt;
                        long j11 = this.zzp.zzb;
                        if (j10 != j11) {
                            this.zzt = j11;
                            int i17 = zzamvVarZza.zza;
                            String strConcat = i17 != -1 ? "mhm1".concat(String.valueOf(String.format(".%02X", Integer.valueOf(i17)))) : "mhm1";
                            byte[] bArr = zzamvVarZza.zzd;
                            zzfxr zzfxrVarZzo = null;
                            if (bArr != null && bArr.length > 0) {
                                zzfxrVarZzo = zzfxr.zzo(zzet.zzf, bArr);
                            }
                            zzad zzadVar = new zzad();
                            zzadVar.zzK(this.zze);
                            zzadVar.zzX(MimeTypes.AUDIO_MPEGH_MHM1);
                            zzadVar.zzY(this.zzq);
                            zzadVar.zzz(strConcat);
                            zzadVar.zzL(zzfxrVarZzo);
                            this.zzf.zzl(zzadVar.zzad());
                        }
                        this.zzu = true;
                    } else if (i16 == 17) {
                        byte[] bArrZzM2 = this.zzc.zzM();
                        zzej zzejVar = new zzej(bArrZzM2, bArrZzM2.length);
                        if (zzejVar.zzp()) {
                            zzejVar.zzn(2);
                            iZzd = zzejVar.zzd(13);
                        }
                        this.zzs = iZzd;
                    } else if (i16 == 2) {
                        if (this.zzu) {
                            this.zzj = false;
                            i10 = 1;
                        } else {
                            i10 = 0;
                        }
                        int i18 = this.zzr - this.zzs;
                        double d10 = this.zzq;
                        long jRound = Math.round(this.zzg);
                        if (this.zzi) {
                            this.zzi = false;
                            this.zzg = this.zzh;
                        } else {
                            this.zzg += (((double) i18) * 1000000.0d) / d10;
                        }
                        this.zzf.zzs(jRound, i10, this.zzo, 0, null);
                        this.zzu = false;
                        this.zzs = 0;
                        this.zzo = 0;
                    }
                    this.zzd = 1;
                }
            } else {
                zzf(zzekVar, this.zza, false);
                zzek zzekVar2 = this.zza;
                if (zzekVar2.zzb() == 0) {
                    zzej zzejVar2 = this.zzb;
                    int iZze = zzekVar2.zze();
                    zzejVar2.zzk(zzekVar2.zzM(), iZze);
                    if (zzamw.zzb(this.zzb, this.zzp)) {
                        this.zzn = 0;
                        this.zzo += this.zzp.zzc + iZze;
                        this.zza.zzK(0);
                        zzadp zzadpVar = this.zzf;
                        zzek zzekVar3 = this.zza;
                        zzadpVar.zzq(zzekVar3, zzekVar3.zze());
                        this.zza.zzH(2);
                        this.zzc.zzH(this.zzp.zzc);
                        this.zzm = true;
                        this.zzd = 2;
                    } else {
                        zzek zzekVar4 = this.zza;
                        if (zzekVar4.zze() < 15) {
                            zzekVar4.zzJ(zzekVar4.zze() + 1);
                        }
                    }
                }
                this.zzm = false;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamf
    public final void zzb(zzacn zzacnVar, zzans zzansVar) {
        zzansVar.zzc();
        this.zze = zzansVar.zzb();
        this.zzf = zzacnVar.zzw(zzansVar.zza(), 1);
    }

    @Override // com.google.android.gms.internal.ads.zzamf
    public final void zzd(long j10, int i10) {
        this.zzk = i10;
        if (!this.zzj && (this.zzo != 0 || !this.zzm)) {
            this.zzi = true;
        }
        if (j10 != C.TIME_UNSET) {
            double d10 = j10;
            if (this.zzi) {
                this.zzh = d10;
            } else {
                this.zzg = d10;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamf
    public final void zze() {
        this.zzd = 0;
        this.zzl = 0;
        this.zza.zzH(2);
        this.zzn = 0;
        this.zzo = 0;
        this.zzq = C.RATE_UNSET_INT;
        this.zzr = -1;
        this.zzs = 0;
        this.zzt = -1L;
        this.zzu = false;
        this.zzi = false;
        this.zzm = true;
        this.zzj = true;
        this.zzg = -9.223372036854776E18d;
        this.zzh = -9.223372036854776E18d;
    }

    @Override // com.google.android.gms.internal.ads.zzamf
    public final void zzc(boolean z10) {
    }
}
