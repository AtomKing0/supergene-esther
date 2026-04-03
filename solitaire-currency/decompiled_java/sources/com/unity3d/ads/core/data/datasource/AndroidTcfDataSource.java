package com.unity3d.ads.core.data.datasource;

import com.unity3d.services.core.preferences.AndroidPreferences;
import com.unity3d.services.core.properties.ClientProperties;
import kotlin.jvm.internal.k;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: AndroidTcfDataSource.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class AndroidTcfDataSource implements TcfDataSource {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    public static final String TCF_TCSTRING_KEY = "IABTCF_TCString";

    /* JADX INFO: compiled from: AndroidTcfDataSource.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k kVar) {
            this();
        }
    }

    @Override // com.unity3d.ads.core.data.datasource.TcfDataSource
    @Nullable
    public String getTcfString() {
        return AndroidPreferences.getString(ClientProperties.getAppName() + "_settings", "IABTCF_TCString");
    }
}
