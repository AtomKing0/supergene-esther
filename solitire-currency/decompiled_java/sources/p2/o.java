package p2;

import androidx.annotation.Nullable;
import java.io.EOFException;
import java.io.IOException;
import k2.j2;

/* JADX INFO: compiled from: ExtractorUtil.java */
/* JADX INFO: loaded from: classes2.dex */
public final class o {
    public static void a(boolean z10, @Nullable String str) throws j2 {
        if (!z10) {
            throw j2.a(str, null);
        }
    }

    public static boolean b(m mVar, byte[] bArr, int i10, int i11, boolean z10) throws IOException {
        try {
            return mVar.peekFully(bArr, i10, i11, z10);
        } catch (EOFException e10) {
            if (z10) {
                return false;
            }
            throw e10;
        }
    }

    public static int c(m mVar, byte[] bArr, int i10, int i11) throws IOException {
        int i12 = 0;
        while (i12 < i11) {
            int iPeek = mVar.peek(bArr, i10 + i12, i11 - i12);
            if (iPeek == -1) {
                break;
            }
            i12 += iPeek;
        }
        return i12;
    }

    public static boolean d(m mVar, byte[] bArr, int i10, int i11) throws IOException {
        try {
            mVar.readFully(bArr, i10, i11);
            return true;
        } catch (EOFException unused) {
            return false;
        }
    }

    public static boolean e(m mVar, int i10) throws IOException {
        try {
            mVar.skipFully(i10);
            return true;
        } catch (EOFException unused) {
            return false;
        }
    }
}
