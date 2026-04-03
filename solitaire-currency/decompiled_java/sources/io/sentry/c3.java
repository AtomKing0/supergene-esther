package io.sentry;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: NoOpSerializer.java */
/* JADX INFO: loaded from: classes5.dex */
final class c3 implements l1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final c3 f27635a = new c3();

    private c3() {
    }

    public static c3 g() {
        return f27635a;
    }

    @Override // io.sentry.l1
    @Nullable
    public <T> T c(@NotNull Reader reader, @NotNull Class<T> cls) {
        return null;
    }

    @Override // io.sentry.l1
    @Nullable
    public p5 d(@NotNull InputStream inputStream) {
        return null;
    }

    @Override // io.sentry.l1
    @Nullable
    public <T, R> T e(@NotNull Reader reader, @NotNull Class<T> cls, @Nullable x1<R> x1Var) {
        return null;
    }

    @Override // io.sentry.l1
    @NotNull
    public String f(@NotNull Map<String, Object> map) throws Exception {
        return "";
    }

    @Override // io.sentry.l1
    public <T> void a(@NotNull T t10, @NotNull Writer writer) throws IOException {
    }

    @Override // io.sentry.l1
    public void b(@NotNull p5 p5Var, @NotNull OutputStream outputStream) throws Exception {
    }
}
