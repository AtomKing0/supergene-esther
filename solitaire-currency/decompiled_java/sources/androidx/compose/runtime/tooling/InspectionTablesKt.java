package androidx.compose.runtime.tooling;

import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import java.util.Set;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: InspectionTables.kt */
/* JADX INFO: loaded from: classes.dex */
public final class InspectionTablesKt {

    @NotNull
    private static final ProvidableCompositionLocal<Set<CompositionData>> LocalInspectionTables = CompositionLocalKt.staticCompositionLocalOf(InspectionTablesKt$LocalInspectionTables$1.INSTANCE);

    @NotNull
    public static final ProvidableCompositionLocal<Set<CompositionData>> getLocalInspectionTables() {
        return LocalInspectionTables;
    }
}
