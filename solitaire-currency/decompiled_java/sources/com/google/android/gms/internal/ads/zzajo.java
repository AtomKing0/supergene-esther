package com.google.android.gms.internal.ads;

import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
abstract class zzajo {
    private zzadp zzb;
    private zzacn zzc;
    private zzajj zzd;
    private long zze;
    private long zzf;
    private long zzg;
    private int zzh;
    private int zzi;
    private long zzk;
    private boolean zzl;
    private boolean zzm;
    private final zzajh zza = new zzajh();
    private zzajl zzj = new zzajl();

    protected abstract long zza(zzek zzekVar);

    protected void zzb(boolean z10) {
        int i10;
        if (z10) {
            this.zzj = new zzajl();
            this.zzf = 0L;
            i10 = 0;
        } else {
            i10 = 1;
        }
        this.zzh = i10;
        this.zze = -1L;
        this.zzg = 0L;
    }

    protected abstract boolean zzc(zzek zzekVar, long j10, zzajl zzajlVar) throws IOException;

    final int zze(zzacl zzaclVar, zzadf zzadfVar) throws IOException {
        zzdi.zzb(this.zzb);
        int i10 = zzet.zza;
        int i11 = this.zzh;
        if (i11 == 0) {
            while (this.zza.zze(zzaclVar)) {
                long jZzf = zzaclVar.zzf();
                long j10 = this.zzf;
                this.zzk = jZzf - j10;
                if (zzc(this.zza.zza(), j10, this.zzj)) {
                    this.zzf = zzaclVar.zzf();
                } else {
                    zzaf zzafVar = this.zzj.zza;
                    this.zzi = zzafVar.zzA;
                    if (!this.zzm) {
                        this.zzb.zzl(zzafVar);
                        this.zzm = true;
                    }
                    zzajj zzajjVar = this.zzj.zzb;
                    if (zzajjVar != null) {
                        this.zzd = zzajjVar;
                    } else if (zzaclVar.zzd() == -1) {
                        this.zzd = new zzajn(null);
                    } else {
                        zzaji zzajiVarZzb = this.zza.zzb();
                        this.zzd = new zzajd(this, this.zzf, zzaclVar.zzd(), zzajiVarZzb.zzd + zzajiVarZzb.zze, zzajiVarZzb.zzb, (zzajiVarZzb.zza & 4) != 0);
                    }
                    this.zzh = 2;
                    this.zza.zzd();
                }
            }
            this.zzh = 3;
            return -1;
        }
        if (i11 == 1) {
            ((zzaby) zzaclVar).zzo((int) this.zzf, false);
            this.zzh = 2;
            return 0;
        }
        if (i11 != 2) {
            return -1;
        }
        long jZzd = this.zzd.zzd(zzaclVar);
        if (jZzd >= 0) {
            zzadfVar.zza = jZzd;
            return 1;
        }
        if (jZzd < -1) {
            zzi(-(jZzd + 2));
        }
        if (!this.zzl) {
            zzadi zzadiVarZze = this.zzd.zze();
            zzdi.zzb(zzadiVarZze);
            this.zzc.zzO(zzadiVarZze);
            this.zzl = true;
        }
        if (this.zzk <= 0 && !this.zza.zze(zzaclVar)) {
            this.zzh = 3;
            return -1;
        }
        this.zzk = 0L;
        zzek zzekVarZza = this.zza.zza();
        long jZza = zza(zzekVarZza);
        if (jZza >= 0) {
            long j11 = this.zzg;
            if (j11 + jZza >= this.zze) {
                long jZzf2 = zzf(j11);
                this.zzb.zzq(zzekVarZza, zzekVarZza.zze());
                this.zzb.zzs(jZzf2, 1, zzekVarZza.zze(), 0, null);
                this.zze = -1L;
            }
        }
        this.zzg += jZza;
        return 0;
    }

    protected final long zzf(long j10) {
        return (j10 * 1000000) / ((long) this.zzi);
    }

    protected final long zzg(long j10) {
        return (((long) this.zzi) * j10) / 1000000;
    }

    final void zzh(zzacn zzacnVar, zzadp zzadpVar) {
        this.zzc = zzacnVar;
        this.zzb = zzadpVar;
        zzb(true);
    }

    protected void zzi(long j10) {
        this.zzg = j10;
    }

    final void zzj(long j10, long j11) {
        this.zza.zzc();
        if (j10 == 0) {
            zzb(!this.zzl);
            return;
        }
        if (this.zzh != 0) {
            long jZzg = zzg(j11);
            this.zze = jZzg;
            zzajj zzajjVar = this.zzd;
            int i10 = zzet.zza;
            zzajjVar.zzg(jZzg);
            this.zzh = 2;
        }
    }
}
