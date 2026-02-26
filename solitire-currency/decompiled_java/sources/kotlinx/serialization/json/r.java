package kotlinx.serialization.json;

import java.util.LinkedHashMap;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: JsonElementBuilders.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final Map<String, JsonElement> f30082a = new LinkedHashMap();

    @NotNull
    public final JsonObject a() {
        return new JsonObject(this.f30082a);
    }

    @Nullable
    public final JsonElement b(@NotNull String key, @NotNull JsonElement element) {
        kotlin.jvm.internal.t.i(key, "key");
        kotlin.jvm.internal.t.i(element, "element");
        return this.f30082a.put(key, element);
    }
}
