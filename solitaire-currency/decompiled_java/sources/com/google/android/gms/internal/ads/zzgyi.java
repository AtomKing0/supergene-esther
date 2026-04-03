package com.google.android.gms.internal.ads;

import java.util.AbstractList;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzgyi extends AbstractList {
    private final zzgyg zza;
    private final zzgyh zzb;

    public zzgyi(zzgyg zzgygVar, zzgyh zzgyhVar) {
        this.zza = zzgygVar;
        this.zzb = zzgyhVar;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i10) {
        return this.zzb.zzb(this.zza.zzd(i10));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zza.size();
    }
}
