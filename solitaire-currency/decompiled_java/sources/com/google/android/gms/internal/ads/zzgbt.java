package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
abstract class zzgbt extends zzgbi {
    private List zza;

    zzgbt(zzfxm zzfxmVar, boolean z10) {
        super(zzfxmVar, z10, true);
        List listEmptyList = zzfxmVar.isEmpty() ? Collections.emptyList() : zzfyh.zza(zzfxmVar.size());
        for (int i10 = 0; i10 < zzfxmVar.size(); i10++) {
            listEmptyList.add(null);
        }
        this.zza = listEmptyList;
    }

    abstract Object zzG(List list);

    @Override // com.google.android.gms.internal.ads.zzgbi
    final void zzf(int i10, Object obj) {
        List list = this.zza;
        if (list != null) {
            list.set(i10, new zzgbs(obj));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgbi
    final void zzu() {
        List list = this.zza;
        if (list != null) {
            zzc(zzG(list));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgbi
    final void zzy(int i10) {
        super.zzy(i10);
        this.zza = null;
    }
}
