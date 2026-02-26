package com.braze.ui;

import android.webkit.ConsoleMessage;
import h9.a;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: BrazeWebViewActivity.kt */
/* JADX INFO: loaded from: classes2.dex */
final class BrazeWebViewActivity$createWebChromeClient$1$onConsoleMessage$1 extends v implements a<String> {
    final /* synthetic */ ConsoleMessage $cm;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BrazeWebViewActivity$createWebChromeClient$1$onConsoleMessage$1(ConsoleMessage consoleMessage) {
        super(0);
        this.$cm = consoleMessage;
    }

    @Override // h9.a
    @NotNull
    public final String invoke() {
        return "Braze WebView Activity log. Line: " + this.$cm.lineNumber() + ". SourceId: " + this.$cm.sourceId() + ". Log Level: " + this.$cm.messageLevel() + ". Message: " + this.$cm.message();
    }
}
