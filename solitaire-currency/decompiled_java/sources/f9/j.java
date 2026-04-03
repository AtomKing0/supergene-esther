package f9;

import java.io.File;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import p9.r;

/* JADX INFO: compiled from: FilePathComponents.kt */
/* JADX INFO: loaded from: classes5.dex */
class j {
    private static final int a(String str) {
        int iD0;
        int iD02 = r.d0(str, File.separatorChar, 0, false, 4, null);
        if (iD02 != 0) {
            if (iD02 > 0 && str.charAt(iD02 - 1) == ':') {
                return iD02 + 1;
            }
            if (iD02 == -1 && r.U(str, ':', false, 2, null)) {
                return str.length();
            }
            return 0;
        }
        if (str.length() > 1) {
            char cCharAt = str.charAt(1);
            char c10 = File.separatorChar;
            if (cCharAt == c10 && (iD0 = r.d0(str, c10, 2, false, 4, null)) >= 0) {
                int iD03 = r.d0(str, File.separatorChar, iD0 + 1, false, 4, null);
                return iD03 >= 0 ? iD03 + 1 : str.length();
            }
        }
        return 1;
    }

    public static final boolean b(@NotNull File file) {
        t.i(file, "<this>");
        String path = file.getPath();
        t.h(path, "path");
        return a(path) > 0;
    }
}
