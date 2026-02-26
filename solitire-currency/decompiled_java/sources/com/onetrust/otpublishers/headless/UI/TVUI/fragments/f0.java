package com.onetrust.otpublishers.headless.UI.TVUI.fragments;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.ads.RequestConfiguration;
import com.onetrust.otpublishers.headless.Public.DataModel.OTConfiguration;
import com.onetrust.otpublishers.headless.Public.Keys.OTFragmentTags;
import com.onetrust.otpublishers.headless.Public.OTPublishersHeadlessSDK;
import com.onetrust.otpublishers.headless.Public.OTVendorListMode;
import com.onetrust.otpublishers.headless.Public.uiutils.OTVendorUtils;
import com.onetrust.otpublishers.headless.UI.TVUI.adapter.c;
import com.onetrust.otpublishers.headless.UI.TVUI.adapter.d0;
import com.onetrust.otpublishers.headless.UI.TVUI.fragments.a0;
import com.onetrust.otpublishers.headless.UI.TVUI.fragments.b0;
import com.onetrust.otpublishers.headless.UI.TVUI.fragments.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class f0 extends Fragment implements d0.b, View.OnKeyListener, a0.a, b0.a, OTVendorUtils.ItemListener, View.OnFocusChangeListener, c.b, d.a {
    public Button A;
    public Button B;
    public Button C;
    public Button D;
    public ImageView E;
    public ArrayList<String> F;
    public String G;
    public boolean I;
    public OTConfiguration J;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public FragmentActivity f22509a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public OTPublishersHeadlessSDK f22510b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public a f22511c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public com.onetrust.otpublishers.headless.Internal.Event.a f22512d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public RecyclerView f22513e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public com.onetrust.otpublishers.headless.UI.TVUI.datautils.c f22514f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public com.onetrust.otpublishers.headless.UI.TVUI.datautils.d f22515g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public RelativeLayout f22516h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public LinearLayout f22517i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ImageView f22518j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ImageView f22519k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public View f22520l;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f22522n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public OTVendorUtils f22523o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public com.onetrust.otpublishers.headless.UI.TVUI.adapter.d0 f22524p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public com.onetrust.otpublishers.headless.UI.TVUI.adapter.c f22525q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public View f22526r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public TextView f22527s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public a0 f22528t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public d f22529u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Button f22530v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Button f22531w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Button f22532x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public Button f22533y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public Button f22534z;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Map<String, String> f22521m = new HashMap();
    public String H = OTVendorListMode.IAB;

    public interface a {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        View view;
        if (event.compareTo(Lifecycle.Event.ON_RESUME) == 0) {
            d dVar = this.f22529u;
            TextView textView = dVar.f22479b;
            if (textView == null || com.onetrust.otpublishers.headless.Internal.c.q(textView.getText().toString())) {
                view = dVar.f22482e;
                if (view == null) {
                    return;
                }
            } else {
                view = dVar.f22479b;
            }
            view.requestFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void F(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        if (event.compareTo(Lifecycle.Event.ON_RESUME) == 0) {
            this.f22532x.clearFocus();
            this.f22531w.clearFocus();
            this.f22530v.clearFocus();
        }
    }

    @RequiresApi(api = 21)
    public static void v(@NonNull Button button, @Nullable String str, @Nullable String str2) {
        if (str == null || str2 == null) {
            return;
        }
        button.getBackground().setTint(Color.parseColor(str));
        button.setTextColor(Color.parseColor(str2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void x(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        if (event.compareTo(Lifecycle.Event.ON_RESUME) == 0) {
            this.f22528t.z();
        }
    }

    public final void A(@NonNull Map<String, String> map) {
        Drawable drawable;
        String str;
        this.f22522n = !map.isEmpty();
        this.f22521m = map;
        com.onetrust.otpublishers.headless.UI.UIProperty.f fVar = this.f22515g.f22386g;
        if (map.isEmpty()) {
            drawable = this.E.getDrawable();
            str = fVar.f22759b;
        } else {
            drawable = this.E.getDrawable();
            str = fVar.f22760c;
        }
        drawable.setTint(Color.parseColor(str));
        this.f22524p.f22222m = !map.isEmpty();
        com.onetrust.otpublishers.headless.UI.TVUI.adapter.d0 d0Var = this.f22524p;
        d0Var.f22223n = map;
        d0Var.h();
        com.onetrust.otpublishers.headless.UI.TVUI.adapter.d0 d0Var2 = this.f22524p;
        d0Var2.f22224o = 0;
        d0Var2.notifyDataSetChanged();
        try {
            JSONObject vendorsByPurpose = this.f22522n ? this.f22523o.getVendorsByPurpose(this.f22521m, this.f22510b.getVendorListUI(OTVendorListMode.IAB)) : this.f22510b.getVendorListUI(OTVendorListMode.IAB);
            if (vendorsByPurpose == null || vendorsByPurpose.length() <= 0) {
                return;
            }
            JSONArray jSONArrayNames = vendorsByPurpose.names();
            Objects.requireNonNull(jSONArrayNames);
            y(jSONArrayNames.getString(0));
        } catch (JSONException e10) {
            com.onetrust.otpublishers.headless.Internal.Helper.n.a(e10, new StringBuilder("error while setting first vendor detail,err "), "TVVendorList", 6);
        }
    }

    public final void B() {
        Lifecycle lifecycle;
        LifecycleEventObserver lifecycleEventObserver;
        this.I = true;
        if (!OTVendorListMode.IAB.equalsIgnoreCase(this.H)) {
            if ("google".equalsIgnoreCase(this.H)) {
                lifecycle = this.f22529u.getLifecycle();
                lifecycleEventObserver = new LifecycleEventObserver() { // from class: com.onetrust.otpublishers.headless.UI.TVUI.fragments.e0
                    @Override // androidx.lifecycle.LifecycleEventObserver
                    public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                        this.f22507a.D(lifecycleOwner, event);
                    }
                };
            }
            this.f22532x.clearFocus();
            this.f22531w.clearFocus();
            this.f22530v.clearFocus();
        }
        lifecycle = this.f22528t.getLifecycle();
        lifecycleEventObserver = new LifecycleEventObserver() { // from class: com.onetrust.otpublishers.headless.UI.TVUI.fragments.d0
            @Override // androidx.lifecycle.LifecycleEventObserver
            public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                this.f22496a.x(lifecycleOwner, event);
            }
        };
        lifecycle.addObserver(lifecycleEventObserver);
        this.f22532x.clearFocus();
        this.f22531w.clearFocus();
        this.f22530v.clearFocus();
    }

    @RequiresApi(api = 21)
    public final void C(Button button, com.onetrust.otpublishers.headless.UI.UIProperty.f fVar, boolean z10) {
        if (!z10) {
            button.setElevation(0.0f);
            s(button, fVar, ExifInterface.GPS_MEASUREMENT_3D, button.isSelected());
            return;
        }
        button.setElevation(6.0f);
        if (!com.onetrust.otpublishers.headless.Internal.c.q(fVar.f22761d)) {
            com.onetrust.otpublishers.headless.UI.Helper.i.m(button, fVar, true);
        } else {
            if (com.onetrust.otpublishers.headless.Internal.c.q(fVar.f22766i) || com.onetrust.otpublishers.headless.Internal.c.q(fVar.f22767j)) {
                return;
            }
            button.getBackground().setTint(Color.parseColor(fVar.f22766i));
            button.setTextColor(Color.parseColor(fVar.f22767j));
        }
    }

    @RequiresApi(api = 21)
    public final void E() {
        com.onetrust.otpublishers.headless.UI.TVUI.adapter.c cVar = new com.onetrust.otpublishers.headless.UI.TVUI.adapter.c(this.f22523o, this, this.f22510b);
        this.f22525q = cVar;
        cVar.h();
        this.f22513e.setAdapter(this.f22525q);
        this.E.setVisibility(4);
        this.f22527s.setText(this.f22514f.f22372l);
        this.C.setSelected(false);
        this.D.setSelected(true);
        C(this.D, this.f22514f.f22370j.f22873y, false);
        JSONObject vendorListUI = this.f22510b.getVendorListUI("google");
        if (vendorListUI == null || vendorListUI.length() <= 0) {
            return;
        }
        JSONArray jSONArrayNames = vendorListUI.names();
        Objects.requireNonNull(jSONArrayNames);
        y(jSONArrayNames.getString(0));
    }

    @RequiresApi(api = 21)
    public final void G() {
        com.onetrust.otpublishers.headless.UI.TVUI.adapter.d0 d0Var = new com.onetrust.otpublishers.headless.UI.TVUI.adapter.d0(this.f22523o, this, this.f22510b, this.f22522n, this.f22521m);
        this.f22524p = d0Var;
        d0Var.h();
        this.f22513e.setAdapter(this.f22524p);
        if (8 == this.f22515g.f22386g.f22769l) {
            this.E.setVisibility(4);
        } else {
            this.E.setVisibility(0);
        }
        this.f22527s.setText(this.f22514f.f22371k);
        this.C.setSelected(true);
        this.D.setSelected(false);
        C(this.C, this.f22514f.f22370j.f22873y, false);
        JSONObject vendorsByPurpose = this.f22522n ? this.f22523o.getVendorsByPurpose(this.f22521m, this.f22510b.getVendorListUI(OTVendorListMode.IAB)) : this.f22510b.getVendorListUI(OTVendorListMode.IAB);
        if (vendorsByPurpose == null || vendorsByPurpose.length() <= 0) {
            return;
        }
        JSONArray jSONArrayNames = vendorsByPurpose.names();
        Objects.requireNonNull(jSONArrayNames);
        y(jSONArrayNames.getString(0));
    }

    public final void a(int i10) {
        com.onetrust.otpublishers.headless.UI.TVUI.adapter.c cVar;
        com.onetrust.otpublishers.headless.UI.TVUI.adapter.d0 d0Var;
        if (i10 != 24) {
            getChildFragmentManager().popBackStackImmediate();
            return;
        }
        if (OTVendorListMode.IAB.equalsIgnoreCase(this.H) && (d0Var = this.f22524p) != null) {
            d0Var.notifyDataSetChanged();
        }
        if (!"google".equalsIgnoreCase(this.H) || (cVar = this.f22525q) == null) {
            return;
        }
        cVar.notifyDataSetChanged();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        this.f22509a = getActivity();
        this.f22514f = com.onetrust.otpublishers.headless.UI.TVUI.datautils.c.j();
        this.f22515g = com.onetrust.otpublishers.headless.UI.TVUI.datautils.d.a();
        this.F = new ArrayList<>();
        this.G = "A_F";
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x0281  */
    @Override // androidx.fragment.app.Fragment
    @androidx.annotation.RequiresApi(api = 21)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.view.View onCreateView(@androidx.annotation.NonNull android.view.LayoutInflater r20, android.view.ViewGroup r21, android.os.Bundle r22) {
        /*
            Method dump skipped, instruction units count: 922
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onetrust.otpublishers.headless.UI.TVUI.fragments.f0.onCreateView(android.view.LayoutInflater, android.view.ViewGroup, android.os.Bundle):android.view.View");
    }

    @Override // android.view.View.OnFocusChangeListener
    @RequiresApi(api = 21)
    public final void onFocusChange(View view, boolean z10) {
        Drawable drawable;
        String str;
        if (view.getId() == p6.d.f32833v5) {
            com.onetrust.otpublishers.headless.UI.Helper.i.k(this.f22530v, this.f22514f.f22370j.f22873y, z10);
        }
        if (view.getId() == p6.d.f32849x5) {
            com.onetrust.otpublishers.headless.UI.Helper.i.k(this.f22532x, this.f22514f.f22370j.f22872x, z10);
        }
        if (view.getId() == p6.d.f32824u5) {
            com.onetrust.otpublishers.headless.UI.Helper.i.k(this.f22531w, this.f22514f.f22370j.f22871w, z10);
        }
        if (view.getId() == p6.d.f32777p3) {
            t(this.f22533y, this.f22514f.f22370j.f22873y, z10);
        }
        if (view.getId() == p6.d.f32795r3) {
            t(this.f22534z, this.f22514f.f22370j.f22873y, z10);
        }
        if (view.getId() == p6.d.f32813t3) {
            t(this.A, this.f22514f.f22370j.f22873y, z10);
        }
        if (view.getId() == p6.d.f32831v3) {
            t(this.B, this.f22514f.f22370j.f22873y, z10);
        }
        if (view.getId() == p6.d.N5) {
            C(this.D, this.f22514f.f22370j.f22873y, z10);
        }
        if (view.getId() == p6.d.T5) {
            C(this.C, this.f22514f.f22370j.f22873y, z10);
        }
        if (view.getId() == p6.d.S3) {
            ImageView imageView = this.E;
            if (z10) {
                drawable = imageView.getDrawable();
                str = this.f22515g.f22386g.f22766i;
            } else {
                Map<String, String> map = this.f22521m;
                if (map == null || map.isEmpty()) {
                    drawable = imageView.getDrawable();
                    str = this.f22515g.f22386g.f22759b;
                } else {
                    drawable = imageView.getDrawable();
                    str = this.f22515g.f22386g.f22760c;
                }
            }
            drawable.setTint(Color.parseColor(str));
        }
        if (view.getId() == p6.d.O3) {
            com.onetrust.otpublishers.headless.UI.Helper.i.i(z10, this.f22514f.f22370j.f22873y, this.f22519k);
        }
    }

    @Override // android.view.View.OnKeyListener
    @RequiresApi(api = 21)
    public final boolean onKey(View view, int i10, KeyEvent keyEvent) {
        boolean z10;
        com.onetrust.otpublishers.headless.UI.TVUI.adapter.c cVar;
        d dVar;
        View view2;
        a0 a0Var;
        if (view.getId() == p6.d.O3 && com.onetrust.otpublishers.headless.UI.Helper.i.a(i10, keyEvent) == 21) {
            ((k) this.f22511c).a(23);
        }
        int id = view.getId();
        int i11 = p6.d.f32833v5;
        if (id == i11 && com.onetrust.otpublishers.headless.UI.Helper.i.a(i10, keyEvent) == 21) {
            ((k) this.f22511c).a(33);
        }
        int id2 = view.getId();
        int i12 = p6.d.f32824u5;
        if ((id2 == i12 || view.getId() == p6.d.f32849x5 || view.getId() == i11) && com.onetrust.otpublishers.headless.UI.Helper.i.a(i10, keyEvent) == 25) {
            if (this.I) {
                if (OTVendorListMode.IAB.equalsIgnoreCase(this.H) && (a0Var = this.f22528t) != null) {
                    a0Var.z();
                }
                if ("google".equalsIgnoreCase(this.H) && (dVar = this.f22529u) != null) {
                    TextView textView = dVar.f22479b;
                    if (textView == null || com.onetrust.otpublishers.headless.Internal.c.q(textView.getText().toString())) {
                        view2 = dVar.f22482e;
                        if (view2 != null) {
                        }
                    } else {
                        view2 = dVar.f22479b;
                    }
                    view2.requestFocus();
                }
            } else {
                if (OTVendorListMode.IAB.equalsIgnoreCase(this.H)) {
                    this.f22524p.notifyDataSetChanged();
                }
                if ("google".equalsIgnoreCase(this.H) && (cVar = this.f22525q) != null) {
                    cVar.notifyDataSetChanged();
                }
            }
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            return true;
        }
        if (view.getId() == i12 && com.onetrust.otpublishers.headless.UI.Helper.i.a(i10, keyEvent) == 21) {
            ((k) this.f22511c).a(31);
        }
        if (view.getId() == p6.d.f32849x5 && com.onetrust.otpublishers.headless.UI.Helper.i.a(i10, keyEvent) == 21) {
            ((k) this.f22511c).a(32);
        }
        if (view.getId() == p6.d.S3 && com.onetrust.otpublishers.headless.UI.Helper.i.a(i10, keyEvent) == 21) {
            Map<String, String> map = this.f22521m;
            b0 b0Var = new b0();
            Bundle bundle = new Bundle();
            bundle.putString("TV_PC_CONTENT", OTFragmentTags.OT_VENDOR_LIST_FILTER_FRAGMENT_TAG);
            b0Var.setArguments(bundle);
            b0Var.f22468c = this;
            b0Var.f22472g = map;
            getChildFragmentManager().beginTransaction().replace(p6.d.P3, b0Var).addToBackStack(null).commit();
        }
        if (view.getId() == p6.d.f32777p3 && com.onetrust.otpublishers.headless.UI.Helper.i.a(i10, keyEvent) == 21) {
            u(this.f22533y, "A_F");
        }
        if (view.getId() == p6.d.f32795r3 && com.onetrust.otpublishers.headless.UI.Helper.i.a(i10, keyEvent) == 21) {
            u(this.f22534z, "G_L");
        }
        if (view.getId() == p6.d.f32813t3 && com.onetrust.otpublishers.headless.UI.Helper.i.a(i10, keyEvent) == 21) {
            u(this.A, "M_R");
        }
        if (view.getId() == p6.d.f32831v3 && com.onetrust.otpublishers.headless.UI.Helper.i.a(i10, keyEvent) == 21) {
            u(this.B, "S_Z");
        }
        if (view.getId() == p6.d.T5 && com.onetrust.otpublishers.headless.UI.Helper.i.a(i10, keyEvent) == 21) {
            try {
                this.H = OTVendorListMode.IAB;
                a();
                G();
                C(this.D, this.f22514f.f22370j.f22873y, false);
                com.onetrust.otpublishers.headless.UI.UIProperty.f fVar = this.f22514f.f22370j.f22873y;
                z(fVar.f22759b, fVar.c());
            } catch (JSONException e10) {
                com.onetrust.otpublishers.headless.Internal.Helper.x.a("onKey: error on setIABVendorData , ", e10, "TVVendorList", 6);
            }
        }
        if (view.getId() == p6.d.N5 && com.onetrust.otpublishers.headless.UI.Helper.i.a(i10, keyEvent) == 21) {
            try {
                this.H = "google";
                a();
                E();
                C(this.C, this.f22514f.f22370j.f22873y, false);
                com.onetrust.otpublishers.headless.UI.UIProperty.f fVar2 = this.f22514f.f22370j.f22873y;
                z(fVar2.f22759b, fVar2.c());
            } catch (JSONException e11) {
                com.onetrust.otpublishers.headless.Internal.Helper.x.a("onKey: error on setGoogleVendorData , ", e11, "TVVendorList", 6);
            }
        }
        return false;
    }

    @RequiresApi(api = 21)
    public final void s(Button button, com.onetrust.otpublishers.headless.UI.UIProperty.f fVar, String str, boolean z10) {
        if (z10) {
            if (!com.onetrust.otpublishers.headless.Internal.c.q(fVar.f22761d)) {
                com.onetrust.otpublishers.headless.UI.Helper.i.h(false, button, this.f22514f, str, true);
                return;
            } else {
                button.getBackground().setTint(Color.parseColor(this.f22514f.f22370j.B.f22798e));
                button.setTextColor(Color.parseColor(this.f22514f.f22370j.B.f22799f));
                return;
            }
        }
        if (!com.onetrust.otpublishers.headless.Internal.c.q(fVar.f22761d)) {
            com.onetrust.otpublishers.headless.UI.Helper.i.h(false, button, this.f22514f, str, false);
        } else {
            button.getBackground().setTint(Color.parseColor(fVar.f22759b));
            button.setTextColor(Color.parseColor(fVar.c()));
        }
    }

    @RequiresApi(api = 21)
    public final void t(Button button, com.onetrust.otpublishers.headless.UI.UIProperty.f fVar, boolean z10) {
        boolean z11 = true;
        if (!z10) {
            button.setElevation(0.0f);
            if (!(this.F.contains("A_F") && button.getText().toString().startsWith(ExifInterface.GPS_MEASUREMENT_IN_PROGRESS))) {
                if (!(this.F.contains("G_L") && button.getText().toString().startsWith(RequestConfiguration.MAX_AD_CONTENT_RATING_G))) {
                    if (!(this.F.contains("M_R") && button.getText().toString().startsWith("M"))) {
                        if (!(this.F.contains("S_Z") && button.getText().toString().startsWith(ExifInterface.LATITUDE_SOUTH))) {
                            z11 = false;
                        }
                    }
                }
            }
            s(button, fVar, "300", z11);
            return;
        }
        button.setElevation(6.0f);
        if (!com.onetrust.otpublishers.headless.Internal.c.q(fVar.f22761d)) {
            com.onetrust.otpublishers.headless.UI.Helper.i.h(true, button, this.f22514f, "300", false);
        } else {
            if (com.onetrust.otpublishers.headless.Internal.c.q(fVar.f22766i) || com.onetrust.otpublishers.headless.Internal.c.q(fVar.f22767j)) {
                return;
            }
            button.getBackground().setTint(Color.parseColor(fVar.f22766i));
            button.setTextColor(Color.parseColor(fVar.f22767j));
        }
    }

    public final void u(@NonNull Button button, @NonNull String str) {
        String str2;
        button.setSelected(!button.isSelected());
        if (button.isSelected()) {
            this.G = str;
            this.F.add(str);
            com.onetrust.otpublishers.headless.UI.UIProperty.x xVar = this.f22514f.f22370j;
            com.onetrust.otpublishers.headless.UI.UIProperty.q qVar = xVar.B;
            String str3 = qVar.f22798e;
            String str4 = qVar.f22799f;
            if (com.onetrust.otpublishers.headless.Internal.c.q(xVar.f22873y.f22761d)) {
                v(button, str3, str4);
            } else {
                com.onetrust.otpublishers.headless.UI.Helper.i.h(false, button, this.f22514f, "300", true);
            }
        } else {
            this.F.remove(str);
            com.onetrust.otpublishers.headless.UI.UIProperty.f fVar = this.f22514f.f22370j.f22873y;
            String str5 = fVar.f22759b;
            String strC = fVar.c();
            if (com.onetrust.otpublishers.headless.Internal.c.q(this.f22514f.f22370j.f22873y.f22761d)) {
                v(button, str5, strC);
            } else {
                com.onetrust.otpublishers.headless.UI.Helper.i.h(false, button, this.f22514f, "300", false);
            }
            if (this.F.isEmpty()) {
                str2 = "A_F";
            } else if (!this.F.contains(this.G)) {
                ArrayList<String> arrayList = this.F;
                str2 = arrayList.get(arrayList.size() - 1);
            }
            this.G = str2;
        }
        if (OTVendorListMode.IAB.equalsIgnoreCase(this.H)) {
            com.onetrust.otpublishers.headless.UI.TVUI.adapter.d0 d0Var = this.f22524p;
            d0Var.f22227r = this.F;
            d0Var.h();
            com.onetrust.otpublishers.headless.UI.TVUI.adapter.d0 d0Var2 = this.f22524p;
            d0Var2.f22224o = 0;
            d0Var2.notifyDataSetChanged();
            return;
        }
        if ("google".equalsIgnoreCase(this.H)) {
            com.onetrust.otpublishers.headless.UI.TVUI.adapter.c cVar = this.f22525q;
            cVar.f22206p = this.F;
            cVar.h();
            com.onetrust.otpublishers.headless.UI.TVUI.adapter.c cVar2 = this.f22525q;
            cVar2.f22203m = 0;
            cVar2.notifyDataSetChanged();
        }
    }

    public final void w(@NonNull Fragment fragment) {
        getChildFragmentManager().beginTransaction().replace(p6.d.P3, fragment).addToBackStack(null).commit();
        fragment.getLifecycle().addObserver(new LifecycleEventObserver() { // from class: com.onetrust.otpublishers.headless.UI.TVUI.fragments.c0
            @Override // androidx.lifecycle.LifecycleEventObserver
            public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                this.f22477a.F(lifecycleOwner, event);
            }
        });
    }

    public final void y(@NonNull String str) {
        if (com.onetrust.otpublishers.headless.Internal.c.q(str)) {
            return;
        }
        if (OTVendorListMode.IAB.equalsIgnoreCase(this.H)) {
            if (this.f22510b.getVendorDetails(OTVendorListMode.IAB, str) == null) {
                this.f22510b.reInitVendorArray();
            }
            com.onetrust.otpublishers.headless.Internal.Event.a aVar = this.f22512d;
            OTPublishersHeadlessSDK oTPublishersHeadlessSDK = this.f22510b;
            a0 a0Var = new a0();
            Bundle bundle = new Bundle();
            bundle.putString(OTFragmentTags.FRAGMENT_TAG, OTFragmentTags.OT_VENDOR_DETAILS_FRAGMENT_TAG);
            a0Var.setArguments(bundle);
            a0Var.f22432s = this;
            a0Var.f22430q = oTPublishersHeadlessSDK;
            a0Var.f22431r = oTPublishersHeadlessSDK.getVendorDetails(Integer.parseInt(str));
            a0Var.f22438y = aVar;
            this.f22528t = a0Var;
            w(a0Var);
            return;
        }
        if ("google".equalsIgnoreCase(this.H)) {
            if (this.f22510b.getVendorDetails("google", str) == null) {
                this.f22510b.reInitVendorArray();
            }
            com.onetrust.otpublishers.headless.Internal.Event.a aVar2 = this.f22512d;
            OTPublishersHeadlessSDK oTPublishersHeadlessSDK2 = this.f22510b;
            d dVar = new d();
            Bundle bundle2 = new Bundle();
            bundle2.putString(OTFragmentTags.FRAGMENT_TAG, OTFragmentTags.OT_VENDOR_DETAILS_FRAGMENT_TAG);
            dVar.setArguments(bundle2);
            dVar.f22488k = this;
            dVar.f22486i = oTPublishersHeadlessSDK2;
            dVar.f22487j = oTPublishersHeadlessSDK2.getVendorDetails("google", str);
            dVar.f22491n = aVar2;
            this.f22529u = dVar;
            w(dVar);
        }
    }

    @RequiresApi(api = 21)
    public final void z(String str, String str2) {
        if (com.onetrust.otpublishers.headless.Internal.c.q(this.f22514f.f22370j.f22873y.f22761d)) {
            v(this.f22533y, str, str2);
            v(this.f22534z, str, str2);
            v(this.A, str, str2);
            v(this.B, str, str2);
            v(this.C, str, str2);
            v(this.D, str, str2);
            this.C.setMinHeight(70);
            this.C.setMinimumHeight(70);
            this.D.setMinHeight(70);
            this.D.setMinimumHeight(70);
            return;
        }
        com.onetrust.otpublishers.headless.UI.Helper.i.h(false, this.f22533y, this.f22514f, "300", false);
        com.onetrust.otpublishers.headless.UI.Helper.i.h(false, this.f22534z, this.f22514f, "300", false);
        com.onetrust.otpublishers.headless.UI.Helper.i.h(false, this.A, this.f22514f, "300", false);
        com.onetrust.otpublishers.headless.UI.Helper.i.h(false, this.B, this.f22514f, "300", false);
        com.onetrust.otpublishers.headless.UI.Helper.i.h(false, this.C, this.f22514f, ExifInterface.GPS_MEASUREMENT_3D, false);
        com.onetrust.otpublishers.headless.UI.Helper.i.h(false, this.D, this.f22514f, ExifInterface.GPS_MEASUREMENT_3D, false);
        this.C.setMinHeight(0);
        this.C.setMinimumHeight(0);
        this.D.setMinHeight(0);
        this.D.setMinimumHeight(0);
        this.C.setPadding(0, 5, 0, 5);
        this.D.setPadding(0, 5, 0, 5);
    }

    @RequiresApi(api = 21)
    public final void a() {
        this.F.clear();
        this.B.setSelected(false);
        this.f22534z.setSelected(false);
        this.A.setSelected(false);
        this.f22533y.setSelected(false);
        com.onetrust.otpublishers.headless.UI.UIProperty.f fVar = this.f22514f.f22370j.f22873y;
        v(this.f22533y, fVar.f22759b, fVar.c());
        v(this.f22534z, fVar.f22759b, fVar.c());
        v(this.A, fVar.f22759b, fVar.c());
        v(this.B, fVar.f22759b, fVar.c());
    }

    @Override // com.onetrust.otpublishers.headless.Public.uiutils.OTVendorUtils.ItemListener
    public final void onItemClick(@NonNull String str, boolean z10) {
    }
}
