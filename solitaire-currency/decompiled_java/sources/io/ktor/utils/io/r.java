package io.ktor.utils.io;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Comparator;
import java.util.WeakHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlinx.coroutines.i0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import v8.t;

/* JADX INFO: compiled from: ExceptionUtilsJvm.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f26940a = d(Throwable.class, -1);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private static final ReentrantReadWriteLock f26941b = new ReentrantReadWriteLock();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private static final WeakHashMap<Class<? extends Throwable>, h9.l<Throwable, Throwable>> f26942c = new WeakHashMap<>();

    /* JADX INFO: compiled from: ExceptionUtilsJvm.kt */
    public static final class a extends kotlin.jvm.internal.v implements h9.l<Throwable, Throwable> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ Constructor f26943g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Constructor constructor) {
            super(1);
            this.f26943g = constructor;
        }

        @Override // h9.l
        @Nullable
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Throwable invoke(@NotNull Throwable e10) {
            Object objB;
            kotlin.jvm.internal.t.i(e10, "e");
            try {
                t.a aVar = v8.t.f35208b;
                Object objNewInstance = this.f26943g.newInstance(e10.getMessage(), e10);
                kotlin.jvm.internal.t.g(objNewInstance, "null cannot be cast to non-null type kotlin.Throwable");
                objB = v8.t.b((Throwable) objNewInstance);
            } catch (Throwable th) {
                t.a aVar2 = v8.t.f35208b;
                objB = v8.t.b(v8.u.a(th));
            }
            if (v8.t.g(objB)) {
                objB = null;
            }
            return (Throwable) objB;
        }
    }

    /* JADX INFO: compiled from: ExceptionUtilsJvm.kt */
    public static final class b extends kotlin.jvm.internal.v implements h9.l<Throwable, Throwable> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ Constructor f26944g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Constructor constructor) {
            super(1);
            this.f26944g = constructor;
        }

        @Override // h9.l
        @Nullable
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Throwable invoke(@NotNull Throwable e10) {
            Object objB;
            kotlin.jvm.internal.t.i(e10, "e");
            try {
                t.a aVar = v8.t.f35208b;
                Object objNewInstance = this.f26944g.newInstance(e10);
                kotlin.jvm.internal.t.g(objNewInstance, "null cannot be cast to non-null type kotlin.Throwable");
                objB = v8.t.b((Throwable) objNewInstance);
            } catch (Throwable th) {
                t.a aVar2 = v8.t.f35208b;
                objB = v8.t.b(v8.u.a(th));
            }
            if (v8.t.g(objB)) {
                objB = null;
            }
            return (Throwable) objB;
        }
    }

    /* JADX INFO: compiled from: ExceptionUtilsJvm.kt */
    public static final class c extends kotlin.jvm.internal.v implements h9.l<Throwable, Throwable> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ Constructor f26945g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(Constructor constructor) {
            super(1);
            this.f26945g = constructor;
        }

        @Override // h9.l
        @Nullable
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Throwable invoke(@NotNull Throwable e10) {
            Object objB;
            kotlin.jvm.internal.t.i(e10, "e");
            try {
                t.a aVar = v8.t.f35208b;
                Object objNewInstance = this.f26945g.newInstance(e10.getMessage());
                kotlin.jvm.internal.t.g(objNewInstance, "null cannot be cast to non-null type kotlin.Throwable");
                Throwable th = (Throwable) objNewInstance;
                th.initCause(e10);
                objB = v8.t.b(th);
            } catch (Throwable th2) {
                t.a aVar2 = v8.t.f35208b;
                objB = v8.t.b(v8.u.a(th2));
            }
            if (v8.t.g(objB)) {
                objB = null;
            }
            return (Throwable) objB;
        }
    }

    /* JADX INFO: compiled from: ExceptionUtilsJvm.kt */
    public static final class d extends kotlin.jvm.internal.v implements h9.l<Throwable, Throwable> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ Constructor f26946g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(Constructor constructor) {
            super(1);
            this.f26946g = constructor;
        }

        @Override // h9.l
        @Nullable
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Throwable invoke(@NotNull Throwable e10) {
            Object objB;
            kotlin.jvm.internal.t.i(e10, "e");
            try {
                t.a aVar = v8.t.f35208b;
                Object objNewInstance = this.f26946g.newInstance(new Object[0]);
                kotlin.jvm.internal.t.g(objNewInstance, "null cannot be cast to non-null type kotlin.Throwable");
                Throwable th = (Throwable) objNewInstance;
                th.initCause(e10);
                objB = v8.t.b(th);
            } catch (Throwable th2) {
                t.a aVar2 = v8.t.f35208b;
                objB = v8.t.b(v8.u.a(th2));
            }
            if (v8.t.g(objB)) {
                objB = null;
            }
            return (Throwable) objB;
        }
    }

    /* JADX INFO: compiled from: Comparisons.kt */
    public static final class e<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t10, T t11) {
            return x8.b.a(Integer.valueOf(((Constructor) t11).getParameterTypes().length), Integer.valueOf(((Constructor) t10).getParameterTypes().length));
        }
    }

    /* JADX INFO: compiled from: ExceptionUtilsJvm.kt */
    static final class f extends kotlin.jvm.internal.v implements h9.l {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final f f26947g = new f();

        f() {
            super(1);
        }

        @Override // h9.l
        @Nullable
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Void invoke(@NotNull Throwable it) {
            kotlin.jvm.internal.t.i(it, "it");
            return null;
        }
    }

    /* JADX INFO: compiled from: ExceptionUtilsJvm.kt */
    static final class g extends kotlin.jvm.internal.v implements h9.l {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final g f26948g = new g();

        g() {
            super(1);
        }

        @Override // h9.l
        @Nullable
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Void invoke(@NotNull Throwable it) {
            kotlin.jvm.internal.t.i(it, "it");
            return null;
        }
    }

    private static final h9.l<Throwable, Throwable> a(Constructor<?> constructor) {
        Class<?>[] parameterTypes = constructor.getParameterTypes();
        int length = parameterTypes.length;
        if (length == 0) {
            return new d(constructor);
        }
        if (length != 1) {
            if (length == 2 && kotlin.jvm.internal.t.d(parameterTypes[0], String.class) && kotlin.jvm.internal.t.d(parameterTypes[1], Throwable.class)) {
                return new a(constructor);
            }
            return null;
        }
        Class<?> cls = parameterTypes[0];
        if (kotlin.jvm.internal.t.d(cls, Throwable.class)) {
            return new b(constructor);
        }
        if (kotlin.jvm.internal.t.d(cls, String.class)) {
            return new c(constructor);
        }
        return null;
    }

    private static final int b(Class<?> cls, int i10) {
        do {
            Field[] declaredFields = cls.getDeclaredFields();
            kotlin.jvm.internal.t.h(declaredFields, "declaredFields");
            int i11 = 0;
            for (Field field : declaredFields) {
                if (!Modifier.isStatic(field.getModifiers())) {
                    i11++;
                }
            }
            i10 += i11;
            cls = cls.getSuperclass();
        } while (cls != null);
        return i10;
    }

    static /* synthetic */ int c(Class cls, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = 0;
        }
        return b(cls, i10);
    }

    private static final int d(Class<?> cls, int i10) {
        Object objB;
        g9.a.c(cls);
        try {
            t.a aVar = v8.t.f35208b;
            objB = v8.t.b(Integer.valueOf(c(cls, 0, 1, null)));
        } catch (Throwable th) {
            t.a aVar2 = v8.t.f35208b;
            objB = v8.t.b(v8.u.a(th));
        }
        Integer numValueOf = Integer.valueOf(i10);
        if (v8.t.g(objB)) {
            objB = numValueOf;
        }
        return ((Number) objB).intValue();
    }

    @Nullable
    public static final <E extends Throwable> E e(@NotNull E exception, @NotNull Throwable cause) {
        Object objB;
        ReentrantReadWriteLock.ReadLock lock;
        int readHoldCount;
        ReentrantReadWriteLock.WriteLock writeLock;
        kotlin.jvm.internal.t.i(exception, "exception");
        kotlin.jvm.internal.t.i(cause, "cause");
        if (exception instanceof i0) {
            try {
                t.a aVar = v8.t.f35208b;
                objB = v8.t.b(((i0) exception).a());
            } catch (Throwable th) {
                t.a aVar2 = v8.t.f35208b;
                objB = v8.t.b(v8.u.a(th));
            }
            return (E) (v8.t.g(objB) ? null : objB);
        }
        ReentrantReadWriteLock reentrantReadWriteLock = f26941b;
        ReentrantReadWriteLock.ReadLock lock2 = reentrantReadWriteLock.readLock();
        lock2.lock();
        try {
            h9.l<Throwable, Throwable> lVar = f26942c.get(exception.getClass());
            if (lVar != null) {
                return (E) lVar.invoke(exception);
            }
            int i10 = 0;
            if (f26940a != d(exception.getClass(), 0)) {
                lock = reentrantReadWriteLock.readLock();
                readHoldCount = reentrantReadWriteLock.getWriteHoldCount() == 0 ? reentrantReadWriteLock.getReadHoldCount() : 0;
                for (int i11 = 0; i11 < readHoldCount; i11++) {
                    lock.unlock();
                }
                writeLock = reentrantReadWriteLock.writeLock();
                writeLock.lock();
                try {
                    f26942c.put(exception.getClass(), f.f26947g);
                    k0 k0Var = k0.f35197a;
                    return null;
                } finally {
                    while (i10 < readHoldCount) {
                        lock.lock();
                        i10++;
                    }
                    writeLock.unlock();
                }
            }
            Constructor<?>[] constructors = exception.getClass().getConstructors();
            kotlin.jvm.internal.t.h(constructors, "exception.javaClass.constructors");
            h9.l<Throwable, Throwable> lVarA = null;
            for (Constructor constructor : kotlin.collections.p.l0(constructors, new e())) {
                kotlin.jvm.internal.t.h(constructor, "constructor");
                lVarA = a(constructor);
                if (lVarA != null) {
                    break;
                }
            }
            ReentrantReadWriteLock reentrantReadWriteLock2 = f26941b;
            lock = reentrantReadWriteLock2.readLock();
            readHoldCount = reentrantReadWriteLock2.getWriteHoldCount() == 0 ? reentrantReadWriteLock2.getReadHoldCount() : 0;
            for (int i12 = 0; i12 < readHoldCount; i12++) {
                lock.unlock();
            }
            writeLock = reentrantReadWriteLock2.writeLock();
            writeLock.lock();
            try {
                f26942c.put(exception.getClass(), lVarA == null ? g.f26948g : lVarA);
                k0 k0Var2 = k0.f35197a;
                while (i10 < readHoldCount) {
                    lock.lock();
                    i10++;
                }
                writeLock.unlock();
                if (lVarA != null) {
                    return (E) lVarA.invoke(cause);
                }
                return null;
            } finally {
                while (i10 < readHoldCount) {
                    lock.lock();
                    i10++;
                }
                writeLock.unlock();
            }
        } finally {
            lock2.unlock();
        }
    }
}
