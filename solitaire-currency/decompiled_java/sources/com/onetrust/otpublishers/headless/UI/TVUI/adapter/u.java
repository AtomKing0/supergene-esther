package com.onetrust.otpublishers.headless.UI.TVUI.adapter;

import android.R;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class u extends RecyclerView.Adapter<b> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final a f22310i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final JSONArray f22311j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f22312k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public HashMap f22313l;

    public interface a {
    }

    public static class b extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final TextView f22314b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final CheckBox f22315c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final LinearLayout f22316d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final CardView f22317e;

        public b(View view) {
            super(view);
            this.f22314b = (TextView) view.findViewById(p6.d.F3);
            this.f22315c = (CheckBox) view.findViewById(p6.d.C3);
            this.f22316d = (LinearLayout) view.findViewById(p6.d.D3);
            this.f22317e = (CardView) view.findViewById(p6.d.B3);
        }
    }

    public u(@NonNull JSONArray jSONArray, @NonNull String str, @NonNull Map<String, String> map, @NonNull a aVar) {
        this.f22313l = new HashMap();
        this.f22311j = jSONArray;
        this.f22312k = str;
        this.f22310i = aVar;
        this.f22313l = new HashMap(map);
    }

    public static void c(@NonNull CheckBox checkBox, int i10) {
        checkBox.setButtonTintList(new ColorStateList(new int[][]{new int[]{R.attr.state_checked}, new int[0]}, new int[]{i10, i10}));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(b bVar, com.onetrust.otpublishers.headless.UI.TVUI.datautils.c cVar, String str, View view, boolean z10) {
        if (z10) {
            bVar.f22316d.setBackgroundColor(Color.parseColor(cVar.f22370j.f22873y.f22766i));
            bVar.f22314b.setTextColor(Color.parseColor(cVar.f22370j.f22873y.f22767j));
            c(bVar.f22315c, Color.parseColor(cVar.f22370j.f22873y.f22767j));
            bVar.f22317e.setCardElevation(6.0f);
            return;
        }
        bVar.f22316d.setBackgroundColor(Color.parseColor(str));
        bVar.f22314b.setTextColor(Color.parseColor(this.f22312k));
        c(bVar.f22315c, Color.parseColor(this.f22312k));
        bVar.f22317e.setCardElevation(1.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(b bVar, String str, String str2, CompoundButton compoundButton, boolean z10) {
        String str3;
        if (!bVar.f22315c.isChecked()) {
            this.f22313l.remove(str);
            ((com.onetrust.otpublishers.headless.UI.TVUI.fragments.b0) this.f22310i).f22472g = this.f22313l;
            str3 = "Purposes Removed : " + str;
        } else {
            if (this.f22313l.containsKey(str)) {
                return;
            }
            this.f22313l.put(str, str2);
            ((com.onetrust.otpublishers.headless.UI.TVUI.fragments.b0) this.f22310i).f22472g = this.f22313l;
            str3 = "Purposes Added : " + str;
        }
        OTLogger.a("OneTrust", 4, str3);
    }

    public static /* synthetic */ boolean g(b bVar, View view, int i10, KeyEvent keyEvent) {
        if (com.onetrust.otpublishers.headless.UI.Helper.i.a(i10, keyEvent) != 21) {
            return false;
        }
        bVar.f22315c.setChecked(!r0.isChecked());
        return false;
    }

    public final void d(final b bVar) {
        boolean zContainsKey = false;
        bVar.setIsRecyclable(false);
        try {
            final com.onetrust.otpublishers.headless.UI.TVUI.datautils.c cVarJ = com.onetrust.otpublishers.headless.UI.TVUI.datautils.c.j();
            JSONObject jSONObject = this.f22311j.getJSONObject(bVar.getAdapterPosition());
            bVar.f22314b.setText(jSONObject.getString("GroupName"));
            final String strOptString = jSONObject.optString("CustomGroupId", "");
            OTLogger.a("OneTrust", 4, "Purposes to pass on apply filters : " + this.f22313l);
            if (this.f22313l != null) {
                OTLogger.a("OneTrust", 4, "Purposes to pass on apply filters : " + this.f22313l);
                zContainsKey = this.f22313l.containsKey(strOptString);
            }
            bVar.f22315c.setChecked(zContainsKey);
            final String strJ = com.onetrust.otpublishers.headless.UI.Helper.i.j(cVarJ.a());
            bVar.f22316d.setBackgroundColor(Color.parseColor(strJ));
            bVar.f22314b.setTextColor(Color.parseColor(this.f22312k));
            c(bVar.f22315c, Color.parseColor(this.f22312k));
            bVar.f22317e.setCardElevation(1.0f);
            bVar.itemView.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.onetrust.otpublishers.headless.UI.TVUI.adapter.r
                @Override // android.view.View.OnFocusChangeListener
                public final void onFocusChange(View view, boolean z10) {
                    this.f22301a.e(bVar, cVarJ, strJ, view, z10);
                }
            });
            bVar.f22317e.setOnKeyListener(new View.OnKeyListener() { // from class: com.onetrust.otpublishers.headless.UI.TVUI.adapter.s
                @Override // android.view.View.OnKeyListener
                public final boolean onKey(View view, int i10, KeyEvent keyEvent) {
                    return u.g(bVar, view, i10, keyEvent);
                }
            });
            final String string = jSONObject.getString("Type");
            bVar.f22315c.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.onetrust.otpublishers.headless.UI.TVUI.adapter.t
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
                    this.f22306a.f(bVar, strOptString, string, compoundButton, z10);
                }
            });
        } catch (JSONException e10) {
            com.onetrust.otpublishers.headless.Internal.Helper.p.a(e10, new StringBuilder("error while parsing "), "OneTrust", 6);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f22311j.length();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i10) {
        d((b) viewHolder);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i10) {
        return new b(LayoutInflater.from(viewGroup.getContext()).inflate(p6.e.H, viewGroup, false));
    }
}
