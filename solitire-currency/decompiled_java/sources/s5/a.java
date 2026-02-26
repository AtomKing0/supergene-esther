package s5;

import java.lang.annotation.Annotation;
import s5.d;

/* JADX INFO: compiled from: AtProtobuf.java */
/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f33555a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private d.a f33556b = d.a.DEFAULT;

    /* JADX INFO: renamed from: s5.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AtProtobuf.java */
    private static final class C0671a implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f33557a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final d.a f33558b;

        C0671a(int i10, d.a aVar) {
            this.f33557a = i10;
            this.f33558b = aVar;
        }

        @Override // java.lang.annotation.Annotation
        public Class<? extends Annotation> annotationType() {
            return d.class;
        }

        @Override // java.lang.annotation.Annotation
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof d)) {
                return false;
            }
            d dVar = (d) obj;
            return this.f33557a == dVar.tag() && this.f33558b.equals(dVar.intEncoding());
        }

        @Override // java.lang.annotation.Annotation
        public int hashCode() {
            return (14552422 ^ this.f33557a) + (this.f33558b.hashCode() ^ 2041407134);
        }

        @Override // s5.d
        public d.a intEncoding() {
            return this.f33558b;
        }

        @Override // s5.d
        public int tag() {
            return this.f33557a;
        }

        @Override // java.lang.annotation.Annotation
        public String toString() {
            return "@com.google.firebase.encoders.proto.Protobuf(tag=" + this.f33557a + "intEncoding=" + this.f33558b + ')';
        }
    }

    public static a b() {
        return new a();
    }

    public d a() {
        return new C0671a(this.f33555a, this.f33556b);
    }

    public a c(int i10) {
        this.f33555a = i10;
        return this;
    }
}
