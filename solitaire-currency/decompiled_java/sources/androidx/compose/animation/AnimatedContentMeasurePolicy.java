package androidx.compose.animation;

import androidx.compose.animation.AnimatedContentScope;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.IntSizeKt;
import h9.l;
import java.util.List;
import kotlin.collections.d0;
import kotlin.collections.p;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import o9.o;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: AnimatedContent.kt */
/* JADX INFO: loaded from: classes.dex */
final class AnimatedContentMeasurePolicy implements MeasurePolicy {

    @NotNull
    private final AnimatedContentScope<?> rootScope;

    /* JADX INFO: renamed from: androidx.compose.animation.AnimatedContentMeasurePolicy$maxIntrinsicHeight$1, reason: invalid class name */
    /* JADX INFO: compiled from: AnimatedContent.kt */
    static final class AnonymousClass1 extends v implements l<IntrinsicMeasurable, Integer> {
        final /* synthetic */ int $width;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(int i10) {
            super(1);
            this.$width = i10;
        }

        @Override // h9.l
        @NotNull
        public final Integer invoke(@NotNull IntrinsicMeasurable it) {
            t.i(it, "it");
            return Integer.valueOf(it.maxIntrinsicHeight(this.$width));
        }
    }

    /* JADX INFO: renamed from: androidx.compose.animation.AnimatedContentMeasurePolicy$maxIntrinsicWidth$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AnimatedContent.kt */
    static final class C07771 extends v implements l<IntrinsicMeasurable, Integer> {
        final /* synthetic */ int $height;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C07771(int i10) {
            super(1);
            this.$height = i10;
        }

        @Override // h9.l
        @NotNull
        public final Integer invoke(@NotNull IntrinsicMeasurable it) {
            t.i(it, "it");
            return Integer.valueOf(it.maxIntrinsicWidth(this.$height));
        }
    }

    /* JADX INFO: renamed from: androidx.compose.animation.AnimatedContentMeasurePolicy$minIntrinsicHeight$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AnimatedContent.kt */
    static final class C07781 extends v implements l<IntrinsicMeasurable, Integer> {
        final /* synthetic */ int $width;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C07781(int i10) {
            super(1);
            this.$width = i10;
        }

        @Override // h9.l
        @NotNull
        public final Integer invoke(@NotNull IntrinsicMeasurable it) {
            t.i(it, "it");
            return Integer.valueOf(it.minIntrinsicHeight(this.$width));
        }
    }

    /* JADX INFO: renamed from: androidx.compose.animation.AnimatedContentMeasurePolicy$minIntrinsicWidth$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AnimatedContent.kt */
    static final class C07791 extends v implements l<IntrinsicMeasurable, Integer> {
        final /* synthetic */ int $height;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C07791(int i10) {
            super(1);
            this.$height = i10;
        }

        @Override // h9.l
        @NotNull
        public final Integer invoke(@NotNull IntrinsicMeasurable it) {
            t.i(it, "it");
            return Integer.valueOf(it.minIntrinsicWidth(this.$height));
        }
    }

    public AnimatedContentMeasurePolicy(@NotNull AnimatedContentScope<?> rootScope) {
        t.i(rootScope, "rootScope");
        this.rootScope = rootScope;
    }

    @NotNull
    public final AnimatedContentScope<?> getRootScope() {
        return this.rootScope;
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public int maxIntrinsicHeight(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull List<? extends IntrinsicMeasurable> measurables, int i10) {
        t.i(intrinsicMeasureScope, "<this>");
        t.i(measurables, "measurables");
        Integer num = (Integer) o.u(o.s(d0.a0(measurables), new AnonymousClass1(i10)));
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public int maxIntrinsicWidth(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull List<? extends IntrinsicMeasurable> measurables, int i10) {
        t.i(intrinsicMeasureScope, "<this>");
        t.i(measurables, "measurables");
        Integer num = (Integer) o.u(o.s(d0.a0(measurables), new C07771(i10)));
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.compose.ui.layout.MeasurePolicy
    @NotNull
    /* JADX INFO: renamed from: measure-3p2s80s, reason: not valid java name */
    public MeasureResult mo8measure3p2s80s(@NotNull MeasureScope measure, @NotNull List<? extends Measurable> measurables, long j10) {
        Placeable placeable;
        int i10;
        Placeable placeable2;
        t.i(measure, "$this$measure");
        t.i(measurables, "measurables");
        int size = measurables.size();
        Placeable[] placeableArr = new Placeable[size];
        int size2 = measurables.size();
        int i11 = 0;
        while (true) {
            placeable = null;
            if (i11 >= size2) {
                break;
            }
            Measurable measurable = measurables.get(i11);
            Object parentData = measurable.getParentData();
            AnimatedContentScope.ChildData childData = parentData instanceof AnimatedContentScope.ChildData ? (AnimatedContentScope.ChildData) parentData : null;
            if (((childData == null || !childData.isTarget()) ? 0 : 1) != 0) {
                placeableArr[i11] = measurable.mo2987measureBRTryo0(j10);
            }
            i11++;
        }
        int size3 = measurables.size();
        for (int i12 = 0; i12 < size3; i12++) {
            Measurable measurable2 = measurables.get(i12);
            if (placeableArr[i12] == null) {
                placeableArr[i12] = measurable2.mo2987measureBRTryo0(j10);
            }
        }
        if ((size == 0) == true) {
            placeable2 = null;
        } else {
            placeable2 = placeableArr[0];
            int iS = p.S(placeableArr);
            if (iS != 0) {
                int width = placeable2 != null ? placeable2.getWidth() : 0;
                if (1 <= iS) {
                    int i13 = 1;
                    while (true) {
                        Placeable placeable3 = placeableArr[i13];
                        int width2 = placeable3 != null ? placeable3.getWidth() : 0;
                        if (width < width2) {
                            placeable2 = placeable3;
                            width = width2;
                        }
                        if (i13 == iS) {
                            break;
                        }
                        i13++;
                    }
                }
            }
        }
        int width3 = placeable2 != null ? placeable2.getWidth() : 0;
        if ((size == 0) == false) {
            placeable = placeableArr[0];
            int iS2 = p.S(placeableArr);
            if (iS2 != 0) {
                int height = placeable != null ? placeable.getHeight() : 0;
                if (1 <= iS2) {
                    while (true) {
                        Placeable placeable4 = placeableArr[i10];
                        int height2 = placeable4 != null ? placeable4.getHeight() : 0;
                        if (height < height2) {
                            placeable = placeable4;
                            height = height2;
                        }
                        if (i10 == iS2) {
                            break;
                        }
                        i10++;
                    }
                }
            }
        }
        int height3 = placeable != null ? placeable.getHeight() : 0;
        this.rootScope.m20setMeasuredSizeozmzZPI$animation_release(IntSizeKt.IntSize(width3, height3));
        return MeasureScope.CC.p(measure, width3, height3, null, new AnimatedContentMeasurePolicy$measure$3(placeableArr, this, width3, height3), 4, null);
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public int minIntrinsicHeight(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull List<? extends IntrinsicMeasurable> measurables, int i10) {
        t.i(intrinsicMeasureScope, "<this>");
        t.i(measurables, "measurables");
        Integer num = (Integer) o.u(o.s(d0.a0(measurables), new C07781(i10)));
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public int minIntrinsicWidth(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull List<? extends IntrinsicMeasurable> measurables, int i10) {
        t.i(intrinsicMeasureScope, "<this>");
        t.i(measurables, "measurables");
        Integer num = (Integer) o.u(o.s(d0.a0(measurables), new C07791(i10)));
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }
}
