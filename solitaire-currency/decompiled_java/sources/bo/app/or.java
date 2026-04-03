package bo.app;

import java.io.Closeable;
import java.io.InputStream;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes2.dex */
public final class or implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InputStream[] f3578a;

    public or(InputStream[] inputStreamArr) {
        this.f3578a = inputStreamArr;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        for (InputStream inputStream : this.f3578a) {
            Charset charset = di0.f2659a;
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (RuntimeException e10) {
                    throw e10;
                } catch (Exception unused) {
                }
            }
        }
    }
}
