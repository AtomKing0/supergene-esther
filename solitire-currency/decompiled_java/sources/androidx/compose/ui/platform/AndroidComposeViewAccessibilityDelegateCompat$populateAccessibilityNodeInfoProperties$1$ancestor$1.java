package androidx.compose.ui.platform;

import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.semantics.SemanticsConfiguration;
import androidx.compose.ui.semantics.SemanticsEntity;
import androidx.compose.ui.semantics.SemanticsNodeKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: AndroidComposeViewAccessibilityDelegateCompat.android.kt */
/* JADX INFO: loaded from: classes.dex */
final class AndroidComposeViewAccessibilityDelegateCompat$populateAccessibilityNodeInfoProperties$1$ancestor$1 extends kotlin.jvm.internal.v implements h9.l<LayoutNode, Boolean> {
    public static final AndroidComposeViewAccessibilityDelegateCompat$populateAccessibilityNodeInfoProperties$1$ancestor$1 INSTANCE = new AndroidComposeViewAccessibilityDelegateCompat$populateAccessibilityNodeInfoProperties$1$ancestor$1();

    AndroidComposeViewAccessibilityDelegateCompat$populateAccessibilityNodeInfoProperties$1$ancestor$1() {
        super(1);
    }

    @Override // h9.l
    @NotNull
    public final Boolean invoke(@NotNull LayoutNode parent) {
        SemanticsConfiguration semanticsConfigurationCollapsedSemanticsConfiguration;
        kotlin.jvm.internal.t.i(parent, "parent");
        SemanticsEntity outerSemantics = SemanticsNodeKt.getOuterSemantics(parent);
        boolean z10 = false;
        if (outerSemantics != null && (semanticsConfigurationCollapsedSemanticsConfiguration = outerSemantics.collapsedSemanticsConfiguration()) != null && semanticsConfigurationCollapsedSemanticsConfiguration.isMergingSemanticsOfDescendants()) {
            z10 = true;
        }
        return Boolean.valueOf(z10);
    }
}
