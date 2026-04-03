package e8;

import androidx.core.app.FrameMetricsAggregator;
import com.ironsource.nb;
import com.ironsource.v8;
import com.unity3d.services.UnityAdsConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: URLUtils.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class n0 {

    /* JADX INFO: compiled from: URLUtils.kt */
    static final class a extends kotlin.jvm.internal.v implements h9.l<v8.s<? extends String, ? extends String>, CharSequence> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final a f25273g = new a();

        a() {
            super(1);
        }

        @Override // h9.l
        @NotNull
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final CharSequence invoke(@NotNull v8.s<String, String> it) {
            kotlin.jvm.internal.t.i(it, "it");
            String strC = it.c();
            if (it.d() == null) {
                return strC;
            }
            return strC + nb.T + String.valueOf(it.d());
        }
    }

    @NotNull
    public static final f0 a(@NotNull p0 url) {
        kotlin.jvm.internal.t.i(url, "url");
        return h(new f0(null, null, 0, null, null, null, null, null, false, FrameMetricsAggregator.EVERY_DURATION, null), url);
    }

    @NotNull
    public static final f0 b(@NotNull String urlString) {
        kotlin.jvm.internal.t.i(urlString, "urlString");
        return k0.j(new f0(null, null, 0, null, null, null, null, null, false, FrameMetricsAggregator.EVERY_DURATION, null), urlString);
    }

    @NotNull
    public static final p0 c(@NotNull String urlString) {
        kotlin.jvm.internal.t.i(urlString, "urlString");
        return b(urlString).b();
    }

    public static final void d(@NotNull Appendable appendable, @NotNull String encodedPath, @NotNull a0 encodedQueryParameters, boolean z10) {
        List listE;
        kotlin.jvm.internal.t.i(appendable, "<this>");
        kotlin.jvm.internal.t.i(encodedPath, "encodedPath");
        kotlin.jvm.internal.t.i(encodedQueryParameters, "encodedQueryParameters");
        if ((!p9.q.z(encodedPath)) && !p9.q.K(encodedPath, UnityAdsConstants.DefaultUrls.AD_ASSET_PATH, false, 2, null)) {
            appendable.append('/');
        }
        appendable.append(encodedPath);
        if (!encodedQueryParameters.isEmpty() || z10) {
            appendable.append("?");
        }
        Set<Map.Entry<String, List<String>>> setA = encodedQueryParameters.a();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = setA.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            String str = (String) entry.getKey();
            List list = (List) entry.getValue();
            if (list.isEmpty()) {
                listE = kotlin.collections.u.e(v8.y.a(str, null));
            } else {
                List list2 = list;
                ArrayList arrayList2 = new ArrayList(kotlin.collections.w.v(list2, 10));
                Iterator it2 = list2.iterator();
                while (it2.hasNext()) {
                    arrayList2.add(v8.y.a(str, (String) it2.next()));
                }
                listE = arrayList2;
            }
            kotlin.collections.a0.B(arrayList, listE);
        }
        kotlin.collections.d0.p0(arrayList, appendable, v8.i.f15835c, null, null, 0, null, a.f25273g, 60, null);
    }

    public static final void e(@NotNull StringBuilder sb, @Nullable String str, @Nullable String str2) {
        kotlin.jvm.internal.t.i(sb, "<this>");
        if (str == null) {
            return;
        }
        sb.append(str);
        if (str2 != null) {
            sb.append(':');
            sb.append(str2);
        }
        sb.append("@");
    }

    @NotNull
    public static final String f(@NotNull p0 p0Var) {
        kotlin.jvm.internal.t.i(p0Var, "<this>");
        return p0Var.g() + ':' + p0Var.j();
    }

    @NotNull
    public static final f0 g(@NotNull f0 f0Var, @NotNull f0 url) {
        kotlin.jvm.internal.t.i(f0Var, "<this>");
        kotlin.jvm.internal.t.i(url, "url");
        f0Var.y(url.o());
        f0Var.w(url.j());
        f0Var.x(url.n());
        f0Var.u(url.g());
        f0Var.v(url.h());
        f0Var.t(url.f());
        a0 a0VarB = d0.b(0, 1, null);
        g8.x.c(a0VarB, url.e());
        f0Var.s(a0VarB);
        f0Var.r(url.d());
        f0Var.z(url.p());
        return f0Var;
    }

    @NotNull
    public static final f0 h(@NotNull f0 f0Var, @NotNull p0 url) {
        kotlin.jvm.internal.t.i(f0Var, "<this>");
        kotlin.jvm.internal.t.i(url, "url");
        f0Var.y(url.k());
        f0Var.w(url.g());
        f0Var.x(url.j());
        h0.i(f0Var, url.d());
        f0Var.v(url.f());
        f0Var.t(url.c());
        a0 a0VarB = d0.b(0, 1, null);
        a0VarB.e(e0.d(url.e(), 0, 0, false, 6, null));
        f0Var.s(a0VarB);
        f0Var.r(url.b());
        f0Var.z(url.m());
        return f0Var;
    }
}
