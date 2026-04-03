package com.onetrust.otpublishers.headless.UI.viewmodel;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.RequiresApi;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.n;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.onetrust.otpublishers.headless.Internal.Helper.p;
import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import com.onetrust.otpublishers.headless.Internal.Preferences.g;
import com.onetrust.otpublishers.headless.Public.OTPublishersHeadlessSDK;
import com.onetrust.otpublishers.headless.Public.OTVendorListMode;
import com.onetrust.otpublishers.headless.Public.uiutils.OTVendorUtils;
import com.onetrust.otpublishers.headless.UI.DataModels.i;
import com.onetrust.otpublishers.headless.UI.DataModels.l;
import com.onetrust.otpublishers.headless.UI.UIProperty.b0;
import com.onetrust.otpublishers.headless.UI.UIProperty.d0;
import com.onetrust.otpublishers.headless.UI.UIProperty.f;
import com.onetrust.otpublishers.headless.UI.UIProperty.y;
import com.onetrust.otpublishers.headless.UI.extensions.h;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;
import p9.q;

/* JADX INFO: loaded from: classes4.dex */
public final class d extends AndroidViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public final g f23694a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f23695b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    public String f23696c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    public OTPublishersHeadlessSDK f23697d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    public OTVendorUtils f23698e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    public final MutableLiveData<l> f23699f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NotNull
    public final MutableLiveData<String> f23700g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NotNull
    public final MutableLiveData<Boolean> f23701h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NotNull
    public final MutableLiveData<Map<String, String>> f23702i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NotNull
    public final MutableLiveData<Map<String, String>> f23703j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @NotNull
    public final MutableLiveData<List<i>> f23704k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @NotNull
    public final MutableLiveData<List<i>> f23705l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @NotNull
    public final MutableLiveData<List<i>> f23706m;

    public static final class a implements ViewModelProvider.Factory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        public final Application f23707a;

        public a(@NotNull Application application) {
            t.i(application, "application");
            this.f23707a = application;
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        @NotNull
        public final <T extends ViewModel> T create(@NotNull Class<T> modelClass) {
            t.i(modelClass, "modelClass");
            return new d(this.f23707a, new g(this.f23707a));
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        public /* synthetic */ ViewModel create(Class cls, CreationExtras creationExtras) {
            return n.b(this, cls, creationExtras);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(@NotNull Application application, @NotNull g otSharedPreferenceUtils) {
        super(application);
        t.i(application, "application");
        t.i(otSharedPreferenceUtils, "otSharedPreferenceUtils");
        this.f23694a = otSharedPreferenceUtils;
        this.f23696c = "";
        this.f23699f = new MutableLiveData<>();
        this.f23700g = new MutableLiveData<>(OTVendorListMode.IAB);
        this.f23701h = new MutableLiveData<>();
        this.f23702i = new MutableLiveData<>(new LinkedHashMap());
        this.f23703j = new MutableLiveData<>(new LinkedHashMap());
        this.f23704k = new MutableLiveData<>();
        this.f23705l = new MutableLiveData<>();
        this.f23706m = new MutableLiveData<>();
    }

    public static final void b(d this$0, String vendorMode, boolean z10) {
        t.i(this$0, "this$0");
        t.i(vendorMode, "vendorMode");
        if (t.d(h.a(this$0.f23700g), vendorMode)) {
            this$0.f23701h.setValue(Boolean.valueOf(z10));
        }
    }

    @NotNull
    public final String a() {
        String str = ((l) h.a(this.f23699f)).f22122a;
        if (!(true ^ (str == null || str.length() == 0))) {
            str = null;
        }
        return str == null ? this.f23695b == 11 ? "#2F2F2F" : "#FFFFFF" : str;
    }

    @RequiresApi(17)
    public final boolean c(int i10) throws JSONException {
        String str;
        com.onetrust.otpublishers.headless.Internal.Preferences.h hVar;
        boolean z10;
        String string;
        String string2;
        this.f23695b = i10;
        com.onetrust.otpublishers.headless.UI.mobiledatautils.g vlDataConfig = new com.onetrust.otpublishers.headless.UI.mobiledatautils.g();
        com.onetrust.otpublishers.headless.UI.mobiledatautils.d pcDataConfig = new com.onetrust.otpublishers.headless.UI.mobiledatautils.d();
        OTPublishersHeadlessSDK oTPublishersHeadlessSDK = this.f23697d;
        String string3 = "";
        if (oTPublishersHeadlessSDK != null) {
            Application application = getApplication();
            int i11 = this.f23695b;
            try {
                vlDataConfig.f23666q = application;
                JSONObject preferenceCenterData = oTPublishersHeadlessSDK.getPreferenceCenterData();
                vlDataConfig.f23650a = preferenceCenterData;
                if (preferenceCenterData != null) {
                    d0 d0VarG = new b0(vlDataConfig.f23666q).g(i11);
                    vlDataConfig.f23651b = d0VarG;
                    if (d0VarG != null) {
                        vlDataConfig.f23652c = d0VarG.f22755r;
                    }
                    vlDataConfig.e();
                    com.onetrust.otpublishers.headless.UI.UIProperty.c cVar = vlDataConfig.f23652c.f22875a;
                    cVar.f22722c = com.onetrust.otpublishers.headless.UI.mobiledatautils.g.d(cVar.f22722c, "PcTextColor", vlDataConfig.f23650a);
                    String strOptString = cVar.f22724e;
                    JSONObject jSONObject = vlDataConfig.f23650a;
                    if (com.onetrust.otpublishers.headless.Internal.c.q(strOptString) || strOptString == null) {
                        strOptString = !com.onetrust.otpublishers.headless.Internal.c.q("PCenterVendorsListText") ? jSONObject.optString("PCenterVendorsListText") : "";
                    }
                    cVar.f22724e = strOptString;
                    vlDataConfig.f23652c.f22875a = cVar;
                    vlDataConfig.f23653d = com.onetrust.otpublishers.headless.UI.mobiledatautils.g.b(vlDataConfig.f23650a, vlDataConfig.f23651b.f22748k, "PCenterVendorsListText", false);
                    vlDataConfig.f23654e = com.onetrust.otpublishers.headless.UI.mobiledatautils.g.b(vlDataConfig.f23650a, vlDataConfig.f23651b.f22749l, "PCenterAllowAllConsentText", false);
                    d0 d0Var = vlDataConfig.f23651b;
                    vlDataConfig.f23655f = com.onetrust.otpublishers.headless.UI.mobiledatautils.g.a(d0Var.f22751n, d0Var.f22738a);
                    vlDataConfig.f23656g = vlDataConfig.c(vlDataConfig.f23651b.f22752o);
                    if (!com.onetrust.otpublishers.headless.Internal.c.q(vlDataConfig.f23651b.f22738a)) {
                        String str2 = vlDataConfig.f23651b.f22738a;
                        String strOptString2 = vlDataConfig.f23650a.optString("PcBackgroundColor");
                        if (com.onetrust.otpublishers.headless.Internal.c.q(str2)) {
                            str2 = !com.onetrust.otpublishers.headless.Internal.c.q(strOptString2) ? strOptString2 : i11 == 11 ? "#2F2F2F" : "#FFFFFF";
                        }
                        vlDataConfig.f23657h = str2;
                    }
                    vlDataConfig.f23663n = !com.onetrust.otpublishers.headless.Internal.c.q(vlDataConfig.f23651b.f22746i) ? vlDataConfig.f23651b.f22746i : vlDataConfig.f23650a.optString("PcTextColor");
                    String str3 = vlDataConfig.f23651b.f22739b;
                    if (str3 == null || com.onetrust.otpublishers.headless.Internal.c.q(str3)) {
                        str3 = "#E8E8E8";
                    }
                    vlDataConfig.f23664o = str3;
                    vlDataConfig.f23665p = !com.onetrust.otpublishers.headless.Internal.c.q(vlDataConfig.f23651b.f22754q) ? vlDataConfig.f23651b.f22754q : vlDataConfig.f23650a.optString("PcTextColor");
                    if (vlDataConfig.f23650a.has("PCenterBackText")) {
                        vlDataConfig.f23651b.f22756s.f22786a = vlDataConfig.f23650a.optString("PCenterBackText");
                    }
                    d0 d0Var2 = vlDataConfig.f23651b;
                    vlDataConfig.f23660k = d0Var2.f22742e;
                    vlDataConfig.f23658i = d0Var2.f22740c;
                    vlDataConfig.f23659j = d0Var2.f22741d;
                    vlDataConfig.f23661l = !com.onetrust.otpublishers.headless.Internal.c.q(d0Var2.f22743f) ? vlDataConfig.f23651b.f22743f : vlDataConfig.f23650a.getString("PcButtonColor");
                    vlDataConfig.f23662m = vlDataConfig.f23651b.f22744g;
                    vlDataConfig.f23667r = vlDataConfig.f23650a.optString("BConsentText");
                }
            } catch (JSONException e10) {
                p.a(e10, new StringBuilder("Error in ui property object, error message = "), "VLDataConfig", 6);
            }
            if (!pcDataConfig.l(this.f23695b, getApplication(), oTPublishersHeadlessSDK)) {
                return false;
            }
        }
        OTLogger.a("VendorsList", 3, "themeMode = " + this.f23695b);
        OTPublishersHeadlessSDK oTPublishersHeadlessSDK2 = this.f23697d;
        JSONObject preferenceCenterData2 = oTPublishersHeadlessSDK2 != null ? oTPublishersHeadlessSDK2.getPreferenceCenterData() : null;
        g otSharedPreferenceUtils = this.f23694a;
        t.i(vlDataConfig, "vlDataConfig");
        t.i(otSharedPreferenceUtils, "otSharedPreferenceUtils");
        t.i(pcDataConfig, "pcDataConfig");
        MutableLiveData<l> mutableLiveData = this.f23699f;
        String str4 = vlDataConfig.f23657h;
        d0 d0Var3 = vlDataConfig.f23651b;
        t.h(d0Var3, "vlDataConfig.vendorListUIProperty");
        String str5 = vlDataConfig.f23661l;
        String str6 = vlDataConfig.f23662m;
        String str7 = vlDataConfig.f23664o;
        String str8 = vlDataConfig.f23660k;
        String str9 = vlDataConfig.f23658i;
        String str10 = vlDataConfig.f23659j;
        f fVar = vlDataConfig.f23656g;
        t.h(fVar, "vlDataConfig.confirmMyChoiceProperty");
        String strB = preferenceCenterData2 != null ? com.onetrust.otpublishers.headless.UI.extensions.g.b(preferenceCenterData2, "PcButtonTextColor") : null;
        com.onetrust.otpublishers.headless.UI.UIProperty.c cVar2 = vlDataConfig.f23653d;
        t.h(cVar2, "vlDataConfig.vlTitleTextProperty");
        String strB2 = preferenceCenterData2 != null ? com.onetrust.otpublishers.headless.UI.extensions.g.b(preferenceCenterData2, "PcTextColor") : null;
        boolean z11 = otSharedPreferenceUtils.f21894b.f21886a.c().getBoolean("OT_GENERAL_VENDORS_TOGGLE_CONFIGURED", false);
        com.onetrust.otpublishers.headless.UI.UIProperty.a aVar = vlDataConfig.f23655f;
        t.h(aVar, "vlDataConfig.searchBarProperty");
        if (preferenceCenterData2 != null) {
            if (preferenceCenterData2.has("PCIABVendorsText")) {
                string2 = preferenceCenterData2.getString("PCIABVendorsText");
            } else if (preferenceCenterData2.has("PCenterVendorsListText")) {
                string2 = preferenceCenterData2.getString("PCenterVendorsListText");
            } else {
                str = "";
            }
            str = string2;
        } else {
            str = null;
        }
        Context context = vlDataConfig.f23666q;
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0);
        if (com.onetrust.otpublishers.headless.Internal.Helper.h.a(Boolean.FALSE, context.getSharedPreferences("com.onetrust.otpublishers.headless.preference".concat("OTT_DEFAULT_USER"), 0), "OT_ENABLE_MULTI_PROFILE")) {
            hVar = new com.onetrust.otpublishers.headless.Internal.Preferences.h(context, sharedPreferences, sharedPreferences.getString("OT_ACTIVE_PROFILE_ID", ""));
            z10 = true;
        } else {
            hVar = null;
            z10 = false;
        }
        if (z10) {
            sharedPreferences = hVar;
        }
        try {
            string = sharedPreferences.getString("OT_MOBILE_DATA", "");
        } catch (JSONException e11) {
            p.a(e11, new StringBuilder("error while getting mobile data json, err: "), "OneTrust", 6);
        }
        JSONObject jSONObject2 = !com.onetrust.otpublishers.headless.Internal.c.q(string) ? new JSONObject(string) : new JSONObject();
        if (jSONObject2.has("preferenceCenterData")) {
            JSONObject jSONObject3 = jSONObject2.getJSONObject("preferenceCenterData");
            if (jSONObject3.has("googleVendors")) {
                JSONObject jSONObject4 = jSONObject3.getJSONObject("googleVendors");
                if (jSONObject4.has(OTVendorListMode.GENERAL)) {
                    string3 = jSONObject4.getJSONObject(OTVendorListMode.GENERAL).getString("text");
                }
            }
        }
        String str11 = string3;
        String str12 = vlDataConfig.f23667r;
        String str13 = vlDataConfig.f23665p;
        String strB3 = preferenceCenterData2 != null ? com.onetrust.otpublishers.headless.UI.extensions.g.b(preferenceCenterData2, "PcButtonColor") : null;
        y yVar = vlDataConfig.f23652c;
        t.h(yVar, "vlDataConfig.vlPageHeaderTitle");
        com.onetrust.otpublishers.headless.UI.UIProperty.c cVar3 = vlDataConfig.f23654e;
        t.h(cVar3, "vlDataConfig.allowAllToggleTextProperty");
        mutableLiveData.setValue(new l(str4, d0Var3, str5, str6, str7, str8, str9, str10, fVar, strB, cVar2, strB2, z11, aVar, str, str11, str12, str13, strB3, yVar, cVar3, pcDataConfig.f23627u, vlDataConfig.f23663n));
        OTVendorUtils oTVendorUtils = this.f23698e;
        if (oTVendorUtils != null) {
            oTVendorUtils.setSelectAllButtonListener(new OTVendorUtils.ItemListener() { // from class: com.onetrust.otpublishers.headless.UI.viewmodel.c
                @Override // com.onetrust.otpublishers.headless.Public.uiutils.OTVendorUtils.ItemListener
                public final void onItemClick(String str14, boolean z12) {
                    d.b(this.f23693a, str14, z12);
                }
            });
        }
        e();
        return true;
    }

    public final boolean d() {
        return q.x(OTVendorListMode.IAB, (String) h.a(this.f23700g), true);
    }

    /* JADX WARN: Removed duplicated region for block: B:114:0x01b9  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00fe  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void e() {
        /*
            Method dump skipped, instruction units count: 457
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onetrust.otpublishers.headless.UI.viewmodel.d.e():void");
    }
}
