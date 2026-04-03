package com.facebook.ads.redexgen.core;

import java.util.Set;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class AG<E> extends C2877lm<E> implements Set<E> {
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.AG != com.google.common.collect.Sets$FilteredSet<E> */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.jB != com.google.common.base.Predicate<? super E> */
    public AG(Set<E> unfiltered, InterfaceC2730jB<? super E> predicate) {
        super(unfiltered, predicate);
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.AG != com.google.common.collect.Sets$FilteredSet<E> */
    @Override // java.util.Collection, java.util.Set
    public final boolean equals(@CheckForNull Object object) {
        return AbstractC3067ou.A09(this, object);
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.AG != com.google.common.collect.Sets$FilteredSet<E> */
    @Override // java.util.Collection, java.util.Set
    public final int hashCode() {
        return AbstractC3067ou.A00(this);
    }
}
