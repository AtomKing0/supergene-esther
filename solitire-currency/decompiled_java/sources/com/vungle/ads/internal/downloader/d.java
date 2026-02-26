package com.vungle.ads.internal.downloader;

import androidx.media3.common.C;
import com.vungle.ads.internal.l;
import com.vungle.ads.internal.model.a;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import com.vungle.ads.o;
import com.vungle.ads.w1;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: DownloadRequest.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class d {

    @NotNull
    private final com.vungle.ads.internal.model.a asset;

    @NotNull
    private final AtomicBoolean cancelled;

    @Nullable
    private final String creativeId;

    @Nullable
    private w1 downloadDuration;

    @Nullable
    private final String eventId;

    @Nullable
    private final String placementId;

    @NotNull
    private final a priority;

    /* JADX INFO: compiled from: DownloadRequest.kt */
    public enum a {
        CRITICAL(C.RATE_UNSET_INT),
        HIGHEST(0),
        HIGH(1),
        LOWEST(Integer.MAX_VALUE);

        private final int priority;

        a(int i10) {
            this.priority = i10;
        }

        public final int getPriority() {
            return this.priority;
        }
    }

    public d(@NotNull a priority, @NotNull com.vungle.ads.internal.model.a asset, @Nullable String str, @Nullable String str2, @Nullable String str3) {
        t.i(priority, "priority");
        t.i(asset, "asset");
        this.priority = priority;
        this.asset = asset;
        this.placementId = str;
        this.creativeId = str2;
        this.eventId = str3;
        this.cancelled = new AtomicBoolean(false);
    }

    public final void cancel() {
        this.cancelled.set(true);
    }

    @NotNull
    public final com.vungle.ads.internal.model.a getAsset() {
        return this.asset;
    }

    @Nullable
    public final String getCreativeId() {
        return this.creativeId;
    }

    @Nullable
    public final String getEventId() {
        return this.eventId;
    }

    @Nullable
    public final String getPlacementId() {
        return this.placementId;
    }

    @NotNull
    /* JADX INFO: renamed from: getPriority, reason: collision with other method in class */
    public final a m4037getPriority() {
        return this.priority;
    }

    public final boolean isCancelled() {
        return this.cancelled.get();
    }

    public final boolean isHtmlTemplate() {
        return t.d(this.asset.getAdIdentifier(), com.vungle.ads.internal.model.b.KEY_VM);
    }

    public final boolean isMainVideo() {
        return t.d(this.asset.getAdIdentifier(), l.KEY_MAIN_VIDEO);
    }

    public final boolean isTemplate() {
        return this.asset.getFileType() == a.EnumC0510a.ZIP || isHtmlTemplate();
    }

    public final void startRecord() {
        w1 w1Var = new w1(Sdk$SDKMetric.b.TEMPLATE_DOWNLOAD_DURATION_MS);
        this.downloadDuration = w1Var;
        w1Var.markStart();
    }

    public final void stopRecord() {
        w1 w1Var = this.downloadDuration;
        if (w1Var != null) {
            w1Var.markEnd();
            o.INSTANCE.logMetric$vungle_ads_release(w1Var, this.placementId, this.creativeId, this.eventId, this.asset.getServerPath());
        }
    }

    @NotNull
    public String toString() {
        return "DownloadRequest{, priority=" + this.priority + ", url='" + this.asset.getServerPath() + "', path='" + this.asset.getLocalPath() + "', cancelled=" + this.cancelled + ", placementId=" + this.placementId + ", creativeId=" + this.creativeId + ", eventId=" + this.eventId + '}';
    }

    public final int getPriority() {
        return this.priority.getPriority();
    }

    public /* synthetic */ d(a aVar, com.vungle.ads.internal.model.a aVar2, String str, String str2, String str3, int i10, k kVar) {
        this(aVar, aVar2, (i10 & 4) != 0 ? null : str, (i10 & 8) != 0 ? null : str2, (i10 & 16) != 0 ? null : str3);
    }
}
