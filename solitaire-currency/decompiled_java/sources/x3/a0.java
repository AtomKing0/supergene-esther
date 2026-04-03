package x3;

import com.google.common.collect.y;
import java.util.Arrays;
import java.util.List;
import k2.s3;
import l3.c1;
import l3.e1;
import x3.u;

/* JADX INFO: compiled from: TrackSelectionUtil.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a0 {
    public static s3 a(u.a aVar, List<? extends v>[] listArr) {
        boolean z10;
        y.a aVar2 = new y.a();
        for (int i10 = 0; i10 < aVar.d(); i10++) {
            e1 e1VarF = aVar.f(i10);
            List<? extends v> list = listArr[i10];
            for (int i11 = 0; i11 < e1VarF.f30517a; i11++) {
                c1 c1VarB = e1VarF.b(i11);
                boolean z11 = aVar.a(i10, i11, false) != 0;
                int i12 = c1VarB.f30482a;
                int[] iArr = new int[i12];
                boolean[] zArr = new boolean[i12];
                for (int i13 = 0; i13 < c1VarB.f30482a; i13++) {
                    iArr[i13] = aVar.g(i10, i11, i13);
                    int i14 = 0;
                    while (true) {
                        if (i14 >= list.size()) {
                            z10 = false;
                            break;
                        }
                        v vVar = list.get(i14);
                        if (vVar.getTrackGroup().equals(c1VarB) && vVar.indexOf(i13) != -1) {
                            z10 = true;
                            break;
                        }
                        i14++;
                    }
                    zArr[i13] = z10;
                }
                aVar2.a(new s3.a(c1VarB, z11, iArr, zArr));
            }
        }
        e1 e1VarH = aVar.h();
        for (int i15 = 0; i15 < e1VarH.f30517a; i15++) {
            c1 c1VarB2 = e1VarH.b(i15);
            int[] iArr2 = new int[c1VarB2.f30482a];
            Arrays.fill(iArr2, 0);
            aVar2.a(new s3.a(c1VarB2, false, iArr2, new boolean[c1VarB2.f30482a]));
        }
        return new s3(aVar2.k());
    }

    public static s3 b(u.a aVar, v[] vVarArr) {
        List[] listArr = new List[vVarArr.length];
        for (int i10 = 0; i10 < vVarArr.length; i10++) {
            v vVar = vVarArr[i10];
            listArr[i10] = vVar != null ? com.google.common.collect.y.r(vVar) : com.google.common.collect.y.q();
        }
        return a(aVar, listArr);
    }
}
