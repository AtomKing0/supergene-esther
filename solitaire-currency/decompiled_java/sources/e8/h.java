package e8;

import java.util.Locale;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: HttpHeaderValueParser.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final String f25250a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final String f25251b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f25252c;

    public h(@NotNull String name, @NotNull String value, boolean z10) {
        kotlin.jvm.internal.t.i(name, "name");
        kotlin.jvm.internal.t.i(value, "value");
        this.f25250a = name;
        this.f25251b = value;
        this.f25252c = z10;
    }

    @NotNull
    public final String a() {
        return this.f25250a;
    }

    @NotNull
    public final String b() {
        return this.f25251b;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof h) {
            h hVar = (h) obj;
            if (p9.q.x(hVar.f25250a, this.f25250a, true) && p9.q.x(hVar.f25251b, this.f25251b, true)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        String str = this.f25250a;
        Locale locale = Locale.ROOT;
        String lowerCase = str.toLowerCase(locale);
        kotlin.jvm.internal.t.h(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        int iHashCode = lowerCase.hashCode();
        String lowerCase2 = this.f25251b.toLowerCase(locale);
        kotlin.jvm.internal.t.h(lowerCase2, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        return iHashCode + (iHashCode * 31) + lowerCase2.hashCode();
    }

    @NotNull
    public String toString() {
        return "HeaderValueParam(name=" + this.f25250a + ", value=" + this.f25251b + ", escapeValue=" + this.f25252c + ')';
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public h(@NotNull String name, @NotNull String value) {
        this(name, value, false);
        kotlin.jvm.internal.t.i(name, "name");
        kotlin.jvm.internal.t.i(value, "value");
    }
}
