package io.sentry.android.core.internal.util;

import io.sentry.k1;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.VisibleForTesting;

/* JADX INFO: compiled from: CpuInfoUtils.java */
/* JADX INFO: loaded from: classes5.dex */
@ApiStatus.Internal
public final class g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final g f27302c = new g();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final io.sentry.util.a f27303a = new io.sentry.util.a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final List<Integer> f27304b = new ArrayList();

    private g() {
    }

    public static g a() {
        return f27302c;
    }

    @VisibleForTesting
    @NotNull
    String b() {
        return "/sys/devices/system/cpu";
    }

    @NotNull
    public List<Integer> c() {
        k1 k1VarA = this.f27303a.a();
        try {
            if (!this.f27304b.isEmpty()) {
                List<Integer> list = this.f27304b;
                if (k1VarA != null) {
                    k1VarA.close();
                }
                return list;
            }
            File[] fileArrListFiles = new File(b()).listFiles();
            if (fileArrListFiles == null) {
                ArrayList arrayList = new ArrayList();
                if (k1VarA != null) {
                    k1VarA.close();
                }
                return arrayList;
            }
            for (File file : fileArrListFiles) {
                if (file.getName().matches("cpu[0-9]+")) {
                    File file2 = new File(file, "cpufreq/cpuinfo_max_freq");
                    if (file2.exists() && file2.canRead()) {
                        try {
                            String strC = io.sentry.util.h.c(file2);
                            if (strC != null) {
                                this.f27304b.add(Integer.valueOf((int) (Long.parseLong(strC.trim()) / 1000)));
                            }
                        } catch (IOException | NumberFormatException unused) {
                        }
                    }
                }
            }
            List<Integer> list2 = this.f27304b;
            if (k1VarA != null) {
                k1VarA.close();
            }
            return list2;
        } catch (Throwable th) {
            if (k1VarA != null) {
                try {
                    k1VarA.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }
}
