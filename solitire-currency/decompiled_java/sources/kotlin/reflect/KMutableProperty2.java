package kotlin.reflect;

import h9.q;
import kotlin.reflect.KMutableProperty;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: KProperty.kt */
/* JADX INFO: loaded from: classes5.dex */
public interface KMutableProperty2<D, E, V> extends KProperty2<D, E, V>, KMutableProperty<V> {

    /* JADX INFO: compiled from: KProperty.kt */
    public interface Setter<D, E, V> extends KMutableProperty.Setter<V>, q<D, E, V, k0> {
        @Override // h9.q
        /* synthetic */ k0 invoke(Object obj, Object obj2, Object obj3);
    }

    @Override // kotlin.reflect.KMutableProperty
    @NotNull
    Setter<D, E, V> getSetter();

    @Override // kotlin.reflect.KProperty2, h9.p
    /* JADX INFO: renamed from: invoke */
    /* synthetic */ Object mo4invoke(Object obj, Object obj2);

    void set(D d10, E e10, V v10);
}
