package ea;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: JsonStreams.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class f0 {
    public static final <T> void a(@NotNull kotlinx.serialization.json.a aVar, @NotNull o0 writer, @NotNull z9.j<? super T> serializer, T t10) {
        kotlin.jvm.internal.t.i(aVar, "<this>");
        kotlin.jvm.internal.t.i(writer, "writer");
        kotlin.jvm.internal.t.i(serializer, "serializer");
        new s0(writer, aVar, y0.OBJ, new kotlinx.serialization.json.k[y0.values().length]).E(serializer, t10);
    }
}
