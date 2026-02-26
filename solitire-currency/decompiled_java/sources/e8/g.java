package e8;

import java.util.Iterator;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: HttpHeaderValueParser.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final String f25247a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final List<h> f25248b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final double f25249c;

    public g(@NotNull String value, @NotNull List<h> params) {
        Object next;
        String strB;
        Double dI;
        kotlin.jvm.internal.t.i(value, "value");
        kotlin.jvm.internal.t.i(params, "params");
        this.f25247a = value;
        this.f25248b = params;
        Iterator<T> it = params.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            } else {
                next = it.next();
                if (kotlin.jvm.internal.t.d(((h) next).a(), "q")) {
                    break;
                }
            }
        }
        h hVar = (h) next;
        double dDoubleValue = 1.0d;
        if (hVar != null && (strB = hVar.b()) != null && (dI = p9.o.i(strB)) != null) {
            double dDoubleValue2 = dI.doubleValue();
            boolean z10 = false;
            if (0.0d <= dDoubleValue2 && dDoubleValue2 <= 1.0d) {
                z10 = true;
            }
            Double d10 = z10 ? dI : null;
            if (d10 != null) {
                dDoubleValue = d10.doubleValue();
            }
        }
        this.f25249c = dDoubleValue;
    }

    @NotNull
    public final List<h> a() {
        return this.f25248b;
    }

    @NotNull
    public final String b() {
        return this.f25247a;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return kotlin.jvm.internal.t.d(this.f25247a, gVar.f25247a) && kotlin.jvm.internal.t.d(this.f25248b, gVar.f25248b);
    }

    public int hashCode() {
        return (this.f25247a.hashCode() * 31) + this.f25248b.hashCode();
    }

    @NotNull
    public String toString() {
        return "HeaderValue(value=" + this.f25247a + ", params=" + this.f25248b + ')';
    }
}
