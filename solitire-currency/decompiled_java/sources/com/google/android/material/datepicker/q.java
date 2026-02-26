package com.google.android.material.datepicker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.datepicker.j;

/* JADX INFO: compiled from: MonthsPagerAdapter.java */
/* JADX INFO: loaded from: classes3.dex */
class q extends RecyclerView.Adapter<b> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NonNull
    private final com.google.android.material.datepicker.a f9270i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final d<?> f9271j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @Nullable
    private final h f9272k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final j.m f9273l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final int f9274m;

    /* JADX INFO: compiled from: MonthsPagerAdapter.java */
    class a implements AdapterView.OnItemClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ MaterialCalendarGridView f9275a;

        a(MaterialCalendarGridView materialCalendarGridView) {
            this.f9275a = materialCalendarGridView;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i10, long j10) {
            if (this.f9275a.getAdapter().r(i10)) {
                q.this.f9273l.a(this.f9275a.getAdapter().getItem(i10).longValue());
            }
        }
    }

    /* JADX INFO: compiled from: MonthsPagerAdapter.java */
    public static class b extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final TextView f9277b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final MaterialCalendarGridView f9278c;

        b(@NonNull LinearLayout linearLayout, boolean z10) {
            super(linearLayout);
            TextView textView = (TextView) linearLayout.findViewById(e4.f.f24842w);
            this.f9277b = textView;
            ViewCompat.setAccessibilityHeading(textView, true);
            this.f9278c = (MaterialCalendarGridView) linearLayout.findViewById(e4.f.f24838s);
            if (z10) {
                return;
            }
            textView.setVisibility(8);
        }
    }

    q(@NonNull Context context, d<?> dVar, @NonNull com.google.android.material.datepicker.a aVar, @Nullable h hVar, j.m mVar) {
        o oVarM = aVar.m();
        o oVarH = aVar.h();
        o oVarL = aVar.l();
        if (oVarM.compareTo(oVarL) > 0) {
            throw new IllegalArgumentException("firstPage cannot be after currentPage");
        }
        if (oVarL.compareTo(oVarH) > 0) {
            throw new IllegalArgumentException("currentPage cannot be after lastPage");
        }
        this.f9274m = (p.f9262g * j.E(context)) + (l.E(context) ? j.E(context) : 0);
        this.f9270i = aVar;
        this.f9271j = dVar;
        this.f9272k = hVar;
        this.f9273l = mVar;
        setHasStableIds(true);
    }

    @NonNull
    o b(int i10) {
        return this.f9270i.m().l(i10);
    }

    @NonNull
    CharSequence c(int i10) {
        return b(i10).j();
    }

    int d(@NonNull o oVar) {
        return this.f9270i.m().m(oVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NonNull b bVar, int i10) {
        o oVarL = this.f9270i.m().l(i10);
        bVar.f9277b.setText(oVarL.j());
        MaterialCalendarGridView materialCalendarGridView = (MaterialCalendarGridView) bVar.f9278c.findViewById(e4.f.f24838s);
        if (materialCalendarGridView.getAdapter() == null || !oVarL.equals(materialCalendarGridView.getAdapter().f9264a)) {
            p pVar = new p(oVarL, this.f9271j, this.f9270i, this.f9272k);
            materialCalendarGridView.setNumColumns(oVarL.f9258d);
            materialCalendarGridView.setAdapter((ListAdapter) pVar);
        } else {
            materialCalendarGridView.invalidate();
            materialCalendarGridView.getAdapter().q(materialCalendarGridView);
        }
        materialCalendarGridView.setOnItemClickListener(new a(materialCalendarGridView));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public b onCreateViewHolder(@NonNull ViewGroup viewGroup, int i10) {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(viewGroup.getContext()).inflate(e4.h.f24865q, viewGroup, false);
        if (!l.E(viewGroup.getContext())) {
            return new b(linearLayout, false);
        }
        linearLayout.setLayoutParams(new RecyclerView.LayoutParams(-1, this.f9274m));
        return new b(linearLayout, true);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f9270i.k();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i10) {
        return this.f9270i.m().l(i10).k();
    }
}
