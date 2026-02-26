package com.onetrust.otpublishers.headless.UI.fragment;

import android.app.Application;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import androidx.appcompat.R;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.os.BundleKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.ironsource.v8;
import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import com.onetrust.otpublishers.headless.Public.DataModel.OTConfiguration;
import com.onetrust.otpublishers.headless.Public.Keys.OTFragmentTags;
import com.onetrust.otpublishers.headless.Public.OTConsentInteractionType;
import com.onetrust.otpublishers.headless.Public.OTPublishersHeadlessSDK;
import com.onetrust.otpublishers.headless.Public.OTThemeConstants;
import com.onetrust.otpublishers.headless.Public.OTVendorListMode;
import com.onetrust.otpublishers.headless.Public.uiutils.OTVendorUtils;
import com.onetrust.otpublishers.headless.UI.fragment.a3;
import com.onetrust.otpublishers.headless.UI.fragment.o0;
import com.onetrust.otpublishers.headless.UI.fragment.w;
import com.onetrust.otpublishers.headless.UI.viewmodel.d;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class m2 extends com.google.android.material.bottomsheet.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public final com.onetrust.otpublishers.headless.UI.Helper.b f23428b = com.onetrust.otpublishers.headless.UI.Helper.m.a(this, b.f23441b);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    public final v8.l f23429c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    public com.onetrust.otpublishers.headless.Internal.Event.a f23430d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    public OTConfiguration f23431e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    public final com.onetrust.otpublishers.headless.UI.Helper.l f23432f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    public com.onetrust.otpublishers.headless.UI.a f23433g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Nullable
    public OTPublishersHeadlessSDK f23434h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public o0 f23435i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public a3 f23436j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public w f23437k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public com.onetrust.otpublishers.headless.UI.adapter.i0 f23438l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public com.onetrust.otpublishers.headless.UI.adapter.s0 f23439m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public com.onetrust.otpublishers.headless.UI.adapter.p0 f23440n;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final /* synthetic */ KProperty<Object>[] f23427p = {kotlin.jvm.internal.o0.g(new kotlin.jvm.internal.g0(m2.class, "binding", "getBinding()Lcom/onetrust/otpublishers/headless/databinding/FragmentOtVendorsListBinding;", 0))};

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @NotNull
    public static final a f23426o = new a();

    public static final class a {
        @NotNull
        public static m2 a(@Nullable com.onetrust.otpublishers.headless.Internal.Event.a aVar, @Nullable OTConfiguration oTConfiguration) {
            kotlin.jvm.internal.t.i(OTFragmentTags.OT_VENDOR_LIST_FRAGMENT_TAG, "fragmentTag");
            Bundle bundleBundleOf = BundleKt.bundleOf(v8.y.a(OTFragmentTags.FRAGMENT_TAG, OTFragmentTags.OT_VENDOR_LIST_FRAGMENT_TAG));
            m2 m2Var = new m2();
            m2Var.setArguments(bundleBundleOf);
            m2Var.f23430d = aVar;
            m2Var.f23431e = oTConfiguration;
            return m2Var;
        }
    }

    public /* synthetic */ class b extends kotlin.jvm.internal.q implements h9.l<View, com.onetrust.otpublishers.headless.databinding.c> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final b f23441b = new b();

        public b() {
            super(1, com.onetrust.otpublishers.headless.databinding.c.class, "bind", "bind(Landroid/view/View;)Lcom/onetrust/otpublishers/headless/databinding/FragmentOtVendorsListBinding;", 0);
        }

        @Override // h9.l
        public final com.onetrust.otpublishers.headless.databinding.c invoke(View view) {
            View viewFindChildViewById;
            View p02 = view;
            kotlin.jvm.internal.t.i(p02, "p0");
            int i10 = p6.d.J2;
            View viewFindChildViewById2 = ViewBindings.findChildViewById(p02, i10);
            if (viewFindChildViewById2 == null) {
                throw new NullPointerException("Missing required view with ID: ".concat(p02.getResources().getResourceName(i10)));
            }
            int i11 = p6.d.f32843x;
            TextView textView = (TextView) ViewBindings.findChildViewById(viewFindChildViewById2, i11);
            if (textView != null) {
                i11 = p6.d.D;
                SwitchCompat switchCompat = (SwitchCompat) ViewBindings.findChildViewById(viewFindChildViewById2, i11);
                if (switchCompat != null) {
                    i11 = p6.d.E;
                    if (((SwitchCompat) ViewBindings.findChildViewById(viewFindChildViewById2, i11)) != null) {
                        i11 = p6.d.F;
                        if (((LinearLayout) ViewBindings.findChildViewById(viewFindChildViewById2, i11)) != null) {
                            i11 = p6.d.G;
                            if (((SwitchCompat) ViewBindings.findChildViewById(viewFindChildViewById2, i11)) != null) {
                                i11 = p6.d.P;
                                ImageView imageView = (ImageView) ViewBindings.findChildViewById(viewFindChildViewById2, i11);
                                if (imageView != null) {
                                    i11 = p6.d.f32836w0;
                                    AppCompatButton appCompatButton = (AppCompatButton) ViewBindings.findChildViewById(viewFindChildViewById2, i11);
                                    if (appCompatButton != null) {
                                        i11 = p6.d.f32844x0;
                                        AppCompatButton appCompatButton2 = (AppCompatButton) ViewBindings.findChildViewById(viewFindChildViewById2, i11);
                                        if (appCompatButton2 != null) {
                                            i11 = p6.d.f32852y0;
                                            AppCompatButton appCompatButton3 = (AppCompatButton) ViewBindings.findChildViewById(viewFindChildViewById2, i11);
                                            if (appCompatButton3 != null) {
                                                i11 = p6.d.W0;
                                                if (((TextView) ViewBindings.findChildViewById(viewFindChildViewById2, i11)) != null) {
                                                    i11 = p6.d.F1;
                                                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(viewFindChildViewById2, i11);
                                                    if (imageView2 != null) {
                                                        i11 = p6.d.H1;
                                                        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(viewFindChildViewById2, i11);
                                                        if (relativeLayout != null) {
                                                            i11 = p6.d.f32821u2;
                                                            if (((TextView) ViewBindings.findChildViewById(viewFindChildViewById2, i11)) != null) {
                                                                i11 = p6.d.f32805s4;
                                                                RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(viewFindChildViewById2, i11);
                                                                if (recyclerView != null) {
                                                                    i11 = p6.d.P4;
                                                                    if (((LinearLayout) ViewBindings.findChildViewById(viewFindChildViewById2, i11)) != null) {
                                                                        i11 = p6.d.R4;
                                                                        SearchView searchView = (SearchView) ViewBindings.findChildViewById(viewFindChildViewById2, i11);
                                                                        if (searchView != null) {
                                                                            i11 = p6.d.f32689f5;
                                                                            CardView cardView = (CardView) ViewBindings.findChildViewById(viewFindChildViewById2, i11);
                                                                            if (cardView != null) {
                                                                                i11 = p6.d.S6;
                                                                                TextView textView2 = (TextView) ViewBindings.findChildViewById(viewFindChildViewById2, i11);
                                                                                if (textView2 != null) {
                                                                                    i11 = p6.d.Z6;
                                                                                    Button button = (Button) ViewBindings.findChildViewById(viewFindChildViewById2, i11);
                                                                                    if (button != null) {
                                                                                        RelativeLayout relativeLayout2 = (RelativeLayout) viewFindChildViewById2;
                                                                                        i11 = p6.d.f32718i7;
                                                                                        if (ViewBindings.findChildViewById(viewFindChildViewById2, i11) != null && (viewFindChildViewById = ViewBindings.findChildViewById(viewFindChildViewById2, (i11 = p6.d.f32727j7))) != null) {
                                                                                            return new com.onetrust.otpublishers.headless.databinding.c((CoordinatorLayout) p02, new com.onetrust.otpublishers.headless.databinding.h(relativeLayout2, textView, switchCompat, imageView, appCompatButton, appCompatButton2, appCompatButton3, imageView2, relativeLayout, recyclerView, searchView, cardView, textView2, button, relativeLayout2, viewFindChildViewById));
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
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(viewFindChildViewById2.getResources().getResourceName(i11)));
        }
    }

    public static final class c implements SearchView.OnQueryTextListener {
        public c() {
        }

        @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
        public final boolean onQueryTextChange(@NotNull String newSearchQuery) {
            kotlin.jvm.internal.t.i(newSearchQuery, "newText");
            if (newSearchQuery.length() == 0) {
                m2 m2Var = m2.this;
                a aVar = m2.f23426o;
                com.onetrust.otpublishers.headless.UI.viewmodel.d dVarO = m2Var.O();
                dVarO.getClass();
                kotlin.jvm.internal.t.i("", "newSearchQuery");
                dVarO.f23696c = "";
                dVarO.e();
            } else {
                m2 m2Var2 = m2.this;
                a aVar2 = m2.f23426o;
                com.onetrust.otpublishers.headless.UI.viewmodel.d dVarO2 = m2Var2.O();
                dVarO2.getClass();
                kotlin.jvm.internal.t.i(newSearchQuery, "newSearchQuery");
                dVarO2.f23696c = newSearchQuery;
                dVarO2.e();
            }
            return false;
        }

        @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
        public final boolean onQueryTextSubmit(@NotNull String newSearchQuery) {
            kotlin.jvm.internal.t.i(newSearchQuery, "query");
            m2 m2Var = m2.this;
            a aVar = m2.f23426o;
            com.onetrust.otpublishers.headless.UI.viewmodel.d dVarO = m2Var.O();
            dVarO.getClass();
            kotlin.jvm.internal.t.i(newSearchQuery, "newSearchQuery");
            dVarO.f23696c = newSearchQuery;
            dVarO.e();
            return false;
        }
    }

    public static final class d extends kotlin.jvm.internal.v implements h9.a<Fragment> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ Fragment f23443g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(Fragment fragment) {
            super(0);
            this.f23443g = fragment;
        }

        @Override // h9.a
        public final Fragment invoke() {
            return this.f23443g;
        }
    }

    public static final class e extends kotlin.jvm.internal.v implements h9.a<ViewModelStoreOwner> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ h9.a f23444g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(d dVar) {
            super(0);
            this.f23444g = dVar;
        }

        @Override // h9.a
        public final ViewModelStoreOwner invoke() {
            return (ViewModelStoreOwner) this.f23444g.invoke();
        }
    }

    public static final class f extends kotlin.jvm.internal.v implements h9.a<ViewModelStore> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ v8.l f23445g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(v8.l lVar) {
            super(0);
            this.f23445g = lVar;
        }

        @Override // h9.a
        public final ViewModelStore invoke() {
            return FragmentViewModelLazyKt.m3931viewModels$lambda1(this.f23445g).getViewModelStore();
        }
    }

    public static final class g extends kotlin.jvm.internal.v implements h9.a<CreationExtras> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ v8.l f23446g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(v8.l lVar) {
            super(0);
            this.f23446g = lVar;
        }

        @Override // h9.a
        public final CreationExtras invoke() {
            ViewModelStoreOwner viewModelStoreOwnerM3931viewModels$lambda1 = FragmentViewModelLazyKt.m3931viewModels$lambda1(this.f23446g);
            HasDefaultViewModelProviderFactory hasDefaultViewModelProviderFactory = viewModelStoreOwnerM3931viewModels$lambda1 instanceof HasDefaultViewModelProviderFactory ? (HasDefaultViewModelProviderFactory) viewModelStoreOwnerM3931viewModels$lambda1 : null;
            return hasDefaultViewModelProviderFactory != null ? hasDefaultViewModelProviderFactory.getDefaultViewModelCreationExtras() : CreationExtras.Empty.INSTANCE;
        }
    }

    public static final class h extends kotlin.jvm.internal.v implements h9.a<ViewModelProvider.Factory> {
        public h() {
            super(0);
        }

        @Override // h9.a
        public final ViewModelProvider.Factory invoke() {
            Application application = m2.this.requireActivity().getApplication();
            kotlin.jvm.internal.t.h(application, "requireActivity().application");
            return new d.a(application);
        }
    }

    public m2() {
        h hVar = new h();
        v8.l lVarB = v8.n.b(v8.p.f35203c, new e(new d(this)));
        this.f23429c = FragmentViewModelLazyKt.createViewModelLazy(this, kotlin.jvm.internal.o0.b(com.onetrust.otpublishers.headless.UI.viewmodel.d.class), new f(lVarB), new g(lVarB), hVar);
        this.f23432f = new com.onetrust.otpublishers.headless.UI.Helper.l();
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00b7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void A(com.onetrust.otpublishers.headless.UI.fragment.m2 r23, com.onetrust.otpublishers.headless.UI.DataModels.l r24) {
        /*
            Method dump skipped, instruction units count: 1164
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onetrust.otpublishers.headless.UI.fragment.m2.A(com.onetrust.otpublishers.headless.UI.fragment.m2, com.onetrust.otpublishers.headless.UI.DataModels.l):void");
    }

    public static final void B(m2 this$0, com.onetrust.otpublishers.headless.UI.DataModels.l vendorListData, View view) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        kotlin.jvm.internal.t.i(vendorListData, "$vendorListData");
        this$0.e0(vendorListData);
    }

    public static final void C(m2 this$0, com.onetrust.otpublishers.headless.UI.DataModels.l vendorListData, CompoundButton compoundButton, boolean z10) {
        com.onetrust.otpublishers.headless.UI.Helper.l lVar;
        Context contextRequireContext;
        SwitchCompat switchCompat;
        String str;
        String str2;
        kotlin.jvm.internal.t.i(this$0, "this$0");
        kotlin.jvm.internal.t.i(vendorListData, "$vendorListData");
        OTLogger.a("OneTrust", 3, "onCreateViewSetOnCheckedChangeListener " + z10);
        com.onetrust.otpublishers.headless.databinding.h hVar = this$0.t().f23737b;
        if (z10) {
            lVar = this$0.f23432f;
            contextRequireContext = this$0.requireContext();
            switchCompat = hVar.f23773c;
            str = vendorListData.f22127f;
            str2 = vendorListData.f22128g;
        } else {
            lVar = this$0.f23432f;
            contextRequireContext = this$0.requireContext();
            switchCompat = hVar.f23773c;
            str = vendorListData.f22127f;
            str2 = vendorListData.f22129h;
        }
        lVar.getClass();
        com.onetrust.otpublishers.headless.UI.Helper.l.k(contextRequireContext, switchCompat, str, str2);
    }

    public static final void D(m2 this$0, com.onetrust.otpublishers.headless.databinding.h this_with, View view) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        kotlin.jvm.internal.t.i(this_with, "$this_with");
        boolean zIsChecked = this_with.f23773c.isChecked();
        com.onetrust.otpublishers.headless.UI.viewmodel.d dVarO = this$0.O();
        OTPublishersHeadlessSDK oTPublishersHeadlessSDK = dVarO.f23697d;
        if (oTPublishersHeadlessSDK != null) {
            oTPublishersHeadlessSDK.updateAllVendorsConsentLocal((String) com.onetrust.otpublishers.headless.UI.extensions.h.a(dVarO.f23700g), zIsChecked);
        }
        dVarO.e();
    }

    public static final void E(m2 this$0, Boolean it) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        SwitchCompat switchCompat = this$0.t().f23737b.f23773c;
        kotlin.jvm.internal.t.h(it, "it");
        switchCompat.setChecked(it.booleanValue());
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0053  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void F(com.onetrust.otpublishers.headless.UI.fragment.m2 r10, java.lang.String r11, boolean r12, java.lang.String r13) {
        /*
            Method dump skipped, instruction units count: 291
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onetrust.otpublishers.headless.UI.fragment.m2.F(com.onetrust.otpublishers.headless.UI.fragment.m2, java.lang.String, boolean, java.lang.String):void");
    }

    public static final void G(m2 this$0, List list) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        com.onetrust.otpublishers.headless.UI.adapter.i0 i0Var = this$0.f23438l;
        if (i0Var == null) {
            kotlin.jvm.internal.t.A("iabVendorAdapter");
            i0Var = null;
        }
        i0Var.submitList(list);
    }

    public static final void H(m2 this$0, Map selectedMap) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        kotlin.jvm.internal.t.i(selectedMap, "selectedMap");
        com.onetrust.otpublishers.headless.UI.viewmodel.d dVarO = this$0.O();
        dVarO.getClass();
        kotlin.jvm.internal.t.i(selectedMap, "selectedMap");
        (dVarO.d() ? dVarO.f23702i : dVarO.f23703j).setValue(selectedMap);
        dVarO.e();
        this$0.L(!selectedMap.isEmpty(), (com.onetrust.otpublishers.headless.UI.DataModels.l) com.onetrust.otpublishers.headless.UI.extensions.h.a(this$0.O().f23699f));
    }

    public static final void I(com.onetrust.otpublishers.headless.UI.viewmodel.d this_with, m2 this$0, Map it) {
        kotlin.jvm.internal.t.i(this_with, "$this_with");
        kotlin.jvm.internal.t.i(this$0, "this$0");
        if (this_with.d()) {
            kotlin.jvm.internal.t.h(it, "it");
            this$0.K(it);
        }
    }

    public static final boolean N(m2 this$0, DialogInterface dialogInterface, int i10, KeyEvent event) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        kotlin.jvm.internal.t.i(event, "event");
        if (i10 != 4 || event.getAction() != 1) {
            return false;
        }
        com.onetrust.otpublishers.headless.UI.Helper.l lVar = this$0.f23432f;
        com.onetrust.otpublishers.headless.Internal.Event.b bVar = new com.onetrust.otpublishers.headless.Internal.Event.b(13);
        com.onetrust.otpublishers.headless.Internal.Event.a aVar = this$0.f23430d;
        lVar.getClass();
        com.onetrust.otpublishers.headless.UI.Helper.l.s(bVar, aVar);
        this$0.dismiss();
        com.onetrust.otpublishers.headless.UI.a aVar2 = this$0.f23433g;
        if (aVar2 != null) {
            aVar2.a(3);
        }
        ((Map) com.onetrust.otpublishers.headless.UI.extensions.h.a(this$0.O().f23702i)).clear();
        return true;
    }

    public static final void Q(m2 this$0) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        this$0.O().e();
    }

    public static final void R(m2 this$0, View view) throws Throwable {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        com.onetrust.otpublishers.headless.UI.viewmodel.d dVarO = this$0.O();
        dVarO.getClass();
        kotlin.jvm.internal.t.i(OTConsentInteractionType.VENDOR_LIST_CONFIRM, "consent");
        OTPublishersHeadlessSDK oTPublishersHeadlessSDK = dVarO.f23697d;
        if (oTPublishersHeadlessSDK != null) {
            oTPublishersHeadlessSDK.saveConsent(OTConsentInteractionType.VENDOR_LIST_CONFIRM);
        }
        com.onetrust.otpublishers.headless.UI.Helper.l lVar = this$0.f23432f;
        com.onetrust.otpublishers.headless.Internal.Event.b bVar = new com.onetrust.otpublishers.headless.Internal.Event.b(14);
        com.onetrust.otpublishers.headless.Internal.Event.a aVar = this$0.f23430d;
        lVar.getClass();
        com.onetrust.otpublishers.headless.UI.Helper.l.s(bVar, aVar);
        com.onetrust.otpublishers.headless.Internal.Event.b bVar2 = new com.onetrust.otpublishers.headless.Internal.Event.b(17);
        bVar2.f21748d = OTConsentInteractionType.VENDOR_LIST_CONFIRM;
        com.onetrust.otpublishers.headless.UI.Helper.l lVar2 = this$0.f23432f;
        com.onetrust.otpublishers.headless.Internal.Event.a aVar2 = this$0.f23430d;
        lVar2.getClass();
        com.onetrust.otpublishers.headless.UI.Helper.l.s(bVar2, aVar2);
        this$0.dismiss();
        com.onetrust.otpublishers.headless.UI.a aVar3 = this$0.f23433g;
        if (aVar3 != null) {
            aVar3.a(1);
        }
        ((Map) com.onetrust.otpublishers.headless.UI.extensions.h.a(this$0.O().f23702i)).clear();
    }

    public static final void S(m2 this$0, com.onetrust.otpublishers.headless.UI.DataModels.l vendorListData, View view) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        kotlin.jvm.internal.t.i(vendorListData, "$vendorListData");
        this$0.d0(vendorListData);
    }

    public static final void T(m2 this$0, List list) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        com.onetrust.otpublishers.headless.UI.adapter.s0 s0Var = this$0.f23439m;
        if (s0Var == null) {
            kotlin.jvm.internal.t.A("googleVendorAdapter");
            s0Var = null;
        }
        s0Var.submitList(list);
    }

    public static final void U(com.onetrust.otpublishers.headless.UI.viewmodel.d this_with, m2 this$0, Map it) {
        kotlin.jvm.internal.t.i(this_with, "$this_with");
        kotlin.jvm.internal.t.i(this$0, "this$0");
        if (this_with.d()) {
            return;
        }
        kotlin.jvm.internal.t.h(it, "it");
        this$0.K(it);
    }

    public static final void X(m2 this$0, View view) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        o0 o0Var = this$0.f23435i;
        o0 o0Var2 = null;
        if (o0Var == null) {
            kotlin.jvm.internal.t.A("purposeListFragment");
            o0Var = null;
        }
        if (o0Var.isAdded()) {
            return;
        }
        o0Var.f23470r = (String) com.onetrust.otpublishers.headless.UI.extensions.h.a(this$0.O().f23700g);
        o0 o0Var3 = this$0.f23435i;
        if (o0Var3 == null) {
            kotlin.jvm.internal.t.A("purposeListFragment");
        } else {
            o0Var2 = o0Var3;
        }
        com.onetrust.otpublishers.headless.UI.mobiledatautils.c.j(o0Var2, this$0.requireActivity(), OTFragmentTags.OT_VENDOR_LIST_FILTER_FRAGMENT_TAG);
    }

    public static final void Y(m2 this$0, com.onetrust.otpublishers.headless.UI.DataModels.l vendorListData, View view) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        kotlin.jvm.internal.t.i(vendorListData, "$vendorListData");
        this$0.b0(vendorListData);
    }

    public static final void Z(m2 this$0, List list) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        com.onetrust.otpublishers.headless.UI.adapter.p0 p0Var = this$0.f23440n;
        if (p0Var == null) {
            kotlin.jvm.internal.t.A("generalVendorAdapter");
            p0Var = null;
        }
        p0Var.submitList(list);
    }

    public static final boolean a0(m2 this$0) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        com.onetrust.otpublishers.headless.UI.viewmodel.d dVarO = this$0.O();
        dVarO.getClass();
        kotlin.jvm.internal.t.i("", "newSearchQuery");
        dVarO.f23696c = "";
        dVarO.e();
        return false;
    }

    public static final void c0(m2 this$0) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        this$0.t().f23737b.f23781k.setQuery(this$0.O().f23696c, true);
    }

    public static final void x(m2 this$0) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        this$0.O().e();
    }

    public static final void y(final m2 this$0, DialogInterface dialogInterface) {
        com.onetrust.otpublishers.headless.UI.UIProperty.y yVar;
        com.onetrust.otpublishers.headless.UI.UIProperty.c cVar;
        kotlin.jvm.internal.t.i(this$0, "this$0");
        kotlin.jvm.internal.t.i(dialogInterface, "dialogInterface");
        com.google.android.material.bottomsheet.a aVar = (com.google.android.material.bottomsheet.a) dialogInterface;
        com.onetrust.otpublishers.headless.UI.Helper.l lVar = this$0.f23432f;
        FragmentActivity fragmentActivityRequireActivity = this$0.requireActivity();
        lVar.getClass();
        com.onetrust.otpublishers.headless.UI.Helper.l.r(fragmentActivityRequireActivity, aVar);
        aVar.setCancelable(false);
        aVar.setCanceledOnTouchOutside(false);
        com.onetrust.otpublishers.headless.UI.DataModels.l value = this$0.O().f23699f.getValue();
        if (value != null && (yVar = value.f22141t) != null && (cVar = yVar.f22875a) != null) {
            aVar.setTitle(cVar.f22724e);
        }
        aVar.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.onetrust.otpublishers.headless.UI.fragment.u1
            @Override // android.content.DialogInterface.OnKeyListener
            public final boolean onKey(DialogInterface dialogInterface2, int i10, KeyEvent keyEvent) {
                return m2.N(this.f23537a, dialogInterface2, i10, keyEvent);
            }
        });
    }

    public static final void z(m2 this$0, View view) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        com.onetrust.otpublishers.headless.UI.Helper.l lVar = this$0.f23432f;
        com.onetrust.otpublishers.headless.Internal.Event.b bVar = new com.onetrust.otpublishers.headless.Internal.Event.b(13);
        com.onetrust.otpublishers.headless.Internal.Event.a aVar = this$0.f23430d;
        lVar.getClass();
        com.onetrust.otpublishers.headless.UI.Helper.l.s(bVar, aVar);
        this$0.dismiss();
        com.onetrust.otpublishers.headless.UI.a aVar2 = this$0.f23433g;
        if (aVar2 != null) {
            aVar2.a(3);
        }
        ((Map) com.onetrust.otpublishers.headless.UI.extensions.h.a(this$0.O().f23702i)).clear();
    }

    public final void J(String str, String str2) {
        OTPublishersHeadlessSDK oTPublishersHeadlessSDK;
        if (kotlin.jvm.internal.t.d(str2, OTVendorListMode.IAB)) {
            OTPublishersHeadlessSDK oTPublishersHeadlessSDK2 = O().f23697d;
            if ((oTPublishersHeadlessSDK2 != null ? oTPublishersHeadlessSDK2.getVendorDetails(str2, str) : null) == null && (oTPublishersHeadlessSDK = O().f23697d) != null) {
                oTPublishersHeadlessSDK.reInitVendorArray();
            }
        }
        if (kotlin.jvm.internal.t.d(str2, OTVendorListMode.IAB)) {
            a3 a3Var = this.f23436j;
            if (a3Var == null) {
                kotlin.jvm.internal.t.A("vendorsDetailsFragment");
                a3Var = null;
            }
            if (a3Var.isAdded() || getActivity() == null) {
                return;
            }
            a3 a3Var2 = this.f23436j;
            if (a3Var2 == null) {
                kotlin.jvm.internal.t.A("vendorsDetailsFragment");
                a3Var2 = null;
            }
            OTPublishersHeadlessSDK oTPublishersHeadlessSDK3 = O().f23697d;
            if (oTPublishersHeadlessSDK3 != null) {
                a3Var2.B = oTPublishersHeadlessSDK3;
            }
            a3Var2.f23221d0 = this.f23430d;
            a3Var2.setArguments(BundleKt.bundleOf(v8.y.a("vendorId", str)));
            a3Var2.R = new a3.b() { // from class: com.onetrust.otpublishers.headless.UI.fragment.s1
                @Override // com.onetrust.otpublishers.headless.UI.fragment.a3.b
                public final void a() {
                    m2.x(this.f23528a);
                }
            };
            a3 a3Var3 = this.f23436j;
            if (a3Var3 == null) {
                kotlin.jvm.internal.t.A("vendorsDetailsFragment");
                a3Var3 = null;
            }
            com.onetrust.otpublishers.headless.UI.mobiledatautils.c.j(a3Var3, requireActivity(), OTFragmentTags.OT_VENDOR_DETAILS_FRAGMENT_TAG);
        }
        if (kotlin.jvm.internal.t.d(str2, OTVendorListMode.GENERAL)) {
            w wVar = this.f23437k;
            if (wVar == null) {
                kotlin.jvm.internal.t.A("vendorsGeneralDetailsFragment");
                wVar = null;
            }
            if (wVar.isAdded() || getActivity() == null) {
                return;
            }
            w wVar2 = this.f23437k;
            if (wVar2 == null) {
                kotlin.jvm.internal.t.A("vendorsGeneralDetailsFragment");
                wVar2 = null;
            }
            OTPublishersHeadlessSDK oTPublishersHeadlessSDK4 = O().f23697d;
            if (oTPublishersHeadlessSDK4 != null) {
                wVar2.f23554j = oTPublishersHeadlessSDK4;
            }
            wVar2.C = this.f23430d;
            wVar2.setArguments(BundleKt.bundleOf(v8.y.a("vendorId", str)));
            wVar2.f23561q = new w.a() { // from class: com.onetrust.otpublishers.headless.UI.fragment.t1
                @Override // com.onetrust.otpublishers.headless.UI.fragment.w.a
                public final void a() {
                    m2.Q(this.f23532a);
                }
            };
            w wVar3 = this.f23437k;
            if (wVar3 == null) {
                kotlin.jvm.internal.t.A("vendorsGeneralDetailsFragment");
                wVar3 = null;
            }
            com.onetrust.otpublishers.headless.UI.mobiledatautils.c.j(wVar3, requireActivity(), OTFragmentTags.OT_GENERAL_VENDOR_DETAILS_TAG);
        }
        if (kotlin.jvm.internal.t.d(str2, "google")) {
            CustomTabsIntent customTabsIntentBuild = new CustomTabsIntent.Builder().build();
            kotlin.jvm.internal.t.h(customTabsIntentBuild, "builder.build()");
            OTPublishersHeadlessSDK oTPublishersHeadlessSDK5 = O().f23697d;
            JSONObject vendorDetails = oTPublishersHeadlessSDK5 != null ? oTPublishersHeadlessSDK5.getVendorDetails(str2, str) : null;
            String strB = vendorDetails != null ? com.onetrust.otpublishers.headless.UI.extensions.g.b(vendorDetails, "policyUrl") : null;
            if (strB == null || strB.length() == 0) {
                return;
            }
            Uri uri = Uri.parse(strB);
            Context context = getContext();
            if (context != null) {
                customTabsIntentBuild.launchUrl(context, uri);
            }
        }
    }

    public final void K(Map<String, String> map) {
        OTConfiguration oTConfiguration = this.f23431e;
        String str = (String) com.onetrust.otpublishers.headless.UI.extensions.h.a(O().f23700g);
        o0 o0Var = new o0();
        Bundle bundle = new Bundle();
        bundle.putString(OTFragmentTags.FRAGMENT_TAG, OTFragmentTags.OT_VENDOR_LIST_FILTER_FRAGMENT_TAG);
        o0Var.setArguments(bundle);
        o0Var.f23465m = map;
        o0Var.f23464l = map;
        o0Var.f23467o = oTConfiguration;
        o0Var.f23470r = str;
        kotlin.jvm.internal.t.h(o0Var, "newInstance(\n           …ireValue(),\n            )");
        OTPublishersHeadlessSDK oTPublishersHeadlessSDK = O().f23697d;
        if (oTPublishersHeadlessSDK != null) {
            o0Var.f23462j = oTPublishersHeadlessSDK;
        }
        o0Var.f23463k = new o0.a() { // from class: com.onetrust.otpublishers.headless.UI.fragment.r1
            @Override // com.onetrust.otpublishers.headless.UI.fragment.o0.a
            public final void a(Map map2) {
                m2.H(this.f23525a, map2);
            }
        };
        this.f23435i = o0Var;
    }

    public final void L(boolean z10, com.onetrust.otpublishers.headless.UI.DataModels.l lVar) {
        com.onetrust.otpublishers.headless.databinding.h hVar = t().f23737b;
        String str = z10 ? lVar.f22124c : lVar.f22125d;
        if (str == null) {
            return;
        }
        hVar.f23778h.getDrawable().setTint(Color.parseColor(str));
    }

    @RequiresApi(21)
    public final boolean M(int i10) {
        final com.onetrust.otpublishers.headless.UI.viewmodel.d dVarO = O();
        if (this.f23434h == null) {
            Context context = getContext();
            kotlin.jvm.internal.t.f(context);
            this.f23434h = new OTPublishersHeadlessSDK(context);
        }
        OTPublishersHeadlessSDK otPublishersHeadlessSDK = this.f23434h;
        kotlin.jvm.internal.t.f(otPublishersHeadlessSDK);
        dVarO.getClass();
        kotlin.jvm.internal.t.i(otPublishersHeadlessSDK, "otPublishersHeadlessSDK");
        dVarO.f23697d = otPublishersHeadlessSDK;
        dVarO.f23698e = otPublishersHeadlessSDK.getOtVendorUtils();
        if (!dVarO.c(i10)) {
            return false;
        }
        dVarO.f23702i.observe(getViewLifecycleOwner(), new Observer() { // from class: com.onetrust.otpublishers.headless.UI.fragment.e2
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                m2.I(dVarO, this, (Map) obj);
            }
        });
        dVarO.f23703j.observe(getViewLifecycleOwner(), new Observer() { // from class: com.onetrust.otpublishers.headless.UI.fragment.f2
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                m2.U(dVarO, this, (Map) obj);
            }
        });
        dVarO.f23699f.observe(getViewLifecycleOwner(), new Observer() { // from class: com.onetrust.otpublishers.headless.UI.fragment.g2
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                m2.A(this.f23305a, (com.onetrust.otpublishers.headless.UI.DataModels.l) obj);
            }
        });
        dVarO.f23704k.observe(getViewLifecycleOwner(), new Observer() { // from class: com.onetrust.otpublishers.headless.UI.fragment.h2
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                m2.G(this.f23324a, (List) obj);
            }
        });
        dVarO.f23705l.observe(getViewLifecycleOwner(), new Observer() { // from class: com.onetrust.otpublishers.headless.UI.fragment.i2
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                m2.T(this.f23369a, (List) obj);
            }
        });
        dVarO.f23706m.observe(getViewLifecycleOwner(), new Observer() { // from class: com.onetrust.otpublishers.headless.UI.fragment.j2
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                m2.Z(this.f23373a, (List) obj);
            }
        });
        dVarO.f23701h.observe(getViewLifecycleOwner(), new Observer() { // from class: com.onetrust.otpublishers.headless.UI.fragment.k2
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                m2.E(this.f23377a, (Boolean) obj);
            }
        });
        return true;
    }

    public final com.onetrust.otpublishers.headless.UI.viewmodel.d O() {
        return (com.onetrust.otpublishers.headless.UI.viewmodel.d) this.f23429c.getValue();
    }

    public final void P(final com.onetrust.otpublishers.headless.UI.DataModels.l lVar) {
        final com.onetrust.otpublishers.headless.databinding.h hVar = t().f23737b;
        hVar.f23773c.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.onetrust.otpublishers.headless.UI.fragment.v1
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
                m2.C(this.f23543a, lVar, compoundButton, z10);
            }
        });
        hVar.f23774d.setOnClickListener(new View.OnClickListener() { // from class: com.onetrust.otpublishers.headless.UI.fragment.w1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                m2.z(this.f23572a, view);
            }
        });
        hVar.f23784n.setOnClickListener(new View.OnClickListener() { // from class: com.onetrust.otpublishers.headless.UI.fragment.x1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws Throwable {
                m2.R(this.f23576a, view);
            }
        });
        hVar.f23773c.setOnClickListener(new View.OnClickListener() { // from class: com.onetrust.otpublishers.headless.UI.fragment.y1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                m2.D(this.f23580a, hVar, view);
            }
        });
        hVar.f23778h.setOnClickListener(new View.OnClickListener() { // from class: com.onetrust.otpublishers.headless.UI.fragment.z1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                m2.X(this.f23600a, view);
            }
        });
        hVar.f23777g.setOnClickListener(new View.OnClickListener() { // from class: com.onetrust.otpublishers.headless.UI.fragment.a2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                m2.B(this.f23213a, lVar, view);
            }
        });
        hVar.f23776f.setOnClickListener(new View.OnClickListener() { // from class: com.onetrust.otpublishers.headless.UI.fragment.c2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                m2.S(this.f23269a, lVar, view);
            }
        });
        hVar.f23775e.setOnClickListener(new View.OnClickListener() { // from class: com.onetrust.otpublishers.headless.UI.fragment.d2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                m2.Y(this.f23288a, lVar, view);
            }
        });
    }

    public final void V() {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.onetrust.otpublishers.headless.UI.fragment.b2
            @Override // java.lang.Runnable
            public final void run() {
                m2.c0(this.f23250a);
            }
        });
    }

    public final void W(com.onetrust.otpublishers.headless.UI.DataModels.l lVar) {
        SearchView searchView = t().f23737b.f23781k;
        searchView.setIconifiedByDefault(false);
        searchView.onActionViewExpanded();
        searchView.clearFocus();
        searchView.setOnQueryTextListener(new c());
        searchView.setOnCloseListener(new SearchView.OnCloseListener() { // from class: com.onetrust.otpublishers.headless.UI.fragment.l2
            @Override // androidx.appcompat.widget.SearchView.OnCloseListener
            public final boolean onClose() {
                return m2.a0(this.f23422a);
            }
        });
        v(lVar);
    }

    public final void b0(com.onetrust.otpublishers.headless.UI.DataModels.l lVar) {
        com.onetrust.otpublishers.headless.databinding.h hVar = t().f23737b;
        com.onetrust.otpublishers.headless.UI.viewmodel.d dVarO = O();
        dVarO.getClass();
        kotlin.jvm.internal.t.i(OTVendorListMode.GENERAL, "newMode");
        dVarO.f23700g.setValue(OTVendorListMode.GENERAL);
        O().e();
        ImageView filterVendors = hVar.f23778h;
        kotlin.jvm.internal.t.h(filterVendors, "filterVendors");
        filterVendors.setVisibility(0);
        SearchView searchVendor = hVar.f23781k;
        kotlin.jvm.internal.t.h(searchVendor, "searchVendor");
        searchVendor.setVisibility(0);
        RecyclerView recyclerView = hVar.f23780j;
        com.onetrust.otpublishers.headless.UI.adapter.p0 p0Var = this.f23440n;
        if (p0Var == null) {
            kotlin.jvm.internal.t.A("generalVendorAdapter");
            p0Var = null;
        }
        recyclerView.setAdapter(p0Var);
        boolean z10 = lVar.f22134m;
        SwitchCompat allConsentToggle = hVar.f23773c;
        kotlin.jvm.internal.t.h(allConsentToggle, "allConsentToggle");
        allConsentToggle.setVisibility(z10 ? 0 : 8);
        TextView vendorAllowAllTitle = hVar.f23783m;
        kotlin.jvm.internal.t.h(vendorAllowAllTitle, "vendorAllowAllTitle");
        vendorAllowAllTitle.setVisibility(z10 ? 0 : 8);
        View view3 = hVar.f23786p;
        kotlin.jvm.internal.t.h(view3, "view3");
        view3.setVisibility(z10 ? 0 : 8);
        AppCompatButton buttonGeneralVendors = hVar.f23775e;
        kotlin.jvm.internal.t.h(buttonGeneralVendors, "buttonGeneralVendors");
        AppCompatButton buttonIabVendors = hVar.f23777g;
        kotlin.jvm.internal.t.h(buttonIabVendors, "buttonIabVendors");
        AppCompatButton buttonGoogleVendors = hVar.f23776f;
        kotlin.jvm.internal.t.h(buttonGoogleVendors, "buttonGoogleVendors");
        w(lVar, buttonGeneralVendors, buttonIabVendors, buttonGoogleVendors);
        L(!((Map) com.onetrust.otpublishers.headless.UI.extensions.h.a(O().f23703j)).isEmpty(), lVar);
    }

    public final void d0(com.onetrust.otpublishers.headless.UI.DataModels.l lVar) {
        com.onetrust.otpublishers.headless.databinding.h hVar = t().f23737b;
        com.onetrust.otpublishers.headless.UI.viewmodel.d dVarO = O();
        dVarO.getClass();
        kotlin.jvm.internal.t.i("google", "newMode");
        dVarO.f23700g.setValue("google");
        O().e();
        ImageView filterVendors = hVar.f23778h;
        kotlin.jvm.internal.t.h(filterVendors, "filterVendors");
        filterVendors.setVisibility(8);
        SearchView searchVendor = hVar.f23781k;
        kotlin.jvm.internal.t.h(searchVendor, "searchVendor");
        searchVendor.setVisibility(0);
        SwitchCompat allConsentToggle = hVar.f23773c;
        kotlin.jvm.internal.t.h(allConsentToggle, "allConsentToggle");
        allConsentToggle.setVisibility(0);
        TextView vendorAllowAllTitle = hVar.f23783m;
        kotlin.jvm.internal.t.h(vendorAllowAllTitle, "vendorAllowAllTitle");
        vendorAllowAllTitle.setVisibility(0);
        View view3 = hVar.f23786p;
        kotlin.jvm.internal.t.h(view3, "view3");
        view3.setVisibility(0);
        RecyclerView recyclerView = hVar.f23780j;
        com.onetrust.otpublishers.headless.UI.adapter.s0 s0Var = this.f23439m;
        if (s0Var == null) {
            kotlin.jvm.internal.t.A("googleVendorAdapter");
            s0Var = null;
        }
        recyclerView.setAdapter(s0Var);
        AppCompatButton buttonGoogleVendors = hVar.f23776f;
        kotlin.jvm.internal.t.h(buttonGoogleVendors, "buttonGoogleVendors");
        AppCompatButton buttonIabVendors = hVar.f23777g;
        kotlin.jvm.internal.t.h(buttonIabVendors, "buttonIabVendors");
        AppCompatButton buttonGeneralVendors = hVar.f23775e;
        kotlin.jvm.internal.t.h(buttonGeneralVendors, "buttonGeneralVendors");
        w(lVar, buttonGoogleVendors, buttonIabVendors, buttonGeneralVendors);
    }

    public final void e0(com.onetrust.otpublishers.headless.UI.DataModels.l lVar) {
        com.onetrust.otpublishers.headless.databinding.h hVar = t().f23737b;
        com.onetrust.otpublishers.headless.UI.viewmodel.d dVarO = O();
        dVarO.getClass();
        kotlin.jvm.internal.t.i(OTVendorListMode.IAB, "newMode");
        dVarO.f23700g.setValue(OTVendorListMode.IAB);
        O().e();
        ImageView filterVendors = hVar.f23778h;
        kotlin.jvm.internal.t.h(filterVendors, "filterVendors");
        filterVendors.setVisibility(0);
        SearchView searchVendor = hVar.f23781k;
        kotlin.jvm.internal.t.h(searchVendor, "searchVendor");
        searchVendor.setVisibility(0);
        SwitchCompat allConsentToggle = hVar.f23773c;
        kotlin.jvm.internal.t.h(allConsentToggle, "allConsentToggle");
        allConsentToggle.setVisibility(0);
        TextView vendorAllowAllTitle = hVar.f23783m;
        kotlin.jvm.internal.t.h(vendorAllowAllTitle, "vendorAllowAllTitle");
        vendorAllowAllTitle.setVisibility(0);
        View view3 = hVar.f23786p;
        kotlin.jvm.internal.t.h(view3, "view3");
        view3.setVisibility(0);
        RecyclerView recyclerView = hVar.f23780j;
        com.onetrust.otpublishers.headless.UI.adapter.i0 i0Var = this.f23438l;
        if (i0Var == null) {
            kotlin.jvm.internal.t.A("iabVendorAdapter");
            i0Var = null;
        }
        recyclerView.setAdapter(i0Var);
        AppCompatButton buttonIabVendors = hVar.f23777g;
        kotlin.jvm.internal.t.h(buttonIabVendors, "buttonIabVendors");
        AppCompatButton buttonGeneralVendors = hVar.f23775e;
        kotlin.jvm.internal.t.h(buttonGeneralVendors, "buttonGeneralVendors");
        AppCompatButton buttonGoogleVendors = hVar.f23776f;
        kotlin.jvm.internal.t.h(buttonGoogleVendors, "buttonGoogleVendors");
        w(lVar, buttonIabVendors, buttonGeneralVendors, buttonGoogleVendors);
        kotlin.jvm.internal.t.h(com.onetrust.otpublishers.headless.UI.extensions.h.a(O().f23702i), "_selectedFilterMap.requireValue()");
        L(!((Map) r0).isEmpty(), lVar);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(@Nullable Bundle bundle) {
        LinkedHashMap selectedMap;
        super.onCreate(bundle);
        setRetainInstance(true);
        com.onetrust.otpublishers.headless.UI.viewmodel.d dVarO = O();
        Bundle arguments = getArguments();
        dVarO.getClass();
        if (arguments != null) {
            String newMode = (arguments.containsKey("generalVendors") && arguments.getBoolean("generalVendors")) ? OTVendorListMode.GENERAL : OTVendorListMode.IAB;
            kotlin.jvm.internal.t.i(newMode, "newMode");
            dVarO.f23700g.setValue(newMode);
            String string = arguments.getString("PURPOSE_MAP");
            Map<String, String> value = (dVarO.d() ? dVarO.f23702i : dVarO.f23703j).getValue();
            if (value == null || value.isEmpty()) {
                if ((string == null || string.length() == 0) || kotlin.jvm.internal.t.d(string, JsonUtils.EMPTY_JSON)) {
                    selectedMap = null;
                } else {
                    String strSubstring = string.substring(1, string.length() - 1);
                    kotlin.jvm.internal.t.h(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
                    String[] strArr = (String[]) p9.r.C0(strSubstring, new String[]{","}, false, 0, 6, null).toArray(new String[0]);
                    selectedMap = new LinkedHashMap();
                    for (String str : strArr) {
                        String[] strArr2 = (String[]) p9.r.C0(str, new String[]{v8.i.f15833b}, false, 0, 6, null).toArray(new String[0]);
                        String str2 = strArr2[0];
                        int length = str2.length() - 1;
                        int i10 = 0;
                        boolean z10 = false;
                        while (i10 <= length) {
                            boolean z11 = kotlin.jvm.internal.t.k(str2.charAt(!z10 ? i10 : length), 32) <= 0;
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
                        String string2 = str2.subSequence(i10, length + 1).toString();
                        String str3 = strArr2[1];
                        int length2 = str3.length() - 1;
                        int i11 = 0;
                        boolean z12 = false;
                        while (i11 <= length2) {
                            boolean z13 = kotlin.jvm.internal.t.k(str3.charAt(!z12 ? i11 : length2), 32) <= 0;
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
                        selectedMap.put(string2, str3.subSequence(i11, length2 + 1).toString());
                    }
                }
                if (selectedMap == null) {
                    selectedMap = new LinkedHashMap();
                }
                kotlin.jvm.internal.t.i(selectedMap, "selectedMap");
                (dVarO.d() ? dVarO.f23702i : dVarO.f23703j).setValue(selectedMap);
                dVarO.e();
            }
        }
        FragmentActivity activity = getActivity();
        if (com.onetrust.otpublishers.headless.UI.mobiledatautils.c.i(activity, OTFragmentTags.OT_VENDOR_LIST_FRAGMENT_TAG)) {
            SharedPreferences sharedPreferences = activity.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOT_SDK_APP_CONFIGURATION", 0);
            String str4 = OTThemeConstants.NO_SDK_THEME_OVERRIDE;
            String string3 = sharedPreferences.getString("OT_UX_SDK_THEME", OTThemeConstants.NO_SDK_THEME_OVERRIDE);
            if (com.onetrust.otpublishers.headless.Internal.c.q(string3)) {
                string3 = OTThemeConstants.NO_SDK_THEME_OVERRIDE;
            }
            if (!string3.equals(OTThemeConstants.OT_SDK_UI_THEME)) {
                String string4 = activity.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOT_SDK_APP_CONFIGURATION", 0).getString("OT_UX_SDK_THEME", OTThemeConstants.NO_SDK_THEME_OVERRIDE);
                if (!com.onetrust.otpublishers.headless.Internal.c.q(string4)) {
                    str4 = string4;
                }
                if (!str4.equals(OTThemeConstants.OT_THEME_APP_COMPACT_LIGHT_NO_ACTION_BAR_LANDSCAPE_FULL_SCREEN)) {
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
        dialogOnCreateDialog.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.onetrust.otpublishers.headless.UI.fragment.q1
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                m2.y(this.f23503a, dialogInterface);
            }
        });
        return dialogOnCreateDialog;
    }

    @Override // androidx.fragment.app.Fragment
    @NotNull
    public final View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        kotlin.jvm.internal.t.i(inflater, "inflater");
        com.onetrust.otpublishers.headless.UI.Helper.l lVar = this.f23432f;
        Context contextRequireContext = requireContext();
        int i10 = p6.e.f32875i;
        lVar.getClass();
        View viewC = com.onetrust.otpublishers.headless.UI.Helper.l.c(contextRequireContext, inflater, viewGroup, i10);
        kotlin.jvm.internal.t.h(viewC, "uiUtils.getOTView(requir…fragment_ot_vendors_list)");
        return viewC;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        OTVendorUtils oTVendorUtils = O().f23698e;
        if (oTVendorUtils != null) {
            oTVendorUtils.setSelectAllButtonListener(null);
            v8.k0 k0Var = v8.k0.f35197a;
        }
        this.f23430d = null;
    }

    @Override // androidx.fragment.app.Fragment
    @RequiresApi(21)
    public final void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        kotlin.jvm.internal.t.i(view, "view");
        super.onViewCreated(view, bundle);
        if (!M(com.onetrust.otpublishers.headless.UI.Helper.l.a(requireContext(), this.f23431e))) {
            dismiss();
            return;
        }
        com.onetrust.otpublishers.headless.UI.mobiledatautils.c.f("VendorsList", getContext(), view);
        OTConfiguration oTConfiguration = this.f23431e;
        a3 a3Var = new a3();
        Bundle bundle2 = new Bundle();
        bundle2.putString(TypedValues.Custom.S_STRING, OTFragmentTags.OT_VENDOR_DETAILS_FRAGMENT_TAG);
        a3Var.setArguments(bundle2);
        a3Var.f23215a0 = oTConfiguration;
        kotlin.jvm.internal.t.h(a3Var, "newInstance(\n           …otConfiguration\n        )");
        this.f23436j = a3Var;
        OTConfiguration oTConfiguration2 = this.f23431e;
        w wVar = new w();
        Bundle bundle3 = new Bundle();
        bundle3.putString(TypedValues.Custom.S_STRING, OTFragmentTags.OT_GENERAL_VENDOR_DETAILS_TAG);
        wVar.setArguments(bundle3);
        wVar.f23568x = oTConfiguration2;
        kotlin.jvm.internal.t.h(wVar, "newInstance(\n           …otConfiguration\n        )");
        this.f23437k = wVar;
        V();
    }

    public final com.onetrust.otpublishers.headless.databinding.c t() {
        return (com.onetrust.otpublishers.headless.databinding.c) this.f23428b.a(this, f23427p[0]);
    }

    public final void u(@NotNull OTPublishersHeadlessSDK otPublishersHeadlessSDK) {
        kotlin.jvm.internal.t.i(otPublishersHeadlessSDK, "otPublishersHeadlessSDK");
        this.f23434h = otPublishersHeadlessSDK;
    }

    public final void v(com.onetrust.otpublishers.headless.UI.DataModels.l lVar) {
        SearchView searchView = t().f23737b.f23781k;
        com.onetrust.otpublishers.headless.UI.UIProperty.a aVarA = lVar.a();
        String strG = aVarA.g();
        kotlin.jvm.internal.t.h(strG, "searchBarProperty.placeHolderText");
        if (strG.length() > 0) {
            searchView.setQueryHint(aVarA.g());
        }
        String strJ = aVarA.j();
        if (!(strJ == null || strJ.length() == 0)) {
            ((EditText) searchView.findViewById(R.id.search_src_text)).setTextColor(Color.parseColor(aVarA.j()));
        }
        String strH = aVarA.h();
        if (!(strH == null || strH.length() == 0)) {
            ((EditText) searchView.findViewById(R.id.search_src_text)).setHintTextColor(Color.parseColor(aVarA.h()));
        }
        int i10 = R.id.search_src_text;
        View viewFindViewById = searchView.findViewById(i10);
        kotlin.jvm.internal.t.h(viewFindViewById, "findViewById<EditText>(a…pat.R.id.search_src_text)");
        com.onetrust.otpublishers.headless.UI.extensions.m.a((TextView) viewFindViewById);
        View viewFindViewById2 = searchView.findViewById(i10);
        kotlin.jvm.internal.t.h(viewFindViewById2, "findViewById<EditText>(a…pat.R.id.search_src_text)");
        com.onetrust.otpublishers.headless.UI.UIProperty.l lVarA = aVarA.i().a();
        kotlin.jvm.internal.t.h(lVarA, "searchBarProperty.searchTextProperty.fontProperty");
        com.onetrust.otpublishers.headless.UI.extensions.m.d((TextView) viewFindViewById2, lVarA, this.f23431e);
        String strF = aVarA.f();
        if (!(strF == null || strF.length() == 0)) {
            ((ImageView) searchView.findViewById(R.id.search_mag_icon)).setColorFilter(Color.parseColor(aVarA.f()), PorterDuff.Mode.SRC_IN);
        }
        String strE = aVarA.e();
        if (!(strE == null || strE.length() == 0)) {
            ((ImageView) searchView.findViewById(R.id.search_close_btn)).setColorFilter(Color.parseColor(aVarA.e()), PorterDuff.Mode.SRC_IN);
        }
        View viewFindViewById3 = searchView.findViewById(R.id.search_edit_frame);
        viewFindViewById3.setBackgroundResource(p6.c.f32637d);
        String strD = aVarA.d();
        String strB = aVarA.b();
        String strA = aVarA.a();
        String strC = aVarA.c();
        GradientDrawable gradientDrawable = new GradientDrawable();
        kotlin.jvm.internal.t.f(strD);
        gradientDrawable.setStroke(Integer.parseInt(strD), Color.parseColor(strB));
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(Color.parseColor(strA));
        kotlin.jvm.internal.t.f(strC);
        gradientDrawable.setCornerRadius(Float.parseFloat(strC));
        viewFindViewById3.setBackground(gradientDrawable);
        if (com.onetrust.otpublishers.headless.Internal.Helper.k.e(viewFindViewById3.getContext())) {
            viewFindViewById3.setLayoutDirection(1);
        }
    }

    public final void w(com.onetrust.otpublishers.headless.UI.DataModels.l lVar, AppCompatButton appCompatButton, AppCompatButton appCompatButton2, AppCompatButton appCompatButton3) {
        com.onetrust.otpublishers.headless.databinding.h hVar = t().f23737b;
        String str = lVar.f22130i.f22759b;
        com.onetrust.otpublishers.headless.UI.viewmodel.d dVarO = O();
        String strC = ((com.onetrust.otpublishers.headless.UI.DataModels.l) com.onetrust.otpublishers.headless.UI.extensions.h.a(dVarO.f23699f)).f22130i.c();
        boolean z10 = true;
        if (!(!(strC == null || strC.length() == 0))) {
            strC = null;
        }
        if (strC == null) {
            strC = ((com.onetrust.otpublishers.headless.UI.DataModels.l) com.onetrust.otpublishers.headless.UI.extensions.h.a(dVarO.f23699f)).f22131j;
        }
        com.onetrust.otpublishers.headless.UI.viewmodel.d dVarO2 = O();
        String str2 = ((com.onetrust.otpublishers.headless.UI.DataModels.l) com.onetrust.otpublishers.headless.UI.extensions.h.a(dVarO2.f23699f)).f22132k.f22722c;
        String str3 = (str2 == null || str2.length() == 0) ^ true ? str2 : null;
        if (str3 == null) {
            str3 = ((com.onetrust.otpublishers.headless.UI.DataModels.l) com.onetrust.otpublishers.headless.UI.extensions.h.a(dVarO2.f23699f)).f22133l;
        }
        com.onetrust.otpublishers.headless.UI.extensions.a.c(appCompatButton, strC);
        kotlin.jvm.internal.t.i(appCompatButton, "<this>");
        if (str != null && str.length() != 0) {
            z10 = false;
        }
        if (!z10) {
            appCompatButton.setBackgroundColor(Color.parseColor(str));
        }
        com.onetrust.otpublishers.headless.UI.extensions.a.c(appCompatButton2, str3);
        appCompatButton2.setBackgroundColor(0);
        com.onetrust.otpublishers.headless.UI.extensions.a.c(appCompatButton3, str3);
        appCompatButton3.setBackgroundColor(0);
        hVar.f23782l.setCardBackgroundColor(0);
    }
}
