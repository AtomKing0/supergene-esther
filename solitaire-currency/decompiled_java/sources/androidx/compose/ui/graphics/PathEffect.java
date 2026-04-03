package androidx.compose.ui.graphics;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: PathEffect.kt */
/* JADX INFO: loaded from: classes.dex */
public interface PathEffect {

    @NotNull
    public static final Companion Companion = Companion.$$INSTANCE;

    /* JADX INFO: compiled from: PathEffect.kt */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        public static /* synthetic */ PathEffect dashPathEffect$default(Companion companion, float[] fArr, float f10, int i10, Object obj) {
            if ((i10 & 2) != 0) {
                f10 = 0.0f;
            }
            return companion.dashPathEffect(fArr, f10);
        }

        @NotNull
        public final PathEffect chainPathEffect(@NotNull PathEffect outer, @NotNull PathEffect inner) {
            kotlin.jvm.internal.t.i(outer, "outer");
            kotlin.jvm.internal.t.i(inner, "inner");
            return AndroidPathEffect_androidKt.actualChainPathEffect(outer, inner);
        }

        @NotNull
        public final PathEffect cornerPathEffect(float f10) {
            return AndroidPathEffect_androidKt.actualCornerPathEffect(f10);
        }

        @NotNull
        public final PathEffect dashPathEffect(@NotNull float[] intervals, float f10) {
            kotlin.jvm.internal.t.i(intervals, "intervals");
            return AndroidPathEffect_androidKt.actualDashPathEffect(intervals, f10);
        }

        @NotNull
        /* JADX INFO: renamed from: stampedPathEffect-7aD1DOk, reason: not valid java name */
        public final PathEffect m1816stampedPathEffect7aD1DOk(@NotNull Path shape, float f10, float f11, int i10) {
            kotlin.jvm.internal.t.i(shape, "shape");
            return AndroidPathEffect_androidKt.m1504actualStampedPathEffect7aD1DOk(shape, f10, f11, i10);
        }
    }
}
