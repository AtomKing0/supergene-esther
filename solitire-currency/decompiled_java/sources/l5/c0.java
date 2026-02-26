package l5;

import androidx.annotation.GuardedBy;

/* JADX INFO: compiled from: OptionalProvider.java */
/* JADX INFO: loaded from: classes3.dex */
class c0<T> implements w5.b<T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final w5.a<Object> f30843c = new w5.a() { // from class: l5.a0
        @Override // w5.a
        public final void a(w5.b bVar) {
            c0.d(bVar);
        }
    };

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final w5.b<Object> f30844d = new w5.b() { // from class: l5.b0
        @Override // w5.b
        public final Object get() {
            return c0.e();
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @GuardedBy("this")
    private w5.a<T> f30845a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile w5.b<T> f30846b;

    private c0(w5.a<T> aVar, w5.b<T> bVar) {
        this.f30845a = aVar;
        this.f30846b = bVar;
    }

    static <T> c0<T> c() {
        return new c0<>(f30843c, f30844d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object e() {
        return null;
    }

    void f(w5.b<T> bVar) {
        w5.a<T> aVar;
        if (this.f30846b != f30844d) {
            throw new IllegalStateException("provide() can be called only once.");
        }
        synchronized (this) {
            aVar = this.f30845a;
            this.f30845a = null;
            this.f30846b = bVar;
        }
        aVar.a(bVar);
    }

    @Override // w5.b
    public T get() {
        return this.f30846b.get();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void d(w5.b bVar) {
    }
}
