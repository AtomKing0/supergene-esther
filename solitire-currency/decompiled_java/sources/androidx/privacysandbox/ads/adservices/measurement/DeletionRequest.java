package androidx.privacysandbox.ads.adservices.measurement;

import android.net.Uri;
import androidx.annotation.RequiresApi;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.time.Instant;
import java.util.HashSet;
import java.util.List;
import kotlin.collections.v;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: DeletionRequest.kt */
/* JADX INFO: loaded from: classes2.dex */
@RequiresApi(33)
public final class DeletionRequest {

    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int DELETION_MODE_ALL = 0;
    public static final int DELETION_MODE_EXCLUDE_INTERNAL_DATA = 1;
    public static final int MATCH_BEHAVIOR_DELETE = 0;
    public static final int MATCH_BEHAVIOR_PRESERVE = 1;
    private final int deletionMode;

    @NotNull
    private final List<Uri> domainUris;

    @NotNull
    private final Instant end;
    private final int matchBehavior;

    @NotNull
    private final List<Uri> originUris;

    @NotNull
    private final Instant start;

    /* JADX INFO: compiled from: DeletionRequest.kt */
    @RequiresApi(33)
    public static final class Builder {
        private final int deletionMode;

        @NotNull
        private List<? extends Uri> domainUris;

        @NotNull
        private Instant end;
        private final int matchBehavior;

        @NotNull
        private List<? extends Uri> originUris;

        @NotNull
        private Instant start;

        public Builder(int i10, int i11) {
            this.deletionMode = i10;
            this.matchBehavior = i11;
            Instant MIN = Instant.MIN;
            t.h(MIN, "MIN");
            this.start = MIN;
            Instant MAX = Instant.MAX;
            t.h(MAX, "MAX");
            this.end = MAX;
            this.domainUris = v.l();
            this.originUris = v.l();
        }

        @NotNull
        public final DeletionRequest build() {
            return new DeletionRequest(this.deletionMode, this.matchBehavior, this.start, this.end, this.domainUris, this.originUris);
        }

        @NotNull
        public final Builder setDomainUris(@NotNull List<? extends Uri> domainUris) {
            t.i(domainUris, "domainUris");
            this.domainUris = domainUris;
            return this;
        }

        @NotNull
        public final Builder setEnd(@NotNull Instant end) {
            t.i(end, "end");
            this.end = end;
            return this;
        }

        @NotNull
        public final Builder setOriginUris(@NotNull List<? extends Uri> originUris) {
            t.i(originUris, "originUris");
            this.originUris = originUris;
            return this;
        }

        @NotNull
        public final Builder setStart(@NotNull Instant start) {
            t.i(start, "start");
            this.start = start;
            return this;
        }
    }

    /* JADX INFO: compiled from: DeletionRequest.kt */
    public static final class Companion {

        /* JADX INFO: compiled from: DeletionRequest.kt */
        @Retention(RetentionPolicy.SOURCE)
        public @interface DeletionMode {
        }

        /* JADX INFO: compiled from: DeletionRequest.kt */
        @Retention(RetentionPolicy.SOURCE)
        public @interface MatchBehavior {
        }

        private Companion() {
        }

        public /* synthetic */ Companion(k kVar) {
            this();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DeletionRequest(int i10, int i11, @NotNull Instant start, @NotNull Instant end, @NotNull List<? extends Uri> domainUris, @NotNull List<? extends Uri> originUris) {
        t.i(start, "start");
        t.i(end, "end");
        t.i(domainUris, "domainUris");
        t.i(originUris, "originUris");
        this.deletionMode = i10;
        this.matchBehavior = i11;
        this.start = start;
        this.end = end;
        this.domainUris = domainUris;
        this.originUris = originUris;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DeletionRequest)) {
            return false;
        }
        DeletionRequest deletionRequest = (DeletionRequest) obj;
        return this.deletionMode == deletionRequest.deletionMode && t.d(new HashSet(this.domainUris), new HashSet(deletionRequest.domainUris)) && t.d(new HashSet(this.originUris), new HashSet(deletionRequest.originUris)) && t.d(this.start, deletionRequest.start) && t.d(this.end, deletionRequest.end) && this.matchBehavior == deletionRequest.matchBehavior;
    }

    public final int getDeletionMode() {
        return this.deletionMode;
    }

    @NotNull
    public final List<Uri> getDomainUris() {
        return this.domainUris;
    }

    @NotNull
    public final Instant getEnd() {
        return this.end;
    }

    public final int getMatchBehavior() {
        return this.matchBehavior;
    }

    @NotNull
    public final List<Uri> getOriginUris() {
        return this.originUris;
    }

    @NotNull
    public final Instant getStart() {
        return this.start;
    }

    public int hashCode() {
        return (((((((((this.deletionMode * 31) + this.domainUris.hashCode()) * 31) + this.originUris.hashCode()) * 31) + this.start.hashCode()) * 31) + this.end.hashCode()) * 31) + this.matchBehavior;
    }

    @NotNull
    public String toString() {
        return "DeletionRequest { DeletionMode=" + (this.deletionMode == 0 ? "DELETION_MODE_ALL" : "DELETION_MODE_EXCLUDE_INTERNAL_DATA") + ", MatchBehavior=" + (this.matchBehavior == 0 ? "MATCH_BEHAVIOR_DELETE" : "MATCH_BEHAVIOR_PRESERVE") + ", Start=" + this.start + ", End=" + this.end + ", DomainUris=" + this.domainUris + ", OriginUris=" + this.originUris + " }";
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ DeletionRequest(int i10, int i11, Instant MIN, Instant MAX, List list, List list2, int i12, k kVar) {
        if ((i12 & 4) != 0) {
            MIN = Instant.MIN;
            t.h(MIN, "MIN");
        }
        Instant instant = MIN;
        if ((i12 & 8) != 0) {
            MAX = Instant.MAX;
            t.h(MAX, "MAX");
        }
        this(i10, i11, instant, MAX, (i12 & 16) != 0 ? v.l() : list, (i12 & 32) != 0 ? v.l() : list2);
    }
}
