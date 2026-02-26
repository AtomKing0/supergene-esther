package androidx.compose.material;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.SubcomposeMeasureScope;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import h9.l;
import h9.p;
import h9.q;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.w;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: TabRow.kt */
/* JADX INFO: loaded from: classes.dex */
final class TabRowKt$TabRow$2$1$1 extends v implements p<SubcomposeMeasureScope, Constraints, MeasureResult> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ p<Composer, Integer, k0> $divider;
    final /* synthetic */ q<List<TabPosition>, Composer, Integer, k0> $indicator;
    final /* synthetic */ p<Composer, Integer, k0> $tabs;

    /* JADX INFO: renamed from: androidx.compose.material.TabRowKt$TabRow$2$1$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: TabRow.kt */
    static final class AnonymousClass1 extends v implements l<Placeable.PlacementScope, k0> {
        final /* synthetic */ int $$dirty;
        final /* synthetic */ long $constraints;
        final /* synthetic */ p<Composer, Integer, k0> $divider;
        final /* synthetic */ q<List<TabPosition>, Composer, Integer, k0> $indicator;
        final /* synthetic */ List<Placeable> $tabPlaceables;
        final /* synthetic */ List<TabPosition> $tabPositions;
        final /* synthetic */ int $tabRowHeight;
        final /* synthetic */ int $tabRowWidth;
        final /* synthetic */ int $tabWidth;
        final /* synthetic */ SubcomposeMeasureScope $this_SubcomposeLayout;

        /* JADX INFO: renamed from: androidx.compose.material.TabRowKt$TabRow$2$1$1$1$3, reason: invalid class name */
        /* JADX INFO: compiled from: TabRow.kt */
        static final class AnonymousClass3 extends v implements p<Composer, Integer, k0> {
            final /* synthetic */ int $$dirty;
            final /* synthetic */ q<List<TabPosition>, Composer, Integer, k0> $indicator;
            final /* synthetic */ List<TabPosition> $tabPositions;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            AnonymousClass3(q<? super List<TabPosition>, ? super Composer, ? super Integer, k0> qVar, List<TabPosition> list, int i10) {
                super(2);
                this.$indicator = qVar;
                this.$tabPositions = list;
                this.$$dirty = i10;
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
                    this.$indicator.invoke(this.$tabPositions, composer, Integer.valueOf(((this.$$dirty >> 9) & 112) | 8));
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(List<? extends Placeable> list, SubcomposeMeasureScope subcomposeMeasureScope, p<? super Composer, ? super Integer, k0> pVar, int i10, long j10, int i11, q<? super List<TabPosition>, ? super Composer, ? super Integer, k0> qVar, List<TabPosition> list2, int i12, int i13) {
            super(1);
            this.$tabPlaceables = list;
            this.$this_SubcomposeLayout = subcomposeMeasureScope;
            this.$divider = pVar;
            this.$tabWidth = i10;
            this.$constraints = j10;
            this.$tabRowHeight = i11;
            this.$indicator = qVar;
            this.$tabPositions = list2;
            this.$$dirty = i12;
            this.$tabRowWidth = i13;
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(Placeable.PlacementScope placementScope) {
            invoke2(placementScope);
            return k0.f35197a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull Placeable.PlacementScope layout) {
            t.i(layout, "$this$layout");
            List<Placeable> list = this.$tabPlaceables;
            int i10 = this.$tabWidth;
            int i11 = 0;
            for (Object obj : list) {
                int i12 = i11 + 1;
                if (i11 < 0) {
                    kotlin.collections.v.u();
                }
                Placeable.PlacementScope.placeRelative$default(layout, (Placeable) obj, i11 * i10, 0, 0.0f, 4, null);
                i11 = i12;
            }
            List<Measurable> listSubcompose = this.$this_SubcomposeLayout.subcompose(TabSlots.Divider, this.$divider);
            long j10 = this.$constraints;
            int i13 = this.$tabRowHeight;
            Iterator<T> it = listSubcompose.iterator();
            while (it.hasNext()) {
                Placeable placeableMo2987measureBRTryo0 = ((Measurable) it.next()).mo2987measureBRTryo0(Constraints.m3632copyZbe2FdA$default(j10, 0, 0, 0, 0, 11, null));
                Placeable.PlacementScope.placeRelative$default(layout, placeableMo2987measureBRTryo0, 0, i13 - placeableMo2987measureBRTryo0.getHeight(), 0.0f, 4, null);
                i13 = i13;
                j10 = j10;
            }
            List<Measurable> listSubcompose2 = this.$this_SubcomposeLayout.subcompose(TabSlots.Indicator, ComposableLambdaKt.composableLambdaInstance(-1341594997, true, new AnonymousClass3(this.$indicator, this.$tabPositions, this.$$dirty)));
            int i14 = this.$tabRowWidth;
            int i15 = this.$tabRowHeight;
            Iterator<T> it2 = listSubcompose2.iterator();
            while (it2.hasNext()) {
                Placeable.PlacementScope.placeRelative$default(layout, ((Measurable) it2.next()).mo2987measureBRTryo0(Constraints.Companion.m3649fixedJhjzzOo(i14, i15)), 0, 0, 0.0f, 4, null);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    TabRowKt$TabRow$2$1$1(p<? super Composer, ? super Integer, k0> pVar, p<? super Composer, ? super Integer, k0> pVar2, q<? super List<TabPosition>, ? super Composer, ? super Integer, k0> qVar, int i10) {
        super(2);
        this.$tabs = pVar;
        this.$divider = pVar2;
        this.$indicator = qVar;
        this.$$dirty = i10;
    }

    @Override // h9.p
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ MeasureResult mo4invoke(SubcomposeMeasureScope subcomposeMeasureScope, Constraints constraints) {
        return m1185invoke0kLqBqw(subcomposeMeasureScope, constraints.m3647unboximpl());
    }

    @NotNull
    /* JADX INFO: renamed from: invoke-0kLqBqw, reason: not valid java name */
    public final MeasureResult m1185invoke0kLqBqw(@NotNull SubcomposeMeasureScope SubcomposeLayout, long j10) {
        Object next;
        t.i(SubcomposeLayout, "$this$SubcomposeLayout");
        int iM3641getMaxWidthimpl = Constraints.m3641getMaxWidthimpl(j10);
        List<Measurable> listSubcompose = SubcomposeLayout.subcompose(TabSlots.Tabs, this.$tabs);
        int size = listSubcompose.size();
        int i10 = iM3641getMaxWidthimpl / size;
        List<Measurable> list = listSubcompose;
        ArrayList arrayList = new ArrayList(w.v(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((Measurable) it.next()).mo2987measureBRTryo0(Constraints.m3632copyZbe2FdA$default(j10, i10, i10, 0, 0, 12, null)));
        }
        Iterator it2 = arrayList.iterator();
        if (it2.hasNext()) {
            next = it2.next();
            if (it2.hasNext()) {
                int height = ((Placeable) next).getHeight();
                do {
                    Object next2 = it2.next();
                    int height2 = ((Placeable) next2).getHeight();
                    if (height < height2) {
                        next = next2;
                        height = height2;
                    }
                } while (it2.hasNext());
            }
        } else {
            next = null;
        }
        Placeable placeable = (Placeable) next;
        int height3 = placeable != null ? placeable.getHeight() : 0;
        ArrayList arrayList2 = new ArrayList(size);
        for (int i11 = 0; i11 < size; i11++) {
            arrayList2.add(new TabPosition(Dp.m3673constructorimpl(SubcomposeLayout.mo293toDpu2uoSUM(i10) * i11), SubcomposeLayout.mo293toDpu2uoSUM(i10), null));
        }
        return MeasureScope.CC.p(SubcomposeLayout, iM3641getMaxWidthimpl, height3, null, new AnonymousClass1(arrayList, SubcomposeLayout, this.$divider, i10, j10, height3, this.$indicator, arrayList2, this.$$dirty, iM3641getMaxWidthimpl), 4, null);
    }
}
