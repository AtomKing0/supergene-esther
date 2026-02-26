package io.sentry.rrweb;

import com.applovin.sdk.AppLovinEventTypes;
import io.sentry.SentryLevel;
import io.sentry.h2;
import io.sentry.l3;
import io.sentry.m3;
import io.sentry.protocol.ViewHierarchyNode;
import io.sentry.rrweb.b;
import io.sentry.w0;
import io.sentry.x1;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: RRWebBreadcrumbEvent.java */
/* JADX INFO: loaded from: classes5.dex */
public final class a extends b implements h2 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private String f28158c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private double f28159d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    private String f28160e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    private String f28161f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    private String f28162g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Nullable
    private SentryLevel f28163h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    private Map<String, Object> f28164i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Nullable
    private Map<String, Object> f28165j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @Nullable
    private Map<String, Object> f28166k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @Nullable
    private Map<String, Object> f28167l;

    /* JADX INFO: renamed from: io.sentry.rrweb.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: RRWebBreadcrumbEvent.java */
    public static final class C0586a implements x1<a> {
        private void b(@NotNull a aVar, @NotNull l3 l3Var, @NotNull w0 w0Var) throws Exception {
            l3Var.h();
            ConcurrentHashMap concurrentHashMap = null;
            while (l3Var.peek() == io.sentry.vendor.gson.stream.b.NAME) {
                String strC = l3Var.C();
                strC.hashCode();
                if (strC.equals("payload")) {
                    c(aVar, l3Var, w0Var);
                } else if (strC.equals(ViewHierarchyNode.JsonKeys.TAG)) {
                    String strO0 = l3Var.o0();
                    if (strO0 == null) {
                        strO0 = "";
                    }
                    aVar.f28158c = strO0;
                } else {
                    if (concurrentHashMap == null) {
                        concurrentHashMap = new ConcurrentHashMap();
                    }
                    l3Var.r0(w0Var, concurrentHashMap, strC);
                }
            }
            aVar.n(concurrentHashMap);
            l3Var.k();
        }

        private void c(@NotNull a aVar, @NotNull l3 l3Var, @NotNull w0 w0Var) throws Exception {
            String strC;
            l3Var.h();
            ConcurrentHashMap concurrentHashMap = null;
            while (l3Var.peek() == io.sentry.vendor.gson.stream.b.NAME) {
                strC = l3Var.C();
                strC.hashCode();
                switch (strC) {
                    case "data":
                        Map mapB = io.sentry.util.c.b((Map) l3Var.A0());
                        if (mapB == null) {
                            break;
                        } else {
                            aVar.f28164i = mapB;
                            break;
                        }
                        break;
                    case "type":
                        aVar.f28160e = l3Var.o0();
                        break;
                    case "category":
                        aVar.f28161f = l3Var.o0();
                        break;
                    case "timestamp":
                        aVar.f28159d = l3Var.nextDouble();
                        break;
                    case "level":
                        try {
                            aVar.f28163h = new SentryLevel.a().deserialize(l3Var, w0Var);
                            break;
                        } catch (Exception e10) {
                            w0Var.a(SentryLevel.DEBUG, e10, "Error when deserializing SentryLevel", new Object[0]);
                            break;
                        }
                        break;
                    case "message":
                        aVar.f28162g = l3Var.o0();
                        break;
                    default:
                        if (concurrentHashMap == null) {
                            concurrentHashMap = new ConcurrentHashMap();
                        }
                        l3Var.r0(w0Var, concurrentHashMap, strC);
                        break;
                }
            }
            aVar.o(concurrentHashMap);
            l3Var.k();
        }

        @Override // io.sentry.x1
        @NotNull
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public a deserialize(@NotNull l3 l3Var, @NotNull w0 w0Var) throws Exception {
            l3Var.h();
            a aVar = new a();
            b.a aVar2 = new b.a();
            HashMap map = null;
            while (l3Var.peek() == io.sentry.vendor.gson.stream.b.NAME) {
                String strC = l3Var.C();
                strC.hashCode();
                if (strC.equals("data")) {
                    b(aVar, l3Var, w0Var);
                } else if (!aVar2.a(aVar, strC, l3Var, w0Var)) {
                    if (map == null) {
                        map = new HashMap();
                    }
                    l3Var.r0(w0Var, map, strC);
                }
            }
            aVar.p(map);
            l3Var.k();
            return aVar;
        }
    }

    public a() {
        super(c.Custom);
        this.f28158c = "breadcrumb";
    }

    private void l(@NotNull m3 m3Var, @NotNull w0 w0Var) throws IOException {
        m3Var.h();
        m3Var.e(ViewHierarchyNode.JsonKeys.TAG).g(this.f28158c);
        m3Var.e("payload");
        m(m3Var, w0Var);
        Map<String, Object> map = this.f28167l;
        if (map != null) {
            for (String str : map.keySet()) {
                Object obj = this.f28167l.get(str);
                m3Var.e(str);
                m3Var.o(w0Var, obj);
            }
        }
        m3Var.k();
    }

    private void m(@NotNull m3 m3Var, @NotNull w0 w0Var) throws IOException {
        m3Var.h();
        if (this.f28160e != null) {
            m3Var.e("type").g(this.f28160e);
        }
        m3Var.e("timestamp").o(w0Var, BigDecimal.valueOf(this.f28159d));
        if (this.f28161f != null) {
            m3Var.e("category").g(this.f28161f);
        }
        if (this.f28162g != null) {
            m3Var.e("message").g(this.f28162g);
        }
        if (this.f28163h != null) {
            m3Var.e(AppLovinEventTypes.USER_COMPLETED_LEVEL).o(w0Var, this.f28163h);
        }
        if (this.f28164i != null) {
            m3Var.e("data").o(w0Var, this.f28164i);
        }
        Map<String, Object> map = this.f28166k;
        if (map != null) {
            for (String str : map.keySet()) {
                Object obj = this.f28166k.get(str);
                m3Var.e(str);
                m3Var.o(w0Var, obj);
            }
        }
        m3Var.k();
    }

    public void n(@Nullable Map<String, Object> map) {
        this.f28167l = map;
    }

    public void o(@Nullable Map<String, Object> map) {
        this.f28166k = map;
    }

    public void p(@Nullable Map<String, Object> map) {
        this.f28165j = map;
    }

    @Override // io.sentry.h2
    public void serialize(@NotNull m3 m3Var, @NotNull w0 w0Var) throws IOException {
        m3Var.h();
        new b.C0587b().a(this, m3Var, w0Var);
        m3Var.e("data");
        l(m3Var, w0Var);
        Map<String, Object> map = this.f28165j;
        if (map != null) {
            for (String str : map.keySet()) {
                Object obj = this.f28165j.get(str);
                m3Var.e(str);
                m3Var.o(w0Var, obj);
            }
        }
        m3Var.k();
    }
}
