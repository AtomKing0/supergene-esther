package kotlinx.serialization.internal;

import ba.j;
import da.d0;
import da.h1;
import da.j1;
import da.k1;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.r0;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import n9.o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.n;
import v8.p;

/* JADX INFO: compiled from: PluginGeneratedSerialDescriptor.kt */
/* JADX INFO: loaded from: classes5.dex */
public class PluginGeneratedSerialDescriptor implements SerialDescriptor, da.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final String f29998a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    private final d0<?> f29999b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f30000c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f30001d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    private final String[] f30002e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    private final List<Annotation>[] f30003f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    private List<Annotation> f30004g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NotNull
    private final boolean[] f30005h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NotNull
    private Map<String, Integer> f30006i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NotNull
    private final v8.l f30007j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @NotNull
    private final v8.l f30008k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @NotNull
    private final v8.l f30009l;

    /* JADX INFO: compiled from: PluginGeneratedSerialDescriptor.kt */
    static final class a extends v implements h9.a<Integer> {
        a() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Integer invoke() {
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = PluginGeneratedSerialDescriptor.this;
            return Integer.valueOf(j1.a(pluginGeneratedSerialDescriptor, pluginGeneratedSerialDescriptor.o()));
        }
    }

    /* JADX INFO: compiled from: PluginGeneratedSerialDescriptor.kt */
    static final class b extends v implements h9.a<KSerializer<?>[]> {
        b() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final KSerializer<?>[] invoke() {
            KSerializer<?>[] kSerializerArrChildSerializers;
            d0 d0Var = PluginGeneratedSerialDescriptor.this.f29999b;
            return (d0Var == null || (kSerializerArrChildSerializers = d0Var.childSerializers()) == null) ? k1.f24593a : kSerializerArrChildSerializers;
        }
    }

    /* JADX INFO: compiled from: PluginGeneratedSerialDescriptor.kt */
    static final class c extends v implements h9.l<Integer, CharSequence> {
        c() {
            super(1);
        }

        @NotNull
        public final CharSequence a(int i10) {
            return PluginGeneratedSerialDescriptor.this.e(i10) + ": " + PluginGeneratedSerialDescriptor.this.g(i10).h();
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ CharSequence invoke(Integer num) {
            return a(num.intValue());
        }
    }

    /* JADX INFO: compiled from: PluginGeneratedSerialDescriptor.kt */
    static final class d extends v implements h9.a<SerialDescriptor[]> {
        d() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final SerialDescriptor[] invoke() {
            ArrayList arrayList;
            KSerializer<?>[] kSerializerArrTypeParametersSerializers;
            d0 d0Var = PluginGeneratedSerialDescriptor.this.f29999b;
            if (d0Var == null || (kSerializerArrTypeParametersSerializers = d0Var.typeParametersSerializers()) == null) {
                arrayList = null;
            } else {
                arrayList = new ArrayList(kSerializerArrTypeParametersSerializers.length);
                for (KSerializer<?> kSerializer : kSerializerArrTypeParametersSerializers) {
                    arrayList.add(kSerializer.getDescriptor());
                }
            }
            return h1.b(arrayList);
        }
    }

    public PluginGeneratedSerialDescriptor(@NotNull String serialName, @Nullable d0<?> d0Var, int i10) {
        t.i(serialName, "serialName");
        this.f29998a = serialName;
        this.f29999b = d0Var;
        this.f30000c = i10;
        this.f30001d = -1;
        String[] strArr = new String[i10];
        for (int i11 = 0; i11 < i10; i11++) {
            strArr[i11] = "[UNINITIALIZED]";
        }
        this.f30002e = strArr;
        int i12 = this.f30000c;
        this.f30003f = new List[i12];
        this.f30005h = new boolean[i12];
        this.f30006i = r0.g();
        p pVar = p.f35202b;
        this.f30007j = n.b(pVar, new b());
        this.f30008k = n.b(pVar, new d());
        this.f30009l = n.b(pVar, new a());
    }

    public static /* synthetic */ void l(PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor, String str, boolean z10, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addElement");
        }
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        pluginGeneratedSerialDescriptor.k(str, z10);
    }

    private final Map<String, Integer> m() {
        HashMap map = new HashMap();
        int length = this.f30002e.length;
        for (int i10 = 0; i10 < length; i10++) {
            map.put(this.f30002e[i10], Integer.valueOf(i10));
        }
        return map;
    }

    private final KSerializer<?>[] n() {
        return (KSerializer[]) this.f30007j.getValue();
    }

    private final int p() {
        return ((Number) this.f30009l.getValue()).intValue();
    }

    @Override // da.l
    @NotNull
    public Set<String> a() {
        return this.f30006i.keySet();
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public boolean b() {
        return SerialDescriptor.a.c(this);
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public int c(@NotNull String name) {
        t.i(name, "name");
        Integer num = this.f30006i.get(name);
        if (num != null) {
            return num.intValue();
        }
        return -3;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public final int d() {
        return this.f30000c;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    @NotNull
    public String e(int i10) {
        return this.f30002e[i10];
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PluginGeneratedSerialDescriptor) {
            SerialDescriptor serialDescriptor = (SerialDescriptor) obj;
            if (t.d(h(), serialDescriptor.h()) && Arrays.equals(o(), ((PluginGeneratedSerialDescriptor) obj).o()) && d() == serialDescriptor.d()) {
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
        List<Annotation> list = this.f30003f[i10];
        return list == null ? kotlin.collections.v.l() : list;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    @NotNull
    public SerialDescriptor g(int i10) {
        return n()[i10].getDescriptor();
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    @NotNull
    public List<Annotation> getAnnotations() {
        List<Annotation> list = this.f30004g;
        return list == null ? kotlin.collections.v.l() : list;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    @NotNull
    public ba.i getKind() {
        return j.a.f2321a;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    @NotNull
    public String h() {
        return this.f29998a;
    }

    public int hashCode() {
        return p();
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public boolean i(int i10) {
        return this.f30005h[i10];
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public boolean isInline() {
        return SerialDescriptor.a.b(this);
    }

    public final void k(@NotNull String name, boolean z10) {
        t.i(name, "name");
        String[] strArr = this.f30002e;
        int i10 = this.f30001d + 1;
        this.f30001d = i10;
        strArr[i10] = name;
        this.f30005h[i10] = z10;
        this.f30003f[i10] = null;
        if (i10 == this.f30000c - 1) {
            this.f30006i = m();
        }
    }

    @NotNull
    public final SerialDescriptor[] o() {
        return (SerialDescriptor[]) this.f30008k.getValue();
    }

    @NotNull
    public String toString() {
        return kotlin.collections.d0.r0(o.u(0, this.f30000c), ", ", h() + '(', ")", 0, null, new c(), 24, null);
    }

    public /* synthetic */ PluginGeneratedSerialDescriptor(String str, d0 d0Var, int i10, int i11, kotlin.jvm.internal.k kVar) {
        this(str, (i11 & 2) != 0 ? null : d0Var, i10);
    }
}
