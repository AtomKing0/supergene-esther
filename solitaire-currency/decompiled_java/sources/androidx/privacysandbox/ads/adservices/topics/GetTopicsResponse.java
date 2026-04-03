package androidx.privacysandbox.ads.adservices.topics;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: GetTopicsResponse.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GetTopicsResponse {

    @NotNull
    private final List<Topic> topics;

    public GetTopicsResponse(@NotNull List<Topic> topics) {
        t.i(topics, "topics");
        this.topics = topics;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GetTopicsResponse)) {
            return false;
        }
        GetTopicsResponse getTopicsResponse = (GetTopicsResponse) obj;
        if (this.topics.size() != getTopicsResponse.topics.size()) {
            return false;
        }
        return t.d(new HashSet(this.topics), new HashSet(getTopicsResponse.topics));
    }

    @NotNull
    public final List<Topic> getTopics() {
        return this.topics;
    }

    public int hashCode() {
        return Objects.hash(this.topics);
    }

    @NotNull
    public String toString() {
        return "Topics=" + this.topics;
    }
}
