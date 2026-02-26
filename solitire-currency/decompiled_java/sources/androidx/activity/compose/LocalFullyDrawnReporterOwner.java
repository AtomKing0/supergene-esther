package androidx.activity.compose;

import android.content.Context;
import android.content.ContextWrapper;
import android.view.View;
import androidx.activity.FullyDrawnReporterOwner;
import androidx.activity.ViewTreeFullyDrawnReporterOwner;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ReportDrawn.kt */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
public final class LocalFullyDrawnReporterOwner {
    public static final int $stable = 0;

    @NotNull
    public static final LocalFullyDrawnReporterOwner INSTANCE = new LocalFullyDrawnReporterOwner();

    @NotNull
    private static final ProvidableCompositionLocal<FullyDrawnReporterOwner> LocalFullyDrawnReporterOwner = CompositionLocalKt.compositionLocalOf$default(null, LocalFullyDrawnReporterOwner$LocalFullyDrawnReporterOwner$1.INSTANCE, 1, null);

    private LocalFullyDrawnReporterOwner() {
    }

    @Composable
    @Nullable
    public final FullyDrawnReporterOwner getCurrent(@Nullable Composer composer, int i10) {
        composer.startReplaceableGroup(540186968);
        FullyDrawnReporterOwner fullyDrawnReporterOwner = (FullyDrawnReporterOwner) composer.consume(LocalFullyDrawnReporterOwner);
        composer.startReplaceableGroup(1606493384);
        if (fullyDrawnReporterOwner == null) {
            fullyDrawnReporterOwner = ViewTreeFullyDrawnReporterOwner.get((View) composer.consume(AndroidCompositionLocals_androidKt.getLocalView()));
        }
        composer.endReplaceableGroup();
        if (fullyDrawnReporterOwner == null) {
            Object baseContext = (Context) composer.consume(AndroidCompositionLocals_androidKt.getLocalContext());
            while (true) {
                if (!(baseContext instanceof ContextWrapper)) {
                    baseContext = null;
                    break;
                }
                if (baseContext instanceof FullyDrawnReporterOwner) {
                    break;
                }
                baseContext = ((ContextWrapper) baseContext).getBaseContext();
            }
            fullyDrawnReporterOwner = (FullyDrawnReporterOwner) baseContext;
        }
        composer.endReplaceableGroup();
        return fullyDrawnReporterOwner;
    }

    @NotNull
    public final ProvidedValue<FullyDrawnReporterOwner> provides(@NotNull FullyDrawnReporterOwner fullyDrawnReporterOwner) {
        return LocalFullyDrawnReporterOwner.provides(fullyDrawnReporterOwner);
    }
}
