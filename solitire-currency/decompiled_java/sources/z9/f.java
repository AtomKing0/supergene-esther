package z9;

import kotlin.jvm.internal.o0;
import kotlin.jvm.internal.t;
import kotlinx.serialization.encoding.Encoder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: PolymorphicSerializer.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class f {
    @NotNull
    public static final <T> b<? extends T> a(@NotNull da.b<T> bVar, @NotNull ca.c decoder, @Nullable String str) {
        t.i(bVar, "<this>");
        t.i(decoder, "decoder");
        b<? extends T> bVarC = bVar.c(decoder, str);
        if (bVarC != null) {
            return bVarC;
        }
        da.c.a(str, bVar.e());
        throw new v8.h();
    }

    @NotNull
    public static final <T> j<T> b(@NotNull da.b<T> bVar, @NotNull Encoder encoder, @NotNull T value) {
        t.i(bVar, "<this>");
        t.i(encoder, "encoder");
        t.i(value, "value");
        j<T> jVarD = bVar.d(encoder, value);
        if (jVarD != null) {
            return jVarD;
        }
        da.c.b(o0.b(value.getClass()), bVar.e());
        throw new v8.h();
    }
}
