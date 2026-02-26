package com.onetrust.otpublishers.headless.UI.TVUI.adapter;

import android.graphics.Color;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import com.onetrust.otpublishers.headless.Public.OTPublishersHeadlessSDK;
import com.onetrust.otpublishers.headless.Public.OTVendorListMode;
import com.onetrust.otpublishers.headless.Public.uiutils.OTVendorUtils;
import com.onetrust.otpublishers.headless.UI.TVUI.fragments.f0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class d0 extends RecyclerView.Adapter<c> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final b f22218i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final OTPublishersHeadlessSDK f22219j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final OTVendorUtils f22220k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final com.onetrust.otpublishers.headless.UI.TVUI.datautils.c f22221l = com.onetrust.otpublishers.headless.UI.TVUI.datautils.c.j();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f22222m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Map<String, String> f22223n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f22224o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public JSONObject f22225p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public ArrayList f22226q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public ArrayList<String> f22227r;

    public class a implements Comparator<JSONObject> {
        @Override // java.util.Comparator
        public final int compare(JSONObject jSONObject, JSONObject jSONObject2) {
            String lowerCase;
            JSONObject jSONObject3 = jSONObject2;
            String lowerCase2 = "";
            try {
                String string = jSONObject.getString("name");
                Locale locale = Locale.ENGLISH;
                lowerCase = string.toLowerCase(locale);
                try {
                    lowerCase2 = jSONObject3.getString("name").toLowerCase(locale);
                } catch (JSONException e10) {
                    e = e10;
                    com.onetrust.otpublishers.headless.Internal.Helper.n.a(e, new StringBuilder("error while sorting VL json object lists,err : "), "TVVendorlist", 6);
                }
            } catch (JSONException e11) {
                e = e11;
                lowerCase = "";
            }
            return lowerCase.compareTo(lowerCase2);
        }
    }

    public interface b {
    }

    public static class c extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final TextView f22228b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final TextView f22229c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final LinearLayout f22230d;

        public c(View view) {
            super(view);
            this.f22228b = (TextView) view.findViewById(p6.d.S5);
            this.f22230d = (LinearLayout) view.findViewById(p6.d.Q5);
            this.f22229c = (TextView) view.findViewById(p6.d.O5);
        }
    }

    public d0(@NonNull OTVendorUtils oTVendorUtils, @NonNull b bVar, @NonNull OTPublishersHeadlessSDK oTPublishersHeadlessSDK, boolean z10, @Nullable Map<String, String> map) {
        this.f22223n = new HashMap();
        this.f22220k = oTVendorUtils;
        this.f22218i = bVar;
        this.f22219j = oTPublishersHeadlessSDK;
        this.f22222m = z10;
        this.f22223n = map;
        oTVendorUtils.refreshList(OTVendorListMode.IAB);
        oTVendorUtils.setVendorsListObject(OTVendorListMode.IAB, c(), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(String str, c cVar, View view, boolean z10) {
        if (!z10) {
            cVar.f22228b.setTextColor(Color.parseColor(this.f22221l.f22370j.B.f22795b));
            cVar.f22230d.setBackgroundColor(Color.parseColor(this.f22221l.f22370j.B.f22794a));
            return;
        }
        f0 f0Var = (f0) this.f22218i;
        f0Var.I = false;
        f0Var.y(str);
        cVar.f22228b.setTextColor(Color.parseColor(this.f22221l.f22370j.B.f22797d));
        cVar.f22230d.setBackgroundColor(Color.parseColor(this.f22221l.f22370j.B.f22796c));
        if (cVar.getAdapterPosition() == -1 || cVar.getAdapterPosition() == this.f22224o) {
            return;
        }
        this.f22224o = cVar.getAdapterPosition();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean g(c cVar, View view, int i10, KeyEvent keyEvent) {
        Button button;
        if (com.onetrust.otpublishers.headless.UI.Helper.i.a(i10, keyEvent) == 22) {
            this.f22224o = cVar.getAdapterPosition();
            ((f0) this.f22218i).B();
            cVar.f22228b.setTextColor(Color.parseColor(this.f22221l.f22370j.B.f22799f));
            cVar.f22230d.setBackgroundColor(Color.parseColor(this.f22221l.f22370j.B.f22798e));
            return true;
        }
        if (cVar.getAdapterPosition() != 0 || com.onetrust.otpublishers.headless.UI.Helper.i.a(i10, keyEvent) != 25) {
            return false;
        }
        f0 f0Var = (f0) this.f22218i;
        if (f0Var.G.equals("A_F")) {
            button = f0Var.f22533y;
        } else if (f0Var.G.equals("G_L")) {
            button = f0Var.f22534z;
        } else {
            if (!f0Var.G.equals("M_R")) {
                if (f0Var.G.equals("S_Z")) {
                    button = f0Var.B;
                }
                return true;
            }
            button = f0Var.A;
        }
        button.requestFocus();
        return true;
    }

    @NonNull
    public final JSONObject c() {
        JSONObject jSONObject = new JSONObject();
        if (this.f22222m) {
            JSONObject vendorsByPurpose = this.f22220k.getVendorsByPurpose(this.f22223n, this.f22219j.getVendorListUI(OTVendorListMode.IAB));
            OTLogger.a("TVVendorlist", 3, "Total vendors count with filtered purpose : " + vendorsByPurpose.length());
            return vendorsByPurpose;
        }
        JSONObject vendorListUI = this.f22219j.getVendorListUI(OTVendorListMode.IAB);
        if (vendorListUI != null) {
            jSONObject = vendorListUI;
        }
        OTLogger.a("TVVendorlist", 3, "Total IAB vendors count without filter : " + jSONObject.length());
        return jSONObject;
    }

    public final void d(@NonNull final c cVar) {
        int adapterPosition = cVar.getAdapterPosition();
        OTLogger.a("TVVendorlist", 2, "filtered vendors count " + this.f22226q.size());
        final String string = "";
        if (this.f22225p.names() != null) {
            try {
                cVar.setIsRecyclable(false);
                JSONObject jSONObject = (JSONObject) this.f22226q.get(adapterPosition);
                string = jSONObject.getString("id");
                cVar.f22228b.setText(jSONObject.getString("name"));
            } catch (JSONException e10) {
                com.onetrust.otpublishers.headless.Internal.Helper.p.a(e10, new StringBuilder("exception thrown when rendering vendors, err : "), "OneTrust", 6);
            }
        }
        cVar.f22228b.setTextColor(Color.parseColor(this.f22221l.f22370j.B.f22795b));
        cVar.f22229c.setVisibility(8);
        cVar.f22230d.setBackgroundColor(Color.parseColor(this.f22221l.f22370j.B.f22794a));
        cVar.itemView.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.onetrust.otpublishers.headless.UI.TVUI.adapter.b0
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z10) {
                this.f22196a.e(string, cVar, view, z10);
            }
        });
        cVar.itemView.setOnKeyListener(new View.OnKeyListener() { // from class: com.onetrust.otpublishers.headless.UI.TVUI.adapter.c0
            @Override // android.view.View.OnKeyListener
            public final boolean onKey(View view, int i10, KeyEvent keyEvent) {
                return this.f22210a.g(cVar, view, i10, keyEvent);
            }
        });
    }

    public final void f(@NonNull List<JSONObject> list, @NonNull JSONObject jSONObject) {
        String lowerCase = jSONObject.getString("name").toLowerCase(Locale.ENGLISH);
        if (this.f22227r.contains("A_F") && lowerCase.matches("(a|b|c|d|e|f).*")) {
            list.add(jSONObject);
        }
        if (this.f22227r.contains("G_L") && lowerCase.matches("(g|h|i|j|k|l).*")) {
            list.add(jSONObject);
        }
        if (this.f22227r.contains("M_R") && lowerCase.matches("(m|n|o|p|q|r).*")) {
            list.add(jSONObject);
        }
        if (this.f22227r.contains("S_Z") && lowerCase.matches("(s|t|u|v|w|x|y|z).*")) {
            list.add(jSONObject);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f22226q.size();
    }

    public final void h() {
        this.f22220k.setVendorsListObject(OTVendorListMode.IAB, c(), false);
        this.f22225p = new JSONObject();
        this.f22225p = this.f22220k.getVendorsListObject(OTVendorListMode.IAB);
        this.f22226q = new ArrayList();
        if (this.f22227r == null) {
            this.f22227r = new ArrayList<>();
        }
        if (com.onetrust.otpublishers.headless.Internal.a.d(this.f22225p)) {
            OTLogger.a("TVVendorlist", 6, "setVendorListObject: Empty data found for Vendors");
            return;
        }
        JSONArray jSONArrayNames = this.f22225p.names();
        if (jSONArrayNames == null) {
            OTLogger.a("TVVendorlist", 6, "setVendorListObject: Vendor data is empty");
            return;
        }
        for (int i10 = 0; i10 < this.f22225p.length(); i10++) {
            try {
                JSONObject jSONObject = this.f22225p.getJSONObject(jSONArrayNames.get(i10).toString());
                if (this.f22227r.isEmpty()) {
                    this.f22226q.add(jSONObject);
                } else {
                    f(this.f22226q, jSONObject);
                }
            } catch (JSONException e10) {
                com.onetrust.otpublishers.headless.Internal.Helper.n.a(e10, new StringBuilder("error while constructing VL json object lists,err : "), "TVVendorlist", 6);
            }
        }
        Collections.sort(this.f22226q, new a());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* bridge */ /* synthetic */ void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i10) {
        d((c) viewHolder);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i10) {
        return new c(LayoutInflater.from(viewGroup.getContext()).inflate(p6.e.f32886t, viewGroup, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onViewAttachedToWindow(@NonNull RecyclerView.ViewHolder viewHolder) {
        c cVar = (c) viewHolder;
        super.onViewAttachedToWindow(cVar);
        if (cVar.getAdapterPosition() == this.f22224o) {
            cVar.itemView.requestFocus();
        }
    }
}
