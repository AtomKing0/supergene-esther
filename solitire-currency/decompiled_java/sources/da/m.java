package da;

import java.util.List;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import kotlinx.serialization.KSerializer;
import org.jetbrains.annotations.NotNull;
import v8.t;

/* JADX INFO: compiled from: Caching.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final boolean f24596a;

    static {
        Object objB;
        try {
            t.a aVar = v8.t.f35208b;
            objB = v8.t.b(Class.forName("java.lang.ClassValue"));
        } catch (Throwable th) {
            t.a aVar2 = v8.t.f35208b;
            objB = v8.t.b(v8.u.a(th));
        }
        if (v8.t.h(objB)) {
            objB = Boolean.TRUE;
        }
        Object objB2 = v8.t.b(objB);
        Boolean bool = Boolean.FALSE;
        if (v8.t.g(objB2)) {
            objB2 = bool;
        }
        f24596a = ((Boolean) objB2).booleanValue();
    }

    @NotNull
    public static final <T> t1<T> a(@NotNull h9.l<? super KClass<?>, ? extends KSerializer<T>> factory) {
        kotlin.jvm.internal.t.i(factory, "factory");
        return f24596a ? new p(factory) : new t(factory);
    }

    @NotNull
    public static final <T> f1<T> b(@NotNull h9.p<? super KClass<Object>, ? super List<? extends KType>, ? extends KSerializer<T>> factory) {
        kotlin.jvm.internal.t.i(factory, "factory");
        return f24596a ? new q(factory) : new u(factory);
    }
}
