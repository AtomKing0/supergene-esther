package ea;

import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.json.JsonElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: StreamingJsonEncoder.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class s0 extends ca.b implements kotlinx.serialization.json.k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final j f25488a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final kotlinx.serialization.json.a f25489b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final y0 f25490c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    private final kotlinx.serialization.json.k[] f25491d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    private final fa.c f25492e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    private final kotlinx.serialization.json.e f25493f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f25494g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Nullable
    private String f25495h;

    /* JADX INFO: compiled from: StreamingJsonEncoder.kt */
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f25496a;

        static {
            int[] iArr = new int[y0.values().length];
            try {
                iArr[y0.LIST.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[y0.MAP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[y0.POLY_OBJ.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f25496a = iArr;
        }
    }

    public s0(@NotNull j composer, @NotNull kotlinx.serialization.json.a json, @NotNull y0 mode, @Nullable kotlinx.serialization.json.k[] kVarArr) {
        kotlin.jvm.internal.t.i(composer, "composer");
        kotlin.jvm.internal.t.i(json, "json");
        kotlin.jvm.internal.t.i(mode, "mode");
        this.f25488a = composer;
        this.f25489b = json;
        this.f25490c = mode;
        this.f25491d = kVarArr;
        this.f25492e = d().a();
        this.f25493f = d().e();
        int iOrdinal = mode.ordinal();
        if (kVarArr != null) {
            kotlinx.serialization.json.k kVar = kVarArr[iOrdinal];
            if (kVar == null && kVar == this) {
                return;
            }
            kVarArr[iOrdinal] = this;
        }
    }

    private final j K() {
        j jVar = this.f25488a;
        return jVar instanceof q ? jVar : new q(jVar.f25448a, this.f25494g);
    }

    private final void L(SerialDescriptor serialDescriptor) {
        this.f25488a.c();
        String str = this.f25495h;
        kotlin.jvm.internal.t.f(str);
        G(str);
        this.f25488a.e(':');
        this.f25488a.o();
        G(serialDescriptor.h());
    }

    @Override // kotlinx.serialization.json.k
    public void A(@NotNull JsonElement element) {
        kotlin.jvm.internal.t.i(element, "element");
        E(kotlinx.serialization.json.i.f30067a, element);
    }

    @Override // ca.b, kotlinx.serialization.encoding.Encoder
    public void B(int i10) {
        if (this.f25494g) {
            G(String.valueOf(i10));
        } else {
            this.f25488a.h(i10);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // ca.b, kotlinx.serialization.encoding.Encoder
    public <T> void E(@NotNull z9.j<? super T> serializer, T t10) {
        kotlin.jvm.internal.t.i(serializer, "serializer");
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
        this.f25495h = strC;
        jVarB.serialize(this, t10);
    }

    @Override // ca.b, kotlinx.serialization.encoding.Encoder
    public void G(@NotNull String value) {
        kotlin.jvm.internal.t.i(value, "value");
        this.f25488a.m(value);
    }

    @Override // ca.b
    public boolean H(@NotNull SerialDescriptor descriptor, int i10) {
        kotlin.jvm.internal.t.i(descriptor, "descriptor");
        int i11 = a.f25496a[this.f25490c.ordinal()];
        if (i11 != 1) {
            boolean z10 = false;
            if (i11 != 2) {
                if (i11 != 3) {
                    if (!this.f25488a.a()) {
                        this.f25488a.e(',');
                    }
                    this.f25488a.c();
                    G(descriptor.e(i10));
                    this.f25488a.e(':');
                    this.f25488a.o();
                } else {
                    if (i10 == 0) {
                        this.f25494g = true;
                    }
                    if (i10 == 1) {
                        this.f25488a.e(',');
                        this.f25488a.o();
                        this.f25494g = false;
                    }
                }
            } else if (this.f25488a.a()) {
                this.f25494g = true;
                this.f25488a.c();
            } else {
                if (i10 % 2 == 0) {
                    this.f25488a.e(',');
                    this.f25488a.c();
                    z10 = true;
                } else {
                    this.f25488a.e(':');
                    this.f25488a.o();
                }
                this.f25494g = z10;
            }
        } else {
            if (!this.f25488a.a()) {
                this.f25488a.e(',');
            }
            this.f25488a.c();
        }
        return true;
    }

    @Override // kotlinx.serialization.encoding.Encoder
    @NotNull
    public fa.c a() {
        return this.f25492e;
    }

    @Override // ca.b, kotlinx.serialization.encoding.Encoder
    @NotNull
    public ca.d b(@NotNull SerialDescriptor descriptor) {
        kotlinx.serialization.json.k kVar;
        kotlin.jvm.internal.t.i(descriptor, "descriptor");
        y0 y0VarB = z0.b(d(), descriptor);
        char c10 = y0VarB.f25512a;
        if (c10 != 0) {
            this.f25488a.e(c10);
            this.f25488a.b();
        }
        if (this.f25495h != null) {
            L(descriptor);
            this.f25495h = null;
        }
        if (this.f25490c == y0VarB) {
            return this;
        }
        kotlinx.serialization.json.k[] kVarArr = this.f25491d;
        return (kVarArr == null || (kVar = kVarArr[y0VarB.ordinal()]) == null) ? new s0(this.f25488a, d(), y0VarB, this.f25491d) : kVar;
    }

    @Override // ca.b, ca.d
    public void c(@NotNull SerialDescriptor descriptor) {
        kotlin.jvm.internal.t.i(descriptor, "descriptor");
        if (this.f25490c.f25513b != 0) {
            this.f25488a.p();
            this.f25488a.c();
            this.f25488a.e(this.f25490c.f25513b);
        }
    }

    @Override // kotlinx.serialization.json.k
    @NotNull
    public kotlinx.serialization.json.a d() {
        return this.f25489b;
    }

    @Override // ca.b, kotlinx.serialization.encoding.Encoder
    public void f(double d10) {
        if (this.f25494g) {
            G(String.valueOf(d10));
        } else {
            this.f25488a.f(d10);
        }
        if (this.f25493f.a()) {
            return;
        }
        if (!((Double.isInfinite(d10) || Double.isNaN(d10)) ? false : true)) {
            throw a0.b(Double.valueOf(d10), this.f25488a.f25448a.toString());
        }
    }

    @Override // ca.b, kotlinx.serialization.encoding.Encoder
    public void g(byte b10) {
        if (this.f25494g) {
            G(String.valueOf((int) b10));
        } else {
            this.f25488a.d(b10);
        }
    }

    @Override // ca.b, ca.d
    public <T> void h(@NotNull SerialDescriptor descriptor, int i10, @NotNull z9.j<? super T> serializer, @Nullable T t10) {
        kotlin.jvm.internal.t.i(descriptor, "descriptor");
        kotlin.jvm.internal.t.i(serializer, "serializer");
        if (t10 != null || this.f25493f.f()) {
            super.h(descriptor, i10, serializer, t10);
        }
    }

    @Override // ca.b, kotlinx.serialization.encoding.Encoder
    public void k(@NotNull SerialDescriptor enumDescriptor, int i10) {
        kotlin.jvm.internal.t.i(enumDescriptor, "enumDescriptor");
        G(enumDescriptor.e(i10));
    }

    @Override // ca.b, kotlinx.serialization.encoding.Encoder
    @NotNull
    public Encoder l(@NotNull SerialDescriptor descriptor) {
        kotlin.jvm.internal.t.i(descriptor, "descriptor");
        return t0.a(descriptor) ? new s0(K(), d(), this.f25490c, (kotlinx.serialization.json.k[]) null) : super.l(descriptor);
    }

    @Override // ca.b, kotlinx.serialization.encoding.Encoder
    public void m(long j10) {
        if (this.f25494g) {
            G(String.valueOf(j10));
        } else {
            this.f25488a.i(j10);
        }
    }

    @Override // ca.b, kotlinx.serialization.encoding.Encoder
    public void o() {
        this.f25488a.j("null");
    }

    @Override // ca.b, kotlinx.serialization.encoding.Encoder
    public void q(short s10) {
        if (this.f25494g) {
            G(String.valueOf((int) s10));
        } else {
            this.f25488a.k(s10);
        }
    }

    @Override // ca.b, kotlinx.serialization.encoding.Encoder
    public void r(boolean z10) {
        if (this.f25494g) {
            G(String.valueOf(z10));
        } else {
            this.f25488a.l(z10);
        }
    }

    @Override // ca.b, kotlinx.serialization.encoding.Encoder
    public void t(float f10) {
        if (this.f25494g) {
            G(String.valueOf(f10));
        } else {
            this.f25488a.g(f10);
        }
        if (this.f25493f.a()) {
            return;
        }
        if (!((Float.isInfinite(f10) || Float.isNaN(f10)) ? false : true)) {
            throw a0.b(Float.valueOf(f10), this.f25488a.f25448a.toString());
        }
    }

    @Override // ca.b, kotlinx.serialization.encoding.Encoder
    public void u(char c10) {
        G(String.valueOf(c10));
    }

    @Override // ca.b, ca.d
    public boolean z(@NotNull SerialDescriptor descriptor, int i10) {
        kotlin.jvm.internal.t.i(descriptor, "descriptor");
        return this.f25493f.e();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public s0(@NotNull o0 output, @NotNull kotlinx.serialization.json.a json, @NotNull y0 mode, @NotNull kotlinx.serialization.json.k[] modeReuseCache) {
        this(s.a(output, json), json, mode, modeReuseCache);
        kotlin.jvm.internal.t.i(output, "output");
        kotlin.jvm.internal.t.i(json, "json");
        kotlin.jvm.internal.t.i(mode, "mode");
        kotlin.jvm.internal.t.i(modeReuseCache, "modeReuseCache");
    }
}
