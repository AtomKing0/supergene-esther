package v7;

import e8.o;
import g8.r;
import h9.p;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.collections.d0;
import kotlin.collections.z0;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import z8.g;

/* JADX INFO: compiled from: Utils.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private static final String f35158a = "Ktor client";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private static final Set<String> f35159b;

    /* JADX INFO: compiled from: Utils.kt */
    static final class a extends v implements h9.l<e8.l, k0> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ e8.k f35160g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ f8.b f35161h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(e8.k kVar, f8.b bVar) {
            super(1);
            this.f35160g = kVar;
            this.f35161h = bVar;
        }

        public final void a(@NotNull e8.l buildHeaders) {
            t.i(buildHeaders, "$this$buildHeaders");
            buildHeaders.e(this.f35160g);
            buildHeaders.e(this.f35161h.c());
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(e8.l lVar) {
            a(lVar);
            return k0.f35197a;
        }
    }

    /* JADX INFO: compiled from: Utils.kt */
    static final class b extends v implements p<String, List<? extends String>, k0> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ p<String, String, k0> f35162g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        b(p<? super String, ? super String, k0> pVar) {
            super(2);
            this.f35162g = pVar;
        }

        public final void a(@NotNull String key, @NotNull List<String> values) {
            t.i(key, "key");
            t.i(values, "values");
            o oVar = o.f25274a;
            if (t.d(oVar.g(), key) || t.d(oVar.i(), key)) {
                return;
            }
            if (!m.f35159b.contains(key)) {
                this.f35162g.mo4invoke(key, d0.r0(values, t.d(oVar.j(), key) ? "; " : ",", null, null, 0, null, null, 62, null));
                return;
            }
            p<String, String, k0> pVar = this.f35162g;
            Iterator<T> it = values.iterator();
            while (it.hasNext()) {
                pVar.mo4invoke(key, (String) it.next());
            }
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ k0 mo4invoke(String str, List<? extends String> list) {
            a(str, list);
            return k0.f35197a;
        }
    }

    static {
        o oVar = o.f25274a;
        f35159b = z0.h(oVar.k(), oVar.m(), oVar.q(), oVar.n(), oVar.p());
    }

    @Nullable
    public static final Object b(@NotNull z8.d<? super z8.g> dVar) {
        g.b bVar = dVar.getContext().get(j.f35154b);
        t.f(bVar);
        return ((j) bVar).b();
    }

    public static final void c(@NotNull e8.k requestHeaders, @NotNull f8.b content, @NotNull p<? super String, ? super String, k0> block) {
        String string;
        String string2;
        t.i(requestHeaders, "requestHeaders");
        t.i(content, "content");
        t.i(block, "block");
        c8.e.a(new a(requestHeaders, content)).d(new b(block));
        o oVar = o.f25274a;
        if ((requestHeaders.get(oVar.w()) == null && content.c().get(oVar.w()) == null) && d()) {
            block.mo4invoke(oVar.w(), f35158a);
        }
        e8.c cVarB = content.b();
        if ((cVarB == null || (string = cVarB.toString()) == null) && (string = content.c().get(oVar.i())) == null) {
            string = requestHeaders.get(oVar.i());
        }
        Long lA = content.a();
        if ((lA == null || (string2 = lA.toString()) == null) && (string2 = content.c().get(oVar.g())) == null) {
            string2 = requestHeaders.get(oVar.g());
        }
        if (string != null) {
            block.mo4invoke(oVar.i(), string);
        }
        if (string2 != null) {
            block.mo4invoke(oVar.g(), string2);
        }
    }

    private static final boolean d() {
        return !r.f25911a.a();
    }
}
