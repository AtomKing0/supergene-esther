package androidx.compose.runtime;

import h9.p;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: Composition.kt */
/* JADX INFO: loaded from: classes.dex */
public interface Composition {
    void dispose();

    boolean getHasInvalidations();

    boolean isDisposed();

    void setContent(@NotNull p<? super Composer, ? super Integer, k0> pVar);
}
