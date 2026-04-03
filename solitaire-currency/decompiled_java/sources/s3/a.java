package s3;

import a4.c0;
import a4.o0;
import a4.t;
import android.graphics.PointF;
import android.text.Layout;
import android.text.SpannableString;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import androidx.annotation.Nullable;
import androidx.media3.common.C;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import n3.b;
import n3.h;
import n3.i;
import s3.c;

/* JADX INFO: compiled from: SsaDecoder.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a extends h {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private static final Pattern f33493t = Pattern.compile("(?:(\\d+):)?(\\d+):(\\d+)[:.](\\d+)");

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final boolean f33494o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @Nullable
    private final b f33495p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private Map<String, c> f33496q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private float f33497r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private float f33498s;

    public a(@Nullable List<byte[]> list) {
        super("SsaDecoder");
        this.f33497r = -3.4028235E38f;
        this.f33498s = -3.4028235E38f;
        if (list == null || list.isEmpty()) {
            this.f33494o = false;
            this.f33495p = null;
            return;
        }
        this.f33494o = true;
        String strA = o0.A(list.get(0));
        a4.a.a(strA.startsWith("Format:"));
        this.f33495p = (b) a4.a.e(b.a(strA));
        C(new c0(list.get(1)));
    }

    private void A(String str, b bVar, List<List<n3.b>> list, List<Long> list2) {
        int i10;
        a4.a.a(str.startsWith("Dialogue:"));
        String[] strArrSplit = str.substring(9).split(",", bVar.f33503e);
        if (strArrSplit.length != bVar.f33503e) {
            t.i("SsaDecoder", "Skipping dialogue line with fewer columns than format: " + str);
            return;
        }
        long jF = F(strArrSplit[bVar.f33499a]);
        if (jF == C.TIME_UNSET) {
            t.i("SsaDecoder", "Skipping invalid timing: " + str);
            return;
        }
        long jF2 = F(strArrSplit[bVar.f33500b]);
        if (jF2 == C.TIME_UNSET) {
            t.i("SsaDecoder", "Skipping invalid timing: " + str);
            return;
        }
        Map<String, c> map = this.f33496q;
        c cVar = (map == null || (i10 = bVar.f33501c) == -1) ? null : map.get(strArrSplit[i10].trim());
        String str2 = strArrSplit[bVar.f33502d];
        n3.b bVarZ = z(c.b.d(str2).replace("\\N", "\n").replace("\\n", "\n").replace("\\h", " "), cVar, c.b.b(str2), this.f33497r, this.f33498s);
        int iX = x(jF2, list2, list);
        for (int iX2 = x(jF, list2, list); iX2 < iX; iX2++) {
            list.get(iX2).add(bVarZ);
        }
    }

    private void B(c0 c0Var, List<List<n3.b>> list, List<Long> list2) {
        b bVarA = this.f33494o ? this.f33495p : null;
        while (true) {
            String strP = c0Var.p();
            if (strP == null) {
                return;
            }
            if (strP.startsWith("Format:")) {
                bVarA = b.a(strP);
            } else if (strP.startsWith("Dialogue:")) {
                if (bVarA == null) {
                    t.i("SsaDecoder", "Skipping dialogue line before complete format: " + strP);
                } else {
                    A(strP, bVarA, list, list2);
                }
            }
        }
    }

    private void C(c0 c0Var) {
        while (true) {
            String strP = c0Var.p();
            if (strP == null) {
                return;
            }
            if ("[Script Info]".equalsIgnoreCase(strP)) {
                D(c0Var);
            } else if ("[V4+ Styles]".equalsIgnoreCase(strP)) {
                this.f33496q = E(c0Var);
            } else if ("[V4 Styles]".equalsIgnoreCase(strP)) {
                t.f("SsaDecoder", "[V4 Styles] are not supported");
            } else if ("[Events]".equalsIgnoreCase(strP)) {
                return;
            }
        }
    }

    private void D(c0 c0Var) {
        while (true) {
            String strP = c0Var.p();
            if (strP == null) {
                return;
            }
            if (c0Var.a() != 0 && c0Var.h() == 91) {
                return;
            }
            String[] strArrSplit = strP.split(":");
            if (strArrSplit.length == 2) {
                String strE = e5.c.e(strArrSplit[0].trim());
                strE.hashCode();
                if (strE.equals("playresx")) {
                    this.f33497r = Float.parseFloat(strArrSplit[1].trim());
                } else if (strE.equals("playresy")) {
                    try {
                        this.f33498s = Float.parseFloat(strArrSplit[1].trim());
                    } catch (NumberFormatException unused) {
                    }
                }
            }
        }
    }

    private static Map<String, c> E(c0 c0Var) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        c.a aVarA = null;
        while (true) {
            String strP = c0Var.p();
            if (strP == null || (c0Var.a() != 0 && c0Var.h() == 91)) {
                break;
            }
            if (strP.startsWith("Format:")) {
                aVarA = c.a.a(strP);
            } else if (strP.startsWith("Style:")) {
                if (aVarA == null) {
                    t.i("SsaDecoder", "Skipping 'Style:' line before 'Format:' line: " + strP);
                } else {
                    c cVarB = c.b(strP, aVarA);
                    if (cVarB != null) {
                        linkedHashMap.put(cVarB.f33504a, cVarB);
                    }
                }
            }
        }
        return linkedHashMap;
    }

    private static long F(String str) {
        Matcher matcher = f33493t.matcher(str.trim());
        return !matcher.matches() ? C.TIME_UNSET : (Long.parseLong((String) o0.j(matcher.group(1))) * 60 * 60 * 1000000) + (Long.parseLong((String) o0.j(matcher.group(2))) * 60 * 1000000) + (Long.parseLong((String) o0.j(matcher.group(3))) * 1000000) + (Long.parseLong((String) o0.j(matcher.group(4))) * 10000);
    }

    private static int G(int i10) {
        switch (i10) {
            case -1:
                break;
            case 0:
            default:
                t.i("SsaDecoder", "Unknown alignment: " + i10);
                break;
            case 1:
            case 2:
            case 3:
                break;
            case 4:
            case 5:
            case 6:
                break;
            case 7:
            case 8:
            case 9:
                break;
        }
        return Integer.MIN_VALUE;
    }

    private static int H(int i10) {
        switch (i10) {
            case -1:
                break;
            case 0:
            default:
                t.i("SsaDecoder", "Unknown alignment: " + i10);
                break;
            case 1:
            case 4:
            case 7:
                break;
            case 2:
            case 5:
            case 8:
                break;
            case 3:
            case 6:
            case 9:
                break;
        }
        return Integer.MIN_VALUE;
    }

    @Nullable
    private static Layout.Alignment I(int i10) {
        switch (i10) {
            case -1:
                return null;
            case 0:
            default:
                t.i("SsaDecoder", "Unknown alignment: " + i10);
                return null;
            case 1:
            case 4:
            case 7:
                return Layout.Alignment.ALIGN_NORMAL;
            case 2:
            case 5:
            case 8:
                return Layout.Alignment.ALIGN_CENTER;
            case 3:
            case 6:
            case 9:
                return Layout.Alignment.ALIGN_OPPOSITE;
        }
    }

    private static int x(long j10, List<Long> list, List<List<n3.b>> list2) {
        int i10;
        int size = list.size() - 1;
        while (true) {
            if (size < 0) {
                i10 = 0;
                break;
            }
            if (list.get(size).longValue() == j10) {
                return size;
            }
            if (list.get(size).longValue() < j10) {
                i10 = size + 1;
                break;
            }
            size--;
        }
        list.add(i10, Long.valueOf(j10));
        list2.add(i10, i10 == 0 ? new ArrayList() : new ArrayList(list2.get(i10 - 1)));
        return i10;
    }

    private static float y(int i10) {
        if (i10 == 0) {
            return 0.05f;
        }
        if (i10 != 1) {
            return i10 != 2 ? -3.4028235E38f : 0.95f;
        }
        return 0.5f;
    }

    private static n3.b z(String str, @Nullable c cVar, c.b bVar, float f10, float f11) {
        SpannableString spannableString = new SpannableString(str);
        b.C0631b c0631bO = new b.C0631b().o(spannableString);
        if (cVar != null) {
            if (cVar.f33506c != null) {
                spannableString.setSpan(new ForegroundColorSpan(cVar.f33506c.intValue()), 0, spannableString.length(), 33);
            }
            if (cVar.f33513j == 3 && cVar.f33507d != null) {
                spannableString.setSpan(new BackgroundColorSpan(cVar.f33507d.intValue()), 0, spannableString.length(), 33);
            }
            float f12 = cVar.f33508e;
            if (f12 != -3.4028235E38f && f11 != -3.4028235E38f) {
                c0631bO.q(f12 / f11, 1);
            }
            boolean z10 = cVar.f33509f;
            if (z10 && cVar.f33510g) {
                spannableString.setSpan(new StyleSpan(3), 0, spannableString.length(), 33);
            } else if (z10) {
                spannableString.setSpan(new StyleSpan(1), 0, spannableString.length(), 33);
            } else if (cVar.f33510g) {
                spannableString.setSpan(new StyleSpan(2), 0, spannableString.length(), 33);
            }
            if (cVar.f33511h) {
                spannableString.setSpan(new UnderlineSpan(), 0, spannableString.length(), 33);
            }
            if (cVar.f33512i) {
                spannableString.setSpan(new StrikethroughSpan(), 0, spannableString.length(), 33);
            }
        }
        int i10 = bVar.f33529a;
        if (i10 == -1) {
            i10 = cVar != null ? cVar.f33505b : -1;
        }
        c0631bO.p(I(i10)).l(H(i10)).i(G(i10));
        PointF pointF = bVar.f33530b;
        if (pointF == null || f11 == -3.4028235E38f || f10 == -3.4028235E38f) {
            c0631bO.k(y(c0631bO.d()));
            c0631bO.h(y(c0631bO.c()), 0);
        } else {
            c0631bO.k(pointF.x / f10);
            c0631bO.h(bVar.f33530b.y / f11, 0);
        }
        return c0631bO.a();
    }

    @Override // n3.h
    protected i v(byte[] bArr, int i10, boolean z10) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        c0 c0Var = new c0(bArr, i10);
        if (!this.f33494o) {
            C(c0Var);
        }
        B(c0Var, arrayList, arrayList2);
        return new d(arrayList, arrayList2);
    }
}
