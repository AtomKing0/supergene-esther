package g8;

import java.util.Iterator;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Attributes.kt */
/* JADX INFO: loaded from: classes.dex */
public final class e {
    public static final void a(@NotNull b bVar, @NotNull b other) {
        kotlin.jvm.internal.t.i(bVar, "<this>");
        kotlin.jvm.internal.t.i(other, "other");
        Iterator<T> it = other.f().iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            kotlin.jvm.internal.t.g(aVar, "null cannot be cast to non-null type io.ktor.util.AttributeKey<kotlin.Any>");
            bVar.c(aVar, other.a(aVar));
        }
    }
}
