package p8;

import java.io.EOFException;
import java.nio.ByteBuffer;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: BufferUtilsJvm.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class g {
    public static final void a(@NotNull a aVar, @NotNull ByteBuffer dst, int i10) throws EOFException {
        t.i(aVar, "<this>");
        t.i(dst, "dst");
        ByteBuffer byteBufferG = aVar.g();
        int iH = aVar.h();
        if (aVar.j() - iH < i10) {
            throw new EOFException("Not enough bytes to read a buffer content of size " + i10 + '.');
        }
        int iLimit = dst.limit();
        try {
            dst.limit(dst.position() + i10);
            n8.d.a(byteBufferG, dst, iH);
            dst.limit(iLimit);
            k0 k0Var = k0.f35197a;
            aVar.c(i10);
        } catch (Throwable th) {
            dst.limit(iLimit);
            throw th;
        }
    }
}
