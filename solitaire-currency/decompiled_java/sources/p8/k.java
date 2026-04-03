package p8;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: CloseableJVM.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private static final v8.l f32930a = v8.n.a(a.f32931g);

    /* JADX INFO: compiled from: CloseableJVM.kt */
    static final class a extends v implements h9.a<Method> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final a f32931g = new a();

        a() {
            super(0);
        }

        @Override // h9.a
        @Nullable
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Method invoke() {
            try {
                return Throwable.class.getMethod("addSuppressed", Throwable.class);
            } catch (Throwable unused) {
                return null;
            }
        }
    }

    public static final void a(@NotNull Throwable th, @NotNull Throwable other) throws IllegalAccessException, InvocationTargetException {
        t.i(th, "<this>");
        t.i(other, "other");
        Method methodB = b();
        if (methodB != null) {
            methodB.invoke(th, other);
        }
    }

    private static final Method b() {
        return (Method) f32930a.getValue();
    }
}
