package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import androidx.media3.common.C;
import java.io.EOFException;
import java.io.IOException;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzahp implements zzack {
    private final zzek zza;
    private final zzadc zzb;
    private final zzacy zzc;
    private final zzada zzd;
    private final zzadp zze;
    private zzacn zzf;
    private zzadp zzg;
    private zzadp zzh;
    private int zzi;

    @Nullable
    private zzbk zzj;
    private long zzk;
    private long zzl;
    private long zzm;
    private int zzn;
    private zzahr zzo;
    private boolean zzp;

    public zzahp() {
        throw null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:122:0x02e6  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x02e8  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x01b6  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x01bb  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01c1  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0244  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final int zzg(com.google.android.gms.internal.ads.zzacl r35) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 784
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzahp.zzg(com.google.android.gms.internal.ads.zzacl):int");
    }

    private final long zzh(long j10) {
        return this.zzk + ((j10 * 1000000) / ((long) this.zzb.zzd));
    }

    private static boolean zzk(int i10, long j10) {
        return ((long) (i10 & (-128000))) == (j10 & (-128000));
    }

    private final boolean zzl(zzacl zzaclVar) throws IOException {
        zzahr zzahrVar = this.zzo;
        if (zzahrVar != null) {
            long jZzd = zzahrVar.zzd();
            if (jZzd != -1 && zzaclVar.zze() > jZzd - 4) {
                return true;
            }
        }
        try {
            return !zzaclVar.zzm(this.zza.zzM(), 0, 4, true);
        } catch (EOFException unused) {
            return true;
        }
    }

    private final boolean zzm(zzacl zzaclVar, boolean z10) throws Throwable {
        int iZze;
        int i10;
        int iZzb;
        zzaclVar.zzj();
        if (zzaclVar.zzf() == 0) {
            zzbk zzbkVarZza = this.zzd.zza(zzaclVar, null);
            this.zzj = zzbkVarZza;
            if (zzbkVarZza != null) {
                this.zzc.zzb(zzbkVarZza);
            }
            iZze = (int) zzaclVar.zze();
            if (!z10) {
                ((zzaby) zzaclVar).zzo(iZze, false);
            }
            i10 = 0;
        } else {
            iZze = 0;
            i10 = 0;
        }
        int i11 = i10;
        int i12 = i11;
        while (true) {
            if (!zzl(zzaclVar)) {
                this.zza.zzK(0);
                int iZzg = this.zza.zzg();
                if ((i10 == 0 || zzk(iZzg, i10)) && (iZzb = zzadd.zzb(iZzg)) != -1) {
                    i11++;
                    if (i11 != 1) {
                        if (i11 == 4) {
                            break;
                        }
                    } else {
                        this.zzb.zza(iZzg);
                        i10 = iZzg;
                    }
                    ((zzaby) zzaclVar).zzl(iZzb - 4, false);
                } else {
                    int i13 = i12 + 1;
                    if (i12 == (true != z10 ? 131072 : 32768)) {
                        if (z10) {
                            return false;
                        }
                        throw zzbo.zza("Searched too many bytes.", null);
                    }
                    if (z10) {
                        zzaclVar.zzj();
                        ((zzaby) zzaclVar).zzl(iZze + i13, false);
                    } else {
                        ((zzaby) zzaclVar).zzo(1, false);
                    }
                    i10 = 0;
                    i12 = i13;
                    i11 = 0;
                }
            } else if (i11 <= 0) {
                throw new EOFException();
            }
        }
        if (z10) {
            ((zzaby) zzaclVar).zzo(iZze + i12, false);
        } else {
            zzaclVar.zzj();
        }
        this.zzi = i10;
        return true;
    }

    public final void zza() {
        this.zzp = true;
    }

    @Override // com.google.android.gms.internal.ads.zzack
    public final int zzb(zzacl zzaclVar, zzadf zzadfVar) throws Throwable {
        zzdi.zzb(this.zzg);
        int i10 = zzet.zza;
        int iZzg = zzg(zzaclVar);
        if (iZzg == -1 && (this.zzo instanceof zzahn)) {
            if (this.zzo.zza() != zzh(this.zzl)) {
                throw null;
            }
        }
        return iZzg;
    }

    @Override // com.google.android.gms.internal.ads.zzack
    public final /* synthetic */ List zzd() {
        return zzfxr.zzm();
    }

    @Override // com.google.android.gms.internal.ads.zzack
    public final void zze(zzacn zzacnVar) {
        this.zzf = zzacnVar;
        zzadp zzadpVarZzw = zzacnVar.zzw(0, 1);
        this.zzg = zzadpVarZzw;
        this.zzh = zzadpVarZzw;
        this.zzf.zzD();
    }

    @Override // com.google.android.gms.internal.ads.zzack
    public final void zzi(long j10, long j11) {
        this.zzi = 0;
        this.zzk = C.TIME_UNSET;
        this.zzl = 0L;
        this.zzn = 0;
        zzahr zzahrVar = this.zzo;
        if (zzahrVar instanceof zzahn) {
            throw null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzack
    public final boolean zzj(zzacl zzaclVar) throws IOException {
        return zzm(zzaclVar, true);
    }

    public zzahp(int i10) {
        this.zza = new zzek(10);
        this.zzb = new zzadc();
        this.zzc = new zzacy();
        this.zzk = C.TIME_UNSET;
        this.zzd = new zzada();
        zzacj zzacjVar = new zzacj();
        this.zze = zzacjVar;
        this.zzh = zzacjVar;
    }

    @Override // com.google.android.gms.internal.ads.zzack
    public final /* synthetic */ zzack zzc() {
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzack
    public final void zzf() {
    }
}
