package m1;

import m1.b;

/* JADX INFO: compiled from: NoTransition.java */
/* JADX INFO: loaded from: classes2.dex */
public class a<R> implements b<R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final a<?> f31140a = new a<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final c<?> f31141b = new C0625a();

    /* JADX INFO: renamed from: m1.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: NoTransition.java */
    public static class C0625a<R> implements c<R> {
        @Override // m1.c
        public b<R> a(r0.a aVar, boolean z10) {
            return a.f31140a;
        }
    }

    public static <R> c<R> b() {
        return (c<R>) f31141b;
    }

    @Override // m1.b
    public boolean a(Object obj, b.a aVar) {
        return false;
    }
}
