package androidx.compose.foundation;

import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Indication.kt */
/* JADX INFO: loaded from: classes.dex */
final class NoIndication implements Indication {

    @NotNull
    public static final NoIndication INSTANCE = new NoIndication();

    /* JADX INFO: compiled from: Indication.kt */
    private static final class NoIndicationInstance implements IndicationInstance {

        @NotNull
        public static final NoIndicationInstance INSTANCE = new NoIndicationInstance();

        private NoIndicationInstance() {
        }

        @Override // androidx.compose.foundation.IndicationInstance
        public void drawIndication(@NotNull ContentDrawScope contentDrawScope) {
            t.i(contentDrawScope, "<this>");
            contentDrawScope.drawContent();
        }
    }

    private NoIndication() {
    }

    @Override // androidx.compose.foundation.Indication
    @Composable
    @NotNull
    public IndicationInstance rememberUpdatedInstance(@NotNull InteractionSource interactionSource, @Nullable Composer composer, int i10) {
        t.i(interactionSource, "interactionSource");
        composer.startReplaceableGroup(285654452);
        NoIndicationInstance noIndicationInstance = NoIndicationInstance.INSTANCE;
        composer.endReplaceableGroup();
        return noIndicationInstance;
    }
}
