package com.google.android.material.datepicker;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.datepicker.j;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Locale;

/* JADX INFO: compiled from: YearGridAdapter.java */
/* JADX INFO: loaded from: classes3.dex */
class b0 extends RecyclerView.Adapter<b> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final j<?> f9161i;

    /* JADX INFO: compiled from: YearGridAdapter.java */
    class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f9162a;

        a(int i10) {
            this.f9162a = i10;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b0.this.f9161i.J(b0.this.f9161i.A().f(o.c(this.f9162a, b0.this.f9161i.C().f9256b)));
            b0.this.f9161i.K(j.l.DAY);
        }
    }

    /* JADX INFO: compiled from: YearGridAdapter.java */
    public static class b extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final TextView f9164b;

        b(TextView textView) {
            super(textView);
            this.f9164b = textView;
        }
    }

    b0(j<?> jVar) {
        this.f9161i = jVar;
    }

    @NonNull
    private View.OnClickListener b(int i10) {
        return new a(i10);
    }

    int c(int i10) {
        return i10 - this.f9161i.A().m().f9257c;
    }

    int d(int i10) {
        return this.f9161i.A().m().f9257c + i10;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NonNull b bVar, int i10) {
        int iD = d(i10);
        bVar.f9164b.setText(String.format(Locale.getDefault(), "%d", Integer.valueOf(iD)));
        TextView textView = bVar.f9164b;
        textView.setContentDescription(f.e(textView.getContext(), iD));
        c cVarB = this.f9161i.B();
        Calendar calendarI = a0.i();
        com.google.android.material.datepicker.b bVar2 = calendarI.get(1) == iD ? cVarB.f9170f : cVarB.f9168d;
        Iterator<Long> it = this.f9161i.D().S().iterator();
        while (it.hasNext()) {
            calendarI.setTimeInMillis(it.next().longValue());
            if (calendarI.get(1) == iD) {
                bVar2 = cVarB.f9169e;
            }
        }
        bVar2.d(bVar.f9164b);
        bVar.f9164b.setOnClickListener(b(iD));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public b onCreateViewHolder(@NonNull ViewGroup viewGroup, int i10) {
        return new b((TextView) LayoutInflater.from(viewGroup.getContext()).inflate(e4.h.f24867s, viewGroup, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f9161i.A().n();
    }
}
