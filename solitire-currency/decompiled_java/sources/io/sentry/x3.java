package io.sentry;

import com.applovin.sdk.AppLovinEventParameters;
import io.sentry.profilemeasurements.a;
import io.sentry.protocol.SentrySpan;
import io.sentry.y3;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ProfilingTraceData.java */
/* JADX INFO: loaded from: classes5.dex */
@ApiStatus.Internal
public final class x3 implements h2 {

    @NotNull
    private final Map<String, io.sentry.profilemeasurements.a> A;

    @Nullable
    private String B;

    @Nullable
    private Map<String, Object> C;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final File f28460a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final Callable<List<Integer>> f28461b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f28462c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private String f28463d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    private String f28464e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    private String f28465f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NotNull
    private String f28466g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NotNull
    private String f28467h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NotNull
    private String f28468i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f28469j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @NotNull
    private String f28470k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @NotNull
    private List<Integer> f28471l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @NotNull
    private String f28472m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @NotNull
    private String f28473n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @NotNull
    private String f28474o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @NotNull
    private List<y3> f28475p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @NotNull
    private String f28476q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @NotNull
    private String f28477r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @NotNull
    private String f28478s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @NotNull
    private String f28479t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    @NotNull
    private String f28480u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    @NotNull
    private String f28481v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    @NotNull
    private String f28482w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @NotNull
    private String f28483x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    @NotNull
    private String f28484y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    @NotNull
    private Date f28485z;

