package y7;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import y7.y;

/* JADX INFO: compiled from: HttpTimeout.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private static final xa.a f36901a = k8.a.a("io.ktor.client.plugins.HttpTimeout");

    @NotNull
    public static final x7.a a(@NotNull a8.d request, @Nullable Throwable th) {
        Object objC;
        kotlin.jvm.internal.t.i(request, "request");
        StringBuilder sb = new StringBuilder();
        sb.append("Connect timeout has expired [url=");
        sb.append(request.h());
        sb.append(", connect_timeout=");
        y.a aVar = (y.a) request.c(y.f36881d);
        if (aVar == null || (objC = aVar.c()) == null) {
            objC = "unknown";
        }
        sb.append(objC);
        sb.append(" ms]");
        return new x7.a(sb.toString(), th);
    }

    @NotNull
    public static final x7.b b(@NotNull a8.d request, @Nullable Throwable th) {
        Object objE;
        kotlin.jvm.internal.t.i(request, "request");
        StringBuilder sb = new StringBuilder();
        sb.append("Socket timeout has expired [url=");
        sb.append(request.h());
        sb.append(", socket_timeout=");
        y.a aVar = (y.a) request.c(y.f36881d);
        if (aVar == null || (objE = aVar.e()) == null) {
            objE = "unknown";
        }
        sb.append(objE);
        sb.append("] ms");
        return new x7.b(sb.toString(), th);
    }

    public static final int d(long j10) {
        if (j10 == Long.MAX_VALUE) {
            return 0;
        }
        if (j10 < -2147483648L) {
            return Integer.MIN_VALUE;
        }
        if (j10 > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) j10;
    }

    public static final void e(@NotNull a8.c cVar, @NotNull h9.l<? super y.a, k0> block) {
        kotlin.jvm.internal.t.i(cVar, "<this>");
        kotlin.jvm.internal.t.i(block, "block");
        y.b bVar = y.f36881d;
        y.a aVar = new y.a(null, null, null, 7, null);
        block.invoke(aVar);
        cVar.l(bVar, aVar);
    }
}
