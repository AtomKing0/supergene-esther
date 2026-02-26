package v8;

import java.io.PrintWriter;
import java.io.StringWriter;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: Exceptions.kt */
/* JADX INFO: loaded from: classes5.dex */
public class f {
    public static void a(@NotNull Throwable th, @NotNull Throwable exception) {
        kotlin.jvm.internal.t.i(th, "<this>");
        kotlin.jvm.internal.t.i(exception, "exception");
        if (th != exception) {
            c9.b.f4637a.a(th, exception);
        }
    }

    @NotNull
    public static String b(@NotNull Throwable th) {
        kotlin.jvm.internal.t.i(th, "<this>");
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        th.printStackTrace(printWriter);
        printWriter.flush();
        String string = stringWriter.toString();
        kotlin.jvm.internal.t.h(string, "sw.toString()");
        return string;
    }
}
