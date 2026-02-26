package androidx.compose.material;

import androidx.compose.runtime.Stable;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Scaffold.kt */
/* JADX INFO: loaded from: classes.dex */
@Stable
public final class ScaffoldState {

    @NotNull
    private final DrawerState drawerState;

    @NotNull
    private final SnackbarHostState snackbarHostState;

    public ScaffoldState(@NotNull DrawerState drawerState, @NotNull SnackbarHostState snackbarHostState) {
        t.i(drawerState, "drawerState");
        t.i(snackbarHostState, "snackbarHostState");
        this.drawerState = drawerState;
        this.snackbarHostState = snackbarHostState;
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
