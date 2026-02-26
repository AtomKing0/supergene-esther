package io.sentry.rrweb;

import io.sentry.h2;
import io.sentry.l3;
import io.sentry.m3;
import io.sentry.protocol.SentrySpan;
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

/* JADX INFO: compiled from: RRWebSpanEvent.java */
/* JADX INFO: loaded from: classes5.dex */
public final class h extends b implements h2 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private String f28193c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    private String f28194d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    private String f28195e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private double f28196f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private double f28197g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Nullable
    private Map<String, Object> f28198h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    private Map<String, Object> f28199i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Nullable
    private Map<String, Object> f28200j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @Nullable
    private Map<String, Object> f28201k;

    /* JADX INFO: compiled from: RRWebSpanEvent.java */
    public static final class a implements x1<h> {
        private void b(@NotNull h hVar, @NotNull l3 l3Var, @NotNull w0 w0Var) throws Exception {
            l3Var.h();
            ConcurrentHashMap concurrentHashMap = null;
            while (l3Var.peek() == io.sentry.vendor.gson.stream.b.NAME) {
                String strC = l3Var.C();
                strC.hashCode();
                if (strC.equals("payload")) {
                    c(hVar, l3Var, w0Var);
                } else if (strC.equals(ViewHierarchyNode.JsonKeys.TAG)) {
                    String strO0 = l3Var.o0();
                    if (strO0 == null) {
                        strO0 = "";
                    }
                    hVar.f28193c = strO0;
                } else {
                    if (concurrentHashMap == null) {
                        concurrentHashMap = new ConcurrentHashMap();
                    }
                    l3Var.r0(w0Var, concurrentHashMap, strC);
                }
            }
            hVar.m(concurrentHashMap);
            l3Var.k();
        }

        private void c(@NotNull h hVar, @NotNull l3 l3Var, @NotNull w0 w0Var) throws Exception {
            String strC;
            l3Var.h();
            ConcurrentHashMap concurrentHashMap = null;
            while (l3Var.peek() == io.sentry.vendor.gson.stream.b.NAME) {
                strC = l3Var.C();
                strC.hashCode();
                switch (strC) {
                    case "description":
                        hVar.f28195e = l3Var.o0();
                        break;
                    case "endTimestamp":
                        hVar.f28197g = l3Var.nextDouble();
                        break;
                    case "startTimestamp":
                        hVar.f28196f = l3Var.nextDouble();
                        break;
                    case "op":
                        hVar.f28194d = l3Var.o0();
                        break;
                    case "data":
                        Map mapB = io.sentry.util.c.b((Map) l3Var.A0());
                        if (mapB == null) {
                            break;
                        } else {
                            hVar.f28198h = mapB;
                            break;
                        }
                        break;
                    default:
                        if (concurrentHashMap == null) {
                            concurrentHashMap = new ConcurrentHashMap();
                        }
                        l3Var.r0(w0Var, concurrentHashMap, strC);
                        break;
                }
            }
            hVar.n(concurrentHashMap);
            l3Var.k();
        }

        @Override // io.sentry.x1
        @NotNull
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public h deserialize(@NotNull l3 l3Var, @NotNull w0 w0Var) throws Exception {
            l3Var.h();
            h hVar = new h();
            b.a aVar = new b.a();
            HashMap map = null;
            while (l3Var.peek() == io.sentry.vendor.gson.stream.b.NAME) {
                String strC = l3Var.C();
                strC.hashCode();
                if (strC.equals("data")) {
                    b(hVar, l3Var, w0Var);
                } else if (!aVar.a(hVar, strC, l3Var, w0Var)) {
                    if (map == null) {
                        map = new HashMap();
                    }
                    l3Var.r0(w0Var, map, strC);
                }
            }
            hVar.o(map);
            l3Var.k();
            return hVar;
        }
    }

    public h() {
        super(c.Custom);
        this.f28193c = "performanceSpan";
    }

    private void k(@NotNull m3 m3Var, @NotNull w0 w0Var) throws IOException {
        m3Var.h();
        m3Var.e(ViewHierarchyNode.JsonKeys.TAG).g(this.f28193c);
        m3Var.e("payload");
        l(m3Var, w0Var);
        Map<String, Object> map = this.f28201k;
        if (map != null) {
            for (String str : map.keySet()) {
                Object obj = this.f28201k.get(str);
                m3Var.e(str);
                m3Var.o(w0Var, obj);
            }
        }
        m3Var.k();
    }

    private void l(@NotNull m3 m3Var, @NotNull w0 w0Var) throws IOException {
        m3Var.h();
        if (this.f28194d != null) {
            m3Var.e(SentrySpan.JsonKeys.OP).g(this.f28194d);
        }
        if (this.f28195e != null) {
            m3Var.e("description").g(this.f28195e);
        }
        m3Var.e("startTimestamp").o(w0Var, BigDecimal.valueOf(this.f28196f));
        m3Var.e("endTimestamp").o(w0Var, BigDecimal.valueOf(this.f28197g));
        if (this.f28198h != null) {
            m3Var.e("data").o(w0Var, this.f28198h);
        }
        Map<String, Object> map = this.f28200j;
        if (map != null) {
            for (String str : map.keySet()) {
                Object obj = this.f28200j.get(str);
                m3Var.e(str);
                m3Var.o(w0Var, obj);
            }
        }
        m3Var.k();
    }

    public void m(@Nullable Map<String, Object> map) {
        this.f28201k = map;
    }

    public void n(@Nullable Map<String, Object> map) {
        this.f28200j = map;
    }

    public void o(@Nullable Map<String, Object> map) {
        this.f28199i = map;
    }

    @Override // io.sentry.h2
    public void serialize(@NotNull m3 m3Var, @NotNull w0 w0Var) throws IOException {
        m3Var.h();
        new b.C0587b().a(this, m3Var, w0Var);
        m3Var.e("data");
        k(m3Var, w0Var);
        Map<String, Object> map = this.f28199i;
        if (map != null) {
            for (String str : map.keySet()) {
                Object obj = this.f28199i.get(str);
                m3Var.e(str);
                m3Var.o(w0Var, obj);
            }
        }
        m3Var.k();
    }
}
