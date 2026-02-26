package androidx.window.layout;

import androidx.annotation.RestrictTo;
import androidx.window.core.ExperimentalWindowApi;
import androidx.window.layout.WindowMetricsCalculator;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: WindowMetricsCalculator.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class g {
    static {
        WindowMetricsCalculator.Companion companion = WindowMetricsCalculator.Companion;
    }

    @NotNull
    public static WindowMetricsCalculator a() {
        return WindowMetricsCalculator.Companion.getOrCreate();
    }

    @ExperimentalWindowApi
    @RestrictTo({RestrictTo.Scope.TESTS})
    public static void b(@NotNull WindowMetricsCalculatorDecorator windowMetricsCalculatorDecorator) {
        WindowMetricsCalculator.Companion.overrideDecorator(windowMetricsCalculatorDecorator);
    }

    @ExperimentalWindowApi
    @RestrictTo({RestrictTo.Scope.TESTS})
    public static void c() {
        WindowMetricsCalculator.Companion.reset();
    }
}
