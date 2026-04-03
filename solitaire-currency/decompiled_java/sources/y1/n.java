package y1;

import com.google.auto.value.AutoValue;
import y1.c;

/* JADX INFO: compiled from: SendRequest.java */
/* JADX INFO: loaded from: classes2.dex */
@AutoValue
abstract class n {

    /* JADX INFO: compiled from: SendRequest.java */
    @AutoValue.Builder
    public static abstract class a {
        public abstract n a();

        abstract a b(w1.c cVar);

        abstract a c(w1.d<?> dVar);

        abstract a d(w1.g<?, byte[]> gVar);

        public abstract a e(o oVar);

        public abstract a f(String str);
    }

    n() {
    }

    public static a a() {
        return new c.b();
    }

    public abstract w1.c b();

    abstract w1.d<?> c();

    public byte[] d() {
        return e().apply(c().b());
    }

    abstract w1.g<?, byte[]> e();

    public abstract o f();

    public abstract String g();
}
