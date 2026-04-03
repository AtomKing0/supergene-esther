package va;

import com.unity3d.services.UnityAdsConstants;
import java.io.EOFException;
import java.util.ArrayList;
import kotlin.collections.a0;
import kotlin.collections.d0;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import ua.f;
import ua.q0;

/* JADX INFO: compiled from: -Path.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private static final ua.f f35255a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private static final ua.f f35256b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private static final ua.f f35257c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private static final ua.f f35258d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    private static final ua.f f35259e;

    static {
        f.a aVar = ua.f.f34755d;
        f35255a = aVar.d(UnityAdsConstants.DefaultUrls.AD_ASSET_PATH);
        f35256b = aVar.d("\\");
        f35257c = aVar.d("/\\");
        f35258d = aVar.d(".");
        f35259e = aVar.d("..");
    }

    @NotNull
    public static final q0 j(@NotNull q0 q0Var, @NotNull q0 child, boolean z10) {
        t.i(q0Var, "<this>");
        t.i(child, "child");
        if (child.isAbsolute() || child.m() != null) {
            return child;
        }
        ua.f fVarM = m(q0Var);
        if (fVarM == null && (fVarM = m(child)) == null) {
            fVarM = s(q0.f34807c);
        }
        ua.c cVar = new ua.c();
        cVar.I(q0Var.c());
        if (cVar.size() > 0) {
            cVar.I(fVarM);
        }
        cVar.I(child.c());
        return q(cVar, z10);
    }

    @NotNull
    public static final q0 k(@NotNull String str, boolean z10) {
        t.i(str, "<this>");
        return q(new ua.c().E(str), z10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int l(q0 q0Var) {
        int iS = ua.f.s(q0Var.c(), f35255a, 0, 2, null);
        return iS != -1 ? iS : ua.f.s(q0Var.c(), f35256b, 0, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.f m(q0 q0Var) {
        ua.f fVarC = q0Var.c();
        ua.f fVar = f35255a;
        if (ua.f.n(fVarC, fVar, 0, 2, null) != -1) {
            return fVar;
        }
        ua.f fVarC2 = q0Var.c();
        ua.f fVar2 = f35256b;
        if (ua.f.n(fVarC2, fVar2, 0, 2, null) != -1) {
            return fVar2;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean n(q0 q0Var) {
        return q0Var.c().e(f35259e) && (q0Var.c().B() == 2 || q0Var.c().v(q0Var.c().B() + (-3), f35255a, 0, 1) || q0Var.c().v(q0Var.c().B() + (-3), f35256b, 0, 1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int o(q0 q0Var) {
        if (q0Var.c().B() == 0) {
            return -1;
        }
        boolean z10 = false;
        if (q0Var.c().f(0) == ((byte) 47)) {
            return 1;
        }
        byte b10 = (byte) 92;
        if (q0Var.c().f(0) == b10) {
            if (q0Var.c().B() <= 2 || q0Var.c().f(1) != b10) {
                return 1;
            }
            int iL = q0Var.c().l(f35256b, 2);
            return iL == -1 ? q0Var.c().B() : iL;
        }
        if (q0Var.c().B() <= 2 || q0Var.c().f(1) != ((byte) 58) || q0Var.c().f(2) != b10) {
            return -1;
        }
        char cF = (char) q0Var.c().f(0);
        if ('a' <= cF && cF < '{') {
            return 3;
        }
        if ('A' <= cF && cF < '[') {
            z10 = true;
        }
        return !z10 ? -1 : 3;
    }

    private static final boolean p(ua.c cVar, ua.f fVar) {
        if (!t.d(fVar, f35256b) || cVar.size() < 2 || cVar.L(1L) != ((byte) 58)) {
            return false;
        }
        char cL = (char) cVar.L(0L);
        if (!('a' <= cL && cL < '{')) {
            if (!('A' <= cL && cL < '[')) {
                return false;
            }
        }
        return true;
    }

    @NotNull
    public static final q0 q(@NotNull ua.c cVar, boolean z10) throws EOFException {
        ua.f fVar;
        ua.f fVarF0;
        t.i(cVar, "<this>");
        ua.c cVar2 = new ua.c();
        ua.f fVarR = null;
        int i10 = 0;
        while (true) {
            if (!cVar.W(0L, f35255a)) {
                fVar = f35256b;
                if (!cVar.W(0L, fVar)) {
                    break;
                }
            }
            byte b10 = cVar.readByte();
            if (fVarR == null) {
                fVarR = r(b10);
            }
            i10++;
        }
        boolean z11 = i10 >= 2 && t.d(fVarR, fVar);
        if (z11) {
            t.f(fVarR);
            cVar2.I(fVarR);
            cVar2.I(fVarR);
        } else if (i10 > 0) {
            t.f(fVarR);
            cVar2.I(fVarR);
        } else {
            long jR = cVar.R(f35257c);
            if (fVarR == null) {
                fVarR = jR == -1 ? s(q0.f34807c) : r(cVar.L(jR));
            }
            if (p(cVar, fVarR)) {
                if (jR == 2) {
                    cVar2.G(cVar, 3L);
                } else {
                    cVar2.G(cVar, 2L);
                }
            }
        }
        boolean z12 = cVar2.size() > 0;
        ArrayList arrayList = new ArrayList();
        while (!cVar.m0()) {
            long jR2 = cVar.R(f35257c);
            if (jR2 == -1) {
                fVarF0 = cVar.w0();
            } else {
                fVarF0 = cVar.f0(jR2);
                cVar.readByte();
            }
            ua.f fVar2 = f35259e;
            if (t.d(fVarF0, fVar2)) {
                if (!z12 || !arrayList.isEmpty()) {
                    if (!z10 || (!z12 && (arrayList.isEmpty() || t.d(d0.t0(arrayList), fVar2)))) {
                        arrayList.add(fVarF0);
                    } else if (!z11 || arrayList.size() != 1) {
                        a0.P(arrayList);
                    }
                }
            } else if (!t.d(fVarF0, f35258d) && !t.d(fVarF0, ua.f.f34756e)) {
                arrayList.add(fVarF0);
            }
        }
        int size = arrayList.size();
        for (int i11 = 0; i11 < size; i11++) {
            if (i11 > 0) {
                cVar2.I(fVarR);
            }
            cVar2.I((ua.f) arrayList.get(i11));
        }
        if (cVar2.size() == 0) {
            cVar2.I(f35258d);
        }
        return new q0(cVar2.w0());
    }

    private static final ua.f r(byte b10) {
        if (b10 == 47) {
            return f35255a;
        }
        if (b10 == 92) {
            return f35256b;
        }
        throw new IllegalArgumentException("not a directory separator: " + ((int) b10));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ua.f s(String str) {
        if (t.d(str, UnityAdsConstants.DefaultUrls.AD_ASSET_PATH)) {
            return f35255a;
        }
        if (t.d(str, "\\")) {
            return f35256b;
        }
        throw new IllegalArgumentException("not a directory separator: " + str);
    }
}
