package x1;

import androidx.annotation.Nullable;
import java.util.List;
import x1.m;

/* JADX INFO: compiled from: AutoValue_LogRequest.java */
/* JADX INFO: loaded from: classes2.dex */
final class g extends m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f35651a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f35652b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final k f35653c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Integer f35654d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f35655e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final List<l> f35656f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final p f35657g;

    /* JADX INFO: compiled from: AutoValue_LogRequest.java */
    static final class b extends m.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Long f35658a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Long f35659b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private k f35660c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private Integer f35661d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private String f35662e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private List<l> f35663f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private p f35664g;

        b() {
        }

        @Override // x1.m.a
        public m a() {
            String str = "";
            if (this.f35658a == null) {
                str = " requestTimeMs";
            }
            if (this.f35659b == null) {
                str = str + " requestUptimeMs";
            }
            if (str.isEmpty()) {
                return new g(this.f35658a.longValue(), this.f35659b.longValue(), this.f35660c, this.f35661d, this.f35662e, this.f35663f, this.f35664g);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // x1.m.a
        public m.a b(@Nullable k kVar) {
            this.f35660c = kVar;
            return this;
        }

        @Override // x1.m.a
        public m.a c(@Nullable List<l> list) {
            this.f35663f = list;
            return this;
        }

        @Override // x1.m.a
        m.a d(@Nullable Integer num) {
            this.f35661d = num;
            return this;
        }

        @Override // x1.m.a
        m.a e(@Nullable String str) {
            this.f35662e = str;
            return this;
        }

        @Override // x1.m.a
        public m.a f(@Nullable p pVar) {
            this.f35664g = pVar;
            return this;
        }

        @Override // x1.m.a
        public m.a g(long j10) {
            this.f35658a = Long.valueOf(j10);
            return this;
        }

        @Override // x1.m.a
        public m.a h(long j10) {
            this.f35659b = Long.valueOf(j10);
            return this;
        }
    }

    @Override // x1.m
    @Nullable
    public k b() {
        return this.f35653c;
    }

    @Override // x1.m
    @Nullable
    public List<l> c() {
        return this.f35656f;
    }

    @Override // x1.m
    @Nullable
    public Integer d() {
        return this.f35654d;
    }

    @Override // x1.m
    @Nullable
    public String e() {
        return this.f35655e;
    }

    public boolean equals(Object obj) {
        k kVar;
        Integer num;
        String str;
        List<l> list;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof m)) {
            return false;
        }
        m mVar = (m) obj;
        if (this.f35651a == mVar.g() && this.f35652b == mVar.h() && ((kVar = this.f35653c) != null ? kVar.equals(mVar.b()) : mVar.b() == null) && ((num = this.f35654d) != null ? num.equals(mVar.d()) : mVar.d() == null) && ((str = this.f35655e) != null ? str.equals(mVar.e()) : mVar.e() == null) && ((list = this.f35656f) != null ? list.equals(mVar.c()) : mVar.c() == null)) {
            p pVar = this.f35657g;
            if (pVar == null) {
                if (mVar.f() == null) {
                    return true;
                }
            } else if (pVar.equals(mVar.f())) {
                return true;
            }
        }
        return false;
    }

    @Override // x1.m
    @Nullable
    public p f() {
        return this.f35657g;
    }

    @Override // x1.m
    public long g() {
        return this.f35651a;
    }

    @Override // x1.m
    public long h() {
        return this.f35652b;
    }

    public int hashCode() {
        long j10 = this.f35651a;
        long j11 = this.f35652b;
        int i10 = (((((int) (j10 ^ (j10 >>> 32))) ^ 1000003) * 1000003) ^ ((int) ((j11 >>> 32) ^ j11))) * 1000003;
        k kVar = this.f35653c;
        int iHashCode = (i10 ^ (kVar == null ? 0 : kVar.hashCode())) * 1000003;
        Integer num = this.f35654d;
        int iHashCode2 = (iHashCode ^ (num == null ? 0 : num.hashCode())) * 1000003;
        String str = this.f35655e;
        int iHashCode3 = (iHashCode2 ^ (str == null ? 0 : str.hashCode())) * 1000003;
        List<l> list = this.f35656f;
        int iHashCode4 = (iHashCode3 ^ (list == null ? 0 : list.hashCode())) * 1000003;
        p pVar = this.f35657g;
        return iHashCode4 ^ (pVar != null ? pVar.hashCode() : 0);
    }

    public String toString() {
        return "LogRequest{requestTimeMs=" + this.f35651a + ", requestUptimeMs=" + this.f35652b + ", clientInfo=" + this.f35653c + ", logSource=" + this.f35654d + ", logSourceName=" + this.f35655e + ", logEvents=" + this.f35656f + ", qosTier=" + this.f35657g + "}";
    }

    private g(long j10, long j11, @Nullable k kVar, @Nullable Integer num, @Nullable String str, @Nullable List<l> list, @Nullable p pVar) {
        this.f35651a = j10;
        this.f35652b = j11;
        this.f35653c = kVar;
        this.f35654d = num;
        this.f35655e = str;
        this.f35656f = list;
        this.f35657g = pVar;
    }
}
