package y1;

import y1.n;

/* JADX INFO: compiled from: AutoValue_SendRequest.java */
/* JADX INFO: loaded from: classes2.dex */
final class c extends n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final o f36380a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f36381b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final w1.d<?> f36382c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final w1.g<?, byte[]> f36383d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final w1.c f36384e;

    /* JADX INFO: compiled from: AutoValue_SendRequest.java */
    static final class b extends n.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private o f36385a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f36386b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private w1.d<?> f36387c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private w1.g<?, byte[]> f36388d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private w1.c f36389e;

        b() {
        }

        @Override // y1.n.a
        public n a() {
            String str = "";
            if (this.f36385a == null) {
                str = " transportContext";
            }
            if (this.f36386b == null) {
                str = str + " transportName";
            }
            if (this.f36387c == null) {
                str = str + " event";
            }
            if (this.f36388d == null) {
                str = str + " transformer";
            }
            if (this.f36389e == null) {
                str = str + " encoding";
            }
            if (str.isEmpty()) {
                return new c(this.f36385a, this.f36386b, this.f36387c, this.f36388d, this.f36389e);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // y1.n.a
        n.a b(w1.c cVar) {
            if (cVar == null) {
                throw new NullPointerException("Null encoding");
            }
            this.f36389e = cVar;
            return this;
        }

        @Override // y1.n.a
        n.a c(w1.d<?> dVar) {
            if (dVar == null) {
                throw new NullPointerException("Null event");
            }
            this.f36387c = dVar;
            return this;
        }

        @Override // y1.n.a
        n.a d(w1.g<?, byte[]> gVar) {
            if (gVar == null) {
                throw new NullPointerException("Null transformer");
            }
            this.f36388d = gVar;
            return this;
        }

        @Override // y1.n.a
        public n.a e(o oVar) {
            if (oVar == null) {
                throw new NullPointerException("Null transportContext");
            }
            this.f36385a = oVar;
            return this;
        }

        @Override // y1.n.a
        public n.a f(String str) {
            if (str == null) {
                throw new NullPointerException("Null transportName");
            }
            this.f36386b = str;
            return this;
        }
    }

    @Override // y1.n
    public w1.c b() {
        return this.f36384e;
    }

    @Override // y1.n
    w1.d<?> c() {
        return this.f36382c;
    }

    @Override // y1.n
    w1.g<?, byte[]> e() {
        return this.f36383d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof n)) {
            return false;
        }
        n nVar = (n) obj;
        return this.f36380a.equals(nVar.f()) && this.f36381b.equals(nVar.g()) && this.f36382c.equals(nVar.c()) && this.f36383d.equals(nVar.e()) && this.f36384e.equals(nVar.b());
    }

    @Override // y1.n
    public o f() {
        return this.f36380a;
    }

    @Override // y1.n
    public String g() {
        return this.f36381b;
    }

    public int hashCode() {
        return ((((((((this.f36380a.hashCode() ^ 1000003) * 1000003) ^ this.f36381b.hashCode()) * 1000003) ^ this.f36382c.hashCode()) * 1000003) ^ this.f36383d.hashCode()) * 1000003) ^ this.f36384e.hashCode();
    }

    public String toString() {
        return "SendRequest{transportContext=" + this.f36380a + ", transportName=" + this.f36381b + ", event=" + this.f36382c + ", transformer=" + this.f36383d + ", encoding=" + this.f36384e + "}";
    }

    private c(o oVar, String str, w1.d<?> dVar, w1.g<?, byte[]> gVar, w1.c cVar) {
        this.f36380a = oVar;
        this.f36381b = str;
        this.f36382c = dVar;
        this.f36383d = gVar;
        this.f36384e = cVar;
    }
}
