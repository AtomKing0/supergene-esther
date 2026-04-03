package f9;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import p9.r;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: Utils.kt */
/* JADX INFO: loaded from: classes5.dex */
public class m extends l {
    @NotNull
    public static final File n(@NotNull File file, @NotNull File target, boolean z10, int i10) throws f {
        t.i(file, "<this>");
        t.i(target, "target");
        if (!file.exists()) {
            throw new o(file, null, "The source file doesn't exist.", 2, null);
        }
        if (target.exists()) {
            if (!z10) {
                throw new e(file, target, "The destination file already exists.");
            }
            if (!target.delete()) {
                throw new e(file, target, "Tried to overwrite the destination, but failed to delete it.");
            }
        }
        if (!file.isDirectory()) {
            File parentFile = target.getParentFile();
            if (parentFile != null) {
                parentFile.mkdirs();
            }
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(target);
                try {
                    b.a(fileInputStream, fileOutputStream, i10);
                    c.a(fileOutputStream, null);
                    c.a(fileInputStream, null);
                } finally {
                }
            } finally {
            }
        } else if (!target.mkdirs()) {
            throw new f(file, target, "Failed to create target directory.");
        }
        return target;
    }

    public static /* synthetic */ File o(File file, File file2, boolean z10, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z10 = false;
        }
        if ((i11 & 4) != 0) {
            i10 = 8192;
        }
        return n(file, file2, z10, i10);
    }

    public static boolean p(@NotNull File file) {
        t.i(file, "<this>");
        while (true) {
            boolean z10 = true;
            for (File file2 : l.m(file)) {
                if (!file2.delete() && file2.exists()) {
                    z10 = false;
                } else {
                    if (z10) {
                        break;
                    }
                    z10 = false;
                }
            }
            return z10;
        }
    }

    @NotNull
    public static String q(@NotNull File file) {
        t.i(file, "<this>");
        String name = file.getName();
        t.h(name, "name");
        return r.O0(name, '.', "");
    }

    @NotNull
    public static final File r(@NotNull File file, @NotNull File relative) {
        t.i(file, "<this>");
        t.i(relative, "relative");
        if (j.b(relative)) {
            return relative;
        }
        String string = file.toString();
        t.h(string, "this.toString()");
        if ((string.length() == 0) || r.U(string, File.separatorChar, false, 2, null)) {
            return new File(string + relative);
        }
        return new File(string + File.separatorChar + relative);
    }

    @NotNull
    public static File s(@NotNull File file, @NotNull String relative) {
        t.i(file, "<this>");
        t.i(relative, "relative");
        return r(file, new File(relative));
    }
}
