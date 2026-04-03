package e8;

import com.ironsource.v8;
import com.unity3d.services.UnityAdsConstants;
import java.io.IOException;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: URLBuilder.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class h0 {
    private static final void b(Appendable appendable, String str, String str2) throws IOException {
        appendable.append("://");
        appendable.append(str);
        if (!p9.r.H0(str2, '/', false, 2, null)) {
            appendable.append('/');
        }
        appendable.append(str2);
    }

    private static final void c(Appendable appendable, String str, String str2) throws IOException {
        appendable.append(":");
        appendable.append(str);
        appendable.append(str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <A extends Appendable> A d(f0 f0Var, A a10) throws IOException {
        a10.append(f0Var.o().d());
        String strD = f0Var.o().d();
        if (kotlin.jvm.internal.t.d(strD, v8.h.f15781b)) {
            b(a10, f0Var.j(), f(f0Var));
            return a10;
        }
        if (kotlin.jvm.internal.t.d(strD, "mailto")) {
            c(a10, g(f0Var), f0Var.j());
            return a10;
        }
        a10.append("://");
        a10.append(e(f0Var));
        n0.d(a10, f(f0Var), f0Var.e(), f0Var.p());
        if (f0Var.d().length() > 0) {
            a10.append('#');
            a10.append(f0Var.d());
        }
        return a10;
    }

    @NotNull
    public static final String e(@NotNull f0 f0Var) {
        kotlin.jvm.internal.t.i(f0Var, "<this>");
        StringBuilder sb = new StringBuilder();
        sb.append(g(f0Var));
        sb.append(f0Var.j());
        if (f0Var.n() != 0 && f0Var.n() != f0Var.o().c()) {
            sb.append(":");
            sb.append(String.valueOf(f0Var.n()));
        }
        String string = sb.toString();
        kotlin.jvm.internal.t.h(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    @NotNull
    public static final String f(@NotNull f0 f0Var) {
        kotlin.jvm.internal.t.i(f0Var, "<this>");
        return h(f0Var.g());
    }

    @NotNull
    public static final String g(@NotNull f0 f0Var) {
        kotlin.jvm.internal.t.i(f0Var, "<this>");
        StringBuilder sb = new StringBuilder();
        n0.e(sb, f0Var.h(), f0Var.f());
        String string = sb.toString();
        kotlin.jvm.internal.t.h(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    private static final String h(List<String> list) {
        if (list.isEmpty()) {
            return "";
        }
        if (list.size() == 1) {
            return ((CharSequence) kotlin.collections.d0.i0(list)).length() == 0 ? UnityAdsConstants.DefaultUrls.AD_ASSET_PATH : (String) kotlin.collections.d0.i0(list);
        }
        return kotlin.collections.d0.r0(list, UnityAdsConstants.DefaultUrls.AD_ASSET_PATH, null, null, 0, null, null, 62, null);
    }

    public static final void i(@NotNull f0 f0Var, @NotNull String value) {
        kotlin.jvm.internal.t.i(f0Var, "<this>");
        kotlin.jvm.internal.t.i(value, "value");
        f0Var.u(p9.q.z(value) ? kotlin.collections.v.l() : kotlin.jvm.internal.t.d(value, UnityAdsConstants.DefaultUrls.AD_ASSET_PATH) ? k0.d() : kotlin.collections.d0.R0(p9.r.B0(value, new char[]{'/'}, false, 0, 6, null)));
    }
}
