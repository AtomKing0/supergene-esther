package io.sentry.rrweb;

import io.sentry.h2;
import io.sentry.l3;
import io.sentry.m3;
import io.sentry.rrweb.b;
import io.sentry.util.w;
import io.sentry.w0;
import io.sentry.x1;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: RRWebMetaEvent.java */
/* JADX INFO: loaded from: classes5.dex */
public final class g extends b implements h2 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private String f28188c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f28189d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f28190e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    private Map<String, Object> f28191f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    private Map<String, Object> f28192g;

    /* JADX INFO: compiled from: RRWebMetaEvent.java */
    public static final class a implements x1<g> {
        private void b(@NotNull g gVar, @NotNull l3 l3Var, @NotNull w0 w0Var) throws Exception {
            String strC;
            l3Var.h();
            ConcurrentHashMap concurrentHashMap = null;
            while (l3Var.peek() == io.sentry.vendor.gson.stream.b.NAME) {
                strC = l3Var.C();
                strC.hashCode();
                switch (strC) {
                    case "height":
                        Integer numG0 = l3Var.g0();
                        gVar.f28189d = numG0 != null ? numG0.intValue() : 0;
                        break;
                    case "href":
                        String strO0 = l3Var.o0();
                        if (strO0 == null) {
                            strO0 = "";
                        }
                        gVar.f28188c = strO0;
                        break;
                    case "width":
                        Integer numG02 = l3Var.g0();
                        gVar.f28190e = numG02 != null ? numG02.intValue() : 0;
                        break;
                    default:
                        if (concurrentHashMap == null) {
                            concurrentHashMap = new ConcurrentHashMap();
                        }
                        l3Var.r0(w0Var, concurrentHashMap, strC);
                        break;
                }
            }
            gVar.i(concurrentHashMap);
            l3Var.k();
        }

        @Override // io.sentry.x1
        @NotNull
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public g deserialize(@NotNull l3 l3Var, @NotNull w0 w0Var) throws Exception {
            l3Var.h();
            g gVar = new g();
            b.a aVar = new b.a();
            HashMap map = null;
            while (l3Var.peek() == io.sentry.vendor.gson.stream.b.NAME) {
                String strC = l3Var.C();
                strC.hashCode();
                if (strC.equals("data")) {
                    b(gVar, l3Var, w0Var);
                } else if (!aVar.a(gVar, strC, l3Var, w0Var)) {
                    if (map == null) {
                        map = new HashMap();
                    }
                    l3Var.r0(w0Var, map, strC);
                }
            }
            gVar.j(map);
            l3Var.k();
            return gVar;
        }
    }

    public g() {
        super(c.Meta);
        this.f28188c = "";
    }

    private void h(@NotNull m3 m3Var, @NotNull w0 w0Var) throws IOException {
        m3Var.h();
        m3Var.e("href").g(this.f28188c);
        m3Var.e("height").a(this.f28189d);
        m3Var.e("width").a(this.f28190e);
        Map<String, Object> map = this.f28191f;
        if (map != null) {
            for (String str : map.keySet()) {
                Object obj = this.f28191f.get(str);
                m3Var.e(str);
                m3Var.o(w0Var, obj);
            }
        }
        m3Var.k();
    }

    @Override // io.sentry.rrweb.b
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || g.class != obj.getClass() || !super.equals(obj)) {
            return false;
        }
        g gVar = (g) obj;
        return this.f28189d == gVar.f28189d && this.f28190e == gVar.f28190e && w.a(this.f28188c, gVar.f28188c);
    }

    @Override // io.sentry.rrweb.b
    public int hashCode() {
        return w.b(Integer.valueOf(super.hashCode()), this.f28188c, Integer.valueOf(this.f28189d), Integer.valueOf(this.f28190e));
    }

    public void i(@Nullable Map<String, Object> map) {
        this.f28192g = map;
    }

    public void j(@Nullable Map<String, Object> map) {
        this.f28191f = map;
    }

    @Override // io.sentry.h2
    public void serialize(@NotNull m3 m3Var, @NotNull w0 w0Var) throws IOException {
        m3Var.h();
        new b.C0587b().a(this, m3Var, w0Var);
        m3Var.e("data");
        h(m3Var, w0Var);
        m3Var.k();
    }
}
