package o8;

import java.io.EOFException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import java.nio.charset.MalformedInputException;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import p8.m;
import q8.g;

/* JADX INFO: compiled from: CharsetJVM.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final CharBuffer f32042a = CharBuffer.allocate(0);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private static final ByteBuffer f32043b;

    static {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(0);
        t.f(byteBufferAllocate);
        f32043b = byteBufferAllocate;
    }

    public static final int a(@NotNull CharsetDecoder charsetDecoder, @NotNull m input, @NotNull Appendable dst, int i10) {
        CoderResult cr;
        int iJ;
        q8.a aVarC;
        t.i(charsetDecoder, "<this>");
        t.i(input, "input");
        t.i(dst, "dst");
        CharBuffer charBufferAllocate = CharBuffer.allocate(8192);
        boolean z10 = true;
        q8.a aVarB = g.b(input, 1);
        int iRemaining = 0;
        if (aVarB != null) {
            int i11 = 1;
            int i12 = 1;
            int iRemaining2 = 0;
            while (true) {
                try {
                    iJ = aVarB.j() - aVarB.h();
                } catch (Throwable th) {
                    th = th;
                }
                if (iJ >= i11) {
                    int i13 = i10 - iRemaining2;
                    if (i13 != 0) {
                        try {
                            ByteBuffer byteBufferG = aVarB.g();
                            int iH = aVarB.h();
                            int iJ2 = aVarB.j() - iH;
                            ByteBuffer byteBufferD = n8.c.d(byteBufferG, iH, iJ2);
                            charBufferAllocate.clear();
                            if (i13 < 8192) {
                                charBufferAllocate.limit(i13);
                            }
                            CoderResult rc = charsetDecoder.decode(byteBufferD, charBufferAllocate, false);
                            charBufferAllocate.flip();
                            iRemaining2 += charBufferAllocate.remaining();
                            dst.append(charBufferAllocate);
                            if (rc.isMalformed() || rc.isUnmappable()) {
                                t.h(rc, "rc");
                                j(rc);
                            }
                            i12 = (rc.isUnderflow() && byteBufferD.hasRemaining()) ? i12 + 1 : 1;
                            if (!(byteBufferD.limit() == iJ2)) {
                                throw new IllegalStateException("Buffer's limit change is not allowed".toString());
                            }
                            aVarB.c(byteBufferD.position());
                            i11 = i12;
                        } finally {
                        }
                        th = th;
                        if (z10) {
                            g.a(input, aVarB);
                        }
                        throw th;
                    }
                    i11 = 0;
                    iJ = aVarB.j() - aVarB.h();
                }
                if (iJ == 0) {
                    try {
                        aVarC = g.c(input, aVarB);
                    } catch (Throwable th2) {
                        th = th2;
                        z10 = false;
                    }
                } else if (iJ < i11 || aVarB.e() - aVarB.f() < 8) {
                    g.a(input, aVarB);
                    aVarC = g.b(input, i11);
                } else {
                    aVarC = aVarB;
                }
                if (aVarC == null) {
                    break;
                }
                if (i11 <= 0) {
                    iRemaining = 1;
                    aVarB = aVarC;
                    break;
                }
                aVarB = aVarC;
            }
            if (iRemaining != 0) {
                g.a(input, aVarB);
            }
            iRemaining = iRemaining2;
        }
        do {
            charBufferAllocate.clear();
            int i14 = i10 - iRemaining;
            if (i14 == 0) {
                break;
            }
            if (i14 < 8192) {
                charBufferAllocate.limit(i14);
            }
            cr = charsetDecoder.decode(f32043b, charBufferAllocate, true);
            charBufferAllocate.flip();
            iRemaining += charBufferAllocate.remaining();
            dst.append(charBufferAllocate);
            if (cr.isUnmappable() || cr.isMalformed()) {
                t.h(cr, "cr");
                j(cr);
            }
        } while (cr.isOverflow());
        return iRemaining;
    }

    @NotNull
    public static final String b(@NotNull CharsetDecoder charsetDecoder, @NotNull m input, int i10) throws EOFException {
        t.i(charsetDecoder, "<this>");
        t.i(input, "input");
        if (i10 == 0) {
            return "";
        }
        if (input.L0() - input.N0() < i10) {
            return d(charsetDecoder, input, i10);
        }
        if (!input.M0().hasArray()) {
            return c(charsetDecoder, input, i10);
        }
        ByteBuffer byteBufferM0 = input.M0();
        byte[] bArrArray = byteBufferM0.array();
        t.h(bArrArray, "bb.array()");
        int iArrayOffset = byteBufferM0.arrayOffset() + byteBufferM0.position() + input.K0().h();
        Charset charset = charsetDecoder.charset();
        t.h(charset, "charset()");
        String str = new String(bArrArray, iArrayOffset, i10, charset);
        input.J(i10);
        return str;
    }

    private static final String c(CharsetDecoder charsetDecoder, m mVar, int i10) throws CharacterCodingException, EOFException {
        CharBuffer charBufferAllocate = CharBuffer.allocate(i10);
        ByteBuffer byteBufferD = n8.c.d(mVar.M0(), mVar.K0().h(), i10);
        CoderResult rc = charsetDecoder.decode(byteBufferD, charBufferAllocate, true);
        if (rc.isMalformed() || rc.isUnmappable()) {
            t.h(rc, "rc");
            j(rc);
        }
        charBufferAllocate.flip();
        mVar.J(byteBufferD.position());
        String string = charBufferAllocate.toString();
        t.h(string, "cb.toString()");
        return string;
    }

    private static final String d(CharsetDecoder charsetDecoder, m mVar, int i10) throws Throwable {
        int iPosition;
        int iJ;
        q8.a aVarC;
        CharBuffer charBufferAllocate = CharBuffer.allocate(i10);
        boolean z10 = true;
        q8.a aVarB = g.b(mVar, 1);
        boolean z11 = false;
        if (aVarB == null) {
            iPosition = i10;
        } else {
            iPosition = i10;
            int i11 = 1;
            int i12 = 1;
            boolean z12 = false;
            while (true) {
                try {
                    iJ = aVarB.j() - aVarB.h();
                } catch (Throwable th) {
                    th = th;
                }
                if (iJ >= i11) {
                    try {
                        if (charBufferAllocate.hasRemaining() && iPosition != 0) {
                            ByteBuffer byteBufferG = aVarB.g();
                            int iH = aVarB.h();
                            int iJ2 = aVarB.j() - iH;
                            ByteBuffer byteBufferD = n8.c.d(byteBufferG, iH, iJ2);
                            int iLimit = byteBufferD.limit();
                            int iPosition2 = byteBufferD.position();
                            boolean z13 = iLimit - iPosition2 >= iPosition;
                            if (z13) {
                                byteBufferD.limit(iPosition2 + iPosition);
                            }
                            CoderResult rc = charsetDecoder.decode(byteBufferD, charBufferAllocate, z13);
                            if (rc.isMalformed() || rc.isUnmappable()) {
                                t.h(rc, "rc");
                                j(rc);
                            }
                            i12 = (rc.isUnderflow() && byteBufferD.hasRemaining()) ? i12 + 1 : 1;
                            byteBufferD.limit(iLimit);
                            iPosition -= byteBufferD.position() - iPosition2;
                            if (!(byteBufferD.limit() == iJ2)) {
                                throw new IllegalStateException("Buffer's limit change is not allowed".toString());
                            }
                            aVarB.c(byteBufferD.position());
                            i11 = i12;
                            z12 = z13;
                            th = th;
                            if (z10) {
                                g.a(mVar, aVarB);
                            }
                            throw th;
                        }
                        i11 = 0;
                        iJ = aVarB.j() - aVarB.h();
                    } finally {
                    }
                }
                if (iJ == 0) {
                    try {
                        aVarC = g.c(mVar, aVarB);
                    } catch (Throwable th2) {
                        th = th2;
                        z10 = false;
                    }
                } else if (iJ < i11 || aVarB.e() - aVarB.f() < 8) {
                    g.a(mVar, aVarB);
                    aVarC = g.b(mVar, i11);
                } else {
                    aVarC = aVarB;
                }
                if (aVarC == null) {
                    break;
                }
                if (i11 <= 0) {
                    z11 = true;
                    aVarB = aVarC;
                    break;
                }
                aVarB = aVarC;
            }
            if (z11) {
                g.a(mVar, aVarB);
            }
            z11 = z12;
        }
        if (charBufferAllocate.hasRemaining() && !z11) {
            CoderResult rc2 = charsetDecoder.decode(f32043b, charBufferAllocate, true);
            if (rc2.isMalformed() || rc2.isUnmappable()) {
                t.h(rc2, "rc");
                j(rc2);
            }
        }
        if (iPosition <= 0) {
            if (iPosition < 0) {
                throw new AssertionError("remainingInputBytes < 0");
            }
            charBufferAllocate.flip();
            String string = charBufferAllocate.toString();
            t.h(string, "cb.toString()");
            return string;
        }
        throw new EOFException("Not enough bytes available: had only " + (i10 - iPosition) + " instead of " + i10);
    }

    public static final boolean e(@NotNull CharsetEncoder charsetEncoder, @NotNull p8.a dst) throws CharacterCodingException {
        t.i(charsetEncoder, "<this>");
        t.i(dst, "dst");
        ByteBuffer byteBufferG = dst.g();
        int iJ = dst.j();
        int iF = dst.f() - iJ;
        ByteBuffer byteBufferD = n8.c.d(byteBufferG, iJ, iF);
        CoderResult result = charsetEncoder.encode(f32042a, byteBufferD, true);
        if (result.isMalformed() || result.isUnmappable()) {
            t.h(result, "result");
            j(result);
        }
        boolean zIsUnderflow = result.isUnderflow();
        if (!(byteBufferD.limit() == iF)) {
            throw new IllegalStateException("Buffer's limit change is not allowed".toString());
        }
        dst.a(byteBufferD.position());
        return zIsUnderflow;
    }

    public static final int f(@NotNull CharsetEncoder charsetEncoder, @NotNull CharSequence input, int i10, int i11, @NotNull p8.a dst) throws CharacterCodingException {
        t.i(charsetEncoder, "<this>");
        t.i(input, "input");
        t.i(dst, "dst");
        CharBuffer charBufferWrap = CharBuffer.wrap(input, i10, i11);
        int iRemaining = charBufferWrap.remaining();
        ByteBuffer byteBufferG = dst.g();
        int iJ = dst.j();
        int iF = dst.f() - iJ;
        ByteBuffer byteBufferD = n8.c.d(byteBufferG, iJ, iF);
        CoderResult result = charsetEncoder.encode(charBufferWrap, byteBufferD, false);
        if (result.isMalformed() || result.isUnmappable()) {
            t.h(result, "result");
            j(result);
        }
        if (!(byteBufferD.limit() == iF)) {
            throw new IllegalStateException("Buffer's limit change is not allowed".toString());
        }
        dst.a(byteBufferD.position());
        return iRemaining - charBufferWrap.remaining();
    }

    @NotNull
    public static final byte[] g(@NotNull CharsetEncoder charsetEncoder, @NotNull CharSequence input, int i10, int i11) {
        t.i(charsetEncoder, "<this>");
        t.i(input, "input");
        if (!(input instanceof String)) {
            return h(charsetEncoder, input, i10, i11);
        }
        if (i10 == 0 && i11 == input.length()) {
            byte[] bytes = ((String) input).getBytes(charsetEncoder.charset());
            t.h(bytes, "input as java.lang.String).getBytes(charset())");
            return bytes;
        }
        String strSubstring = ((String) input).substring(i10, i11);
        t.h(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        t.g(strSubstring, "null cannot be cast to non-null type java.lang.String");
        byte[] bytes2 = strSubstring.getBytes(charsetEncoder.charset());
        t.h(bytes2, "input.substring(fromInde…ring).getBytes(charset())");
        return bytes2;
    }

    private static final byte[] h(CharsetEncoder charsetEncoder, CharSequence charSequence, int i10, int i11) throws CharacterCodingException {
        ByteBuffer byteBufferEncode = charsetEncoder.encode(CharBuffer.wrap(charSequence, i10, i11));
        byte[] bArr = null;
        if (byteBufferEncode.hasArray() && byteBufferEncode.arrayOffset() == 0) {
            byte[] bArrArray = byteBufferEncode.array();
            if (bArrArray.length == byteBufferEncode.remaining()) {
                bArr = bArrArray;
            }
        }
        if (bArr != null) {
            return bArr;
        }
        byte[] bArr2 = new byte[byteBufferEncode.remaining()];
        byteBufferEncode.get(bArr2);
        return bArr2;
    }

    @NotNull
    public static final String i(@NotNull Charset charset) {
        t.i(charset, "<this>");
        String strName = charset.name();
        t.h(strName, "name()");
        return strName;
    }

    private static final void j(CoderResult coderResult) throws CharacterCodingException {
        try {
            coderResult.throwException();
        } catch (MalformedInputException e10) {
            String message = e10.getMessage();
            if (message == null) {
                message = "Failed to decode bytes";
            }
            throw new c(message);
        }
    }
}
