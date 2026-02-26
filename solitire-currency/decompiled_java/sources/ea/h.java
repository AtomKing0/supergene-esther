package ea;

import org.jetbrains.annotations.NotNull;
import v8.t;

/* JADX INFO: compiled from: CharArrayPool.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final h f25435a = new h();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private static final kotlin.collections.k<char[]> f25436b = new kotlin.collections.k<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static int f25437c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f25438d;

    static {
        Object objB;
        try {
            t.a aVar = v8.t.f35208b;
            String property = System.getProperty("kotlinx.serialization.json.pool.size");
            kotlin.jvm.internal.t.h(property, "getProperty(\"kotlinx.ser…lization.json.pool.size\")");
            objB = v8.t.b(p9.p.l(property));
        } catch (Throwable th) {
            t.a aVar2 = v8.t.f35208b;
            objB = v8.t.b(v8.u.a(th));
        }
        if (v8.t.g(objB)) {
            objB = null;
        }
        Integer num = (Integer) objB;
        f25438d = num != null ? num.intValue() : 1048576;
    }

    private h() {
    }

    public final void a(@NotNull char[] array) {
        kotlin.jvm.internal.t.i(array, "array");
        synchronized (this) {
            int i10 = f25437c;
            if (array.length + i10 < f25438d) {
                f25437c = i10 + array.length;
                f25436b.addLast(array);
            }
            v8.k0 k0Var = v8.k0.f35197a;
        }
    }

    @NotNull
    public final char[] b() {
        char[] cArrK;
        synchronized (this) {
            cArrK = f25436b.k();
            if (cArrK != null) {
                f25437c -= cArrK.length;
            } else {
                cArrK = null;
            }
        }
        return cArrK == null ? new char[128] : cArrK;
    }
}
