package ea;

import ba.i;
import ba.j;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonNull;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: TreeJsonEncoder.kt */
/* JADX INFO: loaded from: classes5.dex */
abstract class d extends da.z0 implements kotlinx.serialization.json.k {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final kotlinx.serialization.json.a f25423b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final h9.l<JsonElement, v8.k0> f25424c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    protected final kotlinx.serialization.json.e f25425d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    private String f25426e;

    /* JADX INFO: compiled from: TreeJsonEncoder.kt */
    static final class a extends kotlin.jvm.internal.v implements h9.l<JsonElement, v8.k0> {
        a() {
            super(1);
        }

        public final void a(@NotNull JsonElement node) {
            kotlin.jvm.internal.t.i(node, "node");
            d dVar = d.this;
            dVar.s0(d.e0(dVar), node);
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ v8.k0 invoke(JsonElement jsonElement) {
            a(jsonElement);
            return v8.k0.f35197a;
        }
    }

    /* JADX INFO: compiled from: TreeJsonEncoder.kt */
    public static final class b extends ca.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        private final fa.c f25428a;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f25430c;

        b(String str) {
            this.f25430c = str;
            this.f25428a = d.this.d().a();
        }

        @Override // ca.b, kotlinx.serialization.encoding.Encoder
        public void B(int i10) {
            K(Long.toString(((long) v8.c0.c(i10)) & 4294967295L, 10));
        }

        public final void K(@NotNull String s10) {
            kotlin.jvm.internal.t.i(s10, "s");
            d.this.s0(this.f25430c, new kotlinx.serialization.json.n(s10, false));
        }

        @Override // kotlinx.serialization.encoding.Encoder
        @NotNull
        public fa.c a() {
            return this.f25428a;
        }

        @Override // ca.b, kotlinx.serialization.encoding.Encoder
        public void g(byte b10) {
            K(v8.a0.f(v8.a0.c(b10)));
        }

        @Override // ca.b, kotlinx.serialization.encoding.Encoder
        public void m(long j10) {
            K(g.a(v8.e0.c(j10), 10));
        }

        @Override // ca.b, kotlinx.serialization.encoding.Encoder
        public void q(short s10) {
            K(v8.h0.f(v8.h0.c(s10)));
        }
    }

    public /* synthetic */ d(kotlinx.serialization.json.a aVar, h9.l lVar, kotlin.jvm.internal.k kVar) {
        this(aVar, lVar);
    }

    public static final /* synthetic */ String e0(d dVar) {
        return dVar.V();
    }

