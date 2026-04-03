package p8;

import java.nio.ByteBuffer;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: BufferAppend.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b {
    public static final int a(@NotNull a aVar, @NotNull a other, int i10) {
        t.i(aVar, "<this>");
        t.i(other, "other");
        int iMin = Math.min(other.j() - other.h(), i10);
        if (aVar.f() - aVar.j() <= iMin) {
            b(aVar, iMin);
        }
        ByteBuffer byteBufferG = aVar.g();
        int iJ = aVar.j();
        aVar.f();
        ByteBuffer byteBufferG2 = other.g();
        int iH = other.h();
        other.j();
        n8.c.c(byteBufferG2, byteBufferG, iH, iMin, iJ);
        other.c(iMin);
        aVar.a(iMin);
        return iMin;
    }

    private static final void b(a aVar, int i10) {
        if ((aVar.f() - aVar.j()) + (aVar.e() - aVar.f()) < i10) {
            throw new IllegalArgumentException("Can't append buffer: not enough free space at the end");
        }
        if ((aVar.j() + i10) - aVar.f() > 0) {
            aVar.l();
        }
    }

    public static final int c(@NotNull a aVar, @NotNull a other) {
        t.i(aVar, "<this>");
        t.i(other, "other");
        int iJ = other.j() - other.h();
        int iH = aVar.h();
        if (iH < iJ) {
            throw new IllegalArgumentException("Not enough space in the beginning to prepend bytes");
        }
        int i10 = iH - iJ;
        n8.c.c(other.g(), aVar.g(), other.h(), iJ, i10);
        other.c(iJ);
        aVar.n(i10);
        return iJ;
    }
}
