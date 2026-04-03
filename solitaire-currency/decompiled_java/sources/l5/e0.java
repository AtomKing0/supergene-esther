package l5;

import java.lang.annotation.Annotation;

/* JADX INFO: compiled from: Qualified.java */
/* JADX INFO: loaded from: classes3.dex */
public final class e0<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Class<? extends Annotation> f30847a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Class<T> f30848b;

    /* JADX INFO: compiled from: Qualified.java */
    private @interface a {
    }

    public e0(Class<? extends Annotation> cls, Class<T> cls2) {
        this.f30847a = cls;
        this.f30848b = cls2;
    }

    public static <T> e0<T> a(Class<? extends Annotation> cls, Class<T> cls2) {
        return new e0<>(cls, cls2);
    }

    public static <T> e0<T> b(Class<T> cls) {
        return new e0<>(a.class, cls);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || e0.class != obj.getClass()) {
            return false;
        }
        e0 e0Var = (e0) obj;
        if (this.f30848b.equals(e0Var.f30848b)) {
            return this.f30847a.equals(e0Var.f30847a);
        }
        return false;
    }

    public int hashCode() {
        return (this.f30848b.hashCode() * 31) + this.f30847a.hashCode();
    }

    public String toString() {
        if (this.f30847a == a.class) {
            return this.f30848b.getName();
        }
        return "@" + this.f30847a.getName() + " " + this.f30848b.getName();
    }
}
