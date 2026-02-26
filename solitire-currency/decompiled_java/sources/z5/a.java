package z5;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import z5.c;
import z5.d;

/* JADX INFO: compiled from: AutoValue_PersistedInstallationEntry.java */
/* JADX INFO: loaded from: classes3.dex */
final class a extends d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f37565b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final c.a f37566c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f37567d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f37568e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final long f37569f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final long f37570g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final String f37571h;

    /* JADX INFO: compiled from: AutoValue_PersistedInstallationEntry.java */
    static final class b extends d.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f37572a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private c.a f37573b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f37574c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private String f37575d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private Long f37576e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private Long f37577f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private String f37578g;

        @Override // z5.d.a
        public d a() {
            String str = "";
            if (this.f37573b == null) {
                str = " registrationStatus";
            }
            if (this.f37576e == null) {
                str = str + " expiresInSecs";
            }
            if (this.f37577f == null) {
                str = str + " tokenCreationEpochInSecs";
            }
            if (str.isEmpty()) {
                return new a(this.f37572a, this.f37573b, this.f37574c, this.f37575d, this.f37576e.longValue(), this.f37577f.longValue(), this.f37578g);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // z5.d.a
        public d.a b(@Nullable String str) {
            this.f37574c = str;
            return this;
        }

        @Override // z5.d.a
        public d.a c(long j10) {
            this.f37576e = Long.valueOf(j10);
            return this;
        }

        @Override // z5.d.a
        public d.a d(String str) {
            this.f37572a = str;
            return this;
        }

        @Override // z5.d.a
        public d.a e(@Nullable String str) {
            this.f37578g = str;
            return this;
        }

        @Override // z5.d.a
        public d.a f(@Nullable String str) {
            this.f37575d = str;
            return this;
        }

        @Override // z5.d.a
        public d.a g(c.a aVar) {
            if (aVar == null) {
                throw new NullPointerException("Null registrationStatus");
            }
            this.f37573b = aVar;
            return this;
        }

        @Override // z5.d.a
        public d.a h(long j10) {
            this.f37577f = Long.valueOf(j10);
            return this;
        }

        b() {
        }

        private b(d dVar) {
            this.f37572a = dVar.d();
            this.f37573b = dVar.g();
            this.f37574c = dVar.b();
            this.f37575d = dVar.f();
            this.f37576e = Long.valueOf(dVar.c());
            this.f37577f = Long.valueOf(dVar.h());
            this.f37578g = dVar.e();
        }
    }

    @Override // z5.d
    @Nullable
    public String b() {
        return this.f37567d;
    }

    @Override // z5.d
    public long c() {
        return this.f37569f;
    }

    @Override // z5.d
    @Nullable
    public String d() {
        return this.f37565b;
    }

    @Override // z5.d
    @Nullable
    public String e() {
        return this.f37571h;
    }

    public boolean equals(Object obj) {
        String str;
        String str2;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        String str3 = this.f37565b;
        if (str3 != null ? str3.equals(dVar.d()) : dVar.d() == null) {
            if (this.f37566c.equals(dVar.g()) && ((str = this.f37567d) != null ? str.equals(dVar.b()) : dVar.b() == null) && ((str2 = this.f37568e) != null ? str2.equals(dVar.f()) : dVar.f() == null) && this.f37569f == dVar.c() && this.f37570g == dVar.h()) {
                String str4 = this.f37571h;
                if (str4 == null) {
                    if (dVar.e() == null) {
                        return true;
                    }
                } else if (str4.equals(dVar.e())) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // z5.d
    @Nullable
    public String f() {
        return this.f37568e;
    }

    @Override // z5.d
    @NonNull
    public c.a g() {
        return this.f37566c;
    }

    @Override // z5.d
    public long h() {
        return this.f37570g;
    }

    public int hashCode() {
        String str = this.f37565b;
        int iHashCode = ((((str == null ? 0 : str.hashCode()) ^ 1000003) * 1000003) ^ this.f37566c.hashCode()) * 1000003;
        String str2 = this.f37567d;
        int iHashCode2 = (iHashCode ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.f37568e;
        int iHashCode3 = (iHashCode2 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        long j10 = this.f37569f;
        int i10 = (iHashCode3 ^ ((int) (j10 ^ (j10 >>> 32)))) * 1000003;
        long j11 = this.f37570g;
        int i11 = (i10 ^ ((int) (j11 ^ (j11 >>> 32)))) * 1000003;
        String str4 = this.f37571h;
        return i11 ^ (str4 != null ? str4.hashCode() : 0);
    }

    @Override // z5.d
    public d.a n() {
        return new b(this);
    }

    public String toString() {
        return "PersistedInstallationEntry{firebaseInstallationId=" + this.f37565b + ", registrationStatus=" + this.f37566c + ", authToken=" + this.f37567d + ", refreshToken=" + this.f37568e + ", expiresInSecs=" + this.f37569f + ", tokenCreationEpochInSecs=" + this.f37570g + ", fisError=" + this.f37571h + "}";
    }

    private a(@Nullable String str, c.a aVar, @Nullable String str2, @Nullable String str3, long j10, long j11, @Nullable String str4) {
        this.f37565b = str;
        this.f37566c = aVar;
        this.f37567d = str2;
        this.f37568e = str3;
        this.f37569f = j10;
        this.f37570g = j11;
        this.f37571h = str4;
    }
}
