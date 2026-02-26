package com.onetrust.otpublishers.headless.UI.adapter;

import android.graphics.Color;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.ironsource.v8;
import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import com.onetrust.otpublishers.headless.Public.DataModel.OTConfiguration;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class m0 extends RecyclerView.Adapter<a> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final JSONArray f23057i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final com.onetrust.otpublishers.headless.UI.UIProperty.c0 f23058j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final JSONObject f23059k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final OTConfiguration f23060l;

    public static class a extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final TextView f23061b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final TextView f23062c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final TextView f23063d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final TextView f23064e;

        public a(View view) {
            super(view);
            this.f23061b = (TextView) view.findViewById(p6.d.f32837w1);
            this.f23062c = (TextView) view.findViewById(p6.d.f32845x1);
            this.f23063d = (TextView) view.findViewById(p6.d.D6);
            this.f23064e = (TextView) view.findViewById(p6.d.E6);
        }
    }

    public m0(@NonNull JSONArray jSONArray, @NonNull JSONObject jSONObject, @NonNull com.onetrust.otpublishers.headless.UI.UIProperty.c0 c0Var, @Nullable OTConfiguration oTConfiguration) {
        this.f23057i = jSONArray;
        this.f23059k = jSONObject;
        this.f23058j = c0Var;
        this.f23060l = oTConfiguration;
    }

    public final void a(@NonNull TextView textView, String str) {
        Typeface otTypeFaceMap;
        com.onetrust.otpublishers.headless.UI.UIProperty.c0 c0Var = this.f23058j;
        if (c0Var == null) {
            return;
        }
        com.onetrust.otpublishers.headless.UI.UIProperty.c cVar = c0Var.f22732g;
        if (!com.onetrust.otpublishers.headless.Internal.c.q(str)) {
            textView.setText(str);
        }
        textView.setTextColor(Color.parseColor(!com.onetrust.otpublishers.headless.Internal.c.q(cVar.f22722c) ? cVar.f22722c : this.f23059k.optString("PcTextColor")));
        com.onetrust.otpublishers.headless.UI.Helper.l.q(textView, cVar.f22721b);
        if (!com.onetrust.otpublishers.headless.Internal.c.q(cVar.f22720a.f22783b)) {
            textView.setTextSize(Float.parseFloat(cVar.f22720a.f22783b));
        }
        com.onetrust.otpublishers.headless.UI.UIProperty.l lVar = cVar.f22720a;
        OTConfiguration oTConfiguration = this.f23060l;
        String str2 = lVar.f22785d;
        if (!com.onetrust.otpublishers.headless.Internal.c.q(str2) && oTConfiguration != null && (otTypeFaceMap = oTConfiguration.getOtTypeFaceMap(str2)) != null) {
            textView.setTypeface(otTypeFaceMap);
        } else {
            int iA = com.onetrust.otpublishers.headless.UI.UIProperty.l.a(textView, lVar.f22784c);
            textView.setTypeface(!com.onetrust.otpublishers.headless.Internal.c.q(lVar.f22782a) ? Typeface.create(lVar.f22782a, iA) : Typeface.create(textView.getTypeface(), iA));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        try {
            return this.f23057i.length();
        } catch (Exception unused) {
            OTLogger.a("OneTrust", 6, "Error on populating domains used");
            return 0;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i10) {
        a aVar = (a) viewHolder;
        try {
            JSONObject jSONObject = this.f23057i.getJSONObject(aVar.getAdapterPosition());
            if (this.f23059k == null || com.onetrust.otpublishers.headless.Internal.a.d(jSONObject)) {
                return;
            }
            if (!jSONObject.has(v8.i.D) || com.onetrust.otpublishers.headless.Internal.c.q(jSONObject.optString(v8.i.D))) {
                aVar.f23061b.setVisibility(8);
                aVar.f23062c.setVisibility(8);
            } else {
                a(aVar.f23061b, this.f23059k.optString("PCenterVendorListStorageDomain"));
                a(aVar.f23062c, jSONObject.optString(v8.i.D));
            }
            if (!jSONObject.has("use") || com.onetrust.otpublishers.headless.Internal.c.q(jSONObject.optString("use"))) {
                aVar.f23063d.setVisibility(8);
                aVar.f23064e.setVisibility(8);
            } else {
                a(aVar.f23063d, this.f23059k.optString("PCVLSUse"));
                a(aVar.f23064e, jSONObject.optString("use"));
            }
        } catch (JSONException e10) {
            com.onetrust.otpublishers.headless.Internal.Helper.p.a(e10, new StringBuilder("Error on populating disclosures, err : "), "OneTrust", 6);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public final RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i10) {
        return new a(LayoutInflater.from(viewGroup.getContext()).inflate(p6.e.V, viewGroup, false));
    }
}
