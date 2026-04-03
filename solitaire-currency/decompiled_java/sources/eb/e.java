package eb;

import android.webkit.WebView;
import java.util.Arrays;
import java.util.Map;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: SetSensitiveMetafieldsAction.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class e implements eb.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f25523c = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final WebView f25524a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map<String, Object> f25525b;

    /* JADX INFO: compiled from: SetSensitiveMetafieldsAction.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(k kVar) {
            this();
        }
    }

    public e(@NotNull WebView webView, @NotNull Map<String, ? extends Object> metaFields) {
        t.j(webView, "webView");
        t.j(metaFields, "metaFields");
        this.f25524a = webView;
        this.f25525b = metaFields;
    }

    @Override // eb.a
    public void execute() {
        WebView webView = this.f25524a;
        String str = String.format("setSensitiveMetaFields(%s)", Arrays.copyOf(new Object[]{fb.c.c(this.f25525b)}, 1));
        t.e(str, "java.lang.String.format(this, *args)");
        webView.evaluateJavascript(str, null);
    }

    @Override // eb.a
    @NotNull
    public String key() {
        String simpleName = e.class.getSimpleName();
        t.e(simpleName, "SetSensitiveMetafieldsAc…on::class.java.simpleName");
        return simpleName;
    }
}
