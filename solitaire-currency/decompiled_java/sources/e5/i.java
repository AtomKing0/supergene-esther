package e5;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Map;

/* JADX INFO: compiled from: MoreObjects.java */
/* JADX INFO: loaded from: classes3.dex */
public final class i {

    /* JADX INFO: compiled from: MoreObjects.java */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f25145a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final a f25146b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private a f25147c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f25148d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f25149e;

        /* JADX INFO: compiled from: MoreObjects.java */
        private static class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            String f25150a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            Object f25151b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            a f25152c;

            private a() {
            }
        }

        private a a() {
            a aVar = new a();
            this.f25147c.f25152c = aVar;
            this.f25147c = aVar;
            return aVar;
        }

        private b b(Object obj) {
            a().f25151b = obj;
            return this;
        }

        private static boolean d(Object obj) {
            return obj instanceof CharSequence ? ((CharSequence) obj).length() == 0 : obj instanceof Collection ? ((Collection) obj).isEmpty() : obj instanceof Map ? ((Map) obj).isEmpty() : obj instanceof l ? !((l) obj).c() : obj.getClass().isArray() && Array.getLength(obj) == 0;
        }

        public b c(Object obj) {
            return b(obj);
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x002c  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public java.lang.String toString() {
            /*
                r8 = this;
                boolean r0 = r8.f25148d
                boolean r1 = r8.f25149e
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r3 = 32
                r2.<init>(r3)
                java.lang.String r3 = r8.f25145a
                r2.append(r3)
                r3 = 123(0x7b, float:1.72E-43)
                r2.append(r3)
                e5.i$b$a r3 = r8.f25146b
                e5.i$b$a r3 = r3.f25152c
                java.lang.String r4 = ""
            L1b:
                if (r3 == 0) goto L62
                java.lang.Object r5 = r3.f25151b
                if (r5 != 0) goto L24
                if (r0 != 0) goto L5f
                goto L2c
            L24:
                if (r1 == 0) goto L2c
                boolean r6 = d(r5)
                if (r6 != 0) goto L5f
            L2c:
                r2.append(r4)
                java.lang.String r4 = r3.f25150a
                if (r4 == 0) goto L3b
                r2.append(r4)
                r4 = 61
                r2.append(r4)
            L3b:
                if (r5 == 0) goto L5a
                java.lang.Class r4 = r5.getClass()
                boolean r4 = r4.isArray()
                if (r4 == 0) goto L5a
                r4 = 1
                java.lang.Object[] r6 = new java.lang.Object[r4]
                r7 = 0
                r6[r7] = r5
                java.lang.String r5 = java.util.Arrays.deepToString(r6)
                int r6 = r5.length()
                int r6 = r6 - r4
                r2.append(r5, r4, r6)
                goto L5d
            L5a:
                r2.append(r5)
            L5d:
                java.lang.String r4 = ", "
            L5f:
                e5.i$b$a r3 = r3.f25152c
                goto L1b
            L62:
                r0 = 125(0x7d, float:1.75E-43)
                r2.append(r0)
                java.lang.String r0 = r2.toString()
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: e5.i.b.toString():java.lang.String");
        }

        private b(String str) {
            a aVar = new a();
            this.f25146b = aVar;
            this.f25147c = aVar;
            this.f25148d = false;
            this.f25149e = false;
            this.f25145a = (String) o.j(str);
        }
    }

    public static <T> T a(T t10, T t11) {
        if (t10 != null) {
            return t10;
        }
        if (t11 != null) {
            return t11;
        }
        throw new NullPointerException("Both parameters are null");
    }

    public static b b(Object obj) {
        return new b(obj.getClass().getSimpleName());
    }
}
