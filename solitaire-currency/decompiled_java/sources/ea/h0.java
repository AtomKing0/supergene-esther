package ea;

import ba.i;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.collections.a1;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonNull;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonPrimitive;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: TreeJsonDecoder.kt */
/* JADX INFO: loaded from: classes5.dex */
class h0 extends c {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    private final JsonObject f25439f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    private final String f25440g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Nullable
    private final SerialDescriptor f25441h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f25442i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f25443j;

    /* JADX INFO: compiled from: TreeJsonDecoder.kt */
    /* synthetic */ class a extends kotlin.jvm.internal.q implements h9.a<Map<String, ? extends Integer>> {
        a(Object obj) {
            super(0, obj, b0.class, "buildAlternativeNamesMap", "buildAlternativeNamesMap(Lkotlinx/serialization/descriptors/SerialDescriptor;)Ljava/util/Map;", 1);
        }

        @Override // h9.a
        @NotNull
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public final Map<String, Integer> invoke() {
            return b0.a((SerialDescriptor) this.receiver);
        }
    }

    public /* synthetic */ h0(kotlinx.serialization.json.a aVar, JsonObject jsonObject, String str, SerialDescriptor serialDescriptor, int i10, kotlin.jvm.internal.k kVar) {
        this(aVar, jsonObject, (i10 & 4) != 0 ? null : str, (i10 & 8) != 0 ? null : serialDescriptor);
    }

    private final boolean u0(SerialDescriptor serialDescriptor, int i10) {
        boolean z10 = (d().e().f() || serialDescriptor.i(i10) || !serialDescriptor.g(i10).b()) ? false : true;
        this.f25443j = z10;
        return z10;
    }

    private final boolean v0(SerialDescriptor serialDescriptor, int i10, String str) {
        kotlinx.serialization.json.a aVarD = d();
        SerialDescriptor serialDescriptorG = serialDescriptor.g(i10);
        if (!serialDescriptorG.b() && (e0(str) instanceof JsonNull)) {
            return true;
        }
        if (kotlin.jvm.internal.t.d(serialDescriptorG.getKind(), i.b.f2320a)) {
            JsonElement jsonElementE0 = e0(str);
            JsonPrimitive jsonPrimitive = jsonElementE0 instanceof JsonPrimitive ? (JsonPrimitive) jsonElementE0 : null;
            String strF = jsonPrimitive != null ? kotlinx.serialization.json.h.f(jsonPrimitive) : null;
            if (strF != null && b0.d(serialDescriptorG, aVarD, strF) == -3) {
                return true;
            }
        }
        return false;
    }

    @Override // ea.c, da.x1, kotlinx.serialization.encoding.Decoder
    public boolean E() {
        return !this.f25443j && super.E();
    }

    @Override // da.y0
    @NotNull
    protected String a0(@NotNull SerialDescriptor desc, int i10) {
        Object next;
        kotlin.jvm.internal.t.i(desc, "desc");
        String strE = desc.e(i10);
        if (!this.f25418e.j() || s0().keySet().contains(strE)) {
            return strE;
        }
        Map map = (Map) kotlinx.serialization.json.u.a(d()).b(desc, b0.c(), new a(desc));
        Iterator<T> it = s0().keySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            Integer num = (Integer) map.get((String) next);
            if (num != null && num.intValue() == i10) {
                break;
            }
        }
        String str = (String) next;
        return str == null ? strE : str;
    }

    @Override // ea.c, kotlinx.serialization.encoding.Decoder
    @NotNull
    public ca.c b(@NotNull SerialDescriptor descriptor) {
        kotlin.jvm.internal.t.i(descriptor, "descriptor");
        return descriptor == this.f25441h ? this : super.b(descriptor);
    }

    @Override // ea.c, ca.c
    public void c(@NotNull SerialDescriptor descriptor) {
        Set<String> setJ;
        kotlin.jvm.internal.t.i(descriptor, "descriptor");
        if (this.f25418e.g() || (descriptor.getKind() instanceof ba.d)) {
            return;
        }
        if (this.f25418e.j()) {
            Set<String> setA = da.m0.a(descriptor);
            Map map = (Map) kotlinx.serialization.json.u.a(d()).a(descriptor, b0.c());
            Set setKeySet = map != null ? map.keySet() : null;
            if (setKeySet == null) {
                setKeySet = kotlin.collections.z0.e();
            }
            setJ = a1.j(setA, setKeySet);
        } else {
            setJ = da.m0.a(descriptor);
        }
        for (String str : s0().keySet()) {
            if (!setJ.contains(str) && !kotlin.jvm.internal.t.d(str, this.f25440g)) {
                throw a0.g(str, s0().toString());
            }
        }
    }

    @Override // ea.c
    @NotNull
    protected JsonElement e0(@NotNull String tag) {
        kotlin.jvm.internal.t.i(tag, "tag");
        return (JsonElement) kotlin.collections.r0.h(s0(), tag);
    }

    @Override // ca.c
    public int o(@NotNull SerialDescriptor descriptor) {
        kotlin.jvm.internal.t.i(descriptor, "descriptor");
        while (this.f25442i < descriptor.d()) {
            int i10 = this.f25442i;
            this.f25442i = i10 + 1;
            String strV = V(descriptor, i10);
            int i11 = this.f25442i - 1;
            this.f25443j = false;
            if (s0().containsKey(strV) || u0(descriptor, i11)) {
                if (!this.f25418e.d() || !v0(descriptor, i11, strV)) {
                    return i11;
                }
            }
        }
        return -1;
    }

    @Override // ea.c
    @NotNull
    /* JADX INFO: renamed from: w0 */
    public JsonObject s0() {
        return this.f25439f;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h0(@NotNull kotlinx.serialization.json.a json, @NotNull JsonObject value, @Nullable String str, @Nullable SerialDescriptor serialDescriptor) {
        super(json, value, null);
        kotlin.jvm.internal.t.i(json, "json");
        kotlin.jvm.internal.t.i(value, "value");
        this.f25439f = value;
        this.f25440g = str;
        this.f25441h = serialDescriptor;
    }
}
