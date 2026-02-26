package androidx.compose.material;

import androidx.compose.runtime.Stable;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: BottomSheetScaffold.kt */
/* JADX INFO: loaded from: classes.dex */
@Stable
@ExperimentalMaterialApi
public final class BottomSheetScaffoldState {

    @NotNull
    private final BottomSheetState bottomSheetState;

    @NotNull
    private final DrawerState drawerState;

    @NotNull
    private final SnackbarHostState snackbarHostState;

    public BottomSheetScaffoldState(@NotNull DrawerState drawerState, @NotNull BottomSheetState bottomSheetState, @NotNull SnackbarHostState snackbarHostState) {
        t.i(drawerState, "drawerState");
        t.i(bottomSheetState, "bottomSheetState");
        t.i(snackbarHostState, "snackbarHostState");
        this.drawerState = drawerState;
        this.bottomSheetState = bottomSheetState;
        this.snackbarHostState = snackbarHostState;
    }

    @NotNull
    public final BottomSheetState getBottomSheetState() {
        return this.bottomSheetState;
    }

    @NotNull
    public final DrawerState getDrawerState() {
        return this.drawerState;
    }

    @NotNull
    public final SnackbarHostState getSnackbarHostState() {
        return this.snackbarHostState;
    }
}
