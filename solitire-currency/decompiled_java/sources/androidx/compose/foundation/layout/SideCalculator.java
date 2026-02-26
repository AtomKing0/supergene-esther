package androidx.compose.foundation.layout;

import android.graphics.Insets;
import androidx.annotation.RequiresApi;
import androidx.compose.foundation.layout.WindowInsetsSides;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.unit.Velocity;
import androidx.compose.ui.unit.VelocityKt;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: WindowInsetsConnection.android.kt */
/* JADX INFO: loaded from: classes.dex */
@RequiresApi(30)
interface SideCalculator {

    @NotNull
    public static final Companion Companion = Companion.$$INSTANCE;

    /* JADX INFO: compiled from: WindowInsetsConnection.android.kt */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        @NotNull
        private static final SideCalculator$Companion$LeftSideCalculator$1 LeftSideCalculator = new SideCalculator() { // from class: androidx.compose.foundation.layout.SideCalculator$Companion$LeftSideCalculator$1
            @Override // androidx.compose.foundation.layout.SideCalculator
            @NotNull
            public Insets adjustInsets(@NotNull Insets oldInsets, int i10) {
                t.i(oldInsets, "oldInsets");
                Insets insetsOf = Insets.of(i10, oldInsets.top, oldInsets.right, oldInsets.bottom);
                t.h(insetsOf, "of(newValue, oldInsets.t….right, oldInsets.bottom)");
                return insetsOf;
            }

            @Override // androidx.compose.foundation.layout.SideCalculator
            /* JADX INFO: renamed from: consumedOffsets-MK-Hz9U */
            public long mo421consumedOffsetsMKHz9U(long j10) {
                return androidx.compose.ui.geometry.OffsetKt.Offset(Offset.m1367getXimpl(j10), 0.0f);
            }

            @Override // androidx.compose.foundation.layout.SideCalculator
            /* JADX INFO: renamed from: consumedVelocity-QWom1Mo */
            public long mo422consumedVelocityQWom1Mo(long j10, float f10) {
                return VelocityKt.Velocity(Velocity.m3898getXimpl(j10) - f10, 0.0f);
            }

            @Override // androidx.compose.foundation.layout.SideCalculator
            public /* synthetic */ float hideMotion(float f10, float f11) {
                return f.a(this, f10, f11);
            }

            @Override // androidx.compose.foundation.layout.SideCalculator
            public /* synthetic */ float showMotion(float f10, float f11) {
                return f.b(this, f10, f11);
            }

            @Override // androidx.compose.foundation.layout.SideCalculator
            public int valueOf(@NotNull Insets insets) {
                t.i(insets, "insets");
                return insets.left;
            }

            @Override // androidx.compose.foundation.layout.SideCalculator
            public float motionOf(float f10, float f11) {
                return f10;
            }
        };

        @NotNull
        private static final SideCalculator$Companion$TopSideCalculator$1 TopSideCalculator = new SideCalculator() { // from class: androidx.compose.foundation.layout.SideCalculator$Companion$TopSideCalculator$1
            @Override // androidx.compose.foundation.layout.SideCalculator
            @NotNull
            public Insets adjustInsets(@NotNull Insets oldInsets, int i10) {
                t.i(oldInsets, "oldInsets");
                Insets insetsOf = Insets.of(oldInsets.left, i10, oldInsets.right, oldInsets.bottom);
                t.h(insetsOf, "of(oldInsets.left, newVa….right, oldInsets.bottom)");
                return insetsOf;
            }

            @Override // androidx.compose.foundation.layout.SideCalculator
            /* JADX INFO: renamed from: consumedOffsets-MK-Hz9U */
            public long mo421consumedOffsetsMKHz9U(long j10) {
                return androidx.compose.ui.geometry.OffsetKt.Offset(0.0f, Offset.m1368getYimpl(j10));
            }

            @Override // androidx.compose.foundation.layout.SideCalculator
            /* JADX INFO: renamed from: consumedVelocity-QWom1Mo */
            public long mo422consumedVelocityQWom1Mo(long j10, float f10) {
                return VelocityKt.Velocity(0.0f, Velocity.m3899getYimpl(j10) - f10);
            }

            @Override // androidx.compose.foundation.layout.SideCalculator
            public /* synthetic */ float hideMotion(float f10, float f11) {
                return f.a(this, f10, f11);
            }

            @Override // androidx.compose.foundation.layout.SideCalculator
            public /* synthetic */ float showMotion(float f10, float f11) {
                return f.b(this, f10, f11);
            }

            @Override // androidx.compose.foundation.layout.SideCalculator
            public int valueOf(@NotNull Insets insets) {
                t.i(insets, "insets");
                return insets.top;
            }

            @Override // androidx.compose.foundation.layout.SideCalculator
            public float motionOf(float f10, float f11) {
                return f11;
            }
        };

