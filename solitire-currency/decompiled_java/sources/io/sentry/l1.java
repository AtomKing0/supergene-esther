package io.sentry;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ISerializer.java */
/* JADX INFO: loaded from: classes5.dex */
public interface l1 {
    <T> void a(@NotNull T t10, @NotNull Writer writer) throws IOException;

    void b(@NotNull p5 p5Var, @NotNull OutputStream outputStream) throws Exception;

    @Nullable
    <T> T c(@NotNull Reader reader, @NotNull Class<T> cls);

    @Nullable
    p5 d(@NotNull InputStream inputStream);

    @Nullable
    <T, R> T e(@NotNull Reader reader, @NotNull Class<T> cls, @Nullable x1<R> x1Var);

    @NotNull
    String f(@NotNull Map<String, Object> map) throws Exception;
}
