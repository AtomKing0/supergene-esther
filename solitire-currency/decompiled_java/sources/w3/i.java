package w3;

import a4.c0;
import a4.o0;
import java.util.regex.Pattern;
import k2.j2;

/* JADX INFO: compiled from: WebvttParserUtil.java */
/* JADX INFO: loaded from: classes2.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Pattern f35419a = Pattern.compile("^NOTE([ \t].*)?$");

    public static boolean a(c0 c0Var) {
        String strP = c0Var.p();
        return strP != null && strP.startsWith("WEBVTT");
    }

    public static float b(String str) throws NumberFormatException {
        if (str.endsWith("%")) {
            return Float.parseFloat(str.substring(0, str.length() - 1)) / 100.0f;
        }
        throw new NumberFormatException("Percentages must end with %");
    }

    public static long c(String str) throws NumberFormatException {
        String[] strArrI0 = o0.I0(str, "\\.");
        long j10 = 0;
        for (String str2 : o0.H0(strArrI0[0], ":")) {
            j10 = (j10 * 60) + Long.parseLong(str2);
        }
        long j11 = j10 * 1000;
        if (strArrI0.length == 2) {
            j11 += Long.parseLong(strArrI0[1]);
        }
        return j11 * 1000;
    }

    public static void d(c0 c0Var) throws j2 {
        int iE = c0Var.e();
        if (a(c0Var)) {
            return;
        }
        c0Var.P(iE);
        throw j2.a("Expected WEBVTT. Got " + c0Var.p(), null);
    }
}
