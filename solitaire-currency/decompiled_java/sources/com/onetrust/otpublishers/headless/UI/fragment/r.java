package com.onetrust.otpublishers.headless.UI.fragment;

import android.app.Application;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import androidx.core.os.BundleKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import com.onetrust.otpublishers.headless.Public.DataModel.OTConfiguration;
import com.onetrust.otpublishers.headless.Public.Keys.OTFragmentTags;
import com.onetrust.otpublishers.headless.Public.OTBannerHeightRatio;
import com.onetrust.otpublishers.headless.Public.OTConsentInteractionType;
import com.onetrust.otpublishers.headless.Public.OTPublishersHeadlessSDK;
import com.onetrust.otpublishers.headless.Public.OTThemeConstants;
import com.onetrust.otpublishers.headless.Public.OTUIDisplayReason.OTUIDisplayReason;
import com.onetrust.otpublishers.headless.UI.fragment.m2;
import com.onetrust.otpublishers.headless.UI.viewmodel.a;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;

/* JADX INFO: loaded from: classes4.dex */
public final class r extends com.google.android.material.bottomsheet.b implements com.onetrust.otpublishers.headless.UI.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public OTPublishersHeadlessSDK f23507b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    public final com.onetrust.otpublishers.headless.UI.Helper.b f23508c = com.onetrust.otpublishers.headless.UI.Helper.m.a(this, b.f23517b);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    public final v8.l f23509d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    public com.onetrust.otpublishers.headless.Internal.Event.a f23510e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    public OTConfiguration f23511f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public m2 f23512g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public l0 f23513h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NotNull
    public final com.onetrust.otpublishers.headless.UI.Helper.l f23514i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Nullable
    public BottomSheetBehavior<View> f23515j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @Nullable
    public com.google.android.material.bottomsheet.a f23516k;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ KProperty<Object>[] f23506m = {kotlin.jvm.internal.o0.g(new kotlin.jvm.internal.g0(r.class, "binding", "getBinding()Lcom/onetrust/otpublishers/headless/databinding/FragmentOtBannerBinding;", 0))};

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @NotNull
    public static final a f23505l = new a();

    public static final class a {
    }

    public /* synthetic */ class b extends kotlin.jvm.internal.q implements h9.l<View, com.onetrust.otpublishers.headless.databinding.a> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final b f23517b = new b();

        public b() {
            super(1, com.onetrust.otpublishers.headless.databinding.a.class, "bind", "bind(Landroid/view/View;)Lcom/onetrust/otpublishers/headless/databinding/FragmentOtBannerBinding;", 0);
        }

        @Override // h9.l
        public final com.onetrust.otpublishers.headless.databinding.a invoke(View view) {
            View p02 = view;
            kotlin.jvm.internal.t.i(p02, "p0");
            int i10 = p6.d.C;
            TextView textView = (TextView) ViewBindings.findChildViewById(p02, i10);
            if (textView != null) {
                i10 = p6.d.W;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(p02, i10);
                if (textView2 != null) {
                    i10 = p6.d.X;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(p02, i10);
                    if (textView3 != null) {
                        i10 = p6.d.Y;
                        TextView textView4 = (TextView) ViewBindings.findChildViewById(p02, i10);
                        if (textView4 != null) {
                            i10 = p6.d.R;
                            TextView textView5 = (TextView) ViewBindings.findChildViewById(p02, i10);
                            if (textView5 != null) {
                                i10 = p6.d.S;
                                TextView textView6 = (TextView) ViewBindings.findChildViewById(p02, i10);
                                if (textView6 != null) {
                                    RelativeLayout relativeLayout = (RelativeLayout) p02;
                                    i10 = p6.d.f32666d0;
                                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(p02, i10);
                                    if (imageView != null) {
                                        i10 = p6.d.f32675e0;
                                        TextView textView7 = (TextView) ViewBindings.findChildViewById(p02, i10);
                                        if (textView7 != null) {
                                            i10 = p6.d.f32693g0;
                                            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(p02, i10);
                                            if (linearLayout != null) {
                                                i10 = p6.d.f32747m0;
                                                Button button = (Button) ViewBindings.findChildViewById(p02, i10);
                                                if (button != null) {
                                                    i10 = p6.d.f32819u0;
                                                    Button button2 = (Button) ViewBindings.findChildViewById(p02, i10);
                                                    if (button2 != null) {
                                                        i10 = p6.d.f32860z0;
                                                        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(p02, i10);
                                                        if (linearLayout2 != null) {
                                                            i10 = p6.d.I0;
                                                            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(p02, i10);
                                                            if (imageView2 != null) {
                                                                i10 = p6.d.J0;
                                                                Button button3 = (Button) ViewBindings.findChildViewById(p02, i10);
                                                                if (button3 != null) {
                                                                    i10 = p6.d.K0;
                                                                    TextView textView8 = (TextView) ViewBindings.findChildViewById(p02, i10);
                                                                    if (textView8 != null) {
                                                                        i10 = p6.d.f32640a1;
                                                                        TextView textView9 = (TextView) ViewBindings.findChildViewById(p02, i10);
                                                                        if (textView9 != null) {
                                                                            i10 = p6.d.f32658c1;
                                                                            TextView textView10 = (TextView) ViewBindings.findChildViewById(p02, i10);
                                                                            if (textView10 != null) {
                                                                                i10 = p6.d.f32667d1;
                                                                                Button button4 = (Button) ViewBindings.findChildViewById(p02, i10);
                                                                                if (button4 != null) {
                                                                                    i10 = p6.d.f32676e1;
                                                                                    ScrollView scrollView = (ScrollView) ViewBindings.findChildViewById(p02, i10);
                                                                                    if (scrollView != null) {
                                                                                        i10 = p6.d.G1;
                                                                                        if (((LinearLayout) ViewBindings.findChildViewById(p02, i10)) != null) {
                                                                                            i10 = p6.d.V4;
                                                                                            TextView textView11 = (TextView) ViewBindings.findChildViewById(p02, i10);
                                                                                            if (textView11 != null) {
                                                                                                i10 = p6.d.X4;
                                                                                                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(p02, i10);
                                                                                                if (imageView3 != null) {
                                                                                                    i10 = p6.d.Y4;
                                                                                                    TextView textView12 = (TextView) ViewBindings.findChildViewById(p02, i10);
                                                                                                    if (textView12 != null) {
                                                                                                        i10 = p6.d.Z4;
                                                                                                        RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(p02, i10);
                                                                                                        if (relativeLayout2 != null) {
                                                                                                            return new com.onetrust.otpublishers.headless.databinding.a(relativeLayout, textView, textView2, textView3, textView4, textView5, textView6, relativeLayout, imageView, textView7, linearLayout, button, button2, linearLayout2, imageView2, button3, textView8, textView9, textView10, button4, scrollView, textView11, imageView3, textView12, relativeLayout2);
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
                        }
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(p02.getResources().getResourceName(i10)));
        }
    }

    public static final class c extends kotlin.jvm.internal.v implements h9.a<Fragment> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ Fragment f23518g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(Fragment fragment) {
            super(0);
            this.f23518g = fragment;
        }

        @Override // h9.a
        public final Fragment invoke() {
            return this.f23518g;
        }
    }

    public static final class d extends kotlin.jvm.internal.v implements h9.a<ViewModelStoreOwner> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ h9.a f23519g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(c cVar) {
            super(0);
            this.f23519g = cVar;
        }

        @Override // h9.a
        @NotNull
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final ViewModelStoreOwner invoke() {
            return (ViewModelStoreOwner) this.f23519g.invoke();
        }
    }

    public static final class e extends kotlin.jvm.internal.v implements h9.a<ViewModelStore> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ v8.l f23520g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(v8.l lVar) {
            super(0);
            this.f23520g = lVar;
        }

        @Override // h9.a
        public final ViewModelStore invoke() {
            return FragmentViewModelLazyKt.m3931viewModels$lambda1(this.f23520g).getViewModelStore();
        }
    }

    public static final class f extends kotlin.jvm.internal.v implements h9.a<CreationExtras> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ v8.l f23521g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(v8.l lVar) {
            super(0);
            this.f23521g = lVar;
        }

        @Override // h9.a
        public final CreationExtras invoke() {
            ViewModelStoreOwner viewModelStoreOwnerM3931viewModels$lambda1 = FragmentViewModelLazyKt.m3931viewModels$lambda1(this.f23521g);
            HasDefaultViewModelProviderFactory hasDefaultViewModelProviderFactory = viewModelStoreOwnerM3931viewModels$lambda1 instanceof HasDefaultViewModelProviderFactory ? (HasDefaultViewModelProviderFactory) viewModelStoreOwnerM3931viewModels$lambda1 : null;
            return hasDefaultViewModelProviderFactory != null ? hasDefaultViewModelProviderFactory.getDefaultViewModelCreationExtras() : CreationExtras.Empty.INSTANCE;
        }
    }

    public static final class g extends kotlin.jvm.internal.v implements h9.a<ViewModelProvider.Factory> {
        public g() {
            super(0);
        }

        @Override // h9.a
        public final ViewModelProvider.Factory invoke() {
            Application application = r.this.requireActivity().getApplication();
            kotlin.jvm.internal.t.h(application, "requireActivity().application");
            return new a.C0487a(application, r.this.f23507b);
        }
    }

    public r() {
        g gVar = new g();
        v8.l lVarB = v8.n.b(v8.p.f35203c, new d(new c(this)));
        this.f23509d = FragmentViewModelLazyKt.createViewModelLazy(this, kotlin.jvm.internal.o0.b(com.onetrust.otpublishers.headless.UI.viewmodel.a.class), new e(lVarB), new f(lVarB), gVar);
        this.f23514i = new com.onetrust.otpublishers.headless.UI.Helper.l();
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0045  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final boolean B(com.onetrust.otpublishers.headless.UI.fragment.r r1, android.content.DialogInterface r2, int r3, android.view.KeyEvent r4) throws java.lang.Throwable {
        /*
            java.lang.String r2 = "this$0"
            kotlin.jvm.internal.t.i(r1, r2)
            java.lang.String r2 = "event"
            kotlin.jvm.internal.t.i(r4, r2)
            r2 = 4
            r0 = 0
            if (r3 != r2) goto L58
            int r2 = r4.getAction()
            r3 = 1
            if (r2 != r3) goto L58
            com.onetrust.otpublishers.headless.Public.DataModel.OTConfiguration r2 = r1.f23511f
            java.lang.String r4 = "Banner - Back"
            if (r2 == 0) goto L45
            kotlin.jvm.internal.t.f(r2)
            boolean r2 = r2.isBannerBackButtonDisabled()
            if (r2 == 0) goto L25
            goto L45
        L25:
            com.onetrust.otpublishers.headless.Public.DataModel.OTConfiguration r2 = r1.f23511f
            kotlin.jvm.internal.t.f(r2)
            boolean r2 = r2.isBannerBackButtonDisMissUI()
            if (r2 == 0) goto L34
            r1.A(r4, r0)
            return r3
        L34:
            com.onetrust.otpublishers.headless.Public.DataModel.OTConfiguration r2 = r1.f23511f
            kotlin.jvm.internal.t.f(r2)
            boolean r2 = r2.isBannerBackButtonCloseBanner()
            if (r2 == 0) goto L58
            java.lang.String r2 = "Banner - Close"
            r1.A(r2, r3)
            return r3
        L45:
            com.onetrust.otpublishers.headless.Internal.Event.b r2 = new com.onetrust.otpublishers.headless.Internal.Event.b
            r3 = 18
            r2.<init>(r3)
            r2.f21748d = r4
            com.onetrust.otpublishers.headless.UI.Helper.l r3 = r1.f23514i
            com.onetrust.otpublishers.headless.Internal.Event.a r1 = r1.f23510e
            r3.getClass()
            com.onetrust.otpublishers.headless.UI.Helper.l.s(r2, r1)
        L58:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onetrust.otpublishers.headless.UI.fragment.r.B(com.onetrust.otpublishers.headless.UI.fragment.r, android.content.DialogInterface, int, android.view.KeyEvent):boolean");
    }

    public static final void E(r this$0, View view) throws Throwable {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        this$0.A(OTConsentInteractionType.BANNER_CLOSE, true);
    }

    public static final void G(r this$0, View view) throws Throwable {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        this$0.A(OTConsentInteractionType.BANNER_CONTINUE_WITHOUT_ACCEPTING, true);
    }

    public static final void I(r this$0, View view) throws Throwable {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        this$0.A(OTConsentInteractionType.BANNER_CONTINUE_WITHOUT_ACCEPTING, true);
    }

    public static final void J(r this$0, View view) throws Throwable {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        com.onetrust.otpublishers.headless.UI.viewmodel.a aVarC = this$0.C();
        aVarC.getClass();
        kotlin.jvm.internal.t.i(OTConsentInteractionType.BANNER_ALLOW_ALL, "type");
        aVarC.f23668a.saveConsent(OTConsentInteractionType.BANNER_ALLOW_ALL);
        com.onetrust.otpublishers.headless.UI.Helper.l lVar = this$0.f23514i;
        com.onetrust.otpublishers.headless.Internal.Event.b bVar = new com.onetrust.otpublishers.headless.Internal.Event.b(3);
        com.onetrust.otpublishers.headless.Internal.Event.a aVar = this$0.f23510e;
        lVar.getClass();
        com.onetrust.otpublishers.headless.UI.Helper.l.s(bVar, aVar);
        com.onetrust.otpublishers.headless.Internal.Event.b bVar2 = new com.onetrust.otpublishers.headless.Internal.Event.b(17);
        bVar2.f21748d = OTConsentInteractionType.BANNER_ALLOW_ALL;
        com.onetrust.otpublishers.headless.UI.Helper.l lVar2 = this$0.f23514i;
        com.onetrust.otpublishers.headless.Internal.Event.a aVar2 = this$0.f23510e;
        lVar2.getClass();
        com.onetrust.otpublishers.headless.UI.Helper.l.s(bVar2, aVar2);
        this$0.dismiss();
    }

    public static final void K(r this$0, View view) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        this$0.H();
    }

    public static final void L(r this$0, View view) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        this$0.H();
    }

    public static final void M(r this$0, View view) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        m2 m2Var = this$0.f23512g;
        m2 m2Var2 = null;
        if (m2Var == null) {
            kotlin.jvm.internal.t.A("vendorsListFragment");
            m2Var = null;
        }
        if (m2Var.isAdded() || this$0.getActivity() == null) {
            return;
        }
        m2 m2Var3 = this$0.f23512g;
        if (m2Var3 == null) {
            kotlin.jvm.internal.t.A("vendorsListFragment");
            m2Var3 = null;
        }
        m2Var3.setArguments(BundleKt.bundleOf(v8.y.a("IS_FILTERED_VENDOR_LIST", Boolean.FALSE)));
        m2 m2Var4 = this$0.f23512g;
        if (m2Var4 == null) {
            kotlin.jvm.internal.t.A("vendorsListFragment");
        } else {
            m2Var2 = m2Var4;
        }
        com.onetrust.otpublishers.headless.UI.mobiledatautils.c.j(m2Var2, this$0.requireActivity(), OTFragmentTags.OT_VENDOR_LIST_FRAGMENT_TAG);
        com.onetrust.otpublishers.headless.UI.Helper.l lVar = this$0.f23514i;
        com.onetrust.otpublishers.headless.Internal.Event.b bVar = new com.onetrust.otpublishers.headless.Internal.Event.b(12);
        com.onetrust.otpublishers.headless.Internal.Event.a aVar = this$0.f23510e;
        lVar.getClass();
        com.onetrust.otpublishers.headless.UI.Helper.l.s(bVar, aVar);
    }

    public static final void N(r this$0, View view) throws Throwable {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        com.onetrust.otpublishers.headless.UI.viewmodel.a aVarC = this$0.C();
        aVarC.getClass();
        kotlin.jvm.internal.t.i(OTConsentInteractionType.BANNER_REJECT_ALL, "type");
        aVarC.f23668a.saveConsent(OTConsentInteractionType.BANNER_REJECT_ALL);
        com.onetrust.otpublishers.headless.UI.Helper.l lVar = this$0.f23514i;
        com.onetrust.otpublishers.headless.Internal.Event.b bVar = new com.onetrust.otpublishers.headless.Internal.Event.b(4);
        com.onetrust.otpublishers.headless.Internal.Event.a aVar = this$0.f23510e;
        lVar.getClass();
        com.onetrust.otpublishers.headless.UI.Helper.l.s(bVar, aVar);
        com.onetrust.otpublishers.headless.Internal.Event.b bVar2 = new com.onetrust.otpublishers.headless.Internal.Event.b(17);
        bVar2.f21748d = OTConsentInteractionType.BANNER_REJECT_ALL;
        com.onetrust.otpublishers.headless.UI.Helper.l lVar2 = this$0.f23514i;
        com.onetrust.otpublishers.headless.Internal.Event.a aVar2 = this$0.f23510e;
        lVar2.getClass();
        com.onetrust.otpublishers.headless.UI.Helper.l.s(bVar2, aVar2);
        this$0.dismiss();
    }

    public static final void w(final r this$0, DialogInterface dialogInterface) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        kotlin.jvm.internal.t.i(dialogInterface, "dialogInterface");
        this$0.f23516k = (com.google.android.material.bottomsheet.a) dialogInterface;
        if (com.onetrust.otpublishers.headless.UI.mobiledatautils.c.i(this$0.getContext(), "OT_BANNERonCreateDialog")) {
            this$0.D(this$0.getResources().getConfiguration().orientation);
        }
        com.google.android.material.bottomsheet.a aVar = this$0.f23516k;
        if (aVar != null) {
        }
        com.google.android.material.bottomsheet.a aVar2 = this$0.f23516k;
        if (aVar2 != null) {
            aVar2.setCancelable(false);
        }
        com.google.android.material.bottomsheet.a aVar3 = this$0.f23516k;
        if (aVar3 != null) {
            aVar3.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.onetrust.otpublishers.headless.UI.fragment.h
                @Override // android.content.DialogInterface.OnKeyListener
                public final boolean onKey(DialogInterface dialogInterface2, int i10, KeyEvent keyEvent) {
                    return r.B(this.f23306a, dialogInterface2, i10, keyEvent);
                }
            });
        }
    }

    public static final void x(r this$0, View view) throws Throwable {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        this$0.A(OTConsentInteractionType.BANNER_CLOSE, true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:151:0x0265  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x037b  */
    /* JADX WARN: Removed duplicated region for block: B:229:0x038d  */
    /* JADX WARN: Removed duplicated region for block: B:290:0x0458  */
    /* JADX WARN: Removed duplicated region for block: B:321:0x04e4 A[PHI: r8 r11
      0x04e4: PHI (r8v89 'dpdDesc' java.lang.String) = (r8v88 'dpdDesc' java.lang.String), (r8v95 'dpdDesc' java.lang.String) binds: [B:320:0x04e2, B:317:0x04d6] A[DONT_GENERATE, DONT_INLINE]
      0x04e4: PHI (r11v12 java.lang.String) = (r11v11 java.lang.String), (r11v14 java.lang.String) binds: [B:320:0x04e2, B:317:0x04d6] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:322:0x0518 A[PHI: r11
      0x0518: PHI (r11v13 java.lang.String) = (r11v11 java.lang.String), (r11v14 java.lang.String) binds: [B:320:0x04e2, B:317:0x04d6] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:345:0x05b0  */
    /* JADX WARN: Removed duplicated region for block: B:347:0x05b3  */
    /* JADX WARN: Removed duplicated region for block: B:419:0x069a A[PHI: r12
      0x069a: PHI (r12v15 java.lang.String) = (r12v14 java.lang.String), (r12v22 java.lang.String) binds: [B:395:0x0658, B:414:0x0686] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:476:0x0761  */
    /* JADX WARN: Removed duplicated region for block: B:488:0x07dd  */
    /* JADX WARN: Removed duplicated region for block: B:508:0x0817  */
    /* JADX WARN: Removed duplicated region for block: B:510:0x081a  */
    /* JADX WARN: Type inference failed for: r3v37 */
    /* JADX WARN: Type inference failed for: r3v38, types: [android.view.View, android.widget.TextView, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v47 */
    /* JADX WARN: Type inference failed for: r3v48 */
    /* JADX WARN: Type inference failed for: r3v49 */
    /* JADX WARN: Type inference failed for: r8v71, types: [android.content.SharedPreferences] */
    /* JADX WARN: Type inference failed for: r8v72, types: [android.content.SharedPreferences] */
    /* JADX WARN: Type inference failed for: r8v75 */
    /* JADX WARN: Type inference failed for: r9v56, types: [android.content.SharedPreferences] */
    /* JADX WARN: Type inference failed for: r9v57, types: [android.content.SharedPreferences] */
    /* JADX WARN: Type inference failed for: r9v59 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void y(com.onetrust.otpublishers.headless.UI.fragment.r r32, com.onetrust.otpublishers.headless.UI.DataModels.a r33) {
        /*
            Method dump skipped, instruction units count: 2476
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onetrust.otpublishers.headless.UI.fragment.r.y(com.onetrust.otpublishers.headless.UI.fragment.r, com.onetrust.otpublishers.headless.UI.DataModels.a):void");
    }

    public static final void z(r this$0, com.onetrust.otpublishers.headless.UI.UIProperty.u otBannerUIProperty, View view) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        kotlin.jvm.internal.t.i(otBannerUIProperty, "$otBannerUIProperty");
        com.onetrust.otpublishers.headless.Internal.c.e(this$0.requireContext(), otBannerUIProperty.f22827l.f22788b);
    }

    public final void A(String type, boolean z10) throws Throwable {
        if (z10) {
            com.onetrust.otpublishers.headless.UI.viewmodel.a aVarC = C();
            aVarC.getClass();
            kotlin.jvm.internal.t.i(type, "type");
            aVarC.f23668a.saveConsent(type);
        }
        com.onetrust.otpublishers.headless.UI.Helper.l lVar = this.f23514i;
        com.onetrust.otpublishers.headless.Internal.Event.b bVar = new com.onetrust.otpublishers.headless.Internal.Event.b(2);
        com.onetrust.otpublishers.headless.Internal.Event.a aVar = this.f23510e;
        lVar.getClass();
        com.onetrust.otpublishers.headless.UI.Helper.l.s(bVar, aVar);
        com.onetrust.otpublishers.headless.Internal.Event.b bVar2 = new com.onetrust.otpublishers.headless.Internal.Event.b(17);
        bVar2.f21748d = type;
        com.onetrust.otpublishers.headless.UI.Helper.l lVar2 = this.f23514i;
        com.onetrust.otpublishers.headless.Internal.Event.a aVar2 = this.f23510e;
        lVar2.getClass();
        com.onetrust.otpublishers.headless.UI.Helper.l.s(bVar2, aVar2);
        dismiss();
    }

    public final com.onetrust.otpublishers.headless.UI.viewmodel.a C() {
        return (com.onetrust.otpublishers.headless.UI.viewmodel.a) this.f23509d.getValue();
    }

    public final void D(int i10) {
        com.onetrust.otpublishers.headless.UI.UIProperty.u uVar;
        com.google.android.material.bottomsheet.a aVar = this.f23516k;
        String str = null;
        FrameLayout frameLayout = aVar != null ? (FrameLayout) aVar.findViewById(p6.d.f32685f1) : null;
        if (frameLayout != null) {
            this.f23515j = BottomSheetBehavior.M(frameLayout);
            ViewGroup.LayoutParams layoutParams = frameLayout.getLayoutParams();
            kotlin.jvm.internal.t.h(layoutParams, "it.layoutParams");
            boolean z10 = true;
            int iB = com.onetrust.otpublishers.headless.UI.Helper.l.b(getContext(), true);
            layoutParams.height = iB;
            com.onetrust.otpublishers.headless.UI.DataModels.a value = C().f23670c.getValue();
            if (value != null && (uVar = value.f22057t) != null) {
                str = uVar.f22817b;
            }
            if (str != null && str.length() != 0) {
                z10 = false;
            }
            double d10 = 1.0d;
            if (!z10) {
                int iHashCode = str.hashCode();
                if (iHashCode != 288473524) {
                    if (iHashCode != 1945285198) {
                        if (iHashCode == 2002049644 && str.equals(OTBannerHeightRatio.ONE_HALF)) {
                            d10 = 0.5d;
                        }
                    } else if (str.equals(OTBannerHeightRatio.ONE_THIRD)) {
                        d10 = 0.33d;
                    }
                } else if (str.equals(OTBannerHeightRatio.TWO_THIRD)) {
                    d10 = 0.66d;
                }
            }
            if (2 != i10) {
                layoutParams.height = (int) (((double) iB) * d10);
            }
            frameLayout.setLayoutParams(layoutParams);
            BottomSheetBehavior<View> bottomSheetBehavior = this.f23515j;
            if (bottomSheetBehavior != null) {
                bottomSheetBehavior.n0(iB);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:132:0x032e  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x035b  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0369  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0372  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x039b  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x03b6  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x03ca  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x03cd  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x03e8  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x03eb  */
    @androidx.annotation.RequiresApi(17)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void F() throws org.json.JSONException {
        /*
            Method dump skipped, instruction units count: 1205
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onetrust.otpublishers.headless.UI.fragment.r.F():void");
    }

    public final void H() {
        l0 l0Var = this.f23513h;
        l0 l0Var2 = null;
        if (l0Var == null) {
            kotlin.jvm.internal.t.A("preferenceCenterFragment");
            l0Var = null;
        }
        if (l0Var.isAdded() || getActivity() == null) {
            return;
        }
        l0 l0Var3 = this.f23513h;
        if (l0Var3 == null) {
            kotlin.jvm.internal.t.A("preferenceCenterFragment");
        } else {
            l0Var2 = l0Var3;
        }
        com.onetrust.otpublishers.headless.UI.mobiledatautils.c.j(l0Var2, requireActivity(), OTFragmentTags.OT_PREFERENCE_CENTER_FRAGMENT_TAG);
        OTUIDisplayReason oTUIDisplayReason = new OTUIDisplayReason(210, OTUIDisplayReason.getResponseMessage(210));
        com.onetrust.otpublishers.headless.Internal.Event.b bVar = new com.onetrust.otpublishers.headless.Internal.Event.b(5);
        bVar.f21750f = oTUIDisplayReason;
        com.onetrust.otpublishers.headless.UI.Helper.l lVar = this.f23514i;
        com.onetrust.otpublishers.headless.Internal.Event.a aVar = this.f23510e;
        lVar.getClass();
        com.onetrust.otpublishers.headless.UI.Helper.l.s(bVar, aVar);
    }

    @Override // com.onetrust.otpublishers.headless.UI.a
    public final void a(int i10) {
        if (i10 == 1) {
            dismiss();
            return;
        }
        if (i10 != 2) {
            if (i10 != 3) {
                return;
            }
            m2.a aVar = m2.f23426o;
            com.onetrust.otpublishers.headless.Internal.Event.a aVar2 = this.f23510e;
            OTConfiguration oTConfiguration = this.f23511f;
            aVar.getClass();
            m2 m2VarA = m2.a.a(aVar2, oTConfiguration);
            m2VarA.u(C().f23668a);
            m2VarA.f23433g = this;
            this.f23512g = m2VarA;
            return;
        }
        com.onetrust.otpublishers.headless.Internal.Event.a aVar3 = this.f23510e;
        OTConfiguration oTConfiguration2 = this.f23511f;
        l0 l0Var = new l0();
        Bundle bundle = new Bundle();
        bundle.putString(OTFragmentTags.FRAGMENT_TAG, OTFragmentTags.OT_PREFERENCE_CENTER_FRAGMENT_TAG);
        l0Var.setArguments(bundle);
        l0Var.D = aVar3;
        l0Var.E = oTConfiguration2;
        kotlin.jvm.internal.t.h(l0Var, "newInstance(\n           …nfiguration\n            )");
        l0Var.C = this;
        l0Var.f23403z = C().f23668a;
        this.f23513h = l0Var;
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public final void onConfigurationChanged(@NotNull Configuration newConfig) {
        kotlin.jvm.internal.t.i(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        OTLogger.a("OTSDKBanner", 3, "onConfigurationChanged:");
        if (this.f23516k == null && getActivity() != null) {
            OTLogger.a("OTSDKBanner", 3, "onConfigurationChanged: null instance found, recreating bottomSheetDialog");
            SharedPreferences sharedPreferencesA = com.onetrust.otpublishers.headless.UI.fragment.a.a("com.onetrust.otpublishers.headless.preference", "OT_SDK_APP_CONFIGURATION", requireActivity(), 0);
            String str = OTThemeConstants.NO_SDK_THEME_OVERRIDE;
            String string = sharedPreferencesA.getString("OT_UX_SDK_THEME", OTThemeConstants.NO_SDK_THEME_OVERRIDE);
            if (!com.onetrust.otpublishers.headless.Internal.c.q(string)) {
                str = string;
            }
            this.f23516k = str.equals(OTThemeConstants.OT_SDK_UI_THEME) ? new com.google.android.material.bottomsheet.a(requireActivity(), p6.g.f32918a) : new com.google.android.material.bottomsheet.a(requireActivity());
        }
        D(newConfig.orientation);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setRetainInstance(true);
        Context context = getContext();
        if (com.onetrust.otpublishers.headless.UI.mobiledatautils.c.i(context, OTFragmentTags.OT_BANNER_FRAGMENT_TAG)) {
            SharedPreferences sharedPreferences = context.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOT_SDK_APP_CONFIGURATION", 0);
            String str = OTThemeConstants.NO_SDK_THEME_OVERRIDE;
            String string = sharedPreferences.getString("OT_UX_SDK_THEME", OTThemeConstants.NO_SDK_THEME_OVERRIDE);
            if (com.onetrust.otpublishers.headless.Internal.c.q(string)) {
                string = OTThemeConstants.NO_SDK_THEME_OVERRIDE;
            }
            if (!string.equals(OTThemeConstants.OT_SDK_UI_THEME)) {
                String string2 = context.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOT_SDK_APP_CONFIGURATION", 0).getString("OT_UX_SDK_THEME", OTThemeConstants.NO_SDK_THEME_OVERRIDE);
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
        dialogOnCreateDialog.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.onetrust.otpublishers.headless.UI.fragment.i
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                r.w(this.f23325a, dialogInterface);
            }
        });
        return dialogOnCreateDialog;
    }

    @Override // androidx.fragment.app.Fragment
    @NotNull
    public final View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        kotlin.jvm.internal.t.i(inflater, "inflater");
        com.onetrust.otpublishers.headless.UI.Helper.l lVar = this.f23514i;
        Context contextRequireContext = requireContext();
        int i10 = p6.e.f32868b;
        lVar.getClass();
        View viewC = com.onetrust.otpublishers.headless.UI.Helper.l.c(contextRequireContext, inflater, viewGroup, i10);
        kotlin.jvm.internal.t.h(viewC, "uiUtils.getOTView(requir…ayout.fragment_ot_banner)");
        return viewC;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        this.f23510e = null;
    }

    @Override // androidx.fragment.app.Fragment
    @RequiresApi(17)
    public final void onViewCreated(@NotNull View view, @Nullable Bundle bundle) throws JSONException {
        kotlin.jvm.internal.t.i(view, "view");
        super.onViewCreated(view, bundle);
        F();
        com.onetrust.otpublishers.headless.Internal.Event.a aVar = this.f23510e;
        OTConfiguration oTConfiguration = this.f23511f;
        l0 l0Var = new l0();
        Bundle bundle2 = new Bundle();
        bundle2.putString(OTFragmentTags.FRAGMENT_TAG, OTFragmentTags.OT_PREFERENCE_CENTER_FRAGMENT_TAG);
        l0Var.setArguments(bundle2);
        l0Var.D = aVar;
        l0Var.E = oTConfiguration;
        kotlin.jvm.internal.t.h(l0Var, "newInstance(\n           …otConfiguration\n        )");
        l0Var.C = this;
        l0Var.f23403z = C().f23668a;
        this.f23513h = l0Var;
        m2.a aVar2 = m2.f23426o;
        com.onetrust.otpublishers.headless.Internal.Event.a aVar3 = this.f23510e;
        OTConfiguration oTConfiguration2 = this.f23511f;
        aVar2.getClass();
        m2 m2VarA = m2.a.a(aVar3, oTConfiguration2);
        m2VarA.f23433g = this;
        m2VarA.u(C().f23668a);
        this.f23512g = m2VarA;
    }

    public final com.onetrust.otpublishers.headless.databinding.a t() {
        return (com.onetrust.otpublishers.headless.databinding.a) this.f23508c.a(this, f23506m[0]);
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x013a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void u(com.onetrust.otpublishers.headless.UI.DataModels.a r25, com.onetrust.otpublishers.headless.UI.UIProperty.u r26, com.onetrust.otpublishers.headless.UI.UIProperty.v r27) {
        /*
            Method dump skipped, instruction units count: 941
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onetrust.otpublishers.headless.UI.fragment.r.u(com.onetrust.otpublishers.headless.UI.DataModels.a, com.onetrust.otpublishers.headless.UI.UIProperty.u, com.onetrust.otpublishers.headless.UI.UIProperty.v):void");
    }

    public final void v(final com.onetrust.otpublishers.headless.UI.UIProperty.u uVar) {
        com.onetrust.otpublishers.headless.databinding.a aVarT = t();
        aVarT.f23719l.setOnClickListener(new View.OnClickListener() { // from class: com.onetrust.otpublishers.headless.UI.fragment.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws Throwable {
                r.J(this.f23370a, view);
            }
        });
        aVarT.f23727t.setOnClickListener(new View.OnClickListener() { // from class: com.onetrust.otpublishers.headless.UI.fragment.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                r.K(this.f23374a, view);
            }
        });
        aVarT.f23726s.setOnClickListener(new View.OnClickListener() { // from class: com.onetrust.otpublishers.headless.UI.fragment.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                r.L(this.f23378a, view);
            }
        });
        aVarT.f23729v.setOnClickListener(new View.OnClickListener() { // from class: com.onetrust.otpublishers.headless.UI.fragment.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                r.M(this.f23423a, view);
            }
        });
        aVarT.f23720m.setOnClickListener(new View.OnClickListener() { // from class: com.onetrust.otpublishers.headless.UI.fragment.n
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws Throwable {
                r.N(this.f23448a, view);
            }
        });
        aVarT.f23725r.setOnClickListener(new View.OnClickListener() { // from class: com.onetrust.otpublishers.headless.UI.fragment.o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                r.z(this.f23452a, uVar, view);
            }
        });
        aVarT.f23730w.setOnClickListener(new View.OnClickListener() { // from class: com.onetrust.otpublishers.headless.UI.fragment.p
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws Throwable {
                r.x(this.f23473a, view);
            }
        });
        aVarT.f23722o.setOnClickListener(new View.OnClickListener() { // from class: com.onetrust.otpublishers.headless.UI.fragment.q
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws Throwable {
                r.E(this.f23501a, view);
            }
        });
        aVarT.f23724q.setOnClickListener(new View.OnClickListener() { // from class: com.onetrust.otpublishers.headless.UI.fragment.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws Throwable {
                r.G(this.f23296a, view);
            }
        });
        aVarT.f23723p.setOnClickListener(new View.OnClickListener() { // from class: com.onetrust.otpublishers.headless.UI.fragment.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws Throwable {
                r.I(this.f23301a, view);
            }
        });
    }
}
