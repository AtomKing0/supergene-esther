package com.onetrust.otpublishers.headless.UI.TVUI.fragments;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.onetrust.otpublishers.headless.Public.OTPublishersHeadlessSDK;
import com.onetrust.otpublishers.headless.UI.TVUI.adapter.j;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class e extends Fragment implements j.a, View.OnKeyListener, View.OnFocusChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f22497a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f22498b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public RecyclerView f22499c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Context f22500d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public OTPublishersHeadlessSDK f22501e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public JSONObject f22502f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public LinearLayout f22503g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public a f22504h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public com.onetrust.otpublishers.headless.UI.TVUI.datautils.c f22505i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ImageView f22506j;

    public interface a {
    }

    @Override // com.onetrust.otpublishers.headless.UI.TVUI.adapter.j.a
    public final void a() {
    }

    @Override // androidx.fragment.app.Fragment
    public final void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        this.f22500d = getContext();
    }

    @Override // androidx.fragment.app.Fragment
    @RequiresApi(api = 21)
    public final View onCreateView(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Context context = this.f22500d;
        int i10 = p6.e.f32885s;
        if (com.onetrust.otpublishers.headless.Internal.c.x(context)) {
            layoutInflater = layoutInflater.cloneInContext(new ContextThemeWrapper(context, p6.g.f32919b));
        }
        View viewInflate = layoutInflater.inflate(i10, viewGroup, false);
        this.f22497a = (TextView) viewInflate.findViewById(p6.d.f32865z5);
        this.f22498b = (TextView) viewInflate.findViewById(p6.d.f32671d5);
        this.f22499c = (RecyclerView) viewInflate.findViewById(p6.d.f32780p6);
        this.f22503g = (LinearLayout) viewInflate.findViewById(p6.d.P5);
        this.f22506j = (ImageView) viewInflate.findViewById(p6.d.f32771o6);
        this.f22499c.setHasFixedSize(true);
        this.f22499c.setLayoutManager(new LinearLayoutManager(getActivity()));
        this.f22506j.setOnKeyListener(this);
        this.f22506j.setOnFocusChangeListener(this);
        p();
        return viewInflate;
    }

    @Override // android.view.View.OnFocusChangeListener
    @RequiresApi(api = 21)
    public final void onFocusChange(View view, boolean z10) {
        if (view.getId() == p6.d.f32771o6) {
            com.onetrust.otpublishers.headless.UI.Helper.i.i(z10, this.f22505i.f22370j.f22873y, this.f22506j);
        }
    }

    @Override // android.view.View.OnKeyListener
    public final boolean onKey(View view, int i10, KeyEvent keyEvent) {
        Button button;
        if (view.getId() == p6.d.C0 && com.onetrust.otpublishers.headless.UI.Helper.i.a(i10, keyEvent) == 21) {
            HashMap map = new HashMap();
            map.put(this.f22502f.optString("CustomGroupId"), this.f22502f.optString("Type"));
            k kVar = (k) ((q) this.f22504h).f22611c;
            kVar.f22576j = 4;
            b bVar = kVar.f22577k;
            if (bVar != null && bVar.getArguments() != null) {
                kVar.f22577k.getArguments().putInt("OT_TV_FOCUSED_BTN", 1);
            }
            kVar.y(map, true, false);
        }
        if (view.getId() == p6.d.D0 && com.onetrust.otpublishers.headless.UI.Helper.i.a(i10, keyEvent) == 21) {
            FragmentActivity activity = getActivity();
            com.onetrust.otpublishers.headless.UI.TVUI.datautils.c cVar = this.f22505i;
            com.onetrust.otpublishers.headless.UI.Helper.i.g(activity, cVar.f22375o, cVar.f22376p, cVar.f22370j.f22873y);
        }
        if (view.getId() == p6.d.f32771o6 && com.onetrust.otpublishers.headless.UI.Helper.i.a(i10, keyEvent) == 21) {
            this.f22501e.getPurposeConsentLocal(this.f22502f.optString("CustomGroupId"));
            this.f22501e.getPurposeLegitInterestLocal(this.f22502f.optString("CustomGroupId"));
            q qVar = (q) this.f22504h;
            qVar.getChildFragmentManager().popBackStackImmediate();
            g gVar = qVar.f22623o;
            if (gVar != null) {
                gVar.P.requestFocus();
            }
        }
        if (view.getId() != p6.d.R2 || keyEvent.getKeyCode() != 20) {
            if (view.getId() == p6.d.F0 && com.onetrust.otpublishers.headless.UI.Helper.i.a(i10, keyEvent) == 21) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.f22502f.optString("CustomGroupId"));
                ((q) this.f22504h).t(arrayList);
            }
            return false;
        }
        q qVar2 = (q) this.f22504h;
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

    @RequiresApi(api = 21)
    public final void p() {
        JSONArray jSONArray;
        com.onetrust.otpublishers.headless.UI.TVUI.datautils.c cVarJ = com.onetrust.otpublishers.headless.UI.TVUI.datautils.c.j();
        this.f22505i = cVarJ;
        com.onetrust.otpublishers.headless.UI.Helper.l.j(this.f22500d, this.f22497a, cVarJ.f22377q);
        Context context = this.f22500d;
        TextView textView = this.f22498b;
        JSONObject jSONObject = this.f22502f;
        com.onetrust.otpublishers.headless.UI.Helper.l.j(context, textView, jSONObject.optString(com.onetrust.otpublishers.headless.Internal.c.q(jSONObject.optString("GroupNameOTT")) ? "GroupName" : "GroupNameOTT"));
        this.f22506j.setVisibility(0);
        com.onetrust.otpublishers.headless.UI.TVUI.datautils.c cVar = this.f22505i;
        String strM = cVar.m();
        com.onetrust.otpublishers.headless.UI.UIProperty.x xVar = cVar.f22370j;
        com.onetrust.otpublishers.headless.UI.UIProperty.c cVar2 = xVar.f22859k;
        com.onetrust.otpublishers.headless.UI.UIProperty.c cVar3 = xVar.f22867s;
        if (!com.onetrust.otpublishers.headless.Internal.c.q(cVar2.f22720a.f22783b)) {
            this.f22497a.setTextSize(Float.parseFloat(cVar2.f22720a.f22783b));
        }
        if (!com.onetrust.otpublishers.headless.Internal.c.q(cVar3.f22720a.f22783b)) {
            this.f22498b.setTextSize(Float.parseFloat(cVar3.f22720a.f22783b));
        }
        if (com.onetrust.otpublishers.headless.Internal.c.q(cVar2.f22722c)) {
            this.f22497a.setTextColor(Color.parseColor(strM));
        } else {
            this.f22497a.setTextColor(Color.parseColor(cVar2.f22722c));
        }
        if (com.onetrust.otpublishers.headless.Internal.c.q(cVar3.f22722c)) {
            this.f22498b.setTextColor(Color.parseColor(strM));
        } else {
            this.f22498b.setTextColor(Color.parseColor(cVar3.f22722c));
        }
        this.f22503g.setBackgroundColor(Color.parseColor(cVar.a()));
        com.onetrust.otpublishers.headless.UI.Helper.i.i(false, cVar.f22370j.f22873y, this.f22506j);
        this.f22506j.setNextFocusDownId(p6.d.f32857y5);
        if (this.f22502f.has("IabIllustrations")) {
            try {
                jSONArray = this.f22502f.getJSONArray("IabIllustrations");
            } catch (JSONException e10) {
                com.onetrust.otpublishers.headless.Internal.Helper.p.a(e10, new StringBuilder("Error on parsing iab illustrations. Error = "), "TVIllustration", 6);
                jSONArray = null;
            }
        } else {
            jSONArray = null;
        }
        if (jSONArray == null || com.onetrust.otpublishers.headless.Internal.a.c(jSONArray)) {
            return;
        }
        String strM2 = this.f22505i.m();
        this.f22498b.setTextColor(Color.parseColor(strM2));
        this.f22499c.setAdapter(new com.onetrust.otpublishers.headless.UI.TVUI.adapter.d(this.f22500d, jSONArray, strM2));
    }

    @Override // com.onetrust.otpublishers.headless.UI.TVUI.adapter.j.a
    public final void a(JSONObject jSONObject) {
        ((q) this.f22504h).u(jSONObject, true, false);
    }
}
