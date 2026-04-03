package com.braze.ui.inappmessage.views;

import android.webkit.ConsoleMessage;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: InAppMessageHtmlBaseView.kt */
/* JADX INFO: loaded from: classes2.dex */
final class InAppMessageHtmlBaseView$messageWebView$7$onConsoleMessage$1 extends v implements h9.a<String> {
    final /* synthetic */ ConsoleMessage $cm;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    InAppMessageHtmlBaseView$messageWebView$7$onConsoleMessage$1(ConsoleMessage consoleMessage) {
        super(0);
        this.$cm = consoleMessage;
    }

    @Override // h9.a
    @NotNull
    public final String invoke() {
        return "Braze HTML In-app Message log. Line: " + this.$cm.lineNumber() + ". SourceId: " + this.$cm.sourceId() + ". Log Level: " + this.$cm.messageLevel() + ". Message: " + this.$cm.message();
    }
}
