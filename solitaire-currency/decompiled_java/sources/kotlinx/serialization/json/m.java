package kotlinx.serialization.json;

import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: Json.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class m {
    @NotNull
    public static final a a(@NotNull a from, @NotNull h9.l<? super c, k0> builderAction) {
        kotlin.jvm.internal.t.i(from, "from");
        kotlin.jvm.internal.t.i(builderAction, "builderAction");
        c cVar = new c(from);
        builderAction.invoke(cVar);
        return new l(cVar.a(), cVar.b());
    }

    public static /* synthetic */ a b(a aVar, h9.l lVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            aVar = a.f30033d;
        }
        return a(aVar, lVar);
    }
}
