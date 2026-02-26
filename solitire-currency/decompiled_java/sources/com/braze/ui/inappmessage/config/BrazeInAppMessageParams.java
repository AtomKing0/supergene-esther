package com.braze.ui.inappmessage.config;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: BrazeInAppMessageParams.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class BrazeInAppMessageParams {

    @NotNull
    public static final BrazeInAppMessageParams INSTANCE = new BrazeInAppMessageParams();
    private static double modalizedImageRadiusDp = 9.0d;
    private static double graphicModalMaxWidthDp = 290.0d;
    private static double graphicModalMaxHeightDp = 290.0d;

    private BrazeInAppMessageParams() {
    }

    public static final double getModalizedImageRadiusDp() {
        return modalizedImageRadiusDp;
    }
}
