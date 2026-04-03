package com.braze.enums;

import androidx.media3.exoplayer.RendererCapabilities;

/* JADX INFO: loaded from: classes2.dex */
public enum BrazeViewBounds {
    NOTIFICATION_EXPANDED_IMAGE(478, 256),
    NOTIFICATION_INLINE_PUSH_IMAGE(RendererCapabilities.DECODER_SUPPORT_MASK, 256),
    NOTIFICATION_LARGE_ICON(64, 64),
    NOTIFICATION_ONE_IMAGE_STORY(256, 128),
    BASE_CARD_VIEW(512, 512),
    IN_APP_MESSAGE_MODAL(580, 580),
    IN_APP_MESSAGE_SLIDEUP(100, 100),
    NO_BOUNDS(0, 0);

    private final int heightDp;
    private final int widthDp;

    BrazeViewBounds(int i10, int i11) {
        this.widthDp = i10;
        this.heightDp = i11;
    }

    public final int getHeightDp() {
        return this.heightDp;
    }

    public final int getWidthDp() {
        return this.widthDp;
    }
}
