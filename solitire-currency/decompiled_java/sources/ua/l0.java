package ua;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Logger;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: JvmOkio.kt */
/* JADX INFO: loaded from: classes5.dex */
final /* synthetic */ class l0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Logger f34785a = Logger.getLogger("okio.Okio");

    @NotNull
    public static final x0 b(@NotNull File file) throws FileNotFoundException {
        kotlin.jvm.internal.t.i(file, "<this>");
        return k0.h(new FileOutputStream(file, true));
    }

    public static final boolean c(@NotNull AssertionError assertionError) {
        kotlin.jvm.internal.t.i(assertionError, "<this>");
        if (assertionError.getCause() == null) {
            return false;
        }
        String message = assertionError.getMessage();
        return message != null ? p9.r.P(message, "getsockname failed", false, 2, null) : false;
    }

    @NotNull
    public static final x0 d(@NotNull File file) throws FileNotFoundException {
        kotlin.jvm.internal.t.i(file, "<this>");
        return h(file, false, 1, null);
    }

    @NotNull
    public static final x0 e(@NotNull File file, boolean z10) throws FileNotFoundException {
        kotlin.jvm.internal.t.i(file, "<this>");
        return k0.h(new FileOutputStream(file, z10));
    }

    @NotNull
    public static final x0 f(@NotNull OutputStream outputStream) {
        kotlin.jvm.internal.t.i(outputStream, "<this>");
        return new o0(outputStream, new a1());
    }

    @NotNull
    public static final x0 g(@NotNull Socket socket) throws IOException {
        kotlin.jvm.internal.t.i(socket, "<this>");
        y0 y0Var = new y0(socket);
        OutputStream outputStream = socket.getOutputStream();
        kotlin.jvm.internal.t.h(outputStream, "getOutputStream()");
        return y0Var.x(new o0(outputStream, y0Var));
    }

    public static /* synthetic */ x0 h(File file, boolean z10, int i10, Object obj) throws FileNotFoundException {
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        return k0.g(file, z10);
    }

    @NotNull
    public static final z0 i(@NotNull File file) throws FileNotFoundException {
        kotlin.jvm.internal.t.i(file, "<this>");
        return new r(new FileInputStream(file), a1.f34734e);
    }

    @NotNull
    public static final z0 j(@NotNull InputStream inputStream) {
        kotlin.jvm.internal.t.i(inputStream, "<this>");
        return new r(inputStream, new a1());
    }

    @NotNull
    public static final z0 k(@NotNull Socket socket) throws IOException {
        kotlin.jvm.internal.t.i(socket, "<this>");
        y0 y0Var = new y0(socket);
        InputStream inputStream = socket.getInputStream();
        kotlin.jvm.internal.t.h(inputStream, "getInputStream()");
        return y0Var.y(new r(inputStream, y0Var));
    }
}
