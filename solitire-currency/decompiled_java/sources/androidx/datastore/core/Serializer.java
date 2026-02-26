package androidx.datastore.core;

import java.io.InputStream;
import java.io.OutputStream;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import z8.d;

/* JADX INFO: compiled from: Serializer.kt */
/* JADX INFO: loaded from: classes.dex */
public interface Serializer<T> {
    T getDefaultValue();

    @Nullable
    Object readFrom(@NotNull InputStream inputStream, @NotNull d<? super T> dVar);

    @Nullable
    Object writeTo(T t10, @NotNull OutputStream outputStream, @NotNull d<? super k0> dVar);
}
