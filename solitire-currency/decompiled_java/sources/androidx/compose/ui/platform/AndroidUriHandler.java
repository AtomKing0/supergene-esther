package androidx.compose.ui.platform;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.compose.runtime.internal.StabilityInferred;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: AndroidUriHandler.android.kt */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
public final class AndroidUriHandler implements UriHandler {
    public static final int $stable = 8;

    @NotNull
    private final Context context;

    public AndroidUriHandler(@NotNull Context context) {
        kotlin.jvm.internal.t.i(context, "context");
        this.context = context;
    }

    @Override // androidx.compose.ui.platform.UriHandler
    public void openUri(@NotNull String uri) {
        kotlin.jvm.internal.t.i(uri, "uri");
        this.context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(uri)));
    }
}
