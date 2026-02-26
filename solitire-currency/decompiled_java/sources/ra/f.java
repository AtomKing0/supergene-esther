package ra;

import java.util.logging.Handler;
import java.util.logging.LogRecord;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: AndroidLog.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class f extends Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final f f33418a = new f();

    private f() {
    }

    @Override // java.util.logging.Handler
    public void publish(@NotNull LogRecord record) {
        t.i(record, "record");
        e eVar = e.f33415a;
        String loggerName = record.getLoggerName();
        t.h(loggerName, "record.loggerName");
        int iB = g.b(record);
        String message = record.getMessage();
        t.h(message, "record.message");
        eVar.a(loggerName, iB, message, record.getThrown());
    }

    @Override // java.util.logging.Handler
    public void close() {
    }

    @Override // java.util.logging.Handler
    public void flush() {
    }
}
