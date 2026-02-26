package com.google.android.gms.internal.ads;

import androidx.media3.common.MimeTypes;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzanv {
    private final List zza;
    private final zzadp[] zzb;

    public zzanv(List list) {
        this.zza = list;
        this.zzb = new zzadp[list.size()];
    }

    public final void zza(long j10, zzek zzekVar) {
        if (zzekVar.zzb() < 9) {
            return;
        }
        int iZzg = zzekVar.zzg();
        int iZzg2 = zzekVar.zzg();
        int iZzm = zzekVar.zzm();
        if (iZzg == 434 && iZzg2 == 1195456820 && iZzm == 3) {
            zzabv.zzb(j10, zzekVar, this.zzb);
        }
    }

    public final void zzb(zzacn zzacnVar, zzans zzansVar) {
        for (int i10 = 0; i10 < this.zzb.length; i10++) {
            zzansVar.zzc();
            zzadp zzadpVarZzw = zzacnVar.zzw(zzansVar.zza(), 3);
            zzaf zzafVar = (zzaf) this.zza.get(i10);
            String str = zzafVar.zzm;
            boolean z10 = true;
            if (!MimeTypes.APPLICATION_CEA608.equals(str) && !MimeTypes.APPLICATION_CEA708.equals(str)) {
                z10 = false;
            }
            zzdi.zze(z10, "Invalid closed caption MIME type provided: ".concat(String.valueOf(str)));
            zzad zzadVar = new zzad();
            zzadVar.zzK(zzansVar.zzb());
            zzadVar.zzX(str);
            zzadVar.zzZ(zzafVar.zze);
            zzadVar.zzO(zzafVar.zzd);
            zzadVar.zzw(zzafVar.zzE);
            zzadVar.zzL(zzafVar.zzo);
            zzadpVarZzw.zzl(zzadVar.zzad());
            this.zzb[i10] = zzadpVarZzw;
        }
    }
}
