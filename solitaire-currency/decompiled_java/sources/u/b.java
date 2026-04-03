package u;

import a0.j;
import androidx.webkit.ProxyConfig;
import com.ironsource.nb;
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
/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f34205c = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    private final b0 f34206a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    private final u.a f34207b;

    /* JADX INFO: compiled from: CacheStrategy.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(k kVar) {
            this();
        }

        private final boolean d(String str) {
            return q.x("Content-Length", str, true) || q.x("Content-Encoding", str, true) || q.x(nb.K, str, true);
        }

        private final boolean e(String str) {
            return (q.x("Connection", str, true) || q.x("Keep-Alive", str, true) || q.x("Proxy-Authenticate", str, true) || q.x("Proxy-Authorization", str, true) || q.x("TE", str, true) || q.x("Trailers", str, true) || q.x("Transfer-Encoding", str, true) || q.x("Upgrade", str, true)) ? false : true;
        }

        @NotNull
        public final u a(@NotNull u uVar, @NotNull u uVar2) {
            u.a aVar = new u.a();
            int size = uVar.size();
            for (int i10 = 0; i10 < size; i10++) {
                String strE = uVar.e(i10);
                String strI = uVar.i(i10);
                if ((!q.x("Warning", strE, true) || !q.K(strI, "1", false, 2, null)) && (d(strE) || !e(strE) || uVar2.a(strE) == null)) {
                    aVar.a(strE, strI);
                }
            }
            int size2 = uVar2.size();
            for (int i11 = 0; i11 < size2; i11++) {
                String strE2 = uVar2.e(i11);
                if (!d(strE2) && e(strE2)) {
                    aVar.a(strE2, uVar2.i(i11));
                }
            }
            return aVar.f();
        }

        public final boolean b(@NotNull b0 b0Var, @NotNull d0 d0Var) {
            return (b0Var.b().i() || d0Var.c().i() || t.d(d0Var.L().a("Vary"), ProxyConfig.MATCH_ALL_SCHEMES)) ? false : true;
        }

        public final boolean c(@NotNull b0 b0Var, @NotNull u.a aVar) {
            return (b0Var.b().i() || aVar.a().i() || t.d(aVar.d().a("Vary"), ProxyConfig.MATCH_ALL_SCHEMES)) ? false : true;
        }
    }

    /* JADX INFO: renamed from: u.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: CacheStrategy.kt */
    public static final class C0700b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        private final b0 f34208a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        private final u.a f34209b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Nullable
        private Date f34210c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @Nullable
        private String f34211d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @Nullable
        private Date f34212e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @Nullable
        private String f34213f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @Nullable
        private Date f34214g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private long f34215h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private long f34216i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        @Nullable
        private String f34217j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private int f34218k;

        public C0700b(@NotNull b0 b0Var, @Nullable u.a aVar) {
            this.f34208a = b0Var;
            this.f34209b = aVar;
            this.f34218k = -1;
            if (aVar != null) {
                this.f34215h = aVar.e();
                this.f34216i = aVar.c();
                u uVarD = aVar.d();
                int size = uVarD.size();
                for (int i10 = 0; i10 < size; i10++) {
                    String strE = uVarD.e(i10);
                    if (q.x(strE, "Date", true)) {
                        this.f34210c = uVarD.b("Date");
                        this.f34211d = uVarD.i(i10);
                    } else if (q.x(strE, "Expires", true)) {
                        this.f34214g = uVarD.b("Expires");
                    } else if (q.x(strE, "Last-Modified", true)) {
                        this.f34212e = uVarD.b("Last-Modified");
                        this.f34213f = uVarD.i(i10);
                    } else if (q.x(strE, "ETag", true)) {
                        this.f34217j = uVarD.i(i10);
                    } else if (q.x(strE, "Age", true)) {
                        this.f34218k = j.y(uVarD.i(i10), -1);
                    }
                }
            }
        }

        private final long a() {
            Date date = this.f34210c;
            long jMax = date != null ? Math.max(0L, this.f34216i - date.getTime()) : 0L;
            int i10 = this.f34218k;
            if (i10 != -1) {
                jMax = Math.max(jMax, TimeUnit.SECONDS.toMillis(i10));
            }
            return jMax + (this.f34216i - this.f34215h) + (a0.u.f69a.a() - this.f34216i);
        }

        private final long c() {
            u.a aVar = this.f34209b;
            t.f(aVar);
            if (aVar.a().d() != -1) {
                return TimeUnit.SECONDS.toMillis(r0.d());
            }
            Date date = this.f34214g;
            if (date != null) {
                Date date2 = this.f34210c;
                long time = date.getTime() - (date2 != null ? date2.getTime() : this.f34216i);
                if (time > 0) {
                    return time;
                }
                return 0L;
            }
            if (this.f34212e == null || this.f34208a.k().o() != null) {
                return 0L;
            }
            Date date3 = this.f34210c;
            long time2 = date3 != null ? date3.getTime() : this.f34215h;
            Date date4 = this.f34212e;
            t.f(date4);
            long time3 = time2 - date4.getTime();
            if (time3 > 0) {
                return time3 / ((long) 10);
            }
            return 0L;
        }

        private final boolean d(b0 b0Var) {
            return (b0Var.d("If-Modified-Since") == null && b0Var.d("If-None-Match") == null) ? false : true;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @NotNull
        public final b b() {
            String str;
            u.a aVar = null;
            Object[] objArr = 0;
            Object[] objArr2 = 0;
            Object[] objArr3 = 0;
            Object[] objArr4 = 0;
            Object[] objArr5 = 0;
            Object[] objArr6 = 0;
            Object[] objArr7 = 0;
            Object[] objArr8 = 0;
            Object[] objArr9 = 0;
            Object[] objArr10 = 0;
            Object[] objArr11 = 0;
            Object[] objArr12 = 0;
            if (this.f34209b == null) {
                return new b(this.f34208a, aVar, objArr12 == true ? 1 : 0);
            }
            if (this.f34208a.g() && !this.f34209b.f()) {
                return new b(this.f34208a, objArr11 == true ? 1 : 0, objArr10 == true ? 1 : 0);
            }
            ga.d dVarA = this.f34209b.a();
            if (!b.f34205c.c(this.f34208a, this.f34209b)) {
                return new b(this.f34208a, objArr9 == true ? 1 : 0, objArr8 == true ? 1 : 0);
            }
            ga.d dVarB = this.f34208a.b();
            if (dVarB.h() || d(this.f34208a)) {
                return new b(this.f34208a, objArr2 == true ? 1 : 0, objArr == true ? 1 : 0);
            }
            long jA = a();
            long jC = c();
            if (dVarB.d() != -1) {
                jC = Math.min(jC, TimeUnit.SECONDS.toMillis(dVarB.d()));
            }
            long millis = 0;
            long millis2 = dVarB.f() != -1 ? TimeUnit.SECONDS.toMillis(dVarB.f()) : 0L;
            if (!dVarA.g() && dVarB.e() != -1) {
                millis = TimeUnit.SECONDS.toMillis(dVarB.e());
            }
            if (!dVarA.h() && jA + millis2 < jC + millis) {
                return new b(objArr7 == true ? 1 : 0, this.f34209b, objArr6 == true ? 1 : 0);
            }
            String str2 = this.f34217j;
            if (str2 != null) {
                t.f(str2);
                str = "If-None-Match";
            } else {
                str = "If-Modified-Since";
                if (this.f34212e != null) {
                    str2 = this.f34213f;
                    t.f(str2);
                } else {
                    if (this.f34210c == null) {
                        return new b(this.f34208a, objArr4 == true ? 1 : 0, objArr3 == true ? 1 : 0);
                    }
                    str2 = this.f34211d;
                    t.f(str2);
                }
            }
            return new b(this.f34208a.i().a(str, str2).b(), this.f34209b, objArr5 == true ? 1 : 0);
        }
    }

    public /* synthetic */ b(b0 b0Var, u.a aVar, k kVar) {
        this(b0Var, aVar);
    }

    @Nullable
    public final u.a a() {
        return this.f34207b;
    }

    @Nullable
    public final b0 b() {
        return this.f34206a;
    }

    private b(b0 b0Var, u.a aVar) {
        this.f34206a = b0Var;
        this.f34207b = aVar;
    }
}
