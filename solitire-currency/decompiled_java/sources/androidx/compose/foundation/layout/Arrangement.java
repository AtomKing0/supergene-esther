package androidx.compose.foundation.layout;

import androidx.compose.runtime.Immutable;
import androidx.compose.runtime.Stable;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import h9.p;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: Arrangement.kt */
/* JADX INFO: loaded from: classes.dex */
@Immutable
public final class Arrangement {

    @NotNull
    public static final Arrangement INSTANCE = new Arrangement();

    @NotNull
    private static final Horizontal Start = new Horizontal() { // from class: androidx.compose.foundation.layout.Arrangement$Start$1
        @Override // androidx.compose.foundation.layout.Arrangement.Horizontal
        public void arrange(@NotNull Density density, int i10, @NotNull int[] sizes, @NotNull LayoutDirection layoutDirection, @NotNull int[] outPositions) {
            t.i(density, "<this>");
            t.i(sizes, "sizes");
            t.i(layoutDirection, "layoutDirection");
            t.i(outPositions, "outPositions");
            if (layoutDirection == LayoutDirection.Ltr) {
                Arrangement.INSTANCE.placeLeftOrTop$foundation_layout_release(sizes, outPositions, false);
            } else {
                Arrangement.INSTANCE.placeRightOrBottom$foundation_layout_release(i10, sizes, outPositions, true);
            }
        }

        @Override // androidx.compose.foundation.layout.Arrangement.Horizontal, androidx.compose.foundation.layout.Arrangement.Vertical
        /* JADX INFO: renamed from: getSpacing-D9Ej5fM */
        public /* synthetic */ float mo353getSpacingD9Ej5fM() {
            return a.a(this);
        }

        @NotNull
        public String toString() {
            return "Arrangement#Start";
        }
    };

    @NotNull
    private static final Horizontal End = new Horizontal() { // from class: androidx.compose.foundation.layout.Arrangement$End$1
        @Override // androidx.compose.foundation.layout.Arrangement.Horizontal
        public void arrange(@NotNull Density density, int i10, @NotNull int[] sizes, @NotNull LayoutDirection layoutDirection, @NotNull int[] outPositions) {
            t.i(density, "<this>");
            t.i(sizes, "sizes");
            t.i(layoutDirection, "layoutDirection");
            t.i(outPositions, "outPositions");
            if (layoutDirection == LayoutDirection.Ltr) {
                Arrangement.INSTANCE.placeRightOrBottom$foundation_layout_release(i10, sizes, outPositions, false);
            } else {
                Arrangement.INSTANCE.placeLeftOrTop$foundation_layout_release(sizes, outPositions, true);
            }
        }

        @Override // androidx.compose.foundation.layout.Arrangement.Horizontal, androidx.compose.foundation.layout.Arrangement.Vertical
        /* JADX INFO: renamed from: getSpacing-D9Ej5fM */
        public /* synthetic */ float mo353getSpacingD9Ej5fM() {
            return a.a(this);
        }

        @NotNull
        public String toString() {
            return "Arrangement#End";
        }
    };

    @NotNull
    private static final Vertical Top = new Vertical() { // from class: androidx.compose.foundation.layout.Arrangement$Top$1
        @Override // androidx.compose.foundation.layout.Arrangement.Vertical
        public void arrange(@NotNull Density density, int i10, @NotNull int[] sizes, @NotNull int[] outPositions) {
            t.i(density, "<this>");
            t.i(sizes, "sizes");
            t.i(outPositions, "outPositions");
            Arrangement.INSTANCE.placeLeftOrTop$foundation_layout_release(sizes, outPositions, false);
        }

        @Override // androidx.compose.foundation.layout.Arrangement.Vertical
        /* JADX INFO: renamed from: getSpacing-D9Ej5fM */
        public /* synthetic */ float mo353getSpacingD9Ej5fM() {
            return c.a(this);
        }

        @NotNull
        public String toString() {
            return "Arrangement#Top";
        }
    };

    @NotNull
    private static final Vertical Bottom = new Vertical() { // from class: androidx.compose.foundation.layout.Arrangement$Bottom$1
        @Override // androidx.compose.foundation.layout.Arrangement.Vertical
        public void arrange(@NotNull Density density, int i10, @NotNull int[] sizes, @NotNull int[] outPositions) {
            t.i(density, "<this>");
            t.i(sizes, "sizes");
            t.i(outPositions, "outPositions");
            Arrangement.INSTANCE.placeRightOrBottom$foundation_layout_release(i10, sizes, outPositions, false);
        }

        @Override // androidx.compose.foundation.layout.Arrangement.Vertical
        /* JADX INFO: renamed from: getSpacing-D9Ej5fM */
        public /* synthetic */ float mo353getSpacingD9Ej5fM() {
            return c.a(this);
        }

        @NotNull
        public String toString() {
            return "Arrangement#Bottom";
        }
    };

