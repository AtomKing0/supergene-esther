package com.onetrust.otpublishers.headless.UI.fragment;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import com.onetrust.otpublishers.headless.Public.DataModel.OTConfiguration;
import com.onetrust.otpublishers.headless.Public.DataModel.OTCustomConfigurator;
import com.onetrust.otpublishers.headless.Public.DataModel.OTProxyType;
import com.onetrust.otpublishers.headless.Public.Keys.OTFragmentTags;
import com.onetrust.otpublishers.headless.Public.OTConsentUICallback;
import com.onetrust.otpublishers.headless.Public.OTPublishersHeadlessSDK;
import com.onetrust.otpublishers.headless.Public.OTThemeConstants;
import java.net.MalformedURLException;
import java.net.URL;
import org.json.JSONException;

/* JADX INFO: loaded from: classes4.dex */
public class d extends com.google.android.material.bottomsheet.b implements View.OnClickListener, com.onetrust.otpublishers.headless.UI.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Context f23271b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f23272c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f23273d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Button f23274e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Button f23275f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ImageView f23276g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public com.google.android.material.bottomsheet.a f23277h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public RelativeLayout f23278i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public TextView f23279j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public com.onetrust.otpublishers.headless.UI.Helper.l f23280k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public OTConfiguration f23281l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public OTPublishersHeadlessSDK f23282m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public com.onetrust.otpublishers.headless.UI.UIProperty.s f23283n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public OTConsentUICallback f23284o;

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u(DialogInterface dialogInterface) {
        this.f23277h = (com.google.android.material.bottomsheet.a) dialogInterface;
        com.onetrust.otpublishers.headless.UI.Helper.l lVar = this.f23280k;
        FragmentActivity activity = getActivity();
        com.google.android.material.bottomsheet.a aVar = this.f23277h;
        lVar.getClass();
        com.onetrust.otpublishers.headless.UI.Helper.l.r(activity, aVar);
        this.f23277h.setCancelable(false);
        this.f23277h.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.onetrust.otpublishers.headless.UI.fragment.c
            @Override // android.content.DialogInterface.OnKeyListener
            public final boolean onKey(DialogInterface dialogInterface2, int i10, KeyEvent keyEvent) {
                return d.w(dialogInterface2, i10, keyEvent);
            }
        });
    }

    public static /* synthetic */ boolean w(DialogInterface dialogInterface, int i10, KeyEvent keyEvent) {
        return true;
    }

    @Override // com.onetrust.otpublishers.headless.UI.a
    public final void a(int i10) {
        dismiss();
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        OTConsentUICallback oTConsentUICallback;
        int id = view.getId();
        com.onetrust.otpublishers.headless.Internal.Helper.b bVar = new com.onetrust.otpublishers.headless.Internal.Helper.b(this.f23271b);
        if (id == p6.d.f32729k0) {
            bVar.a("OPT_IN");
            dismiss();
            OTLogger.a("OTAgeGateFragment", 3, "Age-Gate Consent Status: " + this.f23282m.getAgeGatePromptValue());
            oTConsentUICallback = this.f23284o;
            if (oTConsentUICallback == null) {
                return;
            }
        } else {
            if (id != p6.d.f32792r0) {
                return;
            }
            bVar.a("OPT_OUT");
            dismiss();
            OTLogger.a("OTAgeGateFragment", 3, "Age-Gate Consent Status: " + this.f23282m.getAgeGatePromptValue());
            oTConsentUICallback = this.f23284o;
            if (oTConsentUICallback == null) {
                return;
            }
        }
        oTConsentUICallback.onCompletion();
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public final void onConfigurationChanged(@NonNull Configuration configuration) {
        super.onConfigurationChanged(configuration);
        com.onetrust.otpublishers.headless.UI.Helper.l lVar = this.f23280k;
        FragmentActivity activity = getActivity();
        com.google.android.material.bottomsheet.a aVar = this.f23277h;
        lVar.getClass();
        com.onetrust.otpublishers.headless.UI.Helper.l.r(activity, aVar);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setRetainInstance(true);
        this.f23282m = new OTPublishersHeadlessSDK(getContext().getApplicationContext());
        FragmentActivity activity = getActivity();
        if (com.onetrust.otpublishers.headless.UI.mobiledatautils.c.i(activity, OTFragmentTags.OT_AGE_GATE_FRAGMENT_TAG)) {
            SharedPreferences sharedPreferencesA = a.a("com.onetrust.otpublishers.headless.preference", "OT_SDK_APP_CONFIGURATION", activity, 0);
            String str = OTThemeConstants.NO_SDK_THEME_OVERRIDE;
            String string = sharedPreferencesA.getString("OT_UX_SDK_THEME", OTThemeConstants.NO_SDK_THEME_OVERRIDE);
            if (com.onetrust.otpublishers.headless.Internal.c.q(string)) {
                string = OTThemeConstants.NO_SDK_THEME_OVERRIDE;
            }
            if (!string.equals(OTThemeConstants.OT_SDK_UI_THEME)) {
                String string2 = a.a("com.onetrust.otpublishers.headless.preference", "OT_SDK_APP_CONFIGURATION", activity, 0).getString("OT_UX_SDK_THEME", OTThemeConstants.NO_SDK_THEME_OVERRIDE);
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
        dialogOnCreateDialog.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.onetrust.otpublishers.headless.UI.fragment.b
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                this.f23246a.u(dialogInterface);
            }
        });
        return dialogOnCreateDialog;
    }

    @Override // androidx.fragment.app.Fragment
    @RequiresApi(api = 17)
    public final View onCreateView(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f23271b = getContext();
        com.onetrust.otpublishers.headless.UI.mobiledatautils.d dVar = new com.onetrust.otpublishers.headless.UI.mobiledatautils.d();
        if (!dVar.l(com.onetrust.otpublishers.headless.UI.Helper.l.a(this.f23271b, this.f23281l), this.f23271b, this.f23282m)) {
            dismiss();
            return null;
        }
        this.f23280k = new com.onetrust.otpublishers.headless.UI.Helper.l();
        View viewC = com.onetrust.otpublishers.headless.UI.Helper.l.c(this.f23271b, layoutInflater, viewGroup, p6.e.f32867a);
        this.f23274e = (Button) viewC.findViewById(p6.d.f32729k0);
        this.f23275f = (Button) viewC.findViewById(p6.d.f32792r0);
        this.f23278i = (RelativeLayout) viewC.findViewById(p6.d.A);
        this.f23272c = (TextView) viewC.findViewById(p6.d.B);
        this.f23273d = (TextView) viewC.findViewById(p6.d.f32851y);
        this.f23276g = (ImageView) viewC.findViewById(p6.d.f32859z);
        this.f23279j = (TextView) viewC.findViewById(p6.d.f32808s7);
        this.f23274e.setOnClickListener(this);
        this.f23275f.setOnClickListener(this);
        try {
            this.f23283n = new com.onetrust.otpublishers.headless.UI.UIProperty.b0(this.f23271b).a();
        } catch (JSONException e10) {
            com.onetrust.otpublishers.headless.Internal.Helper.p.a(e10, new StringBuilder("Error in ui property object, error message = "), "OTAgeGateFragment", 6);
        }
        try {
            a();
            dVar.d(this.f23279j, this.f23281l);
        } catch (JSONException e11) {
            com.onetrust.otpublishers.headless.Internal.Helper.p.a(e11, new StringBuilder("error while populating Age-Gate UI "), "OTAgeGateFragment", 6);
        }
        return viewC;
    }

    public final void v(@NonNull Button button, @NonNull com.onetrust.otpublishers.headless.UI.UIProperty.f fVar, int i10, int i11) {
        com.onetrust.otpublishers.headless.UI.UIProperty.l lVar = fVar.f22758a;
        com.onetrust.otpublishers.headless.UI.Helper.l lVar2 = this.f23280k;
        OTConfiguration oTConfiguration = this.f23281l;
        lVar2.getClass();
        com.onetrust.otpublishers.headless.UI.Helper.l.m(button, lVar, oTConfiguration);
        if (!com.onetrust.otpublishers.headless.Internal.c.q(lVar.f22783b)) {
            button.setTextSize(Float.parseFloat(lVar.f22783b));
        }
        button.setText(fVar.a());
        if (!com.onetrust.otpublishers.headless.Internal.c.q(fVar.c())) {
            i11 = Color.parseColor(fVar.c());
        } else if (button.equals(this.f23275f)) {
            i11 = ContextCompat.getColor(this.f23271b, p6.a.f32623a);
        }
        button.setTextColor(i11);
        if (!com.onetrust.otpublishers.headless.Internal.c.q(fVar.f22759b)) {
            com.onetrust.otpublishers.headless.UI.Helper.l.i(this.f23271b, button, fVar, fVar.f22759b, fVar.f22761d);
            return;
        }
        if (!button.equals(this.f23275f)) {
            button.setBackgroundColor(i10);
            return;
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setStroke(Integer.parseInt(ExifInterface.GPS_MEASUREMENT_3D), ContextCompat.getColor(this.f23271b, p6.a.f32623a));
        gradientDrawable.setColor(ContextCompat.getColor(this.f23271b, p6.a.f32628f));
        button.setBackground(gradientDrawable);
    }

    public final void a() {
        RelativeLayout relativeLayout;
        int color;
        String proxyDomainURLString;
        com.onetrust.otpublishers.headless.UI.UIProperty.s sVar = this.f23283n;
        if (sVar != null) {
            if (com.onetrust.otpublishers.headless.Internal.c.q(sVar.f22806d)) {
                relativeLayout = this.f23278i;
                color = ContextCompat.getColor(this.f23271b, p6.a.f32628f);
            } else {
                relativeLayout = this.f23278i;
                color = Color.parseColor(this.f23283n.f22806d);
            }
            relativeLayout.setBackgroundColor(color);
            int color2 = ContextCompat.getColor(this.f23271b, p6.a.f32626d);
            int color3 = ContextCompat.getColor(this.f23271b, p6.a.f32628f);
            com.onetrust.otpublishers.headless.UI.UIProperty.c cVar = this.f23283n.f22807e;
            String str = !com.onetrust.otpublishers.headless.Internal.c.q(cVar.f22722c) ? cVar.f22722c : "";
            TextView textView = this.f23272c;
            com.onetrust.otpublishers.headless.UI.UIProperty.l lVar = cVar.f22720a;
            textView.setText(cVar.f22724e);
            com.onetrust.otpublishers.headless.UI.UIProperty.l lVar2 = cVar.f22720a;
            com.onetrust.otpublishers.headless.UI.Helper.l lVar3 = this.f23280k;
            OTConfiguration oTConfiguration = this.f23281l;
            lVar3.getClass();
            com.onetrust.otpublishers.headless.UI.Helper.l.p(textView, lVar2, oTConfiguration);
            if (!com.onetrust.otpublishers.headless.Internal.c.q(lVar.f22783b)) {
                textView.setTextSize(Float.parseFloat(lVar.f22783b));
            }
            com.onetrust.otpublishers.headless.UI.Helper.l.q(textView, cVar.f22721b);
            textView.setTextColor(!com.onetrust.otpublishers.headless.Internal.c.q(str) ? Color.parseColor(str) : ContextCompat.getColor(this.f23271b, p6.a.f32623a));
            com.onetrust.otpublishers.headless.UI.UIProperty.c cVar2 = this.f23283n.f22808f;
            String str2 = com.onetrust.otpublishers.headless.Internal.c.q(cVar2.f22722c) ? "" : cVar2.f22722c;
            TextView textView2 = this.f23273d;
            com.onetrust.otpublishers.headless.UI.UIProperty.l lVar4 = cVar2.f22720a;
            textView2.setText(cVar2.f22724e);
            com.onetrust.otpublishers.headless.UI.UIProperty.l lVar5 = cVar2.f22720a;
            com.onetrust.otpublishers.headless.UI.Helper.l lVar6 = this.f23280k;
            OTConfiguration oTConfiguration2 = this.f23281l;
            lVar6.getClass();
            com.onetrust.otpublishers.headless.UI.Helper.l.p(textView2, lVar5, oTConfiguration2);
            if (!com.onetrust.otpublishers.headless.Internal.c.q(lVar4.f22783b)) {
                textView2.setTextSize(Float.parseFloat(lVar4.f22783b));
            }
            com.onetrust.otpublishers.headless.UI.Helper.l.q(textView2, cVar2.f22721b);
            textView2.setTextColor(!com.onetrust.otpublishers.headless.Internal.c.q(str2) ? Color.parseColor(str2) : ContextCompat.getColor(this.f23271b, p6.a.f32623a));
            v(this.f23274e, this.f23283n.f22809g, color2, color3);
            v(this.f23275f, this.f23283n.f22810h, color2, color3);
            com.onetrust.otpublishers.headless.UI.UIProperty.s sVar2 = this.f23283n;
            if (!sVar2.f22804b) {
                this.f23276g.getLayoutParams().height = 20;
                return;
            }
            String str3 = sVar2.f22805c;
            if (com.onetrust.otpublishers.headless.Internal.c.q(str3)) {
                this.f23276g.setImageResource(p6.c.f32634a);
                return;
            }
            try {
                proxyDomainURLString = OTCustomConfigurator.getProxyDomainURLString(new OTProxyType.AgeGateLogo(new URL(str3)));
            } catch (MalformedURLException e10) {
                OTLogger.a("OTAgeGateFragment", 6, "Error while fetching age gate logo using proxy" + e10.getMessage());
                proxyDomainURLString = null;
            }
            com.onetrust.otpublishers.headless.UI.extensions.f.a(p6.c.f32634a, 10000, this.f23276g, proxyDomainURLString, str3, "Age Gate Prompt");
        }
    }
}
