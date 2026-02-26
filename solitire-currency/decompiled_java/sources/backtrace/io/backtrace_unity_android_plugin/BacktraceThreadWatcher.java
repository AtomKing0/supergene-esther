package backtrace.io.backtrace_unity_android_plugin;

/* JADX INFO: loaded from: classes2.dex */
public class BacktraceThreadWatcher {
    private boolean active;
    private int counter;
    private int delay;
    private long lastTimestamp;
    private int privateCounter;
    private int timeout;

    BacktraceThreadWatcher(int i10, int i11) {
        this.timeout = i10;
        this.delay = i11;
        setActive(true);
    }

    synchronized int getCounter() {
        return this.counter;
    }

    int getDelay() {
        return this.delay;
    }

    long getLastTimestamp() {
        return this.lastTimestamp;
    }

    int getPrivateCounter() {
        return this.privateCounter;
    }

    int getTimeout() {
        return this.timeout;
    }

    synchronized boolean isActive() {
        return this.active;
    }

    synchronized void setActive(boolean z10) {
        this.active = z10;
    }

    void setLastTimestamp(long j10) {
        this.lastTimestamp = j10;
    }

    void setPrivateCounter(int i10) {
        this.privateCounter = i10;
    }

    public synchronized void tickCounter() {
        this.counter++;
    }

    void tickPrivateCounter() {
        this.privateCounter++;
    }
}
