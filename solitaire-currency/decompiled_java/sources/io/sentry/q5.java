package io.sentry;

import com.unity3d.services.core.di.ServiceProvider;
import io.sentry.protocol.SdkVersion;
import io.sentry.protocol.SentryId;
import io.sentry.v8;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: SentryEnvelopeHeader.java */
/* JADX INFO: loaded from: classes5.dex */
@ApiStatus.Internal
public final class q5 implements h2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    private final SentryId f28107a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    private final SdkVersion f28108b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    private final v8 f28109c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    private Date f28110d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    private Map<String, Object> f28111e;

    /* JADX INFO: compiled from: SentryEnvelopeHeader.java */
    public static final class a implements x1<q5> {
        @Override // io.sentry.x1
        @NotNull
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public q5 deserialize(@NotNull l3 l3Var, @NotNull w0 w0Var) throws Exception {
            String strC;
            l3Var.h();
            SentryId sentryId = null;
            SdkVersion sdkVersion = null;
            v8 v8Var = null;
            Date dateF = null;
            HashMap map = null;
            while (l3Var.peek() == io.sentry.vendor.gson.stream.b.NAME) {
                strC = l3Var.C();
                strC.hashCode();
                switch (strC) {
                    case "sdk":
                        sdkVersion = (SdkVersion) l3Var.M(w0Var, new SdkVersion.Deserializer());
                        break;
                    case "trace":
                        v8Var = (v8) l3Var.M(w0Var, new v8.a());
                        break;
                    case "event_id":
                        sentryId = (SentryId) l3Var.M(w0Var, new SentryId.Deserializer());
                        break;
                    case "sent_at":
                        dateF = l3Var.F(w0Var);
                        break;
                    default:
                        if (map == null) {
                            map = new HashMap();
                        }
                        l3Var.r0(w0Var, map, strC);
                        break;
                }
            }
            q5 q5Var = new q5(sentryId, sdkVersion, v8Var);
            q5Var.d(dateF);
            q5Var.e(map);
            l3Var.k();
            return q5Var;
        }
    }

    public q5(@Nullable SentryId sentryId, @Nullable SdkVersion sdkVersion) {
        this(sentryId, sdkVersion, null);
    }

    @Nullable
    public SentryId a() {
        return this.f28107a;
    }

    @Nullable
    public SdkVersion b() {
        return this.f28108b;
    }

    @Nullable
    public v8 c() {
        return this.f28109c;
    }

    public void d(@Nullable Date date) {
        this.f28110d = date;
    }

    public void e(@Nullable Map<String, Object> map) {
        this.f28111e = map;
    }

    @Override // io.sentry.h2
    public void serialize(@NotNull m3 m3Var, @NotNull w0 w0Var) throws IOException {
        m3Var.h();
        if (this.f28107a != null) {
            m3Var.e("event_id").o(w0Var, this.f28107a);
        }
        if (this.f28108b != null) {
            m3Var.e(ServiceProvider.NAMED_SDK).o(w0Var, this.f28108b);
        }
        if (this.f28109c != null) {
            m3Var.e("trace").o(w0Var, this.f28109c);
        }
        if (this.f28110d != null) {
            m3Var.e("sent_at").o(w0Var, n.h(this.f28110d));
        }
        Map<String, Object> map = this.f28111e;
        if (map != null) {
            for (String str : map.keySet()) {
                Object obj = this.f28111e.get(str);
                m3Var.e(str);
                m3Var.o(w0Var, obj);
            }
        }
        m3Var.k();
    }

    public q5(@Nullable SentryId sentryId, @Nullable SdkVersion sdkVersion, @Nullable v8 v8Var) {
        this.f28107a = sentryId;
        this.f28108b = sdkVersion;
        this.f28109c = v8Var;
    }

    public q5(@Nullable SentryId sentryId) {
        this(sentryId, null);
    }

    public q5() {
        this(new SentryId());
    }
}
