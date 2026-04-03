package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListAdapter;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.annotation.VisibleForTesting;
import androidx.core.util.Pair;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.button.MaterialButton;
import java.util.Calendar;
import java.util.Iterator;

/* JADX INFO: compiled from: MaterialCalendar.java */
/* JADX INFO: loaded from: classes3.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class j<S> extends s<S> {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @VisibleForTesting
    static final Object f9178o = "MONTHS_VIEW_GROUP_TAG";

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @VisibleForTesting
    static final Object f9179p = "NAVIGATION_PREV_TAG";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @VisibleForTesting
    static final Object f9180q = "NAVIGATION_NEXT_TAG";

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @VisibleForTesting
    static final Object f9181r = "SELECTOR_TOGGLE_TAG";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @StyleRes
    private int f9182b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    private com.google.android.material.datepicker.d<S> f9183c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    private com.google.android.material.datepicker.a f9184d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    private com.google.android.material.datepicker.h f9185e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    private o f9186f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private l f9187g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private com.google.android.material.datepicker.c f9188h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private RecyclerView f9189i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private RecyclerView f9190j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private View f9191k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private View f9192l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private View f9193m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private View f9194n;

    /* JADX INFO: compiled from: MaterialCalendar.java */
    class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ q f9195a;

        a(q qVar) {
            this.f9195a = qVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int iFindLastVisibleItemPosition = j.this.G().findLastVisibleItemPosition() - 1;
            if (iFindLastVisibleItemPosition >= 0) {
                j.this.J(this.f9195a.b(iFindLastVisibleItemPosition));
            }
        }
    }

    /* JADX INFO: compiled from: MaterialCalendar.java */
    class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f9197a;

        b(int i10) {
            this.f9197a = i10;
        }

        @Override // java.lang.Runnable
        public void run() {
            j.this.f9190j.smoothScrollToPosition(this.f9197a);
        }
    }

    /* JADX INFO: compiled from: MaterialCalendar.java */
    class c extends AccessibilityDelegateCompat {
        c() {
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.setCollectionInfo(null);
        }
    }

    /* JADX INFO: compiled from: MaterialCalendar.java */
    class d extends t {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f9200a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(Context context, int i10, boolean z10, int i11) {
            super(context, i10, z10);
            this.f9200a = i11;
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager
        protected void calculateExtraLayoutSpace(@NonNull RecyclerView.State state, @NonNull int[] iArr) {
            if (this.f9200a == 0) {
                iArr[0] = j.this.f9190j.getWidth();
                iArr[1] = j.this.f9190j.getWidth();
            } else {
                iArr[0] = j.this.f9190j.getHeight();
                iArr[1] = j.this.f9190j.getHeight();
            }
        }
    }

    /* JADX INFO: compiled from: MaterialCalendar.java */
    class e implements m {
        e() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.android.material.datepicker.j.m
        public void a(long j10) {
            if (j.this.f9184d.g().z(j10)) {
                j.this.f9183c.h0(j10);
                Iterator<r<S>> it = j.this.f9279a.iterator();
                while (it.hasNext()) {
                    it.next().a(j.this.f9183c.W());
                }
                j.this.f9190j.getAdapter().notifyDataSetChanged();
                if (j.this.f9189i != null) {
                    j.this.f9189i.getAdapter().notifyDataSetChanged();
                }
            }
        }
    }

    /* JADX INFO: compiled from: MaterialCalendar.java */
    class f extends AccessibilityDelegateCompat {
        f() {
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.setScrollable(false);
        }
    }

    /* JADX INFO: compiled from: MaterialCalendar.java */
    class g extends RecyclerView.ItemDecoration {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Calendar f9204a = a0.k();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Calendar f9205b = a0.k();

        g() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void onDraw(@NonNull Canvas canvas, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.State state) {
            if ((recyclerView.getAdapter() instanceof b0) && (recyclerView.getLayoutManager() instanceof GridLayoutManager)) {
                b0 b0Var = (b0) recyclerView.getAdapter();
                GridLayoutManager gridLayoutManager = (GridLayoutManager) recyclerView.getLayoutManager();
                for (Pair<Long, Long> pair : j.this.f9183c.J()) {
                    Long l10 = pair.first;
                    if (l10 != null && pair.second != null) {
                        this.f9204a.setTimeInMillis(l10.longValue());
                        this.f9205b.setTimeInMillis(pair.second.longValue());
                        int iC = b0Var.c(this.f9204a.get(1));
                        int iC2 = b0Var.c(this.f9205b.get(1));
                        View viewFindViewByPosition = gridLayoutManager.findViewByPosition(iC);
                        View viewFindViewByPosition2 = gridLayoutManager.findViewByPosition(iC2);
                        int spanCount = iC / gridLayoutManager.getSpanCount();
                        int spanCount2 = iC2 / gridLayoutManager.getSpanCount();
                        int i10 = spanCount;
                        while (i10 <= spanCount2) {
                            if (gridLayoutManager.findViewByPosition(gridLayoutManager.getSpanCount() * i10) != null) {
                                canvas.drawRect((i10 != spanCount || viewFindViewByPosition == null) ? 0 : viewFindViewByPosition.getLeft() + (viewFindViewByPosition.getWidth() / 2), r9.getTop() + j.this.f9188h.f9168d.c(), (i10 != spanCount2 || viewFindViewByPosition2 == null) ? recyclerView.getWidth() : viewFindViewByPosition2.getLeft() + (viewFindViewByPosition2.getWidth() / 2), r9.getBottom() - j.this.f9188h.f9168d.b(), j.this.f9188h.f9172h);
                            }
                            i10++;
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: compiled from: MaterialCalendar.java */
    class h extends AccessibilityDelegateCompat {
        h() {
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.setHintText(j.this.f9194n.getVisibility() == 0 ? j.this.getString(e4.i.f24892u) : j.this.getString(e4.i.f24890s));
        }
    }

    /* JADX INFO: compiled from: MaterialCalendar.java */
    class i extends RecyclerView.OnScrollListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ q f9208a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ MaterialButton f9209b;

        i(q qVar, MaterialButton materialButton) {
            this.f9208a = qVar;
            this.f9209b = materialButton;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i10) {
            if (i10 == 0) {
                recyclerView.announceForAccessibility(this.f9209b.getText());
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(@NonNull RecyclerView recyclerView, int i10, int i11) {
            int iFindFirstVisibleItemPosition = i10 < 0 ? j.this.G().findFirstVisibleItemPosition() : j.this.G().findLastVisibleItemPosition();
            j.this.f9186f = this.f9208a.b(iFindFirstVisibleItemPosition);
            this.f9209b.setText(this.f9208a.c(iFindFirstVisibleItemPosition));
        }
    }

    /* JADX INFO: renamed from: com.google.android.material.datepicker.j$j, reason: collision with other inner class name */
    /* JADX INFO: compiled from: MaterialCalendar.java */
    class ViewOnClickListenerC0211j implements View.OnClickListener {
        ViewOnClickListenerC0211j() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            j.this.M();
        }
    }

    /* JADX INFO: compiled from: MaterialCalendar.java */
    class k implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ q f9212a;

        k(q qVar) {
            this.f9212a = qVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int iFindFirstVisibleItemPosition = j.this.G().findFirstVisibleItemPosition() + 1;
            if (iFindFirstVisibleItemPosition < j.this.f9190j.getAdapter().getItemCount()) {
                j.this.J(this.f9212a.b(iFindFirstVisibleItemPosition));
            }
        }
    }

    /* JADX INFO: compiled from: MaterialCalendar.java */
    enum l {
        DAY,
        YEAR
    }

    /* JADX INFO: compiled from: MaterialCalendar.java */
    interface m {
        void a(long j10);
    }

    @Px
    static int E(@NonNull Context context) {
        return context.getResources().getDimensionPixelSize(e4.d.O);
    }

    private static int F(@NonNull Context context) {
        Resources resources = context.getResources();
        int dimensionPixelSize = resources.getDimensionPixelSize(e4.d.V) + resources.getDimensionPixelOffset(e4.d.W) + resources.getDimensionPixelOffset(e4.d.U);
        int dimensionPixelSize2 = resources.getDimensionPixelSize(e4.d.Q);
        int i10 = p.f9262g;
        return dimensionPixelSize + dimensionPixelSize2 + (resources.getDimensionPixelSize(e4.d.O) * i10) + ((i10 - 1) * resources.getDimensionPixelOffset(e4.d.T)) + resources.getDimensionPixelOffset(e4.d.M);
    }

    @NonNull
    public static <T> j<T> H(@NonNull com.google.android.material.datepicker.d<T> dVar, @StyleRes int i10, @NonNull com.google.android.material.datepicker.a aVar, @Nullable com.google.android.material.datepicker.h hVar) {
        j<T> jVar = new j<>();
        Bundle bundle = new Bundle();
        bundle.putInt("THEME_RES_ID_KEY", i10);
        bundle.putParcelable("GRID_SELECTOR_KEY", dVar);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", aVar);
        bundle.putParcelable("DAY_VIEW_DECORATOR_KEY", hVar);
        bundle.putParcelable("CURRENT_MONTH_KEY", aVar.l());
        jVar.setArguments(bundle);
        return jVar;
    }

    private void I(int i10) {
        this.f9190j.post(new b(i10));
    }

    private void L() {
        ViewCompat.setAccessibilityDelegate(this.f9190j, new f());
    }

    private void y(@NonNull View view, @NonNull q qVar) {
        MaterialButton materialButton = (MaterialButton) view.findViewById(e4.f.f24839t);
        materialButton.setTag(f9181r);
        ViewCompat.setAccessibilityDelegate(materialButton, new h());
        View viewFindViewById = view.findViewById(e4.f.f24841v);
        this.f9191k = viewFindViewById;
        viewFindViewById.setTag(f9179p);
        View viewFindViewById2 = view.findViewById(e4.f.f24840u);
        this.f9192l = viewFindViewById2;
        viewFindViewById2.setTag(f9180q);
        this.f9193m = view.findViewById(e4.f.C);
        this.f9194n = view.findViewById(e4.f.f24843x);
        K(l.DAY);
        materialButton.setText(this.f9186f.j());
        this.f9190j.addOnScrollListener(new i(qVar, materialButton));
        materialButton.setOnClickListener(new ViewOnClickListenerC0211j());
        this.f9192l.setOnClickListener(new k(qVar));
        this.f9191k.setOnClickListener(new a(qVar));
    }

    @NonNull
    private RecyclerView.ItemDecoration z() {
        return new g();
    }

    @Nullable
    com.google.android.material.datepicker.a A() {
        return this.f9184d;
    }

    com.google.android.material.datepicker.c B() {
        return this.f9188h;
    }

    @Nullable
    o C() {
        return this.f9186f;
    }

    @Nullable
    public com.google.android.material.datepicker.d<S> D() {
        return this.f9183c;
    }

    @NonNull
    LinearLayoutManager G() {
        return (LinearLayoutManager) this.f9190j.getLayoutManager();
    }

    void J(o oVar) {
        q qVar = (q) this.f9190j.getAdapter();
        int iD = qVar.d(oVar);
        int iD2 = iD - qVar.d(this.f9186f);
        boolean z10 = Math.abs(iD2) > 3;
        boolean z11 = iD2 > 0;
        this.f9186f = oVar;
        if (z10 && z11) {
            this.f9190j.scrollToPosition(iD - 3);
            I(iD);
        } else if (!z10) {
            I(iD);
        } else {
            this.f9190j.scrollToPosition(iD + 3);
            I(iD);
        }
    }

    void K(l lVar) {
        this.f9187g = lVar;
        if (lVar == l.YEAR) {
            this.f9189i.getLayoutManager().scrollToPosition(((b0) this.f9189i.getAdapter()).c(this.f9186f.f9257c));
            this.f9193m.setVisibility(0);
            this.f9194n.setVisibility(8);
            this.f9191k.setVisibility(8);
            this.f9192l.setVisibility(8);
            return;
        }
        if (lVar == l.DAY) {
            this.f9193m.setVisibility(8);
            this.f9194n.setVisibility(0);
            this.f9191k.setVisibility(0);
            this.f9192l.setVisibility(0);
            J(this.f9186f);
        }
    }

    void M() {
        l lVar = this.f9187g;
        l lVar2 = l.YEAR;
        if (lVar == lVar2) {
            K(l.DAY);
        } else if (lVar == l.DAY) {
            K(lVar2);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            bundle = getArguments();
        }
        this.f9182b = bundle.getInt("THEME_RES_ID_KEY");
        this.f9183c = (com.google.android.material.datepicker.d) bundle.getParcelable("GRID_SELECTOR_KEY");
        this.f9184d = (com.google.android.material.datepicker.a) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
        this.f9185e = (com.google.android.material.datepicker.h) bundle.getParcelable("DAY_VIEW_DECORATOR_KEY");
        this.f9186f = (o) bundle.getParcelable("CURRENT_MONTH_KEY");
    }

    @Override // androidx.fragment.app.Fragment
    @NonNull
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        int i10;
        int i11;
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(getContext(), this.f9182b);
        this.f9188h = new com.google.android.material.datepicker.c(contextThemeWrapper);
        LayoutInflater layoutInflaterCloneInContext = layoutInflater.cloneInContext(contextThemeWrapper);
        o oVarM = this.f9184d.m();
        if (com.google.android.material.datepicker.l.E(contextThemeWrapper)) {
            i10 = e4.h.f24866r;
            i11 = 1;
        } else {
            i10 = e4.h.f24864p;
            i11 = 0;
        }
        View viewInflate = layoutInflaterCloneInContext.inflate(i10, viewGroup, false);
        viewInflate.setMinimumHeight(F(requireContext()));
        GridView gridView = (GridView) viewInflate.findViewById(e4.f.f24844y);
        ViewCompat.setAccessibilityDelegate(gridView, new c());
        int iJ = this.f9184d.j();
        gridView.setAdapter((ListAdapter) (iJ > 0 ? new com.google.android.material.datepicker.i(iJ) : new com.google.android.material.datepicker.i()));
        gridView.setNumColumns(oVarM.f9258d);
        gridView.setEnabled(false);
        this.f9190j = (RecyclerView) viewInflate.findViewById(e4.f.B);
        this.f9190j.setLayoutManager(new d(getContext(), i11, false, i11));
        this.f9190j.setTag(f9178o);
        q qVar = new q(contextThemeWrapper, this.f9183c, this.f9184d, this.f9185e, new e());
        this.f9190j.setAdapter(qVar);
        int integer = contextThemeWrapper.getResources().getInteger(e4.g.f24848c);
        RecyclerView recyclerView = (RecyclerView) viewInflate.findViewById(e4.f.C);
        this.f9189i = recyclerView;
        if (recyclerView != null) {
            recyclerView.setHasFixedSize(true);
            this.f9189i.setLayoutManager(new GridLayoutManager((Context) contextThemeWrapper, integer, 1, false));
            this.f9189i.setAdapter(new b0(this));
            this.f9189i.addItemDecoration(z());
        }
        if (viewInflate.findViewById(e4.f.f24839t) != null) {
            y(viewInflate, qVar);
        }
        if (!com.google.android.material.datepicker.l.E(contextThemeWrapper)) {
            new PagerSnapHelper().attachToRecyclerView(this.f9190j);
        }
        this.f9190j.scrollToPosition(qVar.d(this.f9186f));
        L();
        return viewInflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("THEME_RES_ID_KEY", this.f9182b);
        bundle.putParcelable("GRID_SELECTOR_KEY", this.f9183c);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", this.f9184d);
        bundle.putParcelable("DAY_VIEW_DECORATOR_KEY", this.f9185e);
        bundle.putParcelable("CURRENT_MONTH_KEY", this.f9186f);
    }

    @Override // com.google.android.material.datepicker.s
    public boolean p(@NonNull r<S> rVar) {
        return super.p(rVar);
    }
}
