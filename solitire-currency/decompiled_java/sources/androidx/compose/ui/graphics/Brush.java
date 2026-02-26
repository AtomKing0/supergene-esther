package androidx.compose.ui.graphics;

import androidx.compose.runtime.Immutable;
import androidx.compose.runtime.Stable;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Brush.kt */
/* JADX INFO: loaded from: classes.dex */
@Immutable
public abstract class Brush {

    @NotNull
    public static final Companion Companion = new Companion(null);
    private final long intrinsicSize;

    /* JADX INFO: compiled from: Brush.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.k kVar) {
            this();
        }

        /* JADX INFO: renamed from: horizontalGradient-8A-3gB4$default, reason: not valid java name */
        public static /* synthetic */ Brush m1553horizontalGradient8A3gB4$default(Companion companion, List list, float f10, float f11, int i10, int i11, Object obj) {
            if ((i11 & 2) != 0) {
                f10 = 0.0f;
            }
            if ((i11 & 4) != 0) {
                f11 = Float.POSITIVE_INFINITY;
            }
            if ((i11 & 8) != 0) {
                i10 = TileMode.Companion.m1905getClamp3opZhB0();
            }
            return companion.m1563horizontalGradient8A3gB4((List<Color>) list, f10, f11, i10);
        }

        /* JADX INFO: renamed from: linearGradient-mHitzGk$default, reason: not valid java name */
        public static /* synthetic */ Brush m1556linearGradientmHitzGk$default(Companion companion, v8.s[] sVarArr, long j10, long j11, int i10, int i11, Object obj) {
            if ((i11 & 2) != 0) {
                j10 = Offset.Companion.m1383getZeroF1C5BW0();
            }
            long j12 = j10;
            if ((i11 & 4) != 0) {
                j11 = Offset.Companion.m1381getInfiniteF1C5BW0();
            }
            long j13 = j11;
            if ((i11 & 8) != 0) {
                i10 = TileMode.Companion.m1905getClamp3opZhB0();
            }
            return companion.m1566linearGradientmHitzGk((v8.s<Float, Color>[]) sVarArr, j12, j13, i10);
        }

        /* JADX INFO: renamed from: radialGradient-P_Vx-Ks$default, reason: not valid java name */
        public static /* synthetic */ Brush m1558radialGradientP_VxKs$default(Companion companion, v8.s[] sVarArr, long j10, float f10, int i10, int i11, Object obj) {
            if ((i11 & 2) != 0) {
                j10 = Offset.Companion.m1382getUnspecifiedF1C5BW0();
            }
            long j11 = j10;
            if ((i11 & 4) != 0) {
                f10 = Float.POSITIVE_INFINITY;
            }
            float f11 = f10;
            if ((i11 & 8) != 0) {
                i10 = TileMode.Companion.m1905getClamp3opZhB0();
            }
            return companion.m1568radialGradientP_VxKs((v8.s<Float, Color>[]) sVarArr, j11, f11, i10);
        }

        /* JADX INFO: renamed from: sweepGradient-Uv8p0NA$default, reason: not valid java name */
        public static /* synthetic */ Brush m1560sweepGradientUv8p0NA$default(Companion companion, v8.s[] sVarArr, long j10, int i10, Object obj) {
            if ((i10 & 2) != 0) {
                j10 = Offset.Companion.m1382getUnspecifiedF1C5BW0();
            }
            return companion.m1570sweepGradientUv8p0NA((v8.s<Float, Color>[]) sVarArr, j10);
        }

        /* JADX INFO: renamed from: verticalGradient-8A-3gB4$default, reason: not valid java name */
        public static /* synthetic */ Brush m1561verticalGradient8A3gB4$default(Companion companion, List list, float f10, float f11, int i10, int i11, Object obj) {
            if ((i11 & 2) != 0) {
                f10 = 0.0f;
            }
            if ((i11 & 4) != 0) {
                f11 = Float.POSITIVE_INFINITY;
            }
            if ((i11 & 8) != 0) {
                i10 = TileMode.Companion.m1905getClamp3opZhB0();
            }
            return companion.m1571verticalGradient8A3gB4((List<Color>) list, f10, f11, i10);
        }

        @Stable
        @NotNull
        /* JADX INFO: renamed from: horizontalGradient-8A-3gB4, reason: not valid java name */
        public final Brush m1563horizontalGradient8A3gB4(@NotNull List<Color> colors, float f10, float f11, int i10) {
            kotlin.jvm.internal.t.i(colors, "colors");
            return m1565linearGradientmHitzGk(colors, OffsetKt.Offset(f10, 0.0f), OffsetKt.Offset(f11, 0.0f), i10);
        }

