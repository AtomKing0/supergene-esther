package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import androidx.media3.common.C;
import java.util.ArrayList;
import java.util.zip.Inflater;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzakp implements zzaka {
    private final zzek zza = new zzek();
    private final zzek zzb = new zzek();
    private final zzako zzc = new zzako();

    @Nullable
    private Inflater zzd;

    @Override // com.google.android.gms.internal.ads.zzaka
    public final void zza(byte[] bArr, int i10, int i11, zzajz zzajzVar, zzdn zzdnVar) {
        this.zza.zzI(bArr, i11 + i10);
        this.zza.zzK(i10);
        zzek zzekVar = this.zza;
        if (zzekVar.zzb() > 0 && zzekVar.zzf() == 120) {
            if (this.zzd == null) {
                this.zzd = new Inflater();
            }
            if (zzet.zzI(zzekVar, this.zzb, this.zzd)) {
                zzek zzekVar2 = this.zzb;
                zzekVar.zzI(zzekVar2.zzM(), zzekVar2.zze());
            }
        }
        this.zzc.zze();
        ArrayList arrayList = new ArrayList();
        while (true) {
            zzek zzekVar3 = this.zza;
            if (zzekVar3.zzb() < 3) {
                zzdnVar.zza(new zzajs(arrayList, C.TIME_UNSET, C.TIME_UNSET));
                return;
            }
            zzako zzakoVar = this.zzc;
            int iZze = zzekVar3.zze();
            int iZzm = zzekVar3.zzm();
            int iZzq = zzekVar3.zzq();
            int iZzd = zzekVar3.zzd() + iZzq;
            zzdb zzdbVar = null;
            if (iZzd > iZze) {
                zzekVar3.zzK(iZze);
            } else {
                if (iZzm != 128) {
                    switch (iZzm) {
                        case 20:
                            zzako.zzd(zzakoVar, zzekVar3, iZzq);
                            break;
                        case 21:
                            zzako.zzb(zzakoVar, zzekVar3, iZzq);
                            break;
                        case 22:
                            zzako.zzc(zzakoVar, zzekVar3, iZzq);
                            break;
                    }
                } else {
                    zzdb zzdbVarZza = zzakoVar.zza();
                    zzakoVar.zze();
                    zzdbVar = zzdbVarZza;
                }
                zzekVar3.zzK(iZzd);
            }
            if (zzdbVar != null) {
                arrayList.add(zzdbVar);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaka
    public final /* synthetic */ void zzb() {
    }
}
