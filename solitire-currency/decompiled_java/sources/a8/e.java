package a8;

import e8.l;
import e8.r;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: HttpRequest.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class e {
    @NotNull
    public static final l a(@NotNull r rVar, @NotNull h9.l<? super l, k0> block) {
        t.i(rVar, "<this>");
        t.i(block, "block");
        l lVarB = rVar.b();
        block.invoke(lVarB);
        return lVarB;
    }

    public static final void b(@NotNull c cVar, @NotNull String urlString) {
        t.i(cVar, "<this>");
        t.i(urlString, "urlString");
        e8.k0.j(cVar.i(), urlString);
    }
}
