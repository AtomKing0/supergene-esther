package com.onetrust.otpublishers.headless.UI.adapter;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.RadioButton;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes4.dex */
public final class d0 extends RecyclerView.Adapter<a> implements com.onetrust.otpublishers.headless.UI.a {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f22937i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f22938j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f22939k = -1;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public RadioButton f22940l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final List<com.onetrust.otpublishers.headless.UI.DataModels.d> f22941m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final com.onetrust.otpublishers.headless.Internal.Helper.w f22942n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f22943o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final String f22944p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final com.onetrust.otpublishers.headless.UI.UIProperty.x f22945q;

    public static class a extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final CheckBox f22946b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final RadioButton f22947c;

        public a(View view) {
            super(view);
            this.f22946b = (CheckBox) view.findViewById(p6.d.M2);
            this.f22947c = (RadioButton) view.findViewById(p6.d.W4);
        }
    }

    public d0(@NonNull ArrayList arrayList, @NonNull String str, String str2, @NonNull com.onetrust.otpublishers.headless.Internal.Helper.w wVar, boolean z10, String str3, com.onetrust.otpublishers.headless.UI.UIProperty.x xVar) {
        this.f22941m = arrayList;
        this.f22938j = str;
        this.f22937i = str2;
        this.f22942n = wVar;
        this.f22943o = z10;
        this.f22945q = xVar;
        this.f22944p = str3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(a aVar, int i10, View view) {
        com.onetrust.otpublishers.headless.UI.DataModels.d dVar;
        String str;
        if (aVar.f22946b.isChecked()) {
            com.onetrust.otpublishers.headless.Internal.Helper.w wVar = this.f22942n;
            String str2 = this.f22941m.get(i10).f22087l;
            String str3 = this.f22941m.get(i10).f22076a;
            Objects.requireNonNull(str3);
            wVar.t(str2, str3, true);
            dVar = this.f22941m.get(i10);
            str = "OPT_IN";
        } else {
            com.onetrust.otpublishers.headless.Internal.Helper.w wVar2 = this.f22942n;
            String str4 = this.f22941m.get(i10).f22087l;
            String str5 = this.f22941m.get(i10).f22076a;
            Objects.requireNonNull(str5);
            wVar2.t(str4, str5, false);
            dVar = this.f22941m.get(i10);
            str = "OPT_OUT";
        }
        dVar.f22083h = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g(a aVar, View view) {
        RadioButton radioButton = this.f22940l;
        if (radioButton != null) {
            radioButton.setChecked(false);
        }
        aVar.f22947c.setChecked(true);
        this.f22940l = aVar.f22947c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(a aVar, int i10, View view) {
        com.onetrust.otpublishers.headless.UI.DataModels.d dVar;
        String str;
        if (aVar.f22946b.isChecked()) {
            this.f22942n.g(this.f22941m.get(i10).f22086k, this.f22941m.get(i10).f22084i, this.f22941m.get(i10).f22076a, true);
            dVar = this.f22941m.get(i10);
            str = "OPT_IN";
        } else {
            this.f22942n.g(this.f22941m.get(i10).f22086k, this.f22941m.get(i10).f22084i, this.f22941m.get(i10).f22076a, false);
            dVar = this.f22941m.get(i10);
            str = "OPT_OUT";
        }
        dVar.f22083h = str;
    }

    public final void d(final a aVar) {
        final int adapterPosition = aVar.getAdapterPosition();
        aVar.f22946b.setEnabled(this.f22943o);
        com.onetrust.otpublishers.headless.UI.UIProperty.c cVar = this.f22945q.f22860l;
        String str = this.f22944p;
        CheckBox checkBox = aVar.f22946b;
        if (!com.onetrust.otpublishers.headless.Internal.c.q(str)) {
            checkBox.setTextColor(Color.parseColor(str));
        }
        String str2 = cVar.f22720a.f22783b;
        if (!com.onetrust.otpublishers.headless.Internal.c.q(str2)) {
            checkBox.setTextSize(Float.parseFloat(str2));
        }
        String str3 = this.f22944p;
        RadioButton radioButton = aVar.f22947c;
        if (!com.onetrust.otpublishers.headless.Internal.c.q(str3)) {
            radioButton.setTextColor(Color.parseColor(str3));
        }
        String str4 = cVar.f22720a.f22783b;
        if (!com.onetrust.otpublishers.headless.Internal.c.q(str4)) {
            radioButton.setTextSize(Float.parseFloat(str4));
        }
        if (this.f22943o) {
            com.onetrust.otpublishers.headless.UI.mobiledatautils.c.c(aVar.f22946b, Color.parseColor(this.f22944p), Color.parseColor(this.f22944p));
        }
        com.onetrust.otpublishers.headless.UI.mobiledatautils.c.c(aVar.f22947c, Color.parseColor(this.f22944p), Color.parseColor(this.f22944p));
        if (!this.f22938j.equals("customPrefOptionType")) {
            if (this.f22938j.equals("topicOptionType") && this.f22937i.equals("null")) {
                aVar.f22947c.setVisibility(8);
                aVar.f22946b.setVisibility(0);
                aVar.f22946b.setText(this.f22941m.get(adapterPosition).f22078c);
                aVar.f22946b.setChecked(this.f22942n.a(this.f22941m.get(adapterPosition).f22076a, this.f22941m.get(adapterPosition).f22085j) == 1);
                aVar.f22946b.setOnClickListener(new View.OnClickListener() { // from class: com.onetrust.otpublishers.headless.UI.adapter.b0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.f22924a.f(aVar, adapterPosition, view);
                    }
                });
                return;
            }
            return;
        }
        if ("MULTI_CHOICE".equals(this.f22937i)) {
            aVar.f22947c.setVisibility(8);
            aVar.f22946b.setVisibility(0);
            aVar.f22946b.setText(this.f22941m.get(adapterPosition).f22080e);
            aVar.f22946b.setChecked(this.f22942n.b(this.f22941m.get(adapterPosition).f22076a, this.f22941m.get(adapterPosition).f22085j, this.f22941m.get(adapterPosition).f22086k) == 1);
            e(aVar, adapterPosition);
        } else if ("SINGLE_CHOICE".equals(this.f22937i)) {
            aVar.f22947c.setText(this.f22941m.get(adapterPosition).f22080e);
            aVar.f22947c.setTag(Integer.valueOf(adapterPosition));
            aVar.f22947c.setChecked(adapterPosition == this.f22939k);
            aVar.f22946b.setVisibility(8);
            aVar.f22947c.setVisibility(0);
            if (this.f22940l == null) {
                aVar.f22947c.setChecked(this.f22941m.get(adapterPosition).f22083h.equals("OPT_IN"));
                this.f22940l = aVar.f22947c;
            }
        }
        aVar.f22947c.setOnClickListener(new View.OnClickListener() { // from class: com.onetrust.otpublishers.headless.UI.adapter.a0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f22906a.g(aVar, view);
            }
        });
    }

    public final void e(final a aVar, final int i10) {
        aVar.f22946b.setOnClickListener(new View.OnClickListener() { // from class: com.onetrust.otpublishers.headless.UI.adapter.c0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f22931a.h(aVar, i10, view);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f22941m.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i10) {
        d((a) viewHolder);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i10) {
        return new a(LayoutInflater.from(viewGroup.getContext()).inflate(p6.e.R, viewGroup, false));
    }

    @Override // com.onetrust.otpublishers.headless.UI.a
    public final void a(int i10) {
        if (i10 == 4) {
            notifyDataSetChanged();
        }
    }
}
