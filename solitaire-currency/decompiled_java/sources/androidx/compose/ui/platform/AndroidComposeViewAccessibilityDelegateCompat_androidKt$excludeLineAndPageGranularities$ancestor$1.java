package androidx.compose.ui.platform;

import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.semantics.SemanticsActions;
import androidx.compose.ui.semantics.SemanticsConfiguration;
import androidx.compose.ui.semantics.SemanticsEntity;
import androidx.compose.ui.semantics.SemanticsNodeKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: AndroidComposeViewAccessibilityDelegateCompat.android.kt */
/* JADX INFO: loaded from: classes.dex */
final class AndroidComposeViewAccessibilityDelegateCompat_androidKt$excludeLineAndPageGranularities$ancestor$1 extends kotlin.jvm.internal.v implements h9.l<LayoutNode, Boolean> {
    public static final AndroidComposeViewAccessibilityDelegateCompat_androidKt$excludeLineAndPageGranularities$ancestor$1 INSTANCE = new AndroidComposeViewAccessibilityDelegateCompat_androidKt$excludeLineAndPageGranularities$ancestor$1();

    AndroidComposeViewAccessibilityDelegateCompat_androidKt$excludeLineAndPageGranularities$ancestor$1() {
        super(1);
    }

    @Override // h9.l
    @NotNull
    public final Boolean invoke(@NotNull LayoutNode it) {
        kotlin.jvm.internal.t.i(it, "it");
        SemanticsEntity outerSemantics = SemanticsNodeKt.getOuterSemantics(it);
        SemanticsConfiguration semanticsConfigurationCollapsedSemanticsConfiguration = outerSemantics != null ? outerSemantics.collapsedSemanticsConfiguration() : null;
        return Boolean.valueOf((semanticsConfigurationCollapsedSemanticsConfiguration != null && semanticsConfigurationCollapsedSemanticsConfiguration.isMergingSemanticsOfDescendants()) && semanticsConfigurationCollapsedSemanticsConfiguration.contains(SemanticsActions.INSTANCE.getSetText()));
    }
}
