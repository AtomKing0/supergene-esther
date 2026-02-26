package ba;

import da.h1;
import da.j1;
import da.l;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.d0;
import kotlin.collections.i0;
import kotlin.collections.p;
import kotlin.collections.r0;
import kotlin.collections.w;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import kotlinx.serialization.descriptors.SerialDescriptor;
import n9.o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.n;
import v8.y;

/* JADX INFO: compiled from: SerialDescriptors.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class f implements SerialDescriptor, l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final String f2298a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final i f2299b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f2300c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private final List<Annotation> f2301d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    private final Set<String> f2302e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    private final String[] f2303f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NotNull
    private final SerialDescriptor[] f2304g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NotNull
    private final List<Annotation>[] f2305h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NotNull
    private final boolean[] f2306i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NotNull
    private final Map<String, Integer> f2307j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @NotNull
    private final SerialDescriptor[] f2308k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @NotNull
    private final v8.l f2309l;

    /* JADX INFO: compiled from: SerialDescriptors.kt */
    static final class a extends v implements h9.a<Integer> {
        a() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Integer invoke() {
            f fVar = f.this;
            return Integer.valueOf(j1.a(fVar, fVar.f2308k));
        }
    }

    /* JADX INFO: compiled from: SerialDescriptors.kt */
    static final class b extends v implements h9.l<Integer, CharSequence> {
        b() {
            super(1);
        }

        @NotNull
        public final CharSequence a(int i10) {
            return f.this.e(i10) + ": " + f.this.g(i10).h();
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ CharSequence invoke(Integer num) {
            return a(num.intValue());
        }
    }

    public f(@NotNull String serialName, @NotNull i kind, int i10, @NotNull List<? extends SerialDescriptor> typeParameters, @NotNull ba.a builder) {
        t.i(serialName, "serialName");
        t.i(kind, "kind");
        t.i(typeParameters, "typeParameters");
        t.i(builder, "builder");
        this.f2298a = serialName;
        this.f2299b = kind;
        this.f2300c = i10;
        this.f2301d = builder.c();
        this.f2302e = d0.N0(builder.f());
        Object[] array = builder.f().toArray(new String[0]);
        t.g(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        String[] strArr = (String[]) array;
        this.f2303f = strArr;
        this.f2304g = h1.b(builder.e());
        Object[] array2 = builder.d().toArray(new List[0]);
        t.g(array2, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        this.f2305h = (List[]) array2;
        this.f2306i = d0.K0(builder.g());
        Iterable<i0> iterableS0 = p.s0(strArr);
        ArrayList arrayList = new ArrayList(w.v(iterableS0, 10));
        for (i0 i0Var : iterableS0) {
            arrayList.add(y.a(i0Var.b(), Integer.valueOf(i0Var.a())));
        }
        this.f2307j = r0.s(arrayList);
        this.f2308k = h1.b(typeParameters);
        this.f2309l = n.a(new a());
    }

    private final int k() {
        return ((Number) this.f2309l.getValue()).intValue();
    }

    @Override // da.l
    @NotNull
    public Set<String> a() {
        return this.f2302e;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public boolean b() {
        return SerialDescriptor.a.c(this);
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public int c(@NotNull String name) {
        t.i(name, "name");
        Integer num = this.f2307j.get(name);
        if (num != null) {
            return num.intValue();
        }
        return -3;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public int d() {
        return this.f2300c;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    @NotNull
    public String e(int i10) {
        return this.f2303f[i10];
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof f) {
            SerialDescriptor serialDescriptor = (SerialDescriptor) obj;
            if (t.d(h(), serialDescriptor.h()) && Arrays.equals(this.f2308k, ((f) obj).f2308k) && d() == serialDescriptor.d()) {
                int iD = d();
                for (int i10 = 0; i10 < iD; i10++) {
                    if (t.d(g(i10).h(), serialDescriptor.g(i10).h()) && t.d(g(i10).getKind(), serialDescriptor.g(i10).getKind())) {
                    }
                }
                return true;
            }
        }
        return false;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    @NotNull
    public List<Annotation> f(int i10) {
        return this.f2305h[i10];
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    @NotNull
    public SerialDescriptor g(int i10) {
        return this.f2304g[i10];
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    @NotNull
    public List<Annotation> getAnnotations() {
        return this.f2301d;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    @NotNull
    public i getKind() {
        return this.f2299b;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    @NotNull
    public String h() {
        return this.f2298a;
    }

    public int hashCode() {
        return k();
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public boolean i(int i10) {
        return this.f2306i[i10];
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public boolean isInline() {
        return SerialDescriptor.a.b(this);
    }

    @NotNull
    public String toString() {
        return d0.r0(o.u(0, d()), ", ", h() + '(', ")", 0, null, new b(), 24, null);
    }
}
