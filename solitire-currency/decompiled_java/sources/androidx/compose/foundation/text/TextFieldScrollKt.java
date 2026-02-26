package androidx.compose.foundation.text;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.TransformedText;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.unit.Density;
import h9.a;
import h9.q;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: TextFieldScroll.kt */
/* JADX INFO: loaded from: classes.dex */
public final class TextFieldScrollKt {

    /* JADX INFO: compiled from: TextFieldScroll.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Orientation.values().length];
            iArr[Orientation.Vertical.ordinal()] = 1;
            iArr[Orientation.Horizontal.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.TextFieldScrollKt$textFieldScrollable$2, reason: invalid class name */
    /* JADX INFO: compiled from: TextFieldScroll.kt */
    static final class AnonymousClass2 extends v implements q<Modifier, Composer, Integer, Modifier> {
        final /* synthetic */ boolean $enabled;
        final /* synthetic */ MutableInteractionSource $interactionSource;
        final /* synthetic */ TextFieldScrollerPosition $scrollerPosition;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(TextFieldScrollerPosition textFieldScrollerPosition, boolean z10, MutableInteractionSource mutableInteractionSource) {
            super(3);
            this.$scrollerPosition = textFieldScrollerPosition;
            this.$enabled = z10;
            this.$interactionSource = mutableInteractionSource;
        }

        @Override // h9.q
        public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier, Composer composer, Integer num) {
            return invoke(modifier, composer, num.intValue());
        }

