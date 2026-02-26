package y1;

import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.util.Arrays;
import y1.o;

/* JADX INFO: compiled from: AutoValue_TransportContext.java */
/* JADX INFO: loaded from: classes2.dex */
final class d extends o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f36390a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final byte[] f36391b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final w1.e f36392c;

    /* JADX INFO: compiled from: AutoValue_TransportContext.java */
    static final class b extends o.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f36393a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private byte[] f36394b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private w1.e f36395c;

        b() {
        }

        @Override // y1.o.a
        public o a() {
            String str = "";
            if (this.f36393a == null) {
                str = " backendName";
            }
            if (this.f36395c == null) {
                str = str + " priority";
            }
            if (str.isEmpty()) {
                return new d(this.f36393a, this.f36394b, this.f36395c);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // y1.o.a
        public o.a b(String str) {
            if (str == null) {
                throw new NullPointerException("Null backendName");
            }
            this.f36393a = str;
            return this;
        }

        @Override // y1.o.a
        public o.a c(@Nullable byte[] bArr) {
            this.f36394b = bArr;
            return this;
        }

        @Override // y1.o.a
        public o.a d(w1.e eVar) {
            if (eVar == null) {
                throw new NullPointerException("Null priority");
            }
            this.f36395c = eVar;
            return this;
        }
    }

    @Override // y1.o
    public String b() {
        return this.f36390a;
    }

    @Override // y1.o
    @Nullable
    public byte[] c() {
        return this.f36391b;
    }

    @Override // y1.o
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public w1.e d() {
        return this.f36392c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof o)) {
            return false;
        }
        o oVar = (o) obj;
        if (this.f36390a.equals(oVar.b())) {
            if (Arrays.equals(this.f36391b, oVar instanceof d ? ((d) oVar).f36391b : oVar.c()) && this.f36392c.equals(oVar.d())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((this.f36390a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f36391b)) * 1000003) ^ this.f36392c.hashCode();
    }

    private d(String str, @Nullable byte[] bArr, w1.e eVar) {
        this.f36390a = str;
        this.f36391b = bArr;
        this.f36392c = eVar;
    }
}
