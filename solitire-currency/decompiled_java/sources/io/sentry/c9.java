package io.sentry;

import io.sentry.protocol.SentryId;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: UserFeedback.java */
/* JADX INFO: loaded from: classes5.dex */
public final class c9 implements h2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SentryId f27645a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    private String f27646b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    private String f27647c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    private String f27648d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    private Map<String, Object> f27649e;

    /* JADX INFO: compiled from: UserFeedback.java */
    public static final class a implements x1<c9> {
        @Override // io.sentry.x1
        @NotNull
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public c9 deserialize(@NotNull l3 l3Var, @NotNull w0 w0Var) throws Exception {
            String strC;
            l3Var.h();
            SentryId sentryIdDeserialize = null;
            String strO0 = null;
            String strO02 = null;
            String strO03 = null;
            HashMap map = null;
            while (l3Var.peek() == io.sentry.vendor.gson.stream.b.NAME) {
                strC = l3Var.C();
                strC.hashCode();
                switch (strC) {
                    case "comments":
                        strO03 = l3Var.o0();
                        break;
                    case "name":
                        strO0 = l3Var.o0();
                        break;
                    case "email":
                        strO02 = l3Var.o0();
                        break;
                    case "event_id":
                        sentryIdDeserialize = new SentryId.Deserializer().deserialize(l3Var, w0Var);
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
            if (sentryIdDeserialize != null) {
                c9 c9Var = new c9(sentryIdDeserialize, strO0, strO02, strO03);
                c9Var.b(map);
                return c9Var;
            }
            IllegalStateException illegalStateException = new IllegalStateException("Missing required field \"event_id\"");
            w0Var.b(SentryLevel.ERROR, "Missing required field \"event_id\"", illegalStateException);
            throw illegalStateException;
        }
    }

    public c9(SentryId sentryId, @Nullable String str, @Nullable String str2, @Nullable String str3) {
        this.f27645a = sentryId;
        this.f27646b = str;
        this.f27647c = str2;
        this.f27648d = str3;
    }

    public SentryId a() {
        return this.f27645a;
    }

    public void b(@Nullable Map<String, Object> map) {
        this.f27649e = map;
    }

    @Override // io.sentry.h2
    public void serialize(@NotNull m3 m3Var, @NotNull w0 w0Var) throws IOException {
        m3Var.h();
        m3Var.e("event_id");
        this.f27645a.serialize(m3Var, w0Var);
        if (this.f27646b != null) {
            m3Var.e("name").g(this.f27646b);
        }
        if (this.f27647c != null) {
            m3Var.e("email").g(this.f27647c);
        }
        if (this.f27648d != null) {
            m3Var.e("comments").g(this.f27648d);
        }
        Map<String, Object> map = this.f27649e;
        if (map != null) {
            for (String str : map.keySet()) {
                m3Var.e(str).o(w0Var, this.f27649e.get(str));
            }
        }
        m3Var.k();
    }

    public String toString() {
        return "UserFeedback{eventId=" + this.f27645a + ", name='" + this.f27646b + "', email='" + this.f27647c + "', comments='" + this.f27648d + "'}";
    }
}
