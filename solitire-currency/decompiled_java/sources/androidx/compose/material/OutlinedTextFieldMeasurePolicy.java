package androidx.compose.material;

import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import h9.l;
import h9.p;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: OutlinedTextField.kt */
/* JADX INFO: loaded from: classes.dex */
final class OutlinedTextFieldMeasurePolicy implements MeasurePolicy {
    private final float animationProgress;

    @NotNull
    private final l<Size, k0> onLabelMeasured;

    @NotNull
    private final PaddingValues paddingValues;
    private final boolean singleLine;

    /* JADX INFO: renamed from: androidx.compose.material.OutlinedTextFieldMeasurePolicy$maxIntrinsicHeight$1, reason: invalid class name */
    /* JADX INFO: compiled from: OutlinedTextField.kt */
    static final class AnonymousClass1 extends v implements p<IntrinsicMeasurable, Integer, Integer> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(2);
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Integer mo4invoke(IntrinsicMeasurable intrinsicMeasurable, Integer num) {
            return invoke(intrinsicMeasurable, num.intValue());
        }

        @NotNull
        public final Integer invoke(@NotNull IntrinsicMeasurable intrinsicMeasurable, int i10) {
            t.i(intrinsicMeasurable, "intrinsicMeasurable");
            return Integer.valueOf(intrinsicMeasurable.maxIntrinsicHeight(i10));
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material.OutlinedTextFieldMeasurePolicy$maxIntrinsicWidth$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: OutlinedTextField.kt */
    static final class C09281 extends v implements p<IntrinsicMeasurable, Integer, Integer> {
        public static final C09281 INSTANCE = new C09281();

        C09281() {
            super(2);
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Integer mo4invoke(IntrinsicMeasurable intrinsicMeasurable, Integer num) {
            return invoke(intrinsicMeasurable, num.intValue());
        }

        @NotNull
        public final Integer invoke(@NotNull IntrinsicMeasurable intrinsicMeasurable, int i10) {
            t.i(intrinsicMeasurable, "intrinsicMeasurable");
            return Integer.valueOf(intrinsicMeasurable.maxIntrinsicWidth(i10));
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material.OutlinedTextFieldMeasurePolicy$minIntrinsicHeight$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: OutlinedTextField.kt */
    static final class C09291 extends v implements p<IntrinsicMeasurable, Integer, Integer> {
        public static final C09291 INSTANCE = new C09291();

        C09291() {
            super(2);
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Integer mo4invoke(IntrinsicMeasurable intrinsicMeasurable, Integer num) {
            return invoke(intrinsicMeasurable, num.intValue());
        }

        @NotNull
        public final Integer invoke(@NotNull IntrinsicMeasurable intrinsicMeasurable, int i10) {
            t.i(intrinsicMeasurable, "intrinsicMeasurable");
            return Integer.valueOf(intrinsicMeasurable.minIntrinsicHeight(i10));
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material.OutlinedTextFieldMeasurePolicy$minIntrinsicWidth$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: OutlinedTextField.kt */
    static final class C09301 extends v implements p<IntrinsicMeasurable, Integer, Integer> {
        public static final C09301 INSTANCE = new C09301();

        C09301() {
            super(2);
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Integer mo4invoke(IntrinsicMeasurable intrinsicMeasurable, Integer num) {
            return invoke(intrinsicMeasurable, num.intValue());
        }

        @NotNull
        public final Integer invoke(@NotNull IntrinsicMeasurable intrinsicMeasurable, int i10) {
            t.i(intrinsicMeasurable, "intrinsicMeasurable");
            return Integer.valueOf(intrinsicMeasurable.minIntrinsicWidth(i10));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OutlinedTextFieldMeasurePolicy(@NotNull l<? super Size, k0> onLabelMeasured, boolean z10, float f10, @NotNull PaddingValues paddingValues) {
        t.i(onLabelMeasured, "onLabelMeasured");
        t.i(paddingValues, "paddingValues");
        this.onLabelMeasured = onLabelMeasured;
        this.singleLine = z10;
        this.animationProgress = f10;
        this.paddingValues = paddingValues;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final int intrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i10, p<? super IntrinsicMeasurable, ? super Integer, Integer> pVar) {
        Object obj;
        Object next;
        Object next2;
        Object next3;
        List<? extends IntrinsicMeasurable> list2 = list;
        for (Object obj2 : list2) {
            if (t.d(TextFieldImplKt.getLayoutId((IntrinsicMeasurable) obj2), TextFieldImplKt.TextFieldId)) {
                int iIntValue = pVar.mo4invoke(obj2, Integer.valueOf(i10)).intValue();
                Iterator<T> it = list2.iterator();
                while (true) {
                    obj = null;
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                    if (t.d(TextFieldImplKt.getLayoutId((IntrinsicMeasurable) next), TextFieldImplKt.LabelId)) {
                        break;
                    }
                }
                IntrinsicMeasurable intrinsicMeasurable = (IntrinsicMeasurable) next;
                int iIntValue2 = intrinsicMeasurable != null ? pVar.mo4invoke(intrinsicMeasurable, Integer.valueOf(i10)).intValue() : 0;
                Iterator<T> it2 = list2.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        next2 = null;
                        break;
                    }
                    next2 = it2.next();
                    if (t.d(TextFieldImplKt.getLayoutId((IntrinsicMeasurable) next2), TextFieldImplKt.TrailingId)) {
                        break;
                    }
                }
                IntrinsicMeasurable intrinsicMeasurable2 = (IntrinsicMeasurable) next2;
                int iIntValue3 = intrinsicMeasurable2 != null ? pVar.mo4invoke(intrinsicMeasurable2, Integer.valueOf(i10)).intValue() : 0;
                Iterator<T> it3 = list2.iterator();
                while (true) {
                    if (!it3.hasNext()) {
                        next3 = null;
                        break;
                    }
                    next3 = it3.next();
                    if (t.d(TextFieldImplKt.getLayoutId((IntrinsicMeasurable) next3), TextFieldImplKt.LeadingId)) {
                        break;
                    }
                }
                IntrinsicMeasurable intrinsicMeasurable3 = (IntrinsicMeasurable) next3;
                int iIntValue4 = intrinsicMeasurable3 != null ? pVar.mo4invoke(intrinsicMeasurable3, Integer.valueOf(i10)).intValue() : 0;
                Iterator<T> it4 = list2.iterator();
                while (true) {
                    if (!it4.hasNext()) {
                        break;
                    }
                    Object next4 = it4.next();
                    if (t.d(TextFieldImplKt.getLayoutId((IntrinsicMeasurable) next4), TextFieldImplKt.PlaceholderId)) {
                        obj = next4;
                        break;
                    }
                }
                IntrinsicMeasurable intrinsicMeasurable4 = (IntrinsicMeasurable) obj;
                return OutlinedTextFieldKt.m1084calculateHeightzUg2_y0(iIntValue4, iIntValue3, iIntValue, iIntValue2, intrinsicMeasurable4 != null ? pVar.mo4invoke(intrinsicMeasurable4, Integer.valueOf(i10)).intValue() : 0, TextFieldImplKt.getZeroConstraints(), intrinsicMeasureScope.getDensity(), this.paddingValues);
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final int intrinsicWidth(List<? extends IntrinsicMeasurable> list, int i10, p<? super IntrinsicMeasurable, ? super Integer, Integer> pVar) {
        Object obj;
        Object next;
        Object next2;
        Object next3;
        List<? extends IntrinsicMeasurable> list2 = list;
        for (Object obj2 : list2) {
            if (t.d(TextFieldImplKt.getLayoutId((IntrinsicMeasurable) obj2), TextFieldImplKt.TextFieldId)) {
                int iIntValue = pVar.mo4invoke(obj2, Integer.valueOf(i10)).intValue();
                Iterator<T> it = list2.iterator();
                while (true) {
                    obj = null;
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                    if (t.d(TextFieldImplKt.getLayoutId((IntrinsicMeasurable) next), TextFieldImplKt.LabelId)) {
                        break;
                    }
                }
                IntrinsicMeasurable intrinsicMeasurable = (IntrinsicMeasurable) next;
                int iIntValue2 = intrinsicMeasurable != null ? pVar.mo4invoke(intrinsicMeasurable, Integer.valueOf(i10)).intValue() : 0;
                Iterator<T> it2 = list2.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        next2 = null;
                        break;
                    }
                    next2 = it2.next();
                    if (t.d(TextFieldImplKt.getLayoutId((IntrinsicMeasurable) next2), TextFieldImplKt.TrailingId)) {
                        break;
                    }
                }
                IntrinsicMeasurable intrinsicMeasurable2 = (IntrinsicMeasurable) next2;
                int iIntValue3 = intrinsicMeasurable2 != null ? pVar.mo4invoke(intrinsicMeasurable2, Integer.valueOf(i10)).intValue() : 0;
                Iterator<T> it3 = list2.iterator();
                while (true) {
                    if (!it3.hasNext()) {
                        next3 = null;
                        break;
                    }
                    next3 = it3.next();
                    if (t.d(TextFieldImplKt.getLayoutId((IntrinsicMeasurable) next3), TextFieldImplKt.LeadingId)) {
                        break;
                    }
                }
                IntrinsicMeasurable intrinsicMeasurable3 = (IntrinsicMeasurable) next3;
                int iIntValue4 = intrinsicMeasurable3 != null ? pVar.mo4invoke(intrinsicMeasurable3, Integer.valueOf(i10)).intValue() : 0;
                Iterator<T> it4 = list2.iterator();
                while (true) {
                    if (!it4.hasNext()) {
                        break;
                    }
                    Object next4 = it4.next();
                    if (t.d(TextFieldImplKt.getLayoutId((IntrinsicMeasurable) next4), TextFieldImplKt.PlaceholderId)) {
                        obj = next4;
                        break;
                    }
                }
                IntrinsicMeasurable intrinsicMeasurable4 = (IntrinsicMeasurable) obj;
                return OutlinedTextFieldKt.m1085calculateWidthVsPV1Ek(iIntValue4, iIntValue3, iIntValue, iIntValue2, intrinsicMeasurable4 != null ? pVar.mo4invoke(intrinsicMeasurable4, Integer.valueOf(i10)).intValue() : 0, TextFieldImplKt.getZeroConstraints());
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public int maxIntrinsicHeight(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull List<? extends IntrinsicMeasurable> measurables, int i10) {
        t.i(intrinsicMeasureScope, "<this>");
        t.i(measurables, "measurables");
        return intrinsicHeight(intrinsicMeasureScope, measurables, i10, AnonymousClass1.INSTANCE);
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public int maxIntrinsicWidth(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull List<? extends IntrinsicMeasurable> measurables, int i10) {
        t.i(intrinsicMeasureScope, "<this>");
        t.i(measurables, "measurables");
        return intrinsicWidth(measurables, i10, C09281.INSTANCE);
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    @NotNull
    /* JADX INFO: renamed from: measure-3p2s80s */
    public MeasureResult mo8measure3p2s80s(@NotNull MeasureScope measure, @NotNull List<? extends Measurable> measurables, long j10) {
        Object next;
        Object next2;
        Object next3;
        Object next4;
        t.i(measure, "$this$measure");
        t.i(measurables, "measurables");
        int iMo290roundToPx0680j_4 = measure.mo290roundToPx0680j_4(this.paddingValues.mo379calculateBottomPaddingD9Ej5fM());
        long jM3632copyZbe2FdA$default = Constraints.m3632copyZbe2FdA$default(j10, 0, 0, 0, 0, 10, null);
        List<? extends Measurable> list = measurables;
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (t.d(LayoutIdKt.getLayoutId((Measurable) next), TextFieldImplKt.LeadingId)) {
                break;
            }
        }
        Measurable measurable = (Measurable) next;
        Placeable placeableMo2987measureBRTryo0 = measurable != null ? measurable.mo2987measureBRTryo0(jM3632copyZbe2FdA$default) : null;
        int iWidthOrZero = TextFieldImplKt.widthOrZero(placeableMo2987measureBRTryo0) + 0;
        Iterator<T> it2 = list.iterator();
        while (true) {
            if (!it2.hasNext()) {
                next2 = null;
                break;
            }
            next2 = it2.next();
            if (t.d(LayoutIdKt.getLayoutId((Measurable) next2), TextFieldImplKt.TrailingId)) {
                break;
            }
        }
        Measurable measurable2 = (Measurable) next2;
        Placeable placeableMo2987measureBRTryo02 = measurable2 != null ? measurable2.mo2987measureBRTryo0(ConstraintsKt.m3658offsetNN6EwU$default(jM3632copyZbe2FdA$default, -iWidthOrZero, 0, 2, null)) : null;
        int i10 = -(iWidthOrZero + TextFieldImplKt.widthOrZero(placeableMo2987measureBRTryo02));
        int i11 = -iMo290roundToPx0680j_4;
        long jM3657offsetNN6EwU = ConstraintsKt.m3657offsetNN6EwU(jM3632copyZbe2FdA$default, (i10 - measure.mo290roundToPx0680j_4(this.paddingValues.mo380calculateLeftPaddingu2uoSUM(measure.getLayoutDirection()))) - measure.mo290roundToPx0680j_4(this.paddingValues.mo381calculateRightPaddingu2uoSUM(measure.getLayoutDirection())), i11);
        Iterator<T> it3 = list.iterator();
        while (true) {
            if (!it3.hasNext()) {
                next3 = null;
                break;
            }
            next3 = it3.next();
            if (t.d(LayoutIdKt.getLayoutId((Measurable) next3), TextFieldImplKt.LabelId)) {
                break;
            }
        }
        Measurable measurable3 = (Measurable) next3;
        Placeable placeableMo2987measureBRTryo03 = measurable3 != null ? measurable3.mo2987measureBRTryo0(jM3657offsetNN6EwU) : null;
        if (placeableMo2987measureBRTryo03 != null) {
            this.onLabelMeasured.invoke(Size.m1424boximpl(SizeKt.Size(placeableMo2987measureBRTryo03.getWidth(), placeableMo2987measureBRTryo03.getHeight())));
        }
        long jM3632copyZbe2FdA$default2 = Constraints.m3632copyZbe2FdA$default(ConstraintsKt.m3657offsetNN6EwU(j10, i10, i11 - Math.max(TextFieldImplKt.heightOrZero(placeableMo2987measureBRTryo03) / 2, measure.mo290roundToPx0680j_4(this.paddingValues.mo382calculateTopPaddingD9Ej5fM()))), 0, 0, 0, 0, 11, null);
        for (Measurable measurable4 : list) {
            if (t.d(LayoutIdKt.getLayoutId(measurable4), TextFieldImplKt.TextFieldId)) {
                Placeable placeableMo2987measureBRTryo04 = measurable4.mo2987measureBRTryo0(jM3632copyZbe2FdA$default2);
                long jM3632copyZbe2FdA$default3 = Constraints.m3632copyZbe2FdA$default(jM3632copyZbe2FdA$default2, 0, 0, 0, 0, 14, null);
                Iterator<T> it4 = list.iterator();
                while (true) {
                    if (!it4.hasNext()) {
                        next4 = null;
                        break;
                    }
                    next4 = it4.next();
                    if (t.d(LayoutIdKt.getLayoutId((Measurable) next4), TextFieldImplKt.PlaceholderId)) {
                        break;
                    }
                }
                Measurable measurable5 = (Measurable) next4;
                Placeable placeableMo2987measureBRTryo05 = measurable5 != null ? measurable5.mo2987measureBRTryo0(jM3632copyZbe2FdA$default3) : null;
                int iM1085calculateWidthVsPV1Ek = OutlinedTextFieldKt.m1085calculateWidthVsPV1Ek(TextFieldImplKt.widthOrZero(placeableMo2987measureBRTryo0), TextFieldImplKt.widthOrZero(placeableMo2987measureBRTryo02), placeableMo2987measureBRTryo04.getWidth(), TextFieldImplKt.widthOrZero(placeableMo2987measureBRTryo03), TextFieldImplKt.widthOrZero(placeableMo2987measureBRTryo05), j10);
                int iM1084calculateHeightzUg2_y0 = OutlinedTextFieldKt.m1084calculateHeightzUg2_y0(TextFieldImplKt.heightOrZero(placeableMo2987measureBRTryo0), TextFieldImplKt.heightOrZero(placeableMo2987measureBRTryo02), placeableMo2987measureBRTryo04.getHeight(), TextFieldImplKt.heightOrZero(placeableMo2987measureBRTryo03), TextFieldImplKt.heightOrZero(placeableMo2987measureBRTryo05), j10, measure.getDensity(), this.paddingValues);
                for (Measurable measurable6 : list) {
                    if (t.d(LayoutIdKt.getLayoutId(measurable6), OutlinedTextFieldKt.BorderId)) {
                        return MeasureScope.CC.p(measure, iM1085calculateWidthVsPV1Ek, iM1084calculateHeightzUg2_y0, null, new OutlinedTextFieldMeasurePolicy$measure$2(iM1084calculateHeightzUg2_y0, iM1085calculateWidthVsPV1Ek, placeableMo2987measureBRTryo0, placeableMo2987measureBRTryo02, placeableMo2987measureBRTryo04, placeableMo2987measureBRTryo03, placeableMo2987measureBRTryo05, measurable6.mo2987measureBRTryo0(ConstraintsKt.Constraints(iM1085calculateWidthVsPV1Ek != Integer.MAX_VALUE ? iM1085calculateWidthVsPV1Ek : 0, iM1085calculateWidthVsPV1Ek, iM1084calculateHeightzUg2_y0 != Integer.MAX_VALUE ? iM1084calculateHeightzUg2_y0 : 0, iM1084calculateHeightzUg2_y0)), this, measure), 4, null);
                    }
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public int minIntrinsicHeight(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull List<? extends IntrinsicMeasurable> measurables, int i10) {
        t.i(intrinsicMeasureScope, "<this>");
        t.i(measurables, "measurables");
        return intrinsicHeight(intrinsicMeasureScope, measurables, i10, C09291.INSTANCE);
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public int minIntrinsicWidth(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull List<? extends IntrinsicMeasurable> measurables, int i10) {
        t.i(intrinsicMeasureScope, "<this>");
        t.i(measurables, "measurables");
        return intrinsicWidth(measurables, i10, C09301.INSTANCE);
    }
}
