package com.onetrust.otpublishers.headless.UI.fragment;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.ClipData;
import android.content.ClipboardManager;
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
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.os.BundleKt;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import com.onetrust.otpublishers.headless.Public.DataModel.OTConfiguration;
import com.onetrust.otpublishers.headless.Public.DataModel.OTCustomConfigurator;
import com.onetrust.otpublishers.headless.Public.DataModel.OTProxyType;
import com.onetrust.otpublishers.headless.Public.Keys.OTFragmentTags;
import com.onetrust.otpublishers.headless.Public.OTConsentInteractionType;
import com.onetrust.otpublishers.headless.Public.OTPublishersHeadlessSDK;
import com.onetrust.otpublishers.headless.Public.OTThemeConstants;
import com.onetrust.otpublishers.headless.UI.fragment.m2;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes4.dex */
public class l0 extends com.google.android.material.bottomsheet.b implements View.OnClickListener, com.onetrust.otpublishers.headless.UI.a, com.onetrust.otpublishers.headless.UI.adapter.t {
    public m2 A;
    public c1 B;
    public com.onetrust.otpublishers.headless.UI.a C;
    public OTConfiguration E;
    public com.onetrust.otpublishers.headless.UI.Helper.l F;
    public com.onetrust.otpublishers.headless.UI.UIProperty.v G;
    public View H;
    public View I;
    public View J;
    public View K;
    public View L;
    public View M;
    public TextView N;
    public com.onetrust.otpublishers.headless.UI.mobiledatautils.d O;
    public TextView P;
    public TextView Q;
    public View R;
    public View S;
    public int T;
    public boolean U;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f23379b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f23380c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f23381d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public TextView f23382e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public TextView f23383f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public TextView f23384g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public TextView f23385h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public TextView f23386i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public TextView f23387j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public TextView f23388k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public RecyclerView f23389l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Button f23390m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Button f23391n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Button f23392o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public com.google.android.material.bottomsheet.a f23393p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public ImageView f23394q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public ImageView f23395r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public ImageView f23396s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public TextView f23397t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public Button f23398u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public RelativeLayout f23399v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Context f23400w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public LinearLayout f23401x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public LinearLayout f23402y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public OTPublishersHeadlessSDK f23403z;
    public com.onetrust.otpublishers.headless.Internal.Event.a D = new com.onetrust.otpublishers.headless.Internal.Event.a();
    public boolean V = true;

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean C(DialogInterface dialogInterface, int i10, KeyEvent keyEvent) {
        if (i10 != 4 || keyEvent.getAction() != 1) {
            return false;
        }
        com.onetrust.otpublishers.headless.UI.Helper.l lVar = this.F;
        com.onetrust.otpublishers.headless.Internal.Event.b bVar = new com.onetrust.otpublishers.headless.Internal.Event.b(6);
        com.onetrust.otpublishers.headless.Internal.Event.a aVar = this.D;
        lVar.getClass();
        com.onetrust.otpublishers.headless.UI.Helper.l.s(bVar, aVar);
        v(2, true);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void w(DialogInterface dialogInterface) {
        this.f23393p = (com.google.android.material.bottomsheet.a) dialogInterface;
        if (com.onetrust.otpublishers.headless.UI.mobiledatautils.c.i(getActivity(), "OT_PConCreateDialog")) {
            com.onetrust.otpublishers.headless.UI.Helper.l lVar = this.F;
            FragmentActivity fragmentActivityRequireActivity = requireActivity();
            com.google.android.material.bottomsheet.a aVar = this.f23393p;
            lVar.getClass();
            com.onetrust.otpublishers.headless.UI.Helper.l.r(fragmentActivityRequireActivity, aVar);
        }
        this.f23393p.setCancelable(false);
        this.f23393p.setCanceledOnTouchOutside(false);
        this.f23393p.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.onetrust.otpublishers.headless.UI.fragment.k0
            @Override // android.content.DialogInterface.OnKeyListener
            public final boolean onKey(DialogInterface dialogInterface2, int i10, KeyEvent keyEvent) {
                return this.f23375a.C(dialogInterface2, i10, keyEvent);
            }
        });
    }

    public final void A(@NonNull com.onetrust.otpublishers.headless.UI.UIProperty.f fVar, @NonNull com.onetrust.otpublishers.headless.UI.UIProperty.f fVar2, @NonNull com.onetrust.otpublishers.headless.UI.UIProperty.f fVar3) {
        LinearLayout linearLayout;
        Object value;
        int i10 = fVar.f22771n;
        int i11 = fVar2.f22771n;
        int i12 = fVar3.f22771n;
        if (i10 == 0 && i11 == 0 && i12 == 0) {
            OTLogger.a("PreferenceCenter", 3, "Reordering PC buttons not required");
            return;
        }
        try {
            OTLogger.a("PreferenceCenter", 3, "Reordering PC buttons as per admin configuration");
            HashMap map = new HashMap();
            map.put(Integer.valueOf(i10), this.f23390m);
            map.put(Integer.valueOf(i11), this.f23392o);
            map.put(Integer.valueOf(i12), this.f23391n);
            TreeMap treeMap = new TreeMap(map);
            this.f23402y.removeAllViews();
            this.f23401x.removeAllViews();
            for (Map.Entry entry : treeMap.entrySet()) {
                if (((Integer) entry.getKey()).intValue() < 10) {
                    linearLayout = this.f23402y;
                    value = entry.getValue();
                } else {
                    linearLayout = this.f23401x;
                    value = entry.getValue();
                }
                linearLayout.addView((View) value);
            }
            if (i10 > 10 || i11 > 10 || i12 > 10) {
                return;
            }
            this.f23401x.setVisibility(4);
            this.f23401x.setElevation(0.0f);
            this.f23401x.setBackgroundColor(0);
            this.f23401x.setPaddingRelative(0, 0, 0, 0);
        } catch (Exception e10) {
            OTLogger.a("PreferenceCenter", 6, "Reordering PC buttons failed, falling back to default:" + e10);
            this.f23402y.removeAllViews();
            this.f23401x.removeAllViews();
            this.f23402y.addView(this.f23390m);
            this.f23402y.addView(this.f23392o);
            this.f23401x.addView(this.f23391n);
            this.f23401x.setVisibility(0);
        }
    }

    @RequiresApi(api = 17)
    public final void B(@NonNull com.onetrust.otpublishers.headless.UI.mobiledatautils.d dVar, @NonNull TextView textView) {
        com.onetrust.otpublishers.headless.UI.UIProperty.c cVar;
        com.onetrust.otpublishers.headless.UI.Helper.c cVar2;
        if (textView.equals(this.f23384g)) {
            String str = dVar.f23632z;
            String str2 = dVar.f23627u.f22861m.f22724e;
            if (com.ironsource.mediationsdk.metadata.a.f13688g.equals(str) || !com.onetrust.otpublishers.headless.Internal.c.q(str2)) {
                textView.setVisibility(0);
            } else {
                textView.setVisibility(8);
            }
            textView.setText(dVar.B.f22724e);
            com.onetrust.otpublishers.headless.UI.mobiledatautils.d.e(textView, dVar.B, dVar.f23616j, this.E);
            ImageView imageView = this.f23396s;
            String str3 = dVar.f23627u.G.f22786a;
            if (str3 == null) {
                str3 = "";
            }
            imageView.setContentDescription(str3);
            return;
        }
        if (textView.equals(this.f23388k)) {
            String str4 = dVar.A;
            String str5 = dVar.f23627u.f22866r.f22724e;
            if (com.ironsource.mediationsdk.metadata.a.f13688g.equals(str4) || !com.onetrust.otpublishers.headless.Internal.c.q(str5)) {
                textView.setVisibility(0);
            } else {
                textView.setVisibility(8);
            }
            com.onetrust.otpublishers.headless.UI.Helper.l lVar = this.F;
            Context context = this.f23400w;
            String str6 = dVar.C.f22724e;
            lVar.getClass();
            com.onetrust.otpublishers.headless.UI.Helper.l.j(context, textView, str6);
            cVar = dVar.C;
            cVar2 = dVar.f23608b;
        } else {
            if (textView.equals(this.f23385h)) {
                textView.setText(dVar.D.f22724e);
                cVar = dVar.D;
            } else if (textView.equals(this.f23387j)) {
                textView.setText(dVar.F.f22724e);
                cVar = dVar.F;
                cVar2 = dVar.f23616j;
            } else {
                if (!textView.equals(this.f23386i)) {
                    return;
                }
                textView.setText(dVar.E.f22724e);
                cVar = dVar.E;
            }
            cVar2 = dVar.f23630x;
        }
        OTConfiguration oTConfiguration = this.E;
        dVar.getClass();
        com.onetrust.otpublishers.headless.UI.mobiledatautils.d.e(textView, cVar, cVar2, oTConfiguration);
    }

    @SuppressLint({"WrongConstant"})
    public final void D() {
        boolean z10;
        com.onetrust.otpublishers.headless.Internal.Preferences.h hVar;
        com.onetrust.otpublishers.headless.Internal.Preferences.h hVar2;
        String str;
        com.onetrust.otpublishers.headless.UI.Helper.c cVar = this.O.f23615i;
        this.f23395r.setVisibility(cVar.f22152o);
        ImageView imageView = this.f23395r;
        String str2 = this.O.f23627u.A.f22793c;
        if (str2 == null) {
            str2 = "";
        }
        imageView.setContentDescription(str2);
        if (cVar.f22152o == 0) {
            boolean z11 = true;
            int iB = com.onetrust.otpublishers.headless.UI.Helper.l.b(requireActivity(), true);
            int iB2 = com.onetrust.otpublishers.headless.UI.Helper.l.b(requireActivity(), false) / 2;
            int i10 = iB / 9;
            int dimensionPixelSize = getResources().getDimensionPixelSize(p6.b.f32632d);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(iB2, i10);
            layoutParams.addRule(14);
            layoutParams.setMargins(0, dimensionPixelSize, 0, 0);
            this.f23395r.setLayoutParams(layoutParams);
            if (com.onetrust.otpublishers.headless.Internal.Helper.k.e(this.f23400w)) {
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(iB2, i10);
                layoutParams2.addRule(18);
                layoutParams2.setMargins(0, dimensionPixelSize, getResources().getDimensionPixelSize(p6.b.f32630b), 0);
                this.f23395r.setLayoutParams(layoutParams2);
            }
            Context context = this.f23400w;
            SharedPreferences sharedPreferences = context.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0);
            String proxyDomainURLString = null;
            if (com.onetrust.otpublishers.headless.Internal.Helper.l.a(context)) {
                hVar = new com.onetrust.otpublishers.headless.Internal.Preferences.h(context, sharedPreferences, sharedPreferences.getString("OT_ACTIVE_PROFILE_ID", ""));
                z10 = true;
            } else {
                z10 = false;
                hVar = null;
            }
            if (z10) {
                sharedPreferences = hVar;
            }
            if (sharedPreferences.getBoolean("OTT_LOAD_OFFLINE_DATA", false)) {
                OTConfiguration oTConfiguration = this.E;
                if (oTConfiguration == null || oTConfiguration.getPcLogo() == null) {
                    return;
                } else {
                    str = "Loading offline logo for PC.";
                }
            } else {
                Context context2 = this.f23400w;
                SharedPreferences sharedPreferences2 = context2.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0);
                if (com.onetrust.otpublishers.headless.Internal.Helper.l.a(context2)) {
                    hVar2 = new com.onetrust.otpublishers.headless.Internal.Preferences.h(context2, sharedPreferences2, sharedPreferences2.getString("OT_ACTIVE_PROFILE_ID", ""));
                } else {
                    z11 = false;
                    hVar2 = null;
                }
                if (z11) {
                    sharedPreferences2 = hVar2;
                }
                if (!sharedPreferences2.getBoolean("OTT_OFFLINE_DATA_SET_FLAG", false) || com.onetrust.otpublishers.headless.Internal.Network.o.a(this.f23400w)) {
                    String strA = cVar.a();
                    try {
                        proxyDomainURLString = OTCustomConfigurator.getProxyDomainURLString(new OTProxyType.PCLogo(new URL(strA)));
                    } catch (MalformedURLException e10) {
                        OTLogger.a("PreferenceCenter", 6, "Error while fetching PC Logo using proxy" + e10.getMessage());
                    }
                    com.onetrust.otpublishers.headless.UI.extensions.f.a(p6.c.f32635b, 10000, this.f23395r, proxyDomainURLString, strA, "Preference Center");
                    return;
                }
                OTConfiguration oTConfiguration2 = this.E;
                if (oTConfiguration2 == null || oTConfiguration2.getPcLogo() == null) {
                    return;
                } else {
                    str = "Loading offline set logo for PC.";
                }
            }
            OTLogger.a("PreferenceCenter", 3, str);
            this.f23395r.setImageDrawable(this.E.getPcLogo());
        }
    }

    @RequiresApi(api = 17)
    public final void E() {
        com.onetrust.otpublishers.headless.UI.mobiledatautils.d dVar = this.O;
        if (dVar.f23632z != null) {
            B(dVar, this.f23384g);
            com.onetrust.otpublishers.headless.UI.mobiledatautils.d dVar2 = this.O;
            if (dVar2.A != null) {
                B(dVar2, this.f23388k);
            } else {
                this.f23388k.setVisibility(8);
            }
            B(this.O, this.f23385h);
        } else {
            this.f23384g.setVisibility(8);
            this.f23385h.setVisibility(8);
            this.f23388k.setVisibility(8);
            this.f23396s.setVisibility(8);
            this.M.setVisibility(8);
        }
        if (com.ironsource.mediationsdk.metadata.a.f13688g.equals(this.O.G)) {
            B(this.O, this.f23387j);
            B(this.O, this.f23386i);
        } else {
            this.f23387j.setVisibility(8);
            this.f23386i.setVisibility(8);
        }
    }

    public final void F() {
        String str = this.O.f23626t;
        com.onetrust.otpublishers.headless.Internal.Helper.d.a("setSectionDividerColor PC: ", str, "OT_Automation", 3);
        com.onetrust.otpublishers.headless.UI.mobiledatautils.c.g(str, this.H);
        com.onetrust.otpublishers.headless.UI.mobiledatautils.c.g(str, this.I);
        com.onetrust.otpublishers.headless.UI.mobiledatautils.c.g(str, this.R);
        com.onetrust.otpublishers.headless.UI.mobiledatautils.c.g(str, this.S);
        com.onetrust.otpublishers.headless.UI.mobiledatautils.c.g(str, this.J);
        com.onetrust.otpublishers.headless.UI.mobiledatautils.c.g(str, this.K);
        com.onetrust.otpublishers.headless.UI.mobiledatautils.c.g(str, this.M);
    }

    public final void G() {
        if (!this.U) {
            this.S.setVisibility(8);
        }
        if (this.P.getVisibility() == 8) {
            this.R.setVisibility(8);
        }
        if (!this.O.K || !this.V) {
            this.S.setVisibility(8);
            if (!this.U) {
                this.P.setVisibility(8);
                this.R.setVisibility(8);
                this.J.setVisibility(8);
            }
        }
        if (this.O.f23622p.length() > 0) {
            return;
        }
        this.Q.setVisibility(8);
    }

    @Override // com.onetrust.otpublishers.headless.UI.a
    public final void a(int i10) {
        if (i10 == 1) {
            v(i10, false);
        }
        if (i10 == 3) {
            m2.a aVar = m2.f23426o;
            com.onetrust.otpublishers.headless.Internal.Event.a aVar2 = this.D;
            OTConfiguration oTConfiguration = this.E;
            aVar.getClass();
            m2 m2VarA = m2.a.a(aVar2, oTConfiguration);
            this.A = m2VarA;
            m2VarA.u(this.f23403z);
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) throws Throwable {
        int id = view.getId();
        if (id == p6.d.f32756n0) {
            this.f23403z.saveConsent(OTConsentInteractionType.PC_ALLOW_ALL);
            com.onetrust.otpublishers.headless.UI.Helper.l lVar = this.F;
            com.onetrust.otpublishers.headless.Internal.Event.b bVar = new com.onetrust.otpublishers.headless.Internal.Event.b(8);
            com.onetrust.otpublishers.headless.Internal.Event.a aVar = this.D;
            lVar.getClass();
            com.onetrust.otpublishers.headless.UI.Helper.l.s(bVar, aVar);
            com.onetrust.otpublishers.headless.Internal.Event.b bVar2 = new com.onetrust.otpublishers.headless.Internal.Event.b(17);
            bVar2.f21748d = OTConsentInteractionType.PC_ALLOW_ALL;
            com.onetrust.otpublishers.headless.UI.Helper.l lVar2 = this.F;
            com.onetrust.otpublishers.headless.Internal.Event.a aVar2 = this.D;
            lVar2.getClass();
            com.onetrust.otpublishers.headless.UI.Helper.l.s(bVar2, aVar2);
        } else if (id == p6.d.f32774p0) {
            this.f23403z.saveConsent(OTConsentInteractionType.PC_CONFIRM);
            com.onetrust.otpublishers.headless.UI.Helper.l lVar3 = this.F;
            com.onetrust.otpublishers.headless.Internal.Event.b bVar3 = new com.onetrust.otpublishers.headless.Internal.Event.b(10);
            com.onetrust.otpublishers.headless.Internal.Event.a aVar3 = this.D;
            lVar3.getClass();
            com.onetrust.otpublishers.headless.UI.Helper.l.s(bVar3, aVar3);
            com.onetrust.otpublishers.headless.Internal.Event.b bVar4 = new com.onetrust.otpublishers.headless.Internal.Event.b(17);
            bVar4.f21748d = OTConsentInteractionType.PC_CONFIRM;
            com.onetrust.otpublishers.headless.UI.Helper.l lVar4 = this.F;
            com.onetrust.otpublishers.headless.Internal.Event.a aVar4 = this.D;
            lVar4.getClass();
            com.onetrust.otpublishers.headless.UI.Helper.l.s(bVar4, aVar4);
        } else {
            if (id == p6.d.M0 || id == p6.d.O0 || id == p6.d.N0) {
                this.f23403z.resetUpdatedConsent();
                com.onetrust.otpublishers.headless.UI.Helper.l lVar5 = this.F;
                com.onetrust.otpublishers.headless.Internal.Event.b bVar5 = new com.onetrust.otpublishers.headless.Internal.Event.b(6);
                com.onetrust.otpublishers.headless.Internal.Event.a aVar5 = this.D;
                lVar5.getClass();
                com.onetrust.otpublishers.headless.UI.Helper.l.s(bVar5, aVar5);
                v(2, true);
                return;
            }
            if (id != p6.d.f32801s0) {
                if (id == p6.d.f32745l7) {
                    if (this.A.isAdded() || getActivity() == null) {
                        OTLogger.a("PreferenceCenter", 6, "Show Vendors: Fragment already added or getActivity() returned null");
                        return;
                    }
                    Bundle bundle = new Bundle();
                    bundle.putBoolean("IS_FILTERED_VENDOR_LIST", false);
                    this.A.setArguments(bundle);
                    m2 m2Var = this.A;
                    m2Var.f23433g = this;
                    com.onetrust.otpublishers.headless.UI.mobiledatautils.c.j(m2Var, requireActivity(), OTFragmentTags.OT_VENDOR_LIST_FRAGMENT_TAG);
                    com.onetrust.otpublishers.headless.UI.Helper.l lVar6 = this.F;
                    com.onetrust.otpublishers.headless.Internal.Event.b bVar6 = new com.onetrust.otpublishers.headless.Internal.Event.b(12);
                    com.onetrust.otpublishers.headless.Internal.Event.a aVar6 = this.D;
                    lVar6.getClass();
                    com.onetrust.otpublishers.headless.UI.Helper.l.s(bVar6, aVar6);
                    return;
                }
                if (id == p6.d.f32649b1) {
                    com.onetrust.otpublishers.headless.Internal.c.e(this.f23400w, this.O.f23623q);
                    return;
                }
                if (id == p6.d.f32698g5) {
                    Context context = this.f23400w;
                    ((ClipboardManager) context.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("copiedText", this.f23385h.getText().toString()));
                    Toast.makeText(context, "Data Copied to Clipboard", 0).show();
                    return;
                }
                if (id == p6.d.f32736k7) {
                    if (this.B.isAdded() || getActivity() == null) {
                        OTLogger.a("PreferenceCenter", 6, "renderSDKListFragment: Fragment already added or getActivity() returned null");
                        return;
                    }
                    Bundle bundle2 = new Bundle();
                    com.onetrust.otpublishers.headless.UI.mobiledatautils.f fVar = new com.onetrust.otpublishers.headless.UI.mobiledatautils.f();
                    fVar.c(this.T, this.f23400w, this.f23403z);
                    if (com.onetrust.otpublishers.headless.UI.mobiledatautils.f.b(com.onetrust.otpublishers.headless.Internal.Helper.k.a(fVar.f23649b)).isEmpty()) {
                        this.V = false;
                    }
                    bundle2.putString("OT_GROUP_ID_LIST", com.onetrust.otpublishers.headless.UI.mobiledatautils.f.b(com.onetrust.otpublishers.headless.Internal.Helper.k.a(fVar.f23649b)).toString());
                    bundle2.putString("sdkLevelOptOutShow", this.O.H);
                    com.onetrust.otpublishers.headless.UI.Helper.c cVar = this.O.f23629w;
                    bundle2.putString("ALWAYS_ACTIVE_TEXT", cVar.a());
                    bundle2.putString("ALWAYS_ACTIVE_TEXT_COLOR", cVar.c());
                    this.B.setArguments(bundle2);
                    com.onetrust.otpublishers.headless.UI.mobiledatautils.c.j(this.B, requireActivity(), OTFragmentTags.OT_SDK_LIST_FRAGMENT_TAG);
                    return;
                }
                return;
            }
            this.f23403z.saveConsent(OTConsentInteractionType.PC_REJECT_ALL);
            com.onetrust.otpublishers.headless.UI.Helper.l lVar7 = this.F;
            com.onetrust.otpublishers.headless.Internal.Event.b bVar7 = new com.onetrust.otpublishers.headless.Internal.Event.b(9);
            com.onetrust.otpublishers.headless.Internal.Event.a aVar7 = this.D;
            lVar7.getClass();
            com.onetrust.otpublishers.headless.UI.Helper.l.s(bVar7, aVar7);
            com.onetrust.otpublishers.headless.Internal.Event.b bVar8 = new com.onetrust.otpublishers.headless.Internal.Event.b(17);
            bVar8.f21748d = OTConsentInteractionType.PC_REJECT_ALL;
            com.onetrust.otpublishers.headless.UI.Helper.l lVar8 = this.F;
            com.onetrust.otpublishers.headless.Internal.Event.a aVar8 = this.D;
            lVar8.getClass();
            com.onetrust.otpublishers.headless.UI.Helper.l.s(bVar8, aVar8);
        }
        v(1, false);
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public final void onConfigurationChanged(@NonNull Configuration configuration) {
        super.onConfigurationChanged(configuration);
        com.onetrust.otpublishers.headless.UI.Helper.l lVar = this.F;
        FragmentActivity activity = getActivity();
        com.google.android.material.bottomsheet.a aVar = this.f23393p;
        lVar.getClass();
        com.onetrust.otpublishers.headless.UI.Helper.l.r(activity, aVar);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(@Nullable Bundle bundle) {
        Context applicationContext;
        super.onCreate(bundle);
        setRetainInstance(true);
        if (com.onetrust.otpublishers.headless.UI.mobiledatautils.c.i(getContext(), OTFragmentTags.OT_PREFERENCE_CENTER_FRAGMENT_TAG) && (applicationContext = requireContext().getApplicationContext()) != null && this.f23403z == null) {
            this.f23403z = new OTPublishersHeadlessSDK(applicationContext);
        }
        FragmentActivity activity = getActivity();
        if (com.onetrust.otpublishers.headless.UI.mobiledatautils.c.i(activity, OTFragmentTags.OT_PREFERENCE_CENTER_FRAGMENT_TAG)) {
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
        dialogOnCreateDialog.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.onetrust.otpublishers.headless.UI.fragment.j0
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                this.f23371a.w(dialogInterface);
            }
        });
        return dialogOnCreateDialog;
    }

    @Override // androidx.fragment.app.Fragment
    @RequiresApi(api = 17)
    public final View onCreateView(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        com.onetrust.otpublishers.headless.Internal.Preferences.h hVar;
        boolean z10;
        this.f23400w = getContext();
        m2.a aVar = m2.f23426o;
        com.onetrust.otpublishers.headless.Internal.Event.a aVar2 = this.D;
        OTConfiguration oTConfiguration = this.E;
        aVar.getClass();
        m2 m2VarA = m2.a.a(aVar2, oTConfiguration);
        this.A = m2VarA;
        m2VarA.u(this.f23403z);
        OTConfiguration oTConfiguration2 = this.E;
        kotlin.jvm.internal.t.i(OTFragmentTags.OT_SDK_LIST_FRAGMENT_TAG, "fragmentTag");
        Bundle bundleBundleOf = BundleKt.bundleOf(v8.y.a(OTFragmentTags.FRAGMENT_TAG, OTFragmentTags.OT_SDK_LIST_FRAGMENT_TAG));
        c1 c1Var = new c1();
        c1Var.setArguments(bundleBundleOf);
        c1Var.f23257e = oTConfiguration2;
        this.B = c1Var;
        kotlin.jvm.internal.t.i(this, "listener");
        c1Var.f23259g = this;
        c1 c1Var2 = this.B;
        OTPublishersHeadlessSDK otPublishersHeadlessSDK = this.f23403z;
        c1Var2.getClass();
        kotlin.jvm.internal.t.i(otPublishersHeadlessSDK, "otPublishersHeadlessSDK");
        c1Var2.f23256d = otPublishersHeadlessSDK;
        this.F = new com.onetrust.otpublishers.headless.UI.Helper.l();
        View viewC = com.onetrust.otpublishers.headless.UI.Helper.l.c(this.f23400w, layoutInflater, viewGroup, p6.e.f32869c);
        RecyclerView recyclerView = (RecyclerView) viewC.findViewById(p6.d.f32706h4);
        this.f23389l = recyclerView;
        recyclerView.setHasFixedSize(true);
        this.f23389l.setLayoutManager(new LinearLayoutManager(getActivity()));
        this.f23389l.setNestedScrollingEnabled(false);
        this.f23399v = (RelativeLayout) viewC.findViewById(p6.d.f32670d4);
        this.f23401x = (LinearLayout) viewC.findViewById(p6.d.H1);
        this.f23402y = (LinearLayout) viewC.findViewById(p6.d.F);
        this.f23380c = (TextView) viewC.findViewById(p6.d.L2);
        this.f23381d = (TextView) viewC.findViewById(p6.d.f32697g4);
        this.f23391n = (Button) viewC.findViewById(p6.d.f32774p0);
        this.f23379b = (TextView) viewC.findViewById(p6.d.I2);
        this.f23394q = (ImageView) viewC.findViewById(p6.d.M0);
        this.f23397t = (TextView) viewC.findViewById(p6.d.O0);
        this.f23398u = (Button) viewC.findViewById(p6.d.N0);
        this.P = (TextView) viewC.findViewById(p6.d.f32705h3);
        this.Q = (TextView) viewC.findViewById(p6.d.f32736k7);
        this.R = viewC.findViewById(p6.d.f32687f3);
        this.S = viewC.findViewById(p6.d.f32678e3);
        this.f23382e = (TextView) viewC.findViewById(p6.d.f32745l7);
        this.f23392o = (Button) viewC.findViewById(p6.d.f32801s0);
        this.f23390m = (Button) viewC.findViewById(p6.d.f32756n0);
        this.f23383f = (TextView) viewC.findViewById(p6.d.f32649b1);
        this.f23395r = (ImageView) viewC.findViewById(p6.d.f32679e4);
        this.f23396s = (ImageView) viewC.findViewById(p6.d.f32698g5);
        this.H = viewC.findViewById(p6.d.f32696g3);
        this.M = viewC.findViewById(p6.d.f32853y1);
        this.I = viewC.findViewById(p6.d.Z2);
        this.J = viewC.findViewById(p6.d.f32660c3);
        this.K = viewC.findViewById(p6.d.f32669d3);
        this.L = viewC.findViewById(p6.d.f32688f4);
        this.f23384g = (TextView) viewC.findViewById(p6.d.B1);
        this.f23385h = (TextView) viewC.findViewById(p6.d.f32861z1);
        this.f23386i = (TextView) viewC.findViewById(p6.d.f32707h5);
        this.f23387j = (TextView) viewC.findViewById(p6.d.f32716i5);
        this.f23388k = (TextView) viewC.findViewById(p6.d.A1);
        this.N = (TextView) viewC.findViewById(p6.d.f32808s7);
        com.onetrust.otpublishers.headless.UI.Helper.l lVar = this.F;
        LinearLayout linearLayout = this.f23401x;
        Context context = this.f23400w;
        lVar.getClass();
        com.onetrust.otpublishers.headless.UI.Helper.l.l(linearLayout, context);
        this.f23390m.setOnClickListener(this);
        this.f23394q.setOnClickListener(this);
        this.f23397t.setOnClickListener(this);
        this.f23398u.setOnClickListener(this);
        this.f23391n.setOnClickListener(this);
        this.f23392o.setOnClickListener(this);
        this.f23383f.setOnClickListener(this);
        this.f23382e.setOnClickListener(this);
        this.Q.setOnClickListener(this);
        this.f23396s.setOnClickListener(this);
        this.O = new com.onetrust.otpublishers.headless.UI.mobiledatautils.d();
        if (com.onetrust.otpublishers.headless.UI.mobiledatautils.c.i(this.f23400w, OTFragmentTags.OT_PREFERENCE_CENTER_FRAGMENT_TAG)) {
            com.onetrust.otpublishers.headless.UI.mobiledatautils.c.f("PreferenceCenter", this.f23400w, viewC);
            int iA = com.onetrust.otpublishers.headless.UI.Helper.l.a(this.f23400w, this.E);
            this.T = iA;
            if (!this.O.l(iA, this.f23400w, this.f23403z)) {
                dismiss();
            }
            this.G = this.O.f23628v;
            try {
                new com.onetrust.otpublishers.headless.UI.mobiledatautils.f().c(this.T, this.f23400w, this.f23403z);
                this.V = !com.onetrust.otpublishers.headless.UI.mobiledatautils.f.b(com.onetrust.otpublishers.headless.Internal.Helper.k.a(r1.f23649b)).isEmpty();
                Context context2 = this.f23400w;
                SharedPreferences sharedPreferences = context2.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0);
                String str = "";
                if (com.onetrust.otpublishers.headless.Internal.b.a(context2.getSharedPreferences("com.onetrust.otpublishers.headless.preference".concat("OTT_DEFAULT_USER"), 0).getString("OT_ENABLE_MULTI_PROFILE", Boolean.FALSE.toString()))) {
                    hVar = new com.onetrust.otpublishers.headless.Internal.Preferences.h(context2, sharedPreferences, sharedPreferences.getString("OT_ACTIVE_PROFILE_ID", ""));
                    z10 = true;
                } else {
                    hVar = null;
                    z10 = false;
                }
                if (z10) {
                    sharedPreferences = hVar;
                }
                String string = sharedPreferences.getString("OT_TEMPLATE_TYPE", "");
                if (!com.onetrust.otpublishers.headless.Internal.c.q(string)) {
                    str = string;
                }
                this.U = "IAB2".equalsIgnoreCase(str) || "IAB2V2".equalsIgnoreCase(str);
                z(this.O.f23607a, this.f23380c);
                ViewCompat.setAccessibilityHeading(this.f23380c, true);
                z(this.O.f23608b, this.f23379b);
                z(this.O.f23611e, this.f23383f);
                com.onetrust.otpublishers.headless.UI.mobiledatautils.c.d(this.f23383f, this.O.f23627u.D.a());
                TextView textView = this.f23383f;
                com.onetrust.otpublishers.headless.UI.UIProperty.v vVar = this.G;
                if (vVar == null || vVar.f22831a) {
                    textView.setPaintFlags(textView.getPaintFlags() | 8);
                }
                z(this.O.f23612f, this.P);
                ViewCompat.setAccessibilityHeading(this.P, true);
                z(this.O.f23613g, this.f23382e);
                z(this.O.f23614h, this.Q);
                String str2 = this.O.f23625s;
                if (!com.onetrust.otpublishers.headless.Internal.c.q(str2)) {
                    com.onetrust.otpublishers.headless.UI.Helper.i.f(this.f23382e, str2);
                    com.onetrust.otpublishers.headless.UI.Helper.i.f(this.Q, str2);
                    com.onetrust.otpublishers.headless.UI.Helper.l.o(this.f23396s, str2);
                }
                D();
                com.onetrust.otpublishers.headless.UI.Helper.c cVar = this.O.f23616j;
                z(cVar, this.f23381d);
                ViewCompat.setAccessibilityHeading(this.f23381d, true);
                com.onetrust.otpublishers.headless.UI.mobiledatautils.d dVar = this.O;
                com.onetrust.otpublishers.headless.UI.Helper.c cVar2 = dVar.f23617k;
                com.onetrust.otpublishers.headless.UI.Helper.c cVar3 = dVar.f23618l;
                com.onetrust.otpublishers.headless.UI.Helper.c cVar4 = dVar.f23619m;
                A(cVar2.f22155r, cVar3.f22155r, cVar4.f22155r);
                x(cVar2, this.f23390m);
                x(cVar3, this.f23392o);
                x(cVar4, this.f23391n);
                this.f23389l.setAdapter(new com.onetrust.otpublishers.headless.UI.adapter.n(this.f23400w, this.O, this.f23403z, this.D, this, this.E));
                String str3 = this.O.f23624r;
                this.f23399v.setBackgroundColor(Color.parseColor(str3));
                this.f23389l.setBackgroundColor(Color.parseColor(str3));
                this.f23401x.setBackgroundColor(Color.parseColor(str3));
                OTLogger.a("OT_Automation", 3, "BG color PC: " + str3);
                y(this.O.f23620n, this.f23394q, this.f23397t, this.f23398u);
                F();
                if (this.O.J) {
                    View view = this.M;
                    ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.height = 10;
                    }
                    view.setLayoutParams(layoutParams);
                    View view2 = this.H;
                    ViewGroup.LayoutParams layoutParams2 = view2.getLayoutParams();
                    if (layoutParams2 != null) {
                        layoutParams2.height = 10;
                    }
                    view2.setLayoutParams(layoutParams2);
                    View view3 = this.I;
                    ViewGroup.LayoutParams layoutParams3 = view3.getLayoutParams();
                    if (layoutParams3 != null) {
                        layoutParams3.height = 10;
                    }
                    view3.setLayoutParams(layoutParams3);
                    View view4 = this.J;
                    ViewGroup.LayoutParams layoutParams4 = view4.getLayoutParams();
                    if (layoutParams4 != null) {
                        layoutParams4.height = 10;
                    }
                    view4.setLayoutParams(layoutParams4);
                }
                this.K.setVisibility(cVar.f22152o);
                E();
                this.O.d(this.N, this.E);
                G();
            } catch (RuntimeException e10) {
                OTLogger.a("PreferenceCenter", 6, "error while populating  PC fields" + e10.getMessage());
            }
        }
        return viewC;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        this.D = null;
    }

    public final void v(int i10, boolean z10) {
        dismiss();
        com.onetrust.otpublishers.headless.UI.a aVar = this.C;
        if (aVar != null) {
            aVar.a(i10);
            return;
        }
        if (z10) {
            com.onetrust.otpublishers.headless.Internal.Event.b bVar = new com.onetrust.otpublishers.headless.Internal.Event.b(17);
            bVar.f21748d = OTConsentInteractionType.PC_CLOSE;
            com.onetrust.otpublishers.headless.UI.Helper.l lVar = this.F;
            com.onetrust.otpublishers.headless.Internal.Event.a aVar2 = this.D;
            lVar.getClass();
            com.onetrust.otpublishers.headless.UI.Helper.l.s(bVar, aVar2);
        }
    }

    @SuppressLint({"WrongConstant"})
    public final void x(@NonNull com.onetrust.otpublishers.headless.UI.Helper.c cVar, @NonNull Button button) {
        button.setText(cVar.a());
        button.setVisibility(cVar.f22152o);
        button.setTextColor(Color.parseColor(cVar.c()));
        if (!com.onetrust.otpublishers.headless.Internal.c.q(cVar.f22758a.f22783b)) {
            button.setTextSize(Float.parseFloat(cVar.f22154q));
        }
        com.onetrust.otpublishers.headless.UI.Helper.l lVar = this.F;
        com.onetrust.otpublishers.headless.UI.UIProperty.l lVar2 = cVar.f22758a;
        OTConfiguration oTConfiguration = this.E;
        lVar.getClass();
        com.onetrust.otpublishers.headless.UI.Helper.l.m(button, lVar2, oTConfiguration);
        com.onetrust.otpublishers.headless.UI.Helper.l.i(this.f23400w, button, cVar.f22155r, cVar.f22759b, cVar.f22761d);
    }

    @SuppressLint({"WrongConstant"})
    public final void y(@NonNull com.onetrust.otpublishers.headless.UI.Helper.c cVar, @NonNull ImageView imageView, @NonNull TextView textView, @NonNull Button button) {
        imageView.setVisibility(cVar.f22152o);
        imageView.setContentDescription(cVar.a());
        textView.setVisibility(cVar.f22156s);
        imageView.getDrawable().setTint(Color.parseColor(cVar.c()));
        int i10 = 0;
        if (cVar.f22157t == 0) {
            button.setVisibility(0);
            button.setText(cVar.a());
            button.setTextColor(Color.parseColor(cVar.c()));
            if (!com.onetrust.otpublishers.headless.Internal.c.q(cVar.f22758a.f22783b)) {
                button.setTextSize(Float.parseFloat(cVar.f22154q));
            }
            com.onetrust.otpublishers.headless.UI.Helper.l lVar = this.F;
            com.onetrust.otpublishers.headless.UI.UIProperty.l lVar2 = cVar.f22758a;
            OTConfiguration oTConfiguration = this.E;
            lVar.getClass();
            com.onetrust.otpublishers.headless.UI.Helper.l.m(button, lVar2, oTConfiguration);
            com.onetrust.otpublishers.headless.UI.Helper.l.i(this.f23400w, button, cVar.f22155r, cVar.f22759b, cVar.f22761d);
        } else if (cVar.f22156s == 0) {
            textView.setText(cVar.a());
            textView.setTextColor(Color.parseColor(cVar.c()));
            com.onetrust.otpublishers.headless.UI.UIProperty.v vVar = this.G;
            if (vVar == null || vVar.f22831a) {
                textView.setPaintFlags(textView.getPaintFlags() | 8);
            }
        }
        View view = this.L;
        if (cVar.f22156s == 8 && cVar.f22152o == 8 && cVar.f22157t == 8) {
            i10 = 8;
        }
        view.setVisibility(i10);
    }

    @RequiresApi(api = 17)
    @SuppressLint({"WrongConstant"})
    public final void z(com.onetrust.otpublishers.headless.UI.Helper.c cVar, TextView textView) {
        com.onetrust.otpublishers.headless.UI.Helper.l lVar = this.F;
        Context context = this.f23400w;
        String strA = cVar.a();
        lVar.getClass();
        com.onetrust.otpublishers.headless.UI.Helper.l.j(context, textView, strA);
        textView.setVisibility(cVar.f22152o);
        textView.setTextColor(Color.parseColor(cVar.c()));
        com.onetrust.otpublishers.headless.UI.Helper.l.q(textView, cVar.f22153p);
        if (!com.onetrust.otpublishers.headless.Internal.c.q(cVar.f22154q)) {
            textView.setTextSize(Float.parseFloat(cVar.f22154q));
        }
        com.onetrust.otpublishers.headless.UI.Helper.l lVar2 = this.F;
        com.onetrust.otpublishers.headless.UI.UIProperty.l lVar3 = cVar.f22758a;
        OTConfiguration oTConfiguration = this.E;
        lVar2.getClass();
        com.onetrust.otpublishers.headless.UI.Helper.l.p(textView, lVar3, oTConfiguration);
    }

    @Override // com.onetrust.otpublishers.headless.UI.adapter.t
    public final void a() {
        if (this.f23389l.getAdapter() != null) {
            com.onetrust.otpublishers.headless.UI.adapter.n nVar = (com.onetrust.otpublishers.headless.UI.adapter.n) this.f23389l.getAdapter();
            com.onetrust.otpublishers.headless.UI.mobiledatautils.d dVar = nVar.f23076t;
            JSONArray jSONArray = dVar.f23622p;
            nVar.f23068l = jSONArray;
            nVar.f23072p = dVar.f23627u;
            nVar.notifyItemRangeChanged(0, jSONArray.length());
        }
    }
}