    @Override // kotlinx.serialization.json.k
    public void A(@NotNull JsonElement element) {
        kotlin.jvm.internal.t.i(element, "element");
        E(kotlinx.serialization.json.i.f30067a, element);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // da.y1, kotlinx.serialization.encoding.Encoder
    public <T> void E(@NotNull z9.j<? super T> serializer, T t10) {
        kotlin.jvm.internal.t.i(serializer, "serializer");
        if (W() == null && x0.b(z0.a(serializer.getDescriptor(), a()))) {
            e0 e0Var = new e0(this.f25423b, this.f25424c);
            e0Var.E(serializer, t10);
            e0Var.U(serializer.getDescriptor());
        } else {
            if (!(serializer instanceof da.b) || d().e().k()) {
                serializer.serialize(this, t10);
                return;
            }
            da.b bVar = (da.b) serializer;
            String strC = p0.c(serializer.getDescriptor(), d());
            kotlin.jvm.internal.t.g(t10, "null cannot be cast to non-null type kotlin.Any");
            z9.j jVarB = z9.f.b(bVar, this, t10);
            p0.f(bVar, jVarB, strC);
            p0.b(jVarB.getDescriptor().getKind());
            this.f25426e = strC;
            jVarB.serialize(this, t10);
        }
    }

    @Override // da.y1
    protected void U(@NotNull SerialDescriptor descriptor) {
        kotlin.jvm.internal.t.i(descriptor, "descriptor");
        this.f25424c.invoke(r0());
    }

    @Override // kotlinx.serialization.encoding.Encoder
    @NotNull
    public final fa.c a() {
        return this.f25423b.a();
    }

    @Override // da.z0
    @NotNull
    protected String a0(@NotNull String parentName, @NotNull String childName) {
        kotlin.jvm.internal.t.i(parentName, "parentName");
        kotlin.jvm.internal.t.i(childName, "childName");
        return childName;
    }

    @Override // kotlinx.serialization.encoding.Encoder
    @NotNull
    public ca.d b(@NotNull SerialDescriptor descriptor) {
        d i0Var;
        kotlin.jvm.internal.t.i(descriptor, "descriptor");
        h9.l aVar = W() == null ? this.f25424c : new a();
        ba.i kind = descriptor.getKind();
        if (kotlin.jvm.internal.t.d(kind, j.b.f2322a) ? true : kind instanceof ba.d) {
            i0Var = new k0(this.f25423b, aVar);
        } else if (kotlin.jvm.internal.t.d(kind, j.c.f2323a)) {
            kotlinx.serialization.json.a aVar2 = this.f25423b;
            SerialDescriptor serialDescriptorA = z0.a(descriptor.g(0), aVar2.a());
            ba.i kind2 = serialDescriptorA.getKind();
            if ((kind2 instanceof ba.e) || kotlin.jvm.internal.t.d(kind2, i.b.f2320a)) {
                i0Var = new m0(this.f25423b, aVar);
            } else {
                if (!aVar2.e().b()) {
                    throw a0.d(serialDescriptorA);
                }
                i0Var = new k0(this.f25423b, aVar);
            }
        } else {
            i0Var = new i0(this.f25423b, aVar);
        }
        String str = this.f25426e;
        if (str != null) {
            kotlin.jvm.internal.t.f(str);
            i0Var.s0(str, kotlinx.serialization.json.h.c(descriptor.h()));
            this.f25426e = null;
        }
        return i0Var;
    }

    @Override // kotlinx.serialization.json.k
    @NotNull
    public final kotlinx.serialization.json.a d() {
        return this.f25423b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // da.y1
    /* JADX INFO: renamed from: f0, reason: merged with bridge method [inline-methods] */
    public void J(@NotNull String tag, boolean z10) {
        kotlin.jvm.internal.t.i(tag, "tag");
        s0(tag, kotlinx.serialization.json.h.a(Boolean.valueOf(z10)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // da.y1
    /* JADX INFO: renamed from: g0, reason: merged with bridge method [inline-methods] */
    public void K(@NotNull String tag, byte b10) {
        kotlin.jvm.internal.t.i(tag, "tag");
        s0(tag, kotlinx.serialization.json.h.b(Byte.valueOf(b10)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // da.y1
    /* JADX INFO: renamed from: h0, reason: merged with bridge method [inline-methods] */
    public void L(@NotNull String tag, char c10) {
        kotlin.jvm.internal.t.i(tag, "tag");
        s0(tag, kotlinx.serialization.json.h.c(String.valueOf(c10)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // da.y1
    /* JADX INFO: renamed from: i0, reason: merged with bridge method [inline-methods] */
    public void M(@NotNull String tag, double d10) {
        kotlin.jvm.internal.t.i(tag, "tag");
        s0(tag, kotlinx.serialization.json.h.b(Double.valueOf(d10)));
        if (this.f25425d.a()) {
            return;
        }
        if (!((Double.isInfinite(d10) || Double.isNaN(d10)) ? false : true)) {
            throw a0.c(Double.valueOf(d10), tag, r0().toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // da.y1
    /* JADX INFO: renamed from: j0, reason: merged with bridge method [inline-methods] */
    public void N(@NotNull String tag, @NotNull SerialDescriptor enumDescriptor, int i10) {
        kotlin.jvm.internal.t.i(tag, "tag");
        kotlin.jvm.internal.t.i(enumDescriptor, "enumDescriptor");
        s0(tag, kotlinx.serialization.json.h.c(enumDescriptor.e(i10)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // da.y1
    /* JADX INFO: renamed from: k0, reason: merged with bridge method [inline-methods] */
    public void O(@NotNull String tag, float f10) {
        kotlin.jvm.internal.t.i(tag, "tag");
        s0(tag, kotlinx.serialization.json.h.b(Float.valueOf(f10)));
        if (this.f25425d.a()) {
            return;
        }
        if (!((Float.isInfinite(f10) || Float.isNaN(f10)) ? false : true)) {
            throw a0.c(Float.valueOf(f10), tag, r0().toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // da.y1
    @NotNull
    /* JADX INFO: renamed from: l0, reason: merged with bridge method [inline-methods] */
    public Encoder P(@NotNull String tag, @NotNull SerialDescriptor inlineDescriptor) {
        kotlin.jvm.internal.t.i(tag, "tag");
        kotlin.jvm.internal.t.i(inlineDescriptor, "inlineDescriptor");
        return t0.a(inlineDescriptor) ? new b(tag) : super.P(tag, inlineDescriptor);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // da.y1
    /* JADX INFO: renamed from: m0, reason: merged with bridge method [inline-methods] */
    public void Q(@NotNull String tag, int i10) {
        kotlin.jvm.internal.t.i(tag, "tag");
        s0(tag, kotlinx.serialization.json.h.b(Integer.valueOf(i10)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // da.y1
    /* JADX INFO: renamed from: n0, reason: merged with bridge method [inline-methods] */
    public void R(@NotNull String tag, long j10) {
        kotlin.jvm.internal.t.i(tag, "tag");
        s0(tag, kotlinx.serialization.json.h.b(Long.valueOf(j10)));
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public void o() {
        String strW = W();
        if (strW == null) {
            this.f25424c.invoke(JsonNull.f30027a);
        } else {
            o0(strW);
        }
    }

    protected void o0(@NotNull String tag) {
        kotlin.jvm.internal.t.i(tag, "tag");
        s0(tag, JsonNull.f30027a);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // da.y1
    /* JADX INFO: renamed from: p0, reason: merged with bridge method [inline-methods] */
    public void S(@NotNull String tag, short s10) {
        kotlin.jvm.internal.t.i(tag, "tag");
        s0(tag, kotlinx.serialization.json.h.b(Short.valueOf(s10)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // da.y1
    /* JADX INFO: renamed from: q0, reason: merged with bridge method [inline-methods] */
    public void T(@NotNull String tag, @NotNull String value) {
        kotlin.jvm.internal.t.i(tag, "tag");
        kotlin.jvm.internal.t.i(value, "value");
        s0(tag, kotlinx.serialization.json.h.c(value));
    }

    @NotNull
    public abstract JsonElement r0();

    public abstract void s0(@NotNull String str, @NotNull JsonElement jsonElement);

    @Override // ca.d
    public boolean z(@NotNull SerialDescriptor descriptor, int i10) {
        kotlin.jvm.internal.t.i(descriptor, "descriptor");
        return this.f25425d.e();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private d(kotlinx.serialization.json.a aVar, h9.l<? super JsonElement, v8.k0> lVar) {
        this.f25423b = aVar;
        this.f25424c = lVar;
        this.f25425d = aVar.e();
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public void v() {
    }
}
