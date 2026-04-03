package kotlinx.serialization.json;

import ea.f0;
import ea.g0;
import ea.r0;
import ea.u0;
import ea.w0;
import ea.y0;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Json.kt */
/* JADX INFO: loaded from: classes5.dex */
public abstract class a implements z9.n {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    public static final C0607a f30033d = new C0607a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final e f30034a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final fa.c f30035b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final ea.u f30036c;

    /* JADX INFO: renamed from: kotlinx.serialization.json.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: Json.kt */
    public static final class C0607a extends a {
        public /* synthetic */ C0607a(kotlin.jvm.internal.k kVar) {
            this();
        }

        private C0607a() {
            super(new e(false, false, false, false, false, false, null, false, false, null, false, false, 4095, null), fa.d.a(), null);
        }
    }

    public /* synthetic */ a(e eVar, fa.c cVar, kotlin.jvm.internal.k kVar) {
        this(eVar, cVar);
    }

    @Override // z9.g
    @NotNull
    public fa.c a() {
        return this.f30035b;
    }

    @Override // z9.n
    public final <T> T b(@NotNull z9.b<T> deserializer, @NotNull String string) {
        kotlin.jvm.internal.t.i(deserializer, "deserializer");
        kotlin.jvm.internal.t.i(string, "string");
        u0 u0Var = new u0(string);
        T t10 = (T) new r0(this, y0.OBJ, u0Var, deserializer.getDescriptor(), null).D(deserializer);
        u0Var.w();
        return t10;
    }

    @Override // z9.n
    @NotNull
    public final <T> String c(@NotNull z9.j<? super T> serializer, T t10) {
        kotlin.jvm.internal.t.i(serializer, "serializer");
        g0 g0Var = new g0();
        try {
            f0.a(this, g0Var, serializer, t10);
            return g0Var.toString();
        } finally {
            g0Var.g();
        }
    }

    public final <T> T d(@NotNull z9.b<T> deserializer, @NotNull JsonElement element) {
        kotlin.jvm.internal.t.i(deserializer, "deserializer");
        kotlin.jvm.internal.t.i(element, "element");
        return (T) w0.a(this, element, deserializer);
    }

    @NotNull
    public final e e() {
        return this.f30034a;
    }

    @NotNull
    public final ea.u f() {
        return this.f30036c;
    }

    private a(e eVar, fa.c cVar) {
        this.f30034a = eVar;
        this.f30035b = cVar;
        this.f30036c = new ea.u();
    }
}
