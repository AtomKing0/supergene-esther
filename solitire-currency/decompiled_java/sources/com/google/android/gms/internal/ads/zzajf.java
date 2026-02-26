package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzajf extends zzajo {

    @Nullable
    private zzacv zza;

    @Nullable
    private zzaje zzb;

    zzajf() {
    }

    private static boolean zzd(byte[] bArr) {
        return bArr[0] == -1;
    }

    @Override // com.google.android.gms.internal.ads.zzajo
    protected final long zza(zzek zzekVar) {
        if (!zzd(zzekVar.zzM())) {
            return -1L;
        }
        int i10 = (zzekVar.zzM()[2] & 255) >> 4;
        if (i10 == 6) {
            zzekVar.zzL(4);
            zzekVar.zzw();
        } else if (i10 == 7) {
            i10 = 7;
            zzekVar.zzL(4);
            zzekVar.zzw();
        }
        int iZza = zzacr.zza(zzekVar, i10);
        zzekVar.zzK(0);
        return iZza;
    }

    @Override // com.google.android.gms.internal.ads.zzajo
    protected final void zzb(boolean z10) {
        super.zzb(z10);
        if (z10) {
            this.zza = null;
            this.zzb = null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzajo
    protected final boolean zzc(zzek zzekVar, long j10, zzajl zzajlVar) {
        byte[] bArrZzM = zzekVar.zzM();
        zzacv zzacvVar = this.zza;
        if (zzacvVar == null) {
            zzacv zzacvVar2 = new zzacv(bArrZzM, 17);
            this.zza = zzacvVar2;
            zzajlVar.zza = zzacvVar2.zzc(Arrays.copyOfRange(bArrZzM, 9, zzekVar.zze()), null);
            return true;
        }
        if ((bArrZzM[0] & 127) == 3) {
            zzacu zzacuVarZzb = zzacs.zzb(zzekVar);
            zzacv zzacvVarZzf = zzacvVar.zzf(zzacuVarZzb);
            this.zza = zzacvVarZzf;
            this.zzb = new zzaje(zzacvVarZzf, zzacuVarZzb);
            return true;
        }
        if (!zzd(bArrZzM)) {
            return true;
        }
        zzaje zzajeVar = this.zzb;
        if (zzajeVar != null) {
            zzajeVar.zza(j10);
            zzajlVar.zzb = this.zzb;
        }
        zzajlVar.zza.getClass();
        return false;
    }
}
