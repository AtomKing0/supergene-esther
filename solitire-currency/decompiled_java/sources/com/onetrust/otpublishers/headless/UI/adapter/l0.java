package com.onetrust.otpublishers.headless.UI.adapter;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import com.onetrust.otpublishers.headless.Public.DataModel.OTConfiguration;
import com.onetrust.otpublishers.headless.Public.OTPublishersHeadlessSDK;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class l0 extends RecyclerView.Adapter<a> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final JSONObject f23039i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final OTPublishersHeadlessSDK f23040j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final com.onetrust.otpublishers.headless.UI.UIProperty.c0 f23041k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final JSONObject f23042l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final OTConfiguration f23043m;

    public static class a extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final TextView f23044b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final TextView f23045c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final TextView f23046d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final TextView f23047e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final TextView f23048f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final TextView f23049g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final TextView f23050h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final TextView f23051i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final TextView f23052j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final RecyclerView f23053k;

        public a(View view) {
            super(view);
            this.f23045c = (TextView) view.findViewById(p6.d.f32730k1);
            this.f23048f = (TextView) view.findViewById(p6.d.f32811t1);
            this.f23046d = (TextView) view.findViewById(p6.d.f32757n1);
            this.f23047e = (TextView) view.findViewById(p6.d.f32703h1);
            this.f23044b = (TextView) view.findViewById(p6.d.f32784q1);
            this.f23049g = (TextView) view.findViewById(p6.d.f32748m1);
            this.f23050h = (TextView) view.findViewById(p6.d.f32829v1);
            this.f23051i = (TextView) view.findViewById(p6.d.f32775p1);
            this.f23052j = (TextView) view.findViewById(p6.d.f32721j1);
            this.f23053k = (RecyclerView) view.findViewById(p6.d.f32793r1);
        }
    }

    public l0(@NonNull JSONObject jSONObject, OTPublishersHeadlessSDK oTPublishersHeadlessSDK, @NonNull com.onetrust.otpublishers.headless.UI.UIProperty.c0 c0Var, JSONObject jSONObject2, OTConfiguration oTConfiguration) {
        this.f23039i = jSONObject;
        this.f23040j = oTPublishersHeadlessSDK;
        this.f23041k = c0Var;
        this.f23042l = jSONObject2;
        this.f23043m = oTConfiguration;
    }

    public static void a(@NonNull a aVar, com.onetrust.otpublishers.headless.UI.UIProperty.c0 c0Var) {
        String str = c0Var.f22732g.f22721b;
        com.onetrust.otpublishers.headless.UI.Helper.l.q(aVar.f23045c, str);
        com.onetrust.otpublishers.headless.UI.Helper.l.q(aVar.f23049g, str);
        com.onetrust.otpublishers.headless.UI.Helper.l.q(aVar.f23048f, str);
        com.onetrust.otpublishers.headless.UI.Helper.l.q(aVar.f23050h, str);
        com.onetrust.otpublishers.headless.UI.Helper.l.q(aVar.f23047e, str);
        com.onetrust.otpublishers.headless.UI.Helper.l.q(aVar.f23052j, str);
        com.onetrust.otpublishers.headless.UI.Helper.l.q(aVar.f23046d, str);
        com.onetrust.otpublishers.headless.UI.Helper.l.q(aVar.f23051i, str);
        com.onetrust.otpublishers.headless.UI.Helper.l.q(aVar.f23044b, str);
    }

    public final void b(@NonNull a aVar, JSONObject jSONObject, JSONArray jSONArray) {
        if (com.onetrust.otpublishers.headless.Internal.a.c(jSONArray) || com.onetrust.otpublishers.headless.Internal.a.d(this.f23042l)) {
            aVar.f23044b.setVisibility(8);
            return;
        }
        JSONArray jSONArray2 = new JSONArray();
        JSONObject jSONObject2 = this.f23042l;
        for (int i10 = 0; i10 < jSONArray.length(); i10++) {
            if (jSONArray.getInt(i10) <= 10) {
                jSONArray2.put(jSONObject2.getJSONObject(jSONArray.get(i10).toString()));
            }
        }
        com.onetrust.otpublishers.headless.UI.UIProperty.c cVar = this.f23041k.f22732g;
        j0 j0Var = new j0(jSONArray2, !com.onetrust.otpublishers.headless.Internal.c.q(cVar.f22722c) ? cVar.f22722c : jSONObject.optString("PcTextColor"), this.f23041k, this.f23043m, null, null);
        RecyclerView recyclerView = aVar.f23053k;
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        aVar.f23053k.setAdapter(j0Var);
    }

    public final void c(@NonNull JSONObject jSONObject, @NonNull a aVar) {
        String strOptString;
        try {
            com.onetrust.otpublishers.headless.UI.UIProperty.c0 c0Var = this.f23041k;
            if (c0Var != null) {
                com.onetrust.otpublishers.headless.UI.UIProperty.c cVar = c0Var.f22732g;
                strOptString = !com.onetrust.otpublishers.headless.Internal.c.q(cVar.f22722c) ? cVar.f22722c : jSONObject.optString("PcTextColor");
                if (!com.onetrust.otpublishers.headless.Internal.c.q(this.f23041k.f22732g.f22720a.f22783b)) {
                    float f10 = Float.parseFloat(this.f23041k.f22732g.f22720a.f22783b);
                    aVar.f23045c.setTextSize(f10);
                    aVar.f23049g.setTextSize(f10);
                    aVar.f23048f.setTextSize(f10);
                    aVar.f23050h.setTextSize(f10);
                    aVar.f23047e.setTextSize(f10);
                    aVar.f23052j.setTextSize(f10);
                    aVar.f23046d.setTextSize(f10);
                    aVar.f23051i.setTextSize(f10);
                    aVar.f23044b.setTextSize(f10);
                }
                a(aVar, this.f23041k);
                com.onetrust.otpublishers.headless.UI.UIProperty.l lVar = this.f23041k.f22732g.f22720a;
                com.onetrust.otpublishers.headless.UI.Helper.l.p(aVar.f23045c, lVar, this.f23043m);
                com.onetrust.otpublishers.headless.UI.Helper.l.p(aVar.f23049g, lVar, this.f23043m);
                com.onetrust.otpublishers.headless.UI.Helper.l.p(aVar.f23048f, lVar, this.f23043m);
                com.onetrust.otpublishers.headless.UI.Helper.l.p(aVar.f23050h, lVar, this.f23043m);
                com.onetrust.otpublishers.headless.UI.Helper.l.p(aVar.f23047e, lVar, this.f23043m);
                com.onetrust.otpublishers.headless.UI.Helper.l.p(aVar.f23052j, lVar, this.f23043m);
                com.onetrust.otpublishers.headless.UI.Helper.l.p(aVar.f23046d, lVar, this.f23043m);
                com.onetrust.otpublishers.headless.UI.Helper.l.p(aVar.f23051i, lVar, this.f23043m);
                com.onetrust.otpublishers.headless.UI.Helper.l.p(aVar.f23044b, lVar, this.f23043m);
            } else {
                strOptString = jSONObject.optString("PcTextColor");
            }
            aVar.f23045c.setTextColor(Color.parseColor(strOptString));
            aVar.f23049g.setTextColor(Color.parseColor(strOptString));
            aVar.f23048f.setTextColor(Color.parseColor(strOptString));
            aVar.f23050h.setTextColor(Color.parseColor(strOptString));
            aVar.f23047e.setTextColor(Color.parseColor(strOptString));
            aVar.f23052j.setTextColor(Color.parseColor(strOptString));
            aVar.f23046d.setTextColor(Color.parseColor(strOptString));
            aVar.f23051i.setTextColor(Color.parseColor(strOptString));
            aVar.f23044b.setTextColor(Color.parseColor(strOptString));
        } catch (Exception e10) {
            com.onetrust.otpublishers.headless.Internal.Helper.j.a(e10, new StringBuilder("Error while applying styles to Vendor disclosures, err : "), "OneTrust", 6);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        try {
            return this.f23039i.getJSONArray("disclosures").length();
        } catch (JSONException unused) {
            OTLogger.a("OneTrust", 6, "Error on populating disclosures");
            return 0;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0081 A[Catch: Exception -> 0x00fd, TryCatch #0 {Exception -> 0x00fd, blocks: (B:3:0x000a, B:5:0x001a, B:7:0x0038, B:11:0x0056, B:13:0x0068, B:15:0x0081, B:17:0x0099, B:19:0x00ae, B:21:0x00c6, B:20:0x00bc, B:16:0x008f, B:8:0x0042, B:10:0x0050, B:12:0x005e), top: B:26:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x008f A[Catch: Exception -> 0x00fd, TryCatch #0 {Exception -> 0x00fd, blocks: (B:3:0x000a, B:5:0x001a, B:7:0x0038, B:11:0x0056, B:13:0x0068, B:15:0x0081, B:17:0x0099, B:19:0x00ae, B:21:0x00c6, B:20:0x00bc, B:16:0x008f, B:8:0x0042, B:10:0x0050, B:12:0x005e), top: B:26:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00ae A[Catch: Exception -> 0x00fd, TryCatch #0 {Exception -> 0x00fd, blocks: (B:3:0x000a, B:5:0x001a, B:7:0x0038, B:11:0x0056, B:13:0x0068, B:15:0x0081, B:17:0x0099, B:19:0x00ae, B:21:0x00c6, B:20:0x00bc, B:16:0x008f, B:8:0x0042, B:10:0x0050, B:12:0x005e), top: B:26:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00bc A[Catch: Exception -> 0x00fd, TryCatch #0 {Exception -> 0x00fd, blocks: (B:3:0x000a, B:5:0x001a, B:7:0x0038, B:11:0x0056, B:13:0x0068, B:15:0x0081, B:17:0x0099, B:19:0x00ae, B:21:0x00c6, B:20:0x00bc, B:16:0x008f, B:8:0x0042, B:10:0x0050, B:12:0x005e), top: B:26:0x000a }] */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onBindViewHolder(@androidx.annotation.NonNull androidx.recyclerview.widget.RecyclerView.ViewHolder r10, int r11) {
        /*
            Method dump skipped, instruction units count: 268
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onetrust.otpublishers.headless.UI.adapter.l0.onBindViewHolder(androidx.recyclerview.widget.RecyclerView$ViewHolder, int):void");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public final RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i10) {
        return new a(LayoutInflater.from(viewGroup.getContext()).inflate(p6.e.U, viewGroup, false));
    }
}
