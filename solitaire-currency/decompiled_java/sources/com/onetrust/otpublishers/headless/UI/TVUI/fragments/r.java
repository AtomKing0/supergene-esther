package com.onetrust.otpublishers.headless.UI.TVUI.fragments;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
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
import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import com.onetrust.otpublishers.headless.Public.OTPublishersHeadlessSDK;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class r extends Fragment implements View.OnKeyListener, View.OnFocusChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f22630a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f22631b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f22632c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f22633d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public TextView f22634e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public RelativeLayout f22635f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public CardView f22636g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public CardView f22637h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public LinearLayout f22638i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public LinearLayout f22639j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Context f22640k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public JSONObject f22641l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public CheckBox f22642m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public CheckBox f22643n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public CheckBox f22644o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public a f22645p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public com.onetrust.otpublishers.headless.UI.TVUI.datautils.c f22646q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public ScrollView f22647r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public String f22648s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public String f22649t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public com.onetrust.otpublishers.headless.Internal.Event.a f22650u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public OTPublishersHeadlessSDK f22651v;

    public interface a {
    }

    @Override // androidx.fragment.app.Fragment
    public final void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        this.f22640k = getContext();
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        CheckBox checkBox;
        TextView textView;
        Context context = this.f22640k;
        int i10 = p6.e.B;
        if (com.onetrust.otpublishers.headless.Internal.c.x(context)) {
            layoutInflater = layoutInflater.cloneInContext(new ContextThemeWrapper(context, p6.g.f32919b));
        }
        View viewInflate = layoutInflater.inflate(i10, viewGroup, false);
        this.f22630a = (TextView) viewInflate.findViewById(p6.d.K4);
        this.f22635f = (RelativeLayout) viewInflate.findViewById(p6.d.A4);
        this.f22636g = (CardView) viewInflate.findViewById(p6.d.f32681e6);
        this.f22638i = (LinearLayout) viewInflate.findViewById(p6.d.f32848x4);
        this.f22631b = (TextView) viewInflate.findViewById(p6.d.f32840w4);
        this.f22634e = (TextView) viewInflate.findViewById(p6.d.f32672d6);
        this.f22642m = (CheckBox) viewInflate.findViewById(p6.d.f32699g6);
        this.f22643n = (CheckBox) viewInflate.findViewById(p6.d.f32726j6);
        this.f22644o = (CheckBox) viewInflate.findViewById(p6.d.L4);
        this.f22637h = (CardView) viewInflate.findViewById(p6.d.f32690f6);
        this.f22639j = (LinearLayout) viewInflate.findViewById(p6.d.N4);
        this.f22632c = (TextView) viewInflate.findViewById(p6.d.M4);
        this.f22633d = (TextView) viewInflate.findViewById(p6.d.f32856y4);
        this.f22647r = (ScrollView) viewInflate.findViewById(p6.d.f32711i0);
        this.f22633d.setOnKeyListener(this);
        this.f22636g.setOnKeyListener(this);
        this.f22637h.setOnKeyListener(this);
        this.f22636g.setOnFocusChangeListener(this);
        this.f22637h.setOnFocusChangeListener(this);
        this.f22646q = com.onetrust.otpublishers.headless.UI.TVUI.datautils.c.j();
        this.f22649t = this.f22641l.optString("SdkId");
        com.onetrust.otpublishers.headless.UI.TVUI.datautils.b bVarA = com.onetrust.otpublishers.headless.UI.TVUI.datautils.b.a();
        this.f22637h.setVisibility(8);
        this.f22636g.setVisibility(8);
        boolean zA = com.onetrust.otpublishers.headless.Internal.b.a(this.f22646q.f22370j.f22856h);
        OTLogger.a("TVSDKList", 3, "setToggleVisibility: " + zA);
        int consentStatusForSDKId = this.f22651v.getConsentStatusForSDKId(this.f22649t);
        OTLogger.a("TVSDKList", 3, "setToggleVisibility: status " + consentStatusForSDKId + ": sdkId " + this.f22649t);
        boolean z10 = consentStatusForSDKId == 1;
        com.onetrust.otpublishers.headless.UI.TVUI.datautils.d.a();
        boolean zD = com.onetrust.otpublishers.headless.UI.TVUI.datautils.d.d(requireContext(), this.f22649t);
        if (zA) {
            if (zD) {
                com.onetrust.otpublishers.headless.UI.TVUI.datautils.c cVar = this.f22646q;
                String str = cVar.f22370j.f22869u.f22724e;
                if (str == null) {
                    str = cVar.f22362b;
                }
                if (cVar.q()) {
                    this.f22636g.setVisibility(0);
                    this.f22642m.setVisibility(8);
                    this.f22631b.setText(this.f22646q.b(true));
                    this.f22634e.setVisibility(0);
                    textView = this.f22634e;
                } else {
                    this.f22636g.setVisibility(0);
                    this.f22637h.setVisibility(8);
                    this.f22642m.setVisibility(8);
                    textView = this.f22631b;
                }
                textView.setText(str);
                this.f22643n.setVisibility(8);
                if (com.onetrust.otpublishers.headless.Internal.c.q(str)) {
                    this.f22636g.setVisibility(8);
                }
            } else {
                if (this.f22646q.q()) {
                    this.f22643n.setVisibility(8);
                    this.f22636g.setVisibility(0);
                    this.f22631b.setText(this.f22646q.b(true));
                } else {
                    this.f22636g.setVisibility(0);
                    this.f22637h.setVisibility(0);
                    this.f22642m.setVisibility(8);
                    this.f22631b.setText(bVarA.f22339b);
                    this.f22632c.setText(bVarA.f22340c);
                }
                if (com.onetrust.otpublishers.headless.Internal.c.q(this.f22649t)) {
                    OTLogger.a("TVSDKList", 3, "setSavedStatus: empty sdkId");
                } else {
                    OTLogger.a("TVSDKList", 3, "setSavedStatus: SDK- " + this.f22649t + ", status- " + z10);
                    if (this.f22646q.q()) {
                        this.f22642m.setChecked(z10);
                    } else {
                        if (z10) {
                            this.f22643n.setChecked(true);
                            checkBox = this.f22644o;
                        } else {
                            this.f22644o.setChecked(true);
                            checkBox = this.f22643n;
                        }
                        checkBox.setChecked(false);
                    }
                }
            }
        }
        this.f22647r.setSmoothScrollingEnabled(true);
        com.onetrust.otpublishers.headless.UI.Helper.l.j(requireContext(), this.f22630a, this.f22641l.optString("Name"));
        String strOptString = this.f22641l.optString("Description");
        if (!com.onetrust.otpublishers.headless.Internal.c.q(strOptString) && !"null".equalsIgnoreCase(strOptString)) {
            com.onetrust.otpublishers.headless.UI.Helper.l.j(requireContext(), this.f22633d, strOptString);
        }
        String strA = this.f22646q.a();
        this.f22648s = com.onetrust.otpublishers.headless.UI.Helper.i.j(strA);
        String strM = this.f22646q.m();
        this.f22630a.setTextColor(Color.parseColor(strM));
        this.f22633d.setTextColor(Color.parseColor(strM));
        this.f22634e.setTextColor(Color.parseColor(strM));
        this.f22635f.setBackgroundColor(Color.parseColor(strA));
        p(strM, this.f22648s);
        r(strM, this.f22648s);
        this.f22636g.setCardElevation(1.0f);
        this.f22637h.setCardElevation(1.0f);
        return viewInflate;
    }

    @Override // android.view.View.OnFocusChangeListener
    public final void onFocusChange(View view, boolean z10) {
        if (view.getId() == p6.d.f32681e6) {
            if (z10) {
                com.onetrust.otpublishers.headless.UI.UIProperty.f fVar = this.f22646q.f22370j.f22873y;
                p(fVar.f22767j, fVar.f22766i);
                this.f22636g.setCardElevation(6.0f);
            } else {
                p(this.f22646q.m(), this.f22648s);
                this.f22636g.setCardElevation(1.0f);
            }
        }
        if (view.getId() == p6.d.f32690f6) {
            if (!z10) {
                r(this.f22646q.m(), this.f22648s);
                this.f22637h.setCardElevation(1.0f);
            } else {
                com.onetrust.otpublishers.headless.UI.UIProperty.f fVar2 = this.f22646q.f22370j.f22873y;
                r(fVar2.f22767j, fVar2.f22766i);
                this.f22637h.setCardElevation(6.0f);
            }
        }
    }

    @Override // android.view.View.OnKeyListener
    public final boolean onKey(View view, int i10, KeyEvent keyEvent) {
        com.onetrust.otpublishers.headless.UI.TVUI.adapter.q qVar;
        if (i10 == 4 && keyEvent.getAction() == 1) {
            ((u) this.f22645p).getChildFragmentManager().popBackStackImmediate();
        }
        if (com.onetrust.otpublishers.headless.UI.Helper.i.a(i10, keyEvent) == 24 && (qVar = ((u) this.f22645p).f22674l) != null) {
            qVar.notifyDataSetChanged();
        }
        if (this.f22646q.q()) {
            if (view.getId() == p6.d.f32681e6 && com.onetrust.otpublishers.headless.UI.Helper.i.a(i10, keyEvent) == 21) {
                boolean z10 = !this.f22642m.isChecked();
                this.f22642m.setChecked(z10);
                q(z10);
            }
        } else if (view.getId() == p6.d.f32681e6 && com.onetrust.otpublishers.headless.UI.Helper.i.a(i10, keyEvent) == 21) {
            if (!this.f22643n.isChecked()) {
                q(true);
                this.f22643n.setChecked(true);
                this.f22644o.setChecked(false);
            }
        } else if (view.getId() == p6.d.f32690f6 && com.onetrust.otpublishers.headless.UI.Helper.i.a(i10, keyEvent) == 21 && !this.f22644o.isChecked()) {
            q(false);
            this.f22643n.setChecked(false);
            this.f22644o.setChecked(true);
        }
        return false;
    }

    public final void p(String str, String str2) {
        int[][] iArr = {new int[]{R.attr.state_checked}, new int[0]};
        int[] iArr2 = {Color.parseColor(str), Color.parseColor(str)};
        CompoundButtonCompat.setButtonTintList(this.f22642m, new ColorStateList(iArr, iArr2));
        CompoundButtonCompat.setButtonTintList(this.f22643n, new ColorStateList(iArr, iArr2));
        this.f22631b.setTextColor(Color.parseColor(str));
        this.f22634e.setTextColor(Color.parseColor(str));
        this.f22638i.setBackgroundColor(Color.parseColor(str2));
    }

    public final void q(boolean z10) {
        this.f22651v.updateSDKConsentStatus(this.f22649t, z10);
        String str = this.f22649t;
        com.onetrust.otpublishers.headless.Internal.Event.b bVar = new com.onetrust.otpublishers.headless.Internal.Event.b(24);
        bVar.f21746b = str;
        bVar.f21747c = z10 ? 1 : 0;
        com.onetrust.otpublishers.headless.Internal.Event.a aVar = this.f22650u;
        if (aVar != null) {
            aVar.a(bVar);
        } else {
            OTLogger.a("OneTrust", 6, "Error on sending UI events, listener set was found to be null.This could be because the activity has been recreated. \n Please set listener to get UI event callbacks.");
        }
    }

    public final void r(String str, String str2) {
        CompoundButtonCompat.setButtonTintList(this.f22644o, new ColorStateList(new int[][]{new int[]{R.attr.state_checked}, new int[0]}, new int[]{Color.parseColor(str), Color.parseColor(str)}));
        this.f22632c.setTextColor(Color.parseColor(str));
        this.f22634e.setTextColor(Color.parseColor(str));
        this.f22639j.setBackgroundColor(Color.parseColor(str2));
    }
}
