package io.sentry.rrweb;

import androidx.media3.extractor.text.ttml.TtmlNode;
import io.sentry.h2;
import io.sentry.l3;
import io.sentry.m3;
import io.sentry.protocol.ViewHierarchyNode;
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

/* JADX INFO: compiled from: RRWebVideoEvent.java */
/* JADX INFO: loaded from: classes5.dex */
public final class i extends b implements h2 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private String f28202c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f28203d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f28204e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f28205f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NotNull
    private String f28206g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NotNull
    private String f28207h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f28208i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f28209j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f28210k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @NotNull
    private String f28211l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f28212m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f28213n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f28214o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @Nullable
    private Map<String, Object> f28215p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @Nullable
    private Map<String, Object> f28216q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @Nullable
    private Map<String, Object> f28217r;

    /* JADX INFO: compiled from: RRWebVideoEvent.java */
    public static final class a implements x1<i> {
        private void b(@NotNull i iVar, @NotNull l3 l3Var, @NotNull w0 w0Var) throws Exception {
            l3Var.h();
            ConcurrentHashMap concurrentHashMap = null;
            while (l3Var.peek() == io.sentry.vendor.gson.stream.b.NAME) {
                String strC = l3Var.C();
                strC.hashCode();
                if (strC.equals("payload")) {
                    c(iVar, l3Var, w0Var);
                } else if (strC.equals(ViewHierarchyNode.JsonKeys.TAG)) {
                    String strO0 = l3Var.o0();
                    if (strO0 == null) {
                        strO0 = "";
                    }
                    iVar.f28202c = strO0;
                } else {
                    if (concurrentHashMap == null) {
                        concurrentHashMap = new ConcurrentHashMap();
                    }
                    l3Var.r0(w0Var, concurrentHashMap, strC);
                }
            }
            iVar.t(concurrentHashMap);
            l3Var.k();
        }

        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        private void c(@NotNull i iVar, @NotNull l3 l3Var, @NotNull w0 w0Var) throws Exception {
            l3Var.h();
            ConcurrentHashMap concurrentHashMap = null;
            while (l3Var.peek() == io.sentry.vendor.gson.stream.b.NAME) {
                String strC = l3Var.C();
                strC.hashCode();
                byte b10 = -1;
                switch (strC.hashCode()) {
                    case -1992012396:
                        if (strC.equals("duration")) {
                            b10 = 0;
                        }
                        break;
                    case -1627805778:
                        if (strC.equals("segmentId")) {
                            b10 = 1;
                        }
                        break;
                    case -1221029593:
                        if (strC.equals("height")) {
                            b10 = 2;
                        }
                        break;
                    case -410956671:
                        if (strC.equals(TtmlNode.RUBY_CONTAINER)) {
                            b10 = 3;
                        }
                        break;
                    case -296512606:
                        if (strC.equals("frameCount")) {
                            b10 = 4;
                        }
                        break;
                    case 115029:
                        if (strC.equals("top")) {
                            b10 = 5;
                        }
                        break;
                    case 3317767:
                        if (strC.equals(TtmlNode.LEFT)) {
                            b10 = 6;
                        }
                        break;
                    case 3530753:
                        if (strC.equals("size")) {
                            b10 = 7;
                        }
                        break;
                    case 113126854:
                        if (strC.equals("width")) {
                            b10 = 8;
                        }
                        break;
                    case 545057773:
                        if (strC.equals("frameRate")) {
                            b10 = 9;
                        }
                        break;
                    case 1711222099:
                        if (strC.equals("encoding")) {
                            b10 = 10;
                        }
                        break;
                    case 2135109831:
                        if (strC.equals("frameRateType")) {
                            b10 = 11;
                        }
                        break;
                }
                switch (b10) {
                    case 0:
                        iVar.f28205f = l3Var.nextLong();
                        break;
                    case 1:
                        iVar.f28203d = l3Var.nextInt();
                        break;
                    case 2:
                        Integer numG0 = l3Var.g0();
                        iVar.f28208i = numG0 != null ? numG0.intValue() : 0;
                        break;
                    case 3:
                        String strO0 = l3Var.o0();
                        iVar.f28207h = strO0 != null ? strO0 : "";
                        break;
                    case 4:
                        Integer numG02 = l3Var.g0();
                        iVar.f28210k = numG02 != null ? numG02.intValue() : 0;
                        break;
                    case 5:
                        Integer numG03 = l3Var.g0();
                        iVar.f28214o = numG03 != null ? numG03.intValue() : 0;
                        break;
                    case 6:
                        Integer numG04 = l3Var.g0();
                        iVar.f28213n = numG04 != null ? numG04.intValue() : 0;
                        break;
                    case 7:
                        Long lJ0 = l3Var.j0();
                        iVar.f28204e = lJ0 == null ? 0L : lJ0.longValue();
                        break;
                    case 8:
                        Integer numG05 = l3Var.g0();
                        iVar.f28209j = numG05 != null ? numG05.intValue() : 0;
                        break;
                    case 9:
                        Integer numG06 = l3Var.g0();
                        iVar.f28212m = numG06 != null ? numG06.intValue() : 0;
                        break;
                    case 10:
                        String strO02 = l3Var.o0();
                        iVar.f28206g = strO02 != null ? strO02 : "";
                        break;
                    case 11:
                        String strO03 = l3Var.o0();
                        iVar.f28211l = strO03 != null ? strO03 : "";
                        break;
                    default:
                        if (concurrentHashMap == null) {
                            concurrentHashMap = new ConcurrentHashMap();
                        }
                        l3Var.r0(w0Var, concurrentHashMap, strC);
                        break;
                }
            }
            iVar.u(concurrentHashMap);
            l3Var.k();
        }

        @Override // io.sentry.x1
        @NotNull
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public i deserialize(@NotNull l3 l3Var, @NotNull w0 w0Var) throws Exception {
            l3Var.h();
            i iVar = new i();
            b.a aVar = new b.a();
            HashMap map = null;
            while (l3Var.peek() == io.sentry.vendor.gson.stream.b.NAME) {
                String strC = l3Var.C();
                strC.hashCode();
                if (strC.equals("data")) {
                    b(iVar, l3Var, w0Var);
                } else if (!aVar.a(iVar, strC, l3Var, w0Var)) {
                    if (map == null) {
                        map = new HashMap();
                    }
                    l3Var.r0(w0Var, map, strC);
                }
            }
            iVar.v(map);
            l3Var.k();
            return iVar;
        }
    }

    public i() {
        super(c.Custom);
        this.f28206g = "h264";
        this.f28207h = "mp4";
        this.f28211l = "constant";
        this.f28202c = "video";
    }

    private void r(@NotNull m3 m3Var, @NotNull w0 w0Var) throws IOException {
        m3Var.h();
        m3Var.e(ViewHierarchyNode.JsonKeys.TAG).g(this.f28202c);
        m3Var.e("payload");
        s(m3Var, w0Var);
        Map<String, Object> map = this.f28217r;
        if (map != null) {
            for (String str : map.keySet()) {
                Object obj = this.f28217r.get(str);
                m3Var.e(str);
                m3Var.o(w0Var, obj);
            }
        }
        m3Var.k();
    }

    private void s(@NotNull m3 m3Var, @NotNull w0 w0Var) throws IOException {
        m3Var.h();
        m3Var.e("segmentId").a(this.f28203d);
        m3Var.e("size").a(this.f28204e);
        m3Var.e("duration").a(this.f28205f);
        m3Var.e("encoding").g(this.f28206g);
        m3Var.e(TtmlNode.RUBY_CONTAINER).g(this.f28207h);
        m3Var.e("height").a(this.f28208i);
        m3Var.e("width").a(this.f28209j);
        m3Var.e("frameCount").a(this.f28210k);
        m3Var.e("frameRate").a(this.f28212m);
        m3Var.e("frameRateType").g(this.f28211l);
        m3Var.e(TtmlNode.LEFT).a(this.f28213n);
        m3Var.e("top").a(this.f28214o);
        Map<String, Object> map = this.f28216q;
        if (map != null) {
            for (String str : map.keySet()) {
                Object obj = this.f28216q.get(str);
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
        if (obj == null || i.class != obj.getClass() || !super.equals(obj)) {
            return false;
        }
        i iVar = (i) obj;
        return this.f28203d == iVar.f28203d && this.f28204e == iVar.f28204e && this.f28205f == iVar.f28205f && this.f28208i == iVar.f28208i && this.f28209j == iVar.f28209j && this.f28210k == iVar.f28210k && this.f28212m == iVar.f28212m && this.f28213n == iVar.f28213n && this.f28214o == iVar.f28214o && w.a(this.f28202c, iVar.f28202c) && w.a(this.f28206g, iVar.f28206g) && w.a(this.f28207h, iVar.f28207h) && w.a(this.f28211l, iVar.f28211l);
    }

    @Override // io.sentry.rrweb.b
    public int hashCode() {
        return w.b(Integer.valueOf(super.hashCode()), this.f28202c, Integer.valueOf(this.f28203d), Long.valueOf(this.f28204e), Long.valueOf(this.f28205f), this.f28206g, this.f28207h, Integer.valueOf(this.f28208i), Integer.valueOf(this.f28209j), Integer.valueOf(this.f28210k), this.f28211l, Integer.valueOf(this.f28212m), Integer.valueOf(this.f28213n), Integer.valueOf(this.f28214o));
    }

    @Override // io.sentry.h2
    public void serialize(@NotNull m3 m3Var, @NotNull w0 w0Var) throws IOException {
        m3Var.h();
        new b.C0587b().a(this, m3Var, w0Var);
        m3Var.e("data");
        r(m3Var, w0Var);
        Map<String, Object> map = this.f28215p;
        if (map != null) {
            for (String str : map.keySet()) {
                Object obj = this.f28215p.get(str);
                m3Var.e(str);
                m3Var.o(w0Var, obj);
            }
        }
        m3Var.k();
    }

    public void t(@Nullable Map<String, Object> map) {
        this.f28217r = map;
    }

    public void u(@Nullable Map<String, Object> map) {
        this.f28216q = map;
    }

    public void v(@Nullable Map<String, Object> map) {
        this.f28215p = map;
    }
}
