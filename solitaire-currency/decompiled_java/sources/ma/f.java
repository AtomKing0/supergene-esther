package ma;

import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: HttpMethod.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final f f31482a = new f();

    private f() {
    }

    public static final boolean b(@NotNull String method) {
        t.i(method, "method");
        return (t.d(method, "GET") || t.d(method, "HEAD")) ? false : true;
    }

    public static final boolean e(@NotNull String method) {
        t.i(method, "method");
        return t.d(method, "POST") || t.d(method, "PUT") || t.d(method, "PATCH") || t.d(method, "PROPPATCH") || t.d(method, "REPORT");
    }

    public final boolean a(@NotNull String method) {
        t.i(method, "method");
        return t.d(method, "POST") || t.d(method, "PATCH") || t.d(method, "PUT") || t.d(method, "DELETE") || t.d(method, "MOVE");
    }

    public final boolean c(@NotNull String method) {
        t.i(method, "method");
        return !t.d(method, "PROPFIND");
    }

    public final boolean d(@NotNull String method) {
        t.i(method, "method");
        return t.d(method, "PROPFIND");
    }
}
