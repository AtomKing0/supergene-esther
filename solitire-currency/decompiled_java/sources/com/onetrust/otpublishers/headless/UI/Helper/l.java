package com.onetrust.otpublishers.headless.UI.Helper;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Insets;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.Editable;
import android.text.Html;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.URLSpan;
import android.util.DisplayMetrics;
import android.util.Size;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.view.WindowMetrics;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.appcompat.widget.SwitchCompat;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.onetrust.otpublishers.headless.Internal.Helper.p;
import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import com.onetrust.otpublishers.headless.Public.DataModel.OTConfiguration;
import com.onetrust.otpublishers.headless.Public.OTThemeConstants;
import java.util.Objects;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.xml.sax.XMLReader;

/* JADX INFO: loaded from: classes4.dex */
public final class l {

    public static class a implements Html.TagHandler {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f22165b;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f22164a = true;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f22166c = 1;

        @Override // android.text.Html.TagHandler
        public final void handleTag(boolean z10, @NonNull String str, @NonNull Editable editable, @NonNull XMLReader xMLReader) {
            if ("ul".equals(str)) {
                this.f22165b = "UL";
            } else if ("ol".equals(str)) {
                this.f22165b = "OL";
            }
            if ("li".equals(str)) {
                if ("UL".equals(this.f22165b)) {
                    if (this.f22164a) {
                        editable.append("\n\t•");
                        this.f22164a = false;
                        return;
                    }
                } else if (this.f22164a) {
                    editable.append("\n\t").append((CharSequence) String.valueOf(this.f22166c)).append(". ");
                    this.f22164a = false;
                    this.f22166c++;
                    return;
                }
                this.f22164a = true;
            }
        }
    }

    public static int a(@NonNull Context context, @Nullable OTConfiguration oTConfiguration) {
        return (oTConfiguration == null || com.onetrust.otpublishers.headless.Internal.c.q(oTConfiguration.getDarkModeThemeValue())) ? 32 == (context.getResources().getConfiguration().uiMode & 48) ? 11 : 22 : com.onetrust.otpublishers.headless.Internal.b.a(oTConfiguration.getDarkModeThemeValue()) ? 11 : 22;
    }

