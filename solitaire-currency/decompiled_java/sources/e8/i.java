package e8;

import com.ironsource.v8;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: HeaderValueWithParameters.kt */
/* JADX INFO: loaded from: classes4.dex */
public abstract class i {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f25253c = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final String f25254a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final List<h> f25255b;

    /* JADX INFO: compiled from: HeaderValueWithParameters.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }
    }

    public i(@NotNull String content, @NotNull List<h> parameters) {
        kotlin.jvm.internal.t.i(content, "content");
        kotlin.jvm.internal.t.i(parameters, "parameters");
        this.f25254a = content;
        this.f25255b = parameters;
    }

    @NotNull
    protected final String a() {
        return this.f25254a;
    }

    @NotNull
    public final List<h> b() {
        return this.f25255b;
    }

    @Nullable
    public final String c(@NotNull String name) {
        kotlin.jvm.internal.t.i(name, "name");
        int iM = kotlin.collections.v.m(this.f25255b);
        if (iM < 0) {
            return null;
        }
        int i10 = 0;
        while (true) {
            h hVar = this.f25255b.get(i10);
            if (p9.q.x(hVar.a(), name, true)) {
                return hVar.b();
            }
            if (i10 == iM) {
                return null;
            }
            i10++;
        }
    }

    @NotNull
    public String toString() {
        if (this.f25255b.isEmpty()) {
            return this.f25254a;
        }
        int length = this.f25254a.length();
        int i10 = 0;
        int length2 = 0;
        for (h hVar : this.f25255b) {
            length2 += hVar.a().length() + hVar.b().length() + 3;
        }
        StringBuilder sb = new StringBuilder(length + length2);
        sb.append(this.f25254a);
        int iM = kotlin.collections.v.m(this.f25255b);
        if (iM >= 0) {
            while (true) {
                h hVar2 = this.f25255b.get(i10);
                sb.append("; ");
                sb.append(hVar2.a());
                sb.append(v8.i.f15833b);
                String strB = hVar2.b();
                if (j.c(strB)) {
                    sb.append(j.d(strB));
                } else {
                    sb.append(strB);
                }
                if (i10 == iM) {
                    break;
                }
                i10++;
            }
        }
        String string = sb.toString();
        kotlin.jvm.internal.t.h(string, "{\n            val size =…   }.toString()\n        }");
        return string;
    }
}
