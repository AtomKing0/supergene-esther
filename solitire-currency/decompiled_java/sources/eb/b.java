package eb;

import android.webkit.WebView;
import java.util.Arrays;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: SetDeviceTokenAction.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class b implements eb.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f25514c = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final WebView f25515a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f25516b;

    /* JADX INFO: compiled from: SetDeviceTokenAction.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(k kVar) {
            this();
        }
    }

    public b(@NotNull WebView webView, @NotNull String token) {
        t.j(webView, "webView");
        t.j(token, "token");
        this.f25515a = webView;
        this.f25516b = token;
    }

    @Override // eb.a
    public void execute() {
        WebView webView = this.f25515a;
        String str = String.format("setDeviceToken('%s')", Arrays.copyOf(new Object[]{this.f25516b}, 1));
        t.e(str, "java.lang.String.format(this, *args)");
        webView.evaluateJavascript(str, null);
    }

    @Override // eb.a
    @NotNull
    public String key() {
        String simpleName = b.class.getSimpleName();
        t.e(simpleName, "SetDeviceTokenAction::class.java.simpleName");
        return simpleName;
    }
}
