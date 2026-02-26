package androidx.compose.ui.layout;

import androidx.compose.ui.ExperimentalComposeUiApi;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Rect;
import h9.p;
import h9.q;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: RelocationModifier.kt */
/* JADX INFO: loaded from: classes.dex */
public final class RelocationModifierKt {
    @ExperimentalComposeUiApi
    @NotNull
    public static final Modifier onRelocationRequest(@NotNull Modifier modifier, @NotNull p<? super Rect, ? super LayoutCoordinates, Rect> onProvideDestination, @NotNull q<? super Rect, ? super Rect, ? super z8.d<? super k0>, ? extends Object> onPerformRelocation) {
        t.i(modifier, "<this>");
        t.i(onProvideDestination, "onProvideDestination");
        t.i(onPerformRelocation, "onPerformRelocation");
        return modifier;
    }
}
