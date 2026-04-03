package n;

import java.io.EOFException;
import java.io.IOException;
import org.jetbrains.annotations.NotNull;
import ua.l;
import ua.x0;
import v8.k0;

/* JADX INFO: compiled from: FaultHidingSink.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class c extends l {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final h9.l<IOException, k0> f31548b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f31549c;

    /* JADX WARN: Multi-variable type inference failed */
    public c(@NotNull x0 x0Var, @NotNull h9.l<? super IOException, k0> lVar) {
        super(x0Var);
        this.f31548b = lVar;
    }

    @Override // ua.l, ua.x0
    public void G(@NotNull ua.c cVar, long j10) throws EOFException {
        if (this.f31549c) {
            cVar.skip(j10);
            return;
        }
        try {
            super.G(cVar, j10);
        } catch (IOException e10) {
            this.f31549c = true;
            this.f31548b.invoke(e10);
        }
    }

    @Override // ua.l, ua.x0, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            super.close();
        } catch (IOException e10) {
            this.f31549c = true;
            this.f31548b.invoke(e10);
        }
    }

    @Override // ua.l, ua.x0, java.io.Flushable
    public void flush() {
        try {
            super.flush();
        } catch (IOException e10) {
            this.f31549c = true;
            this.f31548b.invoke(e10);
        }
    }
}