        @Stable
        @NotNull
        /* JADX INFO: renamed from: linearGradient-mHitzGk, reason: not valid java name */
        public final Brush m1566linearGradientmHitzGk(@NotNull v8.s<Float, Color>[] colorStops, long j10, long j11, int i10) {
            kotlin.jvm.internal.t.i(colorStops, "colorStops");
            ArrayList arrayList = new ArrayList(colorStops.length);
            for (v8.s<Float, Color> sVar : colorStops) {
                arrayList.add(Color.m1588boximpl(sVar.d().m1608unboximpl()));
            }
            ArrayList arrayList2 = new ArrayList(colorStops.length);
            for (v8.s<Float, Color> sVar2 : colorStops) {
                arrayList2.add(Float.valueOf(sVar2.c().floatValue()));
            }
            return new LinearGradient(arrayList, arrayList2, j10, j11, i10, null);
        }

        @Stable
        @NotNull
        /* JADX INFO: renamed from: radialGradient-P_Vx-Ks, reason: not valid java name */
        public final Brush m1568radialGradientP_VxKs(@NotNull v8.s<Float, Color>[] colorStops, long j10, float f10, int i10) {
            kotlin.jvm.internal.t.i(colorStops, "colorStops");
            ArrayList arrayList = new ArrayList(colorStops.length);
            for (v8.s<Float, Color> sVar : colorStops) {
                arrayList.add(Color.m1588boximpl(sVar.d().m1608unboximpl()));
            }
            ArrayList arrayList2 = new ArrayList(colorStops.length);
            for (v8.s<Float, Color> sVar2 : colorStops) {
                arrayList2.add(Float.valueOf(sVar2.c().floatValue()));
            }
            return new RadialGradient(arrayList, arrayList2, j10, f10, i10, null);
        }

        @Stable
        @NotNull
        /* JADX INFO: renamed from: sweepGradient-Uv8p0NA, reason: not valid java name */
        public final Brush m1570sweepGradientUv8p0NA(@NotNull v8.s<Float, Color>[] colorStops, long j10) {
            kotlin.jvm.internal.t.i(colorStops, "colorStops");
            ArrayList arrayList = new ArrayList(colorStops.length);
            for (v8.s<Float, Color> sVar : colorStops) {
                arrayList.add(Color.m1588boximpl(sVar.d().m1608unboximpl()));
            }
            ArrayList arrayList2 = new ArrayList(colorStops.length);
            for (v8.s<Float, Color> sVar2 : colorStops) {
                arrayList2.add(Float.valueOf(sVar2.c().floatValue()));
            }
            return new SweepGradient(j10, arrayList, arrayList2, null);
        }

        @Stable
        @NotNull
        /* JADX INFO: renamed from: verticalGradient-8A-3gB4, reason: not valid java name */
        public final Brush m1571verticalGradient8A3gB4(@NotNull List<Color> colors, float f10, float f11, int i10) {
            kotlin.jvm.internal.t.i(colors, "colors");
            return m1565linearGradientmHitzGk(colors, OffsetKt.Offset(0.0f, f10), OffsetKt.Offset(0.0f, f11), i10);
        }

        @Stable
        @NotNull
        /* JADX INFO: renamed from: horizontalGradient-8A-3gB4, reason: not valid java name */
        public final Brush m1564horizontalGradient8A3gB4(@NotNull v8.s<Float, Color>[] colorStops, float f10, float f11, int i10) {
            kotlin.jvm.internal.t.i(colorStops, "colorStops");
            return m1566linearGradientmHitzGk((v8.s<Float, Color>[]) Arrays.copyOf(colorStops, colorStops.length), OffsetKt.Offset(f10, 0.0f), OffsetKt.Offset(f11, 0.0f), i10);
        }

        @Stable
        @NotNull
        /* JADX INFO: renamed from: verticalGradient-8A-3gB4, reason: not valid java name */
        public final Brush m1572verticalGradient8A3gB4(@NotNull v8.s<Float, Color>[] colorStops, float f10, float f11, int i10) {
            kotlin.jvm.internal.t.i(colorStops, "colorStops");
            return m1566linearGradientmHitzGk((v8.s<Float, Color>[]) Arrays.copyOf(colorStops, colorStops.length), OffsetKt.Offset(0.0f, f10), OffsetKt.Offset(0.0f, f11), i10);
        }

        /* JADX INFO: renamed from: horizontalGradient-8A-3gB4$default, reason: not valid java name */
        public static /* synthetic */ Brush m1554horizontalGradient8A3gB4$default(Companion companion, v8.s[] sVarArr, float f10, float f11, int i10, int i11, Object obj) {
            if ((i11 & 2) != 0) {
                f10 = 0.0f;
            }
            if ((i11 & 4) != 0) {
                f11 = Float.POSITIVE_INFINITY;
            }
            if ((i11 & 8) != 0) {
                i10 = TileMode.Companion.m1905getClamp3opZhB0();
            }
            return companion.m1564horizontalGradient8A3gB4((v8.s<Float, Color>[]) sVarArr, f10, f11, i10);
        }

