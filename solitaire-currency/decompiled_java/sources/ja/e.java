package ja;

import java.io.EOFException;
import java.io.IOException;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import ua.l;
import ua.x0;
import v8.k0;

/* JADX INFO: compiled from: FaultHidingSink.kt */
/* JADX INFO: loaded from: classes5.dex */
public class e extends l {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final h9.l<IOException, k0> f28883b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f28884c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public e(@NotNull x0 delegate, @NotNull h9.l<? super IOException, k0> onException) {
        super(delegate);
        t.i(delegate, "delegate");
        t.i(onException, "onException");
        this.f28883b = onException;
    }

    @Override // ua.l, ua.x0
    public void G(@NotNull ua.c source, long j10) throws EOFException {
        t.i(source, "source");
        if (this.f28884c) {
            source.skip(j10);
            return;
        }
        try {
            super.G(source, j10);
        } catch (IOException e10) {
            this.f28884c = true;
            this.f28883b.invoke(e10);
        }
    }

    @Override // ua.l, ua.x0, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.f28884c) {
            return;
        }
        try {
            super.close();
        } catch (IOException e10) {
            this.f28884c = true;
            this.f28883b.invoke(e10);
        }
    }

    @Override // ua.l, ua.x0, java.io.Flushable
    public void flush() {
        if (this.f28884c) {
            return;
        }
        try {
            super.flush();
        } catch (IOException e10) {
            this.f28884c = true;
            this.f28883b.invoke(e10);
        }
    }
}
