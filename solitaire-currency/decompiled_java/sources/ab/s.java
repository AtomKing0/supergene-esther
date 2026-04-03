package ab;

import ga.y;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: ParameterHandler.java */
/* JADX INFO: loaded from: classes5.dex */
abstract class s<T> {

    /* JADX INFO: compiled from: ParameterHandler.java */
    class a extends s<Iterable<T>> {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // ab.s
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(w wVar, Iterable<T> iterable) throws IOException {
            if (iterable == null) {
                return;
            }
            Iterator<T> it = iterable.iterator();
            while (it.hasNext()) {
                s.this.a(wVar, it.next());
            }
        }
    }

    /* JADX INFO: compiled from: ParameterHandler.java */
    class b extends s<Object> {
        b() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // ab.s
        void a(w wVar, Object obj) throws IOException {
            if (obj == null) {
                return;
            }
            int length = Array.getLength(obj);
            for (int i10 = 0; i10 < length; i10++) {
                s.this.a(wVar, Array.get(obj, i10));
            }
        }
    }

    /* JADX INFO: compiled from: ParameterHandler.java */
    static final class c<T> extends s<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Method f467a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f468b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final ab.h<T, ga.c0> f469c;

        c(Method method, int i10, ab.h<T, ga.c0> hVar) {
            this.f467a = method;
            this.f468b = i10;
            this.f469c = hVar;
        }

