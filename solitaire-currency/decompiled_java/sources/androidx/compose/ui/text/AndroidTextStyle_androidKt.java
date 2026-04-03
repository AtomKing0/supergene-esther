package androidx.compose.ui.text;

import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: AndroidTextStyle.android.kt */
/* JADX INFO: loaded from: classes.dex */
public final class AndroidTextStyle_androidKt {
    public static final boolean DefaultIncludeFontPadding = true;

    @NotNull
    public static final PlatformTextStyle createPlatformTextStyle(@Nullable PlatformSpanStyle platformSpanStyle, @Nullable PlatformParagraphStyle platformParagraphStyle) {
        return new PlatformTextStyle(platformSpanStyle, platformParagraphStyle);
    }

    @ExperimentalTextApi
    @NotNull
    public static final PlatformSpanStyle lerp(@NotNull PlatformSpanStyle start, @NotNull PlatformSpanStyle stop, float f10) {
        t.i(start, "start");
        t.i(stop, "stop");
        return start;
    }

    @ExperimentalTextApi
    @NotNull
    public static final PlatformParagraphStyle lerp(@NotNull PlatformParagraphStyle start, @NotNull PlatformParagraphStyle stop, float f10) {
        t.i(start, "start");
        t.i(stop, "stop");
        return start.getIncludeFontPadding() == stop.getIncludeFontPadding() ? start : new PlatformParagraphStyle(((Boolean) SpanStyleKt.lerpDiscrete(Boolean.valueOf(start.getIncludeFontPadding()), Boolean.valueOf(stop.getIncludeFontPadding()), f10)).booleanValue());
    }
}
