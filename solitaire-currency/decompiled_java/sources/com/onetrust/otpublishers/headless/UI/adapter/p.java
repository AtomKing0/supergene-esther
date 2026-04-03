package com.onetrust.otpublishers.headless.UI.adapter;

import android.graphics.Color;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import com.onetrust.otpublishers.headless.Public.DataModel.OTConfiguration;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class p extends RecyclerView.Adapter<b> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final OTConfiguration f23093i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final a f23094j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final JSONArray f23095k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public HashMap f23096l = new HashMap();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final com.onetrust.otpublishers.headless.UI.UIProperty.d0 f23097m;

    public interface a {
    }

    public static class b extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final TextView f23098b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final CheckBox f23099c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final View f23100d;

        public b(View view) {
            super(view);
            this.f23098b = (TextView) view.findViewById(p6.d.f32733k4);
            this.f23099c = (CheckBox) view.findViewById(p6.d.f32751m4);
            this.f23100d = view.findViewById(p6.d.f32742l4);
        }
    }

    public p(@NonNull JSONArray jSONArray, @NonNull Map<String, String> map, @NonNull com.onetrust.otpublishers.headless.UI.UIProperty.d0 d0Var, @Nullable OTConfiguration oTConfiguration, @NonNull a aVar) {
        this.f23095k = jSONArray;
        this.f23097m = d0Var;
        this.f23093i = oTConfiguration;
        this.f23094j = aVar;
        e(map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(b bVar, String str, String str2, View view) {
        String str3;
        boolean zIsChecked = bVar.f23099c.isChecked();
        com.onetrust.otpublishers.headless.UI.UIProperty.d0 d0Var = this.f23097m;
        if (d0Var != null && !com.onetrust.otpublishers.headless.Internal.c.q(d0Var.f22745h) && !com.onetrust.otpublishers.headless.Internal.c.q(this.f23097m.f22750m.f22722c)) {
            com.onetrust.otpublishers.headless.UI.mobiledatautils.c.c(bVar.f23099c, Color.parseColor(this.f23097m.f22745h), Color.parseColor(this.f23097m.f22750m.f22722c));
        }
        if (!zIsChecked) {
            this.f23096l.remove(str);
            ((com.onetrust.otpublishers.headless.UI.fragment.o0) this.f23094j).f23465m = this.f23096l;
            str3 = "Purposes Removed : " + str;
        } else {
            if (this.f23096l.containsKey(str)) {
                return;
            }
            this.f23096l.put(str, str2);
            ((com.onetrust.otpublishers.headless.UI.fragment.o0) this.f23094j).f23465m = this.f23096l;
            str3 = "Purposes Added : " + str;
        }
        OTLogger.a("OneTrust", 4, str3);
    }

    public final void b(@NonNull TextView textView, @NonNull com.onetrust.otpublishers.headless.UI.UIProperty.c cVar) {
        Typeface otTypeFaceMap;
        com.onetrust.otpublishers.headless.UI.UIProperty.l lVar = cVar.f22720a;
        OTConfiguration oTConfiguration = this.f23093i;
        String str = lVar.f22785d;
        if (com.onetrust.otpublishers.headless.Internal.c.q(str) || oTConfiguration == null || (otTypeFaceMap = oTConfiguration.getOtTypeFaceMap(str)) == null) {
            int iA = com.onetrust.otpublishers.headless.UI.UIProperty.l.a(textView, lVar.f22784c);
            textView.setTypeface(!com.onetrust.otpublishers.headless.Internal.c.q(lVar.f22782a) ? Typeface.create(lVar.f22782a, iA) : Typeface.create(textView.getTypeface(), iA));
        } else {
            textView.setTypeface(otTypeFaceMap);
        }
        if (!com.onetrust.otpublishers.headless.Internal.c.q(lVar.f22783b)) {
            textView.setTextSize(Float.parseFloat(lVar.f22783b));
        }
        if (!com.onetrust.otpublishers.headless.Internal.c.q(cVar.f22722c)) {
            textView.setTextColor(Color.parseColor(cVar.f22722c));
        }
        com.onetrust.otpublishers.headless.UI.Helper.l.q(textView, cVar.f22721b);
    }

    public final void c(final b bVar) {
        bVar.setIsRecyclable(false);
        try {
            JSONObject jSONObject = this.f23095k.getJSONObject(bVar.getAdapterPosition());
            final String string = jSONObject.getString("Type");
            bVar.f23098b.setText(jSONObject.getString("GroupName"));
            final String string2 = jSONObject.getString("CustomGroupId");
            OTLogger.a("OneTrust", 4, "Purposes to pass on apply filters : " + this.f23096l);
            boolean zContainsKey = this.f23096l.containsKey(string2);
            OTLogger.a("OTPurposeListAdapter", 3, "purpose status : " + zContainsKey);
            bVar.f23099c.setChecked(zContainsKey);
            bVar.f23099c.setContentDescription("Filter");
            bVar.f23098b.setLabelFor(p6.d.f32751m4);
            com.onetrust.otpublishers.headless.UI.UIProperty.d0 d0Var = this.f23097m;
            if (d0Var != null) {
                b(bVar.f23098b, d0Var.f22750m);
                if (!com.onetrust.otpublishers.headless.Internal.c.q(this.f23097m.f22745h) && !com.onetrust.otpublishers.headless.Internal.c.q(this.f23097m.f22750m.f22722c)) {
                    com.onetrust.otpublishers.headless.UI.mobiledatautils.c.c(bVar.f23099c, Color.parseColor(this.f23097m.f22745h), Color.parseColor(this.f23097m.f22750m.f22722c));
                }
                String str = this.f23097m.f22739b;
                com.onetrust.otpublishers.headless.UI.mobiledatautils.c.g(str, bVar.f23100d);
                if (bVar.getAdapterPosition() == 0) {
                    OTLogger.a("OT_Automation", 3, "setLineBreakColor Vendor Filter List: " + str);
                }
            }
            bVar.f23099c.setOnClickListener(new View.OnClickListener() { // from class: com.onetrust.otpublishers.headless.UI.adapter.o
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f23087a.d(bVar, string2, string, view);
                }
            });
        } catch (JSONException e10) {
            com.onetrust.otpublishers.headless.Internal.Helper.p.a(e10, new StringBuilder("error while parsing "), "OneTrust", 6);
        }
    }

    public final void e(@NonNull Map<String, String> map) {
        this.f23096l = new HashMap(map);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f23095k.length();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i10) {
        c((b) viewHolder);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i10) {
        return new b(LayoutInflater.from(viewGroup.getContext()).inflate(p6.e.A, viewGroup, false));
    }
}
