package s3;

import a4.o0;
import a4.t;
import android.graphics.Color;
import android.graphics.PointF;
import android.text.TextUtils;
import androidx.annotation.ColorInt;
import androidx.annotation.Nullable;
import g5.e;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: SsaStyle.java */
/* JADX INFO: loaded from: classes2.dex */
final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f33504a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f33505b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    @ColorInt
    public final Integer f33506c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    @ColorInt
    public final Integer f33507d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f33508e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f33509f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f33510g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f33511h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f33512i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f33513j;

    /* JADX INFO: compiled from: SsaStyle.java */
    static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f33514a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f33515b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f33516c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f33517d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f33518e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f33519f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final int f33520g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final int f33521h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final int f33522i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final int f33523j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final int f33524k;

        private a(int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, int i19, int i20) {
            this.f33514a = i10;
            this.f33515b = i11;
            this.f33516c = i12;
            this.f33517d = i13;
            this.f33518e = i14;
            this.f33519f = i15;
            this.f33520g = i16;
            this.f33521h = i17;
            this.f33522i = i18;
            this.f33523j = i19;
            this.f33524k = i20;
        }

        @Nullable
        public static a a(String str) {
            String[] strArrSplit = TextUtils.split(str.substring(7), ",");
            int i10 = -1;
            int i11 = -1;
            int i12 = -1;
            int i13 = -1;
            int i14 = -1;
            int i15 = -1;
            int i16 = -1;
            int i17 = -1;
            int i18 = -1;
            int i19 = -1;
            for (int i20 = 0; i20 < strArrSplit.length; i20++) {
                String strE = e5.c.e(strArrSplit[i20].trim());
                strE.hashCode();
                switch (strE) {
                    case "italic":
                        i16 = i20;
                        break;
                    case "underline":
                        i17 = i20;
                        break;
                    case "strikeout":
                        i18 = i20;
                        break;
                    case "primarycolour":
                        i12 = i20;
                        break;
                    case "bold":
                        i15 = i20;
                        break;
                    case "name":
                        i10 = i20;
                        break;
                    case "fontsize":
                        i14 = i20;
                        break;
                    case "borderstyle":
                        i19 = i20;
                        break;
                    case "alignment":
                        i11 = i20;
                        break;
                    case "outlinecolour":
                        i13 = i20;
                        break;
                }
            }
            if (i10 != -1) {
                return new a(i10, i11, i12, i13, i14, i15, i16, i17, i18, i19, strArrSplit.length);
            }
            return null;
        }
    }

    /* JADX INFO: compiled from: SsaStyle.java */
    static final class b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final Pattern f33525c = Pattern.compile("\\{([^}]*)\\}");

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final Pattern f33526d = Pattern.compile(o0.z("\\\\pos\\((%1$s),(%1$s)\\)", "\\s*\\d+(?:\\.\\d+)?\\s*"));

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final Pattern f33527e = Pattern.compile(o0.z("\\\\move\\(%1$s,%1$s,(%1$s),(%1$s)(?:,%1$s,%1$s)?\\)", "\\s*\\d+(?:\\.\\d+)?\\s*"));

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private static final Pattern f33528f = Pattern.compile("\\\\an(\\d+)");

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f33529a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        public final PointF f33530b;

        private b(int i10, @Nullable PointF pointF) {
            this.f33529a = i10;
            this.f33530b = pointF;
        }

        private static int a(String str) {
            Matcher matcher = f33528f.matcher(str);
            if (matcher.find()) {
                return c.e((String) a4.a.e(matcher.group(1)));
            }
            return -1;
        }

        public static b b(String str) {
            Matcher matcher = f33525c.matcher(str);
            PointF pointF = null;
            int i10 = -1;
            while (matcher.find()) {
                String str2 = (String) a4.a.e(matcher.group(1));
                try {
                    PointF pointFC = c(str2);
                    if (pointFC != null) {
                        pointF = pointFC;
                    }
                } catch (RuntimeException unused) {
                }
                try {
                    int iA = a(str2);
                    if (iA != -1) {
                        i10 = iA;
                    }
                } catch (RuntimeException unused2) {
                }
            }
            return new b(i10, pointF);
        }

        @Nullable
        private static PointF c(String str) {
            String strGroup;
            String strGroup2;
            Matcher matcher = f33526d.matcher(str);
            Matcher matcher2 = f33527e.matcher(str);
            boolean zFind = matcher.find();
            boolean zFind2 = matcher2.find();
            if (zFind) {
                if (zFind2) {
                    t.f("SsaStyle.Overrides", "Override has both \\pos(x,y) and \\move(x1,y1,x2,y2); using \\pos values. override='" + str + "'");
                }
                strGroup = matcher.group(1);
                strGroup2 = matcher.group(2);
            } else {
                if (!zFind2) {
                    return null;
                }
                strGroup = matcher2.group(1);
                strGroup2 = matcher2.group(2);
            }
            return new PointF(Float.parseFloat(((String) a4.a.e(strGroup)).trim()), Float.parseFloat(((String) a4.a.e(strGroup2)).trim()));
        }

        public static String d(String str) {
            return f33525c.matcher(str).replaceAll("");
        }
    }

    private c(String str, int i10, @Nullable @ColorInt Integer num, @Nullable @ColorInt Integer num2, float f10, boolean z10, boolean z11, boolean z12, boolean z13, int i11) {
        this.f33504a = str;
        this.f33505b = i10;
        this.f33506c = num;
        this.f33507d = num2;
        this.f33508e = f10;
        this.f33509f = z10;
        this.f33510g = z11;
        this.f33511h = z12;
        this.f33512i = z13;
        this.f33513j = i11;
    }

    @Nullable
    public static c b(String str, a aVar) {
        a4.a.a(str.startsWith("Style:"));
        String[] strArrSplit = TextUtils.split(str.substring(6), ",");
        int length = strArrSplit.length;
        int i10 = aVar.f33524k;
        if (length != i10) {
            t.i("SsaStyle", o0.z("Skipping malformed 'Style:' line (expected %s values, found %s): '%s'", Integer.valueOf(i10), Integer.valueOf(strArrSplit.length), str));
            return null;
        }
        try {
            String strTrim = strArrSplit[aVar.f33514a].trim();
            int i11 = aVar.f33515b;
            int iE = i11 != -1 ? e(strArrSplit[i11].trim()) : -1;
            int i12 = aVar.f33516c;
            Integer numH = i12 != -1 ? h(strArrSplit[i12].trim()) : null;
            int i13 = aVar.f33517d;
            Integer numH2 = i13 != -1 ? h(strArrSplit[i13].trim()) : null;
            int i14 = aVar.f33518e;
            float fI = i14 != -1 ? i(strArrSplit[i14].trim()) : -3.4028235E38f;
            int i15 = aVar.f33519f;
            boolean z10 = i15 != -1 && f(strArrSplit[i15].trim());
            int i16 = aVar.f33520g;
            boolean z11 = i16 != -1 && f(strArrSplit[i16].trim());
            int i17 = aVar.f33521h;
            boolean z12 = i17 != -1 && f(strArrSplit[i17].trim());
            int i18 = aVar.f33522i;
            boolean z13 = i18 != -1 && f(strArrSplit[i18].trim());
            int i19 = aVar.f33523j;
            return new c(strTrim, iE, numH, numH2, fI, z10, z11, z12, z13, i19 != -1 ? g(strArrSplit[i19].trim()) : -1);
        } catch (RuntimeException e10) {
            t.j("SsaStyle", "Skipping malformed 'Style:' line: '" + str + "'", e10);
            return null;
        }
    }

    private static boolean c(int i10) {
        switch (i10) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                return true;
            default:
                return false;
        }
    }

    private static boolean d(int i10) {
        return i10 == 1 || i10 == 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int e(String str) {
        try {
            int i10 = Integer.parseInt(str.trim());
            if (c(i10)) {
                return i10;
            }
        } catch (NumberFormatException unused) {
        }
        t.i("SsaStyle", "Ignoring unknown alignment: " + str);
        return -1;
    }

    private static boolean f(String str) {
        try {
            int i10 = Integer.parseInt(str);
            return i10 == 1 || i10 == -1;
        } catch (NumberFormatException e10) {
            t.j("SsaStyle", "Failed to parse boolean value: '" + str + "'", e10);
            return false;
        }
    }

    private static int g(String str) {
        try {
            int i10 = Integer.parseInt(str.trim());
            if (d(i10)) {
                return i10;
            }
        } catch (NumberFormatException unused) {
        }
        t.i("SsaStyle", "Ignoring unknown BorderStyle: " + str);
        return -1;
    }

    @Nullable
    @ColorInt
    public static Integer h(String str) {
        try {
            long j10 = str.startsWith("&H") ? Long.parseLong(str.substring(2), 16) : Long.parseLong(str);
            a4.a.a(j10 <= 4294967295L);
            return Integer.valueOf(Color.argb(e.d(((j10 >> 24) & 255) ^ 255), e.d(j10 & 255), e.d((j10 >> 8) & 255), e.d((j10 >> 16) & 255)));
        } catch (IllegalArgumentException e10) {
            t.j("SsaStyle", "Failed to parse color expression: '" + str + "'", e10);
            return null;
        }
    }

    private static float i(String str) {
        try {
            return Float.parseFloat(str);
        } catch (NumberFormatException e10) {
            t.j("SsaStyle", "Failed to parse font size: '" + str + "'", e10);
            return -3.4028235E38f;
        }
    }
}
