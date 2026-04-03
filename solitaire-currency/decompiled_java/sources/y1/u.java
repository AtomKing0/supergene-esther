package y1;

import android.content.Context;
import java.io.Closeable;
import java.io.IOException;

/* JADX INFO: compiled from: TransportRuntimeComponent.java */
/* JADX INFO: loaded from: classes2.dex */
abstract class u implements Closeable {

    /* JADX INFO: compiled from: TransportRuntimeComponent.java */
    interface a {
        a a(Context context);

        u build();
    }

    u() {
    }

    abstract g2.d a();

    abstract t c();

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        a().close();
    }
}