        @Override // ab.s
        void a(w wVar, T t10) {
            if (t10 == null) {
                throw d0.o(this.f467a, this.f468b, "Body parameter value must not be null.", new Object[0]);
            }
            try {
                wVar.l(this.f469c.convert(t10));
            } catch (IOException e10) {
                throw d0.p(this.f467a, e10, this.f468b, "Unable to convert " + t10 + " to RequestBody", new Object[0]);
            }
        }
    }

    /* JADX INFO: compiled from: ParameterHandler.java */
    static final class d<T> extends s<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f470a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ab.h<T, String> f471b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final boolean f472c;

        d(String str, ab.h<T, String> hVar, boolean z10) {
            Objects.requireNonNull(str, "name == null");
            this.f470a = str;
            this.f471b = hVar;
            this.f472c = z10;
        }

        @Override // ab.s
        void a(w wVar, T t10) throws IOException {
            String strConvert;
            if (t10 == null || (strConvert = this.f471b.convert(t10)) == null) {
                return;
            }
            wVar.a(this.f470a, strConvert, this.f472c);
        }
    }

    /* JADX INFO: compiled from: ParameterHandler.java */
    static final class e<T> extends s<Map<String, T>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Method f473a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f474b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final ab.h<T, String> f475c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final boolean f476d;

        e(Method method, int i10, ab.h<T, String> hVar, boolean z10) {
            this.f473a = method;
            this.f474b = i10;
            this.f475c = hVar;
            this.f476d = z10;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // ab.s
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(w wVar, Map<String, T> map) throws IOException {
            if (map == null) {
                throw d0.o(this.f473a, this.f474b, "Field map was null.", new Object[0]);
            }
            for (Map.Entry<String, T> entry : map.entrySet()) {
                String key = entry.getKey();
                if (key == null) {
                    throw d0.o(this.f473a, this.f474b, "Field map contained null key.", new Object[0]);
                }
                T value = entry.getValue();
                if (value == null) {
                    throw d0.o(this.f473a, this.f474b, "Field map contained null value for key '" + key + "'.", new Object[0]);
                }
                String strConvert = this.f475c.convert(value);
                if (strConvert == null) {
                    throw d0.o(this.f473a, this.f474b, "Field map value '" + value + "' converted to null by " + this.f475c.getClass().getName() + " for key '" + key + "'.", new Object[0]);
                }
                wVar.a(key, strConvert, this.f476d);
            }
        }
    }

    /* JADX INFO: compiled from: ParameterHandler.java */
    static final class f<T> extends s<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f477a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ab.h<T, String> f478b;

        f(String str, ab.h<T, String> hVar) {
            Objects.requireNonNull(str, "name == null");
            this.f477a = str;
            this.f478b = hVar;
        }

        @Override // ab.s
        void a(w wVar, T t10) throws IOException {
            String strConvert;
            if (t10 == null || (strConvert = this.f478b.convert(t10)) == null) {
                return;
            }
            wVar.b(this.f477a, strConvert);
        }
    }

    /* JADX INFO: compiled from: ParameterHandler.java */
    static final class g<T> extends s<Map<String, T>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Method f479a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f480b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final ab.h<T, String> f481c;

        g(Method method, int i10, ab.h<T, String> hVar) {
            this.f479a = method;
            this.f480b = i10;
            this.f481c = hVar;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // ab.s
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(w wVar, Map<String, T> map) throws IOException {
            if (map == null) {
                throw d0.o(this.f479a, this.f480b, "Header map was null.", new Object[0]);
            }
            for (Map.Entry<String, T> entry : map.entrySet()) {
                String key = entry.getKey();
                if (key == null) {
                    throw d0.o(this.f479a, this.f480b, "Header map contained null key.", new Object[0]);
                }
                T value = entry.getValue();
                if (value == null) {
                    throw d0.o(this.f479a, this.f480b, "Header map contained null value for key '" + key + "'.", new Object[0]);
                }
                wVar.b(key, this.f481c.convert(value));
            }
        }
    }

    /* JADX INFO: compiled from: ParameterHandler.java */
    static final class h extends s<ga.u> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Method f482a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f483b;

        h(Method method, int i10) {
            this.f482a = method;
            this.f483b = i10;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // ab.s
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(w wVar, ga.u uVar) {
            if (uVar == null) {
                throw d0.o(this.f482a, this.f483b, "Headers parameter must not be null.", new Object[0]);
            }
            wVar.c(uVar);
        }
    }

    /* JADX INFO: compiled from: ParameterHandler.java */
    static final class i<T> extends s<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Method f484a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f485b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final ga.u f486c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final ab.h<T, ga.c0> f487d;

        i(Method method, int i10, ga.u uVar, ab.h<T, ga.c0> hVar) {
            this.f484a = method;
            this.f485b = i10;
            this.f486c = uVar;
            this.f487d = hVar;
        }

        @Override // ab.s
        void a(w wVar, T t10) {
            if (t10 == null) {
                return;
            }
            try {
                wVar.d(this.f486c, this.f487d.convert(t10));
            } catch (IOException e10) {
                throw d0.o(this.f484a, this.f485b, "Unable to convert " + t10 + " to RequestBody", e10);
            }
        }
    }

    /* JADX INFO: compiled from: ParameterHandler.java */
    static final class j<T> extends s<Map<String, T>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Method f488a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f489b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final ab.h<T, ga.c0> f490c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final String f491d;

        j(Method method, int i10, ab.h<T, ga.c0> hVar, String str) {
            this.f488a = method;
            this.f489b = i10;
            this.f490c = hVar;
            this.f491d = str;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // ab.s
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(w wVar, Map<String, T> map) throws IOException {
            if (map == null) {
                throw d0.o(this.f488a, this.f489b, "Part map was null.", new Object[0]);
            }
            for (Map.Entry<String, T> entry : map.entrySet()) {
                String key = entry.getKey();
                if (key == null) {
                    throw d0.o(this.f488a, this.f489b, "Part map contained null key.", new Object[0]);
                }
                T value = entry.getValue();
                if (value == null) {
                    throw d0.o(this.f488a, this.f489b, "Part map contained null value for key '" + key + "'.", new Object[0]);
                }
                wVar.d(ga.u.g("Content-Disposition", "form-data; name=\"" + key + "\"", "Content-Transfer-Encoding", this.f491d), this.f490c.convert(value));
            }
        }
    }

    /* JADX INFO: compiled from: ParameterHandler.java */
    static final class k<T> extends s<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Method f492a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f493b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f494c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final ab.h<T, String> f495d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final boolean f496e;

        k(Method method, int i10, String str, ab.h<T, String> hVar, boolean z10) {
            this.f492a = method;
            this.f493b = i10;
            Objects.requireNonNull(str, "name == null");
            this.f494c = str;
            this.f495d = hVar;
            this.f496e = z10;
        }

        @Override // ab.s
        void a(w wVar, T t10) throws IOException {
            if (t10 != null) {
                wVar.f(this.f494c, this.f495d.convert(t10), this.f496e);
                return;
            }
            throw d0.o(this.f492a, this.f493b, "Path parameter \"" + this.f494c + "\" value must not be null.", new Object[0]);
        }
    }

    /* JADX INFO: compiled from: ParameterHandler.java */
    static final class l<T> extends s<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f497a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ab.h<T, String> f498b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final boolean f499c;

        l(String str, ab.h<T, String> hVar, boolean z10) {
            Objects.requireNonNull(str, "name == null");
            this.f497a = str;
            this.f498b = hVar;
            this.f499c = z10;
        }

        @Override // ab.s
        void a(w wVar, T t10) throws IOException {
            String strConvert;
            if (t10 == null || (strConvert = this.f498b.convert(t10)) == null) {
                return;
            }
            wVar.g(this.f497a, strConvert, this.f499c);
        }
    }

    /* JADX INFO: compiled from: ParameterHandler.java */
    static final class m<T> extends s<Map<String, T>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Method f500a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f501b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final ab.h<T, String> f502c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final boolean f503d;

        m(Method method, int i10, ab.h<T, String> hVar, boolean z10) {
            this.f500a = method;
            this.f501b = i10;
            this.f502c = hVar;
            this.f503d = z10;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // ab.s
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(w wVar, Map<String, T> map) throws IOException {
            if (map == null) {
                throw d0.o(this.f500a, this.f501b, "Query map was null", new Object[0]);
            }
            for (Map.Entry<String, T> entry : map.entrySet()) {
                String key = entry.getKey();
                if (key == null) {
                    throw d0.o(this.f500a, this.f501b, "Query map contained null key.", new Object[0]);
                }
                T value = entry.getValue();
                if (value == null) {
                    throw d0.o(this.f500a, this.f501b, "Query map contained null value for key '" + key + "'.", new Object[0]);
                }
                String strConvert = this.f502c.convert(value);
                if (strConvert == null) {
                    throw d0.o(this.f500a, this.f501b, "Query map value '" + value + "' converted to null by " + this.f502c.getClass().getName() + " for key '" + key + "'.", new Object[0]);
                }
                wVar.g(key, strConvert, this.f503d);
            }
        }
    }

    /* JADX INFO: compiled from: ParameterHandler.java */
    static final class n<T> extends s<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ab.h<T, String> f504a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f505b;

        n(ab.h<T, String> hVar, boolean z10) {
            this.f504a = hVar;
            this.f505b = z10;
        }

        @Override // ab.s
        void a(w wVar, T t10) throws IOException {
            if (t10 == null) {
                return;
            }
            wVar.g(this.f504a.convert(t10), null, this.f505b);
        }
    }

    /* JADX INFO: compiled from: ParameterHandler.java */
    static final class o extends s<y.c> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final o f506a = new o();

        private o() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // ab.s
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(w wVar, y.c cVar) {
            if (cVar != null) {
                wVar.e(cVar);
            }
        }
    }

    /* JADX INFO: compiled from: ParameterHandler.java */
    static final class p extends s<Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Method f507a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f508b;

        p(Method method, int i10) {
            this.f507a = method;
            this.f508b = i10;
        }

        @Override // ab.s
        void a(w wVar, Object obj) {
            if (obj == null) {
                throw d0.o(this.f507a, this.f508b, "@Url parameter is null.", new Object[0]);
            }
            wVar.m(obj);
        }
    }

    /* JADX INFO: compiled from: ParameterHandler.java */
    static final class q<T> extends s<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Class<T> f509a;

        q(Class<T> cls) {
            this.f509a = cls;
        }

        @Override // ab.s
        void a(w wVar, T t10) {
            wVar.h(this.f509a, t10);
        }
    }

    s() {
    }

    abstract void a(w wVar, T t10) throws IOException;

    final s<Object> b() {
        return new b();
    }

    final s<Iterable<T>> c() {
        return new a();
    }
}
