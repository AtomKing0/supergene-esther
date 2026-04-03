package androidx.core.view;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Px;
import java.util.Iterator;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: ViewGroup.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ViewGroupKt {

    /* JADX INFO: renamed from: androidx.core.view.ViewGroupKt$iterator$1, reason: invalid class name */
    /* JADX INFO: compiled from: ViewGroup.kt */
    public static final class AnonymousClass1 implements Iterator<View>, i9.a {
        final /* synthetic */ ViewGroup $this_iterator;
        private int index;

        AnonymousClass1(ViewGroup viewGroup) {
            this.$this_iterator = viewGroup;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.index < this.$this_iterator.getChildCount();
        }

        @Override // java.util.Iterator
        public void remove() {
            ViewGroup viewGroup = this.$this_iterator;
            int i10 = this.index - 1;
            this.index = i10;
            viewGroup.removeViewAt(i10);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        @NotNull
        public View next() {
            ViewGroup viewGroup = this.$this_iterator;
            int i10 = this.index;
            this.index = i10 + 1;
            View childAt = viewGroup.getChildAt(i10);
            if (childAt != null) {
                return childAt;
            }
            throw new IndexOutOfBoundsException();
        }
    }

    public static final boolean contains(@NotNull ViewGroup viewGroup, @NotNull View view) {
        return viewGroup.indexOfChild(view) != -1;
    }

    public static final void forEach(@NotNull ViewGroup viewGroup, @NotNull h9.l<? super View, v8.k0> lVar) {
        int childCount = viewGroup.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            lVar.invoke(viewGroup.getChildAt(i10));
        }
    }

    public static final void forEachIndexed(@NotNull ViewGroup viewGroup, @NotNull h9.p<? super Integer, ? super View, v8.k0> pVar) {
        int childCount = viewGroup.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            pVar.mo4invoke(Integer.valueOf(i10), viewGroup.getChildAt(i10));
        }
    }

    @NotNull
    public static final View get(@NotNull ViewGroup viewGroup, int i10) {
        View childAt = viewGroup.getChildAt(i10);
        if (childAt != null) {
            return childAt;
        }
        throw new IndexOutOfBoundsException("Index: " + i10 + ", Size: " + viewGroup.getChildCount());
    }

    @NotNull
    public static final o9.g<View> getChildren(@NotNull final ViewGroup viewGroup) {
        return new o9.g<View>() { // from class: androidx.core.view.ViewGroupKt$children$1
            @Override // o9.g
            @NotNull
            public Iterator<View> iterator() {
                return ViewGroupKt.iterator(viewGroup);
            }
        };
    }

    @NotNull
    public static final o9.g<View> getDescendants(@NotNull final ViewGroup viewGroup) {
        return new o9.g<View>() { // from class: androidx.core.view.ViewGroupKt$special$$inlined$Sequence$1
            @Override // o9.g
            @NotNull
            public Iterator<View> iterator() {
                return new TreeIterator(ViewGroupKt.getChildren(viewGroup).iterator(), ViewGroupKt$descendants$1$1.INSTANCE);
            }
        };
    }

    @NotNull
    public static final n9.i getIndices(@NotNull ViewGroup viewGroup) {
        return n9.o.u(0, viewGroup.getChildCount());
    }

    public static final int getSize(@NotNull ViewGroup viewGroup) {
        return viewGroup.getChildCount();
    }

    public static final boolean isEmpty(@NotNull ViewGroup viewGroup) {
        return viewGroup.getChildCount() == 0;
    }

    public static final boolean isNotEmpty(@NotNull ViewGroup viewGroup) {
        return viewGroup.getChildCount() != 0;
    }

    @NotNull
    public static final Iterator<View> iterator(@NotNull ViewGroup viewGroup) {
        return new AnonymousClass1(viewGroup);
    }

    public static final void minusAssign(@NotNull ViewGroup viewGroup, @NotNull View view) {
        viewGroup.removeView(view);
    }

    public static final void plusAssign(@NotNull ViewGroup viewGroup, @NotNull View view) {
        viewGroup.addView(view);
    }

    public static final void setMargins(@NotNull ViewGroup.MarginLayoutParams marginLayoutParams, @Px int i10) {
        marginLayoutParams.setMargins(i10, i10, i10, i10);
    }

    public static final void updateMargins(@NotNull ViewGroup.MarginLayoutParams marginLayoutParams, @Px int i10, @Px int i11, @Px int i12, @Px int i13) {
        marginLayoutParams.setMargins(i10, i11, i12, i13);
    }

    public static /* synthetic */ void updateMargins$default(ViewGroup.MarginLayoutParams marginLayoutParams, int i10, int i11, int i12, int i13, int i14, Object obj) {
        if ((i14 & 1) != 0) {
            i10 = marginLayoutParams.leftMargin;
        }
        if ((i14 & 2) != 0) {
            i11 = marginLayoutParams.topMargin;
        }
        if ((i14 & 4) != 0) {
            i12 = marginLayoutParams.rightMargin;
        }
        if ((i14 & 8) != 0) {
            i13 = marginLayoutParams.bottomMargin;
        }
        marginLayoutParams.setMargins(i10, i11, i12, i13);
    }

    public static final void updateMarginsRelative(@NotNull ViewGroup.MarginLayoutParams marginLayoutParams, @Px int i10, @Px int i11, @Px int i12, @Px int i13) {
        marginLayoutParams.setMarginStart(i10);
        marginLayoutParams.topMargin = i11;
        marginLayoutParams.setMarginEnd(i12);
        marginLayoutParams.bottomMargin = i13;
    }

    public static /* synthetic */ void updateMarginsRelative$default(ViewGroup.MarginLayoutParams marginLayoutParams, int i10, int i11, int i12, int i13, int i14, Object obj) {
        if ((i14 & 1) != 0) {
            i10 = marginLayoutParams.getMarginStart();
        }
        if ((i14 & 2) != 0) {
            i11 = marginLayoutParams.topMargin;
        }
        if ((i14 & 4) != 0) {
            i12 = marginLayoutParams.getMarginEnd();
        }
        if ((i14 & 8) != 0) {
            i13 = marginLayoutParams.bottomMargin;
        }
        marginLayoutParams.setMarginStart(i10);
        marginLayoutParams.topMargin = i11;
        marginLayoutParams.setMarginEnd(i12);
        marginLayoutParams.bottomMargin = i13;
    }
}
