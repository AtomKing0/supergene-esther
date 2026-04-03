package y7;

import e8.c;
import io.ktor.utils.io.g;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.t0;
import kotlin.jvm.internal.o0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: HttpPlainText.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class o {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    public static final b f36751d = new b(null);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    private static final g8.a<o> f36752e = new g8.a<>("HttpPlainText");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final Charset f36753a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final Charset f36754b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final String f36755c;

    /* JADX INFO: compiled from: HttpPlainText.kt */
    public static final class a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Nullable
        private Charset f36758c;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        private final Set<Charset> f36756a = new LinkedHashSet();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @NotNull
        private final Map<Charset, Float> f36757b = new LinkedHashMap();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @NotNull
        private Charset f36759d = p9.d.f32952b;

        @NotNull
        public final Map<Charset, Float> a() {
            return this.f36757b;
        }

        @NotNull
        public final Set<Charset> b() {
            return this.f36756a;
        }

        @NotNull
        public final Charset c() {
            return this.f36759d;
        }

        @Nullable
        public final Charset d() {
            return this.f36758c;
        }
    }

    /* JADX INFO: compiled from: HttpPlainText.kt */
    public static final class b implements m<a, o> {

        /* JADX INFO: compiled from: HttpPlainText.kt */
        @kotlin.coroutines.jvm.internal.f(c = "io.ktor.client.plugins.HttpPlainText$Plugin$install$1", f = "HttpPlainText.kt", l = {130}, m = "invokeSuspend")
        static final class a extends kotlin.coroutines.jvm.internal.l implements h9.q<l8.e<Object, a8.c>, Object, z8.d<? super k0>, Object> {

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            int f36760j;

            /* JADX INFO: renamed from: k, reason: collision with root package name */
            private /* synthetic */ Object f36761k;

            /* JADX INFO: renamed from: l, reason: collision with root package name */
            /* synthetic */ Object f36762l;

            /* JADX INFO: renamed from: m, reason: collision with root package name */
            final /* synthetic */ o f36763m;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(o oVar, z8.d<? super a> dVar) {
                super(3, dVar);
                this.f36763m = oVar;
            }

            @Override // h9.q
            @Nullable
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public final Object invoke(@NotNull l8.e<Object, a8.c> eVar, @NotNull Object obj, @Nullable z8.d<? super k0> dVar) {
                a aVar = new a(this.f36763m, dVar);
                aVar.f36761k = eVar;
                aVar.f36762l = obj;
                return aVar.invokeSuspend(k0.f35197a);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                Object objE = a9.d.e();
                int i10 = this.f36760j;
                if (i10 == 0) {
                    v8.u.b(obj);
                    l8.e eVar = (l8.e) this.f36761k;
                    Object obj2 = this.f36762l;
                    this.f36763m.c((a8.c) eVar.c());
                    if (!(obj2 instanceof String)) {
                        return k0.f35197a;
                    }
                    e8.c cVarD = e8.s.d((e8.r) eVar.c());
                    if (cVarD != null && !kotlin.jvm.internal.t.d(cVarD.e(), c.C0549c.f25223a.a().e())) {
                        return k0.f35197a;
                    }
                    Object objE2 = this.f36763m.e((a8.c) eVar.c(), (String) obj2, cVarD);
                    this.f36761k = null;
                    this.f36760j = 1;
                    if (eVar.e(objE2, this) == objE) {
                        return objE;
                    }
                } else {
                    if (i10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    v8.u.b(obj);
                }
                return k0.f35197a;
            }
        }

        /* JADX INFO: renamed from: y7.o$b$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: HttpPlainText.kt */
        @kotlin.coroutines.jvm.internal.f(c = "io.ktor.client.plugins.HttpPlainText$Plugin$install$2", f = "HttpPlainText.kt", l = {136, 138}, m = "invokeSuspend")
        static final class C0747b extends kotlin.coroutines.jvm.internal.l implements h9.q<l8.e<b8.d, t7.b>, b8.d, z8.d<? super k0>, Object> {

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            int f36764j;

            /* JADX INFO: renamed from: k, reason: collision with root package name */
            private /* synthetic */ Object f36765k;

            /* JADX INFO: renamed from: l, reason: collision with root package name */
            /* synthetic */ Object f36766l;

            /* JADX INFO: renamed from: m, reason: collision with root package name */
            final /* synthetic */ o f36767m;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0747b(o oVar, z8.d<? super C0747b> dVar) {
                super(3, dVar);
                this.f36767m = oVar;
            }

            @Override // h9.q
            @Nullable
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public final Object invoke(@NotNull l8.e<b8.d, t7.b> eVar, @NotNull b8.d dVar, @Nullable z8.d<? super k0> dVar2) {
                C0747b c0747b = new C0747b(this.f36767m, dVar2);
                c0747b.f36765k = eVar;
                c0747b.f36766l = dVar;
                return c0747b.invokeSuspend(k0.f35197a);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                l8.e eVar;
                m8.a aVar;
                Object objE = a9.d.e();
                int i10 = this.f36764j;
                if (i10 == 0) {
                    v8.u.b(obj);
                    l8.e eVar2 = (l8.e) this.f36765k;
                    b8.d dVar = (b8.d) this.f36766l;
                    m8.a aVarA = dVar.a();
                    Object objB = dVar.b();
                    if (!kotlin.jvm.internal.t.d(aVarA.a(), o0.b(String.class)) || !(objB instanceof io.ktor.utils.io.g)) {
                        return k0.f35197a;
                    }
                    this.f36765k = eVar2;
                    this.f36766l = aVarA;
                    this.f36764j = 1;
                    Object objA = g.b.a((io.ktor.utils.io.g) objB, 0L, this, 1, null);
                    if (objA == objE) {
                        return objE;
                    }
                    eVar = eVar2;
                    obj = objA;
                    aVar = aVarA;
                } else {
                    if (i10 != 1) {
                        if (i10 != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        v8.u.b(obj);
                        return k0.f35197a;
                    }
                    aVar = (m8.a) this.f36766l;
                    eVar = (l8.e) this.f36765k;
                    v8.u.b(obj);
                }
                b8.d dVar2 = new b8.d(aVar, this.f36767m.d((t7.b) eVar.c(), (p8.j) obj));
                this.f36765k = null;
                this.f36766l = null;
                this.f36764j = 2;
                if (eVar.e(dVar2, this) == objE) {
                    return objE;
                }
                return k0.f35197a;
            }
        }

        private b() {
        }

        public /* synthetic */ b(kotlin.jvm.internal.k kVar) {
            this();
        }

        @Override // y7.m
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(@NotNull o plugin, @NotNull s7.a scope) {
            kotlin.jvm.internal.t.i(plugin, "plugin");
            kotlin.jvm.internal.t.i(scope, "scope");
            scope.z().l(a8.f.f354h.b(), new a(plugin, null));
            scope.B().l(b8.f.f2253h.c(), new C0747b(plugin, null));
        }

        @Override // y7.m
        @NotNull
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public o b(@NotNull h9.l<? super a, k0> block) {
            kotlin.jvm.internal.t.i(block, "block");
            a aVar = new a();
            block.invoke(aVar);
            return new o(aVar.b(), aVar.a(), aVar.d(), aVar.c());
        }

        @Override // y7.m
        @NotNull
        public g8.a<o> getKey() {
            return o.f36752e;
        }
    }

    /* JADX INFO: compiled from: Comparisons.kt */
    public static final class c<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t10, T t11) {
            return x8.b.a(o8.a.i((Charset) t10), o8.a.i((Charset) t11));
        }
    }

    /* JADX INFO: compiled from: Comparisons.kt */
    public static final class d<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t10, T t11) {
            return x8.b.a((Float) ((v8.s) t11).d(), (Float) ((v8.s) t10).d());
        }
    }

    public o(@NotNull Set<? extends Charset> charsets, @NotNull Map<Charset, Float> charsetQuality, @Nullable Charset charset, @NotNull Charset responseCharsetFallback) {
        kotlin.jvm.internal.t.i(charsets, "charsets");
        kotlin.jvm.internal.t.i(charsetQuality, "charsetQuality");
        kotlin.jvm.internal.t.i(responseCharsetFallback, "responseCharsetFallback");
        this.f36753a = responseCharsetFallback;
        List<v8.s> listI0 = kotlin.collections.d0.I0(t0.A(charsetQuality), new d());
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = charsets.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (true ^ charsetQuality.containsKey((Charset) next)) {
                arrayList.add(next);
            }
        }
        List listI02 = kotlin.collections.d0.I0(arrayList, new c());
        StringBuilder sb = new StringBuilder();
        Iterator it2 = listI02.iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            Charset charset2 = (Charset) it2.next();
            if (sb.length() > 0) {
                sb.append(",");
            }
            sb.append(o8.a.i(charset2));
        }
        for (v8.s sVar : listI0) {
            Charset charset3 = (Charset) sVar.a();
            float fFloatValue = ((Number) sVar.b()).floatValue();
            if (sb.length() > 0) {
                sb.append(",");
            }
            double d10 = fFloatValue;
            if (!(0.0d <= d10 && d10 <= 1.0d)) {
                throw new IllegalStateException("Check failed.".toString());
            }
            sb.append(o8.a.i(charset3) + ";q=" + (((double) j9.c.c(100 * fFloatValue)) / 100.0d));
        }
        if (sb.length() == 0) {
            sb.append(o8.a.i(this.f36753a));
        }
        String string = sb.toString();
        kotlin.jvm.internal.t.h(string, "StringBuilder().apply(builderAction).toString()");
        this.f36755c = string;
        if (charset == null && (charset = (Charset) kotlin.collections.d0.k0(listI02)) == null) {
            v8.s sVar2 = (v8.s) kotlin.collections.d0.k0(listI0);
            charset = sVar2 != null ? (Charset) sVar2.c() : null;
            if (charset == null) {
                charset = p9.d.f32952b;
            }
        }
        this.f36754b = charset;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object e(a8.c cVar, String str, e8.c cVar2) {
        Charset charsetA;
        e8.c cVarA = cVar2 == null ? c.C0549c.f25223a.a() : cVar2;
        if (cVar2 == null || (charsetA = e8.d.a(cVar2)) == null) {
            charsetA = this.f36754b;
        }
        p.f36768a.b("Sending request body to " + cVar.i() + " as text/plain with charset " + charsetA);
        return new f8.c(str, e8.d.b(cVarA, charsetA), null, 4, null);
    }

    public final void c(@NotNull a8.c context) {
        kotlin.jvm.internal.t.i(context, "context");
        e8.l lVarB = context.b();
        e8.o oVar = e8.o.f25274a;
        if (lVarB.h(oVar.d()) != null) {
            return;
        }
        p.f36768a.b("Adding Accept-Charset=" + this.f36755c + " to " + context.i());
        context.b().k(oVar.d(), this.f36755c);
    }

    @NotNull
    public final String d(@NotNull t7.b call, @NotNull p8.m body) {
        kotlin.jvm.internal.t.i(call, "call");
        kotlin.jvm.internal.t.i(body, "body");
        Charset charsetA = e8.s.a(call.f());
        if (charsetA == null) {
            charsetA = this.f36753a;
        }
        p.f36768a.b("Reading response body for " + call.e().getUrl() + " as String with charset " + charsetA);
        return p8.s.e(body, charsetA, 0, 2, null);
    }
}