    @NotNull
    private static final HorizontalOrVertical Center = new HorizontalOrVertical() { // from class: androidx.compose.foundation.layout.Arrangement$Center$1
        private final float spacing = Dp.m3673constructorimpl(0);

        @Override // androidx.compose.foundation.layout.Arrangement.Horizontal
        public void arrange(@NotNull Density density, int i10, @NotNull int[] sizes, @NotNull LayoutDirection layoutDirection, @NotNull int[] outPositions) {
            t.i(density, "<this>");
            t.i(sizes, "sizes");
            t.i(layoutDirection, "layoutDirection");
            t.i(outPositions, "outPositions");
            if (layoutDirection == LayoutDirection.Ltr) {
                Arrangement.INSTANCE.placeCenter$foundation_layout_release(i10, sizes, outPositions, false);
            } else {
                Arrangement.INSTANCE.placeCenter$foundation_layout_release(i10, sizes, outPositions, true);
            }
        }

        @Override // androidx.compose.foundation.layout.Arrangement.HorizontalOrVertical, androidx.compose.foundation.layout.Arrangement.Horizontal, androidx.compose.foundation.layout.Arrangement.Vertical
        /* JADX INFO: renamed from: getSpacing-D9Ej5fM */
        public float mo353getSpacingD9Ej5fM() {
            return this.spacing;
        }

        @NotNull
        public String toString() {
            return "Arrangement#Center";
        }

        @Override // androidx.compose.foundation.layout.Arrangement.Vertical
        public void arrange(@NotNull Density density, int i10, @NotNull int[] sizes, @NotNull int[] outPositions) {
            t.i(density, "<this>");
            t.i(sizes, "sizes");
            t.i(outPositions, "outPositions");
            Arrangement.INSTANCE.placeCenter$foundation_layout_release(i10, sizes, outPositions, false);
        }
    };

    @NotNull
    private static final HorizontalOrVertical SpaceEvenly = new HorizontalOrVertical() { // from class: androidx.compose.foundation.layout.Arrangement$SpaceEvenly$1
        private final float spacing = Dp.m3673constructorimpl(0);

        @Override // androidx.compose.foundation.layout.Arrangement.Horizontal
        public void arrange(@NotNull Density density, int i10, @NotNull int[] sizes, @NotNull LayoutDirection layoutDirection, @NotNull int[] outPositions) {
            t.i(density, "<this>");
            t.i(sizes, "sizes");
            t.i(layoutDirection, "layoutDirection");
            t.i(outPositions, "outPositions");
            if (layoutDirection == LayoutDirection.Ltr) {
                Arrangement.INSTANCE.placeSpaceEvenly$foundation_layout_release(i10, sizes, outPositions, false);
            } else {
                Arrangement.INSTANCE.placeSpaceEvenly$foundation_layout_release(i10, sizes, outPositions, true);
            }
        }

        @Override // androidx.compose.foundation.layout.Arrangement.HorizontalOrVertical, androidx.compose.foundation.layout.Arrangement.Horizontal, androidx.compose.foundation.layout.Arrangement.Vertical
        /* JADX INFO: renamed from: getSpacing-D9Ej5fM */
        public float mo353getSpacingD9Ej5fM() {
            return this.spacing;
        }

        @NotNull
        public String toString() {
            return "Arrangement#SpaceEvenly";
        }

        @Override // androidx.compose.foundation.layout.Arrangement.Vertical
        public void arrange(@NotNull Density density, int i10, @NotNull int[] sizes, @NotNull int[] outPositions) {
            t.i(density, "<this>");
            t.i(sizes, "sizes");
            t.i(outPositions, "outPositions");
            Arrangement.INSTANCE.placeSpaceEvenly$foundation_layout_release(i10, sizes, outPositions, false);
        }
    };

    @NotNull
    private static final HorizontalOrVertical SpaceBetween = new HorizontalOrVertical() { // from class: androidx.compose.foundation.layout.Arrangement$SpaceBetween$1
        private final float spacing = Dp.m3673constructorimpl(0);

        @Override // androidx.compose.foundation.layout.Arrangement.Horizontal
        public void arrange(@NotNull Density density, int i10, @NotNull int[] sizes, @NotNull LayoutDirection layoutDirection, @NotNull int[] outPositions) {
            t.i(density, "<this>");
            t.i(sizes, "sizes");
            t.i(layoutDirection, "layoutDirection");
            t.i(outPositions, "outPositions");
            if (layoutDirection == LayoutDirection.Ltr) {
                Arrangement.INSTANCE.placeSpaceBetween$foundation_layout_release(i10, sizes, outPositions, false);
            } else {
                Arrangement.INSTANCE.placeSpaceBetween$foundation_layout_release(i10, sizes, outPositions, true);
            }
        }

        @Override // androidx.compose.foundation.layout.Arrangement.HorizontalOrVertical, androidx.compose.foundation.layout.Arrangement.Horizontal, androidx.compose.foundation.layout.Arrangement.Vertical
        /* JADX INFO: renamed from: getSpacing-D9Ej5fM */
        public float mo353getSpacingD9Ej5fM() {
            return this.spacing;
        }

        @NotNull
        public String toString() {
            return "Arrangement#SpaceBetween";
        }

        @Override // androidx.compose.foundation.layout.Arrangement.Vertical
        public void arrange(@NotNull Density density, int i10, @NotNull int[] sizes, @NotNull int[] outPositions) {
            t.i(density, "<this>");
            t.i(sizes, "sizes");
            t.i(outPositions, "outPositions");
            Arrangement.INSTANCE.placeSpaceBetween$foundation_layout_release(i10, sizes, outPositions, false);
        }
    };

