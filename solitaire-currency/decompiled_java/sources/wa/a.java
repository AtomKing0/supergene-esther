package wa;

import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Collection;

/* JADX INFO: compiled from: BoundaryInterfaceReflectionUtil.java */
/* JADX INFO: loaded from: classes5.dex */
public class a {

    /* JADX INFO: renamed from: wa.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: BoundaryInterfaceReflectionUtil.java */
    @RequiresApi(19)
    private static class C0722a implements InvocationHandler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Object f35557a;

        public C0722a(@NonNull Object obj) {
            this.f35557a = obj;
        }

        @NonNull
        public Object a() {
            return this.f35557a;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            try {
                return a.d(method, this.f35557a.getClass().getClassLoader()).invoke(this.f35557a, objArr);
            } catch (InvocationTargetException e10) {
                throw e10.getTargetException();
            } catch (ReflectiveOperationException e11) {
                throw new RuntimeException("Reflection failed for method " + method, e11);
            }
        }
    }

    @Nullable
    public static <T> T a(@NonNull Class<T> cls, @Nullable InvocationHandler invocationHandler) {
        if (invocationHandler == null) {
            return null;
        }
        return cls.cast(Proxy.newProxyInstance(a.class.getClassLoader(), new Class[]{cls}, invocationHandler));
    }

    public static boolean b(Collection<String> collection, String str) {
        if (!collection.contains(str)) {
            if (f()) {
                if (collection.contains(str + ":dev")) {
                }
            }
            return false;
        }
        return true;
    }

    @Nullable
    @RequiresApi(19)
    public static InvocationHandler c(@Nullable Object obj) {
        if (obj == null) {
            return null;
        }
        return new C0722a(obj);
    }

    public static Method d(Method method, ClassLoader classLoader) throws NoSuchMethodException, ClassNotFoundException {
        return Class.forName(method.getDeclaringClass().getName(), true, classLoader).getDeclaredMethod(method.getName(), method.getParameterTypes());
    }

    @Nullable
    @RequiresApi(19)
    public static Object e(@Nullable InvocationHandler invocationHandler) {
        if (invocationHandler == null) {
            return null;
        }
        return ((C0722a) invocationHandler).a();
    }

    private static boolean f() {
        String str = Build.TYPE;
        return "eng".equals(str) || "userdebug".equals(str);
    }
}