    public static int b(Context context, boolean z10) {
        if (Build.VERSION.SDK_INT < 30) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            Objects.requireNonNull(context);
            ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            return z10 ? displayMetrics.heightPixels : displayMetrics.widthPixels;
        }
        Objects.requireNonNull(context);
        WindowMetrics currentWindowMetrics = ((Activity) context).getWindowManager().getCurrentWindowMetrics();
        Insets insetsIgnoringVisibility = currentWindowMetrics.getWindowInsets().getInsetsIgnoringVisibility(WindowInsets.Type.navigationBars() | WindowInsets.Type.displayCutout());
        int i10 = insetsIgnoringVisibility.right + insetsIgnoringVisibility.left;
        int i11 = insetsIgnoringVisibility.top + insetsIgnoringVisibility.bottom;
        Rect bounds = currentWindowMetrics.getBounds();
        Size size = new Size(bounds.width() - i10, bounds.height() - i11);
        return z10 ? size.getHeight() : size.getWidth();
    }

    @NonNull
    public static View c(@NonNull Context context, @NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, int i10) {
        return com.onetrust.otpublishers.headless.Internal.c.x(context) ? layoutInflater.cloneInContext(new ContextThemeWrapper(context, p6.g.f32919b)).inflate(i10, viewGroup, false) : layoutInflater.inflate(i10, viewGroup, false);
    }

    @NonNull
    public static String d(long j10, @NonNull JSONObject jSONObject) {
        String string;
        StringBuilder sb;
        String strOptString;
        if (j10 <= 0) {
            return "0 " + jSONObject.optString("PCenterVendorListLifespanDays");
        }
        int i10 = (int) (j10 / 2629746);
        int i11 = ((int) (j10 % 2629746)) / 86400;
        String str = "";
        if (i10 != 0) {
            if (i10 != 1) {
                sb = new StringBuilder();
                sb.append(i10);
                sb.append(" ");
                strOptString = jSONObject.optString("PCenterVendorListLifespanMonths");
            } else {
                sb = new StringBuilder();
                sb.append(i10);
                sb.append(" ");
                strOptString = jSONObject.optString("PCenterVendorListLifespanMonth");
            }
            sb.append(strOptString);
            string = sb.toString();
        } else {
            string = "";
        }
        if (i11 == 0) {
            boolean z10 = i10 == 0;
            String str2 = "0 " + jSONObject.optString("PCenterVendorListLifespanDays");
            if (z10) {
                str = str2;
            }
        } else if (i11 != 1) {
            if (30 != i11) {
                str = i11 + " " + jSONObject.optString("PCenterVendorListLifespanDays");
            }
            if (30 == i11) {
                int i12 = i10 + 1;
                string = i12 + " " + (i12 == 1 ? jSONObject.optString("PCenterVendorListLifespanMonth") : jSONObject.optString("PCenterVendorListLifespanMonths"));
            }
        } else {
            str = i11 + " " + jSONObject.optString("PCenterVendorListLifespanDay");
        }
        return string + " " + str;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:41:? A[RETURN, SYNTHETIC] */
    @androidx.annotation.NonNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String e(@androidx.annotation.NonNull android.content.Context r1, @androidx.annotation.NonNull org.json.JSONObject r2, @androidx.annotation.NonNull org.json.JSONObject r3, @androidx.annotation.Nullable java.lang.String r4, boolean r5) {
        /*
            com.onetrust.otpublishers.headless.Public.OTPublishersHeadlessSDK r0 = new com.onetrust.otpublishers.headless.Public.OTPublishersHeadlessSDK
            r0.<init>(r1)
            org.json.JSONObject r1 = r0.getPreferenceCenterData()
            boolean r4 = com.onetrust.otpublishers.headless.Internal.c.t(r4)
            java.lang.String r0 = ""
            if (r4 == 0) goto L88
            boolean r4 = v(r3, r5)
            if (r4 == 0) goto L88
            if (r1 == 0) goto L88
            java.lang.String r4 = "CustomGroupId"
            java.lang.String r3 = r3.optString(r4)
            java.lang.String r4 = "IFEV2"
            boolean r4 = r3.startsWith(r4)
            if (r4 != 0) goto L5a
            java.lang.String r4 = "IFE2V2"
            boolean r4 = r3.startsWith(r4)
            if (r4 == 0) goto L30
            goto L5a
        L30:
            java.lang.String r4 = "ISFV2"
            boolean r4 = r3.startsWith(r4)
            if (r4 != 0) goto L57
            java.lang.String r4 = "ISF2V2"
            boolean r4 = r3.startsWith(r4)
            if (r4 == 0) goto L41
            goto L57
        L41:
            java.lang.String r4 = "ISPV2"
            boolean r4 = r3.startsWith(r4)
            if (r4 != 0) goto L54
            java.lang.String r4 = "ISP2V2"
            boolean r4 = r3.startsWith(r4)
            if (r4 == 0) goto L52
            goto L54
        L52:
            r4 = r0
            goto L60
        L54:
            java.lang.String r4 = "PCVendorsCountSpcPurposeText"
            goto L5c
        L57:
            java.lang.String r4 = "PCVendorsCountSpcFeatureText"
            goto L5c
        L5a:
            java.lang.String r4 = "PCVendorsCountFeatureText"
        L5c:
            java.lang.String r4 = r1.optString(r4)
        L60:
            boolean r5 = com.onetrust.otpublishers.headless.Internal.c.q(r4)
            if (r5 == 0) goto L6c
            java.lang.String r4 = "PCVendorsCountText"
            java.lang.String r4 = r1.optString(r4)
        L6c:
            boolean r1 = com.onetrust.otpublishers.headless.Internal.c.q(r4)
            if (r1 != 0) goto L88
            java.lang.String r1 = g(r2, r3)
            boolean r2 = com.onetrust.otpublishers.headless.Internal.c.q(r1)
            if (r2 != 0) goto L88
            int r2 = java.lang.Integer.parseInt(r1)
            if (r2 <= 0) goto L88
            java.lang.String r2 = "[VENDOR_NUMBER]"
            java.lang.String r0 = r4.replace(r2, r1)
        L88:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onetrust.otpublishers.headless.UI.Helper.l.e(android.content.Context, org.json.JSONObject, org.json.JSONObject, java.lang.String, boolean):java.lang.String");
    }

    @NonNull
    public static String f(@NonNull String str) {
        int i10;
        if (com.onetrust.otpublishers.headless.Internal.c.q(str)) {
            return "";
        }
        if (TtmlNode.CENTER.equalsIgnoreCase(str)) {
            i10 = 4;
        } else if (TtmlNode.LEFT.equalsIgnoreCase(str)) {
            i10 = 2;
        } else {
            if (!TtmlNode.RIGHT.equalsIgnoreCase(str)) {
                return "";
            }
            i10 = 3;
        }
        return String.valueOf(i10);
    }

    @NonNull
    public static String g(@NonNull JSONObject jSONObject, @NonNull String str) {
        if (com.onetrust.otpublishers.headless.Internal.c.q(str) || !jSONObject.has(str)) {
            return "";
        }
        try {
            return jSONObject.getString(str);
        } catch (JSONException e10) {
            p.a(e10, new StringBuilder("Error on getting vendor count for category : "), "UIUtils", 6);
            return "";
        }
    }

    @NonNull
    public static JSONArray h(@NonNull JSONArray jSONArray) {
        JSONArray jSONArray2 = new JSONArray();
        for (int i10 = 0; i10 < jSONArray.length(); i10++) {
            try {
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = jSONArray.getJSONObject(i10);
                OTLogger.a("UIUtils", 3, "Individual Purpose List: " + jSONObject2.getString("Type") + "  " + jSONObject2.getString("GroupName"));
                if (!(jSONObject2.getString("Type").contains("IAB2_STACK") || jSONObject2.getString("Type").contains("IAB2V2_STACK")) && !jSONObject2.getString("Type").contains("COOKIE") && !jSONObject2.getString("Type").contains("BRANCH")) {
                    jSONObject.put("CustomGroupId", jSONObject2.optString("CustomGroupId", ""));
                    jSONObject.put("GroupName", jSONObject2.optString("GroupName", ""));
                    jSONObject.put("Type", jSONObject2.optString("Type", ""));
                    jSONArray2.put(jSONObject);
                }
                t(jSONArray2, jSONObject2);
            } catch (JSONException e10) {
                p.a(e10, new StringBuilder("getPurposeList: "), "UIUtils", 6);
            }
        }
        return jSONArray2;
    }

    public static void i(@NonNull Context context, @NonNull Button button, @Nullable com.onetrust.otpublishers.headless.UI.UIProperty.f fVar, @Nullable String str, @Nullable String str2) {
        if (com.onetrust.otpublishers.headless.Internal.c.q(str)) {
            OTLogger.a("UIUtils", 3, "Button set background color called with empty buttonBackGroundColor.");
            return;
        }
        if (com.onetrust.otpublishers.headless.Internal.c.x(context)) {
            button.setBackgroundColor(Color.parseColor(str));
            return;
        }
        if (fVar != null) {
            if ((com.onetrust.otpublishers.headless.Internal.c.q(fVar.f22762e) && com.onetrust.otpublishers.headless.Internal.c.q(fVar.f22763f)) ? false : true) {
                String str3 = fVar.f22762e;
                if (com.onetrust.otpublishers.headless.Internal.c.q(str3)) {
                    str3 = "4";
                }
                if (com.onetrust.otpublishers.headless.Internal.c.q(str2)) {
                    str2 = str;
                }
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setShape(0);
                gradientDrawable.setStroke(Integer.parseInt(str3), Color.parseColor(str2));
                gradientDrawable.setColor(Color.parseColor(str));
                if (!com.onetrust.otpublishers.headless.Internal.c.q(fVar.f22763f)) {
                    gradientDrawable.setCornerRadius(TypedValue.applyDimension(1, Integer.parseInt(fVar.f22763f), context.getResources().getDisplayMetrics()));
                }
                button.setBackground(gradientDrawable);
                return;
            }
        }
        n(button, str, str2, p6.d.f32667d1);
    }

    public static void j(@NonNull Context context, @NonNull TextView textView, @Nullable String str) {
        if (str == null || com.onetrust.otpublishers.headless.Internal.c.q(str)) {
            OTLogger.a("UIUtils", 3, "renderHtmlText called with 'null' text content.");
            return;
        }
        if (!Pattern.compile(".*\\<[^>]+>.*", 32).matcher(str).matches()) {
            textView.setText(str);
            return;
        }
        OTLogger.a("UIUtils", 3, "Rendering html content");
        Spanned spannedFromHtml = Build.VERSION.SDK_INT >= 24 ? Html.fromHtml(str, 0) : Html.fromHtml(str, null, new a());
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(spannedFromHtml);
        for (URLSpan uRLSpan : (URLSpan[]) spannableStringBuilder.getSpans(0, spannedFromHtml.length(), URLSpan.class)) {
            spannableStringBuilder.setSpan(new j(context, uRLSpan), spannableStringBuilder.getSpanStart(uRLSpan), spannableStringBuilder.getSpanEnd(uRLSpan), spannableStringBuilder.getSpanFlags(uRLSpan));
            spannableStringBuilder.removeSpan(uRLSpan);
        }
        textView.setText(spannableStringBuilder);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
    }

    public static void k(@NonNull Context context, @NonNull SwitchCompat switchCompat, @Nullable String str, @Nullable String str2) {
        if (com.onetrust.otpublishers.headless.Internal.c.q(str)) {
            switchCompat.getTrackDrawable().setTint(ContextCompat.getColor(context, p6.a.f32627e));
        } else {
            switchCompat.getTrackDrawable().setTint(Color.parseColor(str));
        }
        if (com.onetrust.otpublishers.headless.Internal.c.q(str2)) {
            switchCompat.getThumbDrawable().setTint(ContextCompat.getColor(context, p6.a.f32625c));
        } else {
            switchCompat.getThumbDrawable().setTint(Color.parseColor(str2));
        }
    }

    public static void l(@NonNull ViewGroup viewGroup, @NonNull Context context) {
        RelativeLayout.LayoutParams layoutParams;
        int i10;
        if (Build.VERSION.SDK_INT >= 28) {
            Objects.requireNonNull(context);
            View decorView = ((Activity) context).getWindow().getDecorView();
            if ((decorView.getRootWindowInsets() != null ? decorView.getRootWindowInsets().getDisplayCutout() : null) != null) {
                OTLogger.a("UIUtils", 5, "Device is notch enabled");
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) viewGroup.getLayoutParams();
                layoutParams2.setMargins(0, 0, 0, 50);
                viewGroup.setLayoutParams(layoutParams2);
                return;
            }
            OTLogger.a("UIUtils", 5, "Device is not notch enabled");
            layoutParams = (RelativeLayout.LayoutParams) viewGroup.getLayoutParams();
            i10 = 70;
        } else {
            layoutParams = (RelativeLayout.LayoutParams) viewGroup.getLayoutParams();
            i10 = 60;
        }
        layoutParams.setMargins(0, 0, 0, i10);
        viewGroup.setLayoutParams(layoutParams);
    }

    public static void m(@NonNull Button button, @NonNull com.onetrust.otpublishers.headless.UI.UIProperty.l lVar, @Nullable OTConfiguration oTConfiguration) {
        Typeface typeface;
        Typeface otTypeFaceMap;
        String str = lVar.f22785d;
        if (!com.onetrust.otpublishers.headless.Internal.c.q(str) && oTConfiguration != null && (otTypeFaceMap = oTConfiguration.getOtTypeFaceMap(str)) != null) {
            button.setTypeface(otTypeFaceMap);
            return;
        }
        int style = lVar.f22784c;
        if (style == -1 && (typeface = button.getTypeface()) != null) {
            style = typeface.getStyle();
        }
        button.setTypeface(!com.onetrust.otpublishers.headless.Internal.c.q(lVar.f22782a) ? Typeface.create(lVar.f22782a, style) : Typeface.create(button.getTypeface(), style));
    }

    public static void n(@NonNull Button button, @Nullable String str, @Nullable String str2, int i10) {
        if (button.getId() != i10) {
            button.setBackgroundColor(Color.parseColor(str));
            return;
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setStroke(Integer.parseInt(ExifInterface.GPS_MEASUREMENT_3D), Color.parseColor(str2));
        gradientDrawable.setColor(Color.parseColor(str));
        gradientDrawable.setCornerRadius(Float.parseFloat("0"));
        button.setBackground(gradientDrawable);
    }

    public static void o(@NonNull ImageView imageView, @NonNull String str) {
        imageView.getDrawable().setTint(Color.parseColor(str));
    }

    public static void p(@NonNull TextView textView, @NonNull com.onetrust.otpublishers.headless.UI.UIProperty.l lVar, @Nullable OTConfiguration oTConfiguration) {
        Typeface otTypeFaceMap;
        String str = lVar.f22785d;
        if (!com.onetrust.otpublishers.headless.Internal.c.q(str) && oTConfiguration != null && (otTypeFaceMap = oTConfiguration.getOtTypeFaceMap(str)) != null) {
            textView.setTypeface(otTypeFaceMap);
        } else {
            int iA = com.onetrust.otpublishers.headless.UI.UIProperty.l.a(textView, lVar.f22784c);
            textView.setTypeface(!com.onetrust.otpublishers.headless.Internal.c.q(lVar.f22782a) ? Typeface.create(lVar.f22782a, iA) : Typeface.create(textView.getTypeface(), iA));
        }
    }

    public static void q(@NonNull TextView textView, String str) {
        if (com.onetrust.otpublishers.headless.Internal.Helper.k.e(textView.getContext())) {
            textView.setTextAlignment(5);
            return;
        }
        if (com.onetrust.otpublishers.headless.Internal.c.q(str)) {
            return;
        }
        int i10 = Integer.parseInt(str);
        int layoutDirection = textView.getContext().getResources().getConfiguration().getLayoutDirection();
        int i11 = GravityCompat.END;
        int i12 = GravityCompat.START;
        if (layoutDirection != 1) {
            i12 = 8388613;
            i11 = 8388611;
        }
        if (i10 == 2) {
            textView.setGravity(3);
            return;
        }
        if (i10 == 3) {
            textView.setGravity(5);
            return;
        }
        if (i10 == 4) {
            textView.setGravity(1);
        } else if (i10 == 5) {
            textView.setGravity(i11);
        } else {
            if (i10 != 6) {
                return;
            }
            textView.setGravity(i12);
        }
    }

    public static void r(FragmentActivity fragmentActivity, com.google.android.material.bottomsheet.a aVar) {
        if (fragmentActivity != null && aVar == null) {
            OTLogger.a("UIUtils", 3, "setupFullHeight: null instance found, recreating bottomSheetDialog");
            SharedPreferences sharedPreferences = fragmentActivity.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOT_SDK_APP_CONFIGURATION", 0);
            String str = OTThemeConstants.NO_SDK_THEME_OVERRIDE;
            String string = sharedPreferences.getString("OT_UX_SDK_THEME", OTThemeConstants.NO_SDK_THEME_OVERRIDE);
            if (!com.onetrust.otpublishers.headless.Internal.c.q(string)) {
                str = string;
            }
            aVar = str.equals(OTThemeConstants.OT_SDK_UI_THEME) ? new com.google.android.material.bottomsheet.a(fragmentActivity, p6.g.f32918a) : new com.google.android.material.bottomsheet.a(fragmentActivity);
        }
        FrameLayout frameLayout = (FrameLayout) aVar.findViewById(p6.d.f32685f1);
        if (frameLayout != null) {
            BottomSheetBehavior bottomSheetBehaviorM = BottomSheetBehavior.M(frameLayout);
            ViewGroup.LayoutParams layoutParams = frameLayout.getLayoutParams();
            int iB = b(fragmentActivity, true);
            if (layoutParams != null) {
                layoutParams.height = iB;
            }
            frameLayout.setLayoutParams(layoutParams);
            bottomSheetBehaviorM.s0(3);
            bottomSheetBehaviorM.n0(b(fragmentActivity, true));
        }
    }

    public static void s(@NonNull com.onetrust.otpublishers.headless.Internal.Event.b bVar, @Nullable com.onetrust.otpublishers.headless.Internal.Event.a aVar) {
        if (aVar != null) {
            aVar.a(bVar);
        } else {
            OTLogger.a("OneTrust", 6, "Error on sending UI events, listener set was found to be null.This could be because the activity has been recreated. \n Please set listener to get UI event callbacks.");
        }
    }

    public static void t(JSONArray jSONArray, JSONObject jSONObject) throws JSONException {
        if (jSONObject.has("SubGroups")) {
            JSONArray jSONArray2 = new JSONArray();
            JSONArray jSONArray3 = jSONObject.getJSONArray("SubGroups");
            for (int i10 = 0; i10 < jSONArray3.length(); i10++) {
                if (!jSONArray3.getJSONObject(i10).getString("Type").contains("COOKIE")) {
                    jSONArray2.put(jSONArray3.getJSONObject(i10));
                }
            }
            for (int i11 = 0; i11 < jSONArray2.length(); i11++) {
                JSONObject jSONObject2 = new JSONObject();
                JSONObject jSONObject3 = jSONArray2.getJSONObject(i11);
                if (!("IAB2_STACK".equals(jSONObject3.getString("Type")) || "IAB2V2_STACK".equals(jSONObject3.getString("Type"))) && !jSONObject3.getString("Type").contains("COOKIE") && !jSONObject3.getString("Type").contains("BRANCH")) {
                    jSONObject2.put("CustomGroupId", jSONObject3.optString("CustomGroupId", ""));
                    jSONObject2.put("GroupName", jSONObject3.optString("GroupName", ""));
                    jSONObject2.put("Type", jSONObject3.optString("Type", ""));
                    jSONArray.put(jSONObject2);
                }
            }
        }
    }

    public static boolean u(@NonNull JSONObject jSONObject) {
        JSONArray jSONArray;
        if (jSONObject.has("IabIllustrations")) {
            try {
                jSONArray = jSONObject.getJSONArray("IabIllustrations");
            } catch (JSONException e10) {
                p.a(e10, new StringBuilder("Error on getting iab illustration array. Error = "), "UIUtils", 6);
                jSONArray = null;
            }
        } else {
            jSONArray = null;
        }
        return jSONArray != null && jSONArray.length() > 0;
    }

    public static boolean v(@NonNull JSONObject jSONObject, boolean z10) throws JSONException {
        if (z10 && jSONObject.optString("Type").contains("IAB")) {
            return true;
        }
        JSONArray jSONArray = new JSONArray();
        if (jSONObject.has("SubGroups")) {
            jSONArray = jSONObject.getJSONArray("SubGroups");
        }
        for (int i10 = 0; i10 < jSONArray.length(); i10++) {
            if (jSONArray.getJSONObject(i10).optString("Type").contains("IAB")) {
                return true;
            }
        }
        return false;
    }

    public static void w(@Nullable JSONObject jSONObject, boolean z10) {
        if (jSONObject == null) {
            return;
        }
        if (z10) {
            if (jSONObject.has("BannerMPButtonColor")) {
                return;
            }
            OTLogger.a("OneTrust", 6, "Downloaded data does not contain the required fields to render the UI. \nPlease publish the application to a version that matches the SDK version from the admin UI.");
        } else {
            if (jSONObject.has("IsIabEnabled") && jSONObject.has("PCGrpDescType") && jSONObject.has("BConsentText")) {
                return;
            }
            OTLogger.a("OneTrust", 6, "Downloaded data does not contain the required fields to render the UI. \nPlease publish the application to a version that matches the SDK version from the admin UI.");
        }
    }
}
