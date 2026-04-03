package androidx.compose.foundation.layout;

import androidx.compose.ui.layout.IntrinsicMeasurable;
import h9.p;
import h9.q;
import java.util.List;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: RowColumnImpl.kt */
/* JADX INFO: loaded from: classes.dex */
final class IntrinsicMeasureBlocks$VerticalMaxWidth$1 extends v implements q<List<? extends IntrinsicMeasurable>, Integer, Integer, Integer> {
    public static final IntrinsicMeasureBlocks$VerticalMaxWidth$1 INSTANCE = new IntrinsicMeasureBlocks$VerticalMaxWidth$1();

    /* JADX INFO: renamed from: androidx.compose.foundation.layout.IntrinsicMeasureBlocks$VerticalMaxWidth$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: RowColumnImpl.kt */
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
        public final Integer invoke(@NotNull IntrinsicMeasurable intrinsicSize, int i10) {
            t.i(intrinsicSize, "$this$intrinsicSize");
            return Integer.valueOf(intrinsicSize.maxIntrinsicWidth(i10));
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.layout.IntrinsicMeasureBlocks$VerticalMaxWidth$1$2, reason: invalid class name */
    /* JADX INFO: compiled from: RowColumnImpl.kt */
    static final class AnonymousClass2 extends v implements p<IntrinsicMeasurable, Integer, Integer> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        AnonymousClass2() {
            super(2);
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Integer mo4invoke(IntrinsicMeasurable intrinsicMeasurable, Integer num) {
            return invoke(intrinsicMeasurable, num.intValue());
        }

        @NotNull
        public final Integer invoke(@NotNull IntrinsicMeasurable intrinsicSize, int i10) {
            t.i(intrinsicSize, "$this$intrinsicSize");
            return Integer.valueOf(intrinsicSize.maxIntrinsicHeight(i10));
        }
    }

    IntrinsicMeasureBlocks$VerticalMaxWidth$1() {
        super(3);
    }

    @Override // h9.q
    public /* bridge */ /* synthetic */ Integer invoke(List<? extends IntrinsicMeasurable> list, Integer num, Integer num2) {
        return invoke(list, num.intValue(), num2.intValue());
    }

    @NotNull
    public final Integer invoke(@NotNull List<? extends IntrinsicMeasurable> measurables, int i10, int i11) {
        t.i(measurables, "measurables");
        return Integer.valueOf(RowColumnImplKt.intrinsicSize(measurables, AnonymousClass1.INSTANCE, AnonymousClass2.INSTANCE, i10, i11, LayoutOrientation.Vertical, LayoutOrientation.Horizontal));
    }
}
