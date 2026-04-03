package z1;

import androidx.annotation.Nullable;
import java.util.Arrays;
import z1.f;

/* JADX INFO: compiled from: AutoValue_BackendRequest.java */
/* JADX INFO: loaded from: classes2.dex */
final class a extends f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Iterable<y1.i> f36972a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final byte[] f36973b;

    /* JADX INFO: compiled from: AutoValue_BackendRequest.java */
    static final class b extends f.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Iterable<y1.i> f36974a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private byte[] f36975b;

        b() {
        }

        @Override // z1.f.a
        public f a() {
            String str = "";
            if (this.f36974a == null) {
                str = " events";
            }
            if (str.isEmpty()) {
                return new a(this.f36974a, this.f36975b);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // z1.f.a
        public f.a b(Iterable<y1.i> iterable) {
            if (iterable == null) {
                throw new NullPointerException("Null events");
            }
            this.f36974a = iterable;
            return this;
        }

        @Override // z1.f.a
        public f.a c(@Nullable byte[] bArr) {
            this.f36975b = bArr;
            return this;
        }
    }

    @Override // z1.f
    public Iterable<y1.i> b() {
        return this.f36972a;
    }

    @Override // z1.f
    @Nullable
    public byte[] c() {
        return this.f36973b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        if (this.f36972a.equals(fVar.b())) {
            if (Arrays.equals(this.f36973b, fVar instanceof a ? ((a) fVar).f36973b : fVar.c())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((this.f36972a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f36973b);
    }

    public String toString() {
        return "BackendRequest{events=" + this.f36972a + ", extras=" + Arrays.toString(this.f36973b) + "}";
    }

    private a(Iterable<y1.i> iterable, @Nullable byte[] bArr) {
        this.f36972a = iterable;
        this.f36973b = bArr;
    }
}
