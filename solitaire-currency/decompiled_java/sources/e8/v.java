package e8;

import androidx.compose.animation.core.AnimationConstants;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.ironsource.c3;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: HttpStatusCode.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class v implements Comparable<v> {

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    @NotNull
    private static final List<v> f25377e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    @NotNull
    private static final Map<Integer, v> f25379f0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f25400a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final String f25401b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f25372c = new a(null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private static final v f25374d = new v(100, "Continue");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    private static final v f25376e = new v(101, "Switching Protocols");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    private static final v f25378f = new v(102, "Processing");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NotNull
    private static final v f25380g = new v(200, "OK");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NotNull
    private static final v f25381h = new v(201, "Created");

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NotNull
    private static final v f25382i = new v(202, "Accepted");

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NotNull
    private static final v f25383j = new v(203, "Non-Authoritative Information");

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @NotNull
    private static final v f25384k = new v(204, "No Content");

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @NotNull
    private static final v f25385l = new v(205, "Reset Content");

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @NotNull
    private static final v f25386m = new v(206, "Partial Content");

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @NotNull
    private static final v f25387n = new v(207, "Multi-Status");

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @NotNull
    private static final v f25388o = new v(AnimationConstants.DefaultDurationMillis, "Multiple Choices");

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @NotNull
    private static final v f25389p = new v(301, "Moved Permanently");

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @NotNull
    private static final v f25390q = new v(302, "Found");

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @NotNull
    private static final v f25391r = new v(303, "See Other");

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @NotNull
    private static final v f25392s = new v(304, "Not Modified");

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @NotNull
    private static final v f25393t = new v(305, "Use Proxy");

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    @NotNull
    private static final v f25394u = new v(306, "Switch Proxy");

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    @NotNull
    private static final v f25395v = new v(307, "Temporary Redirect");

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    @NotNull
    private static final v f25396w = new v(308, "Permanent Redirect");

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @NotNull
    private static final v f25397x = new v(400, "Bad Request");

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    @NotNull
    private static final v f25398y = new v(401, "Unauthorized");

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    @NotNull
    private static final v f25399z = new v(TypedValues.CycleType.TYPE_VISIBILITY, "Payment Required");

    @NotNull
    private static final v A = new v(403, "Forbidden");

    @NotNull
    private static final v B = new v(c3.a.b.f11495d, "Not Found");

    @NotNull
    private static final v C = new v(c3.a.b.f11496e, "Method Not Allowed");

    @NotNull
    private static final v D = new v(c3.a.b.f11497f, "Not Acceptable");

    @NotNull
    private static final v E = new v(c3.a.b.f11498g, "Proxy Authentication Required");

    @NotNull
    private static final v F = new v(c3.a.b.f11499h, "Request Timeout");

    @NotNull
    private static final v G = new v(c3.a.b.f11500i, "Conflict");

    @NotNull
    private static final v H = new v(c3.a.b.f11501j, "Gone");

    @NotNull
    private static final v I = new v(c3.a.b.f11502k, "Length Required");

    @NotNull
    private static final v J = new v(412, "Precondition Failed");

    @NotNull
    private static final v K = new v(413, "Payload Too Large");

    @NotNull
    private static final v L = new v(414, "Request-URI Too Long");

    @NotNull
    private static final v M = new v(415, "Unsupported Media Type");

    @NotNull
    private static final v N = new v(TypedValues.CycleType.TYPE_PATH_ROTATE, "Requested Range Not Satisfiable");

    @NotNull
    private static final v O = new v(417, "Expectation Failed");

    @NotNull
    private static final v P = new v(TypedValues.CycleType.TYPE_CUSTOM_WAVE_SHAPE, "Unprocessable Entity");

    @NotNull
    private static final v Q = new v(TypedValues.CycleType.TYPE_WAVE_PERIOD, "Locked");

    @NotNull
    private static final v R = new v(TypedValues.CycleType.TYPE_WAVE_OFFSET, "Failed Dependency");

    @NotNull
    private static final v S = new v(TypedValues.CycleType.TYPE_WAVE_PHASE, "Too Early");

    @NotNull
    private static final v T = new v(426, "Upgrade Required");

    @NotNull
    private static final v U = new v(429, "Too Many Requests");

    @NotNull
    private static final v V = new v(431, "Request Header Fields Too Large");

    @NotNull
    private static final v W = new v(500, "Internal Server Error");

    @NotNull
    private static final v X = new v(501, "Not Implemented");

    @NotNull
    private static final v Y = new v(502, "Bad Gateway");

    @NotNull
    private static final v Z = new v(TypedValues.PositionType.TYPE_PERCENT_WIDTH, "Service Unavailable");

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    @NotNull
    private static final v f25370a0 = new v(TypedValues.PositionType.TYPE_PERCENT_HEIGHT, "Gateway Timeout");

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    @NotNull
    private static final v f25371b0 = new v(505, "HTTP Version Not Supported");

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    @NotNull
    private static final v f25373c0 = new v(506, "Variant Also Negotiates");

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    @NotNull
    private static final v f25375d0 = new v(TypedValues.PositionType.TYPE_PERCENT_Y, "Insufficient Storage");

    /* JADX INFO: compiled from: HttpStatusCode.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        @NotNull
        public final v A() {
            return v.f25392s;
        }

        @NotNull
        public final v B() {
            return v.f25380g;
        }

        @NotNull
        public final v C() {
            return v.f25386m;
        }

        @NotNull
        public final v D() {
            return v.K;
        }

        @NotNull
        public final v E() {
            return v.f25399z;
        }

        @NotNull
        public final v F() {
            return v.f25396w;
        }

        @NotNull
        public final v G() {
            return v.J;
        }

        @NotNull
        public final v H() {
            return v.f25378f;
        }

        @NotNull
        public final v I() {
            return v.E;
        }

        @NotNull
        public final v J() {
            return v.V;
        }

        @NotNull
        public final v K() {
            return v.F;
        }

        @NotNull
        public final v L() {
            return v.L;
        }

        @NotNull
        public final v M() {
            return v.N;
        }

        @NotNull
        public final v N() {
            return v.f25385l;
        }

        @NotNull
        public final v O() {
            return v.f25391r;
        }

        @NotNull
        public final v P() {
            return v.Z;
        }

        @NotNull
        public final v Q() {
            return v.f25394u;
        }

        @NotNull
        public final v R() {
            return v.f25376e;
        }

        @NotNull
        public final v S() {
            return v.f25395v;
        }

        @NotNull
        public final v T() {
            return v.S;
        }

        @NotNull
        public final v U() {
            return v.U;
        }

        @NotNull
        public final v V() {
            return v.f25398y;
        }

        @NotNull
        public final v W() {
            return v.P;
        }

        @NotNull
        public final v X() {
            return v.M;
        }

        @NotNull
        public final v Y() {
            return v.T;
        }

        @NotNull
        public final v Z() {
            return v.f25393t;
        }

        @NotNull
        public final v a(int i10) {
            v vVar = (v) v.f25379f0.get(Integer.valueOf(i10));
            return vVar == null ? new v(i10, "Unknown Status Code") : vVar;
        }

        @NotNull
        public final v a0() {
            return v.f25373c0;
        }

        @NotNull
        public final v b() {
            return v.f25382i;
        }

        @NotNull
        public final v b0() {
            return v.f25371b0;
        }

        @NotNull
        public final v c() {
            return v.Y;
        }

        @NotNull
        public final v d() {
            return v.f25397x;
        }

        @NotNull
        public final v e() {
            return v.G;
        }

        @NotNull
        public final v f() {
            return v.f25374d;
        }

        @NotNull
        public final v g() {
            return v.f25381h;
        }

        @NotNull
        public final v h() {
            return v.O;
        }

        @NotNull
        public final v i() {
            return v.R;
        }

        @NotNull
        public final v j() {
            return v.A;
        }

        @NotNull
        public final v k() {
            return v.f25390q;
        }

        @NotNull
        public final v l() {
            return v.f25370a0;
        }

        @NotNull
        public final v m() {
            return v.H;
        }

        @NotNull
        public final v n() {
            return v.f25375d0;
        }

        @NotNull
        public final v o() {
            return v.W;
        }

        @NotNull
        public final v p() {
            return v.I;
        }

        @NotNull
        public final v q() {
            return v.Q;
        }

        @NotNull
        public final v r() {
            return v.C;
        }

        @NotNull
        public final v s() {
            return v.f25389p;
        }

        @NotNull
        public final v t() {
            return v.f25387n;
        }

        @NotNull
        public final v u() {
            return v.f25388o;
        }

        @NotNull
        public final v v() {
            return v.f25384k;
        }

        @NotNull
        public final v w() {
            return v.f25383j;
        }

        @NotNull
        public final v x() {
            return v.D;
        }

        @NotNull
        public final v y() {
            return v.B;
        }

        @NotNull
        public final v z() {
            return v.X;
        }
    }

    static {
        List<v> listA = w.a();
        f25377e0 = listA;
        List<v> list = listA;
        LinkedHashMap linkedHashMap = new LinkedHashMap(n9.o.e(kotlin.collections.q0.d(kotlin.collections.w.v(list, 10)), 16));
        for (Object obj : list) {
            linkedHashMap.put(Integer.valueOf(((v) obj).f25400a), obj);
        }
        f25379f0 = linkedHashMap;
    }

    public v(int i10, @NotNull String description) {
        kotlin.jvm.internal.t.i(description, "description");
        this.f25400a = i10;
        this.f25401b = description;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: d0, reason: merged with bridge method [inline-methods] */
    public int compareTo(@NotNull v other) {
        kotlin.jvm.internal.t.i(other, "other");
        return this.f25400a - other.f25400a;
    }

    public final int e0() {
        return this.f25400a;
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof v) && ((v) obj).f25400a == this.f25400a;
    }

    public int hashCode() {
        return this.f25400a;
    }

    @NotNull
    public String toString() {
        return this.f25400a + ' ' + this.f25401b;
    }
}
