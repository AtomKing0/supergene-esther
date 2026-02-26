package androidx.compose.foundation.text;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.text.input.TransformedText;
import androidx.compose.ui.unit.LayoutDirection;
import h9.l;
import j9.c;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: TextFieldScroll.kt */
/* JADX INFO: loaded from: classes.dex */
final class HorizontalScrollLayoutModifier$measure$1 extends v implements l<Placeable.PlacementScope, k0> {
    final /* synthetic */ Placeable $placeable;
    final /* synthetic */ MeasureScope $this_measure;
    final /* synthetic */ int $width;
    final /* synthetic */ HorizontalScrollLayoutModifier this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HorizontalScrollLayoutModifier$measure$1(MeasureScope measureScope, HorizontalScrollLayoutModifier horizontalScrollLayoutModifier, Placeable placeable, int i10) {
        super(1);
        this.$this_measure = measureScope;
        this.this$0 = horizontalScrollLayoutModifier;
        this.$placeable = placeable;
        this.$width = i10;
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ k0 invoke(Placeable.PlacementScope placementScope) {
        invoke2(placementScope);
        return k0.f35197a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull Placeable.PlacementScope layout) {
        t.i(layout, "$this$layout");
        MeasureScope measureScope = this.$this_measure;
        int cursorOffset = this.this$0.getCursorOffset();
        TransformedText transformedText = this.this$0.getTransformedText();
        TextLayoutResultProxy textLayoutResultProxyInvoke = this.this$0.getTextLayoutResultProvider().invoke();
        this.this$0.getScrollerPosition().update(Orientation.Horizontal, TextFieldScrollKt.getCursorRectInScroller(measureScope, cursorOffset, transformedText, textLayoutResultProxyInvoke != null ? textLayoutResultProxyInvoke.getValue() : null, this.$this_measure.getLayoutDirection() == LayoutDirection.Rtl, this.$placeable.getWidth()), this.$width, this.$placeable.getWidth());
        Placeable.PlacementScope.placeRelative$default(layout, this.$placeable, c.c(-this.this$0.getScrollerPosition().getOffset()), 0, 0.0f, 4, null);
    }
}
