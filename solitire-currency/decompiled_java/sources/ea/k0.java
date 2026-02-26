package ea;

import java.util.ArrayList;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.json.JsonArray;
import kotlinx.serialization.json.JsonElement;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: TreeJsonEncoder.kt */
/* JADX INFO: loaded from: classes5.dex */
final class k0 extends d {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    private final ArrayList<JsonElement> f25453f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k0(@NotNull kotlinx.serialization.json.a json, @NotNull h9.l<? super JsonElement, v8.k0> nodeConsumer) {
        super(json, nodeConsumer, null);
        kotlin.jvm.internal.t.i(json, "json");
        kotlin.jvm.internal.t.i(nodeConsumer, "nodeConsumer");
        this.f25453f = new ArrayList<>();
    }

    @Override // da.z0
    @NotNull
    protected String b0(@NotNull SerialDescriptor descriptor, int i10) {
        kotlin.jvm.internal.t.i(descriptor, "descriptor");
        return String.valueOf(i10);
    }

    @Override // ea.d
    @NotNull
    public JsonElement r0() {
        return new JsonArray(this.f25453f);
    }

    @Override // ea.d
    public void s0(@NotNull String key, @NotNull JsonElement element) {
        kotlin.jvm.internal.t.i(key, "key");
        kotlin.jvm.internal.t.i(element, "element");
        this.f25453f.add(Integer.parseInt(key), element);
    }
}
