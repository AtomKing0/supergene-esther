package androidx.compose.foundation;

import android.content.Context;
import android.graphics.Canvas;
import android.widget.EdgeEffect;
import androidx.annotation.VisibleForTesting;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.input.nestedscroll.NestedScrollSource;
import androidx.compose.ui.layout.OnRemeasuredModifierKt;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.Velocity;
import java.util.List;
import kotlin.collections.v;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: AndroidOverscroll.kt */
/* JADX INFO: loaded from: classes.dex */
public final class AndroidEdgeEffectOverscrollEffect implements OverscrollEffect {

    @NotNull
    private final List<EdgeEffect> allEffects;

    @NotNull
    private final EdgeEffect bottomEffect;

    @NotNull
    private final EdgeEffect bottomEffectNegation;
    private long containerSize;

    @NotNull
    private final Modifier effectModifier;
    private boolean invalidationEnabled;
    private boolean isEnabled;

    @NotNull
    private final MutableState<Boolean> isEnabledState;

    @NotNull
    private final EdgeEffect leftEffect;

    @NotNull
    private final EdgeEffect leftEffectNegation;

    @NotNull
    private final h9.l<IntSize, k0> onNewSize;

    @NotNull
    private final OverscrollConfiguration overscrollConfig;

    @NotNull
    private final MutableState<k0> redrawSignal;

    @NotNull
    private final EdgeEffect rightEffect;

    @NotNull
    private final EdgeEffect rightEffectNegation;
    private boolean scrollCycleInProgress;

    @NotNull
    private final EdgeEffect topEffect;

    @NotNull
    private final EdgeEffect topEffectNegation;

