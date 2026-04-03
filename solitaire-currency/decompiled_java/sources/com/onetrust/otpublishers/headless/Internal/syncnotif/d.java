package com.onetrust.otpublishers.headless.Internal.syncnotif;

import android.R;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f21927a;

    public static void d(@NonNull CardView cardView, @NonNull CardView cardView2, @NonNull TextView textView, @NonNull TextView textView2, @NonNull Button button, @NonNull ImageView imageView, @NonNull ImageView imageView2, JSONObject jSONObject, OTConfiguration oTConfiguration) {
        int iA = l.a(textView.getContext(), oTConfiguration);
        String str = iA == 22 ? OTUXParamsKeys.OT_UX_TEXT_COLOR : "textColorDark";
        JSONObject jSONObjectA = com.onetrust.otpublishers.headless.Internal.a.a(jSONObject, "title");
        if (jSONObjectA != null) {
            textView.setText(jSONObjectA.optString("text"));
            String strOptString = jSONObjectA.optString(str);
            if (!com.onetrust.otpublishers.headless.Internal.c.q(strOptString)) {
                textView.setTextColor(Color.parseColor(strOptString));
            }
        }
        JSONObject jSONObjectA2 = com.onetrust.otpublishers.headless.Internal.a.a(jSONObject, "description");
        if (jSONObjectA2 != null) {
            textView2.setText(jSONObjectA2.optString("text"));
            String strOptString2 = jSONObjectA2.optString(str);
            if (!com.onetrust.otpublishers.headless.Internal.c.q(strOptString2)) {
                textView2.setTextColor(Color.parseColor(strOptString2));
            }
        }
        JSONObject jSONObjectA3 = com.onetrust.otpublishers.headless.Internal.a.a(jSONObject, OTVendorListMode.GENERAL);
        String str2 = iA == 22 ? OTUXParamsKeys.OT_UX_BORDER_COLOR : "borderColorDark";
        if (!com.onetrust.otpublishers.headless.Internal.a.d(jSONObjectA3)) {
            Drawable drawable = imageView.getDrawable();
            String strOptString3 = jSONObjectA != null ? jSONObjectA.optString(str) : null;
            boolean zOptBoolean = jSONObjectA3.optBoolean("showClose");
            if (drawable != null && !com.onetrust.otpublishers.headless.Internal.c.q(strOptString3)) {
                drawable.setTint(Color.parseColor(strOptString3));
            }
            imageView.setVisibility(zOptBoolean ? 0 : 8);
            String str3 = iA == 22 ? "iconBackgroundColor" : "iconBackgroundColorDark";
            Drawable background = imageView2.getBackground();
            String strOptString4 = jSONObjectA3.optString(str3);
            boolean zOptBoolean2 = jSONObjectA3.optBoolean("showIcon");
            if (background != null && !com.onetrust.otpublishers.headless.Internal.c.q(strOptString4)) {
                background.setTint(Color.parseColor(strOptString4));
            }
            imageView2.setVisibility(zOptBoolean2 ? 0 : 8);
            String strOptString5 = jSONObjectA3.optString(iA == 22 ? "backgroundColor" : "backgroundColorDark");
            String strOptString6 = jSONObjectA3.optString(str2);
            if (!com.onetrust.otpublishers.headless.Internal.c.q(strOptString5)) {
                cardView2.setBackgroundColor(Color.parseColor(strOptString5));
            }
            if (!com.onetrust.otpublishers.headless.Internal.c.q(strOptString6)) {
                cardView.setBackgroundColor(Color.parseColor(strOptString6));
            }
        }
        JSONObject jSONObjectA4 = com.onetrust.otpublishers.headless.Internal.a.a(jSONObject, "button");
        if (com.onetrust.otpublishers.headless.Internal.a.d(jSONObjectA4) || !jSONObjectA4.optBoolean(f5.f12054u)) {
            return;
        }
        button.setVisibility(0);
        button.setText(jSONObjectA4.optString("text"));
        button.setTextColor(Color.parseColor(jSONObjectA4.optString(str)));
        if (jSONObjectA4.optBoolean("showAsLink")) {
            button.setBackgroundColor(Color.parseColor("#00000000"));
            button.setPaintFlags(button.getPaintFlags() | 8);
            return;
        }
        String strOptString7 = jSONObjectA4.optString(str2);
        String strOptString8 = jSONObjectA4.optString(iA == 22 ? "color" : "colorDark");
        String strOptString9 = jSONObjectA4.optString(OTUXParamsKeys.OT_UX_BORDER_RADIUS);
        Context context = button.getContext();
        if (com.onetrust.otpublishers.headless.Internal.c.q(strOptString8)) {
            OTLogger.a("UIUtils", 3, "Button set background color called with empty buttonBackGroundColor.");
            return;
        }
        if (com.onetrust.otpublishers.headless.Internal.c.x(context)) {
            button.setBackgroundColor(Color.parseColor(strOptString8));
            return;
        }
        if (!((com.onetrust.otpublishers.headless.Internal.c.q("2") && com.onetrust.otpublishers.headless.Internal.c.q(strOptString9)) ? false : true)) {
            l.n(button, strOptString8, strOptString7, p6.d.f32667d1);
            return;
        }
        String str4 = com.onetrust.otpublishers.headless.Internal.c.q("2") ? "4" : "2";
        if (com.onetrust.otpublishers.headless.Internal.c.q(strOptString7)) {
            strOptString7 = strOptString8;
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setStroke(Integer.parseInt(str4), Color.parseColor(strOptString7));
        gradientDrawable.setColor(Color.parseColor(strOptString8));
        if (!com.onetrust.otpublishers.headless.Internal.c.q(strOptString9)) {
            gradientDrawable.setCornerRadius(TypedValue.applyDimension(1, Integer.parseInt(strOptString9), context.getResources().getDisplayMetrics()));
        }
        button.setBackground(gradientDrawable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(Snackbar snackbar, View view) {
        snackbar.x();
        if (this.f21927a) {
            return;
        }
        this.f21927a = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(k kVar, Snackbar snackbar, CardView cardView, CardView cardView2, TextView textView, TextView textView2, Button button, ImageView imageView, ImageView imageView2, OTConfiguration oTConfiguration) {
        if (kVar.f21955e < 12) {
            snackbar.x();
            return;
        }
        if (this.f21927a) {
            snackbar.W();
        }
        d(cardView, cardView2, textView, textView2, button, imageView, imageView2, kVar.f21952b, oTConfiguration);
        imageView2.setImageResource(p6.c.f32636c);
    }

    public static /* synthetic */ void g(OTPublishersHeadlessSDK oTPublishersHeadlessSDK, FragmentActivity fragmentActivity, OTConfiguration oTConfiguration, Snackbar snackbar, View view) {
        oTPublishersHeadlessSDK.showPreferenceCenterUI(fragmentActivity, oTConfiguration);
        snackbar.x();
    }

    public final Snackbar c(@NonNull final FragmentActivity fragmentActivity, @Nullable final OTConfiguration oTConfiguration, @NonNull final OTPublishersHeadlessSDK oTPublishersHeadlessSDK, final k kVar) {
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
        View viewInflate = fragmentActivity.getLayoutInflater().inflate(p6.e.F, (ViewGroup) null);
        final ImageView imageView = (ImageView) viewInflate.findViewById(p6.d.W2);
        final TextView textView = (TextView) viewInflate.findViewById(p6.d.Y2);
        final TextView textView2 = (TextView) viewInflate.findViewById(p6.d.U2);
        final Button button = (Button) viewInflate.findViewById(p6.d.S2);
        final ImageView imageView2 = (ImageView) viewInflate.findViewById(p6.d.T2);
        final CardView cardView = (CardView) viewInflate.findViewById(p6.d.X2);
        final CardView cardView2 = (CardView) viewInflate.findViewById(p6.d.V2);
        d(cardView2, cardView, textView, textView2, button, imageView2, imageView, kVar.f21951a, oTConfiguration);
        imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.onetrust.otpublishers.headless.Internal.syncnotif.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f21910a.e(snackbarI0, view);
            }
        });
        button.setOnClickListener(new View.OnClickListener() { // from class: com.onetrust.otpublishers.headless.Internal.syncnotif.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                d.g(oTPublishersHeadlessSDK, fragmentActivity, oTConfiguration, snackbarI0, view);
            }
        });
        snackbarLayout.setPadding(6, 6, 6, 6);
        snackbarLayout.addView(viewInflate, 0);
        snackbarI0.S(kVar.f21954d);
        viewInflate.postDelayed(new Runnable() { // from class: com.onetrust.otpublishers.headless.Internal.syncnotif.c
            @Override // java.lang.Runnable
            public final void run() {
                this.f21916a.f(kVar, snackbarI0, cardView2, cardView, textView, textView2, button, imageView2, imageView, oTConfiguration);
            }
        }, 1500L);
        return snackbarI0;
    }
}
