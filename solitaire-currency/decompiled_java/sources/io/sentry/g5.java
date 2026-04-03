package io.sentry;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.VisibleForTesting;

/* JADX INFO: compiled from: SentryAppStartProfilingOptions.java */
/* JADX INFO: loaded from: classes5.dex */
@ApiStatus.Internal
public final class g5 implements h2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    boolean f27826a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    Double f27827b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    boolean f27828c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    Double f27829d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    String f27830e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    boolean f27831f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    boolean f27832g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    int f27833h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    boolean f27834i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    boolean f27835j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    boolean f27836k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @NotNull
    v3 f27837l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @Nullable
    private Map<String, Object> f27838m;

    /* JADX INFO: compiled from: SentryAppStartProfilingOptions.java */
    public static final class a implements x1<g5> {
        @Override // io.sentry.x1
        @NotNull
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public g5 deserialize(@NotNull l3 l3Var, @NotNull w0 w0Var) throws Exception {
            String strC;
            l3Var.h();
            g5 g5Var = new g5();
            ConcurrentHashMap concurrentHashMap = null;
            while (l3Var.peek() == io.sentry.vendor.gson.stream.b.NAME) {
                strC = l3Var.C();
                strC.hashCode();
                switch (strC) {
                    case "is_enable_app_start_profiling":
                        Boolean boolH = l3Var.H();
                        if (boolH != null) {
                            g5Var.f27835j = boolH.booleanValue();
                            break;
                        } else {
                            break;
                        }
                        break;
                    case "trace_sampled":
                        Boolean boolH2 = l3Var.H();
                        if (boolH2 != null) {
                            g5Var.f27828c = boolH2.booleanValue();
                            break;
                        } else {
                            break;
                        }
                        break;
                    case "profiling_traces_dir_path":
                        String strO0 = l3Var.o0();
                        if (strO0 != null) {
                            g5Var.f27830e = strO0;
                            break;
                        } else {
                            break;
                        }
                        break;
                    case "is_continuous_profiling_enabled":
                        Boolean boolH3 = l3Var.H();
                        if (boolH3 != null) {
                            g5Var.f27832g = boolH3.booleanValue();
                            break;
                        } else {
                            break;
                        }
                        break;
                    case "is_profiling_enabled":
                        Boolean boolH4 = l3Var.H();
                        if (boolH4 != null) {
                            g5Var.f27831f = boolH4.booleanValue();
                            break;
                        } else {
                            break;
                        }
                        break;
                    case "is_start_profiler_on_app_start":
                        Boolean boolH5 = l3Var.H();
                        if (boolH5 != null) {
                            g5Var.f27836k = boolH5.booleanValue();
                            break;
                        } else {
                            break;
                        }
                        break;
                    case "profile_sampled":
                        Boolean boolH6 = l3Var.H();
                        if (boolH6 != null) {
                            g5Var.f27826a = boolH6.booleanValue();
                            break;
                        } else {
                            break;
                        }
                        break;
                    case "profile_lifecycle":
                        String strO02 = l3Var.o0();
                        if (strO02 != null) {
                            try {
                                g5Var.f27837l = v3.valueOf(strO02);
                            } catch (IllegalArgumentException unused) {
                                w0Var.c(SentryLevel.ERROR, "Error when deserializing ProfileLifecycle: " + strO02, new Object[0]);
                            }
                            break;
                        } else {
                            break;
                        }
                        break;
                    case "continuous_profile_sampled":
                        Boolean boolH7 = l3Var.H();
                        if (boolH7 != null) {
                            g5Var.f27834i = boolH7.booleanValue();
                            break;
                        } else {
                            break;
                        }
                        break;
                    case "profiling_traces_hz":
                        Integer numG0 = l3Var.g0();
                        if (numG0 != null) {
                            g5Var.f27833h = numG0.intValue();
                            break;
                        } else {
                            break;
                        }
                        break;
                    case "trace_sample_rate":
                        Double dA = l3Var.A();
                        if (dA != null) {
                            g5Var.f27829d = dA;
                            break;
                        } else {
                            break;
                        }
                        break;
                    case "profile_sample_rate":
                        Double dA2 = l3Var.A();
                        if (dA2 != null) {
                            g5Var.f27827b = dA2;
                            break;
                        } else {
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
            g5Var.m(concurrentHashMap);
            l3Var.k();
            return g5Var;
        }
    }

    @VisibleForTesting
    public g5() {
        this.f27828c = false;
        this.f27829d = null;
        this.f27826a = false;
        this.f27827b = null;
        this.f27834i = false;
        this.f27830e = null;
        this.f27831f = false;
        this.f27832g = false;
        this.f27837l = v3.MANUAL;
        this.f27833h = 0;
        this.f27835j = true;
        this.f27836k = false;
    }

    @NotNull
    public v3 a() {
        return this.f27837l;
    }

    @Nullable
    public Double b() {
        return this.f27827b;
    }

    @Nullable
    public String c() {
        return this.f27830e;
    }

    public int d() {
        return this.f27833h;
    }

    @Nullable
    public Double e() {
        return this.f27829d;
    }

    public boolean f() {
        return this.f27834i;
    }

    public boolean g() {
        return this.f27832g;
    }

    public boolean h() {
        return this.f27835j;
    }

    public boolean i() {
        return this.f27826a;
    }

    public boolean j() {
        return this.f27831f;
    }

    public boolean k() {
        return this.f27836k;
    }

    public boolean l() {
        return this.f27828c;
    }

    public void m(@Nullable Map<String, Object> map) {
        this.f27838m = map;
    }

    @Override // io.sentry.h2
    public void serialize(@NotNull m3 m3Var, @NotNull w0 w0Var) throws IOException {
        m3Var.h();
        m3Var.e("profile_sampled").o(w0Var, Boolean.valueOf(this.f27826a));
        m3Var.e("profile_sample_rate").o(w0Var, this.f27827b);
        m3Var.e("continuous_profile_sampled").o(w0Var, Boolean.valueOf(this.f27834i));
        m3Var.e("trace_sampled").o(w0Var, Boolean.valueOf(this.f27828c));
        m3Var.e("trace_sample_rate").o(w0Var, this.f27829d);
        m3Var.e("profiling_traces_dir_path").o(w0Var, this.f27830e);
        m3Var.e("is_profiling_enabled").o(w0Var, Boolean.valueOf(this.f27831f));
        m3Var.e("is_continuous_profiling_enabled").o(w0Var, Boolean.valueOf(this.f27832g));
        m3Var.e("profile_lifecycle").o(w0Var, this.f27837l.name());
        m3Var.e("profiling_traces_hz").o(w0Var, Integer.valueOf(this.f27833h));
        m3Var.e("is_enable_app_start_profiling").o(w0Var, Boolean.valueOf(this.f27835j));
        m3Var.e("is_start_profiler_on_app_start").o(w0Var, Boolean.valueOf(this.f27836k));
        Map<String, Object> map = this.f27838m;
        if (map != null) {
            for (String str : map.keySet()) {
                Object obj = this.f27838m.get(str);
                m3Var.e(str);
                m3Var.o(w0Var, obj);
            }
        }
        m3Var.k();
    }

    g5(@NotNull SentryOptions sentryOptions, @NotNull x8 x8Var) {
        this.f27828c = x8Var.e().booleanValue();
        this.f27829d = x8Var.d();
        this.f27826a = x8Var.b().booleanValue();
        this.f27827b = x8Var.a();
        this.f27834i = sentryOptions.getInternalTracesSampler().c(io.sentry.util.b0.a().d());
        this.f27830e = sentryOptions.getProfilingTracesDirPath();
        this.f27831f = sentryOptions.isProfilingEnabled();
        this.f27832g = sentryOptions.isContinuousProfilingEnabled();
        this.f27837l = sentryOptions.getProfileLifecycle();
        this.f27833h = sentryOptions.getProfilingTracesHz();
        this.f27835j = sentryOptions.isEnableAppStartProfiling();
        this.f27836k = sentryOptions.isStartProfilerOnAppStart();
    }
}
