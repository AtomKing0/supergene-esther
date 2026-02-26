package ra;

import java.lang.reflect.Method;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: CloseGuard.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class j {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    public static final a f33429d = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    private final Method f33430a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    private final Method f33431b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    private final Method f33432c;

    /* JADX INFO: compiled from: CloseGuard.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        @NotNull
        public final j a() {
            Method method;
            Method method2;
            Method method3;
            try {
                Class<?> cls = Class.forName("dalvik.system.CloseGuard");
                method = cls.getMethod("get", new Class[0]);
                method3 = cls.getMethod("open", String.class);
                method2 = cls.getMethod("warnIfOpen", new Class[0]);
            } catch (Exception unused) {
                method = null;
                method2 = null;
                method3 = null;
            }
            return new j(method, method3, method2);
        }
    }

    public j(@Nullable Method method, @Nullable Method method2, @Nullable Method method3) {
        this.f33430a = method;
        this.f33431b = method2;
        this.f33432c = method3;
    }

    @Nullable
    public final Object a(@NotNull String closer) {
        t.i(closer, "closer");
        Method method = this.f33430a;
        if (method != null) {
            try {
                Object objInvoke = method.invoke(null, new Object[0]);
                Method method2 = this.f33431b;
                t.f(method2);
                method2.invoke(objInvoke, closer);
                return objInvoke;
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public final boolean b(@Nullable Object obj) {
        if (obj == null) {
            return false;
        }
        try {
            Method method = this.f33432c;
            t.f(method);
            method.invoke(obj, new Object[0]);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }
}
