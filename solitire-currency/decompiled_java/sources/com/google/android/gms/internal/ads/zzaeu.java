package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzaeu extends zzaet {
    private final zzek zzb;
    private final zzek zzc;
    private int zzd;
    private boolean zze;
    private boolean zzf;
    private int zzg;

    public zzaeu(zzadp zzadpVar) {
        super(zzadpVar);
        this.zzb = new zzek(zzfh.zza);
        this.zzc = new zzek(4);
    }

    @Override // com.google.android.gms.internal.ads.zzaet
    protected final boolean zza(zzek zzekVar) throws zzaes {
        int iZzm = zzekVar.zzm();
        int i10 = iZzm >> 4;
        int i11 = iZzm & 15;
        if (i11 == 7) {
            this.zzg = i10;
            return i10 != 5;
        }
        throw new zzaes("Video format not supported: " + i11);
    }

    @Override // com.google.android.gms.internal.ads.zzaet
    protected final boolean zzb(zzek zzekVar, long j10) throws zzbo {
        int i10;
        int iZzm = zzekVar.zzm();
        long jZzh = zzekVar.zzh();
        if (iZzm == 0) {
            if (!this.zze) {
                zzek zzekVar2 = new zzek(new byte[zzekVar.zzb()]);
                zzekVar.zzG(zzekVar2.zzM(), 0, zzekVar.zzb());
                zzabn zzabnVarZza = zzabn.zza(zzekVar2);
                this.zzd = zzabnVarZza.zzb;
                zzad zzadVar = new zzad();
                zzadVar.zzX("video/avc");
                zzadVar.zzz(zzabnVarZza.zzk);
                zzadVar.zzac(zzabnVarZza.zzc);
                zzadVar.zzI(zzabnVarZza.zzd);
                zzadVar.zzT(zzabnVarZza.zzj);
                zzadVar.zzL(zzabnVarZza.zza);
                this.zza.zzl(zzadVar.zzad());
                this.zze = true;
                return false;
            }
        } else if (iZzm == 1 && this.zze) {
            int i11 = this.zzg == 1 ? 1 : 0;
            if (this.zzf) {
                i10 = i11;
            } else if (i11 != 0) {
                i10 = 1;
            }
            byte[] bArrZzM = this.zzc.zzM();
            bArrZzM[0] = 0;
            bArrZzM[1] = 0;
            bArrZzM[2] = 0;
            int i12 = 4 - this.zzd;
            int i13 = 0;
            while (zzekVar.zzb() > 0) {
                zzekVar.zzG(this.zzc.zzM(), i12, this.zzd);
                this.zzc.zzK(0);
                zzek zzekVar3 = this.zzc;
                zzek zzekVar4 = this.zzb;
                int iZzp = zzekVar3.zzp();
                zzekVar4.zzK(0);
                this.zza.zzq(this.zzb, 4);
                this.zza.zzq(zzekVar, iZzp);
                i13 = i13 + 4 + iZzp;
            }
            this.zza.zzs(j10 + (jZzh * 1000), i10, i13, 0, null);
            this.zzf = true;
            return true;
        }
        return false;
    }
}
