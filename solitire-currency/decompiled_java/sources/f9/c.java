package f9;

import java.io.Closeable;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Closeable.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class c {
    public static final void a(@Nullable Closeable closeable, @Nullable Throwable th) {
        if (closeable != null) {
            if (th == null) {
                closeable.close();
                return;
            }
            try {
                closeable.close();
            } catch (Throwable th2) {
                v8.f.a(th, th2);
            }
        }
    }
}
