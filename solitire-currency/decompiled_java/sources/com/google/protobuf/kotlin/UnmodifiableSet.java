package com.google.protobuf.kotlin;

import java.util.Collection;
import java.util.Set;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: UnmodifiableCollections.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class UnmodifiableSet<E> extends UnmodifiableCollection<E> implements Set<E> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UnmodifiableSet(@NotNull Collection<? extends E> delegate) {
        super(delegate);
        t.i(delegate, "delegate");
    }
}