        /* JADX WARN: Removed duplicated region for block: B:20:0x0055  */
        @androidx.compose.runtime.Composable
        @org.jetbrains.annotations.NotNull
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final androidx.compose.ui.Modifier invoke(@org.jetbrains.annotations.NotNull androidx.compose.ui.Modifier r13, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r14, int r15) {
            /*
                r12 = this;
                java.lang.String r15 = "$this$composed"
                kotlin.jvm.internal.t.i(r13, r15)
                r13 = 805428266(0x3001dc2a, float:4.72428E-10)
                r14.startReplaceableGroup(r13)
                androidx.compose.runtime.ProvidableCompositionLocal r13 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
                java.lang.Object r13 = r14.consume(r13)
                androidx.compose.ui.unit.LayoutDirection r15 = androidx.compose.ui.unit.LayoutDirection.Rtl
                r0 = 1
                r1 = 0
                if (r13 != r15) goto L1b
                r13 = r0
                goto L1c
            L1b:
                r13 = r1
            L1c:
                androidx.compose.foundation.text.TextFieldScrollerPosition r15 = r12.$scrollerPosition
                androidx.compose.foundation.gestures.Orientation r15 = r15.getOrientation()
                androidx.compose.foundation.gestures.Orientation r2 = androidx.compose.foundation.gestures.Orientation.Vertical
                if (r15 == r2) goto L2b
                if (r13 != 0) goto L29
                goto L2b
            L29:
                r7 = r1
                goto L2c
            L2b:
                r7 = r0
            L2c:
                androidx.compose.foundation.text.TextFieldScrollKt$textFieldScrollable$2$controller$1 r13 = new androidx.compose.foundation.text.TextFieldScrollKt$textFieldScrollable$2$controller$1
                androidx.compose.foundation.text.TextFieldScrollerPosition r15 = r12.$scrollerPosition
                r13.<init>(r15)
                androidx.compose.foundation.gestures.ScrollableState r4 = androidx.compose.foundation.gestures.ScrollableStateKt.rememberScrollableState(r13, r14, r1)
                androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.Companion
                androidx.compose.foundation.text.TextFieldScrollerPosition r13 = r12.$scrollerPosition
                androidx.compose.foundation.gestures.Orientation r5 = r13.getOrientation()
                boolean r13 = r12.$enabled
                if (r13 == 0) goto L55
                androidx.compose.foundation.text.TextFieldScrollerPosition r13 = r12.$scrollerPosition
                float r13 = r13.getMaximum()
                r15 = 0
                int r13 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
                if (r13 != 0) goto L50
                r13 = r0
                goto L51
            L50:
                r13 = r1
            L51:
                if (r13 != 0) goto L55
                r6 = r0
                goto L56
            L55:
                r6 = r1
            L56:
                r8 = 0
                androidx.compose.foundation.interaction.MutableInteractionSource r9 = r12.$interactionSource
                r10 = 16
                r11 = 0
                androidx.compose.ui.Modifier r13 = androidx.compose.foundation.gestures.ScrollableKt.scrollable$default(r3, r4, r5, r6, r7, r8, r9, r10, r11)
                r14.endReplaceableGroup()
                return r13
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.TextFieldScrollKt.AnonymousClass2.invoke(androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int):androidx.compose.ui.Modifier");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Rect getCursorRectInScroller(Density density, int i10, TransformedText transformedText, TextLayoutResult textLayoutResult, boolean z10, int i11) {
        Rect zero;
        if (textLayoutResult == null || (zero = textLayoutResult.getCursorRect(transformedText.getOffsetMapping().originalToTransformed(i10))) == null) {
            zero = Rect.Companion.getZero();
        }
        Rect rect = zero;
        int iMo290roundToPx0680j_4 = density.mo290roundToPx0680j_4(TextFieldCursorKt.getDefaultCursorThickness());
        return Rect.copy$default(rect, z10 ? (i11 - rect.getLeft()) - iMo290roundToPx0680j_4 : rect.getLeft(), 0.0f, z10 ? i11 - rect.getLeft() : rect.getLeft() + iMo290roundToPx0680j_4, 0.0f, 10, null);
    }

    @NotNull
    public static final Modifier textFieldScroll(@NotNull Modifier modifier, @NotNull TextFieldScrollerPosition scrollerPosition, @NotNull TextFieldValue textFieldValue, @NotNull VisualTransformation visualTransformation, @NotNull a<TextLayoutResultProxy> textLayoutResultProvider) {
        Modifier verticalScrollLayoutModifier;
        t.i(modifier, "<this>");
        t.i(scrollerPosition, "scrollerPosition");
        t.i(textFieldValue, "textFieldValue");
        t.i(visualTransformation, "visualTransformation");
        t.i(textLayoutResultProvider, "textLayoutResultProvider");
        Orientation orientation = scrollerPosition.getOrientation();
        int iM732getOffsetToFollow5zctL8 = scrollerPosition.m732getOffsetToFollow5zctL8(textFieldValue.m3510getSelectiond9O1mEE());
        scrollerPosition.m734setPreviousSelection5zctL8(textFieldValue.m3510getSelectiond9O1mEE());
        TransformedText transformedTextFilter = visualTransformation.filter(textFieldValue.getAnnotatedString());
        int i10 = WhenMappings.$EnumSwitchMapping$0[orientation.ordinal()];
        if (i10 == 1) {
            verticalScrollLayoutModifier = new VerticalScrollLayoutModifier(scrollerPosition, iM732getOffsetToFollow5zctL8, transformedTextFilter, textLayoutResultProvider);
        } else {
            if (i10 != 2) {
                throw new v8.q();
            }
            verticalScrollLayoutModifier = new HorizontalScrollLayoutModifier(scrollerPosition, iM732getOffsetToFollow5zctL8, transformedTextFilter, textLayoutResultProvider);
        }
        return ClipKt.clipToBounds(modifier).then(verticalScrollLayoutModifier);
    }

    @NotNull
    public static final Modifier textFieldScrollable(@NotNull Modifier modifier, @NotNull TextFieldScrollerPosition scrollerPosition, @Nullable MutableInteractionSource mutableInteractionSource, boolean z10) {
        t.i(modifier, "<this>");
        t.i(scrollerPosition, "scrollerPosition");
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new TextFieldScrollKt$textFieldScrollable$$inlined$debugInspectorInfo$1(scrollerPosition, mutableInteractionSource, z10) : InspectableValueKt.getNoInspectorInfo(), new AnonymousClass2(scrollerPosition, z10, mutableInteractionSource));
    }

    public static /* synthetic */ Modifier textFieldScrollable$default(Modifier modifier, TextFieldScrollerPosition textFieldScrollerPosition, MutableInteractionSource mutableInteractionSource, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            mutableInteractionSource = null;
        }
        if ((i10 & 4) != 0) {
            z10 = true;
        }
        return textFieldScrollable(modifier, textFieldScrollerPosition, mutableInteractionSource, z10);
    }
}
