package p9;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Regex.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class f implements Serializable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public static final a f32970b = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final Pattern f32971a;

    /* JADX INFO: compiled from: Regex.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }
    }

    public f(@NotNull Pattern nativePattern) {
        kotlin.jvm.internal.t.i(nativePattern, "nativePattern");
        this.f32971a = nativePattern;
    }

    public final boolean a(@NotNull CharSequence input) {
        kotlin.jvm.internal.t.i(input, "input");
        return this.f32971a.matcher(input).matches();
    }

    @NotNull
    public final String b(@NotNull CharSequence input, @NotNull String replacement) {
        kotlin.jvm.internal.t.i(input, "input");
        kotlin.jvm.internal.t.i(replacement, "replacement");
        String strReplaceAll = this.f32971a.matcher(input).replaceAll(replacement);
        kotlin.jvm.internal.t.h(strReplaceAll, "nativePattern.matcher(in…).replaceAll(replacement)");
        return strReplaceAll;
    }

    @NotNull
    public final String c(@NotNull CharSequence input, @NotNull String replacement) {
        kotlin.jvm.internal.t.i(input, "input");
        kotlin.jvm.internal.t.i(replacement, "replacement");
        String strReplaceFirst = this.f32971a.matcher(input).replaceFirst(replacement);
        kotlin.jvm.internal.t.h(strReplaceFirst, "nativePattern.matcher(in…replaceFirst(replacement)");
        return strReplaceFirst;
    }

    @NotNull
    public final List<String> d(@NotNull CharSequence input, int i10) {
        kotlin.jvm.internal.t.i(input, "input");
        r.x0(i10);
        Matcher matcher = this.f32971a.matcher(input);
        if (i10 == 1 || !matcher.find()) {
            return kotlin.collections.u.e(input.toString());
        }
        ArrayList arrayList = new ArrayList(i10 > 0 ? n9.o.j(i10, 10) : 10);
        int i11 = i10 - 1;
        int iEnd = 0;
        do {
            arrayList.add(input.subSequence(iEnd, matcher.start()).toString());
            iEnd = matcher.end();
            if (i11 >= 0 && arrayList.size() == i11) {
                break;
            }
        } while (matcher.find());
        arrayList.add(input.subSequence(iEnd, input.length()).toString());
        return arrayList;
    }

    @NotNull
    public String toString() {
        String string = this.f32971a.toString();
        kotlin.jvm.internal.t.h(string, "nativePattern.toString()");
        return string;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public f(@NotNull String pattern) {
        kotlin.jvm.internal.t.i(pattern, "pattern");
        Pattern patternCompile = Pattern.compile(pattern);
        kotlin.jvm.internal.t.h(patternCompile, "compile(pattern)");
        this(patternCompile);
    }
}
