package kotlinx.serialization.json;

import ea.v0;
import kotlin.jvm.internal.o0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: JsonElement.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class h {
    @NotNull
    public static final JsonPrimitive a(@Nullable Boolean bool) {
        return bool == null ? JsonNull.f30027a : new n(bool, false);
    }

    @NotNull
    public static final JsonPrimitive b(@Nullable Number number) {
        return number == null ? JsonNull.f30027a : new n(number, false);
    }

    @NotNull
    public static final JsonPrimitive c(@Nullable String str) {
        return str == null ? JsonNull.f30027a : new n(str, true);
    }

    private static final Void d(JsonElement jsonElement, String str) {
        throw new IllegalArgumentException("Element " + o0.b(jsonElement.getClass()) + " is not a " + str);
    }

    @Nullable
    public static final Boolean e(@NotNull JsonPrimitive jsonPrimitive) {
        kotlin.jvm.internal.t.i(jsonPrimitive, "<this>");
        return v0.d(jsonPrimitive.a());
    }

    @Nullable
    public static final String f(@NotNull JsonPrimitive jsonPrimitive) {
        kotlin.jvm.internal.t.i(jsonPrimitive, "<this>");
        if (jsonPrimitive instanceof JsonNull) {
            return null;
        }
        return jsonPrimitive.a();
    }

    public static final double g(@NotNull JsonPrimitive jsonPrimitive) {
        kotlin.jvm.internal.t.i(jsonPrimitive, "<this>");
        return Double.parseDouble(jsonPrimitive.a());
    }

    @Nullable
    public static final Double h(@NotNull JsonPrimitive jsonPrimitive) {
        kotlin.jvm.internal.t.i(jsonPrimitive, "<this>");
        return p9.o.i(jsonPrimitive.a());
    }

    public static final float i(@NotNull JsonPrimitive jsonPrimitive) {
        kotlin.jvm.internal.t.i(jsonPrimitive, "<this>");
        return Float.parseFloat(jsonPrimitive.a());
    }

    public static final int j(@NotNull JsonPrimitive jsonPrimitive) {
        kotlin.jvm.internal.t.i(jsonPrimitive, "<this>");
        return Integer.parseInt(jsonPrimitive.a());
    }

    @NotNull
    public static final JsonObject k(@NotNull JsonElement jsonElement) {
        kotlin.jvm.internal.t.i(jsonElement, "<this>");
        JsonObject jsonObject = jsonElement instanceof JsonObject ? (JsonObject) jsonElement : null;
        if (jsonObject != null) {
            return jsonObject;
        }
        d(jsonElement, "JsonObject");
        throw new v8.h();
    }

    @NotNull
    public static final JsonPrimitive l(@NotNull JsonElement jsonElement) {
        kotlin.jvm.internal.t.i(jsonElement, "<this>");
        JsonPrimitive jsonPrimitive = jsonElement instanceof JsonPrimitive ? (JsonPrimitive) jsonElement : null;
        if (jsonPrimitive != null) {
            return jsonPrimitive;
        }
        d(jsonElement, "JsonPrimitive");
        throw new v8.h();
    }

    public static final long m(@NotNull JsonPrimitive jsonPrimitive) {
        kotlin.jvm.internal.t.i(jsonPrimitive, "<this>");
        return Long.parseLong(jsonPrimitive.a());
    }

    @Nullable
    public static final Long n(@NotNull JsonPrimitive jsonPrimitive) {
        kotlin.jvm.internal.t.i(jsonPrimitive, "<this>");
        return p9.p.n(jsonPrimitive.a());
    }
}
