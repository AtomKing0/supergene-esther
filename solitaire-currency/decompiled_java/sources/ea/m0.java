package ea;

import io.sentry.protocol.ViewHierarchyNode;
import java.util.Map;
import kotlinx.serialization.json.JsonArray;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonPrimitive;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: TreeJsonEncoder.kt */
/* JADX INFO: loaded from: classes5.dex */
final class m0 extends i0 {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f25458g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f25459h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m0(@NotNull kotlinx.serialization.json.a json, @NotNull h9.l<? super JsonElement, v8.k0> nodeConsumer) {
        super(json, nodeConsumer);
        kotlin.jvm.internal.t.i(json, "json");
        kotlin.jvm.internal.t.i(nodeConsumer, "nodeConsumer");
        this.f25459h = true;
    }

    @Override // ea.i0, ea.d
    @NotNull
    public JsonElement r0() {
        return new JsonObject(t0());
    }

    @Override // ea.i0, ea.d
    public void s0(@NotNull String key, @NotNull JsonElement element) {
        kotlin.jvm.internal.t.i(key, "key");
        kotlin.jvm.internal.t.i(element, "element");
        if (!this.f25459h) {
            Map<String, JsonElement> mapT0 = t0();
            String str = this.f25458g;
            if (str == null) {
                kotlin.jvm.internal.t.A(ViewHierarchyNode.JsonKeys.TAG);
                str = null;
            }
            mapT0.put(str, element);
            this.f25459h = true;
            return;
        }
        if (element instanceof JsonPrimitive) {
            this.f25458g = ((JsonPrimitive) element).a();
            this.f25459h = false;
        } else {
            if (element instanceof JsonObject) {
                throw a0.d(kotlinx.serialization.json.s.f30083a.getDescriptor());
            }
            if (!(element instanceof JsonArray)) {
                throw new v8.q();
            }
            throw a0.d(kotlinx.serialization.json.b.f30037a.getDescriptor());
        }
    }
}
