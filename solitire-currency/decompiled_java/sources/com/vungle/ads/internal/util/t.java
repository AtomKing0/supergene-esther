package com.vungle.ads.internal.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: SafeObjectInputStream.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class t extends ObjectInputStream {

    @Nullable
    private final List<Class<?>> allowed;

    /* JADX WARN: Multi-variable type inference failed */
    public t(@Nullable InputStream inputStream, @Nullable List<? extends Class<?>> list) {
        super(inputStream);
        this.allowed = list;
    }

    @Override // java.io.ObjectInputStream
    @NotNull
    protected Class<?> resolveClass(@NotNull ObjectStreamClass desc) throws ClassNotFoundException, IOException {
        kotlin.jvm.internal.t.i(desc, "desc");
        Class<?> c10 = super.resolveClass(desc);
        if (this.allowed == null || Number.class.isAssignableFrom(c10) || kotlin.jvm.internal.t.d(String.class, c10) || kotlin.jvm.internal.t.d(Boolean.class, c10) || c10.isArray() || this.allowed.contains(c10)) {
            kotlin.jvm.internal.t.h(c10, "c");
            return c10;
        }
        throw new IOException("Deserialization is not allowed for " + desc.getName());
    }
}
