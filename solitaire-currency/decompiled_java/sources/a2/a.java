package a2;

/* JADX INFO: compiled from: DoubleCheck.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a<T> implements u8.a<T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Object f83c = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile u8.a<T> f84a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile Object f85b = f83c;

    private a(u8.a<T> aVar) {
        this.f84a = aVar;
    }

    public static <P extends u8.a<T>, T> u8.a<T> a(P p10) {
        d.b(p10);
        return p10 instanceof a ? p10 : new a(p10);
    }

    public static Object b(Object obj, Object obj2) {
        if (!(obj != f83c) || obj == obj2) {
            return obj2;
        }
        throw new IllegalStateException("Scoped provider was invoked recursively returning different results: " + obj + " & " + obj2 + ". This is likely due to a circular dependency.");
    }

    @Override // u8.a
    public T get() {
        T t10 = (T) this.f85b;
        Object obj = f83c;
        if (t10 == obj) {
            synchronized (this) {
                t10 = (T) this.f85b;
                if (t10 == obj) {
                    t10 = this.f84a.get();
                    this.f85b = b(this.f85b, t10);
                    this.f84a = null;
                }
            }
        }
        return t10;
    }
}
