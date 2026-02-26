package com.onetrust.otpublishers.headless.UI.fragment;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.SwitchCompat;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.os.BundleKt;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import com.onetrust.otpublishers.headless.Public.DataModel.OTConfiguration;
import com.onetrust.otpublishers.headless.Public.Keys.OTFragmentTags;
import com.onetrust.otpublishers.headless.Public.OTPublishersHeadlessSDK;
import com.onetrust.otpublishers.headless.Public.OTThemeConstants;
import com.onetrust.otpublishers.headless.UI.adapter.j;
import com.onetrust.otpublishers.headless.UI.fragment.m2;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class i0 extends com.google.android.material.bottomsheet.b implements View.OnClickListener, j.a, com.onetrust.otpublishers.headless.UI.a, com.onetrust.otpublishers.headless.UI.adapter.t {
    public TextView A;
    public TextView B;
    public com.google.android.material.bottomsheet.a C;
    public com.onetrust.otpublishers.headless.UI.adapter.j D;
    public Context E;
    public OTPublishersHeadlessSDK F;
    public com.onetrust.otpublishers.headless.UI.a G;
    public SwitchCompat H;
    public SwitchCompat I;
    public SwitchCompat J;
    public SwitchCompat K;
    public SwitchCompat L;
    public SwitchCompat M;
    public RecyclerView N;
    public RelativeLayout O;
    public RelativeLayout P;
    public String Q;
    public String R;
    public String S;
    public FrameLayout T;
    public int U;
    public ImageView V;
    public TextView W;
    public m2 X;
    public c1 Y;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public boolean f23326a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f23327b;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public boolean f23328b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f23329c;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public boolean f23330c0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f23331d;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public boolean f23332d0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public TextView f23333e;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public JSONObject f23334e0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public TextView f23335f;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public JSONObject f23336f0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public TextView f23337g;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public String f23338g0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public TextView f23339h;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public com.onetrust.otpublishers.headless.UI.Helper.l f23340h0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public TextView f23341i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public TextView f23343j;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public String f23344j0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public TextView f23345k;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public com.onetrust.otpublishers.headless.UI.UIProperty.w f23346k0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public TextView f23347l;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    public OTConfiguration f23348l0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public TextView f23349m;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public com.onetrust.otpublishers.headless.UI.UIProperty.v f23350m0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public TextView f23351n;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public com.onetrust.otpublishers.headless.UI.mobiledatautils.d f23352n0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public TextView f23353o;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public com.onetrust.otpublishers.headless.UI.mobiledatautils.e f23354o0;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public TextView f23355p;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public String f23356p0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public TextView f23357q;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public JSONObject f23358q0;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public TextView f23359r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public TextView f23360s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public TextView f23361t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public TextView f23362u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public TextView f23363v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public TextView f23364w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public TextView f23365x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public TextView f23366y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public TextView f23367z;
    public com.onetrust.otpublishers.headless.Internal.Event.a Z = new com.onetrust.otpublishers.headless.Internal.Event.a();

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public final HashMap f23342i0 = new HashMap();

    /* JADX INFO: Access modifiers changed from: private */
    public void B(DialogInterface dialogInterface) {
        JSONObject jSONObject;
        this.C = (com.google.android.material.bottomsheet.a) dialogInterface;
        com.onetrust.otpublishers.headless.UI.Helper.l lVar = this.f23340h0;
        FragmentActivity activity = getActivity();
        com.google.android.material.bottomsheet.a aVar = this.C;
        lVar.getClass();
        com.onetrust.otpublishers.headless.UI.Helper.l.r(activity, aVar);
        this.C.setCancelable(false);
        com.google.android.material.bottomsheet.a aVar2 = this.C;
        if (aVar2 != null && (jSONObject = this.f23334e0) != null) {
            this.f23340h0.getClass();
            String strOptString = jSONObject.optString("GroupNameMobile");
            if (com.onetrust.otpublishers.headless.Internal.c.q(strOptString)) {
                strOptString = jSONObject.optString("GroupName");
            }
            aVar2.setTitle(strOptString);
        }
        this.C.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.onetrust.otpublishers.headless.UI.fragment.h0
            @Override // android.content.DialogInterface.OnKeyListener
            public final boolean onKey(DialogInterface dialogInterface2, int i10, KeyEvent keyEvent) {
                return this.f23307a.I(dialogInterface2, i10, keyEvent);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E(String str, View view) {
        try {
            G(str, this.H.isChecked(), this.H);
            SwitchCompat switchCompat = this.H;
            JSONArray jSONArrayOptJSONArray = this.f23334e0.optJSONArray("FirstPartyCookies");
            if (!com.onetrust.otpublishers.headless.Internal.a.c(jSONArrayOptJSONArray) && jSONArrayOptJSONArray.length() > 0) {
                F(str, switchCompat.isChecked());
            }
            K(this.H, false);
        } catch (JSONException e10) {
            com.onetrust.otpublishers.headless.Internal.Helper.p.a(e10, new StringBuilder("Error in setting subgroup consent parent for parentGroupConsentToggle "), "OneTrust", 6);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean I(DialogInterface dialogInterface, int i10, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i10 != 4) {
            return false;
        }
        dismiss();
        com.onetrust.otpublishers.headless.UI.a aVar = this.G;
        if (aVar == null) {
            return false;
        }
        aVar.a(4);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L(String str, View view) {
        try {
            G(str, this.M.isChecked(), this.M);
            SwitchCompat switchCompat = this.M;
            JSONArray jSONArrayOptJSONArray = this.f23334e0.optJSONArray("FirstPartyCookies");
            if (!com.onetrust.otpublishers.headless.Internal.a.c(jSONArrayOptJSONArray) && jSONArrayOptJSONArray.length() > 0) {
                F(str, switchCompat.isChecked());
            }
            K(this.M, false);
        } catch (JSONException e10) {
            com.onetrust.otpublishers.headless.Internal.Helper.p.a(e10, new StringBuilder("Error in setting subgroup consent parent for parentGroupConsentToggleNonIab "), "OneTrust", 6);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N(String str, View view) {
        try {
            boolean zIsChecked = this.I.isChecked();
            SwitchCompat switchCompat = this.I;
            this.F.updatePurposeLegitInterest(str, zIsChecked);
            com.onetrust.otpublishers.headless.Internal.Event.b bVar = new com.onetrust.otpublishers.headless.Internal.Event.b(11);
            bVar.f21746b = str;
            bVar.f21747c = zIsChecked ? 1 : 0;
            com.onetrust.otpublishers.headless.UI.Helper.l lVar = this.f23340h0;
            com.onetrust.otpublishers.headless.Internal.Event.a aVar = this.Z;
            lVar.getClass();
            com.onetrust.otpublishers.headless.UI.Helper.l.s(bVar, aVar);
            D(switchCompat, zIsChecked);
            K(this.I, true);
        } catch (JSONException e10) {
            com.onetrust.otpublishers.headless.Internal.Helper.p.a(e10, new StringBuilder("Error in setting subgroup consent parent for parentGroupLegitIntToggle "), "OneTrust", 6);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void P(String str, View view) {
        G(str, this.J.isChecked(), this.J);
        F(str, this.J.isChecked());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void R(String str, View view) {
        G(str, this.L.isChecked(), this.L);
        F(str, this.L.isChecked());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T(String str, View view) {
        boolean zIsChecked = this.K.isChecked();
        SwitchCompat switchCompat = this.K;
        this.F.updatePurposeLegitInterest(str, zIsChecked);
        com.onetrust.otpublishers.headless.Internal.Event.b bVar = new com.onetrust.otpublishers.headless.Internal.Event.b(11);
        bVar.f21746b = str;
        bVar.f21747c = zIsChecked ? 1 : 0;
        com.onetrust.otpublishers.headless.UI.Helper.l lVar = this.f23340h0;
        com.onetrust.otpublishers.headless.Internal.Event.a aVar = this.Z;
        lVar.getClass();
        com.onetrust.otpublishers.headless.UI.Helper.l.s(bVar, aVar);
        D(switchCompat, zIsChecked);
    }

    @RequiresApi(api = 17)
    public final void C(@NonNull TextView textView, com.onetrust.otpublishers.headless.UI.UIProperty.c cVar) {
        Typeface otTypeFaceMap;
        textView.setText(cVar.f22724e);
        textView.setTextColor(Color.parseColor(cVar.f22722c));
        com.onetrust.otpublishers.headless.UI.UIProperty.l lVar = cVar.f22720a;
        OTConfiguration oTConfiguration = this.f23348l0;
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

    public final void D(@NonNull SwitchCompat switchCompat, boolean z10) {
        com.onetrust.otpublishers.headless.UI.Helper.l lVar;
        Context context;
        String str;
        String str2;
        if (z10) {
            lVar = this.f23340h0;
            context = this.E;
            com.onetrust.otpublishers.headless.UI.UIProperty.w wVar = this.f23354o0.f23644l;
            str = wVar.f22837e;
            str2 = wVar.f22835c;
        } else {
            lVar = this.f23340h0;
            context = this.E;
            com.onetrust.otpublishers.headless.UI.UIProperty.w wVar2 = this.f23354o0.f23644l;
            str = wVar2.f22837e;
            str2 = wVar2.f22836d;
        }
        lVar.getClass();
        com.onetrust.otpublishers.headless.UI.Helper.l.k(context, switchCompat, str, str2);
    }

    public final void F(@NonNull String str, boolean z10) {
        com.onetrust.otpublishers.headless.Internal.Preferences.h hVar;
        boolean z11;
        Context context = this.E;
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
            try {
                this.F.updateSDKConsentStatus(jSONArray.get(i10).toString(), z10);
            } catch (JSONException e11) {
                com.onetrust.otpublishers.headless.Internal.Helper.p.a(e11, new StringBuilder("Error while Updating consent of SDK "), "OTPCDetail", 6);
            }
        }
    }

    public final void G(String str, boolean z10, SwitchCompat switchCompat) {
        OTLogger.a("OTPCDetail", 3, "Updating consent of parent :" + z10);
        this.F.updatePurposeConsent(str, z10);
        com.onetrust.otpublishers.headless.Internal.Event.b bVar = new com.onetrust.otpublishers.headless.Internal.Event.b(7);
        bVar.f21746b = str;
        bVar.f21747c = z10 ? 1 : 0;
        com.onetrust.otpublishers.headless.UI.Helper.l lVar = this.f23340h0;
        com.onetrust.otpublishers.headless.Internal.Event.a aVar = this.Z;
        lVar.getClass();
        com.onetrust.otpublishers.headless.UI.Helper.l.s(bVar, aVar);
        D(switchCompat, z10);
    }

    public final void H(String str, boolean z10, boolean z11) {
        SwitchCompat switchCompat;
        if (z11) {
            this.I.setChecked(z10);
            this.F.updatePurposeLegitInterest(str, z10);
            switchCompat = this.I;
        } else if (this.f23327b) {
            this.H.setChecked(z10);
            this.F.updatePurposeConsent(str, z10);
            switchCompat = this.H;
        } else {
            this.M.setChecked(z10);
            this.F.updatePurposeConsent(str, z10);
            switchCompat = this.M;
        }
        D(switchCompat, z10);
    }

    /* JADX WARN: Removed duplicated region for block: B:110:0x02d8  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x032d  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x033f  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01cf A[PHI: r0
      0x01cf: PHI (r0v108 java.lang.String) = (r0v105 java.lang.String), (r0v115 java.lang.String) binds: [B:67:0x01cd, B:62:0x01ae] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01df  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01f8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void J() throws org.json.JSONException {
        /*
            Method dump skipped, instruction units count: 910
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onetrust.otpublishers.headless.UI.fragment.i0.J():void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v5, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r0v7, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r11v0 */
    /* JADX WARN: Type inference failed for: r11v1 */
    /* JADX WARN: Type inference failed for: r11v10 */
    /* JADX WARN: Type inference failed for: r11v12 */
    /* JADX WARN: Type inference failed for: r11v2 */
    /* JADX WARN: Type inference failed for: r11v9 */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r6v2 */
    public final void K(SwitchCompat switchCompat, boolean z10) throws JSONException {
        JSONArray jSONArray;
        ?? r11;
        com.onetrust.otpublishers.headless.Internal.Preferences.h hVar;
        boolean z11;
        if (this.f23334e0.has("SubGroups")) {
            com.onetrust.otpublishers.headless.UI.mobiledatautils.e eVar = this.f23354o0;
            JSONArray jSONArray2 = this.f23334e0.getJSONArray("SubGroups");
            boolean zIsChecked = switchCompat.isChecked();
            OTPublishersHeadlessSDK oTPublishersHeadlessSDK = this.F;
            eVar.getClass();
            ?? r62 = 0;
            int i10 = 0;
            while (i10 < jSONArray2.length()) {
                ?? jSONObject = jSONArray2.getJSONObject(i10);
                boolean zOptBoolean = jSONObject.optBoolean("HasConsentOptOut", r62);
                String string = jSONObject.getString("CustomGroupId");
                if (z10) {
                    jSONArray = jSONArray2;
                    r11 = r62;
                    if (oTPublishersHeadlessSDK.getPurposeLegitInterestLocal(string) >= 0) {
                        oTPublishersHeadlessSDK.updatePurposeLegitInterest(string, zIsChecked);
                    }
                } else if (zOptBoolean) {
                    oTPublishersHeadlessSDK.updatePurposeConsent(string, zIsChecked);
                    ?? r02 = eVar.f23647o;
                    new JSONObject();
                    SharedPreferences sharedPreferences = r02.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", r62);
                    SharedPreferences sharedPreferences2 = r02.getSharedPreferences("com.onetrust.otpublishers.headless.preference".concat("OTT_DEFAULT_USER"), r62);
                    Boolean bool = Boolean.FALSE;
                    if (com.onetrust.otpublishers.headless.Internal.Helper.h.a(bool, sharedPreferences2, "OT_ENABLE_MULTI_PROFILE")) {
                        jSONArray = jSONArray2;
                        hVar = new com.onetrust.otpublishers.headless.Internal.Preferences.h(r02, sharedPreferences, sharedPreferences.getString("OT_ACTIVE_PROFILE_ID", ""));
                        z11 = true;
                    } else {
                        jSONArray = jSONArray2;
                        hVar = null;
                        z11 = false;
                    }
                    if (z11) {
                        sharedPreferences = hVar;
                    }
                    SharedPreferences sharedPreferences3 = r02.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0);
                    if (com.onetrust.otpublishers.headless.Internal.Helper.h.a(bool, com.onetrust.otpublishers.headless.Internal.Helper.c0.a(r02, "OTT_DEFAULT_USER"), "OT_ENABLE_MULTI_PROFILE")) {
                        r11 = 0;
                        new com.onetrust.otpublishers.headless.Internal.Preferences.d(sharedPreferences3, r02.getSharedPreferences("com.onetrust.otpublishers.headless.preference.OTT_USER_" + new com.onetrust.otpublishers.headless.Internal.profile.d(r02).n(sharedPreferences3.getString("OT_ACTIVE_PROFILE_ID", "")), 0));
                    } else {
                        r11 = 0;
                    }
                    String string2 = sharedPreferences.getString("OTT_INTERNAL_SDK_GROUP_MAP", "");
                    JSONArray jSONArray3 = new JSONArray();
                    if (!com.onetrust.otpublishers.headless.Internal.c.q(string2)) {
                        try {
                            JSONObject jSONObject2 = new JSONObject(string2);
                            if (jSONObject2.has(string)) {
                                jSONArray3 = new JSONArray(jSONObject2.get(string).toString());
                            }
                        } catch (JSONException e10) {
                            com.onetrust.otpublishers.headless.Internal.Helper.p.a(e10, new StringBuilder("Error while fetching Sdks by group : "), "SdkListHelper", 6);
                        }
                    }
                    OTLogger.a("PC Detail", 4, "SDKs of group : " + string + " is " + jSONArray3);
                    for (int i11 = r11 == true ? 1 : 0; i11 < jSONArray3.length(); i11++) {
                        try {
                            eVar.f23646n.updateSDKConsentStatus(jSONArray3.get(i11).toString(), zIsChecked);
                        } catch (JSONException e11) {
                            com.onetrust.otpublishers.headless.Internal.Helper.p.a(e11, new StringBuilder("Error in setting group sdk status "), "OneTrust", 6);
                        }
                    }
                } else {
                    jSONArray = jSONArray2;
                    r11 = r62;
                }
                i10++;
                r62 = r11;
                jSONArray2 = jSONArray;
            }
            this.D.notifyDataSetChanged();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:112:0x03bb A[PHI: r11
      0x03bb: PHI (r11v5 android.widget.TextView) = (r11v1 android.widget.TextView), (r11v6 android.widget.TextView) binds: [B:110:0x03b8, B:96:0x0387] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:140:0x045f  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x047d  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x048c  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0491  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x055b  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x063f  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0305  */
    @androidx.annotation.RequiresApi(api = 17)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void M() throws org.json.JSONException {
        /*
            Method dump skipped, instruction units count: 1815
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onetrust.otpublishers.headless.UI.fragment.i0.M():void");
    }

    public final void O() {
        String str = this.f23354o0.f23636d;
        boolean z10 = this.F.getPurposeConsentLocal(str) == 1;
        if (!this.f23327b) {
            this.M.setChecked(z10);
            D(this.M, z10);
            this.L.setChecked(z10);
            D(this.L, z10);
            return;
        }
        boolean z11 = this.F.getPurposeLegitInterestLocal(str) == 1;
        this.H.setChecked(z10);
        this.I.setChecked(z11);
        D(this.H, z10);
        D(this.I, z11);
        this.J.setChecked(z10);
        D(this.J, z10);
        this.K.setChecked(z11);
        D(this.K, z11);
    }

    public final void Q() {
        final String str = this.f23354o0.f23636d;
        this.H.setOnClickListener(new View.OnClickListener() { // from class: com.onetrust.otpublishers.headless.UI.fragment.a0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f23210a.E(str, view);
            }
        });
        this.M.setOnClickListener(new View.OnClickListener() { // from class: com.onetrust.otpublishers.headless.UI.fragment.b0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f23247a.L(str, view);
            }
        });
        this.I.setOnClickListener(new View.OnClickListener() { // from class: com.onetrust.otpublishers.headless.UI.fragment.c0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f23251a.N(str, view);
            }
        });
        this.J.setOnClickListener(new View.OnClickListener() { // from class: com.onetrust.otpublishers.headless.UI.fragment.d0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f23285a.P(str, view);
            }
        });
        this.L.setOnClickListener(new View.OnClickListener() { // from class: com.onetrust.otpublishers.headless.UI.fragment.e0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f23291a.R(str, view);
            }
        });
        S();
    }

    public final void S() {
        com.onetrust.otpublishers.headless.UI.Helper.l lVar;
        Context context;
        SwitchCompat switchCompat;
        String str;
        String str2;
        final String str3 = this.f23354o0.f23636d;
        this.K.setChecked(this.F.getPurposeLegitInterestLocal(str3) == 1);
        if (this.F.getPurposeLegitInterestLocal(str3) == 1) {
            lVar = this.f23340h0;
            context = this.E;
            switchCompat = this.K;
            com.onetrust.otpublishers.headless.UI.UIProperty.w wVar = this.f23354o0.f23644l;
            str = wVar.f22837e;
            str2 = wVar.f22835c;
        } else {
            lVar = this.f23340h0;
            context = this.E;
            switchCompat = this.K;
            com.onetrust.otpublishers.headless.UI.UIProperty.w wVar2 = this.f23354o0.f23644l;
            str = wVar2.f22837e;
            str2 = wVar2.f22836d;
        }
        lVar.getClass();
        com.onetrust.otpublishers.headless.UI.Helper.l.k(context, switchCompat, str, str2);
        this.K.setOnClickListener(new View.OnClickListener() { // from class: com.onetrust.otpublishers.headless.UI.fragment.g0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f23302a.T(str3, view);
            }
        });
    }

    public final void U() {
        com.onetrust.otpublishers.headless.UI.UIProperty.w wVar = this.f23346k0;
        String str = wVar.f22842j.f22724e;
        String str2 = wVar.f22843k.f22724e;
        this.H.setContentDescription(str);
        this.J.setContentDescription(str);
        this.L.setContentDescription(str);
        this.M.setContentDescription(str);
        this.K.setContentDescription(str2);
        this.I.setContentDescription(str2);
    }

    public final void V() {
        TextView textView;
        if (!this.f23332d0 || this.S == null || !com.onetrust.otpublishers.headless.UI.mobiledatautils.e.g(this.f23334e0)) {
            this.f23362u.setVisibility(8);
            this.f23363v.setVisibility(8);
            this.f23366y.setVisibility(8);
        } else {
            if (this.S.equals("bottom")) {
                this.f23367z.setVisibility(0);
                this.f23362u.setVisibility(8);
                textView = this.f23363v;
                textView.setVisibility(8);
            }
            if (!this.S.equals("top")) {
                return;
            }
            this.f23362u.setVisibility(0);
            this.f23363v.setVisibility(0);
            this.f23366y.setVisibility(8);
        }
        textView = this.f23367z;
        textView.setVisibility(8);
    }

    @Override // com.onetrust.otpublishers.headless.UI.adapter.t
    public final void a() {
        O();
        com.onetrust.otpublishers.headless.UI.adapter.j jVar = this.D;
        if (jVar != null) {
            jVar.notifyDataSetChanged();
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int id = view.getId();
        if (id == p6.d.Q) {
            dismiss();
            com.onetrust.otpublishers.headless.UI.a aVar = this.G;
            if (aVar != null) {
                aVar.a(4);
                return;
            }
            return;
        }
        boolean z10 = true;
        if (id == p6.d.f32646a7 || id == p6.d.f32655b7 || id == p6.d.f32664c7 || id == p6.d.f32673d7) {
            if (this.X.isAdded() || getActivity() == null) {
                return;
            }
            try {
                if (this.f23334e0.optBoolean("IsIabPurpose") || !com.onetrust.otpublishers.headless.UI.mobiledatautils.e.d(this.f23334e0)) {
                    z10 = false;
                }
                Bundle bundleA = z10 ? this.f23354o0.a(this.f23342i0) : this.f23354o0.e(this.f23342i0);
                bundleA.putBoolean("generalVendors", z10);
                this.X.setArguments(bundleA);
                m2 m2Var = this.X;
                m2Var.f23433g = this;
                com.onetrust.otpublishers.headless.UI.mobiledatautils.c.j(m2Var, requireActivity(), OTFragmentTags.OT_VENDOR_LIST_FRAGMENT_TAG);
                com.onetrust.otpublishers.headless.UI.Helper.l lVar = this.f23340h0;
                com.onetrust.otpublishers.headless.Internal.Event.b bVar = new com.onetrust.otpublishers.headless.Internal.Event.b(12);
                com.onetrust.otpublishers.headless.Internal.Event.a aVar2 = this.Z;
                lVar.getClass();
                com.onetrust.otpublishers.headless.UI.Helper.l.s(bVar, aVar2);
                return;
            } catch (JSONException e10) {
                com.onetrust.otpublishers.headless.Internal.Helper.x.a("error thrown onClick: Vendor list link ", e10, "OTPCDetail", 6);
                return;
            }
        }
        if (id != p6.d.f32763n7) {
            if (!(id == p6.d.f32772o7 || id == p6.d.f32781p7 || id == p6.d.f32799r7 || id == p6.d.f32790q7)) {
                if (id != p6.d.C4 && id != p6.d.D4 && id != p6.d.E4 && id != p6.d.F4) {
                    z10 = false;
                }
                if (!z10) {
                    if (id == p6.d.f32754m7) {
                        OTConfiguration oTConfiguration = this.f23348l0;
                        JSONObject jSONObject = this.f23334e0;
                        z zVar = new z();
                        Bundle bundle = new Bundle();
                        bundle.putString(TypedValues.Custom.S_STRING, OTFragmentTags.OT_IAB_ILLUSTRATION_DETAILS_TAG);
                        zVar.setArguments(bundle);
                        zVar.f23594m = oTConfiguration;
                        zVar.f23598q = jSONObject;
                        zVar.f23589h = this.F;
                        if (zVar.isAdded()) {
                            return;
                        }
                        com.onetrust.otpublishers.headless.UI.mobiledatautils.c.j(zVar, requireActivity(), OTFragmentTags.OT_IAB_ILLUSTRATION_DETAILS_TAG);
                        return;
                    }
                    return;
                }
                if (this.Y.isAdded() || getActivity() == null) {
                    return;
                }
                Bundle bundle2 = new Bundle();
                try {
                    ArrayList arrayList = new ArrayList();
                    JSONObject jSONObject2 = this.f23334e0;
                    if (!jSONObject2.optBoolean("ShowSubgroup", false) || jSONObject2.getJSONArray("FirstPartyCookies").length() > 0) {
                        arrayList.add(jSONObject2.getString("CustomGroupId"));
                    }
                    if (this.f23334e0.has("SubGroups") && this.f23334e0.optBoolean("ShowSubgroup", false)) {
                        JSONArray jSONArray = this.f23334e0.getJSONArray("SubGroups");
                        for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                            JSONObject jSONObject3 = jSONArray.getJSONObject(i10);
                            if (!jSONObject3.optBoolean("ShowSubgroup", false) || jSONObject3.getJSONArray("FirstPartyCookies").length() > 0) {
                                arrayList.add(jSONObject3.getString("CustomGroupId"));
                            }
                        }
                    }
                    bundle2.putString("OT_GROUP_ID_LIST", arrayList.toString());
                    bundle2.putString("GroupName", this.f23334e0.getString("GroupName"));
                    bundle2.putString("CustomGroupId", this.f23334e0.getString("CustomGroupId"));
                    bundle2.putString("sdkLevelOptOutShow", this.f23356p0);
                    bundle2.putString("SDK_LIST_VIEW_TITLE", this.f23346k0.f22845m.f22787a.f22724e);
                    bundle2.putString("ALWAYS_ACTIVE_TEXT", this.f23346k0.f22844l.f22724e);
                    bundle2.putString("ALWAYS_ACTIVE_TEXT_COLOR", this.f23346k0.f22844l.f22722c);
                } catch (JSONException e11) {
                    com.onetrust.otpublishers.headless.Internal.Helper.p.a(e11, new StringBuilder("error in passing sdklist : "), "OTPCDetail", 6);
                }
                this.Y.setArguments(bundle2);
                com.onetrust.otpublishers.headless.UI.mobiledatautils.c.j(this.Y, requireActivity(), OTFragmentTags.OT_SDK_LIST_FRAGMENT_TAG);
                return;
            }
        }
        com.onetrust.otpublishers.headless.Internal.c.e(this.E, this.f23354o0.f23640h);
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public final void onConfigurationChanged(@NonNull Configuration configuration) {
        super.onConfigurationChanged(configuration);
        com.onetrust.otpublishers.headless.UI.Helper.l lVar = this.f23340h0;
        FragmentActivity activity = getActivity();
        com.google.android.material.bottomsheet.a aVar = this.C;
        lVar.getClass();
        com.onetrust.otpublishers.headless.UI.Helper.l.r(activity, aVar);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setRetainInstance(true);
        Context applicationContext = getContext().getApplicationContext();
        if (applicationContext != null && this.F == null) {
            this.F = new OTPublishersHeadlessSDK(applicationContext);
        }
        FragmentActivity activity = getActivity();
        if (com.onetrust.otpublishers.headless.UI.mobiledatautils.c.i(activity, OTFragmentTags.OT_PREFERENCE_CENTER_DETAILS_FRAGMENT_TAG)) {
            SharedPreferences sharedPreferencesA = a.a("com.onetrust.otpublishers.headless.preference", "OT_SDK_APP_CONFIGURATION", activity, 0);
            String str = OTThemeConstants.NO_SDK_THEME_OVERRIDE;
            String string = sharedPreferencesA.getString("OT_UX_SDK_THEME", OTThemeConstants.NO_SDK_THEME_OVERRIDE);
            if (com.onetrust.otpublishers.headless.Internal.c.q(string)) {
                string = OTThemeConstants.NO_SDK_THEME_OVERRIDE;
            }
            if (!string.equals(OTThemeConstants.OT_SDK_UI_THEME)) {
                String string2 = a.a("com.onetrust.otpublishers.headless.preference", "OT_SDK_APP_CONFIGURATION", activity, 0).getString("OT_UX_SDK_THEME", OTThemeConstants.NO_SDK_THEME_OVERRIDE);
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
        dialogOnCreateDialog.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.onetrust.otpublishers.headless.UI.fragment.f0
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                this.f23297a.B(dialogInterface);
            }
        });
        return dialogOnCreateDialog;
    }

    @Override // androidx.fragment.app.Fragment
    @RequiresApi(api = 17)
    public final View onCreateView(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String string;
        JSONObject jSONObject;
        this.E = getContext();
        m2.a aVar = m2.f23426o;
        com.onetrust.otpublishers.headless.Internal.Event.a aVar2 = this.Z;
        OTConfiguration oTConfiguration = this.f23348l0;
        aVar.getClass();
        m2 m2VarA = m2.a.a(aVar2, oTConfiguration);
        this.X = m2VarA;
        m2VarA.u(this.F);
        OTConfiguration oTConfiguration2 = this.f23348l0;
        kotlin.jvm.internal.t.i(OTFragmentTags.OT_SDK_LIST_FRAGMENT_TAG, "fragmentTag");
        boolean z10 = false;
        Bundle bundleBundleOf = BundleKt.bundleOf(v8.y.a(OTFragmentTags.FRAGMENT_TAG, OTFragmentTags.OT_SDK_LIST_FRAGMENT_TAG));
        c1 c1Var = new c1();
        c1Var.setArguments(bundleBundleOf);
        c1Var.f23257e = oTConfiguration2;
        this.Y = c1Var;
        kotlin.jvm.internal.t.i(this, "listener");
        c1Var.f23259g = this;
        c1 c1Var2 = this.Y;
        OTPublishersHeadlessSDK otPublishersHeadlessSDK = this.F;
        c1Var2.getClass();
        kotlin.jvm.internal.t.i(otPublishersHeadlessSDK, "otPublishersHeadlessSDK");
        c1Var2.f23256d = otPublishersHeadlessSDK;
        this.f23340h0 = new com.onetrust.otpublishers.headless.UI.Helper.l();
        Bundle arguments = getArguments();
        this.f23354o0 = new com.onetrust.otpublishers.headless.UI.mobiledatautils.e();
        if (arguments != null) {
            string = arguments.getString("SUBGROUP_ARRAY");
            this.U = arguments.getInt("PARENT_POSITION");
            this.f23356p0 = arguments.getString("sdkLevelOptOutShow");
        } else {
            string = "";
        }
        int iA = com.onetrust.otpublishers.headless.UI.Helper.l.a(this.E, this.f23348l0);
        com.onetrust.otpublishers.headless.UI.mobiledatautils.e eVar = this.f23354o0;
        Context context = this.E;
        OTPublishersHeadlessSDK oTPublishersHeadlessSDK = this.F;
        eVar.getClass();
        if (!com.onetrust.otpublishers.headless.Internal.c.q(string)) {
            try {
                JSONObject jSONObject2 = new JSONObject(string);
                eVar.f23633a = jSONObject2;
                eVar.f23637e = jSONObject2.optBoolean("ShowSubgroup", false);
                eVar.f23638f = eVar.f23633a.optBoolean("ShowSubgroupToggle", false);
                eVar.f23639g = eVar.f23633a.optBoolean("ShowSubGroupDescription", false);
                eVar.f23634b = eVar.f23633a.optString("Type", "");
                eVar.f23635c = eVar.f23633a.optString("Type").equalsIgnoreCase("IAB2_STACK") || eVar.f23633a.optString("Type").equalsIgnoreCase("IAB2V2_STACK");
                eVar.f23636d = eVar.f23633a.optString("CustomGroupId");
                com.onetrust.otpublishers.headless.UI.UIProperty.b0 b0Var = new com.onetrust.otpublishers.headless.UI.UIProperty.b0(context, iA);
                eVar.f23644l = b0Var.d();
                eVar.f23645m = b0Var.f22714a.d();
                JSONObject preferenceCenterData = oTPublishersHeadlessSDK.getPreferenceCenterData();
                if (preferenceCenterData != null) {
                    eVar.f23640h = preferenceCenterData.optString("IabLegalTextUrl");
                    eVar.f23641i = preferenceCenterData.optBoolean("IsIabEnabled");
                    eVar.f23642j = preferenceCenterData.optString("IabType");
                    eVar.f23646n = oTPublishersHeadlessSDK;
                    eVar.f23647o = context;
                    eVar.f23643k = preferenceCenterData.optString("PCGrpDescType", "");
                    com.onetrust.otpublishers.headless.UI.UIProperty.c cVar = eVar.f23644l.f22844l;
                    if (com.onetrust.otpublishers.headless.Internal.c.q(cVar.f22724e)) {
                        cVar.f22724e = preferenceCenterData.optString("AlwaysActiveText", "");
                    }
                    if (com.onetrust.otpublishers.headless.Internal.c.q(cVar.f22722c)) {
                        String str = cVar.f22722c;
                        String strOptString = preferenceCenterData.optString("PcLinksTextColor");
                        if (com.onetrust.otpublishers.headless.Internal.c.q(str)) {
                            str = !com.onetrust.otpublishers.headless.Internal.c.q(strOptString) ? strOptString : "#3860BE";
                        }
                        cVar.f22722c = str;
                    }
                    com.onetrust.otpublishers.headless.UI.UIProperty.w wVar = eVar.f23644l;
                    wVar.f22844l = cVar;
                    if (com.onetrust.otpublishers.headless.Internal.c.q(wVar.f22838f)) {
                        eVar.f23644l.f22838f = preferenceCenterData.getString("PcTextColor");
                    }
                    if (com.onetrust.otpublishers.headless.Internal.c.q(eVar.f23644l.f22833a)) {
                        eVar.f23644l.f22833a = preferenceCenterData.getString("PcBackgroundColor");
                    }
                    if (com.onetrust.otpublishers.headless.Internal.c.q(eVar.f23644l.f22837e)) {
                        eVar.f23644l.f22837e = "#d1d1d1";
                    }
                    if (com.onetrust.otpublishers.headless.Internal.c.q(eVar.f23644l.f22835c)) {
                        eVar.f23644l.f22835c = "#67B54B";
                    }
                    if (com.onetrust.otpublishers.headless.Internal.c.q(eVar.f23644l.f22836d)) {
                        eVar.f23644l.f22836d = "#788381";
                    }
                    com.onetrust.otpublishers.headless.UI.UIProperty.c cVar2 = eVar.f23644l.f22839g;
                    JSONObject jSONObject3 = eVar.f23633a;
                    String strOptString2 = jSONObject3.optString("GroupNameMobile");
                    if (com.onetrust.otpublishers.headless.Internal.c.q(strOptString2)) {
                        strOptString2 = jSONObject3.optString("GroupName");
                    }
                    cVar2.f22724e = strOptString2;
                    if (com.onetrust.otpublishers.headless.Internal.c.q(cVar2.f22722c)) {
                        cVar2.f22722c = preferenceCenterData.optString("PcTextColor");
                    }
                    com.onetrust.otpublishers.headless.UI.UIProperty.c cVar3 = eVar.f23644l.f22840h;
                    JSONObject jSONObject4 = eVar.f23633a;
                    String strOptString3 = jSONObject4.optString("GroupNameMobile");
                    if (com.onetrust.otpublishers.headless.Internal.c.q(strOptString3)) {
                        strOptString3 = jSONObject4.optString("GroupName");
                    }
                    cVar3.f22724e = strOptString3;
                    if (com.onetrust.otpublishers.headless.Internal.c.q(cVar3.f22722c)) {
                        cVar3.f22722c = preferenceCenterData.optString("PcTextColor");
                    }
                    com.onetrust.otpublishers.headless.UI.UIProperty.c cVar4 = eVar.f23644l.f22842j;
                    String strOptString4 = preferenceCenterData.optString("BConsentText");
                    if (com.onetrust.otpublishers.headless.Internal.c.q(cVar4.f22722c)) {
                        cVar4.f22722c = preferenceCenterData.optString("PcTextColor");
                    }
                    cVar4.f22724e = strOptString4;
                    com.onetrust.otpublishers.headless.UI.UIProperty.c cVar5 = eVar.f23644l.f22843k;
                    String strOptString5 = preferenceCenterData.optString("BLegitInterestText");
                    if (com.onetrust.otpublishers.headless.Internal.c.q(cVar5.f22722c)) {
                        cVar5.f22722c = preferenceCenterData.optString("PcTextColor");
                    }
                    cVar5.f22724e = strOptString5;
                    com.onetrust.otpublishers.headless.UI.mobiledatautils.e.c(eVar.f23644l.f22845m, preferenceCenterData.optString("ThirdPartyCookieListText", "First Party Cookies"), preferenceCenterData);
                    com.onetrust.otpublishers.headless.UI.mobiledatautils.e.c(eVar.f23644l.f22846n, preferenceCenterData.getString("VendorListText"), preferenceCenterData);
                    com.onetrust.otpublishers.headless.UI.mobiledatautils.e.c(eVar.f23644l.f22847o, preferenceCenterData.optString("PCVendorFullLegalText", ""), preferenceCenterData);
                    eVar.f23644l.f22848p.f22786a = preferenceCenterData.optString("PCenterBackText");
                    eVar.f23644l.f22847o.f22790d = preferenceCenterData.optString("PCPrivacyLinkActionAriaLabel");
                }
            } catch (JSONException e10) {
                com.onetrust.otpublishers.headless.Internal.Helper.x.a("No Data found to initialize PC Detail Config, ", e10, "PC Detail", 6);
            }
        }
        this.f23334e0 = this.f23354o0.f23633a;
        com.onetrust.otpublishers.headless.Internal.Preferences.h hVar = null;
        if (this.f23352n0 == null) {
            com.onetrust.otpublishers.headless.UI.mobiledatautils.d dVar = new com.onetrust.otpublishers.headless.UI.mobiledatautils.d();
            this.f23352n0 = dVar;
            if (!dVar.l(iA, this.E, this.F)) {
                dismiss();
                return null;
            }
        }
        com.onetrust.otpublishers.headless.UI.mobiledatautils.d dVar2 = this.f23352n0;
        if (dVar2 != null) {
            this.f23326a0 = dVar2.f23621o;
        }
        com.onetrust.otpublishers.headless.UI.mobiledatautils.e eVar2 = this.f23354o0;
        this.f23346k0 = eVar2.f23644l;
        this.f23350m0 = eVar2.f23645m;
        Context context2 = this.E;
        SharedPreferences sharedPreferences = context2.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0);
        if (com.onetrust.otpublishers.headless.Internal.Helper.l.a(context2)) {
            z10 = true;
            hVar = new com.onetrust.otpublishers.headless.Internal.Preferences.h(context2, sharedPreferences, sharedPreferences.getString("OT_ACTIVE_PROFILE_ID", ""));
        }
        if (z10) {
            sharedPreferences = hVar;
        }
        String string2 = sharedPreferences.getString("OT_VENDOR_COUNT_FOR_CATEGORIES", "");
        OTLogger.a("IAB2V2Flow", 3, "Getting vendorCountForCategoryString = " + string2);
        if (com.onetrust.otpublishers.headless.Internal.c.q(string2)) {
            jSONObject = new JSONObject();
        } else {
            try {
                jSONObject = new JSONObject(string2);
            } catch (JSONException e11) {
                com.onetrust.otpublishers.headless.Internal.Helper.p.a(e11, new StringBuilder("Error on getting vendor count for categories : "), "OTSPUtils", 6);
                jSONObject = new JSONObject();
            }
        }
        this.f23358q0 = jSONObject;
        com.onetrust.otpublishers.headless.UI.Helper.l lVar = this.f23340h0;
        Context context3 = this.E;
        int i10 = p6.e.f32890x;
        lVar.getClass();
        View viewC = com.onetrust.otpublishers.headless.UI.Helper.l.c(context3, layoutInflater, viewGroup, i10);
        this.P = (RelativeLayout) viewC.findViewById(p6.d.K2);
        this.f23329c = (TextView) viewC.findViewById(p6.d.Y3);
        this.f23339h = (TextView) viewC.findViewById(p6.d.W3);
        this.f23337g = (TextView) viewC.findViewById(p6.d.f32662c5);
        this.f23341i = (TextView) viewC.findViewById(p6.d.f32653b5);
        this.T = (FrameLayout) viewC.findViewById(p6.d.T1);
        this.O = (RelativeLayout) viewC.findViewById(p6.d.f32661c4);
        this.f23333e = (TextView) viewC.findViewById(p6.d.C5);
        this.f23335f = (TextView) viewC.findViewById(p6.d.U5);
        this.H = (SwitchCompat) viewC.findViewById(p6.d.V3);
        this.J = (SwitchCompat) viewC.findViewById(p6.d.Y0);
        this.K = (SwitchCompat) viewC.findViewById(p6.d.f32830v2);
        this.V = (ImageView) viewC.findViewById(p6.d.Q);
        this.f23343j = (TextView) viewC.findViewById(p6.d.f32646a7);
        this.f23347l = (TextView) viewC.findViewById(p6.d.f32763n7);
        this.f23331d = (TextView) viewC.findViewById(p6.d.Z3);
        this.f23345k = (TextView) viewC.findViewById(p6.d.f32643a4);
        this.I = (SwitchCompat) viewC.findViewById(p6.d.X3);
        this.L = (SwitchCompat) viewC.findViewById(p6.d.Z0);
        this.M = (SwitchCompat) viewC.findViewById(p6.d.U3);
        this.N = (RecyclerView) viewC.findViewById(p6.d.f32787q4);
        this.f23351n = (TextView) viewC.findViewById(p6.d.H);
        this.f23349m = (TextView) viewC.findViewById(p6.d.I);
        this.A = (TextView) viewC.findViewById(p6.d.K);
        this.f23353o = (TextView) viewC.findViewById(p6.d.f32655b7);
        this.f23355p = (TextView) viewC.findViewById(p6.d.f32772o7);
        this.f23359r = (TextView) viewC.findViewById(p6.d.f32664c7);
        this.f23360s = (TextView) viewC.findViewById(p6.d.f32781p7);
        this.f23361t = (TextView) viewC.findViewById(p6.d.f32790q7);
        this.f23362u = (TextView) viewC.findViewById(p6.d.C4);
        this.f23363v = (TextView) viewC.findViewById(p6.d.D4);
        this.f23366y = (TextView) viewC.findViewById(p6.d.F4);
        this.f23367z = (TextView) viewC.findViewById(p6.d.E4);
        this.f23364w = (TextView) viewC.findViewById(p6.d.f32673d7);
        this.f23365x = (TextView) viewC.findViewById(p6.d.f32799r7);
        this.B = (TextView) viewC.findViewById(p6.d.T3);
        this.W = (TextView) viewC.findViewById(p6.d.f32808s7);
        this.f23357q = (TextView) viewC.findViewById(p6.d.f32754m7);
        this.N.setHasFixedSize(true);
        this.N.setLayoutManager(new LinearLayoutManager(getActivity()));
        this.V.setOnClickListener(this);
        this.f23343j.setOnClickListener(this);
        this.f23347l.setOnClickListener(this);
        this.f23355p.setOnClickListener(this);
        this.f23357q.setOnClickListener(this);
        this.f23353o.setOnClickListener(this);
        this.f23359r.setOnClickListener(this);
        this.f23360s.setOnClickListener(this);
        this.f23364w.setOnClickListener(this);
        this.f23365x.setOnClickListener(this);
        this.f23361t.setOnClickListener(this);
        this.f23362u.setOnClickListener(this);
        this.f23363v.setOnClickListener(this);
        this.f23366y.setOnClickListener(this);
        this.f23367z.setOnClickListener(this);
        com.onetrust.otpublishers.headless.UI.mobiledatautils.c.f("OTPCDetail", this.E, viewC);
        try {
            M();
        } catch (JSONException e12) {
            com.onetrust.otpublishers.headless.Internal.Helper.p.a(e12, new StringBuilder("error in populating views with data "), "OneTrust", 6);
        }
        return viewC;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        this.Z = null;
        this.G = null;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        O();
    }

    @Override // com.onetrust.otpublishers.headless.UI.a
    public final void a(int i10) {
        if (i10 == 1) {
            dismiss();
            com.onetrust.otpublishers.headless.UI.a aVar = this.G;
            if (aVar != null) {
                aVar.a(i10);
            }
        }
        if (i10 == 3) {
            m2.a aVar2 = m2.f23426o;
            com.onetrust.otpublishers.headless.Internal.Event.a aVar3 = this.Z;
            OTConfiguration oTConfiguration = this.f23348l0;
            aVar2.getClass();
            m2 m2VarA = m2.a.a(aVar3, oTConfiguration);
            this.X = m2VarA;
            m2VarA.u(this.F);
        }
    }
}
