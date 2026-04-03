package com.google.android.gms.internal.ads;

import java.util.Iterator;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzfve implements Iterable {
    final /* synthetic */ CharSequence zza;
    final /* synthetic */ zzfvh zzb;

    zzfve(zzfvh zzfvhVar, CharSequence charSequence) {
        this.zza = charSequence;
        this.zzb = zzfvhVar;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return this.zzb.zzf(this.zza);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        zzfum.zzb(sb, this, ", ");
        sb.append(']');
        return sb.toString();
    }
}
