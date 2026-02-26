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
import androidx.recyclerview.widget.RecyclerView;
import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import com.onetrust.otpublishers.headless.Public.OTPublishersHeadlessSDK;
import com.onetrust.otpublishers.headless.Public.uiutils.OTVendorUtils;
import com.onetrust.otpublishers.headless.UI.TVUI.fragments.f0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class c extends RecyclerView.Adapter<C0485c> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final b f22199i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final OTPublishersHeadlessSDK f22200j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final OTVendorUtils f22201k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final com.onetrust.otpublishers.headless.UI.TVUI.datautils.c f22202l = com.onetrust.otpublishers.headless.UI.TVUI.datautils.c.j();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f22203m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public JSONObject f22204n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public ArrayList f22205o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public ArrayList<String> f22206p;

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
                    com.onetrust.otpublishers.headless.Internal.Helper.n.a(e, new StringBuilder("error while sorting VL json object lists,err : "), "TVGoogleVendors", 6);
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

    /* JADX INFO: renamed from: com.onetrust.otpublishers.headless.UI.TVUI.adapter.c$c, reason: collision with other inner class name */
    public static class C0485c extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final TextView f22207b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final TextView f22208c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final LinearLayout f22209d;

        public C0485c(View view) {
            super(view);
            this.f22207b = (TextView) view.findViewById(p6.d.S5);
            this.f22209d = (LinearLayout) view.findViewById(p6.d.Q5);
            this.f22208c = (TextView) view.findViewById(p6.d.O5);
        }
    }

    public c(@NonNull OTVendorUtils oTVendorUtils, @NonNull b bVar, @NonNull OTPublishersHeadlessSDK oTPublishersHeadlessSDK) {
        this.f22201k = oTVendorUtils;
        this.f22199i = bVar;
        this.f22200j = oTPublishersHeadlessSDK;
        oTVendorUtils.refreshList("google");
        oTVendorUtils.setVendorsListObject("google", c(), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(String str, C0485c c0485c, View view, boolean z10) {
        if (!z10) {
            c0485c.f22207b.setTextColor(Color.parseColor(this.f22202l.f22370j.B.f22795b));
            c0485c.f22209d.setBackgroundColor(Color.parseColor(this.f22202l.f22370j.B.f22794a));
            return;
        }
        f0 f0Var = (f0) this.f22199i;
        f0Var.I = false;
        f0Var.y(str);
        c0485c.f22207b.setTextColor(Color.parseColor(this.f22202l.f22370j.B.f22797d));
        c0485c.f22209d.setBackgroundColor(Color.parseColor(this.f22202l.f22370j.B.f22796c));
        if (c0485c.getAdapterPosition() == -1 || c0485c.getAdapterPosition() == this.f22203m) {
            return;
        }
        this.f22203m = c0485c.getAdapterPosition();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean g(C0485c c0485c, View view, int i10, KeyEvent keyEvent) {
        Button button;
        if (com.onetrust.otpublishers.headless.UI.Helper.i.a(i10, keyEvent) == 22) {
            this.f22203m = c0485c.getAdapterPosition();
            ((f0) this.f22199i).B();
            c0485c.f22207b.setTextColor(Color.parseColor(this.f22202l.f22370j.B.f22799f));
            c0485c.f22209d.setBackgroundColor(Color.parseColor(this.f22202l.f22370j.B.f22798e));
            return true;
        }
        if (c0485c.getAdapterPosition() != 0 || com.onetrust.otpublishers.headless.UI.Helper.i.a(i10, keyEvent) != 25) {
            return false;
        }
        f0 f0Var = (f0) this.f22199i;
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
        JSONObject vendorListUI = this.f22200j.getVendorListUI("google");
        if (vendorListUI != null) {
            jSONObject = vendorListUI;
        }
        OTLogger.a("TVGoogleVendors", 3, "Total Google vendors count: " + jSONObject.length());
        return jSONObject;
    }

    public final void d(@NonNull final C0485c c0485c) {
        int adapterPosition = c0485c.getAdapterPosition();
        final String string = "";
        if (this.f22204n.names() != null) {
            try {
                c0485c.setIsRecyclable(false);
                JSONObject jSONObject = (JSONObject) this.f22205o.get(adapterPosition);
                string = jSONObject.getString("id");
                c0485c.f22207b.setText(jSONObject.getString("name"));
            } catch (JSONException e10) {
                com.onetrust.otpublishers.headless.Internal.Helper.p.a(e10, new StringBuilder("exception thrown when rendering vendors, err : "), "OneTrust", 6);
            }
        }
        c0485c.f22207b.setTextColor(Color.parseColor(this.f22202l.f22370j.B.f22795b));
        c0485c.f22208c.setVisibility(8);
        c0485c.f22209d.setBackgroundColor(Color.parseColor(this.f22202l.f22370j.B.f22794a));
        c0485c.itemView.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.onetrust.otpublishers.headless.UI.TVUI.adapter.a
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z10) {
                this.f22167a.e(string, c0485c, view, z10);
            }
        });
        c0485c.itemView.setOnKeyListener(new View.OnKeyListener() { // from class: com.onetrust.otpublishers.headless.UI.TVUI.adapter.b
            @Override // android.view.View.OnKeyListener
            public final boolean onKey(View view, int i10, KeyEvent keyEvent) {
                return this.f22194a.g(c0485c, view, i10, keyEvent);
            }
        });
    }

    public final void f(@NonNull List<JSONObject> list, @NonNull JSONObject jSONObject) {
        String lowerCase = jSONObject.getString("name").toLowerCase(Locale.ENGLISH);
        if (this.f22206p.contains("A_F") && lowerCase.matches("(a|b|c|d|e|f]).*")) {
            list.add(jSONObject);
        }
        if (this.f22206p.contains("G_L") && lowerCase.matches("(g|h|i|j|k|l]).*")) {
            list.add(jSONObject);
        }
        if (this.f22206p.contains("M_R") && lowerCase.matches("(m|n|o|p|q|r]).*")) {
            list.add(jSONObject);
        }
        if (this.f22206p.contains("S_Z") && lowerCase.matches("(s|t|u|v|w|x|y|z]).*")) {
            list.add(jSONObject);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f22205o.size();
    }

    public final void h() {
        this.f22201k.setVendorsListObject("google", c(), false);
        this.f22204n = new JSONObject();
        this.f22204n = this.f22201k.getVendorsListObject("google");
        this.f22205o = new ArrayList();
        if (this.f22206p == null) {
            this.f22206p = new ArrayList<>();
        }
        if (com.onetrust.otpublishers.headless.Internal.a.d(this.f22204n)) {
            OTLogger.a("TVGoogleVendors", 6, "setVendorListObject: Empty data found for Vendors");
            return;
        }
        JSONArray jSONArrayNames = this.f22204n.names();
        if (jSONArrayNames == null) {
            OTLogger.a("TVGoogleVendors", 6, "setVendorListObject: Vendor data is empty");
            return;
        }
        for (int i10 = 0; i10 < this.f22204n.length(); i10++) {
            try {
                JSONObject jSONObject = this.f22204n.getJSONObject(jSONArrayNames.get(i10).toString());
                if (this.f22206p.isEmpty()) {
                    this.f22205o.add(jSONObject);
                } else {
                    f(this.f22205o, jSONObject);
                }
            } catch (JSONException e10) {
                com.onetrust.otpublishers.headless.Internal.Helper.n.a(e10, new StringBuilder("error while constructing VL json object lists,err : "), "TVGoogleVendors", 6);
            }
        }
        Collections.sort(this.f22205o, new a());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* bridge */ /* synthetic */ void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i10) {
        d((C0485c) viewHolder);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i10) {
        return new C0485c(LayoutInflater.from(viewGroup.getContext()).inflate(p6.e.f32886t, viewGroup, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onViewAttachedToWindow(@NonNull RecyclerView.ViewHolder viewHolder) {
        C0485c c0485c = (C0485c) viewHolder;
        super.onViewAttachedToWindow(c0485c);
        if (c0485c.getAdapterPosition() == this.f22203m) {
            c0485c.itemView.requestFocus();
        }
    }
}
