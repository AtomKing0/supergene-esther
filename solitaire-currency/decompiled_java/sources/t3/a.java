package t3;

import a4.c0;
import a4.t;
import a4.u;
import android.text.Html;
import android.text.Spanned;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import n3.h;
import n3.i;

/* JADX INFO: compiled from: SubripDecoder.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a extends h {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final Pattern f34064q = Pattern.compile("\\s*((?:(\\d+):)?(\\d+):(\\d+)(?:,(\\d+))?)\\s*-->\\s*((?:(\\d+):)?(\\d+):(\\d+)(?:,(\\d+))?)\\s*");

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final Pattern f34065r = Pattern.compile("\\{\\\\.*?\\}");

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final StringBuilder f34066o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final ArrayList<String> f34067p;

    public a() {
        super("SubripDecoder");
        this.f34066o = new StringBuilder();
        this.f34067p = new ArrayList<>();
    }

    private String A(String str, ArrayList<String> arrayList) {
        String strTrim = str.trim();
        StringBuilder sb = new StringBuilder(strTrim);
        Matcher matcher = f34065r.matcher(strTrim);
        int i10 = 0;
        while (matcher.find()) {
            String strGroup = matcher.group();
            arrayList.add(strGroup);
            int iStart = matcher.start() - i10;
            int length = strGroup.length();
            sb.replace(iStart, iStart + length, "");
            i10 += length;
        }
        return sb.toString();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:36:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00e6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private n3.b x(android.text.Spanned r17, @androidx.annotation.Nullable java.lang.String r18) {
        /*
            Method dump skipped, instruction units count: 364
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: t3.a.x(android.text.Spanned, java.lang.String):n3.b");
    }

    static float y(int i10) {
        if (i10 == 0) {
            return 0.08f;
        }
        if (i10 == 1) {
            return 0.5f;
        }
        if (i10 == 2) {
            return 0.92f;
        }
        throw new IllegalArgumentException();
    }

    private static long z(Matcher matcher, int i10) {
        String strGroup = matcher.group(i10 + 1);
        long j10 = (strGroup != null ? Long.parseLong(strGroup) * 60 * 60 * 1000 : 0L) + (Long.parseLong((String) a4.a.e(matcher.group(i10 + 2))) * 60 * 1000) + (Long.parseLong((String) a4.a.e(matcher.group(i10 + 3))) * 1000);
        String strGroup2 = matcher.group(i10 + 4);
        if (strGroup2 != null) {
            j10 += Long.parseLong(strGroup2);
        }
        return j10 * 1000;
    }

    @Override // n3.h
    protected i v(byte[] bArr, int i10, boolean z10) {
        String str;
        ArrayList arrayList = new ArrayList();
        u uVar = new u();
        c0 c0Var = new c0(bArr, i10);
        while (true) {
            String strP = c0Var.p();
            int i11 = 0;
            if (strP == null) {
                break;
            }
            if (strP.length() != 0) {
                try {
                    Integer.parseInt(strP);
                    String strP2 = c0Var.p();
                    if (strP2 == null) {
                        t.i("SubripDecoder", "Unexpected end");
                        break;
                    }
                    Matcher matcher = f34064q.matcher(strP2);
                    if (matcher.matches()) {
                        uVar.a(z(matcher, 1));
                        uVar.a(z(matcher, 6));
                        this.f34066o.setLength(0);
                        this.f34067p.clear();
                        for (String strP3 = c0Var.p(); !TextUtils.isEmpty(strP3); strP3 = c0Var.p()) {
                            if (this.f34066o.length() > 0) {
                                this.f34066o.append("<br>");
                            }
                            this.f34066o.append(A(strP3, this.f34067p));
                        }
                        Spanned spannedFromHtml = Html.fromHtml(this.f34066o.toString());
                        while (true) {
                            if (i11 >= this.f34067p.size()) {
                                str = null;
                                break;
                            }
                            str = this.f34067p.get(i11);
                            if (str.matches("\\{\\\\an[1-9]\\}")) {
                                break;
                            }
                            i11++;
                        }
                        arrayList.add(x(spannedFromHtml, str));
                        arrayList.add(n3.b.f31621r);
                    } else {
                        t.i("SubripDecoder", "Skipping invalid timing: " + strP2);
                    }
                } catch (NumberFormatException unused) {
                    t.i("SubripDecoder", "Skipping invalid index: " + strP);
                }
            }
        }
        return new b((n3.b[]) arrayList.toArray(new n3.b[0]), uVar.d());
    }
}
