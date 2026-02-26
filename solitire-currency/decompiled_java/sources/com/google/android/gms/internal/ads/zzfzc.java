package com.google.android.gms.internal.ads;

import java.util.Comparator;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class zzfzc implements Comparator {
    protected zzfzc() {
    }

    public static zzfzc zzb(Comparator comparator) {
        return new zzfxc(comparator);
    }

    public static zzfzc zzc() {
        return zzfza.zza;
    }

    @Override // java.util.Comparator
    public abstract int compare(Object obj, Object obj2);

    public zzfzc zza() {
        return new zzfzl(this);
    }
}
