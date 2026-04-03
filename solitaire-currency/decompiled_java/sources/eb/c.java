package eb;

import android.webkit.WebView;
import java.util.Arrays;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: SetLanguageAction.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class c implements eb.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f25517c = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final WebView f25518a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f25519b;

    /* JADX INFO: compiled from: SetLanguageAction.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(k kVar) {
            this();
        }
    }

    public c(@NotNull WebView webView, @NotNull String language) {
        t.j(webView, "webView");
        t.j(language, "language");
        this.f25518a = webView;
        this.f25519b = language;
    }

    @Override // eb.a
    public void execute() {
        WebView webView = this.f25518a;
        String str = String.format("setLanguage('%s')", Arrays.copyOf(new Object[]{this.f25519b}, 1));
        t.e(str, "java.lang.String.format(this, *args)");
        webView.evaluateJavascript(str, null);
    }

    @Override // eb.a
    @NotNull
    public String key() {
        String simpleName = c.class.getSimpleName();
        t.e(simpleName, "SetLanguageAction::class.java.simpleName");
        return simpleName;
    }
}
