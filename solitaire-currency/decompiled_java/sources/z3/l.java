package z3;

import androidx.annotation.Nullable;
import java.io.IOException;

/* JADX INFO: compiled from: DataSourceException.java */
/* JADX INFO: loaded from: classes2.dex */
public class l extends IOException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f37443a;

    public l(int i10) {
        this.f37443a = i10;
    }

    public static boolean a(IOException iOException) {
        for (Throwable cause = iOException; cause != null; cause = cause.getCause()) {
            if ((cause instanceof l) && ((l) cause).f37443a == 2008) {
                return true;
            }
        }
        return false;
    }

    public l(@Nullable Throwable th, int i10) {
        super(th);
        this.f37443a = i10;
    }

    public l(@Nullable String str, int i10) {
        super(str);
        this.f37443a = i10;
    }

    public l(@Nullable String str, @Nullable Throwable th, int i10) {
        super(str, th);
        this.f37443a = i10;
    }
}
