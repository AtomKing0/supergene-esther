package com.google.android.material.floatingactionbutton;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.AnimatorRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.button.MaterialButton;
import e4.j;
import e4.k;
import f4.h;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class ExtendedFloatingActionButton extends MaterialButton implements CoordinatorLayout.AttachedBehavior {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final int f9285r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f9286s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f9287t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    @NonNull
    private final CoordinatorLayout.Behavior<ExtendedFloatingActionButton> f9288u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private boolean f9289v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private boolean f9290w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private boolean f9291x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    @NonNull
    protected ColorStateList f9292y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private static final int f9284z = j.f24913s;
    static final Property<View, Float> A = new a(Float.class, "width");
    static final Property<View, Float> B = new b(Float.class, "height");
    static final Property<View, Float> C = new c(Float.class, "paddingStart");
    static final Property<View, Float> D = new d(Float.class, "paddingEnd");

    class a extends Property<View, Float> {
        a(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        @NonNull
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(@NonNull View view) {
            return Float.valueOf(view.getLayoutParams().width);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(@NonNull View view, @NonNull Float f10) {
            view.getLayoutParams().width = f10.intValue();
            view.requestLayout();
        }
    }

    class b extends Property<View, Float> {
        b(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        @NonNull
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(@NonNull View view) {
            return Float.valueOf(view.getLayoutParams().height);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(@NonNull View view, @NonNull Float f10) {
            view.getLayoutParams().height = f10.intValue();
            view.requestLayout();
        }
    }

    class c extends Property<View, Float> {
        c(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        @NonNull
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(@NonNull View view) {
            return Float.valueOf(ViewCompat.getPaddingStart(view));
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(@NonNull View view, @NonNull Float f10) {
            ViewCompat.setPaddingRelative(view, f10.intValue(), view.getPaddingTop(), ViewCompat.getPaddingEnd(view), view.getPaddingBottom());
        }
    }

    class d extends Property<View, Float> {
        d(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        @NonNull
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(@NonNull View view) {
            return Float.valueOf(ViewCompat.getPaddingEnd(view));
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(@NonNull View view, @NonNull Float f10) {
            ViewCompat.setPaddingRelative(view, ViewCompat.getPaddingStart(view), view.getPaddingTop(), f10.intValue(), view.getPaddingBottom());
        }
    }

    public static abstract class e {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(int i10, @Nullable e eVar) {
        if (i10 == 0 || i10 == 1 || i10 == 2 || i10 == 3) {
            throw null;
        }
        throw new IllegalStateException("Unknown strategy type: " + i10);
    }

    private void l() {
        this.f9292y = getTextColors();
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.AttachedBehavior
    @NonNull
    public CoordinatorLayout.Behavior<ExtendedFloatingActionButton> getBehavior() {
        return this.f9288u;
    }

    int getCollapsedPadding() {
        return (getCollapsedSize() - getIconSize()) / 2;
    }

    @VisibleForTesting
    int getCollapsedSize() {
        int i10 = this.f9285r;
        return i10 < 0 ? (Math.min(ViewCompat.getPaddingStart(this), ViewCompat.getPaddingEnd(this)) * 2) + getIconSize() : i10;
    }

    @Nullable
    public h getExtendMotionSpec() {
        throw null;
    }

    @Nullable
    public h getHideMotionSpec() {
        throw null;
    }

    @Nullable
    public h getShowMotionSpec() {
        throw null;
    }

    @Nullable
    public h getShrinkMotionSpec() {
        throw null;
    }

    @Override // com.google.android.material.button.MaterialButton, android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f9289v && TextUtils.isEmpty(getText()) && getIcon() != null) {
            this.f9289v = false;
            throw null;
        }
    }

    public void setAnimateShowBeforeLayout(boolean z10) {
        this.f9291x = z10;
    }

    public void setExtendMotionSpec(@Nullable h hVar) {
        throw null;
    }

    public void setExtendMotionSpecResource(@AnimatorRes int i10) {
        setExtendMotionSpec(h.c(getContext(), i10));
    }

    public void setExtended(boolean z10) {
        if (this.f9289v != z10) {
            throw null;
        }
    }

    public void setHideMotionSpec(@Nullable h hVar) {
        throw null;
    }

    public void setHideMotionSpecResource(@AnimatorRes int i10) {
        setHideMotionSpec(h.c(getContext(), i10));
    }

    @Override // android.widget.TextView, android.view.View
    public void setPadding(int i10, int i11, int i12, int i13) {
        super.setPadding(i10, i11, i12, i13);
        if (!this.f9289v || this.f9290w) {
            return;
        }
        this.f9286s = ViewCompat.getPaddingStart(this);
        this.f9287t = ViewCompat.getPaddingEnd(this);
    }

    @Override // android.widget.TextView, android.view.View
    public void setPaddingRelative(int i10, int i11, int i12, int i13) {
        super.setPaddingRelative(i10, i11, i12, i13);
        if (!this.f9289v || this.f9290w) {
            return;
        }
        this.f9286s = i10;
        this.f9287t = i12;
    }

    public void setShowMotionSpec(@Nullable h hVar) {
        throw null;
    }

    public void setShowMotionSpecResource(@AnimatorRes int i10) {
        setShowMotionSpec(h.c(getContext(), i10));
    }

    public void setShrinkMotionSpec(@Nullable h hVar) {
        throw null;
    }

    public void setShrinkMotionSpecResource(@AnimatorRes int i10) {
        setShrinkMotionSpec(h.c(getContext(), i10));
    }

    @Override // android.widget.TextView
    public void setTextColor(int i10) {
        super.setTextColor(i10);
        l();
    }

    protected static class ExtendedFloatingActionButtonBehavior<T extends ExtendedFloatingActionButton> extends CoordinatorLayout.Behavior<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Rect f9293a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f9294b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f9295c;

        public ExtendedFloatingActionButtonBehavior() {
            this.f9294b = false;
            this.f9295c = true;
        }

        private static boolean g(@NonNull View view) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof CoordinatorLayout.LayoutParams) {
                return ((CoordinatorLayout.LayoutParams) layoutParams).getBehavior() instanceof BottomSheetBehavior;
            }
            return false;
        }

        private boolean j(@NonNull View view, @NonNull ExtendedFloatingActionButton extendedFloatingActionButton) {
            return (this.f9294b || this.f9295c) && ((CoordinatorLayout.LayoutParams) extendedFloatingActionButton.getLayoutParams()).getAnchorId() == view.getId();
        }

        private boolean l(CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, @NonNull ExtendedFloatingActionButton extendedFloatingActionButton) {
            if (!j(appBarLayout, extendedFloatingActionButton)) {
                return false;
            }
            if (this.f9293a == null) {
                this.f9293a = new Rect();
            }
            Rect rect = this.f9293a;
            com.google.android.material.internal.c.a(coordinatorLayout, appBarLayout, rect);
            if (rect.bottom <= appBarLayout.getMinimumHeightForVisibleOverlappingContent()) {
                k(extendedFloatingActionButton);
                return true;
            }
            e(extendedFloatingActionButton);
            return true;
        }

        private boolean m(@NonNull View view, @NonNull ExtendedFloatingActionButton extendedFloatingActionButton) {
            if (!j(view, extendedFloatingActionButton)) {
                return false;
            }
            if (view.getTop() < (extendedFloatingActionButton.getHeight() / 2) + ((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.LayoutParams) extendedFloatingActionButton.getLayoutParams())).topMargin) {
                k(extendedFloatingActionButton);
                return true;
            }
            e(extendedFloatingActionButton);
            return true;
        }

        protected void e(@NonNull ExtendedFloatingActionButton extendedFloatingActionButton) {
            extendedFloatingActionButton.k(this.f9295c ? 3 : 0, null);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public boolean getInsetDodgeRect(@NonNull CoordinatorLayout coordinatorLayout, @NonNull ExtendedFloatingActionButton extendedFloatingActionButton, @NonNull Rect rect) {
            return super.getInsetDodgeRect(coordinatorLayout, extendedFloatingActionButton, rect);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, @NonNull ExtendedFloatingActionButton extendedFloatingActionButton, View view) {
            if (view instanceof AppBarLayout) {
                l(coordinatorLayout, (AppBarLayout) view, extendedFloatingActionButton);
                return false;
            }
            if (!g(view)) {
                return false;
            }
            m(view, extendedFloatingActionButton);
            return false;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public boolean onLayoutChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull ExtendedFloatingActionButton extendedFloatingActionButton, int i10) {
            List<View> dependencies = coordinatorLayout.getDependencies(extendedFloatingActionButton);
            int size = dependencies.size();
            for (int i11 = 0; i11 < size; i11++) {
                View view = dependencies.get(i11);
                if (!(view instanceof AppBarLayout)) {
                    if (g(view) && m(view, extendedFloatingActionButton)) {
                        break;
                    }
                } else {
                    if (l(coordinatorLayout, (AppBarLayout) view, extendedFloatingActionButton)) {
                        break;
                    }
                }
            }
            coordinatorLayout.onLayoutChild(extendedFloatingActionButton, i10);
            return true;
        }

        protected void k(@NonNull ExtendedFloatingActionButton extendedFloatingActionButton) {
            extendedFloatingActionButton.k(this.f9295c ? 2 : 1, null);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public void onAttachedToLayoutParams(@NonNull CoordinatorLayout.LayoutParams layoutParams) {
            if (layoutParams.dodgeInsetEdges == 0) {
                layoutParams.dodgeInsetEdges = 80;
            }
        }

        public ExtendedFloatingActionButtonBehavior(@NonNull Context context, @Nullable AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, k.f25048q1);
            this.f9294b = typedArrayObtainStyledAttributes.getBoolean(k.f25056r1, false);
            this.f9295c = typedArrayObtainStyledAttributes.getBoolean(k.f25064s1, true);
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    @Override // android.widget.TextView
    public void setTextColor(@NonNull ColorStateList colorStateList) {
        super.setTextColor(colorStateList);
        l();
    }
}
