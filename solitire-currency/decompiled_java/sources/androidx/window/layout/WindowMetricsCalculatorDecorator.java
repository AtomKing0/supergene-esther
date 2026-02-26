package androidx.window.layout;

import androidx.annotation.RestrictTo;
import androidx.window.core.ExperimentalWindowApi;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: WindowMetricsCalculator.kt */
/* JADX INFO: loaded from: classes2.dex */
@ExperimentalWindowApi
@RestrictTo({RestrictTo.Scope.TESTS})
public interface WindowMetricsCalculatorDecorator {
    @ExperimentalWindowApi
    @RestrictTo({RestrictTo.Scope.TESTS})
    @NotNull
    WindowMetricsCalculator decorate(@NotNull WindowMetricsCalculator windowMetricsCalculator);
}
