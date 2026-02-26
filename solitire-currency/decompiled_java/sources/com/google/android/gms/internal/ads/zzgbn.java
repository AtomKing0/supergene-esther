package com.google.android.gms.internal.ads;

import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzgbn extends zzgbk {
    private zzgbn() {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzgbk
    final int zza(zzgbo zzgboVar) {
        int i10;
        synchronized (zzgboVar) {
            i10 = zzgboVar.remaining - 1;
            zzgboVar.remaining = i10;
        }
        return i10;
    }

    @Override // com.google.android.gms.internal.ads.zzgbk
    final void zzb(zzgbo zzgboVar, Set set, Set set2) {
        synchronized (zzgboVar) {
            if (zzgboVar.seenExceptions == null) {
                zzgboVar.seenExceptions = set2;
            }
        }
    }

    /* synthetic */ zzgbn(zzgbm zzgbmVar) {
        super(null);
    }
}
