package com.google.android.gms.internal.ads;

import androidx.media3.common.C;
import java.io.IOException;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzalw implements zzack {
    private final zzalx zza = new zzalx(null, 0);
    private final zzek zzb = new zzek(2786);
    private boolean zzc;

    @Override // com.google.android.gms.internal.ads.zzack
    public final int zzb(zzacl zzaclVar, zzadf zzadfVar) throws IOException {
        int iZza = zzaclVar.zza(this.zzb.zzM(), 0, 2786);
        if (iZza == -1) {
            return -1;
        }
        this.zzb.zzK(0);
        this.zzb.zzJ(iZza);
        if (!this.zzc) {
            this.zza.zzd(0L, 4);
            this.zzc = true;
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
        this.zza.zzb(zzacnVar, new zzans(Integer.MIN_VALUE, 0, 1));
        zzacnVar.zzD();
        zzacnVar.zzO(new zzadh(C.TIME_UNSET, 0L));
    }

    @Override // com.google.android.gms.internal.ads.zzack
    public final void zzi(long j10, long j11) {
        this.zzc = false;
        this.zza.zze();
    }

    @Override // com.google.android.gms.internal.ads.zzack
    public final boolean zzj(zzacl zzaclVar) throws IOException {
        zzek zzekVar = new zzek(10);
        int i10 = 0;
        while (true) {
            zzaby zzabyVar = (zzaby) zzaclVar;
            zzabyVar.zzm(zzekVar.zzM(), 0, 10, false);
            zzekVar.zzK(0);
            if (zzekVar.zzo() != 4801587) {
                break;
            }
            zzekVar.zzL(3);
            int iZzl = zzekVar.zzl();
            i10 += iZzl + 10;
            zzabyVar.zzl(iZzl, false);
        }
        zzaclVar.zzj();
        zzaby zzabyVar2 = (zzaby) zzaclVar;
        zzabyVar2.zzl(i10, false);
        int i11 = 0;
        int i12 = i10;
        while (true) {
            zzabyVar2.zzm(zzekVar.zzM(), 0, 6, false);
            zzekVar.zzK(0);
            if (zzekVar.zzq() != 2935) {
                zzaclVar.zzj();
                i12++;
                if (i12 - i10 >= 8192) {
                    return false;
                }
                zzabyVar2.zzl(i12, false);
                i11 = 0;
            } else {
                i11++;
                if (i11 >= 4) {
                    return true;
                }
                int iZzb = zzabj.zzb(zzekVar.zzM());
                if (iZzb == -1) {
                    return false;
                }
                zzabyVar2.zzl(iZzb - 6, false);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzack
    public final /* synthetic */ zzack zzc() {
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzack
    public final void zzf() {
    }
}
