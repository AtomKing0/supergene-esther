package ab;

import ab.d0;
import ga.e;
import ga.e0;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/* JADX INFO: compiled from: HttpServiceMethod.java */
/* JADX INFO: loaded from: classes5.dex */
abstract class m<ResponseT, ReturnT> extends a0<ReturnT> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final x f427a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final e.a f428b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final h<e0, ResponseT> f429c;

    /* JADX INFO: compiled from: HttpServiceMethod.java */
    static final class a<ResponseT, ReturnT> extends m<ResponseT, ReturnT> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final ab.c<ResponseT, ReturnT> f430d;

        a(x xVar, e.a aVar, h<e0, ResponseT> hVar, ab.c<ResponseT, ReturnT> cVar) {
            super(xVar, aVar, hVar);
            this.f430d = cVar;
        }

        @Override // ab.m
        protected ReturnT c(ab.b<ResponseT> bVar, Object[] objArr) {
            return this.f430d.b(bVar);
        }
    }

    /* JADX INFO: compiled from: HttpServiceMethod.java */
    static final class b<ResponseT> extends m<ResponseT, Object> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final ab.c<ResponseT, ab.b<ResponseT>> f431d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final boolean f432e;

        b(x xVar, e.a aVar, h<e0, ResponseT> hVar, ab.c<ResponseT, ab.b<ResponseT>> cVar, boolean z10) {
            super(xVar, aVar, hVar);
            this.f431d = cVar;
            this.f432e = z10;
        }

        @Override // ab.m
        protected Object c(ab.b<ResponseT> bVar, Object[] objArr) {
            ab.b<ResponseT> bVarB = this.f431d.b(bVar);
            z8.d dVar = (z8.d) objArr[objArr.length - 1];
            try {
                return this.f432e ? o.b(bVarB, dVar) : o.a(bVarB, dVar);
            } catch (Exception e10) {
                return o.d(e10, dVar);
            }
        }
    }

    /* JADX INFO: compiled from: HttpServiceMethod.java */
    static final class c<ResponseT> extends m<ResponseT, Object> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final ab.c<ResponseT, ab.b<ResponseT>> f433d;

        c(x xVar, e.a aVar, h<e0, ResponseT> hVar, ab.c<ResponseT, ab.b<ResponseT>> cVar) {
            super(xVar, aVar, hVar);
            this.f433d = cVar;
        }

        @Override // ab.m
        protected Object c(ab.b<ResponseT> bVar, Object[] objArr) {
            ab.b<ResponseT> bVarB = this.f433d.b(bVar);
            z8.d dVar = (z8.d) objArr[objArr.length - 1];
            try {
                return o.c(bVarB, dVar);
            } catch (Exception e10) {
                return o.d(e10, dVar);
            }
        }
    }

    m(x xVar, e.a aVar, h<e0, ResponseT> hVar) {
        this.f427a = xVar;
        this.f428b = aVar;
        this.f429c = hVar;
    }

    private static <ResponseT, ReturnT> ab.c<ResponseT, ReturnT> d(z zVar, Method method, Type type, Annotation[] annotationArr) {
        try {
            return (ab.c<ResponseT, ReturnT>) zVar.a(type, annotationArr);
        } catch (RuntimeException e10) {
            throw d0.n(method, e10, "Unable to create call adapter for %s", type);
        }
    }

    private static <ResponseT> h<e0, ResponseT> e(z zVar, Method method, Type type) {
        try {
            return zVar.h(type, method.getAnnotations());
        } catch (RuntimeException e10) {
            throw d0.n(method, e10, "Unable to create converter for %s", type);
        }
    }

    static <ResponseT, ReturnT> m<ResponseT, ReturnT> f(z zVar, Method method, x xVar) {
        Type genericReturnType;
        boolean z10;
        boolean z11 = xVar.f539k;
        Annotation[] annotations = method.getAnnotations();
        if (z11) {
            Type[] genericParameterTypes = method.getGenericParameterTypes();
            Type typeF = d0.f(0, (ParameterizedType) genericParameterTypes[genericParameterTypes.length - 1]);
            if (d0.h(typeF) == y.class && (typeF instanceof ParameterizedType)) {
                typeF = d0.g(0, (ParameterizedType) typeF);
                z10 = true;
            } else {
                z10 = false;
            }
            genericReturnType = new d0.b(null, ab.b.class, typeF);
            annotations = c0.a(annotations);
        } else {
            genericReturnType = method.getGenericReturnType();
            z10 = false;
        }
        ab.c cVarD = d(zVar, method, genericReturnType, annotations);
        Type typeA = cVarD.a();
        if (typeA == ga.d0.class) {
            throw d0.m(method, "'" + d0.h(typeA).getName() + "' is not a valid response body type. Did you mean ResponseBody?", new Object[0]);
        }
        if (typeA == y.class) {
            throw d0.m(method, "Response must include generic type (e.g., Response<String>)", new Object[0]);
        }
        if (xVar.f531c.equals("HEAD") && !Void.class.equals(typeA)) {
            throw d0.m(method, "HEAD method must use Void as response type.", new Object[0]);
        }
        h hVarE = e(zVar, method, typeA);
        e.a aVar = zVar.f569b;
        return !z11 ? new a(xVar, aVar, hVarE, cVarD) : z10 ? new c(xVar, aVar, hVarE, cVarD) : new b(xVar, aVar, hVarE, cVarD, false);
    }

    @Override // ab.a0
    final ReturnT a(Object[] objArr) {
        return c(new p(this.f427a, objArr, this.f428b, this.f429c), objArr);
    }

    protected abstract ReturnT c(ab.b<ResponseT> bVar, Object[] objArr);
}
