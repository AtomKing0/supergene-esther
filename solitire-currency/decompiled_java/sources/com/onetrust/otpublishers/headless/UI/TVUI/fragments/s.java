package com.onetrust.otpublishers.headless.UI.TVUI.fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import com.onetrust.otpublishers.headless.UI.TVUI.adapter.n;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class s extends Fragment implements n.a, View.OnKeyListener, View.OnFocusChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f22652a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public FragmentActivity f22653b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public a f22654c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public RecyclerView f22655d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public com.onetrust.otpublishers.headless.UI.TVUI.datautils.c f22656e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public com.onetrust.otpublishers.headless.UI.TVUI.datautils.d f22657f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public List<String> f22658g = new ArrayList();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Button f22659h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Button f22660i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public com.onetrust.otpublishers.headless.UI.TVUI.adapter.n f22661j;

    public interface a {
    }

    @Override // androidx.fragment.app.Fragment
    public final void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        this.f22653b = getActivity();
        this.f22656e = com.onetrust.otpublishers.headless.UI.TVUI.datautils.c.j();
        this.f22657f = com.onetrust.otpublishers.headless.UI.TVUI.datautils.d.a();
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        FragmentActivity fragmentActivity = this.f22653b;
        int i10 = p6.e.G;
        if (com.onetrust.otpublishers.headless.Internal.c.x(fragmentActivity)) {
            layoutInflater = layoutInflater.cloneInContext(new ContextThemeWrapper(fragmentActivity, p6.g.f32919b));
        }
        View viewInflate = layoutInflater.inflate(i10, viewGroup, false);
        this.f22652a = (TextView) viewInflate.findViewById(p6.d.G3);
        this.f22655d = (RecyclerView) viewInflate.findViewById(p6.d.E3);
        this.f22660i = (Button) viewInflate.findViewById(p6.d.A3);
        this.f22659h = (Button) viewInflate.findViewById(p6.d.f32863z3);
        this.f22652a.requestFocus();
        this.f22659h.setOnKeyListener(this);
        this.f22660i.setOnKeyListener(this);
        this.f22659h.setOnFocusChangeListener(this);
        this.f22660i.setOnFocusChangeListener(this);
        String strM = this.f22656e.m();
        com.onetrust.otpublishers.headless.UI.Helper.i.k(this.f22659h, this.f22656e.f22370j.f22873y, false);
        com.onetrust.otpublishers.headless.UI.Helper.i.k(this.f22660i, this.f22656e.f22370j.f22873y, false);
        this.f22652a.setText("Filter SDK List");
        this.f22652a.setTextColor(Color.parseColor(strM));
        try {
            this.f22660i.setText(this.f22657f.f22383d);
            this.f22659h.setText(this.f22657f.f22382c);
            if (this.f22658g == null) {
                this.f22658g = new ArrayList();
            }
            JSONArray jSONArrayA = com.onetrust.otpublishers.headless.Internal.Helper.k.a(this.f22657f.f22380a);
            JSONArray jSONArray = new JSONArray();
            for (int i11 = 0; i11 < jSONArrayA.length(); i11++) {
                try {
                    com.onetrust.otpublishers.headless.UI.TVUI.datautils.d.b(i11, jSONArrayA, jSONArray, new JSONObject());
                } catch (JSONException e10) {
                    OTLogger.a("TVDataUtils", 6, "Error on parsing Categories list. Error msg = " + e10.getMessage());
                }
            }
            this.f22661j = new com.onetrust.otpublishers.headless.UI.TVUI.adapter.n(jSONArray, this.f22656e.m(), this.f22658g, this);
            this.f22655d.setLayoutManager(new LinearLayoutManager(this.f22653b));
            this.f22655d.setAdapter(this.f22661j);
        } catch (Exception e11) {
            com.onetrust.otpublishers.headless.Internal.Helper.j.a(e11, new StringBuilder("error while populating SDK List fields"), "TVVendorListFilter", 6);
        }
        return viewInflate;
    }

    @Override // android.view.View.OnFocusChangeListener
    public final void onFocusChange(View view, boolean z10) {
        if (view.getId() == p6.d.A3) {
            com.onetrust.otpublishers.headless.UI.Helper.i.k(this.f22660i, this.f22656e.f22370j.f22873y, z10);
        }
        if (view.getId() == p6.d.f32863z3) {
            com.onetrust.otpublishers.headless.UI.Helper.i.k(this.f22659h, this.f22656e.f22370j.f22873y, z10);
        }
    }

    @Override // android.view.View.OnKeyListener
    public final boolean onKey(View view, int i10, KeyEvent keyEvent) {
        if (view.getId() == p6.d.A3 && com.onetrust.otpublishers.headless.UI.Helper.i.a(i10, keyEvent) == 21) {
            this.f22661j.f22277l = new ArrayList();
            this.f22661j.notifyDataSetChanged();
            this.f22658g = new ArrayList();
        }
        if (view.getId() == p6.d.f32863z3 && com.onetrust.otpublishers.headless.UI.Helper.i.a(i10, keyEvent) == 21) {
            ((u) this.f22654c).u(this.f22658g);
        }
        if (i10 != 4 || keyEvent.getAction() != 1) {
            return false;
        }
        ((u) this.f22654c).getChildFragmentManager().popBackStackImmediate();
        return false;
    }
}
