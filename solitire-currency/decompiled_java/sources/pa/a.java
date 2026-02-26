package pa;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import ua.k0;
import ua.l0;
import ua.x0;
import ua.z0;

/* JADX INFO: compiled from: FileSystem.kt */
/* JADX INFO: loaded from: classes5.dex */
public interface a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final C0653a f32981a = C0653a.f32983a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public static final a f32982b = new C0653a.C0654a();

    /* JADX INFO: renamed from: pa.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: FileSystem.kt */
    public static final class C0653a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ C0653a f32983a = new C0653a();

        /* JADX INFO: renamed from: pa.a$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: FileSystem.kt */
        private static final class C0654a implements a {
            @Override // pa.a
            public void a(@NotNull File directory) throws IOException {
                t.i(directory, "directory");
                File[] fileArrListFiles = directory.listFiles();
                if (fileArrListFiles == null) {
                    throw new IOException(t.r("not a readable directory: ", directory));
                }
                int length = fileArrListFiles.length;
                int i10 = 0;
                while (i10 < length) {
                    File file = fileArrListFiles[i10];
                    i10++;
                    if (file.isDirectory()) {
                        t.h(file, "file");
                        a(file);
                    }
                    if (!file.delete()) {
                        throw new IOException(t.r("failed to delete ", file));
                    }
                }
            }

            @Override // pa.a
            public boolean b(@NotNull File file) {
                t.i(file, "file");
                return file.exists();
            }

            @Override // pa.a
            @NotNull
            public x0 c(@NotNull File file) throws FileNotFoundException {
                t.i(file, "file");
                try {
                    return k0.a(file);
                } catch (FileNotFoundException unused) {
                    file.getParentFile().mkdirs();
                    return k0.a(file);
                }
            }

            @Override // pa.a
            public long d(@NotNull File file) {
                t.i(file, "file");
                return file.length();
            }

            @Override // pa.a
            @NotNull
            public z0 e(@NotNull File file) throws FileNotFoundException {
                t.i(file, "file");
                return k0.k(file);
            }

            @Override // pa.a
            @NotNull
            public x0 f(@NotNull File file) throws FileNotFoundException {
                t.i(file, "file");
                try {
                    return l0.h(file, false, 1, null);
                } catch (FileNotFoundException unused) {
                    file.getParentFile().mkdirs();
                    return l0.h(file, false, 1, null);
                }
            }

            @Override // pa.a
            public void g(@NotNull File from, @NotNull File to) throws IOException {
                t.i(from, "from");
                t.i(to, "to");
                h(to);
                if (from.renameTo(to)) {
                    return;
                }
                throw new IOException("failed to rename " + from + " to " + to);
            }

            @Override // pa.a
            public void h(@NotNull File file) throws IOException {
                t.i(file, "file");
                if (!file.delete() && file.exists()) {
                    throw new IOException(t.r("failed to delete ", file));
                }
            }

            @NotNull
            public String toString() {
                return "FileSystem.SYSTEM";
            }
        }

        private C0653a() {
        }
    }

    void a(@NotNull File file) throws IOException;

    boolean b(@NotNull File file);

    @NotNull
    x0 c(@NotNull File file) throws FileNotFoundException;

    long d(@NotNull File file);

    @NotNull
    z0 e(@NotNull File file) throws FileNotFoundException;

    @NotNull
    x0 f(@NotNull File file) throws FileNotFoundException;

    void g(@NotNull File file, @NotNull File file2) throws IOException;

    void h(@NotNull File file) throws IOException;
}
