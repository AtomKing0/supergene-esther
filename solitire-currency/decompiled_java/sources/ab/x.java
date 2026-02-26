package ab;

import ab.s;
import com.ironsource.nb;
import ga.u;
import ga.y;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.net.URI;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: RequestFactory.java */
/* JADX INFO: loaded from: classes5.dex */
final class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Method f529a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ga.v f530b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final String f531c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f532d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ga.u f533e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final ga.x f534f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f535g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final boolean f536h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final boolean f537i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final s<?>[] f538j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    final boolean f539k;

    /* JADX INFO: compiled from: RequestFactory.java */
    static final class a {

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        private static final Pattern f540x = Pattern.compile("\\{([a-zA-Z][a-zA-Z0-9_-]*)\\}");

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        private static final Pattern f541y = Pattern.compile("[a-zA-Z][a-zA-Z0-9_-]*");

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final z f542a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Method f543b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final Annotation[] f544c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final Annotation[][] f545d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final Type[] f546e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        boolean f547f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        boolean f548g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        boolean f549h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        boolean f550i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        boolean f551j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        boolean f552k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        boolean f553l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        boolean f554m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        String f555n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        boolean f556o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        boolean f557p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        boolean f558q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        String f559r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        ga.u f560s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        ga.x f561t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        Set<String> f562u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        s<?>[] f563v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        boolean f564w;

        a(z zVar, Method method) {
            this.f542a = zVar;
            this.f543b = method;
            this.f544c = method.getAnnotations();
            this.f546e = method.getGenericParameterTypes();
            this.f545d = method.getParameterAnnotations();
        }

        private static Class<?> a(Class<?> cls) {
            return Boolean.TYPE == cls ? Boolean.class : Byte.TYPE == cls ? Byte.class : Character.TYPE == cls ? Character.class : Double.TYPE == cls ? Double.class : Float.TYPE == cls ? Float.class : Integer.TYPE == cls ? Integer.class : Long.TYPE == cls ? Long.class : Short.TYPE == cls ? Short.class : cls;
        }

        private ga.u c(String[] strArr) {
            u.a aVar = new u.a();
            for (String str : strArr) {
                int iIndexOf = str.indexOf(58);
                if (iIndexOf == -1 || iIndexOf == 0 || iIndexOf == str.length() - 1) {
                    throw d0.m(this.f543b, "@Headers value must be in the form \"Name: Value\". Found: \"%s\"", str);
                }
                String strSubstring = str.substring(0, iIndexOf);
                String strTrim = str.substring(iIndexOf + 1).trim();
                if (nb.K.equalsIgnoreCase(strSubstring)) {
                    try {
                        this.f561t = ga.x.e(strTrim);
                    } catch (IllegalArgumentException e10) {
                        throw d0.n(this.f543b, e10, "Malformed content type: %s", strTrim);
                    }
                } else {
                    aVar.a(strSubstring, strTrim);
                }
            }
            return aVar.f();
        }

        private void d(String str, String str2, boolean z10) {
            String str3 = this.f555n;
            if (str3 != null) {
                throw d0.m(this.f543b, "Only one HTTP method is allowed. Found: %s and %s.", str3, str);
            }
            this.f555n = str;
            this.f556o = z10;
            if (str2.isEmpty()) {
                return;
            }
            int iIndexOf = str2.indexOf(63);
            if (iIndexOf != -1 && iIndexOf < str2.length() - 1) {
                String strSubstring = str2.substring(iIndexOf + 1);
                if (f540x.matcher(strSubstring).find()) {
                    throw d0.m(this.f543b, "URL query string \"%s\" must not have replace block. For dynamic query parameters use @Query.", strSubstring);
                }
            }
            this.f559r = str2;
            this.f562u = h(str2);
        }

        private void e(Annotation annotation) {
            if (annotation instanceof cb.b) {
                d("DELETE", ((cb.b) annotation).value(), false);
                return;
            }
            if (annotation instanceof cb.f) {
                d("GET", ((cb.f) annotation).value(), false);
                return;
            }
            if (annotation instanceof cb.g) {
                d("HEAD", ((cb.g) annotation).value(), false);
                return;
            }
            if (annotation instanceof cb.n) {
                d("PATCH", ((cb.n) annotation).value(), true);
                return;
            }
            if (annotation instanceof cb.o) {
                d("POST", ((cb.o) annotation).value(), true);
                return;
            }
            if (annotation instanceof cb.p) {
                d("PUT", ((cb.p) annotation).value(), true);
                return;
            }
            if (annotation instanceof cb.m) {
                d("OPTIONS", ((cb.m) annotation).value(), false);
                return;
            }
            if (annotation instanceof cb.h) {
                cb.h hVar = (cb.h) annotation;
                d(hVar.method(), hVar.path(), hVar.hasBody());
                return;
            }
            if (annotation instanceof cb.k) {
                String[] strArrValue = ((cb.k) annotation).value();
                if (strArrValue.length == 0) {
                    throw d0.m(this.f543b, "@Headers annotation is empty.", new Object[0]);
                }
                this.f560s = c(strArrValue);
                return;
            }
            if (annotation instanceof cb.l) {
                if (this.f557p) {
                    throw d0.m(this.f543b, "Only one encoding annotation is allowed.", new Object[0]);
                }
                this.f558q = true;
            } else if (annotation instanceof cb.e) {
                if (this.f558q) {
                    throw d0.m(this.f543b, "Only one encoding annotation is allowed.", new Object[0]);
                }
                this.f557p = true;
            }
        }

        private s<?> f(int i10, Type type, Annotation[] annotationArr, boolean z10) {
            s<?> sVar;
            if (annotationArr != null) {
                sVar = null;
                for (Annotation annotation : annotationArr) {
                    s<?> sVarG = g(i10, type, annotationArr, annotation);
                    if (sVarG != null) {
                        if (sVar != null) {
                            throw d0.o(this.f543b, i10, "Multiple Retrofit annotations found, only one allowed.", new Object[0]);
                        }
                        sVar = sVarG;
                    }
                }
            } else {
                sVar = null;
            }
            if (sVar != null) {
                return sVar;
            }
            if (z10) {
                try {
                    if (d0.h(type) == z8.d.class) {
                        this.f564w = true;
                        return null;
                    }
                } catch (NoClassDefFoundError unused) {
                }
            }
            throw d0.o(this.f543b, i10, "No Retrofit annotation found.", new Object[0]);
        }

        private s<?> g(int i10, Type type, Annotation[] annotationArr, Annotation annotation) {
            if (annotation instanceof cb.y) {
                j(i10, type);
                if (this.f554m) {
                    throw d0.o(this.f543b, i10, "Multiple @Url method annotations found.", new Object[0]);
                }
                if (this.f550i) {
                    throw d0.o(this.f543b, i10, "@Path parameters may not be used with @Url.", new Object[0]);
                }
                if (this.f551j) {
                    throw d0.o(this.f543b, i10, "A @Url parameter must not come after a @Query.", new Object[0]);
                }
                if (this.f552k) {
                    throw d0.o(this.f543b, i10, "A @Url parameter must not come after a @QueryName.", new Object[0]);
                }
                if (this.f553l) {
                    throw d0.o(this.f543b, i10, "A @Url parameter must not come after a @QueryMap.", new Object[0]);
                }
                if (this.f559r != null) {
                    throw d0.o(this.f543b, i10, "@Url cannot be used with @%s URL", this.f555n);
                }
                this.f554m = true;
                if (type == ga.v.class || type == String.class || type == URI.class || ((type instanceof Class) && "android.net.Uri".equals(((Class) type).getName()))) {
                    return new s.p(this.f543b, i10);
                }
                throw d0.o(this.f543b, i10, "@Url must be okhttp3.HttpUrl, String, java.net.URI, or android.net.Uri type.", new Object[0]);
            }
            if (annotation instanceof cb.s) {
                j(i10, type);
                if (this.f551j) {
                    throw d0.o(this.f543b, i10, "A @Path parameter must not come after a @Query.", new Object[0]);
                }
                if (this.f552k) {
                    throw d0.o(this.f543b, i10, "A @Path parameter must not come after a @QueryName.", new Object[0]);
                }
                if (this.f553l) {
                    throw d0.o(this.f543b, i10, "A @Path parameter must not come after a @QueryMap.", new Object[0]);
                }
                if (this.f554m) {
                    throw d0.o(this.f543b, i10, "@Path parameters may not be used with @Url.", new Object[0]);
                }
                if (this.f559r == null) {
                    throw d0.o(this.f543b, i10, "@Path can only be used with relative url on @%s", this.f555n);
                }
                this.f550i = true;
                cb.s sVar = (cb.s) annotation;
                String strValue = sVar.value();
                i(i10, strValue);
                return new s.k(this.f543b, i10, strValue, this.f542a.i(type, annotationArr), sVar.encoded());
            }
            if (annotation instanceof cb.t) {
                j(i10, type);
                cb.t tVar = (cb.t) annotation;
                String strValue2 = tVar.value();
                boolean zEncoded = tVar.encoded();
                Class<?> clsH = d0.h(type);
                this.f551j = true;
                if (!Iterable.class.isAssignableFrom(clsH)) {
                    return clsH.isArray() ? new s.l(strValue2, this.f542a.i(a(clsH.getComponentType()), annotationArr), zEncoded).b() : new s.l(strValue2, this.f542a.i(type, annotationArr), zEncoded);
                }
                if (type instanceof ParameterizedType) {
                    return new s.l(strValue2, this.f542a.i(d0.g(0, (ParameterizedType) type), annotationArr), zEncoded).c();
                }
                throw d0.o(this.f543b, i10, clsH.getSimpleName() + " must include generic type (e.g., " + clsH.getSimpleName() + "<String>)", new Object[0]);
            }
            if (annotation instanceof cb.v) {
                j(i10, type);
                boolean zEncoded2 = ((cb.v) annotation).encoded();
                Class<?> clsH2 = d0.h(type);
                this.f552k = true;
                if (!Iterable.class.isAssignableFrom(clsH2)) {
                    return clsH2.isArray() ? new s.n(this.f542a.i(a(clsH2.getComponentType()), annotationArr), zEncoded2).b() : new s.n(this.f542a.i(type, annotationArr), zEncoded2);
                }
                if (type instanceof ParameterizedType) {
                    return new s.n(this.f542a.i(d0.g(0, (ParameterizedType) type), annotationArr), zEncoded2).c();
                }
                throw d0.o(this.f543b, i10, clsH2.getSimpleName() + " must include generic type (e.g., " + clsH2.getSimpleName() + "<String>)", new Object[0]);
            }
            if (annotation instanceof cb.u) {
                j(i10, type);
                Class<?> clsH3 = d0.h(type);
                this.f553l = true;
                if (!Map.class.isAssignableFrom(clsH3)) {
                    throw d0.o(this.f543b, i10, "@QueryMap parameter type must be Map.", new Object[0]);
                }
                Type typeI = d0.i(type, clsH3, Map.class);
                if (!(typeI instanceof ParameterizedType)) {
                    throw d0.o(this.f543b, i10, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                }
                ParameterizedType parameterizedType = (ParameterizedType) typeI;
                Type typeG = d0.g(0, parameterizedType);
                if (String.class == typeG) {
                    return new s.m(this.f543b, i10, this.f542a.i(d0.g(1, parameterizedType), annotationArr), ((cb.u) annotation).encoded());
                }
                throw d0.o(this.f543b, i10, "@QueryMap keys must be of type String: " + typeG, new Object[0]);
            }
            if (annotation instanceof cb.i) {
                j(i10, type);
                String strValue3 = ((cb.i) annotation).value();
                Class<?> clsH4 = d0.h(type);
                if (!Iterable.class.isAssignableFrom(clsH4)) {
                    return clsH4.isArray() ? new s.f(strValue3, this.f542a.i(a(clsH4.getComponentType()), annotationArr)).b() : new s.f(strValue3, this.f542a.i(type, annotationArr));
                }
                if (type instanceof ParameterizedType) {
                    return new s.f(strValue3, this.f542a.i(d0.g(0, (ParameterizedType) type), annotationArr)).c();
                }
                throw d0.o(this.f543b, i10, clsH4.getSimpleName() + " must include generic type (e.g., " + clsH4.getSimpleName() + "<String>)", new Object[0]);
            }
            if (annotation instanceof cb.j) {
                if (type == ga.u.class) {
                    return new s.h(this.f543b, i10);
                }
                j(i10, type);
                Class<?> clsH5 = d0.h(type);
                if (!Map.class.isAssignableFrom(clsH5)) {
                    throw d0.o(this.f543b, i10, "@HeaderMap parameter type must be Map.", new Object[0]);
                }
                Type typeI2 = d0.i(type, clsH5, Map.class);
                if (!(typeI2 instanceof ParameterizedType)) {
                    throw d0.o(this.f543b, i10, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                }
                ParameterizedType parameterizedType2 = (ParameterizedType) typeI2;
                Type typeG2 = d0.g(0, parameterizedType2);
                if (String.class == typeG2) {
                    return new s.g(this.f543b, i10, this.f542a.i(d0.g(1, parameterizedType2), annotationArr));
                }
                throw d0.o(this.f543b, i10, "@HeaderMap keys must be of type String: " + typeG2, new Object[0]);
            }
            if (annotation instanceof cb.c) {
                j(i10, type);
                if (!this.f557p) {
                    throw d0.o(this.f543b, i10, "@Field parameters can only be used with form encoding.", new Object[0]);
                }
                cb.c cVar = (cb.c) annotation;
                String strValue4 = cVar.value();
                boolean zEncoded3 = cVar.encoded();
                this.f547f = true;
                Class<?> clsH6 = d0.h(type);
                if (!Iterable.class.isAssignableFrom(clsH6)) {
                    return clsH6.isArray() ? new s.d(strValue4, this.f542a.i(a(clsH6.getComponentType()), annotationArr), zEncoded3).b() : new s.d(strValue4, this.f542a.i(type, annotationArr), zEncoded3);
                }
                if (type instanceof ParameterizedType) {
                    return new s.d(strValue4, this.f542a.i(d0.g(0, (ParameterizedType) type), annotationArr), zEncoded3).c();
                }
                throw d0.o(this.f543b, i10, clsH6.getSimpleName() + " must include generic type (e.g., " + clsH6.getSimpleName() + "<String>)", new Object[0]);
            }
            if (annotation instanceof cb.d) {
                j(i10, type);
                if (!this.f557p) {
                    throw d0.o(this.f543b, i10, "@FieldMap parameters can only be used with form encoding.", new Object[0]);
                }
                Class<?> clsH7 = d0.h(type);
                if (!Map.class.isAssignableFrom(clsH7)) {
                    throw d0.o(this.f543b, i10, "@FieldMap parameter type must be Map.", new Object[0]);
                }
                Type typeI3 = d0.i(type, clsH7, Map.class);
                if (!(typeI3 instanceof ParameterizedType)) {
                    throw d0.o(this.f543b, i10, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                }
                ParameterizedType parameterizedType3 = (ParameterizedType) typeI3;
                Type typeG3 = d0.g(0, parameterizedType3);
                if (String.class == typeG3) {
                    h hVarI = this.f542a.i(d0.g(1, parameterizedType3), annotationArr);
                    this.f547f = true;
                    return new s.e(this.f543b, i10, hVarI, ((cb.d) annotation).encoded());
                }
                throw d0.o(this.f543b, i10, "@FieldMap keys must be of type String: " + typeG3, new Object[0]);
            }
            if (annotation instanceof cb.q) {
                j(i10, type);
                if (!this.f558q) {
                    throw d0.o(this.f543b, i10, "@Part parameters can only be used with multipart encoding.", new Object[0]);
                }
                cb.q qVar = (cb.q) annotation;
                this.f548g = true;
                String strValue5 = qVar.value();
                Class<?> clsH8 = d0.h(type);
                if (strValue5.isEmpty()) {
                    if (!Iterable.class.isAssignableFrom(clsH8)) {
                        if (clsH8.isArray()) {
                            if (y.c.class.isAssignableFrom(clsH8.getComponentType())) {
                                return s.o.f506a.b();
                            }
                            throw d0.o(this.f543b, i10, "@Part annotation must supply a name or use MultipartBody.Part parameter type.", new Object[0]);
                        }
                        if (y.c.class.isAssignableFrom(clsH8)) {
                            return s.o.f506a;
                        }
                        throw d0.o(this.f543b, i10, "@Part annotation must supply a name or use MultipartBody.Part parameter type.", new Object[0]);
                    }
                    if (type instanceof ParameterizedType) {
                        if (y.c.class.isAssignableFrom(d0.h(d0.g(0, (ParameterizedType) type)))) {
                            return s.o.f506a.c();
                        }
                        throw d0.o(this.f543b, i10, "@Part annotation must supply a name or use MultipartBody.Part parameter type.", new Object[0]);
                    }
                    throw d0.o(this.f543b, i10, clsH8.getSimpleName() + " must include generic type (e.g., " + clsH8.getSimpleName() + "<String>)", new Object[0]);
                }
                ga.u uVarG = ga.u.g("Content-Disposition", "form-data; name=\"" + strValue5 + "\"", "Content-Transfer-Encoding", qVar.encoding());
                if (!Iterable.class.isAssignableFrom(clsH8)) {
                    if (!clsH8.isArray()) {
                        if (y.c.class.isAssignableFrom(clsH8)) {
                            throw d0.o(this.f543b, i10, "@Part parameters using the MultipartBody.Part must not include a part name in the annotation.", new Object[0]);
                        }
                        return new s.i(this.f543b, i10, uVarG, this.f542a.g(type, annotationArr, this.f544c));
                    }
                    Class<?> clsA = a(clsH8.getComponentType());
                    if (y.c.class.isAssignableFrom(clsA)) {
                        throw d0.o(this.f543b, i10, "@Part parameters using the MultipartBody.Part must not include a part name in the annotation.", new Object[0]);
                    }
                    return new s.i(this.f543b, i10, uVarG, this.f542a.g(clsA, annotationArr, this.f544c)).b();
                }
                if (type instanceof ParameterizedType) {
                    Type typeG4 = d0.g(0, (ParameterizedType) type);
                    if (y.c.class.isAssignableFrom(d0.h(typeG4))) {
                        throw d0.o(this.f543b, i10, "@Part parameters using the MultipartBody.Part must not include a part name in the annotation.", new Object[0]);
                    }
                    return new s.i(this.f543b, i10, uVarG, this.f542a.g(typeG4, annotationArr, this.f544c)).c();
                }
                throw d0.o(this.f543b, i10, clsH8.getSimpleName() + " must include generic type (e.g., " + clsH8.getSimpleName() + "<String>)", new Object[0]);
            }
            if (annotation instanceof cb.r) {
                j(i10, type);
                if (!this.f558q) {
                    throw d0.o(this.f543b, i10, "@PartMap parameters can only be used with multipart encoding.", new Object[0]);
                }
                this.f548g = true;
                Class<?> clsH9 = d0.h(type);
                if (!Map.class.isAssignableFrom(clsH9)) {
                    throw d0.o(this.f543b, i10, "@PartMap parameter type must be Map.", new Object[0]);
                }
                Type typeI4 = d0.i(type, clsH9, Map.class);
                if (!(typeI4 instanceof ParameterizedType)) {
                    throw d0.o(this.f543b, i10, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                }
                ParameterizedType parameterizedType4 = (ParameterizedType) typeI4;
                Type typeG5 = d0.g(0, parameterizedType4);
                if (String.class == typeG5) {
                    Type typeG6 = d0.g(1, parameterizedType4);
                    if (y.c.class.isAssignableFrom(d0.h(typeG6))) {
                        throw d0.o(this.f543b, i10, "@PartMap values cannot be MultipartBody.Part. Use @Part List<Part> or a different value type instead.", new Object[0]);
                    }
                    return new s.j(this.f543b, i10, this.f542a.g(typeG6, annotationArr, this.f544c), ((cb.r) annotation).encoding());
                }
                throw d0.o(this.f543b, i10, "@PartMap keys must be of type String: " + typeG5, new Object[0]);
            }
            if (annotation instanceof cb.a) {
                j(i10, type);
                if (this.f557p || this.f558q) {
                    throw d0.o(this.f543b, i10, "@Body parameters cannot be used with form or multi-part encoding.", new Object[0]);
                }
                if (this.f549h) {
                    throw d0.o(this.f543b, i10, "Multiple @Body method annotations found.", new Object[0]);
                }
                try {
                    h hVarG = this.f542a.g(type, annotationArr, this.f544c);
                    this.f549h = true;
                    return new s.c(this.f543b, i10, hVarG);
                } catch (RuntimeException e10) {
                    throw d0.p(this.f543b, e10, i10, "Unable to create @Body converter for %s", type);
                }
            }
            if (!(annotation instanceof cb.x)) {
                return null;
            }
            j(i10, type);
            Class<?> clsH10 = d0.h(type);
            for (int i11 = i10 - 1; i11 >= 0; i11--) {
                s<?> sVar2 = this.f563v[i11];
                if ((sVar2 instanceof s.q) && ((s.q) sVar2).f509a.equals(clsH10)) {
                    throw d0.o(this.f543b, i10, "@Tag type " + clsH10.getName() + " is duplicate of parameter #" + (i11 + 1) + " and would always overwrite its value.", new Object[0]);
                }
            }
            return new s.q(clsH10);
        }

        static Set<String> h(String str) {
            Matcher matcher = f540x.matcher(str);
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            while (matcher.find()) {
                linkedHashSet.add(matcher.group(1));
            }
            return linkedHashSet;
        }

        private void i(int i10, String str) {
            if (!f541y.matcher(str).matches()) {
                throw d0.o(this.f543b, i10, "@Path parameter name must match %s. Found: %s", f540x.pattern(), str);
            }
            if (!this.f562u.contains(str)) {
                throw d0.o(this.f543b, i10, "URL \"%s\" does not contain \"{%s}\".", this.f559r, str);
            }
        }

        private void j(int i10, Type type) {
            if (d0.j(type)) {
                throw d0.o(this.f543b, i10, "Parameter type must not include a type variable or wildcard: %s", type);
            }
        }

        x b() {
            for (Annotation annotation : this.f544c) {
                e(annotation);
            }
            if (this.f555n == null) {
                throw d0.m(this.f543b, "HTTP method annotation is required (e.g., @GET, @POST, etc.).", new Object[0]);
            }
            if (!this.f556o) {
                if (this.f558q) {
                    throw d0.m(this.f543b, "Multipart can only be specified on HTTP methods with request body (e.g., @POST).", new Object[0]);
                }
                if (this.f557p) {
                    throw d0.m(this.f543b, "FormUrlEncoded can only be specified on HTTP methods with request body (e.g., @POST).", new Object[0]);
                }
            }
            int length = this.f545d.length;
            this.f563v = new s[length];
            int i10 = length - 1;
            int i11 = 0;
            while (true) {
                boolean z10 = true;
                if (i11 >= length) {
                    break;
                }
                s<?>[] sVarArr = this.f563v;
                Type type = this.f546e[i11];
                Annotation[] annotationArr = this.f545d[i11];
                if (i11 != i10) {
                    z10 = false;
                }
                sVarArr[i11] = f(i11, type, annotationArr, z10);
                i11++;
            }
            if (this.f559r == null && !this.f554m) {
                throw d0.m(this.f543b, "Missing either @%s URL or @Url parameter.", this.f555n);
            }
            boolean z11 = this.f557p;
            if (!z11 && !this.f558q && !this.f556o && this.f549h) {
                throw d0.m(this.f543b, "Non-body HTTP method cannot contain @Body.", new Object[0]);
            }
            if (z11 && !this.f547f) {
                throw d0.m(this.f543b, "Form-encoded method must contain at least one @Field.", new Object[0]);
            }
            if (!this.f558q || this.f548g) {
                return new x(this);
            }
            throw d0.m(this.f543b, "Multipart method must contain at least one @Part.", new Object[0]);
        }
    }

    x(a aVar) {
        this.f529a = aVar.f543b;
        this.f530b = aVar.f542a.f570c;
        this.f531c = aVar.f555n;
        this.f532d = aVar.f559r;
        this.f533e = aVar.f560s;
        this.f534f = aVar.f561t;
        this.f535g = aVar.f556o;
        this.f536h = aVar.f557p;
        this.f537i = aVar.f558q;
        this.f538j = aVar.f563v;
        this.f539k = aVar.f564w;
    }

    static x b(z zVar, Method method) {
        return new a(zVar, method).b();
    }

    ga.b0 a(Object[] objArr) throws IOException {
        s<?>[] sVarArr = this.f538j;
        int length = objArr.length;
        if (length != sVarArr.length) {
            throw new IllegalArgumentException("Argument count (" + length + ") doesn't match expected count (" + sVarArr.length + ")");
        }
        w wVar = new w(this.f531c, this.f530b, this.f532d, this.f533e, this.f534f, this.f535g, this.f536h, this.f537i);
        if (this.f539k) {
            length--;
        }
        ArrayList arrayList = new ArrayList(length);
        for (int i10 = 0; i10 < length; i10++) {
            arrayList.add(objArr[i10]);
            sVarArr[i10].a(wVar, objArr[i10]);
        }
        return wVar.k().q(n.class, new n(this.f529a, arrayList)).b();
    }
}
