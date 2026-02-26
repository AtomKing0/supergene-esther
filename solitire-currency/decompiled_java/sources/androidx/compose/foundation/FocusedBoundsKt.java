package androidx.compose.foundation;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.modifier.ModifierLocalKt;
import androidx.compose.ui.modifier.ProvidableModifierLocal;
import androidx.compose.ui.platform.InspectableValueKt;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: FocusedBounds.kt */
/* JADX INFO: loaded from: classes.dex */
public final class FocusedBoundsKt {

    @NotNull
    private static final ProvidableModifierLocal<h9.l<LayoutCoordinates, k0>> ModifierLocalFocusedBoundsObserver = ModifierLocalKt.modifierLocalOf(FocusedBoundsKt$ModifierLocalFocusedBoundsObserver$1.INSTANCE);

    /* JADX INFO: renamed from: androidx.compose.foundation.FocusedBoundsKt$onFocusedBoundsChanged$2, reason: invalid class name */
    /* JADX INFO: compiled from: FocusedBounds.kt */
    static final class AnonymousClass2 extends v implements h9.q<Modifier, Composer, Integer, Modifier> {
        final /* synthetic */ h9.l<LayoutCoordinates, k0> $onPositioned;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass2(h9.l<? super LayoutCoordinates, k0> lVar) {
            super(3);
            this.$onPositioned = lVar;
        }

        @Override // h9.q
        public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier, Composer composer, Integer num) {
            return invoke(modifier, composer, num.intValue());
        }

        @Composable
        @NotNull
        public final Modifier invoke(@NotNull Modifier composed, @Nullable Composer composer, int i10) {
            t.i(composed, "$this$composed");
            composer.startReplaceableGroup(1176407768);
            h9.l<LayoutCoordinates, k0> lVar = this.$onPositioned;
            composer.startReplaceableGroup(1157296644);
            boolean zChanged = composer.changed(lVar);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = new FocusedBoundsObserverModifier(lVar);
                composer.updateRememberedValue(objRememberedValue);
            }
            composer.endReplaceableGroup();
            FocusedBoundsObserverModifier focusedBoundsObserverModifier = (FocusedBoundsObserverModifier) objRememberedValue;
            composer.endReplaceableGroup();
            return focusedBoundsObserverModifier;
        }
    }

    @NotNull
    public static final ProvidableModifierLocal<h9.l<LayoutCoordinates, k0>> getModifierLocalFocusedBoundsObserver() {
        return ModifierLocalFocusedBoundsObserver;
    }

    @ExperimentalFoundationApi
    @NotNull
    public static final Modifier onFocusedBoundsChanged(@NotNull Modifier modifier, @NotNull h9.l<? super LayoutCoordinates, k0> onPositioned) {
        t.i(modifier, "<this>");
        t.i(onPositioned, "onPositioned");
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new FocusedBoundsKt$onFocusedBoundsChanged$$inlined$debugInspectorInfo$1(onPositioned) : InspectableValueKt.getNoInspectorInfo(), new AnonymousClass2(onPositioned));
    }

    public static /* synthetic */ void getModifierLocalFocusedBoundsObserver$annotations() {
    }
}
