package com.google.android.gms.measurement.internal;

import androidx.collection.LruCache;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@21.6.1 */
/* JADX INFO: loaded from: classes3.dex */
final class zzhe extends LruCache<String, com.google.android.gms.internal.measurement.zzb> {
    private final /* synthetic */ zzgy zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzhe(zzgy zzgyVar, int i10) {
        super(20);
        this.zza = zzgyVar;
    }

    @Override // androidx.collection.LruCache
    protected final /* synthetic */ com.google.android.gms.internal.measurement.zzb create(String str) {
        String str2 = str;
        Preconditions.checkNotEmpty(str2);
        return zzgy.zza(this.zza, str2);
    }
}
