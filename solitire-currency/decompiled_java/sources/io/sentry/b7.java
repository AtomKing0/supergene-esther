package io.sentry;

import androidx.core.app.NotificationCompat;
import com.google.android.gms.common.Scopes;
import io.sentry.protocol.Feedback;
import io.sentry.protocol.SentryTransaction;
import java.io.IOException;
import java.util.Locale;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: SentryItemType.java */
/* JADX INFO: loaded from: classes5.dex */
@ApiStatus.Internal
public enum b7 implements h2 {
    Session("session"),
    Event(NotificationCompat.CATEGORY_EVENT),
    UserFeedback("user_report"),
    Attachment("attachment"),
    Transaction(SentryTransaction.JsonKeys.TRANSACTION),
    Profile(Scopes.PROFILE),
    ProfileChunk("profile_chunk"),
    ClientReport("client_report"),
    ReplayEvent("replay_event"),
    ReplayRecording("replay_recording"),
    ReplayVideo("replay_video"),
    CheckIn("check_in"),
    Feedback(Feedback.TYPE),
    Log("log"),
    Unknown("__unknown__");

    private final String itemType;

    /* JADX INFO: compiled from: SentryItemType.java */
    public static final class a implements x1<b7> {
        @Override // io.sentry.x1
        @NotNull
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public b7 deserialize(@NotNull l3 l3Var, @NotNull w0 w0Var) throws Exception {
            return b7.valueOfLabel(l3Var.e0().toLowerCase(Locale.ROOT));
        }
    }

    b7(String str) {
        this.itemType = str;
    }

    public static b7 resolve(Object obj) {
        return obj instanceof r6 ? ((r6) obj).getContexts().getFeedback() == null ? Event : Feedback : obj instanceof SentryTransaction ? Transaction : obj instanceof e8 ? Session : obj instanceof io.sentry.clientreport.c ? ClientReport : Attachment;
    }

    @NotNull
    public static b7 valueOfLabel(String str) {
        for (b7 b7Var : values()) {
            if (b7Var.itemType.equals(str)) {
                return b7Var;
            }
        }
        return Unknown;
    }

    public String getItemType() {
        return this.itemType;
    }

    @Override // io.sentry.h2
    public void serialize(@NotNull m3 m3Var, @NotNull w0 w0Var) throws IOException {
        m3Var.g(this.itemType);
    }
}
