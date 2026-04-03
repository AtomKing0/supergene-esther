package e8;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: UrlDecodedParametersBuilder.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class r0 {
    private static final void b(g8.u uVar, g8.u uVar2) {
        for (String str : uVar2.names()) {
            List<String> listC = uVar2.c(str);
            if (listC == null) {
                listC = kotlin.collections.v.l();
            }
            String strK = b.k(str, 0, 0, false, null, 15, null);
            List<String> list = listC;
            ArrayList arrayList = new ArrayList(kotlin.collections.w.v(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(b.k((String) it.next(), 0, 0, true, null, 11, null));
            }
            uVar.d(strK, arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(g8.u uVar, g8.t tVar) {
        for (String str : tVar.names()) {
            List<String> listC = tVar.c(str);
            if (listC == null) {
                listC = kotlin.collections.v.l();
            }
            String strM = b.m(str, false, 1, null);
            List<String> list = listC;
            ArrayList arrayList = new ArrayList(kotlin.collections.w.v(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(b.n((String) it.next()));
            }
            uVar.d(strM, arrayList);
        }
    }

    @NotNull
    public static final z d(@NotNull g8.u parameters) {
        kotlin.jvm.internal.t.i(parameters, "parameters");
        a0 a0VarB = d0.b(0, 1, null);
        b(a0VarB, parameters);
        return a0VarB.build();
    }

    @NotNull
    public static final a0 e(@NotNull g8.t parameters) {
        kotlin.jvm.internal.t.i(parameters, "parameters");
        a0 a0VarB = d0.b(0, 1, null);
        c(a0VarB, parameters);
        return a0VarB;
    }
}
