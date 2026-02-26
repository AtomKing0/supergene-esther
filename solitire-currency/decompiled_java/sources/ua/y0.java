package ua;

import java.io.IOException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: JvmOkio.kt */
/* JADX INFO: loaded from: classes5.dex */
final class y0 extends a {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @NotNull
    private final Socket f34840m;

    public y0(@NotNull Socket socket) {
        kotlin.jvm.internal.t.i(socket, "socket");
        this.f34840m = socket;
    }

    @Override // ua.a
    @NotNull
    protected IOException v(@Nullable IOException iOException) {
        SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
        if (iOException != null) {
            socketTimeoutException.initCause(iOException);
        }
        return socketTimeoutException;
    }

    @Override // ua.a
    protected void z() {
        try {
            this.f34840m.close();
        } catch (AssertionError e10) {
            if (!k0.e(e10)) {
                throw e10;
            }
            l0.f34785a.log(Level.WARNING, "Failed to close timed out socket " + this.f34840m, (Throwable) e10);
        } catch (Exception e11) {
            l0.f34785a.log(Level.WARNING, "Failed to close timed out socket " + this.f34840m, (Throwable) e11);
        }
    }
}
