package com.google.protobuf.kotlin;

import i9.a;
import java.util.Map;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: UnmodifiableCollections.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class UnmodifiableMapEntry<K, V> implements Map.Entry<K, V>, a {
    private final /* synthetic */ Map.Entry<K, V> $$delegate_0;

    /* JADX WARN: Multi-variable type inference failed */
    public UnmodifiableMapEntry(@NotNull Map.Entry<? extends K, ? extends V> delegate) {
        t.i(delegate, "delegate");
        this.$$delegate_0 = delegate;
    }

    @Override // java.util.Map.Entry
    public K getKey() {
        return this.$$delegate_0.getKey();
    }

    @Override // java.util.Map.Entry
    public V getValue() {
        return this.$$delegate_0.getValue();
    }

    @Override // java.util.Map.Entry
    public V setValue(V v10) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
