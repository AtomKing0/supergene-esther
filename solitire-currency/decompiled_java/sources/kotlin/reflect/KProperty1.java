package kotlin.reflect;

import h9.l;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: KProperty.kt */
/* JADX INFO: loaded from: classes5.dex */
public interface KProperty1<T, V> extends KProperty<V>, l<T, V> {

    /* JADX INFO: compiled from: KProperty.kt */
    public interface Getter<T, V> extends KProperty.Getter<V>, l<T, V> {
        @Override // h9.l
        /* synthetic */ Object invoke(Object obj);
    }

    V get(T t10);

    @Nullable
    Object getDelegate(T t10);

    @Override // kotlin.reflect.KProperty
    @NotNull
    Getter<T, V> getGetter();

    /* synthetic */ Object invoke(Object obj);
}