        /* JADX INFO: renamed from: sweepGradient-Uv8p0NA$default, reason: not valid java name */
        public static /* synthetic */ Brush m1559sweepGradientUv8p0NA$default(Companion companion, List list, long j10, int i10, Object obj) {
            if ((i10 & 2) != 0) {
                j10 = Offset.Companion.m1382getUnspecifiedF1C5BW0();
            }
            return companion.m1569sweepGradientUv8p0NA((List<Color>) list, j10);
        }

        /* JADX INFO: renamed from: verticalGradient-8A-3gB4$default, reason: not valid java name */
        public static /* synthetic */ Brush m1562verticalGradient8A3gB4$default(Companion companion, v8.s[] sVarArr, float f10, float f11, int i10, int i11, Object obj) {
            if ((i11 & 2) != 0) {
                f10 = 0.0f;
            }
            if ((i11 & 4) != 0) {
                f11 = Float.POSITIVE_INFINITY;
            }
            if ((i11 & 8) != 0) {
                i10 = TileMode.Companion.m1905getClamp3opZhB0();
            }
            return companion.m1572verticalGradient8A3gB4((v8.s<Float, Color>[]) sVarArr, f10, f11, i10);
        }

        /* JADX INFO: renamed from: radialGradient-P_Vx-Ks$default, reason: not valid java name */
        public static /* synthetic */ Brush m1557radialGradientP_VxKs$default(Companion companion, List list, long j10, float f10, int i10, int i11, Object obj) {
            if ((i11 & 2) != 0) {
                j10 = Offset.Companion.m1382getUnspecifiedF1C5BW0();
            }
            long j11 = j10;
            if ((i11 & 4) != 0) {
                f10 = Float.POSITIVE_INFINITY;
            }
            float f11 = f10;
            if ((i11 & 8) != 0) {
                i10 = TileMode.Companion.m1905getClamp3opZhB0();
            }
            return companion.m1567radialGradientP_VxKs((List<Color>) list, j11, f11, i10);
        }

        @Stable
        @NotNull
        /* JADX INFO: renamed from: linearGradient-mHitzGk, reason: not valid java name */
        public final Brush m1565linearGradientmHitzGk(@NotNull List<Color> colors, long j10, long j11, int i10) {
            kotlin.jvm.internal.t.i(colors, "colors");
            return new LinearGradient(colors, null, j10, j11, i10, null);
        }

        @Stable
        @NotNull
        /* JADX INFO: renamed from: radialGradient-P_Vx-Ks, reason: not valid java name */
        public final Brush m1567radialGradientP_VxKs(@NotNull List<Color> colors, long j10, float f10, int i10) {
            kotlin.jvm.internal.t.i(colors, "colors");
            return new RadialGradient(colors, null, j10, f10, i10, null);
        }

        @Stable
        @NotNull
        /* JADX INFO: renamed from: sweepGradient-Uv8p0NA, reason: not valid java name */
        public final Brush m1569sweepGradientUv8p0NA(@NotNull List<Color> colors, long j10) {
            kotlin.jvm.internal.t.i(colors, "colors");
            return new SweepGradient(j10, colors, null, null);
        }

        /* JADX INFO: renamed from: linearGradient-mHitzGk$default, reason: not valid java name */
        public static /* synthetic */ Brush m1555linearGradientmHitzGk$default(Companion companion, List list, long j10, long j11, int i10, int i11, Object obj) {
            if ((i11 & 2) != 0) {
                j10 = Offset.Companion.m1383getZeroF1C5BW0();
            }
            long j12 = j10;
            if ((i11 & 4) != 0) {
                j11 = Offset.Companion.m1381getInfiniteF1C5BW0();
            }
            long j13 = j11;
            if ((i11 & 8) != 0) {
                i10 = TileMode.Companion.m1905getClamp3opZhB0();
            }
            return companion.m1565linearGradientmHitzGk((List<Color>) list, j12, j13, i10);
        }
    }

    public /* synthetic */ Brush(kotlin.jvm.internal.k kVar) {
        this();
    }

    /* JADX INFO: renamed from: applyTo-Pq9zytI, reason: not valid java name */
    public abstract void mo1551applyToPq9zytI(long j10, @NotNull Paint paint, float f10);

    /* JADX INFO: renamed from: getIntrinsicSize-NH-jbRc, reason: not valid java name */
    public long mo1552getIntrinsicSizeNHjbRc() {
        return this.intrinsicSize;
    }

    private Brush() {
        this.intrinsicSize = Size.Companion.m1444getUnspecifiedNHjbRc();
    }
}
