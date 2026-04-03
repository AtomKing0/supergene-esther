package kotlin.coroutines.jvm.internal;

import java.lang.reflect.Method;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: DebugMetadata.kt */
/* JADX INFO: loaded from: classes5.dex */
final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final i f29805a = new i();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private static final a f29806b = new a(null, null, null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    private static a f29807c;

    /* JADX INFO: compiled from: DebugMetadata.kt */
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        public final Method f29808a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        public final Method f29809b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Nullable
        public final Method f29810c;

        public a(@Nullable Method method, @Nullable Method method2, @Nullable Method method3) {
            this.f29808a = method;
            this.f29809b = method2;
            this.f29810c = method3;
        }
    }

    private i() {
    }

    private final a a(kotlin.coroutines.jvm.internal.a aVar) {
        try {
            a aVar2 = new a(Class.class.getDeclaredMethod("getModule", new Class[0]), aVar.getClass().getClassLoader().loadClass("java.lang.Module").getDeclaredMethod("getDescriptor", new Class[0]), aVar.getClass().getClassLoader().loadClass("java.lang.module.ModuleDescriptor").getDeclaredMethod("name", new Class[0]));
            f29807c = aVar2;
            return aVar2;
        } catch (Exception unused) {
            a aVar3 = f29806b;
            f29807c = aVar3;
            return aVar3;
        }
    }

    @Nullable
    public final String b(@NotNull kotlin.coroutines.jvm.internal.a continuation) {
        t.i(continuation, "continuation");
        a aVarA = f29807c;
        if (aVarA == null) {
            aVarA = a(continuation);
        }
        if (aVarA == f29806b) {
            return null;
        }
        Method method = aVarA.f29808a;
        Object objInvoke = method != null ? method.invoke(continuation.getClass(), new Object[0]) : null;
        if (objInvoke == null) {
            return null;
        }
        Method method2 = aVarA.f29809b;
        Object objInvoke2 = method2 != null ? method2.invoke(objInvoke, new Object[0]) : null;
        if (objInvoke2 == null) {
            return null;
        }
        Method method3 = aVarA.f29810c;
        Object objInvoke3 = method3 != null ? method3.invoke(objInvoke2, new Object[0]) : null;
        if (objInvoke3 instanceof String) {
            return (String) objInvoke3;
        }
        return null;
    }
}
