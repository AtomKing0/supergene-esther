package ja;

import ga.b0;
import ga.d0;
import ga.u;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p9.q;

/* JADX INFO: compiled from: CacheStrategy.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f28815c = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    private final b0 f28816a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    private final d0 f28817b;

    /* JADX INFO: compiled from: CacheStrategy.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(k kVar) {
            this();
        }

        /* JADX WARN: Removed duplicated region for block: B:24:0x003b  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final boolean a(@org.jetbrains.annotations.NotNull ga.d0 r5, @org.jetbrains.annotations.NotNull ga.b0 r6) {
            /*
                r4 = this;
                java.lang.String r0 = "response"
                kotlin.jvm.internal.t.i(r5, r0)
                java.lang.String r0 = "request"
                kotlin.jvm.internal.t.i(r6, r0)
                int r0 = r5.q()
                r1 = 200(0xc8, float:2.8E-43)
                r2 = 0
                if (r0 == r1) goto L65
                r1 = 410(0x19a, float:5.75E-43)
                if (r0 == r1) goto L65
                r1 = 414(0x19e, float:5.8E-43)
                if (r0 == r1) goto L65
                r1 = 501(0x1f5, float:7.02E-43)
                if (r0 == r1) goto L65
                r1 = 203(0xcb, float:2.84E-43)
                if (r0 == r1) goto L65
                r1 = 204(0xcc, float:2.86E-43)
                if (r0 == r1) goto L65
                r1 = 307(0x133, float:4.3E-43)
                if (r0 == r1) goto L3b
                r1 = 308(0x134, float:4.32E-43)
                if (r0 == r1) goto L65
                r1 = 404(0x194, float:5.66E-43)
                if (r0 == r1) goto L65
                r1 = 405(0x195, float:5.68E-43)
                if (r0 == r1) goto L65
                switch(r0) {
                    case 300: goto L65;
                    case 301: goto L65;
                    case 302: goto L3b;
                    default: goto L3a;
                }
            L3a:
                return r2
            L3b:
                java.lang.String r0 = "Expires"
                r1 = 2
                r3 = 0
                java.lang.String r0 = ga.d0.J(r5, r0, r3, r1, r3)
                if (r0 != 0) goto L65
                ga.d r0 = r5.c()
                int r0 = r0.d()
                r1 = -1
                if (r0 != r1) goto L65
                ga.d r0 = r5.c()
                boolean r0 = r0.c()
                if (r0 != 0) goto L65
                ga.d r0 = r5.c()
                boolean r0 = r0.b()
                if (r0 != 0) goto L65
                return r2
            L65:
                ga.d r5 = r5.c()
                boolean r5 = r5.i()
                if (r5 != 0) goto L7a
                ga.d r5 = r6.b()
                boolean r5 = r5.i()
                if (r5 != 0) goto L7a
                r2 = 1
            L7a:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: ja.c.a.a(ga.d0, ga.b0):boolean");
        }
    }

    /* JADX INFO: compiled from: CacheStrategy.kt */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f28818a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @NotNull
        private final b0 f28819b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Nullable
        private final d0 f28820c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @Nullable
        private Date f28821d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @Nullable
        private String f28822e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @Nullable
        private Date f28823f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @Nullable
        private String f28824g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        @Nullable
        private Date f28825h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private long f28826i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private long f28827j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        @Nullable
        private String f28828k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private int f28829l;

        public b(long j10, @NotNull b0 request, @Nullable d0 d0Var) {
            t.i(request, "request");
            this.f28818a = j10;
            this.f28819b = request;
            this.f28820c = d0Var;
            this.f28829l = -1;
            if (d0Var != null) {
                this.f28826i = d0Var.J0();
                this.f28827j = d0Var.G0();
                u uVarL = d0Var.L();
                int size = uVarL.size();
                int i10 = 0;
                while (i10 < size) {
                    int i11 = i10 + 1;
                    String strE = uVarL.e(i10);
                    String strI = uVarL.i(i10);
                    if (q.x(strE, "Date", true)) {
                        this.f28821d = ma.c.a(strI);
                        this.f28822e = strI;
                    } else if (q.x(strE, "Expires", true)) {
                        this.f28825h = ma.c.a(strI);
                    } else if (q.x(strE, "Last-Modified", true)) {
                        this.f28823f = ma.c.a(strI);
                        this.f28824g = strI;
                    } else if (q.x(strE, "ETag", true)) {
                        this.f28828k = strI;
                    } else if (q.x(strE, "Age", true)) {
                        this.f28829l = ha.d.W(strI, -1);
                    }
                    i10 = i11;
                }
            }
        }

        private final long a() {
            Date date = this.f28821d;
            long jMax = date != null ? Math.max(0L, this.f28827j - date.getTime()) : 0L;
            int i10 = this.f28829l;
            if (i10 != -1) {
                jMax = Math.max(jMax, TimeUnit.SECONDS.toMillis(i10));
            }
            long j10 = this.f28827j;
            return jMax + (j10 - this.f28826i) + (this.f28818a - j10);
        }

        private final c c() {
            String str;
            if (this.f28820c == null) {
                return new c(this.f28819b, null);
            }
            if (this.f28819b.g() && this.f28820c.z() == null) {
                return new c(this.f28819b, null);
            }
            if (!c.f28815c.a(this.f28820c, this.f28819b)) {
                return new c(this.f28819b, null);
            }
            ga.d dVarB = this.f28819b.b();
            if (dVarB.h() || e(this.f28819b)) {
                return new c(this.f28819b, null);
            }
            ga.d dVarC = this.f28820c.c();
            long jA = a();
            long jD = d();
            if (dVarB.d() != -1) {
                jD = Math.min(jD, TimeUnit.SECONDS.toMillis(dVarB.d()));
            }
            long millis = 0;
            long millis2 = dVarB.f() != -1 ? TimeUnit.SECONDS.toMillis(dVarB.f()) : 0L;
            if (!dVarC.g() && dVarB.e() != -1) {
                millis = TimeUnit.SECONDS.toMillis(dVarB.e());
            }
            if (!dVarC.h()) {
                long j10 = millis2 + jA;
                if (j10 < millis + jD) {
                    d0.a aVarW = this.f28820c.W();
                    if (j10 >= jD) {
                        aVarW.a("Warning", "110 HttpURLConnection \"Response is stale\"");
                    }
                    if (jA > com.vungle.ads.internal.signals.b.TWENTY_FOUR_HOURS_MILLIS && f()) {
                        aVarW.a("Warning", "113 HttpURLConnection \"Heuristic expiration\"");
                    }
                    return new c(null, aVarW.c());
                }
            }
            String str2 = this.f28828k;
            if (str2 != null) {
                str = "If-None-Match";
            } else {
                if (this.f28823f != null) {
                    str2 = this.f28824g;
                } else {
                    if (this.f28821d == null) {
                        return new c(this.f28819b, null);
                    }
                    str2 = this.f28822e;
                }
                str = "If-Modified-Since";
            }
            u.a aVarF = this.f28819b.e().f();
            t.f(str2);
            aVarF.d(str, str2);
            return new c(this.f28819b.i().h(aVarF.f()).b(), this.f28820c);
        }

        private final long d() {
            Long lValueOf;
            d0 d0Var = this.f28820c;
            t.f(d0Var);
            if (d0Var.c().d() != -1) {
                return TimeUnit.SECONDS.toMillis(r0.d());
            }
            Date date = this.f28825h;
            if (date != null) {
                Date date2 = this.f28821d;
                lValueOf = date2 != null ? Long.valueOf(date2.getTime()) : null;
                long time = date.getTime() - (lValueOf == null ? this.f28827j : lValueOf.longValue());
                if (time > 0) {
                    return time;
                }
                return 0L;
            }
            if (this.f28823f == null || this.f28820c.I0().k().o() != null) {
                return 0L;
            }
            Date date3 = this.f28821d;
            lValueOf = date3 != null ? Long.valueOf(date3.getTime()) : null;
            long jLongValue = lValueOf == null ? this.f28826i : lValueOf.longValue();
            Date date4 = this.f28823f;
            t.f(date4);
            long time2 = jLongValue - date4.getTime();
            if (time2 > 0) {
                return time2 / ((long) 10);
            }
            return 0L;
        }

        private final boolean e(b0 b0Var) {
            return (b0Var.d("If-Modified-Since") == null && b0Var.d("If-None-Match") == null) ? false : true;
        }

        private final boolean f() {
            d0 d0Var = this.f28820c;
            t.f(d0Var);
            return d0Var.c().d() == -1 && this.f28825h == null;
        }

        @NotNull
        public final c b() {
            c cVarC = c();
            return (cVarC.b() == null || !this.f28819b.b().k()) ? cVarC : new c(null, null);
        }
    }

    public c(@Nullable b0 b0Var, @Nullable d0 d0Var) {
        this.f28816a = b0Var;
        this.f28817b = d0Var;
    }

    @Nullable
    public final d0 a() {
        return this.f28817b;
    }

    @Nullable
    public final b0 b() {
        return this.f28816a;
    }
}
