package com.onetrust.otpublishers.headless.UI.fragment;

import android.app.Application;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import androidx.appcompat.R;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import com.onetrust.otpublishers.headless.Public.DataModel.OTConfiguration;
import com.onetrust.otpublishers.headless.Public.Keys.OTFragmentTags;
import com.onetrust.otpublishers.headless.Public.OTPublishersHeadlessSDK;
import com.onetrust.otpublishers.headless.Public.OTThemeConstants;
import com.onetrust.otpublishers.headless.UI.fragment.h1;
import com.onetrust.otpublishers.headless.UI.viewmodel.b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class c1 extends com.google.android.material.bottomsheet.b {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ int f23253k = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public com.onetrust.otpublishers.headless.databinding.b f23254b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    public final v8.l f23255c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    public OTPublishersHeadlessSDK f23256d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    public OTConfiguration f23257e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    public final com.onetrust.otpublishers.headless.UI.Helper.l f23258f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    public com.onetrust.otpublishers.headless.UI.adapter.t f23259g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Nullable
    public com.onetrust.otpublishers.headless.UI.adapter.r f23260h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    public com.google.android.material.bottomsheet.a f23261i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public h1 f23262j;

    public static final class a implements SearchView.OnQueryTextListener {
        public a() {
        }

        @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
        public final boolean onQueryTextChange(@NotNull String query) {
            kotlin.jvm.internal.t.i(query, "newText");
            if (query.length() == 0) {
                c1 c1Var = c1.this;
                int i10 = c1.f23253k;
                com.onetrust.otpublishers.headless.UI.viewmodel.b bVarN = c1Var.N();
                bVarN.getClass();
                kotlin.jvm.internal.t.i("", "query");
                bVarN.f23682i = "";
                bVarN.a();
            } else {
                c1 c1Var2 = c1.this;
                int i11 = c1.f23253k;
                com.onetrust.otpublishers.headless.UI.viewmodel.b bVarN2 = c1Var2.N();
                bVarN2.getClass();
                kotlin.jvm.internal.t.i(query, "query");
                bVarN2.f23682i = query;
                bVarN2.a();
            }
            return false;
        }

        @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
        public final boolean onQueryTextSubmit(@NotNull String query) {
            kotlin.jvm.internal.t.i(query, "query");
            c1 c1Var = c1.this;
            int i10 = c1.f23253k;
            com.onetrust.otpublishers.headless.UI.viewmodel.b bVarN = c1Var.N();
            bVarN.getClass();
            kotlin.jvm.internal.t.i(query, "query");
            bVarN.f23682i = query;
            bVarN.a();
            return false;
        }
    }

    public static final class b extends kotlin.jvm.internal.v implements h9.a<Fragment> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ Fragment f23264g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Fragment fragment) {
            super(0);
            this.f23264g = fragment;
        }

        @Override // h9.a
        public final Fragment invoke() {
            return this.f23264g;
        }
    }

    public static final class c extends kotlin.jvm.internal.v implements h9.a<ViewModelStoreOwner> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ h9.a f23265g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(b bVar) {
            super(0);
            this.f23265g = bVar;
        }

        @Override // h9.a
        public final ViewModelStoreOwner invoke() {
            return (ViewModelStoreOwner) this.f23265g.invoke();
        }
    }

    public static final class d extends kotlin.jvm.internal.v implements h9.a<ViewModelStore> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ v8.l f23266g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(v8.l lVar) {
            super(0);
            this.f23266g = lVar;
        }

        @Override // h9.a
        public final ViewModelStore invoke() {
            return FragmentViewModelLazyKt.m3931viewModels$lambda1(this.f23266g).getViewModelStore();
        }
    }

    public static final class e extends kotlin.jvm.internal.v implements h9.a<CreationExtras> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ v8.l f23267g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(v8.l lVar) {
            super(0);
            this.f23267g = lVar;
        }

        @Override // h9.a
        public final CreationExtras invoke() {
            ViewModelStoreOwner viewModelStoreOwnerM3931viewModels$lambda1 = FragmentViewModelLazyKt.m3931viewModels$lambda1(this.f23267g);
            HasDefaultViewModelProviderFactory hasDefaultViewModelProviderFactory = viewModelStoreOwnerM3931viewModels$lambda1 instanceof HasDefaultViewModelProviderFactory ? (HasDefaultViewModelProviderFactory) viewModelStoreOwnerM3931viewModels$lambda1 : null;
            return hasDefaultViewModelProviderFactory != null ? hasDefaultViewModelProviderFactory.getDefaultViewModelCreationExtras() : CreationExtras.Empty.INSTANCE;
        }
    }

    public static final class f extends kotlin.jvm.internal.v implements h9.a<ViewModelProvider.Factory> {
        public f() {
            super(0);
        }

        @Override // h9.a
        public final ViewModelProvider.Factory invoke() {
            Application application = c1.this.requireActivity().getApplication();
            kotlin.jvm.internal.t.h(application, "requireActivity().application");
            return new b.a(application);
        }
    }

    public c1() {
        f fVar = new f();
        v8.l lVarB = v8.n.b(v8.p.f35203c, new c(new b(this)));
        this.f23255c = FragmentViewModelLazyKt.createViewModelLazy(this, kotlin.jvm.internal.o0.b(com.onetrust.otpublishers.headless.UI.viewmodel.b.class), new d(lVarB), new e(lVarB), fVar);
        this.f23258f = new com.onetrust.otpublishers.headless.UI.Helper.l();
    }

    public static final void A(c1 this$0, List it) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        kotlin.jvm.internal.t.h(it, "it");
        this$0.D(it);
    }

    public static final void B(c1 this$0, List selectedList, boolean z10) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        kotlin.jvm.internal.t.i(selectedList, "selectedCategories");
        com.onetrust.otpublishers.headless.UI.viewmodel.b bVarN = this$0.N();
        bVarN.getClass();
        kotlin.jvm.internal.t.i(selectedList, "selectedList");
        bVarN.f23688o.setValue(selectedList);
        this$0.N().f23680g = z10;
        this$0.N().a();
        this$0.C(Boolean.valueOf(z10));
        boolean zC = this$0.N().c();
        if (!Boolean.parseBoolean(this$0.N().f23677d)) {
            zC = false;
        }
        this$0.E(zC);
    }

    public static final boolean G(c1 this$0) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        com.onetrust.otpublishers.headless.UI.viewmodel.b bVarN = this$0.N();
        bVarN.getClass();
        kotlin.jvm.internal.t.i("", "query");
        bVarN.f23682i = "";
        bVarN.a();
        return false;
    }

    public static final boolean H(c1 this$0, DialogInterface dialogInterface, int i10, KeyEvent event) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        kotlin.jvm.internal.t.i(event, "event");
        if (i10 != 4 || event.getAction() != 1) {
            return false;
        }
        this$0.a();
        return true;
    }

    public static final void K(c1 this$0) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        com.onetrust.otpublishers.headless.databinding.b bVar = this$0.f23254b;
        kotlin.jvm.internal.t.f(bVar);
        bVar.f23734b.f23762j.setQuery(this$0.N().f23682i, true);
    }

    public static final void L(c1 this$0, View view) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        h1 h1Var = this$0.f23262j;
        h1 h1Var2 = null;
        if (h1Var == null) {
            kotlin.jvm.internal.t.A("otSdkListFilterFragment");
            h1Var = null;
        }
        if (h1Var.isAdded()) {
            return;
        }
        h1 h1Var3 = this$0.f23262j;
        if (h1Var3 == null) {
            kotlin.jvm.internal.t.A("otSdkListFilterFragment");
        } else {
            h1Var2 = h1Var3;
        }
        com.onetrust.otpublishers.headless.UI.mobiledatautils.c.j(h1Var2, this$0.requireActivity(), OTFragmentTags.OT_SDK_LIST_FILTER_FRAGMENT_TAG);
    }

    public static final void M(c1 this$0, List list) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        com.onetrust.otpublishers.headless.UI.adapter.r rVar = this$0.f23260h;
        if (rVar != null) {
            rVar.submitList(list);
        }
    }

    public static final void u(final c1 this$0, DialogInterface dialogInterface) {
        com.google.android.material.bottomsheet.a aVar;
        kotlin.jvm.internal.t.i(this$0, "this$0");
        kotlin.jvm.internal.t.i(dialogInterface, "dialogInterface");
        this$0.f23261i = (com.google.android.material.bottomsheet.a) dialogInterface;
        com.onetrust.otpublishers.headless.UI.Helper.l lVar = this$0.f23258f;
        FragmentActivity activity = this$0.getActivity();
        com.google.android.material.bottomsheet.a aVar2 = this$0.f23261i;
        lVar.getClass();
        com.onetrust.otpublishers.headless.UI.Helper.l.r(activity, aVar2);
        com.google.android.material.bottomsheet.a aVar3 = this$0.f23261i;
        if (aVar3 != null) {
            aVar3.setCancelable(false);
        }
        com.google.android.material.bottomsheet.a aVar4 = this$0.f23261i;
        if (aVar4 != null) {
            aVar4.setCanceledOnTouchOutside(false);
        }
        if (this$0.requireArguments().containsKey("SDK_LIST_VIEW_TITLE") && (aVar = this$0.f23261i) != null) {
            aVar.setTitle(this$0.requireArguments().getString("SDK_LIST_VIEW_TITLE"));
        }
        com.google.android.material.bottomsheet.a aVar5 = this$0.f23261i;
        if (aVar5 != null) {
            aVar5.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.onetrust.otpublishers.headless.UI.fragment.s0
                @Override // android.content.DialogInterface.OnKeyListener
                public final boolean onKey(DialogInterface dialogInterface2, int i10, KeyEvent keyEvent) {
                    return c1.H(this.f23527a, dialogInterface2, i10, keyEvent);
                }
            });
        }
    }

    public static final void v(c1 this$0, View view) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        this$0.a();
    }

    public static final void w(c1 this$0, com.onetrust.otpublishers.headless.UI.DataModels.h it) {
        com.onetrust.otpublishers.headless.UI.Helper.l lVar;
        Context contextRequireContext;
        SwitchCompat switchCompat;
        String str;
        String str2;
        kotlin.jvm.internal.t.i(this$0, "this$0");
        kotlin.jvm.internal.t.h(it, "it");
        this$0.getClass();
        this$0.f23260h = new com.onetrust.otpublishers.headless.UI.adapter.r(it, this$0.f23257e, this$0.N().f23677d, this$0.N().f23678e, this$0.N().f23679f, new d1(this$0), new e1(this$0));
        com.onetrust.otpublishers.headless.databinding.b bVar = this$0.f23254b;
        kotlin.jvm.internal.t.f(bVar);
        bVar.f23734b.f23756d.setAdapter(this$0.f23260h);
        com.onetrust.otpublishers.headless.databinding.b bVar2 = this$0.f23254b;
        kotlin.jvm.internal.t.f(bVar2);
        bVar2.f23734b.f23756d.setItemAnimator(null);
        this$0.t(it);
        com.onetrust.otpublishers.headless.databinding.b bVar3 = this$0.f23254b;
        kotlin.jvm.internal.t.f(bVar3);
        CoordinatorLayout parentSdkList = bVar3.f23735c;
        kotlin.jvm.internal.t.h(parentSdkList, "parentSdkList");
        com.onetrust.otpublishers.headless.UI.extensions.n.a(it.f22100c, parentSdkList);
        RelativeLayout relativeLayout = bVar3.f23734b.f23760h;
        kotlin.jvm.internal.t.h(relativeLayout, "mainLayout.sdkParentLayout");
        com.onetrust.otpublishers.headless.UI.extensions.n.a(it.f22100c, relativeLayout);
        TextView textView = bVar3.f23734b.f23757e;
        kotlin.jvm.internal.t.h(textView, "mainLayout.sdkAllowAllTitle");
        com.onetrust.otpublishers.headless.UI.extensions.m.b(textView, it.f22111n, null, null, true, 6);
        TextView textView2 = bVar3.f23734b.f23757e;
        kotlin.jvm.internal.t.h(textView2, "mainLayout.sdkAllowAllTitle");
        com.onetrust.otpublishers.headless.UI.UIProperty.l lVar2 = it.f22108k.f22720a;
        kotlin.jvm.internal.t.h(lVar2, "sdkListData.summaryTitle.fontProperty");
        com.onetrust.otpublishers.headless.UI.extensions.m.d(textView2, lVar2, this$0.f23257e);
        boolean zIsChecked = bVar3.f23734b.f23758f.isChecked();
        com.onetrust.otpublishers.headless.databinding.b bVar4 = this$0.f23254b;
        kotlin.jvm.internal.t.f(bVar4);
        com.onetrust.otpublishers.headless.databinding.f fVar = bVar4.f23734b;
        if (zIsChecked) {
            lVar = this$0.f23258f;
            contextRequireContext = this$0.requireContext();
            switchCompat = fVar.f23758f;
            str = it.f22106i;
            str2 = it.f22104g;
        } else {
            lVar = this$0.f23258f;
            contextRequireContext = this$0.requireContext();
            switchCompat = fVar.f23758f;
            str = it.f22106i;
            str2 = it.f22105h;
        }
        lVar.getClass();
        com.onetrust.otpublishers.headless.UI.Helper.l.k(contextRequireContext, switchCompat, str, str2);
        com.onetrust.otpublishers.headless.UI.viewmodel.b bVarN = this$0.N();
        boolean z10 = false;
        if (Boolean.parseBoolean(bVarN.f23677d)) {
            String string = bVarN.f23681h;
            if (string != null) {
                try {
                    com.onetrust.otpublishers.headless.Internal.Helper.k0 k0Var = bVarN.f23684k;
                    kotlin.jvm.internal.t.f(string);
                    JSONObject jSONObject = new JSONObject(k0Var.f21775e.f21893a.c().getString("DOMAIN_PARENT_ID_MAP", ""));
                    string = jSONObject.has(string) ? jSONObject.getString(string) : null;
                    if (!(!(string == null || string.length() == 0))) {
                        string = null;
                    }
                    if (string == null) {
                        string = bVarN.f23681h;
                    }
                } catch (Exception e10) {
                    com.onetrust.otpublishers.headless.Internal.Helper.j.a(e10, new StringBuilder("Error on getting parent child JSON. Error message = "), "OTSDKListFragment", 6);
                    string = "";
                }
            }
            if (!(string == null ? false : bVarN.f23674a.k(string)) || bVarN.c()) {
                z10 = true;
            }
        }
        this$0.E(z10);
        com.onetrust.otpublishers.headless.databinding.b bVar5 = this$0.f23254b;
        kotlin.jvm.internal.t.f(bVar5);
        com.onetrust.otpublishers.headless.databinding.f fVar2 = bVar5.f23734b;
        fVar2.f23761i.setBackgroundColor(Color.parseColor(it.f22100c));
        fVar2.f23759g.setTextColor(Color.parseColor(it.f22108k.f22722c));
        TextView sdkListPageTitle = fVar2.f23759g;
        kotlin.jvm.internal.t.h(sdkListPageTitle, "sdkListPageTitle");
        com.onetrust.otpublishers.headless.UI.extensions.n.a(it.f22100c, sdkListPageTitle);
        ImageView imageView = fVar2.f23754b;
        String str3 = it.f22112o.f22889n.f22786a;
        imageView.setContentDescription(str3 != null ? str3 : "");
        ImageView backFromSdklist = fVar2.f23754b;
        kotlin.jvm.internal.t.h(backFromSdklist, "backFromSdklist");
        com.onetrust.otpublishers.headless.UI.extensions.f.b(backFromSdklist, it.f22099b);
        this$0.C(null);
        this$0.I();
        this$0.J(it);
    }

    public static final void x(c1 this$0, com.onetrust.otpublishers.headless.UI.DataModels.h sdkListData, CompoundButton compoundButton, boolean z10) {
        com.onetrust.otpublishers.headless.UI.Helper.l lVar;
        Context contextRequireContext;
        SwitchCompat switchCompat;
        String str;
        String str2;
        kotlin.jvm.internal.t.i(this$0, "this$0");
        kotlin.jvm.internal.t.i(sdkListData, "$sdkListData");
        com.onetrust.otpublishers.headless.databinding.b bVar = this$0.f23254b;
        kotlin.jvm.internal.t.f(bVar);
        com.onetrust.otpublishers.headless.databinding.f fVar = bVar.f23734b;
        if (z10) {
            lVar = this$0.f23258f;
            contextRequireContext = this$0.requireContext();
            switchCompat = fVar.f23758f;
            str = sdkListData.f22106i;
            str2 = sdkListData.f22104g;
        } else {
            lVar = this$0.f23258f;
            contextRequireContext = this$0.requireContext();
            switchCompat = fVar.f23758f;
            str = sdkListData.f22106i;
            str2 = sdkListData.f22105h;
        }
        lVar.getClass();
        com.onetrust.otpublishers.headless.UI.Helper.l.k(contextRequireContext, switchCompat, str, str2);
    }

    public static final void y(c1 this$0, com.onetrust.otpublishers.headless.databinding.f this_with, View view) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        kotlin.jvm.internal.t.i(this_with, "$this_with");
        boolean zIsChecked = this_with.f23758f.isChecked();
        com.onetrust.otpublishers.headless.UI.viewmodel.b bVarN = this$0.N();
        bVarN.f23685l.clear();
        bVarN.f23686m.clear();
        Object objA = com.onetrust.otpublishers.headless.UI.extensions.h.a(bVarN.f23689p);
        kotlin.jvm.internal.t.h(objA, "_sdkItems.requireValue()");
        for (com.onetrust.otpublishers.headless.UI.DataModels.f fVar : (Iterable) objA) {
            bVarN.f23685l.add(fVar.f22090a);
            String groupId = bVarN.f23683j.c(fVar.f22090a);
            if (groupId != null) {
                LinkedHashMap linkedHashMap = bVarN.f23686m;
                kotlin.jvm.internal.t.h(groupId, "groupId");
                linkedHashMap.put(groupId, bVarN.f23685l);
            }
        }
        OTPublishersHeadlessSDK oTPublishersHeadlessSDK = bVarN.f23675b;
        if (oTPublishersHeadlessSDK != null) {
            ArrayList arrayList = bVarN.f23685l;
            kotlin.jvm.internal.t.i(arrayList, "<this>");
            JSONArray jSONArray = new JSONArray();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                jSONArray.put((String) it.next());
            }
            oTPublishersHeadlessSDK.updateAllSDKConsentStatus(jSONArray, zIsChecked);
        }
        bVarN.a();
    }

    public static final void z(c1 this$0, Boolean it) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        com.onetrust.otpublishers.headless.databinding.b bVar = this$0.f23254b;
        kotlin.jvm.internal.t.f(bVar);
        SwitchCompat switchCompat = bVar.f23734b.f23758f;
        kotlin.jvm.internal.t.h(it, "it");
        switchCompat.setChecked(it.booleanValue());
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x00e2 A[PHI: r0 r1 r7
      0x00e2: PHI (r0v3 android.widget.ImageView) = (r0v2 android.widget.ImageView), (r0v5 android.widget.ImageView) binds: [B:40:0x00e0, B:21:0x007e] A[DONT_GENERATE, DONT_INLINE]
      0x00e2: PHI (r1v7 java.lang.String) = (r1v6 java.lang.String), (r1v8 java.lang.String) binds: [B:40:0x00e0, B:21:0x007e] A[DONT_GENERATE, DONT_INLINE]
      0x00e2: PHI (r7v20 java.lang.String) = (r7v6 java.lang.String), (r7v25 java.lang.String) binds: [B:40:0x00e0, B:21:0x007e] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void C(java.lang.Boolean r7) {
        /*
            Method dump skipped, instruction units count: 235
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onetrust.otpublishers.headless.UI.fragment.c1.C(java.lang.Boolean):void");
    }

    public final void D(List<String> list) {
        OTConfiguration oTConfiguration = this.f23257e;
        h1 h1Var = new h1();
        Bundle bundle = new Bundle();
        bundle.putString(OTFragmentTags.FRAGMENT_TAG, OTFragmentTags.OT_SDK_LIST_FILTER_FRAGMENT_TAG);
        h1Var.setArguments(bundle);
        h1Var.f23318l = Collections.unmodifiableList(list);
        h1Var.f23319m = Collections.unmodifiableList(list);
        h1Var.f23322p = oTConfiguration;
        kotlin.jvm.internal.t.h(h1Var, "newInstance(\n           …figuration,\n            )");
        this.f23262j = h1Var;
        OTPublishersHeadlessSDK oTPublishersHeadlessSDK = N().f23675b;
        h1 h1Var2 = null;
        if (oTPublishersHeadlessSDK != null) {
            h1 h1Var3 = this.f23262j;
            if (h1Var3 == null) {
                kotlin.jvm.internal.t.A("otSdkListFilterFragment");
                h1Var3 = null;
            }
            h1Var3.f23316j = oTPublishersHeadlessSDK;
        }
        h1 h1Var4 = this.f23262j;
        if (h1Var4 == null) {
            kotlin.jvm.internal.t.A("otSdkListFilterFragment");
        } else {
            h1Var2 = h1Var4;
        }
        h1Var2.f23317k = new h1.a() { // from class: com.onetrust.otpublishers.headless.UI.fragment.q0
            @Override // com.onetrust.otpublishers.headless.UI.fragment.h1.a
            public final void a(List list2, boolean z10) {
                c1.B(this.f23502a, list2, z10);
            }
        };
    }

    public final void E(boolean z10) {
        com.onetrust.otpublishers.headless.databinding.b bVar = this.f23254b;
        kotlin.jvm.internal.t.f(bVar);
        com.onetrust.otpublishers.headless.databinding.f fVar = bVar.f23734b;
        SwitchCompat sdkAllowAllToggle = fVar.f23758f;
        kotlin.jvm.internal.t.h(sdkAllowAllToggle, "sdkAllowAllToggle");
        sdkAllowAllToggle.setVisibility(z10 ? 0 : 8);
        TextView sdkAllowAllTitle = fVar.f23757e;
        kotlin.jvm.internal.t.h(sdkAllowAllTitle, "sdkAllowAllTitle");
        sdkAllowAllTitle.setVisibility(z10 ? 0 : 8);
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00ae  */
    @androidx.annotation.RequiresApi(17)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean F(int r28) {
        /*
            Method dump skipped, instruction units count: 577
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onetrust.otpublishers.headless.UI.fragment.c1.F(int):boolean");
    }

    public final void I() {
        com.onetrust.otpublishers.headless.databinding.b bVar = this.f23254b;
        kotlin.jvm.internal.t.f(bVar);
        SearchView searchView = bVar.f23734b.f23762j;
        searchView.setIconifiedByDefault(false);
        searchView.onActionViewExpanded();
        searchView.clearFocus();
        searchView.setOnQueryTextListener(new a());
        searchView.setOnCloseListener(new SearchView.OnCloseListener() { // from class: com.onetrust.otpublishers.headless.UI.fragment.b1
            @Override // androidx.appcompat.widget.SearchView.OnCloseListener
            public final boolean onClose() {
                return c1.G(this.f23249a);
            }
        });
    }

    public final void J(com.onetrust.otpublishers.headless.UI.DataModels.h hVar) {
        com.onetrust.otpublishers.headless.databinding.b bVar = this.f23254b;
        kotlin.jvm.internal.t.f(bVar);
        SearchView searchView = bVar.f23734b.f23762j;
        String strG = hVar.b().g();
        kotlin.jvm.internal.t.h(strG, "sdkListData.searchBarProperty.placeHolderText");
        if (strG.length() > 0) {
            searchView.setQueryHint(hVar.b().g());
        }
        EditText editText = (EditText) searchView.findViewById(R.id.search_src_text);
        String strJ = hVar.b().j();
        if (!(strJ == null || strJ.length() == 0)) {
            editText.setTextColor(Color.parseColor(hVar.b().j()));
        }
        String strH = hVar.b().h();
        if (!(strH == null || strH.length() == 0)) {
            editText.setHintTextColor(Color.parseColor(hVar.b().h()));
        }
        OTLogger.d("font " + hVar.b().i());
        kotlin.jvm.internal.t.h(editText, "");
        com.onetrust.otpublishers.headless.UI.UIProperty.l lVarA = hVar.b().i().a();
        kotlin.jvm.internal.t.h(lVarA, "sdkListData.searchBarPro…TextProperty.fontProperty");
        com.onetrust.otpublishers.headless.UI.extensions.m.d(editText, lVarA, this.f23257e);
        com.onetrust.otpublishers.headless.UI.extensions.m.a(editText);
        String strF = hVar.b().f();
        if (!(strF == null || strF.length() == 0)) {
            ((ImageView) searchView.findViewById(R.id.search_mag_icon)).setColorFilter(Color.parseColor(hVar.b().f()), PorterDuff.Mode.SRC_IN);
        }
        String strE = hVar.b().e();
        if (!(strE == null || strE.length() == 0)) {
            ((ImageView) searchView.findViewById(R.id.search_close_btn)).setColorFilter(Color.parseColor(hVar.b().e()), PorterDuff.Mode.SRC_IN);
        }
        View viewFindViewById = searchView.findViewById(R.id.search_edit_frame);
        viewFindViewById.setBackgroundResource(p6.c.f32637d);
        com.onetrust.otpublishers.headless.UI.UIProperty.a aVarB = hVar.b();
        String strD = aVarB.d();
        if (!(!(strD == null || strD.length() == 0))) {
            strD = null;
        }
        if (strD == null) {
            strD = "0";
        }
        kotlin.jvm.internal.t.h(strD, "searchBarProperty.border….isNullOrEmpty() } ?: \"0\"");
        String strB = aVarB.b();
        if (!(!(strB == null || strB.length() == 0))) {
            strB = null;
        }
        if (strB == null) {
            strB = hVar.a();
        }
        String strA = aVarB.a();
        if (!(!(strA == null || strA.length() == 0))) {
            strA = null;
        }
        if (strA == null) {
            strA = "#2D6B6767";
        }
        kotlin.jvm.internal.t.h(strA, "searchBarProperty.backGr…nstants.TRANSPARENT_COLOR");
        String strC = aVarB.c();
        String str = (strC == null || strC.length() == 0) ^ true ? strC : null;
        if (str == null) {
            str = "20";
        }
        kotlin.jvm.internal.t.h(str, "searchBarProperty.border…isNullOrEmpty() } ?: \"20\"");
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setStroke(Integer.parseInt(strD), Color.parseColor(strB));
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(Color.parseColor(strA));
        gradientDrawable.setCornerRadius(Float.parseFloat(str));
        viewFindViewById.setBackground(gradientDrawable);
        if (com.onetrust.otpublishers.headless.Internal.Helper.k.e(viewFindViewById.getContext())) {
            viewFindViewById.setLayoutDirection(1);
        }
    }

    public final com.onetrust.otpublishers.headless.UI.viewmodel.b N() {
        return (com.onetrust.otpublishers.headless.UI.viewmodel.b) this.f23255c.getValue();
    }

    public final void O() {
        com.onetrust.otpublishers.headless.databinding.b bVar = this.f23254b;
        kotlin.jvm.internal.t.f(bVar);
        final com.onetrust.otpublishers.headless.databinding.f fVar = bVar.f23734b;
        fVar.f23754b.setOnClickListener(new View.OnClickListener() { // from class: com.onetrust.otpublishers.headless.UI.fragment.p0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                c1.v(this.f23474a, view);
            }
        });
        fVar.f23755c.setOnClickListener(new View.OnClickListener() { // from class: com.onetrust.otpublishers.headless.UI.fragment.t0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                c1.L(this.f23531a, view);
            }
        });
        fVar.f23758f.setOnClickListener(new View.OnClickListener() { // from class: com.onetrust.otpublishers.headless.UI.fragment.u0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                c1.y(this.f23535a, fVar, view);
            }
        });
    }

    public final void P() {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.onetrust.otpublishers.headless.UI.fragment.w0
            @Override // java.lang.Runnable
            public final void run() {
                c1.K(this.f23571a);
            }
        });
    }

    public final void a() {
        dismiss();
        N().f23688o.setValue(kotlin.collections.v.l());
        com.onetrust.otpublishers.headless.UI.viewmodel.b bVarN = N();
        for (String str : bVarN.f23686m.keySet()) {
            JSONArray it = bVarN.f23683j.f(str);
            kotlin.jvm.internal.t.h(it, "it");
            int length = it.length();
            int i10 = 0;
            int i11 = 0;
            for (int i12 = 0; i12 < length; i12++) {
                String string = it.get(i12).toString();
                OTPublishersHeadlessSDK oTPublishersHeadlessSDK = bVarN.f23675b;
                if (oTPublishersHeadlessSDK != null && oTPublishersHeadlessSDK.getConsentStatusForSDKId(string) == 0) {
                    i10++;
                    if (i10 == it.length()) {
                        OTPublishersHeadlessSDK oTPublishersHeadlessSDK2 = bVarN.f23675b;
                        if (oTPublishersHeadlessSDK2 != null) {
                            oTPublishersHeadlessSDK2.updatePurposeConsent(str, false, true);
                        }
                        i10 = 0;
                    }
                } else {
                    OTPublishersHeadlessSDK oTPublishersHeadlessSDK3 = bVarN.f23675b;
                    if ((oTPublishersHeadlessSDK3 != null && 1 == oTPublishersHeadlessSDK3.getConsentStatusForSDKId(string)) && (i11 = i11 + 1) == it.length()) {
                        OTPublishersHeadlessSDK oTPublishersHeadlessSDK4 = bVarN.f23675b;
                        if (oTPublishersHeadlessSDK4 != null) {
                            oTPublishersHeadlessSDK4.updatePurposeConsent(str, true, true);
                        }
                        i11 = 0;
                    }
                }
            }
        }
        com.onetrust.otpublishers.headless.UI.adapter.t tVar = this.f23259g;
        if (tVar != null) {
            tVar.a();
        }
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public final void onConfigurationChanged(@NotNull Configuration newConfig) {
        kotlin.jvm.internal.t.i(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        com.onetrust.otpublishers.headless.UI.Helper.l lVar = this.f23258f;
        FragmentActivity fragmentActivityRequireActivity = requireActivity();
        com.google.android.material.bottomsheet.a aVar = this.f23261i;
        lVar.getClass();
        com.onetrust.otpublishers.headless.UI.Helper.l.r(fragmentActivityRequireActivity, aVar);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setRetainInstance(true);
        N().b(getArguments());
        FragmentActivity activity = getActivity();
        if (com.onetrust.otpublishers.headless.UI.mobiledatautils.c.i(activity, OTFragmentTags.OT_SDK_LIST_FRAGMENT_TAG)) {
            SharedPreferences sharedPreferencesA = com.onetrust.otpublishers.headless.UI.fragment.a.a("com.onetrust.otpublishers.headless.preference", "OT_SDK_APP_CONFIGURATION", activity, 0);
            String str = OTThemeConstants.NO_SDK_THEME_OVERRIDE;
            String string = sharedPreferencesA.getString("OT_UX_SDK_THEME", OTThemeConstants.NO_SDK_THEME_OVERRIDE);
            if (com.onetrust.otpublishers.headless.Internal.c.q(string)) {
                string = OTThemeConstants.NO_SDK_THEME_OVERRIDE;
            }
            if (!string.equals(OTThemeConstants.OT_SDK_UI_THEME)) {
                String string2 = com.onetrust.otpublishers.headless.UI.fragment.a.a("com.onetrust.otpublishers.headless.preference", "OT_SDK_APP_CONFIGURATION", activity, 0).getString("OT_UX_SDK_THEME", OTThemeConstants.NO_SDK_THEME_OVERRIDE);
                if (!com.onetrust.otpublishers.headless.Internal.c.q(string2)) {
                    str = string2;
                }
                if (!str.equals(OTThemeConstants.OT_THEME_APP_COMPACT_LIGHT_NO_ACTION_BAR_LANDSCAPE_FULL_SCREEN)) {
                    return;
                }
            }
            OTLogger.a("OneTrust", 3, "set theme to OT defined theme ");
            setStyle(0, p6.g.f32918a);
        }
    }

    @Override // com.google.android.material.bottomsheet.b, androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    @NotNull
    public final Dialog onCreateDialog(@Nullable Bundle bundle) {
        Dialog dialogOnCreateDialog = super.onCreateDialog(bundle);
        kotlin.jvm.internal.t.h(dialogOnCreateDialog, "super.onCreateDialog(savedInstanceState)");
        dialogOnCreateDialog.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.onetrust.otpublishers.headless.UI.fragment.v0
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                c1.u(this.f23542a, dialogInterface);
            }
        });
        return dialogOnCreateDialog;
    }

    @Override // androidx.fragment.app.Fragment
    @NotNull
    public final View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        kotlin.jvm.internal.t.i(inflater, "inflater");
        com.onetrust.otpublishers.headless.UI.Helper.l lVar = this.f23258f;
        Context contextRequireContext = requireContext();
        int i10 = p6.e.f32871e;
        lVar.getClass();
        View viewC = com.onetrust.otpublishers.headless.UI.Helper.l.c(contextRequireContext, inflater, viewGroup, i10);
        int i11 = p6.d.J2;
        View viewFindChildViewById = ViewBindings.findChildViewById(viewC, i11);
        if (viewFindChildViewById == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(viewC.getResources().getResourceName(i11)));
        }
        int i12 = p6.d.O;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(viewFindChildViewById, i12);
        if (imageView != null) {
            i12 = p6.d.E1;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(viewFindChildViewById, i12);
            if (imageView2 != null) {
                i12 = p6.d.f32796r4;
                RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(viewFindChildViewById, i12);
                if (recyclerView != null) {
                    i12 = p6.d.f32823u4;
                    TextView textView = (TextView) ViewBindings.findChildViewById(viewFindChildViewById, i12);
                    if (textView != null) {
                        i12 = p6.d.f32832v4;
                        SwitchCompat switchCompat = (SwitchCompat) ViewBindings.findChildViewById(viewFindChildViewById, i12);
                        if (switchCompat != null) {
                            i12 = p6.d.B4;
                            if (((LinearLayout) ViewBindings.findChildViewById(viewFindChildViewById, i12)) != null) {
                                i12 = p6.d.G4;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(viewFindChildViewById, i12);
                                if (textView2 != null) {
                                    RelativeLayout relativeLayout = (RelativeLayout) viewFindChildViewById;
                                    i12 = p6.d.O4;
                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(viewFindChildViewById, i12);
                                    if (textView3 != null) {
                                        i12 = p6.d.Q4;
                                        SearchView searchView = (SearchView) ViewBindings.findChildViewById(viewFindChildViewById, i12);
                                        if (searchView != null) {
                                            i12 = p6.d.f32718i7;
                                            if (ViewBindings.findChildViewById(viewFindChildViewById, i12) != null) {
                                                i12 = p6.d.f32727j7;
                                                if (ViewBindings.findChildViewById(viewFindChildViewById, i12) != null) {
                                                    CoordinatorLayout coordinatorLayout = (CoordinatorLayout) viewC;
                                                    com.onetrust.otpublishers.headless.databinding.b bVar = new com.onetrust.otpublishers.headless.databinding.b(coordinatorLayout, new com.onetrust.otpublishers.headless.databinding.f(relativeLayout, imageView, imageView2, recyclerView, textView, switchCompat, textView2, relativeLayout, textView3, searchView), coordinatorLayout);
                                                    this.f23254b = bVar;
                                                    kotlin.jvm.internal.t.f(bVar);
                                                    kotlin.jvm.internal.t.h(coordinatorLayout, "binding.root");
                                                    return coordinatorLayout;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewFindChildViewById.getResources().getResourceName(i12)));
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        this.f23254b = null;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onSaveInstanceState(@NotNull Bundle outState) {
        kotlin.jvm.internal.t.i(outState, "outState");
        outState.putInt("NAV_FROM_PCDETAILS", !N().f23680g ? 1 : 0);
        super.onSaveInstanceState(outState);
    }

    @Override // androidx.fragment.app.Fragment
    @RequiresApi(17)
    public final void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        kotlin.jvm.internal.t.i(view, "view");
        super.onViewCreated(view, bundle);
        if (bundle != null && bundle.containsKey("NAV_FROM_PCDETAILS")) {
            int i10 = bundle.getInt("NAV_FROM_PCDETAILS");
            N().f23676c = i10 == 1;
            bundle.remove("NAV_FROM_PCDETAILS");
        }
        int iA = com.onetrust.otpublishers.headless.UI.Helper.l.a(requireContext(), this.f23257e);
        com.onetrust.otpublishers.headless.UI.mobiledatautils.c.f("OTSDKListFragment", getContext(), view);
        if (!F(iA)) {
            dismiss();
            return;
        }
        O();
        com.onetrust.otpublishers.headless.databinding.b bVar = this.f23254b;
        kotlin.jvm.internal.t.f(bVar);
        bVar.f23734b.f23756d.setLayoutManager(new LinearLayoutManager(requireContext()));
        P();
    }

    public final void t(final com.onetrust.otpublishers.headless.UI.DataModels.h hVar) {
        com.onetrust.otpublishers.headless.databinding.b bVar = this.f23254b;
        kotlin.jvm.internal.t.f(bVar);
        SwitchCompat switchCompat = bVar.f23734b.f23758f;
        switchCompat.setContentDescription(hVar.f22107j);
        switchCompat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.onetrust.otpublishers.headless.UI.fragment.r0
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
                c1.x(this.f23523a, hVar, compoundButton, z10);
            }
        });
    }
}
