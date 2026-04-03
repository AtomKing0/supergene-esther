package e8;

import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: HttpHeaderValueParser.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class n {

    /* JADX INFO: compiled from: HttpHeaderValueParser.kt */
    static final class a extends kotlin.jvm.internal.v implements h9.a<ArrayList<g>> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final a f25271g = new a();

        a() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final ArrayList<g> invoke() {
            return new ArrayList<>();
        }
    }

    /* JADX INFO: compiled from: HttpHeaderValueParser.kt */
    static final class b extends kotlin.jvm.internal.v implements h9.a<ArrayList<h>> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final b f25272g = new b();

        b() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final ArrayList<h> invoke() {
            return new ArrayList<>();
        }
    }

    private static final boolean a(String str, int i10) {
        int i11 = i10 + 1;
        while (i11 < str.length() && str.charAt(i11) == ' ') {
            i11++;
        }
        return i11 == str.length() || str.charAt(i11) == ';';
    }

    @NotNull
    public static final List<g> b(@Nullable String str) {
        return c(str, false);
    }

    @NotNull
    public static final List<g> c(@Nullable String str, boolean z10) {
        if (str == null) {
            return kotlin.collections.v.l();
        }
        v8.l lVarB = v8.n.b(v8.p.f35203c, a.f25271g);
        int iD = 0;
        while (iD <= p9.r.Y(str)) {
            iD = d(str, iD, lVarB, z10);
        }
        return j(lVarB);
    }

    private static final int d(String str, int i10, v8.l<? extends ArrayList<g>> lVar, boolean z10) {
        v8.l lVarB = v8.n.b(v8.p.f35203c, b.f25272g);
        Integer numValueOf = z10 ? Integer.valueOf(i10) : null;
        int iE = i10;
        while (iE <= p9.r.Y(str)) {
            char cCharAt = str.charAt(iE);
            if (cCharAt == ',') {
                lVar.getValue().add(new g(i(str, i10, numValueOf != null ? numValueOf.intValue() : iE), j(lVarB)));
                return iE + 1;
            }
            if (cCharAt == ';') {
                if (numValueOf == null) {
                    numValueOf = Integer.valueOf(iE);
                }
                iE = e(str, iE + 1, lVarB);
            } else {
                iE = z10 ? e(str, iE, lVarB) : iE + 1;
            }
        }
        lVar.getValue().add(new g(i(str, i10, numValueOf != null ? numValueOf.intValue() : iE), j(lVarB)));
        return iE;
    }

    private static final int e(String str, int i10, v8.l<? extends ArrayList<h>> lVar) {
        int i11 = i10;
        while (i11 <= p9.r.Y(str)) {
            char cCharAt = str.charAt(i11);
            if (cCharAt == '=') {
                v8.s<Integer, String> sVarG = g(str, i11 + 1);
                int iIntValue = sVarG.a().intValue();
                f(lVar, str, i10, i11, sVarG.b());
                return iIntValue;
            }
            boolean z10 = true;
            if (cCharAt != ';' && cCharAt != ',') {
                z10 = false;
            }
            if (z10) {
                f(lVar, str, i10, i11, "");
                return i11;
            }
            i11++;
        }
        f(lVar, str, i10, i11, "");
        return i11;
    }

    private static final void f(v8.l<? extends ArrayList<h>> lVar, String str, int i10, int i11, String str2) {
        String strI = i(str, i10, i11);
        if (strI.length() == 0) {
            return;
        }
        lVar.getValue().add(new h(strI, str2));
    }

    private static final v8.s<Integer, String> g(String str, int i10) {
        if (str.length() == i10) {
            return v8.y.a(Integer.valueOf(i10), "");
        }
        if (str.charAt(i10) == '\"') {
            return h(str, i10 + 1);
        }
        int i11 = i10;
        while (i11 <= p9.r.Y(str)) {
            char cCharAt = str.charAt(i11);
            if (cCharAt == ';' || cCharAt == ',') {
                return v8.y.a(Integer.valueOf(i11), i(str, i10, i11));
            }
            i11++;
        }
        return v8.y.a(Integer.valueOf(i11), i(str, i10, i11));
    }

    private static final v8.s<Integer, String> h(String str, int i10) {
        StringBuilder sb = new StringBuilder();
        while (i10 <= p9.r.Y(str)) {
            char cCharAt = str.charAt(i10);
            if (cCharAt == '\"' && a(str, i10)) {
                Integer numValueOf = Integer.valueOf(i10 + 1);
                String string = sb.toString();
                kotlin.jvm.internal.t.h(string, "builder.toString()");
                return v8.y.a(numValueOf, string);
            }
            if (cCharAt != '\\' || i10 >= p9.r.Y(str) - 2) {
                sb.append(cCharAt);
                i10++;
            } else {
                sb.append(str.charAt(i10 + 1));
                i10 += 2;
            }
        }
        Integer numValueOf2 = Integer.valueOf(i10);
        String string2 = sb.toString();
        kotlin.jvm.internal.t.h(string2, "builder.toString()");
        return v8.y.a(numValueOf2, '\"' + string2);
    }

    private static final String i(String str, int i10, int i11) {
        String strSubstring = str.substring(i10, i11);
        kotlin.jvm.internal.t.h(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return p9.r.b1(strSubstring).toString();
    }

    private static final <T> List<T> j(v8.l<? extends List<? extends T>> lVar) {
        return lVar.isInitialized() ? lVar.getValue() : kotlin.collections.v.l();
    }
}
