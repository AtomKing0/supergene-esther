package ua;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Path.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class q0 implements Comparable<q0> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public static final a f34806b = new a(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    public static final String f34807c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final f f34808a;

    /* JADX INFO: compiled from: Path.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        public static /* synthetic */ q0 d(a aVar, File file, boolean z10, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                z10 = false;
            }
            return aVar.a(file, z10);
        }

        public static /* synthetic */ q0 e(a aVar, String str, boolean z10, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                z10 = false;
            }
            return aVar.b(str, z10);
        }

        public static /* synthetic */ q0 f(a aVar, Path path, boolean z10, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                z10 = false;
            }
            return aVar.c(path, z10);
        }

        @NotNull
        public final q0 a(@NotNull File file, boolean z10) {
            kotlin.jvm.internal.t.i(file, "<this>");
            String string = file.toString();
            kotlin.jvm.internal.t.h(string, "toString()");
            return b(string, z10);
        }

        @NotNull
        public final q0 b(@NotNull String str, boolean z10) {
            kotlin.jvm.internal.t.i(str, "<this>");
            return va.i.k(str, z10);
        }

        @IgnoreJRERequirement
        @NotNull
        public final q0 c(@NotNull Path path, boolean z10) {
            kotlin.jvm.internal.t.i(path, "<this>");
            return b(path.toString(), z10);
        }
    }

    static {
        String separator = File.separator;
        kotlin.jvm.internal.t.h(separator, "separator");
        f34807c = separator;
    }

    public q0(@NotNull f bytes) {
        kotlin.jvm.internal.t.i(bytes, "bytes");
        this.f34808a = bytes;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(@NotNull q0 other) {
        kotlin.jvm.internal.t.i(other, "other");
        return c().compareTo(other.c());
    }

    @NotNull
    public final f c() {
        return this.f34808a;
    }

    @Nullable
    public final q0 d() {
        int iO = va.i.o(this);
        if (iO == -1) {
            return null;
        }
        return new q0(c().D(0, iO));
    }

    @NotNull
    public final List<f> e() {
        ArrayList arrayList = new ArrayList();
        int iO = va.i.o(this);
        if (iO == -1) {
            iO = 0;
        } else if (iO < c().B() && c().f(iO) == ((byte) 92)) {
            iO++;
        }
        int iB = c().B();
        int i10 = iO;
        while (iO < iB) {
            if (c().f(iO) == ((byte) 47) || c().f(iO) == ((byte) 92)) {
                arrayList.add(c().D(i10, iO));
                i10 = iO + 1;
            }
            iO++;
        }
        if (i10 < c().B()) {
            arrayList.add(c().D(i10, c().B()));
        }
        return arrayList;
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof q0) && kotlin.jvm.internal.t.d(((q0) obj).c(), c());
    }

    @NotNull
    public final String f() {
        return g().G();
    }

    @NotNull
    public final f g() {
        int iL = va.i.l(this);
        return iL != -1 ? f.E(c(), iL + 1, 0, 2, null) : (m() == null || c().B() != 2) ? c() : f.f34756e;
    }

    @Nullable
    public final q0 h() {
        q0 q0Var;
        if (kotlin.jvm.internal.t.d(c(), va.i.f35258d) || kotlin.jvm.internal.t.d(c(), va.i.f35255a) || kotlin.jvm.internal.t.d(c(), va.i.f35256b) || va.i.n(this)) {
            return null;
        }
        int iL = va.i.l(this);
        if (iL != 2 || m() == null) {
            if (iL == 1 && c().C(va.i.f35256b)) {
                return null;
            }
            if (iL != -1 || m() == null) {
                if (iL == -1) {
                    return new q0(va.i.f35258d);
                }
                if (iL != 0) {
                    return new q0(f.E(c(), 0, iL, 1, null));
                }
                q0Var = new q0(f.E(c(), 0, 1, 1, null));
            } else {
                if (c().B() == 2) {
                    return null;
                }
                q0Var = new q0(f.E(c(), 0, 2, 1, null));
            }
        } else {
            if (c().B() == 3) {
                return null;
            }
            q0Var = new q0(f.E(c(), 0, 3, 1, null));
        }
        return q0Var;
    }

    public int hashCode() {
        return c().hashCode();
    }

    @NotNull
    public final q0 i(@NotNull q0 other) {
        kotlin.jvm.internal.t.i(other, "other");
        if (!kotlin.jvm.internal.t.d(d(), other.d())) {
            throw new IllegalArgumentException(("Paths of different roots cannot be relative to each other: " + this + " and " + other).toString());
        }
        List<f> listE = e();
        List<f> listE2 = other.e();
        int iMin = Math.min(listE.size(), listE2.size());
        int i10 = 0;
        while (i10 < iMin && kotlin.jvm.internal.t.d(listE.get(i10), listE2.get(i10))) {
            i10++;
        }
        if (i10 == iMin && c().B() == other.c().B()) {
            return a.e(f34806b, ".", false, 1, null);
        }
        if (!(listE2.subList(i10, listE2.size()).indexOf(va.i.f35259e) == -1)) {
            throw new IllegalArgumentException(("Impossible relative path to resolve: " + this + " and " + other).toString());
        }
        c cVar = new c();
        f fVarM = va.i.m(other);
        if (fVarM == null && (fVarM = va.i.m(this)) == null) {
            fVarM = va.i.s(f34807c);
        }
        int size = listE2.size();
        for (int i11 = i10; i11 < size; i11++) {
            cVar.I(va.i.f35259e);
            cVar.I(fVarM);
        }
        int size2 = listE.size();
        while (i10 < size2) {
            cVar.I(listE.get(i10));
            cVar.I(fVarM);
            i10++;
        }
        return va.i.q(cVar, false);
    }

    public final boolean isAbsolute() {
        return va.i.o(this) != -1;
    }

    @NotNull
    public final q0 j(@NotNull String child) {
        kotlin.jvm.internal.t.i(child, "child");
        return va.i.j(this, va.i.q(new c().E(child), false), false);
    }

    @NotNull
    public final q0 k(@NotNull q0 child, boolean z10) {
        kotlin.jvm.internal.t.i(child, "child");
        return va.i.j(this, child, z10);
    }

    @IgnoreJRERequirement
    @NotNull
    public final Path l() {
        Path path = Paths.get(toString(), new String[0]);
        kotlin.jvm.internal.t.h(path, "get(toString())");
        return path;
    }

    @Nullable
    public final Character m() {
        boolean z10 = false;
        if (f.n(c(), va.i.f35255a, 0, 2, null) != -1 || c().B() < 2 || c().f(1) != ((byte) 58)) {
            return null;
        }
        char cF = (char) c().f(0);
        if (!('a' <= cF && cF < '{')) {
            if ('A' <= cF && cF < '[') {
                z10 = true;
            }
            if (!z10) {
                return null;
            }
        }
        return Character.valueOf(cF);
    }

    @NotNull
    public final File toFile() {
        return new File(toString());
    }

    @NotNull
    public String toString() {
        return c().G();
    }
}
