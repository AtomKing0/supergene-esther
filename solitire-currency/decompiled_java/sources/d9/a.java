package d9;

import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: JDK7PlatformImplementations.kt */
/* JADX INFO: loaded from: classes5.dex */
public class a extends c9.a {

    /* JADX INFO: renamed from: d9.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: JDK7PlatformImplementations.kt */
    private static final class C0541a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        public static final C0541a f24532a = new C0541a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        public static final Integer f24533b;

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
            f24533b = num;
        }

        private C0541a() {
        }
    }

    private final boolean c(int i10) {
        Integer num = C0541a.f24533b;
        return num == null || num.intValue() >= i10;
    }

    @Override // c9.a
    public void a(@NotNull Throwable cause, @NotNull Throwable exception) {
        t.i(cause, "cause");
        t.i(exception, "exception");
        if (c(19)) {
            cause.addSuppressed(exception);
        } else {
            super.a(cause, exception);
        }
    }
}
