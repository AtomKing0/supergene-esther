package androidx.compose.ui.platform;

import android.view.accessibility.AccessibilityNodeInfo;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: AndroidComposeViewAccessibilityDelegateCompat.android.kt */
/* JADX INFO: loaded from: classes.dex */
@RequiresApi(26)
public final class AccessibilityNodeInfoVerificationHelperMethods {

    @NotNull
    public static final AccessibilityNodeInfoVerificationHelperMethods INSTANCE = new AccessibilityNodeInfoVerificationHelperMethods();

    private AccessibilityNodeInfoVerificationHelperMethods() {
    }

    @DoNotInline
    @RequiresApi(26)
    public final void setAvailableExtraData(@NotNull AccessibilityNodeInfo node, @NotNull List<String> data) {
        kotlin.jvm.internal.t.i(node, "node");
        kotlin.jvm.internal.t.i(data, "data");
        node.setAvailableExtraData(data);
    }
}
