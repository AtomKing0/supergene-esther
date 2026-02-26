package com.onetrust.otpublishers.headless.Internal.syncnotif;

import android.R;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentActivity;
import com.google.android.material.snackbar.Snackbar;
import com.ironsource.f5;
import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import com.onetrust.otpublishers.headless.Public.DataModel.OTConfiguration;
import com.onetrust.otpublishers.headless.Public.Keys.OTUXParamsKeys;
import com.onetrust.otpublishers.headless.Public.OTPublishersHeadlessSDK;
import com.onetrust.otpublishers.headless.Public.OTVendorListMode;
import com.onetrust.otpublishers.headless.UI.Helper.l;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f21950a;

    public static void d(Button button, com.onetrust.otpublishers.headless.UI.UIProperty.f fVar, k kVar, View view, boolean z10) {
        if (!z10) {
            OTLogger.a("SyncNotification", 3, "focus: " + z10);
            e(button, kVar.f21952b, OTUXParamsKeys.OT_UX_TEXT_COLOR, OTUXParamsKeys.OT_UX_BORDER_COLOR);
            return;
        }
        OTLogger.a("SyncNotification", 3, "focus: " + z10);
        button.getBackground().setTint(Color.parseColor(fVar.f22766i));
        button.setTextColor(Color.parseColor(fVar.f22767j));
    }

    public static void e(@NonNull Button button, JSONObject jSONObject, String str, String str2) {
        JSONObject jSONObjectA = com.onetrust.otpublishers.headless.Internal.a.a(jSONObject, "button");
        if (com.onetrust.otpublishers.headless.Internal.a.d(jSONObjectA) || !jSONObjectA.optBoolean(f5.f12054u)) {
            return;
        }
        button.setVisibility(0);
        button.setText(jSONObjectA.optString("text"));
        button.setTextColor(Color.parseColor(jSONObjectA.optString(str)));
        if (jSONObjectA.optBoolean("showAsLink")) {
            button.setBackgroundColor(Color.parseColor("#00000000"));
            button.setPaintFlags(button.getPaintFlags() | 8);
            return;
        }
        com.onetrust.otpublishers.headless.UI.UIProperty.f fVar = new com.onetrust.otpublishers.headless.UI.UIProperty.f();
        String strOptString = jSONObjectA.optString(str2);
        String strOptString2 = jSONObjectA.optString("color");
        fVar.f22761d = strOptString;
        fVar.f22763f = jSONObjectA.optString(OTUXParamsKeys.OT_UX_BORDER_RADIUS);
        fVar.f22762e = "2";
        l.i(button.getContext(), button, fVar, strOptString2, strOptString);
    }

    public static void f(ImageView imageView, com.onetrust.otpublishers.headless.UI.UIProperty.f fVar, k kVar, View view, boolean z10) {
        if (!z10) {
            i(kVar, imageView);
        } else {
            imageView.getBackground().setTint(Color.parseColor(fVar.f22766i));
            imageView.getDrawable().setTint(Color.parseColor(fVar.f22767j));
        }
    }

    public static void g(@NonNull CardView cardView, @NonNull CardView cardView2, @NonNull TextView textView, @NonNull TextView textView2, @NonNull Button button, @NonNull ImageView imageView, @NonNull ImageView imageView2, JSONObject jSONObject) {
        JSONObject jSONObjectA = com.onetrust.otpublishers.headless.Internal.a.a(jSONObject, "title");
        if (jSONObjectA != null) {
            textView.setText(jSONObjectA.optString("text"));
            String strOptString = jSONObjectA.optString(OTUXParamsKeys.OT_UX_TEXT_COLOR);
            if (!com.onetrust.otpublishers.headless.Internal.c.q(strOptString)) {
                textView.setTextColor(Color.parseColor(strOptString));
            }
        }
        JSONObject jSONObjectA2 = com.onetrust.otpublishers.headless.Internal.a.a(jSONObject, "description");
        if (jSONObjectA2 != null) {
            textView2.setText(jSONObjectA2.optString("text"));
            String strOptString2 = jSONObjectA2.optString(OTUXParamsKeys.OT_UX_TEXT_COLOR);
            if (!com.onetrust.otpublishers.headless.Internal.c.q(strOptString2)) {
                textView2.setTextColor(Color.parseColor(strOptString2));
            }
        }
        JSONObject jSONObjectA3 = com.onetrust.otpublishers.headless.Internal.a.a(jSONObject, OTVendorListMode.GENERAL);
        if (!com.onetrust.otpublishers.headless.Internal.a.d(jSONObjectA3)) {
            Drawable drawable = imageView.getDrawable();
            String strOptString3 = jSONObjectA != null ? jSONObjectA.optString(OTUXParamsKeys.OT_UX_TEXT_COLOR) : null;
            boolean zOptBoolean = jSONObjectA3.optBoolean("showClose");
            if (drawable != null && !com.onetrust.otpublishers.headless.Internal.c.q(strOptString3)) {
                drawable.setTint(Color.parseColor(strOptString3));
            }
            imageView.setVisibility(zOptBoolean ? 0 : 8);
            Drawable background = imageView2.getBackground();
            String strOptString4 = jSONObjectA3.optString("iconBackgroundColor");
            boolean zOptBoolean2 = jSONObjectA3.optBoolean("showIcon");
            if (background != null && !com.onetrust.otpublishers.headless.Internal.c.q(strOptString4)) {
                background.setTint(Color.parseColor(strOptString4));
            }
            imageView2.setVisibility(zOptBoolean2 ? 0 : 8);
            String strOptString5 = jSONObjectA3.optString("backgroundColor");
            String strOptString6 = jSONObjectA3.optString(OTUXParamsKeys.OT_UX_BORDER_COLOR);
            if (!com.onetrust.otpublishers.headless.Internal.c.q(strOptString5)) {
                cardView2.setBackgroundColor(Color.parseColor(strOptString5));
            }
            if (!com.onetrust.otpublishers.headless.Internal.c.q(strOptString6)) {
                cardView.setBackgroundColor(Color.parseColor(strOptString6));
            }
        }
        e(button, jSONObject, OTUXParamsKeys.OT_UX_TEXT_COLOR, OTUXParamsKeys.OT_UX_BORDER_COLOR);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(Snackbar snackbar, View view) {
        snackbar.x();
        if (this.f21950a) {
            return;
        }
        this.f21950a = true;
    }

    @RequiresApi(api = 21)
    public static void i(k kVar, ImageView imageView) {
        JSONObject jSONObjectA = com.onetrust.otpublishers.headless.Internal.a.a(kVar.f21952b, "button");
        if (jSONObjectA != null) {
            String strOptString = jSONObjectA.optString("color");
            String strOptString2 = jSONObjectA.optString(OTUXParamsKeys.OT_UX_TEXT_COLOR);
            imageView.getBackground().setTint(Color.parseColor(strOptString));
            imageView.getDrawable().setTint(Color.parseColor(strOptString2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(k kVar, Snackbar snackbar, CardView cardView, CardView cardView2, TextView textView, TextView textView2, Button button, ImageView imageView, ImageView imageView2) {
        if (kVar.f21955e < 12) {
            snackbar.x();
            return;
        }
        if (this.f21950a) {
            snackbar.W();
        }
        g(cardView, cardView2, textView, textView2, button, imageView, imageView2, kVar.f21952b);
        imageView2.setImageResource(p6.c.f32636c);
        i(kVar, imageView);
    }

    public static /* synthetic */ void k(OTPublishersHeadlessSDK oTPublishersHeadlessSDK, FragmentActivity fragmentActivity, OTConfiguration oTConfiguration, Snackbar snackbar, View view) {
        oTPublishersHeadlessSDK.showPreferenceCenterUI(fragmentActivity, oTConfiguration);
        snackbar.x();
    }

    @RequiresApi(api = 21)
    public final Snackbar c(@NonNull final FragmentActivity fragmentActivity, @Nullable final OTConfiguration oTConfiguration, @NonNull final OTPublishersHeadlessSDK oTPublishersHeadlessSDK, final k kVar) {
        com.onetrust.otpublishers.headless.UI.TVUI.datautils.a aVar;
        try {
            com.onetrust.otpublishers.headless.UI.TVUI.datautils.b.a().b(fragmentActivity);
            synchronized (com.onetrust.otpublishers.headless.UI.TVUI.datautils.a.class) {
                try {
                    if (com.onetrust.otpublishers.headless.UI.TVUI.datautils.a.f22329h == null) {
                        com.onetrust.otpublishers.headless.UI.TVUI.datautils.a.f22329h = new com.onetrust.otpublishers.headless.UI.TVUI.datautils.a();
                    }
                    aVar = com.onetrust.otpublishers.headless.UI.TVUI.datautils.a.f22329h;
                } catch (Exception e10) {
                    e = e10;
                    OTLogger.a("SyncNotification", 6, e.toString());
                    return null;
                }
            }
            aVar.a(fragmentActivity);
            View viewFindViewById = fragmentActivity.findViewById(R.id.content);
            if (viewFindViewById == null) {
                OTLogger.a("SyncNotification", 5, "could not find view from activity");
                if (oTConfiguration != null && oTConfiguration.getView() != null) {
                    OTLogger.a("SyncNotification", 4, "checking for view passed by app");
                    viewFindViewById = oTConfiguration.getView();
                }
            }
            if (viewFindViewById == null) {
                OTLogger.a("SyncNotification", 6, "expected valid view but found null, not showing sync notification");
                return null;
            }
            final Snackbar snackbarI0 = Snackbar.i0(viewFindViewById, "", 0);
            Snackbar.SnackbarLayout snackbarLayout = (Snackbar.SnackbarLayout) snackbarI0.G();
            snackbarLayout.setBackgroundColor(Color.parseColor("#00000000"));
            ((TextView) snackbarLayout.findViewById(p6.d.f32644a5)).setVisibility(4);
            View viewInflate = fragmentActivity.getLayoutInflater().inflate(p6.e.I, (ViewGroup) null);
            final ImageView imageView = (ImageView) viewInflate.findViewById(p6.d.W2);
            final TextView textView = (TextView) viewInflate.findViewById(p6.d.Y2);
            final TextView textView2 = (TextView) viewInflate.findViewById(p6.d.U2);
            final Button button = (Button) viewInflate.findViewById(p6.d.S2);
            final ImageView imageView2 = (ImageView) viewInflate.findViewById(p6.d.H3);
            final CardView cardView = (CardView) viewInflate.findViewById(p6.d.X2);
            final CardView cardView2 = (CardView) viewInflate.findViewById(p6.d.V2);
            g(cardView2, cardView, textView, textView2, button, imageView2, imageView, kVar.f21951a);
            i(kVar, imageView2);
            imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.onetrust.otpublishers.headless.Internal.syncnotif.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f21928a.h(snackbarI0, view);
                }
            });
            button.setOnClickListener(new View.OnClickListener() { // from class: com.onetrust.otpublishers.headless.Internal.syncnotif.f
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    j.k(oTPublishersHeadlessSDK, fragmentActivity, oTConfiguration, snackbarI0, view);
                }
            });
            final com.onetrust.otpublishers.headless.UI.UIProperty.f fVar = aVar.f22335f.f22824i;
            button.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.onetrust.otpublishers.headless.Internal.syncnotif.g
                @Override // android.view.View.OnFocusChangeListener
                public final void onFocusChange(View view, boolean z10) {
                    j.d(button, fVar, kVar, view, z10);
                }
            });
            imageView2.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.onetrust.otpublishers.headless.Internal.syncnotif.h
                @Override // android.view.View.OnFocusChangeListener
                public final void onFocusChange(View view, boolean z10) {
                    j.f(imageView2, fVar, kVar, view, z10);
                }
            });
            snackbarLayout.setPadding(6, 6, 6, 6);
            snackbarLayout.addView(viewInflate, 0);
            snackbarI0.S(kVar.f21954d);
            viewInflate.postDelayed(new Runnable() { // from class: com.onetrust.otpublishers.headless.Internal.syncnotif.i
                @Override // java.lang.Runnable
                public final void run() {
                    this.f21940a.j(kVar, snackbarI0, cardView2, cardView, textView, textView2, button, imageView2, imageView);
                }
            }, 1500L);
            return snackbarI0;
        } catch (Exception e11) {
            e = e11;
        }
    }
}
