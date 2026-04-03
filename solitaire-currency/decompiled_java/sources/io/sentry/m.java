package io.sentry;

import androidx.media3.extractor.text.ttml.TtmlNode;
import com.google.android.gms.common.Scopes;
import io.sentry.protocol.Feedback;
import io.sentry.protocol.SentryTransaction;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: DataCategory.java */
/* JADX INFO: loaded from: classes5.dex */
@ApiStatus.Internal
public enum m {
    All("__all__"),
    Default("default"),
    Error("error"),
    Feedback(Feedback.TYPE),
    Session("session"),
    Attachment("attachment"),
    LogItem("log_item"),
    Monitor("monitor"),
    Profile(Scopes.PROFILE),
    ProfileChunkUi("profile_chunk_ui"),
    Transaction(SentryTransaction.JsonKeys.TRANSACTION),
    Replay("replay"),
    Span(TtmlNode.TAG_SPAN),
    Security("security"),
    UserReport("user_report"),
    Unknown("unknown");

    private final String category;

    m(@NotNull String str) {
        this.category = str;
    }

    public String getCategory() {
        return this.category;
    }
}
