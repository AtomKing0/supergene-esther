package e8;

import java.nio.charset.Charset;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: HttpMessageProperties.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class s {
    @Nullable
    public static final Charset a(@NotNull q qVar) {
        kotlin.jvm.internal.t.i(qVar, "<this>");
        c cVarC = c(qVar);
        if (cVarC != null) {
            return d.a(cVarC);
        }
        return null;
    }

    @Nullable
    public static final Long b(@NotNull q qVar) {
        kotlin.jvm.internal.t.i(qVar, "<this>");
        String str = qVar.b().get(o.f25274a.g());
        if (str != null) {
            return Long.valueOf(Long.parseLong(str));
        }
        return null;
    }

    @Nullable
    public static final c c(@NotNull q qVar) {
        kotlin.jvm.internal.t.i(qVar, "<this>");
        String str = qVar.b().get(o.f25274a.i());
        if (str != null) {
            return c.f25197f.b(str);
        }
        return null;
    }

    @Nullable
    public static final c d(@NotNull r rVar) {
        kotlin.jvm.internal.t.i(rVar, "<this>");
        String strH = rVar.b().h(o.f25274a.i());
        if (strH != null) {
            return c.f25197f.b(strH);
        }
        return null;
    }

    public static final void e(@NotNull r rVar, @NotNull c type) {
        kotlin.jvm.internal.t.i(rVar, "<this>");
        kotlin.jvm.internal.t.i(type, "type");
        rVar.b().k(o.f25274a.i(), type.toString());
    }
}
