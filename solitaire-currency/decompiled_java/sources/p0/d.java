package p0;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: Util.java */
/* JADX INFO: loaded from: classes2.dex */
final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final Charset f32413a = Charset.forName("US-ASCII");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final Charset f32414b = Charset.forName("UTF-8");

    static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e10) {
                throw e10;
            } catch (Exception unused) {
            }
        }
    }

    static void b(File file) throws IOException {
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null) {
            throw new IOException("not a readable directory: " + file);
        }
        for (File file2 : fileArrListFiles) {
            if (file2.isDirectory()) {
                b(file2);
            }
            if (!file2.delete()) {
                throw new IOException("failed to delete file: " + file2);
            }
        }
    }
}
