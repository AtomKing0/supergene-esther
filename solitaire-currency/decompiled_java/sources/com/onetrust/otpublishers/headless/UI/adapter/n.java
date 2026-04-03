package com.onetrust.otpublishers.headless.UI.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.SwitchCompat;
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
public final class n extends RecyclerView.Adapter<a> implements com.onetrust.otpublishers.headless.UI.a {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final com.onetrust.otpublishers.headless.UI.a f23065i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final OTConfiguration f23066j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final OTPublishersHeadlessSDK f23067k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public JSONArray f23068l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Context f23069m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final com.onetrust.otpublishers.headless.Internal.Event.a f23070n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public com.onetrust.otpublishers.headless.UI.fragment.i0 f23071o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public com.onetrust.otpublishers.headless.UI.UIProperty.x f23072p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f23073q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public String f23074r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public String f23075s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final com.onetrust.otpublishers.headless.UI.mobiledatautils.d f23076t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final com.onetrust.otpublishers.headless.UI.Helper.l f23077u = new com.onetrust.otpublishers.headless.UI.Helper.l();

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final JSONObject f23078v;

    public static class a extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final TextView f23079b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final TextView f23080c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final TextView f23081d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final SwitchCompat f23082e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final ImageView f23083f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final View f23084g;

        public a(View view) {
            super(view);
            this.f23079b = (TextView) view.findViewById(p6.d.U1);
            this.f23080c = (TextView) view.findViewById(p6.d.f32659c2);
            this.f23082e = (SwitchCompat) view.findViewById(p6.d.V0);
            this.f23081d = (TextView) view.findViewById(p6.d.H);
            this.f23084g = view.findViewById(p6.d.f32727j7);
            this.f23083f = (ImageView) view.findViewById(p6.d.U4);
        }
    }

    public n(@NonNull Context context, @NonNull com.onetrust.otpublishers.headless.UI.mobiledatautils.d dVar, @NonNull OTPublishersHeadlessSDK oTPublishersHeadlessSDK, @NonNull com.onetrust.otpublishers.headless.Internal.Event.a aVar, @Nullable com.onetrust.otpublishers.headless.UI.a aVar2, @Nullable OTConfiguration oTConfiguration) {
        this.f23076t = dVar;
        this.f23068l = dVar.m();
        this.f23069m = context;
        this.f23067k = oTPublishersHeadlessSDK;
        this.f23070n = aVar;
        this.f23065i = aVar2;
        this.f23072p = dVar.a();
        this.f23066j = oTConfiguration;
        this.f23078v = new com.onetrust.otpublishers.headless.Internal.Preferences.g(context).l();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(int i10, JSONObject jSONObject, View view) {
        if (this.f23071o.isAdded()) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("SUBGROUP_ARRAY", jSONObject.toString());
        if (jSONObject.has("SubGroups")) {
            bundle.putInt("PARENT_POSITION", i10);
        }
        bundle.putString("sdkLevelOptOutShow", this.f23076t.H);
        this.f23071o.setArguments(bundle);
        com.onetrust.otpublishers.headless.UI.mobiledatautils.c.j(this.f23071o, (FragmentActivity) this.f23069m, OTFragmentTags.OT_PREFERENCE_CENTER_DETAILS_FRAGMENT_TAG);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(JSONObject jSONObject, a aVar, CompoundButton compoundButton, boolean z10) {
        try {
            String string = jSONObject.getString("CustomGroupId");
            this.f23067k.updatePurposeConsent(string, z10);
            OTLogger.a("OTPCGroupsAdapter", 3, "updated consent of group : " + string + ":" + this.f23067k.getPurposeConsentLocal(string));
            com.onetrust.otpublishers.headless.Internal.Event.b bVar = new com.onetrust.otpublishers.headless.Internal.Event.b(7);
            bVar.f21746b = string;
            bVar.f21747c = z10 ? 1 : 0;
            com.onetrust.otpublishers.headless.Internal.Event.a aVar2 = this.f23070n;
            if (aVar2 != null) {
                aVar2.a(bVar);
            } else {
                OTLogger.a("OneTrust", 6, "Error on sending UI events, listener set was found to be null.This could be because the activity has been recreated. \n Please set listener to get UI event callbacks.");
            }
            if (z10) {
                com.onetrust.otpublishers.headless.UI.Helper.l.k(this.f23069m, aVar.f23082e, this.f23073q, this.f23074r);
            } else {
                com.onetrust.otpublishers.headless.UI.Helper.l.k(this.f23069m, aVar.f23082e, this.f23073q, this.f23075s);
            }
        } catch (JSONException e10) {
            com.onetrust.otpublishers.headless.Internal.Helper.p.a(e10, new StringBuilder("error while updating parent "), "OneTrust", 6);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(JSONObject jSONObject, a aVar, String str, View view) {
        try {
            if (jSONObject.has("SubGroups")) {
                JSONArray jSONArray = jSONObject.getJSONArray("SubGroups");
                boolean zIsChecked = aVar.f23082e.isChecked();
                for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i10);
                    String string = jSONObject2.getString("CustomGroupId");
                    if (jSONObject2.optBoolean("HasConsentOptOut", false)) {
                        h(string, zIsChecked);
                        this.f23067k.updatePurposeConsent(string, zIsChecked);
                    }
                }
            }
            h(str, aVar.f23082e.isChecked());
        } catch (JSONException e10) {
            com.onetrust.otpublishers.headless.Internal.Helper.p.a(e10, new StringBuilder("error in setting subgroup consent parent "), "OneTrust", 6);
        }
    }

    @RequiresApi(api = 17)
    @SuppressLint({"WrongConstant"})
    public final void e(@NonNull TextView textView, String str, com.onetrust.otpublishers.headless.UI.Helper.c cVar) {
        Typeface otTypeFaceMap;
        textView.setText(str);
        textView.setTextColor(Color.parseColor(cVar.c()));
        if (!com.onetrust.otpublishers.headless.Internal.c.q(cVar.f22154q)) {
            textView.setTextSize(Float.parseFloat(cVar.f22154q));
        }
        com.onetrust.otpublishers.headless.UI.Helper.l.q(textView, cVar.f22153p);
        textView.setVisibility(cVar.f22152o);
        com.onetrust.otpublishers.headless.UI.UIProperty.l lVar = cVar.f22758a;
        OTConfiguration oTConfiguration = this.f23066j;
        String str2 = lVar.f22785d;
        if (!com.onetrust.otpublishers.headless.Internal.c.q(str2) && oTConfiguration != null && (otTypeFaceMap = oTConfiguration.getOtTypeFaceMap(str2)) != null) {
            textView.setTypeface(otTypeFaceMap);
        } else {
            int iA = com.onetrust.otpublishers.headless.UI.UIProperty.l.a(textView, lVar.f22784c);
            textView.setTypeface(!com.onetrust.otpublishers.headless.Internal.c.q(lVar.f22782a) ? Typeface.create(lVar.f22782a, iA) : Typeface.create(textView.getTypeface(), iA));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @RequiresApi(api = 17)
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public final void onBindViewHolder(@NonNull final a aVar, int i10) {
        try {
            final int adapterPosition = aVar.getAdapterPosition();
            final JSONObject jSONObject = this.f23068l.getJSONObject(adapterPosition);
            com.onetrust.otpublishers.headless.UI.UIProperty.x xVar = this.f23072p;
            this.f23073q = xVar.f22853e;
            this.f23074r = xVar.f22851c;
            this.f23075s = xVar.f22852d;
            String str = this.f23076t.f23625s;
            if (!com.onetrust.otpublishers.headless.Internal.c.q(str)) {
                com.onetrust.otpublishers.headless.UI.Helper.l.o(aVar.f23083f, str);
            }
            int i11 = 0;
            boolean zOptBoolean = jSONObject.optBoolean("HasConsentOptOut", false);
            final String string = jSONObject.getString("CustomGroupId");
            com.onetrust.otpublishers.headless.UI.Helper.c cVar = this.f23076t.f23629w;
            e(aVar.f23081d, cVar.a(), cVar);
            com.onetrust.otpublishers.headless.UI.Helper.c cVar2 = this.f23076t.f23630x;
            TextView textView = aVar.f23079b;
            this.f23077u.getClass();
            String strOptString = jSONObject.optString("GroupNameMobile");
            if (com.onetrust.otpublishers.headless.Internal.c.q(strOptString)) {
                strOptString = jSONObject.optString("GroupName");
            }
            e(textView, strOptString, cVar2);
            com.onetrust.otpublishers.headless.UI.Helper.l lVar = this.f23077u;
            Context context = this.f23069m;
            JSONObject jSONObject2 = this.f23078v;
            com.onetrust.otpublishers.headless.UI.mobiledatautils.d dVar = this.f23076t;
            String str2 = dVar.M;
            boolean z10 = dVar.L;
            lVar.getClass();
            String strE = com.onetrust.otpublishers.headless.UI.Helper.l.e(context, jSONObject2, jSONObject, str2, z10);
            if (com.onetrust.otpublishers.headless.Internal.c.q(strE)) {
                aVar.f23080c.setText("");
                aVar.f23080c.setVisibility(8);
            } else {
                aVar.f23080c.setVisibility(0);
                k(aVar.f23080c, strE, this.f23076t.f23631y);
            }
            com.onetrust.otpublishers.headless.UI.mobiledatautils.c.g(this.f23076t.f23626t, aVar.f23084g);
            if (aVar.getAdapterPosition() == 0) {
                OTLogger.a("OT_Automation", 3, "setLineBreakColor PC List: " + this.f23076t.f23626t);
            }
            g(aVar, adapterPosition, zOptBoolean);
            aVar.f23082e.setOnCheckedChangeListener(null);
            aVar.f23082e.setOnClickListener(null);
            aVar.f23082e.setContentDescription(this.f23076t.I);
            aVar.f23079b.setLabelFor(p6.d.V0);
            boolean z11 = true;
            aVar.f23082e.setChecked(this.f23067k.getPurposeConsentLocal(string) == 1);
            if (this.f23067k.getPurposeConsentLocal(string) == 1) {
                com.onetrust.otpublishers.headless.UI.Helper.l.k(this.f23069m, aVar.f23082e, this.f23073q, this.f23074r);
            } else {
                com.onetrust.otpublishers.headless.UI.Helper.l.k(this.f23069m, aVar.f23082e, this.f23073q, this.f23075s);
            }
            aVar.f23082e.setOnClickListener(new View.OnClickListener() { // from class: com.onetrust.otpublishers.headless.UI.adapter.k
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f23032a.j(jSONObject, aVar, string, view);
                }
            });
            aVar.f23082e.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.onetrust.otpublishers.headless.UI.adapter.l
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z12) {
                    this.f23036a.i(jSONObject, aVar, compoundButton, z12);
                }
            });
            com.onetrust.otpublishers.headless.Internal.Event.a aVar2 = this.f23070n;
            OTConfiguration oTConfiguration = this.f23066j;
            com.onetrust.otpublishers.headless.UI.mobiledatautils.d dVar2 = this.f23076t;
            com.onetrust.otpublishers.headless.UI.fragment.i0 i0Var = new com.onetrust.otpublishers.headless.UI.fragment.i0();
            Bundle bundle = new Bundle();
            bundle.putString(OTFragmentTags.FRAGMENT_TAG, OTFragmentTags.OT_PREFERENCE_CENTER_DETAILS_FRAGMENT_TAG);
            i0Var.setArguments(bundle);
            i0Var.Z = aVar2;
            i0Var.f23348l0 = oTConfiguration;
            i0Var.f23352n0 = dVar2;
            this.f23071o = i0Var;
            i0Var.G = this;
            i0Var.F = this.f23067k;
            aVar.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.onetrust.otpublishers.headless.UI.adapter.m
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f23054a.d(adapterPosition, jSONObject, view);
                }
            });
            View view = aVar.f23084g;
            if (i10 == this.f23068l.length() - 1) {
                z11 = false;
            }
            if (!z11) {
                i11 = 8;
            }
            view.setVisibility(i11);
        } catch (JSONException e10) {
            com.onetrust.otpublishers.headless.Internal.Helper.p.a(e10, new StringBuilder("error in rendering groups "), "OneTrust", 6);
        }
    }

    public final void g(@NonNull a aVar, int i10, boolean z10) {
        if (this.f23068l.getJSONObject(i10).getString("Status").contains("always")) {
            aVar.f23082e.setVisibility(8);
            aVar.f23081d.setVisibility(0);
            return;
        }
        aVar.f23081d.setVisibility(4);
        if (z10) {
            aVar.f23082e.setVisibility(0);
        } else {
            aVar.f23082e.setVisibility(8);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f23068l.length();
    }

    public final void h(@NonNull String str, boolean z10) {
        com.onetrust.otpublishers.headless.Internal.Preferences.h hVar;
        boolean z11;
        Context context = this.f23069m;
        new JSONObject();
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0);
        if (com.onetrust.otpublishers.headless.Internal.Helper.l.a(context)) {
            hVar = new com.onetrust.otpublishers.headless.Internal.Preferences.h(context, sharedPreferences, sharedPreferences.getString("OT_ACTIVE_PROFILE_ID", ""));
            z11 = true;
        } else {
            hVar = null;
            z11 = false;
        }
        if (z11) {
            sharedPreferences = hVar;
        }
        new com.onetrust.otpublishers.headless.Internal.Preferences.e(context);
        String string = sharedPreferences.getString("OTT_INTERNAL_SDK_GROUP_MAP", "");
        JSONArray jSONArray = new JSONArray();
        if (!com.onetrust.otpublishers.headless.Internal.c.q(string)) {
            try {
                JSONObject jSONObject = new JSONObject(string);
                if (jSONObject.has(str)) {
                    jSONArray = new JSONArray(jSONObject.get(str).toString());
                }
            } catch (JSONException e10) {
                com.onetrust.otpublishers.headless.Internal.Helper.p.a(e10, new StringBuilder("Error while fetching Sdks by group : "), "SdkListHelper", 6);
            }
        }
        for (int i10 = 0; i10 < jSONArray.length(); i10++) {
            this.f23067k.updateSDKConsentStatus(jSONArray.get(i10).toString(), z10);
        }
    }

    @RequiresApi(api = 17)
    @SuppressLint({"WrongConstant"})
    public final void k(@NonNull TextView textView, String str, com.onetrust.otpublishers.headless.UI.Helper.c cVar) {
        Typeface otTypeFaceMap;
        textView.setText(str);
        textView.setTextColor(Color.parseColor(cVar.c()));
        if (!com.onetrust.otpublishers.headless.Internal.c.q(cVar.f22154q)) {
            textView.setTextSize(Float.parseFloat(cVar.f22154q));
        }
        com.onetrust.otpublishers.headless.UI.Helper.l.q(textView, cVar.f22153p);
        com.onetrust.otpublishers.headless.UI.UIProperty.l lVar = cVar.f22758a;
        OTConfiguration oTConfiguration = this.f23066j;
        String str2 = lVar.f22785d;
        if (!com.onetrust.otpublishers.headless.Internal.c.q(str2) && oTConfiguration != null && (otTypeFaceMap = oTConfiguration.getOtTypeFaceMap(str2)) != null) {
            textView.setTypeface(otTypeFaceMap);
        } else {
            int iA = com.onetrust.otpublishers.headless.UI.UIProperty.l.a(textView, lVar.f22784c);
            textView.setTypeface(!com.onetrust.otpublishers.headless.Internal.c.q(lVar.f22782a) ? Typeface.create(lVar.f22782a, iA) : Typeface.create(textView.getTypeface(), iA));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i10) {
        return new a(LayoutInflater.from(viewGroup.getContext()).inflate(p6.e.f32892z, viewGroup, false));
    }

    @Override // com.onetrust.otpublishers.headless.UI.a
    public final void a(int i10) {
        if (i10 == 4) {
            notifyItemRangeChanged(0, this.f23068l.length());
        }
        com.onetrust.otpublishers.headless.UI.a aVar = this.f23065i;
        if (aVar != null) {
            aVar.a(i10);
        }
    }
}
