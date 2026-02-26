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
import com.onetrust.otpublishers.headless.UI.TVUI.adapter.u;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class b0 extends Fragment implements u.a, View.OnKeyListener, View.OnFocusChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f22466a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public FragmentActivity f22467b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public a f22468c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public RecyclerView f22469d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public com.onetrust.otpublishers.headless.UI.TVUI.datautils.c f22470e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public com.onetrust.otpublishers.headless.UI.TVUI.datautils.d f22471f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Map<String, String> f22472g = new HashMap();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Button f22473h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Button f22474i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public com.onetrust.otpublishers.headless.UI.TVUI.adapter.u f22475j;

    public interface a {
    }

    @Override // androidx.fragment.app.Fragment
    public final void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        this.f22467b = getActivity();
        this.f22470e = com.onetrust.otpublishers.headless.UI.TVUI.datautils.c.j();
        this.f22471f = com.onetrust.otpublishers.headless.UI.TVUI.datautils.d.a();
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        FragmentActivity fragmentActivity = this.f22467b;
        int i10 = p6.e.G;
        if (com.onetrust.otpublishers.headless.Internal.c.x(fragmentActivity)) {
            layoutInflater = layoutInflater.cloneInContext(new ContextThemeWrapper(fragmentActivity, p6.g.f32919b));
        }
        View viewInflate = layoutInflater.inflate(i10, viewGroup, false);
        this.f22466a = (TextView) viewInflate.findViewById(p6.d.G3);
        this.f22469d = (RecyclerView) viewInflate.findViewById(p6.d.E3);
        this.f22474i = (Button) viewInflate.findViewById(p6.d.A3);
        this.f22473h = (Button) viewInflate.findViewById(p6.d.f32863z3);
        this.f22466a.requestFocus();
        this.f22473h.setOnKeyListener(this);
        this.f22474i.setOnKeyListener(this);
        this.f22473h.setOnFocusChangeListener(this);
        this.f22474i.setOnFocusChangeListener(this);
        String strM = this.f22470e.m();
        com.onetrust.otpublishers.headless.UI.Helper.i.k(this.f22473h, this.f22470e.f22370j.f22873y, false);
        com.onetrust.otpublishers.headless.UI.Helper.i.k(this.f22474i, this.f22470e.f22370j.f22873y, false);
        this.f22466a.setTextColor(Color.parseColor(strM));
        try {
            this.f22474i.setText(this.f22471f.f22383d);
            this.f22473h.setText(this.f22471f.f22382c);
            JSONObject jSONObjectL = this.f22470e.l(this.f22467b);
            if (this.f22472g == null) {
                this.f22472g = new HashMap();
            }
            if (jSONObjectL != null) {
                JSONArray jSONArrayOptJSONArray = jSONObjectL.optJSONArray("Groups");
                if (jSONArrayOptJSONArray == null) {
                    jSONArrayOptJSONArray = new JSONArray();
                }
                this.f22475j = new com.onetrust.otpublishers.headless.UI.TVUI.adapter.u(com.onetrust.otpublishers.headless.UI.Helper.l.h(jSONArrayOptJSONArray), this.f22470e.m(), this.f22472g, this);
                this.f22469d.setLayoutManager(new LinearLayoutManager(this.f22467b));
                this.f22469d.setAdapter(this.f22475j);
            }
        } catch (Exception e10) {
            com.onetrust.otpublishers.headless.Internal.Helper.j.a(e10, new StringBuilder("error while populating VL fields"), "TVVendorListFilter", 6);
        }
        return viewInflate;
    }

    @Override // android.view.View.OnFocusChangeListener
    public final void onFocusChange(View view, boolean z10) {
        if (view.getId() == p6.d.A3) {
            com.onetrust.otpublishers.headless.UI.Helper.i.k(this.f22474i, this.f22470e.f22370j.f22873y, z10);
        }
        if (view.getId() == p6.d.f32863z3) {
            com.onetrust.otpublishers.headless.UI.Helper.i.k(this.f22473h, this.f22470e.f22370j.f22873y, z10);
        }
    }

    @Override // android.view.View.OnKeyListener
    public final boolean onKey(View view, int i10, KeyEvent keyEvent) {
        if (view.getId() == p6.d.A3 && com.onetrust.otpublishers.headless.UI.Helper.i.a(i10, keyEvent) == 21) {
            com.onetrust.otpublishers.headless.UI.TVUI.adapter.u uVar = this.f22475j;
            HashMap map = new HashMap();
            uVar.getClass();
            uVar.f22313l = new HashMap(map);
            this.f22475j.notifyDataSetChanged();
            this.f22472g = new HashMap();
        }
        if (view.getId() == p6.d.f32863z3 && com.onetrust.otpublishers.headless.UI.Helper.i.a(i10, keyEvent) == 21) {
            ((f0) this.f22468c).A(this.f22472g);
        }
        if (i10 != 4 || keyEvent.getAction() != 1) {
            return false;
        }
        ((f0) this.f22468c).a(23);
        return false;
    }
}
