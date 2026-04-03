package com.google.android.gms.internal.ads;

import java.util.Iterator;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzfzg extends zzfxw {
    private final transient zzfxu zza;
    private final transient zzfxr zzb;

    zzfzg(zzfxu zzfxuVar, zzfxr zzfxrVar) {
        this.zza = zzfxuVar;
        this.zzb = zzfxrVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfxm, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        return this.zza.get(obj) != null;
    }

    @Override // com.google.android.gms.internal.ads.zzfxw, com.google.android.gms.internal.ads.zzfxm, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return this.zzb.listIterator(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.zza.size();
    }

    @Override // com.google.android.gms.internal.ads.zzfxm
    final int zza(Object[] objArr, int i10) {
        return this.zzb.zza(objArr, i10);
    }

    @Override // com.google.android.gms.internal.ads.zzfxw, com.google.android.gms.internal.ads.zzfxm
    public final zzfxr zzd() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzfxw, com.google.android.gms.internal.ads.zzfxm
    /* JADX INFO: renamed from: zze */
    public final zzfzx iterator() {
        return this.zzb.listIterator(0);
    }

    @Override // com.google.android.gms.internal.ads.zzfxm
    final boolean zzf() {
        return true;
    }
}
