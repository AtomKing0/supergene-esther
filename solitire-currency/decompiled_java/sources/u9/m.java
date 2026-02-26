package u9;

import v8.t;

/* JADX INFO: compiled from: FastServiceLoader.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final boolean f34678a;

    static {
        Object objB;
        try {
            t.a aVar = v8.t.f35208b;
            objB = v8.t.b(Class.forName("android.os.Build"));
        } catch (Throwable th) {
            t.a aVar2 = v8.t.f35208b;
            objB = v8.t.b(v8.u.a(th));
        }
        f34678a = v8.t.h(objB);
    }

    public static final boolean a() {
        return f34678a;
    }
}
