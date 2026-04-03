package f2;

import f2.f;
import java.util.Set;

/* JADX INFO: compiled from: AutoValue_SchedulerConfig_ConfigValue.java */
/* JADX INFO: loaded from: classes2.dex */
final class c extends f.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f25588a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f25589b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Set<f.c> f25590c;

    /* JADX INFO: compiled from: AutoValue_SchedulerConfig_ConfigValue.java */
    static final class b extends f.b.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Long f25591a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Long f25592b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Set<f.c> f25593c;

        b() {
        }

        @Override // f2.f.b.a
        public f.b a() {
            String str = "";
            if (this.f25591a == null) {
                str = " delta";
            }
            if (this.f25592b == null) {
                str = str + " maxAllowedDelay";
            }
            if (this.f25593c == null) {
                str = str + " flags";
            }
            if (str.isEmpty()) {
                return new c(this.f25591a.longValue(), this.f25592b.longValue(), this.f25593c);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // f2.f.b.a
        public f.b.a b(long j10) {
            this.f25591a = Long.valueOf(j10);
            return this;
        }

        @Override // f2.f.b.a
        public f.b.a c(Set<f.c> set) {
            if (set == null) {
                throw new NullPointerException("Null flags");
            }
            this.f25593c = set;
            return this;
        }

        @Override // f2.f.b.a
        public f.b.a d(long j10) {
            this.f25592b = Long.valueOf(j10);
            return this;
        }
    }

    @Override // f2.f.b
    long b() {
        return this.f25588a;
    }

    @Override // f2.f.b
    Set<f.c> c() {
        return this.f25590c;
    }

    @Override // f2.f.b
    long d() {
        return this.f25589b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f.b)) {
            return false;
        }
        f.b bVar = (f.b) obj;
        return this.f25588a == bVar.b() && this.f25589b == bVar.d() && this.f25590c.equals(bVar.c());
    }

    public int hashCode() {
        long j10 = this.f25588a;
        int i10 = (((int) (j10 ^ (j10 >>> 32))) ^ 1000003) * 1000003;
        long j11 = this.f25589b;
        return ((i10 ^ ((int) ((j11 >>> 32) ^ j11))) * 1000003) ^ this.f25590c.hashCode();
    }

    public String toString() {
        return "ConfigValue{delta=" + this.f25588a + ", maxAllowedDelay=" + this.f25589b + ", flags=" + this.f25590c + "}";
    }

    private c(long j10, long j11, Set<f.c> set) {
        this.f25588a = j10;
        this.f25589b = j11;
        this.f25590c = set;
    }
}
