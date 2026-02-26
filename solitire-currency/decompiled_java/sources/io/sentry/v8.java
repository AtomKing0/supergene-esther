package io.sentry;

import io.sentry.protocol.SentryId;
import io.sentry.protocol.SentrySpan;
import io.sentry.protocol.SentryTransaction;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: TraceContext.java */
/* JADX INFO: loaded from: classes5.dex */
@ApiStatus.Experimental
public final class v8 implements h2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final SentryId f28391a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final String f28392b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    private final String f28393c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    private final String f28394d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    private final String f28395e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    private final String f28396f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    private final String f28397g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Nullable
    private final String f28398h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    private final String f28399i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Nullable
    private final SentryId f28400j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @Nullable
    private Map<String, Object> f28401k;

    /* JADX INFO: compiled from: TraceContext.java */
    public static final class a implements x1<v8> {
        private Exception b(String str, w0 w0Var) {
            String str2 = "Missing required field \"" + str + "\"";
            IllegalStateException illegalStateException = new IllegalStateException(str2);
            w0Var.b(SentryLevel.ERROR, str2, illegalStateException);
            return illegalStateException;
        }

        @Override // io.sentry.x1
        @NotNull
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public v8 deserialize(@NotNull l3 l3Var, @NotNull w0 w0Var) throws Exception {
            String strC;
            l3Var.h();
            ConcurrentHashMap concurrentHashMap = null;
            SentryId sentryIdDeserialize = null;
            String strE0 = null;
            String strO0 = null;
            String strO02 = null;
            String strO03 = null;
            String strO04 = null;
            String strO05 = null;
            String strO06 = null;
            SentryId sentryIdDeserialize2 = null;
            String strO07 = null;
            while (true) {
                String str = strO07;
                if (l3Var.peek() != io.sentry.vendor.gson.stream.b.NAME) {
                    if (sentryIdDeserialize == null) {
                        throw b(SentrySpan.JsonKeys.TRACE_ID, w0Var);
                    }
                    if (strE0 == null) {
                        throw b("public_key", w0Var);
                    }
                    v8 v8Var = new v8(sentryIdDeserialize, strE0, strO0, strO02, strO03, strO04, strO05, strO06, sentryIdDeserialize2, str);
                    v8Var.c(concurrentHashMap);
                    l3Var.k();
                    return v8Var;
                }
                strC = l3Var.C();
                strC.hashCode();
                switch (strC) {
                    case "replay_id":
                        sentryIdDeserialize2 = new SentryId.Deserializer().deserialize(l3Var, w0Var);
                        break;
                    case "user_id":
                        strO03 = l3Var.o0();
                        break;
                    case "environment":
                        strO02 = l3Var.o0();
                        break;
                    case "sample_rand":
                        strO07 = l3Var.o0();
                        continue;
                        break;
                    case "sample_rate":
                        strO05 = l3Var.o0();
                        break;
                    case "release":
                        strO0 = l3Var.o0();
                        break;
                    case "trace_id":
                        sentryIdDeserialize = new SentryId.Deserializer().deserialize(l3Var, w0Var);
                        break;
                    case "sampled":
                        strO06 = l3Var.o0();
                        break;
                    case "public_key":
                        strE0 = l3Var.e0();
                        break;
                    case "transaction":
                        strO04 = l3Var.o0();
                        break;
                    default:
                        if (concurrentHashMap == null) {
                            concurrentHashMap = new ConcurrentHashMap();
                        }
                        l3Var.r0(w0Var, concurrentHashMap, strC);
                        break;
                }
                strO07 = str;
            }
        }
    }

    v8(@NotNull SentryId sentryId, @NotNull String str) {
        this(sentryId, str, null, null, null, null, null, null, null);
    }

    @Nullable
    public String a() {
        return this.f28398h;
    }

    @Nullable
    public String b() {
        return this.f28397g;
    }

    public void c(@Nullable Map<String, Object> map) {
        this.f28401k = map;
    }

    @Override // io.sentry.h2
    public void serialize(@NotNull m3 m3Var, @NotNull w0 w0Var) throws IOException {
        m3Var.h();
        m3Var.e(SentrySpan.JsonKeys.TRACE_ID).o(w0Var, this.f28391a);
        m3Var.e("public_key").g(this.f28392b);
        if (this.f28393c != null) {
            m3Var.e("release").g(this.f28393c);
        }
        if (this.f28394d != null) {
            m3Var.e("environment").g(this.f28394d);
        }
        if (this.f28395e != null) {
            m3Var.e("user_id").g(this.f28395e);
        }
        if (this.f28396f != null) {
            m3Var.e(SentryTransaction.JsonKeys.TRANSACTION).g(this.f28396f);
        }
        if (this.f28397g != null) {
            m3Var.e("sample_rate").g(this.f28397g);
        }
        if (this.f28398h != null) {
            m3Var.e("sample_rand").g(this.f28398h);
        }
        if (this.f28399i != null) {
            m3Var.e("sampled").g(this.f28399i);
        }
        if (this.f28400j != null) {
            m3Var.e("replay_id").o(w0Var, this.f28400j);
        }
        Map<String, Object> map = this.f28401k;
        if (map != null) {
            for (String str : map.keySet()) {
                Object obj = this.f28401k.get(str);
                m3Var.e(str);
                m3Var.o(w0Var, obj);
            }
        }
        m3Var.k();
    }

    @Deprecated
    v8(@NotNull SentryId sentryId, @NotNull String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7, @Nullable SentryId sentryId2) {
        this(sentryId, str, str2, str3, str4, str5, str6, str7, sentryId2, null);
    }

    v8(@NotNull SentryId sentryId, @NotNull String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7, @Nullable SentryId sentryId2, @Nullable String str8) {
        this.f28391a = sentryId;
        this.f28392b = str;
        this.f28393c = str2;
        this.f28394d = str3;
        this.f28395e = str4;
        this.f28396f = str5;
        this.f28397g = str6;
        this.f28399i = str7;
        this.f28400j = sentryId2;
        this.f28398h = str8;
    }
}
