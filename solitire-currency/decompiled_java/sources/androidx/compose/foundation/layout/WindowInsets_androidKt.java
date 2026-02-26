package androidx.compose.foundation.layout;

import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.platform.ComposeView;
import androidx.core.graphics.Insets;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: WindowInsets.android.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WindowInsets_androidKt {
    @NotNull
    public static final ValueInsets ValueInsets(@NotNull Insets insets, @NotNull String name) {
        t.i(insets, "insets");
        t.i(name, "name");
        return new ValueInsets(toInsetsValues(insets), name);
    }

    @Composable
    @ExperimentalLayoutApi
    public static final boolean getAreNavigationBarsVisible(@NotNull WindowInsets.Companion companion, @Nullable Composer composer, int i10) {
        t.i(companion, "<this>");
        composer.startReplaceableGroup(710310464);
        boolean zIsVisible = WindowInsetsHolder.Companion.current(composer, 8).getNavigationBars().isVisible();
        composer.endReplaceableGroup();
        return zIsVisible;
    }

    @Composable
    @ExperimentalLayoutApi
    public static final boolean getAreStatusBarsVisible(@NotNull WindowInsets.Companion companion, @Nullable Composer composer, int i10) {
        t.i(companion, "<this>");
        composer.startReplaceableGroup(1613283456);
        boolean zIsVisible = WindowInsetsHolder.Companion.current(composer, 8).getStatusBars().isVisible();
        composer.endReplaceableGroup();
        return zIsVisible;
    }

    @Composable
    @ExperimentalLayoutApi
    public static final boolean getAreSystemBarsVisible(@NotNull WindowInsets.Companion companion, @Nullable Composer composer, int i10) {
        t.i(companion, "<this>");
        composer.startReplaceableGroup(1985490720);
        boolean zIsVisible = WindowInsetsHolder.Companion.current(composer, 8).getSystemBars().isVisible();
        composer.endReplaceableGroup();
        return zIsVisible;
    }

    @Composable
    @NotNull
    public static final WindowInsets getCaptionBar(@NotNull WindowInsets.Companion companion, @Nullable Composer composer, int i10) {
        t.i(companion, "<this>");
        composer.startReplaceableGroup(-1832025528);
        AndroidWindowInsets captionBar = WindowInsetsHolder.Companion.current(composer, 8).getCaptionBar();
        composer.endReplaceableGroup();
        return captionBar;
    }

    @Composable
    @ExperimentalLayoutApi
    @NotNull
    public static final WindowInsets getCaptionBarIgnoringVisibility(@NotNull WindowInsets.Companion companion, @Nullable Composer composer, int i10) {
        t.i(companion, "<this>");
        composer.startReplaceableGroup(-1731251574);
        ValueInsets captionBarIgnoringVisibility = WindowInsetsHolder.Companion.current(composer, 8).getCaptionBarIgnoringVisibility();
        composer.endReplaceableGroup();
        return captionBarIgnoringVisibility;
    }

    public static final boolean getConsumeWindowInsets(@NotNull ComposeView composeView) {
        t.i(composeView, "<this>");
        Object tag = composeView.getTag(androidx.compose.ui.R.id.consume_window_insets_tag);
        Boolean bool = tag instanceof Boolean ? (Boolean) tag : null;
        if (bool != null) {
            return bool.booleanValue();
        }
        return true;
    }

    @Composable
    @NotNull
    public static final WindowInsets getDisplayCutout(@NotNull WindowInsets.Companion companion, @Nullable Composer composer, int i10) {
        t.i(companion, "<this>");
        composer.startReplaceableGroup(1324817724);
        AndroidWindowInsets displayCutout = WindowInsetsHolder.Companion.current(composer, 8).getDisplayCutout();
        composer.endReplaceableGroup();
        return displayCutout;
    }

    @Composable
    @NotNull
    public static final WindowInsets getIme(@NotNull WindowInsets.Companion companion, @Nullable Composer composer, int i10) {
        t.i(companion, "<this>");
        composer.startReplaceableGroup(-1466917860);
        AndroidWindowInsets ime = WindowInsetsHolder.Companion.current(composer, 8).getIme();
        composer.endReplaceableGroup();
        return ime;
    }

    @Composable
    @NotNull
    public static final WindowInsets getMandatorySystemGestures(@NotNull WindowInsets.Companion companion, @Nullable Composer composer, int i10) {
        t.i(companion, "<this>");
        composer.startReplaceableGroup(1369492988);
        AndroidWindowInsets mandatorySystemGestures = WindowInsetsHolder.Companion.current(composer, 8).getMandatorySystemGestures();
        composer.endReplaceableGroup();
        return mandatorySystemGestures;
    }

    @Composable
    @NotNull
    public static final WindowInsets getNavigationBars(@NotNull WindowInsets.Companion companion, @Nullable Composer composer, int i10) {
        t.i(companion, "<this>");
        composer.startReplaceableGroup(1596175702);
        AndroidWindowInsets navigationBars = WindowInsetsHolder.Companion.current(composer, 8).getNavigationBars();
        composer.endReplaceableGroup();
        return navigationBars;
    }

    @Composable
    @ExperimentalLayoutApi
    @NotNull
    public static final WindowInsets getNavigationBarsIgnoringVisibility(@NotNull WindowInsets.Companion companion, @Nullable Composer composer, int i10) {
        t.i(companion, "<this>");
        composer.startReplaceableGroup(-1990981160);
        ValueInsets navigationBarsIgnoringVisibility = WindowInsetsHolder.Companion.current(composer, 8).getNavigationBarsIgnoringVisibility();
        composer.endReplaceableGroup();
        return navigationBarsIgnoringVisibility;
    }

    @Composable
    @NotNull
    public static final WindowInsets getSafeContent(@NotNull WindowInsets.Companion companion, @Nullable Composer composer, int i10) {
        t.i(companion, "<this>");
        composer.startReplaceableGroup(-2026663876);
        WindowInsets safeContent = WindowInsetsHolder.Companion.current(composer, 8).getSafeContent();
        composer.endReplaceableGroup();
        return safeContent;
    }

    @Composable
    @NotNull
    public static final WindowInsets getSafeDrawing(@NotNull WindowInsets.Companion companion, @Nullable Composer composer, int i10) {
        t.i(companion, "<this>");
        composer.startReplaceableGroup(-49441252);
        WindowInsets safeDrawing = WindowInsetsHolder.Companion.current(composer, 8).getSafeDrawing();
        composer.endReplaceableGroup();
        return safeDrawing;
    }

    @Composable
    @NotNull
    public static final WindowInsets getSafeGestures(@NotNull WindowInsets.Companion companion, @Nullable Composer composer, int i10) {
        t.i(companion, "<this>");
        composer.startReplaceableGroup(-1594247780);
        WindowInsets safeGestures = WindowInsetsHolder.Companion.current(composer, 8).getSafeGestures();
        composer.endReplaceableGroup();
        return safeGestures;
    }

    @Composable
    @NotNull
    public static final WindowInsets getStatusBars(@NotNull WindowInsets.Companion companion, @Nullable Composer composer, int i10) {
        t.i(companion, "<this>");
        composer.startReplaceableGroup(-675090670);
        AndroidWindowInsets statusBars = WindowInsetsHolder.Companion.current(composer, 8).getStatusBars();
        composer.endReplaceableGroup();
        return statusBars;
    }

    @Composable
    @ExperimentalLayoutApi
    @NotNull
    public static final WindowInsets getStatusBarsIgnoringVisibility(@NotNull WindowInsets.Companion companion, @Nullable Composer composer, int i10) {
        t.i(companion, "<this>");
        composer.startReplaceableGroup(594020756);
        ValueInsets statusBarsIgnoringVisibility = WindowInsetsHolder.Companion.current(composer, 8).getStatusBarsIgnoringVisibility();
        composer.endReplaceableGroup();
        return statusBarsIgnoringVisibility;
    }

    @Composable
    @NotNull
    public static final WindowInsets getSystemBars(@NotNull WindowInsets.Companion companion, @Nullable Composer composer, int i10) {
        t.i(companion, "<this>");
        composer.startReplaceableGroup(-282936756);
        AndroidWindowInsets systemBars = WindowInsetsHolder.Companion.current(composer, 8).getSystemBars();
        composer.endReplaceableGroup();
        return systemBars;
    }

    @Composable
    @ExperimentalLayoutApi
    @NotNull
    public static final WindowInsets getSystemBarsIgnoringVisibility(@NotNull WindowInsets.Companion companion, @Nullable Composer composer, int i10) {
        t.i(companion, "<this>");
        composer.startReplaceableGroup(1564566798);
        ValueInsets systemBarsIgnoringVisibility = WindowInsetsHolder.Companion.current(composer, 8).getSystemBarsIgnoringVisibility();
        composer.endReplaceableGroup();
        return systemBarsIgnoringVisibility;
    }

    @Composable
    @NotNull
    public static final WindowInsets getSystemGestures(@NotNull WindowInsets.Companion companion, @Nullable Composer composer, int i10) {
        t.i(companion, "<this>");
        composer.startReplaceableGroup(989216224);
        AndroidWindowInsets systemGestures = WindowInsetsHolder.Companion.current(composer, 8).getSystemGestures();
        composer.endReplaceableGroup();
        return systemGestures;
    }

    @Composable
    @NotNull
    public static final WindowInsets getTappableElement(@NotNull WindowInsets.Companion companion, @Nullable Composer composer, int i10) {
        t.i(companion, "<this>");
        composer.startReplaceableGroup(-1994205284);
        AndroidWindowInsets tappableElement = WindowInsetsHolder.Companion.current(composer, 8).getTappableElement();
        composer.endReplaceableGroup();
        return tappableElement;
    }

    @Composable
    @ExperimentalLayoutApi
    @NotNull
    public static final WindowInsets getTappableElementIgnoringVisibility(@NotNull WindowInsets.Companion companion, @Nullable Composer composer, int i10) {
        t.i(companion, "<this>");
        composer.startReplaceableGroup(-1488788292);
        ValueInsets tappableElementIgnoringVisibility = WindowInsetsHolder.Companion.current(composer, 8).getTappableElementIgnoringVisibility();
        composer.endReplaceableGroup();
        return tappableElementIgnoringVisibility;
    }

    @Composable
    @NotNull
    public static final WindowInsets getWaterfall(@NotNull WindowInsets.Companion companion, @Nullable Composer composer, int i10) {
        t.i(companion, "<this>");
        composer.startReplaceableGroup(1943241020);
        ValueInsets waterfall = WindowInsetsHolder.Companion.current(composer, 8).getWaterfall();
        composer.endReplaceableGroup();
        return waterfall;
    }

    @Composable
    @ExperimentalLayoutApi
    public static final boolean isCaptionBarVisible(@NotNull WindowInsets.Companion companion, @Nullable Composer composer, int i10) {
        t.i(companion, "<this>");
        composer.startReplaceableGroup(-501076620);
        boolean zIsVisible = WindowInsetsHolder.Companion.current(composer, 8).getCaptionBar().isVisible();
        composer.endReplaceableGroup();
        return zIsVisible;
    }

    @Composable
    @ExperimentalLayoutApi
    public static final boolean isImeVisible(@NotNull WindowInsets.Companion companion, @Nullable Composer composer, int i10) {
        t.i(companion, "<this>");
        composer.startReplaceableGroup(-1873571424);
        boolean zIsVisible = WindowInsetsHolder.Companion.current(composer, 8).getIme().isVisible();
        composer.endReplaceableGroup();
        return zIsVisible;
    }

    @Composable
    @ExperimentalLayoutApi
    public static final boolean isTappableElementVisible(@NotNull WindowInsets.Companion companion, @Nullable Composer composer, int i10) {
        t.i(companion, "<this>");
        composer.startReplaceableGroup(-1737201120);
        boolean zIsVisible = WindowInsetsHolder.Companion.current(composer, 8).getTappableElement().isVisible();
        composer.endReplaceableGroup();
        return zIsVisible;
    }

    public static final void setConsumeWindowInsets(@NotNull ComposeView composeView, boolean z10) {
        t.i(composeView, "<this>");
        composeView.setTag(androidx.compose.ui.R.id.consume_window_insets_tag, Boolean.valueOf(z10));
    }

    @NotNull
    public static final InsetsValues toInsetsValues(@NotNull Insets insets) {
        t.i(insets, "<this>");
        return new InsetsValues(insets.left, insets.top, insets.right, insets.bottom);
    }

    @ExperimentalLayoutApi
    public static /* synthetic */ void getAreNavigationBarsVisible$annotations(WindowInsets.Companion companion) {
    }

    @ExperimentalLayoutApi
    public static /* synthetic */ void getAreStatusBarsVisible$annotations(WindowInsets.Companion companion) {
    }

    @ExperimentalLayoutApi
    public static /* synthetic */ void getAreSystemBarsVisible$annotations(WindowInsets.Companion companion) {
    }

    @ExperimentalLayoutApi
    public static /* synthetic */ void getCaptionBarIgnoringVisibility$annotations(WindowInsets.Companion companion) {
    }

    @ExperimentalLayoutApi
    public static /* synthetic */ void getNavigationBarsIgnoringVisibility$annotations(WindowInsets.Companion companion) {
    }

    @ExperimentalLayoutApi
    public static /* synthetic */ void getStatusBarsIgnoringVisibility$annotations(WindowInsets.Companion companion) {
    }

    @ExperimentalLayoutApi
    public static /* synthetic */ void getSystemBarsIgnoringVisibility$annotations(WindowInsets.Companion companion) {
    }

    @ExperimentalLayoutApi
    public static /* synthetic */ void getTappableElementIgnoringVisibility$annotations(WindowInsets.Companion companion) {
    }

    @ExperimentalLayoutApi
    public static /* synthetic */ void isCaptionBarVisible$annotations(WindowInsets.Companion companion) {
    }

    @ExperimentalLayoutApi
    public static /* synthetic */ void isImeVisible$annotations(WindowInsets.Companion companion) {
    }

    @ExperimentalLayoutApi
    public static /* synthetic */ void isTappableElementVisible$annotations(WindowInsets.Companion companion) {
    }
}
