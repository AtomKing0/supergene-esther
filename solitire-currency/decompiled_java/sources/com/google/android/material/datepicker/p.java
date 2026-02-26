package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.widget.BaseAdapter;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.core.util.Pair;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: compiled from: MonthAdapter.java */
/* JADX INFO: loaded from: classes3.dex */
class p extends BaseAdapter {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    static final int f9262g = a0.k().getMaximum(4);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final int f9263h = (a0.k().getMaximum(5) + a0.k().getMaximum(7)) - 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final o f9264a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final d<?> f9265b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Collection<Long> f9266c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    c f9267d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final a f9268e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    final h f9269f;

    p(o oVar, d<?> dVar, a aVar, @Nullable h hVar) {
        this.f9264a = oVar;
        this.f9265b = dVar;
        this.f9268e = aVar;
        this.f9269f = hVar;
        this.f9266c = dVar.S();
    }

    private String c(Context context, long j10) {
        return f.a(context, j10, l(j10), k(j10), g(j10));
    }

    private void f(Context context) {
        if (this.f9267d == null) {
            this.f9267d = new c(context);
        }
    }

    private boolean j(long j10) {
        Iterator<Long> it = this.f9265b.S().iterator();
        while (it.hasNext()) {
            if (a0.a(j10) == a0.a(it.next().longValue())) {
                return true;
            }
        }
        return false;
    }

    private boolean l(long j10) {
        return a0.i().getTimeInMillis() == j10;
    }

    private void o(@Nullable TextView textView, long j10, int i10) {
        boolean z10;
        b bVar;
        if (textView == null) {
            return;
        }
        Context context = textView.getContext();
        String strC = c(context, j10);
        textView.setContentDescription(strC);
        boolean z11 = this.f9268e.g().z(j10);
        if (z11) {
            textView.setEnabled(true);
            boolean zJ = j(j10);
            textView.setSelected(zJ);
            bVar = zJ ? this.f9267d.f9166b : l(j10) ? this.f9267d.f9167c : this.f9267d.f9165a;
            z10 = zJ;
        } else {
            textView.setEnabled(false);
            z10 = false;
            bVar = this.f9267d.f9171g;
        }
        h hVar = this.f9269f;
        if (hVar == null || i10 == -1) {
            bVar.d(textView);
            return;
        }
        o oVar = this.f9264a;
        int i11 = oVar.f9257c;
        int i12 = oVar.f9256b;
        ColorStateList colorStateListA = hVar.a(context, i11, i12, i10, z11, z10);
        boolean z12 = z10;
        bVar.e(textView, colorStateListA, this.f9269f.g(context, i11, i12, i10, z11, z12));
        Drawable drawableC = this.f9269f.c(context, i11, i12, i10, z11, z12);
        Drawable drawableE = this.f9269f.e(context, i11, i12, i10, z11, z12);
        Drawable drawableD = this.f9269f.d(context, i11, i12, i10, z11, z12);
        boolean z13 = z10;
        textView.setCompoundDrawables(drawableC, drawableE, drawableD, this.f9269f.b(context, i11, i12, i10, z11, z13));
        textView.setContentDescription(this.f9269f.f(context, i11, i12, i10, z11, z13, strC));
    }

    private void p(MaterialCalendarGridView materialCalendarGridView, long j10) {
        if (o.d(j10).equals(this.f9264a)) {
            int iH = this.f9264a.h(j10);
            o((TextView) materialCalendarGridView.getChildAt(materialCalendarGridView.getAdapter().a(iH) - materialCalendarGridView.getFirstVisiblePosition()), j10, iH);
        }
    }

    int a(int i10) {
        return b() + (i10 - 1);
    }

    int b() {
        return this.f9264a.f(this.f9268e.j());
    }

