package ga;

import com.ironsource.nb;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: MediaType.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class x {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    public static final a f26237e = new a(null);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Pattern f26238f = Pattern.compile("([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final Pattern f26239g = Pattern.compile(";\\s*(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)|\"([^\"]*)\"))?");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final String f26240a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final String f26241b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final String f26242c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private final String[] f26243d;

    /* JADX INFO: compiled from: MediaType.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        @NotNull
        public final x a(@NotNull String str) {
            kotlin.jvm.internal.t.i(str, "<this>");
            Matcher matcher = x.f26238f.matcher(str);
            if (!matcher.lookingAt()) {
                throw new IllegalArgumentException(("No subtype found for: \"" + str + '\"').toString());
            }
            String strGroup = matcher.group(1);
            kotlin.jvm.internal.t.h(strGroup, "typeSubtype.group(1)");
            Locale US = Locale.US;
            kotlin.jvm.internal.t.h(US, "US");
            String lowerCase = strGroup.toLowerCase(US);
            kotlin.jvm.internal.t.h(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            String strGroup2 = matcher.group(2);
            kotlin.jvm.internal.t.h(strGroup2, "typeSubtype.group(2)");
            kotlin.jvm.internal.t.h(US, "US");
            String lowerCase2 = strGroup2.toLowerCase(US);
            kotlin.jvm.internal.t.h(lowerCase2, "this as java.lang.String).toLowerCase(locale)");
            ArrayList arrayList = new ArrayList();
            Matcher matcher2 = x.f26239g.matcher(str);
            int iEnd = matcher.end();
            while (iEnd < str.length()) {
                matcher2.region(iEnd, str.length());
                if (!matcher2.lookingAt()) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Parameter is not formatted correctly: \"");
                    String strSubstring = str.substring(iEnd);
                    kotlin.jvm.internal.t.h(strSubstring, "this as java.lang.String).substring(startIndex)");
                    sb.append(strSubstring);
                    sb.append("\" for: \"");
                    sb.append(str);
                    sb.append('\"');
                    throw new IllegalArgumentException(sb.toString().toString());
                }
                String strGroup3 = matcher2.group(1);
                if (strGroup3 == null) {
                    iEnd = matcher2.end();
                } else {
                    String strGroup4 = matcher2.group(2);
                    if (strGroup4 == null) {
                        strGroup4 = matcher2.group(3);
                    } else if (p9.q.K(strGroup4, "'", false, 2, null) && p9.q.w(strGroup4, "'", false, 2, null) && strGroup4.length() > 2) {
                        strGroup4 = strGroup4.substring(1, strGroup4.length() - 1);
                        kotlin.jvm.internal.t.h(strGroup4, "this as java.lang.String…ing(startIndex, endIndex)");
                    }
                    arrayList.add(strGroup3);
                    arrayList.add(strGroup4);
                    iEnd = matcher2.end();
                }
            }
            Object[] array = arrayList.toArray(new String[0]);
            if (array != null) {
                return new x(str, lowerCase, lowerCase2, (String[]) array, null);
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        }

        @Nullable
        public final x b(@NotNull String str) {
            kotlin.jvm.internal.t.i(str, "<this>");
            try {
                return a(str);
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }
    }

    public /* synthetic */ x(String str, String str2, String str3, String[] strArr, kotlin.jvm.internal.k kVar) {
        this(str, str2, str3, strArr);
    }

    public static /* synthetic */ Charset d(x xVar, Charset charset, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            charset = null;
        }
        return xVar.c(charset);
    }

    @NotNull
    public static final x e(@NotNull String str) {
        return f26237e.a(str);
    }

    @Nullable
    public static final x g(@NotNull String str) {
        return f26237e.b(str);
    }

    @Nullable
    public final Charset c(@Nullable Charset charset) {
        String strF = f(nb.M);
        if (strF == null) {
            return charset;
        }
        try {
            return Charset.forName(strF);
        } catch (IllegalArgumentException unused) {
            return charset;
        }
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof x) && kotlin.jvm.internal.t.d(((x) obj).f26240a, this.f26240a);
    }

    @Nullable
    public final String f(@NotNull String name) {
        kotlin.jvm.internal.t.i(name, "name");
        int i10 = 0;
        int iC = c9.c.c(0, this.f26243d.length - 1, 2);
        if (iC < 0) {
            return null;
        }
        while (true) {
            int i11 = i10 + 2;
            if (p9.q.x(this.f26243d[i10], name, true)) {
                return this.f26243d[i10 + 1];
            }
            if (i10 == iC) {
                return null;
            }
            i10 = i11;
        }
    }

    @NotNull
    public final String h() {
        return this.f26241b;
    }

    public int hashCode() {
        return this.f26240a.hashCode();
    }

    @NotNull
    public String toString() {
        return this.f26240a;
    }

    private x(String str, String str2, String str3, String[] strArr) {
        this.f26240a = str;
        this.f26241b = str2;
        this.f26242c = str3;
        this.f26243d = strArr;
    }
}