    @NotNull
    private static final HorizontalOrVertical SpaceAround = new HorizontalOrVertical() { // from class: androidx.compose.foundation.layout.Arrangement$SpaceAround$1
        private final float spacing = Dp.m3673constructorimpl(0);

        @Override // androidx.compose.foundation.layout.Arrangement.Horizontal
        public void arrange(@NotNull Density density, int i10, @NotNull int[] sizes, @NotNull LayoutDirection layoutDirection, @NotNull int[] outPositions) {
            t.i(density, "<this>");
            t.i(sizes, "sizes");
            t.i(layoutDirection, "layoutDirection");
            t.i(outPositions, "outPositions");
            if (layoutDirection == LayoutDirection.Ltr) {
                Arrangement.INSTANCE.placeSpaceAround$foundation_layout_release(i10, sizes, outPositions, false);
            } else {
                Arrangement.INSTANCE.placeSpaceAround$foundation_layout_release(i10, sizes, outPositions, true);
            }
        }

        @Override // androidx.compose.foundation.layout.Arrangement.HorizontalOrVertical, androidx.compose.foundation.layout.Arrangement.Horizontal, androidx.compose.foundation.layout.Arrangement.Vertical
        /* JADX INFO: renamed from: getSpacing-D9Ej5fM */
        public float mo353getSpacingD9Ej5fM() {
            return this.spacing;
        }

        @NotNull
        public String toString() {
            return "Arrangement#SpaceAround";
        }

        @Override // androidx.compose.foundation.layout.Arrangement.Vertical
        public void arrange(@NotNull Density density, int i10, @NotNull int[] sizes, @NotNull int[] outPositions) {
            t.i(density, "<this>");
            t.i(sizes, "sizes");
            t.i(outPositions, "outPositions");
            Arrangement.INSTANCE.placeSpaceAround$foundation_layout_release(i10, sizes, outPositions, false);
        }
    };

    /* JADX INFO: compiled from: Arrangement.kt */
    @Immutable
    public static final class Absolute {

        @NotNull
        public static final Absolute INSTANCE = new Absolute();

        @NotNull
        private static final Horizontal Left = new Horizontal() { // from class: androidx.compose.foundation.layout.Arrangement$Absolute$Left$1
            @Override // androidx.compose.foundation.layout.Arrangement.Horizontal
            public void arrange(@NotNull Density density, int i10, @NotNull int[] sizes, @NotNull LayoutDirection layoutDirection, @NotNull int[] outPositions) {
                t.i(density, "<this>");
                t.i(sizes, "sizes");
                t.i(layoutDirection, "layoutDirection");
                t.i(outPositions, "outPositions");
                Arrangement.INSTANCE.placeLeftOrTop$foundation_layout_release(sizes, outPositions, false);
            }

            @Override // androidx.compose.foundation.layout.Arrangement.Horizontal, androidx.compose.foundation.layout.Arrangement.Vertical
            /* JADX INFO: renamed from: getSpacing-D9Ej5fM */
            public /* synthetic */ float mo353getSpacingD9Ej5fM() {
                return a.a(this);
            }

            @NotNull
            public String toString() {
                return "AbsoluteArrangement#Left";
            }
        };

        @NotNull
        private static final Horizontal Center = new Horizontal() { // from class: androidx.compose.foundation.layout.Arrangement$Absolute$Center$1
            @Override // androidx.compose.foundation.layout.Arrangement.Horizontal
            public void arrange(@NotNull Density density, int i10, @NotNull int[] sizes, @NotNull LayoutDirection layoutDirection, @NotNull int[] outPositions) {
                t.i(density, "<this>");
                t.i(sizes, "sizes");
                t.i(layoutDirection, "layoutDirection");
                t.i(outPositions, "outPositions");
                Arrangement.INSTANCE.placeCenter$foundation_layout_release(i10, sizes, outPositions, false);
            }

            @Override // androidx.compose.foundation.layout.Arrangement.Horizontal, androidx.compose.foundation.layout.Arrangement.Vertical
            /* JADX INFO: renamed from: getSpacing-D9Ej5fM, reason: not valid java name */
            public /* synthetic */ float mo353getSpacingD9Ej5fM() {
                return a.a(this);
            }

            @NotNull
            public String toString() {
                return "AbsoluteArrangement#Center";
            }
        };

        @NotNull
        private static final Horizontal Right = new Horizontal() { // from class: androidx.compose.foundation.layout.Arrangement$Absolute$Right$1
            @Override // androidx.compose.foundation.layout.Arrangement.Horizontal
            public void arrange(@NotNull Density density, int i10, @NotNull int[] sizes, @NotNull LayoutDirection layoutDirection, @NotNull int[] outPositions) {
                t.i(density, "<this>");
                t.i(sizes, "sizes");
                t.i(layoutDirection, "layoutDirection");
                t.i(outPositions, "outPositions");
                Arrangement.INSTANCE.placeRightOrBottom$foundation_layout_release(i10, sizes, outPositions, false);
            }

            @Override // androidx.compose.foundation.layout.Arrangement.Horizontal, androidx.compose.foundation.layout.Arrangement.Vertical
            /* JADX INFO: renamed from: getSpacing-D9Ej5fM */
            public /* synthetic */ float mo353getSpacingD9Ej5fM() {
                return a.a(this);
            }

            @NotNull
            public String toString() {
                return "AbsoluteArrangement#Right";
            }
        };

