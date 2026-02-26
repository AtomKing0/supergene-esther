package com.google.android.gms.internal.drive;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
final class zzmk implements Iterator {
    private int pos;
    private Iterator zzvj;
    private final /* synthetic */ zzmi zzvk;

    private zzmk(zzmi zzmiVar) {
        this.zzvk = zzmiVar;
        this.pos = zzmiVar.zzve.size();
    }

    private final Iterator zzew() {
        if (this.zzvj == null) {
            this.zzvj = this.zzvk.zzvh.entrySet().iterator();
        }
        return this.zzvj;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        int i10 = this.pos;
        return (i10 > 0 && i10 <= this.zzvk.zzve.size()) || zzew().hasNext();
    }

    @Override // java.util.Iterator
    public final /* synthetic */ Object next() {
        if (zzew().hasNext()) {
            return (Map.Entry) zzew().next();
        }
        List list = this.zzvk.zzve;
        int i10 = this.pos - 1;
        this.pos = i10;
        return (Map.Entry) list.get(i10);
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }

    /* synthetic */ zzmk(zzmi zzmiVar, zzmj zzmjVar) {
        this(zzmiVar);
    }
}
