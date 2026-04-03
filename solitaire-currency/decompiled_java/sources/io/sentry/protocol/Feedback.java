package io.sentry.protocol;

import io.sentry.SentryLevel;
import io.sentry.h2;
import io.sentry.l3;
import io.sentry.m3;
import io.sentry.protocol.SentryId;
import io.sentry.util.w;
import io.sentry.w0;
import io.sentry.x1;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes5.dex */
public final class Feedback implements h2 {
    public static final String TYPE = "feedback";

    @Nullable
    private SentryId associatedEventId;

    @Nullable
    private String contactEmail;

    @NotNull
    private String message;

    @Nullable
    private String name;

    @Nullable
    private SentryId replayId;

    @Nullable
    private Map<String, Object> unknown;

    @Nullable
    private String url;

    public static final class Deserializer implements x1<Feedback> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // io.sentry.x1
        @NotNull
        public Feedback deserialize(@NotNull l3 l3Var, @NotNull w0 w0Var) throws Exception {
            String strC;
            l3Var.h();
            String strO0 = null;
            String strO02 = null;
            String strO03 = null;
            SentryId sentryIdDeserialize = null;
            SentryId sentryIdDeserialize2 = null;
            String strO04 = null;
            HashMap map = null;
            while (l3Var.peek() == io.sentry.vendor.gson.stream.b.NAME) {
                strC = l3Var.C();
                strC.hashCode();
                switch (strC) {
                    case "associated_event_id":
                        sentryIdDeserialize = new SentryId.Deserializer().deserialize(l3Var, w0Var);
                        break;
                    case "replay_id":
                        sentryIdDeserialize2 = new SentryId.Deserializer().deserialize(l3Var, w0Var);
                        break;
                    case "url":
                        strO04 = l3Var.o0();
                        break;
                    case "name":
                        strO03 = l3Var.o0();
                        break;
                    case "contact_email":
                        strO02 = l3Var.o0();
                        break;
                    case "message":
                        strO0 = l3Var.o0();
                        break;
                    default:
                        if (map == null) {
                            map = new HashMap();
                        }
                        l3Var.r0(w0Var, map, strC);
                        break;
                }
            }
            l3Var.k();
            if (strO0 == null) {
                IllegalStateException illegalStateException = new IllegalStateException("Missing required field \"message\"");
                w0Var.b(SentryLevel.ERROR, "Missing required field \"message\"", illegalStateException);
                throw illegalStateException;
            }
            Feedback feedback = new Feedback(strO0);
            feedback.contactEmail = strO02;
            feedback.name = strO03;
            feedback.associatedEventId = sentryIdDeserialize;
            feedback.replayId = sentryIdDeserialize2;
            feedback.url = strO04;
            feedback.unknown = map;
            return feedback;
        }
    }

    public static final class JsonKeys {
        public static final String ASSOCIATED_EVENT_ID = "associated_event_id";
        public static final String CONTACT_EMAIL = "contact_email";
        public static final String MESSAGE = "message";
        public static final String NAME = "name";
        public static final String REPLAY_ID = "replay_id";
        public static final String URL = "url";
    }

    public Feedback(@NotNull String str) {
        setMessage(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Feedback)) {
            return false;
        }
        Feedback feedback = (Feedback) obj;
        return w.a(this.message, feedback.message) && w.a(this.contactEmail, feedback.contactEmail) && w.a(this.name, feedback.name) && w.a(this.associatedEventId, feedback.associatedEventId) && w.a(this.replayId, feedback.replayId) && w.a(this.url, feedback.url) && w.a(this.unknown, feedback.unknown);
    }

    @Nullable
    public SentryId getAssociatedEventId() {
        return this.associatedEventId;
    }

    @Nullable
    public String getContactEmail() {
        return this.contactEmail;
    }

    @NotNull
    public String getMessage() {
        return this.message;
    }

    @Nullable
    public String getName() {
        return this.name;
    }

    @Nullable
    public SentryId getReplayId() {
        return this.replayId;
    }

    @Nullable
    public Map<String, Object> getUnknown() {
        return this.unknown;
    }

    @Nullable
    public String getUrl() {
        return this.url;
    }

    public int hashCode() {
        return w.b(this.message, this.contactEmail, this.name, this.associatedEventId, this.replayId, this.url, this.unknown);
    }

    @Override // io.sentry.h2
    public void serialize(@NotNull m3 m3Var, @NotNull w0 w0Var) throws IOException {
        m3Var.h();
        m3Var.e("message").g(this.message);
        if (this.contactEmail != null) {
            m3Var.e(JsonKeys.CONTACT_EMAIL).g(this.contactEmail);
        }
        if (this.name != null) {
            m3Var.e("name").g(this.name);
        }
        if (this.associatedEventId != null) {
            m3Var.e(JsonKeys.ASSOCIATED_EVENT_ID);
            this.associatedEventId.serialize(m3Var, w0Var);
        }
        if (this.replayId != null) {
            m3Var.e("replay_id");
            this.replayId.serialize(m3Var, w0Var);
        }
        if (this.url != null) {
            m3Var.e("url").g(this.url);
        }
        Map<String, Object> map = this.unknown;
        if (map != null) {
            for (String str : map.keySet()) {
                m3Var.e(str).o(w0Var, this.unknown.get(str));
            }
        }
        m3Var.k();
    }

    public void setAssociatedEventId(@NotNull SentryId sentryId) {
        this.associatedEventId = sentryId;
    }

    public void setContactEmail(@Nullable String str) {
        this.contactEmail = str;
    }

    public void setMessage(@NotNull String str) {
        if (str.length() > 4096) {
            this.message = str.substring(0, 4096);
        } else {
            this.message = str;
        }
    }

    public void setName(@Nullable String str) {
        this.name = str;
    }

    public void setReplayId(@NotNull SentryId sentryId) {
        this.replayId = sentryId;
    }

    public void setUnknown(@Nullable Map<String, Object> map) {
        this.unknown = map;
    }

    public void setUrl(@Nullable String str) {
        this.url = str;
    }

    public String toString() {
        return "Feedback{message='" + this.message + "', contactEmail='" + this.contactEmail + "', name='" + this.name + "', associatedEventId=" + this.associatedEventId + ", replayId=" + this.replayId + ", url='" + this.url + "', unknown=" + this.unknown + '}';
    }

    public Feedback(@NotNull Feedback feedback) {
        this.message = feedback.message;
        this.contactEmail = feedback.contactEmail;
        this.name = feedback.name;
        this.associatedEventId = feedback.associatedEventId;
        this.replayId = feedback.replayId;
        this.url = feedback.url;
        this.unknown = io.sentry.util.c.b(feedback.unknown);
    }
}
