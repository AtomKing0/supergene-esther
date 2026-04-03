package com.google.android.gms.internal.ads;

import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
class zzfwg implements Iterator {
    final Iterator zza;
    final Collection zzb;
    final /* synthetic */ zzfwh zzc;

    zzfwg(zzfwh zzfwhVar, Iterator it) {
        this.zzc = zzfwhVar;
        this.zzb = zzfwhVar.zzb;
        this.zza = it;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        zza();
        return this.zza.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        zza();
        return this.zza.next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        this.zza.remove();
        zzfwk zzfwkVar = this.zzc.zze;
        zzfwkVar.zzb--;
        this.zzc.zzc();
    }

    final void zza() {
        this.zzc.zzb();
        if (this.zzc.zzb != this.zzb) {
            throw new ConcurrentModificationException();
        }
    }

    zzfwg(zzfwh zzfwhVar) {
        this.zzc = zzfwhVar;
        Collection collection = zzfwhVar.zzb;
        this.zzb = collection;
        this.zza = collection instanceof List ? ((List) collection).listIterator() : collection.iterator();
    }
}
