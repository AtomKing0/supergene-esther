package io.sentry.rrweb;

import io.sentry.h2;
import io.sentry.l3;
import io.sentry.m3;
import io.sentry.protocol.ViewHierarchyNode;
import io.sentry.rrweb.b;
import io.sentry.rrweb.d;
import io.sentry.w0;
import io.sentry.x1;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: RRWebInteractionMoveEvent.java */
/* JADX INFO: loaded from: classes5.dex */
public final class f extends d implements h2 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f28179d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    private List<b> f28180e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    private Map<String, Object> f28181f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    private Map<String, Object> f28182g;

    /* JADX INFO: compiled from: RRWebInteractionMoveEvent.java */
    public static final class a implements x1<f> {
        private void b(@NotNull f fVar, @NotNull l3 l3Var, @NotNull w0 w0Var) throws Exception {
            d.a aVar = new d.a();
            l3Var.h();
            HashMap map = null;
            while (l3Var.peek() == io.sentry.vendor.gson.stream.b.NAME) {
                String strC = l3Var.C();
                strC.hashCode();
                if (strC.equals("pointerId")) {
                    fVar.f28179d = l3Var.nextInt();
                } else if (strC.equals("positions")) {
                    fVar.f28180e = l3Var.D0(w0Var, new b.a());
                } else if (!aVar.a(fVar, strC, l3Var, w0Var)) {
                    if (map == null) {
                        map = new HashMap();
                    }
                    l3Var.r0(w0Var, map, strC);
                }
            }
            fVar.j(map);
            l3Var.k();
        }

        @Override // io.sentry.x1
        @NotNull
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public f deserialize(@NotNull l3 l3Var, @NotNull w0 w0Var) throws Exception {
            l3Var.h();
            f fVar = new f();
            b.a aVar = new b.a();
            HashMap map = null;
            while (l3Var.peek() == io.sentry.vendor.gson.stream.b.NAME) {
                String strC = l3Var.C();
                strC.hashCode();
                if (strC.equals("data")) {
                    b(fVar, l3Var, w0Var);
                } else if (!aVar.a(fVar, strC, l3Var, w0Var)) {
                    if (map == null) {
                        map = new HashMap();
                    }
                    l3Var.r0(w0Var, map, strC);
                }
            }
            fVar.k(map);
            l3Var.k();
            return fVar;
        }
    }

    /* JADX INFO: compiled from: RRWebInteractionMoveEvent.java */
    public static final class b implements h2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f28183a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private float f28184b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private float f28185c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private long f28186d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @Nullable
        private Map<String, Object> f28187e;

        /* JADX INFO: compiled from: RRWebInteractionMoveEvent.java */
        public static final class a implements x1<b> {
            @Override // io.sentry.x1
            @NotNull
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public b deserialize(@NotNull l3 l3Var, @NotNull w0 w0Var) throws Exception {
                String strC;
                l3Var.h();
                b bVar = new b();
                HashMap map = null;
                while (l3Var.peek() == io.sentry.vendor.gson.stream.b.NAME) {
                    strC = l3Var.C();
                    strC.hashCode();
                    switch (strC) {
                        case "x":
                            bVar.f28184b = l3Var.nextFloat();
                            break;
                        case "y":
                            bVar.f28185c = l3Var.nextFloat();
                            break;
                        case "id":
                            bVar.f28183a = l3Var.nextInt();
                            break;
                        case "timeOffset":
                            bVar.f28186d = l3Var.nextLong();
                            break;
                        default:
                            if (map == null) {
                                map = new HashMap();
                            }
                            l3Var.r0(w0Var, map, strC);
                            break;
                    }
                }
                bVar.e(map);
                l3Var.k();
                return bVar;
            }
        }

        public void e(@Nullable Map<String, Object> map) {
            this.f28187e = map;
        }

        @Override // io.sentry.h2
        public void serialize(@NotNull m3 m3Var, @NotNull w0 w0Var) throws IOException {
            m3Var.h();
            m3Var.e("id").a(this.f28183a);
            m3Var.e(ViewHierarchyNode.JsonKeys.X).b(this.f28184b);
            m3Var.e(ViewHierarchyNode.JsonKeys.Y).b(this.f28185c);
            m3Var.e("timeOffset").a(this.f28186d);
            Map<String, Object> map = this.f28187e;
            if (map != null) {
                for (String str : map.keySet()) {
                    Object obj = this.f28187e.get(str);
                    m3Var.e(str);
                    m3Var.o(w0Var, obj);
                }
            }
            m3Var.k();
        }
    }

    public f() {
        super(d.b.TouchMove);
    }

    private void i(@NotNull m3 m3Var, @NotNull w0 w0Var) throws IOException {
        m3Var.h();
        new d.c().a(this, m3Var, w0Var);
        List<b> list = this.f28180e;
        if (list != null && !list.isEmpty()) {
            m3Var.e("positions").o(w0Var, this.f28180e);
        }
        m3Var.e("pointerId").a(this.f28179d);
        Map<String, Object> map = this.f28182g;
        if (map != null) {
            for (String str : map.keySet()) {
                Object obj = this.f28182g.get(str);
                m3Var.e(str);
                m3Var.o(w0Var, obj);
            }
        }
        m3Var.k();
    }

    public void j(@Nullable Map<String, Object> map) {
        this.f28182g = map;
    }

    public void k(@Nullable Map<String, Object> map) {
        this.f28181f = map;
    }

    @Override // io.sentry.h2
    public void serialize(@NotNull m3 m3Var, @NotNull w0 w0Var) throws IOException {
        m3Var.h();
        new b.C0587b().a(this, m3Var, w0Var);
        m3Var.e("data");
        i(m3Var, w0Var);
        Map<String, Object> map = this.f28181f;
        if (map != null) {
            for (String str : map.keySet()) {
                Object obj = this.f28181f.get(str);
                m3Var.e(str);
                m3Var.o(w0Var, obj);
            }
        }
        m3Var.k();
    }
}
