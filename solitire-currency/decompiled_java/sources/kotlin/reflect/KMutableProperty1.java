package kotlin.reflect;

import h9.p;
import kotlin.reflect.KMutableProperty;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: KProperty.kt */
/* JADX INFO: loaded from: classes5.dex */
public interface KMutableProperty1<T, V> extends KProperty1<T, V>, KMutableProperty<V> {

    /* JADX INFO: compiled from: KProperty.kt */
    public interface Setter<T, V> extends KMutableProperty.Setter<V>, p<T, V, k0> {
        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        /* synthetic */ k0 mo4invoke(Object obj, Object obj2);
    }

    @Override // kotlin.reflect.KMutableProperty
    @NotNull
    Setter<T, V> getSetter();

    @Override // kotlin.reflect.KProperty1, h9.l
    /* synthetic */ Object invoke(Object obj);

    void set(T t10, V v10);
}
