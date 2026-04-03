package ua;

import com.unity3d.ads.core.data.datasource.AndroidDynamicDeviceInfoDataSource;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: JvmSystemFileSystem.kt */
/* JADX INFO: loaded from: classes5.dex */
public class t extends j {
    private final List<q0> r(q0 q0Var, boolean z10) throws IOException {
        File file = q0Var.toFile();
        String[] list = file.list();
        if (list != null) {
            ArrayList arrayList = new ArrayList();
            for (String it : list) {
                kotlin.jvm.internal.t.h(it, "it");
                arrayList.add(q0Var.j(it));
            }
            kotlin.collections.z.z(arrayList);
            return arrayList;
        }
        if (!z10) {
            return null;
        }
        if (file.exists()) {
            throw new IOException("failed to list " + q0Var);
        }
        throw new FileNotFoundException("no such file: " + q0Var);
    }

    private final void s(q0 q0Var) throws IOException {
        if (j(q0Var)) {
            throw new IOException(q0Var + " already exists.");
        }
    }

    private final void t(q0 q0Var) throws IOException {
        if (j(q0Var)) {
            return;
        }
        throw new IOException(q0Var + " doesn't exist.");
    }

    @Override // ua.j
    @NotNull
    public x0 b(@NotNull q0 file, boolean z10) throws IOException {
        kotlin.jvm.internal.t.i(file, "file");
        if (z10) {
            t(file);
        }
        return k0.g(file.toFile(), true);
    }

    @Override // ua.j
    public void c(@NotNull q0 source, @NotNull q0 target) throws IOException {
        kotlin.jvm.internal.t.i(source, "source");
        kotlin.jvm.internal.t.i(target, "target");
        if (source.toFile().renameTo(target.toFile())) {
            return;
        }
        throw new IOException("failed to move " + source + " to " + target);
    }

    @Override // ua.j
    public void g(@NotNull q0 dir, boolean z10) throws IOException {
        kotlin.jvm.internal.t.i(dir, "dir");
        if (dir.toFile().mkdir()) {
            return;
        }
        i iVarM = m(dir);
        boolean z11 = false;
        if (iVarM != null && iVarM.f()) {
            z11 = true;
        }
        if (!z11) {
            throw new IOException("failed to create directory: " + dir);
        }
        if (z10) {
            throw new IOException(dir + " already exist.");
        }
    }

    @Override // ua.j
    public void i(@NotNull q0 path, boolean z10) throws IOException {
        kotlin.jvm.internal.t.i(path, "path");
        File file = path.toFile();
        if (file.delete()) {
            return;
        }
        if (file.exists()) {
            throw new IOException("failed to delete " + path);
        }
        if (z10) {
            throw new FileNotFoundException("no such file: " + path);
        }
    }

    @Override // ua.j
    @NotNull
    public List<q0> k(@NotNull q0 dir) throws IOException {
        kotlin.jvm.internal.t.i(dir, "dir");
        List<q0> listR = r(dir, true);
        kotlin.jvm.internal.t.f(listR);
        return listR;
    }

    @Override // ua.j
    @Nullable
    public i m(@NotNull q0 path) {
        kotlin.jvm.internal.t.i(path, "path");
        File file = path.toFile();
        boolean zIsFile = file.isFile();
        boolean zIsDirectory = file.isDirectory();
        long jLastModified = file.lastModified();
        long length = file.length();
        if (zIsFile || zIsDirectory || jLastModified != 0 || length != 0 || file.exists()) {
            return new i(zIsFile, zIsDirectory, null, Long.valueOf(length), null, Long.valueOf(jLastModified), null, null, 128, null);
        }
        return null;
    }

    @Override // ua.j
    @NotNull
    public h n(@NotNull q0 file) {
        kotlin.jvm.internal.t.i(file, "file");
        return new s(false, new RandomAccessFile(file.toFile(), AndroidDynamicDeviceInfoDataSource.DIRECTORY_MODE_READ));
    }

    @Override // ua.j
    @NotNull
    public x0 p(@NotNull q0 file, boolean z10) throws IOException {
        kotlin.jvm.internal.t.i(file, "file");
        if (z10) {
            s(file);
        }
        return l0.h(file.toFile(), false, 1, null);
    }

    @Override // ua.j
    @NotNull
    public z0 q(@NotNull q0 file) {
        kotlin.jvm.internal.t.i(file, "file");
        return k0.k(file.toFile());
    }

    @NotNull
    public String toString() {
        return "JvmSystemFileSystem";
    }
}
