package io.sentry;

import io.sentry.profilemeasurements.a;
import io.sentry.protocol.DebugMeta;
import io.sentry.protocol.SdkVersion;
import io.sentry.protocol.SentryId;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ProfileChunk.java */
/* JADX INFO: loaded from: classes5.dex */
@ApiStatus.Internal
public final class t3 implements h2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    private DebugMeta f28229a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private SentryId f28230b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private SentryId f28231c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    private SdkVersion f28232d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    private final Map<String, io.sentry.profilemeasurements.a> f28233e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    private String f28234f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NotNull
    private String f28235g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Nullable
    private String f28236h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NotNull
    private String f28237i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private double f28238j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @NotNull
    private final File f28239k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @Nullable
    private String f28240l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @Nullable
    private Map<String, Object> f28241m;

    /* JADX INFO: compiled from: ProfileChunk.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        private final SentryId f28242a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @NotNull
        private final SentryId f28243b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @NotNull
        private final Map<String, io.sentry.profilemeasurements.a> f28244c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @NotNull
        private final File f28245d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final double f28246e;

        public a(@NotNull SentryId sentryId, @NotNull SentryId sentryId2, @NotNull Map<String, io.sentry.profilemeasurements.a> map, @NotNull File file, @NotNull n5 n5Var) {
            this.f28242a = sentryId;
            this.f28243b = sentryId2;
            this.f28244c = new ConcurrentHashMap(map);
            this.f28245d = file;
            this.f28246e = n.m(n5Var.g());
        }

        public t3 a(SentryOptions sentryOptions) {
            return new t3(this.f28242a, this.f28243b, this.f28245d, this.f28244c, Double.valueOf(this.f28246e), sentryOptions);
        }
    }

    /* JADX INFO: compiled from: ProfileChunk.java */
    public static final class b implements x1<t3> {
        @Override // io.sentry.x1
        @NotNull
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public t3 deserialize(@NotNull l3 l3Var, @NotNull w0 w0Var) throws Exception {
            String strC;
            l3Var.h();
            t3 t3Var = new t3();
            ConcurrentHashMap concurrentHashMap = null;
            while (l3Var.peek() == io.sentry.vendor.gson.stream.b.NAME) {
                strC = l3Var.C();
                strC.hashCode();
                switch (strC) {
                    case "debug_meta":
                        DebugMeta debugMeta = (DebugMeta) l3Var.M(w0Var, new DebugMeta.Deserializer());
                        if (debugMeta == null) {
                            break;
                        } else {
                            t3Var.f28229a = debugMeta;
                            break;
                        }
                        break;
                    case "measurements":
                        Map mapQ0 = l3Var.q0(w0Var, new a.C0585a());
                        if (mapQ0 == null) {
                            break;
                        } else {
                            t3Var.f28233e.putAll(mapQ0);
                            break;
                        }
                        break;
                    case "environment":
                        String strO0 = l3Var.o0();
                        if (strO0 == null) {
                            break;
                        } else {
                            t3Var.f28236h = strO0;
                            break;
                        }
                        break;
                    case "timestamp":
                        Double dA = l3Var.A();
                        if (dA == null) {
                            break;
                        } else {
                            t3Var.f28238j = dA.doubleValue();
                            break;
                        }
                        break;
                    case "profiler_id":
                        SentryId sentryId = (SentryId) l3Var.M(w0Var, new SentryId.Deserializer());
                        if (sentryId == null) {
                            break;
                        } else {
                            t3Var.f28230b = sentryId;
                            break;
                        }
                        break;
                    case "version":
                        String strO02 = l3Var.o0();
                        if (strO02 == null) {
                            break;
                        } else {
                            t3Var.f28237i = strO02;
                            break;
                        }
                        break;
                    case "release":
                        String strO03 = l3Var.o0();
                        if (strO03 == null) {
                            break;
                        } else {
                            t3Var.f28235g = strO03;
                            break;
                        }
                        break;
                    case "client_sdk":
                        SdkVersion sdkVersion = (SdkVersion) l3Var.M(w0Var, new SdkVersion.Deserializer());
                        if (sdkVersion == null) {
                            break;
                        } else {
                            t3Var.f28232d = sdkVersion;
                            break;
                        }
                        break;
                    case "platform":
                        String strO04 = l3Var.o0();
                        if (strO04 == null) {
                            break;
                        } else {
                            t3Var.f28234f = strO04;
                            break;
                        }
                        break;
                    case "sampled_profile":
                        String strO05 = l3Var.o0();
                        if (strO05 == null) {
                            break;
                        } else {
                            t3Var.f28240l = strO05;
                            break;
                        }
                        break;
                    case "chunk_id":
                        SentryId sentryId2 = (SentryId) l3Var.M(w0Var, new SentryId.Deserializer());
                        if (sentryId2 == null) {
                            break;
                        } else {
                            t3Var.f28231c = sentryId2;
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
            t3Var.r(concurrentHashMap);
            l3Var.k();
            return t3Var;
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public t3() {
        SentryId sentryId = SentryId.EMPTY_ID;
        this(sentryId, sentryId, new File("dummy"), new HashMap(), Double.valueOf(0.0d), SentryOptions.empty());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof t3)) {
            return false;
        }
        t3 t3Var = (t3) obj;
        return Objects.equals(this.f28229a, t3Var.f28229a) && Objects.equals(this.f28230b, t3Var.f28230b) && Objects.equals(this.f28231c, t3Var.f28231c) && Objects.equals(this.f28232d, t3Var.f28232d) && Objects.equals(this.f28233e, t3Var.f28233e) && Objects.equals(this.f28234f, t3Var.f28234f) && Objects.equals(this.f28235g, t3Var.f28235g) && Objects.equals(this.f28236h, t3Var.f28236h) && Objects.equals(this.f28237i, t3Var.f28237i) && Objects.equals(this.f28240l, t3Var.f28240l) && Objects.equals(this.f28241m, t3Var.f28241m);
    }

    public int hashCode() {
        return Objects.hash(this.f28229a, this.f28230b, this.f28231c, this.f28232d, this.f28233e, this.f28234f, this.f28235g, this.f28236h, this.f28237i, this.f28240l, this.f28241m);
    }

    @NotNull
    public SentryId l() {
        return this.f28231c;
    }

    @Nullable
    public DebugMeta m() {
        return this.f28229a;
    }

    @NotNull
    public String n() {
        return this.f28234f;
    }

    @NotNull
    public File o() {
        return this.f28239k;
    }

    public void p(@Nullable DebugMeta debugMeta) {
        this.f28229a = debugMeta;
    }

    public void q(@Nullable String str) {
        this.f28240l = str;
    }

    public void r(@Nullable Map<String, Object> map) {
        this.f28241m = map;
    }

    @Override // io.sentry.h2
    public void serialize(@NotNull m3 m3Var, @NotNull w0 w0Var) throws IOException {
        m3Var.h();
        if (this.f28229a != null) {
            m3Var.e("debug_meta").o(w0Var, this.f28229a);
        }
        m3Var.e("profiler_id").o(w0Var, this.f28230b);
        m3Var.e("chunk_id").o(w0Var, this.f28231c);
        if (this.f28232d != null) {
            m3Var.e("client_sdk").o(w0Var, this.f28232d);
        }
        if (!this.f28233e.isEmpty()) {
            String strI = m3Var.i();
            m3Var.m("");
            m3Var.e("measurements").o(w0Var, this.f28233e);
            m3Var.m(strI);
        }
        m3Var.e("platform").o(w0Var, this.f28234f);
        m3Var.e("release").o(w0Var, this.f28235g);
        if (this.f28236h != null) {
            m3Var.e("environment").o(w0Var, this.f28236h);
        }
        m3Var.e("version").o(w0Var, this.f28237i);
        if (this.f28240l != null) {
            m3Var.e("sampled_profile").o(w0Var, this.f28240l);
        }
        m3Var.e("timestamp").o(w0Var, Double.valueOf(this.f28238j));
        Map<String, Object> map = this.f28241m;
        if (map != null) {
            for (String str : map.keySet()) {
                m3Var.e(str).o(w0Var, this.f28241m.get(str));
            }
        }
        m3Var.k();
    }

    public t3(@NotNull SentryId sentryId, @NotNull SentryId sentryId2, @NotNull File file, @NotNull Map<String, io.sentry.profilemeasurements.a> map, @NotNull Double d10, @NotNull SentryOptions sentryOptions) {
        this.f28240l = null;
        this.f28230b = sentryId;
        this.f28231c = sentryId2;
        this.f28239k = file;
        this.f28233e = map;
        this.f28229a = null;
        this.f28232d = sentryOptions.getSdkVersion();
        this.f28235g = sentryOptions.getRelease() != null ? sentryOptions.getRelease() : "";
        this.f28236h = sentryOptions.getEnvironment();
        this.f28234f = "android";
        this.f28237i = "2";
        this.f28238j = d10.doubleValue();
    }
}
