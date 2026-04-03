package l5;

/* JADX INFO: compiled from: Lazy.java */
/* JADX INFO: loaded from: classes3.dex */
public class x<T> implements w5.b<T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Object f30897c = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile Object f30898a = f30897c;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile w5.b<T> f30899b;

    public x(w5.b<T> bVar) {
        this.f30899b = bVar;
    }

    @Override // w5.b
    public T get() {
        T t10 = (T) this.f30898a;
        Object obj = f30897c;
        if (t10 == obj) {
            synchronized (this) {
                t10 = (T) this.f30898a;
                if (t10 == obj) {
                    t10 = this.f30899b.get();
                    this.f30898a = t10;
                    this.f30899b = null;
                }
            }
        }
        return t10;
    }
}
