package com.unity3d.services.core.extensions;

import com.unity3d.services.UnityAdsConstants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: StringExtensions.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class StringExtensionsKt {
    @NotNull
    public static final String toUnityMessage(@Nullable String str) {
        if (str == null || str.length() == 0) {
            return "[Unity Ads] Internal error";
        }
        return UnityAdsConstants.Messages.MSG_UNITY_BASE + str;
    }
}
