package o8;

import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import p8.i;
import p8.j;
import p8.m;
import p8.p;
import q8.g;

/* JADX INFO: compiled from: Encoding.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b {
    @NotNull
    public static final String a(@NotNull CharsetDecoder charsetDecoder, @NotNull m input, int i10) {
        t.i(charsetDecoder, "<this>");
        t.i(input, "input");
        StringBuilder sb = new StringBuilder((int) Math.min(i10, g(input)));
        a.a(charsetDecoder, input, sb, i10);
        String string = sb.toString();
        t.h(string, "StringBuilder(capacity).…builderAction).toString()");
        return string;
    }

    public static /* synthetic */ String b(CharsetDecoder charsetDecoder, m mVar, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = Integer.MAX_VALUE;
        }
        return a(charsetDecoder, mVar, i10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final j c(@NotNull CharsetEncoder charsetEncoder, @NotNull CharSequence input, int i10, int i11) {
        t.i(charsetEncoder, "<this>");
        t.i(input, "input");
        i iVar = new i(null, 1, 0 == true ? 1 : 0);
        try {
            f(charsetEncoder, iVar, input, i10, i11);
            return iVar.T0();
        } catch (Throwable th) {
            iVar.release();
            throw th;
        }
    }

    public static /* synthetic */ j d(CharsetEncoder charsetEncoder, CharSequence charSequence, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = charSequence.length();
        }
        return c(charsetEncoder, charSequence, i10, i11);
    }

    private static final int e(CharsetEncoder charsetEncoder, p pVar) {
        q8.a aVarD = g.d(pVar, 1, null);
        int i10 = 1;
        int iF = 0;
        while (true) {
            try {
                int iF2 = aVarD.f() - aVarD.j();
                i10 = a.e(charsetEncoder, aVarD) ? 0 : i10 + 1;
                iF += iF2 - (aVarD.f() - aVarD.j());
                if (!(i10 > 0)) {
                    return iF;
                }
                aVarD = g.d(pVar, 1, aVarD);
            } finally {
                pVar.c();
            }
        }
    }

    public static final int f(@NotNull CharsetEncoder charsetEncoder, @NotNull p destination, @NotNull CharSequence input, int i10, int i11) {
        t.i(charsetEncoder, "<this>");
        t.i(destination, "destination");
        t.i(input, "input");
        if (i10 >= i11) {
            return 0;
        }
        q8.a aVarD = g.d(destination, 1, null);
        int iF = 0;
        while (true) {
            try {
                int iF2 = aVarD.f() - aVarD.j();
                int iF3 = a.f(charsetEncoder, input, i10, i11, aVarD);
                if (!(iF3 >= 0)) {
                    throw new IllegalStateException("Check failed.".toString());
                }
                i10 += iF3;
                iF += iF2 - (aVarD.f() - aVarD.j());
                int i12 = i10 >= i11 ? 0 : iF3 == 0 ? 8 : 1;
                if (i12 <= 0) {
                    destination.c();
                    return iF + e(charsetEncoder, destination);
                }
                aVarD = g.d(destination, i12, aVarD);
            } catch (Throwable th) {
                destination.c();
                throw th;
            }
        }
    }

    public static final long g(@NotNull m mVar) {
        t.i(mVar, "<this>");
        return mVar instanceof j ? mVar.P0() : Math.max(mVar.P0(), 16L);
    }
}