        @NotNull
        private static final Horizontal SpaceBetween = new Horizontal() { // from class: androidx.compose.foundation.layout.Arrangement$Absolute$SpaceBetween$1
            @Override // androidx.compose.foundation.layout.Arrangement.Horizontal
            public void arrange(@NotNull Density density, int i10, @NotNull int[] sizes, @NotNull LayoutDirection layoutDirection, @NotNull int[] outPositions) {
                t.i(density, "<this>");
                t.i(sizes, "sizes");
                t.i(layoutDirection, "layoutDirection");
                t.i(outPositions, "outPositions");
                Arrangement.INSTANCE.placeSpaceBetween$foundation_layout_release(i10, sizes, outPositions, false);
            }

            @Override // androidx.compose.foundation.layout.Arrangement.Horizontal, androidx.compose.foundation.layout.Arrangement.Vertical
            /* JADX INFO: renamed from: getSpacing-D9Ej5fM */
            public /* synthetic */ float mo353getSpacingD9Ej5fM() {
                return a.a(this);
            }

            @NotNull
            public String toString() {
                return "AbsoluteArrangement#SpaceBetween";
            }
        };

        @NotNull
        private static final Horizontal SpaceEvenly = new Horizontal() { // from class: androidx.compose.foundation.layout.Arrangement$Absolute$SpaceEvenly$1
            @Override // androidx.compose.foundation.layout.Arrangement.Horizontal
            public void arrange(@NotNull Density density, int i10, @NotNull int[] sizes, @NotNull LayoutDirection layoutDirection, @NotNull int[] outPositions) {
                t.i(density, "<this>");
                t.i(sizes, "sizes");
                t.i(layoutDirection, "layoutDirection");
                t.i(outPositions, "outPositions");
                Arrangement.INSTANCE.placeSpaceEvenly$foundation_layout_release(i10, sizes, outPositions, false);
            }

            @Override // androidx.compose.foundation.layout.Arrangement.Horizontal, androidx.compose.foundation.layout.Arrangement.Vertical
            /* JADX INFO: renamed from: getSpacing-D9Ej5fM */
            public /* synthetic */ float mo353getSpacingD9Ej5fM() {
                return a.a(this);
            }

            @NotNull
            public String toString() {
                return "AbsoluteArrangement#SpaceEvenly";
            }
        };

        @NotNull
        private static final Horizontal SpaceAround = new Horizontal() { // from class: androidx.compose.foundation.layout.Arrangement$Absolute$SpaceAround$1
            @Override // androidx.compose.foundation.layout.Arrangement.Horizontal
            public void arrange(@NotNull Density density, int i10, @NotNull int[] sizes, @NotNull LayoutDirection layoutDirection, @NotNull int[] outPositions) {
                t.i(density, "<this>");
                t.i(sizes, "sizes");
                t.i(layoutDirection, "layoutDirection");
                t.i(outPositions, "outPositions");
                Arrangement.INSTANCE.placeSpaceAround$foundation_layout_release(i10, sizes, outPositions, false);
            }

            @Override // androidx.compose.foundation.layout.Arrangement.Horizontal, androidx.compose.foundation.layout.Arrangement.Vertical
            /* JADX INFO: renamed from: getSpacing-D9Ej5fM */
            public /* synthetic */ float mo353getSpacingD9Ej5fM() {
                return a.a(this);
            }

            @NotNull
            public String toString() {
                return "AbsoluteArrangement#SpaceAround";
            }
        };

        private Absolute() {
        }

        @Stable
        @NotNull
        public final Horizontal aligned(@NotNull Alignment.Horizontal alignment) {
            t.i(alignment, "alignment");
            return new SpacedAligned(Dp.m3673constructorimpl(0), false, new Arrangement$Absolute$aligned$1(alignment), null);
        }

        @NotNull
        public final Horizontal getCenter() {
            return Center;
        }

        @NotNull
        public final Horizontal getLeft() {
            return Left;
        }

        @NotNull
        public final Horizontal getRight() {
            return Right;
        }

        @NotNull
        public final Horizontal getSpaceAround() {
            return SpaceAround;
        }

        @NotNull
        public final Horizontal getSpaceBetween() {
            return SpaceBetween;
        }

