package com.onetrust.otpublishers.headless.UI.TVUI.fragments;

import android.R;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.cardview.widget.CardView;
import androidx.core.widget.CompoundButtonCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.webkit.ProxyConfig;
import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import com.onetrust.otpublishers.headless.Public.OTPublishersHeadlessSDK;
import com.onetrust.otpublishers.headless.UI.TVUI.adapter.j;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class n extends Fragment implements j.a, View.OnKeyListener, View.OnFocusChangeListener {
    public ImageView A;
    public int B;
    public CardView C;
    public CardView D;
    public LinearLayout E;
    public LinearLayout F;
    public TextView G;
    public TextView H;
    public CardView I;
    public LinearLayout J;
    public TextView K;
    public String L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f22581a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f22582b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f22583c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f22584d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public TextView f22585e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public RecyclerView f22586f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Context f22587g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public LinearLayout f22588h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public LinearLayout f22589i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public TextView f22590j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public OTPublishersHeadlessSDK f22591k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public JSONObject f22592l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public LinearLayout f22593m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public com.onetrust.otpublishers.headless.Internal.Event.a f22594n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public a f22595o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f22596p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public com.onetrust.otpublishers.headless.UI.TVUI.adapter.j f22597q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public View f22598r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public com.onetrust.otpublishers.headless.UI.TVUI.datautils.c f22599s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public CardView f22600t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public CardView f22601u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public TextView f22602v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public CheckBox f22603w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public CheckBox f22604x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public CheckBox f22605y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public CheckBox f22606z;

    public interface a {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void s(CompoundButton compoundButton, boolean z10) {
        this.B = this.B > 1 ? 3 : 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(CompoundButton compoundButton, boolean z10) {
        String strOptString = this.f22592l.optString("CustomGroupId");
        this.f22591k.updatePurposeLegitInterest(strOptString, z10);
        com.onetrust.otpublishers.headless.Internal.Event.b bVar = new com.onetrust.otpublishers.headless.Internal.Event.b(11);
        bVar.f21746b = strOptString;
        bVar.f21747c = z10 ? 1 : 0;
        com.onetrust.otpublishers.headless.Internal.Event.a aVar = this.f22594n;
        if (aVar != null) {
            aVar.a(bVar);
        } else {
            OTLogger.a("OneTrust", 6, "Error on sending UI events, listener set was found to be null.This could be because the activity has been recreated. \n Please set listener to get UI event callbacks.");
        }
        int i10 = 0;
        if (this.f22592l.has("SubGroups") && com.onetrust.otpublishers.headless.Internal.c.q(this.f22592l.optString("Parent"))) {
            OTPublishersHeadlessSDK oTPublishersHeadlessSDK = this.f22591k;
            JSONObject jSONObject = this.f22592l;
            while (i10 < jSONObject.getJSONArray("SubGroups").length()) {
                try {
                    oTPublishersHeadlessSDK.updatePurposeLegitInterest(jSONObject.getJSONArray("SubGroups").getJSONObject(i10).optString("CustomGroupId"), z10);
                    i10++;
                } catch (Exception e10) {
                    com.onetrust.otpublishers.headless.Internal.Helper.j.a(e10, new StringBuilder("error while updating subgroup LI status on TV, err : "), "OneTrust", 6);
                }
            }
        } else if (!this.f22592l.has("SubGroups") && !com.onetrust.otpublishers.headless.Internal.c.q(this.f22592l.optString("Parent"))) {
            String strOptString2 = this.f22592l.optString("Parent");
            if (z10) {
                try {
                    com.onetrust.otpublishers.headless.UI.TVUI.datautils.c cVarJ = com.onetrust.otpublishers.headless.UI.TVUI.datautils.c.j();
                    OTPublishersHeadlessSDK oTPublishersHeadlessSDK2 = this.f22591k;
                    JSONObject jSONObject2 = cVarJ.f22363c;
                    if (jSONObject2.names().toString().contains(strOptString2)) {
                        JSONArray jSONArrayOptJSONArray = jSONObject2.optJSONArray(strOptString2);
                        int i11 = 0;
                        while (true) {
                            if (i11 >= jSONArrayOptJSONArray.length()) {
                                i10 = 1;
                                break;
                            } else if (oTPublishersHeadlessSDK2.getPurposeLegitInterestLocal(jSONArrayOptJSONArray.getString(i11)) == 0) {
                                break;
                            } else {
                                i11++;
                            }
                        }
                    }
                    if (i10 != 0) {
                        this.f22591k.updatePurposeLegitInterest(strOptString2, true);
                    }
                } catch (JSONException e11) {
                    com.onetrust.otpublishers.headless.Internal.Helper.p.a(e11, new StringBuilder("error while updating parent LI status on TV, err: "), "OneTrust", 6);
                }
            } else {
                this.f22591k.updatePurposeLegitInterest(strOptString2, false);
            }
        }
        com.onetrust.otpublishers.headless.UI.TVUI.adapter.j jVar = this.f22597q;
        if (jVar != null) {
            jVar.notifyDataSetChanged();
        }
        int i12 = this.B;
        int i13 = 2;
        if (i12 != 0 && i12 != 2) {
            i13 = 3;
        }
        this.B = i13;
    }

    @Override // com.onetrust.otpublishers.headless.UI.TVUI.adapter.j.a
    public final void a() {
    }

    @Override // androidx.fragment.app.Fragment
    public final void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        this.f22587g = getContext();
    }

    @Override // androidx.fragment.app.Fragment
    @RequiresApi(api = 21)
    public final View onCreateView(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Context context = this.f22587g;
        int i10 = p6.e.f32888v;
        if (com.onetrust.otpublishers.headless.Internal.c.x(context)) {
            layoutInflater = layoutInflater.cloneInContext(new ContextThemeWrapper(context, p6.g.f32919b));
        }
        View viewInflate = layoutInflater.inflate(i10, viewGroup, false);
        r(viewInflate);
        w();
        return viewInflate;
    }

    @Override // android.view.View.OnFocusChangeListener
    @RequiresApi(api = 21)
    public final void onFocusChange(View view, boolean z10) {
        if (view.getId() == p6.d.f32753m6) {
            if (z10) {
                com.onetrust.otpublishers.headless.UI.UIProperty.f fVar = this.f22599s.f22370j.f22873y;
                t(fVar.f22767j, fVar.f22766i);
                this.f22600t.setCardElevation(6.0f);
            } else {
                t(this.f22599s.m(), this.L);
                this.f22600t.setCardElevation(1.0f);
            }
        }
        if (view.getId() == p6.d.f32744l6) {
            if (z10) {
                com.onetrust.otpublishers.headless.UI.UIProperty.f fVar2 = this.f22599s.f22370j.f22873y;
                y(fVar2.f22767j, fVar2.f22766i);
                this.f22601u.setCardElevation(6.0f);
            } else {
                y(this.f22599s.m(), this.L);
                this.f22601u.setCardElevation(1.0f);
            }
        }
        if (view.getId() == p6.d.C0) {
            v(z10, this.f22599s.f22370j.f22873y, this.C, this.E, this.G);
        }
        if (view.getId() == p6.d.D0) {
            v(z10, this.f22599s.f22370j.f22873y, this.D, this.F, this.H);
        }
        if (view.getId() == p6.d.F0) {
            v(z10, this.f22599s.f22370j.f22873y, this.I, this.J, this.K);
        }
        if (view.getId() == p6.d.f32771o6) {
            com.onetrust.otpublishers.headless.UI.Helper.i.i(z10, this.f22599s.f22370j.f22873y, this.A);
        }
    }

    @Override // android.view.View.OnKeyListener
    public final boolean onKey(View view, int i10, KeyEvent keyEvent) {
        Button button;
        if (this.f22599s.q()) {
            if (view.getId() == p6.d.f32753m6 && com.onetrust.otpublishers.headless.UI.Helper.i.a(i10, keyEvent) == 21) {
                boolean z10 = !this.f22603w.isChecked();
                this.f22603w.setChecked(z10);
                u(z10);
            } else if (view.getId() == p6.d.f32744l6 && com.onetrust.otpublishers.headless.UI.Helper.i.a(i10, keyEvent) == 21) {
                this.f22604x.setChecked(!r0.isChecked());
            }
        } else if (view.getId() == p6.d.f32753m6 && com.onetrust.otpublishers.headless.UI.Helper.i.a(i10, keyEvent) == 21) {
            if (!this.f22605y.isChecked()) {
                u(true);
                this.f22605y.setChecked(true);
                this.f22606z.setChecked(false);
                this.B = 1;
            }
        } else if (view.getId() == p6.d.f32744l6 && com.onetrust.otpublishers.headless.UI.Helper.i.a(i10, keyEvent) == 21 && !this.f22606z.isChecked()) {
            u(false);
            this.f22605y.setChecked(false);
            this.f22606z.setChecked(true);
            this.B = 1;
        }
        if (view.getId() == p6.d.C0 && com.onetrust.otpublishers.headless.UI.Helper.i.a(i10, keyEvent) == 21) {
            HashMap map = new HashMap();
            map.put(this.f22592l.optString("CustomGroupId"), this.f22592l.optString("Type"));
            k kVar = (k) ((q) this.f22595o).f22611c;
            kVar.f22576j = 4;
            b bVar = kVar.f22577k;
            if (bVar != null && bVar.getArguments() != null) {
                kVar.f22577k.getArguments().putInt("OT_TV_FOCUSED_BTN", 1);
            }
            kVar.y(map, true, false);
        }
        if (view.getId() == p6.d.D0 && com.onetrust.otpublishers.headless.UI.Helper.i.a(i10, keyEvent) == 21) {
            ((q) this.f22595o).u(this.f22592l, true, true);
        }
        if (view.getId() == p6.d.f32771o6 && com.onetrust.otpublishers.headless.UI.Helper.i.a(i10, keyEvent) == 21) {
            boolean z11 = this.f22591k.getPurposeConsentLocal(this.f22592l.optString("CustomGroupId")) == 1;
            boolean z12 = this.f22591k.getPurposeLegitInterestLocal(this.f22592l.optString("CustomGroupId")) == 1;
            a aVar = this.f22595o;
            int i11 = this.B;
            q qVar = (q) aVar;
            qVar.getChildFragmentManager().popBackStackImmediate();
            g gVar = qVar.f22623o;
            if (gVar != null) {
                gVar.P.requestFocus();
                if (i11 == 1) {
                    qVar.f22623o.u(z11);
                } else if (i11 == 2) {
                    qVar.f22623o.y(z12);
                } else if (i11 == 3) {
                    qVar.f22623o.u(z11);
                    qVar.f22623o.y(z12);
                }
            }
        }
        if (view.getId() != p6.d.R2 || keyEvent.getKeyCode() != 20) {
            if (view.getId() == p6.d.F0 && com.onetrust.otpublishers.headless.UI.Helper.i.a(i10, keyEvent) == 21) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.f22592l.optString("CustomGroupId"));
                ((q) this.f22595o).t(arrayList);
            }
            return false;
        }
        q qVar2 = (q) this.f22595o;
        if (qVar2.f22614f.getVisibility() == 0) {
            button = qVar2.f22614f;
        } else {
            if (qVar2.f22615g.getVisibility() != 0) {
                if (qVar2.f22613e.getVisibility() == 0) {
                    button = qVar2.f22613e;
                }
                return true;
            }
            button = qVar2.f22615g;
        }
        button.requestFocus();
        return true;
    }

    public final void r(@NonNull View view) {
        this.f22581a = (TextView) view.findViewById(p6.d.f32865z5);
        this.f22582b = (TextView) view.findViewById(p6.d.f32857y5);
        this.f22588h = (LinearLayout) view.findViewById(p6.d.Z1);
        this.f22589i = (LinearLayout) view.findViewById(p6.d.X1);
        this.f22586f = (RecyclerView) view.findViewById(p6.d.f32780p6);
        this.f22583c = (TextView) view.findViewById(p6.d.f32671d5);
        this.f22598r = view.findViewById(p6.d.Q2);
        this.f22593m = (LinearLayout) view.findViewById(p6.d.P5);
        this.f22600t = (CardView) view.findViewById(p6.d.f32753m6);
        this.f22601u = (CardView) view.findViewById(p6.d.f32744l6);
        this.f22605y = (CheckBox) view.findViewById(p6.d.H5);
        this.f22606z = (CheckBox) view.findViewById(p6.d.F5);
        this.f22584d = (TextView) view.findViewById(p6.d.f32641a2);
        this.f22585e = (TextView) view.findViewById(p6.d.Y1);
        this.f22590j = (TextView) view.findViewById(p6.d.R2);
        this.f22602v = (TextView) view.findViewById(p6.d.L);
        this.f22603w = (CheckBox) view.findViewById(p6.d.D5);
        this.f22604x = (CheckBox) view.findViewById(p6.d.V5);
        this.A = (ImageView) view.findViewById(p6.d.f32771o6);
        this.f22586f.setHasFixedSize(true);
        this.f22586f.setLayoutManager(new LinearLayoutManager(getActivity()));
        this.f22600t.setOnKeyListener(this);
        this.f22601u.setOnKeyListener(this);
        this.f22600t.setOnFocusChangeListener(this);
        this.f22601u.setOnFocusChangeListener(this);
        this.A.setOnKeyListener(this);
        this.f22590j.setOnKeyListener(this);
        this.A.setOnFocusChangeListener(this);
        this.I = (CardView) view.findViewById(p6.d.F0);
        this.J = (LinearLayout) view.findViewById(p6.d.E2);
        this.K = (TextView) view.findViewById(p6.d.F2);
        this.f22603w.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.onetrust.otpublishers.headless.UI.TVUI.fragments.l
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
                this.f22579a.s(compoundButton, z10);
            }
        });
        this.f22604x.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.onetrust.otpublishers.headless.UI.TVUI.fragments.m
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
                this.f22580a.x(compoundButton, z10);
            }
        });
        this.C = (CardView) view.findViewById(p6.d.C0);
        this.E = (LinearLayout) view.findViewById(p6.d.f32862z2);
        this.G = (TextView) view.findViewById(p6.d.A2);
        this.D = (CardView) view.findViewById(p6.d.D0);
        this.F = (LinearLayout) view.findViewById(p6.d.B2);
        this.H = (TextView) view.findViewById(p6.d.C2);
        this.C.setOnKeyListener(this);
        this.C.setOnFocusChangeListener(this);
        this.D.setOnKeyListener(this);
        this.D.setOnFocusChangeListener(this);
        this.I.setOnKeyListener(this);
        this.I.setOnFocusChangeListener(this);
    }

    public final void t(String str, String str2) {
        int[][] iArr = {new int[]{R.attr.state_checked}, new int[0]};
        int[] iArr2 = {Color.parseColor(str), Color.parseColor(str)};
        CompoundButtonCompat.setButtonTintList(this.f22603w, new ColorStateList(iArr, iArr2));
        CompoundButtonCompat.setButtonTintList(this.f22605y, new ColorStateList(iArr, iArr2));
        this.f22602v.setTextColor(Color.parseColor(str));
        this.f22584d.setTextColor(Color.parseColor(str));
        this.f22588h.setBackgroundColor(Color.parseColor(str2));
        com.onetrust.otpublishers.headless.UI.Helper.i.f(this.f22584d, str);
    }

    public final void u(boolean z10) {
        com.onetrust.otpublishers.headless.Internal.Preferences.h hVar;
        boolean z11;
        String strOptString = this.f22592l.optString("CustomGroupId");
        com.onetrust.otpublishers.headless.Internal.Event.b bVar = new com.onetrust.otpublishers.headless.Internal.Event.b(7);
        bVar.f21746b = strOptString;
        bVar.f21747c = z10 ? 1 : 0;
        com.onetrust.otpublishers.headless.Internal.Event.a aVar = this.f22594n;
        if (aVar != null) {
            aVar.a(bVar);
        } else {
            OTLogger.a("OneTrust", 6, "Error on sending UI events, listener set was found to be null.This could be because the activity has been recreated. \n Please set listener to get UI event callbacks.");
        }
        this.f22591k.updatePurposeConsent(strOptString, z10);
        if (this.f22592l.optBoolean("IsIabPurpose")) {
            return;
        }
        Context contextRequireContext = requireContext();
        new JSONObject();
        SharedPreferences sharedPreferences = contextRequireContext.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0);
        if (com.onetrust.otpublishers.headless.Internal.Helper.l.a(contextRequireContext)) {
            hVar = new com.onetrust.otpublishers.headless.Internal.Preferences.h(contextRequireContext, sharedPreferences, sharedPreferences.getString("OT_ACTIVE_PROFILE_ID", ""));
            z11 = true;
        } else {
            hVar = null;
            z11 = false;
        }
        if (z11) {
            sharedPreferences = hVar;
        }
        new com.onetrust.otpublishers.headless.Internal.Preferences.e(contextRequireContext);
        OTPublishersHeadlessSDK oTPublishersHeadlessSDK = this.f22591k;
        String string = sharedPreferences.getString("OTT_INTERNAL_SDK_GROUP_MAP", "");
        JSONArray jSONArray = new JSONArray();
        if (!com.onetrust.otpublishers.headless.Internal.c.q(string)) {
            try {
                JSONObject jSONObject = new JSONObject(string);
                if (jSONObject.has(strOptString)) {
                    jSONArray = new JSONArray(jSONObject.get(strOptString).toString());
                }
            } catch (JSONException e10) {
                com.onetrust.otpublishers.headless.Internal.Helper.p.a(e10, new StringBuilder("Error while fetching Sdks by group : "), "SdkListHelper", 6);
            }
        }
        for (int i10 = 0; i10 < jSONArray.length(); i10++) {
            try {
                oTPublishersHeadlessSDK.updateSDKConsentStatus(jSONArray.get(i10).toString(), z10);
            } catch (JSONException e11) {
                com.onetrust.otpublishers.headless.Internal.Helper.p.a(e11, new StringBuilder("Error while Updating consent of SDK "), "SdkListHelper", 6);
            }
        }
    }

    public final void v(boolean z10, com.onetrust.otpublishers.headless.UI.UIProperty.f fVar, CardView cardView, LinearLayout linearLayout, TextView textView) {
        String strM;
        if (z10) {
            cardView.setElevation(6.0f);
            if (com.onetrust.otpublishers.headless.Internal.c.q(fVar.f22766i) || com.onetrust.otpublishers.headless.Internal.c.q(fVar.f22767j)) {
                return;
            }
            linearLayout.setBackgroundColor(Color.parseColor(fVar.f22766i));
            strM = fVar.f22767j;
        } else {
            cardView.setElevation(1.0f);
            linearLayout.setBackgroundColor(Color.parseColor(this.L));
            strM = this.f22599s.m();
        }
        textView.setTextColor(Color.parseColor(strM));
    }

    @RequiresApi(api = 21)
    public final void w() {
        ImageView imageView;
        int i10;
        com.onetrust.otpublishers.headless.Internal.Preferences.h hVar;
        JSONObject jSONObject;
        this.f22599s = com.onetrust.otpublishers.headless.UI.TVUI.datautils.c.j();
        com.onetrust.otpublishers.headless.UI.TVUI.datautils.b bVarA = com.onetrust.otpublishers.headless.UI.TVUI.datautils.b.a();
        Context context = this.f22587g;
        TextView textView = this.f22581a;
        JSONObject jSONObject2 = this.f22592l;
        com.onetrust.otpublishers.headless.UI.Helper.l.j(context, textView, jSONObject2.optString(com.onetrust.otpublishers.headless.Internal.c.q(jSONObject2.optString("GroupNameOTT")) ? "GroupName" : "GroupNameOTT"));
        this.f22584d.setText(bVarA.f22339b);
        this.f22585e.setText(bVarA.f22340c);
        TextView textView2 = this.f22590j;
        com.onetrust.otpublishers.headless.UI.TVUI.datautils.c cVar = this.f22599s;
        JSONObject jSONObject3 = this.f22592l;
        cVar.getClass();
        String strN = com.onetrust.otpublishers.headless.UI.TVUI.datautils.c.n(jSONObject3);
        textView2.setVisibility((com.onetrust.otpublishers.headless.Internal.c.q(strN) || !cVar.f22365e || ProxyConfig.MATCH_ALL_SCHEMES.equals(strN)) ? 8 : 0);
        com.onetrust.otpublishers.headless.UI.Helper.l.j(this.f22587g, this.f22590j, com.onetrust.otpublishers.headless.UI.TVUI.datautils.c.n(this.f22592l));
        this.G.setText(this.f22599s.f22370j.E.f22787a.f22724e);
        this.H.setText(this.f22599s.f22376p);
        this.A.setVisibility(0);
        if (com.onetrust.otpublishers.headless.Internal.c.q(com.onetrust.otpublishers.headless.UI.TVUI.datautils.c.k(this.f22592l))) {
            this.f22582b.setVisibility(8);
        } else {
            com.onetrust.otpublishers.headless.UI.Helper.l.j(this.f22587g, this.f22582b, com.onetrust.otpublishers.headless.UI.TVUI.datautils.c.k(this.f22592l));
        }
        com.onetrust.otpublishers.headless.UI.TVUI.datautils.c cVar2 = this.f22599s;
        this.L = com.onetrust.otpublishers.headless.UI.Helper.i.j(cVar2.a());
        String strM = cVar2.m();
        this.f22582b.setTextColor(Color.parseColor(strM));
        this.f22581a.setTextColor(Color.parseColor(strM));
        this.f22593m.setBackgroundColor(Color.parseColor(cVar2.a()));
        this.f22598r.setBackgroundColor(Color.parseColor(strM));
        this.f22583c.setTextColor(Color.parseColor(strM));
        this.f22590j.setTextColor(Color.parseColor(strM));
        v(false, cVar2.f22370j.f22873y, this.C, this.E, this.G);
        v(false, cVar2.f22370j.f22873y, this.D, this.F, this.H);
        t(strM, this.L);
        y(strM, this.L);
        this.f22600t.setCardElevation(1.0f);
        this.f22601u.setCardElevation(1.0f);
        com.onetrust.otpublishers.headless.UI.Helper.i.i(false, cVar2.f22370j.f22873y, this.A);
        boolean z10 = true;
        (this.f22591k.getPurposeConsentLocal(this.f22592l.optString("CustomGroupId")) == 1 ? this.f22605y : this.f22606z).setChecked(true);
        this.f22600t.setVisibility(this.f22599s.p(this.f22592l));
        this.f22601u.setVisibility(this.f22599s.p(this.f22592l));
        if (this.f22592l.optBoolean("IsIabPurpose")) {
            this.f22600t.setVisibility(this.f22592l.optBoolean("HasConsentOptOut") ? 0 : 8);
            this.f22601u.setVisibility(this.f22592l.optBoolean("HasLegIntOptOut") ? 0 : 8);
        }
        if (this.f22600t.getVisibility() == 0) {
            imageView = this.A;
            i10 = p6.d.f32753m6;
        } else {
            imageView = this.A;
            i10 = p6.d.f32857y5;
        }
        imageView.setNextFocusDownId(i10);
        this.C.setVisibility(this.f22592l.optBoolean("IsIabPurpose") ? 0 : 8);
        this.D.setVisibility((this.f22592l.optBoolean("IsIabPurpose") && com.onetrust.otpublishers.headless.UI.Helper.l.u(this.f22592l)) ? 0 : 8);
        CardView cardView = this.I;
        com.onetrust.otpublishers.headless.UI.TVUI.datautils.c cVar3 = this.f22599s;
        JSONObject jSONObject4 = this.f22592l;
        cVar3.getClass();
        cardView.setVisibility((jSONObject4.optBoolean("ShowSDKListLink") && cVar3.f22374n && com.onetrust.otpublishers.headless.UI.TVUI.datautils.c.i(jSONObject4)) ? 0 : 8);
        this.K.setText(this.f22599s.f22370j.F.f22787a.f22724e);
        v(false, this.f22599s.f22370j.f22873y, this.I, this.J, this.K);
        if (this.f22592l.optString("Status").contains("always")) {
            if (!this.f22592l.optBoolean("isAlertNotice")) {
                this.f22600t.setVisibility(0);
            }
            com.onetrust.otpublishers.headless.UI.TVUI.datautils.c cVar4 = this.f22599s;
            String str = cVar4.f22370j.f22869u.f22724e;
            if (str == null) {
                str = cVar4.f22362b;
            }
            if (cVar4.q()) {
                this.f22584d.setText(this.f22599s.b(!this.f22592l.optBoolean("IsIabPurpose")));
                this.f22602v.setVisibility(0);
                this.f22602v.setText(str);
            } else {
                this.f22584d.setText(str);
                (this.f22591k.getPurposeConsentLocal(this.f22592l.optString("CustomGroupId")) == 1 ? this.f22605y : this.f22606z).setChecked(true);
            }
            this.f22605y.setVisibility(8);
            if (com.onetrust.otpublishers.headless.Internal.c.q(str)) {
                this.f22600t.setVisibility(8);
            }
        } else if (this.f22599s.q()) {
            OTLogger.a("TVPCDetail", 3, "Showing Consent Toggle UI");
            this.f22605y.setVisibility(8);
            this.f22606z.setVisibility(8);
            this.f22584d.setText(this.f22599s.b(!this.f22592l.optBoolean("IsIabPurpose")));
            this.f22585e.setText(this.f22599s.f22368h);
            int purposeLegitInterestLocal = this.f22591k.getPurposeLegitInterestLocal(this.f22592l.optString("CustomGroupId"));
            int i11 = (!this.f22599s.f22369i || purposeLegitInterestLocal <= -1) ? 8 : 0;
            this.f22601u.setVisibility(i11);
            this.f22604x.setVisibility(i11);
            this.f22603w.setVisibility(0);
            if (i11 == 0) {
                this.f22604x.setChecked(purposeLegitInterestLocal == 1);
            }
            this.f22603w.setChecked(this.f22591k.getPurposeConsentLocal(this.f22592l.optString("CustomGroupId")) == 1);
        }
        this.f22583c.setVisibility(8);
        this.f22598r.setVisibility(this.C.getVisibility());
        this.f22598r.setVisibility(this.D.getVisibility());
        if (this.f22596p || com.onetrust.otpublishers.headless.UI.TVUI.datautils.c.r(this.f22592l)) {
            return;
        }
        Context context2 = this.f22587g;
        SharedPreferences sharedPreferences = context2.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0);
        if (com.onetrust.otpublishers.headless.Internal.Helper.l.a(context2)) {
            hVar = new com.onetrust.otpublishers.headless.Internal.Preferences.h(context2, sharedPreferences, sharedPreferences.getString("OT_ACTIVE_PROFILE_ID", ""));
        } else {
            hVar = null;
            z10 = false;
        }
        if (z10) {
            sharedPreferences = hVar;
        }
        String string = sharedPreferences.getString("OT_VENDOR_COUNT_FOR_CATEGORIES", "");
        OTLogger.a("IAB2V2Flow", 3, "Getting vendorCountForCategoryString = " + string);
        if (com.onetrust.otpublishers.headless.Internal.c.q(string)) {
            jSONObject = new JSONObject();
        } else {
            try {
                jSONObject = new JSONObject(string);
            } catch (JSONException e10) {
                com.onetrust.otpublishers.headless.Internal.Helper.p.a(e10, new StringBuilder("Error on getting vendor count for categories : "), "OTSPUtils", 6);
                jSONObject = new JSONObject();
            }
        }
        JSONArray jSONArrayOptJSONArray = this.f22592l.optJSONArray("SubGroups");
        Objects.requireNonNull(jSONArrayOptJSONArray);
        com.onetrust.otpublishers.headless.UI.TVUI.adapter.j jVar = new com.onetrust.otpublishers.headless.UI.TVUI.adapter.j(jSONArrayOptJSONArray, this.f22587g, this.f22591k, this, jSONObject);
        this.f22597q = jVar;
        this.f22586f.setAdapter(jVar);
        this.f22583c.setText(bVarA.f22341d);
        this.f22583c.setVisibility(0);
        this.f22598r.setVisibility(this.f22601u.getVisibility());
    }

    public final void y(String str, String str2) {
        int[][] iArr = {new int[]{R.attr.state_checked}, new int[0]};
        int[] iArr2 = {Color.parseColor(str), Color.parseColor(str)};
        CompoundButtonCompat.setButtonTintList(this.f22604x, new ColorStateList(iArr, iArr2));
        CompoundButtonCompat.setButtonTintList(this.f22606z, new ColorStateList(iArr, iArr2));
        this.f22585e.setTextColor(Color.parseColor(str));
        this.f22589i.setBackgroundColor(Color.parseColor(str2));
        com.onetrust.otpublishers.headless.UI.Helper.i.f(this.f22585e, str);
    }

    @Override // com.onetrust.otpublishers.headless.UI.TVUI.adapter.j.a
    public final void a(JSONObject jSONObject) {
        ((q) this.f22595o).u(jSONObject, true, false);
    }
}
