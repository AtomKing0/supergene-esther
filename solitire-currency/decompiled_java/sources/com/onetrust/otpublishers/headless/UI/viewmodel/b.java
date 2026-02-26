package com.onetrust.otpublishers.headless.UI.viewmodel;

import android.app.Application;
import android.os.Bundle;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.n;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.ironsource.v8;
import com.onetrust.otpublishers.headless.Internal.Helper.k0;
import com.onetrust.otpublishers.headless.Internal.Helper.o;
import com.onetrust.otpublishers.headless.Internal.Preferences.e;
import com.onetrust.otpublishers.headless.Internal.Preferences.g;
import com.onetrust.otpublishers.headless.Public.OTPublishersHeadlessSDK;
import com.onetrust.otpublishers.headless.UI.DataModels.f;
import com.onetrust.otpublishers.headless.UI.DataModels.h;
import h9.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.collections.p;
import kotlin.collections.v;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;
import p9.r;

/* JADX INFO: loaded from: classes4.dex */
public final class b extends AndroidViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public final g f23674a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public OTPublishersHeadlessSDK f23675b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f23676c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    public String f23677d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    public String f23678e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    public String f23679f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f23680g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Nullable
    public String f23681h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NotNull
    public String f23682i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NotNull
    public final o f23683j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @NotNull
    public final k0 f23684k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @NotNull
    public final ArrayList f23685l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @NotNull
    public final LinkedHashMap f23686m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @NotNull
    public String[] f23687n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @NotNull
    public final MutableLiveData<List<String>> f23688o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @NotNull
    public final MutableLiveData<List<f>> f23689p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @NotNull
    public final MutableLiveData<h> f23690q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @NotNull
    public final MutableLiveData<Boolean> f23691r;

    public static final class a implements ViewModelProvider.Factory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        public final Application f23692a;

        public a(@NotNull Application application) {
            t.i(application, "application");
            this.f23692a = application;
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        @NotNull
        public final <T extends ViewModel> T create(@NotNull Class<T> modelClass) {
            t.i(modelClass, "modelClass");
            return new b(this.f23692a, new g(this.f23692a));
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        public /* synthetic */ ViewModel create(Class cls, CreationExtras creationExtras) {
            return n.b(this, cls, creationExtras);
        }
    }

    /* JADX INFO: renamed from: com.onetrust.otpublishers.headless.UI.viewmodel.b$b, reason: collision with other inner class name */
    public /* synthetic */ class C0488b extends q implements l<String, Integer> {
        public C0488b(Object obj) {
            super(1, obj, b.class, "getConsentStatus", "getConsentStatus(Ljava/lang/String;)I", 0);
        }

        @Override // h9.l
        public final Integer invoke(String str) {
            String sdkId = str;
            t.i(sdkId, "p0");
            b bVar = (b) this.receiver;
            bVar.getClass();
            t.i(sdkId, "sdkId");
            OTPublishersHeadlessSDK oTPublishersHeadlessSDK = bVar.f23675b;
            t.f(oTPublishersHeadlessSDK);
            return Integer.valueOf(oTPublishersHeadlessSDK.getConsentStatusForSDKId(sdkId));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@NotNull Application application, @NotNull g otSharedPreferenceUtils) {
        super(application);
        t.i(application, "application");
        t.i(otSharedPreferenceUtils, "otSharedPreferenceUtils");
        this.f23674a = otSharedPreferenceUtils;
        this.f23676c = true;
        this.f23682i = "";
        this.f23683j = new o(getApplication());
        this.f23684k = new k0(getApplication());
        this.f23685l = new ArrayList();
        this.f23686m = new LinkedHashMap();
        this.f23687n = new String[0];
        this.f23688o = new MutableLiveData<>(v.l());
        this.f23689p = new MutableLiveData<>(v.l());
        this.f23690q = new MutableLiveData<>();
        this.f23691r = new MutableLiveData<>();
    }

    public final void a() {
        JSONObject preferenceCenterData;
        Application application = getApplication();
        new e(application);
        new g(application);
        new com.onetrust.otpublishers.headless.Internal.Models.d(application);
        OTPublishersHeadlessSDK oTPublishersHeadlessSDK = this.f23675b;
        if (oTPublishersHeadlessSDK == null || (preferenceCenterData = oTPublishersHeadlessSDK.getPreferenceCenterData()) == null) {
            return;
        }
        JSONArray jSONArray = new JSONArray();
        t.i(preferenceCenterData, "<this>");
        t.i("Groups", v8.h.W);
        t.i(jSONArray, "default");
        try {
            JSONArray jSONArray2 = preferenceCenterData.getJSONArray("Groups");
            t.h(jSONArray2, "{\n        getJSONArray(key)\n    }");
            jSONArray = jSONArray2;
        } catch (Exception unused) {
        }
        if (jSONArray == null) {
            return;
        }
        JSONArray jSONArrayA = com.onetrust.otpublishers.headless.Internal.Helper.t.a((List) com.onetrust.otpublishers.headless.UI.extensions.h.a(this.f23688o), jSONArray);
        C0488b getSdkConsentStatus = new C0488b(this);
        t.i(getSdkConsentStatus, "getSdkConsentStatus");
        ArrayList arrayList = new ArrayList();
        int length = jSONArrayA.length();
        for (int i10 = 0; i10 < length; i10++) {
            JSONObject jSONObject = jSONArrayA.getJSONObject(i10);
            t.h(jSONObject, "getJSONObject(i)");
            String strA = com.onetrust.otpublishers.headless.UI.extensions.g.a("SdkId", "-1", jSONObject);
            int iIntValue = ((Number) getSdkConsentStatus.invoke(strA)).intValue();
            arrayList.add(new f(strA, com.onetrust.otpublishers.headless.UI.extensions.g.a("Name", "", jSONObject), com.onetrust.otpublishers.headless.UI.extensions.g.b(jSONObject, "Description"), iIntValue != 0 ? iIntValue != 1 ? com.onetrust.otpublishers.headless.UI.DataModels.g.NoToggle : com.onetrust.otpublishers.headless.UI.DataModels.g.Grant : com.onetrust.otpublishers.headless.UI.DataModels.g.Deny));
        }
        MutableLiveData<List<f>> mutableLiveData = this.f23689p;
        if (this.f23682i.length() > 0) {
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : arrayList) {
                if (r.N(((f) obj).f22091b, this.f23682i, true)) {
                    arrayList2.add(obj);
                }
            }
            arrayList = arrayList2;
        }
        mutableLiveData.setValue(arrayList);
        d();
    }

    public final void b(@Nullable Bundle bundle) {
        if (bundle == null) {
            return;
        }
        this.f23678e = bundle.getString("ALWAYS_ACTIVE_TEXT", "Always Active");
        this.f23679f = bundle.getString("ALWAYS_ACTIVE_TEXT_COLOR");
        this.f23677d = bundle.getString("sdkLevelOptOutShow");
        String string = bundle.getString("OT_GROUP_ID_LIST");
        if (string == null || string.length() == 0) {
            return;
        }
        String strG = p9.q.G(p9.q.G(string, v8.i.f15837d, "", false, 4, null), v8.i.f15839e, "", false, 4, null);
        int length = strG.length() - 1;
        int i10 = 0;
        boolean z10 = false;
        while (i10 <= length) {
            boolean z11 = t.k(strG.charAt(!z10 ? i10 : length), 32) <= 0;
            if (z10) {
                if (!z11) {
                    break;
                } else {
                    length--;
                }
            } else if (z11) {
                i10++;
            } else {
                z10 = true;
            }
        }
        this.f23687n = (String[]) r.C0(strG.subSequence(i10, length + 1).toString(), new String[]{","}, false, 0, 6, null).toArray(new String[0]);
        ArrayList arrayList = new ArrayList();
        for (String str : this.f23687n) {
            int length2 = str.length() - 1;
            int i11 = 0;
            boolean z12 = false;
            while (i11 <= length2) {
                boolean z13 = t.k(str.charAt(!z12 ? i11 : length2), 32) <= 0;
                if (z12) {
                    if (!z13) {
                        break;
                    } else {
                        length2--;
                    }
                } else if (z13) {
                    i11++;
                } else {
                    z12 = true;
                }
            }
            arrayList.add(str.subSequence(i11, length2 + 1).toString());
            int length3 = str.length() - 1;
            int i12 = 0;
            boolean z14 = false;
            while (i12 <= length3) {
                boolean z15 = t.k(str.charAt(!z14 ? i12 : length3), 32) <= 0;
                if (z14) {
                    if (!z15) {
                        break;
                    } else {
                        length3--;
                    }
                } else if (z15) {
                    i12++;
                } else {
                    z14 = true;
                }
            }
            this.f23681h = str.subSequence(i12, length3 + 1).toString();
        }
        this.f23688o.setValue(arrayList);
    }

    public final boolean c() {
        List<String> listO0;
        List<String> value = this.f23688o.getValue();
        if (value == null || value.isEmpty()) {
            listO0 = p.o0(this.f23687n);
        } else {
            List<String> value2 = this.f23688o.getValue();
            t.f(value2);
            t.h(value2, "{\n            _selectedC…egories.value!!\n        }");
            listO0 = value2;
        }
        int size = listO0.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (!this.f23674a.k(listO0.get(i10))) {
                return true;
            }
        }
        return false;
    }

    public final void d() {
        MutableLiveData<Boolean> mutableLiveData = this.f23691r;
        Object objA = com.onetrust.otpublishers.headless.UI.extensions.h.a(this.f23689p);
        t.h(objA, "_sdkItems.requireValue()");
        Iterable iterable = (Iterable) objA;
        boolean z10 = false;
        if (!(iterable instanceof Collection) || !((Collection) iterable).isEmpty()) {
            Iterator it = iterable.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                if (((f) it.next()).f22093d == com.onetrust.otpublishers.headless.UI.DataModels.g.Deny) {
                    z10 = true;
                    break;
                }
            }
        }
        mutableLiveData.setValue(Boolean.valueOf(!z10));
    }
}
