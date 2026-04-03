package io.sentry;

import io.sentry.protocol.SentrySpan;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ProfilingTransactionData.java */
/* JADX INFO: loaded from: classes5.dex */
@ApiStatus.Internal
public final class y3 implements h2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private String f28503a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private String f28504b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private String f28505c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private Long f28506d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    private Long f28507e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    private Long f28508f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    private Long f28509g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Nullable
    private Map<String, Object> f28510h;

    /* JADX INFO: compiled from: ProfilingTransactionData.java */
    public static final class a implements x1<y3> {
        @Override // io.sentry.x1
        @NotNull
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public y3 deserialize(@NotNull l3 l3Var, @NotNull w0 w0Var) throws Exception {
            String strC;
            l3Var.h();
            y3 y3Var = new y3();
            ConcurrentHashMap concurrentHashMap = null;
            while (l3Var.peek() == io.sentry.vendor.gson.stream.b.NAME) {
                strC = l3Var.C();
                strC.hashCode();
                switch (strC) {
                    case "relative_start_ns":
                        Long lJ0 = l3Var.j0();
                        if (lJ0 == null) {
                            break;
                        } else {
                            y3Var.f28506d = lJ0;
                            break;
                        }
                        break;
                    case "relative_end_ns":
                        Long lJ02 = l3Var.j0();
                        if (lJ02 == null) {
                            break;
                        } else {
                            y3Var.f28507e = lJ02;
                            break;
                        }
                        break;
                    case "id":
                        String strO0 = l3Var.o0();
                        if (strO0 == null) {
                            break;
                        } else {
                            y3Var.f28503a = strO0;
                            break;
                        }
                        break;
                    case "name":
                        String strO02 = l3Var.o0();
                        if (strO02 == null) {
                            break;
                        } else {
                            y3Var.f28505c = strO02;
                            break;
                        }
                        break;
                    case "trace_id":
                        String strO03 = l3Var.o0();
                        if (strO03 == null) {
                            break;
                        } else {
                            y3Var.f28504b = strO03;
                            break;
                        }
                        break;
                    case "relative_cpu_end_ms":
                        Long lJ03 = l3Var.j0();
                        if (lJ03 == null) {
                            break;
                        } else {
                            y3Var.f28509g = lJ03;
                            break;
                        }
                        break;
                    case "relative_cpu_start_ms":
                        Long lJ04 = l3Var.j0();
                        if (lJ04 == null) {
                            break;
                        } else {
                            y3Var.f28508f = lJ04;
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
            y3Var.l(concurrentHashMap);
            l3Var.k();
            return y3Var;
        }
    }

    public y3() {
        this(g3.v(), 0L, 0L);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || y3.class != obj.getClass()) {
            return false;
        }
        y3 y3Var = (y3) obj;
        return this.f28503a.equals(y3Var.f28503a) && this.f28504b.equals(y3Var.f28504b) && this.f28505c.equals(y3Var.f28505c) && this.f28506d.equals(y3Var.f28506d) && this.f28508f.equals(y3Var.f28508f) && io.sentry.util.w.a(this.f28509g, y3Var.f28509g) && io.sentry.util.w.a(this.f28507e, y3Var.f28507e) && io.sentry.util.w.a(this.f28510h, y3Var.f28510h);
    }

    @NotNull
    public String h() {
        return this.f28503a;
    }

    public int hashCode() {
        return io.sentry.util.w.b(this.f28503a, this.f28504b, this.f28505c, this.f28506d, this.f28507e, this.f28508f, this.f28509g, this.f28510h);
    }

    @NotNull
    public String i() {
        return this.f28505c;
    }

    @NotNull
    public String j() {
        return this.f28504b;
    }

    public void k(@NotNull Long l10, @NotNull Long l11, @NotNull Long l12, @NotNull Long l13) {
        if (this.f28507e == null) {
            this.f28507e = Long.valueOf(l10.longValue() - l11.longValue());
            this.f28506d = Long.valueOf(this.f28506d.longValue() - l11.longValue());
            this.f28509g = Long.valueOf(l12.longValue() - l13.longValue());
            this.f28508f = Long.valueOf(this.f28508f.longValue() - l13.longValue());
        }
    }

    public void l(@Nullable Map<String, Object> map) {
        this.f28510h = map;
    }

    @Override // io.sentry.h2
    public void serialize(@NotNull m3 m3Var, @NotNull w0 w0Var) throws IOException {
        m3Var.h();
        m3Var.e("id").o(w0Var, this.f28503a);
        m3Var.e(SentrySpan.JsonKeys.TRACE_ID).o(w0Var, this.f28504b);
        m3Var.e("name").o(w0Var, this.f28505c);
        m3Var.e("relative_start_ns").o(w0Var, this.f28506d);
        m3Var.e("relative_end_ns").o(w0Var, this.f28507e);
        m3Var.e("relative_cpu_start_ms").o(w0Var, this.f28508f);
        m3Var.e("relative_cpu_end_ms").o(w0Var, this.f28509g);
        Map<String, Object> map = this.f28510h;
        if (map != null) {
            for (String str : map.keySet()) {
                Object obj = this.f28510h.get(str);
                m3Var.e(str);
                m3Var.o(w0Var, obj);
            }
        }
        m3Var.k();
    }

    public y3(@NotNull p1 p1Var, @NotNull Long l10, @NotNull Long l11) {
        this.f28503a = p1Var.getEventId().toString();
        this.f28504b = p1Var.r().n().toString();
        this.f28505c = p1Var.getName().isEmpty() ? "unknown" : p1Var.getName();
        this.f28506d = l10;
        this.f28508f = l11;
    }
}
