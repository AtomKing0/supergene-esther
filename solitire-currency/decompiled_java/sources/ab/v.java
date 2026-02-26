package ab;

import ab.c;
import ab.h;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: Platform.java */
/* JADX INFO: loaded from: classes5.dex */
class v {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final v f510c = e();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f511a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Constructor<MethodHandles.Lookup> f512b;

    /* JADX INFO: compiled from: Platform.java */
    static final class a extends v {

        /* JADX INFO: renamed from: ab.v$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: Platform.java */
        static final class ExecutorC0010a implements Executor {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final Handler f513a = new Handler(Looper.getMainLooper());

            ExecutorC0010a() {
            }

            @Override // java.util.concurrent.Executor
            public void execute(Runnable runnable) {
                this.f513a.post(runnable);
            }
        }

        a() {
            super(Build.VERSION.SDK_INT >= 24);
        }

        @Override // ab.v
        public Executor b() {
            return new ExecutorC0010a();
        }

        @Override // ab.v
        Object g(Method method, Class<?> cls, Object obj, Object... objArr) throws Throwable {
            if (Build.VERSION.SDK_INT >= 26) {
                return super.g(method, cls, obj, objArr);
            }
            throw new UnsupportedOperationException("Calling default methods on API 24 and 25 is not supported");
        }
    }

    v(boolean z10) {
        this.f511a = z10;
        Constructor<MethodHandles.Lookup> declaredConstructor = null;
        if (z10) {
            try {
                declaredConstructor = MethodHandles.Lookup.class.getDeclaredConstructor(Class.class, Integer.TYPE);
                declaredConstructor.setAccessible(true);
            } catch (NoClassDefFoundError | NoSuchMethodException unused) {
            }
        }
        this.f512b = declaredConstructor;
    }

    private static v e() {
        try {
            Class.forName("android.os.Build");
            return new a();
        } catch (ClassNotFoundException unused) {
            return new v(true);
        }
    }

    static v f() {
        return f510c;
    }

    List<? extends c.a> a(Executor executor) {
        i iVar = new i(executor);
        return this.f511a ? Arrays.asList(g.f402a, iVar) : Collections.singletonList(iVar);
    }

    Executor b() {
        return null;
    }

    List<? extends h.a> c() {
        return this.f511a ? Collections.singletonList(r.f463a) : Collections.emptyList();
    }

    int d() {
        return this.f511a ? 1 : 0;
    }

    Object g(Method method, Class<?> cls, Object obj, Object... objArr) throws Throwable {
        Constructor<MethodHandles.Lookup> constructor = this.f512b;
        return (constructor != null ? constructor.newInstance(cls, -1) : MethodHandles.lookup()).unreflectSpecial(method, cls).bindTo(obj).invokeWithArguments(objArr);
    }

    boolean h(Method method) {
        return this.f511a && method.isDefault();
    }
}
