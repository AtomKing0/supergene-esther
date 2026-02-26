package androidx.compose.runtime.internal;

import androidx.compose.runtime.ComposeCompilerApi;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScope;
import androidx.compose.runtime.RecomposeScopeImpl;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ComposableLambda.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ComposableLambdaKt {
    private static final int BITS_PER_SLOT = 3;
    private static final int SLOTS_PER_INT = 10;

    public static final int bitsForSlot(int i10, int i11) {
        return i10 << (((i11 % 10) * 3) + 1);
    }

    @ComposeCompilerApi
    @NotNull
    public static final ComposableLambda composableLambda(@NotNull Composer composer, int i10, boolean z10, @NotNull Object block) {
        ComposableLambdaImpl composableLambdaImpl;
        t.i(composer, "composer");
        t.i(block, "block");
        composer.startReplaceableGroup(i10);
        Object objRememberedValue = composer.rememberedValue();
        if (objRememberedValue == Composer.Companion.getEmpty()) {
            composableLambdaImpl = new ComposableLambdaImpl(i10, z10);
            composer.updateRememberedValue(composableLambdaImpl);
        } else {
            if (objRememberedValue == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.compose.runtime.internal.ComposableLambdaImpl");
            }
            composableLambdaImpl = (ComposableLambdaImpl) objRememberedValue;
        }
        composableLambdaImpl.update(block);
        composer.endReplaceableGroup();
        return composableLambdaImpl;
    }

    @ComposeCompilerApi
    @NotNull
    public static final ComposableLambda composableLambdaInstance(int i10, boolean z10, @NotNull Object block) {
        t.i(block, "block");
        ComposableLambdaImpl composableLambdaImpl = new ComposableLambdaImpl(i10, z10);
        composableLambdaImpl.update(block);
        return composableLambdaImpl;
    }

    public static final int differentBits(int i10) {
        return bitsForSlot(2, i10);
    }

    public static final boolean replacableWith(@Nullable RecomposeScope recomposeScope, @NotNull RecomposeScope other) {
        t.i(other, "other");
        if (recomposeScope != null) {
            if ((recomposeScope instanceof RecomposeScopeImpl) && (other instanceof RecomposeScopeImpl)) {
                RecomposeScopeImpl recomposeScopeImpl = (RecomposeScopeImpl) recomposeScope;
                if (!recomposeScopeImpl.getValid() || t.d(recomposeScope, other) || t.d(recomposeScopeImpl.getAnchor(), ((RecomposeScopeImpl) other).getAnchor())) {
                }
            }
            return false;
        }
        return true;
    }

    public static final int sameBits(int i10) {
        return bitsForSlot(1, i10);
    }
}
