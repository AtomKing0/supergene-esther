package ea;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: TreeJsonEncoder.kt */
/* JADX INFO: loaded from: classes5.dex */
class i0 extends d {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    private final Map<String, JsonElement> f25447f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i0(@NotNull kotlinx.serialization.json.a json, @NotNull h9.l<? super JsonElement, v8.k0> nodeConsumer) {
        super(json, nodeConsumer, null);
        kotlin.jvm.internal.t.i(json, "json");
        kotlin.jvm.internal.t.i(nodeConsumer, "nodeConsumer");
        this.f25447f = new LinkedHashMap();
    }

    @Override // da.y1, ca.d
    public <T> void h(@NotNull SerialDescriptor descriptor, int i10, @NotNull z9.j<? super T> serializer, @Nullable T t10) {
        kotlin.jvm.internal.t.i(descriptor, "descriptor");
        kotlin.jvm.internal.t.i(serializer, "serializer");
        if (t10 != null || this.f25425d.f()) {
            super.h(descriptor, i10, serializer, t10);
        }
    }

    @Override // ea.d
    @NotNull
    public JsonElement r0() {
        return new JsonObject(this.f25447f);
    }

    @Override // ea.d
    public void s0(@NotNull String key, @NotNull JsonElement element) {
        kotlin.jvm.internal.t.i(key, "key");
        kotlin.jvm.internal.t.i(element, "element");
        this.f25447f.put(key, element);
    }

    @NotNull
    protected final Map<String, JsonElement> t0() {
        return this.f25447f;
    }
}
