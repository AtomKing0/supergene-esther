package com.google.android.gms.internal.ads;

import java.util.ListIterator;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzfyf extends zzfzw {
    final /* synthetic */ zzfyg zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzfyf(zzfyg zzfygVar, ListIterator listIterator) {
        super(listIterator);
        this.zza = zzfygVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfzv
    final Object zza(Object obj) {
        return this.zza.zzb.apply(obj);
    }
}
