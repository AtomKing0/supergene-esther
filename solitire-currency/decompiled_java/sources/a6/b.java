package a6;

import a6.f;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: AutoValue_TokenResult.java */
/* JADX INFO: loaded from: classes3.dex */
final class b extends f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f301a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f302b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final f.b f303c;

    /* JADX INFO: renamed from: a6.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AutoValue_TokenResult.java */
    static final class C0006b extends f.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f304a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Long f305b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private f.b f306c;

        C0006b() {
        }

        @Override // a6.f.a
        public f a() {
            String str = "";
            if (this.f305b == null) {
                str = " tokenExpirationTimestamp";
            }
            if (str.isEmpty()) {
                return new b(this.f304a, this.f305b.longValue(), this.f306c);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // a6.f.a
        public f.a b(f.b bVar) {
            this.f306c = bVar;
            return this;
        }

        @Override // a6.f.a
        public f.a c(String str) {
            this.f304a = str;
            return this;
        }

        @Override // a6.f.a
        public f.a d(long j10) {
            this.f305b = Long.valueOf(j10);
            return this;
        }
    }

    @Override // a6.f
    @Nullable
    public f.b b() {
        return this.f303c;
    }

    @Override // a6.f
    @Nullable
    public String c() {
        return this.f301a;
    }

    @Override // a6.f
    @NonNull
    public long d() {
        return this.f302b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        String str = this.f301a;
        if (str != null ? str.equals(fVar.c()) : fVar.c() == null) {
            if (this.f302b == fVar.d()) {
                f.b bVar = this.f303c;
                if (bVar == null) {
                    if (fVar.b() == null) {
                        return true;
                    }
                } else if (bVar.equals(fVar.b())) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        String str = this.f301a;
        int iHashCode = str == null ? 0 : str.hashCode();
        long j10 = this.f302b;
        int i10 = (((iHashCode ^ 1000003) * 1000003) ^ ((int) (j10 ^ (j10 >>> 32)))) * 1000003;
        f.b bVar = this.f303c;
        return i10 ^ (bVar != null ? bVar.hashCode() : 0);
    }

    public String toString() {
        return "TokenResult{token=" + this.f301a + ", tokenExpirationTimestamp=" + this.f302b + ", responseCode=" + this.f303c + "}";
    }

    private b(@Nullable String str, long j10, @Nullable f.b bVar) {
        this.f301a = str;
        this.f302b = j10;
        this.f303c = bVar;
    }
}
