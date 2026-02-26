package e8;

import com.ironsource.nb;
import java.nio.charset.Charset;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ContentTypes.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class d {
    @Nullable
    public static final Charset a(@NotNull i iVar) {
        kotlin.jvm.internal.t.i(iVar, "<this>");
        String strC = iVar.c(nb.M);
        if (strC == null) {
            return null;
        }
        try {
            return Charset.forName(strC);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    @NotNull
    public static final c b(@NotNull c cVar, @NotNull Charset charset) {
        kotlin.jvm.internal.t.i(cVar, "<this>");
        kotlin.jvm.internal.t.i(charset, "charset");
        return cVar.g(nb.M, o8.a.i(charset));
    }
}
