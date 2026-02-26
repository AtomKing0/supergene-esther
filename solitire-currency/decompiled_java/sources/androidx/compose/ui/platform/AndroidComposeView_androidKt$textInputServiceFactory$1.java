package androidx.compose.ui.platform;

import androidx.compose.ui.text.input.PlatformTextInputService;
import androidx.compose.ui.text.input.TextInputService;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: AndroidComposeView.android.kt */
/* JADX INFO: loaded from: classes.dex */
final class AndroidComposeView_androidKt$textInputServiceFactory$1 extends kotlin.jvm.internal.v implements h9.l<PlatformTextInputService, TextInputService> {
    public static final AndroidComposeView_androidKt$textInputServiceFactory$1 INSTANCE = new AndroidComposeView_androidKt$textInputServiceFactory$1();

    AndroidComposeView_androidKt$textInputServiceFactory$1() {
        super(1);
    }

    @Override // h9.l
    @NotNull
    public final TextInputService invoke(@NotNull PlatformTextInputService it) {
        kotlin.jvm.internal.t.i(it, "it");
        return new TextInputService(it);
    }
}
