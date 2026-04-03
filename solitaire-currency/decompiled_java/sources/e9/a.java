package e9;

import l9.c;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: JDK8PlatformImplementations.kt */
/* JADX INFO: loaded from: classes5.dex */
public class a extends d9.a {

    /* JADX INFO: renamed from: e9.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: JDK8PlatformImplementations.kt */
    private static final class C0550a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        public static final C0550a f25409a = new C0550a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        public static final Integer f25410b;

        static {
            Object obj;
            Integer num = null;
            try {
                obj = Class.forName("android.os.Build$VERSION").getField("SDK_INT").get(null);
            } catch (Throwable unused) {
            }
            Integer num2 = obj instanceof Integer ? (Integer) obj : null;
            if (num2 != null) {
                if (num2.intValue() > 0) {
                    num = num2;
                }
            }
            f25410b = num;
        }

        private C0550a() {
        }
    }

    private final boolean c(int i10) {
        Integer num = C0550a.f25410b;
        return num == null || num.intValue() >= i10;
    }

    @Override // c9.a
    @NotNull
    public c b() {
        return c(34) ? new m9.a() : super.b();
    }
}
