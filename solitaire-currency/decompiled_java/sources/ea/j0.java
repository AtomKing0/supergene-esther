package ea;

import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.json.JsonArray;
import kotlinx.serialization.json.JsonElement;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: TreeJsonDecoder.kt */
/* JADX INFO: loaded from: classes5.dex */
final class j0 extends c {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    private final JsonArray f25450f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f25451g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f25452h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j0(@NotNull kotlinx.serialization.json.a json, @NotNull JsonArray value) {
        super(json, value, null);
        kotlin.jvm.internal.t.i(json, "json");
        kotlin.jvm.internal.t.i(value, "value");
        this.f25450f = value;
        this.f25451g = s0().size();
        this.f25452h = -1;
    }

    @Override // da.y0
    @NotNull
    protected String a0(@NotNull SerialDescriptor desc, int i10) {
        kotlin.jvm.internal.t.i(desc, "desc");
        return String.valueOf(i10);
    }

    @Override // ea.c
    @NotNull
    protected JsonElement e0(@NotNull String tag) {
        kotlin.jvm.internal.t.i(tag, "tag");
        return s0().get(Integer.parseInt(tag));
    }

    @Override // ca.c
    public int o(@NotNull SerialDescriptor descriptor) {
        kotlin.jvm.internal.t.i(descriptor, "descriptor");
        int i10 = this.f25452h;
        if (i10 >= this.f25451g - 1) {
            return -1;
        }
        int i11 = i10 + 1;
        this.f25452h = i11;
        return i11;
    }

    @Override // ea.c
    @NotNull
    /* JADX INFO: renamed from: u0, reason: merged with bridge method [inline-methods] */
    public JsonArray s0() {
        return this.f25450f;
    }
}
