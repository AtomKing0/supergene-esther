package y7;

import java.io.IOException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import y7.y;

/* JADX INFO: compiled from: HttpTimeout.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class w extends IOException {
    public w(@NotNull String url, @Nullable Long l10) {
        kotlin.jvm.internal.t.i(url, "url");
        StringBuilder sb = new StringBuilder();
        sb.append("Request timeout has expired [url=");
        sb.append(url);
        sb.append(", request_timeout=");
        sb.append(l10 == null ? "unknown" : l10);
        sb.append(" ms]");
        super(sb.toString());
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public w(@NotNull a8.c request) {
        kotlin.jvm.internal.t.i(request, "request");
        String strC = request.i().c();
        y.a aVar = (y.a) request.f(y.f36881d);
        this(strC, aVar != null ? aVar.d() : null);
    }
}
