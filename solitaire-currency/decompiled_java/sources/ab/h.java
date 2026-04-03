package ab;

import ga.e0;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/* JADX INFO: compiled from: Converter.java */
/* JADX INFO: loaded from: classes5.dex */
public interface h<F, T> {

    /* JADX INFO: compiled from: Converter.java */
    public static abstract class a {
        protected static Type a(int i10, ParameterizedType parameterizedType) {
            return d0.g(i10, parameterizedType);
        }

        protected static Class<?> b(Type type) {
            return d0.h(type);
        }

        public h<?, ga.c0> c(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, z zVar) {
            return null;
        }

        public h<e0, ?> d(Type type, Annotation[] annotationArr, z zVar) {
            return null;
        }

        public h<?, String> e(Type type, Annotation[] annotationArr, z zVar) {
            return null;
        }
    }

    T convert(F f10) throws IOException;
}
