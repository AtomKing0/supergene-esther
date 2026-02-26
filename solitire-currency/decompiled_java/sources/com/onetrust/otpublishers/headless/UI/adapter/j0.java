package com.onetrust.otpublishers.headless.UI.adapter;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.onetrust.otpublishers.headless.Public.DataModel.OTConfiguration;
import com.onetrust.otpublishers.headless.Public.OTVendorListMode;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class j0 extends RecyclerView.Adapter<a> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final OTConfiguration f23024i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f23025j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final JSONArray f23026k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final JSONObject f23027l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f23028m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final com.onetrust.otpublishers.headless.UI.UIProperty.c0 f23029n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final String f23030o = OTVendorListMode.IAB;

    public static class a extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final TextView f23031b;

        public a(View view) {
            super(view);
            this.f23031b = (TextView) view.findViewById(p6.d.P6);
        }
    }

    public j0(@NonNull JSONArray jSONArray, @NonNull String str, @Nullable com.onetrust.otpublishers.headless.UI.UIProperty.c0 c0Var, @Nullable OTConfiguration oTConfiguration, @Nullable JSONObject jSONObject, @Nullable String str2) {
        this.f23026k = jSONArray;
        this.f23027l = jSONObject;
        this.f23028m = str;
        this.f23029n = c0Var;
        this.f23024i = oTConfiguration;
        this.f23025j = str2;
    }

    @NonNull
    public final String a(@NonNull a aVar, @NonNull String str) throws JSONException {
        String string = this.f23026k.getJSONObject(aVar.getAdapterPosition()).getString(str);
        if (this.f23027l == null) {
            return string;
        }
        String strOptString = this.f23027l.optString(this.f23026k.getJSONObject(aVar.getAdapterPosition()).getString("id"));
        if (com.onetrust.otpublishers.headless.Internal.c.q(strOptString) || Integer.parseInt(strOptString) < 0) {
            return string;
        }
        return string + " (" + strOptString + " " + this.f23025j + ")";
    }

    public final void b(@NonNull a aVar) {
        Typeface otTypeFaceMap;
        if (!com.onetrust.otpublishers.headless.Internal.c.q(this.f23029n.f22732g.f22720a.f22783b)) {
            aVar.f23031b.setTextSize(Float.parseFloat(this.f23029n.f22732g.f22720a.f22783b));
        }
        if (!com.onetrust.otpublishers.headless.Internal.c.q(this.f23029n.f22732g.f22721b)) {
            aVar.f23031b.setTextAlignment(Integer.parseInt(this.f23029n.f22732g.f22721b));
        }
        com.onetrust.otpublishers.headless.UI.UIProperty.l lVar = this.f23029n.f22732g.f22720a;
        TextView textView = aVar.f23031b;
        OTConfiguration oTConfiguration = this.f23024i;
        String str = lVar.f22785d;
        if (!com.onetrust.otpublishers.headless.Internal.c.q(str) && oTConfiguration != null && (otTypeFaceMap = oTConfiguration.getOtTypeFaceMap(str)) != null) {
            textView.setTypeface(otTypeFaceMap);
        } else {
            int iA = com.onetrust.otpublishers.headless.UI.UIProperty.l.a(textView, lVar.f22784c);
            textView.setTypeface(!com.onetrust.otpublishers.headless.Internal.c.q(lVar.f22782a) ? Typeface.create(lVar.f22782a, iA) : Typeface.create(textView.getTypeface(), iA));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f23026k.length();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i10) {
        a aVar = (a) viewHolder;
        aVar.setIsRecyclable(false);
        try {
            aVar.f23031b.setText(a(aVar, OTVendorListMode.GENERAL.equalsIgnoreCase(this.f23030o) ? "Name" : "name"));
            aVar.f23031b.setTextColor(Color.parseColor(this.f23028m));
            TextView textView = aVar.f23031b;
            String str = this.f23028m;
            for (Drawable drawable : textView.getCompoundDrawablesRelative()) {
                if (drawable != null) {
                    drawable.setColorFilter(new PorterDuffColorFilter(Color.parseColor(str), PorterDuff.Mode.SRC_IN));
                }
            }
            if (this.f23029n != null) {
                b(aVar);
            }
        } catch (Exception e10) {
            com.onetrust.otpublishers.headless.Internal.Helper.j.a(e10, new StringBuilder("error while rendering purpose items in Vendor detail screen "), "OneTrust", 6);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public final RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i10) {
        return new a(LayoutInflater.from(viewGroup.getContext()).inflate(p6.e.S, viewGroup, false));
    }
}
