package a6;

import a6.d;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: AutoValue_InstallationResponse.java */
/* JADX INFO: loaded from: classes3.dex */
final class a extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f291a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f292b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f293c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final f f294d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final d.b f295e;

    /* JADX INFO: compiled from: AutoValue_InstallationResponse.java */
    static final class b extends d.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f296a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f297b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f298c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private f f299d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private d.b f300e;

        b() {
        }

        @Override // a6.d.a
        public d a() {
            return new a(this.f296a, this.f297b, this.f298c, this.f299d, this.f300e);
        }

        @Override // a6.d.a
        public d.a b(f fVar) {
            this.f299d = fVar;
            return this;
        }

        @Override // a6.d.a
        public d.a c(String str) {
            this.f297b = str;
            return this;
        }

        @Override // a6.d.a
        public d.a d(String str) {
            this.f298c = str;
            return this;
        }

        @Override // a6.d.a
        public d.a e(d.b bVar) {
            this.f300e = bVar;
            return this;
        }

        @Override // a6.d.a
        public d.a f(String str) {
            this.f296a = str;
            return this;
        }
    }

    @Override // a6.d
    @Nullable
    public f b() {
        return this.f294d;
    }

    @Override // a6.d
    @Nullable
    public String c() {
        return this.f292b;
    }

    @Override // a6.d
    @Nullable
    public String d() {
        return this.f293c;
    }

    @Override // a6.d
    @Nullable
    public d.b e() {
        return this.f295e;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        String str = this.f291a;
        if (str != null ? str.equals(dVar.f()) : dVar.f() == null) {
            String str2 = this.f292b;
            if (str2 != null ? str2.equals(dVar.c()) : dVar.c() == null) {
                String str3 = this.f293c;
                if (str3 != null ? str3.equals(dVar.d()) : dVar.d() == null) {
                    f fVar = this.f294d;
                    if (fVar != null ? fVar.equals(dVar.b()) : dVar.b() == null) {
                        d.b bVar = this.f295e;
                        if (bVar == null) {
                            if (dVar.e() == null) {
                                return true;
                            }
                        } else if (bVar.equals(dVar.e())) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    @Override // a6.d
    @Nullable
    public String f() {
        return this.f291a;
    }

    public int hashCode() {
        String str = this.f291a;
        int iHashCode = ((str == null ? 0 : str.hashCode()) ^ 1000003) * 1000003;
        String str2 = this.f292b;
        int iHashCode2 = (iHashCode ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.f293c;
        int iHashCode3 = (iHashCode2 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        f fVar = this.f294d;
        int iHashCode4 = (iHashCode3 ^ (fVar == null ? 0 : fVar.hashCode())) * 1000003;
        d.b bVar = this.f295e;
        return iHashCode4 ^ (bVar != null ? bVar.hashCode() : 0);
    }

    public String toString() {
        return "InstallationResponse{uri=" + this.f291a + ", fid=" + this.f292b + ", refreshToken=" + this.f293c + ", authToken=" + this.f294d + ", responseCode=" + this.f295e + "}";
    }

    private a(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable f fVar, @Nullable d.b bVar) {
        this.f291a = str;
        this.f292b = str2;
        this.f293c = str3;
        this.f294d = fVar;
        this.f295e = bVar;
    }
}
