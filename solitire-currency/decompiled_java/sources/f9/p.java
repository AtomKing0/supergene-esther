package f9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Iterator;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: ReadWrite.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class p {
    public static final long a(@NotNull Reader reader, @NotNull Writer out, int i10) throws IOException {
        t.i(reader, "<this>");
        t.i(out, "out");
        char[] cArr = new char[i10];
        int i11 = reader.read(cArr);
        long j10 = 0;
        while (i11 >= 0) {
            out.write(cArr, 0, i11);
            j10 += (long) i11;
            i11 = reader.read(cArr);
        }
        return j10;
    }

    public static /* synthetic */ long b(Reader reader, Writer writer, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = 8192;
        }
        return a(reader, writer, i10);
    }

    public static final void c(@NotNull Reader reader, @NotNull h9.l<? super String, k0> action) {
        t.i(reader, "<this>");
        t.i(action, "action");
        BufferedReader bufferedReader = reader instanceof BufferedReader ? (BufferedReader) reader : new BufferedReader(reader, 8192);
        try {
            Iterator<String> it = d(bufferedReader).iterator();
            while (it.hasNext()) {
                action.invoke(it.next());
            }
            k0 k0Var = k0.f35197a;
            c.a(bufferedReader, null);
        } finally {
        }
    }

    @NotNull
    public static final o9.g<String> d(@NotNull BufferedReader bufferedReader) {
        t.i(bufferedReader, "<this>");
        return o9.m.d(new n(bufferedReader));
    }

    @NotNull
    public static final String e(@NotNull Reader reader) {
        t.i(reader, "<this>");
        StringWriter stringWriter = new StringWriter();
        b(reader, stringWriter, 0, 2, null);
        String string = stringWriter.toString();
        t.h(string, "buffer.toString()");
        return string;
    }
}