    /* JADX INFO: compiled from: ProfilingTraceData.java */
    public static final class b implements x1<x3> {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.sentry.x1
        @NotNull
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public x3 deserialize(@NotNull l3 l3Var, @NotNull w0 w0Var) throws Exception {
            String strC;
            l3Var.h();
            ConcurrentHashMap concurrentHashMap = null;
            x3 x3Var = new x3();
            while (l3Var.peek() == io.sentry.vendor.gson.stream.b.NAME) {
                strC = l3Var.C();
                strC.hashCode();
                switch (strC) {
                    case "device_manufacturer":
                        String strO0 = l3Var.o0();
                        if (strO0 == null) {
                            break;
                        } else {
                            x3Var.f28464e = strO0;
                            break;
                        }
                        break;
                    case "android_api_level":
                        Integer numG0 = l3Var.g0();
                        if (numG0 == null) {
                            break;
                        } else {
                            x3Var.f28462c = numG0.intValue();
                            break;
                        }
                        break;
                    case "build_id":
                        String strO02 = l3Var.o0();
                        if (strO02 == null) {
                            break;
                        } else {
                            x3Var.f28474o = strO02;
                            break;
                        }
                        break;
                    case "device_locale":
                        String strO03 = l3Var.o0();
                        if (strO03 == null) {
                            break;
                        } else {
                            x3Var.f28463d = strO03;
                            break;
                        }
                        break;
                    case "profile_id":
                        String strO04 = l3Var.o0();
                        if (strO04 == null) {
                            break;
                        } else {
                            x3Var.f28482w = strO04;
                            break;
                        }
                        break;
                    case "device_os_build_number":
                        String strO05 = l3Var.o0();
                        if (strO05 == null) {
                            break;
                        } else {
                            x3Var.f28466g = strO05;
                            break;
                        }
                        break;
                    case "device_model":
                        String strO06 = l3Var.o0();
                        if (strO06 == null) {
                            break;
                        } else {
                            x3Var.f28465f = strO06;
                            break;
                        }
                        break;
                    case "device_is_emulator":
                        Boolean boolH = l3Var.H();
                        if (boolH == null) {
                            break;
                        } else {
                            x3Var.f28469j = boolH.booleanValue();
                            break;
                        }
                        break;
                    case "duration_ns":
                        String strO07 = l3Var.o0();
                        if (strO07 == null) {
                            break;
                        } else {
                            x3Var.f28477r = strO07;
                            break;
                        }
                        break;
                    case "measurements":
                        Map mapQ0 = l3Var.q0(w0Var, new a.C0585a());
                        if (mapQ0 == null) {
                            break;
                        } else {
                            x3Var.A.putAll(mapQ0);
                            break;
                        }
                        break;
                    case "device_physical_memory_bytes":
                        String strO08 = l3Var.o0();
                        if (strO08 == null) {
                            break;
                        } else {
                            x3Var.f28472m = strO08;
                            break;
                        }
                        break;
                    case "device_cpu_frequencies":
                        List list = (List) l3Var.A0();
                        if (list == null) {
                            break;
                        } else {
                            x3Var.f28471l = list;
                            break;
                        }
                        break;
                    case "version_code":
                        String strO09 = l3Var.o0();
                        if (strO09 == null) {
                            break;
                        } else {
                            x3Var.f28478s = strO09;
                            break;
                        }
                        break;
                    case "version_name":
                        String strO010 = l3Var.o0();
                        if (strO010 == null) {
                            break;
                        } else {
                            x3Var.f28479t = strO010;
                            break;
                        }
                        break;
                    case "environment":
                        String strO011 = l3Var.o0();
                        if (strO011 == null) {
                            break;
                        } else {
                            x3Var.f28483x = strO011;
                            break;
                        }
                        break;
                    case "timestamp":
                        Date dateF = l3Var.F(w0Var);
                        if (dateF == null) {
                            break;
                        } else {
                            x3Var.f28485z = dateF;
                            break;
                        }
                        break;
                    case "transaction_name":
                        String strO012 = l3Var.o0();
                        if (strO012 == null) {
                            break;
                        } else {
                            x3Var.f28476q = strO012;
                            break;
                        }
                        break;
                    case "device_os_name":
                        String strO013 = l3Var.o0();
                        if (strO013 == null) {
                            break;
                        } else {
                            x3Var.f28467h = strO013;
                            break;
                        }
                        break;
                    case "architecture":
                        String strO014 = l3Var.o0();
                        if (strO014 == null) {
                            break;
                        } else {
                            x3Var.f28470k = strO014;
                            break;
                        }
                        break;
                    case "transaction_id":
                        String strO015 = l3Var.o0();
                        if (strO015 == null) {
                            break;
                        } else {
                            x3Var.f28480u = strO015;
                            break;
                        }
                        break;
                    case "device_os_version":
                        String strO016 = l3Var.o0();
                        if (strO016 == null) {
                            break;
                        } else {
                            x3Var.f28468i = strO016;
                            break;
                        }
                        break;
                    case "truncation_reason":
                        String strO017 = l3Var.o0();
                        if (strO017 == null) {
                            break;
                        } else {
                            x3Var.f28484y = strO017;
                            break;
                        }
                        break;
                    case "trace_id":
                        String strO018 = l3Var.o0();
                        if (strO018 == null) {
                            break;
                        } else {
                            x3Var.f28481v = strO018;
                            break;
                        }
                        break;
                    case "platform":
                        String strO019 = l3Var.o0();
                        if (strO019 == null) {
                            break;
                        } else {
                            x3Var.f28473n = strO019;
                            break;
                        }
                        break;
                    case "sampled_profile":
                        String strO020 = l3Var.o0();
                        if (strO020 == null) {
                            break;
                        } else {
                            x3Var.B = strO020;
                            break;
                        }
                        break;
                    case "transactions":
                        List listD0 = l3Var.D0(w0Var, new y3.a());
                        if (listD0 == null) {
                            break;
                        } else {
                            x3Var.f28475p.addAll(listD0);
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
            x3Var.H(concurrentHashMap);
            l3Var.k();
            return x3Var;
        }
    }

    private boolean D() {
        return this.f28484y.equals("normal") || this.f28484y.equals("timeout") || this.f28484y.equals("backgrounded");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ List E() throws Exception {
        return new ArrayList();
    }

    @NotNull
    public String B() {
        return this.f28482w;
    }

    @NotNull
    public File C() {
        return this.f28460a;
    }

    public void F() {
        try {
            this.f28471l = this.f28461b.call();
        } catch (Throwable unused) {
        }
    }

    public void G(@Nullable String str) {
        this.B = str;
    }

    public void H(@Nullable Map<String, Object> map) {
        this.C = map;
    }

    @Override // io.sentry.h2
    public void serialize(@NotNull m3 m3Var, @NotNull w0 w0Var) throws IOException {
        m3Var.h();
        m3Var.e("android_api_level").o(w0Var, Integer.valueOf(this.f28462c));
        m3Var.e("device_locale").o(w0Var, this.f28463d);
        m3Var.e("device_manufacturer").g(this.f28464e);
        m3Var.e("device_model").g(this.f28465f);
        m3Var.e("device_os_build_number").g(this.f28466g);
        m3Var.e("device_os_name").g(this.f28467h);
        m3Var.e("device_os_version").g(this.f28468i);
        m3Var.e("device_is_emulator").c(this.f28469j);
        m3Var.e("architecture").o(w0Var, this.f28470k);
        m3Var.e("device_cpu_frequencies").o(w0Var, this.f28471l);
        m3Var.e("device_physical_memory_bytes").g(this.f28472m);
        m3Var.e("platform").g(this.f28473n);
        m3Var.e("build_id").g(this.f28474o);
        m3Var.e("transaction_name").g(this.f28476q);
        m3Var.e("duration_ns").g(this.f28477r);
        m3Var.e("version_name").g(this.f28479t);
        m3Var.e("version_code").g(this.f28478s);
        if (!this.f28475p.isEmpty()) {
            m3Var.e("transactions").o(w0Var, this.f28475p);
        }
        m3Var.e(AppLovinEventParameters.CHECKOUT_TRANSACTION_IDENTIFIER).g(this.f28480u);
        m3Var.e(SentrySpan.JsonKeys.TRACE_ID).g(this.f28481v);
        m3Var.e("profile_id").g(this.f28482w);
        m3Var.e("environment").g(this.f28483x);
        m3Var.e("truncation_reason").g(this.f28484y);
        if (this.B != null) {
            m3Var.e("sampled_profile").g(this.B);
        }
        String strI = m3Var.i();
        m3Var.m("");
        m3Var.e("measurements").o(w0Var, this.A);
        m3Var.m(strI);
        m3Var.e("timestamp").o(w0Var, this.f28485z);
        Map<String, Object> map = this.C;
        if (map != null) {
            for (String str : map.keySet()) {
                Object obj = this.C.get(str);
                m3Var.e(str);
                m3Var.o(w0Var, obj);
            }
        }
        m3Var.k();
    }

    private x3() {
        this(new File("dummy"), g3.v());
    }

    public x3(@NotNull File file, @NotNull p1 p1Var) {
        this(file, n.d(), new ArrayList(), p1Var.getName(), p1Var.getEventId().toString(), p1Var.r().n().toString(), "0", 0, "", new Callable() { // from class: io.sentry.w3
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return x3.E();
            }
        }, null, null, null, null, null, null, null, null, "normal", new HashMap());
    }

    public x3(@NotNull File file, @NotNull Date date, @NotNull List<y3> list, @NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, int i10, @NotNull String str5, @NotNull Callable<List<Integer>> callable, @Nullable String str6, @Nullable String str7, @Nullable String str8, @Nullable Boolean bool, @Nullable String str9, @Nullable String str10, @Nullable String str11, @Nullable String str12, @NotNull String str13, @NotNull Map<String, io.sentry.profilemeasurements.a> map) {
        this.f28471l = new ArrayList();
        this.B = null;
        this.f28460a = file;
        this.f28485z = date;
        this.f28470k = str5;
        this.f28461b = callable;
        this.f28462c = i10;
        this.f28463d = Locale.getDefault().toString();
        this.f28464e = str6 != null ? str6 : "";
        this.f28465f = str7 != null ? str7 : "";
        this.f28468i = str8 != null ? str8 : "";
        this.f28469j = bool != null ? bool.booleanValue() : false;
        this.f28472m = str9 != null ? str9 : "0";
        this.f28466g = "";
        this.f28467h = "android";
        this.f28473n = "android";
        this.f28474o = str10 != null ? str10 : "";
        this.f28475p = list;
        this.f28476q = str.isEmpty() ? "unknown" : str;
        this.f28477r = str4;
        this.f28478s = "";
        this.f28479t = str11 != null ? str11 : "";
        this.f28480u = str2;
        this.f28481v = str3;
        this.f28482w = c8.a();
        this.f28483x = str12 != null ? str12 : "production";
        this.f28484y = str13;
        if (!D()) {
            this.f28484y = "normal";
        }
        this.A = map;
    }
}
