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
import com.onetrust.otpublishers.headless.UI.fragment.h1;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class v extends RecyclerView.Adapter<b> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final OTConfiguration f23150i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final JSONArray f23151j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ArrayList f23152k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final com.onetrust.otpublishers.headless.UI.UIProperty.z f23153l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final a f23154m;

    public interface a {
    }

    public static class b extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final TextView f23155b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final CheckBox f23156c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final View f23157d;

        public b(View view) {
            super(view);
            this.f23155b = (TextView) view.findViewById(p6.d.G0);
            this.f23156c = (CheckBox) view.findViewById(p6.d.H0);
            this.f23157d = view.findViewById(p6.d.J4);
        }
    }

    public v(@NonNull JSONArray jSONArray, @NonNull List<String> list, @Nullable OTConfiguration oTConfiguration, com.onetrust.otpublishers.headless.UI.mobiledatautils.f fVar, a aVar) {
        this.f23151j = jSONArray;
        this.f23153l = fVar.a();
        this.f23150i = oTConfiguration;
        this.f23154m = aVar;
        e(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(b bVar, String str, String str2, String str3, View view) {
        String str4;
        boolean zIsChecked = bVar.f23156c.isChecked();
        com.onetrust.otpublishers.headless.UI.mobiledatautils.c.c(bVar.f23156c, Color.parseColor(str), Color.parseColor(str2));
        if (!zIsChecked) {
            boolean zRemove = this.f23152k.remove(str3);
            a aVar = this.f23154m;
            ArrayList arrayList = this.f23152k;
            h1 h1Var = (h1) aVar;
            h1Var.getClass();
            h1Var.f23319m = Collections.unmodifiableList(arrayList);
            str4 = "onClick remove:" + str3 + ", status : " + zRemove;
        } else {
            if (this.f23152k.contains(str3)) {
                return;
            }
            this.f23152k.add(str3);
            a aVar2 = this.f23154m;
            ArrayList arrayList2 = this.f23152k;
            h1 h1Var2 = (h1) aVar2;
            h1Var2.getClass();
            h1Var2.f23319m = Collections.unmodifiableList(arrayList2);
            str4 = "onClick add:" + str3;
        }
        OTLogger.a("OTPurposeListAdapter", 4, str4);
    }

    public final void b(@NonNull TextView textView, @NonNull com.onetrust.otpublishers.headless.UI.UIProperty.c cVar) {
        Typeface otTypeFaceMap;
        com.onetrust.otpublishers.headless.UI.UIProperty.l lVar = cVar.f22720a;
        OTConfiguration oTConfiguration = this.f23150i;
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
        boolean z10 = false;
        bVar.setIsRecyclable(false);
        try {
            JSONObject jSONObject = this.f23151j.getJSONObject(bVar.getAdapterPosition());
            String string = jSONObject.getString("GroupName");
            bVar.f23155b.setText(string);
            if (this.f23153l == null) {
                return;
            }
            bVar.f23155b.setLabelFor(p6.d.H0);
            com.onetrust.otpublishers.headless.UI.UIProperty.z zVar = this.f23153l;
            final String str = zVar.f22885j;
            final String str2 = zVar.f22887l.f22722c;
            final String string2 = jSONObject.getString("CustomGroupId");
            int i10 = 0;
            while (true) {
                if (i10 >= this.f23152k.size()) {
                    break;
                }
                if (((String) this.f23152k.get(i10)).trim().equals(string2)) {
                    z10 = true;
                    break;
                }
                i10++;
            }
            OTLogger.a("OTPurposeListAdapter", 3, "CategoryName : " + string + ", purpose status : " + z10);
            bVar.f23156c.setChecked(z10);
            b(bVar.f23155b, this.f23153l.f22887l);
            com.onetrust.otpublishers.headless.UI.mobiledatautils.c.c(bVar.f23156c, Color.parseColor(str), Color.parseColor(str2));
            String str3 = this.f23153l.f22877b;
            com.onetrust.otpublishers.headless.UI.mobiledatautils.c.g(str3, bVar.f23157d);
            if (bVar.getAdapterPosition() == 0) {
                OTLogger.a("OT_Automation", 3, "setLineBreakColor SDK Filter List: " + str3);
            }
            bVar.f23156c.setContentDescription("Filter");
            bVar.f23156c.setOnClickListener(new View.OnClickListener() { // from class: com.onetrust.otpublishers.headless.UI.adapter.u
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f23145a.d(bVar, str, str2, string2, view);
                }
            });
        } catch (JSONException e10) {
            com.onetrust.otpublishers.headless.Internal.Helper.p.a(e10, new StringBuilder("error while parsing "), "OneTrust", 6);
        }
    }

    public final void e(@NonNull List<String> list) {
        this.f23152k = new ArrayList(list);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f23151j.length();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i10) {
        c((b) viewHolder);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i10) {
        return new b(LayoutInflater.from(viewGroup.getContext()).inflate(p6.e.C, viewGroup, false));
    }
}
