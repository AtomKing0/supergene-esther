package d3;

import a4.b0;
import androidx.annotation.Nullable;
import c3.h;
import e5.e;
import java.nio.ByteBuffer;
import java.util.ArrayList;

/* JADX INFO: compiled from: AppInfoTableDecoder.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b extends h {
    @Nullable
    private static c3.a c(b0 b0Var) {
        b0Var.r(12);
        int iD = (b0Var.d() + b0Var.h(12)) - 4;
        b0Var.r(44);
        b0Var.s(b0Var.h(12));
        b0Var.r(16);
        ArrayList arrayList = new ArrayList();
        while (true) {
            String strL = null;
            if (b0Var.d() >= iD) {
                break;
            }
            b0Var.r(48);
            int iH = b0Var.h(8);
            b0Var.r(4);
            int iD2 = b0Var.d() + b0Var.h(12);
            String strL2 = null;
            while (b0Var.d() < iD2) {
                int iH2 = b0Var.h(8);
                int iH3 = b0Var.h(8);
                int iD3 = b0Var.d() + iH3;
                if (iH2 == 2) {
                    int iH4 = b0Var.h(16);
                    b0Var.r(8);
                    if (iH4 == 3) {
                        while (b0Var.d() < iD3) {
                            strL = b0Var.l(b0Var.h(8), e.f25138a);
                            int iH5 = b0Var.h(8);
                            for (int i10 = 0; i10 < iH5; i10++) {
                                b0Var.s(b0Var.h(8));
                            }
                        }
                    }
                } else if (iH2 == 21) {
                    strL2 = b0Var.l(iH3, e.f25138a);
                }
                b0Var.p(iD3 * 8);
            }
            b0Var.p(iD2 * 8);
            if (strL != null && strL2 != null) {
                arrayList.add(new a(iH, strL + strL2));
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new c3.a(arrayList);
    }

    @Override // c3.h
    @Nullable
    protected c3.a b(c3.e eVar, ByteBuffer byteBuffer) {
        if (byteBuffer.get() == 116) {
            return c(new b0(byteBuffer.array(), byteBuffer.limit()));
        }
        return null;
    }
}
