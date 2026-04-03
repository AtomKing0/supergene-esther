package a8;

import androidx.core.app.FrameMetricsAggregator;
import e8.f0;
import e8.l;
import e8.n0;
import e8.p0;
import e8.r;
import e8.t;
import g8.x;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.v;
import kotlinx.coroutines.b2;
import kotlinx.coroutines.y2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: HttpRequest.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class c implements r {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NotNull
    public static final a f339g = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final f0 f340a = new f0(null, null, 0, null, null, null, null, null, false, FrameMetricsAggregator.EVERY_DURATION, null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private t f341b = t.f25351b.a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final l f342c = new l(0, 1, null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private Object f343d = c8.c.f4630a;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    private b2 f344e = y2.b(null, 1, null);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    private final g8.b f345f = g8.d.a(true);

    /* JADX INFO: compiled from: HttpRequest.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(k kVar) {
            this();
        }
    }

    /* JADX INFO: compiled from: HttpRequest.kt */
    static final class b extends v implements h9.a<Map<v7.e<?>, Object>> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final b f346g = new b();

        b() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final Map<v7.e<?>, Object> invoke() {
            return new LinkedHashMap();
        }
    }

    @NotNull
    public final d a() {
        p0 p0VarB = this.f340a.b();
        t tVar = this.f341b;
        e8.k kVarN = b().n();
        Object obj = this.f343d;
        f8.b bVar = obj instanceof f8.b ? (f8.b) obj : null;
        if (bVar != null) {
            return new d(p0VarB, tVar, kVarN, bVar, this.f344e, this.f345f);
        }
        throw new IllegalStateException(("No request transformation found: " + this.f343d).toString());
    }

    @Override // e8.r
    @NotNull
    public l b() {
        return this.f342c;
    }

    @NotNull
    public final g8.b c() {
        return this.f345f;
    }

    @NotNull
    public final Object d() {
        return this.f343d;
    }

    @Nullable
    public final m8.a e() {
        return (m8.a) this.f345f.d(i.a());
    }

    @Nullable
    public final <T> T f(@NotNull v7.e<T> key) {
        kotlin.jvm.internal.t.i(key, "key");
        Map map = (Map) this.f345f.d(v7.f.a());
        if (map != null) {
            return (T) map.get(key);
        }
        return null;
    }

    @NotNull
    public final b2 g() {
        return this.f344e;
    }

    @NotNull
    public final t h() {
        return this.f341b;
    }

    @NotNull
    public final f0 i() {
        return this.f340a;
    }

    public final void j(@NotNull Object obj) {
        kotlin.jvm.internal.t.i(obj, "<set-?>");
        this.f343d = obj;
    }

    public final void k(@Nullable m8.a aVar) {
        if (aVar != null) {
            this.f345f.c(i.a(), aVar);
        } else {
            this.f345f.b(i.a());
        }
    }

    public final <T> void l(@NotNull v7.e<T> key, @NotNull T capability) {
        kotlin.jvm.internal.t.i(key, "key");
        kotlin.jvm.internal.t.i(capability, "capability");
        ((Map) this.f345f.g(v7.f.a(), b.f346g)).put(key, capability);
    }

    public final void m(@NotNull b2 b2Var) {
        kotlin.jvm.internal.t.i(b2Var, "<set-?>");
        this.f344e = b2Var;
    }

    public final void n(@NotNull t tVar) {
        kotlin.jvm.internal.t.i(tVar, "<set-?>");
        this.f341b = tVar;
    }

    @NotNull
    public final c o(@NotNull c builder) {
        kotlin.jvm.internal.t.i(builder, "builder");
        this.f341b = builder.f341b;
        this.f343d = builder.f343d;
        k(builder.e());
        n0.g(this.f340a, builder.f340a);
        f0 f0Var = this.f340a;
        f0Var.u(f0Var.g());
        x.c(b(), builder.b());
        g8.e.a(this.f345f, builder.f345f);
        return this;
    }

    @NotNull
    public final c p(@NotNull c builder) {
        kotlin.jvm.internal.t.i(builder, "builder");
        this.f344e = builder.f344e;
        return o(builder);
    }
}
