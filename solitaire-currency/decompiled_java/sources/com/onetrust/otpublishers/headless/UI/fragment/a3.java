package com.onetrust.otpublishers.headless.UI.fragment;

import ab.z;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.appcompat.widget.SwitchCompat;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import com.onetrust.otpublishers.headless.Public.DataModel.OTConfiguration;
import com.onetrust.otpublishers.headless.Public.Keys.OTFragmentTags;
import com.onetrust.otpublishers.headless.Public.OTPublishersHeadlessSDK;
import com.onetrust.otpublishers.headless.Public.OTThemeConstants;
import com.onetrust.otpublishers.headless.Public.OTVendorListMode;
import ga.z;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class a3 extends com.google.android.material.bottomsheet.b implements View.OnClickListener {
    public Context A;
    public OTPublishersHeadlessSDK B;
    public JSONObject C;
    public SwitchCompat D;
    public SwitchCompat E;
    public RecyclerView F;
    public RecyclerView G;
    public RecyclerView H;
    public RecyclerView I;
    public RecyclerView J;
    public RecyclerView K;
    public RecyclerView L;
    public RelativeLayout M;
    public RelativeLayout N;
    public LinearLayout O;
    public LinearLayout P;
    public String Q;
    public b R;
    public View S;
    public View T;
    public String U;
    public String V;
    public String W;
    public String X;
    public String Y;
    public com.onetrust.otpublishers.headless.UI.UIProperty.c0 Z;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public OTConfiguration f23215a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f23216b;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public com.onetrust.otpublishers.headless.UI.UIProperty.v f23217b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f23218c;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public com.onetrust.otpublishers.headless.UI.Helper.l f23219c0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f23220d;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public com.onetrust.otpublishers.headless.Internal.Event.a f23221d0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public TextView f23222e;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public TextView f23223e0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public TextView f23224f;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public com.onetrust.otpublishers.headless.UI.mobiledatautils.d f23225f0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public TextView f23226g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public TextView f23227h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public TextView f23228i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public TextView f23229j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public TextView f23230k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public TextView f23231l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public TextView f23232m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public TextView f23233n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public TextView f23234o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public TextView f23235p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public TextView f23236q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public TextView f23237r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public TextView f23238s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public TextView f23239t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public TextView f23240u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public TextView f23241v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public RecyclerView f23242w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public RelativeLayout f23243x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public com.google.android.material.bottomsheet.a f23244y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public ImageView f23245z;

    public interface a {
        void a(JSONObject jSONObject);
    }

    public interface b {
        void a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void A(DialogInterface dialogInterface) {
        JSONObject jSONObject;
        this.f23244y = (com.google.android.material.bottomsheet.a) dialogInterface;
        com.onetrust.otpublishers.headless.UI.Helper.l lVar = this.f23219c0;
        FragmentActivity activity = getActivity();
        com.google.android.material.bottomsheet.a aVar = this.f23244y;
        lVar.getClass();
        com.onetrust.otpublishers.headless.UI.Helper.l.r(activity, aVar);
        this.f23244y.setCancelable(false);
        com.google.android.material.bottomsheet.a aVar2 = this.f23244y;
        if (aVar2 != null && (jSONObject = this.C) != null) {
            aVar2.setTitle(jSONObject.optString("name"));
        }
        this.f23244y.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.onetrust.otpublishers.headless.UI.fragment.z2
            @Override // android.content.DialogInterface.OnKeyListener
            public final boolean onKey(DialogInterface dialogInterface2, int i10, KeyEvent keyEvent) {
                return this.f23601a.H(dialogInterface2, i10, keyEvent);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B(View view) {
        com.onetrust.otpublishers.headless.Internal.Event.b bVar = new com.onetrust.otpublishers.headless.Internal.Event.b(15);
        bVar.f21746b = this.Q;
        bVar.f21747c = this.D.isChecked() ? 1 : 0;
        com.onetrust.otpublishers.headless.Internal.Event.a aVar = this.f23221d0;
        if (aVar != null) {
            aVar.a(bVar);
        } else {
            OTLogger.a("OneTrust", 6, "Error on sending UI events, listener set was found to be null.This could be because the activity has been recreated. \n Please set listener to get UI event callbacks.");
        }
        bVar.f21749e = OTVendorListMode.IAB;
        com.onetrust.otpublishers.headless.Internal.Event.a aVar2 = this.f23221d0;
        if (aVar2 != null) {
            aVar2.a(bVar);
        } else {
            OTLogger.a("OneTrust", 6, "Error on sending UI events, listener set was found to be null.This could be because the activity has been recreated. \n Please set listener to get UI event callbacks.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void C(CompoundButton compoundButton, boolean z10) {
        Context context;
        SwitchCompat switchCompat;
        String str;
        String str2;
        this.B.updateVendorConsent(OTVendorListMode.IAB, this.Q, z10);
        com.onetrust.otpublishers.headless.UI.Helper.l lVar = this.f23219c0;
        if (z10) {
            context = this.A;
            switchCompat = this.D;
            str = this.Y;
            str2 = this.W;
        } else {
            context = this.A;
            switchCompat = this.D;
            str = this.Y;
            str2 = this.X;
        }
        lVar.getClass();
        com.onetrust.otpublishers.headless.UI.Helper.l.k(context, switchCompat, str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G(JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
        com.onetrust.otpublishers.headless.UI.adapter.l0 l0Var = new com.onetrust.otpublishers.headless.UI.adapter.l0(jSONObject3, this.B, this.Z, jSONObject, this.f23215a0);
        try {
            if (com.onetrust.otpublishers.headless.Internal.a.d(jSONObject3)) {
                this.f23243x.setVisibility(8);
            }
            if (!com.onetrust.otpublishers.headless.Internal.a.d(jSONObject3) && jSONObject3.has("disclosures") && jSONObject3.getJSONArray("disclosures").length() > 0) {
                this.f23243x.setVisibility(0);
                this.f23240u.setVisibility(0);
                this.L.setLayoutManager(new LinearLayoutManager(this.A));
                this.L.setAdapter(l0Var);
            }
            JSONArray jSONArray = new JSONArray();
            if (jSONObject3.has("domains")) {
                jSONArray = jSONObject3.getJSONArray("domains");
            }
            if (com.onetrust.otpublishers.headless.Internal.a.c(jSONArray)) {
                return;
            }
            this.f23243x.setVisibility(0);
            this.f23241v.setVisibility(0);
            this.f23241v.setText(jSONObject2.optString("PCVLSDomainsUsed"));
            com.onetrust.otpublishers.headless.UI.adapter.m0 m0Var = new com.onetrust.otpublishers.headless.UI.adapter.m0(jSONArray, jSONObject2, this.Z, this.f23215a0);
            this.f23242w.setLayoutManager(new LinearLayoutManager(this.A));
            this.f23242w.setAdapter(m0Var);
        } catch (JSONException e10) {
            com.onetrust.otpublishers.headless.Internal.Helper.x.a("showVendorDisclosureDetails: ", e10, "VendorDetail", 6);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean H(DialogInterface dialogInterface, int i10, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i10 != 4) {
            return false;
        }
        dismiss();
        b bVar = this.R;
        if (bVar == null) {
            return false;
        }
        bVar.a();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J(View view) {
        com.onetrust.otpublishers.headless.Internal.Event.b bVar = new com.onetrust.otpublishers.headless.Internal.Event.b(16);
        bVar.f21746b = this.Q;
        bVar.f21747c = this.E.isChecked() ? 1 : 0;
        com.onetrust.otpublishers.headless.Internal.Event.a aVar = this.f23221d0;
        if (aVar != null) {
            aVar.a(bVar);
        } else {
            OTLogger.a("OneTrust", 6, "Error on sending UI events, listener set was found to be null.This could be because the activity has been recreated. \n Please set listener to get UI event callbacks.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void K(CompoundButton compoundButton, boolean z10) {
        Context context;
        SwitchCompat switchCompat;
        String str;
        String str2;
        this.B.updateVendorLegitInterest(OTVendorListMode.IAB, this.Q, z10);
        com.onetrust.otpublishers.headless.UI.Helper.l lVar = this.f23219c0;
        if (z10) {
            context = this.A;
            switchCompat = this.E;
            str = this.Y;
            str2 = this.W;
        } else {
            context = this.A;
            switchCompat = this.E;
            str = this.Y;
            str2 = this.X;
        }
        lVar.getClass();
        com.onetrust.otpublishers.headless.UI.Helper.l.k(context, switchCompat, str, str2);
    }

    public final void D(@NonNull String str, @NonNull String str2, @NonNull String str3, @NonNull String str4, @NonNull String str5, @NonNull String str6) {
        this.f23220d.setTextColor(Color.parseColor(this.V));
        this.f23234o.setTextColor(Color.parseColor(this.V));
        this.f23235p.setTextColor(Color.parseColor(str2));
        this.f23236q.setTextColor(Color.parseColor(str3));
        this.N.setBackgroundColor(Color.parseColor(str));
        this.M.setBackgroundColor(Color.parseColor(str));
        this.P.setBackgroundColor(Color.parseColor(str));
        this.O.setBackgroundColor(Color.parseColor(str));
        this.f23245z.setColorFilter(Color.parseColor(str5), PorterDuff.Mode.SRC_IN);
        this.f23222e.setTextColor(Color.parseColor(str6));
        this.f23224f.setTextColor(Color.parseColor(str6));
        this.f23226g.setTextColor(Color.parseColor(str4));
        this.f23227h.setTextColor(Color.parseColor(str4));
        this.f23228i.setTextColor(Color.parseColor(str4));
        this.f23232m.setTextColor(Color.parseColor(str4));
        this.f23233n.setTextColor(Color.parseColor(str4));
        this.f23231l.setTextColor(Color.parseColor(str4));
        this.f23230k.setTextColor(Color.parseColor(str4));
        this.f23237r.setTextColor(Color.parseColor(str4));
        this.f23239t.setTextColor(Color.parseColor(this.U));
        this.f23229j.setTextColor(Color.parseColor(this.U));
        this.f23238s.setTextColor(Color.parseColor(this.U));
        this.f23240u.setTextColor(Color.parseColor(str4));
        this.f23241v.setTextColor(Color.parseColor(str4));
    }

    public final void E(String str, @NonNull final JSONObject jSONObject, final JSONObject jSONObject2) {
        a aVar = new a() { // from class: com.onetrust.otpublishers.headless.UI.fragment.u2
            @Override // com.onetrust.otpublishers.headless.UI.fragment.a3.a
            public final void a(JSONObject jSONObject3) {
                this.f23538a.G(jSONObject2, jSONObject, jSONObject3);
            }
        };
        new com.onetrust.otpublishers.headless.Internal.Preferences.e(this.A);
        OTLogger.a("NetworkRequestHandler", 3, "IAB Vendor Disclosure API called ");
        ((com.onetrust.otpublishers.headless.Internal.Network.a) new z.b().c("https://geolocation.1trust.app/").a(bb.k.f()).f(new z.a().b()).d().b(com.onetrust.otpublishers.headless.Internal.Network.a.class)).a(str).i0(new com.onetrust.otpublishers.headless.Internal.Network.h(new JSONObject[1], aVar));
    }

    public final void F(@NonNull JSONObject jSONObject, @Nullable JSONObject jSONObject2) {
        if (this.C.getJSONArray("purposes").length() > 0) {
            this.f23226g.setVisibility(0);
            TextView textView = this.f23226g;
            textView.setText(jSONObject.optString("BConsentPurposesText", getString(p6.f.f32905m)));
            ViewCompat.setAccessibilityHeading(textView, true);
            this.F.setVisibility(0);
            this.F.setLayoutManager(new LinearLayoutManager(this.A));
            this.F.setAdapter(new com.onetrust.otpublishers.headless.UI.adapter.j0(this.C.getJSONArray("purposes"), this.U, this.Z, this.f23215a0, (jSONObject2 == null || !jSONObject2.has("purposes")) ? null : jSONObject2.getJSONObject("purposes"), jSONObject.optString("PCenterVendorListLifespanDays", "Days")));
            this.F.setNestedScrollingEnabled(false);
        }
        if (this.C.getJSONArray("legIntPurposes").length() > 0) {
            this.f23230k.setVisibility(0);
            TextView textView2 = this.f23230k;
            textView2.setText(jSONObject.optString("BLegitimateInterestPurposesText", getString(p6.f.f32899g)));
            ViewCompat.setAccessibilityHeading(textView2, true);
            this.H.setVisibility(0);
            this.H.setLayoutManager(new LinearLayoutManager(this.A));
            this.H.setAdapter(new com.onetrust.otpublishers.headless.UI.adapter.j0(this.C.getJSONArray("legIntPurposes"), this.U, this.Z, this.f23215a0, null, null));
            this.H.setNestedScrollingEnabled(false);
        }
        if (this.C.getJSONArray("features").length() > 0) {
            this.f23231l.setVisibility(0);
            TextView textView3 = this.f23231l;
            textView3.setText(jSONObject.optString("BFeaturesText", getString(p6.f.f32904l)));
            ViewCompat.setAccessibilityHeading(textView3, true);
            this.I.setVisibility(0);
            this.I.setLayoutManager(new LinearLayoutManager(this.A));
            this.I.setAdapter(new com.onetrust.otpublishers.headless.UI.adapter.j0(this.C.getJSONArray("features"), this.U, this.Z, this.f23215a0, null, null));
            this.I.setNestedScrollingEnabled(false);
        }
        if (this.C.getJSONArray("specialFeatures").length() > 0) {
            this.f23233n.setVisibility(0);
            TextView textView4 = this.f23233n;
            textView4.setText(jSONObject.optString("BSpecialFeaturesText", getString(p6.f.f32900h)));
            ViewCompat.setAccessibilityHeading(textView4, true);
            this.J.setVisibility(0);
            this.J.setLayoutManager(new LinearLayoutManager(this.A));
            this.J.setAdapter(new com.onetrust.otpublishers.headless.UI.adapter.j0(this.C.getJSONArray("specialFeatures"), this.U, this.Z, this.f23215a0, null, null));
            this.J.setNestedScrollingEnabled(false);
        }
        if (this.C.getJSONArray("specialPurposes").length() > 0) {
            this.f23232m.setVisibility(0);
            TextView textView5 = this.f23232m;
            textView5.setText(jSONObject.optString("BSpecialPurposesText", getString(p6.f.f32901i)));
            ViewCompat.setAccessibilityHeading(textView5, true);
            this.K.setVisibility(0);
            this.K.setLayoutManager(new LinearLayoutManager(this.A));
            this.K.setAdapter(new com.onetrust.otpublishers.headless.UI.adapter.j0(this.C.getJSONArray("specialPurposes"), this.U, this.Z, this.f23215a0, (jSONObject2 == null || !jSONObject2.has("purposes")) ? null : jSONObject2.getJSONObject("specialPurposes"), jSONObject.optString("PCenterVendorListLifespanDays", "Days")));
            this.K.setNestedScrollingEnabled(false);
        }
        if (this.C.getJSONArray("dataDeclaration").length() > 0) {
            this.f23227h.setText(jSONObject.optString("PCVListDataDeclarationText", getString(p6.f.f32902j)));
            this.f23227h.setVisibility(0);
            ViewCompat.setAccessibilityHeading(this.f23227h, true);
            this.G.setVisibility(0);
            this.G.setLayoutManager(new LinearLayoutManager(this.A));
            this.G.setAdapter(new com.onetrust.otpublishers.headless.UI.adapter.j0(this.C.getJSONArray("dataDeclaration"), this.U, this.Z, this.f23215a0, null, null));
            this.G.setNestedScrollingEnabled(false);
        }
    }

    public final void I() {
        com.onetrust.otpublishers.headless.UI.Helper.l.q(this.f23220d, this.Z.f22730e.f22721b);
        com.onetrust.otpublishers.headless.UI.Helper.l.q(this.f23235p, this.Z.f22733h.f22721b);
        com.onetrust.otpublishers.headless.UI.Helper.l.q(this.f23236q, this.Z.f22734i.f22721b);
        String str = this.Z.f22731f.f22721b;
        com.onetrust.otpublishers.headless.UI.Helper.l.q(this.f23226g, str);
        com.onetrust.otpublishers.headless.UI.Helper.l.q(this.f23227h, str);
        com.onetrust.otpublishers.headless.UI.Helper.l.q(this.f23228i, str);
        com.onetrust.otpublishers.headless.UI.Helper.l.q(this.f23231l, str);
        com.onetrust.otpublishers.headless.UI.Helper.l.q(this.f23233n, str);
        com.onetrust.otpublishers.headless.UI.Helper.l.q(this.f23232m, str);
        com.onetrust.otpublishers.headless.UI.Helper.l.q(this.f23230k, str);
        com.onetrust.otpublishers.headless.UI.Helper.l.q(this.f23237r, str);
        com.onetrust.otpublishers.headless.UI.Helper.l.q(this.f23240u, str);
        com.onetrust.otpublishers.headless.UI.Helper.l.q(this.f23241v, str);
        String str2 = this.Z.f22732g.f22721b;
        com.onetrust.otpublishers.headless.UI.Helper.l.q(this.f23238s, str2);
        com.onetrust.otpublishers.headless.UI.Helper.l.q(this.f23239t, str2);
    }

    public final void L(@NonNull JSONObject jSONObject) {
        try {
            int iA = com.onetrust.otpublishers.headless.UI.Helper.l.a(this.A, this.f23215a0);
            com.onetrust.otpublishers.headless.UI.UIProperty.b0 b0Var = new com.onetrust.otpublishers.headless.UI.UIProperty.b0(this.A, iA);
            this.Z = b0Var.f();
            this.f23217b0 = b0Var.f22714a.d();
            a(jSONObject);
            String str = this.Z.f22731f.f22722c;
            String strOptString = jSONObject.optString("PcTextColor");
            String str2 = "#696969";
            String str3 = !com.onetrust.otpublishers.headless.Internal.c.q(str) ? str : !com.onetrust.otpublishers.headless.Internal.c.q(strOptString) ? strOptString : iA == 11 ? "#FFFFFF" : "#696969";
            String str4 = this.Z.f22733h.f22722c;
            String strOptString2 = jSONObject.optString("PcTextColor");
            if (com.onetrust.otpublishers.headless.Internal.c.q(str4)) {
                str4 = !com.onetrust.otpublishers.headless.Internal.c.q(strOptString2) ? strOptString2 : iA == 11 ? "#FFFFFF" : "#696969";
            }
            String str5 = this.Z.f22734i.f22722c;
            String strOptString3 = jSONObject.optString("PcTextColor");
            if (com.onetrust.otpublishers.headless.Internal.c.q(str5)) {
                str5 = !com.onetrust.otpublishers.headless.Internal.c.q(strOptString3) ? strOptString3 : iA == 11 ? "#FFFFFF" : "#696969";
            }
            String str6 = this.Z.f22726a;
            String strOptString4 = jSONObject.optString("PcBackgroundColor");
            if (com.onetrust.otpublishers.headless.Internal.c.q(str6)) {
                str6 = !com.onetrust.otpublishers.headless.Internal.c.q(strOptString4) ? strOptString4 : iA == 11 ? "#2F2F2F" : "#FFFFFF";
            }
            String str7 = this.Z.f22736k;
            String strOptString5 = jSONObject.optString("PcTextColor");
            if (!com.onetrust.otpublishers.headless.Internal.c.q(str7)) {
                str2 = str7;
            } else if (!com.onetrust.otpublishers.headless.Internal.c.q(strOptString5)) {
                str2 = strOptString5;
            } else if (iA == 11) {
                str2 = "#FFFFFF";
            }
            Q();
            com.onetrust.otpublishers.headless.UI.Helper.l lVar = this.f23219c0;
            com.onetrust.otpublishers.headless.UI.UIProperty.c cVar = this.Z.f22735j.f22787a;
            String strOptString6 = jSONObject.optString("PcLinksTextColor");
            lVar.getClass();
            if (!com.onetrust.otpublishers.headless.Internal.c.q(cVar.f22722c)) {
                strOptString6 = cVar.f22722c;
            }
            String str8 = strOptString6;
            com.onetrust.otpublishers.headless.UI.UIProperty.v vVar = this.f23217b0;
            if (vVar == null || vVar.f22831a) {
                TextView textView = this.f23222e;
                textView.setPaintFlags(textView.getPaintFlags() | 8);
                TextView textView2 = this.f23224f;
                textView2.setPaintFlags(textView2.getPaintFlags() | 8);
            }
            a();
            I();
            P();
            D(str6, str4, str5, str3, str2, str8);
        } catch (JSONException e10) {
            com.onetrust.otpublishers.headless.Internal.Helper.p.a(e10, new StringBuilder("Error while applying styles to Vendor details, err : "), "OneTrust", 6);
        }
    }

    public final void M(@Nullable JSONObject jSONObject, @NonNull JSONObject jSONObject2) throws JSONException {
        if (com.onetrust.otpublishers.headless.Internal.c.t(this.f23225f0.M)) {
            this.f23228i.setText(jSONObject2.optString("PCVListDataRetentionText", getString(p6.f.f32903k)));
            this.f23228i.setVisibility(0);
            ViewCompat.setAccessibilityHeading(this.f23228i, true);
            if (jSONObject == null || !jSONObject.has("stdRetention") || com.onetrust.otpublishers.headless.Internal.c.q(jSONObject.getString("stdRetention"))) {
                return;
            }
            String string = jSONObject.getString("stdRetention");
            if (com.onetrust.otpublishers.headless.Internal.c.q(string) || Integer.parseInt(string) < 0) {
                return;
            }
            this.f23229j.setVisibility(0);
            this.f23229j.setText(jSONObject2.optString("PCVListStdRetentionText", getString(p6.f.f32906n)) + " (" + string + " " + jSONObject2.optString("PCenterVendorListLifespanDays") + ")");
        }
    }

    public final void N() {
        this.f23222e.setOnClickListener(this);
        this.f23224f.setOnClickListener(this);
        this.f23245z.setOnClickListener(this);
        this.D.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.onetrust.otpublishers.headless.UI.fragment.v2
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
                this.f23545a.C(compoundButton, z10);
            }
        });
        this.E.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.onetrust.otpublishers.headless.UI.fragment.w2
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
                this.f23573a.K(compoundButton, z10);
            }
        });
        this.D.setOnClickListener(new View.OnClickListener() { // from class: com.onetrust.otpublishers.headless.UI.fragment.x2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f23577a.B(view);
            }
        });
        this.E.setOnClickListener(new View.OnClickListener() { // from class: com.onetrust.otpublishers.headless.UI.fragment.y2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f23582a.J(view);
            }
        });
    }

    public final void O(@NonNull JSONObject jSONObject) throws JSONException {
        com.onetrust.otpublishers.headless.Internal.Preferences.h hVar;
        if (!this.C.has("deviceStorageDisclosureUrl")) {
            this.f23243x.setVisibility(8);
            return;
        }
        this.f23240u.setVisibility(8);
        boolean z10 = true;
        this.f23240u.setText(String.format("%s:", jSONObject.optString("PCenterVendorListDisclosure")));
        String string = this.C.getString("deviceStorageDisclosureUrl");
        Context context = this.A;
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0);
        if (com.onetrust.otpublishers.headless.Internal.Helper.l.a(context)) {
            hVar = new com.onetrust.otpublishers.headless.Internal.Preferences.h(context, sharedPreferences, sharedPreferences.getString("OT_ACTIVE_PROFILE_ID", ""));
        } else {
            z10 = false;
            hVar = null;
        }
        if (z10) {
            sharedPreferences = hVar;
        }
        String string2 = sharedPreferences.getString("OT_IAB_PURPOSES_TRANSLATED", "");
        JSONObject jSONObject2 = new JSONObject();
        if (!com.onetrust.otpublishers.headless.Internal.c.q(string2)) {
            jSONObject2 = new JSONObject(string2);
        }
        JSONObject jSONObject3 = new JSONObject();
        if (jSONObject2.has("purposes")) {
            jSONObject3 = jSONObject2.getJSONObject("purposes");
        }
        E(string, jSONObject, jSONObject3);
    }

    public final void P() {
        com.onetrust.otpublishers.headless.UI.UIProperty.l lVar = this.Z.f22730e.f22720a;
        com.onetrust.otpublishers.headless.UI.Helper.l lVar2 = this.f23219c0;
        TextView textView = this.f23220d;
        OTConfiguration oTConfiguration = this.f23215a0;
        lVar2.getClass();
        com.onetrust.otpublishers.headless.UI.Helper.l.p(textView, lVar, oTConfiguration);
        com.onetrust.otpublishers.headless.UI.UIProperty.l lVar3 = this.Z.f22735j.f22787a.f22720a;
        com.onetrust.otpublishers.headless.UI.Helper.l lVar4 = this.f23219c0;
        TextView textView2 = this.f23222e;
        OTConfiguration oTConfiguration2 = this.f23215a0;
        lVar4.getClass();
        com.onetrust.otpublishers.headless.UI.Helper.l.p(textView2, lVar3, oTConfiguration2);
        com.onetrust.otpublishers.headless.UI.Helper.l lVar5 = this.f23219c0;
        TextView textView3 = this.f23224f;
        OTConfiguration oTConfiguration3 = this.f23215a0;
        lVar5.getClass();
        com.onetrust.otpublishers.headless.UI.Helper.l.p(textView3, lVar3, oTConfiguration3);
        com.onetrust.otpublishers.headless.UI.UIProperty.l lVar6 = this.Z.f22731f.f22720a;
        com.onetrust.otpublishers.headless.UI.Helper.l lVar7 = this.f23219c0;
        TextView textView4 = this.f23226g;
        OTConfiguration oTConfiguration4 = this.f23215a0;
        lVar7.getClass();
        com.onetrust.otpublishers.headless.UI.Helper.l.p(textView4, lVar6, oTConfiguration4);
        com.onetrust.otpublishers.headless.UI.Helper.l lVar8 = this.f23219c0;
        TextView textView5 = this.f23227h;
        OTConfiguration oTConfiguration5 = this.f23215a0;
        lVar8.getClass();
        com.onetrust.otpublishers.headless.UI.Helper.l.p(textView5, lVar6, oTConfiguration5);
        com.onetrust.otpublishers.headless.UI.Helper.l lVar9 = this.f23219c0;
        TextView textView6 = this.f23228i;
        OTConfiguration oTConfiguration6 = this.f23215a0;
        lVar9.getClass();
        com.onetrust.otpublishers.headless.UI.Helper.l.p(textView6, lVar6, oTConfiguration6);
        com.onetrust.otpublishers.headless.UI.Helper.l lVar10 = this.f23219c0;
        TextView textView7 = this.f23230k;
        OTConfiguration oTConfiguration7 = this.f23215a0;
        lVar10.getClass();
        com.onetrust.otpublishers.headless.UI.Helper.l.p(textView7, lVar6, oTConfiguration7);
        com.onetrust.otpublishers.headless.UI.Helper.l lVar11 = this.f23219c0;
        TextView textView8 = this.f23232m;
        OTConfiguration oTConfiguration8 = this.f23215a0;
        lVar11.getClass();
        com.onetrust.otpublishers.headless.UI.Helper.l.p(textView8, lVar6, oTConfiguration8);
        com.onetrust.otpublishers.headless.UI.Helper.l lVar12 = this.f23219c0;
        TextView textView9 = this.f23233n;
        OTConfiguration oTConfiguration9 = this.f23215a0;
        lVar12.getClass();
        com.onetrust.otpublishers.headless.UI.Helper.l.p(textView9, lVar6, oTConfiguration9);
        com.onetrust.otpublishers.headless.UI.Helper.l lVar13 = this.f23219c0;
        TextView textView10 = this.f23231l;
        OTConfiguration oTConfiguration10 = this.f23215a0;
        lVar13.getClass();
        com.onetrust.otpublishers.headless.UI.Helper.l.p(textView10, lVar6, oTConfiguration10);
        com.onetrust.otpublishers.headless.UI.Helper.l lVar14 = this.f23219c0;
        TextView textView11 = this.f23237r;
        OTConfiguration oTConfiguration11 = this.f23215a0;
        lVar14.getClass();
        com.onetrust.otpublishers.headless.UI.Helper.l.p(textView11, lVar6, oTConfiguration11);
        com.onetrust.otpublishers.headless.UI.Helper.l lVar15 = this.f23219c0;
        TextView textView12 = this.f23240u;
        OTConfiguration oTConfiguration12 = this.f23215a0;
        lVar15.getClass();
        com.onetrust.otpublishers.headless.UI.Helper.l.p(textView12, lVar6, oTConfiguration12);
        com.onetrust.otpublishers.headless.UI.Helper.l lVar16 = this.f23219c0;
        TextView textView13 = this.f23241v;
        OTConfiguration oTConfiguration13 = this.f23215a0;
        lVar16.getClass();
        com.onetrust.otpublishers.headless.UI.Helper.l.p(textView13, lVar6, oTConfiguration13);
        com.onetrust.otpublishers.headless.UI.UIProperty.l lVar17 = this.Z.f22732g.f22720a;
        com.onetrust.otpublishers.headless.UI.Helper.l lVar18 = this.f23219c0;
        TextView textView14 = this.f23238s;
        OTConfiguration oTConfiguration14 = this.f23215a0;
        lVar18.getClass();
        com.onetrust.otpublishers.headless.UI.Helper.l.p(textView14, lVar17, oTConfiguration14);
        com.onetrust.otpublishers.headless.UI.Helper.l lVar19 = this.f23219c0;
        TextView textView15 = this.f23239t;
        OTConfiguration oTConfiguration15 = this.f23215a0;
        lVar19.getClass();
        com.onetrust.otpublishers.headless.UI.Helper.l.p(textView15, lVar17, oTConfiguration15);
        com.onetrust.otpublishers.headless.UI.Helper.l lVar20 = this.f23219c0;
        TextView textView16 = this.f23229j;
        OTConfiguration oTConfiguration16 = this.f23215a0;
        lVar20.getClass();
        com.onetrust.otpublishers.headless.UI.Helper.l.p(textView16, lVar17, oTConfiguration16);
        com.onetrust.otpublishers.headless.UI.UIProperty.l lVar21 = this.Z.f22733h.f22720a;
        com.onetrust.otpublishers.headless.UI.Helper.l lVar22 = this.f23219c0;
        TextView textView17 = this.f23235p;
        OTConfiguration oTConfiguration17 = this.f23215a0;
        lVar22.getClass();
        com.onetrust.otpublishers.headless.UI.Helper.l.p(textView17, lVar21, oTConfiguration17);
        com.onetrust.otpublishers.headless.UI.UIProperty.l lVar23 = this.Z.f22734i.f22720a;
        com.onetrust.otpublishers.headless.UI.Helper.l lVar24 = this.f23219c0;
        TextView textView18 = this.f23236q;
        OTConfiguration oTConfiguration18 = this.f23215a0;
        lVar24.getClass();
        com.onetrust.otpublishers.headless.UI.Helper.l.p(textView18, lVar23, oTConfiguration18);
    }

    public final void Q() {
        String str = this.Z.f22728c;
        if (str != null && !com.onetrust.otpublishers.headless.Internal.c.q(str)) {
            this.X = this.Z.f22728c;
        }
        String str2 = this.Z.f22727b;
        if (str2 != null && !com.onetrust.otpublishers.headless.Internal.c.q(str2)) {
            this.W = this.Z.f22727b;
        }
        String str3 = this.Z.f22729d;
        if (str3 == null || com.onetrust.otpublishers.headless.Internal.c.q(str3)) {
            return;
        }
        this.Y = this.Z.f22729d;
    }

    public final void a() {
        if (!com.onetrust.otpublishers.headless.Internal.c.q(this.Z.f22730e.f22720a.f22783b)) {
            this.f23220d.setTextSize(Float.parseFloat(this.Z.f22730e.f22720a.f22783b));
        }
        if (!com.onetrust.otpublishers.headless.Internal.c.q(this.Z.f22733h.f22720a.f22783b)) {
            this.f23235p.setTextSize(Float.parseFloat(this.Z.f22733h.f22720a.f22783b));
        }
        if (!com.onetrust.otpublishers.headless.Internal.c.q(this.Z.f22734i.f22720a.f22783b)) {
            this.f23236q.setTextSize(Float.parseFloat(this.Z.f22734i.f22720a.f22783b));
        }
        String str = this.Z.f22735j.f22787a.f22720a.f22783b;
        if (!com.onetrust.otpublishers.headless.Internal.c.q(str)) {
            this.f23222e.setTextSize(Float.parseFloat(str));
            this.f23224f.setTextSize(Float.parseFloat(str));
        }
        if (!com.onetrust.otpublishers.headless.Internal.c.q(this.Z.f22731f.f22720a.f22783b)) {
            float f10 = Float.parseFloat(this.Z.f22731f.f22720a.f22783b);
            this.f23226g.setTextSize(f10);
            this.f23227h.setTextSize(f10);
            this.f23228i.setTextSize(f10);
            this.f23230k.setTextSize(f10);
            this.f23232m.setTextSize(f10);
            this.f23233n.setTextSize(f10);
            this.f23231l.setTextSize(f10);
            this.f23237r.setTextSize(f10);
            this.f23240u.setTextSize(f10);
            this.f23241v.setTextSize(f10);
        }
        if (com.onetrust.otpublishers.headless.Internal.c.q(this.Z.f22732g.f22720a.f22783b)) {
            return;
        }
        float f11 = Float.parseFloat(this.Z.f22732g.f22720a.f22783b);
        this.f23238s.setTextSize(f11);
        this.f23239t.setTextSize(f11);
        this.f23229j.setTextSize(f11);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Context context;
        String str;
        int id = view.getId();
        if (id == p6.d.U6) {
            dismiss();
            b bVar = this.R;
            if (bVar != null) {
                bVar.a();
                return;
            }
            return;
        }
        if (id == p6.d.f32835w) {
            context = this.A;
            str = this.f23216b;
        } else {
            if (id != p6.d.f32827v) {
                return;
            }
            context = this.A;
            str = this.f23218c;
        }
        com.onetrust.otpublishers.headless.Internal.c.e(context, str);
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public final void onConfigurationChanged(@NonNull Configuration configuration) {
        super.onConfigurationChanged(configuration);
        com.onetrust.otpublishers.headless.UI.Helper.l lVar = this.f23219c0;
        FragmentActivity activity = getActivity();
        com.google.android.material.bottomsheet.a aVar = this.f23244y;
        lVar.getClass();
        com.onetrust.otpublishers.headless.UI.Helper.l.r(activity, aVar);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setRetainInstance(true);
        if (this.B == null && getActivity() != null) {
            this.B = new OTPublishersHeadlessSDK(getActivity());
        }
        FragmentActivity activity = getActivity();
        if (com.onetrust.otpublishers.headless.UI.mobiledatautils.c.i(activity, OTFragmentTags.OT_VENDOR_DETAILS_FRAGMENT_TAG)) {
            SharedPreferences sharedPreferencesA = com.onetrust.otpublishers.headless.UI.fragment.a.a("com.onetrust.otpublishers.headless.preference", "OT_SDK_APP_CONFIGURATION", activity, 0);
            String str = OTThemeConstants.NO_SDK_THEME_OVERRIDE;
            String string = sharedPreferencesA.getString("OT_UX_SDK_THEME", OTThemeConstants.NO_SDK_THEME_OVERRIDE);
            if (com.onetrust.otpublishers.headless.Internal.c.q(string)) {
                string = OTThemeConstants.NO_SDK_THEME_OVERRIDE;
            }
            if (!string.equals(OTThemeConstants.OT_SDK_UI_THEME)) {
                String string2 = com.onetrust.otpublishers.headless.UI.fragment.a.a("com.onetrust.otpublishers.headless.preference", "OT_SDK_APP_CONFIGURATION", activity, 0).getString("OT_UX_SDK_THEME", OTThemeConstants.NO_SDK_THEME_OVERRIDE);
                if (!com.onetrust.otpublishers.headless.Internal.c.q(string2)) {
                    str = string2;
                }
                if (!str.equals(OTThemeConstants.OT_THEME_APP_COMPACT_LIGHT_NO_ACTION_BAR_LANDSCAPE_FULL_SCREEN)) {
                    return;
                }
            }
            OTLogger.a("OneTrust", 3, "set theme to OT defined theme ");
            setStyle(0, p6.g.f32918a);
        }
    }

    @Override // com.google.android.material.bottomsheet.b, androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    @NonNull
    public final Dialog onCreateDialog(Bundle bundle) {
        Dialog dialogOnCreateDialog = super.onCreateDialog(bundle);
        dialogOnCreateDialog.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.onetrust.otpublishers.headless.UI.fragment.t2
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                this.f23533a.A(dialogInterface);
            }
        });
        return dialogOnCreateDialog;
    }

    @Override // androidx.fragment.app.Fragment
    @RequiresApi(api = 17)
    public final View onCreateView(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.A = getContext();
        this.f23225f0 = new com.onetrust.otpublishers.headless.UI.mobiledatautils.d();
        if (!this.f23225f0.l(com.onetrust.otpublishers.headless.UI.Helper.l.a(this.A, this.f23215a0), this.A, this.B)) {
            dismiss();
            return null;
        }
        Context context = this.A;
        int i10 = p6.e.X;
        if (com.onetrust.otpublishers.headless.Internal.c.x(context)) {
            layoutInflater = layoutInflater.cloneInContext(new ContextThemeWrapper(context, p6.g.f32919b));
        }
        View viewInflate = layoutInflater.inflate(i10, viewGroup, false);
        this.f23220d = (TextView) viewInflate.findViewById(p6.d.f32818u);
        this.f23222e = (TextView) viewInflate.findViewById(p6.d.f32835w);
        this.f23224f = (TextView) viewInflate.findViewById(p6.d.f32827v);
        this.M = (RelativeLayout) viewInflate.findViewById(p6.d.V6);
        this.N = (RelativeLayout) viewInflate.findViewById(p6.d.T6);
        this.f23234o = (TextView) viewInflate.findViewById(p6.d.f32782q);
        this.f23245z = (ImageView) viewInflate.findViewById(p6.d.U6);
        int i11 = p6.d.f32692g;
        this.D = (SwitchCompat) viewInflate.findViewById(i11);
        int i12 = p6.d.f32665d;
        this.E = (SwitchCompat) viewInflate.findViewById(i12);
        this.O = (LinearLayout) viewInflate.findViewById(p6.d.N6);
        this.f23235p = (TextView) viewInflate.findViewById(p6.d.f32701h);
        this.f23236q = (TextView) viewInflate.findViewById(p6.d.f32656c);
        this.S = viewInflate.findViewById(p6.d.N2);
        this.T = viewInflate.findViewById(p6.d.X0);
        this.F = (RecyclerView) viewInflate.findViewById(p6.d.Q6);
        this.G = (RecyclerView) viewInflate.findViewById(p6.d.I6);
        this.H = (RecyclerView) viewInflate.findViewById(p6.d.K6);
        this.I = (RecyclerView) viewInflate.findViewById(p6.d.J6);
        this.J = (RecyclerView) viewInflate.findViewById(p6.d.R6);
        this.K = (RecyclerView) viewInflate.findViewById(p6.d.F6);
        this.f23226g = (TextView) viewInflate.findViewById(p6.d.f32791r);
        this.f23227h = (TextView) viewInflate.findViewById(p6.d.f32710i);
        this.f23228i = (TextView) viewInflate.findViewById(p6.d.f32800s);
        this.f23229j = (TextView) viewInflate.findViewById(p6.d.f32809t);
        this.f23230k = (TextView) viewInflate.findViewById(p6.d.f32647b);
        this.f23231l = (TextView) viewInflate.findViewById(p6.d.f32638a);
        this.f23233n = (TextView) viewInflate.findViewById(p6.d.f32674e);
        this.f23232m = (TextView) viewInflate.findViewById(p6.d.f32683f);
        this.f23237r = (TextView) viewInflate.findViewById(p6.d.f32764o);
        this.f23238s = (TextView) viewInflate.findViewById(p6.d.f32773p);
        this.f23239t = (TextView) viewInflate.findViewById(p6.d.f32755n);
        this.f23243x = (RelativeLayout) viewInflate.findViewById(p6.d.f32694g1);
        this.f23240u = (TextView) viewInflate.findViewById(p6.d.f32728k);
        this.L = (RecyclerView) viewInflate.findViewById(p6.d.f32719j);
        this.P = (LinearLayout) viewInflate.findViewById(p6.d.f32814t4);
        this.f23223e0 = (TextView) viewInflate.findViewById(p6.d.f32808s7);
        this.f23241v = (TextView) viewInflate.findViewById(p6.d.f32737l);
        this.f23242w = (RecyclerView) viewInflate.findViewById(p6.d.f32746m);
        com.onetrust.otpublishers.headless.UI.mobiledatautils.c.f("VendorDetail", this.A, viewInflate);
        this.f23219c0 = new com.onetrust.otpublishers.headless.UI.Helper.l();
        N();
        try {
            JSONObject preferenceCenterData = this.B.getPreferenceCenterData();
            L(preferenceCenterData);
            String strOptString = preferenceCenterData.optString("BConsentText");
            this.f23235p.setText(strOptString);
            this.D.setContentDescription(strOptString);
            String strOptString2 = preferenceCenterData.optString("BLegitInterestText");
            this.f23236q.setText(strOptString2);
            this.E.setContentDescription(strOptString2);
            if (preferenceCenterData.has("PCenterViewPrivacyPolicyText")) {
                this.f23222e.setText(preferenceCenterData.getString("PCenterViewPrivacyPolicyText"));
                if (preferenceCenterData.has("PCPrivacyLinkActionAriaLabel")) {
                    com.onetrust.otpublishers.headless.UI.mobiledatautils.c.d(this.f23222e, preferenceCenterData.optString("PCPrivacyLinkActionAriaLabel"));
                }
            }
            if (preferenceCenterData.has("PCIABVendorLegIntClaimText")) {
                this.f23224f.setText(preferenceCenterData.getString("PCIABVendorLegIntClaimText"));
                if (preferenceCenterData.has("PCPrivacyLinkActionAriaLabel")) {
                    com.onetrust.otpublishers.headless.UI.mobiledatautils.c.d(this.f23224f, preferenceCenterData.optString("PCPrivacyLinkActionAriaLabel"));
                }
            }
            if (preferenceCenterData.has("PCenterBackText")) {
                this.f23245z.setContentDescription(preferenceCenterData.optString("PCenterBackText"));
            }
            if (getArguments() != null) {
                String string = getArguments().getString("vendorId");
                this.Q = string;
                JSONObject vendorDetails = this.B.getVendorDetails(OTVendorListMode.IAB, string);
                this.C = vendorDetails;
                if (vendorDetails != null) {
                    String string2 = vendorDetails.getString("name");
                    JSONObject jSONObjectOptJSONObject = this.C.optJSONObject("dataRetention");
                    this.f23220d.setText(string2);
                    ViewCompat.setAccessibilityHeading(this.f23220d, true);
                    if (com.onetrust.otpublishers.headless.UI.mobiledatautils.c.h(this.A)) {
                        com.onetrust.otpublishers.headless.UI.mobiledatautils.c.b(this.A, string2, this.O, i11);
                        com.onetrust.otpublishers.headless.UI.mobiledatautils.c.b(this.A, string2, this.O, i12);
                    }
                    String str = this.f23225f0.M;
                    JSONObject jSONObject = this.C;
                    String strC = com.onetrust.otpublishers.headless.Internal.c.t(str) ? com.onetrust.otpublishers.headless.UI.TVUI.datautils.e.c(preferenceCenterData, jSONObject, false) : jSONObject.optString("policyUrl");
                    this.f23216b = strC;
                    if (com.onetrust.otpublishers.headless.Internal.c.q(strC)) {
                        this.f23222e.setVisibility(8);
                    }
                    String strC2 = com.onetrust.otpublishers.headless.Internal.c.t(this.f23225f0.M) ? com.onetrust.otpublishers.headless.UI.TVUI.datautils.e.c(preferenceCenterData, this.C, true) : "";
                    this.f23218c = strC2;
                    if (!com.onetrust.otpublishers.headless.Internal.c.q(strC2)) {
                        this.f23224f.setVisibility(0);
                    }
                    this.f23237r.setText(String.format("%s:", preferenceCenterData.optString("PCenterVendorListLifespan")));
                    this.f23239t.setText(preferenceCenterData.optString("PCenterVendorListNonCookieUsage"));
                    this.f23238s.setText(com.onetrust.otpublishers.headless.UI.Helper.l.d(this.C.optLong("cookieMaxAgeSeconds"), preferenceCenterData));
                    O(preferenceCenterData);
                    F(preferenceCenterData, jSONObjectOptJSONObject);
                    M(jSONObjectOptJSONObject, preferenceCenterData);
                }
            }
            this.f23225f0.d(this.f23223e0, this.f23215a0);
        } catch (Exception e10) {
            com.onetrust.otpublishers.headless.Internal.Helper.j.a(e10, new StringBuilder("error while populating Vendor Detail fields"), "VendorDetail", 6);
        }
        return viewInflate;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0078 A[Catch: Exception -> 0x008e, TryCatch #0 {Exception -> 0x008e, blocks: (B:5:0x0009, B:8:0x001f, B:14:0x0058, B:15:0x0068, B:17:0x0087, B:16:0x0078, B:9:0x002f, B:11:0x004e, B:10:0x003f), top: B:22:0x0009 }] */
    @Override // androidx.fragment.app.Fragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onResume() {
        /*
            r9 = this;
            super.onResume()
            org.json.JSONObject r0 = r9.C
            if (r0 != 0) goto L9
            goto L9c
        L9:
            java.lang.String r1 = "consent"
            int r0 = r0.getInt(r1)     // Catch: java.lang.Exception -> L8e
            org.json.JSONObject r1 = r9.C     // Catch: java.lang.Exception -> L8e
            java.lang.String r2 = "legIntStatus"
            int r1 = r1.getInt(r2)     // Catch: java.lang.Exception -> L8e
            r2 = 0
            r3 = 1
            r4 = 8
            if (r0 == 0) goto L3f
            if (r0 == r3) goto L2f
            androidx.appcompat.widget.SwitchCompat r0 = r9.D     // Catch: java.lang.Exception -> L8e
            r0.setVisibility(r4)     // Catch: java.lang.Exception -> L8e
            android.widget.TextView r0 = r9.f23235p     // Catch: java.lang.Exception -> L8e
            r0.setVisibility(r4)     // Catch: java.lang.Exception -> L8e
            android.view.View r0 = r9.S     // Catch: java.lang.Exception -> L8e
            r0.setVisibility(r4)     // Catch: java.lang.Exception -> L8e
            goto L54
        L2f:
            androidx.appcompat.widget.SwitchCompat r0 = r9.D     // Catch: java.lang.Exception -> L8e
            r0.setChecked(r3)     // Catch: java.lang.Exception -> L8e
            com.onetrust.otpublishers.headless.UI.Helper.l r0 = r9.f23219c0     // Catch: java.lang.Exception -> L8e
            android.content.Context r5 = r9.A     // Catch: java.lang.Exception -> L8e
            androidx.appcompat.widget.SwitchCompat r6 = r9.D     // Catch: java.lang.Exception -> L8e
            java.lang.String r7 = r9.Y     // Catch: java.lang.Exception -> L8e
            java.lang.String r8 = r9.W     // Catch: java.lang.Exception -> L8e
            goto L4e
        L3f:
            androidx.appcompat.widget.SwitchCompat r0 = r9.D     // Catch: java.lang.Exception -> L8e
            r0.setChecked(r2)     // Catch: java.lang.Exception -> L8e
            com.onetrust.otpublishers.headless.UI.Helper.l r0 = r9.f23219c0     // Catch: java.lang.Exception -> L8e
            android.content.Context r5 = r9.A     // Catch: java.lang.Exception -> L8e
            androidx.appcompat.widget.SwitchCompat r6 = r9.D     // Catch: java.lang.Exception -> L8e
            java.lang.String r7 = r9.Y     // Catch: java.lang.Exception -> L8e
            java.lang.String r8 = r9.X     // Catch: java.lang.Exception -> L8e
        L4e:
            r0.getClass()     // Catch: java.lang.Exception -> L8e
            com.onetrust.otpublishers.headless.UI.Helper.l.k(r5, r6, r7, r8)     // Catch: java.lang.Exception -> L8e
        L54:
            if (r1 == 0) goto L78
            if (r1 == r3) goto L68
            androidx.appcompat.widget.SwitchCompat r0 = r9.E     // Catch: java.lang.Exception -> L8e
            r0.setVisibility(r4)     // Catch: java.lang.Exception -> L8e
            android.widget.TextView r0 = r9.f23236q     // Catch: java.lang.Exception -> L8e
            r0.setVisibility(r4)     // Catch: java.lang.Exception -> L8e
            android.view.View r0 = r9.T     // Catch: java.lang.Exception -> L8e
            r0.setVisibility(r4)     // Catch: java.lang.Exception -> L8e
            goto L9c
        L68:
            androidx.appcompat.widget.SwitchCompat r0 = r9.E     // Catch: java.lang.Exception -> L8e
            r0.setChecked(r3)     // Catch: java.lang.Exception -> L8e
            com.onetrust.otpublishers.headless.UI.Helper.l r0 = r9.f23219c0     // Catch: java.lang.Exception -> L8e
            android.content.Context r1 = r9.A     // Catch: java.lang.Exception -> L8e
            androidx.appcompat.widget.SwitchCompat r2 = r9.E     // Catch: java.lang.Exception -> L8e
            java.lang.String r3 = r9.Y     // Catch: java.lang.Exception -> L8e
            java.lang.String r4 = r9.W     // Catch: java.lang.Exception -> L8e
            goto L87
        L78:
            androidx.appcompat.widget.SwitchCompat r0 = r9.E     // Catch: java.lang.Exception -> L8e
            r0.setChecked(r2)     // Catch: java.lang.Exception -> L8e
            com.onetrust.otpublishers.headless.UI.Helper.l r0 = r9.f23219c0     // Catch: java.lang.Exception -> L8e
            android.content.Context r1 = r9.A     // Catch: java.lang.Exception -> L8e
            androidx.appcompat.widget.SwitchCompat r2 = r9.E     // Catch: java.lang.Exception -> L8e
            java.lang.String r3 = r9.Y     // Catch: java.lang.Exception -> L8e
            java.lang.String r4 = r9.X     // Catch: java.lang.Exception -> L8e
        L87:
            r0.getClass()     // Catch: java.lang.Exception -> L8e
            com.onetrust.otpublishers.headless.UI.Helper.l.k(r1, r2, r3, r4)     // Catch: java.lang.Exception -> L8e
            goto L9c
        L8e:
            r0 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "error while setting toggle values"
            r1.<init>(r2)
            java.lang.String r2 = "VendorDetail"
            r3 = 6
            com.onetrust.otpublishers.headless.Internal.Helper.j.a(r0, r1, r2, r3)
        L9c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onetrust.otpublishers.headless.UI.fragment.a3.onResume():void");
    }

    public final void a(@NonNull JSONObject jSONObject) {
        String strOptString;
        String strOptString2;
        com.onetrust.otpublishers.headless.UI.UIProperty.c cVar = this.Z.f22730e;
        if (!com.onetrust.otpublishers.headless.Internal.c.q(cVar.f22722c)) {
            strOptString = cVar.f22722c;
        } else {
            strOptString = jSONObject.optString("PcTextColor");
        }
        this.V = strOptString;
        com.onetrust.otpublishers.headless.UI.UIProperty.c cVar2 = this.Z.f22732g;
        if (!com.onetrust.otpublishers.headless.Internal.c.q(cVar2.f22722c)) {
            strOptString2 = cVar2.f22722c;
        } else {
            strOptString2 = jSONObject.optString("PcTextColor");
        }
        this.U = strOptString2;
    }
}
