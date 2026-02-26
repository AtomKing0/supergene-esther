package e5;

import e5.v;
import java.io.Serializable;

/* JADX INFO: compiled from: Suppliers.java */
/* JADX INFO: loaded from: classes3.dex */
public final class v {

    /* JADX INFO: compiled from: Suppliers.java */
    static class a<T> implements u<T>, Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final u<T> f25168a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        volatile transient boolean f25169b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        transient T f25170c;

        a(u<T> uVar) {
            this.f25168a = (u) o.j(uVar);
        }

        @Override // e5.u
        public T get() {
            if (!this.f25169b) {
                synchronized (this) {
                    if (!this.f25169b) {
                        T t10 = this.f25168a.get();
                        this.f25170c = t10;
                        this.f25169b = true;
                        return t10;
                    }
                }
            }
            return (T) j.a(this.f25170c);
        }

        public String toString() {
            Object obj;
            StringBuilder sb = new StringBuilder();
            sb.append("Suppliers.memoize(");
            if (this.f25169b) {
                obj = "<supplier that returned " + this.f25170c + ">";
            } else {
                obj = this.f25168a;
            }
            sb.append(obj);
            sb.append(")");
            return sb.toString();
        }
    }

    /* JADX INFO: compiled from: Suppliers.java */
    static class b<T> implements u<T> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final u<Void> f25171c = new u() { // from class: e5.w
            @Override // e5.u
            public final Object get() {
                return v.b.b();
            }
        };

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private volatile u<T> f25172a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private T f25173b;

        b(u<T> uVar) {
            this.f25172a = (u) o.j(uVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ Void b() {
            throw new IllegalStateException();
        }

        @Override // e5.u
        public T get() {
            u<T> uVar = this.f25172a;
            u<T> uVar2 = (u<T>) f25171c;
            if (uVar != uVar2) {
                synchronized (this) {
                    if (this.f25172a != uVar2) {
                        T t10 = this.f25172a.get();
                        this.f25173b = t10;
                        this.f25172a = uVar2;
                        return t10;
                    }
                }
            }
            return (T) j.a(this.f25173b);
        }

        public String toString() {
            Object obj = this.f25172a;
            StringBuilder sb = new StringBuilder();
            sb.append("Suppliers.memoize(");
            if (obj == f25171c) {
                obj = "<supplier that returned " + this.f25173b + ">";
            }
            sb.append(obj);
            sb.append(")");
            return sb.toString();
        }
    }

    /* JADX INFO: compiled from: Suppliers.java */
    private static class c<T> implements u<T>, Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final T f25174a;

        c(T t10) {
            this.f25174a = t10;
        }

        public boolean equals(Object obj) {
            if (obj instanceof c) {
                return k.a(this.f25174a, ((c) obj).f25174a);
            }
            return false;
        }

        @Override // e5.u
        public T get() {
            return this.f25174a;
        }

        public int hashCode() {
            return k.b(this.f25174a);
        }

        public String toString() {
            return "Suppliers.ofInstance(" + this.f25174a + ")";
        }
    }

    public static <T> u<T> a(u<T> uVar) {
        return ((uVar instanceof b) || (uVar instanceof a)) ? uVar : uVar instanceof Serializable ? new a(uVar) : new b(uVar);
    }

    public static <T> u<T> b(T t10) {
        return new c(t10);
    }
}