        @NotNull
        public final Horizontal getSpaceEvenly() {
            return SpaceEvenly;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Stable
        @NotNull
        /* JADX INFO: renamed from: spacedBy-0680j_4, reason: not valid java name */
        public final HorizontalOrVertical m350spacedBy0680j_4(float f10) {
            return new SpacedAligned(f10, false, null, 0 == true ? 1 : 0);
        }

        @Stable
        @NotNull
        /* JADX INFO: renamed from: spacedBy-D5KLDUw, reason: not valid java name */
        public final Horizontal m351spacedByD5KLDUw(float f10, @NotNull Alignment.Horizontal alignment) {
            t.i(alignment, "alignment");
            return new SpacedAligned(f10, false, new Arrangement$Absolute$spacedBy$1(alignment), null);
        }

        @Stable
        @NotNull
        /* JADX INFO: renamed from: spacedBy-D5KLDUw, reason: not valid java name */
        public final Vertical m352spacedByD5KLDUw(float f10, @NotNull Alignment.Vertical alignment) {
            t.i(alignment, "alignment");
            return new SpacedAligned(f10, false, new Arrangement$Absolute$spacedBy$2(alignment), null);
        }

        @Stable
        public static /* synthetic */ void getCenter$annotations() {
        }

        @Stable
        public static /* synthetic */ void getLeft$annotations() {
        }

        @Stable
        public static /* synthetic */ void getRight$annotations() {
        }

        @Stable
        public static /* synthetic */ void getSpaceAround$annotations() {
        }

        @Stable
        public static /* synthetic */ void getSpaceBetween$annotations() {
        }

        @Stable
        public static /* synthetic */ void getSpaceEvenly$annotations() {
        }
    }

    /* JADX INFO: compiled from: Arrangement.kt */
    @Stable
    public interface Horizontal {

        /* JADX INFO: compiled from: Arrangement.kt */
        public static final class DefaultImpls {
            @Deprecated
            /* JADX INFO: renamed from: getSpacing-D9Ej5fM, reason: not valid java name */
            public static float m354getSpacingD9Ej5fM(@NotNull Horizontal horizontal) {
                return a.a(horizontal);
            }
        }

        void arrange(@NotNull Density density, int i10, @NotNull int[] iArr, @NotNull LayoutDirection layoutDirection, @NotNull int[] iArr2);

        /* JADX INFO: renamed from: getSpacing-D9Ej5fM */
        float mo353getSpacingD9Ej5fM();
    }

    /* JADX INFO: compiled from: Arrangement.kt */
    @Stable
    public interface HorizontalOrVertical extends Horizontal, Vertical {

        /* JADX INFO: compiled from: Arrangement.kt */
        public static final class DefaultImpls {
            @Deprecated
            /* JADX INFO: renamed from: getSpacing-D9Ej5fM, reason: not valid java name */
            public static float m355getSpacingD9Ej5fM(@NotNull HorizontalOrVertical horizontalOrVertical) {
                return b.a(horizontalOrVertical);
            }
        }

        @Override // androidx.compose.foundation.layout.Arrangement.Horizontal, androidx.compose.foundation.layout.Arrangement.Vertical
        /* JADX INFO: renamed from: getSpacing-D9Ej5fM */
        float mo353getSpacingD9Ej5fM();
    }

    /* JADX INFO: compiled from: Arrangement.kt */
    @Immutable
    public static final class SpacedAligned implements HorizontalOrVertical {

        @Nullable
        private final p<Integer, LayoutDirection, Integer> alignment;
        private final boolean rtlMirror;
        private final float space;
        private final float spacing;

        public /* synthetic */ SpacedAligned(float f10, boolean z10, p pVar, kotlin.jvm.internal.k kVar) {
            this(f10, z10, pVar);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX INFO: renamed from: copy-8Feqmps$default, reason: not valid java name */
        public static /* synthetic */ SpacedAligned m356copy8Feqmps$default(SpacedAligned spacedAligned, float f10, boolean z10, p pVar, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                f10 = spacedAligned.space;
            }
            if ((i10 & 2) != 0) {
                z10 = spacedAligned.rtlMirror;
            }
            if ((i10 & 4) != 0) {
                pVar = spacedAligned.alignment;
            }
            return spacedAligned.m358copy8Feqmps(f10, z10, pVar);
        }

        @Override // androidx.compose.foundation.layout.Arrangement.Horizontal
        public void arrange(@NotNull Density density, int i10, @NotNull int[] sizes, @NotNull LayoutDirection layoutDirection, @NotNull int[] outPositions) {
            int i11;
            int iMin;
            t.i(density, "<this>");
            t.i(sizes, "sizes");
            t.i(layoutDirection, "layoutDirection");
            t.i(outPositions, "outPositions");
            if (sizes.length == 0) {
                return;
            }
            int iMo290roundToPx0680j_4 = density.mo290roundToPx0680j_4(this.space);
            boolean z10 = this.rtlMirror && layoutDirection == LayoutDirection.Rtl;
            Arrangement arrangement = Arrangement.INSTANCE;
            if (z10) {
                i11 = 0;
                iMin = 0;
                for (int length = sizes.length - 1; -1 < length; length--) {
                    int i12 = sizes[length];
                    int iMin2 = Math.min(i11, i10 - i12);
                    outPositions[length] = iMin2;
                    iMin = Math.min(iMo290roundToPx0680j_4, (i10 - iMin2) - i12);
                    i11 = outPositions[length] + i12 + iMin;
                }
            } else {
                int length2 = sizes.length;
                int i13 = 0;
                i11 = 0;
                iMin = 0;
                int i14 = 0;
                while (i13 < length2) {
                    int i15 = sizes[i13];
                    int iMin3 = Math.min(i11, i10 - i15);
                    outPositions[i14] = iMin3;
                    int iMin4 = Math.min(iMo290roundToPx0680j_4, (i10 - iMin3) - i15);
                    int i16 = outPositions[i14] + i15 + iMin4;
                    i13++;
                    i14++;
                    iMin = iMin4;
                    i11 = i16;
                }
            }
            int i17 = i11 - iMin;
            p<Integer, LayoutDirection, Integer> pVar = this.alignment;
            if (pVar == null || i17 >= i10) {
                return;
            }
            int iIntValue = pVar.mo4invoke(Integer.valueOf(i10 - i17), layoutDirection).intValue();
            int length3 = outPositions.length;
            for (int i18 = 0; i18 < length3; i18++) {
                outPositions[i18] = outPositions[i18] + iIntValue;
            }
        }

