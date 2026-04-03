package androidx.compose.ui.node;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import h9.p;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: ComposeUiNode.kt */
/* JADX INFO: loaded from: classes.dex */
public interface ComposeUiNode {

    @NotNull
    public static final Companion Companion = Companion.$$INSTANCE;

    /* JADX INFO: compiled from: ComposeUiNode.kt */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        @NotNull
        private static final h9.a<ComposeUiNode> Constructor = LayoutNode.Companion.getConstructor$ui_release();

        @NotNull
        private static final p<ComposeUiNode, Modifier, k0> SetModifier = ComposeUiNode$Companion$SetModifier$1.INSTANCE;

        @NotNull
        private static final p<ComposeUiNode, Density, k0> SetDensity = ComposeUiNode$Companion$SetDensity$1.INSTANCE;

        @NotNull
        private static final p<ComposeUiNode, MeasurePolicy, k0> SetMeasurePolicy = ComposeUiNode$Companion$SetMeasurePolicy$1.INSTANCE;

        @NotNull
        private static final p<ComposeUiNode, LayoutDirection, k0> SetLayoutDirection = ComposeUiNode$Companion$SetLayoutDirection$1.INSTANCE;

        @NotNull
        private static final p<ComposeUiNode, ViewConfiguration, k0> SetViewConfiguration = ComposeUiNode$Companion$SetViewConfiguration$1.INSTANCE;

        private Companion() {
        }

        @NotNull
        public final h9.a<ComposeUiNode> getConstructor() {
            return Constructor;
        }

        @NotNull
        public final p<ComposeUiNode, Density, k0> getSetDensity() {
            return SetDensity;
        }

        @NotNull
        public final p<ComposeUiNode, LayoutDirection, k0> getSetLayoutDirection() {
            return SetLayoutDirection;
        }

        @NotNull
        public final p<ComposeUiNode, MeasurePolicy, k0> getSetMeasurePolicy() {
            return SetMeasurePolicy;
        }

        @NotNull
        public final p<ComposeUiNode, Modifier, k0> getSetModifier() {
            return SetModifier;
        }

        @NotNull
        public final p<ComposeUiNode, ViewConfiguration, k0> getSetViewConfiguration() {
            return SetViewConfiguration;
        }
    }

    @NotNull
    Density getDensity();

    @NotNull
    LayoutDirection getLayoutDirection();

    @NotNull
    MeasurePolicy getMeasurePolicy();

    @NotNull
    Modifier getModifier();

    @NotNull
    ViewConfiguration getViewConfiguration();

    void setDensity(@NotNull Density density);

    void setLayoutDirection(@NotNull LayoutDirection layoutDirection);

    void setMeasurePolicy(@NotNull MeasurePolicy measurePolicy);

    void setModifier(@NotNull Modifier modifier);

    void setViewConfiguration(@NotNull ViewConfiguration viewConfiguration);
}
