package com.google.android.gms.internal.ads;

import androidx.media3.common.C;
import java.util.ArrayList;
import java.util.Collections;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzalh implements zzaka {
    private final zzek zza = new zzek();

    @Override // com.google.android.gms.internal.ads.zzaka
    public final void zza(byte[] bArr, int i10, int i11, zzajz zzajzVar, zzdn zzdnVar) {
        zzdb zzdbVarZzp;
        this.zza.zzI(bArr, i11 + i10);
        this.zza.zzK(i10);
        ArrayList arrayList = new ArrayList();
        while (true) {
            zzek zzekVar = this.zza;
            if (zzekVar.zzb() <= 0) {
                zzdnVar.zza(new zzajs(arrayList, C.TIME_UNSET, C.TIME_UNSET));
                return;
            }
            zzdi.zze(zzekVar.zzb() >= 8, "Incomplete Mp4Webvtt Top Level box header found.");
            zzek zzekVar2 = this.zza;
            int iZzg = zzekVar2.zzg() - 8;
            if (zzekVar2.zzg() == 1987343459) {
                zzek zzekVar3 = this.zza;
                CharSequence charSequenceZza = null;
                zzcz zzczVarZzb = null;
                while (iZzg > 0) {
                    zzdi.zze(iZzg >= 8, "Incomplete vtt cue box header found.");
                    int iZzg2 = zzekVar3.zzg();
                    int iZzg3 = zzekVar3.zzg();
                    int i12 = iZzg - 8;
                    int i13 = iZzg2 - 8;
                    String strZzB = zzet.zzB(zzekVar3.zzM(), zzekVar3.zzd(), i13);
                    zzekVar3.zzL(i13);
                    if (iZzg3 == 1937011815) {
                        zzczVarZzb = zzalr.zzb(strZzB);
                    } else if (iZzg3 == 1885436268) {
                        charSequenceZza = zzalr.zza(null, strZzB.trim(), Collections.emptyList());
                    }
                    iZzg = i12 - i13;
                }
                if (charSequenceZza == null) {
                    charSequenceZza = "";
                }
                if (zzczVarZzb != null) {
                    zzczVarZzb.zzl(charSequenceZza);
                    zzdbVarZzp = zzczVarZzb.zzp();
                } else {
                    zzalq zzalqVar = new zzalq();
                    zzalqVar.zzc = charSequenceZza;
                    zzdbVarZzp = zzalqVar.zza().zzp();
                }
                arrayList.add(zzdbVarZzp);
            } else {
                this.zza.zzL(iZzg);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaka
    public final /* synthetic */ void zzb() {
    }
}
