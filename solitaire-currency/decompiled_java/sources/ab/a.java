package ab;

import ab.h;
import ga.e0;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import v8.k0;

/* JADX INFO: compiled from: BuiltInConverters.java */
/* JADX INFO: loaded from: classes5.dex */
final class a extends h.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f387a = true;

    /* JADX INFO: renamed from: ab.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: BuiltInConverters.java */
    static final class C0008a implements h<e0, e0> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final C0008a f388a = new C0008a();

        C0008a() {
        }

        @Override // ab.h
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public e0 convert(e0 e0Var) throws IOException {
            try {
                return d0.a(e0Var);
            } finally {
                e0Var.close();
            }
        }
    }

    /* JADX INFO: compiled from: BuiltInConverters.java */
    static final class d implements h<Object, String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final d f391a = new d();

        d() {
        }

        @Override // ab.h
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public String convert(Object obj) {
            return obj.toString();
        }
    }

    /* JADX INFO: compiled from: BuiltInConverters.java */
    static final class e implements h<e0, k0> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final e f392a = new e();

        e() {
        }

        @Override // ab.h
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public k0 convert(e0 e0Var) {
            e0Var.close();
            return k0.f35197a;
        }
    }

    /* JADX INFO: compiled from: BuiltInConverters.java */
    static final class f implements h<e0, Void> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final f f393a = new f();

        f() {
        }

        @Override // ab.h
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void convert(e0 e0Var) {
            e0Var.close();
            return null;
        }
    }

    a() {
    }

    @Override // ab.h.a
    public h<?, ga.c0> c(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, z zVar) {
        if (ga.c0.class.isAssignableFrom(d0.h(type))) {
            return b.f389a;
        }
        return null;
    }

    @Override // ab.h.a
    public h<e0, ?> d(Type type, Annotation[] annotationArr, z zVar) {
        if (type == e0.class) {
            return d0.l(annotationArr, cb.w.class) ? c.f390a : C0008a.f388a;
        }
        if (type == Void.class) {
            return f.f393a;
        }
        if (!this.f387a || type != k0.class) {
            return null;
        }
        try {
            return e.f392a;
        } catch (NoClassDefFoundError unused) {
            this.f387a = false;
            return null;
        }
    }

    /* JADX INFO: compiled from: BuiltInConverters.java */
    static final class b implements h<ga.c0, ga.c0> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final b f389a = new b();

        b() {
        }

        @Override // ab.h
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ga.c0 convert(ga.c0 c0Var) {
            return c0Var;
        }
    }

    /* JADX INFO: compiled from: BuiltInConverters.java */
    static final class c implements h<e0, e0> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final c f390a = new c();

        c() {
        }

        @Override // ab.h
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public e0 convert(e0 e0Var) {
            return e0Var;
        }
    }
}
