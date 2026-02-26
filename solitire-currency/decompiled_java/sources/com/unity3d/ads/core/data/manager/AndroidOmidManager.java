package com.unity3d.ads.core.data.manager;

import android.content.Context;
import android.webkit.WebView;
import com.iab.omid.library.unity3d.Omid;
import com.iab.omid.library.unity3d.adsession.AdEvents;
import com.iab.omid.library.unity3d.adsession.AdSession;
import com.iab.omid.library.unity3d.adsession.AdSessionConfiguration;
import com.iab.omid.library.unity3d.adsession.AdSessionContext;
import com.iab.omid.library.unity3d.adsession.CreativeType;
import com.iab.omid.library.unity3d.adsession.ImpressionType;
import com.iab.omid.library.unity3d.adsession.Owner;
import com.iab.omid.library.unity3d.adsession.Partner;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: AndroidOmidManager.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class AndroidOmidManager implements OmidManager {
    @Override // com.unity3d.ads.core.data.manager.OmidManager
    public void activate(@NotNull Context context) {
        t.i(context, "context");
        Omid.activate(context);
    }

    @Override // com.unity3d.ads.core.data.manager.OmidManager
    @NotNull
    public AdEvents createAdEvents(@NotNull AdSession adSession) {
        t.i(adSession, "adSession");
        AdEvents adEventsCreateAdEvents = AdEvents.createAdEvents(adSession);
        t.h(adEventsCreateAdEvents, "createAdEvents(adSession)");
        return adEventsCreateAdEvents;
    }

    @Override // com.unity3d.ads.core.data.manager.OmidManager
    @NotNull
    public AdSession createAdSession(@NotNull AdSessionConfiguration adSessionConfiguration, @NotNull AdSessionContext context) {
        t.i(adSessionConfiguration, "adSessionConfiguration");
        t.i(context, "context");
        AdSession adSessionCreateAdSession = AdSession.createAdSession(adSessionConfiguration, context);
        t.h(adSessionCreateAdSession, "createAdSession(adSessionConfiguration, context)");
        return adSessionCreateAdSession;
    }

    @Override // com.unity3d.ads.core.data.manager.OmidManager
    @NotNull
    public AdSessionConfiguration createAdSessionConfiguration(@NotNull CreativeType creativeType, @NotNull ImpressionType impressionType, @NotNull Owner owner, @NotNull Owner mediaEventsOwner, boolean z10) {
        t.i(creativeType, "creativeType");
        t.i(impressionType, "impressionType");
        t.i(owner, "owner");
        t.i(mediaEventsOwner, "mediaEventsOwner");
        AdSessionConfiguration adSessionConfigurationCreateAdSessionConfiguration = AdSessionConfiguration.createAdSessionConfiguration(creativeType, impressionType, owner, mediaEventsOwner, z10);
        t.h(adSessionConfigurationCreateAdSessionConfiguration, "createAdSessionConfigura…VerificationScripts\n    )");
        return adSessionConfigurationCreateAdSessionConfiguration;
    }

    @Override // com.unity3d.ads.core.data.manager.OmidManager
    @NotNull
    public AdSessionContext createHtmlAdSessionContext(@Nullable Partner partner, @Nullable WebView webView, @Nullable String str, @Nullable String str2) {
        AdSessionContext adSessionContextCreateHtmlAdSessionContext = AdSessionContext.createHtmlAdSessionContext(partner, webView, str, str2);
        t.h(adSessionContextCreateHtmlAdSessionContext, "createHtmlAdSessionConte…customReferenceData\n    )");
        return adSessionContextCreateHtmlAdSessionContext;
    }

    @Override // com.unity3d.ads.core.data.manager.OmidManager
    @NotNull
    public AdSessionContext createJavaScriptAdSessionContext(@Nullable Partner partner, @Nullable WebView webView, @Nullable String str, @Nullable String str2) {
        AdSessionContext adSessionContextCreateJavascriptAdSessionContext = AdSessionContext.createJavascriptAdSessionContext(partner, webView, str, str2);
        t.h(adSessionContextCreateJavascriptAdSessionContext, "createJavascriptAdSessio…customReferenceData\n    )");
        return adSessionContextCreateJavascriptAdSessionContext;
    }

    @Override // com.unity3d.ads.core.data.manager.OmidManager
    @NotNull
    public String getVersion() {
        String version = Omid.getVersion();
        t.h(version, "getVersion()");
        return version;
    }

    @Override // com.unity3d.ads.core.data.manager.OmidManager
    public boolean isActive() {
        return Omid.isActive();
    }
}
