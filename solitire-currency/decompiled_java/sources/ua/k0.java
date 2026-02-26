package ua;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes5.dex */
public final class k0 {
    @NotNull
    public static final x0 a(@NotNull File file) throws FileNotFoundException {
        return l0.b(file);
    }

    @NotNull
    public static final x0 b() {
        return m0.a();
    }

    @NotNull
    public static final d c(@NotNull x0 x0Var) {
        return m0.b(x0Var);
    }

    @NotNull
    public static final e d(@NotNull z0 z0Var) {
        return m0.c(z0Var);
    }

    public static final boolean e(@NotNull AssertionError assertionError) {
        return l0.c(assertionError);
    }

    @NotNull
    public static final x0 f(@NotNull File file) throws FileNotFoundException {
        return l0.d(file);
    }

    @NotNull
    public static final x0 g(@NotNull File file, boolean z10) throws FileNotFoundException {
        return l0.e(file, z10);
    }

    @NotNull
    public static final x0 h(@NotNull OutputStream outputStream) {
        return l0.f(outputStream);
    }

    @NotNull
    public static final x0 i(@NotNull Socket socket) throws IOException {
        return l0.g(socket);
    }

    @NotNull
    public static final z0 k(@NotNull File file) throws FileNotFoundException {
        return l0.i(file);
    }

    @NotNull
    public static final z0 l(@NotNull InputStream inputStream) {
        return l0.j(inputStream);
    }

    @NotNull
    public static final z0 m(@NotNull Socket socket) throws IOException {
        return l0.k(socket);
    }
}
