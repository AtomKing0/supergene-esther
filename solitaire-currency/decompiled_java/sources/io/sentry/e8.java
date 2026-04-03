package io.sentry;

import com.ironsource.v8;
import io.sentry.protocol.User;
import java.io.IOException;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Session.java */
/* JADX INFO: loaded from: classes5.dex */
public final class e8 implements h2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final Date f27784a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    private Date f27785b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final AtomicInteger f27786c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    private final String f27787d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    private final String f27788e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    private Boolean f27789f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NotNull
    private b f27790g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Nullable
    private Long f27791h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    private Double f27792i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Nullable
    private final String f27793j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @Nullable
    private String f27794k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @Nullable
    private final String f27795l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @NotNull
    private final String f27796m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @Nullable
    private String f27797n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @NotNull
    private final io.sentry.util.a f27798o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @Nullable
    private Map<String, Object> f27799p;

    /* JADX INFO: compiled from: Session.java */
    public static final class a implements x1<e8> {
        private Exception b(String str, w0 w0Var) {
            String str2 = "Missing required field \"" + str + "\"";
            IllegalStateException illegalStateException = new IllegalStateException(str2);
            w0Var.b(SentryLevel.ERROR, str2, illegalStateException);
            return illegalStateException;
        }

        @Override // io.sentry.x1
        @NotNull
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public e8 deserialize(@NotNull l3 l3Var, @NotNull w0 w0Var) throws Exception {
            String strC;
            Long l10;
            l3Var.h();
            Integer numG0 = null;
            b bVarValueOf = null;
            Date dateF = null;
            Date dateF2 = null;
            String strO0 = null;
            String str = null;
            Boolean boolH = null;
            Long lJ0 = null;
            Double dA = null;
            String strO02 = null;
            String strO03 = null;
            ConcurrentHashMap concurrentHashMap = null;
            String strO04 = null;
            String strO05 = null;
            String strO06 = null;
            while (true) {
                String str2 = strO03;
                String str3 = strO02;
                Double d10 = dA;
                if (l3Var.peek() != io.sentry.vendor.gson.stream.b.NAME) {
                    Long l11 = lJ0;
                    if (bVarValueOf == null) {
                        throw b("status", w0Var);
                    }
                    if (dateF == null) {
                        throw b(v8.h.f15786d0, w0Var);
                    }
                    if (numG0 == null) {
                        throw b("errors", w0Var);
                    }
                    if (strO05 == null) {
                        throw b("release", w0Var);
                    }
                    e8 e8Var = new e8(bVarValueOf, dateF, dateF2, numG0.intValue(), strO0, str, boolH, l11, d10, str3, str2, strO04, strO05, strO06);
                    e8Var.o(concurrentHashMap);
                    l3Var.k();
                    return e8Var;
                }
                strC = l3Var.C();
                strC.hashCode();
                l10 = lJ0;
                switch (strC) {
                    case "duration":
                        dA = l3Var.A();
                        strO03 = str2;
                        strO02 = str3;
                        lJ0 = l10;
                        break;
                    case "started":
                        dateF = l3Var.F(w0Var);
                        strO03 = str2;
                        strO02 = str3;
                        dA = d10;
                        lJ0 = l10;
                        break;
                    case "errors":
                        numG0 = l3Var.g0();
                        strO03 = str2;
                        strO02 = str3;
                        dA = d10;
                        lJ0 = l10;
                        break;
                    case "status":
                        String strC2 = io.sentry.util.d0.c(l3Var.o0());
                        if (strC2 != null) {
                            bVarValueOf = b.valueOf(strC2);
                        }
                        strO03 = str2;
                        strO02 = str3;
                        dA = d10;
                        lJ0 = l10;
                        break;
                    case "did":
                        strO0 = l3Var.o0();
                        strO03 = str2;
                        strO02 = str3;
                        dA = d10;
                        lJ0 = l10;
                        break;
                    case "seq":
                        lJ0 = l3Var.j0();
                        strO03 = str2;
                        strO02 = str3;
                        dA = d10;
                        break;
                    case "sid":
                        String strO07 = l3Var.o0();
                        if (strO07 == null || !(strO07.length() == 36 || strO07.length() == 32)) {
                            w0Var.c(SentryLevel.ERROR, "%s sid is not valid.", strO07);
                        } else {
                            str = strO07;
                        }
                        strO03 = str2;
                        strO02 = str3;
                        dA = d10;
                        lJ0 = l10;
                        break;
                    case "init":
                        boolH = l3Var.H();
                        strO03 = str2;
                        strO02 = str3;
                        dA = d10;
                        lJ0 = l10;
                        break;
                    case "timestamp":
                        dateF2 = l3Var.F(w0Var);
                        strO03 = str2;
                        strO02 = str3;
                        dA = d10;
                        lJ0 = l10;
                        break;
                    case "attrs":
                        l3Var.h();
                        strO03 = str2;
                        strO02 = str3;
                        while (l3Var.peek() == io.sentry.vendor.gson.stream.b.NAME) {
                            String strC3 = l3Var.C();
                            strC3.hashCode();
                            switch (strC3) {
                                case "environment":
                                    strO04 = l3Var.o0();
                                    break;
                                case "release":
                                    strO05 = l3Var.o0();
                                    break;
                                case "ip_address":
                                    strO02 = l3Var.o0();
                                    break;
                                case "user_agent":
                                    strO03 = l3Var.o0();
                                    break;
                                default:
                                    l3Var.p();
                                    break;
                            }
                        }
                        l3Var.k();
                        dA = d10;
                        lJ0 = l10;
                        break;
                    case "abnormal_mechanism":
                        strO06 = l3Var.o0();
                        strO03 = str2;
                        strO02 = str3;
                        dA = d10;
                        lJ0 = l10;
                        break;
                    default:
                        if (concurrentHashMap == null) {
                            concurrentHashMap = new ConcurrentHashMap();
                        }
                        l3Var.r0(w0Var, concurrentHashMap, strC);
                        strO03 = str2;
                        strO02 = str3;
                        dA = d10;
                        lJ0 = l10;
                        break;
                }
            }
        }
    }

    /* JADX INFO: compiled from: Session.java */
    public enum b {
        Ok,
        Exited,
        Crashed,
        Abnormal
    }

    public e8(@NotNull b bVar, @NotNull Date date, @Nullable Date date2, int i10, @Nullable String str, @Nullable String str2, @Nullable Boolean bool, @Nullable Long l10, @Nullable Double d10, @Nullable String str3, @Nullable String str4, @Nullable String str5, @NotNull String str6, @Nullable String str7) {
        this.f27798o = new io.sentry.util.a();
        this.f27790g = bVar;
        this.f27784a = date;
        this.f27785b = date2;
        this.f27786c = new AtomicInteger(i10);
        this.f27787d = str;
        this.f27788e = str2;
        this.f27789f = bool;
        this.f27791h = l10;
        this.f27792i = d10;
        this.f27793j = str3;
        this.f27794k = str4;
        this.f27795l = str5;
        this.f27796m = str6;
        this.f27797n = str7;
    }

    private double a(@NotNull Date date) {
        return Math.abs(date.getTime() - this.f27784a.getTime()) / 1000.0d;
    }

    private long i(@NotNull Date date) {
        long time = date.getTime();
        return time < 0 ? Math.abs(time) : time;
    }

    @NotNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public e8 clone() {
        return new e8(this.f27790g, this.f27784a, this.f27785b, this.f27786c.get(), this.f27787d, this.f27788e, this.f27789f, this.f27791h, this.f27792i, this.f27793j, this.f27794k, this.f27795l, this.f27796m, this.f27797n);
    }

    public void c() {
        d(n.d());
    }

    public void d(@Nullable Date date) {
        k1 k1VarA = this.f27798o.a();
        try {
            this.f27789f = null;
            if (this.f27790g == b.Ok) {
                this.f27790g = b.Exited;
            }
            if (date != null) {
                this.f27785b = date;
            } else {
                this.f27785b = n.d();
            }
            Date date2 = this.f27785b;
            if (date2 != null) {
                this.f27792i = Double.valueOf(a(date2));
                this.f27791h = Long.valueOf(i(this.f27785b));
            }
            if (k1VarA != null) {
                k1VarA.close();
            }
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

    public int e() {
        return this.f27786c.get();
    }

    @Nullable
    public String f() {
        return this.f27797n;
    }

    @Nullable
    public Boolean g() {
        return this.f27789f;
    }

    @NotNull
    public String h() {
        return this.f27796m;
    }

    @Nullable
    public String j() {
        return this.f27788e;
    }

    @Nullable
    public Date k() {
        Date date = this.f27784a;
        if (date == null) {
            return null;
        }
        return (Date) date.clone();
    }

    @NotNull
    public b l() {
        return this.f27790g;
    }

    public boolean m() {
        return this.f27790g != b.Ok;
    }

    @ApiStatus.Internal
    public void n() {
        this.f27789f = Boolean.TRUE;
    }

    public void o(@Nullable Map<String, Object> map) {
        this.f27799p = map;
    }

    public boolean p(@Nullable b bVar, @Nullable String str, boolean z10) {
        return q(bVar, str, z10, null);
    }

    public boolean q(@Nullable b bVar, @Nullable String str, boolean z10, @Nullable String str2) {
        boolean z11;
        k1 k1VarA = this.f27798o.a();
        boolean z12 = true;
        if (bVar != null) {
            try {
                this.f27790g = bVar;
                z11 = true;
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
        } else {
            z11 = false;
        }
        if (str != null) {
            this.f27794k = str;
            z11 = true;
        }
        if (z10) {
            this.f27786c.addAndGet(1);
            z11 = true;
        }
        if (str2 != null) {
            this.f27797n = str2;
        } else {
            z12 = z11;
        }
        if (z12) {
            this.f27789f = null;
            Date dateD = n.d();
            this.f27785b = dateD;
            if (dateD != null) {
                this.f27791h = Long.valueOf(i(dateD));
            }
        }
        if (k1VarA != null) {
            k1VarA.close();
        }
        return z12;
    }

    @Override // io.sentry.h2
    public void serialize(@NotNull m3 m3Var, @NotNull w0 w0Var) throws IOException {
        m3Var.h();
        if (this.f27788e != null) {
            m3Var.e("sid").g(this.f27788e);
        }
        if (this.f27787d != null) {
            m3Var.e("did").g(this.f27787d);
        }
        if (this.f27789f != null) {
            m3Var.e(v8.a.f15678e).p(this.f27789f);
        }
        m3Var.e(v8.h.f15786d0).o(w0Var, this.f27784a);
        m3Var.e("status").o(w0Var, this.f27790g.name().toLowerCase(Locale.ROOT));
        if (this.f27791h != null) {
            m3Var.e("seq").n(this.f27791h);
        }
        m3Var.e("errors").a(this.f27786c.intValue());
        if (this.f27792i != null) {
            m3Var.e("duration").n(this.f27792i);
        }
        if (this.f27785b != null) {
            m3Var.e("timestamp").o(w0Var, this.f27785b);
        }
        if (this.f27797n != null) {
            m3Var.e("abnormal_mechanism").o(w0Var, this.f27797n);
        }
        m3Var.e("attrs");
        m3Var.h();
        m3Var.e("release").o(w0Var, this.f27796m);
        if (this.f27795l != null) {
            m3Var.e("environment").o(w0Var, this.f27795l);
        }
        if (this.f27793j != null) {
            m3Var.e(User.JsonKeys.IP_ADDRESS).o(w0Var, this.f27793j);
        }
        if (this.f27794k != null) {
            m3Var.e("user_agent").o(w0Var, this.f27794k);
        }
        m3Var.k();
        Map<String, Object> map = this.f27799p;
        if (map != null) {
            for (String str : map.keySet()) {
                Object obj = this.f27799p.get(str);
                m3Var.e(str);
                m3Var.o(w0Var, obj);
            }
        }
        m3Var.k();
    }

    public e8(@Nullable String str, @Nullable User user, @Nullable String str2, @NotNull String str3) {
        this(b.Ok, n.d(), n.d(), 0, str, c8.a(), Boolean.TRUE, null, null, user != null ? user.getIpAddress() : null, null, str2, str3, null);
    }
}
