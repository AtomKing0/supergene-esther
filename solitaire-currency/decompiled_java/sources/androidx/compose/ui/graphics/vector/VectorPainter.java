package androidx.compose.ui.graphics.vector;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composition;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.CompositionKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.unit.LayoutDirection;
import h9.p;
import h9.r;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: VectorPainter.kt */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
public final class VectorPainter extends Painter {
    public static final int $stable = 8;

    @Nullable
    private Composition composition;
    private float currentAlpha;

    @Nullable
    private ColorFilter currentColorFilter;

    @NotNull
    private final MutableState isDirty$delegate;

    @NotNull
    private final VectorComponent vector;

    @NotNull
    private final MutableState size$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Size.m1424boximpl(Size.Companion.m1445getZeroNHjbRc()), null, 2, null);

    @NotNull
    private final MutableState autoMirror$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);

    /* JADX INFO: renamed from: androidx.compose.ui.graphics.vector.VectorPainter$composeVector$1, reason: invalid class name */
    /* JADX INFO: compiled from: VectorPainter.kt */
    static final class AnonymousClass1 extends v implements p<Composer, Integer, k0> {
        final /* synthetic */ r<Float, Float, Composer, Integer, k0> $composable;
        final /* synthetic */ VectorPainter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(r<? super Float, ? super Float, ? super Composer, ? super Integer, k0> rVar, VectorPainter vectorPainter) {
            super(2);
            this.$composable = rVar;
            this.this$0 = vectorPainter;
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ k0 mo4invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return k0.f35197a;
        }

        @Composable
        public final void invoke(@Nullable Composer composer, int i10) {
            if ((i10 & 11) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
            } else {
                this.$composable.invoke(Float.valueOf(this.this$0.vector.getViewportWidth()), Float.valueOf(this.this$0.vector.getViewportHeight()), composer, 0);
            }
        }
    }

    public VectorPainter() {
        VectorComponent vectorComponent = new VectorComponent();
        vectorComponent.setInvalidateCallback$ui_release(new VectorPainter$vector$1$1(this));
        this.vector = vectorComponent;
        this.isDirty$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.TRUE, null, 2, null);
        this.currentAlpha = 1.0f;
    }

    @ComposableInferredTarget(scheme = "[0[0]]")
    private final Composition composeVector(CompositionContext compositionContext, r<? super Float, ? super Float, ? super Composer, ? super Integer, k0> rVar) {
        Composition Composition = this.composition;
        if (Composition == null || Composition.isDisposed()) {
            Composition = CompositionKt.Composition(new VectorApplier(this.vector.getRoot()), compositionContext);
        }
        this.composition = Composition;
        Composition.setContent(ComposableLambdaKt.composableLambdaInstance(-1916507005, true, new AnonymousClass1(rVar, this)));
        return Composition;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean isDirty() {
        return ((Boolean) this.isDirty$delegate.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setDirty(boolean z10) {
        this.isDirty$delegate.setValue(Boolean.valueOf(z10));
    }

    @Composable
    @ComposableInferredTarget(scheme = "[0[0]]")
    public final void RenderVector$ui_release(@NotNull String name, float f10, float f11, @NotNull r<? super Float, ? super Float, ? super Composer, ? super Integer, k0> content, @Nullable Composer composer, int i10) {
        t.i(name, "name");
        t.i(content, "content");
        Composer composerStartRestartGroup = composer.startRestartGroup(1264894527);
        VectorComponent vectorComponent = this.vector;
        vectorComponent.setName(name);
        vectorComponent.setViewportWidth(f10);
        vectorComponent.setViewportHeight(f11);
        Composition compositionComposeVector = composeVector(ComposablesKt.rememberCompositionContext(composerStartRestartGroup, 0), content);
        EffectsKt.DisposableEffect(compositionComposeVector, new VectorPainter$RenderVector$2(compositionComposeVector), composerStartRestartGroup, 8);
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new VectorPainter$RenderVector$3(this, name, f10, f11, content, i10));
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    protected boolean applyAlpha(float f10) {
        this.currentAlpha = f10;
        return true;
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    protected boolean applyColorFilter(@Nullable ColorFilter colorFilter) {
        this.currentColorFilter = colorFilter;
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean getAutoMirror$ui_release() {
        return ((Boolean) this.autoMirror$delegate.getValue()).booleanValue();
    }

    @Nullable
    public final ColorFilter getIntrinsicColorFilter$ui_release() {
        return this.vector.getIntrinsicColorFilter$ui_release();
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    /* JADX INFO: renamed from: getIntrinsicSize-NH-jbRc */
    public long mo2089getIntrinsicSizeNHjbRc() {
        return m2127getSizeNHjbRc$ui_release();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: getSize-NH-jbRc$ui_release, reason: not valid java name */
    public final long m2127getSizeNHjbRc$ui_release() {
        return ((Size) this.size$delegate.getValue()).m1441unboximpl();
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    protected void onDraw(@NotNull DrawScope drawScope) {
        t.i(drawScope, "<this>");
        VectorComponent vectorComponent = this.vector;
        ColorFilter intrinsicColorFilter$ui_release = this.currentColorFilter;
        if (intrinsicColorFilter$ui_release == null) {
            intrinsicColorFilter$ui_release = vectorComponent.getIntrinsicColorFilter$ui_release();
        }
        if (getAutoMirror$ui_release() && drawScope.getLayoutDirection() == LayoutDirection.Rtl) {
            long jMo1995getCenterF1C5BW0 = drawScope.mo1995getCenterF1C5BW0();
            DrawContext drawContext = drawScope.getDrawContext();
            long jMo2002getSizeNHjbRc = drawContext.mo2002getSizeNHjbRc();
            drawContext.getCanvas().save();
            drawContext.getTransform().mo2009scale0AR0LA0(-1.0f, 1.0f, jMo1995getCenterF1C5BW0);
            vectorComponent.draw(drawScope, this.currentAlpha, intrinsicColorFilter$ui_release);
            drawContext.getCanvas().restore();
            drawContext.mo2003setSizeuvyYCjk(jMo2002getSizeNHjbRc);
        } else {
            vectorComponent.draw(drawScope, this.currentAlpha, intrinsicColorFilter$ui_release);
        }
        if (isDirty()) {
            setDirty(false);
        }
    }

    public final void setAutoMirror$ui_release(boolean z10) {
        this.autoMirror$delegate.setValue(Boolean.valueOf(z10));
    }

    public final void setIntrinsicColorFilter$ui_release(@Nullable ColorFilter colorFilter) {
        this.vector.setIntrinsicColorFilter$ui_release(colorFilter);
    }

    /* JADX INFO: renamed from: setSize-uvyYCjk$ui_release, reason: not valid java name */
    public final void m2128setSizeuvyYCjk$ui_release(long j10) {
        this.size$delegate.setValue(Size.m1424boximpl(j10));
    }
}
