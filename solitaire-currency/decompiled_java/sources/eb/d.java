package eb;

import android.webkit.WebView;
import java.util.Arrays;
import java.util.Map;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: SetMetafieldsAction.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class d implements eb.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f25520c = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final WebView f25521a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map<String, Object> f25522b;

    /* JADX INFO: compiled from: SetMetafieldsAction.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(k kVar) {
            this();
        }
    }

    public d(@NotNull WebView webView, @NotNull Map<String, ? extends Object> metaFields) {
        t.j(webView, "webView");
        t.j(metaFields, "metaFields");
        this.f25521a = webView;
        this.f25522b = metaFields;
    }

    @Override // eb.a
    public void execute() {
        WebView webView = this.f25521a;
        String str = String.format("setMetaFields(%s)", Arrays.copyOf(new Object[]{fb.c.c(this.f25522b)}, 1));
        t.e(str, "java.lang.String.format(this, *args)");
        webView.evaluateJavascript(str, null);
    }

    @Override // eb.a
    @NotNull
    public String key() {
        String simpleName = d.class.getSimpleName();
        t.e(simpleName, "SetMetafieldsAction::class.java.simpleName");
        return simpleName;
    }
}
