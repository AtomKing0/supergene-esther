package com.google.android.gms.measurement.internal;

import java.util.Iterator;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* JADX INFO: loaded from: classes3.dex */
final class zzbd implements Iterator<String> {
    private Iterator<String> zza;
    private final /* synthetic */ zzba zzb;

    zzbd(zzba zzbaVar) {
        this.zzb = zzbaVar;
        this.zza = zzbaVar.zza.keySet().iterator();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zza.hasNext();
    }

    @Override // java.util.Iterator
    public final /* synthetic */ String next() {
        return this.zza.next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Remove not supported");
    }
}
