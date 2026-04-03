package kotlinx.serialization.json;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: JsonElementBuilders.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class g {
    @Nullable
    public static final JsonElement a(@NotNull r rVar, @NotNull String key, @Nullable Boolean bool) {
        kotlin.jvm.internal.t.i(rVar, "<this>");
        kotlin.jvm.internal.t.i(key, "key");
        return rVar.b(key, h.a(bool));
    }

    @Nullable
    public static final JsonElement b(@NotNull r rVar, @NotNull String key, @Nullable Number number) {
        kotlin.jvm.internal.t.i(rVar, "<this>");
        kotlin.jvm.internal.t.i(key, "key");
        return rVar.b(key, h.b(number));
    }

    @Nullable
    public static final JsonElement c(@NotNull r rVar, @NotNull String key, @Nullable String str) {
        kotlin.jvm.internal.t.i(rVar, "<this>");
        kotlin.jvm.internal.t.i(key, "key");
        return rVar.b(key, h.c(str));
    }
}
