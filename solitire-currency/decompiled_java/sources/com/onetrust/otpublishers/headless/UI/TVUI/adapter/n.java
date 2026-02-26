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
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class n extends RecyclerView.Adapter<b> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final a f22274i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final JSONArray f22275j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f22276k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public List<String> f22277l;

    public interface a {
    }

    public static class b extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final TextView f22278b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final CheckBox f22279c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final LinearLayout f22280d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final CardView f22281e;

        public b(View view) {
            super(view);
            this.f22278b = (TextView) view.findViewById(p6.d.F3);
            this.f22279c = (CheckBox) view.findViewById(p6.d.C3);
            this.f22280d = (LinearLayout) view.findViewById(p6.d.D3);
            this.f22281e = (CardView) view.findViewById(p6.d.B3);
        }
    }

    public n(@NonNull JSONArray jSONArray, @NonNull String str, @NonNull List<String> list, @NonNull a aVar) {
        new ArrayList();
        this.f22275j = jSONArray;
        this.f22276k = str;
        this.f22274i = aVar;
        this.f22277l = list;
    }

    public static void c(@NonNull CheckBox checkBox, int i10) {
        checkBox.setButtonTintList(new ColorStateList(new int[][]{new int[]{R.attr.state_checked}, new int[0]}, new int[]{i10, i10}));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(b bVar, com.onetrust.otpublishers.headless.UI.TVUI.datautils.c cVar, String str, View view, boolean z10) {
        if (z10) {
            bVar.f22280d.setBackgroundColor(Color.parseColor(cVar.f22370j.f22873y.f22766i));
            bVar.f22278b.setTextColor(Color.parseColor(cVar.f22370j.f22873y.f22767j));
            c(bVar.f22279c, Color.parseColor(cVar.f22370j.f22873y.f22767j));
            bVar.f22281e.setCardElevation(6.0f);
            return;
        }
        bVar.f22280d.setBackgroundColor(Color.parseColor(str));
        bVar.f22278b.setTextColor(Color.parseColor(this.f22276k));
        c(bVar.f22279c, Color.parseColor(this.f22276k));
        bVar.f22281e.setCardElevation(1.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(b bVar, String str, CompoundButton compoundButton, boolean z10) {
        String str2;
        if (!bVar.f22279c.isChecked()) {
            this.f22277l.remove(str);
            ((com.onetrust.otpublishers.headless.UI.TVUI.fragments.s) this.f22274i).f22658g = this.f22277l;
            str2 = "Purposes Removed : " + str;
        } else {
            if (this.f22277l.contains(str)) {
                return;
            }
            this.f22277l.add(str);
            ((com.onetrust.otpublishers.headless.UI.TVUI.fragments.s) this.f22274i).f22658g = this.f22277l;
            str2 = "Purposes Added : " + str;
        }
        OTLogger.a("OneTrust", 4, str2);
    }

    public static /* synthetic */ boolean g(b bVar, View view, int i10, KeyEvent keyEvent) {
        if (com.onetrust.otpublishers.headless.UI.Helper.i.a(i10, keyEvent) != 21) {
            return false;
        }
        bVar.f22279c.setChecked(!r0.isChecked());
        return false;
    }

    public final void d(final b bVar) {
        boolean z10 = false;
        bVar.setIsRecyclable(false);
        try {
            final com.onetrust.otpublishers.headless.UI.TVUI.datautils.c cVarJ = com.onetrust.otpublishers.headless.UI.TVUI.datautils.c.j();
            JSONObject jSONObject = this.f22275j.getJSONObject(bVar.getAdapterPosition());
            bVar.f22278b.setText(jSONObject.getString("GroupName"));
            final String strOptString = jSONObject.optString("CustomGroupId", "");
            int i10 = 0;
            while (true) {
                if (i10 >= this.f22277l.size()) {
                    break;
                }
                if (this.f22277l.get(i10).trim().equals(strOptString)) {
                    z10 = true;
                    break;
                }
                i10++;
            }
            bVar.f22279c.setChecked(z10);
            final String strJ = com.onetrust.otpublishers.headless.UI.Helper.i.j(cVarJ.a());
            bVar.f22280d.setBackgroundColor(Color.parseColor(strJ));
            bVar.f22278b.setTextColor(Color.parseColor(this.f22276k));
            c(bVar.f22279c, Color.parseColor(this.f22276k));
            bVar.f22281e.setCardElevation(1.0f);
            bVar.itemView.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.onetrust.otpublishers.headless.UI.TVUI.adapter.k
                @Override // android.view.View.OnFocusChangeListener
                public final void onFocusChange(View view, boolean z11) {
                    this.f22266a.e(bVar, cVarJ, strJ, view, z11);
                }
            });
            bVar.f22281e.setOnKeyListener(new View.OnKeyListener() { // from class: com.onetrust.otpublishers.headless.UI.TVUI.adapter.l
                @Override // android.view.View.OnKeyListener
                public final boolean onKey(View view, int i11, KeyEvent keyEvent) {
                    return n.g(bVar, view, i11, keyEvent);
                }
            });
            bVar.f22279c.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.onetrust.otpublishers.headless.UI.TVUI.adapter.m
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z11) {
                    this.f22271a.f(bVar, strOptString, compoundButton, z11);
                }
            });
        } catch (JSONException e10) {
            com.onetrust.otpublishers.headless.Internal.Helper.p.a(e10, new StringBuilder("error while parsing "), "OneTrust", 6);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f22275j.length();
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
