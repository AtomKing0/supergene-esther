package w3;

import a4.c0;
import a4.o0;
import a4.t;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.media3.extractor.text.ttml.TtmlNode;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: WebvttCssParser.java */
/* JADX INFO: loaded from: classes2.dex */
final class c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Pattern f35369c = Pattern.compile("\\[voice=\"([^\"]*)\"\\]");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Pattern f35370d = Pattern.compile("^((?:[0-9]*\\.)?[0-9]+)(px|em|%)$");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final c0 f35371a = new c0();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final StringBuilder f35372b = new StringBuilder();

    private void a(d dVar, String str) {
        if ("".equals(str)) {
            return;
        }
        int iIndexOf = str.indexOf(91);
        if (iIndexOf != -1) {
            Matcher matcher = f35369c.matcher(str.substring(iIndexOf));
            if (matcher.matches()) {
                dVar.z((String) a4.a.e(matcher.group(1)));
            }
            str = str.substring(0, iIndexOf);
        }
        String[] strArrH0 = o0.H0(str, "\\.");
        String str2 = strArrH0[0];
        int iIndexOf2 = str2.indexOf(35);
        if (iIndexOf2 != -1) {
            dVar.y(str2.substring(0, iIndexOf2));
            dVar.x(str2.substring(iIndexOf2 + 1));
        } else {
            dVar.y(str2);
        }
        if (strArrH0.length > 1) {
            dVar.w((String[]) o0.B0(strArrH0, 1, strArrH0.length));
        }
    }

    private static boolean b(c0 c0Var) {
        int iE = c0Var.e();
        int iF = c0Var.f();
        byte[] bArrD = c0Var.d();
        if (iE + 2 > iF) {
            return false;
        }
        int i10 = iE + 1;
        if (bArrD[iE] != 47) {
            return false;
        }
        int i11 = i10 + 1;
        if (bArrD[i10] != 42) {
            return false;
        }
        while (true) {
            int i12 = i11 + 1;
            if (i12 >= iF) {
                c0Var.Q(iF - c0Var.e());
                return true;
            }
            if (((char) bArrD[i11]) == '*' && ((char) bArrD[i12]) == '/') {
                i11 = i12 + 1;
                iF = i11;
            } else {
                i11 = i12;
            }
        }
    }

    private static boolean c(c0 c0Var) {
        char cK = k(c0Var, c0Var.e());
        if (cK != '\t' && cK != '\n' && cK != '\f' && cK != '\r' && cK != ' ') {
            return false;
        }
        c0Var.Q(1);
        return true;
    }

    private static void e(String str, d dVar) {
        Matcher matcher = f35370d.matcher(e5.c.e(str));
        if (!matcher.matches()) {
            t.i("WebvttCssParser", "Invalid font-size: '" + str + "'.");
            return;
        }
        String str2 = (String) a4.a.e(matcher.group(2));
        str2.hashCode();
        switch (str2) {
            case "%":
                dVar.t(3);
                break;
            case "em":
                dVar.t(2);
                break;
            case "px":
                dVar.t(1);
                break;
            default:
                throw new IllegalStateException();
        }
        dVar.s(Float.parseFloat((String) a4.a.e(matcher.group(1))));
    }

    private static String f(c0 c0Var, StringBuilder sb) {
        boolean z10 = false;
        sb.setLength(0);
        int iE = c0Var.e();
        int iF = c0Var.f();
        while (iE < iF && !z10) {
            char c10 = (char) c0Var.d()[iE];
            if ((c10 < 'A' || c10 > 'Z') && ((c10 < 'a' || c10 > 'z') && !((c10 >= '0' && c10 <= '9') || c10 == '#' || c10 == '-' || c10 == '.' || c10 == '_'))) {
                z10 = true;
            } else {
                iE++;
                sb.append(c10);
            }
        }
        c0Var.Q(iE - c0Var.e());
        return sb.toString();
    }

    @Nullable
    static String g(c0 c0Var, StringBuilder sb) {
        n(c0Var);
        if (c0Var.a() == 0) {
            return null;
        }
        String strF = f(c0Var, sb);
        if (!"".equals(strF)) {
            return strF;
        }
        return "" + ((char) c0Var.D());
    }

    @Nullable
    private static String h(c0 c0Var, StringBuilder sb) {
        StringBuilder sb2 = new StringBuilder();
        boolean z10 = false;
        while (!z10) {
            int iE = c0Var.e();
            String strG = g(c0Var, sb);
            if (strG == null) {
                return null;
            }
            if ("}".equals(strG) || ";".equals(strG)) {
                c0Var.P(iE);
                z10 = true;
            } else {
                sb2.append(strG);
            }
        }
        return sb2.toString();
    }

    @Nullable
    private static String i(c0 c0Var, StringBuilder sb) {
        n(c0Var);
        if (c0Var.a() < 5 || !"::cue".equals(c0Var.A(5))) {
            return null;
        }
        int iE = c0Var.e();
        String strG = g(c0Var, sb);
        if (strG == null) {
            return null;
        }
        if ("{".equals(strG)) {
            c0Var.P(iE);
            return "";
        }
        String strL = "(".equals(strG) ? l(c0Var) : null;
        if (")".equals(g(c0Var, sb))) {
            return strL;
        }
        return null;
    }

    private static void j(c0 c0Var, d dVar, StringBuilder sb) {
        n(c0Var);
        String strF = f(c0Var, sb);
        if (!"".equals(strF) && ":".equals(g(c0Var, sb))) {
            n(c0Var);
            String strH = h(c0Var, sb);
            if (strH == null || "".equals(strH)) {
                return;
            }
            int iE = c0Var.e();
            String strG = g(c0Var, sb);
            if (!";".equals(strG)) {
                if (!"}".equals(strG)) {
                    return;
                } else {
                    c0Var.P(iE);
                }
            }
            if ("color".equals(strF)) {
                dVar.q(a4.f.b(strH));
                return;
            }
            if ("background-color".equals(strF)) {
                dVar.n(a4.f.b(strH));
                return;
            }
            boolean z10 = true;
            if ("ruby-position".equals(strF)) {
                if ("over".equals(strH)) {
                    dVar.v(1);
                    return;
                } else {
                    if ("under".equals(strH)) {
                        dVar.v(2);
                        return;
                    }
                    return;
                }
            }
            if ("text-combine-upright".equals(strF)) {
                if (!"all".equals(strH) && !strH.startsWith("digits")) {
                    z10 = false;
                }
                dVar.p(z10);
                return;
            }
            if ("text-decoration".equals(strF)) {
                if (TtmlNode.UNDERLINE.equals(strH)) {
                    dVar.A(true);
                    return;
                }
                return;
            }
            if ("font-family".equals(strF)) {
                dVar.r(strH);
                return;
            }
            if ("font-weight".equals(strF)) {
                if (TtmlNode.BOLD.equals(strH)) {
                    dVar.o(true);
                }
            } else if ("font-style".equals(strF)) {
                if (TtmlNode.ITALIC.equals(strH)) {
                    dVar.u(true);
                }
            } else if ("font-size".equals(strF)) {
                e(strH, dVar);
            }
        }
    }

    private static char k(c0 c0Var, int i10) {
        return (char) c0Var.d()[i10];
    }

    private static String l(c0 c0Var) {
        int iE = c0Var.e();
        int iF = c0Var.f();
        boolean z10 = false;
        while (iE < iF && !z10) {
            int i10 = iE + 1;
            z10 = ((char) c0Var.d()[iE]) == ')';
            iE = i10;
        }
        return c0Var.A((iE - 1) - c0Var.e()).trim();
    }

    static void m(c0 c0Var) {
        while (!TextUtils.isEmpty(c0Var.p())) {
        }
    }

    static void n(c0 c0Var) {
        while (true) {
            for (boolean z10 = true; c0Var.a() > 0 && z10; z10 = false) {
                if (c(c0Var) || b(c0Var)) {
                    break;
                }
            }
            return;
        }
    }

    public List<d> d(c0 c0Var) {
        this.f35372b.setLength(0);
        int iE = c0Var.e();
        m(c0Var);
        this.f35371a.N(c0Var.d(), c0Var.e());
        this.f35371a.P(iE);
        ArrayList arrayList = new ArrayList();
        while (true) {
            String strI = i(this.f35371a, this.f35372b);
            if (strI == null) {
                return arrayList;
            }
            if (!"{".equals(g(this.f35371a, this.f35372b))) {
                return arrayList;
            }
            d dVar = new d();
            a(dVar, strI);
            String str = null;
            boolean z10 = false;
            while (!z10) {
                int iE2 = this.f35371a.e();
                String strG = g(this.f35371a, this.f35372b);
                boolean z11 = strG == null || "}".equals(strG);
                if (!z11) {
                    this.f35371a.P(iE2);
                    j(this.f35371a, dVar, this.f35372b);
                }
                str = strG;
                z10 = z11;
            }
            if ("}".equals(str)) {
                arrayList.add(dVar);
            }
        }
    }
}
