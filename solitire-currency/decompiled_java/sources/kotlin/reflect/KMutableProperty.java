package kotlin.reflect;

import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: KProperty.kt */
/* JADX INFO: loaded from: classes5.dex */
public interface KMutableProperty<V> extends KProperty<V> {

    /* JADX INFO: compiled from: KProperty.kt */
    public interface Setter<V> extends KProperty.Accessor<V>, KFunction<k0> {
    }

    @NotNull
    Setter<V> getSetter();
}
