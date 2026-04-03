package ma;

import ga.b0;
import ga.v;
import java.net.Proxy;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: RequestLine.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final i f31495a = new i();

    private i() {
    }

    private final boolean b(b0 b0Var, Proxy.Type type) {
        return !b0Var.g() && type == Proxy.Type.HTTP;
    }

    @NotNull
    public final String a(@NotNull b0 request, @NotNull Proxy.Type proxyType) {
        t.i(request, "request");
        t.i(proxyType, "proxyType");
        StringBuilder sb = new StringBuilder();
        sb.append(request.h());
        sb.append(' ');
        i iVar = f31495a;
        if (iVar.b(request, proxyType)) {
            sb.append(request.k());
        } else {
            sb.append(iVar.c(request.k()));
        }
        sb.append(" HTTP/1.1");
        String string = sb.toString();
        t.h(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    @NotNull
    public final String c(@NotNull v url) {
        t.i(url, "url");
        String strD = url.d();
        String strF = url.f();
        if (strF == null) {
            return strD;
        }
        return strD + '?' + ((Object) strF);
    }
}
