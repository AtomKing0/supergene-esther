package ab;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/* JADX INFO: compiled from: CallAdapter.java */
/* JADX INFO: loaded from: classes5.dex */
public interface c<R, T> {

    /* JADX INFO: compiled from: CallAdapter.java */
    public static abstract class a {
        protected static Type b(int i10, ParameterizedType parameterizedType) {
            return d0.g(i10, parameterizedType);
        }

        protected static Class<?> c(Type type) {
            return d0.h(type);
        }

        public abstract c<?, ?> a(Type type, Annotation[] annotationArr, z zVar);
    }

    Type a();

    T b(b<R> bVar);
}