    @Override // android.widget.Adapter
    @Nullable
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public Long getItem(int i10) {
        if (i10 < b() || i10 > m()) {
            return null;
        }
        return Long.valueOf(this.f9264a.g(n(i10)));
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0054  */
    @Override // android.widget.Adapter
    @androidx.annotation.NonNull
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.widget.TextView getView(int r6, @androidx.annotation.Nullable android.view.View r7, @androidx.annotation.NonNull android.view.ViewGroup r8) {
        /*
            r5 = this;
            android.content.Context r0 = r8.getContext()
            r5.f(r0)
            r0 = r7
            android.widget.TextView r0 = (android.widget.TextView) r0
            r1 = 0
            if (r7 != 0) goto L1e
            android.content.Context r7 = r8.getContext()
            android.view.LayoutInflater r7 = android.view.LayoutInflater.from(r7)
            int r0 = e4.h.f24862n
            android.view.View r7 = r7.inflate(r0, r8, r1)
            r0 = r7
            android.widget.TextView r0 = (android.widget.TextView) r0
        L1e:
            int r7 = r5.b()
            int r7 = r6 - r7
            if (r7 < 0) goto L54
            com.google.android.material.datepicker.o r8 = r5.f9264a
            int r2 = r8.f9259e
            if (r7 < r2) goto L2d
            goto L54
        L2d:
            r2 = 1
            int r7 = r7 + r2
            r0.setTag(r8)
            android.content.res.Resources r8 = r0.getResources()
            android.content.res.Configuration r8 = r8.getConfiguration()
            java.util.Locale r8 = r8.locale
            java.lang.Object[] r3 = new java.lang.Object[r2]
            java.lang.Integer r4 = java.lang.Integer.valueOf(r7)
            r3[r1] = r4
            java.lang.String r4 = "%d"
            java.lang.String r8 = java.lang.String.format(r8, r4, r3)
            r0.setText(r8)
            r0.setVisibility(r1)
            r0.setEnabled(r2)
            goto L5d
        L54:
            r7 = 8
            r0.setVisibility(r7)
            r0.setEnabled(r1)
            r7 = -1
        L5d:
            java.lang.Long r6 = r5.getItem(r6)
            if (r6 != 0) goto L64
            return r0
        L64:
            long r1 = r6.longValue()
            r5.o(r0, r1, r7)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.datepicker.p.getView(int, android.view.View, android.view.ViewGroup):android.widget.TextView");
    }

    @VisibleForTesting
    boolean g(long j10) {
        Iterator<Pair<Long, Long>> it = this.f9265b.J().iterator();
        while (it.hasNext()) {
            Long l10 = it.next().second;
            if (l10 != null && l10.longValue() == j10) {
                return true;
            }
        }
        return false;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return f9263h;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i10) {
        return i10 / this.f9264a.f9258d;
    }

    boolean h(int i10) {
        return i10 % this.f9264a.f9258d == 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return true;
    }

    boolean i(int i10) {
        return (i10 + 1) % this.f9264a.f9258d == 0;
    }

    @VisibleForTesting
    boolean k(long j10) {
        Iterator<Pair<Long, Long>> it = this.f9265b.J().iterator();
        while (it.hasNext()) {
            Long l10 = it.next().first;
            if (l10 != null && l10.longValue() == j10) {
                return true;
            }
        }
        return false;
    }

    int m() {
        return (b() + this.f9264a.f9259e) - 1;
    }

    int n(int i10) {
        return (i10 - b()) + 1;
    }

    public void q(MaterialCalendarGridView materialCalendarGridView) {
        Iterator<Long> it = this.f9266c.iterator();
        while (it.hasNext()) {
            p(materialCalendarGridView, it.next().longValue());
        }
        d<?> dVar = this.f9265b;
        if (dVar != null) {
            Iterator<Long> it2 = dVar.S().iterator();
            while (it2.hasNext()) {
                p(materialCalendarGridView, it2.next().longValue());
            }
            this.f9266c = this.f9265b.S();
        }
    }

    boolean r(int i10) {
        return i10 >= b() && i10 <= m();
    }
}
