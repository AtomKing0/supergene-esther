package kotlin.reflect;

import h9.l;
import kotlin.reflect.KMutableProperty;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: KProperty.kt */
/* JADX INFO: loaded from: classes5.dex */
public interface KMutableProperty0<V> extends KProperty0<V>, KMutableProperty<V> {

    /* JADX INFO: compiled from: KProperty.kt */
    public interface Setter<V> extends KMutableProperty.Setter<V>, l<V, k0> {
        @Override // h9.l
        /* synthetic */ k0 invoke(Object obj);
    }

    @Override // kotlin.reflect.KMutableProperty
    @NotNull
    Setter<V> getSetter();

    @Override // kotlin.reflect.KProperty0, h9.a
    /* synthetic */ Object invoke();

    void set(V v10);
}