        /* JADX INFO: renamed from: component1-D9Ej5fM, reason: not valid java name */
        public final float m357component1D9Ej5fM() {
            return this.space;
        }

        public final boolean component2() {
            return this.rtlMirror;
        }

        @Nullable
        public final p<Integer, LayoutDirection, Integer> component3() {
            return this.alignment;
        }

        @NotNull
        /* JADX INFO: renamed from: copy-8Feqmps, reason: not valid java name */
        public final SpacedAligned m358copy8Feqmps(float f10, boolean z10, @Nullable p<? super Integer, ? super LayoutDirection, Integer> pVar) {
            return new SpacedAligned(f10, z10, pVar, null);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof SpacedAligned)) {
                return false;
            }
            SpacedAligned spacedAligned = (SpacedAligned) obj;
            return Dp.m3678equalsimpl0(this.space, spacedAligned.space) && this.rtlMirror == spacedAligned.rtlMirror && t.d(this.alignment, spacedAligned.alignment);
        }

        @Nullable
        public final p<Integer, LayoutDirection, Integer> getAlignment() {
            return this.alignment;
        }

        public final boolean getRtlMirror() {
            return this.rtlMirror;
        }

        /* JADX INFO: renamed from: getSpace-D9Ej5fM, reason: not valid java name */
        public final float m359getSpaceD9Ej5fM() {
            return this.space;
        }

        @Override // androidx.compose.foundation.layout.Arrangement.HorizontalOrVertical, androidx.compose.foundation.layout.Arrangement.Horizontal, androidx.compose.foundation.layout.Arrangement.Vertical
        /* JADX INFO: renamed from: getSpacing-D9Ej5fM */
        public float mo353getSpacingD9Ej5fM() {
            return this.spacing;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v1, types: [int] */
        /* JADX WARN: Type inference failed for: r1v6 */
        /* JADX WARN: Type inference failed for: r1v7 */
        public int hashCode() {
            int iM3679hashCodeimpl = Dp.m3679hashCodeimpl(this.space) * 31;
            boolean z10 = this.rtlMirror;
            ?? r12 = z10;
            if (z10) {
                r12 = 1;
            }
            int i10 = (iM3679hashCodeimpl + r12) * 31;
            p<Integer, LayoutDirection, Integer> pVar = this.alignment;
            return i10 + (pVar == null ? 0 : pVar.hashCode());
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.rtlMirror ? "" : "Absolute");
            sb.append("Arrangement#spacedAligned(");
            sb.append((Object) Dp.m3684toStringimpl(this.space));
            sb.append(", ");
            sb.append(this.alignment);
            sb.append(')');
            return sb.toString();
        }

        /* JADX WARN: Multi-variable type inference failed */
        private SpacedAligned(float f10, boolean z10, p<? super Integer, ? super LayoutDirection, Integer> pVar) {
            this.space = f10;
            this.rtlMirror = z10;
            this.alignment = pVar;
            this.spacing = f10;
        }

