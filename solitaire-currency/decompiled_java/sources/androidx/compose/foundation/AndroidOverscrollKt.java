package androidx.compose.foundation;

import android.content.Context;
import android.os.Build;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.layout.LayoutModifierKt;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.unit.Velocity;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: AndroidOverscroll.kt */
/* JADX INFO: loaded from: classes.dex */
public final class AndroidOverscrollKt {

    @NotNull
    private static final AndroidOverscrollKt$NoOpOverscrollEffect$1 NoOpOverscrollEffect = new OverscrollEffect() { // from class: androidx.compose.foundation.AndroidOverscrollKt$NoOpOverscrollEffect$1
        private boolean isEnabled;

        @Override // androidx.compose.foundation.OverscrollEffect
        @Nullable
        /* JADX INFO: renamed from: consumePostFling-sF-c-tU */
        public Object mo158consumePostFlingsFctU(long j10, @NotNull z8.d<? super k0> dVar) {
            return k0.f35197a;
        }

        @Override // androidx.compose.foundation.OverscrollEffect
        @Nullable
        /* JADX INFO: renamed from: consumePreFling-QWom1Mo */
        public Object mo160consumePreFlingQWom1Mo(long j10, @NotNull z8.d<? super Velocity> dVar) {
            return Velocity.m3889boximpl(Velocity.Companion.m3909getZero9UxMQ8M());
        }

        @Override // androidx.compose.foundation.OverscrollEffect
        /* JADX INFO: renamed from: consumePreScroll-A0NYTsA */
        public long mo161consumePreScrollA0NYTsA(long j10, @Nullable Offset offset, int i10) {
            return Offset.Companion.m1383getZeroF1C5BW0();
        }

        @Override // androidx.compose.foundation.OverscrollEffect
        @NotNull
        public Modifier getEffectModifier() {
            return Modifier.Companion;
        }

        @Override // androidx.compose.foundation.OverscrollEffect
        public boolean isEnabled() {
            return this.isEnabled;
        }

        @Override // androidx.compose.foundation.OverscrollEffect
        public boolean isInProgress() {
            return false;
        }

        @Override // androidx.compose.foundation.OverscrollEffect
        public void setEnabled(boolean z10) {
            this.isEnabled = z10;
        }

        @Override // androidx.compose.foundation.OverscrollEffect
        /* JADX INFO: renamed from: consumePostScroll-l7mfB5k */
        public void mo159consumePostScrolll7mfB5k(long j10, long j11, @Nullable Offset offset, int i10) {
        }
    };

    @NotNull
    private static final Modifier StretchOverscrollNonClippingLayer;

    /* JADX WARN: Type inference failed for: r0v0, types: [androidx.compose.foundation.AndroidOverscrollKt$NoOpOverscrollEffect$1] */
    static {
        StretchOverscrollNonClippingLayer = Build.VERSION.SDK_INT >= 31 ? LayoutModifierKt.layout(LayoutModifierKt.layout(Modifier.Companion, AndroidOverscrollKt$StretchOverscrollNonClippingLayer$1.INSTANCE), AndroidOverscrollKt$StretchOverscrollNonClippingLayer$2.INSTANCE) : Modifier.Companion;
    }

    @Composable
    @NotNull
    public static final OverscrollEffect rememberOverscrollEffect(@Nullable Composer composer, int i10) {
        composer.startReplaceableGroup(-81138291);
        Context context = (Context) composer.consume(AndroidCompositionLocals_androidKt.getLocalContext());
        OverscrollConfiguration overscrollConfiguration = (OverscrollConfiguration) composer.consume(OverscrollConfigurationKt.getLocalOverscrollConfiguration());
        composer.startReplaceableGroup(511388516);
        boolean zChanged = composer.changed(context) | composer.changed(overscrollConfiguration);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
            objRememberedValue = overscrollConfiguration != null ? new AndroidEdgeEffectOverscrollEffect(context, overscrollConfiguration) : NoOpOverscrollEffect;
            composer.updateRememberedValue(objRememberedValue);
        }
        composer.endReplaceableGroup();
        OverscrollEffect overscrollEffect = (OverscrollEffect) objRememberedValue;
        composer.endReplaceableGroup();
        return overscrollEffect;
    }

    private static /* synthetic */ void getNoOpOverscrollEffect$annotations() {
    }
}
