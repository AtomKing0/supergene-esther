package com.unity3d.ads.core.data.manager;

import android.content.Context;
import android.webkit.WebView;
import com.iab.omid.library.unity3d.adsession.AdEvents;
import com.iab.omid.library.unity3d.adsession.AdSession;
import com.iab.omid.library.unity3d.adsession.AdSessionConfiguration;
import com.iab.omid.library.unity3d.adsession.AdSessionContext;
import com.iab.omid.library.unity3d.adsession.CreativeType;
import com.iab.omid.library.unity3d.adsession.ImpressionType;
import com.iab.omid.library.unity3d.adsession.Owner;
import com.iab.omid.library.unity3d.adsession.Partner;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: OmidManager.kt */
/* JADX INFO: loaded from: classes4.dex */
public interface OmidManager {
    void activate(@NotNull Context context);

    @NotNull
    AdEvents createAdEvents(@NotNull AdSession adSession);

    @NotNull
    AdSession createAdSession(@NotNull AdSessionConfiguration adSessionConfiguration, @NotNull AdSessionContext adSessionContext);

    @NotNull
    AdSessionConfiguration createAdSessionConfiguration(@NotNull CreativeType creativeType, @NotNull ImpressionType impressionType, @NotNull Owner owner, @NotNull Owner owner2, boolean z10);

    @NotNull
    AdSessionContext createHtmlAdSessionContext(@Nullable Partner partner, @Nullable WebView webView, @Nullable String str, @Nullable String str2);

    @NotNull
    AdSessionContext createJavaScriptAdSessionContext(@Nullable Partner partner, @Nullable WebView webView, @Nullable String str, @Nullable String str2);

    @NotNull
    String getVersion();

    boolean isActive();
}