        @NotNull
        private static final SideCalculator$Companion$RightSideCalculator$1 RightSideCalculator = new SideCalculator() { // from class: androidx.compose.foundation.layout.SideCalculator$Companion$RightSideCalculator$1
            @Override // androidx.compose.foundation.layout.SideCalculator
            @NotNull
            public Insets adjustInsets(@NotNull Insets oldInsets, int i10) {
                t.i(oldInsets, "oldInsets");
                Insets insetsOf = Insets.of(oldInsets.left, oldInsets.top, i10, oldInsets.bottom);
                t.h(insetsOf, "of(oldInsets.left, oldIn…wValue, oldInsets.bottom)");
                return insetsOf;
            }

            @Override // androidx.compose.foundation.layout.SideCalculator
            /* JADX INFO: renamed from: consumedOffsets-MK-Hz9U */
            public long mo421consumedOffsetsMKHz9U(long j10) {
                return androidx.compose.ui.geometry.OffsetKt.Offset(Offset.m1367getXimpl(j10), 0.0f);
            }

            @Override // androidx.compose.foundation.layout.SideCalculator
            /* JADX INFO: renamed from: consumedVelocity-QWom1Mo */
            public long mo422consumedVelocityQWom1Mo(long j10, float f10) {
                return VelocityKt.Velocity(Velocity.m3898getXimpl(j10) + f10, 0.0f);
            }

            @Override // androidx.compose.foundation.layout.SideCalculator
            public /* synthetic */ float hideMotion(float f10, float f11) {
                return f.a(this, f10, f11);
            }

            @Override // androidx.compose.foundation.layout.SideCalculator
            public float motionOf(float f10, float f11) {
                return -f10;
            }

            @Override // androidx.compose.foundation.layout.SideCalculator
            public /* synthetic */ float showMotion(float f10, float f11) {
                return f.b(this, f10, f11);
            }

            @Override // androidx.compose.foundation.layout.SideCalculator
            public int valueOf(@NotNull Insets insets) {
                t.i(insets, "insets");
                return insets.right;
            }
        };

        @NotNull
        private static final SideCalculator$Companion$BottomSideCalculator$1 BottomSideCalculator = new SideCalculator() { // from class: androidx.compose.foundation.layout.SideCalculator$Companion$BottomSideCalculator$1
            @Override // androidx.compose.foundation.layout.SideCalculator
            @NotNull
            public Insets adjustInsets(@NotNull Insets oldInsets, int i10) {
                t.i(oldInsets, "oldInsets");
                Insets insetsOf = Insets.of(oldInsets.left, oldInsets.top, oldInsets.right, i10);
                t.h(insetsOf, "of(oldInsets.left, oldIn…ldInsets.right, newValue)");
                return insetsOf;
            }

            @Override // androidx.compose.foundation.layout.SideCalculator
            /* JADX INFO: renamed from: consumedOffsets-MK-Hz9U */
            public long mo421consumedOffsetsMKHz9U(long j10) {
                return androidx.compose.ui.geometry.OffsetKt.Offset(0.0f, Offset.m1368getYimpl(j10));
            }

            @Override // androidx.compose.foundation.layout.SideCalculator
            /* JADX INFO: renamed from: consumedVelocity-QWom1Mo */
            public long mo422consumedVelocityQWom1Mo(long j10, float f10) {
                return VelocityKt.Velocity(0.0f, Velocity.m3899getYimpl(j10) + f10);
            }

            @Override // androidx.compose.foundation.layout.SideCalculator
            public /* synthetic */ float hideMotion(float f10, float f11) {
                return f.a(this, f10, f11);
            }

            @Override // androidx.compose.foundation.layout.SideCalculator
            public float motionOf(float f10, float f11) {
                return -f11;
            }

            @Override // androidx.compose.foundation.layout.SideCalculator
            public /* synthetic */ float showMotion(float f10, float f11) {
                return f.b(this, f10, f11);
            }

            @Override // androidx.compose.foundation.layout.SideCalculator
            public int valueOf(@NotNull Insets insets) {
                t.i(insets, "insets");
                return insets.bottom;
            }
        };

        private Companion() {
        }

        @NotNull
        /* JADX INFO: renamed from: chooseCalculator-ni1skBw, reason: not valid java name */
        public final SideCalculator m423chooseCalculatorni1skBw(int i10, @NotNull LayoutDirection layoutDirection) {
            t.i(layoutDirection, "layoutDirection");
            WindowInsetsSides.Companion companion = WindowInsetsSides.Companion;
            if (WindowInsetsSides.m464equalsimpl0(i10, companion.m479getLeftJoeWqyM())) {
                return LeftSideCalculator;
            }
            if (WindowInsetsSides.m464equalsimpl0(i10, companion.m482getTopJoeWqyM())) {
                return TopSideCalculator;
            }
            if (WindowInsetsSides.m464equalsimpl0(i10, companion.m480getRightJoeWqyM())) {
                return RightSideCalculator;
            }
            if (WindowInsetsSides.m464equalsimpl0(i10, companion.m476getBottomJoeWqyM())) {
                return BottomSideCalculator;
            }
            if (WindowInsetsSides.m464equalsimpl0(i10, companion.m481getStartJoeWqyM())) {
                return layoutDirection == LayoutDirection.Ltr ? LeftSideCalculator : RightSideCalculator;
            }
            if (WindowInsetsSides.m464equalsimpl0(i10, companion.m477getEndJoeWqyM())) {
                return layoutDirection == LayoutDirection.Ltr ? RightSideCalculator : LeftSideCalculator;
            }
            throw new IllegalStateException("Only Left, Top, Right, Bottom, Start and End are allowed".toString());
        }
    }

    @NotNull
    Insets adjustInsets(@NotNull Insets insets, int i10);

    /* JADX INFO: renamed from: consumedOffsets-MK-Hz9U, reason: not valid java name */
    long mo421consumedOffsetsMKHz9U(long j10);

    /* JADX INFO: renamed from: consumedVelocity-QWom1Mo, reason: not valid java name */
    long mo422consumedVelocityQWom1Mo(long j10, float f10);

    float hideMotion(float f10, float f11);

    float motionOf(float f10, float f11);

    float showMotion(float f10, float f11);

    int valueOf(@NotNull Insets insets);
}
