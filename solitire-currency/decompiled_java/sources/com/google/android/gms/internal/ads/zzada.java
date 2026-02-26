package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.io.EOFException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzada {
    private final zzek zza = new zzek(10);

    @Nullable
    public final zzbk zza(zzacl zzaclVar, @Nullable zzaga zzagaVar) throws Throwable {
        zzbk zzbkVarZza = null;
        int i10 = 0;
        while (true) {
            try {
                ((zzaby) zzaclVar).zzm(this.zza.zzM(), 0, 10, false);
                this.zza.zzK(0);
                if (this.zza.zzo() != 4801587) {
                    break;
                }
                this.zza.zzL(3);
                int iZzl = this.zza.zzl();
                int i11 = iZzl + 10;
                if (zzbkVarZza == null) {
                    byte[] bArr = new byte[i11];
                    System.arraycopy(this.zza.zzM(), 0, bArr, 0, 10);
                    ((zzaby) zzaclVar).zzm(bArr, 10, iZzl, false);
                    zzbkVarZza = zzagc.zza(bArr, i11, zzagaVar, new zzafe());
                } else {
                    ((zzaby) zzaclVar).zzl(iZzl, false);
                }
                i10 += i11;
            } catch (EOFException unused) {
            }
        }
        zzaclVar.zzj();
        ((zzaby) zzaclVar).zzl(i10, false);
        return zzbkVarZza;
    }
}
