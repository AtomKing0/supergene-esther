package com.facebook.ads.redexgen.core;

import com.google.common.collect.ParametricNullness;
import java.util.Iterator;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ak, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1529Ak<T> extends AbstractC3098pg<T> {
    public final /* synthetic */ Iterator A00;

    public C1529Ak(final Iterator val$iterator) {
        this.A00 = val$iterator;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.A00.hasNext();
    }

    @Override // java.util.Iterator
    @ParametricNullness
    public final T next() {
        return (T) this.A00.next();
    }
}
