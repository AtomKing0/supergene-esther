package e8;

import com.ironsource.nb;
import java.util.Set;
import kotlin.collections.z0;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: HeaderValueWithParameters.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private static final Set<Character> f25256a = z0.h('(', ')', '<', '>', '@', ',', ';', ':', '\\', '\"', '/', '[', ']', '?', Character.valueOf(nb.T), '{', '}', ' ', '\t', '\n', '\r');

    private static final boolean b(String str) {
        if (str.length() < 2 || p9.t.e1(str) != '\"' || p9.t.f1(str) != '\"') {
            return false;
        }
        int i10 = 1;
        do {
            int iD0 = p9.r.d0(str, '\"', i10, false, 4, null);
            if (iD0 == p9.r.Y(str)) {
                break;
            }
            int i11 = 0;
            for (int i12 = iD0 - 1; str.charAt(i12) == '\\'; i12--) {
                i11++;
            }
            if (i11 % 2 == 0) {
                return false;
            }
            i10 = iD0 + 1;
        } while (i10 < str.length());
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean c(String str) {
        if (str.length() == 0) {
            return true;
        }
        if (b(str)) {
            return false;
        }
        int length = str.length();
        for (int i10 = 0; i10 < length; i10++) {
            if (f25256a.contains(Character.valueOf(str.charAt(i10)))) {
                return true;
            }
        }
        return false;
    }

    @NotNull
    public static final String d(@NotNull String str) {
        kotlin.jvm.internal.t.i(str, "<this>");
        StringBuilder sb = new StringBuilder();
        e(str, sb);
        String string = sb.toString();
        kotlin.jvm.internal.t.h(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    private static final void e(String str, StringBuilder sb) {
        sb.append("\"");
        int length = str.length();
        for (int i10 = 0; i10 < length; i10++) {
            char cCharAt = str.charAt(i10);
            if (cCharAt == '\\') {
                sb.append("\\\\");
            } else if (cCharAt == '\n') {
                sb.append("\\n");
            } else if (cCharAt == '\r') {
                sb.append("\\r");
            } else if (cCharAt == '\t') {
                sb.append("\\t");
            } else if (cCharAt == '\"') {
                sb.append("\\\"");
            } else {
                sb.append(cCharAt);
            }
        }
        sb.append("\"");
    }
}
