package androidx.compose.foundation.relocation;

import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.platform.InspectableValueKt;
import h9.q;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: BringIntoViewResponder.kt */
/* JADX INFO: loaded from: classes.dex */
public final class BringIntoViewResponderKt {

    /* JADX INFO: renamed from: androidx.compose.foundation.relocation.BringIntoViewResponderKt$bringIntoViewResponder$2, reason: invalid class name */
    /* JADX INFO: compiled from: BringIntoViewResponder.kt */
    static final class AnonymousClass2 extends v implements q<Modifier, Composer, Integer, Modifier> {
        final /* synthetic */ BringIntoViewResponder $responder;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(BringIntoViewResponder bringIntoViewResponder) {
            super(3);
            this.$responder = bringIntoViewResponder;
        }

        @Override // h9.q
        public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier, Composer composer, Integer num) {
            return invoke(modifier, composer, num.intValue());
        }

        @Composable
        @NotNull
        public final Modifier invoke(@NotNull Modifier composed, @Nullable Composer composer, int i10) {
            t.i(composed, "$this$composed");
            composer.startReplaceableGroup(-852052847);
            BringIntoViewParent bringIntoViewParentRememberDefaultBringIntoViewParent = BringIntoViewResponder_androidKt.rememberDefaultBringIntoViewParent(composer, 0);
            composer.startReplaceableGroup(1157296644);
            boolean zChanged = composer.changed(bringIntoViewParentRememberDefaultBringIntoViewParent);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = new BringIntoViewResponderModifier(bringIntoViewParentRememberDefaultBringIntoViewParent);
                composer.updateRememberedValue(objRememberedValue);
            }
            composer.endReplaceableGroup();
            BringIntoViewResponderModifier bringIntoViewResponderModifier = (BringIntoViewResponderModifier) objRememberedValue;
            bringIntoViewResponderModifier.setResponder(this.$responder);
            composer.endReplaceableGroup();
            return bringIntoViewResponderModifier;
        }
    }

    @ExperimentalFoundationApi
    @NotNull
    public static final Modifier bringIntoViewResponder(@NotNull Modifier modifier, @NotNull BringIntoViewResponder responder) {
        t.i(modifier, "<this>");
        t.i(responder, "responder");
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new BringIntoViewResponderKt$bringIntoViewResponder$$inlined$debugInspectorInfo$1(responder) : InspectableValueKt.getNoInspectorInfo(), new AnonymousClass2(responder));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean completelyOverlaps(Rect rect, Rect rect2) {
        return rect.getLeft() <= rect2.getLeft() && rect.getTop() <= rect2.getTop() && rect.getRight() >= rect2.getRight() && rect.getBottom() >= rect2.getBottom();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Rect localRectOf(LayoutCoordinates layoutCoordinates, LayoutCoordinates layoutCoordinates2, Rect rect) {
        return rect.m1404translatek4lQ0M(layoutCoordinates.localBoundingBoxOf(layoutCoordinates2, false).m1402getTopLeftF1C5BW0());
    }
}
