package com.ironsource.mediationsdk;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.ironsource.b7;
import com.ironsource.environment.ContextProvider;
import com.ironsource.environment.thread.IronSourceThreadManager;
import com.ironsource.i9;
import com.ironsource.ji;
import com.ironsource.kb;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.ironsource.v7;
import com.vungle.ads.internal.protos.Sdk$SDKError;
import io.sentry.protocol.ViewHierarchyNode;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f13634a = "BANNER";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f13635b = "LARGE";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f13636c = "RECTANGLE";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f13637d = "LEADERBOARD";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f13638e = "SMART";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f13639f = "CUSTOM";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f13640g = "MEDIUM_RECTANGLE";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f13641h = "bannerAdSize";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f13642i = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f13643j = 1;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f13644k = 2;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f13645l = 3;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f13646m = 4;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f13647n = 5;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f13648o = 6;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f13649p = -1;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final String f13650q = "Adaptive=true";

    interface a {
        void a(Map<String, Object> map, List<String> list, StringBuilder sb);
    }

    interface b {
        void a();

        void a(String str);
    }

    public static int a(int i10) {
        int i11 = -1;
        for (AbstractAdapter abstractAdapter : c.b().a().values()) {
            try {
                int adaptiveHeight = abstractAdapter.getAdaptiveHeight(i10);
                if (adaptiveHeight > i11) {
                    i11 = adaptiveHeight;
                }
            } catch (Throwable th) {
                i9.d().a(th);
                IronLog.INTERNAL.error("exception while calling getAdaptiveHeight for adapter - " + abstractAdapter.getProviderName());
            }
        }
        return i11;
    }

    static boolean c(IronSourceBannerLayout ironSourceBannerLayout) {
        return (ironSourceBannerLayout == null || ironSourceBannerLayout.isDestroyed()) ? false : true;
    }

    static long a(long j10, long j11) {
        return j11 - (new Date().getTime() - j10);
    }

    public static int b(int i10) {
        int iA;
        if (p.m().O()) {
            iA = a(i10);
        } else {
            IronLog.API.error("The mediation must be successfully initiated before calling this API");
            iA = -1;
        }
        a(i10, iA);
        IronLog.API.verbose("maximal height - " + iA + " for width - " + i10);
        return iA;
    }

    public static ISBannerSize a() {
        return new ISBannerSize(f13637d, 728, 90);
    }

    public static ISBannerSize b() {
        if (AdapterUtils.isLargeScreen(ContextProvider.getInstance().getApplicationContext())) {
            a(f13638e, 728, 90);
        }
        return a(f13638e, Sdk$SDKError.b.WEBVIEW_ERROR_VALUE, 50);
    }

    public static ISBannerSize a(String str, int i10, int i11) {
        return new ISBannerSize(str, i10, i11);
    }

    public static void b(IronSourceBannerLayout ironSourceBannerLayout) {
        ISBannerSize size;
        if (ironSourceBannerLayout == null || (size = ironSourceBannerLayout.getSize()) == null || !size.isSmart()) {
            return;
        }
        ISBannerSize iSBannerSizeB = b();
        iSBannerSizeB.setContainerParams(size.containerParams);
        iSBannerSizeB.setAdaptive(size.isAdaptive());
        ironSourceBannerLayout.setBannerSize(iSBannerSizeB);
    }

    public static String a(ISBannerSize iSBannerSize) {
        return "Adaptive=true, size: " + iSBannerSize.containerParams.getWidth() + ViewHierarchyNode.JsonKeys.X + iSBannerSize.containerParams.getHeight() + "; fallback: " + iSBannerSize.getDescription() + ", size: " + iSBannerSize.getWidth() + ViewHierarchyNode.JsonKeys.X + iSBannerSize.getHeight() + ";";
    }

    private static void a(int i10, int i11) {
        try {
            JSONObject jSONObject = new JSONObject();
            if (i11 == -1) {
                jSONObject.put(IronSourceConstants.EVENTS_ERROR_CODE, 2);
                jSONObject.put("reason", "No networks found supporting adaptive banners");
            } else {
                jSONObject.put(IronSourceConstants.EVENTS_EXT1, "w:" + i10 + ",h:" + i11);
            }
            ji.i().a(new kb(IronSourceConstants.BN_GET_MAXIMAL_ADAPTIVE_HEIGHT, jSONObject));
        } catch (Exception e10) {
            i9.d().a(e10);
            IronLog.INTERNAL.error(e10.toString());
        }
    }

    public static void a(IronSourceBannerLayout ironSourceBannerLayout) {
        if (ironSourceBannerLayout != null) {
            ironSourceBannerLayout.a();
        }
    }

    private static void a(IronSourceBannerLayout ironSourceBannerLayout, View view, Context context, ISBannerSize iSBannerSize) {
        int iDpToPixels = AdapterUtils.dpToPixels(context, iSBannerSize.containerParams.getWidth());
        int iDpToPixels2 = AdapterUtils.dpToPixels(context, iSBannerSize.containerParams.getHeight());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(iDpToPixels, iDpToPixels2);
        RelativeLayout relativeLayout = new RelativeLayout(context);
        relativeLayout.setLayoutParams(layoutParams);
        relativeLayout.setGravity(17);
        relativeLayout.addView(view, 0);
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) ironSourceBannerLayout.getLayoutParams();
        if (layoutParams2 == null) {
            layoutParams2 = new FrameLayout.LayoutParams(iDpToPixels, iDpToPixels2);
        }
        layoutParams2.height = iDpToPixels2;
        layoutParams2.width = iDpToPixels;
        layoutParams2.gravity = 17;
        ironSourceBannerLayout.setLayoutParams(layoutParams2);
        IronLog.INTERNAL.verbose("containerParams height - " + iSBannerSize.containerParams.getHeight() + " width - " + iSBannerSize.containerParams.getWidth());
        ironSourceBannerLayout.addView(relativeLayout, 0, layoutParams2);
    }

    public static void a(IronSourceBannerLayout ironSourceBannerLayout, View view, FrameLayout.LayoutParams layoutParams) {
        a(ironSourceBannerLayout, view, layoutParams, (v7) null);
    }

    public static void a(final IronSourceBannerLayout ironSourceBannerLayout, final View view, final FrameLayout.LayoutParams layoutParams, final v7 v7Var) {
        if (ironSourceBannerLayout == null || view == null || layoutParams == null) {
            return;
        }
        final Context applicationContext = ContextProvider.getInstance().getApplicationContext();
        final ISBannerSize size = ironSourceBannerLayout.getSize();
        IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new Runnable() { // from class: com.ironsource.mediationsdk.a0
            @Override // java.lang.Runnable
            public final void run() {
                l.a(ironSourceBannerLayout, view, size, applicationContext, layoutParams, v7Var);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(IronSourceBannerLayout ironSourceBannerLayout, View view, ISBannerSize iSBannerSize, Context context, FrameLayout.LayoutParams layoutParams, v7 v7Var) {
        try {
            ironSourceBannerLayout.removeAllViews();
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view);
            }
            if (iSBannerSize != null) {
                if (iSBannerSize.isAdaptive()) {
                    a(ironSourceBannerLayout, view, context, iSBannerSize);
                } else {
                    ironSourceBannerLayout.addView(view, 0, layoutParams);
                }
            }
            if (v7Var != null) {
                v7Var.a();
            }
        } catch (Exception e10) {
            i9.d().a(e10);
            IronLog.INTERNAL.error("Error while binding a banner - " + Log.getStackTraceString(e10));
        }
    }

    static void a(IronSourceBannerLayout ironSourceBannerLayout, b7 b7Var, b bVar) {
        String str;
        if (c(ironSourceBannerLayout)) {
            str = null;
        } else {
            Object[] objArr = new Object[1];
            objArr[0] = ironSourceBannerLayout == null ? "banner is null" : "banner is destroyed";
            str = String.format("can't load banner - %s", objArr);
        }
        if (b7Var == null || TextUtils.isEmpty(b7Var.getPlacementName())) {
            Object[] objArr2 = new Object[1];
            objArr2[0] = b7Var == null ? "placement is null" : "placement name is empty";
            str = String.format("can't load banner - %s", objArr2);
        }
        if (TextUtils.isEmpty(str)) {
            bVar.a();
        } else {
            IronLog.INTERNAL.error(str);
            bVar.a(str);
        }
    }

    static void a(IronSourceBannerLayout ironSourceBannerLayout, b bVar) {
        if (ironSourceBannerLayout != null && !ironSourceBannerLayout.isDestroyed()) {
            bVar.a();
            return;
        }
        Object[] objArr = new Object[1];
        objArr[0] = ironSourceBannerLayout == null ? "banner is null" : "banner is destroyed";
        bVar.a(String.format("can't destroy banner - %s", objArr));
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00ac A[Catch: Exception -> 0x00d6, TryCatch #0 {Exception -> 0x00d6, blocks: (B:4:0x0004, B:5:0x0011, B:35:0x0062, B:42:0x00a6, B:44:0x00ac, B:46:0x00b6, B:47:0x00d2, B:36:0x008b, B:41:0x00a3, B:37:0x0090, B:38:0x0095, B:39:0x009a, B:40:0x009f, B:7:0x0015, B:10:0x001f, B:13:0x0029, B:16:0x0033, B:19:0x003d, B:22:0x0047), top: B:52:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:55:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void a(java.util.Map<java.lang.String, java.lang.Object> r8, com.ironsource.mediationsdk.ISBannerSize r9) {
        /*
            Method dump skipped, instruction units count: 258
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.l.a(java.util.Map, com.ironsource.mediationsdk.ISBannerSize):void");
    }

    public static boolean a(ISContainerParams iSContainerParams, int i10, int i11) {
        if (iSContainerParams == null || iSContainerParams.getWidth() <= 0 || iSContainerParams.getHeight() <= 0) {
            IronLog.API.warning("Container size is invalid: Default banner size will be used.");
            return false;
        }
        if (iSContainerParams.getWidth() >= i10 && iSContainerParams.getHeight() >= i11) {
            return true;
        }
        IronLog.API.warning("Container size too small: Banner may not display correctly.");
        return true;
    }
}
