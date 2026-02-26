package g2;

import g2.e;

/* JADX INFO: compiled from: AutoValue_EventStoreConfig.java */
/* JADX INFO: loaded from: classes2.dex */
final class a extends e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f25789b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f25790c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f25791d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final long f25792e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f25793f;

    /* JADX INFO: compiled from: AutoValue_EventStoreConfig.java */
    static final class b extends e.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Long f25794a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Integer f25795b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Integer f25796c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private Long f25797d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private Integer f25798e;

        b() {
        }

        @Override // g2.e.a
        e a() {
            String str = "";
            if (this.f25794a == null) {
                str = " maxStorageSizeInBytes";
            }
            if (this.f25795b == null) {
                str = str + " loadBatchSize";
            }
            if (this.f25796c == null) {
                str = str + " criticalSectionEnterTimeoutMs";
            }
            if (this.f25797d == null) {
                str = str + " eventCleanUpAge";
            }
            if (this.f25798e == null) {
                str = str + " maxBlobByteSizePerRow";
            }
            if (str.isEmpty()) {
                return new a(this.f25794a.longValue(), this.f25795b.intValue(), this.f25796c.intValue(), this.f25797d.longValue(), this.f25798e.intValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // g2.e.a
        e.a b(int i10) {
            this.f25796c = Integer.valueOf(i10);
            return this;
        }

        @Override // g2.e.a
        e.a c(long j10) {
            this.f25797d = Long.valueOf(j10);
            return this;
        }

        @Override // g2.e.a
        e.a d(int i10) {
            this.f25795b = Integer.valueOf(i10);
            return this;
        }

        @Override // g2.e.a
        e.a e(int i10) {
            this.f25798e = Integer.valueOf(i10);
            return this;
        }

        @Override // g2.e.a
        e.a f(long j10) {
            this.f25794a = Long.valueOf(j10);
            return this;
        }
    }

    @Override // g2.e
    int b() {
        return this.f25791d;
    }

    @Override // g2.e
    long c() {
        return this.f25792e;
    }

    @Override // g2.e
    int d() {
        return this.f25790c;
    }

    @Override // g2.e
    int e() {
        return this.f25793f;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return this.f25789b == eVar.f() && this.f25790c == eVar.d() && this.f25791d == eVar.b() && this.f25792e == eVar.c() && this.f25793f == eVar.e();
    }

    @Override // g2.e
    long f() {
        return this.f25789b;
    }

    public int hashCode() {
        long j10 = this.f25789b;
        int i10 = (((((((int) (j10 ^ (j10 >>> 32))) ^ 1000003) * 1000003) ^ this.f25790c) * 1000003) ^ this.f25791d) * 1000003;
        long j11 = this.f25792e;
        return ((i10 ^ ((int) ((j11 >>> 32) ^ j11))) * 1000003) ^ this.f25793f;
    }

    public String toString() {
        return "EventStoreConfig{maxStorageSizeInBytes=" + this.f25789b + ", loadBatchSize=" + this.f25790c + ", criticalSectionEnterTimeoutMs=" + this.f25791d + ", eventCleanUpAge=" + this.f25792e + ", maxBlobByteSizePerRow=" + this.f25793f + "}";
    }

    private a(long j10, int i10, int i11, long j11, int i12) {
        this.f25789b = j10;
        this.f25790c = i10;
        this.f25791d = i11;
        this.f25792e = j11;
        this.f25793f = i12;
    }
}
