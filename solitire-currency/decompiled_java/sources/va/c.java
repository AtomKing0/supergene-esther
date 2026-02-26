package va;

import com.ironsource.v8;
import com.unity3d.services.UnityAdsConstants;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.collections.a0;
import kotlin.collections.d0;
import kotlin.collections.w;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p9.q;
import p9.r;
import ua.q0;
import ua.x0;
import ua.z0;
import v8.l;
import v8.n;
import v8.s;
import v8.y;

/* JADX INFO: compiled from: ResourceFileSystem.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class c extends ua.j {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    private static final a f35228f = new a(null);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Deprecated
    @NotNull
    private static final q0 f35229g = q0.a.e(q0.f34806b, UnityAdsConstants.DefaultUrls.AD_ASSET_PATH, false, 1, null);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    private final l f35230e;

    /* JADX INFO: compiled from: ResourceFileSystem.kt */
    private static final class a {

        /* JADX INFO: renamed from: va.c$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: ResourceFileSystem.kt */
        static final class C0715a extends v implements h9.l<d, Boolean> {

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public static final C0715a f35231g = new C0715a();

            C0715a() {
                super(1);
            }

            @Override // h9.l
            @NotNull
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Boolean invoke(@NotNull d entry) {
                t.i(entry, "entry");
                return Boolean.valueOf(c.f35228f.c(entry.a()));
            }
        }

        private a() {
        }

        public /* synthetic */ a(k kVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean c(q0 q0Var) {
            return !q.v(q0Var.f(), ".class", true);
        }

        @NotNull
        public final q0 b() {
            return c.f35229g;
        }

        @NotNull
        public final q0 d(@NotNull q0 q0Var, @NotNull q0 base) {
            t.i(q0Var, "<this>");
            t.i(base, "base");
            return b().j(q.F(r.v0(q0Var.toString(), base.toString()), '\\', '/', false, 4, null));
        }

        @NotNull
        public final List<s<ua.j, q0>> e(@NotNull ClassLoader classLoader) throws IOException {
            t.i(classLoader, "<this>");
            Enumeration<URL> resources = classLoader.getResources("");
            t.h(resources, "getResources(\"\")");
            ArrayList<URL> list = Collections.list(resources);
            t.h(list, "list(this)");
            ArrayList arrayList = new ArrayList();
            for (URL it : list) {
                a aVar = c.f35228f;
                t.h(it, "it");
                s<ua.j, q0> sVarF = aVar.f(it);
                if (sVarF != null) {
                    arrayList.add(sVarF);
                }
            }
            Enumeration<URL> resources2 = classLoader.getResources("META-INF/MANIFEST.MF");
            t.h(resources2, "getResources(\"META-INF/MANIFEST.MF\")");
            ArrayList<URL> list2 = Collections.list(resources2);
            t.h(list2, "list(this)");
            ArrayList arrayList2 = new ArrayList();
            for (URL it2 : list2) {
                a aVar2 = c.f35228f;
                t.h(it2, "it");
                s<ua.j, q0> sVarG = aVar2.g(it2);
                if (sVarG != null) {
                    arrayList2.add(sVarG);
                }
            }
            return d0.A0(arrayList, arrayList2);
        }

        @Nullable
        public final s<ua.j, q0> f(@NotNull URL url) {
            t.i(url, "<this>");
            if (t.d(url.getProtocol(), v8.h.f15781b)) {
                return y.a(ua.j.f34780b, q0.a.d(q0.f34806b, new File(url.toURI()), false, 1, null));
            }
            return null;
        }

        @Nullable
        public final s<ua.j, q0> g(@NotNull URL url) {
            int iK0;
            t.i(url, "<this>");
            String string = url.toString();
            t.h(string, "toString()");
            if (!q.K(string, "jar:file:", false, 2, null) || (iK0 = r.k0(string, "!", 0, false, 6, null)) == -1) {
                return null;
            }
            q0.a aVar = q0.f34806b;
            String strSubstring = string.substring(4, iK0);
            t.h(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
            return y.a(e.d(q0.a.d(aVar, new File(URI.create(strSubstring)), false, 1, null), ua.j.f34780b, C0715a.f35231g), b());
        }
    }

    /* JADX INFO: compiled from: ResourceFileSystem.kt */
    static final class b extends v implements h9.a<List<? extends s<? extends ua.j, ? extends q0>>> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ ClassLoader f35232g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(ClassLoader classLoader) {
            super(0);
            this.f35232g = classLoader;
        }

        @Override // h9.a
        @NotNull
        public final List<? extends s<? extends ua.j, ? extends q0>> invoke() {
            return c.f35228f.e(this.f35232g);
        }
    }

    public c(@NotNull ClassLoader classLoader, boolean z10) {
        t.i(classLoader, "classLoader");
        this.f35230e = n.a(new b(classLoader));
        if (z10) {
            u().size();
        }
    }

    private final q0 t(q0 q0Var) {
        return f35229g.k(q0Var, true);
    }

    private final List<s<ua.j, q0>> u() {
        return (List) this.f35230e.getValue();
    }

    private final String v(q0 q0Var) {
        return t(q0Var).i(f35229g).toString();
    }

    @Override // ua.j
    @NotNull
    public x0 b(@NotNull q0 file, boolean z10) throws IOException {
        t.i(file, "file");
        throw new IOException(this + " is read-only");
    }

    @Override // ua.j
    public void c(@NotNull q0 source, @NotNull q0 target) throws IOException {
        t.i(source, "source");
        t.i(target, "target");
        throw new IOException(this + " is read-only");
    }

    @Override // ua.j
    public void g(@NotNull q0 dir, boolean z10) throws IOException {
        t.i(dir, "dir");
        throw new IOException(this + " is read-only");
    }

    @Override // ua.j
    public void i(@NotNull q0 path, boolean z10) throws IOException {
        t.i(path, "path");
        throw new IOException(this + " is read-only");
    }

    @Override // ua.j
    @NotNull
    public List<q0> k(@NotNull q0 dir) throws FileNotFoundException {
        t.i(dir, "dir");
        String strV = v(dir);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        boolean z10 = false;
        for (s<ua.j, q0> sVar : u()) {
            ua.j jVarA = sVar.a();
            q0 q0VarB = sVar.b();
            try {
                List<q0> listK = jVarA.k(q0VarB.j(strV));
                ArrayList arrayList = new ArrayList();
                for (Object obj : listK) {
                    if (f35228f.c((q0) obj)) {
                        arrayList.add(obj);
                    }
                }
                ArrayList arrayList2 = new ArrayList(w.v(arrayList, 10));
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    arrayList2.add(f35228f.d((q0) it.next(), q0VarB));
                }
                a0.B(linkedHashSet, arrayList2);
                z10 = true;
            } catch (IOException unused) {
            }
        }
        if (z10) {
            return d0.P0(linkedHashSet);
        }
        throw new FileNotFoundException("file not found: " + dir);
    }

    @Override // ua.j
    @Nullable
    public ua.i m(@NotNull q0 path) throws IOException {
        t.i(path, "path");
        if (!f35228f.c(path)) {
            return null;
        }
        String strV = v(path);
        for (s<ua.j, q0> sVar : u()) {
            ua.i iVarM = sVar.a().m(sVar.b().j(strV));
            if (iVarM != null) {
                return iVarM;
            }
        }
        return null;
    }

    @Override // ua.j
    @NotNull
    public ua.h n(@NotNull q0 file) throws FileNotFoundException {
        t.i(file, "file");
        if (!f35228f.c(file)) {
            throw new FileNotFoundException("file not found: " + file);
        }
        String strV = v(file);
        for (s<ua.j, q0> sVar : u()) {
            try {
                return sVar.a().n(sVar.b().j(strV));
            } catch (FileNotFoundException unused) {
            }
        }
        throw new FileNotFoundException("file not found: " + file);
    }

    @Override // ua.j
    @NotNull
    public x0 p(@NotNull q0 file, boolean z10) throws IOException {
        t.i(file, "file");
        throw new IOException(this + " is read-only");
    }

    @Override // ua.j
    @NotNull
    public z0 q(@NotNull q0 file) throws FileNotFoundException {
        t.i(file, "file");
        if (!f35228f.c(file)) {
            throw new FileNotFoundException("file not found: " + file);
        }
        String strV = v(file);
        for (s<ua.j, q0> sVar : u()) {
            try {
                return sVar.a().q(sVar.b().j(strV));
            } catch (FileNotFoundException unused) {
            }
        }
        throw new FileNotFoundException("file not found: " + file);
    }
}
