package io.sentry;

import com.ironsource.v8;
import io.sentry.protocol.SentryId;
import io.sentry.protocol.TransactionNameSource;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Baggage.java */
/* JADX INFO: loaded from: classes5.dex */
@ApiStatus.Experimental
public final class d {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NotNull
    static final Integer f27740i = 8192;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NotNull
    static final Integer f27741j = 64;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final c f27742k = new c();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final ConcurrentHashMap<String, String> f27743a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final io.sentry.util.a f27744b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    private Double f27745c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    private Double f27746d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    private final String f27747e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f27748f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f27749g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NotNull
    final w0 f27750h;

    /* JADX INFO: compiled from: Baggage.java */
    @ApiStatus.Internal
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final List<String> f27751a = Arrays.asList("sentry-trace_id", "sentry-public_key", "sentry-release", "sentry-user_id", "sentry-environment", "sentry-transaction", "sentry-sample_rate", "sentry-sample_rand", "sentry-sampled", "sentry-replay_id");
    }

    /* JADX INFO: compiled from: Baggage.java */
    private static class c extends ThreadLocal<DecimalFormat> {
        private c() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public DecimalFormat initialValue() {
            return new DecimalFormat("#.################", DecimalFormatSymbols.getInstance(Locale.ROOT));
        }
    }

    @ApiStatus.Internal
    public d(@NotNull w0 w0Var) {
        this(new ConcurrentHashMap(), null, null, null, true, false, w0Var);
    }

    @Nullable
    private static String A(@Nullable Double d10) {
        if (io.sentry.util.a0.h(d10, false)) {
            return f27742k.get().format(d10);
        }
        return null;
    }

    @Nullable
    private static Boolean B(@Nullable x8 x8Var) {
        if (x8Var == null) {
            return null;
        }
        return x8Var.e();
    }

    @Nullable
    private static Double P(@Nullable String str) {
        if (str != null) {
            try {
                double d10 = Double.parseDouble(str);
                if (io.sentry.util.a0.h(Double.valueOf(d10), false)) {
                    return Double.valueOf(d10);
                }
            } catch (NumberFormatException unused) {
            }
        }
        return null;
    }

    private static String a(@NotNull String str) throws UnsupportedEncodingException {
        return URLDecoder.decode(str, "UTF-8");
    }

    private String b(@NotNull String str) throws UnsupportedEncodingException {
        return URLEncoder.encode(str, "UTF-8").replaceAll("\\+", "%20");
    }

    @ApiStatus.Internal
    @NotNull
    public static d e(@NotNull i5 i5Var, @Nullable String str, @NotNull SentryOptions sentryOptions) {
        d dVar = new d(sentryOptions.getLogger());
        j8 trace = i5Var.getContexts().getTrace();
        dVar.K(trace != null ? trace.n().toString() : null);
        dVar.E(sentryOptions.retrieveParsedDsn().a());
        dVar.F(i5Var.getRelease());
        dVar.D(i5Var.getEnvironment());
        dVar.L(str);
        dVar.I(null);
        dVar.J(null);
        dVar.H(null);
        Object obj = i5Var.getContexts().get("replay_id");
        if (obj != null && !obj.toString().equals(SentryId.EMPTY_ID.toString())) {
            dVar.G(obj.toString());
            i5Var.getContexts().remove("replay_id");
        }
        dVar.d();
        return dVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00b8  */
    @org.jetbrains.annotations.ApiStatus.Internal
    @org.jetbrains.annotations.NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static io.sentry.d f(@org.jetbrains.annotations.Nullable java.lang.String r17, boolean r18, @org.jetbrains.annotations.NotNull io.sentry.w0 r19) {
        /*
            Method dump skipped, instruction units count: 201
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.d.f(java.lang.String, boolean, io.sentry.w0):io.sentry.d");
    }

    @ApiStatus.Internal
    @NotNull
    public static d g(@Nullable List<String> list, @NotNull w0 w0Var) {
        return h(list, false, w0Var);
    }

    @ApiStatus.Internal
    @NotNull
    public static d h(@Nullable List<String> list, boolean z10, @NotNull w0 w0Var) {
        return list != null ? f(io.sentry.util.d0.f(",", list), z10, w0Var) : f(null, z10, w0Var);
    }

    private static boolean v(@Nullable TransactionNameSource transactionNameSource) {
        return (transactionNameSource == null || TransactionNameSource.URL.equals(transactionNameSource)) ? false : true;
    }

    @Nullable
    private static Double y(@Nullable x8 x8Var) {
        if (x8Var == null) {
            return null;
        }
        return x8Var.c();
    }

    @Nullable
    private static Double z(@Nullable x8 x8Var) {
        if (x8Var == null) {
            return null;
        }
        return x8Var.d();
    }

    @ApiStatus.Internal
    public void C(@NotNull String str, @Nullable String str2) {
        if (this.f27748f) {
            if (str2 == null) {
                this.f27743a.remove(str);
            } else {
                this.f27743a.put(str, str2);
            }
        }
    }

    @ApiStatus.Internal
    public void D(@Nullable String str) {
        C("sentry-environment", str);
    }

    @ApiStatus.Internal
    public void E(@Nullable String str) {
        C("sentry-public_key", str);
    }

    @ApiStatus.Internal
    public void F(@Nullable String str) {
        C("sentry-release", str);
    }

    @ApiStatus.Internal
    public void G(@Nullable String str) {
        C("sentry-replay_id", str);
    }

    @ApiStatus.Internal
    public void H(@Nullable Double d10) {
        if (w()) {
            this.f27746d = d10;
        }
    }

    @ApiStatus.Internal
    public void I(@Nullable Double d10) {
        if (w()) {
            this.f27745c = d10;
        }
    }

    @ApiStatus.Internal
    public void J(@Nullable String str) {
        C("sentry-sampled", str);
    }

    @ApiStatus.Internal
    public void K(@Nullable String str) {
        C("sentry-trace_id", str);
    }

    @ApiStatus.Internal
    public void L(@Nullable String str) {
        C("sentry-transaction", str);
    }

    @ApiStatus.Internal
    public void M(@Nullable x8 x8Var) {
        if (x8Var == null) {
            return;
        }
        J(io.sentry.util.d0.i(B(x8Var)));
        if (x8Var.c() != null) {
            H(y(x8Var));
        }
        if (x8Var.d() != null) {
            c(z(x8Var));
        }
    }

    @ApiStatus.Internal
    public void N(@NotNull c1 c1Var, @NotNull SentryOptions sentryOptions) {
        z3 propagationContext = c1Var.getPropagationContext();
        SentryId replayId = c1Var.getReplayId();
        K(propagationContext.h().toString());
        E(sentryOptions.retrieveParsedDsn().a());
        F(sentryOptions.getRelease());
        D(sentryOptions.getEnvironment());
        if (!SentryId.EMPTY_ID.equals(replayId)) {
            G(replayId.toString());
        }
        L(null);
        I(null);
        J(null);
    }

    @ApiStatus.Internal
    public void O(@NotNull SentryId sentryId, @Nullable SentryId sentryId2, @NotNull SentryOptions sentryOptions, @Nullable x8 x8Var, @Nullable String str, @Nullable TransactionNameSource transactionNameSource) {
        K(sentryId.toString());
        E(sentryOptions.retrieveParsedDsn().a());
        F(sentryOptions.getRelease());
        D(sentryOptions.getEnvironment());
        if (!v(transactionNameSource)) {
            str = null;
        }
        L(str);
        if (sentryId2 != null && !SentryId.EMPTY_ID.equals(sentryId2)) {
            G(sentryId2.toString());
        }
        I(z(x8Var));
        J(io.sentry.util.d0.i(B(x8Var)));
        H(y(x8Var));
    }

    @NotNull
    public String Q(@Nullable String str) {
        String str2;
        int iD;
        String str3;
        char c10;
        StringBuilder sb = new StringBuilder();
        String str4 = ",";
        char c11 = 1;
        if (str == null || str.isEmpty()) {
            str2 = "";
            iD = 0;
        } else {
            sb.append(str);
            iD = io.sentry.util.d0.d(str, ',') + 1;
            str2 = ",";
        }
        k1 k1VarA = this.f27744b.a();
        try {
            TreeSet<String> treeSet = new TreeSet(Collections.list(this.f27743a.keys()));
            if (k1VarA != null) {
                k1VarA.close();
            }
            treeSet.add("sentry-sample_rate");
            treeSet.add("sentry-sample_rand");
            String str5 = str2;
            int i10 = iD;
            for (String str6 : treeSet) {
                String strA = "sentry-sample_rate".equals(str6) ? A(this.f27745c) : "sentry-sample_rand".equals(str6) ? A(this.f27746d) : this.f27743a.get(str6);
                if (strA != null) {
                    Integer num = f27741j;
                    if (i10 >= num.intValue()) {
                        w0 w0Var = this.f27750h;
                        SentryLevel sentryLevel = SentryLevel.ERROR;
                        Object[] objArr = new Object[2];
                        objArr[0] = str6;
                        objArr[c11] = num;
                        w0Var.c(sentryLevel, "Not adding baggage value %s as the total number of list members would exceed the maximum of %s.", objArr);
                        str3 = str4;
                        c10 = c11;
                    } else {
                        try {
                            String str7 = str5 + b(str6) + v8.i.f15833b + b(strA);
                            int length = sb.length() + str7.length();
                            Integer num2 = f27740i;
                            if (length > num2.intValue()) {
                                str3 = str4;
                                try {
                                    this.f27750h.c(SentryLevel.ERROR, "Not adding baggage value %s as the total header value length would exceed the maximum of %s.", str6, num2);
                                } catch (Throwable th) {
                                    th = th;
                                    c10 = 1;
                                    this.f27750h.a(SentryLevel.ERROR, th, "Unable to encode baggage key value pair (key=%s,value=%s).", str6, strA);
                                }
                            } else {
                                str3 = str4;
                                i10++;
                                sb.append(str7);
                                str5 = str3;
                            }
                            c10 = 1;
                        } catch (Throwable th2) {
                            th = th2;
                            str3 = str4;
                        }
                    }
                } else {
                    str3 = str4;
                    c10 = c11;
                }
                c11 = c10;
                str4 = str3;
            }
            return sb.toString();
        } finally {
        }
    }

    @ApiStatus.Internal
    @Nullable
    public v8 R() {
        String strR = r();
        String strM = m();
        String strK = k();
        if (strR == null || strK == null) {
            return null;
        }
        v8 v8Var = new v8(new SentryId(strR), strK, l(), j(), u(), s(), A(o()), p(), strM == null ? null : new SentryId(strM), A(n()));
        v8Var.c(t());
        return v8Var;
    }

    @ApiStatus.Internal
    public void c(@Nullable Double d10) {
        this.f27745c = d10;
    }

    @ApiStatus.Internal
    public void d() {
        this.f27748f = false;
    }

    @ApiStatus.Internal
    @Nullable
    public String i(@Nullable String str) {
        if (str == null) {
            return null;
        }
        return this.f27743a.get(str);
    }

    @ApiStatus.Internal
    @Nullable
    public String j() {
        return i("sentry-environment");
    }

    @ApiStatus.Internal
    @Nullable
    public String k() {
        return i("sentry-public_key");
    }

    @ApiStatus.Internal
    @Nullable
    public String l() {
        return i("sentry-release");
    }

    @ApiStatus.Internal
    @Nullable
    public String m() {
        return i("sentry-replay_id");
    }

    @ApiStatus.Internal
    @Nullable
    public Double n() {
        return this.f27746d;
    }

    @ApiStatus.Internal
    @Nullable
    public Double o() {
        return this.f27745c;
    }

    @ApiStatus.Internal
    @Nullable
    public String p() {
        return i("sentry-sampled");
    }

    @Nullable
    public String q() {
        return this.f27747e;
    }

    @ApiStatus.Internal
    @Nullable
    public String r() {
        return i("sentry-trace_id");
    }

    @ApiStatus.Internal
    @Nullable
    public String s() {
        return i("sentry-transaction");
    }

    @ApiStatus.Internal
    @NotNull
    public Map<String, Object> t() {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        k1 k1VarA = this.f27744b.a();
        try {
            for (Map.Entry<String, String> entry : this.f27743a.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                if (!b.f27751a.contains(key) && value != null) {
                    concurrentHashMap.put(key.replaceFirst("sentry-", ""), value);
                }
            }
            if (k1VarA != null) {
                k1VarA.close();
            }
            return concurrentHashMap;
        } catch (Throwable th) {
            if (k1VarA != null) {
                try {
                    k1VarA.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    @ApiStatus.Internal
    @Nullable
    public String u() {
        return i("sentry-user_id");
    }

    @ApiStatus.Internal
    public boolean w() {
        return this.f27748f;
    }

    @ApiStatus.Internal
    public boolean x() {
        return this.f27749g;
    }

    @ApiStatus.Internal
    public d(@NotNull ConcurrentHashMap<String, String> concurrentHashMap, @Nullable Double d10, @Nullable Double d11, @Nullable String str, boolean z10, boolean z11, @NotNull w0 w0Var) {
        this.f27744b = new io.sentry.util.a();
        this.f27743a = concurrentHashMap;
        this.f27745c = d10;
        this.f27746d = d11;
        this.f27750h = w0Var;
        this.f27747e = str;
        this.f27748f = z10;
        this.f27749g = z11;
    }
}
