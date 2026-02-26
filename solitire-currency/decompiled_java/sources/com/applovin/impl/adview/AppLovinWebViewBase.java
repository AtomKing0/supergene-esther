package com.applovin.impl.adview;

import android.content.Context;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.applovin.impl.k0;
import com.unity3d.ads.adplayer.AndroidWebViewClient;

/* JADX INFO: loaded from: classes2.dex */
public class AppLovinWebViewBase extends WebView {
    public AppLovinWebViewBase(Context context) {
        super(context);
    }

    protected void applySettings(com.applovin.impl.sdk.ad.b bVar) {
        Boolean boolM;
        loadUrl(AndroidWebViewClient.BLANK_PAGE);
        int iQ0 = bVar.q0();
        if (iQ0 >= 0) {
            setLayerType(iQ0, null);
        }
        getSettings().setMediaPlaybackRequiresUserGesture(bVar.H());
        if (bVar.I0()) {
            WebView.setWebContentsDebuggingEnabled(true);
        }
        m mVarR0 = bVar.r0();
        if (mVarR0 != null) {
            WebSettings settings = getSettings();
            WebSettings.PluginState pluginStateB = mVarR0.b();
            if (pluginStateB != null) {
                settings.setPluginState(pluginStateB);
            }
            Boolean boolE = mVarR0.e();
            if (boolE != null) {
                settings.setAllowFileAccess(boolE.booleanValue());
            }
            Boolean boolI = mVarR0.i();
            if (boolI != null) {
                settings.setLoadWithOverviewMode(boolI.booleanValue());
            }
            Boolean boolQ = mVarR0.q();
            if (boolQ != null) {
                settings.setUseWideViewPort(boolQ.booleanValue());
            }
            Boolean boolD = mVarR0.d();
            if (boolD != null) {
                settings.setAllowContentAccess(boolD.booleanValue());
            }
            Boolean boolP = mVarR0.p();
            if (boolP != null) {
                settings.setBuiltInZoomControls(boolP.booleanValue());
            }
            Boolean boolH = mVarR0.h();
            if (boolH != null) {
                settings.setDisplayZoomControls(boolH.booleanValue());
            }
            Boolean boolL = mVarR0.l();
            if (boolL != null) {
                settings.setSaveFormData(boolL.booleanValue());
            }
            Boolean boolC = mVarR0.c();
            if (boolC != null) {
                settings.setGeolocationEnabled(boolC.booleanValue());
            }
            Boolean boolJ = mVarR0.j();
            if (boolJ != null) {
                settings.setNeedInitialFocus(boolJ.booleanValue());
            }
            Boolean boolF = mVarR0.f();
            if (boolF != null) {
                settings.setAllowFileAccessFromFileURLs(boolF.booleanValue());
            }
            Boolean boolG = mVarR0.g();
            if (boolG != null) {
                settings.setAllowUniversalAccessFromFileURLs(boolG.booleanValue());
            }
            Boolean boolO = mVarR0.o();
            if (boolO != null) {
                settings.setLoadsImagesAutomatically(boolO.booleanValue());
            }
            Boolean boolN = mVarR0.n();
            if (boolN != null) {
                settings.setBlockNetworkImage(boolN.booleanValue());
            }
            if (k0.d()) {
                Integer numA = mVarR0.a();
                if (numA != null) {
                    settings.setMixedContentMode(numA.intValue());
                }
                if (k0.e()) {
                    Boolean boolK = mVarR0.k();
                    if (boolK != null) {
                        settings.setOffscreenPreRaster(boolK.booleanValue());
                    }
                    if (!k0.j() || (boolM = mVarR0.m()) == null) {
                        return;
                    }
                    settings.setAlgorithmicDarkeningAllowed(boolM.booleanValue());
                }
            }
        }
    }
}
