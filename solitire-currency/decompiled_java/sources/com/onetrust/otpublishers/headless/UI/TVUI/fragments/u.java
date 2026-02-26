package com.onetrust.otpublishers.headless.UI.TVUI.fragments;

import android.content.Context;
import android.content.SharedPreferences;
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
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.onetrust.otpublishers.headless.Public.DataModel.OTConfiguration;
import com.onetrust.otpublishers.headless.Public.Keys.OTFragmentTags;
import com.onetrust.otpublishers.headless.Public.OTPublishersHeadlessSDK;
import com.onetrust.otpublishers.headless.UI.TVUI.adapter.q;
import com.onetrust.otpublishers.headless.UI.TVUI.fragments.r;
import com.onetrust.otpublishers.headless.UI.TVUI.fragments.s;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class u extends Fragment implements q.b, View.OnKeyListener, r.a, s.a, View.OnFocusChangeListener {
    public com.onetrust.otpublishers.headless.Internal.Event.a A;
    public boolean B;
    public OTConfiguration C;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public FragmentActivity f22663a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a f22664b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public RecyclerView f22665c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public com.onetrust.otpublishers.headless.UI.TVUI.datautils.c f22666d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public com.onetrust.otpublishers.headless.UI.TVUI.datautils.d f22667e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public RelativeLayout f22668f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public LinearLayout f22669g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ImageView f22670h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ImageView f22671i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public View f22672j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public List<String> f22673k = new ArrayList();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public com.onetrust.otpublishers.headless.UI.TVUI.adapter.q f22674l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public View f22675m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public TextView f22676n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public r f22677o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Button f22678p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Button f22679q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Button f22680r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public Button f22681s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public Button f22682t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public Button f22683u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Button f22684v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public ImageView f22685w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public ArrayList<String> f22686x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public String f22687y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public OTPublishersHeadlessSDK f22688z;

    public interface a {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void s(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        if (event.compareTo(Lifecycle.Event.ON_RESUME) == 0) {
            this.f22680r.clearFocus();
            this.f22679q.clearFocus();
            this.f22678p.clearFocus();
        }
    }

    public final void a() {
        List<String> list;
        com.onetrust.otpublishers.headless.Internal.Preferences.h hVar;
        boolean z10;
        boolean z11;
        List<String> list2 = this.f22673k;
        if (list2 == null || list2.isEmpty()) {
            JSONArray jSONArrayA = com.onetrust.otpublishers.headless.Internal.Helper.k.a(com.onetrust.otpublishers.headless.UI.TVUI.datautils.d.a().f22380a);
            JSONArray jSONArray = new JSONArray();
            for (int i10 = 0; i10 < jSONArrayA.length(); i10++) {
                try {
                    com.onetrust.otpublishers.headless.UI.TVUI.datautils.d.b(i10, jSONArrayA, jSONArray, new JSONObject());
                } catch (JSONException e10) {
                    com.onetrust.otpublishers.headless.Internal.Helper.p.a(e10, new StringBuilder("Error on parsing Categories list. Error msg = "), "TVDataUtils", 6);
                }
            }
            ArrayList arrayList = new ArrayList();
            for (int i11 = 0; i11 < jSONArray.length(); i11++) {
                try {
                    arrayList.add(jSONArray.getJSONObject(i11).optString("CustomGroupId", ""));
                } catch (JSONException e11) {
                    com.onetrust.otpublishers.headless.Internal.Helper.x.a("addCategoriesToMapForClearFilter: ", e11, "TVDataUtils", 6);
                }
            }
            list = arrayList;
        } else {
            list = this.f22673k;
        }
        Context contextRequireContext = requireContext();
        new JSONObject();
        SharedPreferences sharedPreferences = contextRequireContext.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0);
        if (com.onetrust.otpublishers.headless.Internal.Helper.l.a(contextRequireContext)) {
            hVar = new com.onetrust.otpublishers.headless.Internal.Preferences.h(contextRequireContext, sharedPreferences, sharedPreferences.getString("OT_ACTIVE_PROFILE_ID", ""));
            z10 = true;
        } else {
            hVar = null;
            z10 = false;
        }
        if (z10) {
            sharedPreferences = hVar;
        }
        new com.onetrust.otpublishers.headless.Internal.Preferences.e(contextRequireContext);
        OTPublishersHeadlessSDK oTPublishersHeadlessSDK = this.f22688z;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (String str : list) {
            String string = sharedPreferences.getString("OTT_INTERNAL_SDK_GROUP_MAP", "");
            JSONArray jSONArray2 = new JSONArray();
            if (!com.onetrust.otpublishers.headless.Internal.c.q(string)) {
                try {
                    JSONObject jSONObject = new JSONObject(string);
                    if (jSONObject.has(str)) {
                        jSONArray2 = new JSONArray(jSONObject.get(str).toString());
                    }
                } catch (JSONException e12) {
                    com.onetrust.otpublishers.headless.Internal.Helper.p.a(e12, new StringBuilder("Error while fetching Sdks by group : "), "SdkListHelper", 6);
                }
            }
            int purposeConsentLocal = oTPublishersHeadlessSDK.getPurposeConsentLocal(str);
            int length = jSONArray2.length();
            if (length == 1) {
                int consentStatusForSDKId = oTPublishersHeadlessSDK.getConsentStatusForSDKId(jSONArray2.optString(0));
                if (purposeConsentLocal != consentStatusForSDKId) {
                    oTPublishersHeadlessSDK.updatePurposeConsent(str, consentStatusForSDKId == 1, true);
                }
                z11 = true;
            } else {
                z11 = false;
            }
            if (!z11) {
                for (int i12 = 1; i12 < length; i12++) {
                    int consentStatusForSDKId2 = oTPublishersHeadlessSDK.getConsentStatusForSDKId(jSONArray2.optString(i12 - 1));
                    int consentStatusForSDKId3 = oTPublishersHeadlessSDK.getConsentStatusForSDKId(jSONArray2.optString(i12));
                    if (consentStatusForSDKId2 != consentStatusForSDKId3) {
                        break;
                    }
                    if (i12 == length - 1) {
                        oTPublishersHeadlessSDK.updatePurposeConsent(str, consentStatusForSDKId3 == 1, true);
                    }
                }
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        this.f22663a = getActivity();
        this.f22666d = com.onetrust.otpublishers.headless.UI.TVUI.datautils.c.j();
        this.f22667e = com.onetrust.otpublishers.headless.UI.TVUI.datautils.d.a();
        this.f22686x = new ArrayList<>();
        this.f22687y = "A_F";
    }

    /* JADX WARN: Removed duplicated region for block: B:59:0x02e3  */
    @Override // androidx.fragment.app.Fragment
    @androidx.annotation.RequiresApi(api = 21)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.view.View onCreateView(@androidx.annotation.NonNull android.view.LayoutInflater r17, android.view.ViewGroup r18, android.os.Bundle r19) {
        /*
            Method dump skipped, instruction units count: 966
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onetrust.otpublishers.headless.UI.TVUI.fragments.u.onCreateView(android.view.LayoutInflater, android.view.ViewGroup, android.os.Bundle):android.view.View");
    }

    @Override // android.view.View.OnFocusChangeListener
    @RequiresApi(api = 21)
    public final void onFocusChange(View view, boolean z10) {
        Drawable drawable;
        String str;
        if (view.getId() == p6.d.f32797r5) {
            com.onetrust.otpublishers.headless.UI.Helper.i.k(this.f22678p, this.f22666d.f22370j.f22873y, z10);
        }
        if (view.getId() == p6.d.f32815t5) {
            com.onetrust.otpublishers.headless.UI.Helper.i.k(this.f22680r, this.f22666d.f22370j.f22872x, z10);
        }
        if (view.getId() == p6.d.f32788q5) {
            com.onetrust.otpublishers.headless.UI.Helper.i.k(this.f22679q, this.f22666d.f22370j.f22871w, z10);
        }
        if (view.getId() == p6.d.f32786q3) {
            q(this.f22681s, this.f22666d.f22370j.f22873y, z10);
        }
        if (view.getId() == p6.d.f32804s3) {
            q(this.f22682t, this.f22666d.f22370j.f22873y, z10);
        }
        if (view.getId() == p6.d.f32822u3) {
            q(this.f22683u, this.f22666d.f22370j.f22873y, z10);
        }
        if (view.getId() == p6.d.f32839w3) {
            q(this.f22684v, this.f22666d.f22370j.f22873y, z10);
        }
        if (view.getId() == p6.d.f32768o3) {
            ImageView imageView = this.f22685w;
            if (z10) {
                drawable = imageView.getDrawable();
                str = this.f22667e.f22386g.f22766i;
            } else {
                List<String> list = this.f22673k;
                if (list == null || list.isEmpty()) {
                    drawable = imageView.getDrawable();
                    str = this.f22667e.f22386g.f22759b;
                } else {
                    drawable = imageView.getDrawable();
                    str = this.f22667e.f22386g.f22760c;
                }
            }
            drawable.setTint(Color.parseColor(str));
        }
        if (view.getId() == p6.d.f32723j3) {
            com.onetrust.otpublishers.headless.UI.Helper.i.i(z10, this.f22666d.f22370j.f22873y, this.f22671i);
        }
    }

    @Override // android.view.View.OnKeyListener
    @RequiresApi(api = 21)
    public final boolean onKey(View view, int i10, KeyEvent keyEvent) {
        boolean z10;
        View view2;
        if (view.getId() == p6.d.f32723j3 && com.onetrust.otpublishers.headless.UI.Helper.i.a(i10, keyEvent) == 21) {
            a();
            ((k) this.f22664b).a(23);
        }
        int id = view.getId();
        int i11 = p6.d.f32797r5;
        if (id == i11 && com.onetrust.otpublishers.headless.UI.Helper.i.a(i10, keyEvent) == 21) {
            a();
            ((k) this.f22664b).a(43);
        }
        int id2 = view.getId();
        int i12 = p6.d.f32788q5;
        if ((id2 == i12 || view.getId() == p6.d.f32815t5 || view.getId() == i11) && com.onetrust.otpublishers.headless.UI.Helper.i.a(i10, keyEvent) == 25) {
            if (this.B) {
                r rVar = this.f22677o;
                if (rVar.f22636g.getVisibility() == 0) {
                    view2 = rVar.f22636g;
                } else {
                    rVar.f22633d.setFocusableInTouchMode(true);
                    if (!com.onetrust.otpublishers.headless.Internal.c.q(rVar.f22633d.getText().toString())) {
                        view2 = rVar.f22633d;
                    }
                }
                view2.requestFocus();
            } else {
                this.f22674l.notifyDataSetChanged();
            }
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            return true;
        }
        if (view.getId() == i12 && com.onetrust.otpublishers.headless.UI.Helper.i.a(i10, keyEvent) == 21) {
            ((k) this.f22664b).a(41);
        }
        if (view.getId() == p6.d.f32815t5 && com.onetrust.otpublishers.headless.UI.Helper.i.a(i10, keyEvent) == 21) {
            ((k) this.f22664b).a(42);
        }
        if (view.getId() == p6.d.f32768o3 && com.onetrust.otpublishers.headless.UI.Helper.i.a(i10, keyEvent) == 21) {
            List<String> list = this.f22673k;
            s sVar = new s();
            Bundle bundle = new Bundle();
            bundle.putString("TV_PC_CONTENT", OTFragmentTags.OT_SDK_LIST_FILTER_FRAGMENT_TAG);
            sVar.setArguments(bundle);
            sVar.f22658g = list;
            sVar.f22654c = this;
            getChildFragmentManager().beginTransaction().replace(p6.d.f32732k3, sVar).addToBackStack(null).commit();
        }
        if (view.getId() == p6.d.f32786q3 && com.onetrust.otpublishers.headless.UI.Helper.i.a(i10, keyEvent) == 21) {
            r(this.f22681s, "A_F");
        }
        if (view.getId() == p6.d.f32804s3 && com.onetrust.otpublishers.headless.UI.Helper.i.a(i10, keyEvent) == 21) {
            r(this.f22682t, "G_L");
        }
        if (view.getId() == p6.d.f32822u3 && com.onetrust.otpublishers.headless.UI.Helper.i.a(i10, keyEvent) == 21) {
            r(this.f22683u, "M_R");
        }
        if (view.getId() == p6.d.f32839w3 && com.onetrust.otpublishers.headless.UI.Helper.i.a(i10, keyEvent) == 21) {
            r(this.f22684v, "S_Z");
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x00c4  */
    @androidx.annotation.RequiresApi(api = 21)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void q(android.widget.Button r5, com.onetrust.otpublishers.headless.UI.UIProperty.f r6, boolean r7) {
        /*
            Method dump skipped, instruction units count: 287
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onetrust.otpublishers.headless.UI.TVUI.fragments.u.q(android.widget.Button, com.onetrust.otpublishers.headless.UI.UIProperty.f, boolean):void");
    }

    public final void r(@NonNull Button button, @NonNull String str) {
        String str2;
        button.setSelected(!button.isSelected());
        if (button.isSelected()) {
            this.f22687y = str;
            this.f22686x.add(str);
            com.onetrust.otpublishers.headless.UI.UIProperty.x xVar = this.f22666d.f22370j;
            com.onetrust.otpublishers.headless.UI.UIProperty.q qVar = xVar.B;
            String str3 = qVar.f22798e;
            String str4 = qVar.f22799f;
            if (!com.onetrust.otpublishers.headless.Internal.c.q(xVar.f22873y.f22761d)) {
                com.onetrust.otpublishers.headless.UI.Helper.i.h(false, button, this.f22666d, "300", true);
            } else if (str3 != null && str4 != null) {
                button.getBackground().setTint(Color.parseColor(str3));
                button.setTextColor(Color.parseColor(str4));
            }
        } else {
            this.f22686x.remove(str);
            com.onetrust.otpublishers.headless.UI.UIProperty.x xVar2 = this.f22666d.f22370j;
            com.onetrust.otpublishers.headless.UI.UIProperty.q qVar2 = xVar2.B;
            String str5 = qVar2.f22798e;
            String str6 = qVar2.f22799f;
            if (!com.onetrust.otpublishers.headless.Internal.c.q(xVar2.f22873y.f22761d)) {
                com.onetrust.otpublishers.headless.UI.Helper.i.h(false, button, this.f22666d, "300", false);
            } else if (str5 != null && str6 != null) {
                button.getBackground().setTint(Color.parseColor(str5));
                button.setTextColor(Color.parseColor(str6));
            }
            if (this.f22686x.size() == 0) {
                str2 = "A_F";
            } else if (!this.f22686x.contains(this.f22687y)) {
                ArrayList<String> arrayList = this.f22686x;
                str2 = arrayList.get(arrayList.size() - 1);
            }
            this.f22687y = str2;
        }
        com.onetrust.otpublishers.headless.UI.TVUI.adapter.q qVar3 = this.f22674l;
        qVar3.f22297o = this.f22686x;
        List<JSONObject> listC = qVar3.c();
        com.onetrust.otpublishers.headless.UI.TVUI.adapter.q qVar4 = this.f22674l;
        qVar4.f22295m = 0;
        qVar4.notifyDataSetChanged();
        if (listC != null) {
            ArrayList arrayList2 = (ArrayList) listC;
            if (arrayList2.isEmpty()) {
                return;
            }
            JSONObject jSONObject = (JSONObject) arrayList2.get(0);
            com.onetrust.otpublishers.headless.Internal.Event.a aVar = this.A;
            OTPublishersHeadlessSDK oTPublishersHeadlessSDK = this.f22688z;
            r rVar = new r();
            Bundle bundle = new Bundle();
            bundle.putString(OTFragmentTags.FRAGMENT_TAG, OTFragmentTags.OT_SDK_DETAIL_FRAGMENT);
            rVar.setArguments(bundle);
            rVar.f22645p = this;
            rVar.f22641l = jSONObject;
            rVar.f22650u = aVar;
            rVar.f22651v = oTPublishersHeadlessSDK;
            this.f22677o = rVar;
            t(rVar);
        }
    }

    public final void t(@NonNull r rVar) {
        getChildFragmentManager().beginTransaction().replace(p6.d.f32732k3, rVar).addToBackStack(null).commit();
        rVar.getLifecycle().addObserver(new LifecycleEventObserver() { // from class: com.onetrust.otpublishers.headless.UI.TVUI.fragments.t
            @Override // androidx.lifecycle.LifecycleEventObserver
            public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                this.f22662a.s(lifecycleOwner, event);
            }
        });
    }

    @RequiresApi(api = 21)
    public final void u(@NonNull List<String> list) {
        Drawable drawable;
        String str;
        this.f22673k = list;
        com.onetrust.otpublishers.headless.UI.UIProperty.f fVar = this.f22667e.f22386g;
        if (list.isEmpty()) {
            drawable = this.f22685w.getDrawable();
            str = fVar.f22759b;
        } else {
            drawable = this.f22685w.getDrawable();
            str = fVar.f22760c;
        }
        drawable.setTint(Color.parseColor(str));
        com.onetrust.otpublishers.headless.UI.TVUI.adapter.q qVar = this.f22674l;
        qVar.f22294l = list;
        List<JSONObject> listC = qVar.c();
        com.onetrust.otpublishers.headless.UI.TVUI.adapter.q qVar2 = this.f22674l;
        qVar2.f22295m = 0;
        qVar2.notifyDataSetChanged();
        if (listC != null) {
            ArrayList arrayList = (ArrayList) listC;
            if (arrayList.isEmpty()) {
                return;
            }
            JSONObject jSONObject = (JSONObject) arrayList.get(0);
            com.onetrust.otpublishers.headless.Internal.Event.a aVar = this.A;
            OTPublishersHeadlessSDK oTPublishersHeadlessSDK = this.f22688z;
            r rVar = new r();
            Bundle bundle = new Bundle();
            bundle.putString(OTFragmentTags.FRAGMENT_TAG, OTFragmentTags.OT_SDK_DETAIL_FRAGMENT);
            rVar.setArguments(bundle);
            rVar.f22645p = this;
            rVar.f22641l = jSONObject;
            rVar.f22650u = aVar;
            rVar.f22651v = oTPublishersHeadlessSDK;
            this.f22677o = rVar;
            t(rVar);
        }
    }
}
