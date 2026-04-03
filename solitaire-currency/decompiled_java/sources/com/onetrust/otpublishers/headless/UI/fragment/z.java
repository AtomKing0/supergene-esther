package com.onetrust.otpublishers.headless.UI.fragment;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Color;
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
import androidx.core.view.ViewCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import com.onetrust.otpublishers.headless.Public.DataModel.OTConfiguration;
import com.onetrust.otpublishers.headless.Public.Keys.OTFragmentTags;
import com.onetrust.otpublishers.headless.Public.OTPublishersHeadlessSDK;
import com.onetrust.otpublishers.headless.Public.OTThemeConstants;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class z extends com.google.android.material.bottomsheet.b implements View.OnClickListener {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f23583b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f23584c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public RecyclerView f23585d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public com.google.android.material.bottomsheet.a f23586e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ImageView f23587f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Context f23588g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public OTPublishersHeadlessSDK f23589h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public RelativeLayout f23590i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public RelativeLayout f23591j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public LinearLayout f23592k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public com.onetrust.otpublishers.headless.UI.UIProperty.c0 f23593l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public OTConfiguration f23594m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public com.onetrust.otpublishers.headless.UI.Helper.l f23595n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f23596o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public com.onetrust.otpublishers.headless.UI.mobiledatautils.d f23597p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public JSONObject f23598q;

    /* JADX INFO: Access modifiers changed from: private */
    public void v(DialogInterface dialogInterface) {
        this.f23586e = (com.google.android.material.bottomsheet.a) dialogInterface;
        com.onetrust.otpublishers.headless.UI.Helper.l lVar = this.f23595n;
        FragmentActivity activity = getActivity();
        com.google.android.material.bottomsheet.a aVar = this.f23586e;
        lVar.getClass();
        com.onetrust.otpublishers.headless.UI.Helper.l.r(activity, aVar);
        this.f23586e.setCancelable(false);
        com.google.android.material.bottomsheet.a aVar2 = this.f23586e;
        if (aVar2 != null) {
            aVar2.setTitle(this.f23597p.N);
            this.f23586e.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.onetrust.otpublishers.headless.UI.fragment.y
                @Override // android.content.DialogInterface.OnKeyListener
                public final boolean onKey(DialogInterface dialogInterface2, int i10, KeyEvent keyEvent) {
                    return this.f23578a.w(dialogInterface2, i10, keyEvent);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x000c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean w(android.content.DialogInterface r2, int r3, android.view.KeyEvent r4) {
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
            if (r3 == 0) goto L12
            r1.dismiss()
        L12:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onetrust.otpublishers.headless.UI.fragment.z.w(android.content.DialogInterface, int, android.view.KeyEvent):boolean");
    }

    @RequiresApi(api = 17)
    public final void a(@NonNull JSONObject jSONObject) {
        this.f23595n.getClass();
        String strOptString = jSONObject.optString("GroupNameMobile");
        if (com.onetrust.otpublishers.headless.Internal.c.q(strOptString)) {
            strOptString = jSONObject.optString("GroupName");
        }
        this.f23583b.setText(this.f23597p.N);
        ViewCompat.setAccessibilityHeading(this.f23583b, true);
        this.f23584c.setText(strOptString);
        ViewCompat.setAccessibilityHeading(this.f23584c, true);
        JSONArray jSONArray = jSONObject.has("IabIllustrations") ? jSONObject.getJSONArray("IabIllustrations") : null;
        if (com.onetrust.otpublishers.headless.Internal.a.c(jSONArray) && com.onetrust.otpublishers.headless.Internal.c.q("") && !this.f23597p.f23627u.f22857i) {
            return;
        }
        if (jSONArray == null) {
            jSONArray = new JSONArray();
        }
        JSONArray jSONArray2 = jSONArray;
        this.f23585d.setLayoutManager(new LinearLayoutManager(this.f23588g));
        RecyclerView recyclerView = this.f23585d;
        Context context = this.f23588g;
        String str = this.f23596o;
        com.onetrust.otpublishers.headless.UI.UIProperty.c0 c0Var = this.f23593l;
        recyclerView.setAdapter(new com.onetrust.otpublishers.headless.UI.adapter.b(context, jSONArray2, str, c0Var, this.f23594m, c0Var, this.f23597p));
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view.getId() == p6.d.f32713i2) {
            dismiss();
        }
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public final void onConfigurationChanged(@NonNull Configuration configuration) {
        super.onConfigurationChanged(configuration);
        com.onetrust.otpublishers.headless.UI.Helper.l lVar = this.f23595n;
        FragmentActivity activity = getActivity();
        com.google.android.material.bottomsheet.a aVar = this.f23586e;
        lVar.getClass();
        com.onetrust.otpublishers.headless.UI.Helper.l.r(activity, aVar);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setRetainInstance(true);
        if (this.f23589h == null) {
            dismiss();
        }
        FragmentActivity activity = getActivity();
        if (com.onetrust.otpublishers.headless.UI.mobiledatautils.c.i(activity, OTFragmentTags.OT_IAB_ILLUSTRATION_DETAILS_TAG)) {
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
        dialogOnCreateDialog.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.onetrust.otpublishers.headless.UI.fragment.x
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                this.f23574a.v(dialogInterface);
            }
        });
        return dialogOnCreateDialog;
    }

    @Override // androidx.fragment.app.Fragment
    @RequiresApi(api = 21)
    public final View onCreateView(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f23588g = getContext();
        this.f23597p = new com.onetrust.otpublishers.headless.UI.mobiledatautils.d();
        int iA = com.onetrust.otpublishers.headless.UI.Helper.l.a(this.f23588g, this.f23594m);
        if (!this.f23597p.l(iA, this.f23588g, this.f23589h) || this.f23598q == null) {
            dismiss();
            return null;
        }
        Context context = this.f23588g;
        int i10 = p6.e.f32882p;
        if (com.onetrust.otpublishers.headless.Internal.c.x(context)) {
            layoutInflater = layoutInflater.cloneInContext(new ContextThemeWrapper(context, p6.g.f32919b));
        }
        View viewInflate = layoutInflater.inflate(i10, viewGroup, false);
        this.f23583b = (TextView) viewInflate.findViewById(p6.d.f32776p2);
        this.f23584c = (TextView) viewInflate.findViewById(p6.d.f32695g2);
        this.f23590i = (RelativeLayout) viewInflate.findViewById(p6.d.f32722j2);
        this.f23591j = (RelativeLayout) viewInflate.findViewById(p6.d.f32704h2);
        this.f23587f = (ImageView) viewInflate.findViewById(p6.d.f32713i2);
        this.f23592k = (LinearLayout) viewInflate.findViewById(p6.d.f32749m2);
        this.f23585d = (RecyclerView) viewInflate.findViewById(p6.d.f32731k2);
        com.onetrust.otpublishers.headless.UI.mobiledatautils.c.f("IabIllustrations", this.f23588g, viewInflate);
        this.f23595n = new com.onetrust.otpublishers.headless.UI.Helper.l();
        try {
            JSONObject preferenceCenterData = this.f23589h.getPreferenceCenterData();
            if (preferenceCenterData != null) {
                x(preferenceCenterData);
                a(this.f23598q);
                if (preferenceCenterData.has("PCenterBackText")) {
                    this.f23587f.setContentDescription(preferenceCenterData.optString("PCenterBackText"));
                }
            }
        } catch (Exception e10) {
            com.onetrust.otpublishers.headless.Internal.Helper.j.a(e10, new StringBuilder("error while populating Vendor Detail fields"), "IabIllustrations", 6);
        }
        this.f23587f.setOnClickListener(this);
        return viewInflate;
    }

    @Override // androidx.fragment.app.Fragment
    @RequiresApi(api = 21)
    public final void onResume() {
        super.onResume();
    }

    public final void x(@NonNull JSONObject jSONObject) {
        try {
            int iA = com.onetrust.otpublishers.headless.UI.Helper.l.a(this.f23588g, this.f23594m);
            com.onetrust.otpublishers.headless.UI.UIProperty.c0 c0VarF = new com.onetrust.otpublishers.headless.UI.UIProperty.b0(this.f23588g, iA).f();
            this.f23593l = c0VarF;
            String str = c0VarF.f22732g.f22722c;
            String strOptString = jSONObject.optString("PcTextColor");
            String str2 = "#696969";
            if (com.onetrust.otpublishers.headless.Internal.c.q(str)) {
                str = !com.onetrust.otpublishers.headless.Internal.c.q(strOptString) ? strOptString : iA == 11 ? "#FFFFFF" : "#696969";
            }
            this.f23596o = str;
            String str3 = this.f23593l.f22726a;
            String strOptString2 = jSONObject.optString("PcBackgroundColor");
            if (com.onetrust.otpublishers.headless.Internal.c.q(str3)) {
                str3 = !com.onetrust.otpublishers.headless.Internal.c.q(strOptString2) ? strOptString2 : iA == 11 ? "#2F2F2F" : "#FFFFFF";
            }
            String str4 = this.f23593l.f22736k;
            String strOptString3 = jSONObject.optString("PcTextColor");
            if (!com.onetrust.otpublishers.headless.Internal.c.q(str4)) {
                str2 = str4;
            } else if (!com.onetrust.otpublishers.headless.Internal.c.q(strOptString3)) {
                str2 = strOptString3;
            } else if (iA == 11) {
                str2 = "#FFFFFF";
            }
            this.f23591j.setBackgroundColor(Color.parseColor(str3));
            this.f23590i.setBackgroundColor(Color.parseColor(str3));
            this.f23592k.setBackgroundColor(Color.parseColor(str3));
            this.f23587f.setColorFilter(Color.parseColor(str2));
            com.onetrust.otpublishers.headless.UI.mobiledatautils.d dVar = this.f23597p;
            com.onetrust.otpublishers.headless.UI.Helper.c cVar = dVar.f23607a;
            com.onetrust.otpublishers.headless.UI.Helper.c cVar2 = dVar.f23630x;
            TextView textView = this.f23583b;
            textView.setTextColor(Color.parseColor(cVar.c()));
            com.onetrust.otpublishers.headless.UI.Helper.l.q(textView, cVar.f22153p);
            if (!com.onetrust.otpublishers.headless.Internal.c.q(cVar.f22154q)) {
                textView.setTextSize(Float.parseFloat(cVar.f22154q));
            }
            com.onetrust.otpublishers.headless.UI.Helper.l lVar = this.f23595n;
            com.onetrust.otpublishers.headless.UI.UIProperty.l lVar2 = cVar.f22758a;
            OTConfiguration oTConfiguration = this.f23594m;
            lVar.getClass();
            com.onetrust.otpublishers.headless.UI.Helper.l.p(textView, lVar2, oTConfiguration);
            TextView textView2 = this.f23584c;
            textView2.setTextColor(Color.parseColor(cVar2.c()));
            com.onetrust.otpublishers.headless.UI.Helper.l.q(textView2, cVar2.f22153p);
            if (!com.onetrust.otpublishers.headless.Internal.c.q(cVar2.f22154q)) {
                textView2.setTextSize(Float.parseFloat(cVar2.f22154q));
            }
            com.onetrust.otpublishers.headless.UI.Helper.l lVar3 = this.f23595n;
            com.onetrust.otpublishers.headless.UI.UIProperty.l lVar4 = cVar2.f22758a;
            OTConfiguration oTConfiguration2 = this.f23594m;
            lVar3.getClass();
            com.onetrust.otpublishers.headless.UI.Helper.l.p(textView2, lVar4, oTConfiguration2);
        } catch (JSONException e10) {
            com.onetrust.otpublishers.headless.Internal.Helper.p.a(e10, new StringBuilder("Error while applying styles to Vendor details, err : "), "OneTrust", 6);
        }
    }
}
