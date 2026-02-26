package io.sentry;

import com.applovin.sdk.AppLovinEventTypes;
import io.sentry.e7;
import io.sentry.g7;
import io.sentry.protocol.SentryId;
import io.sentry.protocol.SentrySpan;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: SentryLogEvent.java */
/* JADX INFO: loaded from: classes5.dex */
public final class d7 implements h2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private SentryId f27761a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private Double f27762b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private String f27763c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private g7 f27764d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    private Integer f27765e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    private Map<String, e7> f27766f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    private Map<String, Object> f27767g;

    /* JADX INFO: compiled from: SentryLogEvent.java */
    public static final class a implements x1<d7> {
        @Override // io.sentry.x1
        @NotNull
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public d7 deserialize(@NotNull l3 l3Var, @NotNull w0 w0Var) throws Exception {
            String strC;
            l3Var.h();
            SentryId sentryId = null;
            Double dA = null;
            String strO0 = null;
            HashMap map = null;
            g7 g7Var = null;
            Map<String, e7> mapQ0 = null;
            Integer numG0 = null;
            while (l3Var.peek() == io.sentry.vendor.gson.stream.b.NAME) {
                strC = l3Var.C();
                strC.hashCode();
                switch (strC) {
                    case "severity_number":
                        numG0 = l3Var.g0();
                        break;
                    case "body":
                        strO0 = l3Var.o0();
                        break;
                    case "timestamp":
                        dA = l3Var.A();
                        break;
                    case "level":
                        g7Var = (g7) l3Var.M(w0Var, new g7.a());
                        break;
                    case "attributes":
                        mapQ0 = l3Var.q0(w0Var, new e7.a());
                        break;
                    case "trace_id":
                        sentryId = (SentryId) l3Var.M(w0Var, new SentryId.Deserializer());
                        break;
                    default:
                        if (map == null) {
                            map = new HashMap();
                        }
                        l3Var.r0(w0Var, map, strC);
                        break;
                }
            }
            l3Var.k();
            if (sentryId == null) {
                IllegalStateException illegalStateException = new IllegalStateException("Missing required field \"trace_id\"");
                w0Var.b(SentryLevel.ERROR, "Missing required field \"trace_id\"", illegalStateException);
                throw illegalStateException;
            }
            if (dA == null) {
                IllegalStateException illegalStateException2 = new IllegalStateException("Missing required field \"timestamp\"");
                w0Var.b(SentryLevel.ERROR, "Missing required field \"timestamp\"", illegalStateException2);
                throw illegalStateException2;
            }
            if (strO0 == null) {
                IllegalStateException illegalStateException3 = new IllegalStateException("Missing required field \"body\"");
                w0Var.b(SentryLevel.ERROR, "Missing required field \"body\"", illegalStateException3);
                throw illegalStateException3;
            }
            if (g7Var == null) {
                IllegalStateException illegalStateException4 = new IllegalStateException("Missing required field \"level\"");
                w0Var.b(SentryLevel.ERROR, "Missing required field \"level\"", illegalStateException4);
                throw illegalStateException4;
            }
            d7 d7Var = new d7(sentryId, dA, strO0, g7Var);
            d7Var.a(mapQ0);
            d7Var.b(numG0);
            d7Var.c(map);
            return d7Var;
        }
    }

    public d7(@NotNull SentryId sentryId, @NotNull Double d10, @NotNull String str, @NotNull g7 g7Var) {
        this.f27761a = sentryId;
        this.f27762b = d10;
        this.f27763c = str;
        this.f27764d = g7Var;
    }

    public void a(@Nullable Map<String, e7> map) {
        this.f27766f = map;
    }

    public void b(@Nullable Integer num) {
        this.f27765e = num;
    }

    public void c(@Nullable Map<String, Object> map) {
        this.f27767g = map;
    }

    @Override // io.sentry.h2
    public void serialize(@NotNull m3 m3Var, @NotNull w0 w0Var) throws IOException {
        m3Var.h();
        m3Var.e("timestamp").o(w0Var, n.c(this.f27762b));
        m3Var.e(SentrySpan.JsonKeys.TRACE_ID).o(w0Var, this.f27761a);
        m3Var.e("body").g(this.f27763c);
        m3Var.e(AppLovinEventTypes.USER_COMPLETED_LEVEL).o(w0Var, this.f27764d);
        if (this.f27765e != null) {
            m3Var.e("severity_number").o(w0Var, this.f27765e);
        }
        if (this.f27766f != null) {
            m3Var.e("attributes").o(w0Var, this.f27766f);
        }
        Map<String, Object> map = this.f27767g;
        if (map != null) {
            for (String str : map.keySet()) {
                m3Var.e(str).o(w0Var, this.f27767g.get(str));
            }
        }
        m3Var.k();
    }
}
