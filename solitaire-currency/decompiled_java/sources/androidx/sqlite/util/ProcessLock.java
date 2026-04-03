package androidx.sqlite.util;

import android.annotation.SuppressLint;
import android.util.Log;
import androidx.annotation.RestrictTo;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ProcessLock.kt */
/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class ProcessLock {

    @NotNull
    private static final String TAG = "SupportSQLiteLock";

    @Nullable
    private FileChannel lockChannel;

    @Nullable
    private final File lockFile;
    private final boolean processLock;

    @SuppressLint({"SyntheticAccessor"})
    @NotNull
    private final Lock threadLock;

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    private static final Map<String, Lock> threadLocksMap = new HashMap();

    /* JADX INFO: compiled from: ProcessLock.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k kVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Lock getThreadLock(String str) {
            Lock lock;
            synchronized (ProcessLock.threadLocksMap) {
                Map map = ProcessLock.threadLocksMap;
                Object reentrantLock = map.get(str);
                if (reentrantLock == null) {
                    reentrantLock = new ReentrantLock();
                    map.put(str, reentrantLock);
                }
                lock = (Lock) reentrantLock;
            }
            return lock;
        }
    }

    public ProcessLock(@NotNull String name, @Nullable File file, boolean z10) {
        File file2;
        t.i(name, "name");
        this.processLock = z10;
        if (file != null) {
            file2 = new File(file, name + ".lck");
        } else {
            file2 = null;
        }
        this.lockFile = file2;
        this.threadLock = Companion.getThreadLock(name);
    }

    public static /* synthetic */ void lock$default(ProcessLock processLock, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = processLock.processLock;
        }
        processLock.lock(z10);
    }

    public final void lock(boolean z10) {
        this.threadLock.lock();
        if (z10) {
            try {
                File file = this.lockFile;
                if (file == null) {
                    throw new IOException("No lock directory was provided.");
                }
                File parentFile = file.getParentFile();
                if (parentFile != null) {
                    parentFile.mkdirs();
                }
                FileChannel channel = new FileOutputStream(this.lockFile).getChannel();
                channel.lock();
                this.lockChannel = channel;
            } catch (IOException e10) {
                this.lockChannel = null;
                Log.w(TAG, "Unable to grab file lock.", e10);
            }
        }
    }

    public final void unlock() {
        try {
            FileChannel fileChannel = this.lockChannel;
            if (fileChannel != null) {
                fileChannel.close();
            }
        } catch (IOException unused) {
        }
        this.threadLock.unlock();
    }
}
