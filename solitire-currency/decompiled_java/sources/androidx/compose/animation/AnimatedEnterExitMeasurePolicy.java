package androidx.compose.animation;

import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import h9.l;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.d0;
import kotlin.collections.w;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import o9.o;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: AnimatedVisibility.kt */
/* JADX INFO: loaded from: classes.dex */
final class AnimatedEnterExitMeasurePolicy implements MeasurePolicy {

    @NotNull
    private final AnimatedVisibilityScopeImpl scope;

    /* JADX INFO: renamed from: androidx.compose.animation.AnimatedEnterExitMeasurePolicy$maxIntrinsicHeight$1, reason: invalid class name */
    /* JADX INFO: compiled from: AnimatedVisibility.kt */
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

    /* JADX INFO: renamed from: androidx.compose.animation.AnimatedEnterExitMeasurePolicy$maxIntrinsicWidth$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AnimatedVisibility.kt */
    static final class C07801 extends v implements l<IntrinsicMeasurable, Integer> {
        final /* synthetic */ int $height;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C07801(int i10) {
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

    /* JADX INFO: renamed from: androidx.compose.animation.AnimatedEnterExitMeasurePolicy$minIntrinsicHeight$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AnimatedVisibility.kt */
    static final class C07811 extends v implements l<IntrinsicMeasurable, Integer> {
        final /* synthetic */ int $width;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C07811(int i10) {
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

    /* JADX INFO: renamed from: androidx.compose.animation.AnimatedEnterExitMeasurePolicy$minIntrinsicWidth$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AnimatedVisibility.kt */
    static final class C07821 extends v implements l<IntrinsicMeasurable, Integer> {
        final /* synthetic */ int $height;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C07821(int i10) {
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

    public AnimatedEnterExitMeasurePolicy(@NotNull AnimatedVisibilityScopeImpl scope) {
        t.i(scope, "scope");
        this.scope = scope;
    }

    @NotNull
    public final AnimatedVisibilityScopeImpl getScope() {
        return this.scope;
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
        Integer num = (Integer) o.u(o.s(d0.a0(measurables), new C07801(i10)));
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    @NotNull
    /* JADX INFO: renamed from: measure-3p2s80s */
    public MeasureResult mo8measure3p2s80s(@NotNull MeasureScope measure, @NotNull List<? extends Measurable> measurables, long j10) {
        Object obj;
        t.i(measure, "$this$measure");
        t.i(measurables, "measurables");
        List<? extends Measurable> list = measurables;
        ArrayList arrayList = new ArrayList(w.v(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((Measurable) it.next()).mo2987measureBRTryo0(j10));
        }
        Object obj2 = null;
        int i10 = 1;
        if (arrayList.isEmpty()) {
            obj = null;
        } else {
            obj = arrayList.get(0);
            int width = ((Placeable) obj).getWidth();
            int iM = kotlin.collections.v.m(arrayList);
            if (1 <= iM) {
                int i11 = 1;
                while (true) {
                    Object obj3 = arrayList.get(i11);
                    int width2 = ((Placeable) obj3).getWidth();
                    if (width < width2) {
                        obj = obj3;
                        width = width2;
                    }
                    if (i11 == iM) {
                        break;
                    }
                    i11++;
                }
            }
        }
        Placeable placeable = (Placeable) obj;
        int width3 = placeable != null ? placeable.getWidth() : 0;
        if (!arrayList.isEmpty()) {
            Object obj4 = arrayList.get(0);
            int height = ((Placeable) obj4).getHeight();
            int iM2 = kotlin.collections.v.m(arrayList);
            if (1 <= iM2) {
                while (true) {
                    Object obj5 = arrayList.get(i10);
                    int height2 = ((Placeable) obj5).getHeight();
                    if (height < height2) {
                        obj4 = obj5;
                        height = height2;
                    }
                    if (i10 == iM2) {
                        break;
                    }
                    i10++;
                }
            }
            obj2 = obj4;
        }
        Placeable placeable2 = (Placeable) obj2;
        int height3 = placeable2 != null ? placeable2.getHeight() : 0;
        this.scope.getTargetSize$animation_release().setValue(IntSize.m3825boximpl(IntSizeKt.IntSize(width3, height3)));
        return MeasureScope.CC.p(measure, width3, height3, null, new AnimatedEnterExitMeasurePolicy$measure$1(arrayList), 4, null);
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public int minIntrinsicHeight(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull List<? extends IntrinsicMeasurable> measurables, int i10) {
        t.i(intrinsicMeasureScope, "<this>");
        t.i(measurables, "measurables");
        Integer num = (Integer) o.u(o.s(d0.a0(measurables), new C07811(i10)));
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public int minIntrinsicWidth(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull List<? extends IntrinsicMeasurable> measurables, int i10) {
        t.i(intrinsicMeasureScope, "<this>");
        t.i(measurables, "measurables");
        Integer num = (Integer) o.u(o.s(d0.a0(measurables), new C07821(i10)));
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }
}
