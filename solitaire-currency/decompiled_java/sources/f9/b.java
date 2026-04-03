package f9;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: IOStreams.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class b {
    public static final long a(@NotNull InputStream inputStream, @NotNull OutputStream out, int i10) throws IOException {
        t.i(inputStream, "<this>");
        t.i(out, "out");
        byte[] bArr = new byte[i10];
        int i11 = inputStream.read(bArr);
        long j10 = 0;
        while (i11 >= 0) {
            out.write(bArr, 0, i11);
            j10 += (long) i11;
            i11 = inputStream.read(bArr);
        }
        return j10;
    }

    public static /* synthetic */ long b(InputStream inputStream, OutputStream outputStream, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = 8192;
        }
        return a(inputStream, outputStream, i10);
    }
}
