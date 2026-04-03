package com.google.android.gms.internal.drive;

import java.util.ListIterator;

/* JADX INFO: loaded from: classes3.dex */
final class zznb implements ListIterator<String> {
    private ListIterator<String> zzvu;
    private final /* synthetic */ int zzvv;
    private final /* synthetic */ zzna zzvw;

    zznb(zzna zznaVar, int i10) {
        this.zzvw = zznaVar;
        this.zzvv = i10;
        this.zzvu = zznaVar.zzvt.listIterator(i10);
    }

    @Override // java.util.ListIterator
    public final /* synthetic */ void add(String str) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final boolean hasNext() {
        return this.zzvu.hasNext();
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.zzvu.hasPrevious();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final /* synthetic */ Object next() {
        return this.zzvu.next();
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.zzvu.nextIndex();
    }

    @Override // java.util.ListIterator
    public final /* synthetic */ String previous() {
        return this.zzvu.previous();
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.zzvu.previousIndex();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.ListIterator
    public final /* synthetic */ void set(String str) {
        throw new UnsupportedOperationException();
    }
}
