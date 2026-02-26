package x1;

import androidx.annotation.Nullable;
import x1.k;

/* JADX INFO: compiled from: AutoValue_ClientInfo.java */
/* JADX INFO: loaded from: classes2.dex */
final class e extends k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final k.b f35633a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final x1.a f35634b;

    /* JADX INFO: compiled from: AutoValue_ClientInfo.java */
    static final class b extends k.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private k.b f35635a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private x1.a f35636b;

        b() {
        }

        @Override // x1.k.a
        public k a() {
            return new e(this.f35635a, this.f35636b);
        }

        @Override // x1.k.a
        public k.a b(@Nullable x1.a aVar) {
            this.f35636b = aVar;
            return this;
        }

        @Override // x1.k.a
        public k.a c(@Nullable k.b bVar) {
            this.f35635a = bVar;
            return this;
        }
    }

    @Override // x1.k
    @Nullable
    public x1.a b() {
        return this.f35634b;
    }

    @Override // x1.k
    @Nullable
    public k.b c() {
        return this.f35633a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof k)) {
            return false;
        }
        k kVar = (k) obj;
        k.b bVar = this.f35633a;
        if (bVar != null ? bVar.equals(kVar.c()) : kVar.c() == null) {
            x1.a aVar = this.f35634b;
            if (aVar == null) {
                if (kVar.b() == null) {
                    return true;
                }
            } else if (aVar.equals(kVar.b())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        k.b bVar = this.f35633a;
        int iHashCode = ((bVar == null ? 0 : bVar.hashCode()) ^ 1000003) * 1000003;
        x1.a aVar = this.f35634b;
        return iHashCode ^ (aVar != null ? aVar.hashCode() : 0);
    }

    public String toString() {
        return "ClientInfo{clientType=" + this.f35633a + ", androidClientInfo=" + this.f35634b + "}";
    }

    private e(@Nullable k.b bVar, @Nullable x1.a aVar) {
        this.f35633a = bVar;
        this.f35634b = aVar;
    }
}
