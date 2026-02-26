package com.onetrust.otpublishers.headless.UI.TVUI.fragments;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.fragment.app.FragmentActivity;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import com.onetrust.otpublishers.headless.Public.DataModel.OTConfiguration;
import com.onetrust.otpublishers.headless.Public.Keys.OTFragmentTags;
import com.onetrust.otpublishers.headless.Public.OTConsentInteractionType;
import com.onetrust.otpublishers.headless.Public.OTPublishersHeadlessSDK;
import com.onetrust.otpublishers.headless.Public.OTVendorListMode;
import com.onetrust.otpublishers.headless.UI.TVUI.fragments.b;
import com.onetrust.otpublishers.headless.UI.TVUI.fragments.f0;
import com.onetrust.otpublishers.headless.UI.TVUI.fragments.q;
import com.onetrust.otpublishers.headless.UI.TVUI.fragments.u;
import java.util.HashMap;

/* JADX INFO: loaded from: classes4.dex */
public class k extends com.google.android.material.bottomsheet.b implements q.a, b.a, f0.a, u.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public BottomSheetBehavior<View> f22568b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public FrameLayout f22569c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public com.google.android.material.bottomsheet.a f22570d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public FragmentActivity f22571e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public OTPublishersHeadlessSDK f22572f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public com.onetrust.otpublishers.headless.Internal.Event.a f22573g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f22574h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public com.onetrust.otpublishers.headless.UI.Helper.l f22575i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f22576j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public b f22577k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public OTConfiguration f22578l;

    /* JADX INFO: Access modifiers changed from: private */
    public void w(DialogInterface dialogInterface) {
        com.google.android.material.bottomsheet.a aVar = (com.google.android.material.bottomsheet.a) dialogInterface;
        this.f22570d = aVar;
        if (getActivity() != null && aVar == null) {
            OTLogger.a("OTTV", 3, "setupFullHeight: null instance found, recreating bottomSheetDialog");
            aVar = new com.google.android.material.bottomsheet.a(getActivity());
        }
        FrameLayout frameLayout = (FrameLayout) aVar.findViewById(p6.d.f32685f1);
        this.f22569c = frameLayout;
        if (frameLayout != null) {
            this.f22568b = BottomSheetBehavior.M(frameLayout);
            ViewGroup.LayoutParams layoutParams = this.f22569c.getLayoutParams();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            if (getActivity() != null) {
                getActivity().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            } else {
                OTLogger.a("OneTrust", 6, "TV: getActivity() returned null");
            }
            int i10 = displayMetrics.heightPixels;
            if (layoutParams != null) {
                layoutParams.height = i10;
            }
            this.f22569c.setLayoutParams(layoutParams);
            this.f22568b.s0(3);
        }
        FrameLayout frameLayout2 = (FrameLayout) this.f22570d.findViewById(e4.f.f24825f);
        this.f22569c = frameLayout2;
        if (frameLayout2 != null) {
            this.f22568b = BottomSheetBehavior.M(frameLayout2);
        }
        this.f22570d.setCancelable(false);
        this.f22570d.setCanceledOnTouchOutside(false);
        this.f22568b.r0(true);
        this.f22568b.k0(false);
        BottomSheetBehavior<View> bottomSheetBehavior = this.f22568b;
        DisplayMetrics displayMetrics2 = new DisplayMetrics();
        if (getActivity() != null) {
            getActivity().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics2);
        } else {
            OTLogger.a("OneTrust", 6, "TV: getActivity() returned null");
        }
        bottomSheetBehavior.n0(displayMetrics2.heightPixels);
        this.f22570d.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.onetrust.otpublishers.headless.UI.TVUI.fragments.j
            @Override // android.content.DialogInterface.OnKeyListener
            public final boolean onKey(DialogInterface dialogInterface2, int i11, KeyEvent keyEvent) {
                return this.f22567a.z(dialogInterface2, i11, keyEvent);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(String str, int i10) throws Throwable {
        OTLogger.a("OneTrust", 4, "Saving Consent on BG thread");
        this.f22572f.saveConsent(str);
        com.onetrust.otpublishers.headless.UI.Helper.l lVar = this.f22575i;
        com.onetrust.otpublishers.headless.Internal.Event.b bVar = new com.onetrust.otpublishers.headless.Internal.Event.b(i10);
        com.onetrust.otpublishers.headless.Internal.Event.a aVar = this.f22573g;
        lVar.getClass();
        com.onetrust.otpublishers.headless.UI.Helper.l.s(bVar, aVar);
        com.onetrust.otpublishers.headless.Internal.Event.b bVar2 = new com.onetrust.otpublishers.headless.Internal.Event.b(17);
        bVar2.f21748d = str;
        com.onetrust.otpublishers.headless.UI.Helper.l lVar2 = this.f22575i;
        com.onetrust.otpublishers.headless.Internal.Event.a aVar2 = this.f22573g;
        lVar2.getClass();
        com.onetrust.otpublishers.headless.UI.Helper.l.s(bVar2, aVar2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean z(DialogInterface dialogInterface, int i10, KeyEvent keyEvent) {
        if (i10 != 4 || keyEvent.getAction() != 1) {
            return false;
        }
        a();
        return false;
    }

    public final void A(@NonNull final String str, final int i10) {
        new Thread(new Runnable() { // from class: com.onetrust.otpublishers.headless.UI.TVUI.fragments.i
            @Override // java.lang.Runnable
            public final void run() throws Throwable {
                this.f22564a.x(str, i10);
            }
        }).start();
        dismiss();
    }

    public final void a() {
        String str;
        int i10 = this.f22576j;
        String str2 = OTConsentInteractionType.PC_CLOSE;
        if (i10 == 0) {
            com.onetrust.otpublishers.headless.UI.Helper.l lVar = this.f22575i;
            com.onetrust.otpublishers.headless.Internal.Event.b bVar = new com.onetrust.otpublishers.headless.Internal.Event.b(2);
            com.onetrust.otpublishers.headless.Internal.Event.a aVar = this.f22573g;
            lVar.getClass();
            com.onetrust.otpublishers.headless.UI.Helper.l.s(bVar, aVar);
            str = OTConsentInteractionType.BANNER_CLOSE;
        } else {
            str = OTConsentInteractionType.PC_CLOSE;
        }
        if (this.f22576j == 1) {
            com.onetrust.otpublishers.headless.UI.Helper.l lVar2 = this.f22575i;
            com.onetrust.otpublishers.headless.Internal.Event.b bVar2 = new com.onetrust.otpublishers.headless.Internal.Event.b(6);
            com.onetrust.otpublishers.headless.Internal.Event.a aVar2 = this.f22573g;
            lVar2.getClass();
            com.onetrust.otpublishers.headless.UI.Helper.l.s(bVar2, aVar2);
            this.f22576j = 0;
        } else {
            str2 = str;
        }
        if (this.f22576j == 3) {
            com.onetrust.otpublishers.headless.UI.Helper.l lVar3 = this.f22575i;
            com.onetrust.otpublishers.headless.Internal.Event.b bVar3 = new com.onetrust.otpublishers.headless.Internal.Event.b(13);
            com.onetrust.otpublishers.headless.Internal.Event.a aVar3 = this.f22573g;
            lVar3.getClass();
            com.onetrust.otpublishers.headless.UI.Helper.l.s(bVar3, aVar3);
            this.f22576j = 0;
        }
        int i11 = this.f22576j;
        if (i11 == 4 || 5 == i11) {
            com.onetrust.otpublishers.headless.UI.Helper.l lVar4 = this.f22575i;
            com.onetrust.otpublishers.headless.Internal.Event.b bVar4 = new com.onetrust.otpublishers.headless.Internal.Event.b(13);
            com.onetrust.otpublishers.headless.Internal.Event.a aVar4 = this.f22573g;
            lVar4.getClass();
            com.onetrust.otpublishers.headless.UI.Helper.l.s(bVar4, aVar4);
            this.f22576j = 1;
        }
        if (this.f22576j == 6) {
            com.onetrust.otpublishers.headless.UI.Helper.l lVar5 = this.f22575i;
            com.onetrust.otpublishers.headless.Internal.Event.b bVar5 = new com.onetrust.otpublishers.headless.Internal.Event.b(26);
            com.onetrust.otpublishers.headless.Internal.Event.a aVar5 = this.f22573g;
            lVar5.getClass();
            com.onetrust.otpublishers.headless.UI.Helper.l.s(bVar5, aVar5);
            this.f22576j = 1;
        }
        if (!str2.equals(OTConsentInteractionType.BANNER_CLOSE)) {
            getChildFragmentManager().popBackStack();
        }
        if (getChildFragmentManager().getBackStackEntryCount() > 1 || str2.equals(OTConsentInteractionType.BANNER_CLOSE)) {
            return;
        }
        com.onetrust.otpublishers.headless.Internal.Event.b bVar6 = new com.onetrust.otpublishers.headless.Internal.Event.b(17);
        bVar6.f21748d = str2;
        com.onetrust.otpublishers.headless.UI.Helper.l lVar6 = this.f22575i;
        com.onetrust.otpublishers.headless.Internal.Event.a aVar6 = this.f22573g;
        lVar6.getClass();
        com.onetrust.otpublishers.headless.UI.Helper.l.s(bVar6, aVar6);
        dismiss();
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public final void onConfigurationChanged(@NonNull Configuration configuration) {
        super.onConfigurationChanged(configuration);
        com.google.android.material.bottomsheet.a aVar = this.f22570d;
        if (getActivity() != null && aVar == null) {
            OTLogger.a("OTTV", 3, "setupFullHeight: null instance found, recreating bottomSheetDialog");
            aVar = new com.google.android.material.bottomsheet.a(getActivity());
        }
        FrameLayout frameLayout = (FrameLayout) aVar.findViewById(p6.d.f32685f1);
        this.f22569c = frameLayout;
        if (frameLayout != null) {
            this.f22568b = BottomSheetBehavior.M(frameLayout);
            ViewGroup.LayoutParams layoutParams = this.f22569c.getLayoutParams();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            if (getActivity() != null) {
                getActivity().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            } else {
                OTLogger.a("OneTrust", 6, "TV: getActivity() returned null");
            }
            int i10 = displayMetrics.heightPixels;
            if (layoutParams != null) {
                layoutParams.height = i10;
            }
            this.f22569c.setLayoutParams(layoutParams);
            this.f22568b.s0(3);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00c5  */
    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onCreate(@androidx.annotation.Nullable android.os.Bundle r7) {
        /*
            Method dump skipped, instruction units count: 352
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onetrust.otpublishers.headless.UI.TVUI.fragments.k.onCreate(android.os.Bundle):void");
    }

    @Override // com.google.android.material.bottomsheet.b, androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    @NonNull
    public final Dialog onCreateDialog(Bundle bundle) {
        Dialog dialogOnCreateDialog = super.onCreateDialog(bundle);
        dialogOnCreateDialog.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.onetrust.otpublishers.headless.UI.TVUI.fragments.h
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                this.f22563a.w(dialogInterface);
            }
        });
        return dialogOnCreateDialog;
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        FragmentActivity fragmentActivity = this.f22571e;
        int i10 = p6.e.f32887u;
        if (com.onetrust.otpublishers.headless.Internal.c.x(fragmentActivity)) {
            layoutInflater = layoutInflater.cloneInContext(new ContextThemeWrapper(fragmentActivity, p6.g.f32919b));
        }
        return layoutInflater.inflate(i10, viewGroup, false);
    }

    public final void y(@Nullable HashMap map, boolean z10, boolean z11) {
        com.onetrust.otpublishers.headless.UI.Helper.l lVar = this.f22575i;
        com.onetrust.otpublishers.headless.Internal.Event.b bVar = new com.onetrust.otpublishers.headless.Internal.Event.b(12);
        com.onetrust.otpublishers.headless.Internal.Event.a aVar = this.f22573g;
        lVar.getClass();
        com.onetrust.otpublishers.headless.UI.Helper.l.s(bVar, aVar);
        com.onetrust.otpublishers.headless.Internal.Event.a aVar2 = this.f22573g;
        OTPublishersHeadlessSDK oTPublishersHeadlessSDK = this.f22572f;
        OTConfiguration oTConfiguration = this.f22578l;
        f0 f0Var = new f0();
        Bundle bundle = new Bundle();
        bundle.putString("TV_PC_CONTENT", OTFragmentTags.OT_VENDOR_LIST_FRAGMENT_TAG);
        f0Var.setArguments(bundle);
        f0Var.f22512d = aVar2;
        f0Var.f22511c = this;
        f0Var.f22510b = oTPublishersHeadlessSDK;
        f0Var.f22523o = oTPublishersHeadlessSDK.getOtVendorUtils();
        f0Var.f22522n = z10;
        f0Var.f22521m = map;
        f0Var.H = OTVendorListMode.IAB;
        f0Var.J = oTConfiguration;
        if (z11) {
            f0Var.H = "google";
        }
        getChildFragmentManager().beginTransaction().replace(p6.d.W5, f0Var).addToBackStack(OTFragmentTags.OT_VENDOR_LIST_FRAGMENT_TAG).commit();
    }

    public final void a(int i10) {
        if (i10 == 14) {
            A(OTConsentInteractionType.PC_CONFIRM, 10);
        }
        if (i10 == 11) {
            A(OTConsentInteractionType.BANNER_ALLOW_ALL, 3);
        }
        if (i10 == 12) {
            A(OTConsentInteractionType.BANNER_REJECT_ALL, 4);
        }
        if (i10 == 21) {
            A(OTConsentInteractionType.PC_ALLOW_ALL, 8);
        }
        if (i10 == 22) {
            A(OTConsentInteractionType.PC_REJECT_ALL, 9);
        }
        if (i10 == 13) {
            A(OTConsentInteractionType.BANNER_CLOSE, 2);
        }
        if (i10 == 16) {
            A(OTConsentInteractionType.BANNER_CONTINUE_WITHOUT_ACCEPTING, 2);
        }
        if (i10 == 15) {
            this.f22576j = 3;
            b bVar = this.f22577k;
            if (bVar != null && bVar.getArguments() != null) {
                this.f22577k.getArguments().putInt("OT_TV_FOCUSED_BTN", 2);
            }
            y(null, false, false);
        }
        if (i10 == 17) {
            this.f22576j = 5;
            y(null, false, false);
        }
        if (i10 == 18) {
            this.f22576j = 4;
            y(null, false, true);
        }
        if (i10 == 32) {
            A(OTConsentInteractionType.VENDOR_LIST_REJECT_ALL, 20);
        }
        if (i10 == 31) {
            A(OTConsentInteractionType.VENDOR_LIST_ALLOW_ALL, 19);
        }
        if (i10 == 33) {
            A(OTConsentInteractionType.VENDOR_LIST_CONFIRM, 14);
        }
        if (i10 == 23) {
            a();
        }
        if (i10 == 42) {
            A(OTConsentInteractionType.SDK_LIST_REJECT_ALL, 22);
        }
        if (i10 == 41) {
            A(OTConsentInteractionType.SDK_LIST_ALLOW_ALL, 21);
        }
        if (i10 == 43) {
            A(OTConsentInteractionType.SDK_LIST_CONFIRM, 23);
        }
    }
}
