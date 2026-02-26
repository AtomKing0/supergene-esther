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
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import com.onetrust.otpublishers.headless.Public.Keys.OTFragmentTags;
import com.onetrust.otpublishers.headless.Public.OTConsentInteractionType;
import com.onetrust.otpublishers.headless.Public.OTPublishersHeadlessSDK;
import com.onetrust.otpublishers.headless.Public.OTThemeConstants;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class l1 extends com.google.android.material.bottomsheet.b implements View.OnClickListener, com.onetrust.otpublishers.headless.UI.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public RelativeLayout f23404b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f23405c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f23406d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public TextView f23407e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View f23408f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public View f23409g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Button f23410h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public RecyclerView f23411i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public com.google.android.material.bottomsheet.a f23412j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ImageView f23413k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public TextView f23414l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Context f23415m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public OTPublishersHeadlessSDK f23416n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public JSONObject f23417o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public com.onetrust.otpublishers.headless.UI.UIProperty.a0 f23418p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public com.onetrust.otpublishers.headless.UI.UIProperty.x f23419q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public com.onetrust.otpublishers.headless.UI.Helper.l f23420r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public com.onetrust.otpublishers.headless.Internal.Helper.w f23421s;

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void w(DialogInterface dialogInterface) {
        this.f23412j = (com.google.android.material.bottomsheet.a) dialogInterface;
        com.onetrust.otpublishers.headless.UI.Helper.l lVar = this.f23420r;
        FragmentActivity activity = getActivity();
        com.google.android.material.bottomsheet.a aVar = this.f23412j;
        lVar.getClass();
        com.onetrust.otpublishers.headless.UI.Helper.l.r(activity, aVar);
        this.f23412j.setCancelable(false);
        this.f23412j.setCanceledOnTouchOutside(false);
        this.f23412j.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.onetrust.otpublishers.headless.UI.fragment.k1
            @Override // android.content.DialogInterface.OnKeyListener
            public final boolean onKey(DialogInterface dialogInterface2, int i10, KeyEvent keyEvent) {
                return this.f23376a.y(dialogInterface2, i10, keyEvent);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean y(DialogInterface dialogInterface, int i10, KeyEvent keyEvent) {
        if (i10 == 4 && keyEvent.getAction() == 1) {
            dismiss();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void z(View view) {
        dismiss();
    }

    @Override // com.onetrust.otpublishers.headless.UI.a
    public final void a(int i10) {
        if (i10 == 1) {
            dismiss();
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) throws Throwable {
        int id = view.getId();
        if (id == p6.d.f32828v0) {
            this.f23416n.saveConsent(OTConsentInteractionType.UC_PC_CONFIRM);
            dismiss();
        } else if (id == p6.d.L0) {
            dismiss();
        }
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public final void onConfigurationChanged(@NonNull Configuration configuration) {
        super.onConfigurationChanged(configuration);
        com.onetrust.otpublishers.headless.UI.Helper.l lVar = this.f23420r;
        FragmentActivity activity = getActivity();
        com.google.android.material.bottomsheet.a aVar = this.f23412j;
        lVar.getClass();
        com.onetrust.otpublishers.headless.UI.Helper.l.r(activity, aVar);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setRetainInstance(true);
        Context applicationContext = getContext().getApplicationContext();
        if (applicationContext != null && this.f23416n == null) {
            this.f23416n = new OTPublishersHeadlessSDK(applicationContext);
        }
        OTPublishersHeadlessSDK oTPublishersHeadlessSDK = this.f23416n;
        if (oTPublishersHeadlessSDK != null) {
            this.f23421s = oTPublishersHeadlessSDK.getUcpHandler();
        }
        this.f23420r = new com.onetrust.otpublishers.headless.UI.Helper.l();
        FragmentActivity activity = getActivity();
        if (com.onetrust.otpublishers.headless.UI.mobiledatautils.c.i(activity, OTFragmentTags.OT_UC_PURPOSES_FRAGMENT_TAG)) {
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
    @RequiresApi(api = 17)
    public final Dialog onCreateDialog(Bundle bundle) {
        Dialog dialogOnCreateDialog = super.onCreateDialog(bundle);
        dialogOnCreateDialog.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.onetrust.otpublishers.headless.UI.fragment.i1
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                this.f23368a.w(dialogInterface);
            }
        });
        return dialogOnCreateDialog;
    }

    @Override // androidx.fragment.app.Fragment
    @RequiresApi(api = 17)
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Context context = getContext();
        this.f23415m = context;
        int i10 = p6.e.f32873g;
        if (com.onetrust.otpublishers.headless.Internal.c.x(context)) {
            layoutInflater = layoutInflater.cloneInContext(new ContextThemeWrapper(context, p6.g.f32919b));
        }
        View viewInflate = layoutInflater.inflate(i10, viewGroup, false);
        int iA = com.onetrust.otpublishers.headless.UI.Helper.l.a(this.f23415m, null);
        x(viewInflate);
        this.f23410h.setOnClickListener(this);
        this.f23413k.setOnClickListener(this);
        Context context2 = this.f23415m;
        try {
            this.f23417o = this.f23416n.getPreferenceCenterData();
        } catch (JSONException e10) {
            com.onetrust.otpublishers.headless.Internal.Helper.p.a(e10, new StringBuilder("Error in PC data initialization. Error msg = "), "OTUCPurposesFragment", 6);
        }
        try {
            com.onetrust.otpublishers.headless.UI.UIProperty.b0 b0Var = new com.onetrust.otpublishers.headless.UI.UIProperty.b0(context2);
            this.f23418p = b0Var.c(this.f23421s, iA);
            this.f23419q = b0Var.b(iA);
        } catch (JSONException e11) {
            com.onetrust.otpublishers.headless.Internal.Helper.p.a(e11, new StringBuilder("Error in ui property object, error message = "), "OTUCPurposesFragment", 6);
        }
        com.onetrust.otpublishers.headless.UI.UIProperty.a0 a0Var = this.f23418p;
        if (a0Var != null && this.f23419q != null) {
            this.f23407e.setText(a0Var.f22707c);
            String strOptString = this.f23419q.f22849a;
            if (strOptString == null || com.onetrust.otpublishers.headless.Internal.c.q(strOptString)) {
                strOptString = this.f23417o.optString("PcBackgroundColor");
            }
            this.f23404b.setBackgroundColor(Color.parseColor(strOptString));
            com.onetrust.otpublishers.headless.UI.UIProperty.c cVar = this.f23418p.f22709e;
            com.onetrust.otpublishers.headless.UI.UIProperty.c cVar2 = this.f23419q.f22859k;
            String strOptString2 = cVar2.f22722c;
            if (strOptString2 == null || com.onetrust.otpublishers.headless.Internal.c.q(strOptString2)) {
                strOptString2 = this.f23417o.optString("PcTextColor");
            }
            this.f23407e.setTextColor(Color.parseColor(strOptString2));
            TextView textView = this.f23406d;
            String strOptString3 = cVar2.f22722c;
            if (strOptString3 == null || com.onetrust.otpublishers.headless.Internal.c.q(strOptString3)) {
                strOptString3 = this.f23417o.optString("PcTextColor");
            }
            textView.setTextColor(Color.parseColor(strOptString3));
            if (!com.onetrust.otpublishers.headless.Internal.c.q(cVar2.f22720a.f22783b)) {
                textView.setTextSize(Float.parseFloat(cVar2.f22720a.f22783b));
            }
            this.f23406d.setVisibility(cVar.b() ? 0 : 8);
            com.onetrust.otpublishers.headless.UI.Helper.l lVar = this.f23420r;
            Context context3 = this.f23415m;
            TextView textView2 = this.f23406d;
            String str = cVar.f22724e;
            lVar.getClass();
            com.onetrust.otpublishers.headless.UI.Helper.l.j(context3, textView2, str);
            com.onetrust.otpublishers.headless.UI.UIProperty.c cVar3 = this.f23418p.f22710f;
            com.onetrust.otpublishers.headless.UI.UIProperty.c cVar4 = this.f23419q.f22860l;
            TextView textView3 = this.f23405c;
            String strOptString4 = cVar4.f22722c;
            if (strOptString4 == null || com.onetrust.otpublishers.headless.Internal.c.q(strOptString4)) {
                strOptString4 = this.f23417o.optString("PcTextColor");
            }
            textView3.setTextColor(Color.parseColor(strOptString4));
            if (!com.onetrust.otpublishers.headless.Internal.c.q(cVar4.f22720a.f22783b)) {
                textView3.setTextSize(Float.parseFloat(cVar4.f22720a.f22783b));
            }
            this.f23405c.setVisibility(cVar3.b() ? 0 : 8);
            com.onetrust.otpublishers.headless.UI.Helper.l lVar2 = this.f23420r;
            Context context4 = this.f23415m;
            TextView textView4 = this.f23405c;
            String str2 = cVar3.f22724e;
            lVar2.getClass();
            com.onetrust.otpublishers.headless.UI.Helper.l.j(context4, textView4, str2);
            this.f23414l.setVisibility(this.f23418p.f22708d ? 0 : 8);
            TextView textView5 = this.f23414l;
            String strOptString5 = cVar4.f22722c;
            if (strOptString5 == null || com.onetrust.otpublishers.headless.Internal.c.q(strOptString5)) {
                strOptString5 = this.f23417o.optString("PcTextColor");
            }
            textView5.setTextColor(Color.parseColor(strOptString5));
            if (!com.onetrust.otpublishers.headless.Internal.c.q(cVar4.f22720a.f22783b)) {
                textView5.setTextSize(Float.parseFloat(cVar4.f22720a.f22783b));
            }
            this.f23414l.setText(requireContext().getString(p6.f.f32896d));
            if (this.f23418p.f22712h.size() == 0) {
                this.f23408f.setVisibility(8);
            }
            String str3 = this.f23419q.f22850b;
            if (!com.onetrust.otpublishers.headless.Internal.c.q(str3)) {
                this.f23408f.setBackgroundColor(Color.parseColor(str3));
                this.f23409g.setBackgroundColor(Color.parseColor(str3));
            }
            this.f23411i.setAdapter(new com.onetrust.otpublishers.headless.UI.adapter.x(this.f23415m, this.f23418p, this.f23419q, this.f23417o.optString("PcTextColor"), this, this.f23421s));
            com.onetrust.otpublishers.headless.UI.UIProperty.f fVar = this.f23418p.f22711g;
            com.onetrust.otpublishers.headless.UI.UIProperty.f fVar2 = this.f23419q.f22873y;
            Button button = this.f23410h;
            button.setText(fVar2.a());
            com.onetrust.otpublishers.headless.UI.UIProperty.l lVar3 = fVar2.f22758a;
            if (!com.onetrust.otpublishers.headless.Internal.c.q(lVar3.f22783b)) {
                button.setTextSize(Float.parseFloat(lVar3.f22783b));
            }
            button.setTextColor(Color.parseColor(!com.onetrust.otpublishers.headless.Internal.c.q(fVar2.c()) ? fVar2.c() : this.f23417o.optString("PcButtonTextColor")));
            com.onetrust.otpublishers.headless.UI.Helper.l.i(this.f23415m, button, fVar2, !com.onetrust.otpublishers.headless.Internal.c.q(fVar2.f22759b) ? fVar2.f22759b : this.f23417o.optString("PcButtonColor"), fVar2.f22761d);
            this.f23410h.setText(fVar.a());
            String strOptString6 = this.f23419q.f22874z.f22777e;
            if (com.onetrust.otpublishers.headless.Internal.c.q(strOptString6) && ((strOptString6 = this.f23419q.f22860l.f22722c) == null || com.onetrust.otpublishers.headless.Internal.c.q(strOptString6))) {
                strOptString6 = this.f23417o.optString("PcTextColor");
            }
            this.f23413k.setColorFilter(Color.parseColor(strOptString6));
        }
        return viewInflate;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
    }

    public final void x(@NonNull View view) {
        RecyclerView recyclerView = (RecyclerView) view.findViewById(p6.d.Q0);
        this.f23411i = recyclerView;
        recyclerView.setHasFixedSize(true);
        this.f23411i.setLayoutManager(new LinearLayoutManager(getActivity()));
        this.f23407e = (TextView) view.findViewById(p6.d.f32725j5);
        this.f23410h = (Button) view.findViewById(p6.d.f32828v0);
        this.f23406d = (TextView) view.findViewById(p6.d.U0);
        this.f23405c = (TextView) view.findViewById(p6.d.P0);
        this.f23413k = (ImageView) view.findViewById(p6.d.L0);
        this.f23408f = view.findViewById(p6.d.f32686f2);
        this.f23409g = view.findViewById(p6.d.f32688f4);
        this.f23413k.setOnClickListener(new View.OnClickListener() { // from class: com.onetrust.otpublishers.headless.UI.fragment.j1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f23372a.z(view2);
            }
        });
        this.f23414l = (TextView) view.findViewById(p6.d.f32808s7);
        this.f23404b = (RelativeLayout) view.findViewById(p6.d.C6);
    }
}