    public AndroidEdgeEffectOverscrollEffect(@NotNull Context context, @NotNull OverscrollConfiguration overscrollConfig) {
        t.i(context, "context");
        t.i(overscrollConfig, "overscrollConfig");
        this.overscrollConfig = overscrollConfig;
        EdgeEffectCompat edgeEffectCompat = EdgeEffectCompat.INSTANCE;
        EdgeEffect edgeEffectCreate = edgeEffectCompat.create(context, null);
        this.topEffect = edgeEffectCreate;
        EdgeEffect edgeEffectCreate2 = edgeEffectCompat.create(context, null);
        this.bottomEffect = edgeEffectCreate2;
        EdgeEffect edgeEffectCreate3 = edgeEffectCompat.create(context, null);
        this.leftEffect = edgeEffectCreate3;
        EdgeEffect edgeEffectCreate4 = edgeEffectCompat.create(context, null);
        this.rightEffect = edgeEffectCreate4;
        List<EdgeEffect> listN = v.n(edgeEffectCreate3, edgeEffectCreate, edgeEffectCreate4, edgeEffectCreate2);
        this.allEffects = listN;
        this.topEffectNegation = edgeEffectCompat.create(context, null);
        this.bottomEffectNegation = edgeEffectCompat.create(context, null);
        this.leftEffectNegation = edgeEffectCompat.create(context, null);
        this.rightEffectNegation = edgeEffectCompat.create(context, null);
        int size = listN.size();
        for (int i10 = 0; i10 < size; i10++) {
            listN.get(i10).setColor(ColorKt.m1653toArgb8_81llA(this.overscrollConfig.m235getGlowColor0d7_KjU()));
        }
        this.redrawSignal = SnapshotStateKt.mutableStateOf(k0.f35197a, SnapshotStateKt.neverEqualPolicy());
        this.invalidationEnabled = true;
        this.containerSize = Size.Companion.m1445getZeroNHjbRc();
        this.isEnabledState = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
        AndroidEdgeEffectOverscrollEffect$onNewSize$1 androidEdgeEffectOverscrollEffect$onNewSize$1 = new AndroidEdgeEffectOverscrollEffect$onNewSize$1(this);
        this.onNewSize = androidEdgeEffectOverscrollEffect$onNewSize$1;
        this.effectModifier = OnRemeasuredModifierKt.onSizeChanged(Modifier.Companion.then(AndroidOverscrollKt.StretchOverscrollNonClippingLayer), androidEdgeEffectOverscrollEffect$onNewSize$1).then(new DrawOverscrollModifier(this, InspectableValueKt.isDebugInspectorInfoEnabled() ? new AndroidEdgeEffectOverscrollEffect$special$$inlined$debugInspectorInfo$1(this) : InspectableValueKt.getNoInspectorInfo()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void animateToRelease() {
        List<EdgeEffect> list = this.allEffects;
        int size = list.size();
        boolean z10 = false;
        for (int i10 = 0; i10 < size; i10++) {
            EdgeEffect edgeEffect = list.get(i10);
            edgeEffect.onRelease();
            z10 = edgeEffect.isFinished() || z10;
        }
        if (z10) {
            invalidateOverscroll();
        }
    }

    private final boolean drawBottom(DrawScope drawScope, EdgeEffect edgeEffect, Canvas canvas) {
        int iSave = canvas.save();
        canvas.rotate(180.0f);
        canvas.translate(-Size.m1436getWidthimpl(this.containerSize), (-Size.m1433getHeightimpl(this.containerSize)) + drawScope.mo296toPx0680j_4(this.overscrollConfig.getDrawPadding().mo379calculateBottomPaddingD9Ej5fM()));
        boolean zDraw = edgeEffect.draw(canvas);
        canvas.restoreToCount(iSave);
        return zDraw;
    }

    private final boolean drawLeft(DrawScope drawScope, EdgeEffect edgeEffect, Canvas canvas) {
        int iSave = canvas.save();
        canvas.rotate(270.0f);
        canvas.translate(-Size.m1433getHeightimpl(this.containerSize), drawScope.mo296toPx0680j_4(this.overscrollConfig.getDrawPadding().mo380calculateLeftPaddingu2uoSUM(drawScope.getLayoutDirection())));
        boolean zDraw = edgeEffect.draw(canvas);
        canvas.restoreToCount(iSave);
        return zDraw;
    }

    private final boolean drawRight(DrawScope drawScope, EdgeEffect edgeEffect, Canvas canvas) {
        int iSave = canvas.save();
        int iC = j9.c.c(Size.m1436getWidthimpl(this.containerSize));
        float fMo381calculateRightPaddingu2uoSUM = this.overscrollConfig.getDrawPadding().mo381calculateRightPaddingu2uoSUM(drawScope.getLayoutDirection());
        canvas.rotate(90.0f);
        canvas.translate(0.0f, (-iC) + drawScope.mo296toPx0680j_4(fMo381calculateRightPaddingu2uoSUM));
        boolean zDraw = edgeEffect.draw(canvas);
        canvas.restoreToCount(iSave);
        return zDraw;
    }

    private final boolean drawTop(DrawScope drawScope, EdgeEffect edgeEffect, Canvas canvas) {
        int iSave = canvas.save();
        canvas.translate(0.0f, drawScope.mo296toPx0680j_4(this.overscrollConfig.getDrawPadding().mo382calculateTopPaddingD9Ej5fM()));
        boolean zDraw = edgeEffect.draw(canvas);
        canvas.restoreToCount(iSave);
        return zDraw;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void invalidateOverscroll() {
        if (this.invalidationEnabled) {
            this.redrawSignal.setValue(k0.f35197a);
        }
    }

    /* JADX INFO: renamed from: pullBottom-0a9Yr6o, reason: not valid java name */
    private final float m153pullBottom0a9Yr6o(long j10, long j11) {
        return (-EdgeEffectCompat.INSTANCE.onPullDistanceCompat(this.bottomEffect, -(Offset.m1368getYimpl(j10) / Size.m1433getHeightimpl(this.containerSize)), 1 - (Offset.m1367getXimpl(j11) / Size.m1436getWidthimpl(this.containerSize)))) * Size.m1433getHeightimpl(this.containerSize);
    }

    /* JADX INFO: renamed from: pullLeft-0a9Yr6o, reason: not valid java name */
    private final float m154pullLeft0a9Yr6o(long j10, long j11) {
        return EdgeEffectCompat.INSTANCE.onPullDistanceCompat(this.leftEffect, Offset.m1367getXimpl(j10) / Size.m1436getWidthimpl(this.containerSize), 1 - (Offset.m1368getYimpl(j11) / Size.m1433getHeightimpl(this.containerSize))) * Size.m1436getWidthimpl(this.containerSize);
    }

    /* JADX INFO: renamed from: pullRight-0a9Yr6o, reason: not valid java name */
    private final float m155pullRight0a9Yr6o(long j10, long j11) {
        return (-EdgeEffectCompat.INSTANCE.onPullDistanceCompat(this.rightEffect, -(Offset.m1367getXimpl(j10) / Size.m1436getWidthimpl(this.containerSize)), Offset.m1368getYimpl(j11) / Size.m1433getHeightimpl(this.containerSize))) * Size.m1436getWidthimpl(this.containerSize);
    }

    /* JADX INFO: renamed from: pullTop-0a9Yr6o, reason: not valid java name */
    private final float m156pullTop0a9Yr6o(long j10, long j11) {
        float fM1367getXimpl = Offset.m1367getXimpl(j11) / Size.m1436getWidthimpl(this.containerSize);
        return EdgeEffectCompat.INSTANCE.onPullDistanceCompat(this.topEffect, Offset.m1368getYimpl(j10) / Size.m1433getHeightimpl(this.containerSize), fM1367getXimpl) * Size.m1433getHeightimpl(this.containerSize);
    }

    /* JADX INFO: renamed from: releaseOppositeOverscroll-k-4lQ0M, reason: not valid java name */
    private final boolean m157releaseOppositeOverscrollk4lQ0M(long j10) {
        boolean zIsFinished;
        if (this.leftEffect.isFinished() || Offset.m1367getXimpl(j10) >= 0.0f) {
            zIsFinished = false;
        } else {
            this.leftEffect.onRelease();
            zIsFinished = this.leftEffect.isFinished();
        }
        if (!this.rightEffect.isFinished() && Offset.m1367getXimpl(j10) > 0.0f) {
            this.rightEffect.onRelease();
            zIsFinished = zIsFinished || this.rightEffect.isFinished();
        }
        if (!this.topEffect.isFinished() && Offset.m1368getYimpl(j10) < 0.0f) {
            this.topEffect.onRelease();
            zIsFinished = zIsFinished || this.topEffect.isFinished();
        }
        if (this.bottomEffect.isFinished() || Offset.m1368getYimpl(j10) <= 0.0f) {
            return zIsFinished;
        }
        this.bottomEffect.onRelease();
        return zIsFinished || this.bottomEffect.isFinished();
    }

    private final boolean stopOverscrollAnimation() {
        boolean z10;
        long jM1446getCenteruvyYCjk = SizeKt.m1446getCenteruvyYCjk(this.containerSize);
        EdgeEffectCompat edgeEffectCompat = EdgeEffectCompat.INSTANCE;
        if (edgeEffectCompat.getDistanceCompat(this.leftEffect) == 0.0f) {
            z10 = false;
        } else {
            m154pullLeft0a9Yr6o(Offset.Companion.m1383getZeroF1C5BW0(), jM1446getCenteruvyYCjk);
            z10 = true;
        }
        if (!(edgeEffectCompat.getDistanceCompat(this.rightEffect) == 0.0f)) {
            m155pullRight0a9Yr6o(Offset.Companion.m1383getZeroF1C5BW0(), jM1446getCenteruvyYCjk);
            z10 = true;
        }
        if (!(edgeEffectCompat.getDistanceCompat(this.topEffect) == 0.0f)) {
            m156pullTop0a9Yr6o(Offset.Companion.m1383getZeroF1C5BW0(), jM1446getCenteruvyYCjk);
            z10 = true;
        }
        if (edgeEffectCompat.getDistanceCompat(this.bottomEffect) == 0.0f) {
            return z10;
        }
        m153pullBottom0a9Yr6o(Offset.Companion.m1383getZeroF1C5BW0(), jM1446getCenteruvyYCjk);
        return true;
    }

    @Override // androidx.compose.foundation.OverscrollEffect
    @Nullable
    /* JADX INFO: renamed from: consumePostFling-sF-c-tU, reason: not valid java name */
    public Object mo158consumePostFlingsFctU(long j10, @NotNull z8.d<? super k0> dVar) {
        this.scrollCycleInProgress = false;
        if (Velocity.m3898getXimpl(j10) > 0.0f) {
            EdgeEffectCompat.INSTANCE.onAbsorbCompat(this.leftEffect, j9.c.c(Velocity.m3898getXimpl(j10)));
        } else if (Velocity.m3898getXimpl(j10) < 0.0f) {
            EdgeEffectCompat.INSTANCE.onAbsorbCompat(this.rightEffect, -j9.c.c(Velocity.m3898getXimpl(j10)));
        }
        if (Velocity.m3899getYimpl(j10) > 0.0f) {
            EdgeEffectCompat.INSTANCE.onAbsorbCompat(this.topEffect, j9.c.c(Velocity.m3899getYimpl(j10)));
        } else if (Velocity.m3899getYimpl(j10) < 0.0f) {
            EdgeEffectCompat.INSTANCE.onAbsorbCompat(this.bottomEffect, -j9.c.c(Velocity.m3899getYimpl(j10)));
        }
        if (!Velocity.m3897equalsimpl0(j10, Velocity.Companion.m3909getZero9UxMQ8M())) {
            invalidateOverscroll();
        }
        animateToRelease();
        return k0.f35197a;
    }

    @Override // androidx.compose.foundation.OverscrollEffect
    /* JADX INFO: renamed from: consumePostScroll-l7mfB5k, reason: not valid java name */
    public void mo159consumePostScrolll7mfB5k(long j10, long j11, @Nullable Offset offset, int i10) {
        boolean z10;
        boolean z11 = true;
        if (NestedScrollSource.m2782equalsimpl0(i10, NestedScrollSource.Companion.m2787getDragWNlRxjI())) {
            long jM1377unboximpl = offset != null ? offset.m1377unboximpl() : SizeKt.m1446getCenteruvyYCjk(this.containerSize);
            if (Offset.m1367getXimpl(j11) > 0.0f) {
                m154pullLeft0a9Yr6o(j11, jM1377unboximpl);
            } else if (Offset.m1367getXimpl(j11) < 0.0f) {
                m155pullRight0a9Yr6o(j11, jM1377unboximpl);
            }
            if (Offset.m1368getYimpl(j11) > 0.0f) {
                m156pullTop0a9Yr6o(j11, jM1377unboximpl);
            } else if (Offset.m1368getYimpl(j11) < 0.0f) {
                m153pullBottom0a9Yr6o(j11, jM1377unboximpl);
            }
            z10 = !Offset.m1364equalsimpl0(j11, Offset.Companion.m1383getZeroF1C5BW0());
        } else {
            z10 = false;
        }
        if (!m157releaseOppositeOverscrollk4lQ0M(j10) && !z10) {
            z11 = false;
        }
        if (z11) {
            invalidateOverscroll();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0086  */
    @Override // androidx.compose.foundation.OverscrollEffect
    @org.jetbrains.annotations.Nullable
    /* JADX INFO: renamed from: consumePreFling-QWom1Mo, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object mo160consumePreFlingQWom1Mo(long r6, @org.jetbrains.annotations.NotNull z8.d<? super androidx.compose.ui.unit.Velocity> r8) {
        /*
            r5 = this;
            float r8 = androidx.compose.ui.unit.Velocity.m3898getXimpl(r6)
            r0 = 0
            int r8 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
            r1 = 1
            r2 = 0
            if (r8 <= 0) goto L2e
            androidx.compose.foundation.EdgeEffectCompat r8 = androidx.compose.foundation.EdgeEffectCompat.INSTANCE
            android.widget.EdgeEffect r3 = r5.leftEffect
            float r3 = r8.getDistanceCompat(r3)
            int r3 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
            if (r3 != 0) goto L19
            r3 = r1
            goto L1a
        L19:
            r3 = r2
        L1a:
            if (r3 != 0) goto L2e
            android.widget.EdgeEffect r3 = r5.leftEffect
            float r4 = androidx.compose.ui.unit.Velocity.m3898getXimpl(r6)
            int r4 = j9.a.c(r4)
            r8.onAbsorbCompat(r3, r4)
            float r8 = androidx.compose.ui.unit.Velocity.m3898getXimpl(r6)
            goto L5b
        L2e:
            float r8 = androidx.compose.ui.unit.Velocity.m3898getXimpl(r6)
            int r8 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
            if (r8 >= 0) goto L5a
            androidx.compose.foundation.EdgeEffectCompat r8 = androidx.compose.foundation.EdgeEffectCompat.INSTANCE
            android.widget.EdgeEffect r3 = r5.rightEffect
            float r3 = r8.getDistanceCompat(r3)
            int r3 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
            if (r3 != 0) goto L44
            r3 = r1
            goto L45
        L44:
            r3 = r2
        L45:
            if (r3 != 0) goto L5a
            android.widget.EdgeEffect r3 = r5.rightEffect
            float r4 = androidx.compose.ui.unit.Velocity.m3898getXimpl(r6)
            int r4 = j9.a.c(r4)
            int r4 = -r4
            r8.onAbsorbCompat(r3, r4)
            float r8 = androidx.compose.ui.unit.Velocity.m3898getXimpl(r6)
            goto L5b
        L5a:
            r8 = r0
        L5b:
            float r3 = androidx.compose.ui.unit.Velocity.m3899getYimpl(r6)
            int r3 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
            if (r3 <= 0) goto L86
            androidx.compose.foundation.EdgeEffectCompat r3 = androidx.compose.foundation.EdgeEffectCompat.INSTANCE
            android.widget.EdgeEffect r4 = r5.topEffect
            float r4 = r3.getDistanceCompat(r4)
            int r4 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r4 != 0) goto L71
            r4 = r1
            goto L72
        L71:
            r4 = r2
        L72:
            if (r4 != 0) goto L86
            android.widget.EdgeEffect r0 = r5.topEffect
            float r1 = androidx.compose.ui.unit.Velocity.m3899getYimpl(r6)
            int r1 = j9.a.c(r1)
            r3.onAbsorbCompat(r0, r1)
            float r0 = androidx.compose.ui.unit.Velocity.m3899getYimpl(r6)
            goto Lb0
        L86:
            float r3 = androidx.compose.ui.unit.Velocity.m3899getYimpl(r6)
            int r3 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
            if (r3 >= 0) goto Lb0
            androidx.compose.foundation.EdgeEffectCompat r3 = androidx.compose.foundation.EdgeEffectCompat.INSTANCE
            android.widget.EdgeEffect r4 = r5.bottomEffect
            float r4 = r3.getDistanceCompat(r4)
            int r4 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r4 != 0) goto L9b
            goto L9c
        L9b:
            r1 = r2
        L9c:
            if (r1 != 0) goto Lb0
            android.widget.EdgeEffect r0 = r5.bottomEffect
            float r1 = androidx.compose.ui.unit.Velocity.m3899getYimpl(r6)
            int r1 = j9.a.c(r1)
            int r1 = -r1
            r3.onAbsorbCompat(r0, r1)
            float r0 = androidx.compose.ui.unit.Velocity.m3899getYimpl(r6)
        Lb0:
            long r6 = androidx.compose.ui.unit.VelocityKt.Velocity(r8, r0)
            androidx.compose.ui.unit.Velocity$Companion r8 = androidx.compose.ui.unit.Velocity.Companion
            long r0 = r8.m3909getZero9UxMQ8M()
            boolean r8 = androidx.compose.ui.unit.Velocity.m3897equalsimpl0(r6, r0)
            if (r8 != 0) goto Lc3
            r5.invalidateOverscroll()
        Lc3:
            androidx.compose.ui.unit.Velocity r6 = androidx.compose.ui.unit.Velocity.m3889boximpl(r6)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect.mo160consumePreFlingQWom1Mo(long, z8.d):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0026  */
    @Override // androidx.compose.foundation.OverscrollEffect
    /* JADX INFO: renamed from: consumePreScroll-A0NYTsA, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public long mo161consumePreScrollA0NYTsA(long r7, @org.jetbrains.annotations.Nullable androidx.compose.ui.geometry.Offset r9, int r10) {
        /*
            Method dump skipped, instruction units count: 236
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect.mo161consumePreScrollA0NYTsA(long, androidx.compose.ui.geometry.Offset, int):long");
    }

    public final void drawOverscroll(@NotNull DrawScope drawScope) {
        boolean zDrawLeft;
        t.i(drawScope, "<this>");
        androidx.compose.ui.graphics.Canvas canvas = drawScope.getDrawContext().getCanvas();
        this.redrawSignal.getValue();
        Canvas nativeCanvas = AndroidCanvas_androidKt.getNativeCanvas(canvas);
        EdgeEffectCompat edgeEffectCompat = EdgeEffectCompat.INSTANCE;
        boolean z10 = true;
        if (!(edgeEffectCompat.getDistanceCompat(this.leftEffectNegation) == 0.0f)) {
            drawRight(drawScope, this.leftEffectNegation, nativeCanvas);
            this.leftEffectNegation.finish();
        }
        if (this.leftEffect.isFinished()) {
            zDrawLeft = false;
        } else {
            zDrawLeft = drawLeft(drawScope, this.leftEffect, nativeCanvas);
            edgeEffectCompat.onPullDistanceCompat(this.leftEffectNegation, edgeEffectCompat.getDistanceCompat(this.leftEffect), 0.0f);
        }
        if (!(edgeEffectCompat.getDistanceCompat(this.topEffectNegation) == 0.0f)) {
            drawBottom(drawScope, this.topEffectNegation, nativeCanvas);
            this.topEffectNegation.finish();
        }
        if (!this.topEffect.isFinished()) {
            zDrawLeft = drawTop(drawScope, this.topEffect, nativeCanvas) || zDrawLeft;
            edgeEffectCompat.onPullDistanceCompat(this.topEffectNegation, edgeEffectCompat.getDistanceCompat(this.topEffect), 0.0f);
        }
        if (!(edgeEffectCompat.getDistanceCompat(this.rightEffectNegation) == 0.0f)) {
            drawLeft(drawScope, this.rightEffectNegation, nativeCanvas);
            this.rightEffectNegation.finish();
        }
        if (!this.rightEffect.isFinished()) {
            zDrawLeft = drawRight(drawScope, this.rightEffect, nativeCanvas) || zDrawLeft;
            edgeEffectCompat.onPullDistanceCompat(this.rightEffectNegation, edgeEffectCompat.getDistanceCompat(this.rightEffect), 0.0f);
        }
        if (!(edgeEffectCompat.getDistanceCompat(this.bottomEffectNegation) == 0.0f)) {
            drawTop(drawScope, this.bottomEffectNegation, nativeCanvas);
            this.bottomEffectNegation.finish();
        }
        if (!this.bottomEffect.isFinished()) {
            if (!drawBottom(drawScope, this.bottomEffect, nativeCanvas) && !zDrawLeft) {
                z10 = false;
            }
            edgeEffectCompat.onPullDistanceCompat(this.bottomEffectNegation, edgeEffectCompat.getDistanceCompat(this.bottomEffect), 0.0f);
            zDrawLeft = z10;
        }
        if (zDrawLeft) {
            invalidateOverscroll();
        }
    }

    @Override // androidx.compose.foundation.OverscrollEffect
    @NotNull
    public Modifier getEffectModifier() {
        return this.effectModifier;
    }

    public final boolean getInvalidationEnabled$foundation_release() {
        return this.invalidationEnabled;
    }

    @Override // androidx.compose.foundation.OverscrollEffect
    public boolean isEnabled() {
        return this.isEnabledState.getValue().booleanValue();
    }

    @Override // androidx.compose.foundation.OverscrollEffect
    public boolean isInProgress() {
        List<EdgeEffect> list = this.allEffects;
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (!(EdgeEffectCompat.INSTANCE.getDistanceCompat(list.get(i10)) == 0.0f)) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.compose.foundation.OverscrollEffect
    public void setEnabled(boolean z10) {
        boolean z11 = this.isEnabled != z10;
        this.isEnabledState.setValue(Boolean.valueOf(z10));
        this.isEnabled = z10;
        if (z11) {
            this.scrollCycleInProgress = false;
            animateToRelease();
        }
    }

    public final void setInvalidationEnabled$foundation_release(boolean z10) {
        this.invalidationEnabled = z10;
    }

    @VisibleForTesting
    public static /* synthetic */ void getInvalidationEnabled$foundation_release$annotations() {
    }
}
