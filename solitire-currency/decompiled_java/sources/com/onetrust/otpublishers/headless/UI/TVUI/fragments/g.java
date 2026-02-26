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
import android.widget.RelativeLayout;
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
import com.onetrust.otpublishers.headless.Public.Keys.OTFragmentTags;
import com.onetrust.otpublishers.headless.Public.OTPublishersHeadlessSDK;
import com.onetrust.otpublishers.headless.UI.TVUI.adapter.j;
import com.onetrust.otpublishers.headless.qrcode.OTQRCodeUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class g extends Fragment implements j.a, View.OnKeyListener, View.OnFocusChangeListener {
    public View A;
    public com.onetrust.otpublishers.headless.UI.TVUI.datautils.c B;
    public CardView C;
    public CardView D;
    public CardView E;
    public CardView F;
    public CardView G;
    public LinearLayout H;
    public LinearLayout I;
    public LinearLayout J;
    public LinearLayout K;
    public LinearLayout L;
    public TextView M;
    public TextView N;
    public TextView O;
    public RelativeLayout P;
    public TextView Q;
    public CheckBox R;
    public CheckBox S;
    public CheckBox T;
    public CheckBox U;
    public boolean V = true;
    public boolean W = true;
    public String X;
    public ImageView Y;
    public LinearLayout Z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f22535a;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public TextView f22536a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f22537b;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public View f22538b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f22539c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f22540d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public TextView f22541e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public RecyclerView f22542f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Context f22543g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public LinearLayout f22544h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public LinearLayout f22545i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public TextView f22546j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public OTPublishersHeadlessSDK f22547k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public TextView f22548l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public TextView f22549m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public TextView f22550n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public TextView f22551o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public TextView f22552p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public View f22553q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Button f22554r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public Button f22555s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public TextView f22556t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public JSONObject f22557u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public LinearLayout f22558v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public com.onetrust.otpublishers.headless.Internal.Event.a f22559w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public a f22560x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f22561y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public com.onetrust.otpublishers.headless.UI.TVUI.adapter.j f22562z;

    public interface a {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(CompoundButton compoundButton, boolean z10) {
        String strOptString = this.f22557u.optString("CustomGroupId");
        this.f22547k.updatePurposeLegitInterest(strOptString, z10);
        com.onetrust.otpublishers.headless.Internal.Event.b bVar = new com.onetrust.otpublishers.headless.Internal.Event.b(11);
        bVar.f21746b = strOptString;
        bVar.f21747c = z10 ? 1 : 0;
        com.onetrust.otpublishers.headless.Internal.Event.a aVar = this.f22559w;
        if (aVar != null) {
            aVar.a(bVar);
        } else {
            OTLogger.a("OneTrust", 6, "Error on sending UI events, listener set was found to be null.This could be because the activity has been recreated. \n Please set listener to get UI event callbacks.");
        }
        if (this.f22557u.has("SubGroups") && com.onetrust.otpublishers.headless.Internal.c.q(this.f22557u.optString("Parent")) && this.W) {
            OTPublishersHeadlessSDK oTPublishersHeadlessSDK = this.f22547k;
            JSONObject jSONObject = this.f22557u;
            for (int i10 = 0; i10 < jSONObject.getJSONArray("SubGroups").length(); i10++) {
                try {
                    oTPublishersHeadlessSDK.updatePurposeLegitInterest(jSONObject.getJSONArray("SubGroups").getJSONObject(i10).optString("CustomGroupId"), z10);
                } catch (Exception e10) {
                    com.onetrust.otpublishers.headless.Internal.Helper.j.a(e10, new StringBuilder("error while updating subgroup LI status on TV, err : "), "OneTrust", 6);
                }
            }
        }
        com.onetrust.otpublishers.headless.UI.TVUI.adapter.j jVar = this.f22562z;
        if (jVar != null) {
            jVar.notifyDataSetChanged();
        }
        this.W = true;
    }

    public final void A(boolean z10) {
        String strOptString = this.f22557u.optString("CustomGroupId");
        this.f22547k.updatePurposeConsent(strOptString, z10);
        com.onetrust.otpublishers.headless.Internal.Event.b bVar = new com.onetrust.otpublishers.headless.Internal.Event.b(7);
        bVar.f21746b = strOptString;
        bVar.f21747c = z10 ? 1 : 0;
        com.onetrust.otpublishers.headless.Internal.Event.a aVar = this.f22559w;
        if (aVar != null) {
            aVar.a(bVar);
        } else {
            OTLogger.a("OneTrust", 6, "Error on sending UI events, listener set was found to be null.This could be because the activity has been recreated. \n Please set listener to get UI event callbacks.");
        }
        t(strOptString, z10);
        if (this.f22557u.has("SubGroups") && com.onetrust.otpublishers.headless.Internal.c.q(this.f22557u.optString("Parent")) && this.V) {
            OTPublishersHeadlessSDK oTPublishersHeadlessSDK = this.f22547k;
            JSONObject jSONObject = this.f22557u;
            for (int i10 = 0; i10 < jSONObject.getJSONArray("SubGroups").length(); i10++) {
                try {
                    String strOptString2 = jSONObject.getJSONArray("SubGroups").getJSONObject(i10).optString("CustomGroupId");
                    oTPublishersHeadlessSDK.updatePurposeConsent(strOptString2, z10);
                    t(strOptString2, z10);
                } catch (Exception e10) {
                    com.onetrust.otpublishers.headless.Internal.Helper.j.a(e10, new StringBuilder("error while updating subgroup status on TV, err : "), "OneTrust", 6);
                }
            }
        }
        com.onetrust.otpublishers.headless.UI.TVUI.adapter.j jVar = this.f22562z;
        if (jVar != null) {
            jVar.notifyDataSetChanged();
        }
        this.V = true;
    }

    @Override // com.onetrust.otpublishers.headless.UI.TVUI.adapter.j.a
    public final void a() {
        ((q) this.f22560x).a(24);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        this.f22543g = getContext();
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Context context = this.f22543g;
        int i10 = p6.e.f32883q;
        if (com.onetrust.otpublishers.headless.Internal.c.x(context)) {
            layoutInflater = layoutInflater.cloneInContext(new ContextThemeWrapper(context, p6.g.f32919b));
        }
        View viewInflate = layoutInflater.inflate(i10, viewGroup, false);
        q(viewInflate);
        w();
        com.onetrust.otpublishers.headless.UI.Helper.c cVar = this.B.f22378r;
        if (cVar.f22152o == 8 && cVar.f22156s == 8 && cVar.f22157t == 8) {
            this.f22535a.setNextFocusUpId(p6.d.f32865z5);
        }
        return viewInflate;
    }

    @Override // android.view.View.OnFocusChangeListener
    @RequiresApi(api = 21)
    public final void onFocusChange(View view, boolean z10) {
        if (view.getId() == p6.d.f32753m6) {
            if (z10) {
                com.onetrust.otpublishers.headless.UI.UIProperty.f fVar = this.B.f22370j.f22873y;
                s(fVar.f22767j, fVar.f22766i);
                this.C.setCardElevation(6.0f);
            } else {
                s(this.B.m(), this.X);
                this.C.setCardElevation(1.0f);
            }
        }
        if (view.getId() == p6.d.f32744l6) {
            if (z10) {
                com.onetrust.otpublishers.headless.UI.UIProperty.f fVar2 = this.B.f22370j.f22873y;
                x(fVar2.f22767j, fVar2.f22766i);
                this.D.setCardElevation(6.0f);
            } else {
                x(this.B.m(), this.X);
                this.D.setCardElevation(1.0f);
            }
        }
        if (view.getId() == p6.d.C0) {
            v(z10, this.B.f22370j.f22873y, this.E, this.H, this.M);
        }
        if (view.getId() == p6.d.D0) {
            v(z10, this.B.f22370j.f22873y, this.F, this.I, this.N);
        }
        if (view.getId() == p6.d.E0) {
            v(z10, this.B.f22370j.f22873y, this.G, this.J, this.O);
        }
        if (view.getId() == p6.d.f32752m5) {
            com.onetrust.otpublishers.headless.UI.Helper.i.k(this.f22555s, this.B.f22370j.f22873y, z10);
        }
        if (view.getId() == p6.d.f32761n5) {
            com.onetrust.otpublishers.headless.UI.Helper.i.k(this.f22554r, this.B.f22370j.f22873y, z10);
        }
    }

    @Override // android.view.View.OnKeyListener
    public final boolean onKey(View view, int i10, KeyEvent keyEvent) {
        if (this.B.q()) {
            if (view.getId() == p6.d.f32753m6 && com.onetrust.otpublishers.headless.UI.Helper.i.a(i10, keyEvent) == 21) {
                boolean z10 = !this.R.isChecked();
                this.R.setChecked(z10);
                A(z10);
            } else if (view.getId() == p6.d.f32744l6 && com.onetrust.otpublishers.headless.UI.Helper.i.a(i10, keyEvent) == 21) {
                this.S.setChecked(!r1.isChecked());
            }
        } else if (view.getId() == p6.d.f32753m6 && com.onetrust.otpublishers.headless.UI.Helper.i.a(i10, keyEvent) == 21) {
            if (!this.T.isChecked()) {
                A(true);
                this.T.setChecked(true);
                this.U.setChecked(false);
            }
        } else if (view.getId() == p6.d.f32744l6 && com.onetrust.otpublishers.headless.UI.Helper.i.a(i10, keyEvent) == 21 && !this.U.isChecked()) {
            A(false);
            this.T.setChecked(false);
            this.U.setChecked(true);
        }
        JSONArray jSONArrayOptJSONArray = null;
        if (view.getId() == p6.d.C0 && com.onetrust.otpublishers.headless.UI.Helper.i.a(i10, keyEvent) == 21) {
            HashMap map = new HashMap();
            if (!this.f22557u.optString("Type").equals("IAB2_STACK") && !this.f22557u.optString("Type").equals("IAB2V2_STACK")) {
                map.put(this.f22557u.optString("CustomGroupId"), this.f22557u.optString("Type"));
            }
            JSONObject jSONObject = this.f22557u;
            JSONArray jSONArrayOptJSONArray2 = (jSONObject.optJSONArray("SubGroups") == null || jSONObject.optJSONArray("SubGroups").length() <= 0) ? null : jSONObject.optJSONArray("SubGroups");
            if (jSONArrayOptJSONArray2 != null) {
                for (int i11 = 0; i11 < jSONArrayOptJSONArray2.length(); i11++) {
                    JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray2.optJSONObject(i11);
                    if (jSONObjectOptJSONObject.optBoolean("IsIabPurpose")) {
                        map.put(jSONObjectOptJSONObject.optString("CustomGroupId"), jSONObjectOptJSONObject.optString("Type"));
                    }
                }
            }
            k kVar = (k) ((q) this.f22560x).f22611c;
            kVar.f22576j = 4;
            b bVar = kVar.f22577k;
            if (bVar != null && bVar.getArguments() != null) {
                kVar.f22577k.getArguments().putInt("OT_TV_FOCUSED_BTN", 1);
            }
            kVar.y(map, true, false);
        }
        if (view.getId() == p6.d.D0 && com.onetrust.otpublishers.headless.UI.Helper.i.a(i10, keyEvent) == 21) {
            ((q) this.f22560x).u(this.f22557u, false, true);
        }
        if (i10 == 4 && keyEvent.getAction() == 1) {
            ((q) this.f22560x).a(1);
        }
        if (com.onetrust.otpublishers.headless.UI.Helper.i.a(i10, keyEvent) == 24 || (view.getId() == p6.d.f32769o4 && com.onetrust.otpublishers.headless.UI.Helper.i.a(i10, keyEvent) == 24)) {
            ((q) this.f22560x).a(24);
            return true;
        }
        if (view.getId() == p6.d.R2 && com.onetrust.otpublishers.headless.UI.Helper.i.a(i10, keyEvent) == 24) {
            ((q) this.f22560x).a(24);
        }
        if (view.getId() == p6.d.f32857y5 && com.onetrust.otpublishers.headless.UI.Helper.i.a(i10, keyEvent) == 24) {
            ((q) this.f22560x).a(24);
        }
        if (view.getId() == p6.d.f32865z5 && com.onetrust.otpublishers.headless.UI.Helper.i.a(i10, keyEvent) == 24) {
            ((q) this.f22560x).a(24);
        }
        if (view.getId() == p6.d.f32752m5 && com.onetrust.otpublishers.headless.UI.Helper.i.a(i10, keyEvent) == 21) {
            ((q) this.f22560x).a(18);
        }
        if (view.getId() == p6.d.f32761n5 && com.onetrust.otpublishers.headless.UI.Helper.i.a(i10, keyEvent) == 21) {
            ((q) this.f22560x).a(17);
        }
        if (view.getId() == p6.d.E0 && com.onetrust.otpublishers.headless.UI.Helper.i.a(i10, keyEvent) == 21) {
            ArrayList arrayList = new ArrayList();
            if (!com.onetrust.otpublishers.headless.Internal.a.c(this.f22557u.optJSONArray("FirstPartyCookies"))) {
                arrayList.add(this.f22557u.optString("CustomGroupId"));
            }
            JSONObject jSONObject2 = this.f22557u;
            if (jSONObject2.optJSONArray("SubGroups") != null && jSONObject2.optJSONArray("SubGroups").length() > 0) {
                jSONArrayOptJSONArray = jSONObject2.optJSONArray("SubGroups");
            }
            if (jSONArrayOptJSONArray != null) {
                for (int i12 = 0; i12 < jSONArrayOptJSONArray.length(); i12++) {
                    JSONObject jSONObjectOptJSONObject2 = jSONArrayOptJSONArray.optJSONObject(i12);
                    if (!jSONObjectOptJSONObject2.optBoolean("IsIabPurpose") && jSONObjectOptJSONObject2.optBoolean("ShowSDKListLink")) {
                        arrayList.add(jSONObjectOptJSONObject2.optString("CustomGroupId"));
                    }
                }
            }
            ((q) this.f22560x).t(arrayList);
        }
        return false;
    }

    public final void q(@NonNull View view) {
        this.f22535a = (TextView) view.findViewById(p6.d.f32865z5);
        this.f22537b = (TextView) view.findViewById(p6.d.f32857y5);
        this.f22544h = (LinearLayout) view.findViewById(p6.d.Z1);
        this.f22545i = (LinearLayout) view.findViewById(p6.d.X1);
        this.f22556t = (TextView) view.findViewById(p6.d.f32866z6);
        this.f22542f = (RecyclerView) view.findViewById(p6.d.f32780p6);
        this.f22539c = (TextView) view.findViewById(p6.d.f32671d5);
        this.A = view.findViewById(p6.d.Q2);
        this.f22558v = (LinearLayout) view.findViewById(p6.d.P5);
        this.C = (CardView) view.findViewById(p6.d.f32753m6);
        this.D = (CardView) view.findViewById(p6.d.f32744l6);
        this.T = (CheckBox) view.findViewById(p6.d.G5);
        this.U = (CheckBox) view.findViewById(p6.d.E5);
        this.f22542f.setHasFixedSize(true);
        this.f22542f.setLayoutManager(new LinearLayoutManager(getActivity()));
        this.C.setOnKeyListener(this);
        this.D.setOnKeyListener(this);
        this.C.setOnFocusChangeListener(this);
        this.D.setOnFocusChangeListener(this);
        this.f22540d = (TextView) view.findViewById(p6.d.f32641a2);
        this.f22541e = (TextView) view.findViewById(p6.d.Y1);
        this.f22546j = (TextView) view.findViewById(p6.d.R2);
        this.Q = (TextView) view.findViewById(p6.d.L);
        this.R = (CheckBox) view.findViewById(p6.d.D5);
        this.S = (CheckBox) view.findViewById(p6.d.V5);
        this.K = (LinearLayout) view.findViewById(p6.d.L5);
        this.f22548l = (TextView) view.findViewById(p6.d.M5);
        this.f22549m = (TextView) view.findViewById(p6.d.I5);
        this.f22550n = (TextView) view.findViewById(p6.d.f32798r6);
        this.f22551o = (TextView) view.findViewById(p6.d.f32789q6);
        this.f22552p = (TextView) view.findViewById(p6.d.J5);
        this.f22553q = view.findViewById(p6.d.K5);
        this.L = (LinearLayout) view.findViewById(p6.d.X5);
        this.f22554r = (Button) view.findViewById(p6.d.f32761n5);
        this.f22555s = (Button) view.findViewById(p6.d.f32752m5);
        this.S.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.onetrust.otpublishers.headless.UI.TVUI.fragments.f
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
                this.f22508a.r(compoundButton, z10);
            }
        });
        this.E = (CardView) view.findViewById(p6.d.C0);
        this.F = (CardView) view.findViewById(p6.d.D0);
        this.H = (LinearLayout) view.findViewById(p6.d.f32862z2);
        this.I = (LinearLayout) view.findViewById(p6.d.B2);
        this.M = (TextView) view.findViewById(p6.d.A2);
        this.N = (TextView) view.findViewById(p6.d.C2);
        this.G = (CardView) view.findViewById(p6.d.E0);
        this.J = (LinearLayout) view.findViewById(p6.d.D2);
        this.O = (TextView) view.findViewById(p6.d.G2);
        this.P = (RelativeLayout) view.findViewById(p6.d.K3);
        this.E.setOnKeyListener(this);
        this.E.setOnFocusChangeListener(this);
        this.F.setOnKeyListener(this);
        this.F.setOnFocusChangeListener(this);
        this.G.setOnKeyListener(this);
        this.G.setOnFocusChangeListener(this);
        this.f22546j.setOnKeyListener(this);
        this.f22537b.setOnKeyListener(this);
        this.f22535a.setOnKeyListener(this);
        this.f22535a.setOnFocusChangeListener(this);
        this.f22554r.setOnKeyListener(this);
        this.f22554r.setOnFocusChangeListener(this);
        this.f22555s.setOnFocusChangeListener(this);
        this.f22555s.setOnKeyListener(this);
        this.f22556t.setOnKeyListener(this);
        this.f22556t.setOnFocusChangeListener(this);
        this.Z = (LinearLayout) view.findViewById(p6.d.Z5);
        this.Y = (ImageView) view.findViewById(p6.d.f32769o4);
        this.f22536a0 = (TextView) view.findViewById(p6.d.f32654b6);
        this.f22538b0 = view.findViewById(p6.d.f32714i3);
        this.Y.setOnKeyListener(this);
        this.f22536a0.setOnKeyListener(this);
    }

    public final void s(String str, String str2) {
        int[][] iArr = {new int[]{R.attr.state_checked}, new int[0]};
        int[] iArr2 = {Color.parseColor(str), Color.parseColor(str)};
        CompoundButtonCompat.setButtonTintList(this.R, new ColorStateList(iArr, iArr2));
        CompoundButtonCompat.setButtonTintList(this.T, new ColorStateList(iArr, iArr2));
        this.Q.setTextColor(Color.parseColor(str));
        this.f22540d.setTextColor(Color.parseColor(str));
        this.f22544h.setBackgroundColor(Color.parseColor(str2));
        com.onetrust.otpublishers.headless.UI.Helper.i.f(this.f22540d, str);
    }

    public final void t(@NonNull String str, boolean z10) {
        com.onetrust.otpublishers.headless.Internal.Preferences.h hVar;
        boolean z11;
        if (this.f22557u.optBoolean("IsIabPurpose")) {
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
        OTPublishersHeadlessSDK oTPublishersHeadlessSDK = this.f22547k;
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
                oTPublishersHeadlessSDK.updateSDKConsentStatus(jSONArray.get(i10).toString(), z10);
            } catch (JSONException e11) {
                com.onetrust.otpublishers.headless.Internal.Helper.p.a(e11, new StringBuilder("Error while Updating consent of SDK "), "SdkListHelper", 6);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0054 A[Catch: JSONException -> 0x005a, TRY_LEAVE, TryCatch #0 {JSONException -> 0x005a, blocks: (B:7:0x0020, B:9:0x0036, B:10:0x003b, B:12:0x0041, B:15:0x004c, B:19:0x0054), top: B:31:0x0020 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void u(boolean r7) {
        /*
            r6 = this;
            org.json.JSONObject r0 = r6.f22557u
            java.lang.String r1 = "CustomGroupId"
            java.lang.String r0 = r0.optString(r1)
            boolean r0 = com.onetrust.otpublishers.headless.Internal.c.q(r0)
            if (r0 != 0) goto L82
            org.json.JSONObject r0 = r6.f22557u
            java.lang.String r0 = r0.optString(r1)
            r1 = 0
            r6.V = r1
            r2 = 1
            if (r7 != 0) goto L20
            com.onetrust.otpublishers.headless.Public.OTPublishersHeadlessSDK r7 = r6.f22547k
            r7.updatePurposeConsent(r0, r1)
            goto L68
        L20:
            com.onetrust.otpublishers.headless.UI.TVUI.datautils.c r7 = com.onetrust.otpublishers.headless.UI.TVUI.datautils.c.j()     // Catch: org.json.JSONException -> L5a
            com.onetrust.otpublishers.headless.Public.OTPublishersHeadlessSDK r3 = r6.f22547k     // Catch: org.json.JSONException -> L5a
            org.json.JSONObject r7 = r7.f22363c     // Catch: org.json.JSONException -> L5a
            org.json.JSONArray r4 = r7.names()     // Catch: org.json.JSONException -> L5a
            java.lang.String r4 = r4.toString()     // Catch: org.json.JSONException -> L5a
            boolean r4 = r4.contains(r0)     // Catch: org.json.JSONException -> L5a
            if (r4 == 0) goto L51
            org.json.JSONArray r7 = r7.optJSONArray(r0)     // Catch: org.json.JSONException -> L5a
            r4 = r1
        L3b:
            int r5 = r7.length()     // Catch: org.json.JSONException -> L5a
            if (r4 >= r5) goto L4f
            java.lang.String r5 = r7.getString(r4)     // Catch: org.json.JSONException -> L5a
            int r5 = r3.getPurposeConsentLocal(r5)     // Catch: org.json.JSONException -> L5a
            if (r5 != 0) goto L4c
            goto L51
        L4c:
            int r4 = r4 + 1
            goto L3b
        L4f:
            r7 = r2
            goto L52
        L51:
            r7 = r1
        L52:
            if (r7 == 0) goto L68
            com.onetrust.otpublishers.headless.Public.OTPublishersHeadlessSDK r7 = r6.f22547k     // Catch: org.json.JSONException -> L5a
            r7.updatePurposeConsent(r0, r2)     // Catch: org.json.JSONException -> L5a
            goto L68
        L5a:
            r7 = move-exception
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "error while updating parent category status on TV, err: "
            r3.<init>(r4)
            java.lang.String r4 = "OneTrust"
            r5 = 6
            com.onetrust.otpublishers.headless.Internal.Helper.p.a(r7, r3, r4, r5)
        L68:
            com.onetrust.otpublishers.headless.UI.TVUI.datautils.c r7 = r6.B
            boolean r7 = r7.q()
            if (r7 == 0) goto L7f
            com.onetrust.otpublishers.headless.Public.OTPublishersHeadlessSDK r7 = r6.f22547k
            int r7 = r7.getPurposeConsentLocal(r0)
            if (r7 != r2) goto L79
            r1 = r2
        L79:
            android.widget.CheckBox r7 = r6.R
            r7.setChecked(r1)
            goto L82
        L7f:
            r6.z()
        L82:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onetrust.otpublishers.headless.UI.TVUI.fragments.g.u(boolean):void");
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
            linearLayout.setBackgroundColor(Color.parseColor(this.X));
            strM = this.B.m();
        }
        textView.setTextColor(Color.parseColor(strM));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void w() {
        String str;
        String str2;
        int i10;
        String str3;
        com.onetrust.otpublishers.headless.Internal.Preferences.h hVar;
        JSONObject jSONObject;
        boolean z10;
        com.onetrust.otpublishers.headless.Internal.Preferences.h hVar2;
        this.B = com.onetrust.otpublishers.headless.UI.TVUI.datautils.c.j();
        com.onetrust.otpublishers.headless.UI.TVUI.datautils.b bVarA = com.onetrust.otpublishers.headless.UI.TVUI.datautils.b.a();
        Context context = this.f22543g;
        TextView textView = this.f22535a;
        JSONObject jSONObject2 = this.f22557u;
        com.onetrust.otpublishers.headless.UI.Helper.l.j(context, textView, jSONObject2.optString(com.onetrust.otpublishers.headless.Internal.c.q(jSONObject2.optString("GroupNameOTT")) ? "GroupName" : "GroupNameOTT"));
        this.f22540d.setText(bVarA.f22339b);
        this.f22541e.setText(bVarA.f22340c);
        TextView textView2 = this.f22546j;
        com.onetrust.otpublishers.headless.UI.TVUI.datautils.c cVar = this.B;
        JSONObject jSONObject3 = this.f22557u;
        cVar.getClass();
        String strN = com.onetrust.otpublishers.headless.UI.TVUI.datautils.c.n(jSONObject3);
        textView2.setVisibility((com.onetrust.otpublishers.headless.Internal.c.q(strN) || !cVar.f22365e || ProxyConfig.MATCH_ALL_SCHEMES.equals(strN)) ? 8 : 0);
        com.onetrust.otpublishers.headless.UI.Helper.l.j(this.f22543g, this.f22546j, com.onetrust.otpublishers.headless.UI.TVUI.datautils.c.n(this.f22557u));
        this.M.setText(this.B.f22370j.E.f22787a.f22724e);
        this.N.setText(this.B.f22376p);
        if (com.onetrust.otpublishers.headless.Internal.c.q(com.onetrust.otpublishers.headless.UI.TVUI.datautils.c.k(this.f22557u))) {
            this.f22537b.setVisibility(8);
        } else {
            com.onetrust.otpublishers.headless.UI.Helper.l.j(this.f22543g, this.f22537b, com.onetrust.otpublishers.headless.UI.TVUI.datautils.c.k(this.f22557u));
        }
        com.onetrust.otpublishers.headless.UI.TVUI.datautils.c cVar2 = this.B;
        this.X = com.onetrust.otpublishers.headless.UI.Helper.i.j(cVar2.a());
        String strM = cVar2.m();
        this.f22537b.setTextColor(Color.parseColor(strM));
        this.f22535a.setTextColor(Color.parseColor(strM));
        this.f22558v.setBackgroundColor(Color.parseColor(cVar2.a()));
        this.A.setBackgroundColor(Color.parseColor(strM));
        this.f22539c.setTextColor(Color.parseColor(strM));
        this.f22546j.setTextColor(Color.parseColor(strM));
        v(false, cVar2.f22370j.f22873y, this.E, this.H, this.M);
        v(false, cVar2.f22370j.f22873y, this.F, this.I, this.N);
        s(strM, this.X);
        x(strM, this.X);
        this.C.setCardElevation(1.0f);
        this.D.setCardElevation(1.0f);
        z();
        if (this.f22557u.optBoolean("IS_PARTNERS_LINK")) {
            this.C.setVisibility(8);
            this.D.setVisibility(8);
            this.K.setVisibility(8);
            this.L.setVisibility(0);
            this.f22554r.setText(this.B.f22371k);
            Context context2 = getContext();
            TextView textView3 = this.f22556t;
            String str4 = this.B.f22373m;
            if (str4 == null) {
                str4 = "";
            }
            com.onetrust.otpublishers.headless.UI.Helper.l.j(context2, textView3, str4);
            this.f22556t.setTextColor(Color.parseColor(this.B.m()));
            Context context3 = getContext();
            SharedPreferences sharedPreferences = context3.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0);
            if (com.onetrust.otpublishers.headless.Internal.Helper.h.a(Boolean.FALSE, com.onetrust.otpublishers.headless.Internal.Helper.c0.a(context3, "OTT_DEFAULT_USER"), "OT_ENABLE_MULTI_PROFILE")) {
                hVar2 = new com.onetrust.otpublishers.headless.Internal.Preferences.h(context3, sharedPreferences, sharedPreferences.getString("OT_ACTIVE_PROFILE_ID", ""));
                z10 = true;
            } else {
                z10 = false;
                hVar2 = null;
            }
            if (z10) {
                sharedPreferences = hVar2;
            }
            if (sharedPreferences.getBoolean("OT_GOOGLE_VENDORS_ENABLED_STATE", false)) {
                this.f22555s.setVisibility(0);
                this.f22555s.setText(this.B.f22372l);
            }
            com.onetrust.otpublishers.headless.UI.Helper.i.m(this.f22554r, this.B.f22370j.f22873y, false);
            com.onetrust.otpublishers.headless.UI.Helper.i.m(this.f22555s, this.B.f22370j.f22873y, false);
            if (com.onetrust.otpublishers.headless.Internal.c.q(this.B.f22370j.f22873y.f22761d)) {
                this.f22554r.setMinHeight(70);
                this.f22554r.setMinimumHeight(70);
                this.f22555s.setMinHeight(70);
                this.f22555s.setMinimumHeight(70);
            } else {
                this.f22554r.setMinHeight(0);
                this.f22554r.setMinimumHeight(0);
                this.f22555s.setMinHeight(0);
                this.f22555s.setMinimumHeight(0);
                this.f22554r.setPadding(15, 5, 15, 5);
                this.f22555s.setPadding(15, 5, 15, 5);
            }
            str = "IsIabPurpose";
            str2 = "";
        } else if (this.f22557u.optBoolean("isAlertNotice")) {
            str = "IsIabPurpose";
            str2 = "";
            this.C.setVisibility(8);
            this.D.setVisibility(8);
            com.onetrust.otpublishers.headless.UI.UIProperty.x xVar = this.B.f22370j;
            if (Boolean.parseBoolean(xVar.I)) {
                TextView textView4 = this.f22548l;
                com.onetrust.otpublishers.headless.UI.UIProperty.c cVar3 = xVar.f22861m;
                textView4.setText(cVar3.f22724e);
                textView4.setTextColor(Color.parseColor(this.B.m()));
                textView4.setVisibility(cVar3.f22725f);
                TextView textView5 = this.f22549m;
                com.onetrust.otpublishers.headless.UI.UIProperty.c cVar4 = xVar.f22862n;
                textView5.setText(cVar4.f22724e);
                textView5.setTextColor(Color.parseColor(this.B.m()));
                textView5.setVisibility(cVar4.f22725f);
                TextView textView6 = this.f22550n;
                com.onetrust.otpublishers.headless.UI.UIProperty.c cVar5 = xVar.f22863o;
                textView6.setText(cVar5.f22724e);
                textView6.setTextColor(Color.parseColor(this.B.m()));
                textView6.setVisibility(cVar5.f22725f);
                TextView textView7 = this.f22551o;
                com.onetrust.otpublishers.headless.UI.UIProperty.c cVar6 = xVar.f22864p;
                textView7.setText(cVar6.f22724e);
                textView7.setTextColor(Color.parseColor(this.B.m()));
                textView7.setVisibility(cVar6.f22725f);
                TextView textView8 = this.f22552p;
                com.onetrust.otpublishers.headless.UI.UIProperty.c cVar7 = xVar.f22866r;
                textView8.setText(cVar7.f22724e);
                textView8.setTextColor(Color.parseColor(this.B.m()));
                textView8.setVisibility(cVar7.f22725f);
                this.f22553q.setBackgroundColor(Color.parseColor(this.B.m()));
            } else {
                this.K.setVisibility(8);
            }
            com.onetrust.otpublishers.headless.UI.UIProperty.o oVar = this.B.f22370j.D;
            String str5 = oVar.f22788b;
            com.onetrust.otpublishers.headless.UI.UIProperty.c cVar8 = oVar.f22787a;
            String str6 = cVar8.f22724e;
            boolean zB = cVar8.b();
            if (!com.onetrust.otpublishers.headless.Internal.c.q(str5) && zB && com.onetrust.otpublishers.headless.UI.mobiledatautils.c.i(getActivity(), OTFragmentTags.OT_PREFERENCE_CENTER_DETAILS_FRAGMENT_TAG)) {
                this.Z.setVisibility(0);
                try {
                    OTQRCodeUtils.b(str5, getActivity(), this.B.a(), this.B.m(), this.Y, false);
                    this.f22536a0.setText(str6);
                    this.f22536a0.setTextColor(Color.parseColor(this.B.m()));
                    this.f22538b0.setBackgroundColor(Color.parseColor(this.B.m()));
                } catch (Exception e10) {
                    OTLogger.a("OneTrust", 6, "Exception while rendering QR code," + e10);
                }
            } else {
                this.Z.setVisibility(8);
            }
        } else {
            this.K.setVisibility(8);
            this.C.setVisibility(this.B.p(this.f22557u));
            this.D.setVisibility(this.B.p(this.f22557u));
            if (this.f22557u.optBoolean("IsIabPurpose")) {
                this.C.setVisibility(this.f22557u.optBoolean("HasConsentOptOut") ? 0 : 8);
                this.D.setVisibility(this.f22557u.optBoolean("HasLegIntOptOut") ? 0 : 8);
            }
            CardView cardView = this.G;
            com.onetrust.otpublishers.headless.UI.TVUI.datautils.c cVar9 = this.B;
            JSONObject jSONObject4 = this.f22557u;
            cVar9.getClass();
            cardView.setVisibility((jSONObject4.optBoolean("ShowSDKListLink") && cVar9.f22374n && com.onetrust.otpublishers.headless.UI.TVUI.datautils.c.i(jSONObject4)) ? 0 : 8);
            this.O.setText(this.B.f22370j.F.f22787a.f22724e);
            str = "IsIabPurpose";
            str2 = "";
            v(false, this.B.f22370j.f22873y, this.G, this.J, this.O);
        }
        this.E.setVisibility(this.f22557u.optBoolean(str) ? 0 : 8);
        this.F.setVisibility((this.f22557u.optBoolean(str) && com.onetrust.otpublishers.headless.UI.Helper.l.u(this.f22557u)) ? 0 : 8);
        if (!this.f22557u.optString("Status").contains("always")) {
            if (this.B.q() && !this.f22557u.optBoolean("isAlertNotice")) {
                OTLogger.a("TVPCDetail", 3, "Showing Consent Toggle UI");
                this.T.setVisibility(8);
                this.U.setVisibility(8);
                this.f22540d.setText(this.B.b(!this.f22557u.optBoolean(str)));
                this.f22541e.setText(this.B.f22368h);
                int purposeLegitInterestLocal = this.f22547k.getPurposeLegitInterestLocal(this.f22557u.optString("CustomGroupId"));
                int i11 = (!this.B.f22369i || purposeLegitInterestLocal <= -1) ? 8 : 0;
                this.D.setVisibility(i11);
                this.S.setVisibility(i11);
                this.R.setVisibility(0);
                if (i11 == 0) {
                    i10 = 1;
                    this.S.setChecked(purposeLegitInterestLocal == 1);
                } else {
                    i10 = 1;
                }
                this.R.setChecked(this.f22547k.getPurposeConsentLocal(this.f22557u.optString("CustomGroupId")) == i10 ? i10 : 0);
            }
            this.f22539c.setVisibility(8);
            this.A.setVisibility(this.E.getVisibility());
            if (!this.f22561y || com.onetrust.otpublishers.headless.UI.TVUI.datautils.c.r(this.f22557u)) {
            }
            Context context4 = this.f22543g;
            SharedPreferences sharedPreferences2 = context4.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0);
            if (com.onetrust.otpublishers.headless.Internal.Helper.l.a(context4)) {
                str3 = str2;
                hVar = new com.onetrust.otpublishers.headless.Internal.Preferences.h(context4, sharedPreferences2, sharedPreferences2.getString("OT_ACTIVE_PROFILE_ID", str3));
            } else {
                str3 = str2;
                i10 = 0;
                hVar = null;
            }
            if (i10 != 0) {
                sharedPreferences2 = hVar;
            }
            String string = sharedPreferences2.getString("OT_VENDOR_COUNT_FOR_CATEGORIES", str3);
            OTLogger.a("IAB2V2Flow", 3, "Getting vendorCountForCategoryString = " + string);
            if (com.onetrust.otpublishers.headless.Internal.c.q(string)) {
                jSONObject = new JSONObject();
            } else {
                try {
                    jSONObject = new JSONObject(string);
                } catch (JSONException e11) {
                    com.onetrust.otpublishers.headless.Internal.Helper.p.a(e11, new StringBuilder("Error on getting vendor count for categories : "), "OTSPUtils", 6);
                    jSONObject = new JSONObject();
                }
            }
            JSONArray jSONArrayOptJSONArray = this.f22557u.optJSONArray("SubGroups");
            Objects.requireNonNull(jSONArrayOptJSONArray);
            com.onetrust.otpublishers.headless.UI.TVUI.adapter.j jVar = new com.onetrust.otpublishers.headless.UI.TVUI.adapter.j(jSONArrayOptJSONArray, this.f22543g, this.f22547k, this, jSONObject);
            this.f22562z = jVar;
            this.f22542f.setAdapter(jVar);
            this.f22539c.setText(bVarA.f22341d);
            this.f22539c.setVisibility(0);
            this.A.setVisibility(0);
            return;
        }
        if (!this.f22557u.optBoolean("isAlertNotice")) {
            this.C.setVisibility(0);
        }
        com.onetrust.otpublishers.headless.UI.TVUI.datautils.c cVar10 = this.B;
        String str7 = cVar10.f22370j.f22869u.f22724e;
        if (str7 == null) {
            str7 = cVar10.f22362b;
        }
        if (cVar10.q()) {
            this.f22540d.setText(this.B.b(!this.f22557u.optBoolean(str)));
            this.Q.setVisibility(0);
            this.Q.setText(str7);
        } else {
            this.f22540d.setText(str7);
            z();
        }
        this.T.setVisibility(8);
        if (com.onetrust.otpublishers.headless.Internal.c.q(str7)) {
            this.C.setVisibility(8);
        }
        i10 = 1;
        this.f22539c.setVisibility(8);
        this.A.setVisibility(this.E.getVisibility());
        if (this.f22561y) {
        }
    }

    public final void x(String str, String str2) {
        int[][] iArr = {new int[]{R.attr.state_checked}, new int[0]};
        int[] iArr2 = {Color.parseColor(str), Color.parseColor(str)};
        CompoundButtonCompat.setButtonTintList(this.S, new ColorStateList(iArr, iArr2));
        CompoundButtonCompat.setButtonTintList(this.U, new ColorStateList(iArr, iArr2));
        this.f22541e.setTextColor(Color.parseColor(str));
        this.f22545i.setBackgroundColor(Color.parseColor(str2));
        com.onetrust.otpublishers.headless.UI.Helper.i.f(this.f22541e, str);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0054 A[Catch: JSONException -> 0x005a, TRY_LEAVE, TryCatch #0 {JSONException -> 0x005a, blocks: (B:7:0x0020, B:9:0x0036, B:10:0x003b, B:12:0x0041, B:15:0x004c, B:19:0x0054), top: B:28:0x0020 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void y(boolean r7) {
        /*
            r6 = this;
            org.json.JSONObject r0 = r6.f22557u
            java.lang.String r1 = "CustomGroupId"
            java.lang.String r0 = r0.optString(r1)
            boolean r0 = com.onetrust.otpublishers.headless.Internal.c.q(r0)
            if (r0 != 0) goto L76
            org.json.JSONObject r0 = r6.f22557u
            java.lang.String r0 = r0.optString(r1)
            r1 = 0
            r6.W = r1
            r2 = 1
            if (r7 != 0) goto L20
            com.onetrust.otpublishers.headless.Public.OTPublishersHeadlessSDK r7 = r6.f22547k
            r7.updatePurposeLegitInterest(r0, r1)
            goto L68
        L20:
            com.onetrust.otpublishers.headless.UI.TVUI.datautils.c r7 = com.onetrust.otpublishers.headless.UI.TVUI.datautils.c.j()     // Catch: org.json.JSONException -> L5a
            com.onetrust.otpublishers.headless.Public.OTPublishersHeadlessSDK r3 = r6.f22547k     // Catch: org.json.JSONException -> L5a
            org.json.JSONObject r7 = r7.f22363c     // Catch: org.json.JSONException -> L5a
            org.json.JSONArray r4 = r7.names()     // Catch: org.json.JSONException -> L5a
            java.lang.String r4 = r4.toString()     // Catch: org.json.JSONException -> L5a
            boolean r4 = r4.contains(r0)     // Catch: org.json.JSONException -> L5a
            if (r4 == 0) goto L51
            org.json.JSONArray r7 = r7.optJSONArray(r0)     // Catch: org.json.JSONException -> L5a
            r4 = r1
        L3b:
            int r5 = r7.length()     // Catch: org.json.JSONException -> L5a
            if (r4 >= r5) goto L4f
            java.lang.String r5 = r7.getString(r4)     // Catch: org.json.JSONException -> L5a
            int r5 = r3.getPurposeLegitInterestLocal(r5)     // Catch: org.json.JSONException -> L5a
            if (r5 != 0) goto L4c
            goto L51
        L4c:
            int r4 = r4 + 1
            goto L3b
        L4f:
            r7 = r2
            goto L52
        L51:
            r7 = r1
        L52:
            if (r7 == 0) goto L68
            com.onetrust.otpublishers.headless.Public.OTPublishersHeadlessSDK r7 = r6.f22547k     // Catch: org.json.JSONException -> L5a
            r7.updatePurposeLegitInterest(r0, r2)     // Catch: org.json.JSONException -> L5a
            goto L68
        L5a:
            r7 = move-exception
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "error while updating parent LI status on TV, err: "
            r3.<init>(r4)
            java.lang.String r4 = "OneTrust"
            r5 = 6
            com.onetrust.otpublishers.headless.Internal.Helper.p.a(r7, r3, r4, r5)
        L68:
            android.widget.CheckBox r7 = r6.S
            com.onetrust.otpublishers.headless.Public.OTPublishersHeadlessSDK r3 = r6.f22547k
            int r0 = r3.getPurposeLegitInterestLocal(r0)
            if (r0 != r2) goto L73
            r1 = r2
        L73:
            r7.setChecked(r1)
        L76:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onetrust.otpublishers.headless.UI.TVUI.fragments.g.y(boolean):void");
    }

    public final void z() {
        CheckBox checkBox;
        if (this.f22547k.getPurposeConsentLocal(this.f22557u.optString("CustomGroupId")) == 1) {
            this.T.setChecked(true);
            checkBox = this.U;
        } else {
            this.U.setChecked(true);
            checkBox = this.T;
        }
        checkBox.setChecked(false);
    }

    @Override // com.onetrust.otpublishers.headless.UI.TVUI.adapter.j.a
    public final void a(JSONObject jSONObject) {
        ((q) this.f22560x).u(jSONObject, true, false);
    }
}
