package androidx.compose.material;

import androidx.compose.runtime.Immutable;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DpOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.window.PopupPositionProvider;
import h9.p;
import java.util.Iterator;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import o9.g;
import o9.m;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: Menu.kt */
/* JADX INFO: loaded from: classes.dex */
@Immutable
public final class DropdownMenuPositionProvider implements PopupPositionProvider {
    private final long contentOffset;

    @NotNull
    private final Density density;

    @NotNull
    private final p<IntRect, IntRect, k0> onPositionCalculated;

    /* JADX INFO: renamed from: androidx.compose.material.DropdownMenuPositionProvider$1, reason: invalid class name */
    /* JADX INFO: compiled from: Menu.kt */
    static final class AnonymousClass1 extends v implements p<IntRect, IntRect, k0> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(2);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull IntRect intRect, @NotNull IntRect intRect2) {
            t.i(intRect, "<anonymous parameter 0>");
            t.i(intRect2, "<anonymous parameter 1>");
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ k0 mo4invoke(IntRect intRect, IntRect intRect2) {
            invoke2(intRect, intRect2);
            return k0.f35197a;
        }
    }

    public /* synthetic */ DropdownMenuPositionProvider(long j10, Density density, p pVar, k kVar) {
        this(j10, density, pVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: copy-rOJDEFc$default, reason: not valid java name */
    public static /* synthetic */ DropdownMenuPositionProvider m1012copyrOJDEFc$default(DropdownMenuPositionProvider dropdownMenuPositionProvider, long j10, Density density, p pVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            j10 = dropdownMenuPositionProvider.contentOffset;
        }
        if ((i10 & 2) != 0) {
            density = dropdownMenuPositionProvider.density;
        }
        if ((i10 & 4) != 0) {
            pVar = dropdownMenuPositionProvider.onPositionCalculated;
        }
        return dropdownMenuPositionProvider.m1014copyrOJDEFc(j10, density, pVar);
    }

    @Override // androidx.compose.ui.window.PopupPositionProvider
    /* JADX INFO: renamed from: calculatePosition-llwVHH4 */
    public long mo758calculatePositionllwVHH4(@NotNull IntRect anchorBounds, long j10, @NotNull LayoutDirection layoutDirection, long j11) {
        g gVarG;
        Object obj;
        Object next;
        t.i(anchorBounds, "anchorBounds");
        t.i(layoutDirection, "layoutDirection");
        int iMo290roundToPx0680j_4 = this.density.mo290roundToPx0680j_4(MenuKt.getMenuVerticalMargin());
        int iMo290roundToPx0680j_42 = this.density.mo290roundToPx0680j_4(DpOffset.m3734getXD9Ej5fM(this.contentOffset));
        int iMo290roundToPx0680j_43 = this.density.mo290roundToPx0680j_4(DpOffset.m3736getYD9Ej5fM(this.contentOffset));
        int left = anchorBounds.getLeft() + iMo290roundToPx0680j_42;
        int right = (anchorBounds.getRight() - iMo290roundToPx0680j_42) - IntSize.m3833getWidthimpl(j11);
        int iM3833getWidthimpl = IntSize.m3833getWidthimpl(j10) - IntSize.m3833getWidthimpl(j11);
        if (layoutDirection == LayoutDirection.Ltr) {
            Integer[] numArr = new Integer[3];
            numArr[0] = Integer.valueOf(left);
            numArr[1] = Integer.valueOf(right);
            if (anchorBounds.getLeft() < 0) {
                iM3833getWidthimpl = 0;
            }
            numArr[2] = Integer.valueOf(iM3833getWidthimpl);
            gVarG = m.g(numArr);
        } else {
            Integer[] numArr2 = new Integer[3];
            numArr2[0] = Integer.valueOf(right);
            numArr2[1] = Integer.valueOf(left);
            if (anchorBounds.getRight() <= IntSize.m3833getWidthimpl(j10)) {
                iM3833getWidthimpl = 0;
            }
            numArr2[2] = Integer.valueOf(iM3833getWidthimpl);
            gVarG = m.g(numArr2);
        }
        Iterator it = gVarG.iterator();
        while (true) {
            obj = null;
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            int iIntValue = ((Number) next).intValue();
            if (iIntValue >= 0 && iIntValue + IntSize.m3833getWidthimpl(j11) <= IntSize.m3833getWidthimpl(j10)) {
                break;
            }
        }
        Integer num = (Integer) next;
        if (num != null) {
            right = num.intValue();
        }
        int iMax = Math.max(anchorBounds.getBottom() + iMo290roundToPx0680j_43, iMo290roundToPx0680j_4);
        int top = (anchorBounds.getTop() - iMo290roundToPx0680j_43) - IntSize.m3832getHeightimpl(j11);
        Iterator it2 = m.g(Integer.valueOf(iMax), Integer.valueOf(top), Integer.valueOf(anchorBounds.getTop() - (IntSize.m3832getHeightimpl(j11) / 2)), Integer.valueOf((IntSize.m3832getHeightimpl(j10) - IntSize.m3832getHeightimpl(j11)) - iMo290roundToPx0680j_4)).iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            Object next2 = it2.next();
            int iIntValue2 = ((Number) next2).intValue();
            if (iIntValue2 >= iMo290roundToPx0680j_4 && iIntValue2 + IntSize.m3832getHeightimpl(j11) <= IntSize.m3832getHeightimpl(j10) - iMo290roundToPx0680j_4) {
                obj = next2;
                break;
            }
        }
        Integer num2 = (Integer) obj;
        if (num2 != null) {
            top = num2.intValue();
        }
        this.onPositionCalculated.mo4invoke(anchorBounds, new IntRect(right, top, IntSize.m3833getWidthimpl(j11) + right, IntSize.m3832getHeightimpl(j11) + top));
        return IntOffsetKt.IntOffset(right, top);
    }

    /* JADX INFO: renamed from: component1-RKDOV3M, reason: not valid java name */
    public final long m1013component1RKDOV3M() {
        return this.contentOffset;
    }

    @NotNull
    public final Density component2() {
        return this.density;
    }

    @NotNull
    public final p<IntRect, IntRect, k0> component3() {
        return this.onPositionCalculated;
    }

    @NotNull
    /* JADX INFO: renamed from: copy-rOJDEFc, reason: not valid java name */
    public final DropdownMenuPositionProvider m1014copyrOJDEFc(long j10, @NotNull Density density, @NotNull p<? super IntRect, ? super IntRect, k0> onPositionCalculated) {
        t.i(density, "density");
        t.i(onPositionCalculated, "onPositionCalculated");
        return new DropdownMenuPositionProvider(j10, density, onPositionCalculated, null);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DropdownMenuPositionProvider)) {
            return false;
        }
        DropdownMenuPositionProvider dropdownMenuPositionProvider = (DropdownMenuPositionProvider) obj;
        return DpOffset.m3733equalsimpl0(this.contentOffset, dropdownMenuPositionProvider.contentOffset) && t.d(this.density, dropdownMenuPositionProvider.density) && t.d(this.onPositionCalculated, dropdownMenuPositionProvider.onPositionCalculated);
    }

    /* JADX INFO: renamed from: getContentOffset-RKDOV3M, reason: not valid java name */
    public final long m1015getContentOffsetRKDOV3M() {
        return this.contentOffset;
    }

    @NotNull
    public final Density getDensity() {
        return this.density;
    }

    @NotNull
    public final p<IntRect, IntRect, k0> getOnPositionCalculated() {
        return this.onPositionCalculated;
    }

    public int hashCode() {
        return (((DpOffset.m3738hashCodeimpl(this.contentOffset) * 31) + this.density.hashCode()) * 31) + this.onPositionCalculated.hashCode();
    }

    @NotNull
    public String toString() {
        return "DropdownMenuPositionProvider(contentOffset=" + ((Object) DpOffset.m3741toStringimpl(this.contentOffset)) + ", density=" + this.density + ", onPositionCalculated=" + this.onPositionCalculated + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    private DropdownMenuPositionProvider(long j10, Density density, p<? super IntRect, ? super IntRect, k0> pVar) {
        this.contentOffset = j10;
        this.density = density;
        this.onPositionCalculated = pVar;
    }

    public /* synthetic */ DropdownMenuPositionProvider(long j10, Density density, p pVar, int i10, k kVar) {
        this(j10, density, (i10 & 4) != 0 ? AnonymousClass1.INSTANCE : pVar, null);
    }
}
