package xa;

import com.ironsource.v8;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;
import org.slf4j.impl.StaticLoggerBinder;
import ya.d;
import za.e;
import za.f;
import za.g;

/* JADX INFO: compiled from: LoggerFactory.java */
/* JADX INFO: loaded from: classes5.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static volatile int f36247a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final f f36248b = new f();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final za.c f36249c = new za.c();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static boolean f36250d = g.f("slf4j.detectLoggerNameMismatch");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String[] f36251e = {"1.6", "1.7"};

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static String f36252f = "org/slf4j/impl/StaticLoggerBinder.class";

    private b() {
    }

    private static final void a() {
        Set<URL> setF;
        try {
            try {
                if (l()) {
                    setF = null;
                } else {
                    setF = f();
                    t(setF);
                }
                StaticLoggerBinder.getSingleton();
                f36247a = 3;
                s(setF);
            } catch (Exception e10) {
                e(e10);
                throw new IllegalStateException("Unexpected initialization failure", e10);
            } catch (NoClassDefFoundError e11) {
                if (!m(e11.getMessage())) {
                    e(e11);
                    throw e11;
                }
                f36247a = 4;
                g.c("Failed to load class \"org.slf4j.impl.StaticLoggerBinder\".");
                g.c("Defaulting to no-operation (NOP) logger implementation");
                g.c("See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.");
            } catch (NoSuchMethodError e12) {
                String message = e12.getMessage();
                if (message != null && message.contains("org.slf4j.impl.StaticLoggerBinder.getSingleton()")) {
                    f36247a = 2;
                    g.c("slf4j-api 1.6.x (or later) is incompatible with this binding.");
                    g.c("Your binding is version 1.5.5 or earlier.");
                    g.c("Upgrade your binding to version 1.6.x.");
                }
                throw e12;
            }
        } finally {
            p();
        }
    }

    private static void b(d dVar, int i10) {
        if (dVar.a().e()) {
            c(i10);
        } else {
            if (dVar.a().f()) {
                return;
            }
            d();
        }
    }

    private static void c(int i10) {
        g.c("A number (" + i10 + ") of logging calls during the initialization phase have been intercepted and are");
        g.c("now being replayed. These are subject to the filtering rules of the underlying logging system.");
        g.c("See also http://www.slf4j.org/codes.html#replay");
    }

    private static void d() {
        g.c("The following set of substitute loggers may have been accessed");
        g.c("during the initialization phase. Logging calls during this");
        g.c("phase were not honored. However, subsequent logging calls to these");
        g.c("loggers will work as normally expected.");
        g.c("See also http://www.slf4j.org/codes.html#substituteLogger");
    }

    static void e(Throwable th) {
        f36247a = 2;
        g.d("Failed to instantiate SLF4J LoggerFactory", th);
    }

    static Set<URL> f() {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        try {
            ClassLoader classLoader = b.class.getClassLoader();
            Enumeration<URL> systemResources = classLoader == null ? ClassLoader.getSystemResources(f36252f) : classLoader.getResources(f36252f);
            while (systemResources.hasMoreElements()) {
                linkedHashSet.add(systemResources.nextElement());
            }
        } catch (IOException e10) {
            g.d("Error getting resources from path", e10);
        }
        return linkedHashSet;
    }

    private static void g() {
        f fVar = f36248b;
        synchronized (fVar) {
            fVar.e();
            for (e eVar : fVar.d()) {
                eVar.i(j(eVar.getName()));
            }
        }
    }

    public static ILoggerFactory h() {
        if (f36247a == 0) {
            synchronized (b.class) {
                if (f36247a == 0) {
                    f36247a = 1;
                    o();
                }
            }
        }
        int i10 = f36247a;
        if (i10 == 1) {
            return f36248b;
        }
        if (i10 == 2) {
            throw new IllegalStateException("org.slf4j.LoggerFactory in failed state. Original exception was thrown EARLIER. See also http://www.slf4j.org/codes.html#unsuccessfulInit");
        }
        if (i10 == 3) {
            return StaticLoggerBinder.getSingleton().getLoggerFactory();
        }
        if (i10 == 4) {
            return f36249c;
        }
        throw new IllegalStateException("Unreachable code");
    }

    public static a i(Class<?> cls) {
        Class<?> clsA;
        a aVarJ = j(cls.getName());
        if (f36250d && (clsA = g.a()) != null && n(cls, clsA)) {
            g.c(String.format("Detected logger name mismatch. Given name: \"%s\"; computed name: \"%s\".", aVarJ.getName(), clsA.getName()));
            g.c("See http://www.slf4j.org/codes.html#loggerNameMismatch for an explanation");
        }
        return aVarJ;
    }

    public static a j(String str) {
        return h().a(str);
    }

    private static boolean k(Set<URL> set) {
        return set.size() > 1;
    }

    private static boolean l() {
        String strG = g.g("java.vendor.url");
        if (strG == null) {
            return false;
        }
        return strG.toLowerCase().contains("android");
    }

    private static boolean m(String str) {
        if (str == null) {
            return false;
        }
        return str.contains("org/slf4j/impl/StaticLoggerBinder") || str.contains("org.slf4j.impl.StaticLoggerBinder");
    }

    private static boolean n(Class<?> cls, Class<?> cls2) {
        return !cls2.isAssignableFrom(cls);
    }

    private static final void o() {
        a();
        if (f36247a == 3) {
            u();
        }
    }

    private static void p() {
        g();
        q();
        f36248b.b();
    }

    private static void q() {
        LinkedBlockingQueue<d> linkedBlockingQueueC = f36248b.c();
        int size = linkedBlockingQueueC.size();
        ArrayList<d> arrayList = new ArrayList(128);
        int i10 = 0;
        while (linkedBlockingQueueC.drainTo(arrayList, 128) != 0) {
            for (d dVar : arrayList) {
                r(dVar);
                int i11 = i10 + 1;
                if (i10 == 0) {
                    b(dVar, size);
                }
                i10 = i11;
            }
            arrayList.clear();
        }
    }

    private static void r(d dVar) {
        if (dVar == null) {
            return;
        }
        e eVarA = dVar.a();
        String name = eVarA.getName();
        if (eVarA.g()) {
            throw new IllegalStateException("Delegate logger cannot be null at this state.");
        }
        if (eVarA.f()) {
            return;
        }
        if (eVarA.e()) {
            eVarA.h(dVar);
        } else {
            g.c(name);
        }
    }

    private static void s(Set<URL> set) {
        if (set == null || !k(set)) {
            return;
        }
        g.c("Actual binding is of type [" + StaticLoggerBinder.getSingleton().getLoggerFactoryClassStr() + v8.i.f15839e);
    }

    private static void t(Set<URL> set) {
        if (k(set)) {
            g.c("Class path contains multiple SLF4J bindings.");
            Iterator<URL> it = set.iterator();
            while (it.hasNext()) {
                g.c("Found binding in [" + it.next() + v8.i.f15839e);
            }
            g.c("See http://www.slf4j.org/codes.html#multiple_bindings for an explanation.");
        }
    }

    private static final void u() {
        try {
            String str = StaticLoggerBinder.REQUESTED_API_VERSION;
            boolean z10 = false;
            for (String str2 : f36251e) {
                if (str.startsWith(str2)) {
                    z10 = true;
                }
            }
            if (z10) {
                return;
            }
            g.c("The requested version " + str + " by your slf4j binding is not compatible with " + Arrays.asList(f36251e).toString());
            g.c("See http://www.slf4j.org/codes.html#version_mismatch for further details.");
        } catch (NoSuchFieldError unused) {
        } catch (Throwable th) {
            g.d("Unexpected problem occured during version sanity check", th);
        }
    }
}
