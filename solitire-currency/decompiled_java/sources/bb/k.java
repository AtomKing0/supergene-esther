package bb;

import ab.h;
import ab.z;
import ga.c0;
import ga.e0;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

/* JADX INFO: compiled from: ScalarsConverterFactory.java */
/* JADX INFO: loaded from: classes5.dex */
public final class k extends h.a {
    private k() {
    }

    public static k f() {
        return new k();
    }

    @Override // ab.h.a
    public ab.h<?, c0> c(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, z zVar) {
        if (type == String.class || type == Boolean.TYPE || type == Boolean.class || type == Byte.TYPE || type == Byte.class || type == Character.TYPE || type == Character.class || type == Double.TYPE || type == Double.class || type == Float.TYPE || type == Float.class || type == Integer.TYPE || type == Integer.class || type == Long.TYPE || type == Long.class || type == Short.TYPE || type == Short.class) {
            return a.f2325a;
        }
        return null;
    }

    @Override // ab.h.a
    public ab.h<e0, ?> d(Type type, Annotation[] annotationArr, z zVar) {
        if (type == String.class) {
            return j.f2335a;
        }
        if (type == Boolean.class || type == Boolean.TYPE) {
            return b.f2327a;
        }
        if (type == Byte.class || type == Byte.TYPE) {
            return c.f2328a;
        }
        if (type == Character.class || type == Character.TYPE) {
            return d.f2329a;
        }
        if (type == Double.class || type == Double.TYPE) {
            return e.f2330a;
        }
        if (type == Float.class || type == Float.TYPE) {
            return f.f2331a;
        }
        if (type == Integer.class || type == Integer.TYPE) {
            return g.f2332a;
        }
        if (type == Long.class || type == Long.TYPE) {
            return h.f2333a;
        }
        if (type == Short.class || type == Short.TYPE) {
            return i.f2334a;
        }
        return null;
    }
}
