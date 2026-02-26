package ga;

import java.util.concurrent.TimeUnit;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: CacheControl.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class d {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @NotNull
    public static final b f25999n = new b(null);

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @NotNull
    public static final d f26000o = new a().d().a();

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @NotNull
    public static final d f26001p = new a().f().c(Integer.MAX_VALUE, TimeUnit.SECONDS).a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f26002a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f26003b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f26004c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f26005d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f26006e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f26007f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f26008g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int f26009h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final int f26010i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final boolean f26011j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final boolean f26012k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final boolean f26013l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @Nullable
    private String f26014m;

    /* JADX INFO: compiled from: CacheControl.kt */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f26015a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f26016b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f26017c = -1;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f26018d = -1;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f26019e = -1;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private boolean f26020f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private boolean f26021g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private boolean f26022h;

        private final int b(long j10) {
            if (j10 > 2147483647L) {
                return Integer.MAX_VALUE;
            }
            return (int) j10;
        }

        @NotNull
        public final d a() {
            return new d(this.f26015a, this.f26016b, this.f26017c, -1, false, false, false, this.f26018d, this.f26019e, this.f26020f, this.f26021g, this.f26022h, null, null);
        }

        @NotNull
        public final a c(int i10, @NotNull TimeUnit timeUnit) {
            kotlin.jvm.internal.t.i(timeUnit, "timeUnit");
            if (!(i10 >= 0)) {
                throw new IllegalArgumentException(kotlin.jvm.internal.t.r("maxStale < 0: ", Integer.valueOf(i10)).toString());
            }
            this.f26018d = b(timeUnit.toSeconds(i10));
            return this;
        }

        @NotNull
        public final a d() {
            this.f26015a = true;
            return this;
        }

        @NotNull
        public final a e() {
            this.f26016b = true;
            return this;
        }

        @NotNull
        public final a f() {
            this.f26020f = true;
            return this;
        }
    }

    /* JADX INFO: compiled from: CacheControl.kt */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(kotlin.jvm.internal.k kVar) {
            this();
        }

        private final int a(String str, String str2, int i10) {
            int length = str.length();
            while (i10 < length) {
                int i11 = i10 + 1;
                if (p9.r.O(str2, str.charAt(i10), false, 2, null)) {
                    return i10;
                }
                i10 = i11;
            }
            return str.length();
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x004c  */
        @org.jetbrains.annotations.NotNull
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final ga.d b(@org.jetbrains.annotations.NotNull ga.u r31) {
            /*
                Method dump skipped, instruction units count: 408
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ga.d.b.b(ga.u):ga.d");
        }
    }

    public /* synthetic */ d(boolean z10, boolean z11, int i10, int i11, boolean z12, boolean z13, boolean z14, int i12, int i13, boolean z15, boolean z16, boolean z17, String str, kotlin.jvm.internal.k kVar) {
        this(z10, z11, i10, i11, z12, z13, z14, i12, i13, z15, z16, z17, str);
    }

    public final boolean a() {
        return this.f26013l;
    }

    public final boolean b() {
        return this.f26006e;
    }

    public final boolean c() {
        return this.f26007f;
    }

    public final int d() {
        return this.f26004c;
    }

    public final int e() {
        return this.f26009h;
    }

    public final int f() {
        return this.f26010i;
    }

    public final boolean g() {
        return this.f26008g;
    }

    public final boolean h() {
        return this.f26002a;
    }

    public final boolean i() {
        return this.f26003b;
    }

    public final boolean j() {
        return this.f26012k;
    }

    public final boolean k() {
        return this.f26011j;
    }

    public final int l() {
        return this.f26005d;
    }

    @NotNull
    public String toString() {
        String str = this.f26014m;
        if (str != null) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        if (h()) {
            sb.append("no-cache, ");
        }
        if (i()) {
            sb.append("no-store, ");
        }
        if (d() != -1) {
            sb.append("max-age=");
            sb.append(d());
            sb.append(", ");
        }
        if (l() != -1) {
            sb.append("s-maxage=");
            sb.append(l());
            sb.append(", ");
        }
        if (b()) {
            sb.append("private, ");
        }
        if (c()) {
            sb.append("public, ");
        }
        if (g()) {
            sb.append("must-revalidate, ");
        }
        if (e() != -1) {
            sb.append("max-stale=");
            sb.append(e());
            sb.append(", ");
        }
        if (f() != -1) {
            sb.append("min-fresh=");
            sb.append(f());
            sb.append(", ");
        }
        if (k()) {
            sb.append("only-if-cached, ");
        }
        if (j()) {
            sb.append("no-transform, ");
        }
        if (a()) {
            sb.append("immutable, ");
        }
        if (sb.length() == 0) {
            return "";
        }
        sb.delete(sb.length() - 2, sb.length());
        String string = sb.toString();
        kotlin.jvm.internal.t.h(string, "StringBuilder().apply(builderAction).toString()");
        this.f26014m = string;
        return string;
    }

    private d(boolean z10, boolean z11, int i10, int i11, boolean z12, boolean z13, boolean z14, int i12, int i13, boolean z15, boolean z16, boolean z17, String str) {
        this.f26002a = z10;
        this.f26003b = z11;
        this.f26004c = i10;
        this.f26005d = i11;
        this.f26006e = z12;
        this.f26007f = z13;
        this.f26008g = z14;
        this.f26009h = i12;
        this.f26010i = i13;
        this.f26011j = z15;
        this.f26012k = z16;
        this.f26013l = z17;
        this.f26014m = str;
    }
}
