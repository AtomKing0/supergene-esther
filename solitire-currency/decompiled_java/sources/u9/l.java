package u9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ServiceLoader;
import java.util.Set;
import java.util.jar.JarFile;
import java.util.zip.ZipEntry;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: FastServiceLoader.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final l f34670a = new l();

    private l() {
    }

    private final <S> S a(String str, ClassLoader classLoader, Class<S> cls) throws ClassNotFoundException {
        Class<?> cls2 = Class.forName(str, false, classLoader);
        if (cls.isAssignableFrom(cls2)) {
            return cls.cast(cls2.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
        }
        throw new IllegalArgumentException(("Expected service of class " + cls + ", but found " + cls2).toString());
    }

    private final <S> List<S> b(Class<S> cls, ClassLoader classLoader) {
        try {
            return d(cls, classLoader);
        } catch (Throwable unused) {
            return kotlin.collections.d0.P0(ServiceLoader.load(cls, classLoader));
        }
    }

    private final List<String> e(URL url) {
        BufferedReader bufferedReader;
        String string = url.toString();
        if (!p9.q.K(string, "jar", false, 2, null)) {
            bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()));
            try {
                List<String> listF = f34670a.f(bufferedReader);
                f9.c.a(bufferedReader, null);
                return listF;
            } catch (Throwable th) {
                try {
                    throw th;
                } finally {
                }
            }
        }
        String strU0 = p9.r.U0(p9.r.N0(string, "jar:file:", null, 2, null), '!', null, 2, null);
        String strN0 = p9.r.N0(string, "!/", null, 2, null);
        JarFile jarFile = new JarFile(strU0, false);
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(jarFile.getInputStream(new ZipEntry(strN0)), "UTF-8"));
            try {
                List<String> listF2 = f34670a.f(bufferedReader);
                f9.c.a(bufferedReader, null);
                jarFile.close();
                return listF2;
            } finally {
            }
        } catch (Throwable th2) {
            try {
                throw th2;
            } catch (Throwable th3) {
                try {
                    jarFile.close();
                    throw th3;
                } catch (Throwable th4) {
                    v8.f.a(th2, th4);
                    throw th2;
                }
            }
        }
    }

    private final List<String> f(BufferedReader bufferedReader) throws IOException {
        boolean z10;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        while (true) {
            String line = bufferedReader.readLine();
            if (line == null) {
                return kotlin.collections.d0.P0(linkedHashSet);
            }
            String string = p9.r.b1(p9.r.V0(line, "#", null, 2, null)).toString();
            int i10 = 0;
            while (true) {
                if (i10 >= string.length()) {
                    z10 = true;
                    break;
                }
                char cCharAt = string.charAt(i10);
                if (!(cCharAt == '.' || Character.isJavaIdentifierPart(cCharAt))) {
                    z10 = false;
                    break;
                }
                i10++;
            }
            if (!z10) {
                throw new IllegalArgumentException(("Illegal service provider class name: " + string).toString());
            }
            if (string.length() > 0) {
                linkedHashSet.add(string);
            }
        }
    }

    @NotNull
    public final List<v> c() {
        v vVar;
        if (!m.a()) {
            return b(v.class, v.class.getClassLoader());
        }
        try {
            ArrayList arrayList = new ArrayList(2);
            v vVar2 = null;
            try {
                vVar = (v) v.class.cast(Class.forName("kotlinx.coroutines.android.AndroidDispatcherFactory", true, v.class.getClassLoader()).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
            } catch (ClassNotFoundException unused) {
                vVar = null;
            }
            if (vVar != null) {
                arrayList.add(vVar);
            }
            try {
                vVar2 = (v) v.class.cast(Class.forName("kotlinx.coroutines.test.internal.TestMainDispatcherFactory", true, v.class.getClassLoader()).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
            } catch (ClassNotFoundException unused2) {
            }
            if (vVar2 == null) {
                return arrayList;
            }
            arrayList.add(vVar2);
            return arrayList;
        } catch (Throwable unused3) {
            return b(v.class, v.class.getClassLoader());
        }
    }

    @NotNull
    public final <S> List<S> d(@NotNull Class<S> cls, @NotNull ClassLoader classLoader) {
        ArrayList list = Collections.list(classLoader.getResources("META-INF/services/" + cls.getName()));
        kotlin.jvm.internal.t.h(list, "list(this)");
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            kotlin.collections.a0.B(arrayList, f34670a.e((URL) it.next()));
        }
        Set setT0 = kotlin.collections.d0.T0(arrayList);
        if (!(!setT0.isEmpty())) {
            throw new IllegalArgumentException("No providers were loaded with FastServiceLoader".toString());
        }
        Set set = setT0;
        ArrayList arrayList2 = new ArrayList(kotlin.collections.w.v(set, 10));
        Iterator it2 = set.iterator();
        while (it2.hasNext()) {
            arrayList2.add(f34670a.a((String) it2.next(), classLoader, cls));
        }
        return arrayList2;
    }
}
