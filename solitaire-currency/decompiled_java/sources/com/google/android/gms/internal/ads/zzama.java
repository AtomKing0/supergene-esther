package com.google.android.gms.internal.ads;

import androidx.media3.common.C;
import java.io.IOException;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzama implements zzack {
    private final zzamb zza;
    private final zzek zzb;
    private final zzek zzc;
    private final zzej zzd;
    private zzacn zze;
    private long zzf;
    private long zzg;
    private boolean zzh;
    private boolean zzi;

    public zzama() {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzack
    public final int zzb(zzacl zzaclVar, zzadf zzadfVar) throws IOException {
        zzdi.zzb(this.zze);
        int iZza = zzaclVar.zza(this.zzb.zzM(), 0, 2048);
        if (!this.zzi) {
            this.zze.zzO(new zzadh(C.TIME_UNSET, 0L));
            this.zzi = true;
        }
        if (iZza == -1) {
            return -1;
        }
        this.zzb.zzK(0);
        this.zzb.zzJ(iZza);
        if (!this.zzh) {
            this.zza.zzd(this.zzf, 4);
            this.zzh = true;
        }
        this.zza.zza(this.zzb);
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzack
    public final /* synthetic */ List zzd() {
        return zzfxr.zzm();
    }

    @Override // com.google.android.gms.internal.ads.zzack
    public final void zze(zzacn zzacnVar) {
        this.zze = zzacnVar;
        this.zza.zzb(zzacnVar, new zzans(Integer.MIN_VALUE, 0, 1));
        zzacnVar.zzD();
    }

    @Override // com.google.android.gms.internal.ads.zzack
    public final void zzi(long j10, long j11) {
        this.zzh = false;
        this.zza.zze();
        this.zzf = j11;
    }

    @Override // com.google.android.gms.internal.ads.zzack
    public final boolean zzj(zzacl zzaclVar) throws IOException {
        int i10 = 0;
        while (true) {
            zzaby zzabyVar = (zzaby) zzaclVar;
            zzabyVar.zzm(this.zzc.zzM(), 0, 10, false);
            this.zzc.zzK(0);
            if (this.zzc.zzo() != 4801587) {
                break;
            }
            this.zzc.zzL(3);
            int iZzl = this.zzc.zzl();
            i10 += iZzl + 10;
            zzabyVar.zzl(iZzl, false);
        }
        zzaclVar.zzj();
        zzaby zzabyVar2 = (zzaby) zzaclVar;
        zzabyVar2.zzl(i10, false);
        if (this.zzg == -1) {
            this.zzg = i10;
        }
        int i11 = 0;
        int i12 = 0;
        int i13 = i10;
        do {
            zzabyVar2.zzm(this.zzc.zzM(), 0, 2, false);
            this.zzc.zzK(0);
            if (zzamb.zzf(this.zzc.zzq())) {
                i11++;
                if (i11 >= 4 && i12 > 188) {
                    return true;
                }
                zzabyVar2.zzm(this.zzc.zzM(), 0, 4, false);
                this.zzd.zzl(14);
                int iZzd = this.zzd.zzd(13);
                if (iZzd <= 6) {
                    i13++;
                    zzaclVar.zzj();
                    zzabyVar2.zzl(i13, false);
                } else {
                    zzabyVar2.zzl(iZzd - 6, false);
                    i12 += iZzd;
                }
            } else {
                i13++;
                zzaclVar.zzj();
                zzabyVar2.zzl(i13, false);
            }
            i11 = 0;
            i12 = 0;
        } while (i13 - i10 < 8192);
        return false;
    }

    public zzama(int i10) {
        this.zza = new zzamb(true, null, 0);
        this.zzb = new zzek(2048);
        this.zzg = -1L;
        zzek zzekVar = new zzek(10);
        this.zzc = zzekVar;
        byte[] bArrZzM = zzekVar.zzM();
        this.zzd = new zzej(bArrZzM, bArrZzM.length);
    }

    @Override // com.google.android.gms.internal.ads.zzack
    public final /* synthetic */ zzack zzc() {
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzack
    public final void zzf() {
    }
}
