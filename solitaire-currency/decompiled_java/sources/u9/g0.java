package u9;

import org.jetbrains.annotations.NotNull;
import v8.t;

/* JADX INFO: compiled from: StackTraceRecovery.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class g0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private static final StackTraceElement f34657a = new a.a().a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f34658b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f34659c;

    static {
        Object objB;
        Object objB2;
        try {
            t.a aVar = v8.t.f35208b;
            objB = v8.t.b(kotlin.coroutines.jvm.internal.a.class.getCanonicalName());
        } catch (Throwable th) {
            t.a aVar2 = v8.t.f35208b;
            objB = v8.t.b(v8.u.a(th));
        }
        if (v8.t.e(objB) != null) {
            objB = "kotlin.coroutines.jvm.internal.BaseContinuationImpl";
        }
        f34658b = (String) objB;
        try {
            objB2 = v8.t.b(g0.class.getCanonicalName());
        } catch (Throwable th2) {
            t.a aVar3 = v8.t.f35208b;
            objB2 = v8.t.b(v8.u.a(th2));
        }
        if (v8.t.e(objB2) != null) {
            objB2 = "kotlinx.coroutines.internal.StackTraceRecoveryKt";
        }
        f34659c = (String) objB2;
    }

    @NotNull
    public static final <E extends Throwable> E a(@NotNull E e10) {
        return e10;
    }
}
