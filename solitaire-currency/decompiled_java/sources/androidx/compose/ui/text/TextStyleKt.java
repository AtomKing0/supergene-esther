package androidx.compose.ui.text;

import androidx.compose.ui.text.style.TextDirection;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.q;

/* JADX INFO: compiled from: TextStyle.kt */
/* JADX INFO: loaded from: classes.dex */
public final class TextStyleKt {

    /* JADX INFO: compiled from: TextStyle.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LayoutDirection.values().length];
            iArr[LayoutDirection.Ltr.ordinal()] = 1;
            iArr[LayoutDirection.Rtl.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PlatformTextStyle createPlatformTextStyleInternal(PlatformSpanStyle platformSpanStyle, PlatformParagraphStyle platformParagraphStyle) {
        if (platformSpanStyle == null && platformParagraphStyle == null) {
            return null;
        }
        return AndroidTextStyle_androidKt.createPlatformTextStyle(platformSpanStyle, platformParagraphStyle);
    }

    @NotNull
    public static final TextStyle lerp(@NotNull TextStyle start, @NotNull TextStyle stop, float f10) {
        t.i(start, "start");
        t.i(stop, "stop");
        return new TextStyle(SpanStyleKt.lerp(start.toSpanStyle(), stop.toSpanStyle(), f10), ParagraphStyleKt.lerp(start.toParagraphStyle(), stop.toParagraphStyle(), f10));
    }

    @NotNull
    public static final TextStyle resolveDefaults(@NotNull TextStyle style, @NotNull LayoutDirection direction) {
        t.i(style, "style");
        t.i(direction, "direction");
        return new TextStyle(SpanStyleKt.resolveSpanStyleDefaults(style.getSpanStyle$ui_text_release()), ParagraphStyleKt.resolveParagraphStyleDefaults(style.getParagraphStyle$ui_text_release(), direction), style.getPlatformStyle());
    }

    /* JADX INFO: renamed from: resolveTextDirection-Yj3eThk, reason: not valid java name */
    public static final int m3359resolveTextDirectionYj3eThk(@NotNull LayoutDirection layoutDirection, @Nullable TextDirection textDirection) {
        t.i(layoutDirection, "layoutDirection");
        TextDirection.Companion companion = TextDirection.Companion;
        if (textDirection == null ? false : TextDirection.m3602equalsimpl0(textDirection.m3605unboximpl(), companion.m3606getContents_7Xco())) {
            int i10 = WhenMappings.$EnumSwitchMapping$0[layoutDirection.ordinal()];
            if (i10 == 1) {
                return companion.m3607getContentOrLtrs_7Xco();
            }
            if (i10 == 2) {
                return companion.m3608getContentOrRtls_7Xco();
            }
            throw new q();
        }
        if (textDirection != null) {
            return textDirection.m3605unboximpl();
        }
        int i11 = WhenMappings.$EnumSwitchMapping$0[layoutDirection.ordinal()];
        if (i11 == 1) {
            return companion.m3609getLtrs_7Xco();
        }
        if (i11 == 2) {
            return companion.m3610getRtls_7Xco();
        }
        throw new q();
    }
}
