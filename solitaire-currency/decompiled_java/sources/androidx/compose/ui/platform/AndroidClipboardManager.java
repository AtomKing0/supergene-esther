package androidx.compose.ui.platform;

import android.content.ClipData;
import android.content.ClipDescription;
import android.content.Context;
import androidx.compose.ui.text.AnnotatedString;
import androidx.webkit.internal.AssetHelper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: AndroidClipboardManager.android.kt */
/* JADX INFO: loaded from: classes.dex */
public final class AndroidClipboardManager implements ClipboardManager {

    @NotNull
    private final android.content.ClipboardManager clipboardManager;

    public AndroidClipboardManager(@NotNull android.content.ClipboardManager clipboardManager) {
        kotlin.jvm.internal.t.i(clipboardManager, "clipboardManager");
        this.clipboardManager = clipboardManager;
    }

    @Override // androidx.compose.ui.platform.ClipboardManager
    @Nullable
    public AnnotatedString getText() {
        ClipData primaryClip = this.clipboardManager.getPrimaryClip();
        if (primaryClip == null || primaryClip.getItemCount() <= 0) {
            return null;
        }
        ClipData.Item itemAt = primaryClip.getItemAt(0);
        return AndroidClipboardManager_androidKt.convertToAnnotatedString(itemAt != null ? itemAt.getText() : null);
    }

    public final boolean hasText() {
        ClipDescription primaryClipDescription = this.clipboardManager.getPrimaryClipDescription();
        if (primaryClipDescription != null) {
            return primaryClipDescription.hasMimeType(AssetHelper.DEFAULT_MIME_TYPE);
        }
        return false;
    }

    @Override // androidx.compose.ui.platform.ClipboardManager
    public void setText(@NotNull AnnotatedString annotatedString) {
        kotlin.jvm.internal.t.i(annotatedString, "annotatedString");
        this.clipboardManager.setPrimaryClip(ClipData.newPlainText("plain text", AndroidClipboardManager_androidKt.convertToCharSequence(annotatedString)));
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public AndroidClipboardManager(@NotNull Context context) {
        kotlin.jvm.internal.t.i(context, "context");
        Object systemService = context.getSystemService("clipboard");
        if (systemService != null) {
            this((android.content.ClipboardManager) systemService);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.content.ClipboardManager");
    }
}
