package b4;

import a4.c0;
import a4.y;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import k2.j2;

/* JADX INFO: compiled from: AvcConfig.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<byte[]> f2071a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f2072b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f2073c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f2074d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f2075e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    public final String f2076f;

    private a(List<byte[]> list, int i10, int i11, int i12, float f10, @Nullable String str) {
        this.f2071a = list;
        this.f2072b = i10;
        this.f2073c = i11;
        this.f2074d = i12;
        this.f2075e = f10;
        this.f2076f = str;
    }

    private static byte[] a(c0 c0Var) {
        int iJ = c0Var.J();
        int iE = c0Var.e();
        c0Var.Q(iJ);
        return a4.e.d(c0Var.d(), iE, iJ);
    }

    public static a b(c0 c0Var) throws j2 {
        int i10;
        int i11;
        float f10;
        String strA;
        try {
            c0Var.Q(4);
            int iD = (c0Var.D() & 3) + 1;
            if (iD == 3) {
                throw new IllegalStateException();
            }
            ArrayList arrayList = new ArrayList();
            int iD2 = c0Var.D() & 31;
            for (int i12 = 0; i12 < iD2; i12++) {
                arrayList.add(a(c0Var));
            }
            int iD3 = c0Var.D();
            for (int i13 = 0; i13 < iD3; i13++) {
                arrayList.add(a(c0Var));
            }
            if (iD2 > 0) {
                y.c cVarL = a4.y.l((byte[]) arrayList.get(0), iD, ((byte[]) arrayList.get(0)).length);
                int i14 = cVarL.f280f;
                int i15 = cVarL.f281g;
                float f11 = cVarL.f282h;
                strA = a4.e.a(cVarL.f275a, cVarL.f276b, cVarL.f277c);
                i10 = i14;
                i11 = i15;
                f10 = f11;
            } else {
                i10 = -1;
                i11 = -1;
                f10 = 1.0f;
                strA = null;
            }
            return new a(arrayList, iD, i10, i11, f10, strA);
        } catch (ArrayIndexOutOfBoundsException e10) {
            throw j2.a("Error parsing AVC config", e10);
        }
    }
}
