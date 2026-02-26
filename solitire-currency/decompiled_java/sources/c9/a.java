package c9;

import java.lang.reflect.Method;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: PlatformImplementations.kt */
/* JADX INFO: loaded from: classes5.dex */
public class a {

    /* JADX INFO: renamed from: c9.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: PlatformImplementations.kt */
    private static final class C0156a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        public static final C0156a f4634a = new C0156a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        public static final Method f4635b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Nullable
        public static final Method f4636c;

        /* JADX WARN: Removed duplicated region for block: B:10:0x003b  */
        static {
            /*
                c9.a$a r0 = new c9.a$a
                r0.<init>()
                c9.a.C0156a.f4634a = r0
                java.lang.Class<java.lang.Throwable> r0 = java.lang.Throwable.class
                java.lang.reflect.Method[] r1 = r0.getMethods()
                java.lang.String r2 = "throwableMethods"
                kotlin.jvm.internal.t.h(r1, r2)
                int r2 = r1.length
                r3 = 0
                r4 = r3
            L15:
                r5 = 0
                if (r4 >= r2) goto L42
                r6 = r1[r4]
                java.lang.String r7 = r6.getName()
                java.lang.String r8 = "addSuppressed"
                boolean r7 = kotlin.jvm.internal.t.d(r7, r8)
                if (r7 == 0) goto L3b
                java.lang.Class[] r7 = r6.getParameterTypes()
                java.lang.String r8 = "it.parameterTypes"
                kotlin.jvm.internal.t.h(r7, r8)
                java.lang.Object r7 = kotlin.collections.l.i0(r7)
                boolean r7 = kotlin.jvm.internal.t.d(r7, r0)
                if (r7 == 0) goto L3b
                r7 = 1
                goto L3c
            L3b:
                r7 = r3
            L3c:
                if (r7 == 0) goto L3f
                goto L43
            L3f:
                int r4 = r4 + 1
                goto L15
            L42:
                r6 = r5
            L43:
                c9.a.C0156a.f4635b = r6
                int r0 = r1.length
            L46:
                if (r3 >= r0) goto L5b
                r2 = r1[r3]
                java.lang.String r4 = r2.getName()
                java.lang.String r6 = "getSuppressed"
                boolean r4 = kotlin.jvm.internal.t.d(r4, r6)
                if (r4 == 0) goto L58
                r5 = r2
                goto L5b
            L58:
                int r3 = r3 + 1
                goto L46
            L5b:
                c9.a.C0156a.f4636c = r5
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: c9.a.C0156a.<clinit>():void");
        }

        private C0156a() {
        }
    }

    public void a(@NotNull Throwable cause, @NotNull Throwable exception) {
        t.i(cause, "cause");
        t.i(exception, "exception");
        Method method = C0156a.f4635b;
        if (method != null) {
            method.invoke(cause, exception);
        }
    }

    @NotNull
    public l9.c b() {
        return new l9.b();
    }
}
