package com.onetrust.otpublishers.headless.UI.adapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.SwitchCompat;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import com.onetrust.otpublishers.headless.Public.DataModel.OTConfiguration;
import com.onetrust.otpublishers.headless.Public.Keys.OTFragmentTags;
import com.onetrust.otpublishers.headless.Public.OTPublishersHeadlessSDK;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class j extends RecyclerView.Adapter<b> {
    public final com.onetrust.otpublishers.headless.UI.UIProperty.w A;
    public JSONObject B;
    public final com.onetrust.otpublishers.headless.UI.mobiledatautils.e C;
    public final String D;
    public final String E;
    public final String F;
    public boolean G;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final OTConfiguration f22993i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final JSONObject f22994j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final com.onetrust.otpublishers.headless.UI.UIProperty.v f22995k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final JSONArray f22996l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f22997m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Boolean f22998n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Boolean f22999o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Boolean f23000p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final OTPublishersHeadlessSDK f23001q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Context f23002r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final a f23003s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final boolean f23004t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f23005u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f23006v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f23007w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final com.onetrust.otpublishers.headless.Internal.Event.a f23008x = new com.onetrust.otpublishers.headless.Internal.Event.a();

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public String f23009y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final String f23010z;

    public interface a {
    }

    public static class b extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final TextView f23011b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final TextView f23012c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final TextView f23013d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final TextView f23014e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final TextView f23015f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final TextView f23016g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final TextView f23017h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final TextView f23018i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final SwitchCompat f23019j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final SwitchCompat f23020k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final SwitchCompat f23021l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final View f23022m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final LinearLayout f23023n;

        public b(View view) {
            super(view);
            this.f23014e = (TextView) view.findViewById(p6.d.f32662c5);
            this.f23015f = (TextView) view.findViewById(p6.d.f32652b4);
            this.f23016g = (TextView) view.findViewById(p6.d.f32653b5);
            this.f23011b = (TextView) view.findViewById(p6.d.f32754m7);
            this.f23019j = (SwitchCompat) view.findViewById(p6.d.Y0);
            this.f23020k = (SwitchCompat) view.findViewById(p6.d.f32830v2);
            this.f23012c = (TextView) view.findViewById(p6.d.C5);
            this.f23013d = (TextView) view.findViewById(p6.d.U5);
            this.f23017h = (TextView) view.findViewById(p6.d.I);
            this.f23018i = (TextView) view.findViewById(p6.d.K);
            this.f23021l = (SwitchCompat) view.findViewById(p6.d.Z0);
            this.f23022m = view.findViewById(p6.d.f32785q2);
            this.f23023n = (LinearLayout) view.findViewById(p6.d.V1);
        }
    }

    public j(a aVar, @Nullable Context context, @NonNull int i10, boolean z10, @Nullable OTConfiguration oTConfiguration, com.onetrust.otpublishers.headless.UI.mobiledatautils.e eVar, @NonNull OTPublishersHeadlessSDK oTPublishersHeadlessSDK, @NonNull JSONObject jSONObject) {
        this.C = eVar;
        this.f22996l = eVar.b().optJSONArray("SubGroups");
        this.f22998n = Boolean.valueOf(z10);
        this.f22999o = Boolean.valueOf(eVar.m());
        this.f23000p = Boolean.valueOf(eVar.n());
        this.f23004t = eVar.l();
        this.f23001q = oTPublishersHeadlessSDK;
        this.f23002r = context;
        this.f23003s = aVar;
        this.f23010z = eVar.f();
        this.A = eVar.j();
        this.f22993i = oTConfiguration;
        this.D = eVar.j().c();
        this.E = eVar.j().b();
        this.F = eVar.j().a();
        this.f22994j = jSONObject;
        this.f22995k = eVar.h();
        h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A(JSONObject jSONObject, b bVar, CompoundButton compoundButton, boolean z10) {
        Context context;
        SwitchCompat switchCompat;
        String str;
        String str2;
        try {
            String string = jSONObject.getString("CustomGroupId");
            this.f23001q.updatePurposeConsent(string, z10);
            com.onetrust.otpublishers.headless.Internal.Event.b bVar2 = new com.onetrust.otpublishers.headless.Internal.Event.b(7);
            bVar2.f21746b = string;
            bVar2.f21747c = z10 ? 1 : 0;
            com.onetrust.otpublishers.headless.Internal.Event.a aVar = this.f23008x;
            if (aVar != null) {
                aVar.a(bVar2);
            } else {
                OTLogger.a("OneTrust", 6, "Error on sending UI events, listener set was found to be null.This could be because the activity has been recreated. \n Please set listener to get UI event callbacks.");
            }
            if (z10) {
                context = this.f23002r;
                switchCompat = bVar.f23021l;
                str = this.D;
                str2 = this.E;
            } else {
                context = this.f23002r;
                switchCompat = bVar.f23021l;
                str = this.D;
                str2 = this.F;
            }
            com.onetrust.otpublishers.headless.UI.Helper.l.k(context, switchCompat, str, str2);
        } catch (JSONException e10) {
            com.onetrust.otpublishers.headless.Internal.Helper.p.a(e10, new StringBuilder("Error while updating consent status "), "OTPCDetailsAdapter", 6);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(int i10, b bVar, View view) {
        try {
            q(this.f22996l.getJSONObject(i10).getString("Parent"), this.f22996l.getJSONObject(i10).optString("CustomGroupId", ""), bVar.f23019j.isChecked(), false);
        } catch (JSONException e10) {
            com.onetrust.otpublishers.headless.Internal.Helper.p.a(e10, new StringBuilder("Error while setting parent status "), "OTPCDetailsAdapter", 6);
        }
    }

    public static void j(@NonNull TextView textView, int i10, @Nullable View view) {
        textView.setVisibility(i10);
        if (view != null) {
            view.setVisibility(i10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(JSONObject jSONObject, int i10, b bVar, View view) {
        try {
            q(jSONObject.getString("Parent"), this.f22996l.getJSONObject(i10).optString("CustomGroupId", ""), bVar.f23020k.isChecked(), true);
        } catch (JSONException e10) {
            com.onetrust.otpublishers.headless.Internal.Helper.p.a(e10, new StringBuilder("Error while updating parent status "), "OTPCDetailsAdapter", 6);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(JSONObject jSONObject, View view) {
        OTConfiguration oTConfiguration = this.f22993i;
        com.onetrust.otpublishers.headless.UI.fragment.z zVar = new com.onetrust.otpublishers.headless.UI.fragment.z();
        Bundle bundle = new Bundle();
        bundle.putString(TypedValues.Custom.S_STRING, OTFragmentTags.OT_IAB_ILLUSTRATION_DETAILS_TAG);
        zVar.setArguments(bundle);
        zVar.f23594m = oTConfiguration;
        zVar.f23598q = jSONObject;
        zVar.f23589h = this.f23001q;
        if (zVar.isAdded()) {
            return;
        }
        com.onetrust.otpublishers.headless.UI.mobiledatautils.c.j(zVar, (FragmentActivity) this.f23002r, OTFragmentTags.OT_IAB_ILLUSTRATION_DETAILS_TAG);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(JSONObject jSONObject, b bVar, CompoundButton compoundButton, boolean z10) {
        Context context;
        SwitchCompat switchCompat;
        String str;
        String str2;
        try {
            String string = jSONObject.getString("CustomGroupId");
            this.f23001q.updatePurposeLegitInterest(string, z10);
            com.onetrust.otpublishers.headless.Internal.Event.b bVar2 = new com.onetrust.otpublishers.headless.Internal.Event.b(11);
            bVar2.f21746b = string;
            bVar2.f21747c = z10 ? 1 : 0;
            com.onetrust.otpublishers.headless.Internal.Event.a aVar = this.f23008x;
            if (aVar != null) {
                aVar.a(bVar2);
            } else {
                OTLogger.a("OneTrust", 6, "Error on sending UI events, listener set was found to be null.This could be because the activity has been recreated. \n Please set listener to get UI event callbacks.");
            }
            if (z10) {
                context = this.f23002r;
                switchCompat = bVar.f23020k;
                str = this.D;
                str2 = this.E;
            } else {
                context = this.f23002r;
                switchCompat = bVar.f23020k;
                str = this.D;
                str2 = this.F;
            }
            com.onetrust.otpublishers.headless.UI.Helper.l.k(context, switchCompat, str, str2);
        } catch (JSONException e10) {
            com.onetrust.otpublishers.headless.Internal.Helper.p.a(e10, new StringBuilder("Error while updating LI status "), "OTPCDetailsAdapter", 6);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(int i10, b bVar, View view) {
        try {
            q(this.f22996l.getJSONObject(i10).getString("Parent"), this.f22996l.getJSONObject(i10).optString("CustomGroupId", ""), bVar.f23021l.isChecked(), false);
        } catch (JSONException e10) {
            com.onetrust.otpublishers.headless.Internal.Helper.p.a(e10, new StringBuilder("Error while setting parent status "), "OTPCDetailsAdapter", 6);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(JSONObject jSONObject, b bVar, CompoundButton compoundButton, boolean z10) {
        Context context;
        SwitchCompat switchCompat;
        String str;
        String str2;
        try {
            String string = jSONObject.getString("CustomGroupId");
            this.f23001q.updatePurposeConsent(string, z10);
            com.onetrust.otpublishers.headless.Internal.Event.b bVar2 = new com.onetrust.otpublishers.headless.Internal.Event.b(7);
            bVar2.f21746b = string;
            bVar2.f21747c = z10 ? 1 : 0;
            com.onetrust.otpublishers.headless.Internal.Event.a aVar = this.f23008x;
            if (aVar != null) {
                aVar.a(bVar2);
            } else {
                OTLogger.a("OneTrust", 6, "Error on sending UI events, listener set was found to be null.This could be because the activity has been recreated. \n Please set listener to get UI event callbacks.");
            }
            if (z10) {
                context = this.f23002r;
                switchCompat = bVar.f23019j;
                str = this.D;
                str2 = this.E;
            } else {
                context = this.f23002r;
                switchCompat = bVar.f23019j;
                str = this.D;
                str2 = this.F;
            }
            com.onetrust.otpublishers.headless.UI.Helper.l.k(context, switchCompat, str, str2);
        } catch (JSONException e10) {
            com.onetrust.otpublishers.headless.Internal.Helper.p.a(e10, new StringBuilder("Error while updating consent status "), "OTPCDetailsAdapter", 6);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        JSONArray jSONArray = this.f22996l;
        if (jSONArray != null) {
            return jSONArray.length();
        }
        return 0;
    }

    public final void h() {
        com.onetrust.otpublishers.headless.UI.UIProperty.v vVar = this.f22995k;
        this.G = vVar == null || vVar.f22831a;
    }

    @RequiresApi(api = 17)
    public final void k(@NonNull TextView textView, com.onetrust.otpublishers.headless.UI.UIProperty.c cVar) {
        Typeface otTypeFaceMap;
        textView.setText(cVar.f22724e);
        textView.setTextColor(Color.parseColor(cVar.f22722c));
        com.onetrust.otpublishers.headless.UI.UIProperty.l lVar = cVar.f22720a;
        OTConfiguration oTConfiguration = this.f22993i;
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
        com.onetrust.otpublishers.headless.UI.Helper.l.q(textView, cVar.f22721b);
    }

    @RequiresApi(api = 17)
    public final void l(@NonNull b bVar) {
        try {
            com.onetrust.otpublishers.headless.UI.UIProperty.w wVar = this.A;
            if (wVar != null) {
                k(bVar.f23014e, wVar.f22840h);
                k(bVar.f23016g, this.A.f22841i);
                v(bVar.f23015f, this.A.f22841i);
                k(bVar.f23012c, this.A.f22842j);
                k(bVar.f23013d, this.A.f22843k);
                k(bVar.f23017h, this.A.f22844l);
                k(bVar.f23018i, this.A.f22844l);
                String str = this.A.f22834b;
                com.onetrust.otpublishers.headless.UI.mobiledatautils.c.g(str, bVar.f23022m);
                if (bVar.getAdapterPosition() == 0) {
                    OTLogger.a("OT_Automation", 3, "setLineBreakColor PC Detail Subgroups List: " + str);
                }
                String str2 = this.A.f22842j.f22724e;
                bVar.f23019j.setContentDescription(str2);
                bVar.f23021l.setContentDescription(str2);
                bVar.f23020k.setContentDescription(this.A.f22843k.f22724e);
            }
        } catch (IllegalArgumentException e10) {
            OTLogger.a("OneTrust", 6, "Error while applying Styles to PC Details view, err : " + e10.getMessage());
        }
    }

    public final void m(@NonNull final b bVar, final int i10, final JSONObject jSONObject) {
        bVar.f23020k.setOnClickListener(new View.OnClickListener() { // from class: com.onetrust.otpublishers.headless.UI.adapter.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f22927a.r(jSONObject, i10, bVar, view);
            }
        });
        bVar.f23020k.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.onetrust.otpublishers.headless.UI.adapter.d
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
                this.f22934a.t(jSONObject, bVar, compoundButton, z10);
            }
        });
    }

    public final void n(@NonNull b bVar, @NonNull JSONObject jSONObject) {
        if (bVar.f23020k.getVisibility() == 0) {
            bVar.f23020k.setChecked(this.f23001q.getPurposeLegitInterestLocal(jSONObject.optString("CustomGroupId", "")) == 1);
            if (this.f23001q.getPurposeLegitInterestLocal(jSONObject.optString("CustomGroupId", "")) == 1) {
                com.onetrust.otpublishers.headless.UI.Helper.l.k(this.f23002r, bVar.f23020k, this.D, this.E);
            } else {
                com.onetrust.otpublishers.headless.UI.Helper.l.k(this.f23002r, bVar.f23020k, this.D, this.F);
            }
        }
    }

    public final void o(@NonNull b bVar, @NonNull JSONObject jSONObject, @NonNull String str) {
        if (this.B != null) {
            if (com.onetrust.otpublishers.headless.Internal.c.q(str)) {
                j(bVar.f23016g, 8, null);
            } else {
                j(bVar.f23016g, 0, null);
            }
            if (!this.f23010z.equalsIgnoreCase("user_friendly")) {
                if (this.f23010z.equalsIgnoreCase("legal")) {
                    if (!jSONObject.getString("Type").equals("COOKIE")) {
                        com.onetrust.otpublishers.headless.UI.Helper.l.j(this.f23002r, bVar.f23016g, this.f23009y);
                        return;
                    }
                } else if (!this.B.isNull(this.f23010z) && !com.onetrust.otpublishers.headless.Internal.c.q(this.f23010z)) {
                    return;
                }
            }
            com.onetrust.otpublishers.headless.UI.Helper.l.j(this.f23002r, bVar.f23016g, str);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @RequiresApi(api = 17)
    public final void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i10) {
        boolean z10;
        com.onetrust.otpublishers.headless.Internal.Preferences.h hVar;
        b bVar = (b) viewHolder;
        bVar.setIsRecyclable(false);
        try {
            this.B = this.f23001q.getPreferenceCenterData();
            Context context = this.f23002r;
            SharedPreferences sharedPreferences = context.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0);
            String str = "";
            if (com.onetrust.otpublishers.headless.Internal.b.a(context.getSharedPreferences("com.onetrust.otpublishers.headless.preference".concat("OTT_DEFAULT_USER"), 0).getString("OT_ENABLE_MULTI_PROFILE", Boolean.FALSE.toString()))) {
                hVar = new com.onetrust.otpublishers.headless.Internal.Preferences.h(context, sharedPreferences, sharedPreferences.getString("OT_ACTIVE_PROFILE_ID", ""));
                z10 = true;
            } else {
                z10 = false;
                hVar = null;
            }
            if (z10) {
                sharedPreferences = hVar;
            }
            String string = sharedPreferences.getString("OT_TEMPLATE_TYPE", "");
            if (!com.onetrust.otpublishers.headless.Internal.c.q(string)) {
                str = string;
            }
            this.f23006v = "IAB2".equalsIgnoreCase(str) || "IAB2V2".equalsIgnoreCase(str);
            l(bVar);
            JSONObject jSONObject = this.f22996l.getJSONObject(bVar.getAdapterPosition());
            this.f23005u = jSONObject.optBoolean("HasLegIntOptOut", false);
            this.f23007w = jSONObject.optBoolean("HasConsentOptOut", false);
            this.f22997m = jSONObject.getString("Type");
            boolean zOptBoolean = jSONObject.optBoolean("HasLegIntOptOut", false);
            if (this.f23006v && jSONObject.getString("Type").contains("IAB")) {
                j(bVar.f23013d, 0, null);
            } else {
                j(bVar.f23013d, 8, null);
            }
            String strOptString = jSONObject.optString("GroupNameMobile");
            if (com.onetrust.otpublishers.headless.Internal.c.q(strOptString)) {
                strOptString = jSONObject.optString("GroupName");
            }
            bVar.f23014e.setText(strOptString);
            ViewCompat.setAccessibilityHeading(bVar.f23014e, true);
            if (com.onetrust.otpublishers.headless.UI.mobiledatautils.c.h(this.f23002r)) {
                com.onetrust.otpublishers.headless.UI.mobiledatautils.c.b(this.f23002r, strOptString, bVar.f23023n, p6.d.Y0);
                com.onetrust.otpublishers.headless.UI.mobiledatautils.c.b(this.f23002r, strOptString, bVar.f23023n, p6.d.f32830v2);
                com.onetrust.otpublishers.headless.UI.mobiledatautils.c.b(this.f23002r, strOptString, bVar.f23023n, p6.d.Z0);
            }
            String strOptString2 = jSONObject.optString("GroupDescription");
            if (jSONObject.has("DescriptionLegal")) {
                this.f23009y = jSONObject.getString("DescriptionLegal");
            }
            String str2 = this.A.f22844l.f22724e;
            bVar.f23017h.setText(str2);
            bVar.f23018i.setText(str2);
            o(bVar, jSONObject, strOptString2);
            x(bVar, jSONObject);
            w(bVar, i10, jSONObject);
            z(bVar, jSONObject);
            n(bVar, jSONObject);
            m(bVar, i10, jSONObject);
            if (this.f23004t) {
                j(bVar.f23016g, 0, null);
            } else {
                j(bVar.f23016g, 8, null);
            }
            p(bVar, jSONObject, zOptBoolean);
            TextView textView = bVar.f23017h;
            TextView textView2 = bVar.f23012c;
            if (jSONObject.optString("Status").contains("always") && com.onetrust.otpublishers.headless.Internal.c.q(str2)) {
                textView.setVisibility(8);
                textView2.setVisibility(8);
            }
            if (this.B.optBoolean("IsIabEnabled", false) && jSONObject.optBoolean("IsIabPurpose", false) && com.onetrust.otpublishers.headless.Internal.c.t(this.C.f23642j) && com.onetrust.otpublishers.headless.UI.Helper.l.u(jSONObject)) {
                j(bVar.f23011b, 0, null);
            }
            k(bVar.f23011b, this.A.f22847o.f22787a);
            if (this.G) {
                TextView textView3 = bVar.f23011b;
                textView3.setPaintFlags(textView3.getPaintFlags() | 8);
            }
        } catch (JSONException e10) {
            com.onetrust.otpublishers.headless.Internal.Helper.p.a(e10, new StringBuilder("error while rendering purpose items in Vendor detail screen "), "OneTrust", 6);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public final RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i10) {
        return new b(LayoutInflater.from(viewGroup.getContext()).inflate(p6.e.f32891y, viewGroup, false));
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x016c  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:75:0x01c0 -> B:78:0x01fb). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void p(@androidx.annotation.NonNull com.onetrust.otpublishers.headless.UI.adapter.j.b r10, @androidx.annotation.NonNull org.json.JSONObject r11, boolean r12) {
        /*
            Method dump skipped, instruction units count: 508
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onetrust.otpublishers.headless.UI.adapter.j.p(com.onetrust.otpublishers.headless.UI.adapter.j$b, org.json.JSONObject, boolean):void");
    }

    public final void q(@NonNull String str, @NonNull String str2, boolean z10, boolean z11) throws JSONException {
        int purposeLegitInterestLocal;
        com.onetrust.otpublishers.headless.Internal.Preferences.h hVar;
        boolean z12 = true;
        if (z10) {
            int length = this.f22996l.length();
            int i10 = 0;
            for (int i11 = 0; i11 < this.f22996l.length(); i11++) {
                OTPublishersHeadlessSDK oTPublishersHeadlessSDK = this.f23001q;
                JSONObject jSONObject = this.f22996l.getJSONObject(i11);
                if (!z11) {
                    purposeLegitInterestLocal = oTPublishersHeadlessSDK.getPurposeConsentLocal(jSONObject.optString("CustomGroupId", ""));
                } else if (oTPublishersHeadlessSDK.getPurposeLegitInterestLocal(jSONObject.optString("CustomGroupId", "")) >= 0) {
                    purposeLegitInterestLocal = this.f23001q.getPurposeLegitInterestLocal(this.f22996l.getJSONObject(i11).optString("CustomGroupId", ""));
                } else {
                    length--;
                }
                i10 += purposeLegitInterestLocal;
            }
            if (z11) {
                if (i10 == length) {
                    ((com.onetrust.otpublishers.headless.UI.fragment.i0) this.f23003s).H(str, true, true);
                }
            } else if (this.f22996l.length() == i10) {
                ((com.onetrust.otpublishers.headless.UI.fragment.i0) this.f23003s).H(str, true, false);
            }
        } else {
            ((com.onetrust.otpublishers.headless.UI.fragment.i0) this.f23003s).H(str, false, z11);
        }
        Context context = this.f23002r;
        new JSONObject();
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0);
        if (com.onetrust.otpublishers.headless.Internal.Helper.h.a(Boolean.FALSE, com.onetrust.otpublishers.headless.Internal.Helper.c0.a(context, "OTT_DEFAULT_USER"), "OT_ENABLE_MULTI_PROFILE")) {
            hVar = new com.onetrust.otpublishers.headless.Internal.Preferences.h(context, sharedPreferences, sharedPreferences.getString("OT_ACTIVE_PROFILE_ID", ""));
        } else {
            hVar = null;
            z12 = false;
        }
        if (z12) {
            sharedPreferences = hVar;
        }
        SharedPreferences sharedPreferences2 = context.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0);
        if (com.onetrust.otpublishers.headless.Internal.Helper.l.a(context)) {
            new com.onetrust.otpublishers.headless.Internal.Preferences.h(context, sharedPreferences2, sharedPreferences2.getString("OT_ACTIVE_PROFILE_ID", ""));
        }
        String string = sharedPreferences.getString("OTT_INTERNAL_SDK_GROUP_MAP", "");
        JSONArray jSONArray = new JSONArray();
        if (!com.onetrust.otpublishers.headless.Internal.c.q(string)) {
            try {
                JSONObject jSONObject2 = new JSONObject(string);
                if (jSONObject2.has(str2)) {
                    jSONArray = new JSONArray(jSONObject2.get(str2).toString());
                }
            } catch (JSONException e10) {
                com.onetrust.otpublishers.headless.Internal.Helper.p.a(e10, new StringBuilder("Error while fetching Sdks by group : "), "SdkListHelper", 6);
            }
        }
        OTLogger.a("OTPCDetailsAdapter", 4, "SDK Ids of  : " + str2 + " is " + jSONArray);
        for (int i12 = 0; i12 < jSONArray.length(); i12++) {
            try {
                this.f23001q.updateSDKConsentStatus(jSONArray.get(i12).toString(), z10);
            } catch (JSONException e11) {
                com.onetrust.otpublishers.headless.Internal.Helper.p.a(e11, new StringBuilder("Error in setting group sdk status "), "OneTrust", 6);
            }
        }
    }

    @RequiresApi(api = 17)
    public final void v(@NonNull TextView textView, com.onetrust.otpublishers.headless.UI.UIProperty.c cVar) {
        Typeface otTypeFaceMap;
        textView.setTextColor(Color.parseColor(cVar.f22722c));
        com.onetrust.otpublishers.headless.UI.UIProperty.l lVar = cVar.f22720a;
        OTConfiguration oTConfiguration = this.f22993i;
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
        if (com.onetrust.otpublishers.headless.Internal.c.q(cVar.f22721b)) {
            return;
        }
        textView.setTextAlignment(Integer.parseInt(cVar.f22721b));
    }

    public final void w(@NonNull final b bVar, final int i10, @NonNull final JSONObject jSONObject) {
        bVar.f23019j.setOnClickListener(new View.OnClickListener() { // from class: com.onetrust.otpublishers.headless.UI.adapter.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f22971a.i(i10, bVar, view);
            }
        });
        bVar.f23021l.setOnClickListener(new View.OnClickListener() { // from class: com.onetrust.otpublishers.headless.UI.adapter.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f22976a.u(i10, bVar, view);
            }
        });
        bVar.f23011b.setOnClickListener(new View.OnClickListener() { // from class: com.onetrust.otpublishers.headless.UI.adapter.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f22981a.s(jSONObject, view);
            }
        });
    }

    public final void x(@NonNull b bVar, @NonNull JSONObject jSONObject) {
        Context context;
        SwitchCompat switchCompat;
        Context context2;
        SwitchCompat switchCompat2;
        if (this.f23006v) {
            bVar.f23019j.setChecked(this.f23001q.getPurposeConsentLocal(jSONObject.optString("CustomGroupId", "")) == 1);
            if (this.f23001q.getPurposeConsentLocal(jSONObject.optString("CustomGroupId", "")) == 1) {
                context2 = this.f23002r;
                switchCompat2 = bVar.f23019j;
                com.onetrust.otpublishers.headless.UI.Helper.l.k(context2, switchCompat2, this.D, this.E);
            } else {
                context = this.f23002r;
                switchCompat = bVar.f23019j;
                com.onetrust.otpublishers.headless.UI.Helper.l.k(context, switchCompat, this.D, this.F);
            }
        }
        bVar.f23021l.setChecked(this.f23001q.getPurposeConsentLocal(jSONObject.optString("CustomGroupId", "")) == 1);
        if (this.f23001q.getPurposeConsentLocal(jSONObject.optString("CustomGroupId", "")) == 1) {
            context2 = this.f23002r;
            switchCompat2 = bVar.f23021l;
            com.onetrust.otpublishers.headless.UI.Helper.l.k(context2, switchCompat2, this.D, this.E);
        } else {
            context = this.f23002r;
            switchCompat = bVar.f23021l;
            com.onetrust.otpublishers.headless.UI.Helper.l.k(context, switchCompat, this.D, this.F);
        }
    }

    public final void z(@NonNull final b bVar, final JSONObject jSONObject) {
        bVar.f23019j.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.onetrust.otpublishers.headless.UI.adapter.e
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
                this.f22948a.y(jSONObject, bVar, compoundButton, z10);
            }
        });
        bVar.f23021l.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.onetrust.otpublishers.headless.UI.adapter.f
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
                this.f22954a.A(jSONObject, bVar, compoundButton, z10);
            }
        });
    }
}
