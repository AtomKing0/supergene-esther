package com.unity3d.ads.adplayer;

import android.webkit.WebView;
import java.util.Map;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: DisplayMessage.kt */
/* JADX INFO: loaded from: classes4.dex */
public abstract class DisplayMessage {

    @NotNull
    private final String opportunityId;

    /* JADX INFO: compiled from: DisplayMessage.kt */
    public static final class DisplayDestroyed extends DisplayMessage {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DisplayDestroyed(@NotNull String opportunityId) {
            super(opportunityId, null);
            t.i(opportunityId, "opportunityId");
        }
    }

    /* JADX INFO: compiled from: DisplayMessage.kt */
    public static final class DisplayError extends DisplayMessage {

        @NotNull
        private final String reason;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DisplayError(@NotNull String opportunityId, @NotNull String reason) {
            super(opportunityId, null);
            t.i(opportunityId, "opportunityId");
            t.i(reason, "reason");
            this.reason = reason;
        }

        @NotNull
        public final String getReason() {
            return this.reason;
        }
    }

    /* JADX INFO: compiled from: DisplayMessage.kt */
    public static final class DisplayFinishRequest extends DisplayMessage {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DisplayFinishRequest(@NotNull String opportunityId) {
            super(opportunityId, null);
            t.i(opportunityId, "opportunityId");
        }
    }

    /* JADX INFO: compiled from: DisplayMessage.kt */
    public static final class DisplayReady extends DisplayMessage {

        @Nullable
        private final Map<String, Object> showOptions;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DisplayReady(@NotNull String opportunityId, @Nullable Map<String, ? extends Object> map) {
            super(opportunityId, null);
            t.i(opportunityId, "opportunityId");
            this.showOptions = map;
        }

        @Nullable
        public final Map<String, Object> getShowOptions() {
            return this.showOptions;
        }

        public /* synthetic */ DisplayReady(String str, Map map, int i10, k kVar) {
            this(str, (i10 & 2) != 0 ? null : map);
        }
    }

    /* JADX INFO: compiled from: DisplayMessage.kt */
    public static final class FocusChanged extends DisplayMessage {
        private final boolean isFocused;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FocusChanged(@NotNull String opportunityId, boolean z10) {
            super(opportunityId, null);
            t.i(opportunityId, "opportunityId");
            this.isFocused = z10;
        }

        public final boolean isFocused() {
            return this.isFocused;
        }
    }

    /* JADX INFO: compiled from: DisplayMessage.kt */
    public static final class VisibilityChanged extends DisplayMessage {
        private final boolean isVisible;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public VisibilityChanged(@NotNull String opportunityId, boolean z10) {
            super(opportunityId, null);
            t.i(opportunityId, "opportunityId");
            this.isVisible = z10;
        }

        public final boolean isVisible() {
            return this.isVisible;
        }
    }

    /* JADX INFO: compiled from: DisplayMessage.kt */
    public static final class WebViewInstanceRequest extends DisplayMessage {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public WebViewInstanceRequest(@NotNull String opportunityId) {
            super(opportunityId, null);
            t.i(opportunityId, "opportunityId");
        }
    }

    /* JADX INFO: compiled from: DisplayMessage.kt */
    public static final class WebViewInstanceResponse extends DisplayMessage {

        @NotNull
        private final WebView webView;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public WebViewInstanceResponse(@NotNull String opportunityId, @NotNull WebView webView) {
            super(opportunityId, null);
            t.i(opportunityId, "opportunityId");
            t.i(webView, "webView");
            this.webView = webView;
        }

        @NotNull
        public final WebView getWebView() {
            return this.webView;
        }
    }

    public /* synthetic */ DisplayMessage(String str, k kVar) {
        this(str);
    }

    @NotNull
    public final String getOpportunityId() {
        return this.opportunityId;
    }

    private DisplayMessage(String str) {
        this.opportunityId = str;
    }
}
