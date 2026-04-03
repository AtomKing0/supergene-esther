package com.google.android.gms.internal.ads;

import androidx.media3.common.MimeTypes;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzani {
    private final List zza;
    private final zzadp[] zzb;

    public zzani(List list) {
        this.zza = list;
        this.zzb = new zzadp[list.size()];
    }

    public final void zza(long j10, zzek zzekVar) {
        zzabv.zza(j10, zzekVar, this.zzb);
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
            String strZzb = zzafVar.zza;
            if (strZzb == null) {
                strZzb = zzansVar.zzb();
            }
            zzad zzadVar = new zzad();
            zzadVar.zzK(strZzb);
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
