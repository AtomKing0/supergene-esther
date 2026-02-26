package com.google.android.gms.internal.ads;

import androidx.media3.common.C;
import java.io.IOException;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzaeq implements zzack {
    private zzacn zzf;
    private boolean zzh;
    private long zzi;
    private int zzj;
    private int zzk;
    private int zzl;
    private long zzm;
    private boolean zzn;
    private zzaep zzo;
    private zzaeu zzp;
    private final zzek zza = new zzek(4);
    private final zzek zzb = new zzek(9);
    private final zzek zzc = new zzek(11);
    private final zzek zzd = new zzek();
    private final zzaer zze = new zzaer();
    private int zzg = 1;

    private final zzek zza(zzacl zzaclVar) throws IOException {
        if (this.zzl > this.zzd.zzc()) {
            zzek zzekVar = this.zzd;
            int iZzc = zzekVar.zzc();
            zzekVar.zzI(new byte[Math.max(iZzc + iZzc, this.zzl)], 0);
        } else {
            this.zzd.zzK(0);
        }
        this.zzd.zzJ(this.zzl);
        ((zzaby) zzaclVar).zzn(this.zzd.zzM(), 0, this.zzl, false);
        return this.zzd;
    }

    private final void zzg() {
        if (this.zzn) {
            return;
        }
        this.zzf.zzO(new zzadh(C.TIME_UNSET, 0L));
        this.zzn = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c2 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0009 A[SYNTHETIC] */
    @Override // com.google.android.gms.internal.ads.zzack
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int zzb(com.google.android.gms.internal.ads.zzacl r17, com.google.android.gms.internal.ads.zzadf r18) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 376
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaeq.zzb(com.google.android.gms.internal.ads.zzacl, com.google.android.gms.internal.ads.zzadf):int");
    }

    @Override // com.google.android.gms.internal.ads.zzack
    public final /* synthetic */ List zzd() {
        return zzfxr.zzm();
    }

    @Override // com.google.android.gms.internal.ads.zzack
    public final void zze(zzacn zzacnVar) {
        this.zzf = zzacnVar;
    }

    @Override // com.google.android.gms.internal.ads.zzack
    public final void zzi(long j10, long j11) {
        if (j10 == 0) {
            this.zzg = 1;
            this.zzh = false;
        } else {
            this.zzg = 3;
        }
        this.zzj = 0;
    }

    @Override // com.google.android.gms.internal.ads.zzack
    public final boolean zzj(zzacl zzaclVar) throws IOException {
        zzaby zzabyVar = (zzaby) zzaclVar;
        zzabyVar.zzm(this.zza.zzM(), 0, 3, false);
        this.zza.zzK(0);
        if (this.zza.zzo() != 4607062) {
            return false;
        }
        zzabyVar.zzm(this.zza.zzM(), 0, 2, false);
        this.zza.zzK(0);
        if ((this.zza.zzq() & 250) != 0) {
            return false;
        }
        zzabyVar.zzm(this.zza.zzM(), 0, 4, false);
        this.zza.zzK(0);
        int iZzg = this.zza.zzg();
        zzaclVar.zzj();
        zzaby zzabyVar2 = (zzaby) zzaclVar;
        zzabyVar2.zzl(iZzg, false);
        zzabyVar2.zzm(this.zza.zzM(), 0, 4, false);
        this.zza.zzK(0);
        return this.zza.zzg() == 0;
    }

    @Override // com.google.android.gms.internal.ads.zzack
    public final /* synthetic */ zzack zzc() {
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzack
    public final void zzf() {
    }
}
