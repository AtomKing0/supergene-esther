package androidx.compose.ui.res;

import android.content.Context;
import androidx.annotation.ArrayRes;
import androidx.annotation.BoolRes;
import androidx.annotation.DimenRes;
import androidx.annotation.IntegerRes;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ReadOnlyComposable;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: PrimitiveResources.android.kt */
/* JADX INFO: loaded from: classes.dex */
public final class PrimitiveResources_androidKt {
    @Composable
    @ReadOnlyComposable
    public static final boolean booleanResource(@BoolRes int i10, @Nullable Composer composer, int i11) {
        return ((Context) composer.consume(AndroidCompositionLocals_androidKt.getLocalContext())).getResources().getBoolean(i10);
    }

    @Composable
    @ReadOnlyComposable
    public static final float dimensionResource(@DimenRes int i10, @Nullable Composer composer, int i11) {
        return Dp.m3673constructorimpl(((Context) composer.consume(AndroidCompositionLocals_androidKt.getLocalContext())).getResources().getDimension(i10) / ((Density) composer.consume(CompositionLocalsKt.getLocalDensity())).getDensity());
    }

    @Composable
    @ReadOnlyComposable
    @NotNull
    public static final int[] integerArrayResource(@ArrayRes int i10, @Nullable Composer composer, int i11) {
        int[] intArray = ((Context) composer.consume(AndroidCompositionLocals_androidKt.getLocalContext())).getResources().getIntArray(i10);
        t.h(intArray, "context.resources.getIntArray(id)");
        return intArray;
    }

    @Composable
    @ReadOnlyComposable
    public static final int integerResource(@IntegerRes int i10, @Nullable Composer composer, int i11) {
        return ((Context) composer.consume(AndroidCompositionLocals_androidKt.getLocalContext())).getResources().getInteger(i10);
    }
}