        @Override // androidx.compose.foundation.layout.Arrangement.Vertical
        public void arrange(@NotNull Density density, int i10, @NotNull int[] sizes, @NotNull int[] outPositions) {
            t.i(density, "<this>");
            t.i(sizes, "sizes");
            t.i(outPositions, "outPositions");
            arrange(density, i10, sizes, LayoutDirection.Ltr, outPositions);
        }
    }

    /* JADX INFO: compiled from: Arrangement.kt */
    @Stable
    public interface Vertical {

        /* JADX INFO: compiled from: Arrangement.kt */
        public static final class DefaultImpls {
            @Deprecated
            /* JADX INFO: renamed from: getSpacing-D9Ej5fM, reason: not valid java name */
            public static float m360getSpacingD9Ej5fM(@NotNull Vertical vertical) {
                return c.a(vertical);
            }
        }

        void arrange(@NotNull Density density, int i10, @NotNull int[] iArr, @NotNull int[] iArr2);

        /* JADX INFO: renamed from: getSpacing-D9Ej5fM */
        float mo353getSpacingD9Ej5fM();
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.layout.Arrangement$aligned$1, reason: invalid class name */
    /* JADX INFO: compiled from: Arrangement.kt */
    static final class AnonymousClass1 extends v implements p<Integer, LayoutDirection, Integer> {
        final /* synthetic */ Alignment.Horizontal $alignment;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Alignment.Horizontal horizontal) {
            super(2);
            this.$alignment = horizontal;
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Integer mo4invoke(Integer num, LayoutDirection layoutDirection) {
            return invoke(num.intValue(), layoutDirection);
        }

        @NotNull
        public final Integer invoke(int i10, @NotNull LayoutDirection layoutDirection) {
            t.i(layoutDirection, "layoutDirection");
            return Integer.valueOf(this.$alignment.align(0, i10, layoutDirection));
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.layout.Arrangement$aligned$2, reason: invalid class name */
    /* JADX INFO: compiled from: Arrangement.kt */
    static final class AnonymousClass2 extends v implements p<Integer, LayoutDirection, Integer> {
        final /* synthetic */ Alignment.Vertical $alignment;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(Alignment.Vertical vertical) {
            super(2);
            this.$alignment = vertical;
        }

        @NotNull
        public final Integer invoke(int i10, @NotNull LayoutDirection layoutDirection) {
            t.i(layoutDirection, "<anonymous parameter 1>");
            return Integer.valueOf(this.$alignment.align(0, i10));
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Integer mo4invoke(Integer num, LayoutDirection layoutDirection) {
            return invoke(num.intValue(), layoutDirection);
        }
    }

    private Arrangement() {
    }

    private final void forEachIndexed(int[] iArr, boolean z10, p<? super Integer, ? super Integer, k0> pVar) {
        if (!z10) {
            int length = iArr.length;
            int i10 = 0;
            int i11 = 0;
            while (i10 < length) {
                pVar.mo4invoke(Integer.valueOf(i11), Integer.valueOf(iArr[i10]));
                i10++;
                i11++;
            }
            return;
        }
        int length2 = iArr.length;
        while (true) {
            length2--;
            if (-1 >= length2) {
                return;
            } else {
                pVar.mo4invoke(Integer.valueOf(length2), Integer.valueOf(iArr[length2]));
            }
        }
    }

    @Stable
    @NotNull
    public final Horizontal aligned(@NotNull Alignment.Horizontal alignment) {
        t.i(alignment, "alignment");
        return new SpacedAligned(Dp.m3673constructorimpl(0), true, new AnonymousClass1(alignment), null);
    }

    @NotNull
    public final Vertical getBottom() {
        return Bottom;
    }

    @NotNull
    public final HorizontalOrVertical getCenter() {
        return Center;
    }

    @NotNull
    public final Horizontal getEnd() {
        return End;
    }

    @NotNull
    public final HorizontalOrVertical getSpaceAround() {
        return SpaceAround;
    }

    @NotNull
    public final HorizontalOrVertical getSpaceBetween() {
        return SpaceBetween;
    }

    @NotNull
    public final HorizontalOrVertical getSpaceEvenly() {
        return SpaceEvenly;
    }

    @NotNull
    public final Horizontal getStart() {
        return Start;
    }

    @NotNull
    public final Vertical getTop() {
        return Top;
    }

    public final void placeCenter$foundation_layout_release(int i10, @NotNull int[] size, @NotNull int[] outPosition, boolean z10) {
        t.i(size, "size");
        t.i(outPosition, "outPosition");
        int i11 = 0;
        int i12 = 0;
        for (int i13 : size) {
            i12 += i13;
        }
        float f10 = (i10 - i12) / 2;
        if (!z10) {
            int length = size.length;
            int i14 = 0;
            while (i11 < length) {
                int i15 = size[i11];
                outPosition[i14] = j9.c.c(f10);
                f10 += i15;
                i11++;
                i14++;
            }
            return;
        }
        int length2 = size.length;
        while (true) {
            length2--;
            if (-1 >= length2) {
                return;
            }
            int i16 = size[length2];
            outPosition[length2] = j9.c.c(f10);
            f10 += i16;
        }
    }

    public final void placeLeftOrTop$foundation_layout_release(@NotNull int[] size, @NotNull int[] outPosition, boolean z10) {
        t.i(size, "size");
        t.i(outPosition, "outPosition");
        int i10 = 0;
        if (!z10) {
            int length = size.length;
            int i11 = 0;
            int i12 = 0;
            while (i10 < length) {
                int i13 = size[i10];
                outPosition[i11] = i12;
                i12 += i13;
                i10++;
                i11++;
            }
            return;
        }
        int length2 = size.length;
        while (true) {
            length2--;
            if (-1 >= length2) {
                return;
            }
            int i14 = size[length2];
            outPosition[length2] = i10;
            i10 += i14;
        }
    }

    public final void placeRightOrBottom$foundation_layout_release(int i10, @NotNull int[] size, @NotNull int[] outPosition, boolean z10) {
        t.i(size, "size");
        t.i(outPosition, "outPosition");
        int i11 = 0;
        int i12 = 0;
        for (int i13 : size) {
            i12 += i13;
        }
        int i14 = i10 - i12;
        if (!z10) {
            int length = size.length;
            int i15 = 0;
            while (i11 < length) {
                int i16 = size[i11];
                outPosition[i15] = i14;
                i14 += i16;
                i11++;
                i15++;
            }
            return;
        }
        int length2 = size.length;
        while (true) {
            length2--;
            if (-1 >= length2) {
                return;
            }
            int i17 = size[length2];
            outPosition[length2] = i14;
            i14 += i17;
        }
    }

    public final void placeSpaceAround$foundation_layout_release(int i10, @NotNull int[] size, @NotNull int[] outPosition, boolean z10) {
        t.i(size, "size");
        t.i(outPosition, "outPosition");
        int i11 = 0;
        int i12 = 0;
        for (int i13 : size) {
            i12 += i13;
        }
        float length = (size.length == 0) ^ true ? (i10 - i12) / size.length : 0.0f;
        float f10 = length / 2;
        if (z10) {
            for (int length2 = size.length - 1; -1 < length2; length2--) {
                int i14 = size[length2];
                outPosition[length2] = j9.c.c(f10);
                f10 += i14 + length;
            }
            return;
        }
        int length3 = size.length;
        int i15 = 0;
        while (i11 < length3) {
            int i16 = size[i11];
            outPosition[i15] = j9.c.c(f10);
            f10 += i16 + length;
            i11++;
            i15++;
        }
    }

    public final void placeSpaceBetween$foundation_layout_release(int i10, @NotNull int[] size, @NotNull int[] outPosition, boolean z10) {
        t.i(size, "size");
        t.i(outPosition, "outPosition");
        int i11 = 0;
        int i12 = 0;
        for (int i13 : size) {
            i12 += i13;
        }
        float f10 = 0.0f;
        float length = size.length > 1 ? (i10 - i12) / (size.length - 1) : 0.0f;
        if (z10) {
            for (int length2 = size.length - 1; -1 < length2; length2--) {
                int i14 = size[length2];
                outPosition[length2] = j9.c.c(f10);
                f10 += i14 + length;
            }
            return;
        }
        int length3 = size.length;
        int i15 = 0;
        while (i11 < length3) {
            int i16 = size[i11];
            outPosition[i15] = j9.c.c(f10);
            f10 += i16 + length;
            i11++;
            i15++;
        }
    }

    public final void placeSpaceEvenly$foundation_layout_release(int i10, @NotNull int[] size, @NotNull int[] outPosition, boolean z10) {
        t.i(size, "size");
        t.i(outPosition, "outPosition");
        int i11 = 0;
        int i12 = 0;
        for (int i13 : size) {
            i12 += i13;
        }
        float length = (i10 - i12) / (size.length + 1);
        if (z10) {
            float f10 = length;
            for (int length2 = size.length - 1; -1 < length2; length2--) {
                int i14 = size[length2];
                outPosition[length2] = j9.c.c(f10);
                f10 += i14 + length;
            }
            return;
        }
        int length3 = size.length;
        float f11 = length;
        int i15 = 0;
        while (i11 < length3) {
            int i16 = size[i11];
            outPosition[i15] = j9.c.c(f11);
            f11 += i16 + length;
            i11++;
            i15++;
        }
    }

    @Stable
    @NotNull
    /* JADX INFO: renamed from: spacedBy-0680j_4, reason: not valid java name */
    public final HorizontalOrVertical m347spacedBy0680j_4(float f10) {
        return new SpacedAligned(f10, true, Arrangement$spacedBy$1.INSTANCE, null);
    }

    @Stable
    @NotNull
    /* JADX INFO: renamed from: spacedBy-D5KLDUw, reason: not valid java name */
    public final Horizontal m348spacedByD5KLDUw(float f10, @NotNull Alignment.Horizontal alignment) {
        t.i(alignment, "alignment");
        return new SpacedAligned(f10, true, new Arrangement$spacedBy$2(alignment), null);
    }

    @Stable
    @NotNull
    /* JADX INFO: renamed from: spacedBy-D5KLDUw, reason: not valid java name */
    public final Vertical m349spacedByD5KLDUw(float f10, @NotNull Alignment.Vertical alignment) {
        t.i(alignment, "alignment");
        return new SpacedAligned(f10, false, new Arrangement$spacedBy$3(alignment), null);
    }

    @Stable
    @NotNull
    public final Vertical aligned(@NotNull Alignment.Vertical alignment) {
        t.i(alignment, "alignment");
        return new SpacedAligned(Dp.m3673constructorimpl(0), false, new AnonymousClass2(alignment), null);
    }

    @Stable
    public static /* synthetic */ void getBottom$annotations() {
    }

    @Stable
    public static /* synthetic */ void getCenter$annotations() {
    }

    @Stable
    public static /* synthetic */ void getEnd$annotations() {
    }

    @Stable
    public static /* synthetic */ void getSpaceAround$annotations() {
    }

    @Stable
    public static /* synthetic */ void getSpaceBetween$annotations() {
    }

    @Stable
    public static /* synthetic */ void getSpaceEvenly$annotations() {
    }

    @Stable
    public static /* synthetic */ void getStart$annotations() {
    }

    @Stable
    public static /* synthetic */ void getTop$annotations() {
    }
}
