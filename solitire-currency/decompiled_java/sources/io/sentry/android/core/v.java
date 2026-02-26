package io.sentry.android.core;

import android.os.SystemClock;
import android.system.Os;
import android.system.OsConstants;
import androidx.media3.common.C;
import com.unity3d.ads.core.data.datasource.AndroidDynamicDeviceInfoDataSource;
import io.sentry.SentryLevel;
import io.sentry.i7;
import io.sentry.r3;
import java.io.File;
import java.io.IOException;
import java.util.regex.Pattern;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: AndroidCpuCollector.java */
/* JADX INFO: loaded from: classes5.dex */
@ApiStatus.Internal
public final class v implements io.sentry.a1 {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NotNull
    private final io.sentry.w0 f27546h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f27539a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f27540b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f27541c = 1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f27542d = 1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final long f27543e = C.NANOS_PER_SECOND;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private double f27544f = 1.0E9d / 1;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NotNull
    private final File f27545g = new File(AndroidDynamicDeviceInfoDataSource.DIRECTORY_PROCESS_INFO);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f27547i = false;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NotNull
    private final Pattern f27548j = Pattern.compile("[\n\t\r ]");

    public v(@NotNull io.sentry.w0 w0Var) {
        this.f27546h = (io.sentry.w0) io.sentry.util.w.c(w0Var, "Logger is required.");
    }

    private long e() {
        String strC;
        try {
            strC = io.sentry.util.h.c(this.f27545g);
        } catch (IOException e10) {
            this.f27547i = false;
            this.f27546h.b(SentryLevel.WARNING, "Unable to read /proc/self/stat file. Disabling cpu collection.", e10);
            strC = null;
        }
        if (strC != null) {
            String[] strArrSplit = this.f27548j.split(strC.trim());
            try {
                long j10 = Long.parseLong(strArrSplit[13]);
                long j11 = Long.parseLong(strArrSplit[14]);
                return (long) ((j10 + j11 + Long.parseLong(strArrSplit[15]) + Long.parseLong(strArrSplit[16])) * this.f27544f);
            } catch (ArrayIndexOutOfBoundsException | NumberFormatException e11) {
                this.f27546h.b(SentryLevel.ERROR, "Error parsing /proc/self/stat file.", e11);
            }
        }
        return 0L;
    }

    @Override // io.sentry.a1
    public void c() {
        this.f27547i = true;
        this.f27541c = Os.sysconf(OsConstants._SC_CLK_TCK);
        this.f27542d = Os.sysconf(OsConstants._SC_NPROCESSORS_CONF);
        this.f27544f = 1.0E9d / this.f27541c;
        this.f27540b = e();
    }

    @Override // io.sentry.a1
    public void d(@NotNull r3 r3Var) {
        if (this.f27547i) {
            long jElapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos();
            long j10 = jElapsedRealtimeNanos - this.f27539a;
            this.f27539a = jElapsedRealtimeNanos;
            long jE = e();
            long j11 = jE - this.f27540b;
            this.f27540b = jE;
            r3Var.a(new io.sentry.k(((j11 / j10) / this.f27542d) * 100.0d, new i7()));
        }
    }
}
