package kotlin.jvm.internal;

import java.util.Arrays;

/* JADX INFO: compiled from: Intrinsics.java */
/* JADX INFO: loaded from: classes5.dex */
public class t {

    /* JADX INFO: compiled from: Intrinsics.java */
    public static class a {
        private a() {
        }
    }

    private t() {
    }

    public static void A(String str) {
        z("lateinit property " + str + " has not been initialized");
    }

    public static boolean a(float f10, Float f11) {
        return f11 != null && f10 == f11.floatValue();
    }

    public static boolean b(Double d10, Double d11) {
        if (d10 == null) {
            if (d11 == null) {
                return true;
            }
        } else if (d11 != null && d10.doubleValue() == d11.doubleValue()) {
            return true;
        }
        return false;
    }

    public static boolean c(Float f10, Float f11) {
        if (f10 == null) {
            if (f11 == null) {
                return true;
            }
        } else if (f11 != null && f10.floatValue() == f11.floatValue()) {
            return true;
        }
        return false;
    }

    public static boolean d(Object obj, Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    public static void e(Object obj, String str) {
        if (obj != null) {
            return;
        }
        throw ((IllegalStateException) p(new IllegalStateException(str + " must not be null")));
    }

    public static void f(Object obj) {
        if (obj == null) {
            s();
        }
    }

    public static void g(Object obj, String str) {
        if (obj == null) {
            t(str);
        }
    }

    public static void h(Object obj, String str) {
        if (obj != null) {
            return;
        }
        throw ((NullPointerException) p(new NullPointerException(str + " must not be null")));
    }

    public static void i(Object obj, String str) {
        if (obj == null) {
            w(str);
        }
    }

    public static void j(Object obj, String str) {
        if (obj == null) {
            v(str);
        }
    }

    public static int k(int i10, int i11) {
        if (i10 < i11) {
            return -1;
        }
        return i10 == i11 ? 0 : 1;
    }

    public static int l(long j10, long j11) {
        if (j10 < j11) {
            return -1;
        }
        return j10 == j11 ? 0 : 1;
    }

    private static String m(String str) {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        String name = t.class.getName();
        int i10 = 0;
        while (!stackTrace[i10].getClassName().equals(name)) {
            i10++;
        }
        while (stackTrace[i10].getClassName().equals(name)) {
            i10++;
        }
        StackTraceElement stackTraceElement = stackTrace[i10];
        return "Parameter specified as non-null is null: method " + stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName() + ", parameter " + str;
    }

    public static void n() {
        x();
    }

    public static void o(int i10, String str) {
        x();
    }

    private static <T extends Throwable> T p(T t10) {
        return (T) q(t10, t.class.getName());
    }

    static <T extends Throwable> T q(T t10, String str) {
        StackTraceElement[] stackTrace = t10.getStackTrace();
        int length = stackTrace.length;
        int i10 = -1;
        for (int i11 = 0; i11 < length; i11++) {
            if (str.equals(stackTrace[i11].getClassName())) {
                i10 = i11;
            }
        }
        t10.setStackTrace((StackTraceElement[]) Arrays.copyOfRange(stackTrace, i10 + 1, length));
        return t10;
    }

    public static String r(String str, Object obj) {
        return str + obj;
    }

    public static void s() {
        throw ((NullPointerException) p(new NullPointerException()));
    }

    public static void t(String str) {
        throw ((NullPointerException) p(new NullPointerException(str)));
    }

    public static void u() {
        throw ((v8.i) p(new v8.i()));
    }

    private static void v(String str) {
        throw ((IllegalArgumentException) p(new IllegalArgumentException(m(str))));
    }

    private static void w(String str) {
        throw ((NullPointerException) p(new NullPointerException(m(str))));
    }

    public static void x() {
        y("This function has a reified type parameter and thus can only be inlined at compilation time, not called directly.");
    }

    public static void y(String str) {
        throw new UnsupportedOperationException(str);
    }

    public static void z(String str) {
        throw ((v8.j0) p(new v8.j0(str)));
    }
}
