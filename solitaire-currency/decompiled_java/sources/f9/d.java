package f9;

import java.io.File;
import kotlin.jvm.internal.t;

/* JADX INFO: compiled from: Exceptions.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class d {
    /* JADX INFO: Access modifiers changed from: private */
    public static final String b(File file, File file2, String str) {
        StringBuilder sb = new StringBuilder(file.toString());
        if (file2 != null) {
            sb.append(" -> " + file2);
        }
        if (str != null) {
            sb.append(": " + str);
        }
        String string = sb.toString();
        t.h(string, "sb.toString()");
        return string;
    }
}
