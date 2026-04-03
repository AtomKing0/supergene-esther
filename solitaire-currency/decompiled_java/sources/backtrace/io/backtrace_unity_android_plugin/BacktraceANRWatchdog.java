package backtrace.io.backtrace_unity_android_plugin;

import android.os.Debug;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.unity3d.player.UnityPlayer;
import java.io.PrintWriter;
import java.io.StringWriter;

/* JADX INFO: loaded from: classes2.dex */
public class BacktraceANRWatchdog extends Thread {
    private static final transient String LOG_TAG = "BacktraceANRWatchdog";
    private String gameObjectName;
    private String methodName;
    private int timeout;
    private final Handler mainThreadHandler = new Handler(Looper.getMainLooper());
    private volatile boolean shouldStop = false;

    public BacktraceANRWatchdog(String str, String str2, int i10) {
        Log.d(LOG_TAG, "Initializing ANR watchdog");
        this.methodName = str2;
        this.gameObjectName = str;
        this.timeout = i10;
        start();
    }

    public static void printStackTrace(StackTraceElement[] stackTraceElementArr, PrintWriter printWriter) {
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            printWriter.println(stackTraceElement);
        }
    }

    public static String stackTraceToString(StackTraceElement[] stackTraceElementArr) {
        StringWriter stringWriter = new StringWriter();
        printStackTrace(stackTraceElementArr, new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    public void NotifyUnityAboutANR() {
        String strStackTraceToString = stackTraceToString(Looper.getMainLooper().getThread().getStackTrace());
        Log.d(LOG_TAG, strStackTraceToString);
        UnityPlayer.UnitySendMessage(this.gameObjectName, this.methodName, strStackTraceToString);
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        if (Debug.isDebuggerConnected() || Debug.waitingForDebugger()) {
            Log.d(LOG_TAG, "Detected a debugger connection. ANR Watchdog is disabled");
            return;
        }
        Boolean bool = Boolean.FALSE;
        Log.d(LOG_TAG, "Starting ANR watchdog. Anr timeout: " + this.timeout);
        while (!this.shouldStop && !isInterrupted()) {
            final BacktraceThreadWatcher backtraceThreadWatcher = new BacktraceThreadWatcher(0, 0);
            this.mainThreadHandler.post(new Runnable() { // from class: backtrace.io.backtrace_unity_android_plugin.BacktraceANRWatchdog.1
                @Override // java.lang.Runnable
                public void run() {
                    backtraceThreadWatcher.tickCounter();
                }
            });
            try {
                Thread.sleep(this.timeout);
                backtraceThreadWatcher.tickPrivateCounter();
                if (backtraceThreadWatcher.getCounter() == backtraceThreadWatcher.getPrivateCounter()) {
                    bool = Boolean.FALSE;
                } else if (!bool.booleanValue()) {
                    bool = Boolean.TRUE;
                    Log.d(LOG_TAG, "Detected blocked Java thread. Reporting Java ANR.");
                    NotifyUnityAboutANR();
                }
            } catch (InterruptedException e10) {
                Log.d(LOG_TAG, "Thread is interrupted", e10);
                return;
            }
        }
    }

    public void stopMonitoring() {
        Log.d(LOG_TAG, "ANR handler has been disabled.");
        this.shouldStop = true;
    }
}
