package l5;

import java.util.Set;

/* JADX INFO: compiled from: ComponentContainer.java */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class d {
    public static Object a(e eVar, Class cls) {
        return eVar.d(e0.b(cls));
    }

    public static Object b(e eVar, e0 e0Var) {
        w5.b bVarC = eVar.c(e0Var);
        if (bVarC == null) {
            return null;
        }
        return bVarC.get();
    }

    public static w5.b c(e eVar, Class cls) {
        return eVar.c(e0.b(cls));
    }

    public static Set d(e eVar, Class cls) {
        return eVar.b(e0.b(cls));
    }

    public static Set e(e eVar, e0 e0Var) {
        return (Set) eVar.e(e0Var).get();
    }
}
