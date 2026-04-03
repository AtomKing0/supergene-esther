package ea;

import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonPrimitive;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: TreeJsonDecoder.kt */
/* JADX INFO: loaded from: classes5.dex */
final class d0 extends c {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    private final JsonPrimitive f25431f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d0(@NotNull kotlinx.serialization.json.a json, @NotNull JsonPrimitive value) {
        super(json, value, null);
        kotlin.jvm.internal.t.i(json, "json");
        kotlin.jvm.internal.t.i(value, "value");
        this.f25431f = value;
        X("primitive");
    }

    @Override // ea.c
    @NotNull
    protected JsonElement e0(@NotNull String tag) {
        kotlin.jvm.internal.t.i(tag, "tag");
        if (tag == "primitive") {
            return s0();
        }
        throw new IllegalArgumentException("This input can only handle primitives with 'primitive' tag".toString());
    }

    @Override // ca.c
    public int o(@NotNull SerialDescriptor descriptor) {
        kotlin.jvm.internal.t.i(descriptor, "descriptor");
        return 0;
    }

    @Override // ea.c
    @NotNull
    /* JADX INFO: renamed from: u0, reason: merged with bridge method [inline-methods] */
    public JsonPrimitive s0() {
        return this.f25431f;
    }
}
