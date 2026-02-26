package com.onetrust.otpublishers.headless.UI.fragment;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import com.onetrust.otpublishers.headless.Public.DataModel.OTConfiguration;
import com.onetrust.otpublishers.headless.Public.Keys.OTFragmentTags;
import com.onetrust.otpublishers.headless.Public.OTPublishersHeadlessSDK;
import com.onetrust.otpublishers.headless.Public.OTThemeConstants;
import com.onetrust.otpublishers.headless.UI.adapter.p;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class o0 extends com.google.android.material.bottomsheet.b implements p.a, View.OnClickListener, com.onetrust.otpublishers.headless.UI.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f23454b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public RecyclerView f23455c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Button f23456d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public com.google.android.material.bottomsheet.a f23457e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public com.onetrust.otpublishers.headless.UI.adapter.p f23458f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public RelativeLayout f23459g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Context f23460h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public RelativeLayout f23461i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public OTPublishersHeadlessSDK f23462j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public a f23463k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Map<String, String> f23464l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Map<String, String> f23465m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public com.onetrust.otpublishers.headless.UI.UIProperty.d0 f23466n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public OTConfiguration f23467o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public View f23468p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public com.onetrust.otpublishers.headless.UI.mobiledatautils.c f23469q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public String f23470r;

    public interface a {
        void a(@NonNull Map<String, String> map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void v(DialogInterface dialogInterface) {
        com.google.android.material.bottomsheet.a aVar = (com.google.android.material.bottomsheet.a) dialogInterface;
        this.f23457e = aVar;
        com.onetrust.otpublishers.headless.UI.mobiledatautils.c cVar = this.f23469q;
        Context context = this.f23460h;
        cVar.getClass();
        com.onetrust.otpublishers.headless.UI.mobiledatautils.c.a(context, aVar);
        this.f23457e.setCancelable(false);
        this.f23457e.setCanceledOnTouchOutside(false);
        this.f23457e.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.onetrust.otpublishers.headless.UI.fragment.n0
            @Override // android.content.DialogInterface.OnKeyListener
            public final boolean onKey(DialogInterface dialogInterface2, int i10, KeyEvent keyEvent) {
                return this.f23449a.w(dialogInterface2, i10, keyEvent);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x000c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean w(android.content.DialogInterface r2, int r3, android.view.KeyEvent r4) {
        /*
            r1 = this;
            r2 = 4
            r0 = 0
            if (r3 != r2) goto Lc
            int r2 = r4.getAction()
            r3 = 1
            if (r2 != r3) goto Lc
            goto Ld
        Lc:
            r3 = r0
        Ld:
            if (r3 == 0) goto L16
            java.util.Map<java.lang.String, java.lang.String> r2 = r1.f23464l
            r1.f23465m = r2
            r1.dismiss()
        L16:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onetrust.otpublishers.headless.UI.fragment.o0.w(android.content.DialogInterface, int, android.view.KeyEvent):boolean");
    }

    @Override // com.onetrust.otpublishers.headless.UI.a
    public final void a(int i10) {
        if (i10 == 1) {
            a aVar = this.f23463k;
            com.onetrust.otpublishers.headless.UI.adapter.p pVar = this.f23458f;
            OTLogger.a("OneTrust", 4, "Purposes to pass on apply filters : " + pVar.f23096l);
            aVar.a(pVar.f23096l);
            dismiss();
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int id = view.getId();
        if (id != p6.d.f32765o0) {
            if (id == p6.d.P2) {
                this.f23465m = this.f23464l;
                dismiss();
                return;
            }
            return;
        }
        a aVar = this.f23463k;
        com.onetrust.otpublishers.headless.UI.adapter.p pVar = this.f23458f;
        OTLogger.a("OneTrust", 4, "Purposes to pass on apply filters : " + pVar.f23096l);
        aVar.a(pVar.f23096l);
        dismiss();
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public final void onConfigurationChanged(@NonNull Configuration configuration) {
        super.onConfigurationChanged(configuration);
        com.onetrust.otpublishers.headless.UI.mobiledatautils.c cVar = this.f23469q;
        Context context = this.f23460h;
        com.google.android.material.bottomsheet.a aVar = this.f23457e;
        cVar.getClass();
        com.onetrust.otpublishers.headless.UI.mobiledatautils.c.a(context, aVar);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setRetainInstance(true);
        if (this.f23462j == null) {
            dismiss();
        }
        FragmentActivity activity = getActivity();
        if (com.onetrust.otpublishers.headless.UI.mobiledatautils.c.i(activity, OTFragmentTags.OT_VENDOR_LIST_FILTER_FRAGMENT_TAG)) {
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
    @NonNull
    public final Dialog onCreateDialog(Bundle bundle) {
        Dialog dialogOnCreateDialog = super.onCreateDialog(bundle);
        dialogOnCreateDialog.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.onetrust.otpublishers.headless.UI.fragment.m0
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                this.f23424a.v(dialogInterface);
            }
        });
        return dialogOnCreateDialog;
    }

    /* JADX WARN: Removed duplicated region for block: B:81:0x01f7 A[Catch: JSONException -> 0x020d, TryCatch #3 {JSONException -> 0x020d, blocks: (B:78:0x01ed, B:79:0x01f1, B:81:0x01f7, B:83:0x0207), top: B:141:0x01ed }] */
    @Override // androidx.fragment.app.Fragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.view.View onCreateView(@androidx.annotation.NonNull android.view.LayoutInflater r18, android.view.ViewGroup r19, android.os.Bundle r20) {
        /*
            Method dump skipped, instruction units count: 862
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onetrust.otpublishers.headless.UI.fragment.o0.onCreateView(android.view.LayoutInflater, android.view.ViewGroup, android.os.Bundle):android.view.View");
    }
}
