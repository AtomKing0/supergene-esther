package com.google.android.gms.internal.consent_sdk;

import java.util.NoSuchElementException;

/* JADX INFO: compiled from: com.google.android.ump:user-messaging-platform@@3.0.0 */
/* JADX INFO: loaded from: classes3.dex */
abstract class zzcy extends zzdk {
    private final int zza;
    private int zzb;

    protected zzcy(int i10, int i11) {
        zzcw.zzb(i11, i10, "index");
        this.zza = i10;
        this.zzb = i11;
    }

    @Override // java.util.Iterator, java.util.ListIterator
    public final boolean hasNext() {
        return this.zzb < this.zza;
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.zzb > 0;
    }

    @Override // java.util.Iterator, java.util.ListIterator
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int i10 = this.zzb;
        this.zzb = i10 + 1;
        return zza(i10);
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.zzb;
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
        int i10 = this.zzb - 1;
        this.zzb = i10;
        return zza(i10);
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.zzb - 1;
    }

    protected abstract Object zza(int i10);
}
