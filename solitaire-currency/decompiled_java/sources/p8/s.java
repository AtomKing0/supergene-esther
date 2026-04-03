package p8;

import java.io.EOFException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Strings.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class s {
    @NotNull
    public static final Void a(int i10) throws EOFException {
        throw new EOFException("Premature end of stream: expected " + i10 + " bytes");
    }

    @NotNull
    public static final byte[] b(@NotNull j jVar, int i10) {
        t.i(jVar, "<this>");
        if (i10 == 0) {
            return q8.g.f33176a;
        }
        byte[] bArr = new byte[i10];
        n.b(jVar, bArr, 0, i10);
        return bArr;
    }

    public static /* synthetic */ byte[] c(j jVar, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            long jP0 = jVar.P0();
            if (jP0 > 2147483647L) {
                throw new IllegalArgumentException("Unable to convert to a ByteArray: packet is too big");
            }
            i10 = (int) jP0;
        }
        return b(jVar, i10);
    }

    @NotNull
    public static final String d(@NotNull m mVar, @NotNull Charset charset, int i10) {
        t.i(mVar, "<this>");
        t.i(charset, "charset");
        CharsetDecoder charsetDecoderNewDecoder = charset.newDecoder();
        t.h(charsetDecoderNewDecoder, "charset.newDecoder()");
        return o8.b.a(charsetDecoderNewDecoder, mVar, i10);
    }

    public static /* synthetic */ String e(m mVar, Charset charset, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            charset = p9.d.f32952b;
        }
        if ((i11 & 2) != 0) {
            i10 = Integer.MAX_VALUE;
        }
        return d(mVar, charset, i10);
    }

    @NotNull
    public static final String f(@NotNull m mVar, int i10, @NotNull Charset charset) {
        t.i(mVar, "<this>");
        t.i(charset, "charset");
        CharsetDecoder charsetDecoderNewDecoder = charset.newDecoder();
        t.h(charsetDecoderNewDecoder, "charset.newDecoder()");
        return o8.a.b(charsetDecoderNewDecoder, mVar, i10);
    }

    public static /* synthetic */ String g(m mVar, int i10, Charset charset, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            charset = p9.d.f32952b;
        }
        return f(mVar, i10, charset);
    }

    public static final void h(@NotNull p pVar, @NotNull CharSequence text, int i10, int i11, @NotNull Charset charset) {
        t.i(pVar, "<this>");
        t.i(text, "text");
        t.i(charset, "charset");
        if (charset == p9.d.f32952b) {
            i(pVar, text, i10, i11);
            return;
        }
        CharsetEncoder charsetEncoderNewEncoder = charset.newEncoder();
        t.h(charsetEncoderNewEncoder, "charset.newEncoder()");
        o8.b.f(charsetEncoderNewEncoder, pVar, text, i10, i11);
    }

    private static final void i(p pVar, CharSequence charSequence, int i10, int i11) {
        q8.a aVarD = q8.g.d(pVar, 1, null);
        while (true) {
            try {
                int iB = q8.f.b(aVarD.g(), charSequence, i10, i11, aVarD.j(), aVarD.f());
                int iA = q8.c.a(iB) & 65535;
                i10 += iA;
                aVarD.a(q8.c.b(iB) & 65535);
                int i12 = (iA != 0 || i10 >= i11) ? i10 < i11 ? 1 : 0 : 8;
                if (i12 <= 0) {
                    return;
                } else {
                    aVarD = q8.g.d(pVar, i12, aVarD);
                }
            } finally {
                pVar.c();
            }
        }
    }
}
