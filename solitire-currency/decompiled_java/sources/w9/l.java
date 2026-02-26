package w9;

import androidx.media3.exoplayer.audio.SilenceSkippingAudioProcessor;
import java.util.concurrent.TimeUnit;
import n9.o;
import org.jetbrains.annotations.NotNull;
import u9.i0;
import u9.k0;

/* JADX INFO: compiled from: Tasks.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final String f35543a = i0.e("kotlinx.coroutines.scheduler.default.name", "DefaultDispatcher");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final long f35544b = k0.f("kotlinx.coroutines.scheduler.resolution.ns", SilenceSkippingAudioProcessor.DEFAULT_MINIMUM_SILENCE_DURATION_US, 0, 0, 12, null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f35545c = k0.e("kotlinx.coroutines.scheduler.core.pool.size", o.e(i0.a(), 2), 1, 0, 8, null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f35546d = k0.e("kotlinx.coroutines.scheduler.max.pool.size", 2097150, 0, 2097150, 4, null);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final long f35547e = TimeUnit.SECONDS.toNanos(k0.f("kotlinx.coroutines.scheduler.keep.alive.sec", 60, 0, 0, 12, null));

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    public static g f35548f = e.f35533a;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NotNull
    public static final i f35549g = new j(0);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NotNull
    public static final i f35550h = new j(1);
}
