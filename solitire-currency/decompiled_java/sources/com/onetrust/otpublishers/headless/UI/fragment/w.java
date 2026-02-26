package com.onetrust.otpublishers.headless.UI.fragment;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.appcompat.widget.SwitchCompat;
import androidx.core.content.ContextCompat;
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
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class w extends com.google.android.material.bottomsheet.b implements View.OnClickListener {
    public String A;
    public String B;
    public com.onetrust.otpublishers.headless.Internal.Event.a C;
    public com.onetrust.otpublishers.headless.UI.mobiledatautils.d D;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f23546b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f23547c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f23548d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public TextView f23549e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public RecyclerView f23550f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public com.google.android.material.bottomsheet.a f23551g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ImageView f23552h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Context f23553i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public OTPublishersHeadlessSDK f23554j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public JSONObject f23555k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public SwitchCompat f23556l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public RelativeLayout f23557m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public RelativeLayout f23558n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public LinearLayout f23559o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f23560p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public a f23561q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public View f23562r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public String f23563s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public String f23564t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public String f23565u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public String f23566v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public com.onetrust.otpublishers.headless.UI.UIProperty.c0 f23567w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public OTConfiguration f23568x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public com.onetrust.otpublishers.headless.UI.UIProperty.v f23569y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public com.onetrust.otpublishers.headless.UI.Helper.l f23570z;

    public interface a {
        void a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void w(DialogInterface dialogInterface) {
        JSONObject jSONObject;
        this.f23551g = (com.google.android.material.bottomsheet.a) dialogInterface;
        com.onetrust.otpublishers.headless.UI.Helper.l lVar = this.f23570z;
        FragmentActivity activity = getActivity();
        com.google.android.material.bottomsheet.a aVar = this.f23551g;
        lVar.getClass();
        com.onetrust.otpublishers.headless.UI.Helper.l.r(activity, aVar);
        this.f23551g.setCancelable(false);
        com.google.android.material.bottomsheet.a aVar2 = this.f23551g;
        if (aVar2 != null && (jSONObject = this.f23555k) != null) {
            aVar2.setTitle(jSONObject.optString("Name"));
        }
        this.f23551g.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.onetrust.otpublishers.headless.UI.fragment.v
            @Override // android.content.DialogInterface.OnKeyListener
            public final boolean onKey(DialogInterface dialogInterface2, int i10, KeyEvent keyEvent) {
                return this.f23541a.z(dialogInterface2, i10, keyEvent);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(View view) {
        Drawable trackDrawable;
        int color;
        this.f23554j.updateVendorConsent(OTVendorListMode.GENERAL, this.f23560p, this.f23556l.isChecked());
        if (this.f23556l.isChecked()) {
            y(this.f23556l);
        } else {
            SwitchCompat switchCompat = this.f23556l;
            if (this.f23566v != null) {
                trackDrawable = switchCompat.getTrackDrawable();
                color = Color.parseColor(this.f23566v);
            } else {
                trackDrawable = switchCompat.getTrackDrawable();
                color = ContextCompat.getColor(this.f23553i, p6.a.f32627e);
            }
            trackDrawable.setTint(color);
            switchCompat.getThumbDrawable().setTint(this.f23565u != null ? Color.parseColor(this.f23565u) : ContextCompat.getColor(this.f23553i, p6.a.f32625c));
        }
        String strOptString = this.f23555k.optString("VendorCustomId");
        com.onetrust.otpublishers.headless.Internal.Event.b bVar = new com.onetrust.otpublishers.headless.Internal.Event.b(15);
        bVar.f21746b = strOptString;
        bVar.f21747c = this.f23556l.isChecked() ? 1 : 0;
        bVar.f21749e = OTVendorListMode.GENERAL;
        com.onetrust.otpublishers.headless.Internal.Event.a aVar = this.C;
        if (aVar != null) {
            aVar.a(bVar);
        } else {
            OTLogger.a("OneTrust", 6, "Error on sending UI events, listener set was found to be null.This could be because the activity has been recreated. \n Please set listener to get UI event callbacks.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x000c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean z(android.content.DialogInterface r2, int r3, android.view.KeyEvent r4) {
        /*
            r1 = this;
            r2 = 4
            r0 = 0
            if (r3 != r2) goto Lc
            int r2 = r4.getAction()
            r3 = 1
            if (r2 != r3) goto Lc
            goto Ld
        Lc:
            r3 = r0
        Ld:
            if (r3 == 0) goto L17
            r1.dismiss()
            com.onetrust.otpublishers.headless.UI.fragment.w$a r2 = r1.f23561q
            r2.a()
        L17:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onetrust.otpublishers.headless.UI.fragment.w.z(android.content.DialogInterface, int, android.view.KeyEvent):boolean");
    }

    public final void A() {
        this.f23556l.setVisibility(8);
        this.f23549e.setVisibility(8);
        this.f23562r.setVisibility(8);
    }

    public final void B(@NonNull JSONObject jSONObject) {
        try {
            int iA = com.onetrust.otpublishers.headless.UI.Helper.l.a(this.f23553i, this.f23568x);
            com.onetrust.otpublishers.headless.UI.UIProperty.b0 b0Var = new com.onetrust.otpublishers.headless.UI.UIProperty.b0(this.f23553i, iA);
            this.f23567w = b0Var.f();
            this.f23569y = b0Var.f22714a.d();
            com.onetrust.otpublishers.headless.UI.UIProperty.c cVar = this.f23567w.f22730e;
            this.f23563s = !com.onetrust.otpublishers.headless.Internal.c.q(cVar.f22722c) ? cVar.f22722c : jSONObject.optString("PcTextColor");
            String str = this.f23567w.f22732g.f22722c;
            String strOptString = jSONObject.optString("PcTextColor");
            String str2 = "#696969";
            if (com.onetrust.otpublishers.headless.Internal.c.q(str)) {
                str = !com.onetrust.otpublishers.headless.Internal.c.q(strOptString) ? strOptString : iA == 11 ? "#FFFFFF" : "#696969";
            }
            this.A = str;
            String str3 = this.f23567w.f22731f.f22722c;
            String strOptString2 = jSONObject.optString("PcTextColor");
            if (com.onetrust.otpublishers.headless.Internal.c.q(str3)) {
                str3 = !com.onetrust.otpublishers.headless.Internal.c.q(strOptString2) ? strOptString2 : iA == 11 ? "#FFFFFF" : "#696969";
            }
            this.B = str3;
            String str4 = this.f23567w.f22733h.f22722c;
            String strOptString3 = jSONObject.optString("PcTextColor");
            if (com.onetrust.otpublishers.headless.Internal.c.q(str4)) {
                str4 = !com.onetrust.otpublishers.headless.Internal.c.q(strOptString3) ? strOptString3 : iA == 11 ? "#FFFFFF" : "#696969";
            }
            String str5 = this.f23567w.f22726a;
            String strOptString4 = jSONObject.optString("PcBackgroundColor");
            if (com.onetrust.otpublishers.headless.Internal.c.q(str5)) {
                str5 = !com.onetrust.otpublishers.headless.Internal.c.q(strOptString4) ? strOptString4 : iA == 11 ? "#2F2F2F" : "#FFFFFF";
            }
            String str6 = this.f23567w.f22736k;
            String strOptString5 = jSONObject.optString("PcTextColor");
            if (!com.onetrust.otpublishers.headless.Internal.c.q(str6)) {
                str2 = str6;
            } else if (!com.onetrust.otpublishers.headless.Internal.c.q(strOptString5)) {
                str2 = strOptString5;
            } else if (iA == 11) {
                str2 = "#FFFFFF";
            }
            D();
            com.onetrust.otpublishers.headless.UI.Helper.l lVar = this.f23570z;
            com.onetrust.otpublishers.headless.UI.UIProperty.c cVar2 = this.f23567w.f22735j.f22787a;
            String strOptString6 = jSONObject.optString("PcLinksTextColor");
            lVar.getClass();
            if (!com.onetrust.otpublishers.headless.Internal.c.q(cVar2.f22722c)) {
                strOptString6 = cVar2.f22722c;
            }
            com.onetrust.otpublishers.headless.UI.UIProperty.v vVar = this.f23569y;
            if (vVar == null || vVar.f22831a) {
                TextView textView = this.f23548d;
                textView.setPaintFlags(textView.getPaintFlags() | 8);
            }
            a();
            com.onetrust.otpublishers.headless.UI.Helper.l.q(this.f23547c, this.f23567w.f22730e.f22721b);
            com.onetrust.otpublishers.headless.UI.Helper.l.q(this.f23549e, this.f23567w.f22733h.f22721b);
            com.onetrust.otpublishers.headless.UI.UIProperty.l lVar2 = this.f23567w.f22730e.f22720a;
            com.onetrust.otpublishers.headless.UI.Helper.l lVar3 = this.f23570z;
            TextView textView2 = this.f23547c;
            OTConfiguration oTConfiguration = this.f23568x;
            lVar3.getClass();
            com.onetrust.otpublishers.headless.UI.Helper.l.p(textView2, lVar2, oTConfiguration);
            com.onetrust.otpublishers.headless.UI.UIProperty.l lVar4 = this.f23567w.f22735j.f22787a.f22720a;
            com.onetrust.otpublishers.headless.UI.Helper.l lVar5 = this.f23570z;
            TextView textView3 = this.f23548d;
            OTConfiguration oTConfiguration2 = this.f23568x;
            lVar5.getClass();
            com.onetrust.otpublishers.headless.UI.Helper.l.p(textView3, lVar4, oTConfiguration2);
            com.onetrust.otpublishers.headless.UI.UIProperty.l lVar6 = this.f23567w.f22733h.f22720a;
            com.onetrust.otpublishers.headless.UI.Helper.l lVar7 = this.f23570z;
            TextView textView4 = this.f23549e;
            OTConfiguration oTConfiguration3 = this.f23568x;
            lVar7.getClass();
            com.onetrust.otpublishers.headless.UI.Helper.l.p(textView4, lVar6, oTConfiguration3);
            this.f23547c.setTextColor(Color.parseColor(this.f23563s));
            this.f23549e.setTextColor(Color.parseColor(str4));
            this.f23558n.setBackgroundColor(Color.parseColor(str5));
            this.f23557m.setBackgroundColor(Color.parseColor(str5));
            this.f23559o.setBackgroundColor(Color.parseColor(str5));
            this.f23552h.setColorFilter(Color.parseColor(str2));
            this.f23548d.setTextColor(Color.parseColor(strOptString6));
        } catch (JSONException e10) {
            com.onetrust.otpublishers.headless.Internal.Helper.p.a(e10, new StringBuilder("Error while applying styles to Vendor details, err : "), "OneTrust", 6);
        }
    }

    @RequiresApi(api = 21)
    public final void C() {
        this.f23548d.setOnClickListener(this);
        this.f23552h.setOnClickListener(this);
        this.f23556l.setOnClickListener(new View.OnClickListener() { // from class: com.onetrust.otpublishers.headless.UI.fragment.u
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f23534a.x(view);
            }
        });
    }

    public final void D() {
        String str = this.f23567w.f22728c;
        if (str != null && !com.onetrust.otpublishers.headless.Internal.c.q(str)) {
            this.f23565u = this.f23567w.f22728c;
        }
        String str2 = this.f23567w.f22727b;
        if (str2 != null && !com.onetrust.otpublishers.headless.Internal.c.q(str2)) {
            this.f23564t = this.f23567w.f22727b;
        }
        String str3 = this.f23567w.f22729d;
        if (str3 == null || com.onetrust.otpublishers.headless.Internal.c.q(str3)) {
            return;
        }
        this.f23566v = this.f23567w.f22729d;
    }

    public final void a() {
        if (!com.onetrust.otpublishers.headless.Internal.c.q(this.f23567w.f22730e.f22720a.f22783b)) {
            this.f23547c.setTextSize(Float.parseFloat(this.f23567w.f22730e.f22720a.f22783b));
        }
        if (!com.onetrust.otpublishers.headless.Internal.c.q(this.f23567w.f22733h.f22720a.f22783b)) {
            this.f23549e.setTextSize(Float.parseFloat(this.f23567w.f22733h.f22720a.f22783b));
        }
        String str = this.f23567w.f22735j.f22787a.f22720a.f22783b;
        if (com.onetrust.otpublishers.headless.Internal.c.q(str)) {
            return;
        }
        this.f23548d.setTextSize(Float.parseFloat(str));
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int id = view.getId();
        if (id == p6.d.M1) {
            dismiss();
            this.f23561q.a();
        } else if (id == p6.d.S1) {
            com.onetrust.otpublishers.headless.Internal.c.e(this.f23553i, this.f23546b);
        }
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public final void onConfigurationChanged(@NonNull Configuration configuration) {
        super.onConfigurationChanged(configuration);
        com.onetrust.otpublishers.headless.UI.Helper.l lVar = this.f23570z;
        FragmentActivity activity = getActivity();
        com.google.android.material.bottomsheet.a aVar = this.f23551g;
        lVar.getClass();
        com.onetrust.otpublishers.headless.UI.Helper.l.r(activity, aVar);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setRetainInstance(true);
        if (this.f23554j == null) {
            dismiss();
        }
        FragmentActivity activity = getActivity();
        if (com.onetrust.otpublishers.headless.UI.mobiledatautils.c.i(activity, OTFragmentTags.OT_GENERAL_VENDOR_DETAILS_TAG)) {
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
        dialogOnCreateDialog.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.onetrust.otpublishers.headless.UI.fragment.t
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                this.f23530a.w(dialogInterface);
            }
        });
        return dialogOnCreateDialog;
    }

    @Override // androidx.fragment.app.Fragment
    @RequiresApi(api = 21)
    public final View onCreateView(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        com.onetrust.otpublishers.headless.Internal.Preferences.h hVar;
        String string;
        this.f23553i = getContext();
        this.D = new com.onetrust.otpublishers.headless.UI.mobiledatautils.d();
        String strOptString = null;
        if (!this.D.l(com.onetrust.otpublishers.headless.UI.Helper.l.a(this.f23553i, this.f23568x), this.f23553i, this.f23554j)) {
            dismiss();
            return null;
        }
        Context context = this.f23553i;
        int i10 = p6.e.f32878l;
        boolean z10 = false;
        if (com.onetrust.otpublishers.headless.Internal.c.x(context)) {
            layoutInflater = layoutInflater.cloneInContext(new ContextThemeWrapper(context, p6.g.f32919b));
        }
        View viewInflate = layoutInflater.inflate(i10, viewGroup, false);
        this.f23547c = (TextView) viewInflate.findViewById(p6.d.O1);
        this.f23548d = (TextView) viewInflate.findViewById(p6.d.S1);
        this.f23557m = (RelativeLayout) viewInflate.findViewById(p6.d.N1);
        this.f23558n = (RelativeLayout) viewInflate.findViewById(p6.d.L1);
        this.f23552h = (ImageView) viewInflate.findViewById(p6.d.M1);
        this.f23556l = (SwitchCompat) viewInflate.findViewById(p6.d.I1);
        this.f23559o = (LinearLayout) viewInflate.findViewById(p6.d.f32677e2);
        this.f23549e = (TextView) viewInflate.findViewById(p6.d.J1);
        this.f23562r = viewInflate.findViewById(p6.d.P1);
        this.f23550f = (RecyclerView) viewInflate.findViewById(p6.d.Q1);
        com.onetrust.otpublishers.headless.UI.mobiledatautils.c.f("VendorDetail", this.f23553i, viewInflate);
        this.f23570z = new com.onetrust.otpublishers.headless.UI.Helper.l();
        try {
            JSONObject preferenceCenterData = this.f23554j.getPreferenceCenterData();
            if (preferenceCenterData != null) {
                B(preferenceCenterData);
                String strOptString2 = preferenceCenterData.optString("BConsentText");
                this.f23549e.setText(strOptString2);
                this.f23556l.setContentDescription(strOptString2);
                Context context2 = this.f23553i;
                try {
                    SharedPreferences sharedPreferences = context2.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0);
                    if (new com.onetrust.otpublishers.headless.Internal.profile.d(context2).t()) {
                        hVar = new com.onetrust.otpublishers.headless.Internal.Preferences.h(context2, sharedPreferences, sharedPreferences.getString("OT_ACTIVE_PROFILE_ID", ""));
                        z10 = true;
                    } else {
                        hVar = null;
                    }
                    if (z10) {
                        sharedPreferences = hVar;
                    }
                    try {
                        string = sharedPreferences.getString("OT_MOBILE_DATA", "");
                    } catch (JSONException e10) {
                        OTLogger.a("OneTrust", 6, "error while getting mobile data json, err: " + e10.getMessage());
                    }
                    JSONObject jSONObject = !com.onetrust.otpublishers.headless.Internal.c.q(string) ? new JSONObject(string) : new JSONObject();
                    JSONObject jSONObject2 = jSONObject.has("preferenceCenterData") ? jSONObject.getJSONObject("preferenceCenterData") : new JSONObject();
                    if (jSONObject2.has("generalVendors")) {
                        JSONObject jSONObject3 = jSONObject2.getJSONObject("generalVendors");
                        if (jSONObject3.has(OTVendorListMode.GENERAL)) {
                            JSONObject jSONObject4 = jSONObject3.getJSONObject(OTVendorListMode.GENERAL);
                            jSONObject4.optString("text");
                            strOptString = jSONObject4.optString("vendorListPrivacyPolicyText");
                            jSONObject4.optString("vendorListLabelText");
                        }
                    }
                } catch (JSONException e11) {
                    OTLogger.a("GeneralVendors", 6, "Error while parsing General Vendor labels:" + e11);
                }
                if (getArguments() != null) {
                    String string2 = getArguments().getString("vendorId");
                    this.f23560p = string2;
                    this.f23555k = this.f23554j.getVendorDetails(OTVendorListMode.GENERAL, string2);
                    a(preferenceCenterData);
                    if (com.onetrust.otpublishers.headless.Internal.c.q(strOptString) || com.onetrust.otpublishers.headless.Internal.c.q(this.f23546b)) {
                        this.f23548d.setVisibility(8);
                    } else {
                        this.f23548d.setText(strOptString);
                    }
                    if (preferenceCenterData.has("PCPrivacyLinkActionAriaLabel")) {
                        com.onetrust.otpublishers.headless.UI.mobiledatautils.c.d(this.f23548d, preferenceCenterData.optString("PCPrivacyLinkActionAriaLabel"));
                    }
                    if (preferenceCenterData.has("PCenterBackText")) {
                        this.f23552h.setContentDescription(preferenceCenterData.optString("PCenterBackText"));
                    }
                }
            }
        } catch (Exception e12) {
            com.onetrust.otpublishers.headless.Internal.Helper.j.a(e12, new StringBuilder("error while populating Vendor Detail fields"), "VendorDetail", 6);
        }
        C();
        return viewInflate;
    }

    @Override // androidx.fragment.app.Fragment
    @RequiresApi(api = 21)
    public final void onResume() {
        com.onetrust.otpublishers.headless.Internal.Preferences.h hVar;
        boolean z10;
        Drawable trackDrawable;
        int color;
        Drawable thumbDrawable;
        int color2;
        super.onResume();
        try {
            Context context = this.f23553i;
            SharedPreferences sharedPreferences = context.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0);
            if (com.onetrust.otpublishers.headless.Internal.b.a(new com.onetrust.otpublishers.headless.Internal.Preferences.e(context, "OTT_DEFAULT_USER").c().getString("OT_ENABLE_MULTI_PROFILE", Boolean.FALSE.toString()))) {
                hVar = new com.onetrust.otpublishers.headless.Internal.Preferences.h(context, sharedPreferences, sharedPreferences.getString("OT_ACTIVE_PROFILE_ID", ""));
                z10 = true;
            } else {
                hVar = null;
                z10 = false;
            }
            if (z10) {
                sharedPreferences = hVar;
            }
            if (sharedPreferences.getBoolean("OT_GENERAL_VENDORS_TOGGLE_CONFIGURED", false)) {
                int i10 = this.f23555k.getInt("consent");
                if (i10 == 0) {
                    this.f23556l.setChecked(false);
                    SwitchCompat switchCompat = this.f23556l;
                    if (this.f23566v != null) {
                        trackDrawable = switchCompat.getTrackDrawable();
                        color = Color.parseColor(this.f23566v);
                    } else {
                        trackDrawable = switchCompat.getTrackDrawable();
                        color = ContextCompat.getColor(this.f23553i, p6.a.f32627e);
                    }
                    trackDrawable.setTint(color);
                    if (this.f23565u != null) {
                        thumbDrawable = switchCompat.getThumbDrawable();
                        color2 = Color.parseColor(this.f23565u);
                    } else {
                        thumbDrawable = switchCompat.getThumbDrawable();
                        color2 = ContextCompat.getColor(this.f23553i, p6.a.f32625c);
                    }
                    thumbDrawable.setTint(color2);
                    return;
                }
                if (i10 == 1) {
                    this.f23556l.setChecked(true);
                    y(this.f23556l);
                    return;
                } else if (i10 == 2) {
                    this.f23556l.setChecked(true);
                    y(this.f23556l);
                    this.f23556l.setEnabled(false);
                    this.f23556l.setAlpha(0.5f);
                    return;
                }
            }
            A();
        } catch (JSONException e10) {
            com.onetrust.otpublishers.headless.Internal.Helper.p.a(e10, new StringBuilder("error while setting toggle values"), "VendorDetail", 6);
        }
    }

    @RequiresApi(api = 21)
    public final void y(SwitchCompat switchCompat) {
        Drawable trackDrawable;
        int color;
        if (this.f23566v != null) {
            trackDrawable = switchCompat.getTrackDrawable();
            color = Color.parseColor(this.f23566v);
        } else {
            trackDrawable = switchCompat.getTrackDrawable();
            color = ContextCompat.getColor(this.f23553i, p6.a.f32627e);
        }
        trackDrawable.setTint(color);
        switchCompat.getThumbDrawable().setTint(this.f23564t != null ? Color.parseColor(this.f23564t) : ContextCompat.getColor(this.f23553i, p6.a.f32624b));
    }

    @RequiresApi(api = 17)
    public final void a(@NonNull JSONObject jSONObject) throws JSONException {
        String str;
        JSONArray jSONArray;
        JSONObject jSONObject2 = this.f23555k;
        if (jSONObject2 != null) {
            this.f23547c.setText(jSONObject2.getString("Name"));
            ViewCompat.setAccessibilityHeading(this.f23547c, true);
            this.f23547c.setLabelFor(p6.d.I1);
            this.f23546b = this.f23555k.getString("PrivacyPolicyUrl");
            String string = this.f23555k.getString("Description");
            JSONArray jSONArray2 = this.f23555k.getJSONArray("Sdks");
            if (com.onetrust.otpublishers.headless.Internal.a.c(jSONArray2) && com.onetrust.otpublishers.headless.Internal.c.q(string) && !this.D.f23627u.f22857i) {
                return;
            }
            String strOptString = jSONObject.optString("PCenterCookiesListText");
            if (com.onetrust.otpublishers.headless.Internal.a.c(jSONArray2)) {
                jSONArray = new JSONArray();
                str = "";
            } else {
                str = strOptString;
                jSONArray = jSONArray2;
            }
            this.f23550f.setLayoutManager(new LinearLayoutManager(this.f23553i));
            this.f23550f.setAdapter(new com.onetrust.otpublishers.headless.UI.adapter.a(this.f23553i, jSONArray, this.A, this.f23567w, this.f23568x, str, Color.parseColor(this.B), this.f23567w, string, this.D));
        }
    }
}
