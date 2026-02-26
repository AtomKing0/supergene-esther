package ka;

import androidx.media3.common.PlaybackException;
import java.util.Arrays;
import java.util.logging.Logger;
import kotlin.jvm.internal.s0;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: TaskLogger.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class b {
    @NotNull
    public static final String b(long j10) {
        String str;
        if (j10 <= -999500000) {
            str = ((j10 - ((long) 500000000)) / ((long) 1000000000)) + " s ";
        } else if (j10 <= -999500) {
            str = ((j10 - ((long) 500000)) / ((long) PlaybackException.CUSTOM_ERROR_CODE_BASE)) + " ms";
        } else if (j10 <= 0) {
            str = ((j10 - ((long) 500)) / ((long) 1000)) + " µs";
        } else if (j10 < 999500) {
            str = ((j10 + ((long) 500)) / ((long) 1000)) + " µs";
        } else if (j10 < 999500000) {
            str = ((j10 + ((long) 500000)) / ((long) PlaybackException.CUSTOM_ERROR_CODE_BASE)) + " ms";
        } else {
            str = ((j10 + ((long) 500000000)) / ((long) 1000000000)) + " s ";
        }
        s0 s0Var = s0.f29840a;
        String str2 = String.format("%6s", Arrays.copyOf(new Object[]{str}, 1));
        t.h(str2, "format(format, *args)");
        return str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(a aVar, d dVar, String str) {
        Logger loggerA = e.f29729h.a();
        StringBuilder sb = new StringBuilder();
        sb.append(dVar.f());
        sb.append(' ');
        s0 s0Var = s0.f29840a;
        String str2 = String.format("%-22s", Arrays.copyOf(new Object[]{str}, 1));
        t.h(str2, "format(format, *args)");
        sb.append(str2);
        sb.append(": ");
        sb.append(aVar.b());
        loggerA.fine(sb.toString());
    }
}
