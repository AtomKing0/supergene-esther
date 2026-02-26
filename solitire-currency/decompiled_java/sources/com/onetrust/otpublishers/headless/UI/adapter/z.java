package com.onetrust.otpublishers.headless.UI.adapter;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import com.onetrust.otpublishers.headless.Public.DataModel.OTConfiguration;
import com.onetrust.otpublishers.headless.Public.Keys.OTFragmentTags;
import com.onetrust.otpublishers.headless.UI.fragment.p1;
import java.util.ArrayList;
import java.util.Objects;
import org.json.JSONException;

/* JADX INFO: loaded from: classes4.dex */
public final class z extends RecyclerView.Adapter<a> implements com.onetrust.otpublishers.headless.UI.a {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final com.onetrust.otpublishers.headless.UI.a f23180i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f23181j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Context f23182k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f23183l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f23184m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final com.onetrust.otpublishers.headless.Internal.Helper.w f23185n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final ArrayList<com.onetrust.otpublishers.headless.UI.DataModels.b> f23186o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final com.onetrust.otpublishers.headless.UI.UIProperty.a0 f23187p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final boolean f23188q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final OTConfiguration f23189r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final com.onetrust.otpublishers.headless.UI.UIProperty.x f23190s;

    public static class a extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final TextView f23191b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final TextView f23192c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final LinearLayout f23193d;

        public a(View view) {
            super(view);
            this.f23192c = (TextView) view.findViewById(p6.d.f32812t2);
            this.f23191b = (TextView) view.findViewById(p6.d.f32803s2);
            this.f23193d = (LinearLayout) view.findViewById(p6.d.J2);
        }
    }

    public z(@NonNull Context context, @NonNull ArrayList<com.onetrust.otpublishers.headless.UI.DataModels.b> arrayList, @NonNull String str, @NonNull String str2, com.onetrust.otpublishers.headless.UI.UIProperty.x xVar, @NonNull String str3, @NonNull com.onetrust.otpublishers.headless.UI.a aVar, @NonNull com.onetrust.otpublishers.headless.Internal.Helper.w wVar, boolean z10, @NonNull OTConfiguration oTConfiguration) {
        this.f23182k = context;
        this.f23186o = arrayList;
        this.f23184m = str;
        this.f23183l = str2;
        this.f23181j = str3;
        this.f23190s = xVar;
        this.f23180i = aVar;
        this.f23185n = wVar;
        this.f23188q = z10;
        try {
            this.f23187p = new com.onetrust.otpublishers.headless.UI.UIProperty.b0(context).c(wVar, com.onetrust.otpublishers.headless.UI.Helper.l.a(context, oTConfiguration));
        } catch (JSONException e10) {
            OTLogger.h("error in parsing ucp data " + e10.getMessage());
        }
        this.f23189r = oTConfiguration;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(p1 p1Var, a aVar, View view) {
        if (p1Var.isAdded()) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("CUSTOM_PREF_ARRAY", this.f23186o);
        bundle.putString("ITEM_LABEL", this.f23184m);
        bundle.putString("ITEM_DESC", this.f23183l);
        bundle.putInt("ITEM_POSITION", aVar.getAdapterPosition());
        bundle.putString("DESC_TEXT_COLOR", this.f23181j);
        bundle.putString("TITLE_TEXT_COLOR", null);
        bundle.putBoolean("PURPOSE_TOGGLE_STATE", this.f23188q);
        p1Var.setArguments(bundle);
        p1Var.f23492s = this.f23185n;
        p1Var.f23485l = this.f23180i;
        FragmentActivity fragmentActivity = (FragmentActivity) this.f23182k;
        Objects.requireNonNull(fragmentActivity);
        p1Var.show(fragmentActivity.getSupportFragmentManager(), OTFragmentTags.OT_CONSENT_PREF_OPTION_FRAGMENT_TAG);
    }

    public final void b(final a aVar) {
        com.onetrust.otpublishers.headless.UI.DataModels.b bVar = this.f23186o.get(aVar.getAdapterPosition());
        String str = this.f23190s.f22868t.f22722c;
        String str2 = this.f23181j;
        if (com.onetrust.otpublishers.headless.Internal.c.q(str)) {
            str = str2;
        }
        TextView textView = aVar.f23192c;
        String str3 = bVar.f22060b;
        if (str3 != null) {
            textView.setText(str3);
        }
        if (str != null) {
            textView.setTextColor(Color.parseColor(str));
        }
        TextView textView2 = aVar.f23192c;
        com.onetrust.otpublishers.headless.UI.UIProperty.c cVar = this.f23190s.f22860l;
        if (!com.onetrust.otpublishers.headless.Internal.c.q(cVar.f22720a.f22783b)) {
            textView2.setTextSize(Float.parseFloat(cVar.f22720a.f22783b));
        }
        TextView textView3 = aVar.f23191b;
        String str4 = this.f23187p.f22706b;
        if (str4 != null) {
            textView3.setText(str4);
        }
        if (str != null) {
            textView3.setTextColor(Color.parseColor(str));
        }
        TextView textView4 = aVar.f23191b;
        com.onetrust.otpublishers.headless.UI.UIProperty.c cVar2 = this.f23190s.f22860l;
        if (!com.onetrust.otpublishers.headless.Internal.c.q(cVar2.f22720a.f22783b)) {
            textView4.setTextSize(Float.parseFloat(cVar2.f22720a.f22783b));
        }
        String str5 = this.f23190s.f22855g;
        String str6 = this.f23181j;
        if (com.onetrust.otpublishers.headless.Internal.c.q(str5)) {
            str5 = str6;
        }
        if (str5 != null) {
            com.onetrust.otpublishers.headless.UI.Helper.i.f(aVar.f23191b, str5);
        }
        OTConfiguration oTConfiguration = this.f23189r;
        final p1 p1Var = new p1();
        Bundle bundle = new Bundle();
        bundle.putString(OTFragmentTags.FRAGMENT_TAG, OTFragmentTags.OT_CONSENT_PREF_OPTION_FRAGMENT_TAG);
        p1Var.setArguments(bundle);
        p1Var.f23497x = oTConfiguration;
        aVar.f23193d.setOnClickListener(new View.OnClickListener() { // from class: com.onetrust.otpublishers.headless.UI.adapter.y
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f23177a.c(p1Var, aVar, view);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f23186o.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i10) {
        b((a) viewHolder);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i10) {
        return new a(LayoutInflater.from(viewGroup.getContext()).inflate(p6.e.P, viewGroup, false));
    }

    @Override // com.onetrust.otpublishers.headless.UI.a
    public final void a(int i10) {
        com.onetrust.otpublishers.headless.UI.a aVar = this.f23180i;
        if (aVar != null) {
            aVar.a(i10);
        }
    }
}
