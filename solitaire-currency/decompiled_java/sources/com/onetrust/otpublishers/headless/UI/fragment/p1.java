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
import com.onetrust.otpublishers.headless.Public.DataModel.OTConfiguration;
import com.onetrust.otpublishers.headless.Public.Keys.OTFragmentTags;
import com.onetrust.otpublishers.headless.Public.OTPublishersHeadlessSDK;
import com.onetrust.otpublishers.headless.Public.OTThemeConstants;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class p1 extends com.google.android.material.bottomsheet.b {
    public View A;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f23475b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f23476c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f23477d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public TextView f23478e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public RecyclerView f23479f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public com.google.android.material.bottomsheet.a f23480g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ImageView f23481h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public TextView f23482i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public com.onetrust.otpublishers.headless.UI.adapter.d0 f23483j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public OTPublishersHeadlessSDK f23484k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public com.onetrust.otpublishers.headless.UI.a f23485l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f23486m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f23487n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f23488o;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public com.onetrust.otpublishers.headless.UI.Helper.l f23490q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f23491r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public com.onetrust.otpublishers.headless.Internal.Helper.w f23492s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f23493t;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public JSONObject f23496w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public OTConfiguration f23497x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public com.onetrust.otpublishers.headless.UI.UIProperty.x f23498y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public RelativeLayout f23499z;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final com.onetrust.otpublishers.headless.Internal.Event.a f23489p = new com.onetrust.otpublishers.headless.Internal.Event.a();

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public ArrayList f23494u = new ArrayList();

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public ArrayList f23495v = new ArrayList();

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void w(DialogInterface dialogInterface) {
        this.f23480g = (com.google.android.material.bottomsheet.a) dialogInterface;
        com.onetrust.otpublishers.headless.UI.Helper.l lVar = this.f23490q;
        FragmentActivity activity = getActivity();
        com.google.android.material.bottomsheet.a aVar = this.f23480g;
        lVar.getClass();
        com.onetrust.otpublishers.headless.UI.Helper.l.r(activity, aVar);
        this.f23480g.setCancelable(false);
        this.f23480g.setCanceledOnTouchOutside(false);
        this.f23480g.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.onetrust.otpublishers.headless.UI.fragment.o1
            @Override // android.content.DialogInterface.OnKeyListener
            public final boolean onKey(DialogInterface dialogInterface2, int i10, KeyEvent keyEvent) {
                return this.f23471a.y(dialogInterface2, i10, keyEvent);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(View view) {
        dismiss();
        com.onetrust.otpublishers.headless.UI.a aVar = this.f23485l;
        if (aVar != null) {
            aVar.a(6);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean y(DialogInterface dialogInterface, int i10, KeyEvent keyEvent) {
        if (i10 == 4 && keyEvent.getAction() == 1) {
            this.f23489p.a(new com.onetrust.otpublishers.headless.Internal.Event.b(6));
            dismiss();
            com.onetrust.otpublishers.headless.UI.a aVar = this.f23485l;
            if (aVar != null) {
                aVar.a(6);
            }
        }
        return true;
    }

    public final void a() {
        this.f23481h.setOnClickListener(new View.OnClickListener() { // from class: com.onetrust.otpublishers.headless.UI.fragment.n1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f23450a.x(view);
            }
        });
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public final void onConfigurationChanged(@NonNull Configuration configuration) {
        super.onConfigurationChanged(configuration);
        com.onetrust.otpublishers.headless.UI.Helper.l lVar = this.f23490q;
        FragmentActivity activity = getActivity();
        com.google.android.material.bottomsheet.a aVar = this.f23480g;
        lVar.getClass();
        com.onetrust.otpublishers.headless.UI.Helper.l.r(activity, aVar);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setRetainInstance(true);
        Context applicationContext = getContext().getApplicationContext();
        if (applicationContext != null && this.f23484k == null) {
            this.f23484k = new OTPublishersHeadlessSDK(applicationContext);
        }
        this.f23490q = new com.onetrust.otpublishers.headless.UI.Helper.l();
        try {
            this.f23496w = this.f23484k.getPreferenceCenterData();
        } catch (JSONException e10) {
            com.onetrust.otpublishers.headless.Internal.Helper.x.a("error while fetching PC Data ", e10, "UCPPurposeDetails", 6);
        }
        if (getArguments() != null) {
            if (getArguments().getParcelableArrayList("CUSTOM_PREF_ARRAY") != null) {
                this.f23495v = getArguments().getParcelableArrayList("CUSTOM_PREF_ARRAY");
            } else if (getArguments().getParcelableArrayList("TOPIC_PREF_ARRAY") != null) {
                this.f23494u = getArguments().getParcelableArrayList("TOPIC_PREF_ARRAY");
            }
            this.f23486m = getArguments().getString("ITEM_LABEL");
            this.f23487n = getArguments().getString("ITEM_DESC");
            this.f23491r = getArguments().getInt("ITEM_POSITION");
            this.f23488o = getArguments().getString("TITLE_TEXT_COLOR");
            this.f23493t = getArguments().getBoolean("PURPOSE_TOGGLE_STATE");
        }
        FragmentActivity activity = getActivity();
        if (com.onetrust.otpublishers.headless.UI.mobiledatautils.c.i(activity, OTFragmentTags.OT_UC_PURPOSES_FRAGMENT_TAG)) {
            SharedPreferences sharedPreferences = activity.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOT_SDK_APP_CONFIGURATION", 0);
            String str = OTThemeConstants.NO_SDK_THEME_OVERRIDE;
            String string = sharedPreferences.getString("OT_UX_SDK_THEME", OTThemeConstants.NO_SDK_THEME_OVERRIDE);
            if (com.onetrust.otpublishers.headless.Internal.c.q(string)) {
                string = OTThemeConstants.NO_SDK_THEME_OVERRIDE;
            }
            if (!string.equals(OTThemeConstants.OT_SDK_UI_THEME)) {
                String string2 = activity.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOT_SDK_APP_CONFIGURATION", 0).getString("OT_UX_SDK_THEME", OTThemeConstants.NO_SDK_THEME_OVERRIDE);
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
        dialogOnCreateDialog.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.onetrust.otpublishers.headless.UI.fragment.m1
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                this.f23425a.w(dialogInterface);
            }
        });
        return dialogOnCreateDialog;
    }

    @Override // androidx.fragment.app.Fragment
    @RequiresApi(api = 17)
    public final View onCreateView(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        LayoutInflater layoutInflaterCloneInContext = layoutInflater;
        Context context = getContext();
        int i10 = p6.e.f32874h;
        if (com.onetrust.otpublishers.headless.Internal.c.x(context)) {
            layoutInflaterCloneInContext = layoutInflaterCloneInContext.cloneInContext(new ContextThemeWrapper(context, p6.g.f32919b));
        }
        View viewInflate = layoutInflaterCloneInContext.inflate(i10, viewGroup, false);
        try {
            this.f23498y = new com.onetrust.otpublishers.headless.UI.UIProperty.b0(context).b(com.onetrust.otpublishers.headless.UI.Helper.l.a(context, this.f23497x));
        } catch (JSONException e10) {
            e10.printStackTrace();
        }
        this.f23475b = (TextView) viewInflate.findViewById(p6.d.f32725j5);
        this.f23476c = (TextView) viewInflate.findViewById(p6.d.T4);
        this.f23477d = (TextView) viewInflate.findViewById(p6.d.S4);
        this.f23478e = (TextView) viewInflate.findViewById(p6.d.H2);
        RecyclerView recyclerView = (RecyclerView) viewInflate.findViewById(p6.d.T0);
        this.f23479f = recyclerView;
        recyclerView.setHasFixedSize(true);
        this.f23479f.setLayoutManager(new LinearLayoutManager(getActivity()));
        this.f23481h = (ImageView) viewInflate.findViewById(p6.d.N);
        this.f23482i = (TextView) viewInflate.findViewById(p6.d.f32808s7);
        this.f23499z = (RelativeLayout) viewInflate.findViewById(p6.d.O2);
        this.A = viewInflate.findViewById(p6.d.f32688f4);
        a();
        this.f23476c.setText(this.f23486m);
        this.f23477d.setText(this.f23487n);
        String str = this.f23498y.f22849a;
        String strOptString = this.f23496w.optString("PcBackgroundColor");
        if (com.onetrust.otpublishers.headless.Internal.c.q(str)) {
            str = strOptString;
        }
        com.onetrust.otpublishers.headless.UI.UIProperty.x xVar = this.f23498y;
        com.onetrust.otpublishers.headless.UI.UIProperty.c cVar = xVar.f22868t;
        com.onetrust.otpublishers.headless.UI.UIProperty.c cVar2 = xVar.f22860l;
        String str2 = cVar.f22722c;
        String str3 = com.onetrust.otpublishers.headless.Internal.c.q(str2) ? this.f23488o : str2;
        String str4 = this.f23498y.f22859k.f22722c;
        String str5 = this.f23488o;
        if (com.onetrust.otpublishers.headless.Internal.c.q(str4)) {
            str4 = str5;
        }
        String str6 = cVar2.f22722c;
        String str7 = this.f23488o;
        if (com.onetrust.otpublishers.headless.Internal.c.q(str6)) {
            str6 = str7;
        }
        TextView textView = this.f23476c;
        if (!com.onetrust.otpublishers.headless.Internal.c.q(str3)) {
            textView.setTextColor(Color.parseColor(str3));
        }
        String str8 = cVar.f22720a.f22783b;
        if (!com.onetrust.otpublishers.headless.Internal.c.q(str8)) {
            textView.setTextSize(Float.parseFloat(str8));
        }
        TextView textView2 = this.f23477d;
        if (!com.onetrust.otpublishers.headless.Internal.c.q(str3)) {
            textView2.setTextColor(Color.parseColor(str3));
        }
        String str9 = cVar2.f22720a.f22783b;
        if (!com.onetrust.otpublishers.headless.Internal.c.q(str9)) {
            textView2.setTextSize(Float.parseFloat(str9));
        }
        TextView textView3 = this.f23478e;
        if (!com.onetrust.otpublishers.headless.Internal.c.q(str3)) {
            textView3.setTextColor(Color.parseColor(str3));
        }
        String str10 = cVar2.f22720a.f22783b;
        if (!com.onetrust.otpublishers.headless.Internal.c.q(str10)) {
            textView3.setTextSize(Float.parseFloat(str10));
        }
        this.f23475b.setTextColor(Color.parseColor(str4));
        this.f23481h.setColorFilter(Color.parseColor(str4));
        this.f23499z.setBackgroundColor(Color.parseColor(str));
        this.f23482i.setVisibility(this.f23498y.f22857i ? 0 : 8);
        TextView textView4 = this.f23482i;
        if (!com.onetrust.otpublishers.headless.Internal.c.q(str6)) {
            textView4.setTextColor(Color.parseColor(str6));
        }
        String str11 = cVar2.f22720a.f22783b;
        if (!com.onetrust.otpublishers.headless.Internal.c.q(str11)) {
            textView4.setTextSize(Float.parseFloat(str11));
        }
        String str12 = this.f23498y.f22850b;
        if (!com.onetrust.otpublishers.headless.Internal.c.q(str12)) {
            this.A.setBackgroundColor(Color.parseColor(str12));
        }
        if (this.f23495v.size() > 0) {
            this.f23478e.setText(((com.onetrust.otpublishers.headless.UI.DataModels.b) this.f23495v.get(this.f23491r)).f22060b);
            this.f23475b.setText(((com.onetrust.otpublishers.headless.UI.DataModels.b) this.f23495v.get(this.f23491r)).f22060b);
            this.f23483j = new com.onetrust.otpublishers.headless.UI.adapter.d0(((com.onetrust.otpublishers.headless.UI.DataModels.b) this.f23495v.get(this.f23491r)).f22064f, "customPrefOptionType", ((com.onetrust.otpublishers.headless.UI.DataModels.b) this.f23495v.get(this.f23491r)).f22062d, this.f23492s, this.f23493t, str3, this.f23498y);
        } else if (this.f23494u.size() > 0) {
            this.f23478e.setText(((com.onetrust.otpublishers.headless.UI.DataModels.e) this.f23494u.get(this.f23491r)).f22088a);
            this.f23475b.setText(((com.onetrust.otpublishers.headless.UI.DataModels.e) this.f23494u.get(this.f23491r)).f22088a);
            this.f23483j = new com.onetrust.otpublishers.headless.UI.adapter.d0(((com.onetrust.otpublishers.headless.UI.DataModels.e) this.f23494u.get(this.f23491r)).f22089b, "topicOptionType", "null", this.f23492s, this.f23493t, str3, this.f23498y);
        }
        this.f23479f.setAdapter(this.f23483j);
        return viewInflate;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        this.f23485l = null;
    }
}
