package z3;

import androidx.annotation.Nullable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;

/* JADX INFO: compiled from: HttpDataSource.java */
/* JADX INFO: loaded from: classes2.dex */
public class z extends l {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final o f37562b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f37563c;

    public z(o oVar, int i10, int i11) {
        super(b(i10, i11));
        this.f37562b = oVar;
        this.f37563c = i11;
    }

    private static int b(int i10, int i11) {
        if (i10 == 2000 && i11 == 1) {
            return 2001;
        }
        return i10;
    }

    public static z c(IOException iOException, o oVar, int i10) {
        String message = iOException.getMessage();
        int i11 = iOException instanceof SocketTimeoutException ? 2002 : iOException instanceof InterruptedIOException ? 1004 : (message == null || !e5.c.e(message).matches("cleartext.*not permitted.*")) ? 2001 : 2007;
        return i11 == 2007 ? new y(iOException, oVar) : new z(iOException, oVar, i11, i10);
    }

    public z(String str, o oVar, int i10, int i11) {
        super(str, b(i10, i11));
        this.f37562b = oVar;
        this.f37563c = i11;
    }

    public z(IOException iOException, o oVar, int i10, int i11) {
        super(iOException, b(i10, i11));
        this.f37562b = oVar;
        this.f37563c = i11;
    }

    public z(String str, @Nullable IOException iOException, o oVar, int i10, int i11) {
        super(str, iOException, b(i10, i11));
        this.f37562b = oVar;
        this.f37563c = i11;
    }
}
