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
public final class f0 extends RecyclerView.Adapter<a> implements com.onetrust.otpublishers.headless.UI.a {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f22957i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Context f22958j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f22959k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f22960l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final ArrayList<com.onetrust.otpublishers.headless.UI.DataModels.e> f22961m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final com.onetrust.otpublishers.headless.UI.a f22962n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final com.onetrust.otpublishers.headless.Internal.Helper.w f22963o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final com.onetrust.otpublishers.headless.UI.UIProperty.a0 f22964p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final boolean f22965q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final OTConfiguration f22966r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final com.onetrust.otpublishers.headless.UI.UIProperty.x f22967s;

    public static class a extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final TextView f22968b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final TextView f22969c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final LinearLayout f22970d;

        public a(View view) {
            super(view);
            this.f22969c = (TextView) view.findViewById(p6.d.f32812t2);
            this.f22968b = (TextView) view.findViewById(p6.d.f32803s2);
            this.f22970d = (LinearLayout) view.findViewById(p6.d.J2);
        }
    }

    public f0(@NonNull Context context, @NonNull ArrayList<com.onetrust.otpublishers.headless.UI.DataModels.e> arrayList, @NonNull String str, @NonNull String str2, com.onetrust.otpublishers.headless.UI.UIProperty.x xVar, @NonNull String str3, @NonNull com.onetrust.otpublishers.headless.UI.a aVar, @NonNull com.onetrust.otpublishers.headless.Internal.Helper.w wVar, boolean z10, OTConfiguration oTConfiguration) {
        this.f22958j = context;
        this.f22961m = arrayList;
        this.f22960l = str;
        this.f22959k = str2;
        this.f22957i = str3;
        this.f22967s = xVar;
        this.f22962n = aVar;
        this.f22963o = wVar;
        this.f22965q = z10;
        try {
            this.f22964p = new com.onetrust.otpublishers.headless.UI.UIProperty.b0(context).c(wVar, com.onetrust.otpublishers.headless.UI.Helper.l.a(context, oTConfiguration));
        } catch (JSONException e10) {
            OTLogger.h("error in parsing ucp data " + e10.getMessage());
        }
        this.f22966r = oTConfiguration;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(p1 p1Var, a aVar, View view) {
        if (p1Var.isAdded()) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("TOPIC_PREF_ARRAY", this.f22961m);
        bundle.putString("ITEM_LABEL", this.f22960l);
        bundle.putString("ITEM_DESC", this.f22959k);
        bundle.putInt("ITEM_POSITION", aVar.getAdapterPosition());
        bundle.putString("DESC_TEXT_COLOR", this.f22957i);
        bundle.putString("TITLE_TEXT_COLOR", this.f22957i);
        bundle.putBoolean("PURPOSE_TOGGLE_STATE", this.f22965q);
        p1Var.setArguments(bundle);
        p1Var.f23492s = this.f22963o;
        p1Var.f23485l = this.f22962n;
        FragmentActivity fragmentActivity = (FragmentActivity) this.f22958j;
        Objects.requireNonNull(fragmentActivity);
        p1Var.show(fragmentActivity.getSupportFragmentManager(), OTFragmentTags.OT_CONSENT_PREF_FRAGMENT_TAG);
    }

    public final void b(final a aVar) {
        com.onetrust.otpublishers.headless.UI.DataModels.e eVar = this.f22961m.get(aVar.getAdapterPosition());
        String str = this.f22967s.f22868t.f22722c;
        String str2 = this.f22957i;
        if (com.onetrust.otpublishers.headless.Internal.c.q(str)) {
            str = str2;
        }
        TextView textView = aVar.f22969c;
        String str3 = eVar.f22088a;
        if (str3 != null) {
            textView.setText(str3);
        }
        if (str != null) {
            textView.setTextColor(Color.parseColor(str));
        }
        TextView textView2 = aVar.f22969c;
        com.onetrust.otpublishers.headless.UI.UIProperty.c cVar = this.f22967s.f22860l;
        if (!com.onetrust.otpublishers.headless.Internal.c.q(cVar.f22720a.f22783b)) {
            textView2.setTextSize(Float.parseFloat(cVar.f22720a.f22783b));
        }
        TextView textView3 = aVar.f22968b;
        String str4 = this.f22964p.f22706b;
        if (str4 != null) {
            textView3.setText(str4);
        }
        if (str != null) {
            textView3.setTextColor(Color.parseColor(str));
        }
        TextView textView4 = aVar.f22968b;
        com.onetrust.otpublishers.headless.UI.UIProperty.c cVar2 = this.f22967s.f22860l;
        if (!com.onetrust.otpublishers.headless.Internal.c.q(cVar2.f22720a.f22783b)) {
            textView4.setTextSize(Float.parseFloat(cVar2.f22720a.f22783b));
        }
        String str5 = this.f22967s.f22855g;
        String str6 = this.f22957i;
        if (com.onetrust.otpublishers.headless.Internal.c.q(str5)) {
            str5 = str6;
        }
        if (str5 != null) {
            com.onetrust.otpublishers.headless.UI.Helper.i.f(aVar.f22968b, str5);
        }
        OTConfiguration oTConfiguration = this.f22966r;
        final p1 p1Var = new p1();
        Bundle bundle = new Bundle();
        bundle.putString(OTFragmentTags.FRAGMENT_TAG, OTFragmentTags.OT_CONSENT_PREF_FRAGMENT_TAG);
        p1Var.setArguments(bundle);
        p1Var.f23497x = oTConfiguration;
        aVar.f22970d.setOnClickListener(new View.OnClickListener() { // from class: com.onetrust.otpublishers.headless.UI.adapter.e0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f22951a.c(p1Var, aVar, view);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f22961m.size();
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
        com.onetrust.otpublishers.headless.UI.a aVar = this.f22962n;
        if (aVar != null) {
            aVar.a(i10);
        }
    }
}
