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
import androidx.fragment.app.FragmentActivity;
import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import com.onetrust.otpublishers.headless.Public.OTPublishersHeadlessSDK;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class d extends Fragment implements View.OnKeyListener, View.OnFocusChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f22478a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f22479b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f22480c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public RelativeLayout f22481d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public CardView f22482e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public LinearLayout f22483f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public LinearLayout f22484g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Context f22485h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public OTPublishersHeadlessSDK f22486i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public JSONObject f22487j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public a f22488k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public com.onetrust.otpublishers.headless.UI.TVUI.datautils.c f22489l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public CheckBox f22490m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public com.onetrust.otpublishers.headless.Internal.Event.a f22491n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f22492o = true;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public ScrollView f22493p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f22494q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public com.onetrust.otpublishers.headless.UI.TVUI.datautils.e f22495r;

    public interface a {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(CompoundButton compoundButton, boolean z10) {
        String strTrim = this.f22487j.optString("id").trim();
        this.f22486i.updateVendorConsent("google", strTrim, z10);
        if (this.f22492o) {
            com.onetrust.otpublishers.headless.Internal.Event.b bVar = new com.onetrust.otpublishers.headless.Internal.Event.b(15);
            bVar.f21746b = strTrim;
            bVar.f21747c = z10 ? 1 : 0;
            com.onetrust.otpublishers.headless.Internal.Event.a aVar = this.f22491n;
            if (aVar != null) {
                aVar.a(bVar);
            } else {
                OTLogger.a("OneTrust", 6, "Error on sending UI events, listener set was found to be null.This could be because the activity has been recreated. \n Please set listener to get UI event callbacks.");
            }
        }
        this.f22488k.getClass();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        this.f22485h = getContext();
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Context context = this.f22485h;
        int i10 = p6.e.T;
        if (com.onetrust.otpublishers.headless.Internal.c.x(context)) {
            layoutInflater = layoutInflater.cloneInContext(new ContextThemeWrapper(context, p6.g.f32919b));
        }
        View viewInflate = layoutInflater.inflate(i10, viewGroup, false);
        this.f22495r = com.onetrust.otpublishers.headless.UI.TVUI.datautils.e.a();
        q(viewInflate);
        this.f22484g.setVisibility(8);
        this.f22495r.d(this.f22487j, "google");
        this.f22489l = com.onetrust.otpublishers.headless.UI.TVUI.datautils.c.j();
        this.f22493p.setSmoothScrollingEnabled(true);
        this.f22478a.setText(this.f22495r.f22389c);
        this.f22479b.setText(this.f22495r.f22392f);
        this.f22480c.setText(this.f22489l.b(false));
        this.f22482e.setVisibility(0);
        this.f22492o = false;
        this.f22490m.setChecked(this.f22487j.optInt("consent") == 1);
        this.f22494q = com.onetrust.otpublishers.headless.UI.Helper.i.j(this.f22489l.a());
        String strM = this.f22489l.m();
        this.f22478a.setTextColor(Color.parseColor(strM));
        this.f22479b.setTextColor(Color.parseColor(strM));
        this.f22481d.setBackgroundColor(Color.parseColor(this.f22489l.a()));
        this.f22482e.setCardElevation(1.0f);
        s(strM, this.f22494q);
        return viewInflate;
    }

    @Override // android.view.View.OnFocusChangeListener
    public final void onFocusChange(View view, boolean z10) {
        TextView textView;
        String strM;
        CardView cardView;
        float f10;
        if (view.getId() == p6.d.f32807s6) {
            if (z10) {
                com.onetrust.otpublishers.headless.UI.UIProperty.f fVar = this.f22489l.f22370j.f22873y;
                s(fVar.f22767j, fVar.f22766i);
                cardView = this.f22482e;
                f10 = 6.0f;
            } else {
                s(this.f22489l.m(), this.f22494q);
                cardView = this.f22482e;
                f10 = 1.0f;
            }
            cardView.setCardElevation(f10);
        }
        if (view.getId() == p6.d.f32700g7) {
            if (z10) {
                this.f22479b.setBackgroundColor(Color.parseColor(this.f22489l.f22370j.f22873y.f22766i));
                textView = this.f22479b;
                strM = this.f22489l.f22370j.f22873y.f22767j;
            } else {
                this.f22479b.setBackgroundColor(Color.parseColor(this.f22494q));
                textView = this.f22479b;
                strM = this.f22489l.m();
            }
            textView.setTextColor(Color.parseColor(strM));
        }
    }

    @Override // android.view.View.OnKeyListener
    public final boolean onKey(View view, int i10, KeyEvent keyEvent) {
        if (view.getId() == p6.d.f32807s6 && com.onetrust.otpublishers.headless.UI.Helper.i.a(i10, keyEvent) == 21) {
            this.f22492o = true;
            this.f22490m.setChecked(!r0.isChecked());
        }
        if (view.getId() == p6.d.f32700g7 && com.onetrust.otpublishers.headless.UI.Helper.i.a(i10, keyEvent) == 21) {
            FragmentActivity activity = getActivity();
            com.onetrust.otpublishers.headless.UI.TVUI.datautils.e eVar = this.f22495r;
            com.onetrust.otpublishers.headless.UI.Helper.i.g(activity, eVar.f22390d, eVar.f22392f, this.f22489l.f22370j.f22873y);
        }
        if (i10 == 4 && keyEvent.getAction() == 1) {
            ((f0) this.f22488k).a(23);
        }
        if (com.onetrust.otpublishers.headless.UI.Helper.i.a(i10, keyEvent) != 24) {
            return false;
        }
        ((f0) this.f22488k).a(24);
        return true;
    }

    public final void q(@NonNull View view) {
        this.f22478a = (TextView) view.findViewById(p6.d.X6);
        this.f22479b = (TextView) view.findViewById(p6.d.f32700g7);
        this.f22481d = (RelativeLayout) view.findViewById(p6.d.O6);
        this.f22482e = (CardView) view.findViewById(p6.d.f32807s6);
        this.f22483f = (LinearLayout) view.findViewById(p6.d.H6);
        this.f22484g = (LinearLayout) view.findViewById(p6.d.M6);
        this.f22480c = (TextView) view.findViewById(p6.d.G6);
        this.f22490m = (CheckBox) view.findViewById(p6.d.f32834v6);
        this.f22493p = (ScrollView) view.findViewById(p6.d.f32711i0);
        this.f22490m.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.onetrust.otpublishers.headless.UI.TVUI.fragments.c
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
                this.f22476a.r(compoundButton, z10);
            }
        });
        this.f22482e.setOnKeyListener(this);
        this.f22482e.setOnFocusChangeListener(this);
        this.f22479b.setOnKeyListener(this);
        this.f22479b.setOnFocusChangeListener(this);
    }

    public final void s(String str, String str2) {
        CompoundButtonCompat.setButtonTintList(this.f22490m, new ColorStateList(new int[][]{new int[]{R.attr.state_checked}, new int[0]}, new int[]{Color.parseColor(str), Color.parseColor(str)}));
        this.f22480c.setTextColor(Color.parseColor(str));
        this.f22483f.setBackgroundColor(Color.parseColor(str2));
    }
}
