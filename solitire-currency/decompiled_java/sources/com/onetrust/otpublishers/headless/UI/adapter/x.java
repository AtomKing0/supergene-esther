package com.onetrust.otpublishers.headless.UI.adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.SwitchCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import com.onetrust.otpublishers.headless.Public.DataModel.OTConfiguration;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes4.dex */
public final class x extends RecyclerView.Adapter<a> implements com.onetrust.otpublishers.headless.UI.a {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final com.onetrust.otpublishers.headless.UI.a f23162i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f23163j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f23164k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Context f23165l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f23166m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final ArrayList<com.onetrust.otpublishers.headless.UI.DataModels.c> f23167n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final com.onetrust.otpublishers.headless.Internal.Helper.w f23168o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final OTConfiguration f23169p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final com.onetrust.otpublishers.headless.UI.UIProperty.x f23170q;

    public static class a extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final TextView f23171b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final TextView f23172c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final SwitchCompat f23173d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final RecyclerView f23174e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final RecyclerView f23175f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final View f23176g;

        public a(View view) {
            super(view);
            this.f23172c = (TextView) view.findViewById(p6.d.f32733k4);
            this.f23171b = (TextView) view.findViewById(p6.d.f32715i4);
            this.f23175f = (RecyclerView) view.findViewById(p6.d.R0);
            this.f23174e = (RecyclerView) view.findViewById(p6.d.S0);
            this.f23173d = (SwitchCompat) view.findViewById(p6.d.f32760n4);
            this.f23176g = view.findViewById(p6.d.f32724j4);
        }
    }

    public x(@NonNull Context context, @NonNull com.onetrust.otpublishers.headless.UI.UIProperty.a0 a0Var, com.onetrust.otpublishers.headless.UI.UIProperty.x xVar, @NonNull String str, @NonNull com.onetrust.otpublishers.headless.UI.a aVar, @NonNull com.onetrust.otpublishers.headless.Internal.Helper.w wVar) {
        this.f23165l = context;
        this.f23170q = xVar;
        this.f23167n = a0Var.a();
        this.f23166m = str;
        this.f23162i = aVar;
        this.f23168o = wVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.onetrust.otpublishers.headless.UI.DataModels.c cVar, a aVar, int i10, View view) {
        Drawable thumbDrawable;
        int color;
        Drawable thumbDrawable2;
        int color2;
        this.f23168o.j(cVar.f22065a, aVar.f23173d.isChecked());
        if (aVar.f23173d.isChecked()) {
            SwitchCompat switchCompat = aVar.f23173d;
            switchCompat.getTrackDrawable().setTint(ContextCompat.getColor(this.f23165l, p6.a.f32627e));
            if (com.onetrust.otpublishers.headless.Internal.c.q(this.f23170q.f22851c)) {
                thumbDrawable2 = switchCompat.getThumbDrawable();
                color2 = ContextCompat.getColor(this.f23165l, p6.a.f32624b);
            } else {
                thumbDrawable2 = switchCompat.getThumbDrawable();
                color2 = Color.parseColor(this.f23170q.f22851c);
            }
            thumbDrawable2.setTint(color2);
            this.f23167n.get(i10).f22075k = "ACTIVE";
            d(aVar, cVar, true);
            return;
        }
        SwitchCompat switchCompat2 = aVar.f23173d;
        switchCompat2.getTrackDrawable().setTint(ContextCompat.getColor(this.f23165l, p6.a.f32627e));
        if (com.onetrust.otpublishers.headless.Internal.c.q(this.f23170q.f22852d)) {
            thumbDrawable = switchCompat2.getThumbDrawable();
            color = ContextCompat.getColor(this.f23165l, p6.a.f32625c);
        } else {
            thumbDrawable = switchCompat2.getThumbDrawable();
            color = Color.parseColor(this.f23170q.f22852d);
        }
        thumbDrawable.setTint(color);
        this.f23167n.get(i10).f22075k = "OPT_OUT";
        d(aVar, cVar, false);
        ArrayList<com.onetrust.otpublishers.headless.UI.DataModels.e> arrayList = cVar.f22073i;
        for (int i11 = 0; i11 < arrayList.size(); i11++) {
            ArrayList<com.onetrust.otpublishers.headless.UI.DataModels.d> arrayList2 = arrayList.get(i11).f22089b;
            for (int i12 = 0; i12 < arrayList2.size(); i12++) {
                arrayList2.get(i12).f22083h = "OPT_OUT";
            }
        }
        ArrayList<com.onetrust.otpublishers.headless.UI.DataModels.b> arrayList3 = cVar.f22074j;
        for (int i13 = 0; i13 < arrayList3.size(); i13++) {
            ArrayList<com.onetrust.otpublishers.headless.UI.DataModels.d> arrayList4 = arrayList3.get(i13).f22064f;
            for (int i14 = 0; i14 < arrayList4.size(); i14++) {
                arrayList4.get(i14).f22083h = "OPT_OUT";
            }
        }
    }

    public final void c(final a aVar) {
        Drawable thumbDrawable;
        int color;
        Drawable thumbDrawable2;
        int color2;
        final int adapterPosition = aVar.getAdapterPosition();
        final com.onetrust.otpublishers.headless.UI.DataModels.c cVar = this.f23167n.get(adapterPosition);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(aVar.f23175f.getContext(), 1, false);
        linearLayoutManager.setInitialPrefetchItemCount(cVar.f22074j.size());
        aVar.f23175f.setLayoutManager(linearLayoutManager);
        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(aVar.f23174e.getContext(), 1, false);
        linearLayoutManager2.setInitialPrefetchItemCount(cVar.f22073i.size());
        aVar.f23174e.setLayoutManager(linearLayoutManager2);
        if (!com.onetrust.otpublishers.headless.Internal.c.q(cVar.f22066b)) {
            this.f23163j = cVar.f22066b;
        }
        if (!com.onetrust.otpublishers.headless.Internal.c.q(cVar.f22067c)) {
            this.f23164k = cVar.f22067c;
        }
        OTLogger.a("OTConsentPreferencesAdapter", 3, "error in setting subgroup consent parent " + cVar.f22073i.size());
        aVar.f23175f.setRecycledViewPool(null);
        aVar.f23174e.setRecycledViewPool(null);
        boolean z10 = this.f23168o.u(cVar.f22065a) == 1;
        aVar.f23173d.setChecked(z10);
        String str = this.f23170q.f22850b;
        if (!com.onetrust.otpublishers.headless.Internal.c.q(str)) {
            aVar.f23176g.setBackgroundColor(Color.parseColor(str));
        }
        if (z10) {
            SwitchCompat switchCompat = aVar.f23173d;
            switchCompat.getTrackDrawable().setTint(ContextCompat.getColor(this.f23165l, p6.a.f32627e));
            if (com.onetrust.otpublishers.headless.Internal.c.q(this.f23170q.f22851c)) {
                thumbDrawable2 = switchCompat.getThumbDrawable();
                color2 = ContextCompat.getColor(this.f23165l, p6.a.f32624b);
            } else {
                thumbDrawable2 = switchCompat.getThumbDrawable();
                color2 = Color.parseColor(this.f23170q.f22851c);
            }
            thumbDrawable2.setTint(color2);
        } else {
            SwitchCompat switchCompat2 = aVar.f23173d;
            switchCompat2.getTrackDrawable().setTint(ContextCompat.getColor(this.f23165l, p6.a.f32627e));
            if (com.onetrust.otpublishers.headless.Internal.c.q(this.f23170q.f22852d)) {
                thumbDrawable = switchCompat2.getThumbDrawable();
                color = ContextCompat.getColor(this.f23165l, p6.a.f32625c);
            } else {
                thumbDrawable = switchCompat2.getThumbDrawable();
                color = Color.parseColor(this.f23170q.f22852d);
            }
            thumbDrawable.setTint(color);
        }
        TextView textView = aVar.f23172c;
        com.onetrust.otpublishers.headless.UI.UIProperty.c cVar2 = this.f23170q.f22868t;
        String str2 = this.f23163j;
        String str3 = cVar2.f22722c;
        if (com.onetrust.otpublishers.headless.Internal.c.q(str3)) {
            str3 = this.f23166m;
        }
        textView.setTextColor(Color.parseColor(str3));
        textView.setText(str2);
        if (!com.onetrust.otpublishers.headless.Internal.c.q(cVar2.f22720a.f22783b)) {
            textView.setTextSize(Float.parseFloat(cVar2.f22720a.f22783b));
        }
        TextView textView2 = aVar.f23171b;
        com.onetrust.otpublishers.headless.UI.UIProperty.c cVar3 = this.f23170q.f22868t;
        String str4 = this.f23164k;
        String str5 = cVar3.f22722c;
        if (com.onetrust.otpublishers.headless.Internal.c.q(str5)) {
            str5 = this.f23166m;
        }
        textView2.setTextColor(Color.parseColor(str5));
        textView2.setText(str4);
        if (!com.onetrust.otpublishers.headless.Internal.c.q(cVar3.f22720a.f22783b)) {
            textView2.setTextSize(Float.parseFloat(cVar3.f22720a.f22783b));
        }
        TextView textView3 = aVar.f23171b;
        com.onetrust.otpublishers.headless.UI.UIProperty.c cVar4 = this.f23170q.f22860l;
        if (!com.onetrust.otpublishers.headless.Internal.c.q(cVar4.f22720a.f22783b)) {
            textView3.setTextSize(Float.parseFloat(cVar4.f22720a.f22783b));
        }
        aVar.f23173d.setOnClickListener(new View.OnClickListener() { // from class: com.onetrust.otpublishers.headless.UI.adapter.w
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f23158a.b(cVar, aVar, adapterPosition, view);
            }
        });
        d(aVar, cVar, aVar.f23173d.isChecked());
    }

    public final void d(a aVar, com.onetrust.otpublishers.headless.UI.DataModels.c cVar, boolean z10) {
        f0 f0Var = new f0(this.f23165l, cVar.f22073i, this.f23163j, this.f23164k, this.f23170q, this.f23166m, this.f23162i, this.f23168o, z10, this.f23169p);
        z zVar = new z(this.f23165l, cVar.f22074j, this.f23163j, this.f23164k, this.f23170q, this.f23166m, this.f23162i, this.f23168o, z10, this.f23169p);
        aVar.f23174e.setAdapter(f0Var);
        aVar.f23175f.setAdapter(zVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f23167n.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final long getItemId(int i10) {
        return i10;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i10) {
        c((a) viewHolder);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i10) {
        return new a(LayoutInflater.from(viewGroup.getContext()).inflate(p6.e.Q, viewGroup, false));
    }

    @Override // com.onetrust.otpublishers.headless.UI.a
    public final void a(int i10) {
        com.onetrust.otpublishers.headless.UI.a aVar = this.f23162i;
        if (aVar != null) {
            aVar.a(i10);
        }
    }
}
