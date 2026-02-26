package p8;

import java.io.EOFException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: BufferPrimitives.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class f {
    public static final int a(@NotNull a aVar, @NotNull a dst, int i10) throws EOFException {
        t.i(aVar, "<this>");
        t.i(dst, "dst");
        if (!(i10 >= 0)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        if (!(i10 <= dst.f() - dst.j())) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        ByteBuffer byteBufferG = aVar.g();
        int iH = aVar.h();
        if (aVar.j() - iH >= i10) {
            n8.c.c(byteBufferG, dst.g(), iH, i10, dst.j());
            dst.a(i10);
            k0 k0Var = k0.f35197a;
            aVar.c(i10);
            return i10;
        }
        throw new EOFException("Not enough bytes to read a buffer content of size " + i10 + '.');
    }

    public static final void b(@NotNull a aVar, @NotNull byte[] destination, int i10, int i11) throws EOFException {
        t.i(aVar, "<this>");
        t.i(destination, "destination");
        ByteBuffer byteBufferG = aVar.g();
        int iH = aVar.h();
        if (aVar.j() - iH >= i11) {
            n8.d.b(byteBufferG, destination, iH, i11, i10);
            k0 k0Var = k0.f35197a;
            aVar.c(i11);
        } else {
            throw new EOFException("Not enough bytes to read a byte array of size " + i11 + '.');
        }
    }

    public static final void c(@NotNull a aVar, @NotNull a src, int i10) throws o {
        t.i(aVar, "<this>");
        t.i(src, "src");
        if (!(i10 >= 0)) {
            throw new IllegalArgumentException(("length shouldn't be negative: " + i10).toString());
        }
        if (!(i10 <= src.j() - src.h())) {
            throw new IllegalArgumentException(("length shouldn't be greater than the source read remaining: " + i10 + " > " + (src.j() - src.h())).toString());
        }
        if (!(i10 <= aVar.f() - aVar.j())) {
            throw new IllegalArgumentException(("length shouldn't be greater than the destination write remaining space: " + i10 + " > " + (aVar.f() - aVar.j())).toString());
        }
        ByteBuffer byteBufferG = aVar.g();
        int iJ = aVar.j();
        int iF = aVar.f() - iJ;
        if (iF < i10) {
            throw new o("buffer readable content", i10, iF);
        }
        n8.c.c(src.g(), byteBufferG, src.h(), i10, iJ);
        src.c(i10);
        aVar.a(i10);
    }

    public static final void d(@NotNull a aVar, @NotNull byte[] source, int i10, int i11) throws o {
        t.i(aVar, "<this>");
        t.i(source, "source");
        ByteBuffer byteBufferG = aVar.g();
        int iJ = aVar.j();
        int iF = aVar.f() - iJ;
        if (iF < i11) {
            throw new o("byte array", i11, iF);
        }
        ByteBuffer byteBufferOrder = ByteBuffer.wrap(source, i10, i11).slice().order(ByteOrder.BIG_ENDIAN);
        t.h(byteBufferOrder, "wrap(this, offset, lengt…der(ByteOrder.BIG_ENDIAN)");
        n8.c.c(n8.c.b(byteBufferOrder), byteBufferG, 0, i11, iJ);
        aVar.a(i11);
    }
}
