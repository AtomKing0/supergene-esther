package com.google.android.material.search;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.activity.BackEventCompat;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.graphics.drawable.DrawerArrowDrawable;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.internal.ClippableRoundedCornerLayout;
import com.google.android.material.internal.TouchObserverFrameLayout;
import com.google.android.material.internal.e;
import com.google.android.material.internal.q;
import e4.d;
import e4.j;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import s4.f;
import x4.h;

/* JADX INFO: loaded from: classes3.dex */
public class SearchView extends FrameLayout implements CoordinatorLayout.AttachedBehavior, s4.b {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private static final int f9515x = j.f24904j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final ClippableRoundedCornerLayout f9516a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final View f9517b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final View f9518c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final FrameLayout f9519d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final MaterialToolbar f9520e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final TextView f9521f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final EditText f9522g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final TouchObserverFrameLayout f9523h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final boolean f9524i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NonNull
    private final s4.c f9525j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final boolean f9526k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final p4.a f9527l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final Set<b> f9528m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @Nullable
    private SearchBar f9529n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f9530o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f9531p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f9532q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private boolean f9533r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @ColorInt
    private final int f9534s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private boolean f9535t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private boolean f9536u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    @NonNull
    private c f9537v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private Map<View, Integer> f9538w;

    public static class Behavior extends CoordinatorLayout.Behavior<SearchView> {
        public Behavior() {
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public boolean onDependentViewChanged(@NonNull CoordinatorLayout coordinatorLayout, @NonNull SearchView searchView, @NonNull View view) {
            if (searchView.g() || !(view instanceof SearchBar)) {
                return false;
            }
            searchView.setupWithSearchBar((SearchBar) view);
            return false;
        }

        public Behavior(@NonNull Context context, @Nullable AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    static class a extends AbsSavedState {
        public static final Parcelable.Creator<a> CREATOR = new C0216a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f9539a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f9540b;

        /* JADX INFO: renamed from: com.google.android.material.search.SearchView$a$a, reason: collision with other inner class name */
        class C0216a implements Parcelable.ClassLoaderCreator<a> {
            C0216a() {
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public a createFromParcel(Parcel parcel) {
                return new a(parcel);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public a createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new a(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public a[] newArray(int i10) {
                return new a[i10];
            }
        }

        public a(Parcel parcel) {
            this(parcel, null);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeString(this.f9539a);
            parcel.writeInt(this.f9540b);
        }

        public a(Parcel parcel, @Nullable ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f9539a = parcel.readString();
            this.f9540b = parcel.readInt();
        }

        public a(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public interface b {
        void a(@NonNull SearchView searchView, @NonNull c cVar, @NonNull c cVar2);
    }

    public enum c {
        HIDING,
        HIDDEN,
        SHOWING,
        SHOWN
    }

    private boolean f() {
        return this.f9537v.equals(c.HIDDEN) || this.f9537v.equals(c.HIDING);
    }

    @Nullable
    private Window getActivityWindow() {
        Activity activityA = com.google.android.material.internal.b.a(getContext());
        if (activityA == null) {
            return null;
        }
        return activityA.getWindow();
    }

    private float getOverlayElevation() {
        SearchBar searchBar = this.f9529n;
        return searchBar != null ? searchBar.getCompatElevation() : getResources().getDimension(d.f24802u);
    }

    @Px
    private int getStatusBarHeight() {
        int identifier = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            return getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    private void h(@NonNull c cVar, boolean z10) {
        if (this.f9537v.equals(cVar)) {
            return;
        }
        if (z10) {
            if (cVar == c.SHOWN) {
                setModalForAccessibility(true);
            } else if (cVar == c.HIDDEN) {
                setModalForAccessibility(false);
            }
        }
        c cVar2 = this.f9537v;
        this.f9537v = cVar;
        Iterator it = new LinkedHashSet(this.f9528m).iterator();
        while (it.hasNext()) {
            ((b) it.next()).a(this, cVar2, cVar);
        }
        j(cVar);
    }

    @SuppressLint({"InlinedApi"})
    private void i(ViewGroup viewGroup, boolean z10) {
        for (int i10 = 0; i10 < viewGroup.getChildCount(); i10++) {
            View childAt = viewGroup.getChildAt(i10);
            if (childAt != this) {
                if (childAt.findViewById(this.f9516a.getId()) != null) {
                    i((ViewGroup) childAt, z10);
                } else if (z10) {
                    this.f9538w.put(childAt, Integer.valueOf(childAt.getImportantForAccessibility()));
                    ViewCompat.setImportantForAccessibility(childAt, 4);
                } else {
                    Map<View, Integer> map = this.f9538w;
                    if (map != null && map.containsKey(childAt)) {
                        ViewCompat.setImportantForAccessibility(childAt, this.f9538w.get(childAt).intValue());
                    }
                }
            }
        }
    }

    private void j(@NonNull c cVar) {
        if (this.f9529n == null || !this.f9526k) {
            return;
        }
        if (cVar.equals(c.SHOWN)) {
            this.f9525j.b();
        } else if (cVar.equals(c.HIDDEN)) {
            this.f9525j.d();
        }
    }

    private void k() {
        ImageButton imageButtonD = q.d(this.f9520e);
        if (imageButtonD == null) {
            return;
        }
        int i10 = this.f9516a.getVisibility() == 0 ? 1 : 0;
        Drawable drawableUnwrap = DrawableCompat.unwrap(imageButtonD.getDrawable());
        if (drawableUnwrap instanceof DrawerArrowDrawable) {
            ((DrawerArrowDrawable) drawableUnwrap).setProgress(i10);
        }
        if (drawableUnwrap instanceof e) {
            ((e) drawableUnwrap).a(i10);
        }
    }

    private void setStatusBarSpacerEnabledInternal(boolean z10) {
        this.f9518c.setVisibility(z10 ? 0 : 8);
    }

    private void setUpBackgroundViewElevationOverlay(float f10) {
        p4.a aVar = this.f9527l;
        if (aVar == null || this.f9517b == null) {
            return;
        }
        this.f9517b.setBackgroundColor(aVar.c(this.f9534s, f10));
    }

    private void setUpHeaderLayout(int i10) {
        if (i10 != -1) {
            e(LayoutInflater.from(getContext()).inflate(i10, (ViewGroup) this.f9519d, false));
        }
    }

    private void setUpStatusBarSpacer(@Px int i10) {
        if (this.f9518c.getLayoutParams().height != i10) {
            this.f9518c.getLayoutParams().height = i10;
            this.f9518c.requestLayout();
        }
    }

    @Override // s4.b
    public void a() {
        if (!f() && this.f9529n != null && Build.VERSION.SDK_INT >= 34) {
            throw null;
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i10, ViewGroup.LayoutParams layoutParams) {
        if (this.f9524i) {
            this.f9523h.addView(view, i10, layoutParams);
        } else {
            super.addView(view, i10, layoutParams);
        }
    }

    @Override // s4.b
    public void b(@NonNull BackEventCompat backEventCompat) {
        if (!f() && this.f9529n != null) {
            throw null;
        }
    }

    @Override // s4.b
    public void c(@NonNull BackEventCompat backEventCompat) {
        if (!f() && this.f9529n != null && Build.VERSION.SDK_INT >= 34) {
            throw null;
        }
    }

    @Override // s4.b
    public void d() {
        if (!f()) {
            throw null;
        }
    }

    public void e(@NonNull View view) {
        this.f9519d.addView(view);
        this.f9519d.setVisibility(0);
    }

    public boolean g() {
        return this.f9529n != null;
    }

    @VisibleForTesting
    f getBackHelper() {
        throw null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.AttachedBehavior
    @NonNull
    public CoordinatorLayout.Behavior<SearchView> getBehavior() {
        return new Behavior();
    }

    @NonNull
    public c getCurrentTransitionState() {
        return this.f9537v;
    }

    @DrawableRes
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected int getDefaultNavigationIconResource() {
        return e4.e.f24809b;
    }

    @NonNull
    public EditText getEditText() {
        return this.f9522g;
    }

    @Nullable
    public CharSequence getHint() {
        return this.f9522g.getHint();
    }

    @NonNull
    public TextView getSearchPrefix() {
        return this.f9521f;
    }

    @Nullable
    public CharSequence getSearchPrefixText() {
        return this.f9521f.getText();
    }

    @SuppressLint({"KotlinPropertyAccess"})
    public int getSoftInputMode() {
        return this.f9530o;
    }

    @NonNull
    @SuppressLint({"KotlinPropertyAccess"})
    public Editable getText() {
        return this.f9522g.getText();
    }

    @NonNull
    public Toolbar getToolbar() {
        return this.f9520e;
    }

    public void l() {
        Window activityWindow = getActivityWindow();
        if (activityWindow != null) {
            this.f9530o = activityWindow.getAttributes().softInputMode;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        h.e(this);
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        l();
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof a)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        a aVar = (a) parcelable;
        super.onRestoreInstanceState(aVar.getSuperState());
        setText(aVar.f9539a);
        setVisible(aVar.f9540b == 0);
    }

    @Override // android.view.View
    @NonNull
    protected Parcelable onSaveInstanceState() {
        a aVar = new a(super.onSaveInstanceState());
        Editable text = getText();
        aVar.f9539a = text == null ? null : text.toString();
        aVar.f9540b = this.f9516a.getVisibility();
        return aVar;
    }

    public void setAnimatedNavigationIcon(boolean z10) {
        this.f9531p = z10;
    }

    public void setAutoShowKeyboard(boolean z10) {
        this.f9533r = z10;
    }

    @Override // android.view.View
    @RequiresApi(21)
    public void setElevation(float f10) {
        super.setElevation(f10);
        setUpBackgroundViewElevationOverlay(f10);
    }

    public void setHint(@Nullable CharSequence charSequence) {
        this.f9522g.setHint(charSequence);
    }

    public void setMenuItemsAnimated(boolean z10) {
        this.f9532q = z10;
    }

    public void setModalForAccessibility(boolean z10) {
        ViewGroup viewGroup = (ViewGroup) getRootView();
        if (z10) {
            this.f9538w = new HashMap(viewGroup.getChildCount());
        }
        i(viewGroup, z10);
        if (z10) {
            return;
        }
        this.f9538w = null;
    }

    public void setOnMenuItemClickListener(@Nullable Toolbar.OnMenuItemClickListener onMenuItemClickListener) {
        this.f9520e.setOnMenuItemClickListener(onMenuItemClickListener);
    }

    public void setSearchPrefixText(@Nullable CharSequence charSequence) {
        this.f9521f.setText(charSequence);
        this.f9521f.setVisibility(TextUtils.isEmpty(charSequence) ? 8 : 0);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setStatusBarSpacerEnabled(boolean z10) {
        this.f9536u = true;
        setStatusBarSpacerEnabledInternal(z10);
    }

    @SuppressLint({"KotlinPropertyAccess"})
    public void setText(@Nullable CharSequence charSequence) {
        this.f9522g.setText(charSequence);
    }

    public void setToolbarTouchscreenBlocksFocus(boolean z10) {
        this.f9520e.setTouchscreenBlocksFocus(z10);
    }

    void setTransitionState(@NonNull c cVar) {
        h(cVar, true);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setUseWindowInsetsController(boolean z10) {
        this.f9535t = z10;
    }

    public void setVisible(boolean z10) {
        boolean z11 = this.f9516a.getVisibility() == 0;
        this.f9516a.setVisibility(z10 ? 0 : 8);
        k();
        h(z10 ? c.SHOWN : c.HIDDEN, z11 != z10);
    }

    public void setupWithSearchBar(@Nullable SearchBar searchBar) {
        this.f9529n = searchBar;
        throw null;
    }

    public void setHint(@StringRes int i10) {
        this.f9522g.setHint(i10);
    }

    public void setText(@StringRes int i10) {
        this.f9522g.setText(i10);
    }
}
