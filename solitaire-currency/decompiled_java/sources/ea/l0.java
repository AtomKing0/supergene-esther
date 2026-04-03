package ea;

import java.util.List;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonObject;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: TreeJsonDecoder.kt */
/* JADX INFO: loaded from: classes5.dex */
final class l0 extends h0 {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @NotNull
    private final JsonObject f25454k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @NotNull
    private final List<String> f25455l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final int f25456m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f25457n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l0(@NotNull kotlinx.serialization.json.a json, @NotNull JsonObject value) {
        super(json, value, null, null, 12, null);
        kotlin.jvm.internal.t.i(json, "json");
        kotlin.jvm.internal.t.i(value, "value");
        this.f25454k = value;
        List<String> listP0 = kotlin.collections.d0.P0(s0().keySet());
        this.f25455l = listP0;
        this.f25456m = listP0.size() * 2;
        this.f25457n = -1;
    }

    @Override // ea.h0, da.y0
    @NotNull
    protected String a0(@NotNull SerialDescriptor desc, int i10) {
        kotlin.jvm.internal.t.i(desc, "desc");
        return this.f25455l.get(i10 / 2);
    }

    @Override // ea.h0, ea.c, ca.c
    public void c(@NotNull SerialDescriptor descriptor) {
        kotlin.jvm.internal.t.i(descriptor, "descriptor");
    }

    @Override // ea.h0, ea.c
    @NotNull
    protected JsonElement e0(@NotNull String tag) {
        kotlin.jvm.internal.t.i(tag, "tag");
        return this.f25457n % 2 == 0 ? kotlinx.serialization.json.h.c(tag) : (JsonElement) kotlin.collections.r0.h(s0(), tag);
    }

    @Override // ea.h0, ca.c
    public int o(@NotNull SerialDescriptor descriptor) {
        kotlin.jvm.internal.t.i(descriptor, "descriptor");
        int i10 = this.f25457n;
        if (i10 >= this.f25456m - 1) {
            return -1;
        }
        int i11 = i10 + 1;
        this.f25457n = i11;
        return i11;
    }

    @Override // ea.h0, ea.c
    @NotNull
    /* JADX INFO: renamed from: w0, reason: merged with bridge method [inline-methods] */
    public JsonObject s0() {
        return this.f25454k;
    }
}
