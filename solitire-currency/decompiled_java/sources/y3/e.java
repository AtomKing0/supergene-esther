package y3;

import a4.o0;
import a4.x;
import android.content.res.Resources;
import android.text.TextUtils;
import androidx.media3.common.C;
import java.util.Locale;
import k2.o1;

/* JADX INFO: compiled from: DefaultTrackNameProvider.java */
/* JADX INFO: loaded from: classes2.dex */
public class e implements u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Resources f36513a;

    public e(Resources resources) {
        this.f36513a = (Resources) a4.a.e(resources);
    }

    private String b(o1 o1Var) {
        int i10 = o1Var.f29360y;
        return (i10 == -1 || i10 < 1) ? "" : i10 != 1 ? i10 != 2 ? (i10 == 6 || i10 == 7) ? this.f36513a.getString(o.B) : i10 != 8 ? this.f36513a.getString(o.A) : this.f36513a.getString(o.C) : this.f36513a.getString(o.f36595z) : this.f36513a.getString(o.f36586q);
    }

    private String c(o1 o1Var) {
        int i10 = o1Var.f29343h;
        return i10 == -1 ? "" : this.f36513a.getString(o.f36585p, Float.valueOf(i10 / 1000000.0f));
    }

    private String d(o1 o1Var) {
        return TextUtils.isEmpty(o1Var.f29337b) ? "" : o1Var.f29337b;
    }

    private String e(o1 o1Var) {
        String strJ = j(f(o1Var), h(o1Var));
        return TextUtils.isEmpty(strJ) ? d(o1Var) : strJ;
    }

    private String f(o1 o1Var) {
        String str = o1Var.f29338c;
        if (TextUtils.isEmpty(str) || C.LANGUAGE_UNDETERMINED.equals(str)) {
            return "";
        }
        Locale localeForLanguageTag = o0.f214a >= 21 ? Locale.forLanguageTag(str) : new Locale(str);
        Locale localeL = o0.L();
        String displayName = localeForLanguageTag.getDisplayName(localeL);
        if (TextUtils.isEmpty(displayName)) {
            return "";
        }
        try {
            int iOffsetByCodePoints = displayName.offsetByCodePoints(0, 1);
            return displayName.substring(0, iOffsetByCodePoints).toUpperCase(localeL) + displayName.substring(iOffsetByCodePoints);
        } catch (IndexOutOfBoundsException unused) {
            return displayName;
        }
    }

    private String g(o1 o1Var) {
        int i10 = o1Var.f29352q;
        int i11 = o1Var.f29353r;
        return (i10 == -1 || i11 == -1) ? "" : this.f36513a.getString(o.f36587r, Integer.valueOf(i10), Integer.valueOf(i11));
    }

    private String h(o1 o1Var) {
        String string = (o1Var.f29340e & 2) != 0 ? this.f36513a.getString(o.f36588s) : "";
        if ((o1Var.f29340e & 4) != 0) {
            string = j(string, this.f36513a.getString(o.f36591v));
        }
        if ((o1Var.f29340e & 8) != 0) {
            string = j(string, this.f36513a.getString(o.f36590u));
        }
        return (o1Var.f29340e & 1088) != 0 ? j(string, this.f36513a.getString(o.f36589t)) : string;
    }

    private static int i(o1 o1Var) {
        int i10 = x.i(o1Var.f29347l);
        if (i10 != -1) {
            return i10;
        }
        if (x.k(o1Var.f29344i) != null) {
            return 2;
        }
        if (x.b(o1Var.f29344i) != null) {
            return 1;
        }
        if (o1Var.f29352q == -1 && o1Var.f29353r == -1) {
            return (o1Var.f29360y == -1 && o1Var.f29361z == -1) ? -1 : 1;
        }
        return 2;
    }

    private String j(String... strArr) {
        String string = "";
        for (String str : strArr) {
            if (str.length() > 0) {
                string = TextUtils.isEmpty(string) ? str : this.f36513a.getString(o.f36584o, string, str);
            }
        }
        return string;
    }

    @Override // y3.u
    public String a(o1 o1Var) {
        int i10 = i(o1Var);
        String strJ = i10 == 2 ? j(h(o1Var), g(o1Var), c(o1Var)) : i10 == 1 ? j(e(o1Var), b(o1Var), c(o1Var)) : e(o1Var);
        return strJ.length() == 0 ? this.f36513a.getString(o.D) : strJ;
    }
}
