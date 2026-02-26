package ab;

import ab.a;
import ab.c;
import ab.h;
import ga.e;
import ga.e0;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: Retrofit.java */
/* JADX INFO: loaded from: classes5.dex */
public final class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<Method, a0<?>> f568a = new ConcurrentHashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final e.a f569b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final ga.v f570c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final List<h.a> f571d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final List<c.a> f572e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final Executor f573f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final boolean f574g;

    /* JADX INFO: compiled from: Retrofit.java */
    class a implements InvocationHandler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final v f575a = v.f();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Object[] f576b = new Object[0];

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Class f577c;

        a(Class cls) {
            this.f577c = cls;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            if (method.getDeclaringClass() == Object.class) {
                return method.invoke(this, objArr);
            }
            if (this.f575a.h(method)) {
                return this.f575a.g(method, this.f577c, obj, objArr);
            }
            a0<?> a0VarC = z.this.c(method);
            if (objArr == null) {
                objArr = this.f576b;
            }
            return a0VarC.a(objArr);
        }
    }

    z(e.a aVar, ga.v vVar, List<h.a> list, List<c.a> list2, Executor executor, boolean z10) {
        this.f569b = aVar;
        this.f570c = vVar;
        this.f571d = list;
        this.f572e = list2;
        this.f573f = executor;
        this.f574g = z10;
    }

    private void j(Class<?> cls) {
        if (!cls.isInterface()) {
            throw new IllegalArgumentException("API declarations must be interfaces.");
        }
        ArrayDeque arrayDeque = new ArrayDeque(1);
        arrayDeque.add(cls);
        while (!arrayDeque.isEmpty()) {
            Class<?> cls2 = (Class) arrayDeque.removeFirst();
            if (cls2.getTypeParameters().length != 0) {
                StringBuilder sb = new StringBuilder("Type parameters are unsupported on ");
                sb.append(cls2.getName());
                if (cls2 != cls) {
                    sb.append(" which is an interface of ");
                    sb.append(cls.getName());
                }
                throw new IllegalArgumentException(sb.toString());
            }
            Collections.addAll(arrayDeque, cls2.getInterfaces());
        }
        if (this.f574g) {
            v vVarF = v.f();
            for (Method method : cls.getDeclaredMethods()) {
                if (!vVarF.h(method) && !Modifier.isStatic(method.getModifiers())) {
                    c(method);
                }
            }
        }
    }

    public c<?, ?> a(Type type, Annotation[] annotationArr) {
        return d(null, type, annotationArr);
    }

    public <T> T b(Class<T> cls) {
        j(cls);
        return (T) Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new a(cls));
    }

    a0<?> c(Method method) {
        a0<?> a0VarB;
        a0<?> a0Var = this.f568a.get(method);
        if (a0Var != null) {
            return a0Var;
        }
        synchronized (this.f568a) {
            a0VarB = this.f568a.get(method);
            if (a0VarB == null) {
                a0VarB = a0.b(this, method);
                this.f568a.put(method, a0VarB);
            }
        }
        return a0VarB;
    }

    public c<?, ?> d(c.a aVar, Type type, Annotation[] annotationArr) {
        Objects.requireNonNull(type, "returnType == null");
        Objects.requireNonNull(annotationArr, "annotations == null");
        int iIndexOf = this.f572e.indexOf(aVar) + 1;
        int size = this.f572e.size();
        for (int i10 = iIndexOf; i10 < size; i10++) {
            c<?, ?> cVarA = this.f572e.get(i10).a(type, annotationArr, this);
            if (cVarA != null) {
                return cVarA;
            }
        }
        StringBuilder sb = new StringBuilder("Could not locate call adapter for ");
        sb.append(type);
        sb.append(".\n");
        if (aVar != null) {
            sb.append("  Skipped:");
            for (int i11 = 0; i11 < iIndexOf; i11++) {
                sb.append("\n   * ");
                sb.append(this.f572e.get(i11).getClass().getName());
            }
            sb.append('\n');
        }
        sb.append("  Tried:");
        int size2 = this.f572e.size();
        while (iIndexOf < size2) {
            sb.append("\n   * ");
            sb.append(this.f572e.get(iIndexOf).getClass().getName());
            iIndexOf++;
        }
        throw new IllegalArgumentException(sb.toString());
    }

    public <T> h<T, ga.c0> e(h.a aVar, Type type, Annotation[] annotationArr, Annotation[] annotationArr2) {
        Objects.requireNonNull(type, "type == null");
        Objects.requireNonNull(annotationArr, "parameterAnnotations == null");
        Objects.requireNonNull(annotationArr2, "methodAnnotations == null");
        int iIndexOf = this.f571d.indexOf(aVar) + 1;
        int size = this.f571d.size();
        for (int i10 = iIndexOf; i10 < size; i10++) {
            h<T, ga.c0> hVar = (h<T, ga.c0>) this.f571d.get(i10).c(type, annotationArr, annotationArr2, this);
            if (hVar != null) {
                return hVar;
            }
        }
        StringBuilder sb = new StringBuilder("Could not locate RequestBody converter for ");
        sb.append(type);
        sb.append(".\n");
        if (aVar != null) {
            sb.append("  Skipped:");
            for (int i11 = 0; i11 < iIndexOf; i11++) {
                sb.append("\n   * ");
                sb.append(this.f571d.get(i11).getClass().getName());
            }
            sb.append('\n');
        }
        sb.append("  Tried:");
        int size2 = this.f571d.size();
        while (iIndexOf < size2) {
            sb.append("\n   * ");
            sb.append(this.f571d.get(iIndexOf).getClass().getName());
            iIndexOf++;
        }
        throw new IllegalArgumentException(sb.toString());
    }

    public <T> h<e0, T> f(h.a aVar, Type type, Annotation[] annotationArr) {
        Objects.requireNonNull(type, "type == null");
        Objects.requireNonNull(annotationArr, "annotations == null");
        int iIndexOf = this.f571d.indexOf(aVar) + 1;
        int size = this.f571d.size();
        for (int i10 = iIndexOf; i10 < size; i10++) {
            h<e0, T> hVar = (h<e0, T>) this.f571d.get(i10).d(type, annotationArr, this);
            if (hVar != null) {
                return hVar;
            }
        }
        StringBuilder sb = new StringBuilder("Could not locate ResponseBody converter for ");
        sb.append(type);
        sb.append(".\n");
        if (aVar != null) {
            sb.append("  Skipped:");
            for (int i11 = 0; i11 < iIndexOf; i11++) {
                sb.append("\n   * ");
                sb.append(this.f571d.get(i11).getClass().getName());
            }
            sb.append('\n');
        }
        sb.append("  Tried:");
        int size2 = this.f571d.size();
        while (iIndexOf < size2) {
            sb.append("\n   * ");
            sb.append(this.f571d.get(iIndexOf).getClass().getName());
            iIndexOf++;
        }
        throw new IllegalArgumentException(sb.toString());
    }

    public <T> h<T, ga.c0> g(Type type, Annotation[] annotationArr, Annotation[] annotationArr2) {
        return e(null, type, annotationArr, annotationArr2);
    }

    public <T> h<e0, T> h(Type type, Annotation[] annotationArr) {
        return f(null, type, annotationArr);
    }

    public <T> h<T, String> i(Type type, Annotation[] annotationArr) {
        Objects.requireNonNull(type, "type == null");
        Objects.requireNonNull(annotationArr, "annotations == null");
        int size = this.f571d.size();
        for (int i10 = 0; i10 < size; i10++) {
            h<T, String> hVar = (h<T, String>) this.f571d.get(i10).e(type, annotationArr, this);
            if (hVar != null) {
                return hVar;
            }
        }
        return a.d.f391a;
    }

    /* JADX INFO: compiled from: Retrofit.java */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final v f579a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private e.a f580b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private ga.v f581c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final List<h.a> f582d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final List<c.a> f583e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private Executor f584f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private boolean f585g;

        b(v vVar) {
            this.f582d = new ArrayList();
            this.f583e = new ArrayList();
            this.f579a = vVar;
        }

        public b a(h.a aVar) {
            List<h.a> list = this.f582d;
            Objects.requireNonNull(aVar, "factory == null");
            list.add(aVar);
            return this;
        }

        public b b(ga.v vVar) {
            Objects.requireNonNull(vVar, "baseUrl == null");
            if ("".equals(vVar.m().get(r0.size() - 1))) {
                this.f581c = vVar;
                return this;
            }
            throw new IllegalArgumentException("baseUrl must end in /: " + vVar);
        }

        public b c(String str) {
            Objects.requireNonNull(str, "baseUrl == null");
            return b(ga.v.h(str));
        }

        public z d() {
            if (this.f581c == null) {
                throw new IllegalStateException("Base URL required.");
            }
            e.a zVar = this.f580b;
            if (zVar == null) {
                zVar = new ga.z();
            }
            e.a aVar = zVar;
            Executor executorB = this.f584f;
            if (executorB == null) {
                executorB = this.f579a.b();
            }
            Executor executor = executorB;
            ArrayList arrayList = new ArrayList(this.f583e);
            arrayList.addAll(this.f579a.a(executor));
            ArrayList arrayList2 = new ArrayList(this.f582d.size() + 1 + this.f579a.d());
            arrayList2.add(new ab.a());
            arrayList2.addAll(this.f582d);
            arrayList2.addAll(this.f579a.c());
            return new z(aVar, this.f581c, Collections.unmodifiableList(arrayList2), Collections.unmodifiableList(arrayList), executor, this.f585g);
        }

        public b e(e.a aVar) {
            Objects.requireNonNull(aVar, "factory == null");
            this.f580b = aVar;
            return this;
        }

        public b f(ga.z zVar) {
            Objects.requireNonNull(zVar, "client == null");
            return e(zVar);
        }

        public b() {
            this(v.f());
        }
    }
}
