package com.onetrust.otpublishers.headless.Public.DataModel;

import androidx.annotation.Keep;
import java.net.URL;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Keep
public interface OTProxyManager {
    @Keep
    @Nullable
    URL getProxyDomain(@NotNull OTProxyType oTProxyType);
}
