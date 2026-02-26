package io.sentry.util;

import io.sentry.protocol.Message;
import io.sentry.r6;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ErrorUtils.java */
/* JADX INFO: loaded from: classes5.dex */
public final class e {
    @ApiStatus.Internal
    public static boolean a(@Nullable List<io.sentry.j0> list, @NotNull r6 r6Var) {
        if (r6Var != null && list != null && !list.isEmpty()) {
            HashSet hashSet = new HashSet();
            Message messageM = r6Var.m();
            if (messageM != null) {
                String message = messageM.getMessage();
                if (message != null) {
                    hashSet.add(message);
                }
                String formatted = messageM.getFormatted();
                if (formatted != null) {
                    hashSet.add(formatted);
                }
            }
            Throwable throwable = r6Var.getThrowable();
            if (throwable != null) {
                hashSet.add(throwable.toString());
            }
            Iterator<io.sentry.j0> it = list.iterator();
            while (it.hasNext()) {
                if (hashSet.contains(it.next().a())) {
                    return true;
                }
            }
            for (io.sentry.j0 j0Var : list) {
                Iterator it2 = hashSet.iterator();
                while (it2.hasNext()) {
                    if (j0Var.b((String) it2.next())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
