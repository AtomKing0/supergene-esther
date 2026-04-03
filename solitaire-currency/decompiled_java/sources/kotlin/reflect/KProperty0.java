package kotlin.reflect;

import h9.a;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: KProperty.kt */
/* JADX INFO: loaded from: classes5.dex */
public interface KProperty0<V> extends KProperty<V>, a<V> {

    /* JADX INFO: compiled from: KProperty.kt */
    public interface Getter<V> extends KProperty.Getter<V>, a<V> {
        @Override // h9.a
        /* synthetic */ Object invoke();
    }

    V get();

    @Nullable
    Object getDelegate();

    @Override // kotlin.reflect.KProperty
    @NotNull
    Getter<V> getGetter();

    /* synthetic */ Object invoke();
}
