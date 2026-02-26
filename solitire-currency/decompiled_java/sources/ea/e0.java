package ea;

import kotlinx.serialization.json.JsonElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: TreeJsonEncoder.kt */
/* JADX INFO: loaded from: classes5.dex */
final class e0 extends d {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    private JsonElement f25432f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e0(@NotNull kotlinx.serialization.json.a json, @NotNull h9.l<? super JsonElement, v8.k0> nodeConsumer) {
        super(json, nodeConsumer, null);
        kotlin.jvm.internal.t.i(json, "json");
        kotlin.jvm.internal.t.i(nodeConsumer, "nodeConsumer");
        Z("primitive");
    }

    @Override // ea.d
    @NotNull
    public JsonElement r0() {
        JsonElement jsonElement = this.f25432f;
        if (jsonElement != null) {
            return jsonElement;
        }
        throw new IllegalArgumentException("Primitive element has not been recorded. Is call to .encodeXxx is missing in serializer?".toString());
    }

    @Override // ea.d
    public void s0(@NotNull String key, @NotNull JsonElement element) {
        kotlin.jvm.internal.t.i(key, "key");
        kotlin.jvm.internal.t.i(element, "element");
        if (!(key == "primitive")) {
            throw new IllegalArgumentException("This output can only consume primitives with 'primitive' tag".toString());
        }
        if (!(this.f25432f == null)) {
            throw new IllegalArgumentException("Primitive element was already recorded. Does call to .encodeXxx happen more than once?".toString());
        }
        this.f25432f = element;
    }
}
