package y1;

import androidx.annotation.Nullable;
import java.util.Map;
import y1.i;

/* JADX INFO: compiled from: AutoValue_EventInternal.java */
/* JADX INFO: loaded from: classes2.dex */
final class b extends i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f36368a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Integer f36369b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final h f36370c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f36371d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final long f36372e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Map<String, String> f36373f;

    /* JADX INFO: renamed from: y1.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AutoValue_EventInternal.java */
    static final class C0739b extends i.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f36374a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Integer f36375b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private h f36376c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private Long f36377d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private Long f36378e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private Map<String, String> f36379f;

        C0739b() {
        }

        @Override // y1.i.a
        public i d() {
            String str = "";
            if (this.f36374a == null) {
                str = " transportName";
            }
            if (this.f36376c == null) {
                str = str + " encodedPayload";
            }
            if (this.f36377d == null) {
                str = str + " eventMillis";
            }
            if (this.f36378e == null) {
                str = str + " uptimeMillis";
            }
            if (this.f36379f == null) {
                str = str + " autoMetadata";
            }
            if (str.isEmpty()) {
                return new b(this.f36374a, this.f36375b, this.f36376c, this.f36377d.longValue(), this.f36378e.longValue(), this.f36379f);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // y1.i.a
        protected Map<String, String> e() {
            Map<String, String> map = this.f36379f;
            if (map != null) {
                return map;
            }
            throw new IllegalStateException("Property \"autoMetadata\" has not been set");
        }

        @Override // y1.i.a
        protected i.a f(Map<String, String> map) {
            if (map == null) {
                throw new NullPointerException("Null autoMetadata");
            }
            this.f36379f = map;
            return this;
        }

        @Override // y1.i.a
        public i.a g(Integer num) {
            this.f36375b = num;
            return this;
        }

        @Override // y1.i.a
        public i.a h(h hVar) {
            if (hVar == null) {
                throw new NullPointerException("Null encodedPayload");
            }
            this.f36376c = hVar;
            return this;
        }

        @Override // y1.i.a
        public i.a i(long j10) {
            this.f36377d = Long.valueOf(j10);
            return this;
        }

        @Override // y1.i.a
        public i.a j(String str) {
            if (str == null) {
                throw new NullPointerException("Null transportName");
            }
            this.f36374a = str;
            return this;
        }

        @Override // y1.i.a
        public i.a k(long j10) {
            this.f36378e = Long.valueOf(j10);
            return this;
        }
    }

    @Override // y1.i
    protected Map<String, String> c() {
        return this.f36373f;
    }

    @Override // y1.i
    @Nullable
    public Integer d() {
        return this.f36369b;
    }

    @Override // y1.i
    public h e() {
        return this.f36370c;
    }

    public boolean equals(Object obj) {
        Integer num;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        return this.f36368a.equals(iVar.j()) && ((num = this.f36369b) != null ? num.equals(iVar.d()) : iVar.d() == null) && this.f36370c.equals(iVar.e()) && this.f36371d == iVar.f() && this.f36372e == iVar.k() && this.f36373f.equals(iVar.c());
    }

    @Override // y1.i
    public long f() {
        return this.f36371d;
    }

    public int hashCode() {
        int iHashCode = (this.f36368a.hashCode() ^ 1000003) * 1000003;
        Integer num = this.f36369b;
        int iHashCode2 = (((iHashCode ^ (num == null ? 0 : num.hashCode())) * 1000003) ^ this.f36370c.hashCode()) * 1000003;
        long j10 = this.f36371d;
        int i10 = (iHashCode2 ^ ((int) (j10 ^ (j10 >>> 32)))) * 1000003;
        long j11 = this.f36372e;
        return ((i10 ^ ((int) (j11 ^ (j11 >>> 32)))) * 1000003) ^ this.f36373f.hashCode();
    }

    @Override // y1.i
    public String j() {
        return this.f36368a;
    }

    @Override // y1.i
    public long k() {
        return this.f36372e;
    }

    public String toString() {
        return "EventInternal{transportName=" + this.f36368a + ", code=" + this.f36369b + ", encodedPayload=" + this.f36370c + ", eventMillis=" + this.f36371d + ", uptimeMillis=" + this.f36372e + ", autoMetadata=" + this.f36373f + "}";
    }

    private b(String str, @Nullable Integer num, h hVar, long j10, long j11, Map<String, String> map) {
        this.f36368a = str;
        this.f36369b = num;
        this.f36370c = hVar;
        this.f36371d = j10;
        this.f36372e = j11;
        this.f36373f = map;
    }
}
