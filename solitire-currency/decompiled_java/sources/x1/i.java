package x1;

import androidx.annotation.Nullable;
import x1.o;

/* JADX INFO: compiled from: AutoValue_NetworkConnectionInfo.java */
/* JADX INFO: loaded from: classes2.dex */
final class i extends o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final o.c f35666a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final o.b f35667b;

    /* JADX INFO: compiled from: AutoValue_NetworkConnectionInfo.java */
    static final class b extends o.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private o.c f35668a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private o.b f35669b;

        b() {
        }

        @Override // x1.o.a
        public o a() {
            return new i(this.f35668a, this.f35669b);
        }

        @Override // x1.o.a
        public o.a b(@Nullable o.b bVar) {
            this.f35669b = bVar;
            return this;
        }

        @Override // x1.o.a
        public o.a c(@Nullable o.c cVar) {
            this.f35668a = cVar;
            return this;
        }
    }

    @Override // x1.o
    @Nullable
    public o.b b() {
        return this.f35667b;
    }

    @Override // x1.o
    @Nullable
    public o.c c() {
        return this.f35666a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof o)) {
            return false;
        }
        o oVar = (o) obj;
        o.c cVar = this.f35666a;
        if (cVar != null ? cVar.equals(oVar.c()) : oVar.c() == null) {
            o.b bVar = this.f35667b;
            if (bVar == null) {
                if (oVar.b() == null) {
                    return true;
                }
            } else if (bVar.equals(oVar.b())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        o.c cVar = this.f35666a;
        int iHashCode = ((cVar == null ? 0 : cVar.hashCode()) ^ 1000003) * 1000003;
        o.b bVar = this.f35667b;
        return iHashCode ^ (bVar != null ? bVar.hashCode() : 0);
    }

    public String toString() {
        return "NetworkConnectionInfo{networkType=" + this.f35666a + ", mobileSubtype=" + this.f35667b + "}";
    }

    private i(@Nullable o.c cVar, @Nullable o.b bVar) {
        this.f35666a = cVar;
        this.f35667b = bVar;
    }
}
