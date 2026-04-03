package com.google.android.gms.internal.ads;

import java.util.Set;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzgbl extends zzgbk {
    final AtomicReferenceFieldUpdater zza;
    final AtomicIntegerFieldUpdater zzb;

    zzgbl(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, AtomicIntegerFieldUpdater atomicIntegerFieldUpdater) {
        super(null);
        this.zza = atomicReferenceFieldUpdater;
        this.zzb = atomicIntegerFieldUpdater;
    }

    @Override // com.google.android.gms.internal.ads.zzgbk
    final int zza(zzgbo zzgboVar) {
        return this.zzb.decrementAndGet(zzgboVar);
    }

    @Override // com.google.android.gms.internal.ads.zzgbk
    final void zzb(zzgbo zzgboVar, Set set, Set set2) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        do {
            atomicReferenceFieldUpdater = this.zza;
            if (androidx.concurrent.futures.a.a(atomicReferenceFieldUpdater, zzgboVar, null, set2)) {
                return;
            }
        } while (atomicReferenceFieldUpdater.get(zzgboVar) == null);
    }
}
