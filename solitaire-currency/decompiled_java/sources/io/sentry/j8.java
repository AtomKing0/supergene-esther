package io.sentry;

import io.sentry.o8;
import io.sentry.protocol.SentryId;
import io.sentry.protocol.SentrySpan;
import io.sentry.q8;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.TestOnly;

/* JADX INFO: compiled from: SpanContext.java */
/* JADX INFO: loaded from: classes5.dex */
public class j8 implements h2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final SentryId f27945a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final o8 f27946b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    private o8 f27947c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    private transient x8 f27948d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    protected String f27949e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    protected String f27950f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    protected q8 f27951g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NotNull
    protected Map<String, String> f27952h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    protected String f27953i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NotNull
    protected Map<String, Object> f27954j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @Nullable
    private Map<String, Object> f27955k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @NotNull
    private u1 f27956l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @Nullable
    protected d f27957m;

    /* JADX INFO: compiled from: SpanContext.java */
    public static final class a implements x1<j8> {
        @Override // io.sentry.x1
        @NotNull
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public j8 deserialize(@NotNull l3 l3Var, @NotNull w0 w0Var) throws Exception {
            String strC;
            l3Var.h();
            String strE0 = null;
            SentryId sentryIdDeserialize = null;
            o8 o8VarA = null;
            o8 o8Var = null;
            ConcurrentHashMap concurrentHashMap = null;
            String strE02 = null;
            q8 q8Var = null;
            String strE03 = null;
            Map<String, String> mapB = null;
            Map<String, Object> map = null;
            while (l3Var.peek() == io.sentry.vendor.gson.stream.b.NAME) {
                strC = l3Var.C();
                strC.hashCode();
                switch (strC) {
                    case "span_id":
                        o8VarA = new o8.a().deserialize(l3Var, w0Var);
                        break;
                    case "parent_span_id":
                        o8Var = (o8) l3Var.M(w0Var, new o8.a());
                        break;
                    case "description":
                        strE02 = l3Var.e0();
                        break;
                    case "origin":
                        strE03 = l3Var.e0();
                        break;
                    case "status":
                        q8Var = (q8) l3Var.M(w0Var, new q8.a());
                        break;
                    case "op":
                        strE0 = l3Var.e0();
                        break;
                    case "data":
                        map = (Map) l3Var.A0();
                        break;
                    case "tags":
                        mapB = io.sentry.util.c.b((Map) l3Var.A0());
                        break;
                    case "trace_id":
                        sentryIdDeserialize = new SentryId.Deserializer().deserialize(l3Var, w0Var);
                        break;
                    default:
                        if (concurrentHashMap == null) {
                            concurrentHashMap = new ConcurrentHashMap();
                        }
                        l3Var.r0(w0Var, concurrentHashMap, strC);
                        break;
                }
            }
            if (sentryIdDeserialize == null) {
                IllegalStateException illegalStateException = new IllegalStateException("Missing required field \"trace_id\"");
                w0Var.b(SentryLevel.ERROR, "Missing required field \"trace_id\"", illegalStateException);
                throw illegalStateException;
            }
            if (o8VarA == null) {
                IllegalStateException illegalStateException2 = new IllegalStateException("Missing required field \"span_id\"");
                w0Var.b(SentryLevel.ERROR, "Missing required field \"span_id\"", illegalStateException2);
                throw illegalStateException2;
            }
            j8 j8Var = new j8(sentryIdDeserialize, o8VarA, strE0 == null ? "" : strE0, o8Var, null);
            j8Var.p(strE02);
            j8Var.t(q8Var);
            j8Var.r(strE03);
            if (mapB != null) {
                j8Var.f27952h = mapB;
            }
            if (map != null) {
                j8Var.f27954j = map;
            }
            j8Var.u(concurrentHashMap);
            l3Var.k();
            return j8Var;
        }
    }

    public j8(@NotNull String str) {
        this(new SentryId(), new o8(), str, null, null);
    }

    @ApiStatus.Internal
    public j8 a(@NotNull String str, @Nullable o8 o8Var, @Nullable o8 o8Var2) {
        SentryId sentryId = this.f27945a;
        if (o8Var2 == null) {
            o8Var2 = new o8();
        }
        return new j8(sentryId, o8Var2, o8Var, str, null, this.f27948d, null, "manual");
    }

    @Nullable
    public d b() {
        return this.f27957m;
    }

    @Nullable
    public String c() {
        return this.f27950f;
    }

    @NotNull
    public u1 d() {
        return this.f27956l;
    }

    @NotNull
    public String e() {
        return this.f27949e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof j8)) {
            return false;
        }
        j8 j8Var = (j8) obj;
        return this.f27945a.equals(j8Var.f27945a) && this.f27946b.equals(j8Var.f27946b) && io.sentry.util.w.a(this.f27947c, j8Var.f27947c) && this.f27949e.equals(j8Var.f27949e) && io.sentry.util.w.a(this.f27950f, j8Var.f27950f) && l() == j8Var.l();
    }

    @Nullable
    public String f() {
        return this.f27953i;
    }

    @TestOnly
    @Nullable
    public o8 g() {
        return this.f27947c;
    }

    @Nullable
    public Boolean h() {
        x8 x8Var = this.f27948d;
        if (x8Var == null) {
            return null;
        }
        return x8Var.b();
    }

    public int hashCode() {
        return io.sentry.util.w.b(this.f27945a, this.f27946b, this.f27947c, this.f27949e, this.f27950f, l());
    }

    @Nullable
    public Boolean i() {
        x8 x8Var = this.f27948d;
        if (x8Var == null) {
            return null;
        }
        return x8Var.e();
    }

    @Nullable
    public x8 j() {
        return this.f27948d;
    }

    @NotNull
    public o8 k() {
        return this.f27946b;
    }

    @Nullable
    public q8 l() {
        return this.f27951g;
    }

    @NotNull
    public Map<String, String> m() {
        return this.f27952h;
    }

    @NotNull
    public SentryId n() {
        return this.f27945a;
    }

    public void o(@Nullable String str, @Nullable Object obj) {
        if (str == null) {
            return;
        }
        if (obj == null) {
            this.f27954j.remove(str);
        } else {
            this.f27954j.put(str, obj);
        }
    }

    public void p(@Nullable String str) {
        this.f27950f = str;
    }

    public void q(@NotNull u1 u1Var) {
        this.f27956l = u1Var;
    }

    public void r(@Nullable String str) {
        this.f27953i = str;
    }

    @ApiStatus.Internal
    public void s(@Nullable x8 x8Var) {
        this.f27948d = x8Var;
        d dVar = this.f27957m;
        if (dVar != null) {
            dVar.M(x8Var);
        }
    }

    @Override // io.sentry.h2
    public void serialize(@NotNull m3 m3Var, @NotNull w0 w0Var) throws IOException {
        m3Var.h();
        m3Var.e(SentrySpan.JsonKeys.TRACE_ID);
        this.f27945a.serialize(m3Var, w0Var);
        m3Var.e(SentrySpan.JsonKeys.SPAN_ID);
        this.f27946b.serialize(m3Var, w0Var);
        if (this.f27947c != null) {
            m3Var.e(SentrySpan.JsonKeys.PARENT_SPAN_ID);
            this.f27947c.serialize(m3Var, w0Var);
        }
        m3Var.e(SentrySpan.JsonKeys.OP).g(this.f27949e);
        if (this.f27950f != null) {
            m3Var.e("description").g(this.f27950f);
        }
        if (l() != null) {
            m3Var.e("status").o(w0Var, l());
        }
        if (this.f27953i != null) {
            m3Var.e("origin").o(w0Var, this.f27953i);
        }
        if (!this.f27952h.isEmpty()) {
            m3Var.e(SentrySpan.JsonKeys.TAGS).o(w0Var, this.f27952h);
        }
        if (!this.f27954j.isEmpty()) {
            m3Var.e("data").o(w0Var, this.f27954j);
        }
        Map<String, Object> map = this.f27955k;
        if (map != null) {
            for (String str : map.keySet()) {
                m3Var.e(str).o(w0Var, this.f27955k.get(str));
            }
        }
        m3Var.k();
    }

    public void t(@Nullable q8 q8Var) {
        this.f27951g = q8Var;
    }

    public void u(@Nullable Map<String, Object> map) {
        this.f27955k = map;
    }

    public j8(@NotNull SentryId sentryId, @NotNull o8 o8Var, @NotNull String str, @Nullable o8 o8Var2, @Nullable x8 x8Var) {
        this(sentryId, o8Var, o8Var2, str, null, x8Var, null, "manual");
    }

    @ApiStatus.Internal
    public j8(@NotNull SentryId sentryId, @NotNull o8 o8Var, @Nullable o8 o8Var2, @NotNull String str, @Nullable String str2, @Nullable x8 x8Var, @Nullable q8 q8Var, @Nullable String str3) {
        this.f27952h = new ConcurrentHashMap();
        this.f27953i = "manual";
        this.f27954j = new ConcurrentHashMap();
        this.f27956l = u1.SENTRY;
        this.f27945a = (SentryId) io.sentry.util.w.c(sentryId, "traceId is required");
        this.f27946b = (o8) io.sentry.util.w.c(o8Var, "spanId is required");
        this.f27949e = (String) io.sentry.util.w.c(str, "operation is required");
        this.f27947c = o8Var2;
        this.f27950f = str2;
        this.f27951g = q8Var;
        this.f27953i = str3;
        s(x8Var);
        io.sentry.util.thread.a threadChecker = r4.a().getOptions().getThreadChecker();
        this.f27954j.put("thread.id", String.valueOf(threadChecker.c()));
        this.f27954j.put("thread.name", threadChecker.b());
    }

    public j8(@NotNull j8 j8Var) {
        this.f27952h = new ConcurrentHashMap();
        this.f27953i = "manual";
        this.f27954j = new ConcurrentHashMap();
        this.f27956l = u1.SENTRY;
        this.f27945a = j8Var.f27945a;
        this.f27946b = j8Var.f27946b;
        this.f27947c = j8Var.f27947c;
        s(j8Var.f27948d);
        this.f27949e = j8Var.f27949e;
        this.f27950f = j8Var.f27950f;
        this.f27951g = j8Var.f27951g;
        Map<String, String> mapB = io.sentry.util.c.b(j8Var.f27952h);
        if (mapB != null) {
            this.f27952h = mapB;
        }
        Map<String, Object> mapB2 = io.sentry.util.c.b(j8Var.f27955k);
        if (mapB2 != null) {
            this.f27955k = mapB2;
        }
        this.f27957m = j8Var.f27957m;
        Map<String, Object> mapB3 = io.sentry.util.c.b(j8Var.f27954j);
        if (mapB3 != null) {
            this.f27954j = mapB3;
        }
    }
}
