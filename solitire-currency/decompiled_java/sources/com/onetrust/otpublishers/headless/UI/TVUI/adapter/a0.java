package com.onetrust.otpublishers.headless.UI.TVUI.adapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.ironsource.v8;
import com.onetrust.otpublishers.headless.UI.TVUI.fragments.f0;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class a0 extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public JSONObject f22170i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final com.onetrust.otpublishers.headless.UI.TVUI.datautils.d f22171j = com.onetrust.otpublishers.headless.UI.TVUI.datautils.d.a();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final c f22172k;

    public static class a extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final TextView f22173b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final TextView f22174c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final TextView f22175d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final TextView f22176e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final TextView f22177f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final TextView f22178g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final TextView f22179h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final TextView f22180i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final TextView f22181j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final RecyclerView f22182k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final LinearLayout f22183l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final LinearLayout f22184m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final LinearLayout f22185n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final LinearLayout f22186o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public final LinearLayout f22187p;

        public a(View view) {
            super(view);
            this.f22173b = (TextView) view.findViewById(p6.d.f32730k1);
            this.f22174c = (TextView) view.findViewById(p6.d.f32811t1);
            this.f22175d = (TextView) view.findViewById(p6.d.f32757n1);
            this.f22176e = (TextView) view.findViewById(p6.d.f32703h1);
            this.f22177f = (TextView) view.findViewById(p6.d.f32784q1);
            this.f22178g = (TextView) view.findViewById(p6.d.f32748m1);
            this.f22179h = (TextView) view.findViewById(p6.d.f32829v1);
            this.f22180i = (TextView) view.findViewById(p6.d.f32775p1);
            this.f22181j = (TextView) view.findViewById(p6.d.f32721j1);
            this.f22182k = (RecyclerView) view.findViewById(p6.d.f32793r1);
            this.f22183l = (LinearLayout) view.findViewById(p6.d.f32739l1);
            this.f22184m = (LinearLayout) view.findViewById(p6.d.f32820u1);
            this.f22185n = (LinearLayout) view.findViewById(p6.d.f32766o1);
            this.f22186o = (LinearLayout) view.findViewById(p6.d.f32712i1);
            this.f22187p = (LinearLayout) view.findViewById(p6.d.f32802s1);
        }
    }

    public static class b extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final TextView f22188b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final TextView f22189c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final TextView f22190d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final TextView f22191e;

        public b(View view) {
            super(view);
            this.f22188b = (TextView) view.findViewById(p6.d.f32837w1);
            this.f22189c = (TextView) view.findViewById(p6.d.f32845x1);
            this.f22190d = (TextView) view.findViewById(p6.d.D6);
            this.f22191e = (TextView) view.findViewById(p6.d.E6);
        }
    }

    public interface c {
    }

    public static class d extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final TextView f22192b;

        public d(View view) {
            super(view);
            this.f22192b = (TextView) view.findViewById(p6.d.f32850x6);
        }
    }

    public static class e extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final TextView f22193b;

        public e(View view) {
            super(view);
            this.f22193b = (TextView) view.findViewById(p6.d.f32858y6);
        }
    }

    public a0(@NonNull JSONObject jSONObject, c cVar) {
        this.f22170i = jSONObject;
        this.f22172k = cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean i(a aVar, View view, int i10, KeyEvent keyEvent) {
        if (com.onetrust.otpublishers.headless.UI.Helper.i.a(i10, keyEvent) != 24) {
            return false;
        }
        ((f0) ((com.onetrust.otpublishers.headless.UI.TVUI.fragments.a0) this.f22172k).f22432s).a(24);
        aVar.itemView.setFocusable(false);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean j(b bVar, View view, int i10, KeyEvent keyEvent) {
        if (com.onetrust.otpublishers.headless.UI.Helper.i.a(i10, keyEvent) != 24) {
            return false;
        }
        ((f0) ((com.onetrust.otpublishers.headless.UI.TVUI.fragments.a0) this.f22172k).f22432s).a(24);
        bVar.itemView.setFocusable(false);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean k(d dVar, View view, int i10, KeyEvent keyEvent) {
        if (com.onetrust.otpublishers.headless.UI.Helper.i.a(i10, keyEvent) != 24) {
            return false;
        }
        ((f0) ((com.onetrust.otpublishers.headless.UI.TVUI.fragments.a0) this.f22172k).f22432s).a(24);
        dVar.itemView.setFocusable(false);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean l(e eVar, View view, int i10, KeyEvent keyEvent) {
        if (com.onetrust.otpublishers.headless.UI.Helper.i.a(i10, keyEvent) != 24) {
            return false;
        }
        ((f0) ((com.onetrust.otpublishers.headless.UI.TVUI.fragments.a0) this.f22172k).f22432s).a(24);
        eVar.itemView.setFocusable(false);
        return true;
    }

    public final void e(final a aVar, int i10) {
        boolean z10;
        com.onetrust.otpublishers.headless.Internal.Preferences.h hVar;
        boolean z11;
        com.onetrust.otpublishers.headless.Internal.Preferences.h hVar2;
        JSONArray jSONArrayNames = this.f22170i.names();
        if (jSONArrayNames == null) {
            return;
        }
        String strOptString = jSONArrayNames.optString(i10);
        com.onetrust.otpublishers.headless.UI.TVUI.datautils.e eVarA = com.onetrust.otpublishers.headless.UI.TVUI.datautils.e.a();
        String str = this.f22171j.f22381b;
        aVar.itemView.setFocusable(true);
        try {
            JSONObject jSONObject = new JSONObject(strOptString);
            long jOptLong = jSONObject.optLong("maxAgeSeconds");
            Context context = aVar.f22182k.getContext();
            SharedPreferences sharedPreferences = context.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0);
            if (new com.onetrust.otpublishers.headless.Internal.profile.d(context).t()) {
                hVar = new com.onetrust.otpublishers.headless.Internal.Preferences.h(context, sharedPreferences, sharedPreferences.getString("OT_ACTIVE_PROFILE_ID", ""));
                z10 = true;
            } else {
                z10 = false;
                hVar = null;
            }
            if (z10) {
                sharedPreferences = hVar;
            }
            String string = sharedPreferences.getString("OT_IAB_PURPOSES_TRANSLATED", "");
            if (com.onetrust.otpublishers.headless.Internal.c.q(string)) {
                aVar.f22187p.setVisibility(8);
            } else {
                JSONObject jSONObject2 = new JSONObject(string);
                JSONObject jSONObject3 = jSONObject2.has("purposes") ? jSONObject2.getJSONObject("purposes") : null;
                JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("purposes");
                if (!com.onetrust.otpublishers.headless.Internal.a.c(jSONArrayOptJSONArray) && !com.onetrust.otpublishers.headless.Internal.a.d(jSONObject3)) {
                    JSONArray jSONArray = new JSONArray();
                    for (int i11 = 0; i11 < jSONArrayOptJSONArray.length(); i11++) {
                        jSONArray.put(jSONObject3.getJSONObject(jSONArrayOptJSONArray.get(i11).toString()));
                    }
                    v vVar = new v(str, jSONArray);
                    aVar.f22177f.setText(eVarA.f22408v);
                    aVar.f22177f.setTextColor(Color.parseColor(str));
                    RecyclerView recyclerView = aVar.f22182k;
                    recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
                    aVar.f22182k.setAdapter(vVar);
                }
            }
            TextView textView = aVar.f22173b;
            String str2 = eVarA.f22404r;
            TextView textView2 = aVar.f22178g;
            String strB = com.onetrust.otpublishers.headless.UI.TVUI.datautils.e.b(jSONObject);
            LinearLayout linearLayout = aVar.f22183l;
            if (com.onetrust.otpublishers.headless.Internal.c.q(strB)) {
                linearLayout.setVisibility(8);
            } else {
                textView.setText(str2);
                textView2.setText(strB);
            }
            TextView textView3 = aVar.f22174c;
            String str3 = eVarA.f22405s;
            TextView textView4 = aVar.f22179h;
            String strOptString2 = jSONObject.optString("type");
            LinearLayout linearLayout2 = aVar.f22184m;
            if (com.onetrust.otpublishers.headless.Internal.c.q(strOptString2)) {
                linearLayout2.setVisibility(8);
            } else {
                textView3.setText(str3);
                textView4.setText(strOptString2);
            }
            TextView textView5 = aVar.f22176e;
            String str4 = eVarA.f22407u;
            TextView textView6 = aVar.f22181j;
            String strOptString3 = jSONObject.optString(v8.i.D);
            LinearLayout linearLayout3 = aVar.f22186o;
            if (com.onetrust.otpublishers.headless.Internal.c.q(strOptString3)) {
                linearLayout3.setVisibility(8);
            } else {
                textView5.setText(str4);
                textView6.setText(strOptString3);
            }
            TextView textView7 = aVar.f22175d;
            String str5 = eVarA.f22406t;
            TextView textView8 = aVar.f22180i;
            com.onetrust.otpublishers.headless.UI.TVUI.datautils.d dVar = this.f22171j;
            Context context2 = aVar.itemView.getContext();
            JSONObject jSONObject4 = dVar.f22380a;
            if (jSONObject4 == null) {
                SharedPreferences sharedPreferences2 = context2.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0);
                if (com.onetrust.otpublishers.headless.Internal.b.a(new com.onetrust.otpublishers.headless.Internal.Preferences.e(context2, "OTT_DEFAULT_USER").c().getString("OT_ENABLE_MULTI_PROFILE", Boolean.FALSE.toString()))) {
                    hVar2 = new com.onetrust.otpublishers.headless.Internal.Preferences.h(context2, sharedPreferences2, sharedPreferences2.getString("OT_ACTIVE_PROFILE_ID", ""));
                    z11 = true;
                } else {
                    z11 = false;
                    hVar2 = null;
                }
                if (z11) {
                    sharedPreferences2 = hVar2;
                }
                String string2 = sharedPreferences2.getString("OTT_PC_DATA", null);
                jSONObject4 = com.onetrust.otpublishers.headless.Internal.c.q(string2) ? null : new JSONObject(string2);
            }
            String strD = com.onetrust.otpublishers.headless.UI.Helper.l.d(jOptLong, jSONObject4);
            LinearLayout linearLayout4 = aVar.f22185n;
            if (com.onetrust.otpublishers.headless.Internal.c.q(strD)) {
                linearLayout4.setVisibility(8);
            } else {
                textView7.setText(str5);
                textView8.setText(strD);
            }
            aVar.f22177f.setTextColor(Color.parseColor(str));
            aVar.f22173b.setTextColor(Color.parseColor(str));
            aVar.f22176e.setTextColor(Color.parseColor(str));
            aVar.f22175d.setTextColor(Color.parseColor(str));
            aVar.f22174c.setTextColor(Color.parseColor(str));
            aVar.f22178g.setTextColor(Color.parseColor(str));
            aVar.f22181j.setTextColor(Color.parseColor(str));
            aVar.f22180i.setTextColor(Color.parseColor(str));
            aVar.f22179h.setTextColor(Color.parseColor(str));
            aVar.itemView.setOnKeyListener(new View.OnKeyListener() { // from class: com.onetrust.otpublishers.headless.UI.TVUI.adapter.y
                @Override // android.view.View.OnKeyListener
                public final boolean onKey(View view, int i12, KeyEvent keyEvent) {
                    return this.f22325a.i(aVar, view, i12, keyEvent);
                }
            });
        } catch (JSONException e10) {
            com.onetrust.otpublishers.headless.Internal.Helper.n.a(e10, new StringBuilder("exception thrown while populating disclosure items, err : "), "OneTrust", 6);
        }
    }

    public final void f(final b bVar, int i10) {
        JSONArray jSONArrayNames = this.f22170i.names();
        if (jSONArrayNames == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(jSONArrayNames.optString(i10));
            com.onetrust.otpublishers.headless.UI.TVUI.datautils.e eVarA = com.onetrust.otpublishers.headless.UI.TVUI.datautils.e.a();
            if (!com.onetrust.otpublishers.headless.Internal.a.d(jSONObject)) {
                if (!jSONObject.has(v8.i.D) || com.onetrust.otpublishers.headless.Internal.c.q(jSONObject.optString(v8.i.D))) {
                    bVar.f22188b.setVisibility(8);
                    bVar.f22189c.setVisibility(8);
                } else {
                    TextView textView = bVar.f22188b;
                    String str = eVarA.f22407u;
                    String str2 = this.f22171j.f22381b;
                    if (!com.onetrust.otpublishers.headless.Internal.c.q(str)) {
                        textView.setText(str);
                    }
                    textView.setTextColor(Color.parseColor(str2));
                    TextView textView2 = bVar.f22189c;
                    String strOptString = jSONObject.optString(v8.i.D);
                    String str3 = this.f22171j.f22381b;
                    if (!com.onetrust.otpublishers.headless.Internal.c.q(strOptString)) {
                        textView2.setText(strOptString);
                    }
                    textView2.setTextColor(Color.parseColor(str3));
                }
                if (!jSONObject.has("use") || com.onetrust.otpublishers.headless.Internal.c.q(jSONObject.optString("use"))) {
                    bVar.f22190d.setVisibility(8);
                    bVar.f22191e.setVisibility(8);
                } else {
                    TextView textView3 = bVar.f22190d;
                    String str4 = eVarA.f22410x;
                    String str5 = this.f22171j.f22381b;
                    if (!com.onetrust.otpublishers.headless.Internal.c.q(str4)) {
                        textView3.setText(str4);
                    }
                    textView3.setTextColor(Color.parseColor(str5));
                    TextView textView4 = bVar.f22191e;
                    String strOptString2 = jSONObject.optString("use");
                    String str6 = this.f22171j.f22381b;
                    if (!com.onetrust.otpublishers.headless.Internal.c.q(strOptString2)) {
                        textView4.setText(strOptString2);
                    }
                    textView4.setTextColor(Color.parseColor(str6));
                }
            }
            bVar.itemView.setFocusable(true);
            bVar.itemView.setOnKeyListener(new View.OnKeyListener() { // from class: com.onetrust.otpublishers.headless.UI.TVUI.adapter.z
                @Override // android.view.View.OnKeyListener
                public final boolean onKey(View view, int i11, KeyEvent keyEvent) {
                    return this.f22327a.j(bVar, view, i11, keyEvent);
                }
            });
        } catch (Exception e10) {
            com.onetrust.otpublishers.headless.Internal.Helper.j.a(e10, new StringBuilder("Error on populating disclosures, err : "), "OneTrust", 6);
        }
    }

    public final void g(final d dVar, int i10) {
        JSONArray jSONArrayNames = this.f22170i.names();
        if (jSONArrayNames == null) {
            return;
        }
        dVar.f22192b.setText(jSONArrayNames.optString(i10));
        dVar.f22192b.setTextColor(Color.parseColor(this.f22171j.f22381b));
        com.onetrust.otpublishers.headless.UI.Helper.i.f(dVar.f22192b, this.f22171j.f22381b);
        dVar.itemView.setFocusable(true);
        dVar.itemView.setOnKeyListener(new View.OnKeyListener() { // from class: com.onetrust.otpublishers.headless.UI.TVUI.adapter.w
            @Override // android.view.View.OnKeyListener
            public final boolean onKey(View view, int i11, KeyEvent keyEvent) {
                return this.f22321a.k(dVar, view, i11, keyEvent);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        JSONObject jSONObject = this.f22170i;
        if (jSONObject == null) {
            return 0;
        }
        return jSONObject.length();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int i10) {
        try {
            JSONArray jSONArrayNames = this.f22170i.names();
            if (jSONArrayNames != null) {
                return this.f22170i.getInt(jSONArrayNames.get(i10).toString());
            }
        } catch (Exception e10) {
            com.onetrust.otpublishers.headless.Internal.Helper.j.a(e10, new StringBuilder("error while getting view type "), "OneTrust", 6);
        }
        return 0;
    }

    public final void h(final e eVar, int i10) {
        JSONArray jSONArrayNames = this.f22170i.names();
        if (jSONArrayNames == null) {
            return;
        }
        eVar.f22193b.setText(jSONArrayNames.optString(i10));
        eVar.f22193b.setTextColor(Color.parseColor(this.f22171j.f22381b));
        eVar.itemView.setFocusable(true);
        eVar.itemView.setOnKeyListener(new View.OnKeyListener() { // from class: com.onetrust.otpublishers.headless.UI.TVUI.adapter.x
            @Override // android.view.View.OnKeyListener
            public final boolean onKey(View view, int i11, KeyEvent keyEvent) {
                return this.f22323a.l(eVar, view, i11, keyEvent);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i10) {
        int itemViewType = viewHolder.getItemViewType();
        if (itemViewType == 1) {
            h((e) viewHolder, i10);
            return;
        }
        if (itemViewType != 2) {
            if (itemViewType == 3) {
                e((a) viewHolder, i10);
                return;
            } else if (itemViewType == 4) {
                f((b) viewHolder, i10);
                return;
            } else if (itemViewType != 5) {
                return;
            }
        }
        g((d) viewHolder, i10);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public final RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i10) {
        if (i10 == 1) {
            return new e(LayoutInflater.from(viewGroup.getContext()).inflate(p6.e.K, viewGroup, false));
        }
        if (i10 == 2) {
            return new d(LayoutInflater.from(viewGroup.getContext()).inflate(p6.e.J, viewGroup, false));
        }
        if (i10 == 3) {
            return new a(LayoutInflater.from(viewGroup.getContext()).inflate(p6.e.M, viewGroup, false));
        }
        if (i10 == 4) {
            return new b(LayoutInflater.from(viewGroup.getContext()).inflate(p6.e.N, viewGroup, false));
        }
        if (i10 == 5) {
            return new d(LayoutInflater.from(viewGroup.getContext()).inflate(p6.e.L, viewGroup, false));
        }
        throw new RuntimeException("Invalid view type found");
    }
}
