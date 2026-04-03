package com.onetrust.otpublishers.headless.UI.TVUI.fragments;

import ab.z;
import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.cardview.widget.CardView;
import androidx.core.widget.CompoundButtonCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import com.onetrust.otpublishers.headless.Public.OTPublishersHeadlessSDK;
import com.onetrust.otpublishers.headless.Public.OTVendorListMode;
import com.onetrust.otpublishers.headless.Public.uiutils.OTVendorUtils;
import com.onetrust.otpublishers.headless.UI.TVUI.adapter.a0;
import ga.z;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class a0 extends Fragment implements a0.c, View.OnKeyListener, View.OnFocusChangeListener {
    public static final /* synthetic */ int F = 0;
    public ScrollView B;
    public String C;
    public com.onetrust.otpublishers.headless.UI.TVUI.datautils.e D;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f22414a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f22415b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f22416c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f22417d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public TextView f22418e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public TextView f22419f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public TextView f22420g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public TextView f22421h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public RelativeLayout f22422i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public CardView f22423j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public CardView f22424k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public LinearLayout f22425l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public LinearLayout f22426m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public View f22427n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public RecyclerView f22428o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Context f22429p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public OTPublishersHeadlessSDK f22430q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public JSONObject f22431r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public a f22432s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public com.onetrust.otpublishers.headless.UI.TVUI.datautils.c f22433t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public CheckBox f22434u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public CheckBox f22435v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public JSONObject f22436w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public com.onetrust.otpublishers.headless.UI.TVUI.adapter.a0 f22437x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public com.onetrust.otpublishers.headless.Internal.Event.a f22438y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f22439z = true;
    public boolean A = true;
    public int E = -1;

    public interface a {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A(CompoundButton compoundButton, boolean z10) {
        String strTrim = this.f22431r.optString("id").trim();
        this.f22430q.updateVendorLegitInterest(strTrim, z10);
        if (this.A) {
            com.onetrust.otpublishers.headless.Internal.Event.b bVar = new com.onetrust.otpublishers.headless.Internal.Event.b(16);
            bVar.f21746b = strTrim;
            bVar.f21747c = z10 ? 1 : 0;
            com.onetrust.otpublishers.headless.Internal.Event.a aVar = this.f22438y;
            if (aVar != null) {
                aVar.a(bVar);
            } else {
                OTLogger.a("OneTrust", 6, "Error on sending UI events, listener set was found to be null.This could be because the activity has been recreated. \n Please set listener to get UI event callbacks.");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a() {
        com.onetrust.otpublishers.headless.UI.TVUI.adapter.a0 a0Var = this.f22437x;
        if (a0Var != null) {
            a0Var.notifyDataSetChanged();
            this.E = 2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(CompoundButton compoundButton, boolean z10) {
        String strTrim = this.f22431r.optString("id").trim();
        this.f22430q.updateVendorConsent(strTrim, z10);
        if (this.f22439z) {
            com.onetrust.otpublishers.headless.Internal.Event.b bVar = new com.onetrust.otpublishers.headless.Internal.Event.b(15);
            bVar.f21746b = strTrim;
            bVar.f21747c = z10 ? 1 : 0;
            com.onetrust.otpublishers.headless.Internal.Event.a aVar = this.f22438y;
            if (aVar != null) {
                aVar.a(bVar);
            } else {
                OTLogger.a("OneTrust", 6, "Error on sending UI events, listener set was found to be null.This could be because the activity has been recreated. \n Please set listener to get UI event callbacks.");
            }
        }
        this.f22432s.getClass();
    }

    public static void w(@Nullable JSONArray jSONArray, @NonNull String str, @NonNull JSONObject jSONObject, boolean z10, boolean z11, @Nullable JSONObject jSONObject2, @Nullable String str2) {
        if (jSONArray != null) {
            try {
                if (jSONArray.length() > 0) {
                    jSONObject.put(str, 1);
                    for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                        y(jSONObject, z11, jSONArray.optJSONObject(i10), z10, jSONObject2, str2);
                    }
                }
            } catch (JSONException e10) {
                com.onetrust.otpublishers.headless.Internal.Helper.x.a("exception thrown while constructing vendor purpose data, err: ", e10, "OneTrust", 6);
            }
        }
    }

    public static void x(@NonNull JSONObject jSONObject, @NonNull JSONObject jSONObject2, @NonNull com.onetrust.otpublishers.headless.UI.TVUI.datautils.e eVar) throws JSONException {
        String string = jSONObject.getString("stdRetention");
        if (com.onetrust.otpublishers.headless.Internal.c.q(string) || Integer.parseInt(string) < 0) {
            return;
        }
        jSONObject2.put(eVar.A + " (" + string + " " + eVar.B + ")", 5);
    }

    public static void y(@NonNull JSONObject jSONObject, boolean z10, JSONObject jSONObject2, boolean z11, @Nullable JSONObject jSONObject3, @Nullable String str) throws JSONException {
        if (com.onetrust.otpublishers.headless.Internal.a.d(jSONObject2)) {
            return;
        }
        String string = z10 ? jSONObject2.toString() : jSONObject2.optString("name");
        if (jSONObject3 != null && jSONObject2.has("id")) {
            String string2 = jSONObject2.getString("id");
            if (jSONObject3.has(string2) && !com.onetrust.otpublishers.headless.Internal.c.q(str)) {
                String strOptString = jSONObject3.optString(string2);
                if (!com.onetrust.otpublishers.headless.Internal.c.q(strOptString) && Integer.parseInt(strOptString) >= 0) {
                    string = string + " (" + strOptString + " " + str + ")";
                }
            }
        }
        jSONObject.put(string, z10 ? z11 ? 4 : 3 : 2);
    }

    public final void B(String str, String str2) {
        CompoundButtonCompat.setButtonTintList(this.f22435v, new ColorStateList(new int[][]{new int[]{R.attr.state_checked}, new int[0]}, new int[]{Color.parseColor(str), Color.parseColor(str)}));
        this.f22420g.setTextColor(Color.parseColor(str));
        this.f22426m.setBackgroundColor(Color.parseColor(str2));
    }

    @Override // androidx.fragment.app.Fragment
    public final void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        this.f22429p = getContext();
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Context context = this.f22429p;
        int i10 = p6.e.T;
        if (com.onetrust.otpublishers.headless.Internal.c.x(context)) {
            layoutInflater = layoutInflater.cloneInContext(new ContextThemeWrapper(context, p6.g.f32919b));
        }
        View viewInflate = layoutInflater.inflate(i10, viewGroup, false);
        this.f22436w = new JSONObject();
        this.D = com.onetrust.otpublishers.headless.UI.TVUI.datautils.e.a();
        t(viewInflate);
        this.D.d(this.f22431r, OTVendorListMode.IAB);
        this.f22433t = com.onetrust.otpublishers.headless.UI.TVUI.datautils.c.j();
        this.f22437x = new com.onetrust.otpublishers.headless.UI.TVUI.adapter.a0(s(this.D, this.f22436w), this);
        this.f22428o.setLayoutManager(new LinearLayoutManager(this.f22429p));
        this.f22428o.setAdapter(this.f22437x);
        this.B.setSmoothScrollingEnabled(true);
        this.f22414a.setText(this.D.f22389c);
        if (com.onetrust.otpublishers.headless.Internal.c.q(this.D.f22390d)) {
            this.f22415b.setVisibility(8);
        } else {
            this.f22415b.setText(this.D.f22392f);
        }
        if (com.onetrust.otpublishers.headless.Internal.c.q(this.D.f22391e)) {
            this.f22416c.setVisibility(8);
        } else {
            this.f22416c.setText(this.D.f22393g);
            this.f22416c.setVisibility(0);
        }
        this.f22417d.setText(this.D.f22394h);
        this.f22418e.setText(this.D.f22395i);
        this.f22419f.setText(this.f22433t.b(false));
        this.f22420g.setText(this.f22433t.f22368h);
        this.f22421h.setText(this.D.f22402p);
        JSONObject jSONObject = this.f22431r;
        if (jSONObject != null) {
            int iOptInt = jSONObject.optInt(OTVendorUtils.LEGITIMATE_CONSENT_TYPE);
            this.f22439z = false;
            this.A = false;
            this.f22435v.setChecked(iOptInt == 1);
            this.f22434u.setChecked(this.f22431r.optInt("consent") == 1);
            this.f22424k.setVisibility((!this.f22433t.f22369i || this.f22431r.optInt(OTVendorUtils.LEGITIMATE_CONSENT_TYPE) <= -1) ? 8 : 0);
            this.f22423j.setVisibility(this.f22431r.optInt("consent") > -1 ? 0 : 8);
        }
        this.C = com.onetrust.otpublishers.headless.UI.Helper.i.j(this.f22433t.a());
        String strM = this.f22433t.m();
        this.f22414a.setTextColor(Color.parseColor(strM));
        this.f22415b.setTextColor(Color.parseColor(strM));
        this.f22416c.setTextColor(Color.parseColor(strM));
        this.f22421h.setTextColor(Color.parseColor(strM));
        this.f22417d.setTextColor(Color.parseColor(strM));
        this.f22418e.setTextColor(Color.parseColor(strM));
        this.f22422i.setBackgroundColor(Color.parseColor(this.f22433t.a()));
        this.f22427n.setBackgroundColor(Color.parseColor(strM));
        this.f22423j.setCardElevation(1.0f);
        this.f22424k.setCardElevation(1.0f);
        v(strM, this.C);
        B(strM, this.C);
        this.E = 0;
        return viewInflate;
    }

    @Override // android.view.View.OnFocusChangeListener
    public final void onFocusChange(View view, boolean z10) {
        TextView textView;
        String strM;
        TextView textView2;
        String strM2;
        if (view.getId() == p6.d.f32807s6) {
            if (z10) {
                com.onetrust.otpublishers.headless.UI.UIProperty.f fVar = this.f22433t.f22370j.f22873y;
                v(fVar.f22767j, fVar.f22766i);
                this.f22423j.setCardElevation(6.0f);
            } else {
                v(this.f22433t.m(), this.C);
                this.f22423j.setCardElevation(1.0f);
            }
        }
        if (view.getId() == p6.d.f32816t6) {
            if (z10) {
                com.onetrust.otpublishers.headless.UI.UIProperty.f fVar2 = this.f22433t.f22370j.f22873y;
                B(fVar2.f22767j, fVar2.f22766i);
                this.f22424k.setCardElevation(6.0f);
            } else {
                B(this.f22433t.m(), this.C);
                this.f22424k.setCardElevation(1.0f);
            }
        }
        if (view.getId() == p6.d.f32700g7) {
            if (z10) {
                this.f22415b.setBackgroundColor(Color.parseColor(this.f22433t.f22370j.f22873y.f22766i));
                textView2 = this.f22415b;
                strM2 = this.f22433t.f22370j.f22873y.f22767j;
            } else {
                this.f22415b.setBackgroundColor(Color.parseColor(this.C));
                textView2 = this.f22415b;
                strM2 = this.f22433t.m();
            }
            textView2.setTextColor(Color.parseColor(strM2));
        }
        if (view.getId() == p6.d.f32682e7) {
            if (z10) {
                this.f22416c.setBackgroundColor(Color.parseColor(this.f22433t.f22370j.f22873y.f22766i));
                textView = this.f22416c;
                strM = this.f22433t.f22370j.f22873y.f22767j;
            } else {
                this.f22416c.setBackgroundColor(Color.parseColor(this.C));
                textView = this.f22416c;
                strM = this.f22433t.m();
            }
            textView.setTextColor(Color.parseColor(strM));
        }
        if (view.getId() == p6.d.f32846x2 && z10 && this.E <= 1) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.onetrust.otpublishers.headless.UI.TVUI.fragments.x
                @Override // java.lang.Runnable
                public final void run() {
                    this.f22692a.a();
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00bd A[RETURN] */
    @Override // android.view.View.OnKeyListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onKey(android.view.View r8, int r9, android.view.KeyEvent r10) {
        /*
            r7 = this;
            int r0 = r8.getId()
            int r1 = p6.d.f32807s6
            r2 = 21
            r3 = 1
            if (r0 != r1) goto L1a
            int r0 = com.onetrust.otpublishers.headless.UI.Helper.i.a(r9, r10)
            if (r0 != r2) goto L1a
            r7.f22439z = r3
            android.widget.CheckBox r0 = r7.f22434u
        L15:
            boolean r1 = r0.isChecked()
            goto L2d
        L1a:
            int r0 = r8.getId()
            int r1 = p6.d.f32816t6
            if (r0 != r1) goto L31
            int r0 = com.onetrust.otpublishers.headless.UI.Helper.i.a(r9, r10)
            if (r0 != r2) goto L31
            r7.A = r3
            android.widget.CheckBox r0 = r7.f22435v
            goto L15
        L2d:
            r1 = r1 ^ r3
            r0.setChecked(r1)
        L31:
            com.onetrust.otpublishers.headless.UI.TVUI.datautils.e r0 = r7.D
            java.lang.String r0 = r0.f22390d
            boolean r0 = com.onetrust.otpublishers.headless.Internal.c.q(r0)
            r1 = 8
            if (r0 != 0) goto L5f
            int r0 = r8.getId()
            int r4 = p6.d.f32700g7
            if (r0 != r4) goto L64
            int r0 = com.onetrust.otpublishers.headless.UI.Helper.i.a(r9, r10)
            if (r0 != r2) goto L64
            androidx.fragment.app.FragmentActivity r0 = r7.getActivity()
            com.onetrust.otpublishers.headless.UI.TVUI.datautils.e r4 = r7.D
            java.lang.String r5 = r4.f22390d
            java.lang.String r4 = r4.f22392f
            com.onetrust.otpublishers.headless.UI.TVUI.datautils.c r6 = r7.f22433t
            com.onetrust.otpublishers.headless.UI.UIProperty.x r6 = r6.f22370j
            com.onetrust.otpublishers.headless.UI.UIProperty.f r6 = r6.f22873y
            com.onetrust.otpublishers.headless.UI.Helper.i.g(r0, r5, r4, r6)
            goto L64
        L5f:
            android.widget.TextView r0 = r7.f22415b
            r0.setVisibility(r1)
        L64:
            com.onetrust.otpublishers.headless.UI.TVUI.datautils.e r0 = r7.D
            java.lang.String r0 = r0.f22391e
            boolean r0 = com.onetrust.otpublishers.headless.Internal.c.q(r0)
            r4 = 0
            if (r0 != 0) goto L96
            int r8 = r8.getId()
            int r0 = p6.d.f32682e7
            if (r8 != r0) goto L9b
            int r8 = com.onetrust.otpublishers.headless.UI.Helper.i.a(r9, r10)
            if (r8 != r2) goto L9b
            android.widget.TextView r8 = r7.f22416c
            r8.setVisibility(r4)
            androidx.fragment.app.FragmentActivity r8 = r7.getActivity()
            com.onetrust.otpublishers.headless.UI.TVUI.datautils.e r0 = r7.D
            java.lang.String r1 = r0.f22391e
            java.lang.String r0 = r0.f22393g
            com.onetrust.otpublishers.headless.UI.TVUI.datautils.c r2 = r7.f22433t
            com.onetrust.otpublishers.headless.UI.UIProperty.x r2 = r2.f22370j
            com.onetrust.otpublishers.headless.UI.UIProperty.f r2 = r2.f22873y
            com.onetrust.otpublishers.headless.UI.Helper.i.g(r8, r1, r0, r2)
            goto L9b
        L96:
            android.widget.TextView r8 = r7.f22416c
            r8.setVisibility(r1)
        L9b:
            r8 = 4
            if (r9 != r8) goto Lad
            int r8 = r10.getAction()
            if (r8 != r3) goto Lad
            com.onetrust.otpublishers.headless.UI.TVUI.fragments.a0$a r8 = r7.f22432s
            com.onetrust.otpublishers.headless.UI.TVUI.fragments.f0 r8 = (com.onetrust.otpublishers.headless.UI.TVUI.fragments.f0) r8
            r0 = 23
            r8.a(r0)
        Lad:
            int r8 = com.onetrust.otpublishers.headless.UI.Helper.i.a(r9, r10)
            r9 = 24
            if (r8 != r9) goto Lbd
            com.onetrust.otpublishers.headless.UI.TVUI.fragments.a0$a r8 = r7.f22432s
            com.onetrust.otpublishers.headless.UI.TVUI.fragments.f0 r8 = (com.onetrust.otpublishers.headless.UI.TVUI.fragments.f0) r8
            r8.a(r9)
            return r3
        Lbd:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onetrust.otpublishers.headless.UI.TVUI.fragments.a0.onKey(android.view.View, int, android.view.KeyEvent):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0068  */
    @androidx.annotation.NonNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final org.json.JSONObject s(@androidx.annotation.NonNull com.onetrust.otpublishers.headless.UI.TVUI.datautils.e r13, @androidx.annotation.NonNull org.json.JSONObject r14) {
        /*
            Method dump skipped, instruction units count: 224
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onetrust.otpublishers.headless.UI.TVUI.fragments.a0.s(com.onetrust.otpublishers.headless.UI.TVUI.datautils.e, org.json.JSONObject):org.json.JSONObject");
    }

    public final void t(@NonNull View view) {
        CardView cardView;
        this.f22414a = (TextView) view.findViewById(p6.d.X6);
        this.f22415b = (TextView) view.findViewById(p6.d.f32700g7);
        this.f22416c = (TextView) view.findViewById(p6.d.f32682e7);
        this.f22417d = (TextView) view.findViewById(p6.d.f32854y2);
        this.f22418e = (TextView) view.findViewById(p6.d.f32773p);
        this.f22422i = (RelativeLayout) view.findViewById(p6.d.O6);
        this.f22423j = (CardView) view.findViewById(p6.d.f32807s6);
        this.f22424k = (CardView) view.findViewById(p6.d.f32816t6);
        this.f22425l = (LinearLayout) view.findViewById(p6.d.H6);
        this.f22426m = (LinearLayout) view.findViewById(p6.d.M6);
        this.f22419f = (TextView) view.findViewById(p6.d.G6);
        this.f22420g = (TextView) view.findViewById(p6.d.L6);
        int i10 = p6.d.f32846x2;
        this.f22421h = (TextView) view.findViewById(i10);
        this.f22427n = view.findViewById(p6.d.f32825u6);
        this.f22428o = (RecyclerView) view.findViewById(p6.d.Q6);
        this.f22434u = (CheckBox) view.findViewById(p6.d.f32834v6);
        this.f22435v = (CheckBox) view.findViewById(p6.d.f32842w6);
        this.B = (ScrollView) view.findViewById(p6.d.f32711i0);
        this.f22434u.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.onetrust.otpublishers.headless.UI.TVUI.fragments.y
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
                this.f22693a.u(compoundButton, z10);
            }
        });
        this.f22435v.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.onetrust.otpublishers.headless.UI.TVUI.fragments.z
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
                this.f22694a.A(compoundButton, z10);
            }
        });
        this.f22423j.setOnKeyListener(this);
        this.f22424k.setOnKeyListener(this);
        this.f22423j.setOnFocusChangeListener(this);
        this.f22424k.setOnFocusChangeListener(this);
        this.f22415b.setOnKeyListener(this);
        this.f22416c.setOnKeyListener(this);
        this.f22415b.setOnFocusChangeListener(this);
        this.f22416c.setOnFocusChangeListener(this);
        this.f22421h.setOnFocusChangeListener(this);
        if (this.f22424k.getVisibility() == 8 && this.f22423j.getVisibility() == 0) {
            cardView = this.f22423j;
        } else if (this.f22424k.getVisibility() != 0) {
            return;
        } else {
            cardView = this.f22424k;
        }
        cardView.setNextFocusDownId(i10);
    }

    public final void v(String str, String str2) {
        CompoundButtonCompat.setButtonTintList(this.f22434u, new ColorStateList(new int[][]{new int[]{R.attr.state_checked}, new int[0]}, new int[]{Color.parseColor(str), Color.parseColor(str)}));
        this.f22419f.setTextColor(Color.parseColor(str));
        this.f22425l.setBackgroundColor(Color.parseColor(str2));
    }

    public final void z() {
        CardView cardView;
        TextView textView;
        com.onetrust.otpublishers.headless.UI.TVUI.datautils.e eVar = this.D;
        if (eVar != null && !com.onetrust.otpublishers.headless.Internal.c.q(eVar.f22403q)) {
            String str = this.D.f22403q;
            OTLogger.a("TV Vendor", 3, "IAB Vendor Disclosure API called ");
            ((com.onetrust.otpublishers.headless.Internal.Network.a) new z.b().c("https://geolocation.1trust.app/").a(bb.k.f()).f(new z.a().b()).d().b(com.onetrust.otpublishers.headless.Internal.Network.a.class)).a(str).i0(new w(this));
        }
        TextView textView2 = this.f22415b;
        if (textView2 == null || com.onetrust.otpublishers.headless.Internal.c.q(textView2.getText().toString())) {
            TextView textView3 = this.f22416c;
            if (textView3 == null || com.onetrust.otpublishers.headless.Internal.c.q(textView3.getText().toString())) {
                CardView cardView2 = this.f22423j;
                if (cardView2 == null || cardView2.getVisibility() != 0) {
                    CardView cardView3 = this.f22424k;
                    if (cardView3 == null || cardView3.getVisibility() != 0) {
                        return;
                    } else {
                        cardView = this.f22424k;
                    }
                } else {
                    cardView = this.f22423j;
                }
                cardView.requestFocus();
                return;
            }
            textView = this.f22416c;
        } else {
            textView = this.f22415b;
        }
        textView.requestFocus();
    }
}
