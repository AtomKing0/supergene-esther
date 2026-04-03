package io.sentry;

import io.sentry.protocol.SdkVersion;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: SentryReplayOptions.java */
/* JADX INFO: loaded from: classes5.dex */
public final class q7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    private Double f28121a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    private Double f28122b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @Nullable
    private SdkVersion f28133m;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Set<String> f28123c = new CopyOnWriteArraySet();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Set<String> f28124d = new CopyOnWriteArraySet();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    private String f28125e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    private String f28126f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private a f28127g = a.MEDIUM;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f28128h = 1;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private long f28129i = 30000;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private long f28130j = 5000;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private long f28131k = 3600000;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f28132l = true;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f28134n = false;

    /* JADX INFO: compiled from: SentryReplayOptions.java */
    public enum a {
        LOW(0.8f, 50000, 10),
        MEDIUM(1.0f, 75000, 30),
        HIGH(1.0f, 100000, 50);

        public final int bitRate;
        public final int screenshotQuality;
        public final float sizeScale;

        a(float f10, int i10, int i11) {
            this.sizeScale = f10;
            this.bitRate = i10;
            this.screenshotQuality = i11;
        }

        @NotNull
        public String serializedName() {
            return name().toLowerCase(Locale.ROOT);
        }
    }

    public q7(boolean z10, @Nullable SdkVersion sdkVersion) {
        if (z10) {
            return;
        }
        h(true);
        g(true);
        this.f28123c.add("android.webkit.WebView");
        this.f28123c.add("android.widget.VideoView");
        this.f28123c.add("androidx.media3.ui.PlayerView");
        this.f28123c.add("com.google.android.exoplayer2.ui.PlayerView");
        this.f28123c.add("com.google.android.exoplayer2.ui.StyledPlayerView");
        this.f28133m = sdkVersion;
    }

    public void a(@NotNull String str) {
        this.f28123c.add(str);
    }

    public void b(@NotNull String str) {
        this.f28124d.add(str);
    }

    @Nullable
    public Double c() {
        return this.f28122b;
    }

    @ApiStatus.Internal
    @Nullable
    public SdkVersion d() {
        return this.f28133m;
    }

    @Nullable
    public Double e() {
        return this.f28121a;
    }

    public void f(boolean z10) {
        this.f28134n = z10;
    }

    public void g(boolean z10) {
        if (z10) {
            a("android.widget.ImageView");
            this.f28124d.remove("android.widget.ImageView");
        } else {
            b("android.widget.ImageView");
            this.f28123c.remove("android.widget.ImageView");
        }
    }

    public void h(boolean z10) {
        if (z10) {
            a("android.widget.TextView");
            this.f28124d.remove("android.widget.TextView");
        } else {
            b("android.widget.TextView");
            this.f28123c.remove("android.widget.TextView");
        }
    }

    public void i(@Nullable Double d10) {
        if (io.sentry.util.a0.f(d10)) {
            this.f28122b = d10;
            return;
        }
        throw new IllegalArgumentException("The value " + d10 + " is not valid. Use null to disable or values >= 0.0 and <= 1.0.");
    }

    @ApiStatus.Internal
    public void j(@Nullable SdkVersion sdkVersion) {
        this.f28133m = sdkVersion;
    }

    public void k(@Nullable Double d10) {
        if (io.sentry.util.a0.f(d10)) {
            this.f28121a = d10;
            return;
        }
        throw new IllegalArgumentException("The value " + d10 + " is not valid. Use null to disable or values >= 0.0 and <= 1.0.");
    }
}
