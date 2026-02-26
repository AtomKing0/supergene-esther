package x1;

import androidx.annotation.Nullable;
import java.util.Arrays;
import x1.l;

/* JADX INFO: compiled from: AutoValue_LogEvent.java */
/* JADX INFO: loaded from: classes2.dex */
final class f extends l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f35637a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Integer f35638b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f35639c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final byte[] f35640d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f35641e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final long f35642f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final o f35643g;

    /* JADX INFO: compiled from: AutoValue_LogEvent.java */
    static final class b extends l.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Long f35644a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Integer f35645b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Long f35646c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private byte[] f35647d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private String f35648e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private Long f35649f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private o f35650g;

        b() {
        }

        @Override // x1.l.a
        public l a() {
            String str = "";
            if (this.f35644a == null) {
                str = " eventTimeMs";
            }
            if (this.f35646c == null) {
                str = str + " eventUptimeMs";
            }
            if (this.f35649f == null) {
                str = str + " timezoneOffsetSeconds";
            }
            if (str.isEmpty()) {
                return new f(this.f35644a.longValue(), this.f35645b, this.f35646c.longValue(), this.f35647d, this.f35648e, this.f35649f.longValue(), this.f35650g);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // x1.l.a
        public l.a b(@Nullable Integer num) {
            this.f35645b = num;
            return this;
        }

        @Override // x1.l.a
        public l.a c(long j10) {
            this.f35644a = Long.valueOf(j10);
            return this;
        }

        @Override // x1.l.a
        public l.a d(long j10) {
            this.f35646c = Long.valueOf(j10);
            return this;
        }

        @Override // x1.l.a
        public l.a e(@Nullable o oVar) {
            this.f35650g = oVar;
            return this;
        }

        @Override // x1.l.a
        l.a f(@Nullable byte[] bArr) {
            this.f35647d = bArr;
            return this;
        }

        @Override // x1.l.a
        l.a g(@Nullable String str) {
            this.f35648e = str;
            return this;
        }

        @Override // x1.l.a
        public l.a h(long j10) {
            this.f35649f = Long.valueOf(j10);
            return this;
        }
    }

    @Override // x1.l
    @Nullable
    public Integer b() {
        return this.f35638b;
    }

    @Override // x1.l
    public long c() {
        return this.f35637a;
    }

    @Override // x1.l
    public long d() {
        return this.f35639c;
    }

    @Override // x1.l
    @Nullable
    public o e() {
        return this.f35643g;
    }

    public boolean equals(Object obj) {
        Integer num;
        String str;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof l)) {
            return false;
        }
        l lVar = (l) obj;
        if (this.f35637a == lVar.c() && ((num = this.f35638b) != null ? num.equals(lVar.b()) : lVar.b() == null) && this.f35639c == lVar.d()) {
            if (Arrays.equals(this.f35640d, lVar instanceof f ? ((f) lVar).f35640d : lVar.f()) && ((str = this.f35641e) != null ? str.equals(lVar.g()) : lVar.g() == null) && this.f35642f == lVar.h()) {
                o oVar = this.f35643g;
                if (oVar == null) {
                    if (lVar.e() == null) {
                        return true;
                    }
                } else if (oVar.equals(lVar.e())) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // x1.l
    @Nullable
    public byte[] f() {
        return this.f35640d;
    }

    @Override // x1.l
    @Nullable
    public String g() {
        return this.f35641e;
    }

    @Override // x1.l
    public long h() {
        return this.f35642f;
    }

    public int hashCode() {
        long j10 = this.f35637a;
        int i10 = (((int) (j10 ^ (j10 >>> 32))) ^ 1000003) * 1000003;
        Integer num = this.f35638b;
        int iHashCode = num == null ? 0 : num.hashCode();
        long j11 = this.f35639c;
        int iHashCode2 = (((((i10 ^ iHashCode) * 1000003) ^ ((int) (j11 ^ (j11 >>> 32)))) * 1000003) ^ Arrays.hashCode(this.f35640d)) * 1000003;
        String str = this.f35641e;
        int iHashCode3 = str == null ? 0 : str.hashCode();
        long j12 = this.f35642f;
        int i11 = (((iHashCode2 ^ iHashCode3) * 1000003) ^ ((int) ((j12 >>> 32) ^ j12))) * 1000003;
        o oVar = this.f35643g;
        return i11 ^ (oVar != null ? oVar.hashCode() : 0);
    }

    public String toString() {
        return "LogEvent{eventTimeMs=" + this.f35637a + ", eventCode=" + this.f35638b + ", eventUptimeMs=" + this.f35639c + ", sourceExtension=" + Arrays.toString(this.f35640d) + ", sourceExtensionJsonProto3=" + this.f35641e + ", timezoneOffsetSeconds=" + this.f35642f + ", networkConnectionInfo=" + this.f35643g + "}";
    }

    private f(long j10, @Nullable Integer num, long j11, @Nullable byte[] bArr, @Nullable String str, long j12, @Nullable o oVar) {
        this.f35637a = j10;
        this.f35638b = num;
        this.f35639c = j11;
        this.f35640d = bArr;
        this.f35641e = str;
        this.f35642f = j12;
        this.f35643g = oVar;
    }
}
