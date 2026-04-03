package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public class zzabu {
    protected final zzabo zza;
    protected final zzabt zzb;

    @Nullable
    protected zzabq zzc;
    private final int zzd;

    protected zzabu(zzabr zzabrVar, zzabt zzabtVar, long j10, long j11, long j12, long j13, long j14, long j15, int i10) {
        this.zzb = zzabtVar;
        this.zzd = i10;
        this.zza = new zzabo(zzabrVar, j10, 0L, j12, j13, j14, j15);
    }

    protected static final int zzf(zzacl zzaclVar, long j10, zzadf zzadfVar) {
        if (j10 == zzaclVar.zzf()) {
            return 0;
        }
        zzadfVar.zza = j10;
        return 1;
    }

    protected static final boolean zzg(zzacl zzaclVar, long j10) throws IOException {
        long jZzf = j10 - zzaclVar.zzf();
        if (jZzf < 0 || jZzf > 262144) {
            return false;
        }
        ((zzaby) zzaclVar).zzo((int) jZzf, false);
        return true;
    }

    public final int zza(zzacl zzaclVar, zzadf zzadfVar) throws IOException {
        while (true) {
            zzabq zzabqVar = this.zzc;
            zzdi.zzb(zzabqVar);
            long j10 = zzabqVar.zzf;
            long j11 = zzabqVar.zzg - j10;
            int i10 = this.zzd;
            long j12 = zzabqVar.zzh;
            if (j11 <= i10) {
                zzc(false, j10);
                return zzf(zzaclVar, j10, zzadfVar);
            }
            if (!zzg(zzaclVar, j12)) {
                return zzf(zzaclVar, j12, zzadfVar);
            }
            zzaclVar.zzj();
            zzabs zzabsVarZza = this.zzb.zza(zzaclVar, zzabqVar.zzb);
            int i11 = zzabsVarZza.zzb;
            if (i11 == -3) {
                zzc(false, j12);
                return zzf(zzaclVar, j12, zzadfVar);
            }
            if (i11 == -2) {
                zzabq.zzh(zzabqVar, zzabsVarZza.zzc, zzabsVarZza.zzd);
            } else {
                if (i11 != -1) {
                    zzg(zzaclVar, zzabsVarZza.zzd);
                    zzc(true, zzabsVarZza.zzd);
                    return zzf(zzaclVar, zzabsVarZza.zzd, zzadfVar);
                }
                zzabq.zzg(zzabqVar, zzabsVarZza.zzc, zzabsVarZza.zzd);
            }
        }
    }

    public final zzadi zzb() {
        return this.zza;
    }

    protected final void zzc(boolean z10, long j10) {
        this.zzc = null;
        this.zzb.zzb();
    }

    public final void zzd(long j10) {
        zzabq zzabqVar = this.zzc;
        if (zzabqVar == null || zzabqVar.zza != j10) {
            zzabo zzaboVar = this.zza;
            this.zzc = new zzabq(j10, zzaboVar.zzf(j10), 0L, zzaboVar.zzc, zzaboVar.zzd, zzaboVar.zze, zzaboVar.zzf);
        }
    }

    public final boolean zze() {
        return this.zzc != null;
    }
}
