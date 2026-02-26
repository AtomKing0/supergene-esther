package androidx.activity;

import android.view.View;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ViewTreeFullyLoadedReporterOwner.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ViewTreeFullyDrawnReporterOwner {
    @Nullable
    public static final FullyDrawnReporterOwner get(@NotNull View view) {
        t.i(view, "<this>");
        return (FullyDrawnReporterOwner) o9.o.n(o9.o.t(o9.m.f(view, ViewTreeFullyDrawnReporterOwner$findViewTreeFullyDrawnReporterOwner$1.INSTANCE), ViewTreeFullyDrawnReporterOwner$findViewTreeFullyDrawnReporterOwner$2.INSTANCE));
    }

    public static final void set(@NotNull View view, @NotNull FullyDrawnReporterOwner fullyDrawnReporterOwner) {
        t.i(view, "<this>");
        t.i(fullyDrawnReporterOwner, "fullyDrawnReporterOwner");
        view.setTag(R.id.report_drawn, fullyDrawnReporterOwner);
    }
}
