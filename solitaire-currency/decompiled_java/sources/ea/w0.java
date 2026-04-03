package ea;

import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.json.JsonArray;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonNull;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonPrimitive;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: TreeJsonDecoder.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class w0 {
    public static final <T> T a(@NotNull kotlinx.serialization.json.a aVar, @NotNull JsonElement element, @NotNull z9.b<T> deserializer) {
        Decoder d0Var;
        kotlin.jvm.internal.t.i(aVar, "<this>");
        kotlin.jvm.internal.t.i(element, "element");
        kotlin.jvm.internal.t.i(deserializer, "deserializer");
        if (element instanceof JsonObject) {
            d0Var = new h0(aVar, (JsonObject) element, null, null, 12, null);
        } else if (element instanceof JsonArray) {
            d0Var = new j0(aVar, (JsonArray) element);
        } else {
            if (!(element instanceof kotlinx.serialization.json.n ? true : kotlin.jvm.internal.t.d(element, JsonNull.f30027a))) {
                throw new v8.q();
            }
            d0Var = new d0(aVar, (JsonPrimitive) element);
        }
        return (T) d0Var.D(deserializer);
    }

    public static final <T> T b(@NotNull kotlinx.serialization.json.a aVar, @NotNull String discriminator, @NotNull JsonObject element, @NotNull z9.b<T> deserializer) {
        kotlin.jvm.internal.t.i(aVar, "<this>");
        kotlin.jvm.internal.t.i(discriminator, "discriminator");
        kotlin.jvm.internal.t.i(element, "element");
        kotlin.jvm.internal.t.i(deserializer, "deserializer");
        return (T) new h0(aVar, element, discriminator, deserializer.getDescriptor()).D(deserializer);
    }
}
